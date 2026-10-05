package defpackage;

import com.google.android.gms.internal.vision.A;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Wf0 {
    public static final Vf0 a = c();
    public static final Vf0 b = new A();

    public static Vf0 a() {
        return a;
    }

    public static Vf0 b() {
        return b;
    }

    public static Vf0 c() {
        try {
            return (Vf0) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
