package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import defpackage.AI;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class DefaultScheduler_Factory implements Factory<DefaultScheduler> {
    private final AI backendRegistryProvider;
    private final AI eventStoreProvider;
    private final AI executorProvider;
    private final AI guardProvider;
    private final AI workSchedulerProvider;

    public DefaultScheduler_Factory(AI ai, AI ai2, AI ai3, AI ai4, AI ai5) {
        this.executorProvider = ai;
        this.backendRegistryProvider = ai2;
        this.workSchedulerProvider = ai3;
        this.eventStoreProvider = ai4;
        this.guardProvider = ai5;
    }

    public static DefaultScheduler_Factory create(AI ai, AI ai2, AI ai3, AI ai4, AI ai5) {
        return new DefaultScheduler_Factory(ai, ai2, ai3, ai4, ai5);
    }

    public static DefaultScheduler newInstance(Executor executor, BackendRegistry backendRegistry, WorkScheduler workScheduler, EventStore eventStore, SynchronizationGuard synchronizationGuard) {
        return new DefaultScheduler(executor, backendRegistry, workScheduler, eventStore, synchronizationGuard);
    }

    @Override // com.google.android.datatransport.runtime.dagger.internal.Factory, defpackage.AI
    public DefaultScheduler get() {
        return newInstance((Executor) this.executorProvider.get(), (BackendRegistry) this.backendRegistryProvider.get(), (WorkScheduler) this.workSchedulerProvider.get(), (EventStore) this.eventStoreProvider.get(), (SynchronizationGuard) this.guardProvider.get());
    }
}
