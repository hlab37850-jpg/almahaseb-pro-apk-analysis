package com.google.android.datatransport.runtime.scheduling;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.time.Clock;
import defpackage.AI;

/* JADX INFO: loaded from: classes2.dex */
public final class SchedulingModule_WorkSchedulerFactory implements Factory<WorkScheduler> {
    private final AI clockProvider;
    private final AI configProvider;
    private final AI contextProvider;
    private final AI eventStoreProvider;

    public SchedulingModule_WorkSchedulerFactory(AI ai, AI ai2, AI ai3, AI ai4) {
        this.contextProvider = ai;
        this.eventStoreProvider = ai2;
        this.configProvider = ai3;
        this.clockProvider = ai4;
    }

    public static SchedulingModule_WorkSchedulerFactory create(AI ai, AI ai2, AI ai3, AI ai4) {
        return new SchedulingModule_WorkSchedulerFactory(ai, ai2, ai3, ai4);
    }

    public static WorkScheduler workScheduler(Context context, EventStore eventStore, SchedulerConfig schedulerConfig, Clock clock) {
        return (WorkScheduler) Preconditions.checkNotNull(SchedulingModule.workScheduler(context, eventStore, schedulerConfig, clock), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.datatransport.runtime.dagger.internal.Factory, defpackage.AI
    public WorkScheduler get() {
        return workScheduler((Context) this.contextProvider.get(), (EventStore) this.eventStoreProvider.get(), (SchedulerConfig) this.configProvider.get(), (Clock) this.clockProvider.get());
    }
}
