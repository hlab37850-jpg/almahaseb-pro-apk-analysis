package com.google.api.client.util.store;

import defpackage.Z;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class MemoryDataStoreFactory extends AbstractDataStoreFactory {

    public static class a {
        public static final MemoryDataStoreFactory a = new MemoryDataStoreFactory();
    }

    public static class b extends Z {
        public b(MemoryDataStoreFactory memoryDataStoreFactory, String str) {
            super(memoryDataStoreFactory, str);
        }

        @Override // com.google.api.client.util.store.AbstractDataStore, com.google.api.client.util.store.DataStore
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public MemoryDataStoreFactory getDataStoreFactory() {
            return (MemoryDataStoreFactory) super.getDataStoreFactory();
        }
    }

    public static MemoryDataStoreFactory getDefaultInstance() {
        return a.a;
    }

    @Override // com.google.api.client.util.store.AbstractDataStoreFactory
    public <V extends Serializable> DataStore<V> createDataStore(String str) {
        return new b(this, str);
    }
}
