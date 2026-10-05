package defpackage;

import androidx.core.location.LocationRequestCompat;

/* JADX INFO: renamed from: Xi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1043Xi {
    public static final Object a(long j, InterfaceC0793Of interfaceC0793Of) {
        if (j <= 0) {
            return FW.a;
        }
        C4374ya c4374ya = new C4374ya(AbstractC0352At.c(interfaceC0793Of), 1);
        c4374ya.A();
        if (j < LocationRequestCompat.PASSIVE_INTERVAL) {
            b(c4374ya.getContext()).g(j, c4374ya);
        }
        Object objX = c4374ya.x();
        if (objX == AbstractC0378Bt.d()) {
            AbstractC3416mi.c(interfaceC0793Of);
        }
        return objX == AbstractC0378Bt.d() ? objX : FW.a;
    }

    public static final InterfaceC1017Wi b(InterfaceC0988Vf interfaceC0988Vf) {
        InterfaceC0988Vf.b bVar = interfaceC0988Vf.get(InterfaceC0854Qf.o);
        InterfaceC1017Wi interfaceC1017Wi = bVar instanceof InterfaceC1017Wi ? (InterfaceC1017Wi) bVar : null;
        return interfaceC1017Wi == null ? AbstractC0545Gi.a() : interfaceC1017Wi;
    }
}
