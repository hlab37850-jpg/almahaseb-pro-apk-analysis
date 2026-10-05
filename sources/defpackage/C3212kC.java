package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: kC, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3212kC implements InterfaceC4202wQ {
    public final AtomicReference a = new AtomicReference();
    public final AtomicReference b = new AtomicReference();

    /* JADX INFO: renamed from: kC$a */
    public static final class a extends AtomicReference {
        public Object a;

        public a() {
        }

        public Object a() {
            Object objB = b();
            f(null);
            return objB;
        }

        public Object b() {
            return this.a;
        }

        public a c() {
            return (a) get();
        }

        public void e(a aVar) {
            lazySet(aVar);
        }

        public void f(Object obj) {
            this.a = obj;
        }

        public a(Object obj) {
            f(obj);
        }
    }

    public C3212kC() {
        a aVar = new a();
        e(aVar);
        f(aVar);
    }

    public a a() {
        return (a) this.b.get();
    }

    public a b() {
        return (a) this.b.get();
    }

    @Override // defpackage.InterfaceC4283xQ
    public void clear() {
        while (poll() != null && !isEmpty()) {
        }
    }

    public a d() {
        return (a) this.a.get();
    }

    public void e(a aVar) {
        this.b.lazySet(aVar);
    }

    public a f(a aVar) {
        return (a) this.a.getAndSet(aVar);
    }

    @Override // defpackage.InterfaceC4283xQ
    public boolean isEmpty() {
        return b() == d();
    }

    @Override // defpackage.InterfaceC4283xQ
    public boolean offer(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        a aVar = new a(obj);
        f(aVar).e(aVar);
        return true;
    }

    @Override // defpackage.InterfaceC4202wQ, defpackage.InterfaceC4283xQ
    public Object poll() {
        a aVarC;
        a aVarA = a();
        a aVarC2 = aVarA.c();
        if (aVarC2 != null) {
            Object objA = aVarC2.a();
            e(aVarC2);
            return objA;
        }
        if (aVarA == d()) {
            return null;
        }
        do {
            aVarC = aVarA.c();
        } while (aVarC == null);
        Object objA2 = aVarC.a();
        e(aVarC);
        return objA2;
    }
}
