package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: renamed from: j0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3108j0 implements InterfaceC4038uO {
    public static final /* synthetic */ AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(AbstractC3108j0.class, Object.class, "onCloseHandler");
    public final InterfaceC3750qp a;
    public final C0433Dw b = new C0433Dw();
    private volatile /* synthetic */ Object onCloseHandler = null;

    /* JADX INFO: renamed from: j0$b */
    public static final class b extends C0533Fw.a {
        public final /* synthetic */ AbstractC3108j0 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(C0533Fw c0533Fw, AbstractC3108j0 abstractC3108j0) {
            super(c0533Fw);
            this.d = abstractC3108j0;
        }

        @Override // defpackage.Y5
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Object g(C0533Fw c0533Fw) {
            if (this.d.r()) {
                return null;
            }
            return AbstractC0459Ew.a();
        }
    }

    /* JADX INFO: renamed from: j0$c */
    public static final class c implements InterfaceC3552oO {
        public c() {
        }
    }

    public AbstractC3108j0(InterfaceC3750qp interfaceC3750qp) {
        this.a = interfaceC3750qp;
    }

    @Override // defpackage.InterfaceC4038uO
    public boolean close(Throwable th) {
        boolean z;
        C0737Mb c0737Mb = new C0737Mb(th);
        C0533Fw c0533Fw = this.b;
        while (true) {
            C0533Fw c0533FwO = c0533Fw.o();
            if (c0533FwO instanceof C0737Mb) {
                z = false;
                break;
            }
            if (c0533FwO.h(c0737Mb, c0533Fw)) {
                z = true;
                break;
            }
        }
        if (!z) {
            c0737Mb = (C0737Mb) this.b.o();
        }
        m(c0737Mb);
        if (z) {
            p(th);
        }
        return z;
    }

    public final int e() {
        C0433Dw c0433Dw = this.b;
        int i = 0;
        for (C0533Fw c0533FwN = (C0533Fw) c0433Dw.m(); !AbstractC4492zt.d(c0533FwN, c0433Dw); c0533FwN = c0533FwN.n()) {
            if (c0533FwN instanceof C0533Fw) {
                i++;
            }
        }
        return i;
    }

    public Object g(AbstractC3957tO abstractC3957tO) {
        int iW;
        C0533Fw c0533FwO;
        if (q()) {
            C0533Fw c0533Fw = this.b;
            do {
                c0533FwO = c0533Fw.o();
                if (c0533FwO instanceof JJ) {
                    return c0533FwO;
                }
            } while (!c0533FwO.h(abstractC3957tO, c0533Fw));
            return null;
        }
        C0533Fw c0533Fw2 = this.b;
        b bVar = new b(abstractC3957tO, this);
        do {
            C0533Fw c0533FwO2 = c0533Fw2.o();
            if (c0533FwO2 instanceof JJ) {
                return c0533FwO2;
            }
            iW = c0533FwO2.w(abstractC3957tO, c0533Fw2, bVar);
            if (iW == 1) {
                return null;
            }
        } while (iW != 2);
        return C.e;
    }

    @Override // defpackage.InterfaceC4038uO
    public final InterfaceC3552oO getOnSend() {
        return new c();
    }

    public String h() {
        return "";
    }

    public final C0737Mb i() {
        C0533Fw c0533FwN = this.b.n();
        C0737Mb c0737Mb = c0533FwN instanceof C0737Mb ? (C0737Mb) c0533FwN : null;
        if (c0737Mb == null) {
            return null;
        }
        m(c0737Mb);
        return c0737Mb;
    }

    @Override // defpackage.InterfaceC4038uO
    public void invokeOnClose(InterfaceC3750qp interfaceC3750qp) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c;
        if (AbstractC2403i0.a(atomicReferenceFieldUpdater, this, null, interfaceC3750qp)) {
            C0737Mb c0737MbJ = j();
            if (c0737MbJ == null || !AbstractC2403i0.a(atomicReferenceFieldUpdater, this, interfaceC3750qp, C.f)) {
                return;
            }
            interfaceC3750qp.invoke(c0737MbJ.d);
            return;
        }
        Object obj = this.onCloseHandler;
        if (obj == C.f) {
            throw new IllegalStateException("Another handler was already registered and successfully invoked");
        }
        throw new IllegalStateException("Another handler was already registered: " + obj);
    }

    @Override // defpackage.InterfaceC4038uO
    public final boolean isClosedForSend() {
        return j() != null;
    }

    public final C0737Mb j() {
        C0533Fw c0533FwO = this.b.o();
        C0737Mb c0737Mb = c0533FwO instanceof C0737Mb ? (C0737Mb) c0533FwO : null;
        if (c0737Mb == null) {
            return null;
        }
        m(c0737Mb);
        return c0737Mb;
    }

    public final C0433Dw k() {
        return this.b;
    }

    public final String l() {
        String string;
        C0533Fw c0533FwN = this.b.n();
        if (c0533FwN == this.b) {
            return "EmptyQueue";
        }
        if (c0533FwN instanceof C0737Mb) {
            string = c0533FwN.toString();
        } else if (c0533FwN instanceof HJ) {
            string = "ReceiveQueued";
        } else if (c0533FwN instanceof AbstractC3957tO) {
            string = "SendQueued";
        } else {
            string = "UNEXPECTED:" + c0533FwN;
        }
        C0533Fw c0533FwO = this.b.o();
        if (c0533FwO == c0533FwN) {
            return string;
        }
        String str = string + ",queueSize=" + e();
        if (!(c0533FwO instanceof C0737Mb)) {
            return str;
        }
        return str + ",closedForSend=" + c0533FwO;
    }

    public final void m(C0737Mb c0737Mb) {
        Object objB = AbstractC0633Js.b(null, 1, null);
        while (true) {
            C0533Fw c0533FwO = c0737Mb.o();
            HJ hj = c0533FwO instanceof HJ ? (HJ) c0533FwO : null;
            if (hj == null) {
                break;
            } else if (hj.s()) {
                objB = AbstractC0633Js.c(objB, hj);
            } else {
                hj.p();
            }
        }
        if (objB != null) {
            if (objB instanceof ArrayList) {
                ArrayList arrayList = (ArrayList) objB;
                for (int size = arrayList.size() - 1; -1 < size; size--) {
                    ((HJ) arrayList.get(size)).z(c0737Mb);
                }
            } else {
                ((HJ) objB).z(c0737Mb);
            }
        }
        u(c0737Mb);
    }

    public final Throwable n(C0737Mb c0737Mb) {
        m(c0737Mb);
        return c0737Mb.F();
    }

    public final void o(InterfaceC0793Of interfaceC0793Of, Object obj, C0737Mb c0737Mb) throws IllegalAccessException, InvocationTargetException {
        C3965tW c3965tWD;
        m(c0737Mb);
        Throwable thF = c0737Mb.F();
        InterfaceC3750qp interfaceC3750qp = this.a;
        if (interfaceC3750qp == null || (c3965tWD = OE.d(interfaceC3750qp, obj, null, 2, null)) == null) {
            KL.a aVar = KL.a;
            interfaceC0793Of.resumeWith(KL.a(LL.a(thF)));
        } else {
            AbstractC0773Nl.a(c3965tWD, thF);
            KL.a aVar2 = KL.a;
            interfaceC0793Of.resumeWith(KL.a(LL.a(c3965tWD)));
        }
    }

    @Override // defpackage.InterfaceC4038uO
    public boolean offer(Object obj) throws IllegalAccessException, InvocationTargetException {
        C3965tW c3965tWD;
        try {
            return InterfaceC4038uO.a.b(this, obj);
        } catch (Throwable th) {
            InterfaceC3750qp interfaceC3750qp = this.a;
            if (interfaceC3750qp == null || (c3965tWD = OE.d(interfaceC3750qp, obj, null, 2, null)) == null) {
                throw th;
            }
            AbstractC0773Nl.a(c3965tWD, th);
            throw c3965tWD;
        }
    }

    public final void p(Throwable th) {
        YS ys;
        Object obj = this.onCloseHandler;
        if (obj == null || obj == (ys = C.f) || !AbstractC2403i0.a(c, this, obj, ys)) {
            return;
        }
        ((InterfaceC3750qp) NV.d(obj, 1)).invoke(th);
    }

    public abstract boolean q();

    public abstract boolean r();

    public final boolean s() {
        return !(this.b.n() instanceof JJ) && r();
    }

    @Override // defpackage.InterfaceC4038uO
    public final Object send(Object obj, InterfaceC0793Of interfaceC0793Of) throws IllegalAccessException, InvocationTargetException {
        if (t(obj) == C.b) {
            return FW.a;
        }
        Object objW = w(obj, interfaceC0793Of);
        return objW == AbstractC0378Bt.d() ? objW : FW.a;
    }

    public Object t(Object obj) {
        JJ jjX;
        do {
            jjX = x();
            if (jjX == null) {
                return C.c;
            }
        } while (jjX.e(obj, null) == null);
        jjX.d(obj);
        return jjX.a();
    }

    public String toString() {
        return AbstractC3498ni.a(this) + '@' + AbstractC3498ni.b(this) + '{' + l() + '}' + h();
    }

    @Override // defpackage.InterfaceC4038uO
    /* JADX INFO: renamed from: trySend-JP2dKIU */
    public final Object mo0trySendJP2dKIU(Object obj) {
        Object objT = t(obj);
        if (objT == C.b) {
            return C2451ib.b.c(FW.a);
        }
        if (objT == C.c) {
            C0737Mb c0737MbJ = j();
            return c0737MbJ == null ? C2451ib.b.b() : C2451ib.b.a(n(c0737MbJ));
        }
        if (objT instanceof C0737Mb) {
            return C2451ib.b.a(n((C0737Mb) objT));
        }
        throw new IllegalStateException(("trySend returned " + objT).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final JJ v(Object obj) {
        C0533Fw c0533FwO;
        C0433Dw c0433Dw = this.b;
        a aVar = new a(obj);
        do {
            c0533FwO = c0433Dw.o();
            if (c0533FwO instanceof JJ) {
                return (JJ) c0533FwO;
            }
        } while (!c0533FwO.h(aVar, c0433Dw));
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x006b  */
    /* JADX WARN: Code duplicated, block: B:29:0x0073 A[EDGE_INSN: B:29:0x0073->B:30:0x0078 BREAK  A[LOOP:0: B:3:0x0008->B:45:?]] */
    /* JADX WARN: Code duplicated, block: B:38:0x008f  */
    /* JADX WARN: Code duplicated, block: B:43:0x005f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x006f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:? A[LOOP:0: B:3:0x0008->B:45:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:38:0x008f, please report this as an issue */
    public final Object w(Object obj, InterfaceC0793Of interfaceC0793Of) throws IllegalAccessException, InvocationTargetException {
        Object objT;
        C4374ya c4374yaB = AbstractC0333Aa.b(AbstractC0352At.c(interfaceC0793Of));
        while (true) {
            if (s()) {
                AbstractC3957tO c4119vO = this.a == null ? new C4119vO(obj, c4374yaB) : new C4200wO(obj, c4374yaB, this.a);
                Object objG = g(c4119vO);
                if (objG == null) {
                    AbstractC0333Aa.c(c4374yaB, c4119vO);
                    break;
                }
                if (objG instanceof C0737Mb) {
                    o(c4374yaB, obj, (C0737Mb) objG);
                    break;
                }
                if (objG != C.e && !(objG instanceof HJ)) {
                    throw new IllegalStateException(("enqueueSend returned " + objG).toString());
                }
                objT = t(obj);
                if (objT == C.b) {
                    KL.a aVar = KL.a;
                    c4374yaB.resumeWith(KL.a(FW.a));
                    break;
                }
                if (objT != C.c) {
                    if (objT instanceof C0737Mb) {
                        o(c4374yaB, obj, (C0737Mb) objT);
                        break;
                    }
                    throw new IllegalStateException(("offerInternal returned " + objT).toString());
                }
            } else {
                objT = t(obj);
                if (objT == C.b) {
                    KL.a aVar2 = KL.a;
                    c4374yaB.resumeWith(KL.a(FW.a));
                    break;
                }
                if (objT != C.c) {
                    if (objT instanceof C0737Mb) {
                        o(c4374yaB, obj, (C0737Mb) objT);
                        break;
                    }
                    throw new IllegalStateException(("offerInternal returned " + objT).toString());
                }
            }
        }
        Object objX = c4374yaB.x();
        if (objX == AbstractC0378Bt.d()) {
            AbstractC3416mi.c(interfaceC0793Of);
        }
        return objX == AbstractC0378Bt.d() ? objX : FW.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [Fw] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public JJ x() {
        ?? r1;
        C0533Fw c0533FwU;
        C0433Dw c0433Dw = this.b;
        while (true) {
            r1 = (C0533Fw) c0433Dw.m();
            if (r1 == c0433Dw || !(r1 instanceof JJ)) {
                break;
            }
            if ((!(((JJ) r1) instanceof C0737Mb) || r1.r()) && (c0533FwU = r1.u()) != null) {
                c0533FwU.q();
            }
            return (JJ) r1;
        }
        r1 = 0;
        return (JJ) r1;
    }

    public final AbstractC3957tO y() {
        C0533Fw c0533Fw;
        C0533Fw c0533FwU;
        C0433Dw c0433Dw = this.b;
        while (true) {
            c0533Fw = (C0533Fw) c0433Dw.m();
            if (c0533Fw == c0433Dw || !(c0533Fw instanceof AbstractC3957tO)) {
                break;
            }
            if ((!(((AbstractC3957tO) c0533Fw) instanceof C0737Mb) || c0533Fw.r()) && (c0533FwU = c0533Fw.u()) != null) {
                c0533FwU.q();
            }
            return (AbstractC3957tO) c0533Fw;
        }
        c0533Fw = null;
        return (AbstractC3957tO) c0533Fw;
    }

    /* JADX INFO: renamed from: j0$a */
    public static final class a extends AbstractC3957tO {
        public final Object d;

        public a(Object obj) {
            this.d = obj;
        }

        @Override // defpackage.AbstractC3957tO
        public YS A(C0533Fw.b bVar) {
            return AbstractC4465za.a;
        }

        @Override // defpackage.C0533Fw
        public String toString() {
            return "SendBuffered@" + AbstractC3498ni.b(this) + '(' + this.d + ')';
        }

        @Override // defpackage.AbstractC3957tO
        public Object y() {
            return this.d;
        }

        @Override // defpackage.AbstractC3957tO
        public void x() {
        }

        @Override // defpackage.AbstractC3957tO
        public void z(C0737Mb c0737Mb) {
        }
    }

    public void u(C0533Fw c0533Fw) {
    }
}
