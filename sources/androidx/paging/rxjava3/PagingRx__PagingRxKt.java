package androidx.paging.rxjava3;

import androidx.paging.CachedPagingDataKt;
import androidx.paging.Pager;
import defpackage.AbstractC1047Xm;
import defpackage.AbstractC3132jE;
import defpackage.AbstractC3258kn;
import defpackage.AbstractC3952tJ;
import defpackage.AbstractC4492zt;
import defpackage.EM;
import defpackage.InterfaceC2052dg;
import defpackage.M6;

/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class PagingRx__PagingRxKt {
    public static final <T> AbstractC3132jE cachedIn(AbstractC3132jE abstractC3132jE, InterfaceC2052dg interfaceC2052dg) {
        AbstractC4492zt.h(abstractC3132jE, "<this>");
        AbstractC4492zt.h(interfaceC2052dg, "scope");
        AbstractC3258kn abstractC3258knN = abstractC3132jE.n(M6.LATEST);
        AbstractC4492zt.g(abstractC3258knN, "toFlowable(BackpressureStrategy.LATEST)");
        return EM.e(CachedPagingDataKt.cachedIn(AbstractC3952tJ.a(abstractC3258knN), interfaceC2052dg), null, 1, null);
    }

    public static final <Key, Value> AbstractC3258kn getFlowable(Pager<Key, Value> pager) {
        AbstractC4492zt.h(pager, "<this>");
        return EM.c(AbstractC1047Xm.h(pager.getFlow()), null, 1, null);
    }

    public static final <Key, Value> AbstractC3132jE getObservable(Pager<Key, Value> pager) {
        AbstractC4492zt.h(pager, "<this>");
        return EM.e(AbstractC1047Xm.h(pager.getFlow()), null, 1, null);
    }

    public static final <T> AbstractC3258kn cachedIn(AbstractC3258kn abstractC3258kn, InterfaceC2052dg interfaceC2052dg) {
        AbstractC4492zt.h(abstractC3258kn, "<this>");
        AbstractC4492zt.h(interfaceC2052dg, "scope");
        return EM.c(CachedPagingDataKt.cachedIn(AbstractC3952tJ.a(abstractC3258kn), interfaceC2052dg), null, 1, null);
    }
}
