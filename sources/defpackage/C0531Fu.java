package defpackage;

/* JADX INFO: renamed from: Fu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C0531Fu extends AbstractC0379Bu {
    public final C0531Fu c;
    public String d;
    public C0531Fu e = null;

    public C0531Fu(int i, C0531Fu c0531Fu) {
        this.a = i;
        this.c = c0531Fu;
        this.b = -1;
    }

    public static C0531Fu j() {
        return new C0531Fu(0, null);
    }

    public final void g(StringBuilder sb) {
        int i = this.a;
        if (i != 2) {
            if (i != 1) {
                sb.append("/");
                return;
            }
            sb.append('[');
            sb.append(a());
            sb.append(']');
            return;
        }
        sb.append('{');
        if (this.d != null) {
            sb.append('\"');
            sb.append(this.d);
            sb.append('\"');
        } else {
            sb.append('?');
        }
        sb.append('}');
    }

    public final C0531Fu h() {
        C0531Fu c0531Fu = this.e;
        if (c0531Fu != null) {
            return c0531Fu.l(1);
        }
        C0531Fu c0531Fu2 = new C0531Fu(1, this);
        this.e = c0531Fu2;
        return c0531Fu2;
    }

    public final C0531Fu i() {
        C0531Fu c0531Fu = this.e;
        if (c0531Fu != null) {
            return c0531Fu.l(2);
        }
        C0531Fu c0531Fu2 = new C0531Fu(2, this);
        this.e = c0531Fu2;
        return c0531Fu2;
    }

    public final C0531Fu k() {
        return this.c;
    }

    public final C0531Fu l(int i) {
        this.a = i;
        this.b = -1;
        this.d = null;
        return this;
    }

    public final int m(String str) {
        if (this.a != 2 || this.d != null) {
            return 4;
        }
        this.d = str;
        return this.b < 0 ? 0 : 1;
    }

    public final int n() {
        int i = this.a;
        if (i == 2) {
            if (this.d == null) {
                return 5;
            }
            this.d = null;
            this.b++;
            return 2;
        }
        if (i == 1) {
            int i2 = this.b;
            this.b = i2 + 1;
            return i2 < 0 ? 0 : 1;
        }
        int i3 = this.b + 1;
        this.b = i3;
        return i3 == 0 ? 0 : 3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(64);
        g(sb);
        return sb.toString();
    }
}
