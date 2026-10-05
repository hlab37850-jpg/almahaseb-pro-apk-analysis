package androidx.paging;

import defpackage.AbstractC0378Bt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3252ki;
import defpackage.LL;
import defpackage.XS;

/* JADX INFO: loaded from: classes2.dex */
@InterfaceC3252ki(c = "androidx.paging.PageFetcher$flow$1$3$downstreamFlow$1", f = "PageFetcher.kt", l = {}, m = "invokeSuspend")
public final class PageFetcher$flow$1$3$downstreamFlow$1 extends XS implements InterfaceC0526Fp {
    /* synthetic */ Object L$0;
    int label;

    public PageFetcher$flow$1$3$downstreamFlow$1(InterfaceC0793Of interfaceC0793Of) {
        super(2, interfaceC0793Of);
    }

    @Override // defpackage.AbstractC2171f7
    public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
        PageFetcher$flow$1$3$downstreamFlow$1 pageFetcher$flow$1$3$downstreamFlow$1 = new PageFetcher$flow$1$3$downstreamFlow$1(interfaceC0793Of);
        pageFetcher$flow$1$3$downstreamFlow$1.L$0 = obj;
        return pageFetcher$flow$1$3$downstreamFlow$1;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo13invoke(PageEvent<Value> pageEvent, InterfaceC0793Of interfaceC0793Of) {
        return ((PageFetcher$flow$1$3$downstreamFlow$1) create(pageEvent, interfaceC0793Of)).invokeSuspend(FW.a);
    }

    @Override // defpackage.AbstractC2171f7
    public final Object invokeSuspend(Object obj) throws Throwable {
        AbstractC0378Bt.d();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        LL.b(obj);
        PageEvent pageEvent = (PageEvent) this.L$0;
        Logger logger = LoggerKt.getLOGGER();
        if (logger != null && logger.isLoggable(2)) {
            logger.log(2, "Sent " + pageEvent, null);
        }
        return FW.a;
    }
}
