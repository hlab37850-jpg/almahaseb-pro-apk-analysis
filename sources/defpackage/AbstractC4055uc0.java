package defpackage;

/* JADX INFO: renamed from: uc0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC4055uc0 {
    public static final C3893sc0 a;
    public static final C3893sc0 b;

    static {
        C3893sc0 c3893sc0;
        try {
            c3893sc0 = (C3893sc0) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            c3893sc0 = null;
        }
        a = c3893sc0;
        b = new C3893sc0();
    }

    public static C3893sc0 a() {
        return a;
    }

    public static C3893sc0 b() {
        return b;
    }
}
