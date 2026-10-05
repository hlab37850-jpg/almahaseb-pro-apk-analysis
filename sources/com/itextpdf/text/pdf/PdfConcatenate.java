package com.itextpdf.text.pdf;

import com.itextpdf.text.Document;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class PdfConcatenate {
    protected PdfCopy copy;
    protected Document document;

    public PdfConcatenate(OutputStream outputStream) {
        this(outputStream, false);
    }

    public int addPages(PdfReader pdfReader) {
        open();
        int numberOfPages = pdfReader.getNumberOfPages();
        for (int i = 1; i <= numberOfPages; i++) {
            PdfCopy pdfCopy = this.copy;
            pdfCopy.addPage(pdfCopy.getImportedPage(pdfReader, i));
        }
        this.copy.freeReader(pdfReader);
        pdfReader.close();
        return numberOfPages;
    }

    public void close() {
        this.document.close();
    }

    public PdfCopy getWriter() {
        return this.copy;
    }

    public void open() {
        if (this.document.isOpen()) {
            return;
        }
        this.document.open();
    }

    public PdfConcatenate(OutputStream outputStream, boolean z) {
        this.document = new Document();
        if (z) {
            this.copy = new PdfSmartCopy(this.document, outputStream);
        } else {
            this.copy = new PdfCopy(this.document, outputStream);
        }
    }
}
