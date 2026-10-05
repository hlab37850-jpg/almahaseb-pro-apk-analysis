package androidx.paging;

import androidx.annotation.VisibleForTesting;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC2371hc;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class InvalidatingPagingSourceFactory<Key, Value> implements PagingSourceFactory<Key, Value> {
    private final InterfaceC3588op pagingSourceFactory;
    private final CopyOnWriteArrayList<PagingSource<Key, Value>> pagingSources;

    /* JADX INFO: renamed from: androidx.paging.InvalidatingPagingSourceFactory$invalidate$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final Boolean invoke(PagingSource<Key, Value> pagingSource) {
            return Boolean.valueOf(pagingSource.getInvalid());
        }
    }

    public InvalidatingPagingSourceFactory(InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3588op, "pagingSourceFactory");
        this.pagingSourceFactory = interfaceC3588op;
        this.pagingSources = new CopyOnWriteArrayList<>();
    }

    @VisibleForTesting
    public static /* synthetic */ void getPagingSources$paging_common$annotations() {
    }

    public final CopyOnWriteArrayList<PagingSource<Key, Value>> getPagingSources$paging_common() {
        return this.pagingSources;
    }

    public final void invalidate() {
        for (PagingSource<Key, Value> pagingSource : this.pagingSources) {
            if (!pagingSource.getInvalid()) {
                pagingSource.invalidate();
            }
        }
        AbstractC2371hc.M(this.pagingSources, AnonymousClass1.INSTANCE);
    }

    @Override // androidx.paging.PagingSourceFactory, defpackage.InterfaceC3588op
    public PagingSource<Key, Value> invoke() {
        PagingSource<Key, Value> pagingSource = (PagingSource) this.pagingSourceFactory.invoke();
        this.pagingSources.add(pagingSource);
        return pagingSource;
    }
}
