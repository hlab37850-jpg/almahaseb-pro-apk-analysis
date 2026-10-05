package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import defpackage.AI;

/* JADX INFO: loaded from: classes2.dex */
public final class EventStoreModule_PackageNameFactory implements Factory<String> {
    private final AI contextProvider;

    public EventStoreModule_PackageNameFactory(AI ai) {
        this.contextProvider = ai;
    }

    public static EventStoreModule_PackageNameFactory create(AI ai) {
        return new EventStoreModule_PackageNameFactory(ai);
    }

    public static String packageName(Context context) {
        return (String) Preconditions.checkNotNull(EventStoreModule.packageName(context), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.datatransport.runtime.dagger.internal.Factory, defpackage.AI
    public String get() {
        return packageName((Context) this.contextProvider.get());
    }
}
