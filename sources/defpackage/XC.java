package defpackage;

/* JADX INFO: loaded from: classes2.dex */
public abstract class XC {
    public final String a;
    public final int b;

    public XC(String str, int i) {
        this.a = str;
        this.b = i;
    }

    public abstract boolean a(int i);

    public abstract boolean b(int i, int i2);

    public abstract boolean c(int[] iArr, int i);

    public String d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    public final int hashCode() {
        return this.b;
    }

    public String toString() {
        return this.a;
    }
}
