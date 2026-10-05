package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import defpackage.AbstractC2362hV;
import defpackage.AbstractC3122j7;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes3.dex */
public abstract class N {

    public static class b extends k {
        public transient Set f;
        public transient Collection g;

        public b(Map map, Object obj) {
            super(map, obj);
        }

        @Override // com.google.common.collect.N.k, java.util.Map
        public boolean containsValue(Object obj) {
            return values().contains(obj);
        }

        @Override // com.google.common.collect.N.k, java.util.Map
        public Set entrySet() {
            Set set;
            synchronized (this.b) {
                try {
                    if (this.f == null) {
                        this.f = new c(f().entrySet(), this.b);
                    }
                    set = this.f;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return set;
        }

        @Override // com.google.common.collect.N.k, java.util.Map
        public Collection values() {
            Collection collection;
            synchronized (this.b) {
                try {
                    if (this.g == null) {
                        this.g = new d(f().values(), this.b);
                    }
                    collection = this.g;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return collection;
        }

        @Override // com.google.common.collect.N.k, java.util.Map
        public Collection get(Object obj) {
            Collection collectionZ;
            synchronized (this.b) {
                Collection collection = (Collection) super.get(obj);
                collectionZ = collection == null ? null : N.z(collection, this.b);
            }
            return collectionZ;
        }
    }

    public static class d extends f {

        public class a extends AbstractC2362hV {
            public a(Iterator it) {
                super(it);
            }

            @Override // defpackage.AbstractC2362hV
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Collection a(Collection collection) {
                return N.z(collection, d.this.b);
            }
        }

        public d(Collection collection, Object obj) {
            super(collection, obj);
        }

        @Override // com.google.common.collect.N.f, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new a(super.iterator());
        }
    }

    public static class e extends k implements BiMap, Serializable {
        public transient Set f;
        public transient BiMap g;

        @Override // com.google.common.collect.N.k
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public BiMap f() {
            return (BiMap) super.f();
        }

        @Override // com.google.common.collect.BiMap
        public Object forcePut(Object obj, Object obj2) {
            Object objForcePut;
            synchronized (this.b) {
                objForcePut = e().forcePut(obj, obj2);
            }
            return objForcePut;
        }

        @Override // com.google.common.collect.BiMap
        public BiMap inverse() {
            BiMap biMap;
            synchronized (this.b) {
                try {
                    if (this.g == null) {
                        this.g = new e(e().inverse(), this.b, this);
                    }
                    biMap = this.g;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return biMap;
        }

        public e(BiMap biMap, Object obj, BiMap biMap2) {
            super(biMap, obj);
            this.g = biMap2;
        }

        @Override // com.google.common.collect.N.k, java.util.Map
        public Set values() {
            Set set;
            synchronized (this.b) {
                try {
                    if (this.f == null) {
                        this.f = N.u(e().values(), this.b);
                    }
                    set = this.f;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return set;
        }
    }

    public static class f extends p implements Collection {
        @Override // java.util.Collection
        public boolean add(Object obj) {
            boolean zAdd;
            synchronized (this.b) {
                zAdd = f().add(obj);
            }
            return zAdd;
        }

        @Override // java.util.Collection
        public boolean addAll(Collection collection) {
            boolean zAddAll;
            synchronized (this.b) {
                zAddAll = f().addAll(collection);
            }
            return zAddAll;
        }

        @Override // java.util.Collection
        public void clear() {
            synchronized (this.b) {
                f().clear();
            }
        }

        public boolean contains(Object obj) {
            boolean zContains;
            synchronized (this.b) {
                zContains = f().contains(obj);
            }
            return zContains;
        }

        public boolean containsAll(Collection collection) {
            boolean zContainsAll;
            synchronized (this.b) {
                zContainsAll = f().containsAll(collection);
            }
            return zContainsAll;
        }

        /* JADX INFO: renamed from: e */
        public Collection f() {
            return (Collection) super.c();
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            boolean zIsEmpty;
            synchronized (this.b) {
                zIsEmpty = f().isEmpty();
            }
            return zIsEmpty;
        }

        public Iterator iterator() {
            return f().iterator();
        }

        public boolean remove(Object obj) {
            boolean zRemove;
            synchronized (this.b) {
                zRemove = f().remove(obj);
            }
            return zRemove;
        }

        public boolean removeAll(Collection collection) {
            boolean zRemoveAll;
            synchronized (this.b) {
                zRemoveAll = f().removeAll(collection);
            }
            return zRemoveAll;
        }

        public boolean retainAll(Collection collection) {
            boolean zRetainAll;
            synchronized (this.b) {
                zRetainAll = f().retainAll(collection);
            }
            return zRetainAll;
        }

        @Override // java.util.Collection
        public int size() {
            int size;
            synchronized (this.b) {
                size = f().size();
            }
            return size;
        }

        public Object[] toArray() {
            Object[] array;
            synchronized (this.b) {
                array = f().toArray();
            }
            return array;
        }

        public f(Collection collection, Object obj) {
            super(collection, obj);
        }

        public Object[] toArray(Object[] objArr) {
            Object[] array;
            synchronized (this.b) {
                array = f().toArray(objArr);
            }
            return array;
        }
    }

    public static final class g extends q implements Deque {
        public g(Deque deque, Object obj) {
            super(deque, obj);
        }

        @Override // java.util.Deque
        public void addFirst(Object obj) {
            synchronized (this.b) {
                e().addFirst(obj);
            }
        }

        @Override // java.util.Deque
        public void addLast(Object obj) {
            synchronized (this.b) {
                e().addLast(obj);
            }
        }

        @Override // java.util.Deque
        public Iterator descendingIterator() {
            Iterator itDescendingIterator;
            synchronized (this.b) {
                itDescendingIterator = e().descendingIterator();
            }
            return itDescendingIterator;
        }

        @Override // java.util.Deque
        public Object getFirst() {
            Object first;
            synchronized (this.b) {
                first = e().getFirst();
            }
            return first;
        }

        @Override // java.util.Deque
        public Object getLast() {
            Object last;
            synchronized (this.b) {
                last = e().getLast();
            }
            return last;
        }

        @Override // com.google.common.collect.N.q
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public Deque f() {
            return (Deque) super.f();
        }

        @Override // java.util.Deque
        public boolean offerFirst(Object obj) {
            boolean zOfferFirst;
            synchronized (this.b) {
                zOfferFirst = e().offerFirst(obj);
            }
            return zOfferFirst;
        }

        @Override // java.util.Deque
        public boolean offerLast(Object obj) {
            boolean zOfferLast;
            synchronized (this.b) {
                zOfferLast = e().offerLast(obj);
            }
            return zOfferLast;
        }

        @Override // java.util.Deque
        public Object peekFirst() {
            Object objPeekFirst;
            synchronized (this.b) {
                objPeekFirst = e().peekFirst();
            }
            return objPeekFirst;
        }

        @Override // java.util.Deque
        public Object peekLast() {
            Object objPeekLast;
            synchronized (this.b) {
                objPeekLast = e().peekLast();
            }
            return objPeekLast;
        }

        @Override // java.util.Deque
        public Object pollFirst() {
            Object objPollFirst;
            synchronized (this.b) {
                objPollFirst = e().pollFirst();
            }
            return objPollFirst;
        }

        @Override // java.util.Deque
        public Object pollLast() {
            Object objPollLast;
            synchronized (this.b) {
                objPollLast = e().pollLast();
            }
            return objPollLast;
        }

        @Override // java.util.Deque
        public Object pop() {
            Object objPop;
            synchronized (this.b) {
                objPop = e().pop();
            }
            return objPop;
        }

        @Override // java.util.Deque
        public void push(Object obj) {
            synchronized (this.b) {
                e().push(obj);
            }
        }

        @Override // java.util.Deque
        public Object removeFirst() {
            Object objRemoveFirst;
            synchronized (this.b) {
                objRemoveFirst = e().removeFirst();
            }
            return objRemoveFirst;
        }

        @Override // java.util.Deque
        public boolean removeFirstOccurrence(Object obj) {
            boolean zRemoveFirstOccurrence;
            synchronized (this.b) {
                zRemoveFirstOccurrence = e().removeFirstOccurrence(obj);
            }
            return zRemoveFirstOccurrence;
        }

        @Override // java.util.Deque
        public Object removeLast() {
            Object objRemoveLast;
            synchronized (this.b) {
                objRemoveLast = e().removeLast();
            }
            return objRemoveLast;
        }

        @Override // java.util.Deque
        public boolean removeLastOccurrence(Object obj) {
            boolean zRemoveLastOccurrence;
            synchronized (this.b) {
                zRemoveLastOccurrence = e().removeLastOccurrence(obj);
            }
            return zRemoveLastOccurrence;
        }
    }

    public static class h extends p implements Map.Entry {
        public h(Map.Entry entry, Object obj) {
            super(entry, obj);
        }

        public Map.Entry e() {
            return (Map.Entry) super.c();
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            boolean zEquals;
            synchronized (this.b) {
                zEquals = e().equals(obj);
            }
            return zEquals;
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            Object key;
            synchronized (this.b) {
                key = e().getKey();
            }
            return key;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            Object value;
            synchronized (this.b) {
                value = e().getValue();
            }
            return value;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int iHashCode;
            synchronized (this.b) {
                iHashCode = e().hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            Object value;
            synchronized (this.b) {
                value = e().setValue(obj);
            }
            return value;
        }
    }

    public static class i extends f implements List {
        public i(List list, Object obj) {
            super(list, obj);
        }

        @Override // java.util.List
        public void add(int i, Object obj) {
            synchronized (this.b) {
                f().add(i, obj);
            }
        }

        @Override // java.util.List
        public boolean addAll(int i, Collection collection) {
            boolean zAddAll;
            synchronized (this.b) {
                zAddAll = f().addAll(i, collection);
            }
            return zAddAll;
        }

        @Override // java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            boolean zEquals;
            if (obj == this) {
                return true;
            }
            synchronized (this.b) {
                zEquals = f().equals(obj);
            }
            return zEquals;
        }

        @Override // com.google.common.collect.N.f
        public List f() {
            return (List) super.f();
        }

        @Override // java.util.List
        public Object get(int i) {
            Object obj;
            synchronized (this.b) {
                obj = f().get(i);
            }
            return obj;
        }

        @Override // java.util.Collection, java.util.List
        public int hashCode() {
            int iHashCode;
            synchronized (this.b) {
                iHashCode = f().hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            int iIndexOf;
            synchronized (this.b) {
                iIndexOf = f().indexOf(obj);
            }
            return iIndexOf;
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            int iLastIndexOf;
            synchronized (this.b) {
                iLastIndexOf = f().lastIndexOf(obj);
            }
            return iLastIndexOf;
        }

        @Override // java.util.List
        public ListIterator listIterator() {
            return f().listIterator();
        }

        @Override // java.util.List
        public Object remove(int i) {
            Object objRemove;
            synchronized (this.b) {
                objRemove = f().remove(i);
            }
            return objRemove;
        }

        @Override // java.util.List
        public Object set(int i, Object obj) {
            Object obj2;
            synchronized (this.b) {
                obj2 = f().set(i, obj);
            }
            return obj2;
        }

        @Override // java.util.List
        public List subList(int i, int i2) {
            List listJ;
            synchronized (this.b) {
                listJ = N.j(f().subList(i, i2), this.b);
            }
            return listJ;
        }

        @Override // java.util.List
        public ListIterator listIterator(int i) {
            return f().listIterator(i);
        }
    }

    public static class j extends l implements ListMultimap {
        public j(ListMultimap listMultimap, Object obj) {
            super(listMultimap, obj);
        }

        @Override // com.google.common.collect.N.l
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public ListMultimap e() {
            return (ListMultimap) super.e();
        }

        @Override // com.google.common.collect.N.l, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public List get(Object obj) {
            List listJ;
            synchronized (this.b) {
                listJ = N.j(e().get(obj), this.b);
            }
            return listJ;
        }

        @Override // com.google.common.collect.N.l, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public List removeAll(Object obj) {
            List listRemoveAll;
            synchronized (this.b) {
                listRemoveAll = e().removeAll(obj);
            }
            return listRemoveAll;
        }

        @Override // com.google.common.collect.N.l, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public List replaceValues(Object obj, Iterable iterable) {
            List listReplaceValues;
            synchronized (this.b) {
                listReplaceValues = e().replaceValues(obj, iterable);
            }
            return listReplaceValues;
        }
    }

    public static class k extends p implements Map {
        public transient Set c;
        public transient Collection d;
        public transient Set e;

        public k(Map map, Object obj) {
            super(map, obj);
        }

        @Override // java.util.Map
        public void clear() {
            synchronized (this.b) {
                f().clear();
            }
        }

        @Override // java.util.Map
        public boolean containsKey(Object obj) {
            boolean zContainsKey;
            synchronized (this.b) {
                zContainsKey = f().containsKey(obj);
            }
            return zContainsKey;
        }

        public boolean containsValue(Object obj) {
            boolean zContainsValue;
            synchronized (this.b) {
                zContainsValue = f().containsValue(obj);
            }
            return zContainsValue;
        }

        /* JADX INFO: renamed from: e */
        public Map f() {
            return (Map) super.c();
        }

        public Set entrySet() {
            Set set;
            synchronized (this.b) {
                try {
                    if (this.e == null) {
                        this.e = N.u(f().entrySet(), this.b);
                    }
                    set = this.e;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return set;
        }

        @Override // java.util.Map
        public boolean equals(Object obj) {
            boolean zEquals;
            if (obj == this) {
                return true;
            }
            synchronized (this.b) {
                zEquals = f().equals(obj);
            }
            return zEquals;
        }

        public Object get(Object obj) {
            Object obj2;
            synchronized (this.b) {
                obj2 = f().get(obj);
            }
            return obj2;
        }

        @Override // java.util.Map
        public int hashCode() {
            int iHashCode;
            synchronized (this.b) {
                iHashCode = f().hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            boolean zIsEmpty;
            synchronized (this.b) {
                zIsEmpty = f().isEmpty();
            }
            return zIsEmpty;
        }

        @Override // java.util.Map
        public Set keySet() {
            Set set;
            synchronized (this.b) {
                try {
                    if (this.c == null) {
                        this.c = N.u(f().keySet(), this.b);
                    }
                    set = this.c;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return set;
        }

        @Override // java.util.Map
        public Object put(Object obj, Object obj2) {
            Object objPut;
            synchronized (this.b) {
                objPut = f().put(obj, obj2);
            }
            return objPut;
        }

        @Override // java.util.Map
        public void putAll(Map map) {
            synchronized (this.b) {
                f().putAll(map);
            }
        }

        @Override // java.util.Map
        public Object remove(Object obj) {
            Object objRemove;
            synchronized (this.b) {
                objRemove = f().remove(obj);
            }
            return objRemove;
        }

        @Override // java.util.Map
        public int size() {
            int size;
            synchronized (this.b) {
                size = f().size();
            }
            return size;
        }

        public Collection values() {
            Collection collection;
            synchronized (this.b) {
                try {
                    if (this.d == null) {
                        this.d = N.h(f().values(), this.b);
                    }
                    collection = this.d;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return collection;
        }
    }

    public static class p implements Serializable {
        public final Object a;
        public final Object b;

        public p(Object obj, Object obj2) {
            this.a = Preconditions.checkNotNull(obj);
            this.b = obj2 == null ? this : obj2;
        }

        public Object c() {
            return this.a;
        }

        public String toString() {
            String string;
            synchronized (this.b) {
                string = this.a.toString();
            }
            return string;
        }
    }

    public static class q extends f implements Queue {
        public q(Queue queue, Object obj) {
            super(queue, obj);
        }

        @Override // java.util.Queue
        public Object element() {
            Object objElement;
            synchronized (this.b) {
                objElement = f().element();
            }
            return objElement;
        }

        @Override // com.google.common.collect.N.f
        public Queue f() {
            return (Queue) super.f();
        }

        @Override // java.util.Queue
        public boolean offer(Object obj) {
            boolean zOffer;
            synchronized (this.b) {
                zOffer = f().offer(obj);
            }
            return zOffer;
        }

        @Override // java.util.Queue
        public Object peek() {
            Object objPeek;
            synchronized (this.b) {
                objPeek = f().peek();
            }
            return objPeek;
        }

        @Override // java.util.Queue
        public Object poll() {
            Object objPoll;
            synchronized (this.b) {
                objPoll = f().poll();
            }
            return objPoll;
        }

        @Override // java.util.Queue
        public Object remove() {
            Object objRemove;
            synchronized (this.b) {
                objRemove = f().remove();
            }
            return objRemove;
        }
    }

    public static class r extends i implements RandomAccess {
        public r(List list, Object obj) {
            super(list, obj);
        }
    }

    public static class s extends f implements Set {
        public s(Set set, Object obj) {
            super(set, obj);
        }

        public boolean equals(Object obj) {
            boolean zEquals;
            if (obj == this) {
                return true;
            }
            synchronized (this.b) {
                zEquals = f().equals(obj);
            }
            return zEquals;
        }

        @Override // com.google.common.collect.N.f
        public Set f() {
            return (Set) super.f();
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            int iHashCode;
            synchronized (this.b) {
                iHashCode = f().hashCode();
            }
            return iHashCode;
        }
    }

    public static class t extends l implements SetMultimap {
        public transient Set h;

        public t(SetMultimap setMultimap, Object obj) {
            super(setMultimap, obj);
        }

        @Override // com.google.common.collect.N.l
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public SetMultimap e() {
            return (SetMultimap) super.e();
        }

        @Override // com.google.common.collect.N.l, com.google.common.collect.Multimap
        public Set entries() {
            Set set;
            synchronized (this.b) {
                try {
                    if (this.h == null) {
                        this.h = N.u(e().entries(), this.b);
                    }
                    set = this.h;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return set;
        }

        @Override // com.google.common.collect.N.l, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Set get(Object obj) {
            Set setU;
            synchronized (this.b) {
                setU = N.u(e().get(obj), this.b);
            }
            return setU;
        }

        @Override // com.google.common.collect.N.l, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Set removeAll(Object obj) {
            Set setRemoveAll;
            synchronized (this.b) {
                setRemoveAll = e().removeAll(obj);
            }
            return setRemoveAll;
        }

        @Override // com.google.common.collect.N.l, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Set replaceValues(Object obj, Iterable iterable) {
            Set setReplaceValues;
            synchronized (this.b) {
                setReplaceValues = e().replaceValues(obj, iterable);
            }
            return setReplaceValues;
        }
    }

    public static class u extends k implements SortedMap {
        public u(SortedMap sortedMap, Object obj) {
            super(sortedMap, obj);
        }

        @Override // java.util.SortedMap
        public Comparator comparator() {
            Comparator comparator;
            synchronized (this.b) {
                comparator = f().comparator();
            }
            return comparator;
        }

        public SortedMap f() {
            return (SortedMap) super.f();
        }

        @Override // java.util.SortedMap
        public Object firstKey() {
            Object objFirstKey;
            synchronized (this.b) {
                objFirstKey = f().firstKey();
            }
            return objFirstKey;
        }

        @Override // java.util.SortedMap
        public Object lastKey() {
            Object objLastKey;
            synchronized (this.b) {
                objLastKey = f().lastKey();
            }
            return objLastKey;
        }
    }

    public static class v extends s implements SortedSet {
        public v(SortedSet sortedSet, Object obj) {
            super(sortedSet, obj);
        }

        @Override // java.util.SortedSet
        public Comparator comparator() {
            Comparator comparator;
            synchronized (this.b) {
                comparator = f().comparator();
            }
            return comparator;
        }

        @Override // java.util.SortedSet
        public Object first() {
            Object objFirst;
            synchronized (this.b) {
                objFirst = f().first();
            }
            return objFirst;
        }

        @Override // com.google.common.collect.N.s
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public SortedSet f() {
            return (SortedSet) super.f();
        }

        public SortedSet headSet(Object obj) {
            SortedSet sortedSetW;
            synchronized (this.b) {
                sortedSetW = N.w(f().headSet(obj), this.b);
            }
            return sortedSetW;
        }

        @Override // java.util.SortedSet
        public Object last() {
            Object objLast;
            synchronized (this.b) {
                objLast = f().last();
            }
            return objLast;
        }

        public SortedSet subSet(Object obj, Object obj2) {
            SortedSet sortedSetW;
            synchronized (this.b) {
                sortedSetW = N.w(f().subSet(obj, obj2), this.b);
            }
            return sortedSetW;
        }

        public SortedSet tailSet(Object obj) {
            SortedSet sortedSetW;
            synchronized (this.b) {
                sortedSetW = N.w(f().tailSet(obj), this.b);
            }
            return sortedSetW;
        }
    }

    public static final class x extends p implements Table {

        public class a implements Function {
            public a() {
            }

            @Override // com.google.common.base.Function
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map apply(Map map) {
                return N.l(map, x.this.b);
            }
        }

        public class b implements Function {
            public b() {
            }

            @Override // com.google.common.base.Function
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map apply(Map map) {
                return N.l(map, x.this.b);
            }
        }

        public x(Table table, Object obj) {
            super(table, obj);
        }

        @Override // com.google.common.collect.Table
        public Set cellSet() {
            Set setU;
            synchronized (this.b) {
                setU = N.u(e().cellSet(), this.b);
            }
            return setU;
        }

        @Override // com.google.common.collect.Table
        public void clear() {
            synchronized (this.b) {
                e().clear();
            }
        }

        @Override // com.google.common.collect.Table
        public Map column(Object obj) {
            Map mapL;
            synchronized (this.b) {
                mapL = N.l(e().column(obj), this.b);
            }
            return mapL;
        }

        @Override // com.google.common.collect.Table
        public Set columnKeySet() {
            Set setU;
            synchronized (this.b) {
                setU = N.u(e().columnKeySet(), this.b);
            }
            return setU;
        }

        @Override // com.google.common.collect.Table
        public Map columnMap() {
            Map mapL;
            synchronized (this.b) {
                mapL = N.l(Maps.transformValues(e().columnMap(), new b()), this.b);
            }
            return mapL;
        }

        @Override // com.google.common.collect.Table
        public boolean contains(Object obj, Object obj2) {
            boolean zContains;
            synchronized (this.b) {
                zContains = e().contains(obj, obj2);
            }
            return zContains;
        }

        @Override // com.google.common.collect.Table
        public boolean containsColumn(Object obj) {
            boolean zContainsColumn;
            synchronized (this.b) {
                zContainsColumn = e().containsColumn(obj);
            }
            return zContainsColumn;
        }

        @Override // com.google.common.collect.Table
        public boolean containsRow(Object obj) {
            boolean zContainsRow;
            synchronized (this.b) {
                zContainsRow = e().containsRow(obj);
            }
            return zContainsRow;
        }

        @Override // com.google.common.collect.Table
        public boolean containsValue(Object obj) {
            boolean zContainsValue;
            synchronized (this.b) {
                zContainsValue = e().containsValue(obj);
            }
            return zContainsValue;
        }

        public Table e() {
            return (Table) super.c();
        }

        @Override // com.google.common.collect.Table
        public boolean equals(Object obj) {
            boolean zEquals;
            if (this == obj) {
                return true;
            }
            synchronized (this.b) {
                zEquals = e().equals(obj);
            }
            return zEquals;
        }

        @Override // com.google.common.collect.Table
        public Object get(Object obj, Object obj2) {
            Object obj3;
            synchronized (this.b) {
                obj3 = e().get(obj, obj2);
            }
            return obj3;
        }

        @Override // com.google.common.collect.Table
        public int hashCode() {
            int iHashCode;
            synchronized (this.b) {
                iHashCode = e().hashCode();
            }
            return iHashCode;
        }

        @Override // com.google.common.collect.Table
        public boolean isEmpty() {
            boolean zIsEmpty;
            synchronized (this.b) {
                zIsEmpty = e().isEmpty();
            }
            return zIsEmpty;
        }

        @Override // com.google.common.collect.Table
        public Object put(Object obj, Object obj2, Object obj3) {
            Object objPut;
            synchronized (this.b) {
                objPut = e().put(obj, obj2, obj3);
            }
            return objPut;
        }

        @Override // com.google.common.collect.Table
        public void putAll(Table table) {
            synchronized (this.b) {
                e().putAll(table);
            }
        }

        @Override // com.google.common.collect.Table
        public Object remove(Object obj, Object obj2) {
            Object objRemove;
            synchronized (this.b) {
                objRemove = e().remove(obj, obj2);
            }
            return objRemove;
        }

        @Override // com.google.common.collect.Table
        public Map row(Object obj) {
            Map mapL;
            synchronized (this.b) {
                mapL = N.l(e().row(obj), this.b);
            }
            return mapL;
        }

        @Override // com.google.common.collect.Table
        public Set rowKeySet() {
            Set setU;
            synchronized (this.b) {
                setU = N.u(e().rowKeySet(), this.b);
            }
            return setU;
        }

        @Override // com.google.common.collect.Table
        public Map rowMap() {
            Map mapL;
            synchronized (this.b) {
                mapL = N.l(Maps.transformValues(e().rowMap(), new a()), this.b);
            }
            return mapL;
        }

        @Override // com.google.common.collect.Table
        public int size() {
            int size;
            synchronized (this.b) {
                size = e().size();
            }
            return size;
        }

        @Override // com.google.common.collect.Table
        public Collection values() {
            Collection collectionH;
            synchronized (this.b) {
                collectionH = N.h(e().values(), this.b);
            }
            return collectionH;
        }
    }

    public static Set A(Set set, Object obj) {
        return set instanceof SortedSet ? w((SortedSet) set, obj) : u(set, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static BiMap g(BiMap biMap, Object obj) {
        return ((biMap instanceof e) || (biMap instanceof ImmutableBiMap)) ? biMap : new e(biMap, obj, null);
    }

    public static Collection h(Collection collection, Object obj) {
        return new f(collection, obj);
    }

    public static Deque i(Deque deque, Object obj) {
        return new g(deque, obj);
    }

    public static List j(List list, Object obj) {
        return list instanceof RandomAccess ? new r(list, obj) : new i(list, obj);
    }

    public static ListMultimap k(ListMultimap listMultimap, Object obj) {
        return ((listMultimap instanceof j) || (listMultimap instanceof AbstractC3122j7)) ? listMultimap : new j(listMultimap, obj);
    }

    public static Map l(Map map, Object obj) {
        return new k(map, obj);
    }

    public static Multimap m(Multimap multimap, Object obj) {
        return ((multimap instanceof l) || (multimap instanceof AbstractC3122j7)) ? multimap : new l(multimap, obj);
    }

    public static Multiset n(Multiset multiset, Object obj) {
        return ((multiset instanceof m) || (multiset instanceof ImmutableMultiset)) ? multiset : new m(multiset, obj);
    }

    public static NavigableMap o(NavigableMap navigableMap) {
        return p(navigableMap, null);
    }

    public static NavigableMap p(NavigableMap navigableMap, Object obj) {
        return new n(navigableMap, obj);
    }

    public static NavigableSet q(NavigableSet navigableSet) {
        return r(navigableSet, null);
    }

    public static NavigableSet r(NavigableSet navigableSet, Object obj) {
        return new o(navigableSet, obj);
    }

    public static Map.Entry s(Map.Entry entry, Object obj) {
        if (entry == null) {
            return null;
        }
        return new h(entry, obj);
    }

    public static Queue t(Queue queue, Object obj) {
        return queue instanceof q ? queue : new q(queue, obj);
    }

    public static Set u(Set set, Object obj) {
        return new s(set, obj);
    }

    public static SetMultimap v(SetMultimap setMultimap, Object obj) {
        return ((setMultimap instanceof t) || (setMultimap instanceof AbstractC3122j7)) ? setMultimap : new t(setMultimap, obj);
    }

    public static SortedSet w(SortedSet sortedSet, Object obj) {
        return new v(sortedSet, obj);
    }

    public static SortedSetMultimap x(SortedSetMultimap sortedSetMultimap, Object obj) {
        return sortedSetMultimap instanceof w ? sortedSetMultimap : new w(sortedSetMultimap, obj);
    }

    public static Table y(Table table, Object obj) {
        return new x(table, obj);
    }

    public static Collection z(Collection collection, Object obj) {
        if (collection instanceof SortedSet) {
            return w((SortedSet) collection, obj);
        }
        if (collection instanceof Set) {
            return u((Set) collection, obj);
        }
        return collection instanceof List ? j((List) collection, obj) : h(collection, obj);
    }

    public static class w extends t implements SortedSetMultimap {
        public w(SortedSetMultimap sortedSetMultimap, Object obj) {
            super(sortedSetMultimap, obj);
        }

        @Override // com.google.common.collect.N.t
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public SortedSetMultimap e() {
            return (SortedSetMultimap) super.e();
        }

        @Override // com.google.common.collect.SortedSetMultimap
        public Comparator valueComparator() {
            Comparator comparatorValueComparator;
            synchronized (this.b) {
                comparatorValueComparator = e().valueComparator();
            }
            return comparatorValueComparator;
        }

        @Override // com.google.common.collect.N.t, com.google.common.collect.N.l, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public SortedSet get(Object obj) {
            SortedSet sortedSetW;
            synchronized (this.b) {
                sortedSetW = N.w(e().get(obj), this.b);
            }
            return sortedSetW;
        }

        @Override // com.google.common.collect.N.t, com.google.common.collect.N.l, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public SortedSet removeAll(Object obj) {
            SortedSet sortedSetRemoveAll;
            synchronized (this.b) {
                sortedSetRemoveAll = e().removeAll(obj);
            }
            return sortedSetRemoveAll;
        }

        @Override // com.google.common.collect.N.t, com.google.common.collect.N.l, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public SortedSet replaceValues(Object obj, Iterable iterable) {
            SortedSet sortedSetReplaceValues;
            synchronized (this.b) {
                sortedSetReplaceValues = e().replaceValues(obj, iterable);
            }
            return sortedSetReplaceValues;
        }
    }

    public static class l extends p implements Multimap {
        public transient Set c;
        public transient Collection d;
        public transient Collection e;
        public transient Map f;
        public transient Multiset g;

        public l(Multimap multimap, Object obj) {
            super(multimap, obj);
        }

        @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Map asMap() {
            Map map;
            synchronized (this.b) {
                try {
                    if (this.f == null) {
                        this.f = new b(e().asMap(), this.b);
                    }
                    map = this.f;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return map;
        }

        @Override // com.google.common.collect.Multimap
        public void clear() {
            synchronized (this.b) {
                e().clear();
            }
        }

        @Override // com.google.common.collect.Multimap
        public boolean containsEntry(Object obj, Object obj2) {
            boolean zContainsEntry;
            synchronized (this.b) {
                zContainsEntry = e().containsEntry(obj, obj2);
            }
            return zContainsEntry;
        }

        @Override // com.google.common.collect.Multimap
        public boolean containsKey(Object obj) {
            boolean zContainsKey;
            synchronized (this.b) {
                zContainsKey = e().containsKey(obj);
            }
            return zContainsKey;
        }

        @Override // com.google.common.collect.Multimap
        public boolean containsValue(Object obj) {
            boolean zContainsValue;
            synchronized (this.b) {
                zContainsValue = e().containsValue(obj);
            }
            return zContainsValue;
        }

        public Multimap e() {
            return (Multimap) super.c();
        }

        @Override // com.google.common.collect.Multimap
        public Collection entries() {
            Collection collection;
            synchronized (this.b) {
                try {
                    if (this.e == null) {
                        this.e = N.z(e().entries(), this.b);
                    }
                    collection = this.e;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return collection;
        }

        @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public boolean equals(Object obj) {
            boolean zEquals;
            if (obj == this) {
                return true;
            }
            synchronized (this.b) {
                zEquals = e().equals(obj);
            }
            return zEquals;
        }

        public Collection get(Object obj) {
            Collection collectionZ;
            synchronized (this.b) {
                collectionZ = N.z(e().get(obj), this.b);
            }
            return collectionZ;
        }

        @Override // com.google.common.collect.Multimap
        public int hashCode() {
            int iHashCode;
            synchronized (this.b) {
                iHashCode = e().hashCode();
            }
            return iHashCode;
        }

        @Override // com.google.common.collect.Multimap
        public boolean isEmpty() {
            boolean zIsEmpty;
            synchronized (this.b) {
                zIsEmpty = e().isEmpty();
            }
            return zIsEmpty;
        }

        @Override // com.google.common.collect.Multimap
        public Set keySet() {
            Set set;
            synchronized (this.b) {
                try {
                    if (this.c == null) {
                        this.c = N.A(e().keySet(), this.b);
                    }
                    set = this.c;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return set;
        }

        @Override // com.google.common.collect.Multimap
        public Multiset keys() {
            Multiset multiset;
            synchronized (this.b) {
                try {
                    if (this.g == null) {
                        this.g = N.n(e().keys(), this.b);
                    }
                    multiset = this.g;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return multiset;
        }

        @Override // com.google.common.collect.Multimap
        public boolean put(Object obj, Object obj2) {
            boolean zPut;
            synchronized (this.b) {
                zPut = e().put(obj, obj2);
            }
            return zPut;
        }

        @Override // com.google.common.collect.Multimap
        public boolean putAll(Object obj, Iterable iterable) {
            boolean zPutAll;
            synchronized (this.b) {
                zPutAll = e().putAll(obj, iterable);
            }
            return zPutAll;
        }

        @Override // com.google.common.collect.Multimap
        public boolean remove(Object obj, Object obj2) {
            boolean zRemove;
            synchronized (this.b) {
                zRemove = e().remove(obj, obj2);
            }
            return zRemove;
        }

        public Collection removeAll(Object obj) {
            Collection collectionRemoveAll;
            synchronized (this.b) {
                collectionRemoveAll = e().removeAll(obj);
            }
            return collectionRemoveAll;
        }

        public Collection replaceValues(Object obj, Iterable iterable) {
            Collection collectionReplaceValues;
            synchronized (this.b) {
                collectionReplaceValues = e().replaceValues(obj, iterable);
            }
            return collectionReplaceValues;
        }

        @Override // com.google.common.collect.Multimap
        public int size() {
            int size;
            synchronized (this.b) {
                size = e().size();
            }
            return size;
        }

        @Override // com.google.common.collect.Multimap
        public Collection values() {
            Collection collection;
            synchronized (this.b) {
                try {
                    if (this.d == null) {
                        this.d = N.h(e().values(), this.b);
                    }
                    collection = this.d;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return collection;
        }

        @Override // com.google.common.collect.Multimap
        public boolean putAll(Multimap multimap) {
            boolean zPutAll;
            synchronized (this.b) {
                zPutAll = e().putAll(multimap);
            }
            return zPutAll;
        }
    }

    public static class m extends f implements Multiset {
        public transient Set c;
        public transient Set d;

        public m(Multiset multiset, Object obj) {
            super(multiset, obj);
        }

        @Override // com.google.common.collect.Multiset
        public int add(Object obj, int i) {
            int iAdd;
            synchronized (this.b) {
                iAdd = f().add(obj, i);
            }
            return iAdd;
        }

        @Override // com.google.common.collect.Multiset
        public int count(Object obj) {
            int iCount;
            synchronized (this.b) {
                iCount = f().count(obj);
            }
            return iCount;
        }

        @Override // com.google.common.collect.Multiset
        public Set elementSet() {
            Set set;
            synchronized (this.b) {
                try {
                    if (this.c == null) {
                        this.c = N.A(f().elementSet(), this.b);
                    }
                    set = this.c;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return set;
        }

        @Override // com.google.common.collect.Multiset
        public Set entrySet() {
            Set set;
            synchronized (this.b) {
                try {
                    if (this.d == null) {
                        this.d = N.A(f().entrySet(), this.b);
                    }
                    set = this.d;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return set;
        }

        @Override // java.util.Collection, com.google.common.collect.Multiset
        public boolean equals(Object obj) {
            boolean zEquals;
            if (obj == this) {
                return true;
            }
            synchronized (this.b) {
                zEquals = f().equals(obj);
            }
            return zEquals;
        }

        @Override // com.google.common.collect.N.f
        public Multiset f() {
            return (Multiset) super.f();
        }

        @Override // java.util.Collection, com.google.common.collect.Multiset
        public int hashCode() {
            int iHashCode;
            synchronized (this.b) {
                iHashCode = f().hashCode();
            }
            return iHashCode;
        }

        @Override // com.google.common.collect.Multiset
        public int remove(Object obj, int i) {
            int iRemove;
            synchronized (this.b) {
                iRemove = f().remove(obj, i);
            }
            return iRemove;
        }

        @Override // com.google.common.collect.Multiset
        public int setCount(Object obj, int i) {
            int count;
            synchronized (this.b) {
                count = f().setCount(obj, i);
            }
            return count;
        }

        @Override // com.google.common.collect.Multiset
        public boolean setCount(Object obj, int i, int i2) {
            boolean count;
            synchronized (this.b) {
                count = f().setCount(obj, i, i2);
            }
            return count;
        }
    }

    public static class n extends u implements NavigableMap {
        public transient NavigableSet f;
        public transient NavigableMap g;
        public transient NavigableSet h;

        public n(NavigableMap navigableMap, Object obj) {
            super(navigableMap, obj);
        }

        @Override // java.util.NavigableMap
        public Map.Entry ceilingEntry(Object obj) {
            Map.Entry entryS;
            synchronized (this.b) {
                entryS = N.s(e().ceilingEntry(obj), this.b);
            }
            return entryS;
        }

        @Override // java.util.NavigableMap
        public Object ceilingKey(Object obj) {
            Object objCeilingKey;
            synchronized (this.b) {
                objCeilingKey = e().ceilingKey(obj);
            }
            return objCeilingKey;
        }

        @Override // java.util.NavigableMap
        public NavigableSet descendingKeySet() {
            synchronized (this.b) {
                try {
                    NavigableSet navigableSet = this.f;
                    if (navigableSet != null) {
                        return navigableSet;
                    }
                    NavigableSet navigableSetR = N.r(e().descendingKeySet(), this.b);
                    this.f = navigableSetR;
                    return navigableSetR;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.util.NavigableMap
        public NavigableMap descendingMap() {
            synchronized (this.b) {
                try {
                    NavigableMap navigableMap = this.g;
                    if (navigableMap != null) {
                        return navigableMap;
                    }
                    NavigableMap navigableMapP = N.p(e().descendingMap(), this.b);
                    this.g = navigableMapP;
                    return navigableMapP;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.util.NavigableMap
        public Map.Entry firstEntry() {
            Map.Entry entryS;
            synchronized (this.b) {
                entryS = N.s(e().firstEntry(), this.b);
            }
            return entryS;
        }

        @Override // java.util.NavigableMap
        public Map.Entry floorEntry(Object obj) {
            Map.Entry entryS;
            synchronized (this.b) {
                entryS = N.s(e().floorEntry(obj), this.b);
            }
            return entryS;
        }

        @Override // java.util.NavigableMap
        public Object floorKey(Object obj) {
            Object objFloorKey;
            synchronized (this.b) {
                objFloorKey = e().floorKey(obj);
            }
            return objFloorKey;
        }

        @Override // com.google.common.collect.N.u
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public NavigableMap f() {
            return (NavigableMap) super.f();
        }

        @Override // java.util.NavigableMap
        public NavigableMap headMap(Object obj, boolean z) {
            NavigableMap navigableMapP;
            synchronized (this.b) {
                navigableMapP = N.p(e().headMap(obj, z), this.b);
            }
            return navigableMapP;
        }

        @Override // java.util.NavigableMap
        public Map.Entry higherEntry(Object obj) {
            Map.Entry entryS;
            synchronized (this.b) {
                entryS = N.s(e().higherEntry(obj), this.b);
            }
            return entryS;
        }

        @Override // java.util.NavigableMap
        public Object higherKey(Object obj) {
            Object objHigherKey;
            synchronized (this.b) {
                objHigherKey = e().higherKey(obj);
            }
            return objHigherKey;
        }

        @Override // com.google.common.collect.N.k, java.util.Map
        public Set keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry lastEntry() {
            Map.Entry entryS;
            synchronized (this.b) {
                entryS = N.s(e().lastEntry(), this.b);
            }
            return entryS;
        }

        @Override // java.util.NavigableMap
        public Map.Entry lowerEntry(Object obj) {
            Map.Entry entryS;
            synchronized (this.b) {
                entryS = N.s(e().lowerEntry(obj), this.b);
            }
            return entryS;
        }

        @Override // java.util.NavigableMap
        public Object lowerKey(Object obj) {
            Object objLowerKey;
            synchronized (this.b) {
                objLowerKey = e().lowerKey(obj);
            }
            return objLowerKey;
        }

        @Override // java.util.NavigableMap
        public NavigableSet navigableKeySet() {
            synchronized (this.b) {
                try {
                    NavigableSet navigableSet = this.h;
                    if (navigableSet != null) {
                        return navigableSet;
                    }
                    NavigableSet navigableSetR = N.r(e().navigableKeySet(), this.b);
                    this.h = navigableSetR;
                    return navigableSetR;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.util.NavigableMap
        public Map.Entry pollFirstEntry() {
            Map.Entry entryS;
            synchronized (this.b) {
                entryS = N.s(e().pollFirstEntry(), this.b);
            }
            return entryS;
        }

        @Override // java.util.NavigableMap
        public Map.Entry pollLastEntry() {
            Map.Entry entryS;
            synchronized (this.b) {
                entryS = N.s(e().pollLastEntry(), this.b);
            }
            return entryS;
        }

        @Override // java.util.NavigableMap
        public NavigableMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
            NavigableMap navigableMapP;
            synchronized (this.b) {
                navigableMapP = N.p(e().subMap(obj, z, obj2, z2), this.b);
            }
            return navigableMapP;
        }

        @Override // java.util.NavigableMap
        public NavigableMap tailMap(Object obj, boolean z) {
            NavigableMap navigableMapP;
            synchronized (this.b) {
                navigableMapP = N.p(e().tailMap(obj, z), this.b);
            }
            return navigableMapP;
        }

        @Override // java.util.SortedMap, java.util.NavigableMap
        public SortedMap headMap(Object obj) {
            return headMap(obj, false);
        }

        @Override // java.util.SortedMap, java.util.NavigableMap
        public SortedMap subMap(Object obj, Object obj2) {
            return subMap(obj, true, obj2, false);
        }

        @Override // java.util.SortedMap, java.util.NavigableMap
        public SortedMap tailMap(Object obj) {
            return tailMap(obj, true);
        }
    }

    public static class o extends v implements NavigableSet {
        public transient NavigableSet c;

        public o(NavigableSet navigableSet, Object obj) {
            super(navigableSet, obj);
        }

        @Override // java.util.NavigableSet
        public Object ceiling(Object obj) {
            Object objCeiling;
            synchronized (this.b) {
                objCeiling = f().ceiling(obj);
            }
            return objCeiling;
        }

        @Override // java.util.NavigableSet
        public Iterator descendingIterator() {
            return f().descendingIterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet descendingSet() {
            synchronized (this.b) {
                try {
                    NavigableSet navigableSet = this.c;
                    if (navigableSet != null) {
                        return navigableSet;
                    }
                    NavigableSet navigableSetR = N.r(f().descendingSet(), this.b);
                    this.c = navigableSetR;
                    return navigableSetR;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.util.NavigableSet
        public Object floor(Object obj) {
            Object objFloor;
            synchronized (this.b) {
                objFloor = f().floor(obj);
            }
            return objFloor;
        }

        @Override // java.util.NavigableSet
        public NavigableSet headSet(Object obj, boolean z) {
            NavigableSet navigableSetR;
            synchronized (this.b) {
                navigableSetR = N.r(f().headSet(obj, z), this.b);
            }
            return navigableSetR;
        }

        @Override // java.util.NavigableSet
        public Object higher(Object obj) {
            Object objHigher;
            synchronized (this.b) {
                objHigher = f().higher(obj);
            }
            return objHigher;
        }

        @Override // com.google.common.collect.N.v
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public NavigableSet f() {
            return (NavigableSet) super.f();
        }

        @Override // java.util.NavigableSet
        public Object lower(Object obj) {
            Object objLower;
            synchronized (this.b) {
                objLower = f().lower(obj);
            }
            return objLower;
        }

        @Override // java.util.NavigableSet
        public Object pollFirst() {
            Object objPollFirst;
            synchronized (this.b) {
                objPollFirst = f().pollFirst();
            }
            return objPollFirst;
        }

        @Override // java.util.NavigableSet
        public Object pollLast() {
            Object objPollLast;
            synchronized (this.b) {
                objPollLast = f().pollLast();
            }
            return objPollLast;
        }

        @Override // java.util.NavigableSet
        public NavigableSet subSet(Object obj, boolean z, Object obj2, boolean z2) {
            NavigableSet navigableSetR;
            synchronized (this.b) {
                navigableSetR = N.r(f().subSet(obj, z, obj2, z2), this.b);
            }
            return navigableSetR;
        }

        @Override // java.util.NavigableSet
        public NavigableSet tailSet(Object obj, boolean z) {
            NavigableSet navigableSetR;
            synchronized (this.b) {
                navigableSetR = N.r(f().tailSet(obj, z), this.b);
            }
            return navigableSetR;
        }

        @Override // com.google.common.collect.N.v, java.util.SortedSet, java.util.NavigableSet
        public SortedSet headSet(Object obj) {
            return headSet(obj, false);
        }

        @Override // com.google.common.collect.N.v, java.util.SortedSet, java.util.NavigableSet
        public SortedSet tailSet(Object obj) {
            return tailSet(obj, true);
        }

        @Override // com.google.common.collect.N.v, java.util.SortedSet, java.util.NavigableSet
        public SortedSet subSet(Object obj, Object obj2) {
            return subSet(obj, true, obj2, false);
        }
    }

    public static class c extends s {

        public class a extends AbstractC2362hV {

            /* JADX INFO: renamed from: com.google.common.collect.N$c$a$a, reason: collision with other inner class name */
            public class C0231a extends ForwardingMapEntry {
                public final /* synthetic */ Map.Entry a;

                public C0231a(Map.Entry entry) {
                    this.a = entry;
                }

                @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public Collection getValue() {
                    return N.z((Collection) this.a.getValue(), c.this.b);
                }

                @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
                public Map.Entry delegate() {
                    return this.a;
                }
            }

            public a(Iterator it) {
                super(it);
            }

            @Override // defpackage.AbstractC2362hV
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Map.Entry a(Map.Entry entry) {
                return new C0231a(entry);
            }
        }

        public c(Set set, Object obj) {
            super(set, obj);
        }

        @Override // com.google.common.collect.N.f, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            boolean zContainsEntryImpl;
            synchronized (this.b) {
                zContainsEntryImpl = Maps.containsEntryImpl(f(), obj);
            }
            return zContainsEntryImpl;
        }

        @Override // com.google.common.collect.N.f, java.util.Collection, java.util.Set
        public boolean containsAll(Collection collection) {
            boolean zContainsAllImpl;
            synchronized (this.b) {
                zContainsAllImpl = Collections2.containsAllImpl(f(), collection);
            }
            return zContainsAllImpl;
        }

        @Override // com.google.common.collect.N.s, java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            boolean zEqualsImpl;
            if (obj == this) {
                return true;
            }
            synchronized (this.b) {
                zEqualsImpl = Sets.equalsImpl(f(), obj);
            }
            return zEqualsImpl;
        }

        @Override // com.google.common.collect.N.f, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new a(super.iterator());
        }

        @Override // com.google.common.collect.N.f, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            boolean zRemoveEntryImpl;
            synchronized (this.b) {
                zRemoveEntryImpl = Maps.removeEntryImpl(f(), obj);
            }
            return zRemoveEntryImpl;
        }

        @Override // com.google.common.collect.N.f, java.util.Collection, java.util.Set
        public boolean removeAll(Collection collection) {
            boolean zRemoveAll;
            synchronized (this.b) {
                zRemoveAll = Iterators.removeAll(f().iterator(), collection);
            }
            return zRemoveAll;
        }

        @Override // com.google.common.collect.N.f, java.util.Collection, java.util.Set
        public boolean retainAll(Collection collection) {
            boolean zRetainAll;
            synchronized (this.b) {
                zRetainAll = Iterators.retainAll(f().iterator(), collection);
            }
            return zRetainAll;
        }

        @Override // com.google.common.collect.N.f, java.util.Collection, java.util.Set
        public Object[] toArray() {
            Object[] arrayImpl;
            synchronized (this.b) {
                arrayImpl = ObjectArrays.toArrayImpl(f());
            }
            return arrayImpl;
        }

        @Override // com.google.common.collect.N.f, java.util.Collection, java.util.Set
        public Object[] toArray(Object[] objArr) {
            Object[] arrayImpl;
            synchronized (this.b) {
                arrayImpl = ObjectArrays.toArrayImpl(f(), objArr);
            }
            return arrayImpl;
        }
    }
}
