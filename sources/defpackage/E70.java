package defpackage;

import com.google.android.gms.internal.clearcut.C1915j;

/* JADX INFO: loaded from: classes2.dex */
public abstract class E70 {
    public static final AbstractC4343y70 a = new C1915j();
    public static final AbstractC4343y70 b = a();

    public static AbstractC4343y70 a() {
        try {
            return (AbstractC4343y70) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    public static AbstractC4343y70 b() {
        return a;
    }

    public static AbstractC4343y70 c() {
        AbstractC4343y70 abstractC4343y70 = b;
        if (abstractC4343y70 != null) {
            return abstractC4343y70;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
