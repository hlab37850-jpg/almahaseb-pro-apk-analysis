package com.itextpdf.text.pdf.codec;

import com.google.common.primitives.UnsignedBytes;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class TIFFField implements Comparable<TIFFField>, Serializable {
    public static final int TIFF_ASCII = 2;
    public static final int TIFF_BYTE = 1;
    public static final int TIFF_DOUBLE = 12;
    public static final int TIFF_FLOAT = 11;
    public static final int TIFF_LONG = 4;
    public static final int TIFF_RATIONAL = 5;
    public static final int TIFF_SBYTE = 6;
    public static final int TIFF_SHORT = 3;
    public static final int TIFF_SLONG = 9;
    public static final int TIFF_SRATIONAL = 10;
    public static final int TIFF_SSHORT = 8;
    public static final int TIFF_UNDEFINED = 7;
    private static final long serialVersionUID = 9088332901412823834L;
    int count;
    Object data;
    int tag;
    int type;

    public TIFFField() {
    }

    public byte[] getAsBytes() {
        return (byte[]) this.data;
    }

    public char[] getAsChars() {
        return (char[]) this.data;
    }

    public double getAsDouble(int i) {
        double d;
        double d2;
        switch (this.type) {
            case 1:
                return ((byte[]) this.data)[i] & UnsignedBytes.MAX_VALUE;
            case 2:
            case 7:
            default:
                throw new ClassCastException();
            case 3:
                return ((char[]) this.data)[i] & 65535;
            case 4:
                return ((long[]) this.data)[i];
            case 5:
                long[] asRational = getAsRational(i);
                d = asRational[0];
                d2 = asRational[1];
                break;
            case 6:
                return ((byte[]) this.data)[i];
            case 8:
                return ((short[]) this.data)[i];
            case 9:
                return ((int[]) this.data)[i];
            case 10:
                int[] asSRational = getAsSRational(i);
                d = asSRational[0];
                d2 = asSRational[1];
                break;
            case 11:
                return ((float[]) this.data)[i];
            case 12:
                return ((double[]) this.data)[i];
        }
        return d / d2;
    }

    public double[] getAsDoubles() {
        return (double[]) this.data;
    }

    public float getAsFloat(int i) {
        switch (this.type) {
            case 1:
                return ((byte[]) this.data)[i] & UnsignedBytes.MAX_VALUE;
            case 2:
            case 7:
            default:
                throw new ClassCastException();
            case 3:
                return ((char[]) this.data)[i] & 65535;
            case 4:
                return ((long[]) this.data)[i];
            case 5:
                long[] asRational = getAsRational(i);
                return (float) (asRational[0] / asRational[1]);
            case 6:
                return ((byte[]) this.data)[i];
            case 8:
                return ((short[]) this.data)[i];
            case 9:
                return ((int[]) this.data)[i];
            case 10:
                int[] asSRational = getAsSRational(i);
                return (float) (((double) asSRational[0]) / ((double) asSRational[1]));
            case 11:
                return ((float[]) this.data)[i];
            case 12:
                return (float) ((double[]) this.data)[i];
        }
    }

    public float[] getAsFloats() {
        return (float[]) this.data;
    }

    public int getAsInt(int i) {
        int i2 = this.type;
        if (i2 != 1) {
            if (i2 == 3) {
                return ((char[]) this.data)[i] & 65535;
            }
            switch (i2) {
                case 6:
                    return ((byte[]) this.data)[i];
                case 7:
                    break;
                case 8:
                    return ((short[]) this.data)[i];
                case 9:
                    return ((int[]) this.data)[i];
                default:
                    throw new ClassCastException();
            }
        }
        return ((byte[]) this.data)[i] & UnsignedBytes.MAX_VALUE;
    }

    public int[] getAsInts() {
        return (int[]) this.data;
    }

    public long getAsLong(int i) {
        int i2;
        switch (this.type) {
            case 1:
            case 7:
                i2 = ((byte[]) this.data)[i] & UnsignedBytes.MAX_VALUE;
                break;
            case 2:
            case 5:
            default:
                throw new ClassCastException();
            case 3:
                i2 = ((char[]) this.data)[i] & 65535;
                break;
            case 4:
                return ((long[]) this.data)[i];
            case 6:
                i2 = ((byte[]) this.data)[i];
                break;
            case 8:
                i2 = ((short[]) this.data)[i];
                break;
            case 9:
                i2 = ((int[]) this.data)[i];
                break;
        }
        return i2;
    }

    public long[] getAsLongs() {
        return (long[]) this.data;
    }

    public long[] getAsRational(int i) {
        return this.type == 4 ? getAsLongs() : ((long[][]) this.data)[i];
    }

    public long[][] getAsRationals() {
        return (long[][]) this.data;
    }

    public int[] getAsSRational(int i) {
        return ((int[][]) this.data)[i];
    }

    public int[][] getAsSRationals() {
        return (int[][]) this.data;
    }

    public short[] getAsShorts() {
        return (short[]) this.data;
    }

    public String getAsString(int i) {
        return ((String[]) this.data)[i];
    }

    public int getCount() {
        return this.count;
    }

    public int getTag() {
        return this.tag;
    }

    public int getType() {
        return this.type;
    }

    public TIFFField(int i, int i2, int i3, Object obj) {
        this.tag = i;
        this.type = i2;
        this.count = i3;
        this.data = obj;
    }

    @Override // java.lang.Comparable
    public int compareTo(TIFFField tIFFField) {
        if (tIFFField == null) {
            throw new IllegalArgumentException();
        }
        int tag = tIFFField.getTag();
        int i = this.tag;
        if (i < tag) {
            return -1;
        }
        return i > tag ? 1 : 0;
    }
}
