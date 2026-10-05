package defpackage;

import android.graphics.Path;
import android.graphics.PointF;

/* JADX INFO: renamed from: aF, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1214aF extends AbstractC3948tF {
    public int g;
    public int h;
    public float[] i;

    public AbstractC1214aF(String str, BF bf, C4029uF c4029uF) {
        super(str, c4029uF);
        this.g = -1;
        this.h = -1;
        BF bfJ = bf.j("FirstChar");
        BF bfJ2 = bf.j("LastChar");
        BF bfJ3 = bf.j("Widths");
        if (bfJ != null) {
            this.g = bfJ.n();
        }
        if (bfJ2 != null) {
            this.h = bfJ2.n();
        }
        if (bfJ3 != null) {
            BF[] bfArrD = bfJ3.d();
            this.i = new float[bfArrD.length];
            for (int i = 0; i < bfArrD.length; i++) {
                this.i[i] = bfArrD[i].m() / k();
            }
        }
    }

    @Override // defpackage.AbstractC3948tF
    public C4272xF e(char c, String str) {
        float fP = p(c, str);
        Path pathO = str != null ? o(str, fP) : null;
        if (pathO == null) {
            pathO = n(c, fP);
        }
        return new C4272xF(c, str, pathO, new PointF(fP, 0.0f));
    }

    public int k() {
        return 1000;
    }

    public int l() {
        return this.g;
    }

    public int m() {
        return this.h;
    }

    public abstract Path n(char c, float f);

    public abstract Path o(String str, float f);

    public float p(char c, String str) {
        float[] fArr;
        int iL = (c & 255) - l();
        if (iL >= 0 && (fArr = this.i) != null && iL < fArr.length) {
            return fArr[iL];
        }
        if (c() != null) {
            return c().g();
        }
        return 0.0f;
    }
}
