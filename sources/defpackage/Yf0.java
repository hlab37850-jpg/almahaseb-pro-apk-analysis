package defpackage;

import com.google.android.gms.internal.vision.zzjf;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes2.dex */
public final class Yf0 {
    public static final Yf0 c = new Yf0();
    public final ConcurrentMap b = new ConcurrentHashMap();
    public final InterfaceC3413mg0 a = new Nf0();

    public static Yf0 a() {
        return c;
    }

    public final InterfaceC3167jg0 b(Class cls) {
        zzjf.zza(cls, "messageType");
        InterfaceC3167jg0 interfaceC3167jg0 = (InterfaceC3167jg0) this.b.get(cls);
        if (interfaceC3167jg0 != null) {
            return interfaceC3167jg0;
        }
        InterfaceC3167jg0 interfaceC3167jg0A = this.a.a(cls);
        zzjf.zza(cls, "messageType");
        zzjf.zza(interfaceC3167jg0A, "schema");
        InterfaceC3167jg0 interfaceC3167jg1 = (InterfaceC3167jg0) this.b.putIfAbsent(cls, interfaceC3167jg0A);
        return interfaceC3167jg1 != null ? interfaceC3167jg1 : interfaceC3167jg0A;
    }

    public final InterfaceC3167jg0 c(Object obj) {
        return b(obj.getClass());
    }
}
