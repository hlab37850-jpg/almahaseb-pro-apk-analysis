package com.itextpdf.text.pdf.codec;

import androidx.core.app.FrameMetricsAggregator;
import com.google.common.primitives.UnsignedBytes;
import com.itextpdf.text.error_messages.MessageLocalization;
import org.apache.poi.ss.util.IEEEDouble;

/* JADX INFO: loaded from: classes3.dex */
public class TIFFLZWDecoder {
    int bitPointer;
    int bytePointer;
    int dstIndex;
    int h;
    int predictor;
    int samplesPerPixel;
    byte[][] stringTable;
    int tableIndex;
    byte[] uncompData;
    int w;
    byte[] data = null;
    int bitsToGet = 9;
    int nextData = 0;
    int nextBits = 0;
    int[] andTable = {FrameMetricsAggregator.EVERY_DURATION, IEEEDouble.EXPONENT_BIAS, IEEEDouble.BIASED_EXPONENT_SPECIAL_VALUE, 4095};

    public TIFFLZWDecoder(int i, int i2, int i3) {
        this.w = i;
        this.predictor = i2;
        this.samplesPerPixel = i3;
    }

    public void addStringToTable(byte[] bArr, byte b) {
        int length = bArr.length;
        byte[] bArr2 = new byte[length + 1];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        bArr2[length] = b;
        byte[][] bArr3 = this.stringTable;
        int i = this.tableIndex;
        int i2 = i + 1;
        this.tableIndex = i2;
        bArr3[i] = bArr2;
        if (i2 == 511) {
            this.bitsToGet = 10;
        } else if (i2 == 1023) {
            this.bitsToGet = 11;
        } else if (i2 == 2047) {
            this.bitsToGet = 12;
        }
    }

    public byte[] composeString(byte[] bArr, byte b) {
        int length = bArr.length;
        byte[] bArr2 = new byte[length + 1];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        bArr2[length] = b;
        return bArr2;
    }

    public byte[] decode(byte[] bArr, byte[] bArr2, int i) {
        if (bArr[0] == 0 && bArr[1] == 1) {
            throw new UnsupportedOperationException(MessageLocalization.getComposedMessage("tiff.5.0.style.lzw.codes.are.not.supported", new Object[0]));
        }
        initializeStringTable();
        this.data = bArr;
        this.h = i;
        this.uncompData = bArr2;
        this.bytePointer = 0;
        this.bitPointer = 0;
        this.dstIndex = 0;
        this.nextData = 0;
        this.nextBits = 0;
        int nextCode = 0;
        while (true) {
            int nextCode2 = getNextCode();
            if (nextCode2 == 257 || this.dstIndex >= bArr2.length) {
                break;
            }
            if (nextCode2 == 256) {
                initializeStringTable();
                nextCode = getNextCode();
                if (nextCode == 257) {
                    break;
                }
                writeString(this.stringTable[nextCode]);
            } else {
                if (nextCode2 < this.tableIndex) {
                    byte[] bArr3 = this.stringTable[nextCode2];
                    writeString(bArr3);
                    addStringToTable(this.stringTable[nextCode], bArr3[0]);
                } else {
                    byte[] bArr4 = this.stringTable[nextCode];
                    byte[] bArrComposeString = composeString(bArr4, bArr4[0]);
                    writeString(bArrComposeString);
                    addStringToTable(bArrComposeString);
                }
                nextCode = nextCode2;
            }
        }
        if (this.predictor == 2) {
            for (int i2 = 0; i2 < i; i2++) {
                int i3 = this.samplesPerPixel;
                int i4 = ((this.w * i2) + 1) * i3;
                while (true) {
                    int i5 = this.w;
                    int i6 = this.samplesPerPixel;
                    if (i3 < i5 * i6) {
                        bArr2[i4] = (byte) (bArr2[i4] + bArr2[i4 - i6]);
                        i4++;
                        i3++;
                    }
                }
            }
        }
        return bArr2;
    }

    public int getNextCode() {
        try {
            int i = this.nextData << 8;
            byte[] bArr = this.data;
            int i2 = this.bytePointer;
            int i3 = i2 + 1;
            this.bytePointer = i3;
            int i4 = i | (bArr[i2] & UnsignedBytes.MAX_VALUE);
            this.nextData = i4;
            int i5 = this.nextBits;
            int i6 = i5 + 8;
            this.nextBits = i6;
            int i7 = this.bitsToGet;
            if (i6 < i7) {
                this.bytePointer = i2 + 2;
                this.nextData = (i4 << 8) | (bArr[i3] & UnsignedBytes.MAX_VALUE);
                this.nextBits = i5 + 16;
            }
            int i8 = this.nextData;
            int i9 = this.nextBits;
            int i10 = (i8 >> (i9 - i7)) & this.andTable[i7 - 9];
            this.nextBits = i9 - i7;
            return i10;
        } catch (ArrayIndexOutOfBoundsException unused) {
            return 257;
        }
    }

    public void initializeStringTable() {
        this.stringTable = new byte[4096][];
        for (int i = 0; i < 256; i++) {
            this.stringTable[i] = new byte[]{(byte) i};
        }
        this.tableIndex = 258;
        this.bitsToGet = 9;
    }

    public void writeString(byte[] bArr) {
        byte[] bArr2 = this.uncompData;
        int length = bArr2.length;
        int i = this.dstIndex;
        int length2 = length - i;
        if (bArr.length < length2) {
            length2 = bArr.length;
        }
        System.arraycopy(bArr, 0, bArr2, i, length2);
        this.dstIndex += length2;
    }

    public void addStringToTable(byte[] bArr) {
        byte[][] bArr2 = this.stringTable;
        int i = this.tableIndex;
        int i2 = i + 1;
        this.tableIndex = i2;
        bArr2[i] = bArr;
        if (i2 == 511) {
            this.bitsToGet = 10;
        } else if (i2 == 1023) {
            this.bitsToGet = 11;
        } else if (i2 == 2047) {
            this.bitsToGet = 12;
        }
    }
}
