package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.time.Clock;
import defpackage.AI;
import defpackage.C3248kg;

/* JADX INFO: loaded from: classes2.dex */
public final class CreationContextFactory_Factory implements Factory<C3248kg> {
    private final AI applicationContextProvider;
    private final AI monotonicClockProvider;
    private final AI wallClockProvider;

    public CreationContextFactory_Factory(AI ai, AI ai2, AI ai3) {
        this.applicationContextProvider = ai;
        this.wallClockProvider = ai2;
        this.monotonicClockProvider = ai3;
    }

    public static CreationContextFactory_Factory create(AI ai, AI ai2, AI ai3) {
        return new CreationContextFactory_Factory(ai, ai2, ai3);
    }

    public static C3248kg newInstance(Context context, Clock clock, Clock clock2) {
        return new C3248kg(context, clock, clock2);
    }

    @Override // com.google.android.datatransport.runtime.dagger.internal.Factory, defpackage.AI
    public C3248kg get() {
        return newInstance((Context) this.applicationContextProvider.get(), (Clock) this.wallClockProvider.get(), (Clock) this.monotonicClockProvider.get());
    }
}
