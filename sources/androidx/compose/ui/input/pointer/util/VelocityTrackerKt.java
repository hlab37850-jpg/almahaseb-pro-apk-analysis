package androidx.compose.ui.input.pointer.util;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.HistoricalChange;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.core.app.NotificationCompat;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class VelocityTrackerKt {
    private static final int AssumePointerMoveStoppedMilliseconds = 40;
    private static final float DefaultWeight = 1.0f;
    private static final int HistorySize = 20;
    private static final int HorizonMilliseconds = 100;

    private static final float[][] Matrix(int i, int i2) {
        float[][] fArr = new float[i][];
        for (int i3 = 0; i3 < i; i3++) {
            fArr[i3] = new float[i2];
        }
        return fArr;
    }

    public static final void addPointerInputChange(VelocityTracker velocityTracker, PointerInputChange pointerInputChange) {
        AbstractC4492zt.h(velocityTracker, "<this>");
        AbstractC4492zt.h(pointerInputChange, NotificationCompat.CATEGORY_EVENT);
        if (PointerEventKt.changedToDownIgnoreConsumed(pointerInputChange)) {
            velocityTracker.m4135setCurrentPointerPositionAccumulatork4lQ0M$ui_release(pointerInputChange.m4054getPositionF1C5BW0());
            velocityTracker.resetTracking();
        }
        long jM4055getPreviousPositionF1C5BW0 = pointerInputChange.m4055getPreviousPositionF1C5BW0();
        List<HistoricalChange> historical = pointerInputChange.getHistorical();
        int size = historical.size();
        int i = 0;
        while (i < size) {
            HistoricalChange historicalChange = historical.get(i);
            long jM2802minusMKHz9U = Offset.m2802minusMKHz9U(historicalChange.m3981getPositionF1C5BW0(), jM4055getPreviousPositionF1C5BW0);
            long jM3981getPositionF1C5BW0 = historicalChange.m3981getPositionF1C5BW0();
            velocityTracker.m4135setCurrentPointerPositionAccumulatork4lQ0M$ui_release(Offset.m2803plusMKHz9U(velocityTracker.m4134getCurrentPointerPositionAccumulatorF1C5BW0$ui_release(), jM2802minusMKHz9U));
            velocityTracker.m4132addPositionUv8p0NA(historicalChange.getUptimeMillis(), velocityTracker.m4134getCurrentPointerPositionAccumulatorF1C5BW0$ui_release());
            i++;
            jM4055getPreviousPositionF1C5BW0 = jM3981getPositionF1C5BW0;
        }
        velocityTracker.m4135setCurrentPointerPositionAccumulatork4lQ0M$ui_release(Offset.m2803plusMKHz9U(velocityTracker.m4134getCurrentPointerPositionAccumulatorF1C5BW0$ui_release(), Offset.m2802minusMKHz9U(pointerInputChange.m4054getPositionF1C5BW0(), jM4055getPreviousPositionF1C5BW0)));
        velocityTracker.m4132addPositionUv8p0NA(pointerInputChange.getUptimeMillis(), velocityTracker.m4134getCurrentPointerPositionAccumulatorF1C5BW0$ui_release());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calculateImpulseVelocity(float[] fArr, float[] fArr2, int i, boolean z) {
        float fAbs = 0.0f;
        if (i < 2) {
            return 0.0f;
        }
        if (i == 2) {
            float f = fArr2[0];
            float f2 = fArr2[1];
            if (f == f2) {
                return 0.0f;
            }
            return (z ? fArr[0] : fArr[0] - fArr[1]) / (f - f2);
        }
        int i2 = i - 1;
        for (int i3 = i2; i3 > 0; i3--) {
            int i4 = i3 - 1;
            if (fArr2[i3] != fArr2[i4]) {
                float fSignum = Math.signum(fAbs) * ((float) Math.sqrt(2 * Math.abs(fAbs)));
                float f3 = (z ? -fArr[i4] : fArr[i3] - fArr[i4]) / (fArr2[i3] - fArr2[i4]);
                fAbs += (f3 - fSignum) * Math.abs(f3);
                if (i3 == i2) {
                    fAbs *= 0.5f;
                }
            }
        }
        return Math.signum(fAbs) * ((float) Math.sqrt(2 * Math.abs(fAbs)));
    }

    private static final float dot(float[] fArr, float[] fArr2) {
        int length = fArr.length;
        float f = 0.0f;
        for (int i = 0; i < length; i++) {
            f += fArr[i] * fArr2[i];
        }
        return f;
    }

    private static final float get(float[][] fArr, int i, int i2) {
        AbstractC4492zt.h(fArr, "<this>");
        return fArr[i][i2];
    }

    private static final float kineticEnergyToVelocity(float f) {
        return Math.signum(f) * ((float) Math.sqrt(2 * Math.abs(f)));
    }

    private static final float norm(float[] fArr) {
        return (float) Math.sqrt(dot(fArr, fArr));
    }

    public static final float[] polyFitLeastSquares(float[] fArr, float[] fArr2, int i, int i2, float[] fArr3) {
        int i3 = i2;
        AbstractC4492zt.h(fArr, "x");
        AbstractC4492zt.h(fArr2, "y");
        AbstractC4492zt.h(fArr3, "coefficients");
        if (i3 < 1) {
            throw new IllegalArgumentException("The degree must be at positive integer");
        }
        if (i == 0) {
            throw new IllegalArgumentException("At least one point must be provided");
        }
        if (i3 >= i) {
            i3 = i - 1;
        }
        int i4 = i3 + 1;
        float[][] fArr4 = new float[i4][];
        for (int i5 = 0; i5 < i4; i5++) {
            fArr4[i5] = new float[i];
        }
        for (int i6 = 0; i6 < i; i6++) {
            fArr4[0][i6] = 1.0f;
            for (int i7 = 1; i7 < i4; i7++) {
                fArr4[i7][i6] = fArr4[i7 - 1][i6] * fArr[i6];
            }
        }
        float[][] fArr5 = new float[i4][];
        for (int i8 = 0; i8 < i4; i8++) {
            fArr5[i8] = new float[i];
        }
        float[][] fArr6 = new float[i4][];
        for (int i9 = 0; i9 < i4; i9++) {
            fArr6[i9] = new float[i4];
        }
        int i10 = 0;
        while (i10 < i4) {
            float[] fArr7 = fArr5[i10];
            float[] fArr8 = fArr4[i10];
            for (int i11 = 0; i11 < i; i11++) {
                fArr7[i11] = fArr8[i11];
            }
            for (int i12 = 0; i12 < i10; i12++) {
                float[] fArr9 = fArr5[i12];
                float fDot = dot(fArr7, fArr9);
                for (int i13 = 0; i13 < i; i13++) {
                    fArr7[i13] = fArr7[i13] - (fArr9[i13] * fDot);
                }
            }
            float fSqrt = (float) Math.sqrt(dot(fArr7, fArr7));
            if (fSqrt < 1.0E-6f) {
                throw new IllegalArgumentException("Vectors are linearly dependent or zero so no solution. TODO(shepshapard), actually determine what this means");
            }
            float f = 1.0f / fSqrt;
            for (int i14 = 0; i14 < i; i14++) {
                fArr7[i14] = fArr7[i14] * f;
            }
            float[] fArr10 = fArr6[i10];
            int i15 = 0;
            while (i15 < i4) {
                fArr10[i15] = i15 < i10 ? 0.0f : dot(fArr7, fArr4[i15]);
                i15++;
            }
            i10++;
        }
        for (int i16 = i3; -1 < i16; i16--) {
            fArr3[i16] = dot(fArr5[i16], fArr2);
            int i17 = i16 + 1;
            if (i17 <= i3) {
                int i18 = i3;
                while (true) {
                    fArr3[i16] = fArr3[i16] - (fArr6[i16][i18] * fArr3[i18]);
                    if (i18 != i17) {
                        i18--;
                    }
                }
            }
            fArr3[i16] = fArr3[i16] / fArr6[i16][i16];
        }
        return fArr3;
    }

    public static /* synthetic */ float[] polyFitLeastSquares$default(float[] fArr, float[] fArr2, int i, int i2, float[] fArr3, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            fArr3 = new float[AbstractC3871sJ.d(i2 + 1, 0)];
        }
        return polyFitLeastSquares(fArr, fArr2, i, i2, fArr3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void set(DataPointAtTime[] dataPointAtTimeArr, int i, long j, float f) {
        DataPointAtTime dataPointAtTime = dataPointAtTimeArr[i];
        if (dataPointAtTime == null) {
            dataPointAtTimeArr[i] = new DataPointAtTime(j, f);
        } else {
            dataPointAtTime.setTime(j);
            dataPointAtTime.setDataPoint(f);
        }
    }

    private static final void set(float[][] fArr, int i, int i2, float f) {
        AbstractC4492zt.h(fArr, "<this>");
        fArr[i][i2] = f;
    }
}
