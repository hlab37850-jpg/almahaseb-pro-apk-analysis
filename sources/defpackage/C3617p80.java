package defpackage;

import com.google.android.gms.internal.clearcut.zzcg;

/* JADX INFO: renamed from: p80, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3617p80 implements T90 {
    public static final C3617p80 a = new C3617p80();

    public static C3617p80 c() {
        return a;
    }

    @Override // defpackage.T90
    public final boolean a(Class cls) {
        return zzcg.class.isAssignableFrom(cls);
    }

    @Override // defpackage.T90
    public final P90 b(Class cls) {
        if (!zzcg.class.isAssignableFrom(cls)) {
            String name = cls.getName();
            throw new IllegalArgumentException(name.length() != 0 ? "Unsupported message type: ".concat(name) : new String("Unsupported message type: "));
        }
        try {
            return (P90) zzcg.zzc(cls.asSubclass(zzcg.class)).zza(zzcg.zzg.zzkf, (Object) null, (Object) null);
        } catch (Exception e) {
            String name2 = cls.getName();
            throw new RuntimeException(name2.length() != 0 ? "Unable to get message info for ".concat(name2) : new String("Unable to get message info for "), e);
        }
    }
}
