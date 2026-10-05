package androidx.paging.rxjava3;

import androidx.annotation.CheckResult;
import androidx.paging.PagingData;
import androidx.paging.PagingDataTransforms;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class PagingRx__RxPagingDataKt {
    @CheckResult
    public static final <T> PagingData<T> filter(PagingData<T> pagingData, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(pagingData, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "predicate");
        return PagingDataTransforms.filter(pagingData, new PagingRx__RxPagingDataKt$filterAsync$1(interfaceC3750qp, null));
    }

    @CheckResult
    public static final <T, R> PagingData<R> flatMap(PagingData<T> pagingData, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(pagingData, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "transform");
        return PagingDataTransforms.flatMap(pagingData, new PagingRx__RxPagingDataKt$flatMapAsync$1(interfaceC3750qp, null));
    }

    @CheckResult
    public static final <T extends R, R> PagingData<R> insertSeparators(PagingData<T> pagingData, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(pagingData, "<this>");
        AbstractC4492zt.h(interfaceC0526Fp, "generator");
        return PagingDataTransforms.insertSeparators$default(pagingData, null, new PagingRx__RxPagingDataKt$insertSeparatorsAsync$1(interfaceC0526Fp, null), 1, null);
    }

    @CheckResult
    public static final <T, R> PagingData<R> map(PagingData<T> pagingData, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(pagingData, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "transform");
        return PagingDataTransforms.map(pagingData, new PagingRx__RxPagingDataKt$mapAsync$1(interfaceC3750qp, null));
    }
}
