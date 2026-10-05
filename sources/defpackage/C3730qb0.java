package defpackage;

import com.google.android.gms.internal.auth.zzeu;

/* JADX INFO: renamed from: qb0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3730qb0 implements InterfaceC4298xc0 {
    public static final C3730qb0 a = new C3730qb0();

    public static C3730qb0 c() {
        return a;
    }

    @Override // defpackage.InterfaceC4298xc0
    public final boolean a(Class cls) {
        return zzeu.class.isAssignableFrom(cls);
    }

    @Override // defpackage.InterfaceC4298xc0
    public final InterfaceC4217wc0 b(Class cls) {
        if (!zzeu.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
        try {
            return (InterfaceC4217wc0) zzeu.zza(cls.asSubclass(zzeu.class)).zzi(3, null, null);
        } catch (Exception e) {
            throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e);
        }
    }
}
