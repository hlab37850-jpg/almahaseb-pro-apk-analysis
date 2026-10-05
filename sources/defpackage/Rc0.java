package defpackage;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Rc0 {
    public static final Pc0 a;
    public static final Pc0 b;

    static {
        Pc0 pc0;
        try {
            pc0 = (Pc0) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            pc0 = null;
        }
        a = pc0;
        b = new Pc0();
    }

    public static Pc0 a() {
        return a;
    }

    public static Pc0 b() {
        return b;
    }
}
