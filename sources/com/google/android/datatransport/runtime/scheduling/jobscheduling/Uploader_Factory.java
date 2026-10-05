package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import defpackage.AI;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class Uploader_Factory implements Factory<Uploader> {
    private final AI backendRegistryProvider;
    private final AI clientHealthMetricsStoreProvider;
    private final AI clockProvider;
    private final AI contextProvider;
    private final AI eventStoreProvider;
    private final AI executorProvider;
    private final AI guardProvider;
    private final AI uptimeClockProvider;
    private final AI workSchedulerProvider;

    public Uploader_Factory(AI ai, AI ai2, AI ai3, AI ai4, AI ai5, AI ai6, AI ai7, AI ai8, AI ai9) {
        this.contextProvider = ai;
        this.backendRegistryProvider = ai2;
        this.eventStoreProvider = ai3;
        this.workSchedulerProvider = ai4;
        this.executorProvider = ai5;
        this.guardProvider = ai6;
        this.clockProvider = ai7;
        this.uptimeClockProvider = ai8;
        this.clientHealthMetricsStoreProvider = ai9;
    }

    public static Uploader_Factory create(AI ai, AI ai2, AI ai3, AI ai4, AI ai5, AI ai6, AI ai7, AI ai8, AI ai9) {
        return new Uploader_Factory(ai, ai2, ai3, ai4, ai5, ai6, ai7, ai8, ai9);
    }

    public static Uploader newInstance(Context context, BackendRegistry backendRegistry, EventStore eventStore, WorkScheduler workScheduler, Executor executor, SynchronizationGuard synchronizationGuard, Clock clock, Clock clock2, ClientHealthMetricsStore clientHealthMetricsStore) {
        return new Uploader(context, backendRegistry, eventStore, workScheduler, executor, synchronizationGuard, clock, clock2, clientHealthMetricsStore);
    }

    @Override // com.google.android.datatransport.runtime.dagger.internal.Factory, defpackage.AI
    public Uploader get() {
        return newInstance((Context) this.contextProvider.get(), (BackendRegistry) this.backendRegistryProvider.get(), (EventStore) this.eventStoreProvider.get(), (WorkScheduler) this.workSchedulerProvider.get(), (Executor) this.executorProvider.get(), (SynchronizationGuard) this.guardProvider.get(), (Clock) this.clockProvider.get(), (Clock) this.uptimeClockProvider.get(), (ClientHealthMetricsStore) this.clientHealthMetricsStoreProvider.get());
    }
}
