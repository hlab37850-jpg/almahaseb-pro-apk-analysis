package defpackage;

import com.google.android.gms.internal.clearcut.n;

/* JADX INFO: renamed from: qa0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC3728qa0 {
    public static final InterfaceC3155ja0 a = c();
    public static final InterfaceC3155ja0 b = new n();

    public static InterfaceC3155ja0 a() {
        return a;
    }

    public static InterfaceC3155ja0 b() {
        return b;
    }

    public static InterfaceC3155ja0 c() {
        try {
            return (InterfaceC3155ja0) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
