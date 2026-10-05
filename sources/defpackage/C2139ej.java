package defpackage;

import com.google.zxing.pdf417.PDF417Common;
import java.util.Formatter;

/* JADX INFO: renamed from: ej, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C2139ej {
    public final X6 a;
    public final C2221fj[] b;
    public D8 c;
    public final int d;

    public C2139ej(X6 x6, D8 d8) {
        this.a = x6;
        int iA = x6.a();
        this.d = iA;
        this.c = d8;
        this.b = new C2221fj[iA + 2];
    }

    public static boolean b(C0928Tb c0928Tb, C0928Tb c0928Tb2) {
        if (c0928Tb2 == null || !c0928Tb2.g() || c0928Tb2.a() != c0928Tb.a()) {
            return false;
        }
        c0928Tb.i(c0928Tb2.c());
        return true;
    }

    public static int c(int i, int i2, C0928Tb c0928Tb) {
        if (c0928Tb == null || c0928Tb.g()) {
            return i2;
        }
        if (!c0928Tb.h(i)) {
            return i2 + 1;
        }
        c0928Tb.i(i);
        return 0;
    }

    public final void a(C2221fj c2221fj) {
        if (c2221fj != null) {
            ((C2303gj) c2221fj).g(this.a);
        }
    }

    public final int d() {
        int iF = f();
        if (iF == 0) {
            return 0;
        }
        for (int i = 1; i < this.d + 1; i++) {
            C0928Tb[] c0928TbArrD = this.b[i].d();
            for (int i2 = 0; i2 < c0928TbArrD.length; i2++) {
                C0928Tb c0928Tb = c0928TbArrD[i2];
                if (c0928Tb != null && !c0928Tb.g()) {
                    e(i, i2, c0928TbArrD);
                }
            }
        }
        return iF;
    }

    public final void e(int i, int i2, C0928Tb[] c0928TbArr) {
        C0928Tb c0928Tb = c0928TbArr[i2];
        C0928Tb[] c0928TbArrD = this.b[i - 1].d();
        C2221fj c2221fj = this.b[i + 1];
        C0928Tb[] c0928TbArrD2 = c2221fj != null ? c2221fj.d() : c0928TbArrD;
        C0928Tb[] c0928TbArr2 = new C0928Tb[14];
        c0928TbArr2[2] = c0928TbArrD[i2];
        c0928TbArr2[3] = c0928TbArrD2[i2];
        if (i2 > 0) {
            int i3 = i2 - 1;
            c0928TbArr2[0] = c0928TbArr[i3];
            c0928TbArr2[4] = c0928TbArrD[i3];
            c0928TbArr2[5] = c0928TbArrD2[i3];
        }
        if (i2 > 1) {
            int i4 = i2 - 2;
            c0928TbArr2[8] = c0928TbArr[i4];
            c0928TbArr2[10] = c0928TbArrD[i4];
            c0928TbArr2[11] = c0928TbArrD2[i4];
        }
        if (i2 < c0928TbArr.length - 1) {
            int i5 = i2 + 1;
            c0928TbArr2[1] = c0928TbArr[i5];
            c0928TbArr2[6] = c0928TbArrD[i5];
            c0928TbArr2[7] = c0928TbArrD2[i5];
        }
        if (i2 < c0928TbArr.length - 2) {
            int i6 = i2 + 2;
            c0928TbArr2[9] = c0928TbArr[i6];
            c0928TbArr2[12] = c0928TbArrD[i6];
            c0928TbArr2[13] = c0928TbArrD2[i6];
        }
        for (int i7 = 0; i7 < 14 && !b(c0928Tb, c0928TbArr2[i7]); i7++) {
        }
    }

    public final int f() {
        g();
        return h() + i();
    }

    public final void g() {
        C2221fj[] c2221fjArr = this.b;
        C2221fj c2221fj = c2221fjArr[0];
        if (c2221fj == null || c2221fjArr[this.d + 1] == null) {
            return;
        }
        C0928Tb[] c0928TbArrD = c2221fj.d();
        C0928Tb[] c0928TbArrD2 = this.b[this.d + 1].d();
        for (int i = 0; i < c0928TbArrD.length; i++) {
            C0928Tb c0928Tb = c0928TbArrD[i];
            if (c0928Tb != null && c0928TbArrD2[i] != null && c0928Tb.c() == c0928TbArrD2[i].c()) {
                for (int i2 = 1; i2 <= this.d; i2++) {
                    C0928Tb c0928Tb2 = this.b[i2].d()[i];
                    if (c0928Tb2 != null) {
                        c0928Tb2.i(c0928TbArrD[i].c());
                        if (!c0928Tb2.g()) {
                            this.b[i2].d()[i] = null;
                        }
                    }
                }
            }
        }
    }

    public final int h() {
        C2221fj c2221fj = this.b[0];
        if (c2221fj == null) {
            return 0;
        }
        C0928Tb[] c0928TbArrD = c2221fj.d();
        int i = 0;
        for (int i2 = 0; i2 < c0928TbArrD.length; i2++) {
            C0928Tb c0928Tb = c0928TbArrD[i2];
            if (c0928Tb != null) {
                int iC = c0928Tb.c();
                int iC2 = 0;
                for (int i3 = 1; i3 < this.d + 1 && iC2 < 2; i3++) {
                    C0928Tb c0928Tb2 = this.b[i3].d()[i2];
                    if (c0928Tb2 != null) {
                        iC2 = c(iC, iC2, c0928Tb2);
                        if (!c0928Tb2.g()) {
                            i++;
                        }
                    }
                }
            }
        }
        return i;
    }

    public final int i() {
        C2221fj[] c2221fjArr = this.b;
        int i = this.d;
        if (c2221fjArr[i + 1] == null) {
            return 0;
        }
        C0928Tb[] c0928TbArrD = c2221fjArr[i + 1].d();
        int i2 = 0;
        for (int i3 = 0; i3 < c0928TbArrD.length; i3++) {
            C0928Tb c0928Tb = c0928TbArrD[i3];
            if (c0928Tb != null) {
                int iC = c0928Tb.c();
                int iC2 = 0;
                for (int i4 = this.d + 1; i4 > 0 && iC2 < 2; i4--) {
                    C0928Tb c0928Tb2 = this.b[i4].d()[i3];
                    if (c0928Tb2 != null) {
                        iC2 = c(iC, iC2, c0928Tb2);
                        if (!c0928Tb2.g()) {
                            i2++;
                        }
                    }
                }
            }
        }
        return i2;
    }

    public int j() {
        return this.d;
    }

    public int k() {
        return this.a.b();
    }

    public int l() {
        return this.a.c();
    }

    public D8 m() {
        return this.c;
    }

    public C2221fj n(int i) {
        return this.b[i];
    }

    public C2221fj[] o() {
        a(this.b[0]);
        a(this.b[this.d + 1]);
        int i = PDF417Common.MAX_CODEWORDS_IN_BARCODE;
        while (true) {
            int iD = d();
            if (iD <= 0 || iD >= i) {
                break;
            }
            i = iD;
        }
        return this.b;
    }

    public void p(D8 d8) {
        this.c = d8;
    }

    public void q(int i, C2221fj c2221fj) {
        this.b[i] = c2221fj;
    }

    public String toString() {
        C2221fj[] c2221fjArr = this.b;
        C2221fj c2221fj = c2221fjArr[0];
        if (c2221fj == null) {
            c2221fj = c2221fjArr[this.d + 1];
        }
        Formatter formatter = new Formatter();
        for (int i = 0; i < c2221fj.d().length; i++) {
            try {
                formatter.format("CW %3d:", Integer.valueOf(i));
                for (int i2 = 0; i2 < this.d + 2; i2++) {
                    C2221fj c2221fj2 = this.b[i2];
                    if (c2221fj2 == null) {
                        formatter.format("    |   ", new Object[0]);
                    } else {
                        C0928Tb c0928Tb = c2221fj2.d()[i];
                        if (c0928Tb == null) {
                            formatter.format("    |   ", new Object[0]);
                        } else {
                            formatter.format(" %3d|%3d", Integer.valueOf(c0928Tb.c()), Integer.valueOf(c0928Tb.e()));
                        }
                    }
                }
                formatter.format("%n", new Object[0]);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        formatter.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        }
        String string = formatter.toString();
        formatter.close();
        return string;
    }
}
