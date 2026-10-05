package defpackage;

/* JADX INFO: renamed from: fe, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C2211fe {
    public final Object a;
    public final InterfaceC3750qp b;

    public C2211fe(Object obj, InterfaceC3750qp interfaceC3750qp) {
        this.a = obj;
        this.b = interfaceC3750qp;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2211fe)) {
            return false;
        }
        C2211fe c2211fe = (C2211fe) obj;
        return AbstractC4492zt.d(this.a, c2211fe.a) && AbstractC4492zt.d(this.b, c2211fe.b);
    }

    public int hashCode() {
        Object obj = this.a;
        return ((obj == null ? 0 : obj.hashCode()) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "CompletedWithCancellation(result=" + this.a + ", onCancellation=" + this.b + ')';
    }
}
