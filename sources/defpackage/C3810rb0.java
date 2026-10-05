package defpackage;

/* JADX INFO: renamed from: rb0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3810rb0 {
    public final Object a;
    public final int b;

    public C3810rb0(Object obj, int i) {
        this.a = obj;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C3810rb0)) {
            return false;
        }
        C3810rb0 c3810rb0 = (C3810rb0) obj;
        return this.a == c3810rb0.a && this.b == c3810rb0.b;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.a) * 65535) + this.b;
    }
}
