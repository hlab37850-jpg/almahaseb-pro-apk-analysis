package androidx.compose.ui.geometry;

/* JADX INFO: loaded from: classes.dex */
public final class GeometryUtilsKt {
    public static final String toStringAsFixed(float f, int i) {
        int iMax = Math.max(i, 0);
        float fPow = (float) Math.pow(10.0f, iMax);
        float f2 = f * fPow;
        int i2 = (int) f2;
        if (f2 - i2 >= 0.5f) {
            i2++;
        }
        float f3 = i2 / fPow;
        return iMax > 0 ? String.valueOf(f3) : String.valueOf((int) f3);
    }
}
