package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Supplier;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import defpackage.AbstractC1163Zb;
import defpackage.AbstractC2362hV;
import defpackage.C3666pm;
import defpackage.C3747qm;
import defpackage.C3827rm;
import defpackage.C3908sm;
import defpackage.InterfaceC3989tm;
import defpackage.InterfaceC4151vm;
import defpackage.WD;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
public final class Multimaps {

    public static final class a extends Maps.Q {
        public final Multimap d;

        /* JADX INFO: renamed from: com.google.common.collect.Multimaps$a$a, reason: collision with other inner class name */
        public class C0226a extends Maps.s {

            /* JADX INFO: renamed from: com.google.common.collect.Multimaps$a$a$a, reason: collision with other inner class name */
            public class C0227a implements Function {
                public C0227a() {
                }

                @Override // com.google.common.base.Function
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Collection apply(Object obj) {
                    return a.this.d.get(obj);
                }
            }

            public C0226a() {
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator iterator() {
                return Maps.asMapEntryIterator(a.this.d.keySet(), new C0227a());
            }

            @Override // com.google.common.collect.Maps.s
            public Map map() {
                return a.this;
            }

            @Override // com.google.common.collect.Maps.s, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Objects.requireNonNull(entry);
                a.this.g(entry.getKey());
                return true;
            }
        }

        public a(Multimap multimap) {
            this.d = (Multimap) Preconditions.checkNotNull(multimap);
        }

        @Override // com.google.common.collect.Maps.Q
        public Set a() {
            return new C0226a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.d.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.d.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Collection get(Object obj) {
            if (containsKey(obj)) {
                return this.d.get(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Collection remove(Object obj) {
            if (containsKey(obj)) {
                return this.d.removeAll(obj);
            }
            return null;
        }

        public void g(Object obj) {
            this.d.keySet().remove(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.d.isEmpty();
        }

        @Override // com.google.common.collect.Maps.Q, java.util.AbstractMap, java.util.Map, java.util.SortedMap
        public Set keySet() {
            return this.d.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.d.keySet().size();
        }
    }

    public static class b extends AbstractC1951a {
        public transient Supplier a;

        public b(Map map, Supplier supplier) {
            super(map);
            this.a = (Supplier) Preconditions.checkNotNull(supplier);
        }

        @Override // com.google.common.collect.AbstractC1952b, com.google.common.collect.AbstractC1954d
        public Map createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // com.google.common.collect.AbstractC1952b, com.google.common.collect.AbstractC1954d
        public Set createKeySet() {
            return createMaybeNavigableKeySet();
        }

        @Override // com.google.common.collect.AbstractC1952b
        public List createCollection() {
            return (List) this.a.get();
        }
    }

    public static class c extends AbstractC1952b {
        public transient Supplier a;

        public c(Map map, Supplier supplier) {
            super(map);
            this.a = (Supplier) Preconditions.checkNotNull(supplier);
        }

        @Override // com.google.common.collect.AbstractC1952b, com.google.common.collect.AbstractC1954d
        public Map createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // com.google.common.collect.AbstractC1952b
        public Collection createCollection() {
            return (Collection) this.a.get();
        }

        @Override // com.google.common.collect.AbstractC1952b, com.google.common.collect.AbstractC1954d
        public Set createKeySet() {
            return createMaybeNavigableKeySet();
        }

        @Override // com.google.common.collect.AbstractC1952b
        public Collection unmodifiableCollectionSubclass(Collection collection) {
            if (collection instanceof NavigableSet) {
                return Sets.unmodifiableNavigableSet((NavigableSet) collection);
            }
            if (collection instanceof SortedSet) {
                return Collections.unmodifiableSortedSet((SortedSet) collection);
            }
            if (collection instanceof Set) {
                return Collections.unmodifiableSet((Set) collection);
            }
            return collection instanceof List ? Collections.unmodifiableList((List) collection) : Collections.unmodifiableCollection(collection);
        }

        @Override // com.google.common.collect.AbstractC1952b
        public Collection wrapCollection(Object obj, Collection collection) {
            if (collection instanceof List) {
                return wrapList(obj, (List) collection, null);
            }
            if (collection instanceof NavigableSet) {
                return new AbstractC1952b.m(obj, (NavigableSet) collection, null);
            }
            if (collection instanceof SortedSet) {
                return new AbstractC1952b.o(obj, (SortedSet) collection, null);
            }
            return collection instanceof Set ? new AbstractC1952b.n(obj, (Set) collection) : new AbstractC1952b.k(obj, collection, null);
        }
    }

    public static class d extends AbstractC1957g {
        public transient Supplier a;

        public d(Map map, Supplier supplier) {
            super(map);
            this.a = (Supplier) Preconditions.checkNotNull(supplier);
        }

        @Override // com.google.common.collect.AbstractC1952b, com.google.common.collect.AbstractC1954d
        public Map createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // com.google.common.collect.AbstractC1952b, com.google.common.collect.AbstractC1954d
        public Set createKeySet() {
            return createMaybeNavigableKeySet();
        }

        @Override // com.google.common.collect.AbstractC1957g, com.google.common.collect.AbstractC1952b
        public Collection unmodifiableCollectionSubclass(Collection collection) {
            if (collection instanceof NavigableSet) {
                return Sets.unmodifiableNavigableSet((NavigableSet) collection);
            }
            return collection instanceof SortedSet ? Collections.unmodifiableSortedSet((SortedSet) collection) : Collections.unmodifiableSet((Set) collection);
        }

        @Override // com.google.common.collect.AbstractC1957g, com.google.common.collect.AbstractC1952b
        public Collection wrapCollection(Object obj, Collection collection) {
            if (collection instanceof NavigableSet) {
                return new AbstractC1952b.m(obj, (NavigableSet) collection, null);
            }
            return collection instanceof SortedSet ? new AbstractC1952b.o(obj, (SortedSet) collection, null) : new AbstractC1952b.n(obj, (Set) collection);
        }

        @Override // com.google.common.collect.AbstractC1952b
        public Set createCollection() {
            return (Set) this.a.get();
        }
    }

    public static class e extends AbstractC1959i {
        public transient Supplier a;
        public transient Comparator b;

        public e(Map map, Supplier supplier) {
            super(map);
            this.a = (Supplier) Preconditions.checkNotNull(supplier);
            this.b = ((SortedSet) supplier.get()).comparator();
        }

        @Override // com.google.common.collect.AbstractC1952b, com.google.common.collect.AbstractC1954d
        public Map createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // com.google.common.collect.AbstractC1952b, com.google.common.collect.AbstractC1954d
        public Set createKeySet() {
            return createMaybeNavigableKeySet();
        }

        @Override // com.google.common.collect.SortedSetMultimap
        public Comparator valueComparator() {
            return this.b;
        }

        @Override // com.google.common.collect.AbstractC1952b
        public SortedSet createCollection() {
            return (SortedSet) this.a.get();
        }
    }

    public static abstract class f extends AbstractCollection {
        public abstract Multimap a();

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return a().containsEntry(entry.getKey(), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return a().remove(entry.getKey(), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return a().size();
        }
    }

    public static class g extends AbstractC1955e {
        public final Multimap a;

        public class a extends AbstractC2362hV {

            /* JADX INFO: renamed from: com.google.common.collect.Multimaps$g$a$a, reason: collision with other inner class name */
            public class C0228a extends Multisets.f {
                public final /* synthetic */ Map.Entry a;

                public C0228a(a aVar, Map.Entry entry) {
                    this.a = entry;
                }

                @Override // com.google.common.collect.Multiset.Entry
                public int getCount() {
                    return ((Collection) this.a.getValue()).size();
                }

                @Override // com.google.common.collect.Multiset.Entry
                public Object getElement() {
                    return this.a.getKey();
                }
            }

            public a(g gVar, Iterator it) {
                super(it);
            }

            @Override // defpackage.AbstractC2362hV
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Multiset.Entry a(Map.Entry entry) {
                return new C0228a(this, entry);
            }
        }

        public g(Multimap multimap) {
            this.a = multimap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.a.clear();
        }

        @Override // com.google.common.collect.AbstractC1955e, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
        public boolean contains(Object obj) {
            return this.a.containsKey(obj);
        }

        @Override // com.google.common.collect.Multiset
        public int count(Object obj) {
            Collection collection = (Collection) Maps.safeGet(this.a.asMap(), obj);
            if (collection == null) {
                return 0;
            }
            return collection.size();
        }

        @Override // com.google.common.collect.AbstractC1955e
        public int distinctElements() {
            return this.a.asMap().size();
        }

        @Override // com.google.common.collect.AbstractC1955e
        public Iterator elementIterator() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.AbstractC1955e, com.google.common.collect.Multiset
        public Set elementSet() {
            return this.a.keySet();
        }

        @Override // com.google.common.collect.AbstractC1955e
        public Iterator entryIterator() {
            return new a(this, this.a.asMap().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
        public Iterator iterator() {
            return Maps.keyIterator(this.a.entries().iterator());
        }

        @Override // com.google.common.collect.AbstractC1955e, com.google.common.collect.Multiset
        public int remove(Object obj, int i) {
            AbstractC1163Zb.b(i, "occurrences");
            if (i == 0) {
                return count(obj);
            }
            Collection collection = (Collection) Maps.safeGet(this.a.asMap(), obj);
            if (collection == null) {
                return 0;
            }
            int size = collection.size();
            if (i >= size) {
                collection.clear();
            } else {
                Iterator it = collection.iterator();
                for (int i2 = 0; i2 < i; i2++) {
                    it.next();
                    it.remove();
                }
            }
            return size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
        public int size() {
            return this.a.size();
        }
    }

    public static class h extends AbstractC1954d implements SetMultimap, Serializable {
        public final Map a;

        public class a extends Sets.k {
            public final /* synthetic */ Object a;

            /* JADX INFO: renamed from: com.google.common.collect.Multimaps$h$a$a, reason: collision with other inner class name */
            public class C0229a implements Iterator {
                public int a;

                public C0229a() {
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    if (this.a == 0) {
                        a aVar = a.this;
                        if (h.this.a.containsKey(aVar.a)) {
                            return true;
                        }
                    }
                    return false;
                }

                @Override // java.util.Iterator
                public Object next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    this.a++;
                    a aVar = a.this;
                    return WD.a(h.this.a.get(aVar.a));
                }

                @Override // java.util.Iterator
                public void remove() {
                    AbstractC1163Zb.e(this.a == 1);
                    this.a = -1;
                    a aVar = a.this;
                    h.this.a.remove(aVar.a);
                }
            }

            public a(Object obj) {
                this.a = obj;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator iterator() {
                return new C0229a();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return h.this.a.containsKey(this.a) ? 1 : 0;
            }
        }

        public h(Map map) {
            this.a = (Map) Preconditions.checkNotNull(map);
        }

        @Override // com.google.common.collect.Multimap
        public void clear() {
            this.a.clear();
        }

        @Override // com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap
        public boolean containsEntry(Object obj, Object obj2) {
            return this.a.entrySet().contains(Maps.immutableEntry(obj, obj2));
        }

        @Override // com.google.common.collect.Multimap
        public boolean containsKey(Object obj) {
            return this.a.containsKey(obj);
        }

        @Override // com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap
        public boolean containsValue(Object obj) {
            return this.a.containsValue(obj);
        }

        @Override // com.google.common.collect.AbstractC1954d
        public Map createAsMap() {
            return new a(this);
        }

        @Override // com.google.common.collect.AbstractC1954d
        public Collection createEntries() {
            throw new AssertionError("unreachable");
        }

        @Override // com.google.common.collect.AbstractC1954d
        public Set createKeySet() {
            return this.a.keySet();
        }

        @Override // com.google.common.collect.AbstractC1954d
        public Multiset createKeys() {
            return new g(this);
        }

        @Override // com.google.common.collect.AbstractC1954d
        public Collection createValues() {
            return this.a.values();
        }

        @Override // com.google.common.collect.AbstractC1954d
        public Iterator entryIterator() {
            return this.a.entrySet().iterator();
        }

        @Override // com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap
        public int hashCode() {
            return this.a.hashCode();
        }

        @Override // com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap
        public boolean put(Object obj, Object obj2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap
        public boolean putAll(Object obj, Iterable iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap
        public boolean remove(Object obj, Object obj2) {
            return this.a.entrySet().remove(Maps.immutableEntry(obj, obj2));
        }

        @Override // com.google.common.collect.Multimap
        public int size() {
            return this.a.size();
        }

        @Override // com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap
        public Set entries() {
            return this.a.entrySet();
        }

        @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Set get(Object obj) {
            return new a(obj);
        }

        @Override // com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap
        public boolean putAll(Multimap multimap) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Set removeAll(Object obj) {
            HashSet hashSet = new HashSet(2);
            if (!this.a.containsKey(obj)) {
                return hashSet;
            }
            hashSet.add(this.a.remove(obj));
            return hashSet;
        }

        @Override // com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Set replaceValues(Object obj, Iterable iterable) {
            throw new UnsupportedOperationException();
        }
    }

    public static final class i extends j implements ListMultimap {
        public i(ListMultimap listMultimap, Maps.EntryTransformer entryTransformer) {
            super(listMultimap, entryTransformer);
        }

        @Override // com.google.common.collect.Multimaps.j
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public List c(Object obj, Collection collection) {
            return Lists.transform((List) collection, Maps.asValueToValueFunction(this.b, obj));
        }

        @Override // com.google.common.collect.Multimaps.j, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public List get(Object obj) {
            return c(obj, this.a.get(obj));
        }

        @Override // com.google.common.collect.Multimaps.j, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public List removeAll(Object obj) {
            return c(obj, this.a.removeAll(obj));
        }

        @Override // com.google.common.collect.Multimaps.j, com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public List replaceValues(Object obj, Iterable iterable) {
            throw new UnsupportedOperationException();
        }
    }

    public static class j extends AbstractC1954d {
        public final Multimap a;
        public final Maps.EntryTransformer b;

        public class a implements Maps.EntryTransformer {
            public a() {
            }

            @Override // com.google.common.collect.Maps.EntryTransformer
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Collection transformEntry(Object obj, Collection collection) {
                return j.this.c(obj, collection);
            }
        }

        public j(Multimap multimap, Maps.EntryTransformer entryTransformer) {
            this.a = (Multimap) Preconditions.checkNotNull(multimap);
            this.b = (Maps.EntryTransformer) Preconditions.checkNotNull(entryTransformer);
        }

        public Collection c(Object obj, Collection collection) {
            Function functionAsValueToValueFunction = Maps.asValueToValueFunction(this.b, obj);
            return collection instanceof List ? Lists.transform((List) collection, functionAsValueToValueFunction) : Collections2.transform(collection, functionAsValueToValueFunction);
        }

        @Override // com.google.common.collect.Multimap
        public void clear() {
            this.a.clear();
        }

        @Override // com.google.common.collect.Multimap
        public boolean containsKey(Object obj) {
            return this.a.containsKey(obj);
        }

        @Override // com.google.common.collect.AbstractC1954d
        public Map createAsMap() {
            return Maps.transformEntries(this.a.asMap(), new a());
        }

        @Override // com.google.common.collect.AbstractC1954d
        public Collection createEntries() {
            return new AbstractC1954d.a();
        }

        @Override // com.google.common.collect.AbstractC1954d
        public Set createKeySet() {
            return this.a.keySet();
        }

        @Override // com.google.common.collect.AbstractC1954d
        public Multiset createKeys() {
            return this.a.keys();
        }

        @Override // com.google.common.collect.AbstractC1954d
        public Collection createValues() {
            return Collections2.transform(this.a.entries(), Maps.asEntryToValueFunction(this.b));
        }

        @Override // com.google.common.collect.AbstractC1954d
        public Iterator entryIterator() {
            return Iterators.transform(this.a.entries().iterator(), Maps.asEntryToEntryFunction(this.b));
        }

        @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Collection get(Object obj) {
            return c(obj, this.a.get(obj));
        }

        @Override // com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap
        public boolean isEmpty() {
            return this.a.isEmpty();
        }

        @Override // com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap
        public boolean put(Object obj, Object obj2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap
        public boolean putAll(Object obj, Iterable iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap
        public boolean remove(Object obj, Object obj2) {
            return get(obj).remove(obj2);
        }

        @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Collection removeAll(Object obj) {
            return c(obj, this.a.removeAll(obj));
        }

        @Override // com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Collection replaceValues(Object obj, Iterable iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimap
        public int size() {
            return this.a.size();
        }

        @Override // com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap
        public boolean putAll(Multimap multimap) {
            throw new UnsupportedOperationException();
        }
    }

    public static class k extends l implements ListMultimap {
        public k(ListMultimap listMultimap) {
            super(listMultimap);
        }

        @Override // com.google.common.collect.Multimaps.l, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public List get(Object obj) {
            return Collections.unmodifiableList(delegate().get(obj));
        }

        @Override // com.google.common.collect.Multimaps.l, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public List removeAll(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.l, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public List replaceValues(Object obj, Iterable iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.l, com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
        public ListMultimap delegate() {
            return (ListMultimap) super.delegate();
        }
    }

    public static class l extends ForwardingMultimap implements Serializable {
        public final Multimap a;
        public transient Collection b;
        public transient Multiset c;
        public transient Set d;
        public transient Collection e;
        public transient Map f;

        public class a implements Function {
            public a(l lVar) {
            }

            @Override // com.google.common.base.Function
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Collection apply(Collection collection) {
                return Multimaps.unmodifiableValueCollection(collection);
            }
        }

        public l(Multimap multimap) {
            this.a = (Multimap) Preconditions.checkNotNull(multimap);
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Map asMap() {
            Map map = this.f;
            if (map != null) {
                return map;
            }
            Map mapUnmodifiableMap = Collections.unmodifiableMap(Maps.transformValues(this.a.asMap(), new a(this)));
            this.f = mapUnmodifiableMap;
            return mapUnmodifiableMap;
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public Collection entries() {
            Collection collection = this.b;
            if (collection != null) {
                return collection;
            }
            Collection collectionUnmodifiableEntries = Multimaps.unmodifiableEntries(this.a.entries());
            this.b = collectionUnmodifiableEntries;
            return collectionUnmodifiableEntries;
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Collection get(Object obj) {
            return Multimaps.unmodifiableValueCollection(this.a.get(obj));
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public Set keySet() {
            Set set = this.d;
            if (set != null) {
                return set;
            }
            Set setUnmodifiableSet = Collections.unmodifiableSet(this.a.keySet());
            this.d = setUnmodifiableSet;
            return setUnmodifiableSet;
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public Multiset keys() {
            Multiset multiset = this.c;
            if (multiset != null) {
                return multiset;
            }
            Multiset multisetUnmodifiableMultiset = Multisets.unmodifiableMultiset(this.a.keys());
            this.c = multisetUnmodifiableMultiset;
            return multisetUnmodifiableMultiset;
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public boolean put(Object obj, Object obj2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public boolean putAll(Object obj, Iterable iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public boolean remove(Object obj, Object obj2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Collection removeAll(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Collection replaceValues(Object obj, Iterable iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public Collection values() {
            Collection collection = this.e;
            if (collection != null) {
                return collection;
            }
            Collection collectionUnmodifiableCollection = Collections.unmodifiableCollection(this.a.values());
            this.e = collectionUnmodifiableCollection;
            return collectionUnmodifiableCollection;
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
        public Multimap delegate() {
            return this.a;
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public boolean putAll(Multimap multimap) {
            throw new UnsupportedOperationException();
        }
    }

    public static class m extends l implements SetMultimap {
        public m(SetMultimap setMultimap) {
            super(setMultimap);
        }

        @Override // com.google.common.collect.Multimaps.l, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public Set entries() {
            return Maps.unmodifiableEntrySet(delegate().entries());
        }

        @Override // com.google.common.collect.Multimaps.l, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Set get(Object obj) {
            return Collections.unmodifiableSet(delegate().get(obj));
        }

        @Override // com.google.common.collect.Multimaps.l, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Set removeAll(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.l, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Set replaceValues(Object obj, Iterable iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.l, com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
        public SetMultimap delegate() {
            return (SetMultimap) super.delegate();
        }
    }

    private Multimaps() {
    }

    @Beta
    public static <K, V> Map<K, List<V>> asMap(ListMultimap<K, V> listMultimap) {
        return listMultimap.asMap();
    }

    public static boolean equalsImpl(Multimap<?, ?> multimap, Object obj) {
        if (obj == multimap) {
            return true;
        }
        if (obj instanceof Multimap) {
            return multimap.asMap().equals(((Multimap) obj).asMap());
        }
        return false;
    }

    public static <K, V> Multimap<K, V> filterEntries(Multimap<K, V> multimap, Predicate<? super Map.Entry<K, V>> predicate) {
        Preconditions.checkNotNull(predicate);
        if (multimap instanceof SetMultimap) {
            return filterEntries((SetMultimap) multimap, (Predicate) predicate);
        }
        return multimap instanceof InterfaceC3989tm ? filterFiltered((InterfaceC3989tm) multimap, predicate) : new q((Multimap) Preconditions.checkNotNull(multimap), predicate);
    }

    private static <K, V> Multimap<K, V> filterFiltered(InterfaceC3989tm interfaceC3989tm, Predicate<? super Map.Entry<K, V>> predicate) {
        return new q(interfaceC3989tm.a(), Predicates.and(interfaceC3989tm.b(), predicate));
    }

    public static <K, V> Multimap<K, V> filterKeys(Multimap<K, V> multimap, Predicate<? super K> predicate) {
        if (multimap instanceof SetMultimap) {
            return filterKeys((SetMultimap) multimap, (Predicate) predicate);
        }
        if (multimap instanceof ListMultimap) {
            return filterKeys((ListMultimap) multimap, (Predicate) predicate);
        }
        if (!(multimap instanceof C3827rm)) {
            return multimap instanceof InterfaceC3989tm ? filterFiltered((InterfaceC3989tm) multimap, Maps.keyPredicateOnEntries(predicate)) : new C3827rm(multimap, predicate);
        }
        C3827rm c3827rm = (C3827rm) multimap;
        return new C3827rm(c3827rm.a, Predicates.and(c3827rm.b, predicate));
    }

    public static <K, V> Multimap<K, V> filterValues(Multimap<K, V> multimap, Predicate<? super V> predicate) {
        return filterEntries(multimap, Maps.valuePredicateOnEntries(predicate));
    }

    public static <K, V> SetMultimap<K, V> forMap(Map<K, V> map) {
        return new h(map);
    }

    public static <K, V> ImmutableListMultimap<K, V> index(Iterable<V> iterable, Function<? super V, K> function) {
        return index(iterable.iterator(), function);
    }

    @CanIgnoreReturnValue
    public static <K, V, M extends Multimap<K, V>> M invertFrom(Multimap<? extends V, ? extends K> multimap, M m2) {
        Preconditions.checkNotNull(m2);
        for (Map.Entry<? extends V, ? extends K> entry : multimap.entries()) {
            m2.put(entry.getValue(), entry.getKey());
        }
        return m2;
    }

    public static <K, V> ListMultimap<K, V> newListMultimap(Map<K, Collection<V>> map, Supplier<? extends List<V>> supplier) {
        return new b(map, supplier);
    }

    public static <K, V> Multimap<K, V> newMultimap(Map<K, Collection<V>> map, Supplier<? extends Collection<V>> supplier) {
        return new c(map, supplier);
    }

    public static <K, V> SetMultimap<K, V> newSetMultimap(Map<K, Collection<V>> map, Supplier<? extends Set<V>> supplier) {
        return new d(map, supplier);
    }

    public static <K, V> SortedSetMultimap<K, V> newSortedSetMultimap(Map<K, Collection<V>> map, Supplier<? extends SortedSet<V>> supplier) {
        return new e(map, supplier);
    }

    public static <K, V> ListMultimap<K, V> synchronizedListMultimap(ListMultimap<K, V> listMultimap) {
        return N.k(listMultimap, null);
    }

    public static <K, V> Multimap<K, V> synchronizedMultimap(Multimap<K, V> multimap) {
        return N.m(multimap, null);
    }

    public static <K, V> SetMultimap<K, V> synchronizedSetMultimap(SetMultimap<K, V> setMultimap) {
        return N.v(setMultimap, null);
    }

    public static <K, V> SortedSetMultimap<K, V> synchronizedSortedSetMultimap(SortedSetMultimap<K, V> sortedSetMultimap) {
        return N.x(sortedSetMultimap, null);
    }

    public static <K, V1, V2> Multimap<K, V2> transformEntries(Multimap<K, V1> multimap, Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return new j(multimap, entryTransformer);
    }

    public static <K, V1, V2> Multimap<K, V2> transformValues(Multimap<K, V1> multimap, Function<? super V1, V2> function) {
        Preconditions.checkNotNull(function);
        return transformEntries(multimap, Maps.asEntryTransformer(function));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> Collection<Map.Entry<K, V>> unmodifiableEntries(Collection<Map.Entry<K, V>> collection) {
        return collection instanceof Set ? Maps.unmodifiableEntrySet((Set) collection) : new Maps.L(Collections.unmodifiableCollection(collection));
    }

    public static <K, V> ListMultimap<K, V> unmodifiableListMultimap(ListMultimap<K, V> listMultimap) {
        return ((listMultimap instanceof k) || (listMultimap instanceof ImmutableListMultimap)) ? listMultimap : new k(listMultimap);
    }

    public static <K, V> Multimap<K, V> unmodifiableMultimap(Multimap<K, V> multimap) {
        return ((multimap instanceof l) || (multimap instanceof ImmutableMultimap)) ? multimap : new l(multimap);
    }

    public static <K, V> SetMultimap<K, V> unmodifiableSetMultimap(SetMultimap<K, V> setMultimap) {
        return ((setMultimap instanceof m) || (setMultimap instanceof ImmutableSetMultimap)) ? setMultimap : new m(setMultimap);
    }

    public static <K, V> SortedSetMultimap<K, V> unmodifiableSortedSetMultimap(SortedSetMultimap<K, V> sortedSetMultimap) {
        return sortedSetMultimap instanceof n ? sortedSetMultimap : new n(sortedSetMultimap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <V> Collection<V> unmodifiableValueCollection(Collection<V> collection) {
        if (collection instanceof SortedSet) {
            return Collections.unmodifiableSortedSet((SortedSet) collection);
        }
        if (collection instanceof Set) {
            return Collections.unmodifiableSet((Set) collection);
        }
        return collection instanceof List ? Collections.unmodifiableList((List) collection) : Collections.unmodifiableCollection(collection);
    }

    public static class n extends m implements SortedSetMultimap {
        public n(SortedSetMultimap sortedSetMultimap) {
            super(sortedSetMultimap);
        }

        @Override // com.google.common.collect.SortedSetMultimap
        public Comparator valueComparator() {
            return delegate().valueComparator();
        }

        @Override // com.google.common.collect.Multimaps.m, com.google.common.collect.Multimaps.l, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public SortedSet get(Object obj) {
            return Collections.unmodifiableSortedSet(delegate().get(obj));
        }

        @Override // com.google.common.collect.Multimaps.m, com.google.common.collect.Multimaps.l, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public SortedSet removeAll(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.m, com.google.common.collect.Multimaps.l, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public SortedSet replaceValues(Object obj, Iterable iterable) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.m, com.google.common.collect.Multimaps.l, com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
        public SortedSetMultimap delegate() {
            return (SortedSetMultimap) super.delegate();
        }
    }

    @Beta
    public static <K, V> Map<K, Set<V>> asMap(SetMultimap<K, V> setMultimap) {
        return setMultimap.asMap();
    }

    public static <K, V> SetMultimap<K, V> filterValues(SetMultimap<K, V> setMultimap, Predicate<? super V> predicate) {
        return filterEntries((SetMultimap) setMultimap, Maps.valuePredicateOnEntries(predicate));
    }

    public static <K, V> ImmutableListMultimap<K, V> index(Iterator<V> it, Function<? super V, K> function) {
        Preconditions.checkNotNull(function);
        ImmutableListMultimap.Builder builder = ImmutableListMultimap.builder();
        while (it.hasNext()) {
            V next = it.next();
            Preconditions.checkNotNull(next, it);
            builder.put((Object) function.apply(next), (Object) next);
        }
        return builder.build();
    }

    public static <K, V1, V2> ListMultimap<K, V2> transformEntries(ListMultimap<K, V1> listMultimap, Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return new i(listMultimap, entryTransformer);
    }

    @Beta
    public static <K, V> Map<K, SortedSet<V>> asMap(SortedSetMultimap<K, V> sortedSetMultimap) {
        return sortedSetMultimap.asMap();
    }

    private static <K, V> SetMultimap<K, V> filterFiltered(InterfaceC4151vm interfaceC4151vm, Predicate<? super Map.Entry<K, V>> predicate) {
        return new C3666pm(interfaceC4151vm.a(), Predicates.and(interfaceC4151vm.b(), predicate));
    }

    @Deprecated
    public static <K, V> ListMultimap<K, V> unmodifiableListMultimap(ImmutableListMultimap<K, V> immutableListMultimap) {
        return (ListMultimap) Preconditions.checkNotNull(immutableListMultimap);
    }

    @Deprecated
    public static <K, V> Multimap<K, V> unmodifiableMultimap(ImmutableMultimap<K, V> immutableMultimap) {
        return (Multimap) Preconditions.checkNotNull(immutableMultimap);
    }

    @Deprecated
    public static <K, V> SetMultimap<K, V> unmodifiableSetMultimap(ImmutableSetMultimap<K, V> immutableSetMultimap) {
        return (SetMultimap) Preconditions.checkNotNull(immutableSetMultimap);
    }

    @Beta
    public static <K, V> Map<K, Collection<V>> asMap(Multimap<K, V> multimap) {
        return multimap.asMap();
    }

    public static <K, V1, V2> ListMultimap<K, V2> transformValues(ListMultimap<K, V1> listMultimap, Function<? super V1, V2> function) {
        Preconditions.checkNotNull(function);
        return transformEntries((ListMultimap) listMultimap, Maps.asEntryTransformer(function));
    }

    public static <K, V> SetMultimap<K, V> filterEntries(SetMultimap<K, V> setMultimap, Predicate<? super Map.Entry<K, V>> predicate) {
        Preconditions.checkNotNull(predicate);
        if (setMultimap instanceof InterfaceC4151vm) {
            return filterFiltered((InterfaceC4151vm) setMultimap, (Predicate) predicate);
        }
        return new C3666pm((SetMultimap) Preconditions.checkNotNull(setMultimap), predicate);
    }

    public static <K, V> SetMultimap<K, V> filterKeys(SetMultimap<K, V> setMultimap, Predicate<? super K> predicate) {
        if (setMultimap instanceof C3908sm) {
            C3908sm c3908sm = (C3908sm) setMultimap;
            return new C3908sm(c3908sm.a(), Predicates.and(c3908sm.b, predicate));
        }
        if (setMultimap instanceof InterfaceC4151vm) {
            return filterFiltered((InterfaceC4151vm) setMultimap, Maps.keyPredicateOnEntries(predicate));
        }
        return new C3908sm(setMultimap, predicate);
    }

    public static <K, V> ListMultimap<K, V> filterKeys(ListMultimap<K, V> listMultimap, Predicate<? super K> predicate) {
        if (listMultimap instanceof C3747qm) {
            C3747qm c3747qm = (C3747qm) listMultimap;
            return new C3747qm(c3747qm.a(), Predicates.and(c3747qm.b, predicate));
        }
        return new C3747qm(listMultimap, predicate);
    }
}
