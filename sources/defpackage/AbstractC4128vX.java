package defpackage;

import android.graphics.Matrix;

/* JADX INFO: renamed from: vX, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4128vX {
    public static Matrix a(float f, float f2, float f3, float f4, float f5, float f6) {
        Matrix matrix = new Matrix();
        c(matrix, f, f2, f3, f4, f5, f6);
        return matrix;
    }

    public static Matrix b(float[] fArr) {
        return a(fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5]);
    }

    public static void c(Matrix matrix, float f, float f2, float f3, float f4, float f5, float f6) {
        matrix.setValues(new float[]{f, f3, f5, f2, f4, f6, 0.0f, 0.0f, 1.0f});
    }

    public static void d(Matrix matrix, float[] fArr) {
        c(matrix, fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5]);
    }
}
