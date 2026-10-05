package defpackage;

/* JADX INFO: renamed from: ce, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1890ce {
    public final Object a;
    public final AbstractC4050ua b;
    public final InterfaceC3750qp c;
    public final Object d;
    public final Throwable e;

    public C1890ce(Object obj, AbstractC4050ua abstractC4050ua, InterfaceC3750qp interfaceC3750qp, Object obj2, Throwable th) {
        this.a = obj;
        this.b = abstractC4050ua;
        this.c = interfaceC3750qp;
        this.d = obj2;
        this.e = th;
    }

    public static /* synthetic */ C1890ce b(C1890ce c1890ce, Object obj, AbstractC4050ua abstractC4050ua, InterfaceC3750qp interfaceC3750qp, Object obj2, Throwable th, int i, Object obj3) {
        if ((i & 1) != 0) {
            obj = c1890ce.a;
        }
        if ((i & 2) != 0) {
            abstractC4050ua = c1890ce.b;
        }
        AbstractC4050ua abstractC4050ua2 = abstractC4050ua;
        if ((i & 4) != 0) {
            interfaceC3750qp = c1890ce.c;
        }
        InterfaceC3750qp interfaceC3750qp2 = interfaceC3750qp;
        if ((i & 8) != 0) {
            obj2 = c1890ce.d;
        }
        Object obj4 = obj2;
        if ((i & 16) != 0) {
            th = c1890ce.e;
        }
        return c1890ce.a(obj, abstractC4050ua2, interfaceC3750qp2, obj4, th);
    }

    public final C1890ce a(Object obj, AbstractC4050ua abstractC4050ua, InterfaceC3750qp interfaceC3750qp, Object obj2, Throwable th) {
        return new C1890ce(obj, abstractC4050ua, interfaceC3750qp, obj2, th);
    }

    public final boolean c() {
        return this.e != null;
    }

    public final void d(C4374ya c4374ya, Throwable th) {
        AbstractC4050ua abstractC4050ua = this.b;
        if (abstractC4050ua != null) {
            c4374ya.p(abstractC4050ua, th);
        }
        InterfaceC3750qp interfaceC3750qp = this.c;
        if (interfaceC3750qp != null) {
            c4374ya.r(interfaceC3750qp, th);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1890ce)) {
            return false;
        }
        C1890ce c1890ce = (C1890ce) obj;
        return AbstractC4492zt.d(this.a, c1890ce.a) && AbstractC4492zt.d(this.b, c1890ce.b) && AbstractC4492zt.d(this.c, c1890ce.c) && AbstractC4492zt.d(this.d, c1890ce.d) && AbstractC4492zt.d(this.e, c1890ce.e);
    }

    public int hashCode() {
        Object obj = this.a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        AbstractC4050ua abstractC4050ua = this.b;
        int iHashCode2 = (iHashCode + (abstractC4050ua == null ? 0 : abstractC4050ua.hashCode())) * 31;
        InterfaceC3750qp interfaceC3750qp = this.c;
        int iHashCode3 = (iHashCode2 + (interfaceC3750qp == null ? 0 : interfaceC3750qp.hashCode())) * 31;
        Object obj2 = this.d;
        int iHashCode4 = (iHashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.e;
        return iHashCode4 + (th != null ? th.hashCode() : 0);
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.a + ", cancelHandler=" + this.b + ", onCancellation=" + this.c + ", idempotentResume=" + this.d + ", cancelCause=" + this.e + ')';
    }

    public /* synthetic */ C1890ce(Object obj, AbstractC4050ua abstractC4050ua, InterfaceC3750qp interfaceC3750qp, Object obj2, Throwable th, int i, AbstractC0419Di abstractC0419Di) {
        this(obj, (i & 2) != 0 ? null : abstractC4050ua, (i & 4) != 0 ? null : interfaceC3750qp, (i & 8) != 0 ? null : obj2, (i & 16) != 0 ? null : th);
    }
}
