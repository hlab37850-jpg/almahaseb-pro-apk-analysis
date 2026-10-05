package com.google.android.datatransport.runtime.dagger.internal;

import defpackage.AI;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractMapFactory implements Factory {
    private final Map<Object, AI> contributingMap;

    public static abstract class Builder<K, V, V2> {
        final LinkedHashMap<K, AI> map;

        public Builder(int i) {
            this.map = DaggerCollections.newLinkedHashMapWithExpectedSize(i);
        }

        public Builder<K, V, V2> put(K k, AI ai) {
            this.map.put((K) Preconditions.checkNotNull(k, "key"), (AI) Preconditions.checkNotNull(ai, "provider"));
            return this;
        }

        public Builder<K, V, V2> putAll(AI ai) {
            if (ai instanceof DelegateFactory) {
                return putAll(((DelegateFactory) ai).getDelegate());
            }
            this.map.putAll(((AbstractMapFactory) ai).contributingMap);
            return this;
        }
    }

    public AbstractMapFactory(Map map) {
        this.contributingMap = Collections.unmodifiableMap(map);
    }

    public final Map<Object, AI> contributingMap() {
        return this.contributingMap;
    }
}
