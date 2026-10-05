package defpackage;

import android.graphics.Rect;

/* JADX INFO: renamed from: Im, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0601Im extends NH {
    public static float e(float f) {
        return f < 1.0f ? 1.0f / f : f;
    }

    @Override // defpackage.NH
    public float c(NQ nq, NQ nq2) {
        int i = nq.a;
        if (i <= 0 || nq.b <= 0) {
            return 0.0f;
        }
        float fE = (1.0f / e((i * 1.0f) / nq2.a)) / e((nq.b * 1.0f) / nq2.b);
        float fE2 = e(((nq.a * 1.0f) / nq.b) / ((nq2.a * 1.0f) / nq2.b));
        return fE * (((1.0f / fE2) / fE2) / fE2);
    }

    @Override // defpackage.NH
    public Rect d(NQ nq, NQ nq2) {
        return new Rect(0, 0, nq2.a, nq2.b);
    }
}
