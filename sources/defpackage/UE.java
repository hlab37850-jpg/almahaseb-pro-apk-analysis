package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public abstract class UE {
    public static final char[] e = {'+', '-', '*', '/', '%', '^', '!', '#', 167, '$', '&', ';', ':', '~', '<', '>', '|', '='};
    public final int a;
    public final boolean b;
    public final String c;
    public final int d;

    public UE(String str, int i, boolean z, int i2) {
        this.a = i;
        this.b = z;
        this.c = str;
        this.d = i2;
    }

    public static boolean d(char c) {
        for (char c2 : e) {
            if (c == c2) {
                return true;
            }
        }
        return false;
    }

    public abstract double a(double... dArr);

    public int b() {
        return this.a;
    }

    public int c() {
        return this.d;
    }

    public boolean e() {
        return this.b;
    }
}
