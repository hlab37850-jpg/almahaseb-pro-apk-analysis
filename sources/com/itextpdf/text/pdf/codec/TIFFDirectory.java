package com.itextpdf.text.pdf.codec;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.RandomAccessFileOrArray;
import java.io.EOFException;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

/* JADX INFO: loaded from: classes3.dex */
public class TIFFDirectory implements Serializable {
    private static final long serialVersionUID = -168636766193675380L;
    private static final int[] sizeOfType = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
    TIFFField[] fields;
    boolean isBigEndian;
    int numEntries;
    Hashtable<Integer, Integer> fieldIndex = new Hashtable<>();
    long IFDOffset = 8;
    long nextIFDOffset = 0;

    public TIFFDirectory() {
    }

    public static int getNumDirectories(RandomAccessFileOrArray randomAccessFileOrArray) throws EOFException {
        long filePointer = randomAccessFileOrArray.getFilePointer();
        randomAccessFileOrArray.seek(0L);
        int unsignedShort = randomAccessFileOrArray.readUnsignedShort();
        int i = 0;
        if (!isValidEndianTag(unsignedShort)) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("bad.endianness.tag.not.0x4949.or.0x4d4d", new Object[0]));
        }
        boolean z = unsignedShort == 19789;
        if (readUnsignedShort(randomAccessFileOrArray, z) != 42) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("bad.magic.number.should.be.42", new Object[0]));
        }
        randomAccessFileOrArray.seek(4L);
        long unsignedInt = readUnsignedInt(randomAccessFileOrArray, z);
        while (unsignedInt != 0) {
            int i2 = i + 1;
            try {
                randomAccessFileOrArray.seek(unsignedInt);
                randomAccessFileOrArray.skip(readUnsignedShort(randomAccessFileOrArray, z) * 12);
                unsignedInt = readUnsignedInt(randomAccessFileOrArray, z);
                i = i2;
            } catch (EOFException unused) {
            }
        }
        randomAccessFileOrArray.seek(filePointer);
        return i;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x005e  */
    /* JADX WARN: Code duplicated, block: B:16:0x0061  */
    /* JADX WARN: Code duplicated, block: B:18:0x0066 A[LOOP:1: B:17:0x0064->B:18:0x0066, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:19:0x006f  */
    /* JADX WARN: Code duplicated, block: B:21:0x0074 A[LOOP:2: B:20:0x0072->B:21:0x0074, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:22:0x007d  */
    /* JADX WARN: Code duplicated, block: B:24:0x008e A[LOOP:3: B:23:0x008c->B:24:0x008e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:25:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:27:0x00a6 A[LOOP:4: B:26:0x00a4->B:27:0x00a6, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:28:0x00af  */
    /* JADX WARN: Code duplicated, block: B:30:0x00b4 A[LOOP:5: B:29:0x00b2->B:30:0x00b4, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:31:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:33:0x00ce A[LOOP:6: B:32:0x00cc->B:33:0x00ce, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:34:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:36:0x00e6 A[LOOP:7: B:35:0x00e4->B:36:0x00e6, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:37:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:39:0x00f4 A[LOOP:8: B:38:0x00f2->B:39:0x00f4, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:40:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:42:0x0105  */
    /* JADX WARN: Code duplicated, block: B:44:0x010d A[ADDED_TO_REGION, LOOP:10: B:44:0x010d->B:47:0x0115, LOOP_START, PHI: r15
      0x010d: PHI (r15v3 int) = (r15v2 int), (r15v7 int) binds: [B:43:0x010b, B:47:0x0115] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:45:0x010f  */
    /* JADX WARN: Code duplicated, block: B:47:0x0115 A[LOOP:10: B:44:0x010d->B:47:0x0115, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:52:0x012f A[LOOP:11: B:51:0x012d->B:52:0x012f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:54:0x013c  */
    /* JADX WARN: Code duplicated, block: B:79:0x0118 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v12, types: [long[]] */
    /* JADX WARN: Type inference failed for: r10v15, types: [long[][]] */
    /* JADX WARN: Type inference failed for: r10v17, types: [int[]] */
    /* JADX WARN: Type inference failed for: r10v20, types: [int[][]] */
    /* JADX WARN: Type inference failed for: r10v21, types: [float[]] */
    /* JADX WARN: Type inference failed for: r10v22, types: [double[]] */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v8 */
    private void initialize(RandomAccessFileOrArray randomAccessFileOrArray) throws EOFException {
        byte[] bArr;
        short[] sArr;
        ArrayList arrayList;
        int i;
        String[] strArr;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        long length = randomAccessFileOrArray.length();
        this.IFDOffset = randomAccessFileOrArray.getFilePointer();
        int unsignedShort = readUnsignedShort(randomAccessFileOrArray);
        this.numEntries = unsignedShort;
        this.fields = new TIFFField[unsignedShort];
        int i12 = 0;
        int i13 = 0;
        long j = 0;
        while (i13 < this.numEntries && j < length) {
            int unsignedShort2 = readUnsignedShort(randomAccessFileOrArray);
            int unsignedShort3 = readUnsignedShort(randomAccessFileOrArray);
            int unsignedInt = (int) readUnsignedInt(randomAccessFileOrArray);
            long filePointer = randomAccessFileOrArray.getFilePointer() + 4;
            try {
                if (sizeOfType[unsignedShort3] * unsignedInt > 4) {
                    long unsignedInt2 = readUnsignedInt(randomAccessFileOrArray);
                    if (unsignedInt2 < length) {
                        randomAccessFileOrArray.seek(unsignedInt2);
                        this.fieldIndex.put(Integer.valueOf(unsignedShort2), Integer.valueOf(i13));
                        switch (unsignedShort3) {
                            case 1:
                            case 2:
                            case 6:
                            case 7:
                                bArr = new byte[unsignedInt];
                                randomAccessFileOrArray.readFully(bArr, i12, unsignedInt);
                                if (unsignedShort3 == 2) {
                                    arrayList = new ArrayList();
                                    i = 0;
                                    while (i < unsignedInt) {
                                        while (i < unsignedInt) {
                                            i3 = i + 1;
                                            if (bArr[i] != 0) {
                                                i = i3;
                                            }
                                            i = i3;
                                            break;
                                        }
                                        arrayList.add(new String(bArr, i12, i - i12));
                                        i12 = i;
                                    }
                                    unsignedInt = arrayList.size();
                                    strArr = new String[unsignedInt];
                                    for (i2 = 0; i2 < unsignedInt; i2++) {
                                        strArr[i2] = (String) arrayList.get(i2);
                                    }
                                    sArr = strArr;
                                } else {
                                    sArr = bArr;
                                }
                                break;
                            case 3:
                                sArr = new char[unsignedInt];
                                for (i4 = 0; i4 < unsignedInt; i4++) {
                                    sArr[i4] = (char) readUnsignedShort(randomAccessFileOrArray);
                                }
                                break;
                            case 4:
                                sArr = new long[unsignedInt];
                                for (i5 = 0; i5 < unsignedInt; i5++) {
                                    sArr[i5] = readUnsignedInt(randomAccessFileOrArray);
                                }
                                break;
                            case 5:
                                int[] iArr = new int[2];
                                iArr[1] = 2;
                                iArr[i12] = unsignedInt;
                                sArr = (long[][]) Array.newInstance((Class<?>) Long.TYPE, iArr);
                                for (i6 = 0; i6 < unsignedInt; i6++) {
                                    sArr[i6][i12] = readUnsignedInt(randomAccessFileOrArray);
                                    sArr[i6][1] = readUnsignedInt(randomAccessFileOrArray);
                                }
                                break;
                            case 8:
                                sArr = new short[unsignedInt];
                                for (i7 = 0; i7 < unsignedInt; i7++) {
                                    sArr[i7] = readShort(randomAccessFileOrArray);
                                }
                                break;
                            case 9:
                                sArr = new int[unsignedInt];
                                for (i8 = 0; i8 < unsignedInt; i8++) {
                                    sArr[i8] = readInt(randomAccessFileOrArray);
                                }
                                break;
                            case 10:
                                int[] iArr2 = new int[2];
                                iArr2[1] = 2;
                                iArr2[i12] = unsignedInt;
                                sArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, iArr2);
                                for (i9 = 0; i9 < unsignedInt; i9++) {
                                    sArr[i9][i12] = readInt(randomAccessFileOrArray);
                                    sArr[i9][1] = readInt(randomAccessFileOrArray);
                                }
                                break;
                            case 11:
                                sArr = new float[unsignedInt];
                                for (i10 = 0; i10 < unsignedInt; i10++) {
                                    sArr[i10] = readFloat(randomAccessFileOrArray);
                                }
                                break;
                            case 12:
                                sArr = new double[unsignedInt];
                                for (i11 = 0; i11 < unsignedInt; i11++) {
                                    sArr[i11] = readDouble(randomAccessFileOrArray);
                                }
                                break;
                            default:
                                sArr = 0;
                                break;
                        }
                        this.fields[i13] = new TIFFField(unsignedShort2, unsignedShort3, unsignedInt, sArr);
                    }
                } else {
                    this.fieldIndex.put(Integer.valueOf(unsignedShort2), Integer.valueOf(i13));
                    switch (unsignedShort3) {
                        case 1:
                        case 2:
                        case 6:
                        case 7:
                            bArr = new byte[unsignedInt];
                            randomAccessFileOrArray.readFully(bArr, i12, unsignedInt);
                            if (unsignedShort3 == 2) {
                                arrayList = new ArrayList();
                                i = 0;
                                while (i < unsignedInt) {
                                    while (i < unsignedInt) {
                                        i3 = i + 1;
                                        if (bArr[i] != 0) {
                                            i = i3;
                                        }
                                        i = i3;
                                        break;
                                    }
                                    arrayList.add(new String(bArr, i12, i - i12));
                                    i12 = i;
                                }
                                unsignedInt = arrayList.size();
                                strArr = new String[unsignedInt];
                                while (i2 < unsignedInt) {
                                    strArr[i2] = (String) arrayList.get(i2);
                                }
                                sArr = strArr;
                            } else {
                                sArr = bArr;
                            }
                            break;
                        case 3:
                            sArr = new char[unsignedInt];
                            while (i4 < unsignedInt) {
                                sArr[i4] = (char) readUnsignedShort(randomAccessFileOrArray);
                            }
                            break;
                        case 4:
                            sArr = new long[unsignedInt];
                            while (i5 < unsignedInt) {
                                sArr[i5] = readUnsignedInt(randomAccessFileOrArray);
                            }
                            break;
                        case 5:
                            int[] iArr3 = new int[2];
                            iArr3[1] = 2;
                            iArr3[i12] = unsignedInt;
                            sArr = (long[][]) Array.newInstance((Class<?>) Long.TYPE, iArr3);
                            while (i6 < unsignedInt) {
                                sArr[i6][i12] = readUnsignedInt(randomAccessFileOrArray);
                                sArr[i6][1] = readUnsignedInt(randomAccessFileOrArray);
                            }
                            break;
                        case 8:
                            sArr = new short[unsignedInt];
                            while (i7 < unsignedInt) {
                                sArr[i7] = readShort(randomAccessFileOrArray);
                            }
                            break;
                        case 9:
                            sArr = new int[unsignedInt];
                            while (i8 < unsignedInt) {
                                sArr[i8] = readInt(randomAccessFileOrArray);
                            }
                            break;
                        case 10:
                            int[] iArr4 = new int[2];
                            iArr4[1] = 2;
                            iArr4[i12] = unsignedInt;
                            sArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, iArr4);
                            while (i9 < unsignedInt) {
                                sArr[i9][i12] = readInt(randomAccessFileOrArray);
                                sArr[i9][1] = readInt(randomAccessFileOrArray);
                            }
                            break;
                        case 11:
                            sArr = new float[unsignedInt];
                            while (i10 < unsignedInt) {
                                sArr[i10] = readFloat(randomAccessFileOrArray);
                            }
                            break;
                        case 12:
                            sArr = new double[unsignedInt];
                            while (i11 < unsignedInt) {
                                sArr[i11] = readDouble(randomAccessFileOrArray);
                            }
                            break;
                        default:
                            sArr = 0;
                            break;
                    }
                    this.fields[i13] = new TIFFField(unsignedShort2, unsignedShort3, unsignedInt, sArr);
                }
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
            randomAccessFileOrArray.seek(filePointer);
            i13++;
            j = filePointer;
            i12 = 0;
        }
        try {
            this.nextIFDOffset = readUnsignedInt(randomAccessFileOrArray);
        } catch (Exception unused2) {
            this.nextIFDOffset = 0L;
        }
    }

    private static boolean isValidEndianTag(int i) {
        return i == 18761 || i == 19789;
    }

    private double readDouble(RandomAccessFileOrArray randomAccessFileOrArray) {
        return this.isBigEndian ? randomAccessFileOrArray.readDouble() : randomAccessFileOrArray.readDoubleLE();
    }

    private float readFloat(RandomAccessFileOrArray randomAccessFileOrArray) {
        return this.isBigEndian ? randomAccessFileOrArray.readFloat() : randomAccessFileOrArray.readFloatLE();
    }

    private int readInt(RandomAccessFileOrArray randomAccessFileOrArray) {
        return this.isBigEndian ? randomAccessFileOrArray.readInt() : randomAccessFileOrArray.readIntLE();
    }

    private long readLong(RandomAccessFileOrArray randomAccessFileOrArray) {
        return this.isBigEndian ? randomAccessFileOrArray.readLong() : randomAccessFileOrArray.readLongLE();
    }

    private short readShort(RandomAccessFileOrArray randomAccessFileOrArray) {
        return this.isBigEndian ? randomAccessFileOrArray.readShort() : randomAccessFileOrArray.readShortLE();
    }

    private long readUnsignedInt(RandomAccessFileOrArray randomAccessFileOrArray) {
        return this.isBigEndian ? randomAccessFileOrArray.readUnsignedInt() : randomAccessFileOrArray.readUnsignedIntLE();
    }

    private int readUnsignedShort(RandomAccessFileOrArray randomAccessFileOrArray) {
        return this.isBigEndian ? randomAccessFileOrArray.readUnsignedShort() : randomAccessFileOrArray.readUnsignedShortLE();
    }

    public TIFFField getField(int i) {
        Integer num = this.fieldIndex.get(Integer.valueOf(i));
        if (num == null) {
            return null;
        }
        return this.fields[num.intValue()];
    }

    public byte getFieldAsByte(int i, int i2) {
        return this.fields[this.fieldIndex.get(Integer.valueOf(i)).intValue()].getAsBytes()[i2];
    }

    public double getFieldAsDouble(int i, int i2) {
        return this.fields[this.fieldIndex.get(Integer.valueOf(i)).intValue()].getAsDouble(i2);
    }

    public float getFieldAsFloat(int i, int i2) {
        return this.fields[this.fieldIndex.get(Integer.valueOf(i)).intValue()].getAsFloat(i2);
    }

    public long getFieldAsLong(int i, int i2) {
        return this.fields[this.fieldIndex.get(Integer.valueOf(i)).intValue()].getAsLong(i2);
    }

    public TIFFField[] getFields() {
        return this.fields;
    }

    public long getIFDOffset() {
        return this.IFDOffset;
    }

    public long getNextIFDOffset() {
        return this.nextIFDOffset;
    }

    public int getNumEntries() {
        return this.numEntries;
    }

    public int[] getTags() {
        int[] iArr = new int[this.fieldIndex.size()];
        Enumeration<Integer> enumerationKeys = this.fieldIndex.keys();
        int i = 0;
        while (enumerationKeys.hasMoreElements()) {
            iArr[i] = enumerationKeys.nextElement().intValue();
            i++;
        }
        return iArr;
    }

    public boolean isBigEndian() {
        return this.isBigEndian;
    }

    public boolean isTagPresent(int i) {
        return this.fieldIndex.containsKey(Integer.valueOf(i));
    }

    public double getFieldAsDouble(int i) {
        return getFieldAsDouble(i, 0);
    }

    public float getFieldAsFloat(int i) {
        return getFieldAsFloat(i, 0);
    }

    public long getFieldAsLong(int i) {
        return getFieldAsLong(i, 0);
    }

    private static long readUnsignedInt(RandomAccessFileOrArray randomAccessFileOrArray, boolean z) {
        if (z) {
            return randomAccessFileOrArray.readUnsignedInt();
        }
        return randomAccessFileOrArray.readUnsignedIntLE();
    }

    private static int readUnsignedShort(RandomAccessFileOrArray randomAccessFileOrArray, boolean z) {
        if (z) {
            return randomAccessFileOrArray.readUnsignedShort();
        }
        return randomAccessFileOrArray.readUnsignedShortLE();
    }

    public byte getFieldAsByte(int i) {
        return getFieldAsByte(i, 0);
    }

    public TIFFDirectory(RandomAccessFileOrArray randomAccessFileOrArray, int i) throws EOFException {
        long filePointer = randomAccessFileOrArray.getFilePointer();
        randomAccessFileOrArray.seek(0L);
        int unsignedShort = randomAccessFileOrArray.readUnsignedShort();
        if (isValidEndianTag(unsignedShort)) {
            this.isBigEndian = unsignedShort == 19789;
            if (readUnsignedShort(randomAccessFileOrArray) == 42) {
                long unsignedInt = readUnsignedInt(randomAccessFileOrArray);
                for (int i2 = 0; i2 < i; i2++) {
                    if (unsignedInt != 0) {
                        randomAccessFileOrArray.seek(unsignedInt);
                        randomAccessFileOrArray.skip(readUnsignedShort(randomAccessFileOrArray) * 12);
                        unsignedInt = readUnsignedInt(randomAccessFileOrArray);
                    } else {
                        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("directory.number.too.large", new Object[0]));
                    }
                }
                randomAccessFileOrArray.seek(unsignedInt);
                initialize(randomAccessFileOrArray);
                randomAccessFileOrArray.seek(filePointer);
                return;
            }
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("bad.magic.number.should.be.42", new Object[0]));
        }
        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("bad.endianness.tag.not.0x4949.or.0x4d4d", new Object[0]));
    }

    public TIFFDirectory(RandomAccessFileOrArray randomAccessFileOrArray, long j, int i) throws EOFException {
        long filePointer = randomAccessFileOrArray.getFilePointer();
        randomAccessFileOrArray.seek(0L);
        int unsignedShort = randomAccessFileOrArray.readUnsignedShort();
        if (isValidEndianTag(unsignedShort)) {
            this.isBigEndian = unsignedShort == 19789;
            randomAccessFileOrArray.seek(j);
            for (int i2 = 0; i2 < i; i2++) {
                randomAccessFileOrArray.seek(j + ((long) (readUnsignedShort(randomAccessFileOrArray) * 12)));
                j = readUnsignedInt(randomAccessFileOrArray);
                randomAccessFileOrArray.seek(j);
            }
            initialize(randomAccessFileOrArray);
            randomAccessFileOrArray.seek(filePointer);
            return;
        }
        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("bad.endianness.tag.not.0x4949.or.0x4d4d", new Object[0]));
    }
}
