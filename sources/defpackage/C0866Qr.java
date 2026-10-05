package defpackage;

/* JADX INFO: renamed from: Qr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0866Qr {
    public final Object a;
    public final int b;

    public C0866Qr(Object obj) {
        this.b = System.identityHashCode(obj);
        this.a = obj;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0866Qr)) {
            return false;
        }
        C0866Qr c0866Qr = (C0866Qr) obj;
        return this.b == c0866Qr.b && this.a == c0866Qr.a;
    }

    public int hashCode() {
        return this.b;
    }
}
