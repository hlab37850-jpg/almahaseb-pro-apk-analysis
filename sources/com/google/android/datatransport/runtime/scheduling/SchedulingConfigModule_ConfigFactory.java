package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.time.Clock;
import defpackage.AI;

/* JADX INFO: loaded from: classes2.dex */
public final class SchedulingConfigModule_ConfigFactory implements Factory<SchedulerConfig> {
    private final AI clockProvider;

    public SchedulingConfigModule_ConfigFactory(AI ai) {
        this.clockProvider = ai;
    }

    public static SchedulerConfig config(Clock clock) {
        return (SchedulerConfig) Preconditions.checkNotNull(SchedulingConfigModule.config(clock), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static SchedulingConfigModule_ConfigFactory create(AI ai) {
        return new SchedulingConfigModule_ConfigFactory(ai);
    }

    @Override // com.google.android.datatransport.runtime.dagger.internal.Factory, defpackage.AI
    public SchedulerConfig get() {
        return config((Clock) this.clockProvider.get());
    }
}
