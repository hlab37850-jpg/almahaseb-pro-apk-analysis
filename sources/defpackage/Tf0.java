package defpackage;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Tf0 {
    public static final Rf0 a = c();
    public static final Rf0 b = new Qf0();

    public static Rf0 a() {
        return a;
    }

    public static Rf0 b() {
        return b;
    }

    public static Rf0 c() {
        try {
            return (Rf0) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
