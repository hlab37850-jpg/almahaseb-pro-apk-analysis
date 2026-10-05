package defpackage;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Zd0 {
    public static final Class a = a("libcore.io.Memory");
    public static final boolean b;

    static {
        b = a("org.robolectric.Robolectric") != null;
    }

    public static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean b() {
        return (a == null || b) ? false : true;
    }

    public static Class c() {
        return a;
    }
}
