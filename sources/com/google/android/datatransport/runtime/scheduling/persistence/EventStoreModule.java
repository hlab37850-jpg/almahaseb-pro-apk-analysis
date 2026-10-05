package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.Binds;
import com.google.android.datatransport.runtime.dagger.Module;
import com.google.android.datatransport.runtime.dagger.Provides;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import defpackage.AbstractC0600Il;

/* JADX INFO: loaded from: classes2.dex */
@Module
public abstract class EventStoreModule {
    @Provides
    public static String dbName() {
        return "com.google.android.datatransport.events";
    }

    @Provides
    public static String packageName(Context context) {
        return context.getPackageName();
    }

    @Provides
    public static int schemaVersion() {
        return SchemaManager.d;
    }

    @Provides
    public static AbstractC0600Il storeConfig() {
        return AbstractC0600Il.a;
    }

    @Binds
    public abstract ClientHealthMetricsStore clientHealthMetricsStore(SQLiteEventStore sQLiteEventStore);

    @Binds
    public abstract EventStore eventStore(SQLiteEventStore sQLiteEventStore);

    @Binds
    public abstract SynchronizationGuard synchronizationGuard(SQLiteEventStore sQLiteEventStore);
}
