package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.time.Clock;
import defpackage.AI;

/* JADX INFO: loaded from: classes2.dex */
public final class TransportRuntime_Factory implements Factory<TransportRuntime> {
    private final AI eventClockProvider;
    private final AI initializerProvider;
    private final AI schedulerProvider;
    private final AI uploaderProvider;
    private final AI uptimeClockProvider;

    public TransportRuntime_Factory(AI ai, AI ai2, AI ai3, AI ai4, AI ai5) {
        this.eventClockProvider = ai;
        this.uptimeClockProvider = ai2;
        this.schedulerProvider = ai3;
        this.uploaderProvider = ai4;
        this.initializerProvider = ai5;
    }

    public static TransportRuntime_Factory create(AI ai, AI ai2, AI ai3, AI ai4, AI ai5) {
        return new TransportRuntime_Factory(ai, ai2, ai3, ai4, ai5);
    }

    public static TransportRuntime newInstance(Clock clock, Clock clock2, Scheduler scheduler, Uploader uploader, WorkInitializer workInitializer) {
        return new TransportRuntime(clock, clock2, scheduler, uploader, workInitializer);
    }

    @Override // com.google.android.datatransport.runtime.dagger.internal.Factory, defpackage.AI
    public TransportRuntime get() {
        return newInstance((Clock) this.eventClockProvider.get(), (Clock) this.uptimeClockProvider.get(), (Scheduler) this.schedulerProvider.get(), (Uploader) this.uploaderProvider.get(), (WorkInitializer) this.initializerProvider.get());
    }
}
