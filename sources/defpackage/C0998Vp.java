package defpackage;

/* JADX INFO: renamed from: Vp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0998Vp extends AbstractC4191wF {
    public float[] d;
    public float[] e;
    public float f;

    public C0998Vp() {
        super(2);
        this.d = new float[]{0.0f};
        this.e = new float[]{1.0f};
    }

    @Override // defpackage.AbstractC4191wF
    public void c(float[] fArr, int i, float[] fArr2, int i2) {
        float f = fArr[i];
        for (int i3 = 0; i3 < g(); i3++) {
            fArr2[i3 + i2] = l(i3) + ((float) (Math.pow(f, n()) * ((double) (m(i3) - l(i3)))));
        }
    }

    @Override // defpackage.AbstractC4191wF
    public void i(BF bf) throws EF {
        BF bfJ = bf.j("N");
        if (bfJ == null) {
            throw new EF("Exponent required for function type 2!");
        }
        q(bfJ.m());
        BF bfJ2 = bf.j("C0");
        if (bfJ2 != null) {
            BF[] bfArrD = bfJ2.d();
            float[] fArr = new float[bfArrD.length];
            for (int i = 0; i < bfArrD.length; i++) {
                fArr[i] = bfArrD[i].m();
            }
            o(fArr);
        }
        BF bfJ3 = bf.j("C1");
        if (bfJ3 != null) {
            BF[] bfArrD2 = bfJ3.d();
            float[] fArr2 = new float[bfArrD2.length];
            for (int i2 = 0; i2 < bfArrD2.length; i2++) {
                fArr2[i2] = bfArrD2[i2].m();
            }
            p(fArr2);
        }
    }

    public float l(int i) {
        return this.d[i];
    }

    public float m(int i) {
        return this.e[i];
    }

    public float n() {
        return this.f;
    }

    public void o(float[] fArr) {
        this.d = fArr;
    }

    public void p(float[] fArr) {
        this.e = fArr;
    }

    public void q(float f) {
        this.f = f;
    }
}
