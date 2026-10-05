package com.itextpdf.text;

import com.itextpdf.text.pdf.PdfName;

/* JADX INFO: loaded from: classes3.dex */
public class ListLabel extends ListBody {
    protected float indentation;
    protected PdfName role;

    public ListLabel(ListItem listItem) {
        super(listItem);
        this.role = PdfName.LBL;
        this.indentation = 0.0f;
    }

    public float getIndentation() {
        return this.indentation;
    }

    @Override // com.itextpdf.text.ListBody, com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public PdfName getRole() {
        return this.role;
    }

    @Deprecated
    public boolean getTagLabelContent() {
        return false;
    }

    @Override // com.itextpdf.text.ListBody, com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public boolean isInline() {
        return true;
    }

    public void setIndentation(float f) {
        this.indentation = f;
    }

    @Override // com.itextpdf.text.ListBody, com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public void setRole(PdfName pdfName) {
        this.role = pdfName;
    }

    @Deprecated
    public void setTagLabelContent(boolean z) {
    }
}
