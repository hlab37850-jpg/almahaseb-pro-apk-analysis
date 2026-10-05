package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Converter;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.Weak;
import defpackage.A30;
import defpackage.AbstractC1163Zb;
import defpackage.AbstractC2362hV;
import defpackage.C3427ms;
import defpackage.WD;
import defpackage.Y;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
public final class Maps {

    public static class A extends Sets.k {

        @Weak
        final Map<Object, Object> map;

        public A(Map map) {
            this.map = (Map) Preconditions.checkNotNull(map);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            map().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return map().containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return map().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Object> iterator() {
            return Maps.keyIterator(map().entrySet().iterator());
        }

        public Map<Object, Object> map() {
            return this.map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            map().remove(obj);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return map().size();
        }
    }

    public static class B implements MapDifference {
        public final Map a;
        public final Map b;
        public final Map c;
        public final Map d;

        public B(Map map, Map map2, Map map3, Map map4) {
            this.a = Maps.unmodifiableMap(map);
            this.b = Maps.unmodifiableMap(map2);
            this.c = Maps.unmodifiableMap(map3);
            this.d = Maps.unmodifiableMap(map4);
        }

        @Override // com.google.common.collect.MapDifference
        public boolean areEqual() {
            return this.a.isEmpty() && this.b.isEmpty() && this.d.isEmpty();
        }

        @Override // com.google.common.collect.MapDifference
        public Map entriesDiffering() {
            return this.d;
        }

        @Override // com.google.common.collect.MapDifference
        public Map entriesInCommon() {
            return this.c;
        }

        @Override // com.google.common.collect.MapDifference
        public Map entriesOnlyOnLeft() {
            return this.a;
        }

        @Override // com.google.common.collect.MapDifference
        public Map entriesOnlyOnRight() {
            return this.b;
        }

        @Override // com.google.common.collect.MapDifference
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof MapDifference)) {
                return false;
            }
            MapDifference mapDifference = (MapDifference) obj;
            return entriesOnlyOnLeft().equals(mapDifference.entriesOnlyOnLeft()) && entriesOnlyOnRight().equals(mapDifference.entriesOnlyOnRight()) && entriesInCommon().equals(mapDifference.entriesInCommon()) && entriesDiffering().equals(mapDifference.entriesDiffering());
        }

        @Override // com.google.common.collect.MapDifference
        public int hashCode() {
            return Objects.hashCode(entriesOnlyOnLeft(), entriesOnlyOnRight(), entriesInCommon(), entriesDiffering());
        }

        public String toString() {
            if (areEqual()) {
                return "equal";
            }
            StringBuilder sb = new StringBuilder("not equal");
            if (!this.a.isEmpty()) {
                sb.append(": only on left=");
                sb.append(this.a);
            }
            if (!this.b.isEmpty()) {
                sb.append(": only on right=");
                sb.append(this.b);
            }
            if (!this.d.isEmpty()) {
                sb.append(": value differences=");
                sb.append(this.d);
            }
            return sb.toString();
        }
    }

    public static final class C extends AbstractC1956f {
        public final NavigableSet a;
        public final Function b;

        public C(NavigableSet navigableSet, Function function) {
            this.a = (NavigableSet) Preconditions.checkNotNull(navigableSet);
            this.b = (Function) Preconditions.checkNotNull(function);
        }

        @Override // com.google.common.collect.Maps.z
        public Iterator a() {
            return Maps.asMapEntryIterator(this.a, this.b);
        }

        @Override // com.google.common.collect.AbstractC1956f
        public Iterator b() {
            return descendingMap().entrySet().iterator();
        }

        @Override // com.google.common.collect.Maps.z, java.util.AbstractMap, java.util.Map
        public void clear() {
            this.a.clear();
        }

        @Override // java.util.SortedMap
        public Comparator comparator() {
            return this.a.comparator();
        }

        @Override // com.google.common.collect.AbstractC1956f, java.util.NavigableMap
        public NavigableMap descendingMap() {
            return Maps.asMap(this.a.descendingSet(), this.b);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object get(Object obj) {
            if (Collections2.safeContains(this.a, obj)) {
                return this.b.apply(obj);
            }
            return null;
        }

        @Override // java.util.NavigableMap
        public NavigableMap headMap(Object obj, boolean z) {
            return Maps.asMap(this.a.headSet(obj, z), this.b);
        }

        @Override // com.google.common.collect.AbstractC1956f, java.util.NavigableMap
        public NavigableSet navigableKeySet() {
            return Maps.removeOnlyNavigableSet(this.a);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.a.size();
        }

        @Override // java.util.NavigableMap
        public NavigableMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
            return Maps.asMap(this.a.subSet(obj, z, obj2, z2), this.b);
        }

        @Override // java.util.NavigableMap
        public NavigableMap tailMap(Object obj, boolean z) {
            return Maps.asMap(this.a.tailSet(obj, z), this.b);
        }
    }

    public static class D extends F implements NavigableSet {
        public D(NavigableMap navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableSet
        public Object ceiling(Object obj) {
            return map().ceilingKey(obj);
        }

        @Override // java.util.NavigableSet
        public Iterator<Object> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<Object> descendingSet() {
            return map().descendingKeySet();
        }

        @Override // java.util.NavigableSet
        public Object floor(Object obj) {
            return map().floorKey(obj);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<Object> headSet(Object obj, boolean z) {
            return map().headMap(obj, z).navigableKeySet();
        }

        @Override // java.util.NavigableSet
        public Object higher(Object obj) {
            return map().higherKey(obj);
        }

        @Override // java.util.NavigableSet
        public Object lower(Object obj) {
            return map().lowerKey(obj);
        }

        @Override // java.util.NavigableSet
        public Object pollFirst() {
            return Maps.keyOrNull(map().pollFirstEntry());
        }

        @Override // java.util.NavigableSet
        public Object pollLast() {
            return Maps.keyOrNull(map().pollLastEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<Object> subSet(Object obj, boolean z, Object obj2, boolean z2) {
            return map().subMap(obj, z, obj2, z2).navigableKeySet();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<Object> tailSet(Object obj, boolean z) {
            return map().tailMap(obj, z).navigableKeySet();
        }

        @Override // com.google.common.collect.Maps.F, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<Object> headSet(Object obj) {
            return headSet(obj, false);
        }

        @Override // com.google.common.collect.Maps.F, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<Object> subSet(Object obj, Object obj2) {
            return subSet(obj, true, obj2, false);
        }

        @Override // com.google.common.collect.Maps.F, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<Object> tailSet(Object obj) {
            return tailSet(obj, true);
        }

        @Override // com.google.common.collect.Maps.F, com.google.common.collect.Maps.A
        public NavigableMap<Object, Object> map() {
            return (NavigableMap) this.map;
        }
    }

    public static class E extends C1948o implements SortedMap {
        public E(SortedSet sortedSet, Function function) {
            super(sortedSet, function);
        }

        @Override // java.util.SortedMap
        public Comparator comparator() {
            return d().comparator();
        }

        @Override // com.google.common.collect.Maps.C1948o
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public SortedSet d() {
            return (SortedSet) super.d();
        }

        @Override // java.util.SortedMap
        public Object firstKey() {
            return d().first();
        }

        @Override // java.util.SortedMap
        public SortedMap headMap(Object obj) {
            return Maps.asMap(d().headSet(obj), this.e);
        }

        @Override // com.google.common.collect.Maps.Q, java.util.AbstractMap, java.util.Map, java.util.SortedMap
        public Set keySet() {
            return Maps.removeOnlySortedSet(d());
        }

        @Override // java.util.SortedMap
        public Object lastKey() {
            return d().last();
        }

        @Override // java.util.SortedMap
        public SortedMap subMap(Object obj, Object obj2) {
            return Maps.asMap(d().subSet(obj, obj2), this.e);
        }

        @Override // java.util.SortedMap
        public SortedMap tailMap(Object obj) {
            return Maps.asMap(d().tailSet(obj), this.e);
        }
    }

    public interface EntryTransformer<K, V1, V2> {
        V2 transformEntry(K k, V1 v1);
    }

    public static class F extends A implements SortedSet {
        public F(SortedMap sortedMap) {
            super(sortedMap);
        }

        @Override // java.util.SortedSet
        public Comparator<Object> comparator() {
            return map().comparator();
        }

        @Override // java.util.SortedSet
        public Object first() {
            return map().firstKey();
        }

        public SortedSet<Object> headSet(Object obj) {
            return new F(map().headMap(obj));
        }

        @Override // java.util.SortedSet
        public Object last() {
            return map().lastKey();
        }

        public SortedSet<Object> subSet(Object obj, Object obj2) {
            return new F(map().subMap(obj, obj2));
        }

        public SortedSet<Object> tailSet(Object obj) {
            return new F(map().tailMap(obj));
        }

        @Override // com.google.common.collect.Maps.A
        public SortedMap<Object, Object> map() {
            return (SortedMap) super.map();
        }
    }

    public static class G extends B implements SortedMapDifference {
        public G(SortedMap sortedMap, SortedMap sortedMap2, SortedMap sortedMap3, SortedMap sortedMap4) {
            super(sortedMap, sortedMap2, sortedMap3, sortedMap4);
        }

        @Override // com.google.common.collect.Maps.B, com.google.common.collect.MapDifference
        public SortedMap entriesDiffering() {
            return (SortedMap) super.entriesDiffering();
        }

        @Override // com.google.common.collect.Maps.B, com.google.common.collect.MapDifference
        public SortedMap entriesInCommon() {
            return (SortedMap) super.entriesInCommon();
        }

        @Override // com.google.common.collect.Maps.B, com.google.common.collect.MapDifference
        public SortedMap entriesOnlyOnLeft() {
            return (SortedMap) super.entriesOnlyOnLeft();
        }

        @Override // com.google.common.collect.Maps.B, com.google.common.collect.MapDifference
        public SortedMap entriesOnlyOnRight() {
            return (SortedMap) super.entriesOnlyOnRight();
        }
    }

    public static class H extends z {
        public final Map a;
        public final EntryTransformer b;

        public H(Map map, EntryTransformer entryTransformer) {
            this.a = (Map) Preconditions.checkNotNull(map);
            this.b = (EntryTransformer) Preconditions.checkNotNull(entryTransformer);
        }

        @Override // com.google.common.collect.Maps.z
        public Iterator a() {
            return Iterators.transform(this.a.entrySet().iterator(), Maps.asEntryToEntryFunction(this.b));
        }

        @Override // com.google.common.collect.Maps.z, java.util.AbstractMap, java.util.Map
        public void clear() {
            this.a.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.a.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object get(Object obj) {
            Object obj2 = this.a.get(obj);
            if (obj2 != null || this.a.containsKey(obj)) {
                return this.b.transformEntry(obj, WD.a(obj2));
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set keySet() {
            return this.a.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object remove(Object obj) {
            if (this.a.containsKey(obj)) {
                return this.b.transformEntry(obj, WD.a(this.a.remove(obj)));
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.a.size();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection values() {
            return new P(this);
        }
    }

    public static class I extends J implements NavigableMap {
        public I(NavigableMap navigableMap, EntryTransformer entryTransformer) {
            super(navigableMap, entryTransformer);
        }

        @Override // com.google.common.collect.Maps.J
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public NavigableMap b() {
            return (NavigableMap) super.b();
        }

        @Override // java.util.NavigableMap
        public Map.Entry ceilingEntry(Object obj) {
            return g(b().ceilingEntry(obj));
        }

        @Override // java.util.NavigableMap
        public Object ceilingKey(Object obj) {
            return b().ceilingKey(obj);
        }

        @Override // com.google.common.collect.Maps.J, java.util.SortedMap, java.util.NavigableMap
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public NavigableMap headMap(Object obj) {
            return headMap(obj, false);
        }

        @Override // java.util.NavigableMap
        public NavigableSet descendingKeySet() {
            return b().descendingKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap descendingMap() {
            return Maps.transformEntries(b().descendingMap(), this.b);
        }

        @Override // com.google.common.collect.Maps.J, java.util.SortedMap, java.util.NavigableMap
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public NavigableMap subMap(Object obj, Object obj2) {
            return subMap(obj, true, obj2, false);
        }

        @Override // com.google.common.collect.Maps.J, java.util.SortedMap, java.util.NavigableMap
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public NavigableMap tailMap(Object obj) {
            return tailMap(obj, true);
        }

        @Override // java.util.NavigableMap
        public Map.Entry firstEntry() {
            return g(b().firstEntry());
        }

        @Override // java.util.NavigableMap
        public Map.Entry floorEntry(Object obj) {
            return g(b().floorEntry(obj));
        }

        @Override // java.util.NavigableMap
        public Object floorKey(Object obj) {
            return b().floorKey(obj);
        }

        public final Map.Entry g(Map.Entry entry) {
            if (entry == null) {
                return null;
            }
            return Maps.transformEntry(this.b, entry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry higherEntry(Object obj) {
            return g(b().higherEntry(obj));
        }

        @Override // java.util.NavigableMap
        public Object higherKey(Object obj) {
            return b().higherKey(obj);
        }

        @Override // java.util.NavigableMap
        public Map.Entry lastEntry() {
            return g(b().lastEntry());
        }

        @Override // java.util.NavigableMap
        public Map.Entry lowerEntry(Object obj) {
            return g(b().lowerEntry(obj));
        }

        @Override // java.util.NavigableMap
        public Object lowerKey(Object obj) {
            return b().lowerKey(obj);
        }

        @Override // java.util.NavigableMap
        public NavigableSet navigableKeySet() {
            return b().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry pollFirstEntry() {
            return g(b().pollFirstEntry());
        }

        @Override // java.util.NavigableMap
        public Map.Entry pollLastEntry() {
            return g(b().pollLastEntry());
        }

        @Override // java.util.NavigableMap
        public NavigableMap headMap(Object obj, boolean z) {
            return Maps.transformEntries(b().headMap(obj, z), this.b);
        }

        @Override // java.util.NavigableMap
        public NavigableMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
            return Maps.transformEntries(b().subMap(obj, z, obj2, z2), this.b);
        }

        @Override // java.util.NavigableMap
        public NavigableMap tailMap(Object obj, boolean z) {
            return Maps.transformEntries(b().tailMap(obj, z), this.b);
        }
    }

    public static class J extends H implements SortedMap {
        public J(SortedMap sortedMap, EntryTransformer entryTransformer) {
            super(sortedMap, entryTransformer);
        }

        public SortedMap b() {
            return (SortedMap) this.a;
        }

        @Override // java.util.SortedMap
        public Comparator comparator() {
            return b().comparator();
        }

        @Override // java.util.SortedMap
        public Object firstKey() {
            return b().firstKey();
        }

        public SortedMap headMap(Object obj) {
            return Maps.transformEntries(b().headMap(obj), this.b);
        }

        @Override // java.util.SortedMap
        public Object lastKey() {
            return b().lastKey();
        }

        public SortedMap subMap(Object obj, Object obj2) {
            return Maps.transformEntries(b().subMap(obj, obj2), this.b);
        }

        public SortedMap tailMap(Object obj) {
            return Maps.transformEntries(b().tailMap(obj), this.b);
        }
    }

    public static class K extends ForwardingMap implements BiMap, Serializable {
        public final Map a;
        public final BiMap b;
        public BiMap c;
        public transient Set d;

        public K(BiMap biMap, BiMap biMap2) {
            this.a = Collections.unmodifiableMap(biMap);
            this.b = biMap;
            this.c = biMap2;
        }

        @Override // com.google.common.collect.BiMap
        public Object forcePut(Object obj, Object obj2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.BiMap
        public BiMap inverse() {
            BiMap biMap = this.c;
            if (biMap != null) {
                return biMap;
            }
            K k = new K(this.b.inverse(), this);
            this.c = k;
            return k;
        }

        @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        public Map delegate() {
            return this.a;
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
        public Set values() {
            Set set = this.d;
            if (set != null) {
                return set;
            }
            Set setUnmodifiableSet = Collections.unmodifiableSet(this.b.values());
            this.d = setUnmodifiableSet;
            return setUnmodifiableSet;
        }
    }

    public static class L extends ForwardingCollection {
        public final Collection a;

        public L(Collection collection) {
            this.a = collection;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return Maps.unmodifiableEntryIterator(this.a.iterator());
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Collection delegate() {
            return this.a;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            return standardToArray(objArr);
        }
    }

    public static class M extends L implements Set {
        public M(Set set) {
            super(set);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return Sets.equalsImpl(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return Sets.hashCodeImpl(this);
        }
    }

    public static class N extends ForwardingSortedMap implements NavigableMap, Serializable {
        public final NavigableMap a;
        public transient N b;

        public N(NavigableMap navigableMap) {
            this.a = navigableMap;
        }

        @Override // java.util.NavigableMap
        public Map.Entry ceilingEntry(Object obj) {
            return Maps.unmodifiableOrNull(this.a.ceilingEntry(obj));
        }

        @Override // java.util.NavigableMap
        public Object ceilingKey(Object obj) {
            return this.a.ceilingKey(obj);
        }

        @Override // java.util.NavigableMap
        public NavigableSet descendingKeySet() {
            return Sets.unmodifiableNavigableSet(this.a.descendingKeySet());
        }

        @Override // java.util.NavigableMap
        public NavigableMap descendingMap() {
            N n = this.b;
            if (n != null) {
                return n;
            }
            N n2 = new N(this.a.descendingMap(), this);
            this.b = n2;
            return n2;
        }

        @Override // java.util.NavigableMap
        public Map.Entry firstEntry() {
            return Maps.unmodifiableOrNull(this.a.firstEntry());
        }

        @Override // java.util.NavigableMap
        public Map.Entry floorEntry(Object obj) {
            return Maps.unmodifiableOrNull(this.a.floorEntry(obj));
        }

        @Override // java.util.NavigableMap
        public Object floorKey(Object obj) {
            return this.a.floorKey(obj);
        }

        @Override // com.google.common.collect.ForwardingSortedMap, java.util.SortedMap
        public SortedMap headMap(Object obj) {
            return headMap(obj, false);
        }

        @Override // java.util.NavigableMap
        public Map.Entry higherEntry(Object obj) {
            return Maps.unmodifiableOrNull(this.a.higherEntry(obj));
        }

        @Override // java.util.NavigableMap
        public Object higherKey(Object obj) {
            return this.a.higherKey(obj);
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public Set keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry lastEntry() {
            return Maps.unmodifiableOrNull(this.a.lastEntry());
        }

        @Override // java.util.NavigableMap
        public Map.Entry lowerEntry(Object obj) {
            return Maps.unmodifiableOrNull(this.a.lowerEntry(obj));
        }

        @Override // java.util.NavigableMap
        public Object lowerKey(Object obj) {
            return this.a.lowerKey(obj);
        }

        @Override // java.util.NavigableMap
        public NavigableSet navigableKeySet() {
            return Sets.unmodifiableNavigableSet(this.a.navigableKeySet());
        }

        @Override // java.util.NavigableMap
        public final Map.Entry pollFirstEntry() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableMap
        public final Map.Entry pollLastEntry() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingSortedMap, java.util.SortedMap
        public SortedMap subMap(Object obj, Object obj2) {
            return subMap(obj, true, obj2, false);
        }

        @Override // com.google.common.collect.ForwardingSortedMap, java.util.SortedMap
        public SortedMap tailMap(Object obj) {
            return tailMap(obj, true);
        }

        @Override // java.util.NavigableMap
        public NavigableMap headMap(Object obj, boolean z) {
            return Maps.unmodifiableNavigableMap(this.a.headMap(obj, z));
        }

        @Override // java.util.NavigableMap
        public NavigableMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
            return Maps.unmodifiableNavigableMap(this.a.subMap(obj, z, obj2, z2));
        }

        @Override // java.util.NavigableMap
        public NavigableMap tailMap(Object obj, boolean z) {
            return Maps.unmodifiableNavigableMap(this.a.tailMap(obj, z));
        }

        public N(NavigableMap navigableMap, N n) {
            this.a = navigableMap;
            this.b = n;
        }

        @Override // com.google.common.collect.ForwardingSortedMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        public SortedMap delegate() {
            return Collections.unmodifiableSortedMap(this.a);
        }
    }

    public static class O implements MapDifference.ValueDifference {
        public final Object a;
        public final Object b;

        public O(Object obj, Object obj2) {
            this.a = obj;
            this.b = obj2;
        }

        public static MapDifference.ValueDifference a(Object obj, Object obj2) {
            return new O(obj, obj2);
        }

        @Override // com.google.common.collect.MapDifference.ValueDifference
        public boolean equals(Object obj) {
            if (!(obj instanceof MapDifference.ValueDifference)) {
                return false;
            }
            MapDifference.ValueDifference valueDifference = (MapDifference.ValueDifference) obj;
            return Objects.equal(this.a, valueDifference.leftValue()) && Objects.equal(this.b, valueDifference.rightValue());
        }

        @Override // com.google.common.collect.MapDifference.ValueDifference
        public int hashCode() {
            return Objects.hashCode(this.a, this.b);
        }

        @Override // com.google.common.collect.MapDifference.ValueDifference
        public Object leftValue() {
            return this.a;
        }

        @Override // com.google.common.collect.MapDifference.ValueDifference
        public Object rightValue() {
            return this.b;
        }

        public String toString() {
            String strValueOf = String.valueOf(this.a);
            String strValueOf2 = String.valueOf(this.b);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 4 + strValueOf2.length());
            sb.append("(");
            sb.append(strValueOf);
            sb.append(", ");
            sb.append(strValueOf2);
            sb.append(")");
            return sb.toString();
        }
    }

    public static class P extends AbstractCollection {

        @Weak
        final Map<Object, Object> map;

        public P(Map map) {
            this.map = (Map) Preconditions.checkNotNull(map);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            map().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return map().containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return map().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Object> iterator() {
            return Maps.valueIterator(map().entrySet().iterator());
        }

        public final Map<Object, Object> map() {
            return this.map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            try {
                return super.remove(obj);
            } catch (UnsupportedOperationException unused) {
                for (Map.Entry<Object, Object> entry : map().entrySet()) {
                    if (Objects.equal(obj, entry.getValue())) {
                        map().remove(entry.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) Preconditions.checkNotNull(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet hashSetNewHashSet = Sets.newHashSet();
                for (Map.Entry<Object, Object> entry : map().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        hashSetNewHashSet.add(entry.getKey());
                    }
                }
                return map().keySet().removeAll(hashSetNewHashSet);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) Preconditions.checkNotNull(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet hashSetNewHashSet = Sets.newHashSet();
                for (Map.Entry<Object, Object> entry : map().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        hashSetNewHashSet.add(entry.getKey());
                    }
                }
                return map().keySet().retainAll(hashSetNewHashSet);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return map().size();
        }
    }

    public static abstract class Q extends AbstractMap {
        public transient Set a;
        public transient Set b;
        public transient Collection c;

        public abstract Set a();

        /* JADX INFO: renamed from: b */
        public Set g() {
            return new A(this);
        }

        public Collection c() {
            return new P(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set entrySet() {
            Set set = this.a;
            if (set != null) {
                return set;
            }
            Set setA = a();
            this.a = setA;
            return setA;
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
        public Set keySet() {
            Set set = this.b;
            if (set != null) {
                return set;
            }
            Set setG = g();
            this.b = setG;
            return setG;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection values() {
            Collection collection = this.c;
            if (collection != null) {
                return collection;
            }
            Collection collectionC = c();
            this.c = collectionC;
            return collectionC;
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.Maps$a, reason: case insensitive filesystem */
    public class C1934a implements Function {
        public final /* synthetic */ EntryTransformer a;
        public final /* synthetic */ Object b;

        public C1934a(EntryTransformer entryTransformer, Object obj) {
            this.a = entryTransformer;
            this.b = obj;
        }

        @Override // com.google.common.base.Function
        public Object apply(Object obj) {
            return this.a.transformEntry(this.b, obj);
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.Maps$b, reason: case insensitive filesystem */
    public class C1935b implements Function {
        public final /* synthetic */ EntryTransformer a;

        public C1935b(EntryTransformer entryTransformer) {
            this.a = entryTransformer;
        }

        @Override // com.google.common.base.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object apply(Map.Entry entry) {
            return this.a.transformEntry(entry.getKey(), entry.getValue());
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.Maps$c, reason: case insensitive filesystem */
    public class C1936c extends Y {
        public final /* synthetic */ Map.Entry a;
        public final /* synthetic */ EntryTransformer b;

        public C1936c(Map.Entry entry, EntryTransformer entryTransformer) {
            this.a = entry;
            this.b = entryTransformer;
        }

        @Override // defpackage.Y, java.util.Map.Entry
        public Object getKey() {
            return this.a.getKey();
        }

        @Override // defpackage.Y, java.util.Map.Entry
        public Object getValue() {
            return this.b.transformEntry(this.a.getKey(), this.a.getValue());
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.Maps$d, reason: case insensitive filesystem */
    public class C1937d implements Function {
        public final /* synthetic */ EntryTransformer a;

        public C1937d(EntryTransformer entryTransformer) {
            this.a = entryTransformer;
        }

        @Override // com.google.common.base.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry apply(Map.Entry entry) {
            return Maps.transformEntry(this.a, entry);
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.Maps$e, reason: case insensitive filesystem */
    public class C1938e extends AbstractC2362hV {
        public C1938e(Iterator it) {
            super(it);
        }

        @Override // defpackage.AbstractC2362hV
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Object a(Map.Entry entry) {
            return entry.getKey();
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.Maps$f, reason: case insensitive filesystem */
    public class C1939f extends AbstractC2362hV {
        public C1939f(Iterator it) {
            super(it);
        }

        @Override // defpackage.AbstractC2362hV
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Object a(Map.Entry entry) {
            return entry.getValue();
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.Maps$g, reason: case insensitive filesystem */
    public class C1940g extends AbstractC2362hV {
        public final /* synthetic */ Function b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1940g(Iterator it, Function function) {
            super(it);
            this.b = function;
        }

        @Override // defpackage.AbstractC2362hV
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry a(Object obj) {
            return Maps.immutableEntry(obj, this.b.apply(obj));
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.Maps$j, reason: case insensitive filesystem */
    public class C1943j extends ForwardingNavigableSet {
        public final /* synthetic */ NavigableSet a;

        public C1943j(NavigableSet navigableSet) {
            this.a = navigableSet;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
        public boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public NavigableSet descendingSet() {
            return Maps.removeOnlyNavigableSet(super.descendingSet());
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public SortedSet headSet(Object obj) {
            return Maps.removeOnlySortedSet(super.headSet(obj));
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public SortedSet subSet(Object obj, Object obj2) {
            return Maps.removeOnlySortedSet(super.subSet(obj, obj2));
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public SortedSet tailSet(Object obj) {
            return Maps.removeOnlySortedSet(super.tailSet(obj));
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public NavigableSet headSet(Object obj, boolean z) {
            return Maps.removeOnlyNavigableSet(super.headSet(obj, z));
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public NavigableSet subSet(Object obj, boolean z, Object obj2, boolean z2) {
            return Maps.removeOnlyNavigableSet(super.subSet(obj, z, obj2, z2));
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public NavigableSet tailSet(Object obj, boolean z) {
            return Maps.removeOnlyNavigableSet(super.tailSet(obj, z));
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public NavigableSet delegate() {
            return this.a;
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.Maps$k, reason: case insensitive filesystem */
    public class C1944k extends Y {
        public final /* synthetic */ Map.Entry a;

        public C1944k(Map.Entry entry) {
            this.a = entry;
        }

        @Override // defpackage.Y, java.util.Map.Entry
        public Object getKey() {
            return this.a.getKey();
        }

        @Override // defpackage.Y, java.util.Map.Entry
        public Object getValue() {
            return this.a.getValue();
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.Maps$l, reason: case insensitive filesystem */
    public class C1945l extends UnmodifiableIterator {
        public final /* synthetic */ Iterator a;

        public C1945l(Iterator it) {
            this.a = it;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            return Maps.unmodifiableEntry((Map.Entry) this.a.next());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext();
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.Maps$m, reason: case insensitive filesystem */
    public class C1946m implements EntryTransformer {
        public final /* synthetic */ Function a;

        public C1946m(Function function) {
            this.a = function;
        }

        @Override // com.google.common.collect.Maps.EntryTransformer
        public Object transformEntry(Object obj, Object obj2) {
            return this.a.apply(obj2);
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.Maps$n, reason: case insensitive filesystem */
    public static abstract class AbstractC1947n extends Q {
        public final Map d;
        public final Predicate e;

        public AbstractC1947n(Map map, Predicate predicate) {
            this.d = map;
            this.e = predicate;
        }

        @Override // com.google.common.collect.Maps.Q
        public Collection c() {
            return new y(this, this.d, this.e);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.d.containsKey(obj) && d(obj, this.d.get(obj));
        }

        public boolean d(Object obj, Object obj2) {
            return this.e.apply(Maps.immutableEntry(obj, obj2));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object get(Object obj) {
            Object obj2 = this.d.get(obj);
            if (obj2 == null || !d(obj, obj2)) {
                return null;
            }
            return obj2;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return entrySet().isEmpty();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object put(Object obj, Object obj2) {
            Preconditions.checkArgument(d(obj, obj2));
            return this.d.put(obj, obj2);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void putAll(Map map) {
            for (Map.Entry entry : map.entrySet()) {
                Preconditions.checkArgument(d(entry.getKey(), entry.getValue()));
            }
            this.d.putAll(map);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object remove(Object obj) {
            if (containsKey(obj)) {
                return this.d.remove(obj);
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.Maps$o, reason: case insensitive filesystem */
    public static class C1948o extends Q {
        public final Set d;
        public final Function e;

        /* JADX INFO: renamed from: com.google.common.collect.Maps$o$a */
        public class a extends s {
            public a() {
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator iterator() {
                return Maps.asMapEntryIterator(C1948o.this.d(), C1948o.this.e);
            }

            @Override // com.google.common.collect.Maps.s
            public Map map() {
                return C1948o.this;
            }
        }

        public C1948o(Set set, Function function) {
            this.d = (Set) Preconditions.checkNotNull(set);
            this.e = (Function) Preconditions.checkNotNull(function);
        }

        @Override // com.google.common.collect.Maps.Q
        public Set a() {
            return new a();
        }

        @Override // com.google.common.collect.Maps.Q
        /* JADX INFO: renamed from: b */
        public Set g() {
            return Maps.removeOnlySet(d());
        }

        @Override // com.google.common.collect.Maps.Q
        public Collection c() {
            return Collections2.transform(this.d, this.e);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            d().clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return d().contains(obj);
        }

        public Set d() {
            return this.d;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object get(Object obj) {
            if (Collections2.safeContains(d(), obj)) {
                return this.e.apply(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object remove(Object obj) {
            if (d().remove(obj)) {
                return this.e.apply(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return d().size();
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.Maps$p, reason: case insensitive filesystem */
    public static final class C1949p extends Converter implements Serializable {
        public final BiMap a;

        public C1949p(BiMap biMap) {
            this.a = (BiMap) Preconditions.checkNotNull(biMap);
        }

        public static Object a(BiMap biMap, Object obj) {
            Object obj2 = biMap.get(obj);
            Preconditions.checkArgument(obj2 != null, "No non-null mapping present for input: %s", obj);
            return obj2;
        }

        @Override // com.google.common.base.Converter
        public Object doBackward(Object obj) {
            return a(this.a.inverse(), obj);
        }

        @Override // com.google.common.base.Converter
        public Object doForward(Object obj) {
            return a(this.a, obj);
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(Object obj) {
            if (obj instanceof C1949p) {
                return this.a.equals(((C1949p) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            String strValueOf = String.valueOf(this.a);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 18);
            sb.append("Maps.asConverter(");
            sb.append(strValueOf);
            sb.append(")");
            return sb.toString();
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.Maps$q, reason: case insensitive filesystem */
    public static abstract class AbstractC1950q extends ForwardingMap implements NavigableMap {
        private transient Comparator<Object> comparator;
        private transient Set<Map.Entry<Object, Object>> entrySet;
        private transient NavigableSet<Object> navigableKeySet;

        /* JADX INFO: renamed from: com.google.common.collect.Maps$q$a */
        public class a extends s {
            public a() {
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator iterator() {
                return AbstractC1950q.this.entryIterator();
            }

            @Override // com.google.common.collect.Maps.s
            public Map map() {
                return AbstractC1950q.this;
            }
        }

        private static Ordering c(Comparator comparator) {
            return Ordering.from(comparator).reverse();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<Object, Object> ceilingEntry(Object obj) {
            return forward().floorEntry(obj);
        }

        @Override // java.util.NavigableMap
        public Object ceilingKey(Object obj) {
            return forward().floorKey(obj);
        }

        @Override // java.util.SortedMap
        public Comparator<Object> comparator() {
            Comparator<Object> comparator = this.comparator;
            if (comparator != null) {
                return comparator;
            }
            Comparator comparator2 = forward().comparator();
            if (comparator2 == null) {
                comparator2 = Ordering.natural();
            }
            Ordering orderingC = c(comparator2);
            this.comparator = orderingC;
            return orderingC;
        }

        public Set<Map.Entry<Object, Object>> createEntrySet() {
            return new a();
        }

        @Override // java.util.NavigableMap
        public NavigableSet<Object> descendingKeySet() {
            return forward().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<Object, Object> descendingMap() {
            return forward();
        }

        public abstract Iterator entryIterator();

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public Set<Map.Entry<Object, Object>> entrySet() {
            Set<Map.Entry<Object, Object>> set = this.entrySet;
            if (set != null) {
                return set;
            }
            Set<Map.Entry<Object, Object>> setCreateEntrySet = createEntrySet();
            this.entrySet = setCreateEntrySet;
            return setCreateEntrySet;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<Object, Object> firstEntry() {
            return forward().lastEntry();
        }

        @Override // java.util.SortedMap
        public Object firstKey() {
            return forward().lastKey();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<Object, Object> floorEntry(Object obj) {
            return forward().ceilingEntry(obj);
        }

        @Override // java.util.NavigableMap
        public Object floorKey(Object obj) {
            return forward().ceilingKey(obj);
        }

        public abstract NavigableMap forward();

        @Override // java.util.NavigableMap
        public NavigableMap<Object, Object> headMap(Object obj, boolean z) {
            return forward().tailMap(obj, z).descendingMap();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<Object, Object> higherEntry(Object obj) {
            return forward().lowerEntry(obj);
        }

        @Override // java.util.NavigableMap
        public Object higherKey(Object obj) {
            return forward().lowerKey(obj);
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public Set<Object> keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<Object, Object> lastEntry() {
            return forward().firstEntry();
        }

        @Override // java.util.SortedMap
        public Object lastKey() {
            return forward().firstKey();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<Object, Object> lowerEntry(Object obj) {
            return forward().higherEntry(obj);
        }

        @Override // java.util.NavigableMap
        public Object lowerKey(Object obj) {
            return forward().higherKey(obj);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<Object> navigableKeySet() {
            NavigableSet<Object> navigableSet = this.navigableKeySet;
            if (navigableSet != null) {
                return navigableSet;
            }
            D d = new D(this);
            this.navigableKeySet = d;
            return d;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<Object, Object> pollFirstEntry() {
            return forward().pollLastEntry();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<Object, Object> pollLastEntry() {
            return forward().pollFirstEntry();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<Object, Object> subMap(Object obj, boolean z, Object obj2, boolean z2) {
            return forward().subMap(obj2, z2, obj, z).descendingMap();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<Object, Object> tailMap(Object obj, boolean z) {
            return forward().headMap(obj, z).descendingMap();
        }

        @Override // com.google.common.collect.ForwardingObject
        public String toString() {
            return standardToString();
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
        public Collection<Object> values() {
            return new P(this);
        }

        @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        public final Map<Object, Object> delegate() {
            return forward();
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<Object, Object> headMap(Object obj) {
            return headMap(obj, false);
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<Object, Object> subMap(Object obj, Object obj2) {
            return subMap(obj, true, obj2, false);
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<Object, Object> tailMap(Object obj) {
            return tailMap(obj, true);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class r implements Function {
        public static final r a = new a("KEY", 0);
        public static final r b = new b("VALUE", 1);
        public static final /* synthetic */ r[] c = a();

        public final enum a extends r {
            public a(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.base.Function
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Object apply(Map.Entry entry) {
                return entry.getKey();
            }
        }

        public final enum b extends r {
            public b(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.base.Function
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Object apply(Map.Entry entry) {
                return entry.getValue();
            }
        }

        public r(String str, int i) {
            super(str, i);
        }

        public static /* synthetic */ r[] a() {
            return new r[]{a, b};
        }

        public static r valueOf(String str) {
            return (r) Enum.valueOf(r.class, str);
        }

        public static r[] values() {
            return (r[]) c.clone();
        }

        public /* synthetic */ r(String str, int i, C1938e c1938e) {
            this(str, i);
        }
    }

    public static abstract class s extends Sets.k {
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            map().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object objSafeGet = Maps.safeGet(map(), key);
            if (Objects.equal(objSafeGet, entry.getValue())) {
                return objSafeGet != null || map().containsKey(key);
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return map().isEmpty();
        }

        public abstract Map map();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (contains(obj) && (obj instanceof Map.Entry)) {
                return map().keySet().remove(((Map.Entry) obj).getKey());
            }
            return false;
        }

        @Override // com.google.common.collect.Sets.k, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) Preconditions.checkNotNull(collection));
            } catch (UnsupportedOperationException unused) {
                return Sets.removeAllImpl(this, collection.iterator());
            }
        }

        @Override // com.google.common.collect.Sets.k, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) Preconditions.checkNotNull(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet hashSetNewHashSetWithExpectedSize = Sets.newHashSetWithExpectedSize(collection.size());
                for (Object obj : collection) {
                    if (contains(obj) && (obj instanceof Map.Entry)) {
                        hashSetNewHashSetWithExpectedSize.add(((Map.Entry) obj).getKey());
                    }
                }
                return map().keySet().retainAll(hashSetNewHashSetWithExpectedSize);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return map().size();
        }
    }

    public static final class t extends u implements BiMap {
        public final BiMap g;

        public class a implements Predicate {
            public final /* synthetic */ Predicate a;

            public a(Predicate predicate) {
                this.a = predicate;
            }

            @Override // com.google.common.base.Predicate
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean apply(Map.Entry entry) {
                return this.a.apply(Maps.immutableEntry(entry.getValue(), entry.getKey()));
            }
        }

        public t(BiMap biMap, Predicate predicate) {
            super(biMap, predicate);
            this.g = new t(biMap.inverse(), g(predicate), this);
        }

        public static Predicate g(Predicate predicate) {
            return new a(predicate);
        }

        @Override // com.google.common.collect.BiMap
        public Object forcePut(Object obj, Object obj2) {
            Preconditions.checkArgument(d(obj, obj2));
            return h().forcePut(obj, obj2);
        }

        public BiMap h() {
            return (BiMap) this.d;
        }

        @Override // com.google.common.collect.BiMap
        public BiMap inverse() {
            return this.g;
        }

        @Override // com.google.common.collect.Maps.Q, java.util.AbstractMap, java.util.Map
        public Set values() {
            return this.g.keySet();
        }

        public t(BiMap biMap, Predicate predicate, BiMap biMap2) {
            super(biMap, predicate);
            this.g = biMap2;
        }
    }

    public static class u extends AbstractC1947n {
        public final Set f;

        public class a extends ForwardingSet {

            /* JADX INFO: renamed from: com.google.common.collect.Maps$u$a$a, reason: collision with other inner class name */
            public class C0224a extends AbstractC2362hV {

                /* JADX INFO: renamed from: com.google.common.collect.Maps$u$a$a$a, reason: collision with other inner class name */
                public class C0225a extends ForwardingMapEntry {
                    public final /* synthetic */ Map.Entry a;

                    public C0225a(Map.Entry entry) {
                        this.a = entry;
                    }

                    @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
                    public Object setValue(Object obj) {
                        Preconditions.checkArgument(u.this.d(getKey(), obj));
                        return super.setValue(obj);
                    }

                    @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
                    public Map.Entry delegate() {
                        return this.a;
                    }
                }

                public C0224a(Iterator it) {
                    super(it);
                }

                @Override // defpackage.AbstractC2362hV
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public Map.Entry a(Map.Entry entry) {
                    return new C0225a(entry);
                }
            }

            public a() {
            }

            @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable
            public Iterator iterator() {
                return new C0224a(u.this.f.iterator());
            }

            public /* synthetic */ a(u uVar, C1938e c1938e) {
                this();
            }

            @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
            public Set delegate() {
                return u.this.f;
            }
        }

        public class b extends A {
            public b() {
                super(u.this);
            }

            @Override // com.google.common.collect.Maps.A, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!u.this.containsKey(obj)) {
                    return false;
                }
                u.this.d.remove(obj);
                return true;
            }

            @Override // com.google.common.collect.Sets.k, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection collection) {
                u uVar = u.this;
                return u.e(uVar.d, uVar.e, collection);
            }

            @Override // com.google.common.collect.Sets.k, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection collection) {
                u uVar = u.this;
                return u.f(uVar.d, uVar.e, collection);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public Object[] toArray() {
                return Lists.newArrayList(iterator()).toArray();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public Object[] toArray(Object[] objArr) {
                return Lists.newArrayList(iterator()).toArray(objArr);
            }
        }

        public u(Map map, Predicate predicate) {
            super(map, predicate);
            this.f = Sets.filter(map.entrySet(), this.e);
        }

        public static boolean e(Map map, Predicate predicate, Collection collection) {
            Iterator it = map.entrySet().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (predicate.apply(entry) && collection.contains(entry.getKey())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        public static boolean f(Map map, Predicate predicate, Collection collection) {
            Iterator it = map.entrySet().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (predicate.apply(entry) && !collection.contains(entry.getKey())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // com.google.common.collect.Maps.Q
        public Set a() {
            return new a(this, null);
        }

        @Override // com.google.common.collect.Maps.Q
        /* JADX INFO: renamed from: b */
        public Set g() {
            return new b();
        }
    }

    public static class v extends AbstractC1956f {
        public final NavigableMap a;
        public final Predicate b;
        public final Map c;

        public class a extends D {
            public a(NavigableMap navigableMap) {
                super(navigableMap);
            }

            @Override // com.google.common.collect.Sets.k, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection collection) {
                return u.e(v.this.a, v.this.b, collection);
            }

            @Override // com.google.common.collect.Sets.k, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection collection) {
                return u.f(v.this.a, v.this.b, collection);
            }
        }

        public v(NavigableMap navigableMap, Predicate predicate) {
            this.a = (NavigableMap) Preconditions.checkNotNull(navigableMap);
            this.b = predicate;
            this.c = new u(navigableMap, predicate);
        }

        @Override // com.google.common.collect.Maps.z
        public Iterator a() {
            return Iterators.filter(this.a.entrySet().iterator(), this.b);
        }

        @Override // com.google.common.collect.AbstractC1956f
        public Iterator b() {
            return Iterators.filter(this.a.descendingMap().entrySet().iterator(), this.b);
        }

        @Override // com.google.common.collect.Maps.z, java.util.AbstractMap, java.util.Map
        public void clear() {
            this.c.clear();
        }

        @Override // java.util.SortedMap
        public Comparator comparator() {
            return this.a.comparator();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.c.containsKey(obj);
        }

        @Override // com.google.common.collect.AbstractC1956f, java.util.NavigableMap
        public NavigableMap descendingMap() {
            return Maps.filterEntries(this.a.descendingMap(), this.b);
        }

        @Override // com.google.common.collect.Maps.z, java.util.AbstractMap, java.util.Map, java.util.SortedMap
        public Set entrySet() {
            return this.c.entrySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object get(Object obj) {
            return this.c.get(obj);
        }

        @Override // java.util.NavigableMap
        public NavigableMap headMap(Object obj, boolean z) {
            return Maps.filterEntries(this.a.headMap(obj, z), this.b);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return !Iterables.any(this.a.entrySet(), this.b);
        }

        @Override // com.google.common.collect.AbstractC1956f, java.util.NavigableMap
        public NavigableSet navigableKeySet() {
            return new a(this);
        }

        @Override // com.google.common.collect.AbstractC1956f, java.util.NavigableMap
        public Map.Entry pollFirstEntry() {
            return (Map.Entry) Iterables.removeFirstMatching(this.a.entrySet(), this.b);
        }

        @Override // com.google.common.collect.AbstractC1956f, java.util.NavigableMap
        public Map.Entry pollLastEntry() {
            return (Map.Entry) Iterables.removeFirstMatching(this.a.descendingMap().entrySet(), this.b);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object put(Object obj, Object obj2) {
            return this.c.put(obj, obj2);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void putAll(Map map) {
            this.c.putAll(map);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object remove(Object obj) {
            return this.c.remove(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.c.size();
        }

        @Override // java.util.NavigableMap
        public NavigableMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
            return Maps.filterEntries(this.a.subMap(obj, z, obj2, z2), this.b);
        }

        @Override // java.util.NavigableMap
        public NavigableMap tailMap(Object obj, boolean z) {
            return Maps.filterEntries(this.a.tailMap(obj, z), this.b);
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
        public Collection values() {
            return new y(this, this.a, this.b);
        }
    }

    public static class w extends u implements SortedMap {

        public class a extends u.b implements SortedSet {
            public a() {
                super();
            }

            @Override // java.util.SortedSet
            public Comparator comparator() {
                return w.this.j().comparator();
            }

            @Override // java.util.SortedSet
            public Object first() {
                return w.this.firstKey();
            }

            @Override // java.util.SortedSet
            public SortedSet headSet(Object obj) {
                return (SortedSet) w.this.headMap(obj).keySet();
            }

            @Override // java.util.SortedSet
            public Object last() {
                return w.this.lastKey();
            }

            @Override // java.util.SortedSet
            public SortedSet subSet(Object obj, Object obj2) {
                return (SortedSet) w.this.subMap(obj, obj2).keySet();
            }

            @Override // java.util.SortedSet
            public SortedSet tailSet(Object obj) {
                return (SortedSet) w.this.tailMap(obj).keySet();
            }
        }

        public w(SortedMap sortedMap, Predicate predicate) {
            super(sortedMap, predicate);
        }

        @Override // java.util.SortedMap
        public Comparator comparator() {
            return j().comparator();
        }

        @Override // java.util.SortedMap
        public Object firstKey() {
            return keySet().iterator().next();
        }

        @Override // com.google.common.collect.Maps.u, com.google.common.collect.Maps.Q
        public SortedSet g() {
            return new a();
        }

        @Override // com.google.common.collect.Maps.Q, java.util.AbstractMap, java.util.Map, java.util.SortedMap
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public SortedSet keySet() {
            return (SortedSet) super.keySet();
        }

        @Override // java.util.SortedMap
        public SortedMap headMap(Object obj) {
            return new w(j().headMap(obj), this.e);
        }

        public SortedMap j() {
            return (SortedMap) this.d;
        }

        @Override // java.util.SortedMap
        public Object lastKey() {
            SortedMap sortedMapJ = j();
            while (true) {
                Object objLastKey = sortedMapJ.lastKey();
                if (d(objLastKey, WD.a(this.d.get(objLastKey)))) {
                    return objLastKey;
                }
                sortedMapJ = j().headMap(objLastKey);
            }
        }

        @Override // java.util.SortedMap
        public SortedMap subMap(Object obj, Object obj2) {
            return new w(j().subMap(obj, obj2), this.e);
        }

        @Override // java.util.SortedMap
        public SortedMap tailMap(Object obj) {
            return new w(j().tailMap(obj), this.e);
        }
    }

    public static class x extends AbstractC1947n {
        public final Predicate f;

        public x(Map map, Predicate predicate, Predicate predicate2) {
            super(map, predicate2);
            this.f = predicate;
        }

        @Override // com.google.common.collect.Maps.Q
        public Set a() {
            return Sets.filter(this.d.entrySet(), this.e);
        }

        @Override // com.google.common.collect.Maps.Q
        /* JADX INFO: renamed from: b */
        public Set g() {
            return Sets.filter(this.d.keySet(), this.f);
        }

        @Override // com.google.common.collect.Maps.AbstractC1947n, java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.d.containsKey(obj) && this.f.apply(obj);
        }
    }

    public static final class y extends P {
        public final Map a;
        public final Predicate b;

        public y(Map map, Map map2, Predicate predicate) {
            super(map);
            this.a = map2;
            this.b = predicate;
        }

        @Override // com.google.common.collect.Maps.P, java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            Iterator it = this.a.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (this.b.apply(entry) && Objects.equal(entry.getValue(), obj)) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.common.collect.Maps.P, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection collection) {
            Iterator it = this.a.entrySet().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (this.b.apply(entry) && collection.contains(entry.getValue())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // com.google.common.collect.Maps.P, java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection collection) {
            Iterator it = this.a.entrySet().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (this.b.apply(entry) && !collection.contains(entry.getValue())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return Lists.newArrayList(iterator()).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            return Lists.newArrayList(iterator()).toArray(objArr);
        }
    }

    public static abstract class z extends AbstractMap {

        public class a extends s {
            public a() {
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator iterator() {
                return z.this.a();
            }

            @Override // com.google.common.collect.Maps.s
            public Map map() {
                return z.this;
            }
        }

        public abstract Iterator a();

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            Iterators.clear(a());
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
        public Set entrySet() {
            return new a();
        }
    }

    private Maps() {
    }

    public static <A, B> Converter<A, B> asConverter(BiMap<A, B> biMap) {
        return new C1949p(biMap);
    }

    public static <K, V1, V2> Function<Map.Entry<K, V1>, Map.Entry<K, V2>> asEntryToEntryFunction(EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        Preconditions.checkNotNull(entryTransformer);
        return new C1937d(entryTransformer);
    }

    public static <K, V1, V2> Function<Map.Entry<K, V1>, V2> asEntryToValueFunction(EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        Preconditions.checkNotNull(entryTransformer);
        return new C1935b(entryTransformer);
    }

    public static <K, V1, V2> EntryTransformer<K, V1, V2> asEntryTransformer(Function<? super V1, V2> function) {
        Preconditions.checkNotNull(function);
        return new C1946m(function);
    }

    public static <K, V> Map<K, V> asMap(Set<K> set, Function<? super K, V> function) {
        return new C1948o(set, function);
    }

    public static <K, V> Iterator<Map.Entry<K, V>> asMapEntryIterator(Set<K> set, Function<? super K, V> function) {
        return new C1940g(set.iterator(), function);
    }

    public static <K, V1, V2> Function<V1, V2> asValueToValueFunction(EntryTransformer<? super K, V1, V2> entryTransformer, K k) {
        Preconditions.checkNotNull(entryTransformer);
        return new C1934a(entryTransformer, k);
    }

    public static int capacity(int i) {
        if (i < 3) {
            AbstractC1163Zb.b(i, "expectedSize");
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static <K, V> boolean containsEntryImpl(Collection<Map.Entry<K, V>> collection, Object obj) {
        if (obj instanceof Map.Entry) {
            return collection.contains(unmodifiableEntry((Map.Entry) obj));
        }
        return false;
    }

    public static boolean containsKeyImpl(Map<?, ?> map, Object obj) {
        return Iterators.contains(keyIterator(map.entrySet().iterator()), obj);
    }

    public static boolean containsValueImpl(Map<?, ?> map, Object obj) {
        return Iterators.contains(valueIterator(map.entrySet().iterator()), obj);
    }

    public static <K, V> MapDifference<K, V> difference(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2) {
        return map instanceof SortedMap ? difference((SortedMap) map, (Map) map2) : difference(map, map2, Equivalence.equals());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <K, V> void doDifference(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2, Equivalence<? super V> equivalence, Map<K, V> map3, Map<K, V> map4, Map<K, V> map5, Map<K, MapDifference.ValueDifference<V>> map6) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();
            if (map2.containsKey(key)) {
                A30 a30 = (Object) WD.a(map4.remove(key));
                if (equivalence.equivalent(value, a30)) {
                    map5.put(key, value);
                } else {
                    map6.put(key, O.a(value, a30));
                }
            } else {
                map3.put(key, value);
            }
        }
    }

    public static boolean equalsImpl(Map<?, ?> map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public static <K, V> Map<K, V> filterEntries(Map<K, V> map, Predicate<? super Map.Entry<K, V>> predicate) {
        Preconditions.checkNotNull(predicate);
        return map instanceof AbstractC1947n ? filterFiltered((AbstractC1947n) map, predicate) : new u((Map) Preconditions.checkNotNull(map), predicate);
    }

    private static <K, V> Map<K, V> filterFiltered(AbstractC1947n abstractC1947n, Predicate<? super Map.Entry<K, V>> predicate) {
        return new u(abstractC1947n.d, Predicates.and(abstractC1947n.e, predicate));
    }

    public static <K, V> Map<K, V> filterKeys(Map<K, V> map, Predicate<? super K> predicate) {
        Preconditions.checkNotNull(predicate);
        Predicate predicateKeyPredicateOnEntries = keyPredicateOnEntries(predicate);
        return map instanceof AbstractC1947n ? filterFiltered((AbstractC1947n) map, predicateKeyPredicateOnEntries) : new x((Map) Preconditions.checkNotNull(map), predicate, predicateKeyPredicateOnEntries);
    }

    public static <K, V> Map<K, V> filterValues(Map<K, V> map, Predicate<? super V> predicate) {
        return filterEntries(map, valuePredicateOnEntries(predicate));
    }

    @GwtIncompatible
    public static ImmutableMap<String, String> fromProperties(Properties properties) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        Enumeration<?> enumerationPropertyNames = properties.propertyNames();
        while (enumerationPropertyNames.hasMoreElements()) {
            Object objNextElement = enumerationPropertyNames.nextElement();
            java.util.Objects.requireNonNull(objNextElement);
            String str = (String) objNextElement;
            String property = properties.getProperty(str);
            java.util.Objects.requireNonNull(property);
            builder.put(str, property);
        }
        return builder.buildOrThrow();
    }

    @GwtCompatible(serializable = true)
    public static <K, V> Map.Entry<K, V> immutableEntry(K k, V v2) {
        return new C3427ms(k, v2);
    }

    @GwtCompatible(serializable = true)
    public static <K extends Enum<K>, V> ImmutableMap<K, V> immutableEnumMap(Map<K, ? extends V> map) {
        if (map instanceof com.google.common.collect.r) {
            return (com.google.common.collect.r) map;
        }
        Iterator<Map.Entry<K, ? extends V>> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return ImmutableMap.of();
        }
        Map.Entry<K, ? extends V> next = it.next();
        K key = next.getKey();
        V value = next.getValue();
        AbstractC1163Zb.a(key, value);
        EnumMap enumMap = new EnumMap(key.getDeclaringClass());
        enumMap.put((Enum) key, (Object) value);
        while (it.hasNext()) {
            Map.Entry<K, ? extends V> next2 = it.next();
            K key2 = next2.getKey();
            V value2 = next2.getValue();
            AbstractC1163Zb.a(key2, value2);
            enumMap.put((Enum) key2, (Object) value2);
        }
        return com.google.common.collect.r.b(enumMap);
    }

    public static <E> ImmutableMap<E, Integer> indexMap(Collection<E> collection) {
        ImmutableMap.Builder builder = new ImmutableMap.Builder(collection.size());
        Iterator<E> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            builder.put(it.next(), Integer.valueOf(i));
            i++;
        }
        return builder.buildOrThrow();
    }

    public static <K> Function<Map.Entry<K, ?>, K> keyFunction() {
        return r.a;
    }

    public static <K, V> Iterator<K> keyIterator(Iterator<Map.Entry<K, V>> it) {
        return new C1938e(it);
    }

    public static <K> K keyOrNull(Map.Entry<K, ?> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getKey();
    }

    public static <K> Predicate<Map.Entry<K, ?>> keyPredicateOnEntries(Predicate<? super K> predicate) {
        return Predicates.compose(predicate, keyFunction());
    }

    public static <K, V> ConcurrentMap<K, V> newConcurrentMap() {
        return new ConcurrentHashMap();
    }

    public static <K extends Enum<K>, V> EnumMap<K, V> newEnumMap(Class<K> cls) {
        return new EnumMap<>((Class) Preconditions.checkNotNull(cls));
    }

    public static <K, V> HashMap<K, V> newHashMap() {
        return new HashMap<>();
    }

    public static <K, V> HashMap<K, V> newHashMapWithExpectedSize(int i) {
        return new HashMap<>(capacity(i));
    }

    public static <K, V> IdentityHashMap<K, V> newIdentityHashMap() {
        return new IdentityHashMap<>();
    }

    public static <K, V> LinkedHashMap<K, V> newLinkedHashMap() {
        return new LinkedHashMap<>();
    }

    public static <K, V> LinkedHashMap<K, V> newLinkedHashMapWithExpectedSize(int i) {
        return new LinkedHashMap<>(capacity(i));
    }

    public static <K extends Comparable, V> TreeMap<K, V> newTreeMap() {
        return new TreeMap<>();
    }

    public static <E> Comparator<? super E> orNaturalOrder(Comparator<? super E> comparator) {
        return comparator != null ? comparator : Ordering.natural();
    }

    public static <K, V> void putAllImpl(Map<K, V> map, Map<? extends K, ? extends V> map2) {
        for (Map.Entry<? extends K, ? extends V> entry : map2.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
    }

    public static <K, V> boolean removeEntryImpl(Collection<Map.Entry<K, V>> collection, Object obj) {
        if (obj instanceof Map.Entry) {
            return collection.remove(unmodifiableEntry((Map.Entry) obj));
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GwtIncompatible
    public static <E> NavigableSet<E> removeOnlyNavigableSet(NavigableSet<E> navigableSet) {
        return new C1943j(navigableSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> Set<E> removeOnlySet(Set<E> set) {
        return new C1941h(set);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> SortedSet<E> removeOnlySortedSet(SortedSet<E> sortedSet) {
        return new C1942i(sortedSet);
    }

    public static boolean safeContainsKey(Map<?, ?> map, Object obj) {
        Preconditions.checkNotNull(map);
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static <V> V safeGet(Map<?, V> map, Object obj) {
        Preconditions.checkNotNull(map);
        try {
            return map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    public static <V> V safeRemove(Map<?, V> map, Object obj) {
        Preconditions.checkNotNull(map);
        try {
            return map.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Beta
    @GwtIncompatible
    public static <K extends Comparable<? super K>, V> NavigableMap<K, V> subMap(NavigableMap<K, V> navigableMap, Range<K> range) {
        if (navigableMap.comparator() != null && navigableMap.comparator() != Ordering.natural() && range.hasLowerBound() && range.hasUpperBound()) {
            Preconditions.checkArgument(navigableMap.comparator().compare(range.lowerEndpoint(), range.upperEndpoint()) <= 0, "map is using a custom comparator which is inconsistent with the natural ordering.");
        }
        if (range.hasLowerBound() && range.hasUpperBound()) {
            Comparable comparableLowerEndpoint = range.lowerEndpoint();
            BoundType boundTypeLowerBoundType = range.lowerBoundType();
            BoundType boundType = BoundType.CLOSED;
            return navigableMap.subMap(comparableLowerEndpoint, boundTypeLowerBoundType == boundType, range.upperEndpoint(), range.upperBoundType() == boundType);
        }
        if (range.hasLowerBound()) {
            return navigableMap.tailMap(range.lowerEndpoint(), range.lowerBoundType() == BoundType.CLOSED);
        }
        if (range.hasUpperBound()) {
            return navigableMap.headMap(range.upperEndpoint(), range.upperBoundType() == BoundType.CLOSED);
        }
        return (NavigableMap) Preconditions.checkNotNull(navigableMap);
    }

    public static <K, V> BiMap<K, V> synchronizedBiMap(BiMap<K, V> biMap) {
        return com.google.common.collect.N.g(biMap, null);
    }

    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> synchronizedNavigableMap(NavigableMap<K, V> navigableMap) {
        return com.google.common.collect.N.o(navigableMap);
    }

    public static <K, V> ImmutableMap<K, V> toMap(Iterable<K> iterable, Function<? super K, V> function) {
        return toMap(iterable.iterator(), function);
    }

    public static String toStringImpl(Map<?, ?> map) {
        StringBuilder sbNewStringBuilderForCollection = Collections2.newStringBuilderForCollection(map.size());
        sbNewStringBuilderForCollection.append('{');
        boolean z2 = true;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (!z2) {
                sbNewStringBuilderForCollection.append(", ");
            }
            sbNewStringBuilderForCollection.append(entry.getKey());
            sbNewStringBuilderForCollection.append('=');
            sbNewStringBuilderForCollection.append(entry.getValue());
            z2 = false;
        }
        sbNewStringBuilderForCollection.append('}');
        return sbNewStringBuilderForCollection.toString();
    }

    public static <K, V1, V2> Map<K, V2> transformEntries(Map<K, V1> map, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return new H(map, entryTransformer);
    }

    public static <V2, K, V1> Map.Entry<K, V2> transformEntry(EntryTransformer<? super K, ? super V1, V2> entryTransformer, Map.Entry<K, V1> entry) {
        Preconditions.checkNotNull(entryTransformer);
        Preconditions.checkNotNull(entry);
        return new C1936c(entry, entryTransformer);
    }

    public static <K, V1, V2> Map<K, V2> transformValues(Map<K, V1> map, Function<? super V1, V2> function) {
        return transformEntries(map, asEntryTransformer(function));
    }

    @CanIgnoreReturnValue
    public static <K, V> ImmutableMap<K, V> uniqueIndex(Iterable<V> iterable, Function<? super V, K> function) {
        return uniqueIndex(iterable.iterator(), function);
    }

    public static <K, V> BiMap<K, V> unmodifiableBiMap(BiMap<? extends K, ? extends V> biMap) {
        return new K(biMap, null);
    }

    public static <K, V> Map.Entry<K, V> unmodifiableEntry(Map.Entry<? extends K, ? extends V> entry) {
        Preconditions.checkNotNull(entry);
        return new C1944k(entry);
    }

    public static <K, V> UnmodifiableIterator<Map.Entry<K, V>> unmodifiableEntryIterator(Iterator<Map.Entry<K, V>> it) {
        return new C1945l(it);
    }

    public static <K, V> Set<Map.Entry<K, V>> unmodifiableEntrySet(Set<Map.Entry<K, V>> set) {
        return new M(Collections.unmodifiableSet(set));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> Map<K, V> unmodifiableMap(Map<K, ? extends V> map) {
        return map instanceof SortedMap ? Collections.unmodifiableSortedMap((SortedMap) map) : Collections.unmodifiableMap(map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> unmodifiableNavigableMap(NavigableMap<K, ? extends V> navigableMap) {
        Preconditions.checkNotNull(navigableMap);
        return navigableMap instanceof N ? navigableMap : new N(navigableMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> Map.Entry<K, V> unmodifiableOrNull(Map.Entry<K, ? extends V> entry) {
        if (entry == null) {
            return null;
        }
        return unmodifiableEntry(entry);
    }

    public static <V> Function<Map.Entry<?, V>, V> valueFunction() {
        return r.b;
    }

    public static <K, V> Iterator<V> valueIterator(Iterator<Map.Entry<K, V>> it) {
        return new C1939f(it);
    }

    public static <V> V valueOrNull(Map.Entry<?, V> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    public static <V> Predicate<Map.Entry<?, V>> valuePredicateOnEntries(Predicate<? super V> predicate) {
        return Predicates.compose(predicate, valueFunction());
    }

    /* JADX INFO: renamed from: com.google.common.collect.Maps$h, reason: case insensitive filesystem */
    public class C1941h extends ForwardingSet {
        public final /* synthetic */ Set a;

        public C1941h(Set set) {
            this.a = set;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
        public boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Set delegate() {
            return this.a;
        }
    }

    public static <K, V> SortedMap<K, V> asMap(SortedSet<K> sortedSet, Function<? super K, V> function) {
        return new E(sortedSet, function);
    }

    public static <K, V> SortedMap<K, V> filterValues(SortedMap<K, V> sortedMap, Predicate<? super V> predicate) {
        return filterEntries((SortedMap) sortedMap, valuePredicateOnEntries(predicate));
    }

    public static <K extends Enum<K>, V> EnumMap<K, V> newEnumMap(Map<K, ? extends V> map) {
        return new EnumMap<>(map);
    }

    public static <K, V> HashMap<K, V> newHashMap(Map<? extends K, ? extends V> map) {
        return new HashMap<>(map);
    }

    public static <K, V> LinkedHashMap<K, V> newLinkedHashMap(Map<? extends K, ? extends V> map) {
        return new LinkedHashMap<>(map);
    }

    public static <K, V> TreeMap<K, V> newTreeMap(SortedMap<K, ? extends V> sortedMap) {
        return new TreeMap<>((SortedMap) sortedMap);
    }

    public static <K, V> ImmutableMap<K, V> toMap(Iterator<K> it, Function<? super K, V> function) {
        Preconditions.checkNotNull(function);
        ImmutableMap.Builder builder = ImmutableMap.builder();
        while (it.hasNext()) {
            K next = it.next();
            builder.put(next, function.apply(next));
        }
        return builder.buildKeepingLast();
    }

    public static <K, V1, V2> SortedMap<K, V2> transformEntries(SortedMap<K, V1> sortedMap, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return new J(sortedMap, entryTransformer);
    }

    public static <K, V1, V2> SortedMap<K, V2> transformValues(SortedMap<K, V1> sortedMap, Function<? super V1, V2> function) {
        return transformEntries((SortedMap) sortedMap, asEntryTransformer(function));
    }

    @CanIgnoreReturnValue
    public static <K, V> ImmutableMap<K, V> uniqueIndex(Iterator<V> it, Function<? super V, K> function) {
        Preconditions.checkNotNull(function);
        ImmutableMap.Builder builder = ImmutableMap.builder();
        while (it.hasNext()) {
            V next = it.next();
            builder.put(function.apply(next), next);
        }
        try {
            return builder.buildOrThrow();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(String.valueOf(e.getMessage()).concat(". To index multiple values under a key, use Multimaps.index."));
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.Maps$i, reason: case insensitive filesystem */
    public class C1942i extends ForwardingSortedSet {
        public final /* synthetic */ SortedSet a;

        public C1942i(SortedSet sortedSet) {
            this.a = sortedSet;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
        public boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public SortedSet headSet(Object obj) {
            return Maps.removeOnlySortedSet(super.headSet(obj));
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public SortedSet subSet(Object obj, Object obj2) {
            return Maps.removeOnlySortedSet(super.subSet(obj, obj2));
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public SortedSet tailSet(Object obj) {
            return Maps.removeOnlySortedSet(super.tailSet(obj));
        }

        @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public SortedSet delegate() {
            return this.a;
        }
    }

    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> asMap(NavigableSet<K> navigableSet, Function<? super K, V> function) {
        return new C(navigableSet, function);
    }

    private static <K, V> SortedMap<K, V> filterFiltered(w wVar, Predicate<? super Map.Entry<K, V>> predicate) {
        return new w(wVar.j(), Predicates.and(wVar.e, predicate));
    }

    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> filterValues(NavigableMap<K, V> navigableMap, Predicate<? super V> predicate) {
        return filterEntries((NavigableMap) navigableMap, valuePredicateOnEntries(predicate));
    }

    public static <C, K extends C, V> TreeMap<K, V> newTreeMap(Comparator<C> comparator) {
        return new TreeMap<>(comparator);
    }

    @GwtIncompatible
    public static <K, V1, V2> NavigableMap<K, V2> transformEntries(NavigableMap<K, V1> navigableMap, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return new I(navigableMap, entryTransformer);
    }

    @GwtIncompatible
    public static <K, V1, V2> NavigableMap<K, V2> transformValues(NavigableMap<K, V1> navigableMap, Function<? super V1, V2> function) {
        return transformEntries((NavigableMap) navigableMap, asEntryTransformer(function));
    }

    public static <K, V> BiMap<K, V> filterValues(BiMap<K, V> biMap, Predicate<? super V> predicate) {
        return filterEntries((BiMap) biMap, valuePredicateOnEntries(predicate));
    }

    public static <K, V> MapDifference<K, V> difference(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2, Equivalence<? super V> equivalence) {
        Preconditions.checkNotNull(equivalence);
        LinkedHashMap linkedHashMapNewLinkedHashMap = newLinkedHashMap();
        LinkedHashMap linkedHashMap = new LinkedHashMap(map2);
        LinkedHashMap linkedHashMapNewLinkedHashMap2 = newLinkedHashMap();
        LinkedHashMap linkedHashMapNewLinkedHashMap3 = newLinkedHashMap();
        doDifference(map, map2, equivalence, linkedHashMapNewLinkedHashMap, linkedHashMap, linkedHashMapNewLinkedHashMap2, linkedHashMapNewLinkedHashMap3);
        return new B(linkedHashMapNewLinkedHashMap, linkedHashMap, linkedHashMapNewLinkedHashMap2, linkedHashMapNewLinkedHashMap3);
    }

    public static <K, V> SortedMap<K, V> filterEntries(SortedMap<K, V> sortedMap, Predicate<? super Map.Entry<K, V>> predicate) {
        Preconditions.checkNotNull(predicate);
        if (sortedMap instanceof w) {
            return filterFiltered((w) sortedMap, (Predicate) predicate);
        }
        return new w((SortedMap) Preconditions.checkNotNull(sortedMap), predicate);
    }

    @GwtIncompatible
    private static <K, V> NavigableMap<K, V> filterFiltered(v vVar, Predicate<? super Map.Entry<K, V>> predicate) {
        return new v(vVar.a, Predicates.and(vVar.b, predicate));
    }

    public static <K, V> SortedMap<K, V> filterKeys(SortedMap<K, V> sortedMap, Predicate<? super K> predicate) {
        return filterEntries((SortedMap) sortedMap, keyPredicateOnEntries(predicate));
    }

    private static <K, V> BiMap<K, V> filterFiltered(t tVar, Predicate<? super Map.Entry<K, V>> predicate) {
        return new t(tVar.h(), Predicates.and(tVar.e, predicate));
    }

    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> filterKeys(NavigableMap<K, V> navigableMap, Predicate<? super K> predicate) {
        return filterEntries((NavigableMap) navigableMap, keyPredicateOnEntries(predicate));
    }

    public static <K, V> BiMap<K, V> filterKeys(BiMap<K, V> biMap, Predicate<? super K> predicate) {
        Preconditions.checkNotNull(predicate);
        return filterEntries((BiMap) biMap, keyPredicateOnEntries(predicate));
    }

    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> filterEntries(NavigableMap<K, V> navigableMap, Predicate<? super Map.Entry<K, V>> predicate) {
        Preconditions.checkNotNull(predicate);
        if (navigableMap instanceof v) {
            return filterFiltered((v) navigableMap, predicate);
        }
        return new v((NavigableMap) Preconditions.checkNotNull(navigableMap), predicate);
    }

    public static <K, V> SortedMapDifference<K, V> difference(SortedMap<K, ? extends V> sortedMap, Map<? extends K, ? extends V> map) {
        Preconditions.checkNotNull(sortedMap);
        Preconditions.checkNotNull(map);
        Comparator comparatorOrNaturalOrder = orNaturalOrder(sortedMap.comparator());
        TreeMap treeMapNewTreeMap = newTreeMap(comparatorOrNaturalOrder);
        TreeMap treeMapNewTreeMap2 = newTreeMap(comparatorOrNaturalOrder);
        treeMapNewTreeMap2.putAll(map);
        TreeMap treeMapNewTreeMap3 = newTreeMap(comparatorOrNaturalOrder);
        TreeMap treeMapNewTreeMap4 = newTreeMap(comparatorOrNaturalOrder);
        doDifference(sortedMap, map, Equivalence.equals(), treeMapNewTreeMap, treeMapNewTreeMap2, treeMapNewTreeMap3, treeMapNewTreeMap4);
        return new G(treeMapNewTreeMap, treeMapNewTreeMap2, treeMapNewTreeMap3, treeMapNewTreeMap4);
    }

    public static <K, V> BiMap<K, V> filterEntries(BiMap<K, V> biMap, Predicate<? super Map.Entry<K, V>> predicate) {
        Preconditions.checkNotNull(biMap);
        Preconditions.checkNotNull(predicate);
        if (biMap instanceof t) {
            return filterFiltered((t) biMap, (Predicate) predicate);
        }
        return new t(biMap, predicate);
    }
}
