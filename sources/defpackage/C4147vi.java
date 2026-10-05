package defpackage;

/* JADX INFO: renamed from: vi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C4147vi extends AbstractC4309xi {
    public final String b;
    public final int c;
    public final boolean d;

    public C4147vi(int i, String str) {
        super(i);
        this.b = str;
        this.d = false;
        this.c = 0;
    }

    public String b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }

    public C4147vi(int i, String str, int i2) {
        super(i);
        this.d = true;
        this.c = i2;
        this.b = str;
    }
}
