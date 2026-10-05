package androidx.paging;

import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0939Tm;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes2.dex */
public final class Pager<Key, Value> {
    private final InterfaceC0939Tm flow;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Pager(PagingConfig pagingConfig, InterfaceC3588op interfaceC3588op) {
        this(pagingConfig, null, interfaceC3588op, 2, null);
        AbstractC4492zt.h(pagingConfig, "config");
        AbstractC4492zt.h(interfaceC3588op, "pagingSourceFactory");
    }

    public static /* synthetic */ void getFlow$annotations() {
    }

    public final InterfaceC0939Tm getFlow() {
        return this.flow;
    }

    @ExperimentalPagingApi
    public Pager(PagingConfig pagingConfig, Key key, RemoteMediator<Key, Value> remoteMediator, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(pagingConfig, "config");
        AbstractC4492zt.h(interfaceC3588op, "pagingSourceFactory");
        this.flow = new PageFetcher(interfaceC3588op instanceof SuspendingPagingSourceFactory ? new Pager$flow$1(interfaceC3588op) : new Pager$flow$2(interfaceC3588op, null), key, pagingConfig, remoteMediator).getFlow();
    }

    public /* synthetic */ Pager(PagingConfig pagingConfig, Object obj, RemoteMediator remoteMediator, InterfaceC3588op interfaceC3588op, int i, AbstractC0419Di abstractC0419Di) {
        this(pagingConfig, (i & 2) != 0 ? null : obj, remoteMediator, interfaceC3588op);
    }

    public /* synthetic */ Pager(PagingConfig pagingConfig, Object obj, InterfaceC3588op interfaceC3588op, int i, AbstractC0419Di abstractC0419Di) {
        this(pagingConfig, (i & 2) != 0 ? null : obj, interfaceC3588op);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Pager(PagingConfig pagingConfig, Key key, InterfaceC3588op interfaceC3588op) {
        this(pagingConfig, key, null, interfaceC3588op);
        AbstractC4492zt.h(pagingConfig, "config");
        AbstractC4492zt.h(interfaceC3588op, "pagingSourceFactory");
    }
}
