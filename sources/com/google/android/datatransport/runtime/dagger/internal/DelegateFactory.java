package com.google.android.datatransport.runtime.dagger.internal;

import defpackage.AI;

/* JADX INFO: loaded from: classes2.dex */
public final class DelegateFactory<T> implements Factory<T> {
    private AI delegate;

    public static <T> void setDelegate(AI ai, AI ai2) {
        Preconditions.checkNotNull(ai2);
        DelegateFactory delegateFactory = (DelegateFactory) ai;
        if (delegateFactory.delegate != null) {
            throw new IllegalStateException();
        }
        delegateFactory.delegate = ai2;
    }

    @Override // com.google.android.datatransport.runtime.dagger.internal.Factory, defpackage.AI
    public T get() {
        AI ai = this.delegate;
        if (ai != null) {
            return (T) ai.get();
        }
        throw new IllegalStateException();
    }

    public AI getDelegate() {
        return (AI) Preconditions.checkNotNull(this.delegate);
    }

    @Deprecated
    public void setDelegatedProvider(AI ai) {
        setDelegate(this, ai);
    }
}
