package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.Lazy;
import defpackage.AI;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class MapProviderFactory<K, V> extends AbstractMapFactory implements Lazy<Map<K, AI>> {

    public static final class Builder<K, V> extends AbstractMapFactory.Builder<K, V, AI> {
        public MapProviderFactory<K, V> build() {
            return new MapProviderFactory<>(this.map);
        }

        private Builder(int i) {
            super(i);
        }

        @Override // com.google.android.datatransport.runtime.dagger.internal.AbstractMapFactory.Builder
        public Builder<K, V> put(K k, AI ai) {
            super.put((Object) k, ai);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.dagger.internal.AbstractMapFactory.Builder
        public Builder<K, V> putAll(AI ai) {
            super.putAll(ai);
            return this;
        }
    }

    public static <K, V> Builder<K, V> builder(int i) {
        return new Builder<>(i);
    }

    private MapProviderFactory(Map<K, AI> map) {
        super(map);
    }

    @Override // com.google.android.datatransport.runtime.dagger.internal.Factory, defpackage.AI
    public Map<K, AI> get() {
        return (Map<K, AI>) contributingMap();
    }
}
