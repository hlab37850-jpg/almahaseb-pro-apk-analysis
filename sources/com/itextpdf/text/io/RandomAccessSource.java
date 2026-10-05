package com.itextpdf.text.io;

/* JADX INFO: loaded from: classes3.dex */
public interface RandomAccessSource {
    void close();

    int get(long j);

    int get(long j, byte[] bArr, int i, int i2);

    long length();
}
