package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: renamed from: tj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3986tj extends AbstractC4229wj implements InterfaceC2297gg, InterfaceC0793Of {
    public static final /* synthetic */ AtomicReferenceFieldUpdater h = AtomicReferenceFieldUpdater.newUpdater(C3986tj.class, Object.class, "_reusableCancellableContinuation");
    private volatile /* synthetic */ Object _reusableCancellableContinuation;
    public final AbstractC1040Xf d;
    public final InterfaceC0793Of e;
    public Object f;
    public final Object g;

    public C3986tj(AbstractC1040Xf abstractC1040Xf, InterfaceC0793Of interfaceC0793Of) {
        super(-1);
        this.d = abstractC1040Xf;
        this.e = interfaceC0793Of;
        this.f = AbstractC4067uj.a;
        this.g = AbstractC4368yU.b(getContext());
        this._reusableCancellableContinuation = null;
    }

    @Override // defpackage.AbstractC4229wj
    public void b(Object obj, Throwable th) {
        if (obj instanceof C2211fe) {
            ((C2211fe) obj).b.invoke(th);
        }
    }

    @Override // defpackage.InterfaceC2297gg
    public InterfaceC2297gg getCallerFrame() {
        InterfaceC0793Of interfaceC0793Of = this.e;
        if (interfaceC0793Of instanceof InterfaceC2297gg) {
            return (InterfaceC2297gg) interfaceC0793Of;
        }
        return null;
    }

    @Override // defpackage.InterfaceC0793Of
    public InterfaceC0988Vf getContext() {
        return this.e.getContext();
    }

    @Override // defpackage.AbstractC4229wj
    public Object i() {
        Object obj = this.f;
        this.f = AbstractC4067uj.a;
        return obj;
    }

    public final void l() {
        while (this._reusableCancellableContinuation == AbstractC4067uj.b) {
        }
    }

    public final C4374ya p() {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            if (obj == null) {
                this._reusableCancellableContinuation = AbstractC4067uj.b;
                return null;
            }
            if (obj instanceof C4374ya) {
                if (AbstractC2403i0.a(h, this, obj, AbstractC4067uj.b)) {
                    return (C4374ya) obj;
                }
            } else if (obj != AbstractC4067uj.b && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
    }

    public final void q(InterfaceC0988Vf interfaceC0988Vf, Object obj) {
        this.f = obj;
        this.c = 1;
        this.d.dispatchYield(interfaceC0988Vf, this);
    }

    public final C4374ya r() {
        Object obj = this._reusableCancellableContinuation;
        if (obj instanceof C4374ya) {
            return (C4374ya) obj;
        }
        return null;
    }

    @Override // defpackage.InterfaceC0793Of
    public void resumeWith(Object obj) {
        InterfaceC0988Vf context = this.e.getContext();
        Object objD = AbstractC2457ie.d(obj, null, 1, null);
        if (this.d.isDispatchNeeded(context)) {
            this.f = objD;
            this.c = 0;
            this.d.dispatch(context, this);
            return;
        }
        AbstractC0422Dl abstractC0422DlB = C4459zU.a.b();
        if (abstractC0422DlB.N()) {
            this.f = objD;
            this.c = 0;
            abstractC0422DlB.J(this);
            return;
        }
        abstractC0422DlB.L(true);
        try {
            InterfaceC0988Vf context2 = getContext();
            Object objC = AbstractC4368yU.c(context2, this.g);
            try {
                this.e.resumeWith(obj);
                FW fw = FW.a;
                AbstractC4368yU.a(context2, objC);
                while (abstractC0422DlB.Q()) {
                }
            } catch (Throwable th) {
                AbstractC4368yU.a(context2, objC);
                throw th;
            }
        } catch (Throwable th2) {
            try {
                g(th2, null);
            } finally {
                abstractC0422DlB.G(true);
            }
        }
    }

    public final boolean s() {
        return this._reusableCancellableContinuation != null;
    }

    public final boolean t(Throwable th) {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            YS ys = AbstractC4067uj.b;
            if (AbstractC4492zt.d(obj, ys)) {
                if (AbstractC2403i0.a(h, this, ys, th)) {
                    return true;
                }
            } else {
                if (obj instanceof Throwable) {
                    return true;
                }
                if (AbstractC2403i0.a(h, this, obj, null)) {
                    return false;
                }
            }
        }
    }

    public String toString() {
        return "DispatchedContinuation[" + this.d + ", " + AbstractC3498ni.c(this.e) + ']';
    }

    public final void u() {
        l();
        C4374ya c4374yaR = r();
        if (c4374yaR != null) {
            c4374yaR.t();
        }
    }

    public final Throwable v(InterfaceC4293xa interfaceC4293xa) {
        YS ys;
        do {
            Object obj = this._reusableCancellableContinuation;
            ys = AbstractC4067uj.b;
            if (obj != ys) {
                if (obj instanceof Throwable) {
                    if (AbstractC2403i0.a(h, this, obj, null)) {
                        return (Throwable) obj;
                    }
                    throw new IllegalArgumentException("Failed requirement.");
                }
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        } while (!AbstractC2403i0.a(h, this, ys, interfaceC4293xa));
        return null;
    }

    @Override // defpackage.AbstractC4229wj
    public InterfaceC0793Of c() {
        return this;
    }
}
