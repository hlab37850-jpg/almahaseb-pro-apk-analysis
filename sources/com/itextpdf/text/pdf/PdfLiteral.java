package com.itextpdf.text.pdf;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class PdfLiteral extends PdfObject {
    private long position;

    public PdfLiteral(String str) {
        super(0, str);
    }

    public int getPosLength() {
        byte[] bArr = this.bytes;
        if (bArr != null) {
            return bArr.length;
        }
        return 0;
    }

    public long getPosition() {
        return this.position;
    }

    @Override // com.itextpdf.text.pdf.PdfObject
    public void toPdf(PdfWriter pdfWriter, OutputStream outputStream) throws IOException {
        if (outputStream instanceof OutputStreamCounter) {
            this.position = ((OutputStreamCounter) outputStream).getCounter();
        }
        super.toPdf(pdfWriter, outputStream);
    }

    public PdfLiteral(byte[] bArr) {
        super(0, bArr);
    }

    public PdfLiteral(int i) {
        super(0, (byte[]) null);
        byte[] bArr = new byte[i];
        this.bytes = bArr;
        Arrays.fill(bArr, (byte) 32);
    }

    public PdfLiteral(int i, String str) {
        super(i, str);
    }

    public PdfLiteral(int i, byte[] bArr) {
        super(i, bArr);
    }
}
