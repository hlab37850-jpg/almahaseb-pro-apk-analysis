package com.zebra.sdk.util.fileConversion.internal;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public abstract class StreamDecoratorBase extends InputStream implements MetadataProvider {
    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        bArr.getClass();
        if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 == 0) {
            return 0;
        }
        int i3 = read();
        if (i3 == -1) {
            return -1;
        }
        bArr[i] = (byte) i3;
        int i4 = 1;
        while (i4 < i2) {
            int i5 = read();
            if (i5 == -1) {
                break;
            }
            bArr[i + i4] = (byte) i5;
            i4++;
        }
        return i4;
    }
}
