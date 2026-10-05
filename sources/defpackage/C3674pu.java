package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: renamed from: pu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3674pu implements InterfaceC1830bu, InterfaceC4376yb, InterfaceC3216kG {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(C3674pu.class, Object.class, "_state");
    private volatile /* synthetic */ Object _parentHandle;
    private volatile /* synthetic */ Object _state;

    /* JADX INFO: renamed from: pu$a */
    public static final class a extends C4374ya {
        public final C3674pu i;

        public a(InterfaceC0793Of interfaceC0793Of, C3674pu c3674pu) {
            super(interfaceC0793Of, 1);
            this.i = c3674pu;
        }

        @Override // defpackage.C4374ya
        public String G() {
            return "AwaitContinuation";
        }

        @Override // defpackage.C4374ya
        public Throwable w(InterfaceC1830bu interfaceC1830bu) {
            Throwable thE;
            Object objW = this.i.W();
            if (!(objW instanceof c) || (thE = ((c) objW).e()) == null) {
                return objW instanceof C2129ee ? ((C2129ee) objW).a : interfaceC1830bu.i();
            }
            return thE;
        }
    }

    /* JADX INFO: renamed from: pu$b */
    public static final class b extends AbstractC3593ou {
        public final C3674pu e;
        public final c f;
        public final C4295xb g;
        public final Object h;

        public b(C3674pu c3674pu, c cVar, C4295xb c4295xb, Object obj) {
            this.e = c3674pu;
            this.f = cVar;
            this.g = c4295xb;
            this.h = obj;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            x((Throwable) obj);
            return FW.a;
        }

        @Override // defpackage.AbstractC2293ge
        public void x(Throwable th) {
            this.e.M(this.f, this.g, this.h);
        }
    }

    /* JADX INFO: renamed from: pu$c */
    public static final class c implements InterfaceC0377Bs {
        private volatile /* synthetic */ Object _exceptionsHolder = null;
        private volatile /* synthetic */ int _isCompleting;
        private volatile /* synthetic */ Object _rootCause;
        public final BD a;

        public c(BD bd, boolean z, Throwable th) {
            this.a = bd;
            this._isCompleting = z ? 1 : 0;
            this._rootCause = th;
        }

        public final void a(Throwable th) {
            Throwable thE = e();
            if (thE == null) {
                l(th);
                return;
            }
            if (th == thE) {
                return;
            }
            Object objD = d();
            if (objD == null) {
                k(th);
                return;
            }
            if (objD instanceof Throwable) {
                if (th == objD) {
                    return;
                }
                ArrayList arrayListB = b();
                arrayListB.add(objD);
                arrayListB.add(th);
                k(arrayListB);
                return;
            }
            if (objD instanceof ArrayList) {
                ((ArrayList) objD).add(th);
                return;
            }
            throw new IllegalStateException(("State is " + objD).toString());
        }

        public final ArrayList b() {
            return new ArrayList(4);
        }

        @Override // defpackage.InterfaceC0377Bs
        public BD c() {
            return this.a;
        }

        public final Object d() {
            return this._exceptionsHolder;
        }

        public final Throwable e() {
            return (Throwable) this._rootCause;
        }

        public final boolean f() {
            return e() != null;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
        public final boolean g() {
            return this._isCompleting;
        }

        public final boolean h() {
            return d() == AbstractC3755qu.e;
        }

        public final List i(Throwable th) {
            ArrayList arrayListB;
            Object objD = d();
            if (objD == null) {
                arrayListB = b();
            } else if (objD instanceof Throwable) {
                ArrayList arrayListB2 = b();
                arrayListB2.add(objD);
                arrayListB = arrayListB2;
            } else {
                if (!(objD instanceof ArrayList)) {
                    throw new IllegalStateException(("State is " + objD).toString());
                }
                arrayListB = (ArrayList) objD;
            }
            Throwable thE = e();
            if (thE != null) {
                arrayListB.add(0, thE);
            }
            if (th != null && !AbstractC4492zt.d(th, thE)) {
                arrayListB.add(th);
            }
            k(AbstractC3755qu.e);
            return arrayListB;
        }

        @Override // defpackage.InterfaceC0377Bs
        public boolean isActive() {
            return e() == null;
        }

        public final void j(boolean z) {
            this._isCompleting = z ? 1 : 0;
        }

        public final void k(Object obj) {
            this._exceptionsHolder = obj;
        }

        public final void l(Throwable th) {
            this._rootCause = th;
        }

        public String toString() {
            return "Finishing[cancelling=" + f() + ", completing=" + g() + ", rootCause=" + e() + ", exceptions=" + d() + ", list=" + c() + ']';
        }
    }

    /* JADX INFO: renamed from: pu$d */
    public static final class d extends C0533Fw.a {
        public final /* synthetic */ C3674pu d;
        public final /* synthetic */ Object e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(C0533Fw c0533Fw, C3674pu c3674pu, Object obj) {
            super(c0533Fw);
            this.d = c3674pu;
            this.e = obj;
        }

        @Override // defpackage.Y5
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Object g(C0533Fw c0533Fw) {
            if (this.d.W() == this.e) {
                return null;
            }
            return AbstractC0459Ew.a();
        }
    }

    /* JADX INFO: renamed from: pu$e */
    public static final class e extends JL implements InterfaceC0526Fp {
        public Object a;
        public Object b;
        public int c;
        public /* synthetic */ Object d;

        public e(InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            e eVar = C3674pu.this.new e(interfaceC0793Of);
            eVar.d = obj;
            return eVar;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(AO ao, InterfaceC0793Of interfaceC0793Of) {
            return ((e) create(ao, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0064  */
        /* JADX WARN: Code duplicated, block: B:24:0x0068  */
        /* JADX WARN: Code duplicated, block: B:26:0x007b A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0066 -> B:27:0x007c). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0079 -> B:27:0x007c). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // defpackage.AbstractC2171f7
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = defpackage.AbstractC0378Bt.d()
                int r1 = r6.c
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L2a
                if (r1 == r3) goto L26
                if (r1 != r2) goto L1e
                java.lang.Object r1 = r6.b
                Fw r1 = (defpackage.C0533Fw) r1
                java.lang.Object r3 = r6.a
                Dw r3 = (defpackage.C0433Dw) r3
                java.lang.Object r4 = r6.d
                AO r4 = (defpackage.AO) r4
                defpackage.LL.b(r7)
                goto L7c
            L1e:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L26:
                defpackage.LL.b(r7)
                goto L81
            L2a:
                defpackage.LL.b(r7)
                java.lang.Object r7 = r6.d
                AO r7 = (defpackage.AO) r7
                pu r1 = defpackage.C3674pu.this
                java.lang.Object r1 = r1.W()
                boolean r4 = r1 instanceof defpackage.C4295xb
                if (r4 == 0) goto L48
                xb r1 = (defpackage.C4295xb) r1
                yb r1 = r1.e
                r6.c = r3
                java.lang.Object r7 = r7.b(r1, r6)
                if (r7 != r0) goto L81
                return r0
            L48:
                boolean r3 = r1 instanceof defpackage.InterfaceC0377Bs
                if (r3 == 0) goto L81
                Bs r1 = (defpackage.InterfaceC0377Bs) r1
                BD r1 = r1.c()
                if (r1 == 0) goto L81
                java.lang.Object r3 = r1.m()
                Fw r3 = (defpackage.C0533Fw) r3
                r4 = r7
                r5 = r3
                r3 = r1
                r1 = r5
            L5e:
                boolean r7 = defpackage.AbstractC4492zt.d(r1, r3)
                if (r7 != 0) goto L81
                boolean r7 = r1 instanceof defpackage.C4295xb
                if (r7 == 0) goto L7c
                r7 = r1
                xb r7 = (defpackage.C4295xb) r7
                yb r7 = r7.e
                r6.d = r4
                r6.a = r3
                r6.b = r1
                r6.c = r2
                java.lang.Object r7 = r4.b(r7, r6)
                if (r7 != r0) goto L7c
                return r0
            L7c:
                Fw r1 = r1.n()
                goto L5e
            L81:
                FW r7 = defpackage.FW.a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.C3674pu.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public C3674pu(boolean z) {
        this._state = z ? AbstractC3755qu.g : AbstractC3755qu.f;
        this._parentHandle = null;
    }

    public static /* synthetic */ CancellationException w0(C3674pu c3674pu, Throwable th, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
        }
        if ((i & 1) != 0) {
            str = null;
        }
        return c3674pu.v0(th, str);
    }

    @Override // defpackage.InterfaceC1830bu
    public final InterfaceC4214wb A(InterfaceC4376yb interfaceC4376yb) {
        return (InterfaceC4214wb) InterfaceC1830bu.a.d(this, true, false, new C4295xb(interfaceC4376yb), 2, null);
    }

    public final Object A0(Object obj, Object obj2) {
        if (!(obj instanceof InterfaceC0377Bs)) {
            return AbstractC3755qu.a;
        }
        if ((!(obj instanceof C1045Xk) && !(obj instanceof AbstractC3593ou)) || (obj instanceof C4295xb) || (obj2 instanceof C2129ee)) {
            return B0((InterfaceC0377Bs) obj, obj2);
        }
        return y0((InterfaceC0377Bs) obj, obj2) ? obj2 : AbstractC3755qu.c;
    }

    public final Object B(InterfaceC0793Of interfaceC0793Of) {
        a aVar = new a(AbstractC0352At.c(interfaceC0793Of), this);
        aVar.A();
        AbstractC0333Aa.a(aVar, C(new ML(aVar)));
        Object objX = aVar.x();
        if (objX == AbstractC0378Bt.d()) {
            AbstractC3416mi.c(interfaceC0793Of);
        }
        return objX;
    }

    public final Object B0(InterfaceC0377Bs interfaceC0377Bs, Object obj) throws Throwable {
        BD bdU = U(interfaceC0377Bs);
        if (bdU == null) {
            return AbstractC3755qu.c;
        }
        c cVar = interfaceC0377Bs instanceof c ? (c) interfaceC0377Bs : null;
        if (cVar == null) {
            cVar = new c(bdU, false, null);
        }
        OJ oj = new OJ();
        synchronized (cVar) {
            if (cVar.g()) {
                return AbstractC3755qu.a;
            }
            cVar.j(true);
            if (cVar != interfaceC0377Bs && !AbstractC2403i0.a(a, this, interfaceC0377Bs, cVar)) {
                return AbstractC3755qu.c;
            }
            boolean zF = cVar.f();
            C2129ee c2129ee = obj instanceof C2129ee ? (C2129ee) obj : null;
            if (c2129ee != null) {
                cVar.a(c2129ee.a);
            }
            Throwable thE = zF ? null : cVar.e();
            oj.a = thE;
            FW fw = FW.a;
            if (thE != null) {
                k0(bdU, thE);
            }
            C4295xb c4295xbP = P(interfaceC0377Bs);
            return (c4295xbP == null || !C0(cVar, c4295xbP, obj)) ? O(cVar, obj) : AbstractC3755qu.b;
        }
    }

    @Override // defpackage.InterfaceC1830bu
    public final InterfaceC0745Mj C(InterfaceC3750qp interfaceC3750qp) {
        return c(false, true, interfaceC3750qp);
    }

    public final boolean C0(c cVar, C4295xb c4295xb, Object obj) {
        while (InterfaceC1830bu.a.d(c4295xb.e, false, false, new b(this, cVar, c4295xb, obj), 1, null) == DD.a) {
            c4295xb = j0(c4295xb);
            if (c4295xb == null) {
                return false;
            }
        }
        return true;
    }

    public final boolean D(Throwable th) {
        return E(th);
    }

    public final boolean E(Object obj) throws Throwable {
        Object objE0 = AbstractC3755qu.a;
        if (T() && (objE0 = H(obj)) == AbstractC3755qu.b) {
            return true;
        }
        if (objE0 == AbstractC3755qu.a) {
            objE0 = e0(obj);
        }
        if (objE0 == AbstractC3755qu.a || objE0 == AbstractC3755qu.b) {
            return true;
        }
        if (objE0 == AbstractC3755qu.d) {
            return false;
        }
        w(objE0);
        return true;
    }

    @Override // defpackage.InterfaceC1830bu
    public final Object F(InterfaceC0793Of interfaceC0793Of) {
        if (c0()) {
            Object objD0 = d0(interfaceC0793Of);
            return objD0 == AbstractC0378Bt.d() ? objD0 : FW.a;
        }
        AbstractC3347lu.j(interfaceC0793Of.getContext());
        return FW.a;
    }

    public void G(Throwable th) throws Throwable {
        E(th);
    }

    public final Object H(Object obj) {
        Object objA0;
        do {
            Object objW = W();
            if (!(objW instanceof InterfaceC0377Bs) || ((objW instanceof c) && ((c) objW).g())) {
                return AbstractC3755qu.a;
            }
            objA0 = A0(objW, new C2129ee(N(obj), false, 2, null));
        } while (objA0 == AbstractC3755qu.c);
        return objA0;
    }

    public final boolean I(Throwable th) {
        if (b0()) {
            return true;
        }
        boolean z = th instanceof CancellationException;
        InterfaceC4214wb interfaceC4214wbV = V();
        if (interfaceC4214wbV == null || interfaceC4214wbV == DD.a) {
            return z;
        }
        return interfaceC4214wbV.b(th) || z;
    }

    public String J() {
        return "Job was cancelled";
    }

    public boolean K(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return E(th) && S();
    }

    public final void L(InterfaceC0377Bs interfaceC0377Bs, Object obj) throws Throwable {
        InterfaceC4214wb interfaceC4214wbV = V();
        if (interfaceC4214wbV != null) {
            interfaceC4214wbV.dispose();
            s0(DD.a);
        }
        C2129ee c2129ee = obj instanceof C2129ee ? (C2129ee) obj : null;
        Throwable th = c2129ee != null ? c2129ee.a : null;
        if (!(interfaceC0377Bs instanceof AbstractC3593ou)) {
            BD bdC = interfaceC0377Bs.c();
            if (bdC != null) {
                l0(bdC, th);
                return;
            }
            return;
        }
        try {
            ((AbstractC3593ou) interfaceC0377Bs).x(th);
        } catch (Throwable th2) {
            Y(new C2375he("Exception in completion handler " + interfaceC0377Bs + " for " + this, th2));
        }
    }

    public final void M(c cVar, C4295xb c4295xb, Object obj) {
        C4295xb c4295xbJ0 = j0(c4295xb);
        if (c4295xbJ0 == null || !C0(cVar, c4295xbJ0, obj)) {
            w(O(cVar, obj));
        }
    }

    public final Throwable N(Object obj) {
        if (obj == null ? true : obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            return th == null ? new C1987cu(J(), null, this) : th;
        }
        if (obj != null) {
            return ((InterfaceC3216kG) obj).x();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
    }

    public final Object O(c cVar, Object obj) throws Throwable {
        boolean zF;
        Throwable thR;
        C2129ee c2129ee = obj instanceof C2129ee ? (C2129ee) obj : null;
        Throwable th = c2129ee != null ? c2129ee.a : null;
        synchronized (cVar) {
            zF = cVar.f();
            List listI = cVar.i(th);
            thR = R(cVar, listI);
            if (thR != null) {
                s(thR, listI);
            }
        }
        if (thR != null && thR != th) {
            obj = new C2129ee(thR, false, 2, null);
        }
        if (thR != null && (I(thR) || X(thR))) {
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            }
            ((C2129ee) obj).b();
        }
        if (!zF) {
            m0(thR);
        }
        n0(obj);
        AbstractC2403i0.a(a, this, cVar, AbstractC3755qu.g(obj));
        L(cVar, obj);
        return obj;
    }

    public final C4295xb P(InterfaceC0377Bs interfaceC0377Bs) {
        C4295xb c4295xb = interfaceC0377Bs instanceof C4295xb ? (C4295xb) interfaceC0377Bs : null;
        if (c4295xb != null) {
            return c4295xb;
        }
        BD bdC = interfaceC0377Bs.c();
        if (bdC != null) {
            return j0(bdC);
        }
        return null;
    }

    public final Throwable Q(Object obj) {
        C2129ee c2129ee = obj instanceof C2129ee ? (C2129ee) obj : null;
        if (c2129ee != null) {
            return c2129ee.a;
        }
        return null;
    }

    public final Throwable R(c cVar, List list) {
        Object next;
        Object obj = null;
        if (list.isEmpty()) {
            if (cVar.f()) {
                return new C1987cu(J(), null, this);
            }
            return null;
        }
        List list2 = list;
        Iterator it = list2.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((Throwable) next) instanceof CancellationException);
        Throwable th = (Throwable) next;
        if (th != null) {
            return th;
        }
        Throwable th2 = (Throwable) list.get(0);
        if (th2 instanceof KU) {
            for (Object obj2 : list2) {
                Throwable th3 = (Throwable) obj2;
                if (th3 != th2 && (th3 instanceof KU)) {
                    obj = obj2;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    public boolean S() {
        return true;
    }

    public boolean T() {
        return false;
    }

    public final BD U(InterfaceC0377Bs interfaceC0377Bs) {
        BD bdC = interfaceC0377Bs.c();
        if (bdC != null) {
            return bdC;
        }
        if (interfaceC0377Bs instanceof C1045Xk) {
            return new BD();
        }
        if (interfaceC0377Bs instanceof AbstractC3593ou) {
            q0((AbstractC3593ou) interfaceC0377Bs);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + interfaceC0377Bs).toString());
    }

    public final InterfaceC4214wb V() {
        return (InterfaceC4214wb) this._parentHandle;
    }

    public final Object W() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof PE)) {
                return obj;
            }
            ((PE) obj).c(this);
        }
    }

    public boolean X(Throwable th) {
        return false;
    }

    public final void Z(InterfaceC1830bu interfaceC1830bu) {
        if (interfaceC1830bu == null) {
            s0(DD.a);
            return;
        }
        interfaceC1830bu.start();
        InterfaceC4214wb interfaceC4214wbA = interfaceC1830bu.A(this);
        s0(interfaceC4214wbA);
        if (z()) {
            interfaceC4214wbA.dispose();
            s0(DD.a);
        }
    }

    public final boolean a0() {
        Object objW = W();
        return (objW instanceof C2129ee) || ((objW instanceof c) && ((c) objW).f());
    }

    public boolean b0() {
        return false;
    }

    @Override // defpackage.InterfaceC1830bu
    public final InterfaceC0745Mj c(boolean z, boolean z2, InterfaceC3750qp interfaceC3750qp) {
        AbstractC3593ou abstractC3593ouH0 = h0(interfaceC3750qp, z);
        while (true) {
            Object objW = W();
            if (objW instanceof C1045Xk) {
                C1045Xk c1045Xk = (C1045Xk) objW;
                if (!c1045Xk.isActive()) {
                    p0(c1045Xk);
                } else if (AbstractC2403i0.a(a, this, objW, abstractC3593ouH0)) {
                    return abstractC3593ouH0;
                }
            } else {
                Throwable thE = null;
                if (!(objW instanceof InterfaceC0377Bs)) {
                    if (z2) {
                        C2129ee c2129ee = objW instanceof C2129ee ? (C2129ee) objW : null;
                        interfaceC3750qp.invoke(c2129ee != null ? c2129ee.a : null);
                    }
                    return DD.a;
                }
                BD bdC = ((InterfaceC0377Bs) objW).c();
                if (bdC != null) {
                    InterfaceC0745Mj interfaceC0745Mj = DD.a;
                    if (z && (objW instanceof c)) {
                        synchronized (objW) {
                            try {
                                thE = ((c) objW).e();
                                if (thE == null || ((interfaceC3750qp instanceof C4295xb) && !((c) objW).g())) {
                                    if (q(objW, bdC, abstractC3593ouH0)) {
                                        if (thE == null) {
                                            return abstractC3593ouH0;
                                        }
                                        interfaceC0745Mj = abstractC3593ouH0;
                                    }
                                }
                                FW fw = FW.a;
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                    if (thE != null) {
                        if (z2) {
                            interfaceC3750qp.invoke(thE);
                        }
                        return interfaceC0745Mj;
                    }
                    if (q(objW, bdC, abstractC3593ouH0)) {
                        return abstractC3593ouH0;
                    }
                } else {
                    if (objW == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    }
                    q0((AbstractC3593ou) objW);
                }
            }
        }
    }

    public final boolean c0() {
        Object objW;
        do {
            objW = W();
            if (!(objW instanceof InterfaceC0377Bs)) {
                return false;
            }
        } while (t0(objW) < 0);
        return true;
    }

    @Override // defpackage.InterfaceC1830bu
    public void cancel(CancellationException cancellationException) throws Throwable {
        if (cancellationException == null) {
            cancellationException = new C1987cu(J(), null, this);
        }
        G(cancellationException);
    }

    public final Object d0(InterfaceC0793Of interfaceC0793Of) {
        C4374ya c4374ya = new C4374ya(AbstractC0352At.c(interfaceC0793Of), 1);
        c4374ya.A();
        AbstractC0333Aa.a(c4374ya, C(new NL(c4374ya)));
        Object objX = c4374ya.x();
        if (objX == AbstractC0378Bt.d()) {
            AbstractC3416mi.c(interfaceC0793Of);
        }
        return objX == AbstractC0378Bt.d() ? objX : FW.a;
    }

    public final Object e0(Object obj) throws Throwable {
        Throwable thN = null;
        while (true) {
            Object objW = W();
            if (objW instanceof c) {
                synchronized (objW) {
                    if (((c) objW).h()) {
                        return AbstractC3755qu.d;
                    }
                    boolean zF = ((c) objW).f();
                    if (obj != null || !zF) {
                        if (thN == null) {
                            thN = N(obj);
                        }
                        ((c) objW).a(thN);
                    }
                    Throwable thE = zF ? null : ((c) objW).e();
                    if (thE != null) {
                        k0(((c) objW).c(), thE);
                    }
                    return AbstractC3755qu.a;
                }
            }
            if (!(objW instanceof InterfaceC0377Bs)) {
                return AbstractC3755qu.d;
            }
            if (thN == null) {
                thN = N(obj);
            }
            InterfaceC0377Bs interfaceC0377Bs = (InterfaceC0377Bs) objW;
            if (!interfaceC0377Bs.isActive()) {
                Object objA0 = A0(objW, new C2129ee(thN, false, 2, null));
                if (objA0 == AbstractC3755qu.a) {
                    throw new IllegalStateException(("Cannot happen in " + objW).toString());
                }
                if (objA0 != AbstractC3755qu.c) {
                    return objA0;
                }
            } else if (z0(interfaceC0377Bs, thN)) {
                return AbstractC3755qu.a;
            }
        }
    }

    public final boolean f0(Object obj) {
        Object objA0;
        do {
            objA0 = A0(W(), obj);
            if (objA0 == AbstractC3755qu.a) {
                return false;
            }
            if (objA0 == AbstractC3755qu.b) {
                return true;
            }
        } while (objA0 == AbstractC3755qu.c);
        w(objA0);
        return true;
    }

    @Override // defpackage.InterfaceC0988Vf
    public Object fold(Object obj, InterfaceC0526Fp interfaceC0526Fp) {
        return InterfaceC1830bu.a.b(this, obj, interfaceC0526Fp);
    }

    public final Object g0(Object obj) {
        Object objA0;
        do {
            objA0 = A0(W(), obj);
            if (objA0 == AbstractC3755qu.a) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, Q(obj));
            }
        } while (objA0 == AbstractC3755qu.c);
        return objA0;
    }

    @Override // defpackage.InterfaceC0988Vf.b, defpackage.InterfaceC0988Vf
    public InterfaceC0988Vf.b get(InterfaceC0988Vf.c cVar) {
        return InterfaceC1830bu.a.c(this, cVar);
    }

    @Override // defpackage.InterfaceC1830bu
    public final InterfaceC4362yO getChildren() {
        return BO.b(new e(null));
    }

    @Override // defpackage.InterfaceC0988Vf.b
    public final InterfaceC0988Vf.c getKey() {
        return InterfaceC1830bu.s;
    }

    public final AbstractC3593ou h0(InterfaceC3750qp interfaceC3750qp, boolean z) {
        AbstractC3593ou c0582Ht;
        if (z) {
            c0582Ht = interfaceC3750qp instanceof AbstractC2068du ? (AbstractC2068du) interfaceC3750qp : null;
            if (c0582Ht == null) {
                c0582Ht = new C0556Gt(interfaceC3750qp);
            }
        } else {
            c0582Ht = interfaceC3750qp instanceof AbstractC3593ou ? (AbstractC3593ou) interfaceC3750qp : null;
            if (c0582Ht == null) {
                c0582Ht = new C0582Ht(interfaceC3750qp);
            }
        }
        c0582Ht.z(this);
        return c0582Ht;
    }

    @Override // defpackage.InterfaceC1830bu
    public final CancellationException i() {
        Object objW = W();
        if (!(objW instanceof c)) {
            if (objW instanceof InterfaceC0377Bs) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            if (objW instanceof C2129ee) {
                return w0(this, ((C2129ee) objW).a, null, 1, null);
            }
            return new C1987cu(AbstractC3498ni.a(this) + " has completed normally", null, this);
        }
        Throwable thE = ((c) objW).e();
        if (thE != null) {
            CancellationException cancellationExceptionV0 = v0(thE, AbstractC3498ni.a(this) + " is cancelling");
            if (cancellationExceptionV0 != null) {
                return cancellationExceptionV0;
            }
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    public String i0() {
        return AbstractC3498ni.a(this);
    }

    @Override // defpackage.InterfaceC1830bu
    public boolean isActive() {
        Object objW = W();
        return (objW instanceof InterfaceC0377Bs) && ((InterfaceC0377Bs) objW).isActive();
    }

    public final C4295xb j0(C0533Fw c0533Fw) {
        while (c0533Fw.r()) {
            c0533Fw = c0533Fw.o();
        }
        while (true) {
            c0533Fw = c0533Fw.n();
            if (!c0533Fw.r()) {
                if (c0533Fw instanceof C4295xb) {
                    return (C4295xb) c0533Fw;
                }
                if (c0533Fw instanceof BD) {
                    return null;
                }
            }
        }
    }

    public final void k0(BD bd, Throwable th) throws Throwable {
        m0(th);
        C2375he c2375he = null;
        for (C0533Fw c0533FwN = (C0533Fw) bd.m(); !AbstractC4492zt.d(c0533FwN, bd); c0533FwN = c0533FwN.n()) {
            if (c0533FwN instanceof AbstractC2068du) {
                AbstractC3593ou abstractC3593ou = (AbstractC3593ou) c0533FwN;
                try {
                    abstractC3593ou.x(th);
                } catch (Throwable th2) {
                    if (c2375he != null) {
                        AbstractC0773Nl.a(c2375he, th2);
                    } else {
                        c2375he = new C2375he("Exception in completion handler " + abstractC3593ou + " for " + this, th2);
                        FW fw = FW.a;
                    }
                }
            }
        }
        if (c2375he != null) {
            Y(c2375he);
        }
        I(th);
    }

    public final void l0(BD bd, Throwable th) throws Throwable {
        C2375he c2375he = null;
        for (C0533Fw c0533FwN = (C0533Fw) bd.m(); !AbstractC4492zt.d(c0533FwN, bd); c0533FwN = c0533FwN.n()) {
            if (c0533FwN instanceof AbstractC3593ou) {
                AbstractC3593ou abstractC3593ou = (AbstractC3593ou) c0533FwN;
                try {
                    abstractC3593ou.x(th);
                } catch (Throwable th2) {
                    if (c2375he != null) {
                        AbstractC0773Nl.a(c2375he, th2);
                    } else {
                        c2375he = new C2375he("Exception in completion handler " + abstractC3593ou + " for " + this, th2);
                        FW fw = FW.a;
                    }
                }
            }
        }
        if (c2375he != null) {
            Y(c2375he);
        }
    }

    @Override // defpackage.InterfaceC0988Vf
    public InterfaceC0988Vf minusKey(InterfaceC0988Vf.c cVar) {
        return InterfaceC1830bu.a.e(this, cVar);
    }

    public final void p0(C1045Xk c1045Xk) {
        BD bd = new BD();
        Object c4491zs = bd;
        if (!c1045Xk.isActive()) {
            c4491zs = new C4491zs(bd);
        }
        AbstractC2403i0.a(a, this, c1045Xk, c4491zs);
    }

    @Override // defpackage.InterfaceC0988Vf
    public InterfaceC0988Vf plus(InterfaceC0988Vf interfaceC0988Vf) {
        return InterfaceC1830bu.a.f(this, interfaceC0988Vf);
    }

    public final boolean q(Object obj, BD bd, AbstractC3593ou abstractC3593ou) {
        int iW;
        d dVar = new d(abstractC3593ou, this, obj);
        do {
            iW = bd.o().w(abstractC3593ou, bd, dVar);
            if (iW == 1) {
                return true;
            }
        } while (iW != 2);
        return false;
    }

    public final void q0(AbstractC3593ou abstractC3593ou) {
        abstractC3593ou.i(new BD());
        AbstractC2403i0.a(a, this, abstractC3593ou, abstractC3593ou.n());
    }

    @Override // defpackage.InterfaceC4376yb
    public final void r(InterfaceC3216kG interfaceC3216kG) throws Throwable {
        E(interfaceC3216kG);
    }

    public final void r0(AbstractC3593ou abstractC3593ou) {
        Object objW;
        do {
            objW = W();
            if (!(objW instanceof AbstractC3593ou)) {
                if (!(objW instanceof InterfaceC0377Bs) || ((InterfaceC0377Bs) objW).c() == null) {
                    return;
                }
                abstractC3593ou.s();
                return;
            }
            if (objW != abstractC3593ou) {
                return;
            }
        } while (!AbstractC2403i0.a(a, this, objW, AbstractC3755qu.g));
    }

    public final void s(Throwable th, List list) throws IllegalAccessException, InvocationTargetException {
        if (list.size() <= 1) {
            return;
        }
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Throwable th2 = (Throwable) it.next();
            if (th2 != th && th2 != th && !(th2 instanceof CancellationException) && setNewSetFromMap.add(th2)) {
                AbstractC0773Nl.a(th, th2);
            }
        }
    }

    public final void s0(InterfaceC4214wb interfaceC4214wb) {
        this._parentHandle = interfaceC4214wb;
    }

    @Override // defpackage.InterfaceC1830bu
    public final boolean start() {
        int iT0;
        do {
            iT0 = t0(W());
            if (iT0 == 0) {
                return false;
            }
        } while (iT0 != 1);
        return true;
    }

    public final int t0(Object obj) {
        if (obj instanceof C1045Xk) {
            if (((C1045Xk) obj).isActive()) {
                return 0;
            }
            if (!AbstractC2403i0.a(a, this, obj, AbstractC3755qu.g)) {
                return -1;
            }
            o0();
            return 1;
        }
        if (!(obj instanceof C4491zs)) {
            return 0;
        }
        if (!AbstractC2403i0.a(a, this, obj, ((C4491zs) obj).c())) {
            return -1;
        }
        o0();
        return 1;
    }

    public String toString() {
        return x0() + '@' + AbstractC3498ni.b(this);
    }

    public final String u0(Object obj) {
        if (!(obj instanceof c)) {
            if (obj instanceof InterfaceC0377Bs) {
                return ((InterfaceC0377Bs) obj).isActive() ? "Active" : "New";
            }
            return obj instanceof C2129ee ? "Cancelled" : "Completed";
        }
        c cVar = (c) obj;
        if (cVar.f()) {
            return "Cancelling";
        }
        return cVar.g() ? "Completing" : "Active";
    }

    public final CancellationException v0(Throwable th, String str) {
        CancellationException c1987cu = th instanceof CancellationException ? (CancellationException) th : null;
        if (c1987cu == null) {
            if (str == null) {
                str = J();
            }
            c1987cu = new C1987cu(str, th, this);
        }
        return c1987cu;
    }

    @Override // defpackage.InterfaceC3216kG
    public CancellationException x() {
        Throwable thE;
        Object objW = W();
        if (objW instanceof c) {
            thE = ((c) objW).e();
        } else if (objW instanceof C2129ee) {
            thE = ((C2129ee) objW).a;
        } else {
            if (objW instanceof InterfaceC0377Bs) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + objW).toString());
            }
            thE = null;
        }
        CancellationException cancellationException = thE instanceof CancellationException ? (CancellationException) thE : null;
        if (cancellationException != null) {
            return cancellationException;
        }
        return new C1987cu("Parent job is " + u0(objW), thE, this);
    }

    public final String x0() {
        return i0() + '{' + u0(W()) + '}';
    }

    public final Object y(InterfaceC0793Of interfaceC0793Of) throws Throwable {
        Object objW;
        do {
            objW = W();
            if (!(objW instanceof InterfaceC0377Bs)) {
                if (objW instanceof C2129ee) {
                    throw ((C2129ee) objW).a;
                }
                return AbstractC3755qu.h(objW);
            }
        } while (t0(objW) < 0);
        return B(interfaceC0793Of);
    }

    public final boolean y0(InterfaceC0377Bs interfaceC0377Bs, Object obj) throws Throwable {
        if (!AbstractC2403i0.a(a, this, interfaceC0377Bs, AbstractC3755qu.g(obj))) {
            return false;
        }
        m0(null);
        n0(obj);
        L(interfaceC0377Bs, obj);
        return true;
    }

    @Override // defpackage.InterfaceC1830bu
    public final boolean z() {
        return !(W() instanceof InterfaceC0377Bs);
    }

    public final boolean z0(InterfaceC0377Bs interfaceC0377Bs, Throwable th) throws Throwable {
        BD bdU = U(interfaceC0377Bs);
        if (bdU == null) {
            return false;
        }
        if (!AbstractC2403i0.a(a, this, interfaceC0377Bs, new c(bdU, false, th))) {
            return false;
        }
        k0(bdU, th);
        return true;
    }

    public void Y(Throwable th) throws Throwable {
        throw th;
    }

    public void m0(Throwable th) {
    }

    public void n0(Object obj) {
    }

    public void o0() {
    }

    public void w(Object obj) {
    }
}
