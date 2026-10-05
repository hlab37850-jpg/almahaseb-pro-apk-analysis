package androidx.compose.runtime.snapshots;

import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC1239ac;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0947Tu;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
abstract class SnapshotMapSet<K, V, E> implements Set<E>, InterfaceC0947Tu {
    private final SnapshotStateMap<K, V> map;

    public SnapshotMapSet(SnapshotStateMap<K, V> snapshotStateMap) {
        AbstractC4492zt.h(snapshotStateMap, HTML.Tag.MAP);
        this.map = snapshotStateMap;
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.map.clear();
    }

    public final SnapshotStateMap<K, V> getMap() {
        return this.map;
    }

    public int getSize() {
        return this.map.size();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return AbstractC1239ac.a(this);
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        AbstractC4492zt.h(tArr, "array");
        return (T[]) AbstractC1239ac.b(this, tArr);
    }
}
