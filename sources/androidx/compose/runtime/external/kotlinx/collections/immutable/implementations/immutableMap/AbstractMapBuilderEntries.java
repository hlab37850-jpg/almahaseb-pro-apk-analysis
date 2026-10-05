package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import defpackage.AbstractC1994d0;
import defpackage.AbstractC4492zt;
import java.util.Map;
import java.util.Map.Entry;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractMapBuilderEntries<E extends Map.Entry<? extends K, ? extends V>, K, V> extends AbstractC1994d0 {
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            return contains((Map.Entry) obj);
        }
        return false;
    }

    public abstract boolean containsEntry(Map.Entry<? extends K, ? extends V> entry);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof Map.Entry) {
            return remove((Map.Entry) obj);
        }
        return false;
    }

    public abstract boolean removeEntry(Map.Entry<? extends K, ? extends V> entry);

    public final boolean contains(E e) {
        AbstractC4492zt.h(e, "element");
        if ((e instanceof Object ? e : null) instanceof Map.Entry) {
            return containsEntry(e);
        }
        return false;
    }

    public final boolean remove(E e) {
        AbstractC4492zt.h(e, "element");
        if ((e instanceof Object ? e : null) instanceof Map.Entry) {
            return removeEntry(e);
        }
        return false;
    }
}
