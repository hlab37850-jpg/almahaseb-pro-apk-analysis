package defpackage;

import java.lang.reflect.Array;

/* JADX INFO: renamed from: Up, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0972Up extends AbstractC4191wF {
    public int[] d;
    public int e;
    public int f;
    public float[] g;
    public float[] h;
    public int[][] i;

    public C0972Up() {
        super(0);
        this.f = 1;
    }

    public static float s(float f, float f2, float f3, float f4, float f5) {
        return (((f5 - f4) / (f3 - f2)) * (f - f2)) + f4;
    }

    public void A(int[][] iArr) {
        this.i = iArr;
    }

    public void B(int[] iArr) {
        this.d = iArr;
    }

    @Override // defpackage.AbstractC4191wF
    public void c(float[] fArr, int i, float[] fArr2, int i2) {
        float[] fArr3 = new float[f()];
        for (int i3 = 0; i3 < f(); i3++) {
            int i4 = i3 * 2;
            int i5 = i4 + 1;
            float fS = s(fArr[i3 + i], d(i4), d(i5), n(i4), n(i5));
            fArr3[i3] = fS;
            float fMax = Math.max(fS, 0.0f);
            fArr3[i3] = fMax;
            fArr3[i3] = Math.min(fMax, this.d[i3] - 1);
        }
        for (int i6 = 0; i6 < g(); i6++) {
            if (o() == 1) {
                fArr2[i6 + i2] = u(fArr3, i6);
            } else {
                fArr2[i6 + i2] = t(fArr3, i6);
            }
        }
        for (int i7 = 0; i7 < fArr2.length; i7++) {
            int i8 = i7 + i2;
            int i9 = i7 * 2;
            fArr2[i8] = s(fArr2[i8], 0.0f, ((float) Math.pow(2.0d, l())) - 1.0f, m(i9), m(i9 + 1));
        }
    }

    @Override // defpackage.AbstractC4191wF
    public void i(BF bf) throws EF {
        BF bfJ = bf.j("Size");
        if (bfJ == null) {
            throw new EF("Size required for function type 0!");
        }
        BF[] bfArrD = bfJ.d();
        int[] iArr = new int[bfArrD.length];
        for (int i = 0; i < bfArrD.length; i++) {
            iArr[i] = bfArrD[i].n();
        }
        B(iArr);
        BF bfJ2 = bf.j("BitsPerSample");
        if (bfJ2 == null) {
            throw new EF("BitsPerSample required for function type 0!");
        }
        w(bfJ2.n());
        BF bfJ3 = bf.j("Order");
        if (bfJ3 != null) {
            z(bfJ3.n());
        }
        BF bfJ4 = bf.j("Encode");
        if (bfJ4 != null) {
            BF[] bfArrD2 = bfJ4.d();
            float[] fArr = new float[bfArrD2.length];
            for (int i2 = 0; i2 < bfArrD2.length; i2++) {
                fArr[i2] = bfArrD2[i2].m();
            }
            y(fArr);
        }
        BF bfJ5 = bf.j("Decode");
        if (bfJ5 != null) {
            BF[] bfArrD3 = bfJ5.d();
            float[] fArr2 = new float[bfArrD3.length];
            for (int i3 = 0; i3 < bfArrD3.length; i3++) {
                fArr2[i3] = bfArrD3[i3].m();
            }
            x(fArr2);
        }
        A(v(bf.r()));
    }

    public int l() {
        return this.e;
    }

    public float m(int i) {
        float[] fArr = this.h;
        return fArr != null ? fArr[i] : h(i);
    }

    public float n(int i) {
        float[] fArr = this.g;
        if (fArr != null) {
            return fArr[i];
        }
        if (i % 2 == 0) {
            return 0.0f;
        }
        return r(i / 2) - 1;
    }

    public int o() {
        return this.f;
    }

    public final float p(float[] fArr, int i, int i2) {
        int length = fArr.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            if (((1 << i3) & i) == 0) {
                iArr[i3] = (int) Math.floor(fArr[i3]);
            } else {
                iArr[i3] = (int) Math.ceil(fArr[i3]);
            }
        }
        return q(iArr, i2);
    }

    public int q(int[] iArr, int i) {
        int iR = 1;
        int i2 = 0;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            i2 += iArr[i3] * iR;
            iR *= r(i3);
        }
        return this.i[i2][i];
    }

    public int r(int i) {
        return this.d[i];
    }

    public final float t(float[] fArr, int i) {
        System.out.println("Cubic interpolation not supported!");
        return u(fArr, i);
    }

    public final float u(float[] fArr, int i) {
        int length = fArr.length;
        float[] fArr2 = new float[length];
        for (int i2 = 0; i2 < length; i2++) {
            float f = fArr[i2];
            fArr2[i2] = (float) (((double) f) - Math.floor(f));
        }
        float fP = p(fArr, 0, i);
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            float f2 = -1.0f;
            int i5 = 0;
            for (int i6 = 0; i6 < length; i6++) {
                float f3 = fArr2[i6];
                if (f3 > f2) {
                    i5 = i6;
                    f2 = f3;
                }
            }
            i3 |= 1 << i5;
            fP += fArr2[i5] * (p(fArr, i3, i) - fP);
            fArr2[i5] = -1.0f;
        }
        return fP;
    }

    public final int[][] v(T8 t8) {
        int iR = 1;
        for (int i = 0; i < f(); i++) {
            iR *= r(i);
        }
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, iR, g());
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i4 < f()) {
            int i6 = i5;
            int i7 = i3;
            int i8 = i6;
            for (int i9 = 0; i9 < r(i4); i9++) {
                for (int i10 = 0; i10 < g(); i10++) {
                    byte bI = t8.i(i2);
                    int i11 = 0;
                    for (int iL = l(); iL > 0; iL--) {
                        i11 |= ((bI >> (7 - i8)) & 1) << (iL - 1);
                        i8++;
                        if (i8 == 8) {
                            i2++;
                            if (iL > 1) {
                                bI = t8.i(i2);
                            }
                            i8 = 0;
                        }
                    }
                    iArr[i7][i10] = i11;
                }
                i7++;
            }
            i4++;
            int i12 = i7;
            i5 = i8;
            i3 = i12;
        }
        return iArr;
    }

    public void w(int i) {
        this.e = i;
    }

    public void x(float[] fArr) {
        this.h = fArr;
    }

    public void y(float[] fArr) {
        this.g = fArr;
    }

    public void z(int i) {
        this.f = i;
    }
}
