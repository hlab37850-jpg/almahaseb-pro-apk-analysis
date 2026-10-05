package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import defpackage.AI;
import defpackage.C3248kg;
import defpackage.UB;

/* JADX INFO: loaded from: classes2.dex */
public final class MetadataBackendRegistry_Factory implements Factory<UB> {
    private final AI applicationContextProvider;
    private final AI creationContextFactoryProvider;

    public MetadataBackendRegistry_Factory(AI ai, AI ai2) {
        this.applicationContextProvider = ai;
        this.creationContextFactoryProvider = ai2;
    }

    public static MetadataBackendRegistry_Factory create(AI ai, AI ai2) {
        return new MetadataBackendRegistry_Factory(ai, ai2);
    }

    public static UB newInstance(Context context, Object obj) {
        return new UB(context, (C3248kg) obj);
    }

    @Override // com.google.android.datatransport.runtime.dagger.internal.Factory, defpackage.AI
    public UB get() {
        return newInstance((Context) this.applicationContextProvider.get(), this.creationContextFactoryProvider.get());
    }
}
