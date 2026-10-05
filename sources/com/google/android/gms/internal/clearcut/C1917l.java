package com.google.android.gms.internal.clearcut;

import com.itextpdf.xmp.options.PropertyOptions;
import defpackage.AbstractC3574of;
import defpackage.AbstractC4343y70;
import defpackage.Bb0;
import defpackage.Da0;
import defpackage.E60;
import defpackage.H70;
import defpackage.I90;
import defpackage.InterfaceC3155ja0;
import defpackage.InterfaceC3812rc0;
import defpackage.Ma0;
import defpackage.Na0;
import defpackage.P90;
import defpackage.S50;
import defpackage.Sb0;
import defpackage.Ta0;
import defpackage.X80;
import defpackage.Xb0;
import defpackage.Ya0;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: renamed from: com.google.android.gms.internal.clearcut.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1917l implements Ta0 {
    public static final Unsafe s = Sb0.z();
    public final int[] a;
    public final Object[] b;
    public final int c;
    public final int d;
    public final int e;
    public final zzdo f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final int[] k;
    public final int[] l;
    public final int[] m;
    public final InterfaceC3155ja0 n;
    public final X80 o;
    public final Bb0 p;
    public final AbstractC4343y70 q;
    public final I90 r;

    public C1917l(int[] iArr, Object[] objArr, int i, int i2, int i3, zzdo zzdoVar, boolean z, boolean z2, int[] iArr2, int[] iArr3, int[] iArr4, InterfaceC3155ja0 interfaceC3155ja0, X80 x80, Bb0 bb0, AbstractC4343y70 abstractC4343y70, I90 i90) {
        this.a = iArr;
        this.b = objArr;
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.h = zzdoVar instanceof zzcg;
        this.i = z;
        this.g = abstractC4343y70 != null && abstractC4343y70.g(zzdoVar);
        this.j = false;
        this.k = iArr2;
        this.l = iArr3;
        this.m = iArr4;
        this.n = interfaceC3155ja0;
        this.o = x80;
        this.p = bb0;
        this.q = abstractC4343y70;
        this.f = zzdoVar;
        this.r = i90;
    }

    public static boolean B(Object obj, int i, Ta0 ta0) {
        return ta0.h(Sb0.M(obj, i & 1048575));
    }

    public static List N(Object obj, long j) {
        return (List) Sb0.M(obj, j);
    }

    public static double O(Object obj, long j) {
        return ((Double) Sb0.M(obj, j)).doubleValue();
    }

    public static float P(Object obj, long j) {
        return ((Float) Sb0.M(obj, j)).floatValue();
    }

    public static int Q(Object obj, long j) {
        return ((Integer) Sb0.M(obj, j)).intValue();
    }

    public static long R(Object obj, long j) {
        return ((Long) Sb0.M(obj, j)).longValue();
    }

    public static boolean S(Object obj, long j) {
        return ((Boolean) Sb0.M(obj, j)).booleanValue();
    }

    public static zzey T(Object obj) {
        zzcg zzcgVar = (zzcg) obj;
        zzey zzeyVar = zzcgVar.zzjp;
        if (zzeyVar != zzey.zzea()) {
            return zzeyVar;
        }
        zzey zzeyVarZzeb = zzey.zzeb();
        zzcgVar.zzjp = zzeyVarZzeb;
        return zzeyVarZzeb;
    }

    public static int j(int i, byte[] bArr, int i2, int i3, Object obj, S50 s50) {
        return AbstractC1912g.b(i, bArr, i2, i3, T(obj), s50);
    }

    public static int o(Ta0 ta0, int i, byte[] bArr, int i2, int i3, zzcn zzcnVar, S50 s50) throws zzco {
        int iQ = q(ta0, bArr, i2, i3, s50);
        while (true) {
            zzcnVar.add(s50.c);
            if (iQ >= i3) {
                break;
            }
            int iF = AbstractC1912g.f(bArr, iQ, s50);
            if (i != s50.a) {
                break;
            }
            iQ = q(ta0, bArr, iF, i3, s50);
        }
        return iQ;
    }

    public static int p(Ta0 ta0, byte[] bArr, int i, int i2, int i3, S50 s50) throws zzco {
        C1917l c1917l = (C1917l) ta0;
        Object objG = c1917l.g();
        int iN = c1917l.n(objG, bArr, i, i2, i3, s50);
        c1917l.a(objG);
        s50.c = objG;
        return iN;
    }

    public static int q(Ta0 ta0, byte[] bArr, int i, int i2, S50 s50) throws zzco {
        int iD = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iD = AbstractC1912g.d(i3, bArr, iD, s50);
            i3 = s50.a;
        }
        int i4 = iD;
        if (i3 < 0 || i3 > i2 - i4) {
            throw zzco.zzbl();
        }
        Object objG = ta0.g();
        int i5 = i3 + i4;
        ta0.e(objG, bArr, i4, i5, s50);
        ta0.a(objG);
        s50.c = objG;
        return i5;
    }

    public static int r(Bb0 bb0, Object obj) {
        return bb0.j(bb0.k(obj));
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:41:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:44:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:45:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:48:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:50:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:51:0x0108  */
    /* JADX WARN: Code duplicated, block: B:53:0x010e  */
    /* JADX WARN: Code duplicated, block: B:54:0x0117  */
    /* JADX WARN: Code duplicated, block: B:56:0x011d  */
    /* JADX WARN: Code duplicated, block: B:57:0x0128  */
    /* JADX WARN: Code duplicated, block: B:59:0x012e  */
    /* JADX WARN: Code duplicated, block: B:62:0x0144  */
    /* JADX WARN: Code duplicated, block: B:63:0x014a  */
    /* JADX WARN: Code duplicated, block: B:70:0x0163  */
    /* JADX WARN: Code duplicated, block: B:76:0x016b A[EDGE_INSN: B:76:0x016b->B:72:0x016b BREAK  A[LOOP:0: B:22:0x0066->B:71:0x0167], SYNTHETIC] */
    public static C1917l s(Class cls, P90 p90, InterfaceC3155ja0 interfaceC3155ja0, X80 x80, Bb0 bb0, AbstractC4343y70 abstractC4343y70, I90 i90) {
        int iK;
        int i;
        int i2;
        int iB;
        int iB2;
        int iQ;
        int i3;
        int i4;
        int i5;
        int iH;
        int i6;
        if (!(p90 instanceof Ma0)) {
            AbstractC3574of.a(p90);
            throw null;
        }
        Ma0 ma0 = (Ma0) p90;
        boolean z = ma0.a() == zzcg.zzg.zzkm;
        if (ma0.d() == 0) {
            iK = 0;
            i = 0;
            i2 = 0;
        } else {
            int iF = ma0.f();
            int iG = ma0.g();
            iK = ma0.k();
            i = iF;
            i2 = iG;
        }
        int[] iArr = new int[iK << 2];
        Object[] objArr = new Object[iK << 1];
        int[] iArr2 = ma0.h() > 0 ? new int[ma0.h()] : null;
        int[] iArr3 = ma0.i() > 0 ? new int[ma0.i()] : null;
        Na0 na0E = ma0.e();
        if (na0E.a()) {
            int iG2 = na0E.g();
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            while (true) {
                if (iG2 >= ma0.l() || i7 >= ((iG2 - i) << 2)) {
                    if (!na0E.k()) {
                        iB = (int) Sb0.b(na0E.n());
                        if (na0E.o()) {
                            iB2 = (int) Sb0.b(na0E.p());
                            iQ = na0E.q();
                        } else {
                            iB2 = 0;
                        }
                        iArr[i7] = na0E.g();
                        i3 = i7 + 1;
                        if (na0E.s()) {
                            i4 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i4 = 0;
                        }
                        if (na0E.r()) {
                            i5 = 268435456;
                        } else {
                            i5 = 0;
                        }
                        iArr[i3] = i4 | i5 | (na0E.h() << 20) | iB;
                        iArr[i7 + 2] = iB2 | (iQ << 20);
                        if (na0E.v() != null) {
                            i6 = (i7 / 4) << 1;
                            objArr[i6] = na0E.v();
                            if (na0E.t() != null) {
                                objArr[i6 + 1] = na0E.t();
                            } else if (na0E.u() != null) {
                                objArr[i6 + 1] = na0E.u();
                            }
                        } else if (na0E.t() != null) {
                            objArr[((i7 / 4) << 1) + 1] = na0E.t();
                        } else if (na0E.u() != null) {
                            objArr[((i7 / 4) << 1) + 1] = na0E.u();
                        }
                        iH = na0E.h();
                        if (iH == zzcb.zziw.ordinal()) {
                            iArr2[i8] = i7;
                            i8++;
                        } else if (iH >= 18 && iH <= 49) {
                            iArr3[i9] = iArr[i3] & 1048575;
                            i9++;
                        }
                        if (na0E.a()) {
                            break;
                        }
                        iG2 = na0E.g();
                    } else {
                        iB = (int) Sb0.b(na0E.l());
                        iB2 = (int) Sb0.b(na0E.m());
                    }
                    iQ = 0;
                    iArr[i7] = na0E.g();
                    i3 = i7 + 1;
                    if (na0E.s()) {
                        i4 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i4 = 0;
                    }
                    if (na0E.r()) {
                        i5 = 268435456;
                    } else {
                        i5 = 0;
                    }
                    iArr[i3] = i4 | i5 | (na0E.h() << 20) | iB;
                    iArr[i7 + 2] = iB2 | (iQ << 20);
                    if (na0E.v() != null) {
                        i6 = (i7 / 4) << 1;
                        objArr[i6] = na0E.v();
                        if (na0E.t() != null) {
                            objArr[i6 + 1] = na0E.t();
                        } else if (na0E.u() != null) {
                            objArr[i6 + 1] = na0E.u();
                        }
                    } else if (na0E.t() != null) {
                        objArr[((i7 / 4) << 1) + 1] = na0E.t();
                    } else if (na0E.u() != null) {
                        objArr[((i7 / 4) << 1) + 1] = na0E.u();
                    }
                    iH = na0E.h();
                    if (iH == zzcb.zziw.ordinal()) {
                        iArr2[i8] = i7;
                        i8++;
                    } else if (iH >= 18) {
                        iArr3[i9] = iArr[i3] & 1048575;
                        i9++;
                    }
                    if (na0E.a()) {
                        break;
                        break;
                    }
                    iG2 = na0E.g();
                } else {
                    for (int i10 = 0; i10 < 4; i10++) {
                        iArr[i7 + i10] = -1;
                    }
                }
                i7 += 4;
            }
        }
        return new C1917l(iArr, objArr, i, i2, ma0.l(), ma0.c(), z, false, ma0.j(), iArr2, iArr3, interfaceC3155ja0, x80, bb0, abstractC4343y70, i90);
    }

    public static void u(int i, Object obj, InterfaceC3812rc0 interfaceC3812rc0) {
        if (obj instanceof String) {
            interfaceC3812rc0.o(i, (String) obj);
        } else {
            interfaceC3812rc0.L(i, (zzbb) obj);
        }
    }

    public static void w(Bb0 bb0, Object obj, InterfaceC3812rc0 interfaceC3812rc0) {
        bb0.c(bb0.k(obj), interfaceC3812rc0);
    }

    public final boolean A(Object obj, int i, int i2, int i3) {
        if (this.i) {
            return y(obj, i);
        }
        return (i2 & i3) != 0;
    }

    public final Ta0 C(int i) {
        int i2 = (i / 4) << 1;
        Ta0 ta0 = (Ta0) this.b[i2];
        if (ta0 != null) {
            return ta0;
        }
        Ta0 ta0B = Da0.a().b((Class) this.b[i2 + 1]);
        this.b[i2] = ta0B;
        return ta0B;
    }

    public final Object D(int i) {
        return this.b[(i / 4) << 1];
    }

    public final zzck E(int i) {
        return (zzck) this.b[((i / 4) << 1) + 1];
    }

    public final int F(int i) {
        return this.a[i + 1];
    }

    public final int G(int i) {
        return this.a[i + 2];
    }

    public final int H(int i) {
        int i2 = this.c;
        if (i >= i2) {
            int i3 = this.e;
            if (i < i3) {
                int i4 = (i - i2) << 2;
                if (this.a[i4] == i) {
                    return i4;
                }
                return -1;
            }
            if (i <= this.d) {
                int i5 = i3 - i2;
                int length = (this.a.length / 4) - 1;
                while (i5 <= length) {
                    int i6 = (length + i5) >>> 1;
                    int i7 = i6 << 2;
                    int i8 = this.a[i7];
                    if (i == i8) {
                        return i7;
                    }
                    if (i < i8) {
                        length = i6 - 1;
                    } else {
                        i5 = i6 + 1;
                    }
                }
            }
        }
        return -1;
    }

    public final void I(Object obj, int i) {
        if (this.i) {
            return;
        }
        int iG = G(i);
        long j = iG & 1048575;
        Sb0.g(obj, j, Sb0.H(obj, j) | (1 << (iG >>> 20)));
    }

    public final void J(Object obj, int i, int i2) {
        Sb0.g(obj, G(i2) & 1048575, i);
    }

    public final void K(Object obj, Object obj2, int i) {
        int iF = F(i);
        int i2 = this.a[i];
        long j = iF & 1048575;
        if (z(obj2, i2, i)) {
            Object objM = Sb0.M(obj, j);
            Object objM2 = Sb0.M(obj2, j);
            if (objM != null && objM2 != null) {
                Sb0.i(obj, j, zzci.zza(objM, objM2));
                J(obj, i2, i);
            } else if (objM2 != null) {
                Sb0.i(obj, j, objM2);
                J(obj, i2, i);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:7:0x0021  */
    public final void L(Object obj, InterfaceC3812rc0 interfaceC3812rc0) {
        Iterator itE;
        Map.Entry entry;
        int i;
        boolean z;
        int i2;
        boolean z2;
        int i3;
        boolean z3;
        int i4;
        boolean z4;
        int i5;
        boolean z5;
        int i6;
        int i7;
        List list;
        boolean z6;
        if (this.g) {
            H70 h70B = this.q.b(obj);
            if (h70B.b()) {
                itE = null;
                entry = null;
            } else {
                itE = h70B.e();
                entry = (Map.Entry) itE.next();
            }
        } else {
            itE = null;
            entry = null;
        }
        int length = this.a.length;
        Unsafe unsafe = s;
        int i8 = -1;
        int i9 = 0;
        for (int i10 = 0; i10 < length; i10 += 4) {
            int iF = F(i10);
            int[] iArr = this.a;
            int i11 = iArr[i10];
            int i12 = (267386880 & iF) >>> 20;
            if (this.i || i12 > 17) {
                i = 0;
            } else {
                int i13 = iArr[i10 + 2];
                int i14 = i13 & 1048575;
                if (i14 != i8) {
                    i9 = unsafe.getInt(obj, i14);
                    i8 = i14;
                }
                i = 1 << (i13 >>> 20);
            }
            while (entry != null && this.q.a(entry) <= i11) {
                this.q.d(interfaceC3812rc0, entry);
                entry = itE.hasNext() ? (Map.Entry) itE.next() : null;
            }
            long j = iF & 1048575;
            switch (i12) {
                case 0:
                    if ((i & i9) != 0) {
                        interfaceC3812rc0.r(i11, Sb0.L(obj, j));
                    }
                    break;
                case 1:
                    if ((i & i9) != 0) {
                        interfaceC3812rc0.s(i11, Sb0.K(obj, j));
                    }
                    break;
                case 2:
                    if ((i & i9) != 0) {
                        interfaceC3812rc0.I(i11, unsafe.getLong(obj, j));
                    }
                    break;
                case 3:
                    if ((i & i9) != 0) {
                        interfaceC3812rc0.q(i11, unsafe.getLong(obj, j));
                    }
                    break;
                case 4:
                    if ((i & i9) != 0) {
                        interfaceC3812rc0.k(i11, unsafe.getInt(obj, j));
                    }
                    break;
                case 5:
                    if ((i & i9) != 0) {
                        interfaceC3812rc0.l(i11, unsafe.getLong(obj, j));
                    }
                    break;
                case 6:
                    if ((i & i9) != 0) {
                        interfaceC3812rc0.u(i11, unsafe.getInt(obj, j));
                    }
                    break;
                case 7:
                    if ((i & i9) != 0) {
                        interfaceC3812rc0.j(i11, Sb0.J(obj, j));
                    }
                    break;
                case 8:
                    if ((i & i9) != 0) {
                        u(i11, unsafe.getObject(obj, j), interfaceC3812rc0);
                    }
                    break;
                case 9:
                    if ((i & i9) != 0) {
                        interfaceC3812rc0.J(i11, unsafe.getObject(obj, j), C(i10));
                    }
                    break;
                case 10:
                    if ((i & i9) != 0) {
                        interfaceC3812rc0.L(i11, (zzbb) unsafe.getObject(obj, j));
                    }
                    break;
                case 11:
                    if ((i & i9) != 0) {
                        interfaceC3812rc0.y(i11, unsafe.getInt(obj, j));
                    }
                    break;
                case 12:
                    if ((i & i9) != 0) {
                        interfaceC3812rc0.K(i11, unsafe.getInt(obj, j));
                    }
                    break;
                case 13:
                    if ((i & i9) != 0) {
                        interfaceC3812rc0.O(i11, unsafe.getInt(obj, j));
                    }
                    break;
                case 14:
                    if ((i & i9) != 0) {
                        interfaceC3812rc0.C(i11, unsafe.getLong(obj, j));
                    }
                    break;
                case 15:
                    if ((i & i9) != 0) {
                        interfaceC3812rc0.A(i11, unsafe.getInt(obj, j));
                    }
                    break;
                case 16:
                    if ((i & i9) != 0) {
                        interfaceC3812rc0.g(i11, unsafe.getLong(obj, j));
                    }
                    break;
                case 17:
                    if ((i & i9) != 0) {
                        interfaceC3812rc0.H(i11, unsafe.getObject(obj, j), C(i10));
                    }
                    break;
                case 18:
                    Ya0.f(this.a[i10], (List) unsafe.getObject(obj, j), interfaceC3812rc0, false);
                    break;
                case 19:
                    Ya0.m(this.a[i10], (List) unsafe.getObject(obj, j), interfaceC3812rc0, false);
                    break;
                case 20:
                    Ya0.r(this.a[i10], (List) unsafe.getObject(obj, j), interfaceC3812rc0, false);
                    break;
                case 21:
                    Ya0.x(this.a[i10], (List) unsafe.getObject(obj, j), interfaceC3812rc0, false);
                    break;
                case 22:
                    Ya0.M(this.a[i10], (List) unsafe.getObject(obj, j), interfaceC3812rc0, false);
                    break;
                case 23:
                    Ya0.H(this.a[i10], (List) unsafe.getObject(obj, j), interfaceC3812rc0, false);
                    break;
                case 24:
                    Ya0.R(this.a[i10], (List) unsafe.getObject(obj, j), interfaceC3812rc0, false);
                    break;
                case 25:
                    Ya0.U(this.a[i10], (List) unsafe.getObject(obj, j), interfaceC3812rc0, false);
                    break;
                case 26:
                    Ya0.d(this.a[i10], (List) unsafe.getObject(obj, j), interfaceC3812rc0);
                    break;
                case 27:
                    Ya0.e(this.a[i10], (List) unsafe.getObject(obj, j), interfaceC3812rc0, C(i10));
                    break;
                case 28:
                    Ya0.k(this.a[i10], (List) unsafe.getObject(obj, j), interfaceC3812rc0);
                    break;
                case 29:
                    z = false;
                    i2 = this.a[i10];
                    Ya0.O(i2, (List) unsafe.getObject(obj, j), interfaceC3812rc0, z);
                    break;
                case 30:
                    z2 = false;
                    i3 = this.a[i10];
                    Ya0.T(i3, (List) unsafe.getObject(obj, j), interfaceC3812rc0, z2);
                    break;
                case 31:
                    z3 = false;
                    i4 = this.a[i10];
                    Ya0.S(i4, (List) unsafe.getObject(obj, j), interfaceC3812rc0, z3);
                    break;
                case 32:
                    z4 = false;
                    i5 = this.a[i10];
                    Ya0.K(i5, (List) unsafe.getObject(obj, j), interfaceC3812rc0, z4);
                    break;
                case 33:
                    z5 = false;
                    i6 = this.a[i10];
                    Ya0.Q(i6, (List) unsafe.getObject(obj, j), interfaceC3812rc0, z5);
                    break;
                case 34:
                    i7 = this.a[i10];
                    list = (List) unsafe.getObject(obj, j);
                    z6 = false;
                    Ya0.F(i7, list, interfaceC3812rc0, z6);
                    break;
                case 35:
                    Ya0.f(this.a[i10], (List) unsafe.getObject(obj, j), interfaceC3812rc0, true);
                    break;
                case 36:
                    Ya0.m(this.a[i10], (List) unsafe.getObject(obj, j), interfaceC3812rc0, true);
                    break;
                case 37:
                    Ya0.r(this.a[i10], (List) unsafe.getObject(obj, j), interfaceC3812rc0, true);
                    break;
                case 38:
                    Ya0.x(this.a[i10], (List) unsafe.getObject(obj, j), interfaceC3812rc0, true);
                    break;
                case 39:
                    Ya0.M(this.a[i10], (List) unsafe.getObject(obj, j), interfaceC3812rc0, true);
                    break;
                case 40:
                    Ya0.H(this.a[i10], (List) unsafe.getObject(obj, j), interfaceC3812rc0, true);
                    break;
                case 41:
                    Ya0.R(this.a[i10], (List) unsafe.getObject(obj, j), interfaceC3812rc0, true);
                    break;
                case 42:
                    Ya0.U(this.a[i10], (List) unsafe.getObject(obj, j), interfaceC3812rc0, true);
                    break;
                case 43:
                    z = true;
                    i2 = this.a[i10];
                    Ya0.O(i2, (List) unsafe.getObject(obj, j), interfaceC3812rc0, z);
                    break;
                case 44:
                    z2 = true;
                    i3 = this.a[i10];
                    Ya0.T(i3, (List) unsafe.getObject(obj, j), interfaceC3812rc0, z2);
                    break;
                case 45:
                    z3 = true;
                    i4 = this.a[i10];
                    Ya0.S(i4, (List) unsafe.getObject(obj, j), interfaceC3812rc0, z3);
                    break;
                case 46:
                    z4 = true;
                    i5 = this.a[i10];
                    Ya0.K(i5, (List) unsafe.getObject(obj, j), interfaceC3812rc0, z4);
                    break;
                case 47:
                    z5 = true;
                    i6 = this.a[i10];
                    Ya0.Q(i6, (List) unsafe.getObject(obj, j), interfaceC3812rc0, z5);
                    break;
                case 48:
                    i7 = this.a[i10];
                    list = (List) unsafe.getObject(obj, j);
                    z6 = true;
                    Ya0.F(i7, list, interfaceC3812rc0, z6);
                    break;
                case 49:
                    Ya0.l(this.a[i10], (List) unsafe.getObject(obj, j), interfaceC3812rc0, C(i10));
                    break;
                case 50:
                    x(interfaceC3812rc0, i11, unsafe.getObject(obj, j), i10);
                    break;
                case 51:
                    if (z(obj, i11, i10)) {
                        interfaceC3812rc0.r(i11, O(obj, j));
                    }
                    break;
                case 52:
                    if (z(obj, i11, i10)) {
                        interfaceC3812rc0.s(i11, P(obj, j));
                    }
                    break;
                case 53:
                    if (z(obj, i11, i10)) {
                        interfaceC3812rc0.I(i11, R(obj, j));
                    }
                    break;
                case 54:
                    if (z(obj, i11, i10)) {
                        interfaceC3812rc0.q(i11, R(obj, j));
                    }
                    break;
                case 55:
                    if (z(obj, i11, i10)) {
                        interfaceC3812rc0.k(i11, Q(obj, j));
                    }
                    break;
                case 56:
                    if (z(obj, i11, i10)) {
                        interfaceC3812rc0.l(i11, R(obj, j));
                    }
                    break;
                case 57:
                    if (z(obj, i11, i10)) {
                        interfaceC3812rc0.u(i11, Q(obj, j));
                    }
                    break;
                case 58:
                    if (z(obj, i11, i10)) {
                        interfaceC3812rc0.j(i11, S(obj, j));
                    }
                    break;
                case 59:
                    if (z(obj, i11, i10)) {
                        u(i11, unsafe.getObject(obj, j), interfaceC3812rc0);
                    }
                    break;
                case 60:
                    if (z(obj, i11, i10)) {
                        interfaceC3812rc0.J(i11, unsafe.getObject(obj, j), C(i10));
                    }
                    break;
                case 61:
                    if (z(obj, i11, i10)) {
                        interfaceC3812rc0.L(i11, (zzbb) unsafe.getObject(obj, j));
                    }
                    break;
                case 62:
                    if (z(obj, i11, i10)) {
                        interfaceC3812rc0.y(i11, Q(obj, j));
                    }
                    break;
                case 63:
                    if (z(obj, i11, i10)) {
                        interfaceC3812rc0.K(i11, Q(obj, j));
                    }
                    break;
                case 64:
                    if (z(obj, i11, i10)) {
                        interfaceC3812rc0.O(i11, Q(obj, j));
                    }
                    break;
                case 65:
                    if (z(obj, i11, i10)) {
                        interfaceC3812rc0.C(i11, R(obj, j));
                    }
                    break;
                case 66:
                    if (z(obj, i11, i10)) {
                        interfaceC3812rc0.A(i11, Q(obj, j));
                    }
                    break;
                case 67:
                    if (z(obj, i11, i10)) {
                        interfaceC3812rc0.g(i11, R(obj, j));
                    }
                    break;
                case 68:
                    if (z(obj, i11, i10)) {
                        interfaceC3812rc0.H(i11, unsafe.getObject(obj, j), C(i10));
                    }
                    break;
                default:
                    break;
            }
        }
        while (entry != null) {
            this.q.d(interfaceC3812rc0, entry);
            entry = itE.hasNext() ? (Map.Entry) itE.next() : null;
        }
        w(this.p, obj, interfaceC3812rc0);
    }

    public final boolean M(Object obj, Object obj2, int i) {
        return y(obj, i) == y(obj2, i);
    }

    @Override // defpackage.Ta0
    public final void a(Object obj) {
        int[] iArr = this.l;
        if (iArr != null) {
            for (int i : iArr) {
                long jF = F(i) & 1048575;
                Object objM = Sb0.M(obj, jF);
                if (objM != null) {
                    Sb0.i(obj, jF, this.r.e(objM));
                }
            }
        }
        int[] iArr2 = this.m;
        if (iArr2 != null) {
            for (int i2 : iArr2) {
                this.o.a(obj, i2);
            }
        }
        this.p.d(obj);
        if (this.g) {
            this.q.f(obj);
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002b  */
    /* JADX WARN: Code duplicated, block: B:20:0x0057  */
    /* JADX WARN: Code duplicated, block: B:24:0x0069  */
    /* JADX WARN: Code duplicated, block: B:39:0x0093  */
    @Override // defpackage.Ta0
    public final void b(Object obj, Object obj2) {
        obj2.getClass();
        for (int i = 0; i < this.a.length; i += 4) {
            int iF = F(i);
            long j = 1048575 & iF;
            int i2 = this.a[i];
            switch ((iF & 267386880) >>> 20) {
                case 0:
                    if (y(obj2, i)) {
                        Sb0.e(obj, j, Sb0.L(obj2, j));
                        I(obj, i);
                    }
                    break;
                case 1:
                    if (y(obj2, i)) {
                        Sb0.f(obj, j, Sb0.K(obj2, j));
                        I(obj, i);
                    }
                    break;
                case 2:
                    if (y(obj2, i)) {
                        Sb0.h(obj, j, Sb0.I(obj2, j));
                        I(obj, i);
                    }
                    break;
                case 3:
                    if (y(obj2, i)) {
                        Sb0.h(obj, j, Sb0.I(obj2, j));
                        I(obj, i);
                    }
                    break;
                case 4:
                    if (y(obj2, i)) {
                        Sb0.g(obj, j, Sb0.H(obj2, j));
                        I(obj, i);
                    }
                    break;
                case 5:
                    if (y(obj2, i)) {
                        Sb0.h(obj, j, Sb0.I(obj2, j));
                        I(obj, i);
                    }
                    break;
                case 6:
                    if (y(obj2, i)) {
                        Sb0.g(obj, j, Sb0.H(obj2, j));
                        I(obj, i);
                    }
                    break;
                case 7:
                    if (y(obj2, i)) {
                        Sb0.j(obj, j, Sb0.J(obj2, j));
                        I(obj, i);
                    }
                    break;
                case 8:
                    if (y(obj2, i)) {
                        Sb0.i(obj, j, Sb0.M(obj2, j));
                        I(obj, i);
                    }
                    break;
                case 9:
                case 17:
                    v(obj, obj2, i);
                    break;
                case 10:
                    if (y(obj2, i)) {
                        Sb0.i(obj, j, Sb0.M(obj2, j));
                        I(obj, i);
                    }
                    break;
                case 11:
                    if (y(obj2, i)) {
                        Sb0.g(obj, j, Sb0.H(obj2, j));
                        I(obj, i);
                    }
                    break;
                case 12:
                    if (y(obj2, i)) {
                        Sb0.g(obj, j, Sb0.H(obj2, j));
                        I(obj, i);
                    }
                    break;
                case 13:
                    if (y(obj2, i)) {
                        Sb0.g(obj, j, Sb0.H(obj2, j));
                        I(obj, i);
                    }
                    break;
                case 14:
                    if (y(obj2, i)) {
                        Sb0.h(obj, j, Sb0.I(obj2, j));
                        I(obj, i);
                    }
                    break;
                case 15:
                    if (y(obj2, i)) {
                        Sb0.g(obj, j, Sb0.H(obj2, j));
                        I(obj, i);
                    }
                    break;
                case 16:
                    if (y(obj2, i)) {
                        Sb0.h(obj, j, Sb0.I(obj2, j));
                        I(obj, i);
                    }
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.o.b(obj, obj2, j);
                    break;
                case 50:
                    Ya0.h(this.r, obj, obj2, j);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (z(obj2, i2, i)) {
                        Sb0.i(obj, j, Sb0.M(obj2, j));
                        J(obj, i2, i);
                    }
                    break;
                case 60:
                case 68:
                    K(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (z(obj2, i2, i)) {
                        Sb0.i(obj, j, Sb0.M(obj2, j));
                        J(obj, i2, i);
                    }
                    break;
            }
        }
        if (this.i) {
            return;
        }
        Ya0.i(this.p, obj, obj2);
        if (this.g) {
            Ya0.g(this.q, obj, obj2);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:17:0x004d  */
    /* JADX WARN: Code duplicated, block: B:251:0x0430 A[PHI: r5
      0x0430: PHI (r5v4 int) = 
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v13 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v14 int)
      (r5v1 int)
     binds: [B:245:0x0417, B:435:0x0765, B:432:0x075f, B:427:0x0751, B:424:0x074b, B:421:0x0745, B:418:0x073b, B:415:0x0731, B:412:0x072b, B:409:0x0725, B:406:0x071b, B:403:0x0711, B:400:0x070b, B:382:0x0657, B:377:0x0645, B:372:0x0633, B:367:0x0621, B:362:0x060f, B:357:0x05fd, B:352:0x05eb, B:347:0x05da, B:342:0x05c9, B:337:0x05b8, B:332:0x05a7, B:327:0x0596, B:322:0x0585, B:316:0x0565, B:311:0x0531, B:308:0x0524, B:305:0x0514, B:302:0x0504, B:299:0x04f4, B:296:0x04e6, B:293:0x04da, B:290:0x04ce, B:284:0x04b7, B:281:0x04a3, B:277:0x0492, B:273:0x0483, B:269:0x0474, B:267:0x046e, B:265:0x0467, B:262:0x045a, B:258:0x044b, B:254:0x043c, B:250:0x042f, B:248:0x041f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:279:0x0498 A[PHI: r6
      0x0498: PHI (r6v140 java.lang.Object) = (r6v14 java.lang.Object), (r6v136 java.lang.Object), (r6v143 java.lang.Object) binds: [B:429:0x0759, B:286:0x04bf, B:278:0x0494] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:288:0x04c2 A[PHI: r6
      0x04c2: PHI (r6v132 java.lang.Object) = (r6v14 java.lang.Object), (r6v136 java.lang.Object) binds: [B:429:0x0759, B:286:0x04bf] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:29:0x0082  */
    /* JADX WARN: Code duplicated, block: B:319:0x056b A[PHI: r6
      0x056b: PHI (r6v106 int) = 
      (r6v68 int)
      (r6v71 int)
      (r6v74 int)
      (r6v77 int)
      (r6v80 int)
      (r6v83 int)
      (r6v86 int)
      (r6v89 int)
      (r6v92 int)
      (r6v95 int)
      (r6v98 int)
      (r6v101 int)
      (r6v104 int)
      (r6v109 int)
     binds: [B:384:0x065b, B:379:0x0649, B:374:0x0637, B:369:0x0625, B:364:0x0613, B:359:0x0601, B:354:0x05ef, B:349:0x05de, B:344:0x05cd, B:339:0x05bc, B:334:0x05ab, B:329:0x059a, B:324:0x0589, B:318:0x0569] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:32:0x008d  */
    /* JADX WARN: Code duplicated, block: B:43:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ba A[PHI: r4
      0x00ba: PHI (r4v94 java.lang.Object) = (r4v12 java.lang.Object), (r4v92 java.lang.Object), (r4v96 java.lang.Object) binds: [B:197:0x0365, B:51:0x00e0, B:43:0x00b6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:47:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:53:0x00e3 A[PHI: r4
      0x00e3: PHI (r4v90 java.lang.Object) = (r4v12 java.lang.Object), (r4v92 java.lang.Object) binds: [B:197:0x0365, B:51:0x00e0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:56:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:59:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:62:0x0109  */
    /* JADX WARN: Code duplicated, block: B:77:0x0145  */
    /* JADX WARN: Code duplicated, block: B:80:0x0151  */
    /* JADX WARN: Code duplicated, block: B:87:0x0187 A[PHI: r4
      0x0187: PHI (r4v72 int) = 
      (r4v34 int)
      (r4v37 int)
      (r4v40 int)
      (r4v43 int)
      (r4v46 int)
      (r4v49 int)
      (r4v52 int)
      (r4v55 int)
      (r4v58 int)
      (r4v61 int)
      (r4v64 int)
      (r4v67 int)
      (r4v70 int)
      (r4v75 int)
     binds: [B:152:0x0277, B:147:0x0265, B:142:0x0253, B:137:0x0241, B:132:0x022f, B:127:0x021d, B:122:0x020b, B:117:0x01fa, B:112:0x01e9, B:107:0x01d8, B:102:0x01c7, B:97:0x01b6, B:92:0x01a5, B:86:0x0185] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x041f, code lost:
    
        if (z(r20, r15, r4) != false) goto L249;
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x0421, code lost:
    
        r6 = com.google.android.gms.internal.clearcut.zzbn.zzc(r15, (com.google.android.gms.internal.clearcut.zzdo) r2.getObject(r20, r10), C(r4));
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x045a, code lost:
    
        if (z(r20, r15, r4) != false) goto L263;
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x045c, code lost:
    
        r6 = com.google.android.gms.internal.clearcut.zzbn.zzh(r15, 0L);
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x0467, code lost:
    
        if (z(r20, r15, r4) != false) goto L266;
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x0469, code lost:
    
        r9 = com.google.android.gms.internal.clearcut.zzbn.zzk(r15, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:277:0x0492, code lost:
    
        if (z(r20, r15, r4) != false) goto L278;
     */
    /* JADX WARN: Code restructure failed: missing block: B:278:0x0494, code lost:
    
        r6 = r2.getObject(r20, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:281:0x04a3, code lost:
    
        if (z(r20, r15, r4) != false) goto L282;
     */
    /* JADX WARN: Code restructure failed: missing block: B:282:0x04a5, code lost:
    
        r6 = defpackage.Ya0.n(r15, r2.getObject(r20, r10), C(r4));
     */
    /* JADX WARN: Code restructure failed: missing block: B:290:0x04ce, code lost:
    
        if (z(r20, r15, r4) != false) goto L291;
     */
    /* JADX WARN: Code restructure failed: missing block: B:291:0x04d0, code lost:
    
        r6 = com.google.android.gms.internal.clearcut.zzbn.zzc(r15, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:400:0x070b, code lost:
    
        if ((r12 & r18) != 0) goto L249;
     */
    /* JADX WARN: Code restructure failed: missing block: B:409:0x0725, code lost:
    
        if ((r12 & r18) != 0) goto L263;
     */
    /* JADX WARN: Code restructure failed: missing block: B:412:0x072b, code lost:
    
        if ((r12 & r18) != 0) goto L266;
     */
    /* JADX WARN: Code restructure failed: missing block: B:421:0x0745, code lost:
    
        if ((r12 & r18) != 0) goto L278;
     */
    /* JADX WARN: Code restructure failed: missing block: B:424:0x074b, code lost:
    
        if ((r12 & r18) != 0) goto L282;
     */
    /* JADX WARN: Code restructure failed: missing block: B:432:0x075f, code lost:
    
        if ((r12 & r18) != 0) goto L291;
     */
    @Override // defpackage.Ta0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int c(java.lang.Object r20) {
        /*
            Method dump skipped, instruction units count: 2310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.C1917l.c(java.lang.Object):int");
    }

    /* JADX WARN: Code duplicated, block: B:192:0x04f6  */
    /* JADX WARN: Code duplicated, block: B:208:0x0533  */
    /* JADX WARN: Code duplicated, block: B:235:0x05ae  */
    /* JADX WARN: Code duplicated, block: B:238:0x05c1  */
    /* JADX WARN: Code duplicated, block: B:241:0x05d6  */
    /* JADX WARN: Code duplicated, block: B:25:0x006e  */
    /* JADX WARN: Code duplicated, block: B:52:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:55:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:58:0x0111  */
    /* JADX WARN: Code duplicated, block: B:9:0x0030  */
    @Override // defpackage.Ta0
    public final void d(Object obj, InterfaceC3812rc0 interfaceC3812rc0) {
        Iterator itE;
        Map.Entry entry;
        double dL;
        float fK;
        long jI;
        long jI2;
        int iH;
        long jI3;
        int iH2;
        boolean zJ;
        int iH3;
        int iH4;
        int iH5;
        long jI4;
        int iH6;
        long jI5;
        Iterator itA;
        Map.Entry entry2;
        double dL2;
        float fK2;
        long jI6;
        long jI7;
        int iH7;
        long jI8;
        int iH8;
        boolean zJ2;
        int iH9;
        int iH10;
        int iH11;
        long jI9;
        int iH12;
        long jI10;
        if (interfaceC3812rc0.N() == zzcg.zzg.zzkp) {
            w(this.p, obj, interfaceC3812rc0);
            if (this.g) {
                H70 h70B = this.q.b(obj);
                if (h70B.b()) {
                    itA = null;
                    entry2 = null;
                } else {
                    itA = h70B.a();
                    entry2 = (Map.Entry) itA.next();
                }
            } else {
                itA = null;
                entry2 = null;
            }
            for (int length = this.a.length - 4; length >= 0; length -= 4) {
                int iF = F(length);
                int i = this.a[length];
                while (entry2 != null && this.q.a(entry2) > i) {
                    this.q.d(interfaceC3812rc0, entry2);
                    entry2 = itA.hasNext() ? (Map.Entry) itA.next() : null;
                }
                switch ((iF & 267386880) >>> 20) {
                    case 0:
                        if (y(obj, length)) {
                            dL2 = Sb0.L(obj, iF & 1048575);
                            interfaceC3812rc0.r(i, dL2);
                        }
                        break;
                    case 1:
                        if (y(obj, length)) {
                            fK2 = Sb0.K(obj, iF & 1048575);
                            interfaceC3812rc0.s(i, fK2);
                        }
                        break;
                    case 2:
                        if (y(obj, length)) {
                            jI6 = Sb0.I(obj, iF & 1048575);
                            interfaceC3812rc0.I(i, jI6);
                        }
                        break;
                    case 3:
                        if (y(obj, length)) {
                            jI7 = Sb0.I(obj, iF & 1048575);
                            interfaceC3812rc0.q(i, jI7);
                        }
                        break;
                    case 4:
                        if (y(obj, length)) {
                            iH7 = Sb0.H(obj, iF & 1048575);
                            interfaceC3812rc0.k(i, iH7);
                        }
                        break;
                    case 5:
                        if (y(obj, length)) {
                            jI8 = Sb0.I(obj, iF & 1048575);
                            interfaceC3812rc0.l(i, jI8);
                        }
                        break;
                    case 6:
                        if (y(obj, length)) {
                            iH8 = Sb0.H(obj, iF & 1048575);
                            interfaceC3812rc0.u(i, iH8);
                        }
                        break;
                    case 7:
                        if (y(obj, length)) {
                            zJ2 = Sb0.J(obj, iF & 1048575);
                            interfaceC3812rc0.j(i, zJ2);
                        }
                        break;
                    case 8:
                        if (y(obj, length)) {
                            u(i, Sb0.M(obj, iF & 1048575), interfaceC3812rc0);
                        }
                        break;
                    case 9:
                        if (y(obj, length)) {
                            interfaceC3812rc0.J(i, Sb0.M(obj, iF & 1048575), C(length));
                        }
                        break;
                    case 10:
                        if (y(obj, length)) {
                            interfaceC3812rc0.L(i, (zzbb) Sb0.M(obj, iF & 1048575));
                        }
                        break;
                    case 11:
                        if (y(obj, length)) {
                            iH9 = Sb0.H(obj, iF & 1048575);
                            interfaceC3812rc0.y(i, iH9);
                        }
                        break;
                    case 12:
                        if (y(obj, length)) {
                            iH10 = Sb0.H(obj, iF & 1048575);
                            interfaceC3812rc0.K(i, iH10);
                        }
                        break;
                    case 13:
                        if (y(obj, length)) {
                            iH11 = Sb0.H(obj, iF & 1048575);
                            interfaceC3812rc0.O(i, iH11);
                        }
                        break;
                    case 14:
                        if (y(obj, length)) {
                            jI9 = Sb0.I(obj, iF & 1048575);
                            interfaceC3812rc0.C(i, jI9);
                        }
                        break;
                    case 15:
                        if (y(obj, length)) {
                            iH12 = Sb0.H(obj, iF & 1048575);
                            interfaceC3812rc0.A(i, iH12);
                        }
                        break;
                    case 16:
                        if (y(obj, length)) {
                            jI10 = Sb0.I(obj, iF & 1048575);
                            interfaceC3812rc0.g(i, jI10);
                        }
                        break;
                    case 17:
                        if (y(obj, length)) {
                            interfaceC3812rc0.H(i, Sb0.M(obj, iF & 1048575), C(length));
                        }
                        break;
                    case 18:
                        Ya0.f(this.a[length], (List) Sb0.M(obj, iF & 1048575), interfaceC3812rc0, false);
                        break;
                    case 19:
                        Ya0.m(this.a[length], (List) Sb0.M(obj, iF & 1048575), interfaceC3812rc0, false);
                        break;
                    case 20:
                        Ya0.r(this.a[length], (List) Sb0.M(obj, iF & 1048575), interfaceC3812rc0, false);
                        break;
                    case 21:
                        Ya0.x(this.a[length], (List) Sb0.M(obj, iF & 1048575), interfaceC3812rc0, false);
                        break;
                    case 22:
                        Ya0.M(this.a[length], (List) Sb0.M(obj, iF & 1048575), interfaceC3812rc0, false);
                        break;
                    case 23:
                        Ya0.H(this.a[length], (List) Sb0.M(obj, iF & 1048575), interfaceC3812rc0, false);
                        break;
                    case 24:
                        Ya0.R(this.a[length], (List) Sb0.M(obj, iF & 1048575), interfaceC3812rc0, false);
                        break;
                    case 25:
                        Ya0.U(this.a[length], (List) Sb0.M(obj, iF & 1048575), interfaceC3812rc0, false);
                        break;
                    case 26:
                        Ya0.d(this.a[length], (List) Sb0.M(obj, iF & 1048575), interfaceC3812rc0);
                        break;
                    case 27:
                        Ya0.e(this.a[length], (List) Sb0.M(obj, iF & 1048575), interfaceC3812rc0, C(length));
                        break;
                    case 28:
                        Ya0.k(this.a[length], (List) Sb0.M(obj, iF & 1048575), interfaceC3812rc0);
                        break;
                    case 29:
                        Ya0.O(this.a[length], (List) Sb0.M(obj, iF & 1048575), interfaceC3812rc0, false);
                        break;
                    case 30:
                        Ya0.T(this.a[length], (List) Sb0.M(obj, iF & 1048575), interfaceC3812rc0, false);
                        break;
                    case 31:
                        Ya0.S(this.a[length], (List) Sb0.M(obj, iF & 1048575), interfaceC3812rc0, false);
                        break;
                    case 32:
                        Ya0.K(this.a[length], (List) Sb0.M(obj, iF & 1048575), interfaceC3812rc0, false);
                        break;
                    case 33:
                        Ya0.Q(this.a[length], (List) Sb0.M(obj, iF & 1048575), interfaceC3812rc0, false);
                        break;
                    case 34:
                        Ya0.F(this.a[length], (List) Sb0.M(obj, iF & 1048575), interfaceC3812rc0, false);
                        break;
                    case 35:
                        Ya0.f(this.a[length], (List) Sb0.M(obj, iF & 1048575), interfaceC3812rc0, true);
                        break;
                    case 36:
                        Ya0.m(this.a[length], (List) Sb0.M(obj, iF & 1048575), interfaceC3812rc0, true);
                        break;
                    case 37:
                        Ya0.r(this.a[length], (List) Sb0.M(obj, iF & 1048575), interfaceC3812rc0, true);
                        break;
                    case 38:
                        Ya0.x(this.a[length], (List) Sb0.M(obj, iF & 1048575), interfaceC3812rc0, true);
                        break;
                    case 39:
                        Ya0.M(this.a[length], (List) Sb0.M(obj, iF & 1048575), interfaceC3812rc0, true);
                        break;
                    case 40:
                        Ya0.H(this.a[length], (List) Sb0.M(obj, iF & 1048575), interfaceC3812rc0, true);
                        break;
                    case 41:
                        Ya0.R(this.a[length], (List) Sb0.M(obj, iF & 1048575), interfaceC3812rc0, true);
                        break;
                    case 42:
                        Ya0.U(this.a[length], (List) Sb0.M(obj, iF & 1048575), interfaceC3812rc0, true);
                        break;
                    case 43:
                        Ya0.O(this.a[length], (List) Sb0.M(obj, iF & 1048575), interfaceC3812rc0, true);
                        break;
                    case 44:
                        Ya0.T(this.a[length], (List) Sb0.M(obj, iF & 1048575), interfaceC3812rc0, true);
                        break;
                    case 45:
                        Ya0.S(this.a[length], (List) Sb0.M(obj, iF & 1048575), interfaceC3812rc0, true);
                        break;
                    case 46:
                        Ya0.K(this.a[length], (List) Sb0.M(obj, iF & 1048575), interfaceC3812rc0, true);
                        break;
                    case 47:
                        Ya0.Q(this.a[length], (List) Sb0.M(obj, iF & 1048575), interfaceC3812rc0, true);
                        break;
                    case 48:
                        Ya0.F(this.a[length], (List) Sb0.M(obj, iF & 1048575), interfaceC3812rc0, true);
                        break;
                    case 49:
                        Ya0.l(this.a[length], (List) Sb0.M(obj, iF & 1048575), interfaceC3812rc0, C(length));
                        break;
                    case 50:
                        x(interfaceC3812rc0, i, Sb0.M(obj, iF & 1048575), length);
                        break;
                    case 51:
                        if (z(obj, i, length)) {
                            dL2 = O(obj, iF & 1048575);
                            interfaceC3812rc0.r(i, dL2);
                        }
                        break;
                    case 52:
                        if (z(obj, i, length)) {
                            fK2 = P(obj, iF & 1048575);
                            interfaceC3812rc0.s(i, fK2);
                        }
                        break;
                    case 53:
                        if (z(obj, i, length)) {
                            jI6 = R(obj, iF & 1048575);
                            interfaceC3812rc0.I(i, jI6);
                        }
                        break;
                    case 54:
                        if (z(obj, i, length)) {
                            jI7 = R(obj, iF & 1048575);
                            interfaceC3812rc0.q(i, jI7);
                        }
                        break;
                    case 55:
                        if (z(obj, i, length)) {
                            iH7 = Q(obj, iF & 1048575);
                            interfaceC3812rc0.k(i, iH7);
                        }
                        break;
                    case 56:
                        if (z(obj, i, length)) {
                            jI8 = R(obj, iF & 1048575);
                            interfaceC3812rc0.l(i, jI8);
                        }
                        break;
                    case 57:
                        if (z(obj, i, length)) {
                            iH8 = Q(obj, iF & 1048575);
                            interfaceC3812rc0.u(i, iH8);
                        }
                        break;
                    case 58:
                        if (z(obj, i, length)) {
                            zJ2 = S(obj, iF & 1048575);
                            interfaceC3812rc0.j(i, zJ2);
                        }
                        break;
                    case 59:
                        if (z(obj, i, length)) {
                            u(i, Sb0.M(obj, iF & 1048575), interfaceC3812rc0);
                        }
                        break;
                    case 60:
                        if (z(obj, i, length)) {
                            interfaceC3812rc0.J(i, Sb0.M(obj, iF & 1048575), C(length));
                        }
                        break;
                    case 61:
                        if (z(obj, i, length)) {
                            interfaceC3812rc0.L(i, (zzbb) Sb0.M(obj, iF & 1048575));
                        }
                        break;
                    case 62:
                        if (z(obj, i, length)) {
                            iH9 = Q(obj, iF & 1048575);
                            interfaceC3812rc0.y(i, iH9);
                        }
                        break;
                    case 63:
                        if (z(obj, i, length)) {
                            iH10 = Q(obj, iF & 1048575);
                            interfaceC3812rc0.K(i, iH10);
                        }
                        break;
                    case 64:
                        if (z(obj, i, length)) {
                            iH11 = Q(obj, iF & 1048575);
                            interfaceC3812rc0.O(i, iH11);
                        }
                        break;
                    case 65:
                        if (z(obj, i, length)) {
                            jI9 = R(obj, iF & 1048575);
                            interfaceC3812rc0.C(i, jI9);
                        }
                        break;
                    case 66:
                        if (z(obj, i, length)) {
                            iH12 = Q(obj, iF & 1048575);
                            interfaceC3812rc0.A(i, iH12);
                        }
                        break;
                    case 67:
                        if (z(obj, i, length)) {
                            jI10 = R(obj, iF & 1048575);
                            interfaceC3812rc0.g(i, jI10);
                        }
                        break;
                    case 68:
                        if (z(obj, i, length)) {
                            interfaceC3812rc0.H(i, Sb0.M(obj, iF & 1048575), C(length));
                        }
                        break;
                }
            }
            while (entry2 != null) {
                this.q.d(interfaceC3812rc0, entry2);
                entry2 = itA.hasNext() ? (Map.Entry) itA.next() : null;
            }
            return;
        }
        if (!this.i) {
            L(obj, interfaceC3812rc0);
            return;
        }
        if (this.g) {
            H70 h70B2 = this.q.b(obj);
            if (h70B2.b()) {
                itE = null;
                entry = null;
            } else {
                itE = h70B2.e();
                entry = (Map.Entry) itE.next();
            }
        } else {
            itE = null;
            entry = null;
        }
        int length2 = this.a.length;
        for (int i2 = 0; i2 < length2; i2 += 4) {
            int iF2 = F(i2);
            int i3 = this.a[i2];
            while (entry != null && this.q.a(entry) <= i3) {
                this.q.d(interfaceC3812rc0, entry);
                entry = itE.hasNext() ? (Map.Entry) itE.next() : null;
            }
            switch ((iF2 & 267386880) >>> 20) {
                case 0:
                    if (y(obj, i2)) {
                        dL = Sb0.L(obj, iF2 & 1048575);
                        interfaceC3812rc0.r(i3, dL);
                    }
                    break;
                case 1:
                    if (y(obj, i2)) {
                        fK = Sb0.K(obj, iF2 & 1048575);
                        interfaceC3812rc0.s(i3, fK);
                    }
                    break;
                case 2:
                    if (y(obj, i2)) {
                        jI = Sb0.I(obj, iF2 & 1048575);
                        interfaceC3812rc0.I(i3, jI);
                    }
                    break;
                case 3:
                    if (y(obj, i2)) {
                        jI2 = Sb0.I(obj, iF2 & 1048575);
                        interfaceC3812rc0.q(i3, jI2);
                    }
                    break;
                case 4:
                    if (y(obj, i2)) {
                        iH = Sb0.H(obj, iF2 & 1048575);
                        interfaceC3812rc0.k(i3, iH);
                    }
                    break;
                case 5:
                    if (y(obj, i2)) {
                        jI3 = Sb0.I(obj, iF2 & 1048575);
                        interfaceC3812rc0.l(i3, jI3);
                    }
                    break;
                case 6:
                    if (y(obj, i2)) {
                        iH2 = Sb0.H(obj, iF2 & 1048575);
                        interfaceC3812rc0.u(i3, iH2);
                    }
                    break;
                case 7:
                    if (y(obj, i2)) {
                        zJ = Sb0.J(obj, iF2 & 1048575);
                        interfaceC3812rc0.j(i3, zJ);
                    }
                    break;
                case 8:
                    if (y(obj, i2)) {
                        u(i3, Sb0.M(obj, iF2 & 1048575), interfaceC3812rc0);
                    }
                    break;
                case 9:
                    if (y(obj, i2)) {
                        interfaceC3812rc0.J(i3, Sb0.M(obj, iF2 & 1048575), C(i2));
                    }
                    break;
                case 10:
                    if (y(obj, i2)) {
                        interfaceC3812rc0.L(i3, (zzbb) Sb0.M(obj, iF2 & 1048575));
                    }
                    break;
                case 11:
                    if (y(obj, i2)) {
                        iH3 = Sb0.H(obj, iF2 & 1048575);
                        interfaceC3812rc0.y(i3, iH3);
                    }
                    break;
                case 12:
                    if (y(obj, i2)) {
                        iH4 = Sb0.H(obj, iF2 & 1048575);
                        interfaceC3812rc0.K(i3, iH4);
                    }
                    break;
                case 13:
                    if (y(obj, i2)) {
                        iH5 = Sb0.H(obj, iF2 & 1048575);
                        interfaceC3812rc0.O(i3, iH5);
                    }
                    break;
                case 14:
                    if (y(obj, i2)) {
                        jI4 = Sb0.I(obj, iF2 & 1048575);
                        interfaceC3812rc0.C(i3, jI4);
                    }
                    break;
                case 15:
                    if (y(obj, i2)) {
                        iH6 = Sb0.H(obj, iF2 & 1048575);
                        interfaceC3812rc0.A(i3, iH6);
                    }
                    break;
                case 16:
                    if (y(obj, i2)) {
                        jI5 = Sb0.I(obj, iF2 & 1048575);
                        interfaceC3812rc0.g(i3, jI5);
                    }
                    break;
                case 17:
                    if (y(obj, i2)) {
                        interfaceC3812rc0.H(i3, Sb0.M(obj, iF2 & 1048575), C(i2));
                    }
                    break;
                case 18:
                    Ya0.f(this.a[i2], (List) Sb0.M(obj, iF2 & 1048575), interfaceC3812rc0, false);
                    break;
                case 19:
                    Ya0.m(this.a[i2], (List) Sb0.M(obj, iF2 & 1048575), interfaceC3812rc0, false);
                    break;
                case 20:
                    Ya0.r(this.a[i2], (List) Sb0.M(obj, iF2 & 1048575), interfaceC3812rc0, false);
                    break;
                case 21:
                    Ya0.x(this.a[i2], (List) Sb0.M(obj, iF2 & 1048575), interfaceC3812rc0, false);
                    break;
                case 22:
                    Ya0.M(this.a[i2], (List) Sb0.M(obj, iF2 & 1048575), interfaceC3812rc0, false);
                    break;
                case 23:
                    Ya0.H(this.a[i2], (List) Sb0.M(obj, iF2 & 1048575), interfaceC3812rc0, false);
                    break;
                case 24:
                    Ya0.R(this.a[i2], (List) Sb0.M(obj, iF2 & 1048575), interfaceC3812rc0, false);
                    break;
                case 25:
                    Ya0.U(this.a[i2], (List) Sb0.M(obj, iF2 & 1048575), interfaceC3812rc0, false);
                    break;
                case 26:
                    Ya0.d(this.a[i2], (List) Sb0.M(obj, iF2 & 1048575), interfaceC3812rc0);
                    break;
                case 27:
                    Ya0.e(this.a[i2], (List) Sb0.M(obj, iF2 & 1048575), interfaceC3812rc0, C(i2));
                    break;
                case 28:
                    Ya0.k(this.a[i2], (List) Sb0.M(obj, iF2 & 1048575), interfaceC3812rc0);
                    break;
                case 29:
                    Ya0.O(this.a[i2], (List) Sb0.M(obj, iF2 & 1048575), interfaceC3812rc0, false);
                    break;
                case 30:
                    Ya0.T(this.a[i2], (List) Sb0.M(obj, iF2 & 1048575), interfaceC3812rc0, false);
                    break;
                case 31:
                    Ya0.S(this.a[i2], (List) Sb0.M(obj, iF2 & 1048575), interfaceC3812rc0, false);
                    break;
                case 32:
                    Ya0.K(this.a[i2], (List) Sb0.M(obj, iF2 & 1048575), interfaceC3812rc0, false);
                    break;
                case 33:
                    Ya0.Q(this.a[i2], (List) Sb0.M(obj, iF2 & 1048575), interfaceC3812rc0, false);
                    break;
                case 34:
                    Ya0.F(this.a[i2], (List) Sb0.M(obj, iF2 & 1048575), interfaceC3812rc0, false);
                    break;
                case 35:
                    Ya0.f(this.a[i2], (List) Sb0.M(obj, iF2 & 1048575), interfaceC3812rc0, true);
                    break;
                case 36:
                    Ya0.m(this.a[i2], (List) Sb0.M(obj, iF2 & 1048575), interfaceC3812rc0, true);
                    break;
                case 37:
                    Ya0.r(this.a[i2], (List) Sb0.M(obj, iF2 & 1048575), interfaceC3812rc0, true);
                    break;
                case 38:
                    Ya0.x(this.a[i2], (List) Sb0.M(obj, iF2 & 1048575), interfaceC3812rc0, true);
                    break;
                case 39:
                    Ya0.M(this.a[i2], (List) Sb0.M(obj, iF2 & 1048575), interfaceC3812rc0, true);
                    break;
                case 40:
                    Ya0.H(this.a[i2], (List) Sb0.M(obj, iF2 & 1048575), interfaceC3812rc0, true);
                    break;
                case 41:
                    Ya0.R(this.a[i2], (List) Sb0.M(obj, iF2 & 1048575), interfaceC3812rc0, true);
                    break;
                case 42:
                    Ya0.U(this.a[i2], (List) Sb0.M(obj, iF2 & 1048575), interfaceC3812rc0, true);
                    break;
                case 43:
                    Ya0.O(this.a[i2], (List) Sb0.M(obj, iF2 & 1048575), interfaceC3812rc0, true);
                    break;
                case 44:
                    Ya0.T(this.a[i2], (List) Sb0.M(obj, iF2 & 1048575), interfaceC3812rc0, true);
                    break;
                case 45:
                    Ya0.S(this.a[i2], (List) Sb0.M(obj, iF2 & 1048575), interfaceC3812rc0, true);
                    break;
                case 46:
                    Ya0.K(this.a[i2], (List) Sb0.M(obj, iF2 & 1048575), interfaceC3812rc0, true);
                    break;
                case 47:
                    Ya0.Q(this.a[i2], (List) Sb0.M(obj, iF2 & 1048575), interfaceC3812rc0, true);
                    break;
                case 48:
                    Ya0.F(this.a[i2], (List) Sb0.M(obj, iF2 & 1048575), interfaceC3812rc0, true);
                    break;
                case 49:
                    Ya0.l(this.a[i2], (List) Sb0.M(obj, iF2 & 1048575), interfaceC3812rc0, C(i2));
                    break;
                case 50:
                    x(interfaceC3812rc0, i3, Sb0.M(obj, iF2 & 1048575), i2);
                    break;
                case 51:
                    if (z(obj, i3, i2)) {
                        dL = O(obj, iF2 & 1048575);
                        interfaceC3812rc0.r(i3, dL);
                    }
                    break;
                case 52:
                    if (z(obj, i3, i2)) {
                        fK = P(obj, iF2 & 1048575);
                        interfaceC3812rc0.s(i3, fK);
                    }
                    break;
                case 53:
                    if (z(obj, i3, i2)) {
                        jI = R(obj, iF2 & 1048575);
                        interfaceC3812rc0.I(i3, jI);
                    }
                    break;
                case 54:
                    if (z(obj, i3, i2)) {
                        jI2 = R(obj, iF2 & 1048575);
                        interfaceC3812rc0.q(i3, jI2);
                    }
                    break;
                case 55:
                    if (z(obj, i3, i2)) {
                        iH = Q(obj, iF2 & 1048575);
                        interfaceC3812rc0.k(i3, iH);
                    }
                    break;
                case 56:
                    if (z(obj, i3, i2)) {
                        jI3 = R(obj, iF2 & 1048575);
                        interfaceC3812rc0.l(i3, jI3);
                    }
                    break;
                case 57:
                    if (z(obj, i3, i2)) {
                        iH2 = Q(obj, iF2 & 1048575);
                        interfaceC3812rc0.u(i3, iH2);
                    }
                    break;
                case 58:
                    if (z(obj, i3, i2)) {
                        zJ = S(obj, iF2 & 1048575);
                        interfaceC3812rc0.j(i3, zJ);
                    }
                    break;
                case 59:
                    if (z(obj, i3, i2)) {
                        u(i3, Sb0.M(obj, iF2 & 1048575), interfaceC3812rc0);
                    }
                    break;
                case 60:
                    if (z(obj, i3, i2)) {
                        interfaceC3812rc0.J(i3, Sb0.M(obj, iF2 & 1048575), C(i2));
                    }
                    break;
                case 61:
                    if (z(obj, i3, i2)) {
                        interfaceC3812rc0.L(i3, (zzbb) Sb0.M(obj, iF2 & 1048575));
                    }
                    break;
                case 62:
                    if (z(obj, i3, i2)) {
                        iH3 = Q(obj, iF2 & 1048575);
                        interfaceC3812rc0.y(i3, iH3);
                    }
                    break;
                case 63:
                    if (z(obj, i3, i2)) {
                        iH4 = Q(obj, iF2 & 1048575);
                        interfaceC3812rc0.K(i3, iH4);
                    }
                    break;
                case 64:
                    if (z(obj, i3, i2)) {
                        iH5 = Q(obj, iF2 & 1048575);
                        interfaceC3812rc0.O(i3, iH5);
                    }
                    break;
                case 65:
                    if (z(obj, i3, i2)) {
                        jI4 = R(obj, iF2 & 1048575);
                        interfaceC3812rc0.C(i3, jI4);
                    }
                    break;
                case 66:
                    if (z(obj, i3, i2)) {
                        iH6 = Q(obj, iF2 & 1048575);
                        interfaceC3812rc0.A(i3, iH6);
                    }
                    break;
                case 67:
                    if (z(obj, i3, i2)) {
                        jI5 = R(obj, iF2 & 1048575);
                        interfaceC3812rc0.g(i3, jI5);
                    }
                    break;
                case 68:
                    if (z(obj, i3, i2)) {
                        interfaceC3812rc0.H(i3, Sb0.M(obj, iF2 & 1048575), C(i2));
                    }
                    break;
            }
        }
        while (entry != null) {
            this.q.d(interfaceC3812rc0, entry);
            entry = itE.hasNext() ? (Map.Entry) itE.next() : null;
        }
        w(this.p, obj, interfaceC3812rc0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x0163, code lost:
    
        if (r0 == r15) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0165, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0196, code lost:
    
        if (r0 == r15) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01af, code lost:
    
        if (r0 == r15) goto L74;
     */
    @Override // defpackage.Ta0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(java.lang.Object r23, byte[] r24, int r25, int r26, defpackage.S50 r27) throws com.google.android.gms.internal.clearcut.zzco {
        /*
            Method dump skipped, instruction units count: 516
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.C1917l.e(java.lang.Object, byte[], int, int, S50):void");
    }

    /* JADX WARN: Code duplicated, block: B:12:0x003a  */
    @Override // defpackage.Ta0
    public final boolean f(Object obj, Object obj2) {
        int length = this.a.length;
        int i = 0;
        while (true) {
            boolean zY = true;
            if (i >= length) {
                if (!this.p.k(obj).equals(this.p.k(obj2))) {
                    return false;
                }
                if (this.g) {
                    return this.q.b(obj).equals(this.q.b(obj2));
                }
                return true;
            }
            int iF = F(i);
            long j = iF & 1048575;
            switch ((iF & 267386880) >>> 20) {
                case 0:
                    if (!M(obj, obj2, i) || Sb0.I(obj, j) != Sb0.I(obj2, j)) {
                        zY = false;
                    }
                    break;
                case 1:
                    if (!M(obj, obj2, i) || Sb0.H(obj, j) != Sb0.H(obj2, j)) {
                        zY = false;
                    }
                    break;
                case 2:
                    if (!M(obj, obj2, i) || Sb0.I(obj, j) != Sb0.I(obj2, j)) {
                        zY = false;
                    }
                    break;
                case 3:
                    if (!M(obj, obj2, i) || Sb0.I(obj, j) != Sb0.I(obj2, j)) {
                        zY = false;
                    }
                    break;
                case 4:
                    if (!M(obj, obj2, i) || Sb0.H(obj, j) != Sb0.H(obj2, j)) {
                        zY = false;
                    }
                    break;
                case 5:
                    if (!M(obj, obj2, i) || Sb0.I(obj, j) != Sb0.I(obj2, j)) {
                        zY = false;
                    }
                    break;
                case 6:
                    if (!M(obj, obj2, i) || Sb0.H(obj, j) != Sb0.H(obj2, j)) {
                        zY = false;
                    }
                    break;
                case 7:
                    if (!M(obj, obj2, i) || Sb0.J(obj, j) != Sb0.J(obj2, j)) {
                        zY = false;
                    }
                    break;
                case 8:
                    if (!M(obj, obj2, i) || !Ya0.y(Sb0.M(obj, j), Sb0.M(obj2, j))) {
                        zY = false;
                    }
                    break;
                case 9:
                    if (!M(obj, obj2, i) || !Ya0.y(Sb0.M(obj, j), Sb0.M(obj2, j))) {
                        zY = false;
                    }
                    break;
                case 10:
                    if (!M(obj, obj2, i) || !Ya0.y(Sb0.M(obj, j), Sb0.M(obj2, j))) {
                        zY = false;
                    }
                    break;
                case 11:
                    if (!M(obj, obj2, i) || Sb0.H(obj, j) != Sb0.H(obj2, j)) {
                        zY = false;
                    }
                    break;
                case 12:
                    if (!M(obj, obj2, i) || Sb0.H(obj, j) != Sb0.H(obj2, j)) {
                        zY = false;
                    }
                    break;
                case 13:
                    if (!M(obj, obj2, i) || Sb0.H(obj, j) != Sb0.H(obj2, j)) {
                        zY = false;
                    }
                    break;
                case 14:
                    if (!M(obj, obj2, i) || Sb0.I(obj, j) != Sb0.I(obj2, j)) {
                        zY = false;
                    }
                    break;
                case 15:
                    if (!M(obj, obj2, i) || Sb0.H(obj, j) != Sb0.H(obj2, j)) {
                        zY = false;
                    }
                    break;
                case 16:
                    if (!M(obj, obj2, i) || Sb0.I(obj, j) != Sb0.I(obj2, j)) {
                        zY = false;
                    }
                    break;
                case 17:
                    if (!M(obj, obj2, i) || !Ya0.y(Sb0.M(obj, j), Sb0.M(obj2, j))) {
                        zY = false;
                    }
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                    zY = Ya0.y(Sb0.M(obj, j), Sb0.M(obj2, j));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long jG = G(i) & 1048575;
                    if (Sb0.H(obj, jG) != Sb0.H(obj2, jG) || !Ya0.y(Sb0.M(obj, j), Sb0.M(obj2, j))) {
                        zY = false;
                    }
                    break;
            }
            if (!zY) {
                return false;
            }
            i += 4;
        }
    }

    @Override // defpackage.Ta0
    public final Object g() {
        return this.n.a(this.f);
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:48:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:51:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:54:0x00c6 A[LOOP:1: B:49:0x00b5->B:54:0x00c6, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:72:0x00c5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:76:0x00da A[SYNTHETIC] */
    @Override // defpackage.Ta0
    public final boolean h(Object obj) {
        int i;
        List list;
        Ta0 ta0C;
        int i2;
        int[] iArr = this.k;
        int i3 = 1;
        if (iArr == null || iArr.length == 0) {
            return true;
        }
        int length = iArr.length;
        int i4 = -1;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            int i7 = iArr[i5];
            int iH = H(i7);
            int iF = F(iH);
            if (this.i) {
                i = 0;
            } else {
                int i8 = this.a[iH + 2];
                int i9 = i8 & 1048575;
                i = i3 << (i8 >>> 20);
                if (i9 != i4) {
                    i6 = s.getInt(obj, i9);
                    i4 = i9;
                }
            }
            if ((268435456 & iF) != 0 && !A(obj, iH, i6, i)) {
                return false;
            }
            int i10 = (267386880 & iF) >>> 20;
            if (i10 == 9 || i10 == 17) {
                if (A(obj, iH, i6, i) && !B(obj, iF, C(iH))) {
                    return false;
                }
            } else if (i10 == 27) {
                list = (List) Sb0.M(obj, iF & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    ta0C = C(iH);
                    for (i2 = 0; i2 < list.size(); i2++) {
                        if (!ta0C.h(list.get(i2))) {
                            return false;
                        }
                    }
                }
            } else if (i10 == 60 || i10 == 68) {
                if (z(obj, i7, iH) && !B(obj, iF, C(iH))) {
                    return false;
                }
            } else if (i10 == 49) {
                list = (List) Sb0.M(obj, iF & 1048575);
                if (list.isEmpty()) {
                    ta0C = C(iH);
                    while (i2 < list.size()) {
                        if (!ta0C.h(list.get(i2))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (i10 == 50 && !this.r.g(Sb0.M(obj, iF & 1048575)).isEmpty()) {
                this.r.d(D(iH));
                throw null;
            }
            i5++;
            length = length;
            i3 = 1;
        }
        return !this.g || this.q.b(obj).d();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:14:0x0039  */
    /* JADX WARN: Code duplicated, block: B:18:0x004a  */
    /* JADX WARN: Code duplicated, block: B:33:0x0073  */
    /* JADX WARN: Code duplicated, block: B:39:0x0087  */
    /* JADX WARN: Code duplicated, block: B:69:0x00f4 A[PHI: r3
      0x00f4: PHI (r3v9 java.lang.Object) = (r3v6 java.lang.Object), (r3v10 java.lang.Object) binds: [B:74:0x0110, B:68:0x00f2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:9:0x0026  */
    @Override // defpackage.Ta0
    public final int i(Object obj) {
        int i;
        double dL;
        float fK;
        boolean zJ;
        Object objM;
        int iH;
        long jI;
        Object objM2;
        int length = this.a.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 4) {
            int iF = F(i3);
            int i4 = this.a[i3];
            long j = 1048575 & iF;
            int iHashCode = 37;
            switch ((iF & 267386880) >>> 20) {
                case 0:
                    i = i2 * 53;
                    dL = Sb0.L(obj, j);
                    jI = Double.doubleToLongBits(dL);
                    iH = zzci.zzl(jI);
                    i2 = i + iH;
                    break;
                case 1:
                    i = i2 * 53;
                    fK = Sb0.K(obj, j);
                    iH = Float.floatToIntBits(fK);
                    i2 = i + iH;
                    break;
                case 2:
                case 3:
                case 5:
                case 14:
                case 16:
                    i = i2 * 53;
                    jI = Sb0.I(obj, j);
                    iH = zzci.zzl(jI);
                    i2 = i + iH;
                    break;
                case 4:
                case 6:
                case 11:
                case 12:
                case 13:
                case 15:
                    i = i2 * 53;
                    iH = Sb0.H(obj, j);
                    i2 = i + iH;
                    break;
                case 7:
                    i = i2 * 53;
                    zJ = Sb0.J(obj, j);
                    iH = zzci.zzc(zJ);
                    i2 = i + iH;
                    break;
                case 8:
                    i = i2 * 53;
                    iH = ((String) Sb0.M(obj, j)).hashCode();
                    i2 = i + iH;
                    break;
                case 9:
                    objM = Sb0.M(obj, j);
                    if (objM != null) {
                        iHashCode = objM.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 10:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                    i = i2 * 53;
                    objM2 = Sb0.M(obj, j);
                    iH = objM2.hashCode();
                    i2 = i + iH;
                    break;
                case 17:
                    objM = Sb0.M(obj, j);
                    if (objM != null) {
                        iHashCode = objM.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 51:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        dL = O(obj, j);
                        jI = Double.doubleToLongBits(dL);
                        iH = zzci.zzl(jI);
                        i2 = i + iH;
                    }
                    break;
                case 52:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        fK = P(obj, j);
                        iH = Float.floatToIntBits(fK);
                        i2 = i + iH;
                    }
                    break;
                case 53:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        jI = R(obj, j);
                        iH = zzci.zzl(jI);
                        i2 = i + iH;
                    }
                    break;
                case 54:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        jI = R(obj, j);
                        iH = zzci.zzl(jI);
                        i2 = i + iH;
                    }
                    break;
                case 55:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        iH = Q(obj, j);
                        i2 = i + iH;
                    }
                    break;
                case 56:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        jI = R(obj, j);
                        iH = zzci.zzl(jI);
                        i2 = i + iH;
                    }
                    break;
                case 57:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        iH = Q(obj, j);
                        i2 = i + iH;
                    }
                    break;
                case 58:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        zJ = S(obj, j);
                        iH = zzci.zzc(zJ);
                        i2 = i + iH;
                    }
                    break;
                case 59:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        iH = ((String) Sb0.M(obj, j)).hashCode();
                        i2 = i + iH;
                    }
                    break;
                case 60:
                    if (z(obj, i4, i3)) {
                        objM2 = Sb0.M(obj, j);
                        i = i2 * 53;
                        iH = objM2.hashCode();
                        i2 = i + iH;
                    }
                    break;
                case 61:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        objM2 = Sb0.M(obj, j);
                        iH = objM2.hashCode();
                        i2 = i + iH;
                    }
                    break;
                case 62:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        iH = Q(obj, j);
                        i2 = i + iH;
                    }
                    break;
                case 63:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        iH = Q(obj, j);
                        i2 = i + iH;
                    }
                    break;
                case 64:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        iH = Q(obj, j);
                        i2 = i + iH;
                    }
                    break;
                case 65:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        jI = R(obj, j);
                        iH = zzci.zzl(jI);
                        i2 = i + iH;
                    }
                    break;
                case 66:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        iH = Q(obj, j);
                        i2 = i + iH;
                    }
                    break;
                case 67:
                    if (z(obj, i4, i3)) {
                        i = i2 * 53;
                        jI = R(obj, j);
                        iH = zzci.zzl(jI);
                        i2 = i + iH;
                    }
                    break;
                case 68:
                    if (z(obj, i4, i3)) {
                        objM2 = Sb0.M(obj, j);
                        i = i2 * 53;
                        iH = objM2.hashCode();
                        i2 = i + iH;
                    }
                    break;
            }
        }
        int iHashCode2 = (i2 * 53) + this.p.k(obj).hashCode();
        return this.g ? (iHashCode2 * 53) + this.q.b(obj).hashCode() : iHashCode2;
    }

    public final int k(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, S50 s50) throws zzco {
        Object objValueOf;
        Object objValueOf2;
        int iG;
        long jZza;
        int iZzm;
        Object objValueOf3;
        int i9;
        Unsafe unsafe = s;
        long j2 = this.a[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 != 1) {
                    return i;
                }
                objValueOf = Double.valueOf(AbstractC1912g.l(bArr, i));
                unsafe.putObject(obj, j, objValueOf);
                iG = i + 8;
                unsafe.putInt(obj, j2, i4);
                return iG;
            case 52:
                if (i5 != 5) {
                    return i;
                }
                objValueOf2 = Float.valueOf(AbstractC1912g.n(bArr, i));
                unsafe.putObject(obj, j, objValueOf2);
                iG = i + 4;
                unsafe.putInt(obj, j2, i4);
                return iG;
            case 53:
            case 54:
                if (i5 != 0) {
                    return i;
                }
                iG = AbstractC1912g.g(bArr, i, s50);
                jZza = s50.b;
                objValueOf3 = Long.valueOf(jZza);
                unsafe.putObject(obj, j, objValueOf3);
                unsafe.putInt(obj, j2, i4);
                return iG;
            case 55:
            case 62:
                if (i5 != 0) {
                    return i;
                }
                iG = AbstractC1912g.f(bArr, i, s50);
                iZzm = s50.a;
                objValueOf3 = Integer.valueOf(iZzm);
                unsafe.putObject(obj, j, objValueOf3);
                unsafe.putInt(obj, j2, i4);
                return iG;
            case 56:
            case 65:
                if (i5 != 1) {
                    return i;
                }
                objValueOf = Long.valueOf(AbstractC1912g.k(bArr, i));
                unsafe.putObject(obj, j, objValueOf);
                iG = i + 8;
                unsafe.putInt(obj, j2, i4);
                return iG;
            case 57:
            case 64:
                if (i5 != 5) {
                    return i;
                }
                objValueOf2 = Integer.valueOf(AbstractC1912g.h(bArr, i));
                unsafe.putObject(obj, j, objValueOf2);
                iG = i + 4;
                unsafe.putInt(obj, j2, i4);
                return iG;
            case 58:
                if (i5 != 0) {
                    return i;
                }
                iG = AbstractC1912g.g(bArr, i, s50);
                objValueOf3 = Boolean.valueOf(s50.b != 0);
                unsafe.putObject(obj, j, objValueOf3);
                unsafe.putInt(obj, j2, i4);
                return iG;
            case 59:
                if (i5 != 2) {
                    return i;
                }
                iG = AbstractC1912g.f(bArr, i, s50);
                i9 = s50.a;
                if (i9 == 0) {
                    objValueOf3 = "";
                    unsafe.putObject(obj, j, objValueOf3);
                    unsafe.putInt(obj, j2, i4);
                    return iG;
                }
                if ((i6 & PropertyOptions.DELETE_EXISTING) != 0 && !Xb0.i(bArr, iG, iG + i9)) {
                    throw zzco.zzbp();
                }
                unsafe.putObject(obj, j, new String(bArr, iG, i9, zzci.UTF_8));
                iG += i9;
                unsafe.putInt(obj, j2, i4);
                return iG;
            case 60:
                if (i5 != 2) {
                    return i;
                }
                iG = q(C(i8), bArr, i, i2, s50);
                Object object = unsafe.getInt(obj, j2) == i4 ? unsafe.getObject(obj, j) : null;
                objValueOf3 = s50.c;
                if (object != null) {
                    objValueOf3 = zzci.zza(object, objValueOf3);
                }
                unsafe.putObject(obj, j, objValueOf3);
                unsafe.putInt(obj, j2, i4);
                return iG;
            case 61:
                if (i5 != 2) {
                    return i;
                }
                iG = AbstractC1912g.f(bArr, i, s50);
                i9 = s50.a;
                if (i9 == 0) {
                    objValueOf3 = zzbb.zzfi;
                    unsafe.putObject(obj, j, objValueOf3);
                    unsafe.putInt(obj, j2, i4);
                    return iG;
                }
                unsafe.putObject(obj, j, zzbb.zzb(bArr, iG, i9));
                iG += i9;
                unsafe.putInt(obj, j2, i4);
                return iG;
            case 63:
                if (i5 != 0) {
                    return i;
                }
                int iF = AbstractC1912g.f(bArr, i, s50);
                int i10 = s50.a;
                zzck zzckVarE = E(i8);
                if (zzckVarE != null && zzckVarE.zzb(i10) == null) {
                    T(obj).zzb(i3, Long.valueOf(i10));
                    return iF;
                }
                unsafe.putObject(obj, j, Integer.valueOf(i10));
                iG = iF;
                unsafe.putInt(obj, j2, i4);
                return iG;
            case 66:
                if (i5 != 0) {
                    return i;
                }
                iG = AbstractC1912g.f(bArr, i, s50);
                iZzm = zzbk.zzm(s50.a);
                objValueOf3 = Integer.valueOf(iZzm);
                unsafe.putObject(obj, j, objValueOf3);
                unsafe.putInt(obj, j2, i4);
                return iG;
            case 67:
                if (i5 != 0) {
                    return i;
                }
                iG = AbstractC1912g.g(bArr, i, s50);
                jZza = zzbk.zza(s50.b);
                objValueOf3 = Long.valueOf(jZza);
                unsafe.putObject(obj, j, objValueOf3);
                unsafe.putInt(obj, j2, i4);
                return iG;
            case 68:
                if (i5 != 3) {
                    return i;
                }
                iG = p(C(i8), bArr, i, i2, (i3 & (-8)) | 4, s50);
                Object object2 = unsafe.getInt(obj, j2) == i4 ? unsafe.getObject(obj, j) : null;
                objValueOf3 = s50.c;
                if (object2 != null) {
                    objValueOf3 = zzci.zza(object2, objValueOf3);
                }
                unsafe.putObject(obj, j, objValueOf3);
                unsafe.putInt(obj, j2, i4);
                return iG;
            default:
                return i;
        }
    }

    /* JADX WARN: Code duplicated, block: B:219:0x018e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:85:0x019f  */
    /* JADX WARN: Code duplicated, block: B:87:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:90:0x01b0  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:102:0x01e3 -> B:93:0x01bc). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:72:0x015a -> B:66:0x013c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:88:0x01ad -> B:81:0x018e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final int l(java.lang.Object r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, defpackage.S50 r29) throws com.google.android.gms.internal.clearcut.zzco {
        /*
            Method dump skipped, instruction units count: 892
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.C1917l.l(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, S50):int");
    }

    public final int m(Object obj, byte[] bArr, int i, int i2, int i3, int i4, long j, S50 s50) throws zzco {
        Unsafe unsafe = s;
        Object objD = D(i3);
        Object object = unsafe.getObject(obj, j);
        if (this.r.b(object)) {
            Object objA = this.r.a(objD);
            this.r.c(objA, object);
            unsafe.putObject(obj, j, objA);
            object = objA;
        }
        this.r.d(objD);
        this.r.h(object);
        int iF = AbstractC1912g.f(bArr, i, s50);
        int i5 = s50.a;
        if (i5 < 0 || i5 > i2 - iF) {
            throw zzco.zzbl();
        }
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:123:0x02ef A[PHI: r0 r19 r26 r27
      0x02ef: PHI (r0v30 int) = (r0v25 int), (r0v28 int), (r0v32 int) binds: [B:135:0x035c, B:132:0x0341, B:122:0x02ed] A[DONT_GENERATE, DONT_INLINE]
      0x02ef: PHI (r19v6 int) = (r19v4 int), (r19v4 int), (r19v7 int) binds: [B:135:0x035c, B:132:0x0341, B:122:0x02ed] A[DONT_GENERATE, DONT_INLINE]
      0x02ef: PHI (r26v6 int) = (r26v4 int), (r26v4 int), (r26v7 int) binds: [B:135:0x035c, B:132:0x0341, B:122:0x02ed] A[DONT_GENERATE, DONT_INLINE]
      0x02ef: PHI (r27v9 sun.misc.Unsafe) = (r27v7 sun.misc.Unsafe), (r27v7 sun.misc.Unsafe), (r27v10 sun.misc.Unsafe) binds: [B:135:0x035c, B:132:0x0341, B:122:0x02ed] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:125:0x02fa A[PHI: r0 r19 r26 r27
      0x02fa: PHI (r0v29 int) = (r0v25 int), (r0v28 int), (r0v32 int) binds: [B:135:0x035c, B:132:0x0341, B:122:0x02ed] A[DONT_GENERATE, DONT_INLINE]
      0x02fa: PHI (r19v5 int) = (r19v4 int), (r19v4 int), (r19v7 int) binds: [B:135:0x035c, B:132:0x0341, B:122:0x02ed] A[DONT_GENERATE, DONT_INLINE]
      0x02fa: PHI (r26v5 int) = (r26v4 int), (r26v4 int), (r26v7 int) binds: [B:135:0x035c, B:132:0x0341, B:122:0x02ed] A[DONT_GENERATE, DONT_INLINE]
      0x02fa: PHI (r27v8 sun.misc.Unsafe) = (r27v7 sun.misc.Unsafe), (r27v7 sun.misc.Unsafe), (r27v10 sun.misc.Unsafe) binds: [B:135:0x035c, B:132:0x0341, B:122:0x02ed] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:140:0x036e A[ADDED_TO_REGION] */
    /* JADX WARN: Failed to find 'out' block for switch in B:21:0x006c. Please report as an issue. */
    public final int n(Object obj, byte[] bArr, int i, int i2, int i3, S50 s50) throws zzco {
        Unsafe unsafe;
        int i4;
        int i5;
        int i6;
        int i7;
        Object obj2;
        zzck zzckVarE;
        int i8;
        int iD;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        long j;
        Object objZza;
        this = this;
        obj = obj;
        bArr = bArr;
        i2 = i2;
        s50 = s50;
        Unsafe unsafe2 = s;
        int i18 = -1;
        int iJ = i;
        int i19 = 0;
        int i20 = 0;
        int i21 = -1;
        while (true) {
            if (iJ < i2) {
                int i22 = iJ + 1;
                byte b = bArr[iJ];
                if (b < 0) {
                    iD = AbstractC1912g.d(b, bArr, i22, s50);
                    i8 = s50.a;
                } else {
                    i8 = b;
                    iD = i22;
                }
                int i23 = i8 >>> 3;
                int i24 = i8 & 7;
                int iH = this.H(i23);
                if (iH != i18) {
                    int[] iArr = this.a;
                    int i25 = iArr[iH + 1];
                    int i26 = (i25 & 267386880) >>> 20;
                    long j2 = i25 & 1048575;
                    int i27 = i8;
                    if (i26 <= 17) {
                        int i28 = iArr[iH + 2];
                        int i29 = 1 << (i28 >>> 20);
                        int i30 = i28 & 1048575;
                        if (i30 != i21) {
                            if (i21 != -1) {
                                unsafe2.putInt(obj, i21, i20);
                            }
                            i21 = i30;
                            i20 = unsafe2.getInt(obj, i30);
                        }
                        switch (i26) {
                            case 0:
                                bArr = bArr;
                                i15 = i27;
                                i16 = i21;
                                i17 = iD;
                                if (i24 == 1) {
                                    Sb0.e(obj, j2, AbstractC1912g.l(bArr, i17));
                                    iJ = i17 + 8;
                                    i20 |= i29;
                                    i19 = i15;
                                    i21 = i16;
                                    i2 = i2;
                                    i18 = -1;
                                }
                                i13 = i17;
                                unsafe = unsafe2;
                                i14 = i15;
                                i21 = i16;
                                i3 = i3;
                                if (i14 == i3 || i3 == 0) {
                                    iJ = j(i14, bArr, i13, i2, obj, s50);
                                    i19 = i14;
                                    unsafe2 = unsafe;
                                    i18 = -1;
                                } else {
                                    i7 = i20;
                                    i6 = i21;
                                    i4 = i13;
                                    i5 = i14;
                                }
                                break;
                            case 1:
                                i2 = i2;
                                bArr = bArr;
                                i15 = i27;
                                i16 = i21;
                                i17 = iD;
                                if (i24 == 5) {
                                    Sb0.f(obj, j2, AbstractC1912g.n(bArr, i17));
                                    iJ = i17 + 4;
                                    i20 |= i29;
                                    i19 = i15;
                                    i21 = i16;
                                    i2 = i2;
                                    i18 = -1;
                                }
                                i13 = i17;
                                unsafe = unsafe2;
                                i14 = i15;
                                i21 = i16;
                                i3 = i3;
                                if (i14 == i3) {
                                }
                                iJ = j(i14, bArr, i13, i2, obj, s50);
                                i19 = i14;
                                unsafe2 = unsafe;
                                i18 = -1;
                                break;
                            case 2:
                            case 3:
                                i2 = i2;
                                bArr = bArr;
                                i15 = i27;
                                i16 = i21;
                                i17 = iD;
                                if (i24 == 0) {
                                    int iG = AbstractC1912g.g(bArr, i17, s50);
                                    unsafe2.putLong(obj, j2, s50.b);
                                    i20 |= i29;
                                    iJ = iG;
                                    i19 = i15;
                                    i21 = i16;
                                    i2 = i2;
                                    i18 = -1;
                                }
                                i13 = i17;
                                unsafe = unsafe2;
                                i14 = i15;
                                i21 = i16;
                                i3 = i3;
                                if (i14 == i3) {
                                }
                                iJ = j(i14, bArr, i13, i2, obj, s50);
                                i19 = i14;
                                unsafe2 = unsafe;
                                i18 = -1;
                                break;
                            case 4:
                            case 11:
                                i2 = i2;
                                bArr = bArr;
                                i15 = i27;
                                i16 = i21;
                                i17 = iD;
                                if (i24 == 0) {
                                    iJ = AbstractC1912g.f(bArr, i17, s50);
                                    unsafe2.putInt(obj, j2, s50.a);
                                    i20 |= i29;
                                    i19 = i15;
                                    i21 = i16;
                                    i2 = i2;
                                    i18 = -1;
                                }
                                i13 = i17;
                                unsafe = unsafe2;
                                i14 = i15;
                                i21 = i16;
                                i3 = i3;
                                if (i14 == i3) {
                                }
                                iJ = j(i14, bArr, i13, i2, obj, s50);
                                i19 = i14;
                                unsafe2 = unsafe;
                                i18 = -1;
                                break;
                            case 5:
                            case 14:
                                i15 = i27;
                                bArr = bArr;
                                if (i24 == 1) {
                                    i16 = i21;
                                    i17 = iD;
                                    unsafe2.putLong(obj, j2, AbstractC1912g.k(bArr, iD));
                                    iJ = i17 + 8;
                                    i20 |= i29;
                                    i19 = i15;
                                    i21 = i16;
                                    i2 = i2;
                                    i18 = -1;
                                }
                                i16 = i21;
                                i17 = iD;
                                i13 = i17;
                                unsafe = unsafe2;
                                i14 = i15;
                                i21 = i16;
                                i3 = i3;
                                if (i14 == i3) {
                                }
                                iJ = j(i14, bArr, i13, i2, obj, s50);
                                i19 = i14;
                                unsafe2 = unsafe;
                                i18 = -1;
                                break;
                            case 6:
                            case 13:
                                i2 = i2;
                                i15 = i27;
                                bArr = bArr;
                                if (i24 == 5) {
                                    unsafe2.putInt(obj, j2, AbstractC1912g.h(bArr, iD));
                                    iJ = iD + 4;
                                    i20 |= i29;
                                    i19 = i15;
                                    i2 = i2;
                                    i18 = -1;
                                }
                                i16 = i21;
                                i17 = iD;
                                i13 = i17;
                                unsafe = unsafe2;
                                i14 = i15;
                                i21 = i16;
                                i3 = i3;
                                if (i14 == i3) {
                                }
                                iJ = j(i14, bArr, i13, i2, obj, s50);
                                i19 = i14;
                                unsafe2 = unsafe;
                                i18 = -1;
                                break;
                            case 7:
                                i2 = i2;
                                i15 = i27;
                                bArr = bArr;
                                if (i24 == 0) {
                                    iJ = AbstractC1912g.g(bArr, iD, s50);
                                    Sb0.j(obj, j2, s50.b != 0);
                                    i20 |= i29;
                                    i19 = i15;
                                    i2 = i2;
                                    i18 = -1;
                                }
                                i16 = i21;
                                i17 = iD;
                                i13 = i17;
                                unsafe = unsafe2;
                                i14 = i15;
                                i21 = i16;
                                i3 = i3;
                                if (i14 == i3) {
                                }
                                iJ = j(i14, bArr, i13, i2, obj, s50);
                                i19 = i14;
                                unsafe2 = unsafe;
                                i18 = -1;
                                break;
                            case 8:
                                i2 = i2;
                                j = j2;
                                i15 = i27;
                                bArr = bArr;
                                if (i24 == 2) {
                                    iJ = (i25 & PropertyOptions.DELETE_EXISTING) == 0 ? AbstractC1912g.i(bArr, iD, s50) : AbstractC1912g.j(bArr, iD, s50);
                                    objZza = s50.c;
                                    unsafe2.putObject(obj, j, objZza);
                                    i20 |= i29;
                                    i19 = i15;
                                    i2 = i2;
                                    i18 = -1;
                                }
                                i16 = i21;
                                i17 = iD;
                                i13 = i17;
                                unsafe = unsafe2;
                                i14 = i15;
                                i21 = i16;
                                i3 = i3;
                                if (i14 == i3) {
                                }
                                iJ = j(i14, bArr, i13, i2, obj, s50);
                                i19 = i14;
                                unsafe2 = unsafe;
                                i18 = -1;
                                break;
                            case 9:
                                j = j2;
                                i15 = i27;
                                bArr = bArr;
                                if (i24 == 2) {
                                    i2 = i2;
                                    iJ = q(this.C(iH), bArr, iD, i2, s50);
                                    objZza = (i20 & i29) == 0 ? s50.c : zzci.zza(unsafe2.getObject(obj, j), s50.c);
                                    unsafe2.putObject(obj, j, objZza);
                                    i20 |= i29;
                                    i19 = i15;
                                    i2 = i2;
                                    i18 = -1;
                                }
                                i16 = i21;
                                i17 = iD;
                                i13 = i17;
                                unsafe = unsafe2;
                                i14 = i15;
                                i21 = i16;
                                i3 = i3;
                                if (i14 == i3) {
                                }
                                iJ = j(i14, bArr, i13, i2, obj, s50);
                                i19 = i14;
                                unsafe2 = unsafe;
                                i18 = -1;
                                break;
                            case 10:
                                i15 = i27;
                                bArr = bArr;
                                if (i24 == 2) {
                                    iJ = AbstractC1912g.m(bArr, iD, s50);
                                    unsafe2.putObject(obj, j2, s50.c);
                                    i20 |= i29;
                                    i19 = i15;
                                } else {
                                    i16 = i21;
                                    i17 = iD;
                                    i13 = i17;
                                    unsafe = unsafe2;
                                    i14 = i15;
                                    i21 = i16;
                                    i3 = i3;
                                    if (i14 == i3) {
                                    }
                                    iJ = j(i14, bArr, i13, i2, obj, s50);
                                    i19 = i14;
                                    unsafe2 = unsafe;
                                    i18 = -1;
                                }
                                break;
                            case 12:
                                bArr = bArr;
                                if (i24 == 0) {
                                    iJ = AbstractC1912g.f(bArr, iD, s50);
                                    int i31 = s50.a;
                                    zzck zzckVarE2 = this.E(iH);
                                    if (zzckVarE2 == null || zzckVarE2.zzb(i31) != null) {
                                        i15 = i27;
                                        unsafe2.putInt(obj, j2, i31);
                                        i20 |= i29;
                                    } else {
                                        i15 = i27;
                                        T(obj).zzb(i15, Long.valueOf(i31));
                                    }
                                    i19 = i15;
                                } else {
                                    i15 = i27;
                                    i16 = i21;
                                    i17 = iD;
                                    i13 = i17;
                                    unsafe = unsafe2;
                                    i14 = i15;
                                    i21 = i16;
                                    i3 = i3;
                                    if (i14 == i3) {
                                    }
                                    iJ = j(i14, bArr, i13, i2, obj, s50);
                                    i19 = i14;
                                    unsafe2 = unsafe;
                                    i18 = -1;
                                }
                                break;
                            case 15:
                                bArr = bArr;
                                if (i24 == 0) {
                                    iJ = AbstractC1912g.f(bArr, iD, s50);
                                    unsafe2.putInt(obj, j2, zzbk.zzm(s50.a));
                                    i20 |= i29;
                                    i19 = i27;
                                    i18 = -1;
                                }
                                i15 = i27;
                                i16 = i21;
                                i17 = iD;
                                i13 = i17;
                                unsafe = unsafe2;
                                i14 = i15;
                                i21 = i16;
                                i3 = i3;
                                if (i14 == i3) {
                                }
                                iJ = j(i14, bArr, i13, i2, obj, s50);
                                i19 = i14;
                                unsafe2 = unsafe;
                                i18 = -1;
                                break;
                            case 16:
                                if (i24 == 0) {
                                    bArr = bArr;
                                    int iG2 = AbstractC1912g.g(bArr, iD, s50);
                                    unsafe2.putLong(obj, j2, zzbk.zza(s50.b));
                                    i20 |= i29;
                                    iJ = iG2;
                                    i19 = i27;
                                    i18 = -1;
                                }
                                i15 = i27;
                                i16 = i21;
                                i17 = iD;
                                i13 = i17;
                                unsafe = unsafe2;
                                i14 = i15;
                                i21 = i16;
                                i3 = i3;
                                if (i14 == i3) {
                                }
                                iJ = j(i14, bArr, i13, i2, obj, s50);
                                i19 = i14;
                                unsafe2 = unsafe;
                                i18 = -1;
                                break;
                            case 17:
                                if (i24 == 3) {
                                    iJ = p(this.C(iH), bArr, iD, i2, (i23 << 3) | 4, s50);
                                    unsafe2.putObject(obj, j2, (i20 & i29) == 0 ? s50.c : zzci.zza(unsafe2.getObject(obj, j2), s50.c));
                                    i20 |= i29;
                                    bArr = bArr;
                                    i19 = i27;
                                    i18 = -1;
                                } else {
                                    i15 = i27;
                                    i16 = i21;
                                    i17 = iD;
                                    i13 = i17;
                                    unsafe = unsafe2;
                                    i14 = i15;
                                    i21 = i16;
                                    i3 = i3;
                                    if (i14 == i3) {
                                    }
                                    iJ = j(i14, bArr, i13, i2, obj, s50);
                                    i19 = i14;
                                    unsafe2 = unsafe;
                                    i18 = -1;
                                }
                                break;
                            default:
                                i15 = i27;
                                i16 = i21;
                                i17 = iD;
                                i13 = i17;
                                unsafe = unsafe2;
                                i14 = i15;
                                i21 = i16;
                                i3 = i3;
                                if (i14 == i3) {
                                }
                                iJ = j(i14, bArr, i13, i2, obj, s50);
                                i19 = i14;
                                unsafe2 = unsafe;
                                i18 = -1;
                                break;
                        }
                    } else {
                        bArr = bArr;
                        i12 = i21;
                        int i32 = iD;
                        if (i26 != 27) {
                            if (i26 <= 49) {
                                i11 = i20;
                                unsafe = unsafe2;
                                i10 = i27;
                                iJ = l(obj, bArr, i32, i2, i27, i23, i24, iH, i25, i26, j2, s50);
                                if (iJ == i32) {
                                    i13 = iJ;
                                    i21 = i12;
                                    i14 = i10;
                                    i20 = i11;
                                    if (i14 == i3) {
                                    }
                                    iJ = j(i14, bArr, i13, i2, obj, s50);
                                    i19 = i14;
                                } else {
                                    i21 = i12;
                                    i19 = i10;
                                    i20 = i11;
                                }
                                unsafe2 = unsafe;
                            } else {
                                i11 = i20;
                                i9 = i32;
                                unsafe = unsafe2;
                                i10 = i27;
                                if (i26 == 50) {
                                    if (i24 == 2) {
                                        iJ = m(obj, bArr, i9, i2, iH, i23, j2, s50);
                                        if (iJ == i9) {
                                            i13 = iJ;
                                        } else {
                                            i21 = i12;
                                            i19 = i10;
                                            i20 = i11;
                                        }
                                        unsafe2 = unsafe;
                                    }
                                    i21 = i12;
                                    i14 = i10;
                                    i20 = i11;
                                    if (i14 == i3) {
                                    }
                                    iJ = j(i14, bArr, i13, i2, obj, s50);
                                    i19 = i14;
                                    unsafe2 = unsafe;
                                } else {
                                    iJ = k(obj, bArr, i9, i2, i10, i23, i24, i25, i26, j2, iH, s50);
                                    if (iJ == i9) {
                                        i13 = iJ;
                                        i21 = i12;
                                        i14 = i10;
                                        i20 = i11;
                                        if (i14 == i3) {
                                        }
                                        iJ = j(i14, bArr, i13, i2, obj, s50);
                                        i19 = i14;
                                    } else {
                                        i21 = i12;
                                        i19 = i10;
                                        i20 = i11;
                                    }
                                    unsafe2 = unsafe;
                                }
                            }
                            i18 = -1;
                        } else if (i24 == 2) {
                            zzcn zzcnVarZzi = (zzcn) unsafe2.getObject(obj, j2);
                            if (!zzcnVarZzi.zzu()) {
                                int size = zzcnVarZzi.size();
                                zzcnVarZzi = zzcnVarZzi.zzi(size == 0 ? 10 : size << 1);
                                unsafe2.putObject(obj, j2, zzcnVarZzi);
                            }
                            i19 = i27;
                            iJ = o(this.C(iH), i19, bArr, i32, i2, zzcnVarZzi, s50);
                            i21 = i12;
                        } else {
                            i11 = i20;
                            i9 = i32;
                            unsafe = unsafe2;
                            i10 = i27;
                        }
                    }
                    i18 = -1;
                    i2 = i2;
                } else {
                    i9 = iD;
                    i10 = i8;
                    i11 = i20;
                    i12 = i21;
                    unsafe = unsafe2;
                }
                i13 = i9;
                i21 = i12;
                i14 = i10;
                i20 = i11;
                if (i14 == i3) {
                }
                iJ = j(i14, bArr, i13, i2, obj, s50);
                i19 = i14;
                unsafe2 = unsafe;
                i18 = -1;
            } else {
                int i33 = i20;
                int i34 = i21;
                unsafe = unsafe2;
                i3 = i3;
                i4 = iJ;
                i5 = i19;
                i6 = i34;
                i7 = i33;
            }
        }
        if (i6 != -1) {
            obj2 = obj;
            unsafe.putInt(obj2, i6, i7);
        } else {
            obj2 = obj;
        }
        int[] iArr2 = this.l;
        if (iArr2 != null) {
            Object objT = null;
            for (int i35 : iArr2) {
                Bb0 bb0 = this.p;
                int i36 = this.a[i35];
                Object objM = Sb0.M(obj2, F(i35) & 1048575);
                if (objM != null && (zzckVarE = E(i35)) != null) {
                    objT = t(i35, i36, this.r.h(objM), zzckVarE, objT, bb0);
                }
                objT = (zzey) objT;
            }
            if (objT != null) {
                this.p.h(obj2, objT);
            }
        }
        if (i3 == 0) {
            if (i4 != i2) {
                throw zzco.zzbo();
            }
        } else if (i4 > i2 || i5 != i3) {
            throw zzco.zzbo();
        }
        return i4;
    }

    public final Object t(int i, int i2, Map map, zzck zzckVar, Object obj, Bb0 bb0) {
        this.r.d(D(i));
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (zzckVar.zzb(((Integer) entry.getValue()).intValue()) == null) {
                if (obj == null) {
                    obj = bb0.f();
                }
                E60 e60Zzk = zzbb.zzk(zzdg.zza(null, entry.getKey(), entry.getValue()));
                try {
                    zzdg.zza(e60Zzk.b(), null, entry.getKey(), entry.getValue());
                    bb0.b(obj, i2, e60Zzk.a());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return obj;
    }

    public final void v(Object obj, Object obj2, int i) {
        long jF = F(i) & 1048575;
        if (y(obj2, i)) {
            Object objM = Sb0.M(obj, jF);
            Object objM2 = Sb0.M(obj2, jF);
            if (objM != null && objM2 != null) {
                Sb0.i(obj, jF, zzci.zza(objM, objM2));
                I(obj, i);
            } else if (objM2 != null) {
                Sb0.i(obj, jF, objM2);
                I(obj, i);
            }
        }
    }

    public final void x(InterfaceC3812rc0 interfaceC3812rc0, int i, Object obj, int i2) {
        if (obj != null) {
            this.r.d(D(i2));
            interfaceC3812rc0.E(i, null, this.r.g(obj));
        }
    }

    public final boolean y(Object obj, int i) {
        if (!this.i) {
            int iG = G(i);
            return (Sb0.H(obj, (long) (iG & 1048575)) & (1 << (iG >>> 20))) != 0;
        }
        int iF = F(i);
        long j = iF & 1048575;
        switch ((iF & 267386880) >>> 20) {
            case 0:
                return Sb0.L(obj, j) != 0.0d;
            case 1:
                return Sb0.K(obj, j) != 0.0f;
            case 2:
                return Sb0.I(obj, j) != 0;
            case 3:
                return Sb0.I(obj, j) != 0;
            case 4:
                return Sb0.H(obj, j) != 0;
            case 5:
                return Sb0.I(obj, j) != 0;
            case 6:
                return Sb0.H(obj, j) != 0;
            case 7:
                return Sb0.J(obj, j);
            case 8:
                Object objM = Sb0.M(obj, j);
                if (objM instanceof String) {
                    return !((String) objM).isEmpty();
                }
                if (objM instanceof zzbb) {
                    return !zzbb.zzfi.equals(objM);
                }
                throw new IllegalArgumentException();
            case 9:
                return Sb0.M(obj, j) != null;
            case 10:
                return !zzbb.zzfi.equals(Sb0.M(obj, j));
            case 11:
                return Sb0.H(obj, j) != 0;
            case 12:
                return Sb0.H(obj, j) != 0;
            case 13:
                return Sb0.H(obj, j) != 0;
            case 14:
                return Sb0.I(obj, j) != 0;
            case 15:
                return Sb0.H(obj, j) != 0;
            case 16:
                return Sb0.I(obj, j) != 0;
            case 17:
                return Sb0.M(obj, j) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    public final boolean z(Object obj, int i, int i2) {
        return Sb0.H(obj, (long) (G(i2) & 1048575)) == i;
    }
}
