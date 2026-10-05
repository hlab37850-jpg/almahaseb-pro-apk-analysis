package defpackage;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Af0 {
    public static final Af0 a;
    public static final Af0 b;

    static {
        Cf0 cf0 = null;
        a = new Bf0();
        b = new Ef0();
    }

    public Af0() {
    }

    public static Af0 b() {
        return a;
    }

    public static Af0 d() {
        return b;
    }

    public abstract List a(Object obj, long j);

    public abstract void c(Object obj, Object obj2, long j);

    public abstract void e(Object obj, long j);
}
