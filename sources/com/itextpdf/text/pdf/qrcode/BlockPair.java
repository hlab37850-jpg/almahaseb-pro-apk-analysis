package com.itextpdf.text.pdf.qrcode;

/* JADX INFO: loaded from: classes3.dex */
final class BlockPair {
    private final ByteArray dataBytes;
    private final ByteArray errorCorrectionBytes;

    public BlockPair(ByteArray byteArray, ByteArray byteArray2) {
        this.dataBytes = byteArray;
        this.errorCorrectionBytes = byteArray2;
    }

    public ByteArray getDataBytes() {
        return this.dataBytes;
    }

    public ByteArray getErrorCorrectionBytes() {
        return this.errorCorrectionBytes;
    }
}
