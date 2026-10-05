package com.itextpdf.text.pdf.parser;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class Vector {
    public static final int I1 = 0;
    public static final int I2 = 1;
    public static final int I3 = 2;
    private final float[] vals;

    public Vector(float f, float f2, float f3) {
        float[] fArr = {0.0f, 0.0f, 0.0f};
        this.vals = fArr;
        fArr[0] = f;
        fArr[1] = f2;
        fArr[2] = f3;
    }

    public Vector cross(Matrix matrix) {
        return new Vector((this.vals[0] * matrix.get(0)) + (this.vals[1] * matrix.get(3)) + (this.vals[2] * matrix.get(6)), (this.vals[0] * matrix.get(1)) + (this.vals[1] * matrix.get(4)) + (this.vals[2] * matrix.get(7)), (this.vals[0] * matrix.get(2)) + (this.vals[1] * matrix.get(5)) + (this.vals[2] * matrix.get(8)));
    }

    public float dot(Vector vector) {
        float[] fArr = this.vals;
        float f = fArr[0];
        float[] fArr2 = vector.vals;
        return (f * fArr2[0]) + (fArr[1] * fArr2[1]) + (fArr[2] * fArr2[2]);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && Arrays.equals(this.vals, ((Vector) obj).vals);
    }

    public float get(int i) {
        return this.vals[i];
    }

    public int hashCode() {
        return 31 + Arrays.hashCode(this.vals);
    }

    public float length() {
        return (float) Math.sqrt(lengthSquared());
    }

    public float lengthSquared() {
        float[] fArr = this.vals;
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        return (f * f) + (f2 * f2) + (f3 * f3);
    }

    public Vector multiply(float f) {
        float[] fArr = this.vals;
        return new Vector(fArr[0] * f, fArr[1] * f, fArr[2] * f);
    }

    public Vector normalize() {
        float length = length();
        float[] fArr = this.vals;
        return new Vector(fArr[0] / length, fArr[1] / length, fArr[2] / length);
    }

    public Vector subtract(Vector vector) {
        float[] fArr = this.vals;
        float f = fArr[0];
        float[] fArr2 = vector.vals;
        return new Vector(f - fArr2[0], fArr[1] - fArr2[1], fArr[2] - fArr2[2]);
    }

    public String toString() {
        return this.vals[0] + "," + this.vals[1] + "," + this.vals[2];
    }

    public Vector cross(Vector vector) {
        float[] fArr = this.vals;
        float f = fArr[1];
        float[] fArr2 = vector.vals;
        float f2 = fArr2[2];
        float f3 = fArr[2];
        float f4 = fArr2[1];
        float f5 = fArr2[0];
        float f6 = fArr[0];
        return new Vector((f * f2) - (f3 * f4), (f3 * f5) - (f2 * f6), (f6 * f4) - (f * f5));
    }
}
