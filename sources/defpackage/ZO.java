package defpackage;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class ZO extends AbstractC3272l0 implements CC, InterfaceC0939Tm, InterfaceC1826bq {
    public final int e;
    public final int f;
    public final I8 g;
    public Object[] h;
    public long i;
    public long j;
    public int k;
    public int l;

    public static final class a implements InterfaceC0745Mj {
        public final ZO a;
        public long b;
        public final Object c;
        public final InterfaceC0793Of d;

        public a(ZO zo, long j, Object obj, InterfaceC0793Of interfaceC0793Of) {
            this.a = zo;
            this.b = j;
            this.c = obj;
            this.d = interfaceC0793Of;
        }

        @Override // defpackage.InterfaceC0745Mj
        public void dispose() {
            this.a.y(this);
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[I8.values().length];
            iArr[I8.SUSPEND.ordinal()] = 1;
            iArr[I8.DROP_LATEST.ordinal()] = 2;
            iArr[I8.DROP_OLDEST.ordinal()] = 3;
            a = iArr;
        }
    }

    public static final class c extends AbstractC0819Pf {
        public Object a;
        public Object b;
        public Object c;
        public Object d;
        public /* synthetic */ Object e;
        public int g;

        public c(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= Integer.MIN_VALUE;
            return ZO.A(ZO.this, null, this);
        }
    }

    public ZO(int i, int i2, I8 i8) {
        this.e = i;
        this.f = i2;
        this.g = i8;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static /* synthetic */ Object A(ZO zo, InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        c cVar;
        ZO zo2;
        Throwable th;
        C1790bP c1790bP;
        InterfaceC0995Vm interfaceC0995Vm2;
        InterfaceC1830bu interfaceC1830bu;
        if (interfaceC0793Of instanceof c) {
            cVar = (c) interfaceC0793Of;
            int i = cVar.g;
            if ((i & Integer.MIN_VALUE) != 0) {
                cVar.g = i - Integer.MIN_VALUE;
            } else {
                cVar = zo.new c(interfaceC0793Of);
            }
        } else {
            cVar = zo.new c(interfaceC0793Of);
        }
        Object obj = cVar.e;
        Object objD = AbstractC0378Bt.d();
        int i2 = cVar.g;
        if (i2 != 0) {
            if (i2 == 1) {
                c1790bP = (C1790bP) cVar.c;
                InterfaceC0995Vm interfaceC0995Vm3 = (InterfaceC0995Vm) cVar.b;
                ZO zo3 = (ZO) cVar.a;
                try {
                    LL.b(obj);
                    interfaceC0995Vm2 = interfaceC0995Vm3;
                    zo = zo3;
                    try {
                        interfaceC1830bu = (InterfaceC1830bu) cVar.getContext().get(InterfaceC1830bu.s);
                    } catch (Throwable th2) {
                        zo2 = zo;
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    zo2 = zo3;
                }
            } else {
                if (i2 != 2 && i2 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                InterfaceC1830bu interfaceC1830bu2 = (InterfaceC1830bu) cVar.d;
                c1790bP = (C1790bP) cVar.c;
                InterfaceC0995Vm interfaceC0995Vm4 = (InterfaceC0995Vm) cVar.b;
                zo2 = (ZO) cVar.a;
                try {
                    LL.b(obj);
                    interfaceC0995Vm2 = interfaceC0995Vm4;
                    interfaceC1830bu = interfaceC1830bu2;
                    zo = zo2;
                } catch (Throwable th4) {
                    th = th4;
                }
            }
            zo2.k(c1790bP);
            throw th;
        }
        LL.b(obj);
        C1790bP c1790bP2 = (C1790bP) zo.g();
        try {
            if (interfaceC0995Vm instanceof JS) {
                cVar.a = zo;
                cVar.b = interfaceC0995Vm;
                cVar.c = c1790bP2;
                cVar.g = 1;
                if (((JS) interfaceC0995Vm).a(cVar) == objD) {
                    return objD;
                }
            }
            interfaceC0995Vm2 = interfaceC0995Vm;
            c1790bP = c1790bP2;
            interfaceC1830bu = (InterfaceC1830bu) cVar.getContext().get(InterfaceC1830bu.s);
        } catch (Throwable th5) {
            zo2 = zo;
            th = th5;
            c1790bP = c1790bP2;
        }
        while (true) {
            Object objU = zo.U(c1790bP);
            if (objU == AbstractC1224aP.a) {
                cVar.a = zo;
                cVar.b = interfaceC0995Vm2;
                cVar.c = c1790bP;
                cVar.d = interfaceC1830bu;
                cVar.g = 2;
                if (zo.x(c1790bP, cVar) == objD) {
                    return objD;
                }
            } else {
                if (interfaceC1830bu != null) {
                    AbstractC3347lu.k(interfaceC1830bu);
                }
                cVar.a = zo;
                cVar.b = interfaceC0995Vm2;
                cVar.c = c1790bP;
                cVar.d = interfaceC1830bu;
                cVar.g = 3;
                if (interfaceC0995Vm2.emit(objU, cVar) == objD) {
                    return objD;
                }
            }
        }
    }

    public static /* synthetic */ Object F(ZO zo, Object obj, InterfaceC0793Of interfaceC0793Of) {
        if (zo.f(obj)) {
            return FW.a;
        }
        Object objG = zo.G(obj, interfaceC0793Of);
        return objG == AbstractC0378Bt.d() ? objG : FW.a;
    }

    public final void B(long j) {
        AbstractC3436n0[] abstractC3436n0Arr;
        if (this.b != 0 && (abstractC3436n0Arr = this.a) != null) {
            for (AbstractC3436n0 abstractC3436n0 : abstractC3436n0Arr) {
                if (abstractC3436n0 != null) {
                    C1790bP c1790bP = (C1790bP) abstractC3436n0;
                    long j2 = c1790bP.a;
                    if (j2 >= 0 && j2 < j) {
                        c1790bP.a = j;
                    }
                }
            }
        }
        this.j = j;
    }

    @Override // defpackage.AbstractC3272l0
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public C1790bP h() {
        return new C1790bP();
    }

    @Override // defpackage.AbstractC3272l0
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public C1790bP[] j(int i) {
        return new C1790bP[i];
    }

    public final void E() {
        Object[] objArr = this.h;
        AbstractC4492zt.e(objArr);
        AbstractC1224aP.g(objArr, K(), null);
        this.k--;
        long jK = K() + 1;
        if (this.i < jK) {
            this.i = jK;
        }
        if (this.j < jK) {
            B(jK);
        }
    }

    public final Object G(Object obj, InterfaceC0793Of interfaceC0793Of) {
        InterfaceC0793Of[] interfaceC0793OfArrI;
        a aVar;
        C4374ya c4374ya = new C4374ya(AbstractC0352At.c(interfaceC0793Of), 1);
        c4374ya.A();
        InterfaceC0793Of[] interfaceC0793OfArrI2 = AbstractC3354m0.a;
        synchronized (this) {
            try {
                if (R(obj)) {
                    KL.a aVar2 = KL.a;
                    c4374ya.resumeWith(KL.a(FW.a));
                    interfaceC0793OfArrI = I(interfaceC0793OfArrI2);
                    aVar = null;
                } else {
                    a aVar3 = new a(this, ((long) P()) + K(), obj, c4374ya);
                    H(aVar3);
                    this.l++;
                    if (this.f == 0) {
                        interfaceC0793OfArrI2 = I(interfaceC0793OfArrI2);
                    }
                    interfaceC0793OfArrI = interfaceC0793OfArrI2;
                    aVar = aVar3;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (aVar != null) {
            AbstractC0333Aa.a(c4374ya, aVar);
        }
        for (InterfaceC0793Of interfaceC0793Of2 : interfaceC0793OfArrI) {
            if (interfaceC0793Of2 != null) {
                KL.a aVar4 = KL.a;
                interfaceC0793Of2.resumeWith(KL.a(FW.a));
            }
        }
        Object objX = c4374ya.x();
        if (objX == AbstractC0378Bt.d()) {
            AbstractC3416mi.c(interfaceC0793Of);
        }
        return objX == AbstractC0378Bt.d() ? objX : FW.a;
    }

    public final void H(Object obj) {
        int iP = P();
        Object[] objArrQ = this.h;
        if (objArrQ == null) {
            objArrQ = Q(null, 0, 2);
        } else if (iP >= objArrQ.length) {
            objArrQ = Q(objArrQ, iP, objArrQ.length * 2);
        }
        AbstractC1224aP.g(objArrQ, K() + ((long) iP), obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [Of[]] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v3, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r6v2 */
    public final InterfaceC0793Of[] I(InterfaceC0793Of[] interfaceC0793OfArr) {
        AbstractC3436n0[] abstractC3436n0Arr;
        C1790bP c1790bP;
        InterfaceC0793Of interfaceC0793Of;
        int length = interfaceC0793OfArr.length;
        if (this.b != 0 && (abstractC3436n0Arr = this.a) != null) {
            int length2 = abstractC3436n0Arr.length;
            int i = 0;
            while (i < length2) {
                AbstractC3436n0 abstractC3436n0 = abstractC3436n0Arr[i];
                if (abstractC3436n0 == null || (interfaceC0793Of = (c1790bP = (C1790bP) abstractC3436n0).b) == null || T(c1790bP) < 0) {
                    interfaceC0793OfArr = interfaceC0793OfArr;
                } else {
                    if (length >= interfaceC0793OfArr.length) {
                        interfaceC0793OfArr = interfaceC0793OfArr;
                        interfaceC0793OfArr = interfaceC0793OfArr;
                        Object[] objArrCopyOf = Arrays.copyOf((Object[]) interfaceC0793OfArr, Math.max(2, interfaceC0793OfArr.length * 2));
                        AbstractC4492zt.g(objArrCopyOf, "copyOf(this, newSize)");
                        interfaceC0793OfArr = objArrCopyOf;
                    }
                    interfaceC0793OfArr = interfaceC0793OfArr;
                    interfaceC0793OfArr = interfaceC0793OfArr;
                    ((InterfaceC0793Of[]) interfaceC0793OfArr)[length] = interfaceC0793Of;
                    c1790bP.b = null;
                    length++;
                }
                i++;
                interfaceC0793OfArr = interfaceC0793OfArr;
            }
            interfaceC0793OfArr = interfaceC0793OfArr;
        }
        return (InterfaceC0793Of[]) interfaceC0793OfArr;
    }

    public final long J() {
        return K() + ((long) this.k);
    }

    public final long K() {
        return Math.min(this.j, this.i);
    }

    public final Object L() {
        Object[] objArr = this.h;
        AbstractC4492zt.e(objArr);
        return AbstractC1224aP.f(objArr, (this.i + ((long) O())) - 1);
    }

    public final Object M(long j) {
        Object[] objArr = this.h;
        AbstractC4492zt.e(objArr);
        Object objF = AbstractC1224aP.f(objArr, j);
        return objF instanceof a ? ((a) objF).c : objF;
    }

    public final long N() {
        return K() + ((long) this.k) + ((long) this.l);
    }

    public final int O() {
        return (int) ((K() + ((long) this.k)) - this.i);
    }

    public final int P() {
        return this.k + this.l;
    }

    public final Object[] Q(Object[] objArr, int i, int i2) {
        if (i2 <= 0) {
            throw new IllegalStateException("Buffer size overflow");
        }
        Object[] objArr2 = new Object[i2];
        this.h = objArr2;
        if (objArr == null) {
            return objArr2;
        }
        long jK = K();
        for (int i3 = 0; i3 < i; i3++) {
            long j = ((long) i3) + jK;
            AbstractC1224aP.g(objArr2, j, AbstractC1224aP.f(objArr, j));
        }
        return objArr2;
    }

    public final boolean R(Object obj) {
        if (l() == 0) {
            return S(obj);
        }
        if (this.k >= this.f && this.j <= this.i) {
            int i = b.a[this.g.ordinal()];
            if (i == 1) {
                return false;
            }
            if (i == 2) {
                return true;
            }
        }
        H(obj);
        int i2 = this.k + 1;
        this.k = i2;
        if (i2 > this.f) {
            E();
        }
        if (O() > this.e) {
            V(this.i + 1, this.j, J(), N());
        }
        return true;
    }

    public final boolean S(Object obj) {
        if (this.e == 0) {
            return true;
        }
        H(obj);
        int i = this.k + 1;
        this.k = i;
        if (i > this.e) {
            E();
        }
        this.j = K() + ((long) this.k);
        return true;
    }

    public final long T(C1790bP c1790bP) {
        long j = c1790bP.a;
        if (j < J()) {
            return j;
        }
        if (this.f <= 0 && j <= K() && this.l != 0) {
            return j;
        }
        return -1L;
    }

    public final Object U(C1790bP c1790bP) {
        Object obj;
        InterfaceC0793Of[] interfaceC0793OfArrW = AbstractC3354m0.a;
        synchronized (this) {
            try {
                long jT = T(c1790bP);
                if (jT < 0) {
                    obj = AbstractC1224aP.a;
                } else {
                    long j = c1790bP.a;
                    Object objM = M(jT);
                    c1790bP.a = jT + 1;
                    interfaceC0793OfArrW = W(j);
                    obj = objM;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        for (InterfaceC0793Of interfaceC0793Of : interfaceC0793OfArrW) {
            if (interfaceC0793Of != null) {
                KL.a aVar = KL.a;
                interfaceC0793Of.resumeWith(KL.a(FW.a));
            }
        }
        return obj;
    }

    public final void V(long j, long j2, long j3, long j4) {
        long jMin = Math.min(j2, j);
        for (long jK = K(); jK < jMin; jK++) {
            Object[] objArr = this.h;
            AbstractC4492zt.e(objArr);
            AbstractC1224aP.g(objArr, jK, null);
        }
        this.i = j;
        this.j = j2;
        this.k = (int) (j3 - jMin);
        this.l = (int) (j4 - j3);
    }

    public final InterfaceC0793Of[] W(long j) {
        long j2;
        long j3;
        long j4;
        AbstractC3436n0[] abstractC3436n0Arr;
        if (j > this.j) {
            return AbstractC3354m0.a;
        }
        long jK = K();
        long j5 = ((long) this.k) + jK;
        if (this.f == 0 && this.l > 0) {
            j5++;
        }
        if (this.b != 0 && (abstractC3436n0Arr = this.a) != null) {
            for (AbstractC3436n0 abstractC3436n0 : abstractC3436n0Arr) {
                if (abstractC3436n0 != null) {
                    long j6 = ((C1790bP) abstractC3436n0).a;
                    if (j6 >= 0 && j6 < j5) {
                        j5 = j6;
                    }
                }
            }
        }
        if (j5 <= this.j) {
            return AbstractC3354m0.a;
        }
        long J = J();
        int iMin = l() > 0 ? Math.min(this.l, this.f - ((int) (J - j5))) : this.l;
        InterfaceC0793Of[] interfaceC0793OfArr = AbstractC3354m0.a;
        long j7 = ((long) this.l) + J;
        if (iMin > 0) {
            interfaceC0793OfArr = new InterfaceC0793Of[iMin];
            Object[] objArr = this.h;
            AbstractC4492zt.e(objArr);
            long j8 = J;
            int i = 0;
            while (true) {
                if (J >= j7) {
                    j2 = j5;
                    j3 = j7;
                    break;
                }
                Object objF = AbstractC1224aP.f(objArr, J);
                j2 = j5;
                YS ys = AbstractC1224aP.a;
                if (objF == ys) {
                    j3 = j7;
                    j4 = 1;
                } else {
                    if (objF == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                    }
                    a aVar = (a) objF;
                    int i2 = i + 1;
                    j3 = j7;
                    interfaceC0793OfArr[i] = aVar.d;
                    AbstractC1224aP.g(objArr, J, ys);
                    AbstractC1224aP.g(objArr, j8, aVar.c);
                    j4 = 1;
                    j8++;
                    if (i2 >= iMin) {
                        break;
                    }
                    i = i2;
                }
                J += j4;
                j5 = j2;
                j7 = j3;
            }
            J = j8;
        } else {
            j2 = j5;
            j3 = j7;
        }
        int i3 = (int) (J - jK);
        long j9 = l() == 0 ? J : j2;
        long jMax = Math.max(this.i, J - ((long) Math.min(this.e, i3)));
        if (this.f == 0 && jMax < j3) {
            Object[] objArr2 = this.h;
            AbstractC4492zt.e(objArr2);
            if (AbstractC4492zt.d(AbstractC1224aP.f(objArr2, jMax), AbstractC1224aP.a)) {
                J++;
                jMax++;
            }
        }
        V(jMax, j9, J, j3);
        z();
        return !(interfaceC0793OfArr.length == 0) ? I(interfaceC0793OfArr) : interfaceC0793OfArr;
    }

    public final long X() {
        long j = this.i;
        if (j < this.j) {
            this.j = j;
        }
        return j;
    }

    @Override // defpackage.InterfaceC1826bq
    public InterfaceC0939Tm a(InterfaceC0988Vf interfaceC0988Vf, int i, I8 i8) {
        return AbstractC1224aP.e(this, interfaceC0988Vf, i, i8);
    }

    @Override // defpackage.CC
    public void c() {
        synchronized (this) {
            V(J(), this.j, J(), N());
            FW fw = FW.a;
        }
    }

    @Override // defpackage.YO, defpackage.InterfaceC0939Tm
    public Object collect(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) {
        return A(this, interfaceC0995Vm, interfaceC0793Of);
    }

    @Override // defpackage.CC, defpackage.InterfaceC0995Vm
    public Object emit(Object obj, InterfaceC0793Of interfaceC0793Of) {
        return F(this, obj, interfaceC0793Of);
    }

    @Override // defpackage.CC
    public boolean f(Object obj) {
        int i;
        boolean z;
        InterfaceC0793Of[] interfaceC0793OfArrI = AbstractC3354m0.a;
        synchronized (this) {
            if (R(obj)) {
                interfaceC0793OfArrI = I(interfaceC0793OfArrI);
                z = true;
            } else {
                z = false;
            }
        }
        for (InterfaceC0793Of interfaceC0793Of : interfaceC0793OfArrI) {
            if (interfaceC0793Of != null) {
                KL.a aVar = KL.a;
                interfaceC0793Of.resumeWith(KL.a(FW.a));
            }
        }
        return z;
    }

    public final Object x(C1790bP c1790bP, InterfaceC0793Of interfaceC0793Of) {
        C4374ya c4374ya = new C4374ya(AbstractC0352At.c(interfaceC0793Of), 1);
        c4374ya.A();
        synchronized (this) {
            try {
                if (T(c1790bP) < 0) {
                    c1790bP.b = c4374ya;
                } else {
                    KL.a aVar = KL.a;
                    c4374ya.resumeWith(KL.a(FW.a));
                }
                FW fw = FW.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        Object objX = c4374ya.x();
        if (objX == AbstractC0378Bt.d()) {
            AbstractC3416mi.c(interfaceC0793Of);
        }
        return objX == AbstractC0378Bt.d() ? objX : FW.a;
    }

    public final void y(a aVar) {
        synchronized (this) {
            if (aVar.b < K()) {
                return;
            }
            Object[] objArr = this.h;
            AbstractC4492zt.e(objArr);
            if (AbstractC1224aP.f(objArr, aVar.b) != aVar) {
                return;
            }
            AbstractC1224aP.g(objArr, aVar.b, AbstractC1224aP.a);
            z();
            FW fw = FW.a;
        }
    }

    public final void z() {
        if (this.f != 0 || this.l > 1) {
            Object[] objArr = this.h;
            AbstractC4492zt.e(objArr);
            while (this.l > 0 && AbstractC1224aP.f(objArr, (K() + ((long) P())) - 1) == AbstractC1224aP.a) {
                this.l--;
                AbstractC1224aP.g(objArr, K() + ((long) P()), null);
            }
        }
    }
}
