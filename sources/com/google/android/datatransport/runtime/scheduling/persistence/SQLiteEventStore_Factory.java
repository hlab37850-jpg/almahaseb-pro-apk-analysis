package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.time.Clock;
import defpackage.AI;
import defpackage.AbstractC0600Il;

/* JADX INFO: loaded from: classes2.dex */
public final class SQLiteEventStore_Factory implements Factory<SQLiteEventStore> {
    private final AI clockProvider;
    private final AI configProvider;
    private final AI packageNameProvider;
    private final AI schemaManagerProvider;
    private final AI wallClockProvider;

    public SQLiteEventStore_Factory(AI ai, AI ai2, AI ai3, AI ai4, AI ai5) {
        this.wallClockProvider = ai;
        this.clockProvider = ai2;
        this.configProvider = ai3;
        this.schemaManagerProvider = ai4;
        this.packageNameProvider = ai5;
    }

    public static SQLiteEventStore_Factory create(AI ai, AI ai2, AI ai3, AI ai4, AI ai5) {
        return new SQLiteEventStore_Factory(ai, ai2, ai3, ai4, ai5);
    }

    public static SQLiteEventStore newInstance(Clock clock, Clock clock2, Object obj, Object obj2, AI ai) {
        return new SQLiteEventStore(clock, clock2, (AbstractC0600Il) obj, (SchemaManager) obj2, ai);
    }

    @Override // com.google.android.datatransport.runtime.dagger.internal.Factory, defpackage.AI
    public SQLiteEventStore get() {
        return newInstance((Clock) this.wallClockProvider.get(), (Clock) this.clockProvider.get(), this.configProvider.get(), this.schemaManagerProvider.get(), this.packageNameProvider);
    }
}
