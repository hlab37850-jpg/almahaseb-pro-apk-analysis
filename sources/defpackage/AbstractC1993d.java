package defpackage;

/* JADX INFO: renamed from: d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1993d {
    public static final int a(int[] iArr, int i, int i2, int i3) {
        AbstractC4492zt.h(iArr, "<this>");
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i) {
                i2 = i5 + 1;
            } else {
                if (i6 <= i) {
                    return i5;
                }
                i4 = i5 - 1;
            }
        }
        return (-i2) - 1;
    }

    public static final int b(C3470nO c3470nO, int i) {
        AbstractC4492zt.h(c3470nO, "<this>");
        int iA = a(c3470nO.A(), i + 1, 0, c3470nO.B().length);
        return iA >= 0 ? iA : ~iA;
    }
}
