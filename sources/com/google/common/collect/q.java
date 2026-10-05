package com.google.common.collect;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.q;
import defpackage.AbstractC1163Zb;
import defpackage.C4070um;
import defpackage.InterfaceC3989tm;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class q extends AbstractC1954d implements InterfaceC3989tm {
    public final Multimap a;
    public final Predicate b;

    public class a extends Maps.Q {

        /* JADX INFO: renamed from: com.google.common.collect.q$a$a, reason: collision with other inner class name */
        public class C0241a extends Maps.s {

            /* JADX INFO: renamed from: com.google.common.collect.q$a$a$a, reason: collision with other inner class name */
            public class C0242a extends AbstractIterator {
                public final Iterator a;

                public C0242a() {
                    this.a = q.this.a.asMap().entrySet().iterator();
                }

                @Override // com.google.common.collect.AbstractIterator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Map.Entry computeNext() {
                    while (this.a.hasNext()) {
                        Map.Entry entry = (Map.Entry) this.a.next();
                        Object key = entry.getKey();
                        Collection collectionE = q.e((Collection) entry.getValue(), q.this.new c(key));
                        if (!collectionE.isEmpty()) {
                            return Maps.immutableEntry(key, collectionE);
                        }
                    }
                    return (Map.Entry) endOfData();
                }
            }

            public C0241a() {
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator iterator() {
                return new C0242a();
            }

            @Override // com.google.common.collect.Maps.s
            public Map map() {
                return a.this;
            }

            @Override // com.google.common.collect.Maps.s, com.google.common.collect.Sets.k, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection collection) {
                return q.this.f(Predicates.in(collection));
            }

            @Override // com.google.common.collect.Maps.s, com.google.common.collect.Sets.k, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection collection) {
                return q.this.f(Predicates.not(Predicates.in(collection)));
            }

            @Override // com.google.common.collect.Maps.s, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return Iterators.size(iterator());
            }
        }

        public class b extends Maps.A {
            public b() {
                super(a.this);
            }

            @Override // com.google.common.collect.Maps.A, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                return a.this.remove(obj) != null;
            }

            @Override // com.google.common.collect.Sets.k, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection collection) {
                return q.this.f(Maps.keyPredicateOnEntries(Predicates.in(collection)));
            }

            @Override // com.google.common.collect.Sets.k, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection collection) {
                return q.this.f(Maps.keyPredicateOnEntries(Predicates.not(Predicates.in(collection))));
            }
        }

        public class c extends Maps.P {
            public c() {
                super(a.this);
            }

            @Override // com.google.common.collect.Maps.P, java.util.AbstractCollection, java.util.Collection
            public boolean remove(Object obj) {
                if (!(obj instanceof Collection)) {
                    return false;
                }
                Collection collection = (Collection) obj;
                Iterator it = q.this.a.asMap().entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    Collection collectionE = q.e((Collection) entry.getValue(), q.this.new c(entry.getKey()));
                    if (!collectionE.isEmpty() && collection.equals(collectionE)) {
                        if (collectionE.size() == ((Collection) entry.getValue()).size()) {
                            it.remove();
                            return true;
                        }
                        collectionE.clear();
                        return true;
                    }
                }
                return false;
            }

            @Override // com.google.common.collect.Maps.P, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection collection) {
                return q.this.f(Maps.valuePredicateOnEntries(Predicates.in(collection)));
            }

            @Override // com.google.common.collect.Maps.P, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection collection) {
                return q.this.f(Maps.valuePredicateOnEntries(Predicates.not(Predicates.in(collection))));
            }
        }

        public a() {
        }

        @Override // com.google.common.collect.Maps.Q
        public Set a() {
            return new C0241a();
        }

        @Override // com.google.common.collect.Maps.Q
        /* JADX INFO: renamed from: b */
        public Set g() {
            return new b();
        }

        @Override // com.google.common.collect.Maps.Q
        public Collection c() {
            return new c();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            q.this.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return get(obj) != null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Collection get(Object obj) {
            Collection collection = (Collection) q.this.a.asMap().get(obj);
            if (collection == null) {
                return null;
            }
            Collection collectionE = q.e(collection, q.this.new c(obj));
            if (collectionE.isEmpty()) {
                return null;
            }
            return collectionE;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Collection remove(Object obj) {
            Collection collection = (Collection) q.this.a.asMap().get(obj);
            if (collection == null) {
                return null;
            }
            ArrayList arrayListNewArrayList = Lists.newArrayList();
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (q.this.h(obj, next)) {
                    it.remove();
                    arrayListNewArrayList.add(next);
                }
            }
            if (arrayListNewArrayList.isEmpty()) {
                return null;
            }
            return q.this.a instanceof SetMultimap ? Collections.unmodifiableSet(Sets.newLinkedHashSet(arrayListNewArrayList)) : Collections.unmodifiableList(arrayListNewArrayList);
        }
    }

    public class b extends Multimaps.g {

        public class a extends Multisets.i {
            public a() {
            }

            public static /* synthetic */ boolean f(Predicate predicate, Map.Entry entry) {
                return predicate.apply(Multisets.immutableEntry(entry.getKey(), ((Collection) entry.getValue()).size()));
            }

            public final boolean g(final Predicate predicate) {
                return q.this.f(new Predicate() { // from class: om
                    @Override // com.google.common.base.Predicate
                    public final boolean apply(Object obj) {
                        return q.b.a.f(predicate, (Map.Entry) obj);
                    }
                });
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator iterator() {
                return b.this.entryIterator();
            }

            @Override // com.google.common.collect.Multisets.i
            public Multiset multiset() {
                return b.this;
            }

            @Override // com.google.common.collect.Sets.k, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection collection) {
                return g(Predicates.in(collection));
            }

            @Override // com.google.common.collect.Sets.k, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection collection) {
                return g(Predicates.not(Predicates.in(collection)));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return q.this.keySet().size();
            }
        }

        public b() {
            super(q.this);
        }

        @Override // com.google.common.collect.AbstractC1955e, com.google.common.collect.Multiset
        public Set entrySet() {
            return new a();
        }

        @Override // com.google.common.collect.Multimaps.g, com.google.common.collect.AbstractC1955e, com.google.common.collect.Multiset
        public int remove(Object obj, int i) {
            AbstractC1163Zb.b(i, "occurrences");
            if (i == 0) {
                return count(obj);
            }
            Collection collection = (Collection) q.this.a.asMap().get(obj);
            int i2 = 0;
            if (collection == null) {
                return 0;
            }
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (q.this.h(obj, it.next()) && (i2 = i2 + 1) <= i) {
                    it.remove();
                }
            }
            return i2;
        }
    }

    public final class c implements Predicate {
        public final Object a;

        public c(Object obj) {
            this.a = obj;
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(Object obj) {
            return q.this.h(this.a, obj);
        }
    }

    public q(Multimap multimap, Predicate predicate) {
        this.a = (Multimap) Preconditions.checkNotNull(multimap);
        this.b = (Predicate) Preconditions.checkNotNull(predicate);
    }

    public static Collection e(Collection collection, Predicate predicate) {
        return collection instanceof Set ? Sets.filter((Set) collection, predicate) : Collections2.filter(collection, predicate);
    }

    @Override // defpackage.InterfaceC3989tm
    public Multimap a() {
        return this.a;
    }

    @Override // defpackage.InterfaceC3989tm
    public Predicate b() {
        return this.b;
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        entries().clear();
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(Object obj) {
        return asMap().get(obj) != null;
    }

    @Override // com.google.common.collect.AbstractC1954d
    public Map createAsMap() {
        return new a();
    }

    @Override // com.google.common.collect.AbstractC1954d
    public Collection createEntries() {
        return e(this.a.entries(), this.b);
    }

    @Override // com.google.common.collect.AbstractC1954d
    public Set createKeySet() {
        return asMap().keySet();
    }

    @Override // com.google.common.collect.AbstractC1954d
    public Multiset createKeys() {
        return new b();
    }

    @Override // com.google.common.collect.AbstractC1954d
    public Collection createValues() {
        return new C4070um(this);
    }

    @Override // com.google.common.collect.AbstractC1954d
    public Iterator entryIterator() {
        throw new AssertionError("should never be called");
    }

    public boolean f(Predicate predicate) {
        Iterator it = this.a.asMap().entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Collection collectionE = e((Collection) entry.getValue(), new c(key));
            if (!collectionE.isEmpty() && predicate.apply(Maps.immutableEntry(key, collectionE))) {
                if (collectionE.size() == ((Collection) entry.getValue()).size()) {
                    it.remove();
                } else {
                    collectionE.clear();
                }
                z = true;
            }
        }
        return z;
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Collection get(Object obj) {
        return e(this.a.get(obj), new c(obj));
    }

    public final boolean h(Object obj, Object obj2) {
        return this.b.apply(Maps.immutableEntry(obj, obj2));
    }

    public Collection i() {
        return this.a instanceof SetMultimap ? Collections.emptySet() : Collections.emptyList();
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Collection removeAll(Object obj) {
        return (Collection) MoreObjects.firstNonNull((Collection) asMap().remove(obj), i());
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        return entries().size();
    }
}
