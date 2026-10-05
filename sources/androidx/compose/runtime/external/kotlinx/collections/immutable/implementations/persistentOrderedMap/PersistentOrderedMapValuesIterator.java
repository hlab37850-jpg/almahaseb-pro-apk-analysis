package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap;

import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0756Mu;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class PersistentOrderedMapValuesIterator<K, V> implements Iterator<V>, InterfaceC0756Mu {
    private final PersistentOrderedMapLinksIterator<K, V> internal;

    public PersistentOrderedMapValuesIterator(PersistentOrderedMap<K, V> persistentOrderedMap) {
        AbstractC4492zt.h(persistentOrderedMap, HTML.Tag.MAP);
        this.internal = new PersistentOrderedMapLinksIterator<>(persistentOrderedMap.getFirstKey$runtime_release(), persistentOrderedMap.getHashMap$runtime_release());
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.internal.hasNext();
    }

    @Override // java.util.Iterator
    public V next() {
        return this.internal.next().getValue();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
