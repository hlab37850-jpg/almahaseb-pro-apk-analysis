package androidx.compose.runtime.external.kotlinx.collections.immutable;

import defpackage.InterfaceC0756Mu;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface ImmutableMap<K, V> extends Map<K, V>, InterfaceC0756Mu {
    ImmutableSet<Map.Entry<K, V>> getEntries();

    ImmutableSet<K> getKeys();

    ImmutableCollection<V> getValues();
}
