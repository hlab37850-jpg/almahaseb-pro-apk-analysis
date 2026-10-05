package defpackage;

import com.google.android.gms.internal.play_billing.zzfi;

/* JADX INFO: loaded from: classes2.dex */
public final class Tb0 implements InterfaceC1889cd0 {
    public static final Tb0 a = new Tb0();

    public static Tb0 c() {
        return a;
    }

    @Override // defpackage.InterfaceC1889cd0
    public final boolean a(Class cls) {
        return zzfi.class.isAssignableFrom(cls);
    }

    @Override // defpackage.InterfaceC1889cd0
    public final InterfaceC1242ad0 b(Class cls) {
        if (!zzfi.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
        try {
            return (InterfaceC1242ad0) zzfi.zzn(cls.asSubclass(zzfi.class)).zzb(3, null, null);
        } catch (Exception e) {
            throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e);
        }
    }
}
