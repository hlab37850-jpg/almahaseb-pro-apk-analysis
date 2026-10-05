package com.google.common.collect;

import com.google.common.base.Preconditions;
import defpackage.WD;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: renamed from: com.google.common.collect.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1952b extends AbstractC1954d implements Serializable {
    private static final long serialVersionUID = 2447537837011683357L;
    private transient Map<Object, Collection<Object>> map;
    private transient int totalSize;

    /* JADX INFO: renamed from: com.google.common.collect.b$a */
    public class a extends d {
        public a(AbstractC1952b abstractC1952b) {
            super();
        }

        @Override // com.google.common.collect.AbstractC1952b.d
        public Object a(Object obj, Object obj2) {
            return obj2;
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.b$b, reason: collision with other inner class name */
    public class C0238b extends d {
        public C0238b(AbstractC1952b abstractC1952b) {
            super();
        }

        @Override // com.google.common.collect.AbstractC1952b.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry a(Object obj, Object obj2) {
            return Maps.immutableEntry(obj, obj2);
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.b$c */
    public class c extends Maps.Q {
        public final transient Map d;

        /* JADX INFO: renamed from: com.google.common.collect.b$c$a */
        public class a extends Maps.s {
            public a() {
            }

            @Override // com.google.common.collect.Maps.s, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return Collections2.safeContains(c.this.d.entrySet(), obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator iterator() {
                return c.this.new C0239b();
            }

            @Override // com.google.common.collect.Maps.s
            public Map map() {
                return c.this;
            }

            @Override // com.google.common.collect.Maps.s, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Objects.requireNonNull(entry);
                AbstractC1952b.this.f(entry.getKey());
                return true;
            }
        }

        /* JADX INFO: renamed from: com.google.common.collect.b$c$b, reason: collision with other inner class name */
        public class C0239b implements Iterator {
            public final Iterator a;
            public Collection b;

            public C0239b() {
                this.a = c.this.d.entrySet().iterator();
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry next() {
                Map.Entry entry = (Map.Entry) this.a.next();
                this.b = (Collection) entry.getValue();
                return c.this.f(entry);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.a.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                Preconditions.checkState(this.b != null, "no calls to next() since the last call to remove()");
                this.a.remove();
                AbstractC1952b.access$220(AbstractC1952b.this, this.b.size());
                this.b.clear();
                this.b = null;
            }
        }

        public c(Map map) {
            this.d = map;
        }

        @Override // com.google.common.collect.Maps.Q
        public Set a() {
            return new a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            if (this.d == AbstractC1952b.this.map) {
                AbstractC1952b.this.clear();
            } else {
                Iterators.clear(new C0239b());
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return Maps.safeContainsKey(this.d, obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Collection get(Object obj) {
            Collection collection = (Collection) Maps.safeGet(this.d, obj);
            if (collection == null) {
                return null;
            }
            return AbstractC1952b.this.wrapCollection(obj, collection);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Collection remove(Object obj) {
            Collection collection = (Collection) this.d.remove(obj);
            if (collection == null) {
                return null;
            }
            Collection collectionCreateCollection = AbstractC1952b.this.createCollection();
            collectionCreateCollection.addAll(collection);
            AbstractC1952b.access$220(AbstractC1952b.this, collection.size());
            collection.clear();
            return collectionCreateCollection;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean equals(Object obj) {
            return this == obj || this.d.equals(obj);
        }

        public Map.Entry f(Map.Entry entry) {
            Object key = entry.getKey();
            return Maps.immutableEntry(key, AbstractC1952b.this.wrapCollection(key, (Collection) entry.getValue()));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            return this.d.hashCode();
        }

        @Override // com.google.common.collect.Maps.Q, java.util.AbstractMap, java.util.Map, java.util.SortedMap
        public Set keySet() {
            return AbstractC1952b.this.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.d.size();
        }

        @Override // java.util.AbstractMap
        public String toString() {
            return this.d.toString();
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.b$d */
    public abstract class d implements Iterator {
        public final Iterator a;
        public Object b = null;
        public Collection c = null;
        public Iterator d = Iterators.emptyModifiableIterator();

        public d() {
            this.a = AbstractC1952b.this.map.entrySet().iterator();
        }

        public abstract Object a(Object obj, Object obj2);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext() || this.d.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!this.d.hasNext()) {
                Map.Entry entry = (Map.Entry) this.a.next();
                this.b = entry.getKey();
                Collection collection = (Collection) entry.getValue();
                this.c = collection;
                this.d = collection.iterator();
            }
            return a(WD.a(this.b), this.d.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            this.d.remove();
            Collection collection = this.c;
            Objects.requireNonNull(collection);
            if (collection.isEmpty()) {
                this.a.remove();
            }
            AbstractC1952b.access$210(AbstractC1952b.this);
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.b$e */
    public class e extends Maps.A {

        /* JADX INFO: renamed from: com.google.common.collect.b$e$a */
        public class a implements Iterator {
            public Map.Entry a;
            public final /* synthetic */ Iterator b;

            public a(Iterator it) {
                this.b = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.b.hasNext();
            }

            @Override // java.util.Iterator
            public Object next() {
                Map.Entry entry = (Map.Entry) this.b.next();
                this.a = entry;
                return entry.getKey();
            }

            @Override // java.util.Iterator
            public void remove() {
                Preconditions.checkState(this.a != null, "no calls to next() since the last call to remove()");
                Collection collection = (Collection) this.a.getValue();
                this.b.remove();
                AbstractC1952b.access$220(AbstractC1952b.this, collection.size());
                collection.clear();
                this.a = null;
            }
        }

        public e(Map map) {
            super(map);
        }

        @Override // com.google.common.collect.Maps.A, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Iterators.clear(iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection collection) {
            return map().keySet().containsAll(collection);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return this == obj || map().keySet().equals(obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return map().keySet().hashCode();
        }

        @Override // com.google.common.collect.Maps.A, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new a(map().entrySet().iterator());
        }

        @Override // com.google.common.collect.Maps.A, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int size;
            Collection collection = (Collection) map().remove(obj);
            if (collection != null) {
                size = collection.size();
                collection.clear();
                AbstractC1952b.access$220(AbstractC1952b.this, size);
            } else {
                size = 0;
            }
            return size > 0;
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.b$f */
    public class f extends i implements NavigableMap {
        public f(NavigableMap navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableMap
        public Map.Entry ceilingEntry(Object obj) {
            Map.Entry entryCeilingEntry = j().ceilingEntry(obj);
            if (entryCeilingEntry == null) {
                return null;
            }
            return f(entryCeilingEntry);
        }

        @Override // java.util.NavigableMap
        public Object ceilingKey(Object obj) {
            return j().ceilingKey(obj);
        }

        @Override // java.util.NavigableMap
        public NavigableSet descendingKeySet() {
            return descendingMap().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap descendingMap() {
            return AbstractC1952b.this.new f(j().descendingMap());
        }

        @Override // java.util.NavigableMap
        public Map.Entry firstEntry() {
            Map.Entry entryFirstEntry = j().firstEntry();
            if (entryFirstEntry == null) {
                return null;
            }
            return f(entryFirstEntry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry floorEntry(Object obj) {
            Map.Entry entryFloorEntry = j().floorEntry(obj);
            if (entryFloorEntry == null) {
                return null;
            }
            return f(entryFloorEntry);
        }

        @Override // java.util.NavigableMap
        public Object floorKey(Object obj) {
            return j().floorKey(obj);
        }

        @Override // java.util.NavigableMap
        public Map.Entry higherEntry(Object obj) {
            Map.Entry entryHigherEntry = j().higherEntry(obj);
            if (entryHigherEntry == null) {
                return null;
            }
            return f(entryHigherEntry);
        }

        @Override // java.util.NavigableMap
        public Object higherKey(Object obj) {
            return j().higherKey(obj);
        }

        @Override // com.google.common.collect.AbstractC1952b.i
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public NavigableSet g() {
            return AbstractC1952b.this.new g(j());
        }

        @Override // com.google.common.collect.AbstractC1952b.i, java.util.SortedMap, java.util.NavigableMap
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public NavigableMap headMap(Object obj) {
            return headMap(obj, false);
        }

        @Override // java.util.NavigableMap
        public Map.Entry lastEntry() {
            Map.Entry entryLastEntry = j().lastEntry();
            if (entryLastEntry == null) {
                return null;
            }
            return f(entryLastEntry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry lowerEntry(Object obj) {
            Map.Entry entryLowerEntry = j().lowerEntry(obj);
            if (entryLowerEntry == null) {
                return null;
            }
            return f(entryLowerEntry);
        }

        @Override // java.util.NavigableMap
        public Object lowerKey(Object obj) {
            return j().lowerKey(obj);
        }

        @Override // com.google.common.collect.AbstractC1952b.i, com.google.common.collect.AbstractC1952b.c, com.google.common.collect.Maps.Q, java.util.AbstractMap, java.util.Map, java.util.SortedMap
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public NavigableSet keySet() {
            return (NavigableSet) super.keySet();
        }

        public Map.Entry n(Iterator it) {
            if (!it.hasNext()) {
                return null;
            }
            Map.Entry entry = (Map.Entry) it.next();
            Collection collectionCreateCollection = AbstractC1952b.this.createCollection();
            collectionCreateCollection.addAll((Collection) entry.getValue());
            it.remove();
            return Maps.immutableEntry(entry.getKey(), AbstractC1952b.this.unmodifiableCollectionSubclass(collectionCreateCollection));
        }

        @Override // java.util.NavigableMap
        public NavigableSet navigableKeySet() {
            return h();
        }

        @Override // com.google.common.collect.AbstractC1952b.i
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public NavigableMap j() {
            return (NavigableMap) super.j();
        }

        @Override // com.google.common.collect.AbstractC1952b.i, java.util.SortedMap, java.util.NavigableMap
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public NavigableMap subMap(Object obj, Object obj2) {
            return subMap(obj, true, obj2, false);
        }

        @Override // java.util.NavigableMap
        public Map.Entry pollFirstEntry() {
            return n(entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        public Map.Entry pollLastEntry() {
            return n(descendingMap().entrySet().iterator());
        }

        @Override // com.google.common.collect.AbstractC1952b.i, java.util.SortedMap, java.util.NavigableMap
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public NavigableMap tailMap(Object obj) {
            return tailMap(obj, true);
        }

        @Override // java.util.NavigableMap
        public NavigableMap headMap(Object obj, boolean z) {
            return AbstractC1952b.this.new f(j().headMap(obj, z));
        }

        @Override // java.util.NavigableMap
        public NavigableMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
            return AbstractC1952b.this.new f(j().subMap(obj, z, obj2, z2));
        }

        @Override // java.util.NavigableMap
        public NavigableMap tailMap(Object obj, boolean z) {
            return AbstractC1952b.this.new f(j().tailMap(obj, z));
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.b$g */
    public class g extends j implements NavigableSet {
        public g(NavigableMap navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableSet
        public Object ceiling(Object obj) {
            return d().ceilingKey(obj);
        }

        @Override // java.util.NavigableSet
        public Iterator descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet descendingSet() {
            return AbstractC1952b.this.new g(d().descendingMap());
        }

        @Override // com.google.common.collect.AbstractC1952b.j, java.util.SortedSet, java.util.NavigableSet
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public NavigableSet headSet(Object obj) {
            return headSet(obj, false);
        }

        @Override // java.util.NavigableSet
        public Object floor(Object obj) {
            return d().floorKey(obj);
        }

        @Override // com.google.common.collect.AbstractC1952b.j
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public NavigableMap d() {
            return (NavigableMap) super.d();
        }

        @Override // com.google.common.collect.AbstractC1952b.j, java.util.SortedSet, java.util.NavigableSet
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public NavigableSet subSet(Object obj, Object obj2) {
            return subSet(obj, true, obj2, false);
        }

        @Override // java.util.NavigableSet
        public Object higher(Object obj) {
            return d().higherKey(obj);
        }

        @Override // com.google.common.collect.AbstractC1952b.j, java.util.SortedSet, java.util.NavigableSet
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public NavigableSet tailSet(Object obj) {
            return tailSet(obj, true);
        }

        @Override // java.util.NavigableSet
        public Object lower(Object obj) {
            return d().lowerKey(obj);
        }

        @Override // java.util.NavigableSet
        public Object pollFirst() {
            return Iterators.pollNext(iterator());
        }

        @Override // java.util.NavigableSet
        public Object pollLast() {
            return Iterators.pollNext(descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet headSet(Object obj, boolean z) {
            return AbstractC1952b.this.new g(d().headMap(obj, z));
        }

        @Override // java.util.NavigableSet
        public NavigableSet subSet(Object obj, boolean z, Object obj2, boolean z2) {
            return AbstractC1952b.this.new g(d().subMap(obj, z, obj2, z2));
        }

        @Override // java.util.NavigableSet
        public NavigableSet tailSet(Object obj, boolean z) {
            return AbstractC1952b.this.new g(d().tailMap(obj, z));
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.b$h */
    public class h extends l implements RandomAccess {
        public h(AbstractC1952b abstractC1952b, Object obj, List list, k kVar) {
            super(obj, list, kVar);
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.b$i */
    public class i extends c implements SortedMap {
        public SortedSet f;

        public i(SortedMap sortedMap) {
            super(sortedMap);
        }

        @Override // java.util.SortedMap
        public Comparator comparator() {
            return j().comparator();
        }

        @Override // java.util.SortedMap
        public Object firstKey() {
            return j().firstKey();
        }

        @Override // com.google.common.collect.Maps.Q
        public SortedSet g() {
            return AbstractC1952b.this.new j(j());
        }

        @Override // com.google.common.collect.AbstractC1952b.c, com.google.common.collect.Maps.Q, java.util.AbstractMap, java.util.Map, java.util.SortedMap
        /* JADX INFO: renamed from: h */
        public SortedSet keySet() {
            SortedSet sortedSet = this.f;
            if (sortedSet != null) {
                return sortedSet;
            }
            SortedSet sortedSetG = g();
            this.f = sortedSetG;
            return sortedSetG;
        }

        public SortedMap headMap(Object obj) {
            return AbstractC1952b.this.new i(j().headMap(obj));
        }

        public SortedMap j() {
            return (SortedMap) this.d;
        }

        @Override // java.util.SortedMap
        public Object lastKey() {
            return j().lastKey();
        }

        public SortedMap subMap(Object obj, Object obj2) {
            return AbstractC1952b.this.new i(j().subMap(obj, obj2));
        }

        public SortedMap tailMap(Object obj) {
            return AbstractC1952b.this.new i(j().tailMap(obj));
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.b$j */
    public class j extends e implements SortedSet {
        public j(SortedMap sortedMap) {
            super(sortedMap);
        }

        @Override // java.util.SortedSet
        public Comparator comparator() {
            return d().comparator();
        }

        public SortedMap d() {
            return (SortedMap) super.map();
        }

        @Override // java.util.SortedSet
        public Object first() {
            return d().firstKey();
        }

        public SortedSet headSet(Object obj) {
            return AbstractC1952b.this.new j(d().headMap(obj));
        }

        @Override // java.util.SortedSet
        public Object last() {
            return d().lastKey();
        }

        public SortedSet subSet(Object obj, Object obj2) {
            return AbstractC1952b.this.new j(d().subMap(obj, obj2));
        }

        public SortedSet tailSet(Object obj) {
            return AbstractC1952b.this.new j(d().tailMap(obj));
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.b$m */
    public class m extends o implements NavigableSet {
        public m(Object obj, NavigableSet navigableSet, k kVar) {
            super(obj, navigableSet, kVar);
        }

        @Override // java.util.NavigableSet
        public Object ceiling(Object obj) {
            return g().ceiling(obj);
        }

        @Override // java.util.NavigableSet
        public Iterator descendingIterator() {
            return new k.a(g().descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet descendingSet() {
            return i(g().descendingSet());
        }

        @Override // java.util.NavigableSet
        public Object floor(Object obj) {
            return g().floor(obj);
        }

        @Override // com.google.common.collect.AbstractC1952b.o
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public NavigableSet g() {
            return (NavigableSet) super.g();
        }

        @Override // java.util.NavigableSet
        public NavigableSet headSet(Object obj, boolean z) {
            return i(g().headSet(obj, z));
        }

        @Override // java.util.NavigableSet
        public Object higher(Object obj) {
            return g().higher(obj);
        }

        public final NavigableSet i(NavigableSet navigableSet) {
            return AbstractC1952b.this.new m(this.a, navigableSet, b() == null ? this : b());
        }

        @Override // java.util.NavigableSet
        public Object lower(Object obj) {
            return g().lower(obj);
        }

        @Override // java.util.NavigableSet
        public Object pollFirst() {
            return Iterators.pollNext(iterator());
        }

        @Override // java.util.NavigableSet
        public Object pollLast() {
            return Iterators.pollNext(descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet subSet(Object obj, boolean z, Object obj2, boolean z2) {
            return i(g().subSet(obj, z, obj2, z2));
        }

        @Override // java.util.NavigableSet
        public NavigableSet tailSet(Object obj, boolean z) {
            return i(g().tailSet(obj, z));
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.b$n */
    public class n extends k implements Set {
        public n(Object obj, Set set) {
            super(obj, set, null);
        }

        @Override // com.google.common.collect.AbstractC1952b.k, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zRemoveAllImpl = Sets.removeAllImpl((Set<?>) this.b, (Collection<?>) collection);
            if (zRemoveAllImpl) {
                AbstractC1952b.access$212(AbstractC1952b.this, this.b.size() - size);
                f();
            }
            return zRemoveAllImpl;
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.b$o */
    public class o extends k implements SortedSet {
        public o(Object obj, SortedSet sortedSet, k kVar) {
            super(obj, sortedSet, kVar);
        }

        @Override // java.util.SortedSet
        public Comparator comparator() {
            return g().comparator();
        }

        @Override // java.util.SortedSet
        public Object first() {
            e();
            return g().first();
        }

        public SortedSet g() {
            return (SortedSet) c();
        }

        @Override // java.util.SortedSet
        public SortedSet headSet(Object obj) {
            e();
            return AbstractC1952b.this.new o(d(), g().headSet(obj), b() == null ? this : b());
        }

        @Override // java.util.SortedSet
        public Object last() {
            e();
            return g().last();
        }

        @Override // java.util.SortedSet
        public SortedSet subSet(Object obj, Object obj2) {
            e();
            return AbstractC1952b.this.new o(d(), g().subSet(obj, obj2), b() == null ? this : b());
        }

        @Override // java.util.SortedSet
        public SortedSet tailSet(Object obj) {
            e();
            return AbstractC1952b.this.new o(d(), g().tailSet(obj), b() == null ? this : b());
        }
    }

    public AbstractC1952b(Map map) {
        Preconditions.checkArgument(map.isEmpty());
        this.map = map;
    }

    public static /* synthetic */ int access$208(AbstractC1952b abstractC1952b) {
        int i2 = abstractC1952b.totalSize;
        abstractC1952b.totalSize = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int access$210(AbstractC1952b abstractC1952b) {
        int i2 = abstractC1952b.totalSize;
        abstractC1952b.totalSize = i2 - 1;
        return i2;
    }

    public static /* synthetic */ int access$212(AbstractC1952b abstractC1952b, int i2) {
        int i3 = abstractC1952b.totalSize + i2;
        abstractC1952b.totalSize = i3;
        return i3;
    }

    public static /* synthetic */ int access$220(AbstractC1952b abstractC1952b, int i2) {
        int i3 = abstractC1952b.totalSize - i2;
        abstractC1952b.totalSize = i3;
        return i3;
    }

    public static Iterator e(Collection collection) {
        return collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Object obj) {
        Collection collection = (Collection) Maps.safeRemove(this.map, obj);
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            this.totalSize -= size;
        }
    }

    public Map<Object, Collection<Object>> backingMap() {
        return this.map;
    }

    public final Collection c(Object obj) {
        Collection<Object> collection = this.map.get(obj);
        if (collection != null) {
            return collection;
        }
        Collection<Object> collectionCreateCollection = createCollection(obj);
        this.map.put(obj, collectionCreateCollection);
        return collectionCreateCollection;
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        Iterator<Collection<Object>> it = this.map.values().iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        this.map.clear();
        this.totalSize = 0;
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // com.google.common.collect.AbstractC1954d
    public Map<Object, Collection<Object>> createAsMap() {
        return new c(this.map);
    }

    public abstract Collection createCollection();

    public Collection<Object> createCollection(Object obj) {
        return createCollection();
    }

    @Override // com.google.common.collect.AbstractC1954d
    public Collection<Map.Entry<Object, Object>> createEntries() {
        return this instanceof SetMultimap ? new AbstractC1954d.b(this) : new AbstractC1954d.a();
    }

    @Override // com.google.common.collect.AbstractC1954d
    public Set<Object> createKeySet() {
        return new e(this.map);
    }

    @Override // com.google.common.collect.AbstractC1954d
    public Multiset<Object> createKeys() {
        return new Multimaps.g(this);
    }

    public final Map<Object, Collection<Object>> createMaybeNavigableAsMap() {
        Map<Object, Collection<Object>> map = this.map;
        if (map instanceof NavigableMap) {
            return new f((NavigableMap) this.map);
        }
        return map instanceof SortedMap ? new i((SortedMap) this.map) : new c(this.map);
    }

    public final Set<Object> createMaybeNavigableKeySet() {
        Map<Object, Collection<Object>> map = this.map;
        if (map instanceof NavigableMap) {
            return new g((NavigableMap) this.map);
        }
        return map instanceof SortedMap ? new j((SortedMap) this.map) : new e(this.map);
    }

    public Collection createUnmodifiableEmptyCollection() {
        return unmodifiableCollectionSubclass(createCollection());
    }

    @Override // com.google.common.collect.AbstractC1954d
    public Collection<Object> createValues() {
        return new AbstractC1954d.c();
    }

    @Override // com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap
    public Collection entries() {
        return super.entries();
    }

    @Override // com.google.common.collect.AbstractC1954d
    public Iterator<Map.Entry<Object, Object>> entryIterator() {
        return new C0238b(this);
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Collection get(Object obj) {
        Collection<Object> collectionCreateCollection = this.map.get(obj);
        if (collectionCreateCollection == null) {
            collectionCreateCollection = createCollection(obj);
        }
        return wrapCollection(obj, collectionCreateCollection);
    }

    @Override // com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap
    public boolean put(Object obj, Object obj2) {
        Collection<Object> collection = this.map.get(obj);
        if (collection != null) {
            if (!collection.add(obj2)) {
                return false;
            }
            this.totalSize++;
            return true;
        }
        Collection<Object> collectionCreateCollection = createCollection(obj);
        if (!collectionCreateCollection.add(obj2)) {
            throw new AssertionError("New Collection violated the Collection spec");
        }
        this.totalSize++;
        this.map.put(obj, collectionCreateCollection);
        return true;
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Collection removeAll(Object obj) {
        Collection<Object> collectionRemove = this.map.remove(obj);
        if (collectionRemove == null) {
            return createUnmodifiableEmptyCollection();
        }
        Collection collectionCreateCollection = createCollection();
        collectionCreateCollection.addAll(collectionRemove);
        this.totalSize -= collectionRemove.size();
        collectionRemove.clear();
        return unmodifiableCollectionSubclass(collectionCreateCollection);
    }

    @Override // com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Collection replaceValues(Object obj, Iterable iterable) {
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return removeAll(obj);
        }
        Collection collectionC = c(obj);
        Collection collectionCreateCollection = createCollection();
        collectionCreateCollection.addAll(collectionC);
        this.totalSize -= collectionC.size();
        collectionC.clear();
        while (it.hasNext()) {
            if (collectionC.add(it.next())) {
                this.totalSize++;
            }
        }
        return unmodifiableCollectionSubclass(collectionCreateCollection);
    }

    public final void setMap(Map<Object, Collection<Object>> map) {
        this.map = map;
        this.totalSize = 0;
        for (Collection<Object> collection : map.values()) {
            Preconditions.checkArgument(!collection.isEmpty());
            this.totalSize += collection.size();
        }
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        return this.totalSize;
    }

    public abstract Collection unmodifiableCollectionSubclass(Collection collection);

    @Override // com.google.common.collect.AbstractC1954d
    public Iterator<Object> valueIterator() {
        return new a(this);
    }

    @Override // com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap
    public Collection values() {
        return super.values();
    }

    public abstract Collection wrapCollection(Object obj, Collection collection);

    public final List<Object> wrapList(Object obj, List<Object> list, com.google.common.collect.b.k kVar) {
        return list instanceof RandomAccess ? new h(this, obj, list, kVar) : new l(obj, list, kVar);
    }

    /* JADX INFO: renamed from: com.google.common.collect.b$k */
    public class k extends AbstractCollection {
        public final Object a;
        public Collection b;
        public final k c;
        public final Collection d;

        public k(Object obj, Collection collection, k kVar) {
            this.a = obj;
            this.b = collection;
            this.c = kVar;
            this.d = kVar == null ? null : kVar.c();
        }

        public void a() {
            k kVar = this.c;
            if (kVar != null) {
                kVar.a();
            } else {
                AbstractC1952b.this.map.put(this.a, this.b);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(Object obj) {
            e();
            boolean zIsEmpty = this.b.isEmpty();
            boolean zAdd = this.b.add(obj);
            if (zAdd) {
                AbstractC1952b.access$208(AbstractC1952b.this);
                if (zIsEmpty) {
                    a();
                }
            }
            return zAdd;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zAddAll = this.b.addAll(collection);
            if (zAddAll) {
                AbstractC1952b.access$212(AbstractC1952b.this, this.b.size() - size);
                if (size == 0) {
                    a();
                }
            }
            return zAddAll;
        }

        public k b() {
            return this.c;
        }

        public Collection c() {
            return this.b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            int size = size();
            if (size == 0) {
                return;
            }
            this.b.clear();
            AbstractC1952b.access$220(AbstractC1952b.this, size);
            f();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            e();
            return this.b.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection collection) {
            e();
            return this.b.containsAll(collection);
        }

        public Object d() {
            return this.a;
        }

        public void e() {
            Collection collection;
            k kVar = this.c;
            if (kVar != null) {
                kVar.e();
                if (this.c.c() != this.d) {
                    throw new ConcurrentModificationException();
                }
            } else {
                if (!this.b.isEmpty() || (collection = (Collection) AbstractC1952b.this.map.get(this.a)) == null) {
                    return;
                }
                this.b = collection;
            }
        }

        @Override // java.util.Collection
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            e();
            return this.b.equals(obj);
        }

        public void f() {
            k kVar = this.c;
            if (kVar != null) {
                kVar.f();
            } else if (this.b.isEmpty()) {
                AbstractC1952b.this.map.remove(this.a);
            }
        }

        @Override // java.util.Collection
        public int hashCode() {
            e();
            return this.b.hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            e();
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            e();
            boolean zRemove = this.b.remove(obj);
            if (zRemove) {
                AbstractC1952b.access$210(AbstractC1952b.this);
                f();
            }
            return zRemove;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zRemoveAll = this.b.removeAll(collection);
            if (zRemoveAll) {
                AbstractC1952b.access$212(AbstractC1952b.this, this.b.size() - size);
                f();
            }
            return zRemoveAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection collection) {
            Preconditions.checkNotNull(collection);
            int size = size();
            boolean zRetainAll = this.b.retainAll(collection);
            if (zRetainAll) {
                AbstractC1952b.access$212(AbstractC1952b.this, this.b.size() - size);
                f();
            }
            return zRetainAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            e();
            return this.b.size();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            e();
            return this.b.toString();
        }

        /* JADX INFO: renamed from: com.google.common.collect.b$k$a */
        public class a implements Iterator {
            public final Iterator a;
            public final Collection b;

            public a() {
                Collection collection = k.this.b;
                this.b = collection;
                this.a = AbstractC1952b.e(collection);
            }

            public Iterator a() {
                b();
                return this.a;
            }

            public void b() {
                k.this.e();
                if (k.this.b != this.b) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                b();
                return this.a.hasNext();
            }

            @Override // java.util.Iterator
            public Object next() {
                b();
                return this.a.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.a.remove();
                AbstractC1952b.access$210(AbstractC1952b.this);
                k.this.f();
            }

            public a(Iterator it) {
                this.b = k.this.b;
                this.a = it;
            }
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.b$l */
    public class l extends k implements List {

        /* JADX INFO: renamed from: com.google.common.collect.b$l$a */
        public class a extends k.a implements ListIterator {
            public a() {
                super();
            }

            @Override // java.util.ListIterator
            public void add(Object obj) {
                boolean zIsEmpty = l.this.isEmpty();
                c().add(obj);
                AbstractC1952b.access$208(AbstractC1952b.this);
                if (zIsEmpty) {
                    l.this.a();
                }
            }

            public final ListIterator c() {
                return (ListIterator) a();
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return c().hasPrevious();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return c().nextIndex();
            }

            @Override // java.util.ListIterator
            public Object previous() {
                return c().previous();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return c().previousIndex();
            }

            @Override // java.util.ListIterator
            public void set(Object obj) {
                c().set(obj);
            }

            public a(int i) {
                super(l.this.g().listIterator(i));
            }
        }

        public l(Object obj, List list, k kVar) {
            super(obj, list, kVar);
        }

        @Override // java.util.List
        public void add(int i, Object obj) {
            e();
            boolean zIsEmpty = c().isEmpty();
            g().add(i, obj);
            AbstractC1952b.access$208(AbstractC1952b.this);
            if (zIsEmpty) {
                a();
            }
        }

        @Override // java.util.List
        public boolean addAll(int i, Collection collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zAddAll = g().addAll(i, collection);
            if (zAddAll) {
                AbstractC1952b.access$212(AbstractC1952b.this, c().size() - size);
                if (size == 0) {
                    a();
                }
            }
            return zAddAll;
        }

        public List g() {
            return (List) c();
        }

        @Override // java.util.List
        public Object get(int i) {
            e();
            return g().get(i);
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            e();
            return g().indexOf(obj);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            e();
            return g().lastIndexOf(obj);
        }

        @Override // java.util.List
        public ListIterator listIterator() {
            e();
            return new a();
        }

        @Override // java.util.List
        public Object remove(int i) {
            e();
            Object objRemove = g().remove(i);
            AbstractC1952b.access$210(AbstractC1952b.this);
            f();
            return objRemove;
        }

        @Override // java.util.List
        public Object set(int i, Object obj) {
            e();
            return g().set(i, obj);
        }

        @Override // java.util.List
        public List subList(int i, int i2) {
            e();
            return AbstractC1952b.this.wrapList(d(), g().subList(i, i2), b() == null ? this : b());
        }

        @Override // java.util.List
        public ListIterator listIterator(int i) {
            e();
            return new a(i);
        }
    }
}
