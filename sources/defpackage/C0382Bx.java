package defpackage;

/* JADX INFO: renamed from: Bx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0382Bx {
    public final String a;
    public final C1001Vs b;

    public C0382Bx(String str, C1001Vs c1001Vs) {
        AbstractC4492zt.h(str, "value");
        AbstractC4492zt.h(c1001Vs, "range");
        this.a = str;
        this.b = c1001Vs;
    }

    public final C1001Vs a() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0382Bx)) {
            return false;
        }
        C0382Bx c0382Bx = (C0382Bx) obj;
        return AbstractC4492zt.d(this.a, c0382Bx.a) && AbstractC4492zt.d(this.b, c0382Bx.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "MatchGroup(value=" + this.a + ", range=" + this.b + ')';
    }
}
