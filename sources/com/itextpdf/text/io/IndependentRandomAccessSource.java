package com.itextpdf.text.io;

/* JADX INFO: loaded from: classes3.dex */
public class IndependentRandomAccessSource implements RandomAccessSource {
    private final RandomAccessSource source;

    public IndependentRandomAccessSource(RandomAccessSource randomAccessSource) {
        this.source = randomAccessSource;
    }

    @Override // com.itextpdf.text.io.RandomAccessSource
    public void close() {
    }

    @Override // com.itextpdf.text.io.RandomAccessSource
    public int get(long j) {
        return this.source.get(j);
    }

    @Override // com.itextpdf.text.io.RandomAccessSource
    public long length() {
        return this.source.length();
    }

    @Override // com.itextpdf.text.io.RandomAccessSource
    public int get(long j, byte[] bArr, int i, int i2) {
        return this.source.get(j, bArr, i, i2);
    }
}
