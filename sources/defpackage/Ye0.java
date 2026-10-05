package defpackage;

import com.google.android.gms.internal.vision.w;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Ye0 {
    public static final Xe0 a = new w();
    public static final Xe0 b = c();

    public static Xe0 a() {
        return a;
    }

    public static Xe0 b() {
        Xe0 xe0 = b;
        if (xe0 != null) {
            return xe0;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    public static Xe0 c() {
        try {
            return (Xe0) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
