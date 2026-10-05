package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import defpackage.AI;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class WorkInitializer_Factory implements Factory<WorkInitializer> {
    private final AI executorProvider;
    private final AI guardProvider;
    private final AI schedulerProvider;
    private final AI storeProvider;

    public WorkInitializer_Factory(AI ai, AI ai2, AI ai3, AI ai4) {
        this.executorProvider = ai;
        this.storeProvider = ai2;
        this.schedulerProvider = ai3;
        this.guardProvider = ai4;
    }

    public static WorkInitializer_Factory create(AI ai, AI ai2, AI ai3, AI ai4) {
        return new WorkInitializer_Factory(ai, ai2, ai3, ai4);
    }

    public static WorkInitializer newInstance(Executor executor, EventStore eventStore, WorkScheduler workScheduler, SynchronizationGuard synchronizationGuard) {
        return new WorkInitializer(executor, eventStore, workScheduler, synchronizationGuard);
    }

    @Override // com.google.android.datatransport.runtime.dagger.internal.Factory, defpackage.AI
    public WorkInitializer get() {
        return newInstance((Executor) this.executorProvider.get(), (EventStore) this.storeProvider.get(), (WorkScheduler) this.schedulerProvider.get(), (SynchronizationGuard) this.guardProvider.get());
    }
}
