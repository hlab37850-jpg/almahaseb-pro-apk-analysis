package androidx.paging;

import androidx.annotation.RestrictTo;
import defpackage.AbstractC1040Xf;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC2052dg;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class InitialPagedList<K, V> extends ContiguousPagedList<K, V> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InitialPagedList(InterfaceC2052dg interfaceC2052dg, AbstractC1040Xf abstractC1040Xf, AbstractC1040Xf abstractC1040Xf2, PagedList.Config config, K k) {
        super(new LegacyPagingSource(abstractC1040Xf, new InitialDataSource()), interfaceC2052dg, abstractC1040Xf, abstractC1040Xf2, null, config, PagingSource.LoadResult.Page.Companion.empty$paging_common(), k);
        AbstractC4492zt.h(interfaceC2052dg, "coroutineScope");
        AbstractC4492zt.h(abstractC1040Xf, "notifyDispatcher");
        AbstractC4492zt.h(abstractC1040Xf2, "backgroundDispatcher");
        AbstractC4492zt.h(config, "config");
    }
}
