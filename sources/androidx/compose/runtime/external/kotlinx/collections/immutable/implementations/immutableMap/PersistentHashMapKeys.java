package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC3190k0;
import defpackage.AbstractC4492zt;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class PersistentHashMapKeys<K, V> extends AbstractC3190k0 implements ImmutableSet<K> {
    private final PersistentHashMap<K, V> map;

    public PersistentHashMapKeys(PersistentHashMap<K, V> persistentHashMap) {
        AbstractC4492zt.h(persistentHashMap, HTML.Tag.MAP);
        this.map = persistentHashMap;
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
        return new PersistentHashMapKeysIterator(this.map.getNode$runtime_release());
    }
}
