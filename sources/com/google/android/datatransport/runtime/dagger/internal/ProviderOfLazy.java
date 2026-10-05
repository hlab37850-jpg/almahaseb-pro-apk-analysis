package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.Lazy;
import defpackage.AI;

/* JADX INFO: loaded from: classes2.dex */
public final class ProviderOfLazy<T> implements AI {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final AI provider;

    private ProviderOfLazy(AI ai) {
        this.provider = ai;
    }

    public static <T> AI create(AI ai) {
        return new ProviderOfLazy((AI) Preconditions.checkNotNull(ai));
    }

    @Override // defpackage.AI
    public Lazy<T> get() {
        return DoubleCheck.lazy(this.provider);
    }
}
