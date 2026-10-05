package androidx.compose.runtime.snapshots;

import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0756Mu;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class StateMapMutableKeysIterator<K, V> extends StateMapMutableIterator<K, V> implements Iterator<K>, InterfaceC0756Mu {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StateMapMutableKeysIterator(SnapshotStateMap<K, V> snapshotStateMap, Iterator<? extends Map.Entry<? extends K, ? extends V>> it) {
        super(snapshotStateMap, it);
        AbstractC4492zt.h(snapshotStateMap, HTML.Tag.MAP);
        AbstractC4492zt.h(it, "iterator");
    }

    @Override // java.util.Iterator
    public K next() {
        Map.Entry<K, V> next = getNext();
        if (next == null) {
            throw new IllegalStateException();
        }
        advance();
        return next.getKey();
    }
}
