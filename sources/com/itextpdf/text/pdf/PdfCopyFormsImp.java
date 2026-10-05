package com.itextpdf.text.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
class PdfCopyFormsImp extends PdfCopyFieldsImp {
    public PdfCopyFormsImp(OutputStream outputStream) {
        super(outputStream);
    }

    public void copyDocumentFields(PdfReader pdfReader) throws DocumentException {
        if (!pdfReader.isOpenedWithFullPermissions()) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("pdfreader.not.opened.with.owner.password", new Object[0]));
        }
        if (this.readers2intrefs.containsKey(pdfReader)) {
            pdfReader = new PdfReader(pdfReader);
        } else {
            if (pdfReader.isTampered()) {
                throw new DocumentException(MessageLocalization.getComposedMessage("the.document.was.reused", new Object[0]));
            }
            pdfReader.consolidateNamedDestinations();
            pdfReader.setTampered(true);
        }
        pdfReader.shuffleSubsetNames();
        this.readers2intrefs.put(pdfReader, new IntHashtable());
        this.visited.put(pdfReader, new IntHashtable());
        this.fields.add(pdfReader.getAcroFields());
        updateCalculationOrder(pdfReader);
    }

    @Override // com.itextpdf.text.pdf.PdfCopyFieldsImp
    public void mergeFields() {
        for (int i = 0; i < this.fields.size(); i++) {
            mergeWithMaster(this.fields.get(i).getFields());
        }
    }
}
