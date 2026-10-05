package androidx.compose.ui.graphics;

import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidMatrixConversions_androidKt {
    /* JADX INFO: renamed from: setFrom-EL8BTi8, reason: not valid java name */
    public static final void m2910setFromEL8BTi8(android.graphics.Matrix matrix, float[] fArr) {
        AbstractC4492zt.h(matrix, "$this$setFrom");
        AbstractC4492zt.h(fArr, "matrix");
        float f = fArr[2];
        if (f == 0.0f) {
            float f2 = fArr[6];
            if (f2 == 0.0f && fArr[10] == 1.0f && fArr[14] == 0.0f) {
                float f3 = fArr[8];
                if (f3 == 0.0f && fArr[9] == 0.0f && fArr[11] == 0.0f) {
                    float f4 = fArr[0];
                    float f5 = fArr[1];
                    float f6 = fArr[3];
                    float f7 = fArr[4];
                    float f8 = fArr[5];
                    float f9 = fArr[7];
                    float f10 = fArr[12];
                    float f11 = fArr[13];
                    float f12 = fArr[15];
                    fArr[0] = f4;
                    fArr[1] = f7;
                    fArr[2] = f10;
                    fArr[3] = f5;
                    fArr[4] = f8;
                    fArr[5] = f11;
                    fArr[6] = f6;
                    fArr[7] = f9;
                    fArr[8] = f12;
                    matrix.setValues(fArr);
                    fArr[0] = f4;
                    fArr[1] = f5;
                    fArr[2] = f;
                    fArr[3] = f6;
                    fArr[4] = f7;
                    fArr[5] = f8;
                    fArr[6] = f2;
                    fArr[7] = f9;
                    fArr[8] = f3;
                    return;
                }
            }
        }
        throw new IllegalArgumentException("Android does not support arbitrary transforms");
    }

    /* JADX INFO: renamed from: setFrom-tU-YjHk, reason: not valid java name */
    public static final void m2911setFromtUYjHk(float[] fArr, android.graphics.Matrix matrix) {
        AbstractC4492zt.h(fArr, "$this$setFrom");
        AbstractC4492zt.h(matrix, "matrix");
        matrix.getValues(fArr);
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = fArr[3];
        float f5 = fArr[4];
        float f6 = fArr[5];
        float f7 = fArr[6];
        float f8 = fArr[7];
        float f9 = fArr[8];
        fArr[0] = f;
        fArr[1] = f4;
        fArr[2] = 0.0f;
        fArr[3] = f7;
        fArr[4] = f2;
        fArr[5] = f5;
        fArr[6] = 0.0f;
        fArr[7] = f8;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 1.0f;
        fArr[11] = 0.0f;
        fArr[12] = f3;
        fArr[13] = f6;
        fArr[14] = 0.0f;
        fArr[15] = f9;
    }
}
