package defpackage;

import com.google.zxing.ResultPoint;

/* JADX INFO: renamed from: gj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C2303gj extends C2221fj {
    public final boolean c;

    public C2303gj(D8 d8, boolean z) {
        super(d8);
        this.c = z;
    }

    public void g(X6 x6) {
        C0928Tb[] c0928TbArrD = d();
        m();
        l(c0928TbArrD, x6);
        D8 d8A = a();
        ResultPoint resultPointH = this.c ? d8A.h() : d8A.i();
        ResultPoint resultPointB = this.c ? d8A.b() : d8A.c();
        int iE = e((int) resultPointH.getY());
        int iE2 = e((int) resultPointB.getY());
        int iC = -1;
        int i = 0;
        int iMax = 1;
        while (iE < iE2) {
            C0928Tb c0928Tb = c0928TbArrD[iE];
            if (c0928Tb != null) {
                int iC2 = c0928Tb.c() - iC;
                if (iC2 == 0) {
                    i++;
                } else {
                    if (iC2 == 1) {
                        iMax = Math.max(iMax, i);
                        iC = c0928Tb.c();
                    } else if (iC2 < 0 || c0928Tb.c() >= x6.c() || iC2 > iE) {
                        c0928TbArrD[iE] = null;
                    } else {
                        if (iMax > 2) {
                            iC2 *= iMax - 2;
                        }
                        boolean z = iC2 >= iE;
                        for (int i2 = 1; i2 <= iC2 && !z; i2++) {
                            z = c0928TbArrD[iE - i2] != null;
                        }
                        if (z) {
                            c0928TbArrD[iE] = null;
                        } else {
                            iC = c0928Tb.c();
                        }
                    }
                    i = 1;
                }
            }
            iE++;
        }
    }

    public final void h(X6 x6) {
        D8 d8A = a();
        ResultPoint resultPointH = this.c ? d8A.h() : d8A.i();
        ResultPoint resultPointB = this.c ? d8A.b() : d8A.c();
        int iE = e((int) resultPointB.getY());
        C0928Tb[] c0928TbArrD = d();
        int iC = -1;
        int i = 0;
        int iMax = 1;
        for (int iE2 = e((int) resultPointH.getY()); iE2 < iE; iE2++) {
            C0928Tb c0928Tb = c0928TbArrD[iE2];
            if (c0928Tb != null) {
                c0928Tb.j();
                int iC2 = c0928Tb.c() - iC;
                if (iC2 == 0) {
                    i++;
                } else {
                    if (iC2 == 1) {
                        iMax = Math.max(iMax, i);
                        iC = c0928Tb.c();
                    } else if (c0928Tb.c() >= x6.c()) {
                        c0928TbArrD[iE2] = null;
                    } else {
                        iC = c0928Tb.c();
                    }
                    i = 1;
                }
            }
        }
    }

    public X6 i() {
        C0928Tb[] c0928TbArrD = d();
        C1203a7 c1203a7 = new C1203a7();
        C1203a7 c1203a8 = new C1203a7();
        C1203a7 c1203a9 = new C1203a7();
        C1203a7 c1203a10 = new C1203a7();
        for (C0928Tb c0928Tb : c0928TbArrD) {
            if (c0928Tb != null) {
                c0928Tb.j();
                int iE = c0928Tb.e() % 30;
                int iC = c0928Tb.c();
                if (!this.c) {
                    iC += 2;
                }
                int i = iC % 3;
                if (i == 0) {
                    c1203a8.c((iE * 3) + 1);
                } else if (i == 1) {
                    c1203a10.c(iE / 3);
                    c1203a9.c(iE % 3);
                } else if (i == 2) {
                    c1203a7.c(iE + 1);
                }
            }
        }
        if (c1203a7.b().length == 0 || c1203a8.b().length == 0 || c1203a9.b().length == 0 || c1203a10.b().length == 0 || c1203a7.b()[0] <= 0 || c1203a8.b()[0] + c1203a9.b()[0] < 3 || c1203a8.b()[0] + c1203a9.b()[0] > 90) {
            return null;
        }
        X6 x6 = new X6(c1203a7.b()[0], c1203a8.b()[0], c1203a9.b()[0], c1203a10.b()[0]);
        l(c0928TbArrD, x6);
        return x6;
    }

    public int[] j() {
        int iC;
        X6 x6I = i();
        if (x6I == null) {
            return null;
        }
        h(x6I);
        int iC2 = x6I.c();
        int[] iArr = new int[iC2];
        for (C0928Tb c0928Tb : d()) {
            if (c0928Tb != null && (iC = c0928Tb.c()) < iC2) {
                iArr[iC] = iArr[iC] + 1;
            }
        }
        return iArr;
    }

    public boolean k() {
        return this.c;
    }

    public final void l(C0928Tb[] c0928TbArr, X6 x6) {
        for (int i = 0; i < c0928TbArr.length; i++) {
            C0928Tb c0928Tb = c0928TbArr[i];
            if (c0928Tb != null) {
                int iE = c0928Tb.e() % 30;
                int iC = c0928Tb.c();
                if (iC > x6.c()) {
                    c0928TbArr[i] = null;
                } else {
                    if (!this.c) {
                        iC += 2;
                    }
                    int i2 = iC % 3;
                    if (i2 != 0) {
                        if (i2 != 1) {
                            if (i2 == 2 && iE + 1 != x6.a()) {
                                c0928TbArr[i] = null;
                            }
                        } else if (iE / 3 != x6.b() || iE % 3 != x6.d()) {
                            c0928TbArr[i] = null;
                        }
                    } else if ((iE * 3) + 1 != x6.e()) {
                        c0928TbArr[i] = null;
                    }
                }
            }
        }
    }

    public final void m() {
        for (C0928Tb c0928Tb : d()) {
            if (c0928Tb != null) {
                c0928Tb.j();
            }
        }
    }

    @Override // defpackage.C2221fj
    public String toString() {
        return "IsLeft: " + this.c + '\n' + super.toString();
    }
}
