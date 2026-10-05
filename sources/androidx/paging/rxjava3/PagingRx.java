package androidx.paging.rxjava3;

import androidx.annotation.CheckResult;
import androidx.paging.Pager;
import androidx.paging.PagingData;
import defpackage.AbstractC3132jE;
import defpackage.AbstractC3258kn;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes2.dex */
public final class PagingRx {
    public static final <T> AbstractC3258kn cachedIn(AbstractC3258kn abstractC3258kn, InterfaceC2052dg interfaceC2052dg) {
        return PagingRx__PagingRxKt.cachedIn(abstractC3258kn, interfaceC2052dg);
    }

    @CheckResult
    public static final <T> PagingData<T> filter(PagingData<T> pagingData, InterfaceC3750qp interfaceC3750qp) {
        return PagingRx__RxPagingDataKt.filter(pagingData, interfaceC3750qp);
    }

    @CheckResult
    public static final <T, R> PagingData<R> flatMap(PagingData<T> pagingData, InterfaceC3750qp interfaceC3750qp) {
        return PagingRx__RxPagingDataKt.flatMap(pagingData, interfaceC3750qp);
    }

    public static final <Key, Value> AbstractC3258kn getFlowable(Pager<Key, Value> pager) {
        return PagingRx__PagingRxKt.getFlowable(pager);
    }

    public static final <Key, Value> AbstractC3132jE getObservable(Pager<Key, Value> pager) {
        return PagingRx__PagingRxKt.getObservable(pager);
    }

    @CheckResult
    public static final <T extends R, R> PagingData<R> insertSeparators(PagingData<T> pagingData, InterfaceC0526Fp interfaceC0526Fp) {
        return PagingRx__RxPagingDataKt.insertSeparators(pagingData, interfaceC0526Fp);
    }

    @CheckResult
    public static final <T, R> PagingData<R> map(PagingData<T> pagingData, InterfaceC3750qp interfaceC3750qp) {
        return PagingRx__RxPagingDataKt.map(pagingData, interfaceC3750qp);
    }

    public static final <T> AbstractC3132jE cachedIn(AbstractC3132jE abstractC3132jE, InterfaceC2052dg interfaceC2052dg) {
        return PagingRx__PagingRxKt.cachedIn(abstractC3132jE, interfaceC2052dg);
    }
}
