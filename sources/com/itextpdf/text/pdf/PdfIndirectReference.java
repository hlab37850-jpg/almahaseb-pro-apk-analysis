package com.itextpdf.text.pdf;

import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class PdfIndirectReference extends PdfObject {
    protected int generation;
    protected int number;

    public PdfIndirectReference() {
        super(0);
        this.generation = 0;
    }

    public int getGeneration() {
        return this.generation;
    }

    public int getNumber() {
        return this.number;
    }

    @Override // com.itextpdf.text.pdf.PdfObject
    public void toPdf(PdfWriter pdfWriter, OutputStream outputStream) {
        outputStream.write(PdfEncodings.convertToBytes(toString(), (String) null));
    }

    @Override // com.itextpdf.text.pdf.PdfObject
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.number);
        stringBuffer.append(" ");
        stringBuffer.append(this.generation);
        stringBuffer.append(" R");
        return stringBuffer.toString();
    }

    public PdfIndirectReference(int i, int i2, int i3) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i2);
        stringBuffer.append(" ");
        stringBuffer.append(i3);
        stringBuffer.append(" R");
        super(0, stringBuffer.toString());
        this.number = i2;
        this.generation = i3;
    }

    public PdfIndirectReference(int i, int i2) {
        this(i, i2, 0);
    }
}
