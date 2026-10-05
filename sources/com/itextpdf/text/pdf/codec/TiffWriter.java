package com.itextpdf.text.pdf.codec;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes3.dex */
public class TiffWriter {
    private TreeMap<Integer, FieldBase> ifd = new TreeMap<>();

    public static class FieldAscii extends FieldBase {
        public FieldAscii(int i, String str) {
            super(i, 2, str.getBytes().length + 1);
            byte[] bytes = str.getBytes();
            byte[] bArr = new byte[bytes.length + 1];
            this.data = bArr;
            System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        }
    }

    public static abstract class FieldBase {
        private int count;
        protected byte[] data;
        private int fieldType;
        private int offset;
        private int tag;

        public FieldBase(int i, int i2, int i3) {
            this.tag = i;
            this.fieldType = i2;
            this.count = i3;
        }

        public int getTag() {
            return this.tag;
        }

        public int getValueSize() {
            return (this.data.length + 1) & (-2);
        }

        public void setOffset(int i) {
            this.offset = i;
        }

        public void writeField(OutputStream outputStream) throws IOException {
            TiffWriter.writeShort(this.tag, outputStream);
            TiffWriter.writeShort(this.fieldType, outputStream);
            TiffWriter.writeLong(this.count, outputStream);
            byte[] bArr = this.data;
            if (bArr.length > 4) {
                TiffWriter.writeLong(this.offset, outputStream);
                return;
            }
            outputStream.write(bArr);
            for (int length = this.data.length; length < 4; length++) {
                outputStream.write(0);
            }
        }

        public void writeValue(OutputStream outputStream) throws IOException {
            byte[] bArr = this.data;
            if (bArr.length <= 4) {
                return;
            }
            outputStream.write(bArr);
            if ((this.data.length & 1) == 1) {
                outputStream.write(0);
            }
        }
    }

    public static class FieldByte extends FieldBase {
        public FieldByte(int i, byte[] bArr) {
            super(i, 1, bArr.length);
            this.data = bArr;
        }
    }

    public static class FieldImage extends FieldBase {
        public FieldImage(byte[] bArr) {
            super(TIFFConstants.TIFFTAG_STRIPOFFSETS, 4, 1);
            this.data = bArr;
        }
    }

    public static class FieldRational extends FieldBase {
        public FieldRational(int i, int[] iArr) {
            this(i, new int[][]{iArr});
        }

        public FieldRational(int i, int[][] iArr) {
            super(i, 5, iArr.length);
            this.data = new byte[iArr.length * 8];
            int i2 = 0;
            for (int[] iArr2 : iArr) {
                byte[] bArr = this.data;
                int i3 = iArr2[0];
                bArr[i2] = (byte) (i3 >> 24);
                bArr[i2 + 1] = (byte) (i3 >> 16);
                bArr[i2 + 2] = (byte) (i3 >> 8);
                bArr[i2 + 3] = (byte) i3;
                int i4 = iArr2[1];
                bArr[i2 + 4] = (byte) (i4 >> 24);
                bArr[i2 + 5] = (byte) (i4 >> 16);
                int i5 = i2 + 7;
                bArr[i2 + 6] = (byte) (i4 >> 8);
                i2 += 8;
                bArr[i5] = (byte) i4;
            }
        }
    }

    public static class FieldUndefined extends FieldBase {
        public FieldUndefined(int i, byte[] bArr) {
            super(i, 7, bArr.length);
            this.data = bArr;
        }
    }

    public static void compressLZW(OutputStream outputStream, int i, byte[] bArr, int i2, int i3, int i4) throws IOException {
        LZWCompressor lZWCompressor = new LZWCompressor(outputStream, 8, true);
        boolean z = i == 2;
        if (z) {
            byte[] bArr2 = z ? new byte[i4] : null;
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                System.arraycopy(bArr, i5, bArr2, 0, i4);
                for (int i7 = i4 - 1; i7 >= i3; i7--) {
                    bArr2[i7] = (byte) (bArr2[i7] - bArr2[i7 - i3]);
                }
                lZWCompressor.compress(bArr2, 0, i4);
                i5 += i4;
            }
        } else {
            lZWCompressor.compress(bArr, 0, bArr.length);
        }
        lZWCompressor.flush();
    }

    public static void writeLong(int i, OutputStream outputStream) throws IOException {
        outputStream.write((i >> 24) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write(i & 255);
    }

    public static void writeShort(int i, OutputStream outputStream) throws IOException {
        outputStream.write((i >> 8) & 255);
        outputStream.write(i & 255);
    }

    public void addField(FieldBase fieldBase) {
        this.ifd.put(Integer.valueOf(fieldBase.getTag()), fieldBase);
    }

    public int getIfdSize() {
        return (this.ifd.size() * 12) + 6;
    }

    public void writeFile(OutputStream outputStream) throws IOException {
        outputStream.write(77);
        outputStream.write(77);
        outputStream.write(0);
        outputStream.write(42);
        writeLong(8, outputStream);
        writeShort(this.ifd.size(), outputStream);
        int ifdSize = getIfdSize() + 8;
        for (FieldBase fieldBase : this.ifd.values()) {
            int valueSize = fieldBase.getValueSize();
            if (valueSize > 4) {
                fieldBase.setOffset(ifdSize);
                ifdSize += valueSize;
            }
            fieldBase.writeField(outputStream);
        }
        writeLong(0, outputStream);
        Iterator<FieldBase> it = this.ifd.values().iterator();
        while (it.hasNext()) {
            it.next().writeValue(outputStream);
        }
    }

    public static class FieldShort extends FieldBase {
        public FieldShort(int i, int i2) {
            super(i, 3, 1);
            this.data = new byte[]{(byte) (i2 >> 8), (byte) i2};
        }

        public FieldShort(int i, int[] iArr) {
            super(i, 3, iArr.length);
            this.data = new byte[iArr.length * 2];
            int i2 = 0;
            for (int i3 : iArr) {
                byte[] bArr = this.data;
                int i4 = i2 + 1;
                bArr[i2] = (byte) (i3 >> 8);
                i2 += 2;
                bArr[i4] = (byte) i3;
            }
        }
    }

    public static class FieldLong extends FieldBase {
        public FieldLong(int i, int i2) {
            super(i, 4, 1);
            this.data = new byte[]{(byte) (i2 >> 24), (byte) (i2 >> 16), (byte) (i2 >> 8), (byte) i2};
        }

        public FieldLong(int i, int[] iArr) {
            super(i, 4, iArr.length);
            this.data = new byte[iArr.length * 4];
            int i2 = 0;
            for (int i3 : iArr) {
                byte[] bArr = this.data;
                bArr[i2] = (byte) (i3 >> 24);
                bArr[i2 + 1] = (byte) (i3 >> 16);
                int i4 = i2 + 3;
                bArr[i2 + 2] = (byte) (i3 >> 8);
                i2 += 4;
                bArr[i4] = (byte) i3;
            }
        }
    }
}
