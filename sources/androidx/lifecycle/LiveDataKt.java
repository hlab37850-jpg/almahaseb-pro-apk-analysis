package androidx.lifecycle;

import androidx.annotation.MainThread;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes2.dex */
public final class LiveDataKt {
    @MainThread
    public static final <T> Observer<T> observe(LiveData<T> liveData, LifecycleOwner lifecycleOwner, final InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(liveData, "<this>");
        AbstractC4492zt.h(lifecycleOwner, "owner");
        AbstractC4492zt.h(interfaceC3750qp, "onChanged");
        Observer<T> observer = new Observer() { // from class: androidx.lifecycle.LiveDataKt$observe$wrappedObserver$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                interfaceC3750qp.invoke(t);
            }
        };
        liveData.observe(lifecycleOwner, observer);
        return observer;
    }
}
