package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.dagger.Binds;
import com.google.android.datatransport.runtime.dagger.Module;
import defpackage.UB;

/* JADX INFO: loaded from: classes2.dex */
@Module
public abstract class BackendRegistryModule {
    @Binds
    public abstract BackendRegistry backendRegistry(UB ub);
}
