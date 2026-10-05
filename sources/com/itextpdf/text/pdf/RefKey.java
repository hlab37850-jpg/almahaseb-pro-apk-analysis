package com.itextpdf.text.pdf;

/* JADX INFO: loaded from: classes3.dex */
public class RefKey {
    int gen;
    int num;

    public RefKey(int i, int i2) {
        this.num = i;
        this.gen = i2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof RefKey)) {
            return false;
        }
        RefKey refKey = (RefKey) obj;
        return this.gen == refKey.gen && this.num == refKey.num;
    }

    public int hashCode() {
        return (this.gen << 16) + this.num;
    }

    public String toString() {
        return Integer.toString(this.num) + ' ' + this.gen;
    }

    public RefKey(PdfIndirectReference pdfIndirectReference) {
        this.num = pdfIndirectReference.getNumber();
        this.gen = pdfIndirectReference.getGeneration();
    }

    public RefKey(PRIndirectReference pRIndirectReference) {
        this.num = pRIndirectReference.getNumber();
        this.gen = pRIndirectReference.getGeneration();
    }
}
