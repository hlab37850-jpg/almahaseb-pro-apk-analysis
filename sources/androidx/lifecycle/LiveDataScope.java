package androidx.lifecycle;

import defpackage.InterfaceC0793Of;

/* JADX INFO: loaded from: classes2.dex */
public interface LiveDataScope<T> {
    Object emit(T t, InterfaceC0793Of interfaceC0793Of);

    Object emitSource(LiveData<T> liveData, InterfaceC0793Of interfaceC0793Of);

    T getLatestValue();
}
