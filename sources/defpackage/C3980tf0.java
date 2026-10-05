package defpackage;

import com.google.android.gms.internal.vision.zzjb;

/* JADX INFO: renamed from: tf0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3980tf0 implements Uf0 {
    public static final C3980tf0 a = new C3980tf0();

    public static C3980tf0 c() {
        return a;
    }

    @Override // defpackage.Uf0
    public final boolean a(Class cls) {
        return zzjb.class.isAssignableFrom(cls);
    }

    @Override // defpackage.Uf0
    public final Sf0 b(Class cls) {
        if (!zzjb.class.isAssignableFrom(cls)) {
            String name = cls.getName();
            throw new IllegalArgumentException(name.length() != 0 ? "Unsupported message type: ".concat(name) : new String("Unsupported message type: "));
        }
        try {
            return (Sf0) zzjb.zza(cls.asSubclass(zzjb.class)).zza(zzjb.zzg.zzc, (Object) null, (Object) null);
        } catch (Exception e) {
            String name2 = cls.getName();
            throw new RuntimeException(name2.length() != 0 ? "Unable to get message info for ".concat(name2) : new String("Unable to get message info for "), e);
        }
    }
}
