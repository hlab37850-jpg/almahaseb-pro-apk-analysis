package defpackage;

import com.google.common.collect.AbstractC1959i;
import java.util.Collection;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: renamed from: o0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3518o0 extends AbstractC1959i {
    public AbstractC3518o0(SortedMap sortedMap) {
        super(sortedMap);
    }

    @Override // com.google.common.collect.AbstractC1959i, com.google.common.collect.AbstractC1957g, com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public SortedMap asMap() {
        return (SortedMap) super.asMap();
    }

    @Override // com.google.common.collect.AbstractC1952b, com.google.common.collect.AbstractC1954d
    public Set<Object> createKeySet() {
        return createMaybeNavigableKeySet();
    }

    @Override // com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap
    public SortedSet keySet() {
        return (SortedSet) super.keySet();
    }

    @Override // com.google.common.collect.AbstractC1952b
    public SortedMap<Object, Collection<Object>> backingMap() {
        return (SortedMap) super.backingMap();
    }
}
