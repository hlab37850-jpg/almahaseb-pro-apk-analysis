package androidx.paging;

import defpackage.AbstractC1047Xm;
import defpackage.AbstractC1224aP;
import defpackage.AbstractC4492zt;
import defpackage.CC;
import defpackage.EnumC2379hg;
import defpackage.I8;
import defpackage.InterfaceC0939Tm;
import defpackage.InterfaceC1830bu;
import defpackage.InterfaceC2052dg;
import defpackage.O8;
import defpackage.YO;

/* JADX INFO: loaded from: classes2.dex */
public final class CachedPageEventFlow<T> {
    private final InterfaceC0939Tm downstreamFlow;
    private final InterfaceC1830bu job;
    private final CC mutableSharedSrc;
    private final FlattenedPageController<T> pageController;
    private final YO sharedForDownstream;

    public CachedPageEventFlow(InterfaceC0939Tm interfaceC0939Tm, InterfaceC2052dg interfaceC2052dg) {
        AbstractC4492zt.h(interfaceC0939Tm, "src");
        AbstractC4492zt.h(interfaceC2052dg, "scope");
        this.pageController = new FlattenedPageController<>();
        CC ccA = AbstractC1224aP.a(1, Integer.MAX_VALUE, I8.SUSPEND);
        this.mutableSharedSrc = ccA;
        this.sharedForDownstream = AbstractC1047Xm.C(ccA, new CachedPageEventFlow$sharedForDownstream$1(this, null));
        InterfaceC1830bu interfaceC1830buD = O8.d(interfaceC2052dg, null, EnumC2379hg.LAZY, new CachedPageEventFlow$job$1(interfaceC0939Tm, this, null), 1, null);
        interfaceC1830buD.C(new CachedPageEventFlow$job$2$1(this));
        this.job = interfaceC1830buD;
        this.downstreamFlow = AbstractC1047Xm.s(new CachedPageEventFlow$downstreamFlow$1(this, null));
    }

    public final void close() {
        InterfaceC1830bu.a.a(this.job, null, 1, null);
    }

    public final PageEvent.Insert<T> getCachedEvent$paging_common() {
        return this.pageController.getCachedEvent();
    }

    public final InterfaceC0939Tm getDownstreamFlow() {
        return this.downstreamFlow;
    }
}
