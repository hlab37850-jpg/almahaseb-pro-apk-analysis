package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes3.dex */
public final class HC implements GC, InterfaceC3552oO {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(HC.class, Object.class, "_state");
    volatile /* synthetic */ Object _state;

    public final class a extends b {
        public final InterfaceC4293xa g;

        /* JADX INFO: renamed from: HC$a$a, reason: collision with other inner class name */
        public static final class C0007a extends AbstractC2233fv implements InterfaceC3750qp {
            public final /* synthetic */ HC a;
            public final /* synthetic */ a b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0007a(HC hc, a aVar) {
                super(1);
                this.a = hc;
                this.b = aVar;
            }

            @Override // defpackage.InterfaceC3750qp
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return FW.a;
            }

            public final void invoke(Throwable th) {
                this.a.b(this.b.d);
            }
        }

        public a(Object obj, InterfaceC4293xa interfaceC4293xa) {
            super(obj);
            this.g = interfaceC4293xa;
        }

        @Override // defpackage.C0533Fw
        public String toString() {
            return "LockCont[" + this.d + ", " + this.g + "] for " + HC.this;
        }

        @Override // HC.b
        public void x() {
            this.g.o(AbstractC4465za.a);
        }

        @Override // HC.b
        public boolean z() {
            return y() && this.g.n(FW.a, null, new C0007a(HC.this, this)) != null;
        }
    }

    public abstract class b extends C0533Fw implements InterfaceC0745Mj {
        public static final /* synthetic */ AtomicIntegerFieldUpdater f = AtomicIntegerFieldUpdater.newUpdater(b.class, "isTaken");
        public final Object d;
        private volatile /* synthetic */ int isTaken = 0;

        public b(Object obj) {
            this.d = obj;
        }

        @Override // defpackage.InterfaceC0745Mj
        public final void dispose() {
            s();
        }

        public abstract void x();

        public final boolean y() {
            return f.compareAndSet(this, 0, 1);
        }

        public abstract boolean z();
    }

    public static final class c extends C0433Dw {
        public volatile Object owner;

        public c(Object obj) {
            this.owner = obj;
        }

        @Override // defpackage.C0533Fw
        public String toString() {
            return "LockedQueue[" + this.owner + ']';
        }
    }

    public static final class d extends Y5 {
        public final c b;

        public d(c cVar) {
            this.b = cVar;
        }

        @Override // defpackage.Y5
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(HC hc, Object obj) {
            AbstractC2403i0.a(HC.a, hc, this, obj == null ? IC.f : this.b);
        }

        @Override // defpackage.Y5
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Object g(HC hc) {
            if (this.b.x()) {
                return null;
            }
            return IC.b;
        }
    }

    public static final class e extends AbstractC2233fv implements InterfaceC3750qp {
        public final /* synthetic */ Object b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Object obj) {
            super(1);
            this.b = obj;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return FW.a;
        }

        public final void invoke(Throwable th) {
            HC.this.b(this.b);
        }
    }

    public HC(boolean z) {
        this._state = z ? IC.e : IC.f;
    }

    @Override // defpackage.GC
    public boolean a(Object obj) {
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof C1019Wk) {
                if (((C1019Wk) obj2).a != IC.d) {
                    return false;
                }
                if (AbstractC2403i0.a(a, this, obj2, obj == null ? IC.e : new C1019Wk(obj))) {
                    return true;
                }
            } else {
                if (obj2 instanceof c) {
                    if (((c) obj2).owner != obj) {
                        return false;
                    }
                    throw new IllegalStateException(("Already locked by " + obj).toString());
                }
                if (!(obj2 instanceof PE)) {
                    throw new IllegalStateException(("Illegal state " + obj2).toString());
                }
                ((PE) obj2).c(this);
            }
        }
    }

    @Override // defpackage.GC
    public void b(Object obj) {
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof C1019Wk) {
                if (obj != null) {
                    C1019Wk c1019Wk = (C1019Wk) obj2;
                    if (c1019Wk.a != obj) {
                        throw new IllegalStateException(("Mutex is locked by " + c1019Wk.a + " but expected " + obj).toString());
                    }
                } else if (((C1019Wk) obj2).a == IC.d) {
                    throw new IllegalStateException("Mutex is not locked");
                }
                if (AbstractC2403i0.a(a, this, obj2, IC.f)) {
                    return;
                }
            } else if (obj2 instanceof PE) {
                ((PE) obj2).c(this);
            } else {
                if (!(obj2 instanceof c)) {
                    throw new IllegalStateException(("Illegal state " + obj2).toString());
                }
                if (obj != null) {
                    c cVar = (c) obj2;
                    if (cVar.owner != obj) {
                        throw new IllegalStateException(("Mutex is locked by " + cVar.owner + " but expected " + obj).toString());
                    }
                }
                c cVar2 = (c) obj2;
                C0533Fw c0533FwT = cVar2.t();
                if (c0533FwT == null) {
                    d dVar = new d(cVar2);
                    if (AbstractC2403i0.a(a, this, obj2, dVar) && dVar.c(this) == null) {
                        return;
                    }
                } else {
                    b bVar = (b) c0533FwT;
                    if (bVar.z()) {
                        Object obj3 = bVar.d;
                        if (obj3 == null) {
                            obj3 = IC.c;
                        }
                        cVar2.owner = obj3;
                        bVar.x();
                        return;
                    }
                }
            }
        }
    }

    @Override // defpackage.GC
    public Object c(Object obj, InterfaceC0793Of interfaceC0793Of) {
        if (a(obj)) {
            return FW.a;
        }
        Object objD = d(obj, interfaceC0793Of);
        return objD == AbstractC0378Bt.d() ? objD : FW.a;
    }

    public final Object d(Object obj, InterfaceC0793Of interfaceC0793Of) {
        C4374ya c4374yaB = AbstractC0333Aa.b(AbstractC0352At.c(interfaceC0793Of));
        a aVar = new a(obj, c4374yaB);
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof C1019Wk) {
                C1019Wk c1019Wk = (C1019Wk) obj2;
                if (c1019Wk.a != IC.d) {
                    AbstractC2403i0.a(a, this, obj2, new c(c1019Wk.a));
                } else {
                    if (AbstractC2403i0.a(a, this, obj2, obj == null ? IC.e : new C1019Wk(obj))) {
                        c4374yaB.k(FW.a, new e(obj));
                        break;
                    }
                }
            } else if (obj2 instanceof c) {
                c cVar = (c) obj2;
                if (cVar.owner == obj) {
                    throw new IllegalStateException(("Already locked by " + obj).toString());
                }
                cVar.g(aVar);
                if (this._state == obj2 || !aVar.y()) {
                    AbstractC0333Aa.c(c4374yaB, aVar);
                    break;
                }
                aVar = new a(obj, c4374yaB);
            } else {
                if (!(obj2 instanceof PE)) {
                    throw new IllegalStateException(("Illegal state " + obj2).toString());
                }
                ((PE) obj2).c(this);
            }
        }
        Object objX = c4374yaB.x();
        if (objX == AbstractC0378Bt.d()) {
            AbstractC3416mi.c(interfaceC0793Of);
        }
        return objX == AbstractC0378Bt.d() ? objX : FW.a;
    }

    public String toString() {
        while (true) {
            Object obj = this._state;
            if (obj instanceof C1019Wk) {
                return "Mutex[" + ((C1019Wk) obj).a + ']';
            }
            if (!(obj instanceof PE)) {
                if (!(obj instanceof c)) {
                    throw new IllegalStateException(("Illegal state " + obj).toString());
                }
                return "Mutex[" + ((c) obj).owner + ']';
            }
            ((PE) obj).c(this);
        }
    }
}
