package defpackage;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: renamed from: ya, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C4374ya extends AbstractC4229wj implements InterfaceC4293xa, InterfaceC2297gg {
    public static final /* synthetic */ AtomicIntegerFieldUpdater g = AtomicIntegerFieldUpdater.newUpdater(C4374ya.class, "_decision");
    public static final /* synthetic */ AtomicReferenceFieldUpdater h = AtomicReferenceFieldUpdater.newUpdater(C4374ya.class, Object.class, "_state");
    private volatile /* synthetic */ int _decision;
    private volatile /* synthetic */ Object _state;
    public final InterfaceC0793Of d;
    public final InterfaceC0988Vf e;
    public InterfaceC0745Mj f;

    public C4374ya(InterfaceC0793Of interfaceC0793Of, int i) {
        super(i);
        this.d = interfaceC0793Of;
        this.e = interfaceC0793Of.getContext();
        this._decision = 0;
        this._state = Z1.a;
    }

    private final boolean D() {
        return AbstractC4310xj.c(this.c) && ((C3986tj) this.d).s();
    }

    public static /* synthetic */ void L(C4374ya c4374ya, Object obj, int i, InterfaceC3750qp interfaceC3750qp, int i2, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
        }
        if ((i2 & 4) != 0) {
            interfaceC3750qp = null;
        }
        c4374ya.K(obj, i, interfaceC3750qp);
    }

    private final boolean N() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed");
            }
        } while (!g.compareAndSet(this, 0, 2));
        return true;
    }

    private final boolean P() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended");
            }
        } while (!g.compareAndSet(this, 0, 1));
        return true;
    }

    public void A() {
        InterfaceC0745Mj interfaceC0745MjB = B();
        if (interfaceC0745MjB != null && C()) {
            interfaceC0745MjB.dispose();
            this.f = DD.a;
        }
    }

    public final InterfaceC0745Mj B() {
        InterfaceC1830bu interfaceC1830bu = (InterfaceC1830bu) getContext().get(InterfaceC1830bu.s);
        if (interfaceC1830bu == null) {
            return null;
        }
        InterfaceC0745Mj interfaceC0745MjD = InterfaceC1830bu.a.d(interfaceC1830bu, true, false, new C4133vb(this), 2, null);
        this.f = interfaceC0745MjD;
        return interfaceC0745MjD;
    }

    public boolean C() {
        return !(y() instanceof FD);
    }

    public final AbstractC4050ua E(InterfaceC3750qp interfaceC3750qp) {
        return interfaceC3750qp instanceof AbstractC4050ua ? (AbstractC4050ua) interfaceC3750qp : new C0530Ft(interfaceC3750qp);
    }

    public final void F(InterfaceC3750qp interfaceC3750qp, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + interfaceC3750qp + ", already has " + obj).toString());
    }

    public String G() {
        return "CancellableContinuation";
    }

    public final void H(Throwable th) {
        if (s(th)) {
            return;
        }
        m(th);
        u();
    }

    public final void I() {
        Throwable thV;
        InterfaceC0793Of interfaceC0793Of = this.d;
        C3986tj c3986tj = interfaceC0793Of instanceof C3986tj ? (C3986tj) interfaceC0793Of : null;
        if (c3986tj == null || (thV = c3986tj.v(this)) == null) {
            return;
        }
        t();
        m(thV);
    }

    public final boolean J() {
        Object obj = this._state;
        if ((obj instanceof C1890ce) && ((C1890ce) obj).d != null) {
            t();
            return false;
        }
        this._decision = 0;
        this._state = Z1.a;
        return true;
    }

    public final void K(Object obj, int i, InterfaceC3750qp interfaceC3750qp) {
        Object obj2;
        do {
            obj2 = this._state;
            if (!(obj2 instanceof FD)) {
                if (obj2 instanceof C0411Da) {
                    C0411Da c0411Da = (C0411Da) obj2;
                    if (c0411Da.c()) {
                        if (interfaceC3750qp != null) {
                            r(interfaceC3750qp, c0411Da.a);
                            return;
                        }
                        return;
                    }
                }
                l(obj);
                throw new C1182Zu();
            }
        } while (!AbstractC2403i0.a(h, this, obj2, M((FD) obj2, obj, i, interfaceC3750qp, null)));
        u();
        v(i);
    }

    public final Object M(FD fd, Object obj, int i, InterfaceC3750qp interfaceC3750qp, Object obj2) {
        if (obj instanceof C2129ee) {
            return obj;
        }
        if (!AbstractC4310xj.b(i) && obj2 == null) {
            return obj;
        }
        if (interfaceC3750qp != null || (((fd instanceof AbstractC4050ua) && !(fd instanceof AbstractC4099v7)) || obj2 != null)) {
            return new C1890ce(obj, fd instanceof AbstractC4050ua ? (AbstractC4050ua) fd : null, interfaceC3750qp, obj2, null, 16, null);
        }
        return obj;
    }

    public final YS O(Object obj, Object obj2, InterfaceC3750qp interfaceC3750qp) {
        Object obj3;
        do {
            obj3 = this._state;
            if (!(obj3 instanceof FD)) {
                if ((obj3 instanceof C1890ce) && obj2 != null && ((C1890ce) obj3).d == obj2) {
                    return AbstractC4465za.a;
                }
                return null;
            }
        } while (!AbstractC2403i0.a(h, this, obj3, M((FD) obj3, obj, this.c, interfaceC3750qp, obj2)));
        u();
        return AbstractC4465za.a;
    }

    @Override // defpackage.InterfaceC4293xa
    public Object a(Object obj, Object obj2) {
        return O(obj, obj2, null);
    }

    @Override // defpackage.AbstractC4229wj
    public void b(Object obj, Throwable th) {
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof FD) {
                throw new IllegalStateException("Not completed");
            }
            if (obj2 instanceof C2129ee) {
                return;
            }
            if (obj2 instanceof C1890ce) {
                C1890ce c1890ce = (C1890ce) obj2;
                if (c1890ce.c()) {
                    throw new IllegalStateException("Must be called at most once");
                }
                if (AbstractC2403i0.a(h, this, obj2, C1890ce.b(c1890ce, null, null, null, null, th, 15, null))) {
                    c1890ce.d(this, th);
                    return;
                }
            } else if (AbstractC2403i0.a(h, this, obj2, new C1890ce(obj2, null, null, null, th, 14, null))) {
                return;
            }
        }
    }

    @Override // defpackage.AbstractC4229wj
    public final InterfaceC0793Of c() {
        return this.d;
    }

    @Override // defpackage.AbstractC4229wj
    public Throwable d(Object obj) {
        Throwable thD = super.d(obj);
        if (thD != null) {
            return thD;
        }
        return null;
    }

    @Override // defpackage.InterfaceC4293xa
    public void e(InterfaceC3750qp interfaceC3750qp) {
        AbstractC4050ua abstractC4050uaE = E(interfaceC3750qp);
        while (true) {
            Object obj = this._state;
            if (obj instanceof Z1) {
                if (AbstractC2403i0.a(h, this, obj, abstractC4050uaE)) {
                    return;
                }
            } else if (obj instanceof AbstractC4050ua) {
                F(interfaceC3750qp, obj);
            } else {
                if (obj instanceof C2129ee) {
                    C2129ee c2129ee = (C2129ee) obj;
                    if (!c2129ee.b()) {
                        F(interfaceC3750qp, obj);
                    }
                    if (obj instanceof C0411Da) {
                        if (!(obj instanceof C2129ee)) {
                            c2129ee = null;
                        }
                        q(interfaceC3750qp, c2129ee != null ? c2129ee.a : null);
                        return;
                    }
                    return;
                }
                if (obj instanceof C1890ce) {
                    C1890ce c1890ce = (C1890ce) obj;
                    if (c1890ce.b != null) {
                        F(interfaceC3750qp, obj);
                    }
                    if (abstractC4050uaE instanceof AbstractC4099v7) {
                        return;
                    }
                    if (c1890ce.c()) {
                        q(interfaceC3750qp, c1890ce.e);
                        return;
                    } else {
                        if (AbstractC2403i0.a(h, this, obj, C1890ce.b(c1890ce, null, abstractC4050uaE, null, null, null, 29, null))) {
                            return;
                        }
                    }
                } else {
                    if (abstractC4050uaE instanceof AbstractC4099v7) {
                        return;
                    }
                    if (AbstractC2403i0.a(h, this, obj, new C1890ce(obj, abstractC4050uaE, null, null, null, 28, null))) {
                        return;
                    }
                }
            }
        }
    }

    @Override // defpackage.AbstractC4229wj
    public Object f(Object obj) {
        return obj instanceof C1890ce ? ((C1890ce) obj).a : obj;
    }

    @Override // defpackage.InterfaceC2297gg
    public InterfaceC2297gg getCallerFrame() {
        InterfaceC0793Of interfaceC0793Of = this.d;
        if (interfaceC0793Of instanceof InterfaceC2297gg) {
            return (InterfaceC2297gg) interfaceC0793Of;
        }
        return null;
    }

    @Override // defpackage.InterfaceC0793Of
    public InterfaceC0988Vf getContext() {
        return this.e;
    }

    @Override // defpackage.InterfaceC4293xa
    public void h(AbstractC1040Xf abstractC1040Xf, Object obj) {
        InterfaceC0793Of interfaceC0793Of = this.d;
        C3986tj c3986tj = interfaceC0793Of instanceof C3986tj ? (C3986tj) interfaceC0793Of : null;
        L(this, obj, (c3986tj != null ? c3986tj.d : null) == abstractC1040Xf ? 4 : this.c, null, 4, null);
    }

    @Override // defpackage.AbstractC4229wj
    public Object i() {
        return y();
    }

    @Override // defpackage.InterfaceC4293xa
    public boolean isActive() {
        return y() instanceof FD;
    }

    @Override // defpackage.InterfaceC4293xa
    public Object j(Throwable th) {
        return O(new C2129ee(th, false, 2, null), null, null);
    }

    @Override // defpackage.InterfaceC4293xa
    public void k(Object obj, InterfaceC3750qp interfaceC3750qp) {
        K(obj, this.c, interfaceC3750qp);
    }

    public final Void l(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    @Override // defpackage.InterfaceC4293xa
    public boolean m(Throwable th) {
        Object obj;
        boolean z;
        do {
            obj = this._state;
            if (!(obj instanceof FD)) {
                return false;
            }
            z = obj instanceof AbstractC4050ua;
        } while (!AbstractC2403i0.a(h, this, obj, new C0411Da(this, th, z)));
        AbstractC4050ua abstractC4050ua = z ? (AbstractC4050ua) obj : null;
        if (abstractC4050ua != null) {
            p(abstractC4050ua, th);
        }
        u();
        v(this.c);
        return true;
    }

    @Override // defpackage.InterfaceC4293xa
    public Object n(Object obj, Object obj2, InterfaceC3750qp interfaceC3750qp) {
        return O(obj, obj2, interfaceC3750qp);
    }

    @Override // defpackage.InterfaceC4293xa
    public void o(Object obj) {
        v(this.c);
    }

    public final void p(AbstractC4050ua abstractC4050ua, Throwable th) {
        try {
            abstractC4050ua.a(th);
        } catch (Throwable th2) {
            AbstractC1247ag.a(getContext(), new C2375he("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void q(InterfaceC3750qp interfaceC3750qp, Throwable th) {
        try {
            interfaceC3750qp.invoke(th);
        } catch (Throwable th2) {
            AbstractC1247ag.a(getContext(), new C2375he("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void r(InterfaceC3750qp interfaceC3750qp, Throwable th) {
        try {
            interfaceC3750qp.invoke(th);
        } catch (Throwable th2) {
            AbstractC1247ag.a(getContext(), new C2375he("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    @Override // defpackage.InterfaceC0793Of
    public void resumeWith(Object obj) {
        L(this, AbstractC2457ie.b(obj, this), this.c, null, 4, null);
    }

    public final boolean s(Throwable th) {
        if (D()) {
            return ((C3986tj) this.d).t(th);
        }
        return false;
    }

    public final void t() {
        InterfaceC0745Mj interfaceC0745Mj = this.f;
        if (interfaceC0745Mj == null) {
            return;
        }
        interfaceC0745Mj.dispose();
        this.f = DD.a;
    }

    public String toString() {
        return G() + '(' + AbstractC3498ni.c(this.d) + "){" + z() + "}@" + AbstractC3498ni.b(this);
    }

    public final void u() {
        if (D()) {
            return;
        }
        t();
    }

    public final void v(int i) {
        if (N()) {
            return;
        }
        AbstractC4310xj.a(this, i);
    }

    public Throwable w(InterfaceC1830bu interfaceC1830bu) {
        return interfaceC1830bu.i();
    }

    public final Object x() {
        InterfaceC1830bu interfaceC1830bu;
        boolean zD = D();
        if (P()) {
            if (this.f == null) {
                B();
            }
            if (zD) {
                I();
            }
            return AbstractC0378Bt.d();
        }
        if (zD) {
            I();
        }
        Object objY = y();
        if (objY instanceof C2129ee) {
            throw ((C2129ee) objY).a;
        }
        if (!AbstractC4310xj.b(this.c) || (interfaceC1830bu = (InterfaceC1830bu) getContext().get(InterfaceC1830bu.s)) == null || interfaceC1830bu.isActive()) {
            return f(objY);
        }
        CancellationException cancellationExceptionI = interfaceC1830bu.i();
        b(objY, cancellationExceptionI);
        throw cancellationExceptionI;
    }

    public final Object y() {
        return this._state;
    }

    public final String z() {
        Object objY = y();
        if (objY instanceof FD) {
            return "Active";
        }
        return objY instanceof C0411Da ? "Cancelled" : "Completed";
    }
}
