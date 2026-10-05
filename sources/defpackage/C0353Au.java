package defpackage;

/* JADX INFO: renamed from: Au, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0353Au extends AbstractC0379Bu {
    public final C0353Au c;
    public int d;
    public int e;
    public String f;
    public C0353Au g = null;

    public C0353Au(C0353Au c0353Au, int i, int i2, int i3) {
        this.a = i;
        this.c = c0353Au;
        this.d = i2;
        this.e = i3;
        this.b = -1;
    }

    public static C0353Au i() {
        return new C0353Au(null, 0, 1, 0);
    }

    public C0353Au g(int i, int i2) {
        C0353Au c0353Au = this.g;
        if (c0353Au != null) {
            c0353Au.n(1, i, i2);
            return c0353Au;
        }
        C0353Au c0353Au2 = new C0353Au(this, 1, i, i2);
        this.g = c0353Au2;
        return c0353Au2;
    }

    public C0353Au h(int i, int i2) {
        C0353Au c0353Au = this.g;
        if (c0353Au != null) {
            c0353Au.n(2, i, i2);
            return c0353Au;
        }
        C0353Au c0353Au2 = new C0353Au(this, 2, i, i2);
        this.g = c0353Au2;
        return c0353Au2;
    }

    public boolean j() {
        int i = this.b + 1;
        this.b = i;
        return this.a != 0 && i > 0;
    }

    public String k() {
        return this.f;
    }

    public C0353Au l() {
        return this.c;
    }

    public C4321xu m(Object obj) {
        return new C4321xu(obj, -1L, this.d, this.e);
    }

    public void n(int i, int i2, int i3) {
        this.a = i;
        this.b = -1;
        this.d = i2;
        this.e = i3;
        this.f = null;
    }

    public void o(String str) {
        this.f = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        int i = this.a;
        if (i == 0) {
            sb.append("/");
        } else if (i == 1) {
            sb.append('[');
            sb.append(a());
            sb.append(']');
        } else if (i == 2) {
            sb.append('{');
            if (this.f != null) {
                sb.append('\"');
                AbstractC3484nb.a(sb, this.f);
                sb.append('\"');
            } else {
                sb.append('?');
            }
            sb.append('}');
        }
        return sb.toString();
    }
}
