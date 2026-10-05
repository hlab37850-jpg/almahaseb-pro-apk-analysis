package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: renamed from: Fw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0533Fw {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(C0533Fw.class, Object.class, "_next");
    public static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(C0533Fw.class, Object.class, "_prev");
    public static final /* synthetic */ AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(C0533Fw.class, Object.class, "_removedRef");
    volatile /* synthetic */ Object _next = this;
    volatile /* synthetic */ Object _prev = this;
    private volatile /* synthetic */ Object _removedRef = null;

    /* JADX INFO: renamed from: Fw$a */
    public static abstract class a extends Y5 {
        public final C0533Fw b;
        public C0533Fw c;

        public a(C0533Fw c0533Fw) {
            this.b = c0533Fw;
        }

        @Override // defpackage.Y5
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(C0533Fw c0533Fw, Object obj) {
            boolean z = obj == null;
            C0533Fw c0533Fw2 = z ? this.b : this.c;
            if (c0533Fw2 != null && AbstractC2403i0.a(C0533Fw.a, c0533Fw, this, c0533Fw2) && z) {
                C0533Fw c0533Fw3 = this.b;
                C0533Fw c0533Fw4 = this.c;
                AbstractC4492zt.e(c0533Fw4);
                c0533Fw3.l(c0533Fw4);
            }
        }
    }

    /* JADX INFO: renamed from: Fw$b */
    public static final class b extends PE {
    }

    public final void g(C0533Fw c0533Fw) {
        while (!o().h(c0533Fw, this)) {
        }
    }

    public final boolean h(C0533Fw c0533Fw, C0533Fw c0533Fw2) {
        b.lazySet(c0533Fw, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        atomicReferenceFieldUpdater.lazySet(c0533Fw, c0533Fw2);
        if (!AbstractC2403i0.a(atomicReferenceFieldUpdater, this, c0533Fw2, c0533Fw)) {
            return false;
        }
        c0533Fw.l(c0533Fw2);
        return true;
    }

    public final boolean i(C0533Fw c0533Fw) {
        b.lazySet(c0533Fw, this);
        a.lazySet(c0533Fw, this);
        while (m() == this) {
            if (AbstractC2403i0.a(a, this, this, c0533Fw)) {
                c0533Fw.l(this);
                return true;
            }
        }
        return false;
    }

    public final C0533Fw j(PE pe) {
        Object obj;
        while (true) {
            C0533Fw c0533Fw = (C0533Fw) this._prev;
            C0533Fw c0533Fw2 = c0533Fw;
            while (true) {
                C0533Fw c0533Fw3 = null;
                while (true) {
                    obj = c0533Fw2._next;
                    if (obj == this) {
                        if (c0533Fw == c0533Fw2) {
                            return c0533Fw2;
                        }
                        if (!AbstractC2403i0.a(b, this, c0533Fw, c0533Fw2)) {
                            break;
                        }
                        return c0533Fw2;
                    }
                    if (r()) {
                        return null;
                    }
                    if (obj == pe) {
                        return c0533Fw2;
                    }
                    if (obj instanceof PE) {
                        if (pe != null && pe.b((PE) obj)) {
                            return null;
                        }
                        ((PE) obj).c(c0533Fw2);
                        break;
                    }
                    if (!(obj instanceof C1785bK)) {
                        c0533Fw3 = c0533Fw2;
                        c0533Fw2 = (C0533Fw) obj;
                    } else {
                        if (c0533Fw3 != null) {
                            break;
                        }
                        c0533Fw2 = (C0533Fw) c0533Fw2._prev;
                    }
                }
                if (!AbstractC2403i0.a(a, c0533Fw3, c0533Fw2, ((C1785bK) obj).a)) {
                    break;
                }
                c0533Fw2 = c0533Fw3;
            }
        }
    }

    public final C0533Fw k(C0533Fw c0533Fw) {
        while (c0533Fw.r()) {
            c0533Fw = (C0533Fw) c0533Fw._prev;
        }
        return c0533Fw;
    }

    public final void l(C0533Fw c0533Fw) {
        C0533Fw c0533Fw2;
        do {
            c0533Fw2 = (C0533Fw) c0533Fw._prev;
            if (m() != c0533Fw) {
                return;
            }
        } while (!AbstractC2403i0.a(b, c0533Fw, c0533Fw2, this));
        if (r()) {
            c0533Fw.j(null);
        }
    }

    public final Object m() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof PE)) {
                return obj;
            }
            ((PE) obj).c(this);
        }
    }

    public final C0533Fw n() {
        return AbstractC0459Ew.b(m());
    }

    public final C0533Fw o() {
        C0533Fw c0533FwJ = j(null);
        return c0533FwJ == null ? k((C0533Fw) this._prev) : c0533FwJ;
    }

    public final void p() {
        ((C1785bK) m()).a.q();
    }

    public final void q() {
        C0533Fw c0533Fw = this;
        while (true) {
            Object objM = c0533Fw.m();
            if (!(objM instanceof C1785bK)) {
                c0533Fw.j(null);
                return;
            }
            c0533Fw = ((C1785bK) objM).a;
        }
    }

    public boolean r() {
        return m() instanceof C1785bK;
    }

    public boolean s() {
        return u() == null;
    }

    public final C0533Fw t() {
        while (true) {
            C0533Fw c0533Fw = (C0533Fw) m();
            if (c0533Fw == this) {
                return null;
            }
            if (c0533Fw.s()) {
                return c0533Fw;
            }
            c0533Fw.p();
        }
    }

    public String toString() {
        return new AbstractC3709qI(this) { // from class: Fw.c
            @Override // defpackage.InterfaceC1003Vu
            public Object get() {
                return AbstractC3498ni.a(this.receiver);
            }
        } + '@' + AbstractC3498ni.b(this);
    }

    public final C0533Fw u() {
        Object objM;
        C0533Fw c0533Fw;
        do {
            objM = m();
            if (objM instanceof C1785bK) {
                return ((C1785bK) objM).a;
            }
            if (objM == this) {
                return (C0533Fw) objM;
            }
            c0533Fw = (C0533Fw) objM;
        } while (!AbstractC2403i0.a(a, this, objM, c0533Fw.v()));
        c0533Fw.j(null);
        return null;
    }

    public final C1785bK v() {
        C1785bK c1785bK = (C1785bK) this._removedRef;
        if (c1785bK != null) {
            return c1785bK;
        }
        C1785bK c1785bK2 = new C1785bK(this);
        c.lazySet(this, c1785bK2);
        return c1785bK2;
    }

    public final int w(C0533Fw c0533Fw, C0533Fw c0533Fw2, a aVar) {
        b.lazySet(c0533Fw, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        atomicReferenceFieldUpdater.lazySet(c0533Fw, c0533Fw2);
        aVar.c = c0533Fw2;
        if (AbstractC2403i0.a(atomicReferenceFieldUpdater, this, c0533Fw2, aVar)) {
            return aVar.c(this) == null ? 1 : 2;
        }
        return 0;
    }
}
