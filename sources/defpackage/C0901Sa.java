package defpackage;

import android.graphics.Rect;
import android.util.Log;

/* JADX INFO: renamed from: Sa, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0901Sa extends NH {
    public static final String b = "Sa";

    @Override // defpackage.NH
    public float c(NQ nq, NQ nq2) {
        if (nq.a <= 0 || nq.b <= 0) {
            return 0.0f;
        }
        NQ nqC = nq.c(nq2);
        float fPow = (nqC.a * 1.0f) / nq.a;
        if (fPow > 1.0f) {
            fPow = (float) Math.pow(1.0f / fPow, 1.1d);
        }
        float f = ((nqC.a * 1.0f) / nq2.a) + ((nqC.b * 1.0f) / nq2.b);
        return fPow * ((1.0f / f) / f);
    }

    @Override // defpackage.NH
    public Rect d(NQ nq, NQ nq2) {
        NQ nqC = nq.c(nq2);
        Log.i(b, "Preview: " + nq + "; Scaled: " + nqC + "; Want: " + nq2);
        int i = (nqC.a - nq2.a) / 2;
        int i2 = (nqC.b - nq2.b) / 2;
        return new Rect(-i, -i2, nqC.a - i, nqC.b - i2);
    }
}
