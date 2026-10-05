package androidx.paging.rxjava3;

import androidx.paging.DataSource;
import androidx.paging.PagedList;
import androidx.paging.PagedListConfigKt;
import defpackage.AN;
import defpackage.AbstractC3132jE;
import defpackage.AbstractC3258kn;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;
import defpackage.M6;

/* JADX INFO: loaded from: classes2.dex */
public final class RxPagedListKt {
    private static final <Key, Value> RxPagedListBuilder<Key, Value> createRxPagedListBuilder(DataSource.Factory<Key, Value> factory, PagedList.Config config, Key key, PagedList.BoundaryCallback<Value> boundaryCallback, AN an, AN an2) {
        RxPagedListBuilder<Key, Value> boundaryCallback2 = new RxPagedListBuilder(factory, config).setInitialLoadKey(key).setBoundaryCallback(boundaryCallback);
        if (an != null) {
            boundaryCallback2.setFetchScheduler(an);
        }
        if (an2 != null) {
            boundaryCallback2.setNotifyScheduler(an2);
        }
        return boundaryCallback2;
    }

    public static final <Key, Value> AbstractC3258kn toFlowable(DataSource.Factory<Key, Value> factory, PagedList.Config config, Key key, PagedList.BoundaryCallback<Value> boundaryCallback, AN an, AN an2, M6 m6) {
        AbstractC4492zt.h(factory, "<this>");
        AbstractC4492zt.h(config, "config");
        AbstractC4492zt.h(m6, "backpressureStrategy");
        return createRxPagedListBuilder(factory, config, key, boundaryCallback, an, an2).buildFlowable(m6);
    }

    public static final <Key, Value> AbstractC3132jE toObservable(DataSource.Factory<Key, Value> factory, PagedList.Config config, Key key, PagedList.BoundaryCallback<Value> boundaryCallback, AN an, AN an2) {
        AbstractC4492zt.h(factory, "<this>");
        AbstractC4492zt.h(config, "config");
        return createRxPagedListBuilder(factory, config, key, boundaryCallback, an, an2).buildObservable();
    }

    public static final <Key, Value> AbstractC3258kn toFlowable(DataSource.Factory<Key, Value> factory, int i, Key key, PagedList.BoundaryCallback<Value> boundaryCallback, AN an, AN an2, M6 m6) {
        AbstractC4492zt.h(factory, "<this>");
        AbstractC4492zt.h(m6, "backpressureStrategy");
        return createRxPagedListBuilder(factory, PagedListConfigKt.Config$default(i, 0, false, 0, 0, 30, null), key, boundaryCallback, an, an2).buildFlowable(m6);
    }

    public static final <Key, Value> AbstractC3132jE toObservable(DataSource.Factory<Key, Value> factory, int i, Key key, PagedList.BoundaryCallback<Value> boundaryCallback, AN an, AN an2) {
        AbstractC4492zt.h(factory, "<this>");
        return createRxPagedListBuilder(factory, PagedListConfigKt.Config$default(i, 0, false, 0, 0, 30, null), key, boundaryCallback, an, an2).buildObservable();
    }

    private static final <Key, Value> RxPagedListBuilder<Key, Value> createRxPagedListBuilder(InterfaceC3588op interfaceC3588op, PagedList.Config config, Key key, PagedList.BoundaryCallback<Value> boundaryCallback, AN an, AN an2) {
        RxPagedListBuilder<Key, Value> boundaryCallback2 = new RxPagedListBuilder(interfaceC3588op, config).setInitialLoadKey(key).setBoundaryCallback(boundaryCallback);
        if (an != null) {
            boundaryCallback2.setFetchScheduler(an);
        }
        if (an2 != null) {
            boundaryCallback2.setNotifyScheduler(an2);
        }
        return boundaryCallback2;
    }

    public static final <Key, Value> AbstractC3258kn toFlowable(InterfaceC3588op interfaceC3588op, PagedList.Config config, Key key, PagedList.BoundaryCallback<Value> boundaryCallback, AN an, AN an2, M6 m6) {
        AbstractC4492zt.h(interfaceC3588op, "<this>");
        AbstractC4492zt.h(config, "config");
        AbstractC4492zt.h(m6, "backpressureStrategy");
        return createRxPagedListBuilder(interfaceC3588op, config, key, boundaryCallback, an, an2).buildFlowable(m6);
    }

    public static final <Key, Value> AbstractC3132jE toObservable(InterfaceC3588op interfaceC3588op, PagedList.Config config, Key key, PagedList.BoundaryCallback<Value> boundaryCallback, AN an, AN an2) {
        AbstractC4492zt.h(interfaceC3588op, "<this>");
        AbstractC4492zt.h(config, "config");
        return createRxPagedListBuilder(interfaceC3588op, config, key, boundaryCallback, an, an2).buildObservable();
    }

    public static final <Key, Value> AbstractC3258kn toFlowable(InterfaceC3588op interfaceC3588op, int i, Key key, PagedList.BoundaryCallback<Value> boundaryCallback, AN an, AN an2, M6 m6) {
        AbstractC4492zt.h(interfaceC3588op, "<this>");
        AbstractC4492zt.h(m6, "backpressureStrategy");
        return createRxPagedListBuilder(interfaceC3588op, PagedListConfigKt.Config$default(i, 0, false, 0, 0, 30, null), key, boundaryCallback, an, an2).buildFlowable(m6);
    }

    public static final <Key, Value> AbstractC3132jE toObservable(InterfaceC3588op interfaceC3588op, int i, Key key, PagedList.BoundaryCallback<Value> boundaryCallback, AN an, AN an2) {
        AbstractC4492zt.h(interfaceC3588op, "<this>");
        return createRxPagedListBuilder(interfaceC3588op, PagedListConfigKt.Config$default(i, 0, false, 0, 0, 30, null), key, boundaryCallback, an, an2).buildObservable();
    }
}
