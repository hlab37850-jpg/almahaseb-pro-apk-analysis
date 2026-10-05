package com.google.android.datatransport.runtime.dagger.internal;

import defpackage.AI;

/* JADX INFO: loaded from: classes2.dex */
public final class SingleCheck<T> implements AI {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Object UNINITIALIZED = new Object();
    private volatile Object instance = UNINITIALIZED;
    private volatile AI provider;

    private SingleCheck(AI ai) {
        this.provider = ai;
    }

    public static <P extends AI, T> AI provider(P p) {
        return ((p instanceof SingleCheck) || (p instanceof DoubleCheck)) ? p : new SingleCheck((AI) Preconditions.checkNotNull(p));
    }

    @Override // defpackage.AI
    public T get() {
        T t = (T) this.instance;
        if (t != UNINITIALIZED) {
            return t;
        }
        AI ai = this.provider;
        if (ai == null) {
            return (T) this.instance;
        }
        T t2 = (T) ai.get();
        this.instance = t2;
        this.provider = null;
        return t2;
    }
}
