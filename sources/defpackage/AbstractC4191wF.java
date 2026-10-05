package defpackage;

import com.google.common.net.HttpHeaders;

/* JADX INFO: renamed from: wF, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4191wF {
    public int a;
    public float[] b;
    public float[] c;

    public AbstractC4191wF(int i) {
        this.a = i;
    }

    public static AbstractC4191wF e(BF bf) throws EF {
        float[] fArr;
        AbstractC4191wF c0972Up;
        BF bfJ = bf.j("FunctionType");
        if (bfJ == null) {
            throw new EF("No FunctionType specified in function!");
        }
        int iN = bfJ.n();
        BF bfJ2 = bf.j("Domain");
        if (bfJ2 == null) {
            throw new EF("No Domain specified in function!");
        }
        BF[] bfArrD = bfJ2.d();
        float[] fArr2 = new float[bfArrD.length];
        for (int i = 0; i < bfArrD.length; i++) {
            fArr2[i] = bfArrD[i].m();
        }
        BF bfJ3 = bf.j(HttpHeaders.RANGE);
        if (bfJ3 != null) {
            BF[] bfArrD2 = bfJ3.d();
            fArr = new float[bfArrD2.length];
            for (int i2 = 0; i2 < bfArrD2.length; i2++) {
                fArr[i2] = bfArrD2[i2].m();
            }
        } else {
            fArr = null;
        }
        if (iN == 0) {
            if (bfJ3 == null) {
                throw new EF("No Range specified in Type 0 Function!");
            }
            c0972Up = new C0972Up();
        } else if (iN == 2) {
            c0972Up = new C0998Vp();
        } else if (iN == 3) {
            c0972Up = new C1024Wp();
        } else {
            if (iN != 4) {
                throw new EF("Unsupported function type: " + iN);
            }
            if (bfJ3 == null) {
                throw new EF("No Range specified in Type 4 Function!");
            }
            c0972Up = new C1050Xp();
        }
        c0972Up.j(fArr2);
        if (fArr != null) {
            c0972Up.k(fArr);
        }
        c0972Up.i(bf);
        return c0972Up;
    }

    public float[] a(float[] fArr) {
        float[] fArr2 = new float[g()];
        b(fArr, 0, fArr2, 0);
        return fArr2;
    }

    public float[] b(float[] fArr, int i, float[] fArr2, int i2) {
        if (fArr.length - i < f()) {
            throw new IllegalArgumentException("Wrong number of inputs to function!");
        }
        if (this.c != null && fArr2.length - i2 < g()) {
            throw new IllegalArgumentException("Wrong number of outputs for function!");
        }
        for (int i3 = 0; i3 < fArr.length; i3++) {
            int i4 = i3 * 2;
            float fMax = Math.max(fArr[i3], d(i4));
            fArr[i3] = fMax;
            fArr[i3] = Math.min(fMax, d(i4 + 1));
        }
        c(fArr, i, fArr2, i2);
        for (int i5 = 0; this.c != null && i5 < fArr2.length; i5++) {
            int i6 = i5 * 2;
            float fMax2 = Math.max(fArr2[i5], h(i6));
            fArr2[i5] = fMax2;
            fArr2[i5] = Math.min(fMax2, h(i6 + 1));
        }
        return fArr2;
    }

    public abstract void c(float[] fArr, int i, float[] fArr2, int i2);

    public float d(int i) {
        return this.b[i];
    }

    public int f() {
        return this.b.length / 2;
    }

    public int g() {
        float[] fArr = this.c;
        if (fArr == null) {
            return 0;
        }
        return fArr.length / 2;
    }

    public float h(int i) {
        float[] fArr = this.c;
        if (fArr == null) {
            return i % 2 == 0 ? Float.MIN_VALUE : Float.MAX_VALUE;
        }
        return fArr[i];
    }

    public abstract void i(BF bf);

    public void j(float[] fArr) {
        this.b = fArr;
    }

    public void k(float[] fArr) {
        this.c = fArr;
    }
}
