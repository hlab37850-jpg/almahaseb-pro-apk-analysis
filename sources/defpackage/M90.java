package defpackage;

/* JADX INFO: loaded from: classes2.dex */
public abstract class M90 {
    public static final I90 a = c();
    public static final I90 b = new J90();

    public static I90 a() {
        return a;
    }

    public static I90 b() {
        return b;
    }

    public static I90 c() {
        try {
            return (I90) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
