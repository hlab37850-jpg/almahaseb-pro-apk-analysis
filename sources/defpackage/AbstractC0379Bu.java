package defpackage;

/* JADX INFO: renamed from: Bu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0379Bu {
    public int a;
    public int b;

    public final int a() {
        int i = this.b;
        if (i < 0) {
            return 0;
        }
        return i;
    }

    public final int b() {
        return this.b + 1;
    }

    public final String c() {
        int i = this.a;
        if (i == 0) {
            return "ROOT";
        }
        if (i != 1) {
            return i != 2 ? "?" : "OBJECT";
        }
        return "ARRAY";
    }

    public final boolean d() {
        return this.a == 1;
    }

    public final boolean e() {
        return this.a == 2;
    }

    public final boolean f() {
        return this.a == 0;
    }
}
