package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC3190k0;
import defpackage.AbstractC4492zt;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class PersistentOrderedMapKeys<K, V> extends AbstractC3190k0 implements ImmutableSet<K> {
    private final PersistentOrderedMap<K, V> map;

    public PersistentOrderedMapKeys(PersistentOrderedMap<K, V> persistentOrderedMap) {
        AbstractC4492zt.h(persistentOrderedMap, HTML.Tag.MAP);
        this.map = persistentOrderedMap;
    }

    @Override // defpackage.D, java.util.Collection
    public boolean contains(Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // defpackage.D
    public int getSize() {
        return this.map.size();
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<K> iterator() {
        return new PersistentOrderedMapKeysIterator(this.map);
    }
}
