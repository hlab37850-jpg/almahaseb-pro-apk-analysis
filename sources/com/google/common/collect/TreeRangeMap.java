package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import defpackage.AbstractC2217fh;
import defpackage.Y;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtIncompatible
public final class TreeRangeMap<K extends Comparable, V> implements RangeMap<K, V> {
    private static final RangeMap<Comparable<?>, Object> EMPTY_SUB_RANGE_MAP = new a();
    private final NavigableMap<AbstractC2217fh, c> entriesByLowerBound = Maps.newTreeMap();

    public class a implements RangeMap {
        @Override // com.google.common.collect.RangeMap
        public Map asDescendingMapOfRanges() {
            return Collections.emptyMap();
        }

        @Override // com.google.common.collect.RangeMap
        public Map asMapOfRanges() {
            return Collections.emptyMap();
        }

        @Override // com.google.common.collect.RangeMap
        public void clear() {
        }

        @Override // com.google.common.collect.RangeMap
        public Object get(Comparable comparable) {
            return null;
        }

        @Override // com.google.common.collect.RangeMap
        public Map.Entry getEntry(Comparable comparable) {
            return null;
        }

        @Override // com.google.common.collect.RangeMap
        public void put(Range range, Object obj) {
            Preconditions.checkNotNull(range);
            String strValueOf = String.valueOf(range);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 46);
            sb.append("Cannot insert range ");
            sb.append(strValueOf);
            sb.append(" into an empty subRangeMap");
            throw new IllegalArgumentException(sb.toString());
        }

        @Override // com.google.common.collect.RangeMap
        public void putAll(RangeMap rangeMap) {
            if (!rangeMap.asMapOfRanges().isEmpty()) {
                throw new IllegalArgumentException("Cannot putAll(nonEmptyRangeMap) into an empty subRangeMap");
            }
        }

        @Override // com.google.common.collect.RangeMap
        public void putCoalescing(Range range, Object obj) {
            Preconditions.checkNotNull(range);
            String strValueOf = String.valueOf(range);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 46);
            sb.append("Cannot insert range ");
            sb.append(strValueOf);
            sb.append(" into an empty subRangeMap");
            throw new IllegalArgumentException(sb.toString());
        }

        @Override // com.google.common.collect.RangeMap
        public void remove(Range range) {
            Preconditions.checkNotNull(range);
        }

        @Override // com.google.common.collect.RangeMap
        public Range span() {
            throw new NoSuchElementException();
        }

        @Override // com.google.common.collect.RangeMap
        public RangeMap subRangeMap(Range range) {
            Preconditions.checkNotNull(range);
            return this;
        }
    }

    public final class b extends Maps.z {
        public final Iterable a;

        public b(Iterable iterable) {
            this.a = iterable;
        }

        @Override // com.google.common.collect.Maps.z
        public Iterator a() {
            return this.a.iterator();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return get(obj) != null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object get(Object obj) {
            if (!(obj instanceof Range)) {
                return null;
            }
            Range range = (Range) obj;
            c cVar = (c) TreeRangeMap.this.entriesByLowerBound.get(range.lowerBound);
            if (cVar == null || !cVar.getKey().equals(range)) {
                return null;
            }
            return cVar.getValue();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return TreeRangeMap.this.entriesByLowerBound.size();
        }
    }

    public static final class c extends Y {
        public final Range a;
        public final Object b;

        public c(AbstractC2217fh abstractC2217fh, AbstractC2217fh abstractC2217fh2, Object obj) {
            this(Range.create(abstractC2217fh, abstractC2217fh2), obj);
        }

        public boolean f(Comparable comparable) {
            return this.a.contains(comparable);
        }

        @Override // defpackage.Y, java.util.Map.Entry
        public Object getValue() {
            return this.b;
        }

        @Override // defpackage.Y, java.util.Map.Entry
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Range getKey() {
            return this.a;
        }

        public AbstractC2217fh i() {
            return this.a.lowerBound;
        }

        public AbstractC2217fh j() {
            return this.a.upperBound;
        }

        public c(Range range, Object obj) {
            this.a = range;
            this.b = obj;
        }
    }

    public class d implements RangeMap {
        public final Range a;

        public class a extends b {

            /* JADX INFO: renamed from: com.google.common.collect.TreeRangeMap$d$a$a, reason: collision with other inner class name */
            public class C0235a extends AbstractIterator {
                public final /* synthetic */ Iterator a;

                public C0235a(Iterator it) {
                    this.a = it;
                }

                @Override // com.google.common.collect.AbstractIterator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Map.Entry computeNext() {
                    if (!this.a.hasNext()) {
                        return (Map.Entry) endOfData();
                    }
                    c cVar = (c) this.a.next();
                    return cVar.j().compareTo(d.this.a.lowerBound) <= 0 ? (Map.Entry) endOfData() : Maps.immutableEntry(cVar.getKey().intersection(d.this.a), cVar.getValue());
                }
            }

            public a() {
                super();
            }

            @Override // com.google.common.collect.TreeRangeMap.d.b
            public Iterator b() {
                return d.this.a.isEmpty() ? Iterators.emptyIterator() : new C0235a(TreeRangeMap.this.entriesByLowerBound.headMap(d.this.a.upperBound, false).descendingMap().values().iterator());
            }
        }

        public class b extends AbstractMap {

            public class a extends Maps.A {
                public a(Map map) {
                    super(map);
                }

                @Override // com.google.common.collect.Maps.A, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean remove(Object obj) {
                    return b.this.remove(obj) != null;
                }

                @Override // com.google.common.collect.Sets.k, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean retainAll(Collection collection) {
                    return b.this.c(Predicates.compose(Predicates.not(Predicates.in(collection)), Maps.keyFunction()));
                }
            }

            /* JADX INFO: renamed from: com.google.common.collect.TreeRangeMap$d$b$b, reason: collision with other inner class name */
            public class C0236b extends Maps.s {
                public C0236b() {
                }

                @Override // com.google.common.collect.Maps.s, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean isEmpty() {
                    return !iterator().hasNext();
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
                public Iterator iterator() {
                    return b.this.b();
                }

                @Override // com.google.common.collect.Maps.s
                public Map map() {
                    return b.this;
                }

                @Override // com.google.common.collect.Maps.s, com.google.common.collect.Sets.k, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean retainAll(Collection collection) {
                    return b.this.c(Predicates.not(Predicates.in(collection)));
                }

                @Override // com.google.common.collect.Maps.s, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return Iterators.size(iterator());
                }
            }

            public class c extends AbstractIterator {
                public final /* synthetic */ Iterator a;

                public c(Iterator it) {
                    this.a = it;
                }

                @Override // com.google.common.collect.AbstractIterator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Map.Entry computeNext() {
                    while (this.a.hasNext()) {
                        c cVar = (c) this.a.next();
                        if (cVar.i().compareTo(d.this.a.upperBound) >= 0) {
                            return (Map.Entry) endOfData();
                        }
                        if (cVar.j().compareTo(d.this.a.lowerBound) > 0) {
                            return Maps.immutableEntry(cVar.getKey().intersection(d.this.a), cVar.getValue());
                        }
                    }
                    return (Map.Entry) endOfData();
                }
            }

            /* JADX INFO: renamed from: com.google.common.collect.TreeRangeMap$d$b$d, reason: collision with other inner class name */
            public class C0237d extends Maps.P {
                public C0237d(Map map) {
                    super(map);
                }

                @Override // com.google.common.collect.Maps.P, java.util.AbstractCollection, java.util.Collection
                public boolean removeAll(Collection collection) {
                    return b.this.c(Predicates.compose(Predicates.in(collection), Maps.valueFunction()));
                }

                @Override // com.google.common.collect.Maps.P, java.util.AbstractCollection, java.util.Collection
                public boolean retainAll(Collection collection) {
                    return b.this.c(Predicates.compose(Predicates.not(Predicates.in(collection)), Maps.valueFunction()));
                }
            }

            public b() {
            }

            public Iterator b() {
                if (d.this.a.isEmpty()) {
                    return Iterators.emptyIterator();
                }
                return new c(TreeRangeMap.this.entriesByLowerBound.tailMap((AbstractC2217fh) MoreObjects.firstNonNull((AbstractC2217fh) TreeRangeMap.this.entriesByLowerBound.floorKey(d.this.a.lowerBound), d.this.a.lowerBound), true).values().iterator());
            }

            public final boolean c(Predicate predicate) {
                ArrayList arrayListNewArrayList = Lists.newArrayList();
                for (Map.Entry entry : entrySet()) {
                    if (predicate.apply(entry)) {
                        arrayListNewArrayList.add((Range) entry.getKey());
                    }
                }
                Iterator it = arrayListNewArrayList.iterator();
                while (it.hasNext()) {
                    TreeRangeMap.this.remove((Range) it.next());
                }
                return !arrayListNewArrayList.isEmpty();
            }

            @Override // java.util.AbstractMap, java.util.Map
            public void clear() {
                d.this.clear();
            }

            @Override // java.util.AbstractMap, java.util.Map
            public boolean containsKey(Object obj) {
                return get(obj) != null;
            }

            @Override // java.util.AbstractMap, java.util.Map
            public Set entrySet() {
                return new C0236b();
            }

            @Override // java.util.AbstractMap, java.util.Map
            public Object get(Object obj) {
                c cVar;
                try {
                    if (obj instanceof Range) {
                        Range range = (Range) obj;
                        if (d.this.a.encloses(range) && !range.isEmpty()) {
                            if (range.lowerBound.compareTo(d.this.a.lowerBound) == 0) {
                                Map.Entry entryFloorEntry = TreeRangeMap.this.entriesByLowerBound.floorEntry(range.lowerBound);
                                cVar = entryFloorEntry != null ? (c) entryFloorEntry.getValue() : null;
                            } else {
                                cVar = (c) TreeRangeMap.this.entriesByLowerBound.get(range.lowerBound);
                            }
                            if (cVar != null && cVar.getKey().isConnected(d.this.a) && cVar.getKey().intersection(d.this.a).equals(range)) {
                                return cVar.getValue();
                            }
                        }
                    }
                } catch (ClassCastException unused) {
                }
                return null;
            }

            @Override // java.util.AbstractMap, java.util.Map
            public Set keySet() {
                return new a(this);
            }

            @Override // java.util.AbstractMap, java.util.Map
            public Object remove(Object obj) {
                Object obj2 = get(obj);
                if (obj2 == null) {
                    return null;
                }
                Objects.requireNonNull(obj);
                TreeRangeMap.this.remove((Range) obj);
                return obj2;
            }

            @Override // java.util.AbstractMap, java.util.Map
            public Collection values() {
                return new C0237d(this);
            }
        }

        public d(Range range) {
            this.a = range;
        }

        @Override // com.google.common.collect.RangeMap
        public Map asDescendingMapOfRanges() {
            return new a();
        }

        @Override // com.google.common.collect.RangeMap
        public Map asMapOfRanges() {
            return new b();
        }

        @Override // com.google.common.collect.RangeMap
        public void clear() {
            TreeRangeMap.this.remove(this.a);
        }

        @Override // com.google.common.collect.RangeMap
        public boolean equals(Object obj) {
            if (obj instanceof RangeMap) {
                return asMapOfRanges().equals(((RangeMap) obj).asMapOfRanges());
            }
            return false;
        }

        @Override // com.google.common.collect.RangeMap
        public Object get(Comparable comparable) {
            if (this.a.contains(comparable)) {
                return TreeRangeMap.this.get(comparable);
            }
            return null;
        }

        @Override // com.google.common.collect.RangeMap
        public Map.Entry getEntry(Comparable comparable) {
            Map.Entry<Range<K>, V> entry;
            if (!this.a.contains(comparable) || (entry = TreeRangeMap.this.getEntry(comparable)) == null) {
                return null;
            }
            return Maps.immutableEntry(entry.getKey().intersection(this.a), entry.getValue());
        }

        @Override // com.google.common.collect.RangeMap
        public int hashCode() {
            return asMapOfRanges().hashCode();
        }

        @Override // com.google.common.collect.RangeMap
        public void put(Range range, Object obj) {
            Preconditions.checkArgument(this.a.encloses(range), "Cannot put range %s into a subRangeMap(%s)", range, this.a);
            TreeRangeMap.this.put(range, obj);
        }

        @Override // com.google.common.collect.RangeMap
        public void putAll(RangeMap rangeMap) {
            if (rangeMap.asMapOfRanges().isEmpty()) {
                return;
            }
            Range<K> rangeSpan = rangeMap.span();
            Preconditions.checkArgument(this.a.encloses(rangeSpan), "Cannot putAll rangeMap with span %s into a subRangeMap(%s)", rangeSpan, this.a);
            TreeRangeMap.this.putAll(rangeMap);
        }

        @Override // com.google.common.collect.RangeMap
        public void putCoalescing(Range range, Object obj) {
            if (TreeRangeMap.this.entriesByLowerBound.isEmpty() || !this.a.encloses(range)) {
                put(range, obj);
            } else {
                put(TreeRangeMap.this.coalescedRange(range, Preconditions.checkNotNull(obj)).intersection(this.a), obj);
            }
        }

        @Override // com.google.common.collect.RangeMap
        public void remove(Range range) {
            if (range.isConnected(this.a)) {
                TreeRangeMap.this.remove(range.intersection(this.a));
            }
        }

        @Override // com.google.common.collect.RangeMap
        public Range span() {
            AbstractC2217fh abstractC2217fh;
            Map.Entry entryFloorEntry = TreeRangeMap.this.entriesByLowerBound.floorEntry(this.a.lowerBound);
            if (entryFloorEntry == null || ((c) entryFloorEntry.getValue()).j().compareTo(this.a.lowerBound) <= 0) {
                abstractC2217fh = (AbstractC2217fh) TreeRangeMap.this.entriesByLowerBound.ceilingKey(this.a.lowerBound);
                if (abstractC2217fh == null || abstractC2217fh.compareTo(this.a.upperBound) >= 0) {
                    throw new NoSuchElementException();
                }
            } else {
                abstractC2217fh = this.a.lowerBound;
            }
            Map.Entry entryLowerEntry = TreeRangeMap.this.entriesByLowerBound.lowerEntry(this.a.upperBound);
            if (entryLowerEntry != null) {
                return Range.create(abstractC2217fh, ((c) entryLowerEntry.getValue()).j().compareTo(this.a.upperBound) >= 0 ? this.a.upperBound : ((c) entryLowerEntry.getValue()).j());
            }
            throw new NoSuchElementException();
        }

        @Override // com.google.common.collect.RangeMap
        public RangeMap subRangeMap(Range range) {
            return !range.isConnected(this.a) ? TreeRangeMap.this.emptySubRangeMap() : TreeRangeMap.this.subRangeMap(range.intersection(this.a));
        }

        @Override // com.google.common.collect.RangeMap
        public String toString() {
            return asMapOfRanges().toString();
        }
    }

    private TreeRangeMap() {
    }

    private static <K extends Comparable, V> Range<K> coalesce(Range<K> range, V v, Map.Entry<AbstractC2217fh, c> entry) {
        return (entry != null && entry.getValue().getKey().isConnected(range) && entry.getValue().getValue().equals(v)) ? (Range<K>) range.span(entry.getValue().getKey()) : range;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Range<K> coalescedRange(Range<K> range, V v) {
        return coalesce(coalesce(range, v, this.entriesByLowerBound.lowerEntry(range.lowerBound)), v, this.entriesByLowerBound.floorEntry(range.upperBound));
    }

    public static <K extends Comparable, V> TreeRangeMap<K, V> create() {
        return new TreeRangeMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RangeMap<K, V> emptySubRangeMap() {
        return EMPTY_SUB_RANGE_MAP;
    }

    private void putRangeMapEntry(AbstractC2217fh abstractC2217fh, AbstractC2217fh abstractC2217fh2, V v) {
        this.entriesByLowerBound.put(abstractC2217fh, new c(abstractC2217fh, abstractC2217fh2, v));
    }

    @Override // com.google.common.collect.RangeMap
    public Map<Range<K>, V> asDescendingMapOfRanges() {
        return new b(this.entriesByLowerBound.descendingMap().values());
    }

    @Override // com.google.common.collect.RangeMap
    public Map<Range<K>, V> asMapOfRanges() {
        return new b(this.entriesByLowerBound.values());
    }

    @Override // com.google.common.collect.RangeMap
    public void clear() {
        this.entriesByLowerBound.clear();
    }

    @Override // com.google.common.collect.RangeMap
    public boolean equals(Object obj) {
        if (obj instanceof RangeMap) {
            return asMapOfRanges().equals(((RangeMap) obj).asMapOfRanges());
        }
        return false;
    }

    @Override // com.google.common.collect.RangeMap
    public V get(K k) {
        Map.Entry<Range<K>, V> entry = getEntry(k);
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    @Override // com.google.common.collect.RangeMap
    public Map.Entry<Range<K>, V> getEntry(K k) {
        Map.Entry<AbstractC2217fh, c> entryFloorEntry = this.entriesByLowerBound.floorEntry(AbstractC2217fh.e(k));
        if (entryFloorEntry == null || !entryFloorEntry.getValue().f(k)) {
            return null;
        }
        return entryFloorEntry.getValue();
    }

    @Override // com.google.common.collect.RangeMap
    public int hashCode() {
        return asMapOfRanges().hashCode();
    }

    @Override // com.google.common.collect.RangeMap
    public void put(Range<K> range, V v) {
        if (range.isEmpty()) {
            return;
        }
        Preconditions.checkNotNull(v);
        remove(range);
        this.entriesByLowerBound.put(range.lowerBound, new c(range, v));
    }

    @Override // com.google.common.collect.RangeMap
    public void putAll(RangeMap<K, V> rangeMap) {
        for (Map.Entry<Range<K>, V> entry : rangeMap.asMapOfRanges().entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.RangeMap
    public void putCoalescing(Range<K> range, V v) {
        if (this.entriesByLowerBound.isEmpty()) {
            put(range, v);
        } else {
            put(coalescedRange(range, Preconditions.checkNotNull(v)), v);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.RangeMap
    public void remove(Range<K> range) {
        if (range.isEmpty()) {
            return;
        }
        Map.Entry<AbstractC2217fh, c> entryLowerEntry = this.entriesByLowerBound.lowerEntry(range.lowerBound);
        if (entryLowerEntry != null) {
            c value = entryLowerEntry.getValue();
            if (value.j().compareTo(range.lowerBound) > 0) {
                if (value.j().compareTo(range.upperBound) > 0) {
                    putRangeMapEntry(range.upperBound, value.j(), entryLowerEntry.getValue().getValue());
                }
                putRangeMapEntry(value.i(), range.lowerBound, entryLowerEntry.getValue().getValue());
            }
        }
        Map.Entry<AbstractC2217fh, c> entryLowerEntry2 = this.entriesByLowerBound.lowerEntry(range.upperBound);
        if (entryLowerEntry2 != null) {
            c value2 = entryLowerEntry2.getValue();
            if (value2.j().compareTo(range.upperBound) > 0) {
                putRangeMapEntry(range.upperBound, value2.j(), entryLowerEntry2.getValue().getValue());
            }
        }
        this.entriesByLowerBound.subMap(range.lowerBound, range.upperBound).clear();
    }

    @Override // com.google.common.collect.RangeMap
    public Range<K> span() {
        Map.Entry<AbstractC2217fh, c> entryFirstEntry = this.entriesByLowerBound.firstEntry();
        Map.Entry<AbstractC2217fh, c> entryLastEntry = this.entriesByLowerBound.lastEntry();
        if (entryFirstEntry == null || entryLastEntry == null) {
            throw new NoSuchElementException();
        }
        return Range.create(entryFirstEntry.getValue().getKey().lowerBound, entryLastEntry.getValue().getKey().upperBound);
    }

    @Override // com.google.common.collect.RangeMap
    public RangeMap<K, V> subRangeMap(Range<K> range) {
        return range.equals(Range.all()) ? this : new d(range);
    }

    @Override // com.google.common.collect.RangeMap
    public String toString() {
        return this.entriesByLowerBound.values().toString();
    }
}
