package androidx.paging;

import androidx.annotation.CheckResult;
import com.google.common.util.concurrent.AsyncFunction;
import defpackage.AbstractC4492zt;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class PagingDataFutures {
    @CheckResult
    public static final <T> PagingData<T> filter(PagingData<T> pagingData, AsyncFunction<T, Boolean> asyncFunction, Executor executor) {
        AbstractC4492zt.h(pagingData, "<this>");
        AbstractC4492zt.h(asyncFunction, "predicate");
        AbstractC4492zt.h(executor, "executor");
        return PagingDataTransforms.filter(pagingData, new PagingDataFutures$filterAsync$1(executor, asyncFunction, null));
    }

    @CheckResult
    public static final <T, R> PagingData<R> flatMap(PagingData<T> pagingData, AsyncFunction<T, Iterable<R>> asyncFunction, Executor executor) {
        AbstractC4492zt.h(pagingData, "<this>");
        AbstractC4492zt.h(asyncFunction, "transform");
        AbstractC4492zt.h(executor, "executor");
        return PagingDataTransforms.flatMap(pagingData, new PagingDataFutures$flatMapAsync$1(executor, asyncFunction, null));
    }

    @CheckResult
    public static final <T extends R, R> PagingData<R> insertSeparators(PagingData<T> pagingData, AsyncFunction<AdjacentItems<T>, R> asyncFunction, Executor executor) {
        AbstractC4492zt.h(pagingData, "<this>");
        AbstractC4492zt.h(asyncFunction, "generator");
        AbstractC4492zt.h(executor, "executor");
        return PagingDataTransforms.insertSeparators$default(pagingData, null, new PagingDataFutures$insertSeparatorsAsync$1(executor, asyncFunction, null), 1, null);
    }

    @CheckResult
    public static final <T, R> PagingData<R> map(PagingData<T> pagingData, AsyncFunction<T, R> asyncFunction, Executor executor) {
        AbstractC4492zt.h(pagingData, "<this>");
        AbstractC4492zt.h(asyncFunction, "transform");
        AbstractC4492zt.h(executor, "executor");
        return PagingDataTransforms.map(pagingData, new PagingDataFutures$mapAsync$1(executor, asyncFunction, null));
    }
}
