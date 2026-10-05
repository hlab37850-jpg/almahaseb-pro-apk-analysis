package defpackage;

/* JADX INFO: renamed from: Vd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0986Vd extends AbstractC0956Ud {
    public static float g(float f, float... fArr) {
        AbstractC4492zt.h(fArr, "other");
        for (float f2 : fArr) {
            f = Math.max(f, f2);
        }
        return f;
    }

    public static int h(int i, int... iArr) {
        AbstractC4492zt.h(iArr, "other");
        for (int i2 : iArr) {
            i = Math.max(i, i2);
        }
        return i;
    }

    public static float i(float f, float... fArr) {
        AbstractC4492zt.h(fArr, "other");
        for (float f2 : fArr) {
            f = Math.min(f, f2);
        }
        return f;
    }
}
