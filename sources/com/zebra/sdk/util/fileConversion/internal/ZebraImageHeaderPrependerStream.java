package com.zebra.sdk.util.fileConversion.internal;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class ZebraImageHeaderPrependerStream extends InputStream {
    private InputStream dataUnwrapperStream;
    int[] headerData;
    int preReadIndex;
    int preReadLimit = 50;
    int preReadCounter = 0;
    int[] preReadDataBuffer = new int[50];
    int headerCounter = 0;

    public ZebraImageHeaderPrependerStream(InputStream inputStream, int i, int i2) throws IOException {
        this.preReadIndex = 0;
        this.headerData = null;
        if (inputStream == null) {
            throw new IOException("input stream is null");
        }
        this.dataUnwrapperStream = inputStream;
        while (true) {
            int i3 = this.preReadIndex;
            if (i3 >= this.preReadLimit) {
                break;
            }
            int[] iArr = this.preReadDataBuffer;
            this.preReadIndex = i3 + 1;
            iArr[i3] = this.dataUnwrapperStream.read();
        }
        if (this.headerData == null) {
            this.headerData = DYHelper.calculateZebraHeader(this.preReadDataBuffer, i, i2);
        }
    }

    @Override // java.io.InputStream
    public int read() {
        int i;
        int[] iArr = this.headerData;
        if (iArr != null && (i = this.headerCounter) < 4) {
            this.headerCounter = i + 1;
            return iArr[i];
        }
        int i2 = this.preReadCounter;
        if (i2 >= this.preReadIndex) {
            return this.dataUnwrapperStream.read();
        }
        int[] iArr2 = this.preReadDataBuffer;
        this.preReadCounter = i2 + 1;
        return iArr2[i2];
    }
}
