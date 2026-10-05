package com.itextpdf.text.pdf.parser;

import com.zebra.sdk.util.internal.StringUtilities;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class Matrix {
    public static final int I11 = 0;
    public static final int I12 = 1;
    public static final int I13 = 2;
    public static final int I21 = 3;
    public static final int I22 = 4;
    public static final int I23 = 5;
    public static final int I31 = 6;
    public static final int I32 = 7;
    public static final int I33 = 8;
    private final float[] vals;

    public Matrix() {
        this.vals = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    }

    public boolean equals(Object obj) {
        if (obj instanceof Matrix) {
            return Arrays.equals(this.vals, ((Matrix) obj).vals);
        }
        return false;
    }

    public float get(int i) {
        return this.vals[i];
    }

    public float getDeterminant() {
        float[] fArr = this.vals;
        float f = fArr[0];
        float f2 = fArr[4];
        float f3 = fArr[8];
        float f4 = fArr[1];
        float f5 = fArr[5];
        float f6 = fArr[6];
        float f7 = (f * f2 * f3) + (f4 * f5 * f6);
        float f8 = fArr[2];
        float f9 = fArr[3];
        float f10 = fArr[7];
        return (((f7 + ((f8 * f9) * f10)) - ((f * f5) * f10)) - ((f4 * f9) * f3)) - ((f8 * f2) * f6);
    }

    public int hashCode() {
        int iFloatToIntBits = 1;
        int i = 0;
        while (true) {
            float[] fArr = this.vals;
            if (i >= fArr.length) {
                return iFloatToIntBits;
            }
            iFloatToIntBits = (iFloatToIntBits * 31) + Float.floatToIntBits(fArr[i]);
            i++;
        }
    }

    public Matrix multiply(Matrix matrix) {
        Matrix matrix2 = new Matrix();
        float[] fArr = this.vals;
        float[] fArr2 = matrix.vals;
        float[] fArr3 = matrix2.vals;
        float f = fArr[0] * fArr2[0];
        float f2 = fArr[1];
        float f3 = fArr2[3];
        float f4 = fArr[2];
        float f5 = fArr2[6];
        fArr3[0] = f + (f2 * f3) + (f4 * f5);
        float f6 = fArr[0];
        float f7 = fArr2[1] * f6;
        float f8 = fArr2[4];
        float f9 = fArr2[7];
        fArr3[1] = f7 + (f2 * f8) + (f4 * f9);
        float f10 = f6 * fArr2[2];
        float f11 = fArr[1];
        float f12 = fArr2[5];
        float f13 = fArr2[8];
        fArr3[2] = f10 + (f11 * f12) + (f4 * f13);
        float f14 = fArr[3];
        float f15 = fArr2[0];
        float f16 = fArr[4];
        float f17 = (f14 * f15) + (f3 * f16);
        float f18 = fArr[5];
        fArr3[3] = f17 + (f18 * f5);
        float f19 = fArr[3];
        float f20 = fArr2[1];
        fArr3[4] = (f19 * f20) + (f16 * f8) + (f18 * f9);
        float f21 = fArr2[2];
        fArr3[5] = (f19 * f21) + (fArr[4] * f12) + (f18 * f13);
        float f22 = fArr[6] * f15;
        float f23 = fArr[7];
        float f24 = f22 + (fArr2[3] * f23);
        float f25 = fArr[8];
        fArr3[6] = f24 + (f5 * f25);
        float f26 = fArr[6];
        fArr3[7] = (f20 * f26) + (f23 * fArr2[4]) + (f9 * f25);
        fArr3[8] = (f26 * f21) + (fArr[7] * fArr2[5]) + (f25 * f13);
        return matrix2;
    }

    public Matrix subtract(Matrix matrix) {
        Matrix matrix2 = new Matrix();
        float[] fArr = this.vals;
        float[] fArr2 = matrix.vals;
        float[] fArr3 = matrix2.vals;
        fArr3[0] = fArr[0] - fArr2[0];
        fArr3[1] = fArr[1] - fArr2[1];
        fArr3[2] = fArr[2] - fArr2[2];
        fArr3[3] = fArr[3] - fArr2[3];
        fArr3[4] = fArr[4] - fArr2[4];
        fArr3[5] = fArr[5] - fArr2[5];
        fArr3[6] = fArr[6] - fArr2[6];
        fArr3[7] = fArr[7] - fArr2[7];
        fArr3[8] = fArr[8] - fArr2[8];
        return matrix2;
    }

    public String toString() {
        return this.vals[0] + "\t" + this.vals[1] + "\t" + this.vals[2] + StringUtilities.LF + this.vals[3] + "\t" + this.vals[4] + "\t" + this.vals[2] + StringUtilities.LF + this.vals[6] + "\t" + this.vals[7] + "\t" + this.vals[8];
    }

    public Matrix(float f, float f2) {
        float[] fArr = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        this.vals = fArr;
        fArr[6] = f;
        fArr[7] = f2;
    }

    public Matrix(float f, float f2, float f3, float f4, float f5, float f6) {
        float[] fArr = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        this.vals = fArr;
        fArr[0] = f;
        fArr[1] = f2;
        fArr[2] = 0.0f;
        fArr[3] = f3;
        fArr[4] = f4;
        fArr[5] = 0.0f;
        fArr[6] = f5;
        fArr[7] = f6;
        fArr[8] = 1.0f;
    }
}
