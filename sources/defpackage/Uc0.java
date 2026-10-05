package defpackage;

import com.google.android.gms.internal.auth.zzez;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes2.dex */
public final class Uc0 {
    public static final Uc0 c = new Uc0();
    public final ConcurrentMap b = new ConcurrentHashMap();
    public final InterfaceC1808bd0 a = new C3651pc0();

    public static Uc0 a() {
        return c;
    }

    public final Zc0 b(Class cls) {
        zzez.zzf(cls, "messageType");
        Zc0 zc0A = (Zc0) this.b.get(cls);
        if (zc0A == null) {
            zc0A = this.a.a(cls);
            zzez.zzf(cls, "messageType");
            zzez.zzf(zc0A, "schema");
            Zc0 zc0 = (Zc0) this.b.putIfAbsent(cls, zc0A);
            if (zc0 != null) {
                return zc0;
            }
        }
        return zc0A;
    }
}
