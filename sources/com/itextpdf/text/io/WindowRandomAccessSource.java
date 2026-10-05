package com.itextpdf.text.io;

/* JADX INFO: loaded from: classes3.dex */
public class WindowRandomAccessSource implements RandomAccessSource {
    private final long length;
    private final long offset;
    private final RandomAccessSource source;

    public WindowRandomAccessSource(RandomAccessSource randomAccessSource, long j) {
        this(randomAccessSource, j, randomAccessSource.length() - j);
    }

    @Override // com.itextpdf.text.io.RandomAccessSource
    public void close() {
        this.source.close();
    }

    @Override // com.itextpdf.text.io.RandomAccessSource
    public int get(long j) {
        if (j >= this.length) {
            return -1;
        }
        return this.source.get(this.offset + j);
    }

    @Override // com.itextpdf.text.io.RandomAccessSource
    public long length() {
        return this.length;
    }

    public WindowRandomAccessSource(RandomAccessSource randomAccessSource, long j, long j2) {
        this.source = randomAccessSource;
        this.offset = j;
        this.length = j2;
    }

    @Override // com.itextpdf.text.io.RandomAccessSource
    public int get(long j, byte[] bArr, int i, int i2) {
        long j2 = this.length;
        if (j >= j2) {
            return -1;
        }
        return this.source.get(this.offset + j, bArr, i, (int) Math.min(i2, j2 - j));
    }
}
