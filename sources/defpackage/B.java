package defpackage;

import java.util.ArrayList;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class B extends AbstractC3108j0 implements InterfaceC1009Wa {

    public static final class a implements InterfaceC2205fb {
        public final B a;
        public Object b = C.d;

        public a(B b) {
            this.a = b;
        }

        @Override // defpackage.InterfaceC2205fb
        public Object a(InterfaceC0793Of interfaceC0793Of) {
            Object obj = this.b;
            YS ys = C.d;
            if (obj != ys) {
                return E8.a(b(obj));
            }
            Object objL = this.a.L();
            this.b = objL;
            return objL != ys ? E8.a(b(objL)) : c(interfaceC0793Of);
        }

        public final boolean b(Object obj) throws Throwable {
            if (!(obj instanceof C0737Mb)) {
                return true;
            }
            C0737Mb c0737Mb = (C0737Mb) obj;
            if (c0737Mb.d == null) {
                return false;
            }
            throw AbstractC4041uR.a(c0737Mb.E());
        }

        public final Object c(InterfaceC0793Of interfaceC0793Of) {
            C4374ya c4374yaB = AbstractC0333Aa.b(AbstractC0352At.c(interfaceC0793Of));
            d dVar = new d(this, c4374yaB);
            while (true) {
                if (this.a.C(dVar)) {
                    this.a.N(c4374yaB, dVar);
                    break;
                }
                Object objL = this.a.L();
                d(objL);
                if (objL instanceof C0737Mb) {
                    C0737Mb c0737Mb = (C0737Mb) objL;
                    if (c0737Mb.d != null) {
                        KL.a aVar = KL.a;
                        c4374yaB.resumeWith(KL.a(LL.a(c0737Mb.E())));
                        break;
                    }
                    KL.a aVar2 = KL.a;
                    c4374yaB.resumeWith(KL.a(E8.a(false)));
                    break;
                }
                if (objL != C.d) {
                    Boolean boolA = E8.a(true);
                    InterfaceC3750qp interfaceC3750qp = this.a.a;
                    c4374yaB.k(boolA, interfaceC3750qp != null ? OE.a(interfaceC3750qp, objL, c4374yaB.getContext()) : null);
                    break;
                }
            }
            Object objX = c4374yaB.x();
            if (objX == AbstractC0378Bt.d()) {
                AbstractC3416mi.c(interfaceC0793Of);
            }
            return objX;
        }

        public final void d(Object obj) {
            this.b = obj;
        }

        @Override // defpackage.InterfaceC2205fb
        public Object next() throws Throwable {
            Object obj = this.b;
            if (obj instanceof C0737Mb) {
                throw AbstractC4041uR.a(((C0737Mb) obj).E());
            }
            YS ys = C.d;
            if (obj == ys) {
                throw new IllegalStateException("'hasNext' should be called prior to 'next' invocation");
            }
            this.b = ys;
            return obj;
        }
    }

    public static class b extends HJ {
        public final InterfaceC4293xa d;
        public final int e;

        public b(InterfaceC4293xa interfaceC4293xa, int i) {
            this.d = interfaceC4293xa;
            this.e = i;
        }

        public final Object A(Object obj) {
            return this.e == 1 ? C2451ib.b(C2451ib.b.c(obj)) : obj;
        }

        @Override // defpackage.JJ
        public void d(Object obj) {
            this.d.o(AbstractC4465za.a);
        }

        @Override // defpackage.JJ
        public YS e(Object obj, C0533Fw.b bVar) {
            if (this.d.n(A(obj), null, y(obj)) == null) {
                return null;
            }
            return AbstractC4465za.a;
        }

        @Override // defpackage.C0533Fw
        public String toString() {
            return "ReceiveElement@" + AbstractC3498ni.b(this) + "[receiveMode=" + this.e + ']';
        }

        @Override // defpackage.HJ
        public void z(C0737Mb c0737Mb) {
            if (this.e == 1) {
                this.d.resumeWith(KL.a(C2451ib.b(C2451ib.b.a(c0737Mb.d))));
                return;
            }
            InterfaceC4293xa interfaceC4293xa = this.d;
            KL.a aVar = KL.a;
            interfaceC4293xa.resumeWith(KL.a(LL.a(c0737Mb.E())));
        }
    }

    public static final class c extends b {
        public final InterfaceC3750qp f;

        public c(InterfaceC4293xa interfaceC4293xa, int i, InterfaceC3750qp interfaceC3750qp) {
            super(interfaceC4293xa, i);
            this.f = interfaceC3750qp;
        }

        @Override // defpackage.HJ
        public InterfaceC3750qp y(Object obj) {
            return OE.a(this.f, obj, this.d.getContext());
        }
    }

    public static class d extends HJ {
        public final a d;
        public final InterfaceC4293xa e;

        public d(a aVar, InterfaceC4293xa interfaceC4293xa) {
            this.d = aVar;
            this.e = interfaceC4293xa;
        }

        @Override // defpackage.JJ
        public void d(Object obj) {
            this.d.d(obj);
            this.e.o(AbstractC4465za.a);
        }

        @Override // defpackage.JJ
        public YS e(Object obj, C0533Fw.b bVar) {
            if (this.e.n(Boolean.TRUE, null, y(obj)) == null) {
                return null;
            }
            return AbstractC4465za.a;
        }

        @Override // defpackage.C0533Fw
        public String toString() {
            return "ReceiveHasNext@" + AbstractC3498ni.b(this);
        }

        @Override // defpackage.HJ
        public InterfaceC3750qp y(Object obj) {
            InterfaceC3750qp interfaceC3750qp = this.d.a.a;
            if (interfaceC3750qp != null) {
                return OE.a(interfaceC3750qp, obj, this.e.getContext());
            }
            return null;
        }

        @Override // defpackage.HJ
        public void z(C0737Mb c0737Mb) {
            Object objB = c0737Mb.d == null ? InterfaceC4293xa.a.b(this.e, Boolean.FALSE, null, 2, null) : this.e.j(c0737Mb.E());
            if (objB != null) {
                this.d.d(c0737Mb);
                this.e.o(objB);
            }
        }
    }

    public final class e extends AbstractC4099v7 {
        public final HJ a;

        public e(HJ hj) {
            this.a = hj;
        }

        @Override // defpackage.AbstractC4131va
        public void a(Throwable th) {
            if (this.a.s()) {
                B.this.J();
            }
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return FW.a;
        }

        public String toString() {
            return "RemoveReceiveOnCancel[" + this.a + ']';
        }
    }

    public static final class f extends C0533Fw.a {
        public final /* synthetic */ B d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(C0533Fw c0533Fw, B b) {
            super(c0533Fw);
            this.d = b;
        }

        @Override // defpackage.Y5
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Object g(C0533Fw c0533Fw) {
            if (this.d.F()) {
                return null;
            }
            return AbstractC0459Ew.a();
        }
    }

    public static final class g extends AbstractC0819Pf {
        public /* synthetic */ Object a;
        public int c;

        public g(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            Object objB = B.this.b(this);
            return objB == AbstractC0378Bt.d() ? objB : C2451ib.b(objB);
        }
    }

    public B(InterfaceC3750qp interfaceC3750qp) {
        super(interfaceC3750qp);
    }

    public final boolean B(Throwable th) {
        boolean zClose = close(th);
        H(zClose);
        return zClose;
    }

    public final boolean C(HJ hj) {
        boolean zD = D(hj);
        if (zD) {
            K();
        }
        return zD;
    }

    public boolean D(HJ hj) {
        int iW;
        C0533Fw c0533FwO;
        if (!E()) {
            C0433Dw c0433DwK = k();
            f fVar = new f(hj, this);
            do {
                C0533Fw c0533FwO2 = c0433DwK.o();
                if (c0533FwO2 instanceof AbstractC3957tO) {
                    break;
                }
                iW = c0533FwO2.w(hj, c0433DwK, fVar);
                if (iW == 1) {
                    return true;
                }
            } while (iW != 2);
        } else {
            C0433Dw c0433DwK2 = k();
            do {
                c0533FwO = c0433DwK2.o();
                if (c0533FwO instanceof AbstractC3957tO) {
                }
            } while (!c0533FwO.h(hj, c0433DwK2));
            return true;
        }
        return false;
    }

    public abstract boolean E();

    public abstract boolean F();

    public boolean G() {
        return i() != null && F();
    }

    public void H(boolean z) {
        C0737Mb c0737MbJ = j();
        if (c0737MbJ == null) {
            throw new IllegalStateException("Cannot happen");
        }
        Object objB = AbstractC0633Js.b(null, 1, null);
        while (true) {
            C0533Fw c0533FwO = c0737MbJ.o();
            if (c0533FwO instanceof C0433Dw) {
                I(objB, c0737MbJ);
                return;
            } else if (c0533FwO.s()) {
                objB = AbstractC0633Js.c(objB, (AbstractC3957tO) c0533FwO);
            } else {
                c0533FwO.p();
            }
        }
    }

    public void I(Object obj, C0737Mb c0737Mb) {
        if (obj == null) {
            return;
        }
        if (!(obj instanceof ArrayList)) {
            ((AbstractC3957tO) obj).z(c0737Mb);
            return;
        }
        ArrayList arrayList = (ArrayList) obj;
        int size = arrayList.size();
        while (true) {
            size--;
            if (-1 >= size) {
                return;
            } else {
                ((AbstractC3957tO) arrayList.get(size)).z(c0737Mb);
            }
        }
    }

    public Object L() {
        while (true) {
            AbstractC3957tO abstractC3957tOY = y();
            if (abstractC3957tOY == null) {
                return C.d;
            }
            if (abstractC3957tOY.A(null) != null) {
                abstractC3957tOY.x();
                return abstractC3957tOY.y();
            }
            abstractC3957tOY.B();
        }
    }

    public final Object M(int i, InterfaceC0793Of interfaceC0793Of) {
        C4374ya c4374yaB = AbstractC0333Aa.b(AbstractC0352At.c(interfaceC0793Of));
        b bVar = this.a == null ? new b(c4374yaB, i) : new c(c4374yaB, i, this.a);
        while (true) {
            if (C(bVar)) {
                N(c4374yaB, bVar);
                break;
            }
            Object objL = L();
            if (objL instanceof C0737Mb) {
                bVar.z((C0737Mb) objL);
                break;
            }
            if (objL != C.d) {
                c4374yaB.k(bVar.A(objL), bVar.y(objL));
                break;
            }
        }
        Object objX = c4374yaB.x();
        if (objX == AbstractC0378Bt.d()) {
            AbstractC3416mi.c(interfaceC0793Of);
        }
        return objX;
    }

    public final void N(InterfaceC4293xa interfaceC4293xa, HJ hj) {
        interfaceC4293xa.e(new e(hj));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // defpackage.IJ
    public final Object b(InterfaceC0793Of interfaceC0793Of) throws Throwable {
        g gVar;
        if (interfaceC0793Of instanceof g) {
            gVar = (g) interfaceC0793Of;
            int i = gVar.c;
            if ((i & Integer.MIN_VALUE) != 0) {
                gVar.c = i - Integer.MIN_VALUE;
            } else {
                gVar = new g(interfaceC0793Of);
            }
        } else {
            gVar = new g(interfaceC0793Of);
        }
        Object objM = gVar.a;
        Object objD = AbstractC0378Bt.d();
        int i2 = gVar.c;
        if (i2 == 0) {
            LL.b(objM);
            Object objL = L();
            if (objL != C.d) {
                return objL instanceof C0737Mb ? C2451ib.b.a(((C0737Mb) objL).d) : C2451ib.b.c(objL);
            }
            gVar.c = 1;
            objM = M(1, gVar);
            if (objM == objD) {
                return objD;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(objM);
        }
        return ((C2451ib) objM).l();
    }

    @Override // defpackage.IJ
    public final void cancel(CancellationException cancellationException) {
        if (G()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new CancellationException(AbstractC3498ni.a(this) + " was cancelled");
        }
        B(cancellationException);
    }

    @Override // defpackage.IJ
    public final Object d() {
        Object objL = L();
        if (objL == C.d) {
            return C2451ib.b.b();
        }
        return objL instanceof C0737Mb ? C2451ib.b.a(((C0737Mb) objL).d) : C2451ib.b.c(objL);
    }

    @Override // defpackage.IJ
    public final Object f(InterfaceC0793Of interfaceC0793Of) {
        Object objL = L();
        return (objL == C.d || (objL instanceof C0737Mb)) ? M(0, interfaceC0793Of) : objL;
    }

    @Override // defpackage.IJ
    public final InterfaceC2205fb iterator() {
        return new a(this);
    }

    @Override // defpackage.AbstractC3108j0
    public JJ x() {
        JJ jjX = super.x();
        if (jjX != null && !(jjX instanceof C0737Mb)) {
            J();
        }
        return jjX;
    }

    public void J() {
    }

    public void K() {
    }
}
