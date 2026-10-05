package com.itextpdf.text.io;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.common.primitives.UnsignedBytes;

/* JADX INFO: loaded from: classes3.dex */
public class GetBufferedRandomAccessSource implements RandomAccessSource {
    private final byte[] getBuffer;
    private long getBufferEnd;
    private long getBufferStart;
    private final RandomAccessSource source;

    public GetBufferedRandomAccessSource(RandomAccessSource randomAccessSource) {
        this.getBufferStart = -1L;
        this.getBufferEnd = -1L;
        this.source = randomAccessSource;
        this.getBuffer = new byte[(int) Math.min(Math.max(randomAccessSource.length() / 4, 1L), PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM)];
        this.getBufferStart = -1L;
        this.getBufferEnd = -1L;
    }

    @Override // com.itextpdf.text.io.RandomAccessSource
    public void close() {
        this.source.close();
        this.getBufferStart = -1L;
        this.getBufferEnd = -1L;
    }

    @Override // com.itextpdf.text.io.RandomAccessSource
    public int get(long j) {
        if (j < this.getBufferStart || j > this.getBufferEnd) {
            RandomAccessSource randomAccessSource = this.source;
            byte[] bArr = this.getBuffer;
            int i = randomAccessSource.get(j, bArr, 0, bArr.length);
            if (i == -1) {
                return -1;
            }
            this.getBufferStart = j;
            this.getBufferEnd = (((long) i) + j) - 1;
        }
        return this.getBuffer[(int) (j - this.getBufferStart)] & UnsignedBytes.MAX_VALUE;
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
