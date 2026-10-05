package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import defpackage.AI;

/* JADX INFO: loaded from: classes2.dex */
public final class SchemaManager_Factory implements Factory<SchemaManager> {
    private final AI contextProvider;
    private final AI dbNameProvider;
    private final AI schemaVersionProvider;

    public SchemaManager_Factory(AI ai, AI ai2, AI ai3) {
        this.contextProvider = ai;
        this.dbNameProvider = ai2;
        this.schemaVersionProvider = ai3;
    }

    public static SchemaManager_Factory create(AI ai, AI ai2, AI ai3) {
        return new SchemaManager_Factory(ai, ai2, ai3);
    }

    public static SchemaManager newInstance(Context context, String str, int i) {
        return new SchemaManager(context, str, i);
    }

    @Override // com.google.android.datatransport.runtime.dagger.internal.Factory, defpackage.AI
    public SchemaManager get() {
        return newInstance((Context) this.contextProvider.get(), (String) this.dbNameProvider.get(), ((Integer) this.schemaVersionProvider.get()).intValue());
    }
}
