package com.zebra.sdk.printer.internal;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class RleEncodedImage {
    private ByteArrayOutputStream outputImageByteStream = new ByteArrayOutputStream();

    public class DataBuffer {
        int currentIndex = 0;
        byte[] imageData;

        public DataBuffer(byte[] bArr) {
            this.imageData = bArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int bytesLeft() {
            return this.imageData.length - this.currentIndex;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public byte peek() {
            return this.imageData[this.currentIndex];
        }

        public byte getByte() {
            byte[] bArr = this.imageData;
            int i = this.currentIndex;
            this.currentIndex = i + 1;
            return bArr[i];
        }
    }

    private boolean bothUpperBitsAreSet(byte b) {
        return (b & 192) == 192;
    }

    private byte[] createRun(int i, byte b) {
        return new byte[]{(byte) (((byte) i) | 192), b};
    }

    private byte[] encodeRun(byte b, DataBuffer dataBuffer) {
        int i = 1;
        while (dataBuffer.bytesLeft() > 0 && b == dataBuffer.peek() && i < 63) {
            dataBuffer.getByte();
            i++;
        }
        return createRun(i, b);
    }

    private byte[] getNextElement(DataBuffer dataBuffer) {
        byte b = dataBuffer.getByte();
        if (dataBuffer.bytesLeft() <= 0 || b != dataBuffer.peek()) {
            return bothUpperBitsAreSet(b) ? createRun(1, b) : new byte[]{b};
        }
        return encodeRun(b, dataBuffer);
    }

    private void outputElement(byte[] bArr) {
        this.outputImageByteStream.write(bArr, 0, bArr.length);
    }

    private void rleEncoding(DataBuffer dataBuffer) {
        outputElement(getNextElement(dataBuffer));
        if (dataBuffer.bytesLeft() > 0) {
            rleEncoding(dataBuffer);
        }
    }

    public byte[] rleEncoding(byte[] bArr, int i) throws IOException {
        byte[] bArr2;
        boolean z = i % 2 != 0;
        int i2 = 0;
        while (i2 < bArr.length) {
            int length = bArr.length - i2;
            if (length >= i) {
                length = i;
            }
            if (z) {
                bArr2 = new byte[length + 1];
                for (int i3 = 0; i3 < length; i3++) {
                    bArr2[i3] = bArr[i2 + i3];
                }
                bArr2[length] = 0;
            } else {
                bArr2 = new byte[length];
                System.arraycopy(bArr, i2, bArr2, 0, length);
            }
            rleEncoding(new DataBuffer(bArr2));
            i2 += i;
        }
        byte[] byteArray = this.outputImageByteStream.toByteArray();
        this.outputImageByteStream.close();
        return byteArray;
    }
}
