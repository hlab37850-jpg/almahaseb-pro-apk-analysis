package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import defpackage.AbstractC0600Il;

/* JADX INFO: loaded from: classes2.dex */
public final class EventStoreModule_StoreConfigFactory implements Factory<AbstractC0600Il> {

    public static final class a {
        public static final EventStoreModule_StoreConfigFactory a = new EventStoreModule_StoreConfigFactory();
    }

    public static EventStoreModule_StoreConfigFactory create() {
        return a.a;
    }

    public static AbstractC0600Il storeConfig() {
        return (AbstractC0600Il) Preconditions.checkNotNull(EventStoreModule.storeConfig(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.datatransport.runtime.dagger.internal.Factory, defpackage.AI
    public AbstractC0600Il get() {
        return storeConfig();
    }
}
