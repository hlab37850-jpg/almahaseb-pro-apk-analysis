package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import defpackage.AbstractC0938Tl;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class ExecutionModule_ExecutorFactory implements Factory<Executor> {

    public static final class a {
        public static final ExecutionModule_ExecutorFactory a = new ExecutionModule_ExecutorFactory();
    }

    public static ExecutionModule_ExecutorFactory create() {
        return a.a;
    }

    public static Executor executor() {
        return (Executor) Preconditions.checkNotNull(AbstractC0938Tl.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.datatransport.runtime.dagger.internal.Factory, defpackage.AI
    public Executor get() {
        return executor();
    }
}
