package defpackage;

import com.google.android.gms.internal.auth.b;

/* JADX INFO: renamed from: hb0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2370hb0 {
    public static final AbstractC2124eb0 a = new b();
    public static final AbstractC2124eb0 b;

    static {
        AbstractC2124eb0 abstractC2124eb0;
        try {
            abstractC2124eb0 = (AbstractC2124eb0) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            abstractC2124eb0 = null;
        }
        b = abstractC2124eb0;
    }

    public static AbstractC2124eb0 a() {
        AbstractC2124eb0 abstractC2124eb0 = b;
        if (abstractC2124eb0 != null) {
            return abstractC2124eb0;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    public static AbstractC2124eb0 b() {
        return a;
    }
}
