package defpackage;

import android.graphics.Rect;
import android.util.Log;

/* JADX INFO: renamed from: Hm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0575Hm extends NH {
    public static final String b = "Hm";

    @Override // defpackage.NH
    public float c(NQ nq, NQ nq2) {
        if (nq.a <= 0 || nq.b <= 0) {
            return 0.0f;
        }
        NQ nqD = nq.d(nq2);
        float fPow = (nqD.a * 1.0f) / nq.a;
        if (fPow > 1.0f) {
            fPow = (float) Math.pow(1.0f / fPow, 1.1d);
        }
        float f = ((nq2.a * 1.0f) / nqD.a) * ((nq2.b * 1.0f) / nqD.b);
        return fPow * (((1.0f / f) / f) / f);
    }

    @Override // defpackage.NH
    public Rect d(NQ nq, NQ nq2) {
        NQ nqD = nq.d(nq2);
        Log.i(b, "Preview: " + nq + "; Scaled: " + nqD + "; Want: " + nq2);
        int i = (nqD.a - nq2.a) / 2;
        int i2 = (nqD.b - nq2.b) / 2;
        return new Rect(-i, -i2, nqD.a - i, nqD.b - i2);
    }
}
