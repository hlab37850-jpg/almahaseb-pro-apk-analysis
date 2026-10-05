package androidx.paging;

import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0988Vf;
import defpackage.InterfaceC2052dg;

/* JADX INFO: loaded from: classes2.dex */
public final class PagingLiveData {
    public static final <T> LiveData<PagingData<T>> cachedIn(LiveData<PagingData<T>> liveData, Lifecycle lifecycle) {
        AbstractC4492zt.h(liveData, "<this>");
        AbstractC4492zt.h(lifecycle, "lifecycle");
        return FlowLiveDataConversions.asLiveData$default(CachedPagingDataKt.cachedIn(FlowLiveDataConversions.asFlow(liveData), LifecycleKt.getCoroutineScope(lifecycle)), (InterfaceC0988Vf) null, 0L, 3, (Object) null);
    }

    public static final <Key, Value> LiveData<PagingData<Value>> getLiveData(Pager<Key, Value> pager) {
        AbstractC4492zt.h(pager, "<this>");
        return FlowLiveDataConversions.asLiveData$default(pager.getFlow(), (InterfaceC0988Vf) null, 0L, 3, (Object) null);
    }

    public static final <T> LiveData<PagingData<T>> cachedIn(LiveData<PagingData<T>> liveData, ViewModel viewModel) {
        AbstractC4492zt.h(liveData, "<this>");
        AbstractC4492zt.h(viewModel, "viewModel");
        return FlowLiveDataConversions.asLiveData$default(CachedPagingDataKt.cachedIn(FlowLiveDataConversions.asFlow(liveData), ViewModelKt.getViewModelScope(viewModel)), (InterfaceC0988Vf) null, 0L, 3, (Object) null);
    }

    public static final <T> LiveData<PagingData<T>> cachedIn(LiveData<PagingData<T>> liveData, InterfaceC2052dg interfaceC2052dg) {
        AbstractC4492zt.h(liveData, "<this>");
        AbstractC4492zt.h(interfaceC2052dg, "scope");
        return FlowLiveDataConversions.asLiveData$default(CachedPagingDataKt.cachedIn(FlowLiveDataConversions.asFlow(liveData), interfaceC2052dg), (InterfaceC0988Vf) null, 0L, 3, (Object) null);
    }
}
