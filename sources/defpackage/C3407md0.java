package defpackage;

import com.google.android.gms.internal.play_billing.zzfo;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: renamed from: md0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3407md0 {
    public static final C3407md0 c = new C3407md0();
    public final ConcurrentMap b = new ConcurrentHashMap();
    public final InterfaceC3895sd0 a = new Sc0();

    public static C3407md0 a() {
        return c;
    }

    public final InterfaceC3814rd0 b(Class cls) {
        zzfo.zzc(cls, "messageType");
        ConcurrentMap concurrentMap = this.b;
        InterfaceC3814rd0 interfaceC3814rd0A = (InterfaceC3814rd0) concurrentMap.get(cls);
        if (interfaceC3814rd0A == null) {
            interfaceC3814rd0A = this.a.a(cls);
            zzfo.zzc(cls, "messageType");
            InterfaceC3814rd0 interfaceC3814rd0 = (InterfaceC3814rd0) concurrentMap.putIfAbsent(cls, interfaceC3814rd0A);
            if (interfaceC3814rd0 != null) {
                return interfaceC3814rd0;
            }
        }
        return interfaceC3814rd0A;
    }
}
