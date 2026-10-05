package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC3190k0;
import defpackage.AbstractC4492zt;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class PersistentHashMapEntries<K, V> extends AbstractC3190k0 implements ImmutableSet<Map.Entry<? extends K, ? extends V>> {
    private final PersistentHashMap<K, V> map;

    public PersistentHashMapEntries(PersistentHashMap<K, V> persistentHashMap) {
        AbstractC4492zt.h(persistentHashMap, HTML.Tag.MAP);
        this.map = persistentHashMap;
    }

    @Override // defpackage.D, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            return contains((Map.Entry) obj);
        }
        return false;
    }

    @Override // defpackage.D
    public int getSize() {
        return this.map.size();
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<Map.Entry<K, V>> iterator() {
        return new PersistentHashMapEntriesIterator(this.map.getNode$runtime_release());
    }

    public boolean contains(Map.Entry<? extends K, ? extends V> entry) {
        AbstractC4492zt.h(entry, "element");
        V v = this.map.get(entry.getKey());
        if (v != null) {
            return AbstractC4492zt.d(v, entry.getValue());
        }
        return entry.getValue() == null && this.map.containsKey(entry.getKey());
    }
}
