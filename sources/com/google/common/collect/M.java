package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Supplier;
import defpackage.WD;
import defpackage.Y;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class M extends AbstractC1960j implements Serializable {
    private static final long serialVersionUID = 0;
    final Map<Object, Map<Object, Object>> backingMap;
    private transient Set<Object> columnKeySet;
    private transient com.google.common.collect.M.f columnMap;
    final Supplier<? extends Map<Object, Object>> factory;
    private transient Map<Object, Map<Object, Object>> rowMap;

    public class b implements Iterator {
        public final Iterator a;
        public Map.Entry b;
        public Iterator c;

        public b() {
            this.a = M.this.backingMap.entrySet().iterator();
            this.c = Iterators.emptyModifiableIterator();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Table.Cell next() {
            if (!this.c.hasNext()) {
                Map.Entry entry = (Map.Entry) this.a.next();
                this.b = entry;
                this.c = ((Map) entry.getValue()).entrySet().iterator();
            }
            Objects.requireNonNull(this.b);
            Map.Entry entry2 = (Map.Entry) this.c.next();
            return Tables.immutableCell(this.b.getKey(), entry2.getKey(), entry2.getValue());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext() || this.c.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.c.remove();
            Map.Entry entry = this.b;
            Objects.requireNonNull(entry);
            if (((Map) entry.getValue()).isEmpty()) {
                this.a.remove();
                this.b = null;
            }
        }
    }

    public class c extends Maps.Q {
        public final Object d;

        public class a extends Sets.k {
            public a() {
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                c.this.d(Predicates.alwaysTrue());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return M.this.a(entry.getKey(), c.this.d, entry.getValue());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                c cVar = c.this;
                return !M.this.containsColumn(cVar.d);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator iterator() {
                return new b();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return M.this.e(entry.getKey(), c.this.d, entry.getValue());
            }

            @Override // com.google.common.collect.Sets.k, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection collection) {
                return c.this.d(Predicates.not(Predicates.in(collection)));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                Iterator<Map<Object, Object>> it = M.this.backingMap.values().iterator();
                int i = 0;
                while (it.hasNext()) {
                    if (it.next().containsKey(c.this.d)) {
                        i++;
                    }
                }
                return i;
            }
        }

        public class b extends AbstractIterator {
            public final Iterator a;

            public class a extends Y {
                public final /* synthetic */ Map.Entry a;

                public a(Map.Entry entry) {
                    this.a = entry;
                }

                @Override // defpackage.Y, java.util.Map.Entry
                public Object getKey() {
                    return this.a.getKey();
                }

                @Override // defpackage.Y, java.util.Map.Entry
                public Object getValue() {
                    return ((Map) this.a.getValue()).get(c.this.d);
                }

                @Override // defpackage.Y, java.util.Map.Entry
                public Object setValue(Object obj) {
                    return WD.a(((Map) this.a.getValue()).put(c.this.d, Preconditions.checkNotNull(obj)));
                }
            }

            public b() {
                this.a = M.this.backingMap.entrySet().iterator();
            }

            @Override // com.google.common.collect.AbstractIterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry computeNext() {
                while (this.a.hasNext()) {
                    Map.Entry entry = (Map.Entry) this.a.next();
                    if (((Map) entry.getValue()).containsKey(c.this.d)) {
                        return new a(entry);
                    }
                }
                return (Map.Entry) endOfData();
            }
        }

        /* JADX INFO: renamed from: com.google.common.collect.M$c$c, reason: collision with other inner class name */
        public class C0221c extends Maps.A {
            public C0221c() {
                super(c.this);
            }

            @Override // com.google.common.collect.Maps.A, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                c cVar = c.this;
                return M.this.contains(obj, cVar.d);
            }

            @Override // com.google.common.collect.Maps.A, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                c cVar = c.this;
                return M.this.remove(obj, cVar.d) != null;
            }

            @Override // com.google.common.collect.Sets.k, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection collection) {
                return c.this.d(Maps.keyPredicateOnEntries(Predicates.not(Predicates.in(collection))));
            }
        }

        public class d extends Maps.P {
            public d() {
                super(c.this);
            }

            @Override // com.google.common.collect.Maps.P, java.util.AbstractCollection, java.util.Collection
            public boolean remove(Object obj) {
                return obj != null && c.this.d(Maps.valuePredicateOnEntries(Predicates.equalTo(obj)));
            }

            @Override // com.google.common.collect.Maps.P, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection collection) {
                return c.this.d(Maps.valuePredicateOnEntries(Predicates.in(collection)));
            }

            @Override // com.google.common.collect.Maps.P, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection collection) {
                return c.this.d(Maps.valuePredicateOnEntries(Predicates.not(Predicates.in(collection))));
            }
        }

        public c(Object obj) {
            this.d = Preconditions.checkNotNull(obj);
        }

        @Override // com.google.common.collect.Maps.Q
        public Set a() {
            return new a();
        }

        @Override // com.google.common.collect.Maps.Q
        /* JADX INFO: renamed from: b */
        public Set g() {
            return new C0221c();
        }

        @Override // com.google.common.collect.Maps.Q
        public Collection c() {
            return new d();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return M.this.contains(obj, this.d);
        }

        public boolean d(Predicate predicate) {
            Iterator<Map.Entry<Object, Map<Object, Object>>> it = M.this.backingMap.entrySet().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map.Entry<Object, Map<Object, Object>> next = it.next();
                Map<Object, Object> value = next.getValue();
                Object obj = value.get(this.d);
                if (obj != null && predicate.apply(Maps.immutableEntry(next.getKey(), obj))) {
                    value.remove(this.d);
                    if (value.isEmpty()) {
                        it.remove();
                    }
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object get(Object obj) {
            return M.this.get(obj, this.d);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object put(Object obj, Object obj2) {
            return M.this.put(obj, this.d, obj2);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object remove(Object obj) {
            return M.this.remove(obj, this.d);
        }
    }

    public class d extends AbstractIterator {
        public final Map a;
        public final Iterator b;
        public Iterator c;

        public d() {
            this.a = M.this.factory.get();
            this.b = M.this.backingMap.values().iterator();
            this.c = Iterators.emptyIterator();
        }

        @Override // com.google.common.collect.AbstractIterator
        public Object computeNext() {
            while (true) {
                if (this.c.hasNext()) {
                    Map.Entry entry = (Map.Entry) this.c.next();
                    if (!this.a.containsKey(entry.getKey())) {
                        this.a.put(entry.getKey(), entry.getValue());
                        return entry.getKey();
                    }
                } else {
                    if (!this.b.hasNext()) {
                        return endOfData();
                    }
                    this.c = ((Map) this.b.next()).entrySet().iterator();
                }
            }
        }
    }

    public class e extends i {
        public e() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return M.this.containsColumn(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return M.this.createColumnKeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            boolean z = false;
            if (obj == null) {
                return false;
            }
            Iterator<Map<Object, Object>> it = M.this.backingMap.values().iterator();
            while (it.hasNext()) {
                Map<Object, Object> next = it.next();
                if (next.keySet().remove(obj)) {
                    if (next.isEmpty()) {
                        it.remove();
                    }
                    z = true;
                }
            }
            return z;
        }

        @Override // com.google.common.collect.Sets.k, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection collection) {
            Preconditions.checkNotNull(collection);
            Iterator<Map<Object, Object>> it = M.this.backingMap.values().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map<Object, Object> next = it.next();
                if (Iterators.removeAll(next.keySet().iterator(), collection)) {
                    if (next.isEmpty()) {
                        it.remove();
                    }
                    z = true;
                }
            }
            return z;
        }

        @Override // com.google.common.collect.Sets.k, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection collection) {
            Preconditions.checkNotNull(collection);
            Iterator<Map<Object, Object>> it = M.this.backingMap.values().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map<Object, Object> next = it.next();
                if (next.keySet().retainAll(collection)) {
                    if (next.isEmpty()) {
                        it.remove();
                    }
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Iterators.size(iterator());
        }
    }

    public class f extends Maps.Q {

        public class a extends i {

            /* JADX INFO: renamed from: com.google.common.collect.M$f$a$a, reason: collision with other inner class name */
            public class C0222a implements Function {
                public C0222a() {
                }

                @Override // com.google.common.base.Function
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Map apply(Object obj) {
                    return M.this.column(obj);
                }
            }

            public a() {
                super();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                if (!M.this.containsColumn(entry.getKey())) {
                    return false;
                }
                Map map = f.this.get(entry.getKey());
                Objects.requireNonNull(map);
                return map.equals(entry.getValue());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator iterator() {
                return Maps.asMapEntryIterator(M.this.columnKeySet(), new C0222a());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!contains(obj) || !(obj instanceof Map.Entry)) {
                    return false;
                }
                M.this.c(((Map.Entry) obj).getKey());
                return true;
            }

            @Override // com.google.common.collect.Sets.k, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection collection) {
                Preconditions.checkNotNull(collection);
                return Sets.removeAllImpl(this, (Iterator<?>) collection.iterator());
            }

            @Override // com.google.common.collect.Sets.k, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection collection) {
                Preconditions.checkNotNull(collection);
                boolean z = false;
                for (Object obj : Lists.newArrayList(M.this.columnKeySet().iterator())) {
                    if (!collection.contains(Maps.immutableEntry(obj, M.this.column(obj)))) {
                        M.this.c(obj);
                        z = true;
                    }
                }
                return z;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return M.this.columnKeySet().size();
            }
        }

        public class b extends Maps.P {
            public b() {
                super(f.this);
            }

            @Override // com.google.common.collect.Maps.P, java.util.AbstractCollection, java.util.Collection
            public boolean remove(Object obj) {
                for (Map.Entry entry : f.this.entrySet()) {
                    if (((Map) entry.getValue()).equals(obj)) {
                        M.this.c(entry.getKey());
                        return true;
                    }
                }
                return false;
            }

            @Override // com.google.common.collect.Maps.P, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection collection) {
                Preconditions.checkNotNull(collection);
                boolean z = false;
                for (Object obj : Lists.newArrayList(M.this.columnKeySet().iterator())) {
                    if (collection.contains(M.this.column(obj))) {
                        M.this.c(obj);
                        z = true;
                    }
                }
                return z;
            }

            @Override // com.google.common.collect.Maps.P, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection collection) {
                Preconditions.checkNotNull(collection);
                boolean z = false;
                for (Object obj : Lists.newArrayList(M.this.columnKeySet().iterator())) {
                    if (!collection.contains(M.this.column(obj))) {
                        M.this.c(obj);
                        z = true;
                    }
                }
                return z;
            }
        }

        public f() {
        }

        @Override // com.google.common.collect.Maps.Q
        public Set a() {
            return new a();
        }

        @Override // com.google.common.collect.Maps.Q
        public Collection c() {
            return new b();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return M.this.containsColumn(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map get(Object obj) {
            if (!M.this.containsColumn(obj)) {
                return null;
            }
            M m = M.this;
            Objects.requireNonNull(obj);
            return m.column(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Map remove(Object obj) {
            if (M.this.containsColumn(obj)) {
                return M.this.c(obj);
            }
            return null;
        }

        @Override // com.google.common.collect.Maps.Q, java.util.AbstractMap, java.util.Map, java.util.SortedMap
        public Set keySet() {
            return M.this.columnKeySet();
        }
    }

    public class g extends Maps.z {
        public final Object a;
        public Map b;

        public class a implements Iterator {
            public final /* synthetic */ Iterator a;

            public a(Iterator it) {
                this.a = it;
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry next() {
                return g.this.e((Map.Entry) this.a.next());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.a.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.a.remove();
                g.this.c();
            }
        }

        public class b extends ForwardingMapEntry {
            public final /* synthetic */ Map.Entry a;

            public b(g gVar, Map.Entry entry) {
                this.a = entry;
            }

            @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
            public boolean equals(Object obj) {
                return standardEquals(obj);
            }

            @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
            public Object setValue(Object obj) {
                return super.setValue(Preconditions.checkNotNull(obj));
            }

            @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
            public Map.Entry delegate() {
                return this.a;
            }
        }

        public g(Object obj) {
            this.a = Preconditions.checkNotNull(obj);
        }

        @Override // com.google.common.collect.Maps.z
        public Iterator a() {
            d();
            Map map = this.b;
            return map == null ? Iterators.emptyModifiableIterator() : new a(map.entrySet().iterator());
        }

        public Map b() {
            return M.this.backingMap.get(this.a);
        }

        public void c() {
            d();
            Map map = this.b;
            if (map == null || !map.isEmpty()) {
                return;
            }
            M.this.backingMap.remove(this.a);
            this.b = null;
        }

        @Override // com.google.common.collect.Maps.z, java.util.AbstractMap, java.util.Map
        public void clear() {
            d();
            Map map = this.b;
            if (map != null) {
                map.clear();
            }
            c();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            Map map;
            d();
            return (obj == null || (map = this.b) == null || !Maps.safeContainsKey(map, obj)) ? false : true;
        }

        public final void d() {
            Map map = this.b;
            if (map == null || (map.isEmpty() && M.this.backingMap.containsKey(this.a))) {
                this.b = b();
            }
        }

        public Map.Entry e(Map.Entry entry) {
            return new b(this, entry);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object get(Object obj) {
            Map map;
            d();
            if (obj == null || (map = this.b) == null) {
                return null;
            }
            return Maps.safeGet(map, obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object put(Object obj, Object obj2) {
            Preconditions.checkNotNull(obj);
            Preconditions.checkNotNull(obj2);
            Map map = this.b;
            return (map == null || map.isEmpty()) ? M.this.put(this.a, obj, obj2) : this.b.put(obj, obj2);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object remove(Object obj) {
            d();
            Map map = this.b;
            if (map == null) {
                return null;
            }
            Object objSafeRemove = Maps.safeRemove(map, obj);
            c();
            return objSafeRemove;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            d();
            Map map = this.b;
            if (map == null) {
                return 0;
            }
            return map.size();
        }
    }

    public class h extends Maps.Q {

        public class a extends i {

            /* JADX INFO: renamed from: com.google.common.collect.M$h$a$a, reason: collision with other inner class name */
            public class C0223a implements Function {
                public C0223a() {
                }

                @Override // com.google.common.base.Function
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Map apply(Object obj) {
                    return M.this.row(obj);
                }
            }

            public a() {
                super();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return entry.getKey() != null && (entry.getValue() instanceof Map) && Collections2.safeContains(M.this.backingMap.entrySet(), entry);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator iterator() {
                return Maps.asMapEntryIterator(M.this.backingMap.keySet(), new C0223a());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return entry.getKey() != null && (entry.getValue() instanceof Map) && M.this.backingMap.entrySet().remove(entry);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return M.this.backingMap.size();
            }
        }

        public h() {
        }

        @Override // com.google.common.collect.Maps.Q
        public Set a() {
            return new a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return M.this.containsRow(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map get(Object obj) {
            if (!M.this.containsRow(obj)) {
                return null;
            }
            M m = M.this;
            Objects.requireNonNull(obj);
            return m.row(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Map remove(Object obj) {
            if (obj == null) {
                return null;
            }
            return M.this.backingMap.remove(obj);
        }
    }

    public abstract class i extends Sets.k {
        public i() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            M.this.backingMap.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return M.this.backingMap.isEmpty();
        }
    }

    public M(Map map, Supplier supplier) {
        this.backingMap = map;
        this.factory = supplier;
    }

    public final boolean a(Object obj, Object obj2, Object obj3) {
        return obj3 != null && obj3.equals(get(obj, obj2));
    }

    public final Map b(Object obj) {
        Map<Object, Object> map = this.backingMap.get(obj);
        if (map != null) {
            return map;
        }
        Map<Object, Object> map2 = this.factory.get();
        this.backingMap.put(obj, map2);
        return map2;
    }

    public final Map c(Object obj) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<Object, Map<Object, Object>>> it = this.backingMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Object, Map<Object, Object>> next = it.next();
            Object objRemove = next.getValue().remove(obj);
            if (objRemove != null) {
                linkedHashMap.put(next.getKey(), objRemove);
                if (next.getValue().isEmpty()) {
                    it.remove();
                }
            }
        }
        return linkedHashMap;
    }

    @Override // com.google.common.collect.AbstractC1960j
    public Iterator<Table.Cell<Object, Object, Object>> cellIterator() {
        return new b();
    }

    @Override // com.google.common.collect.AbstractC1960j, com.google.common.collect.Table
    public Set cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.AbstractC1960j, com.google.common.collect.Table
    public void clear() {
        this.backingMap.clear();
    }

    @Override // com.google.common.collect.Table
    public Map column(Object obj) {
        return new c(obj);
    }

    @Override // com.google.common.collect.Table
    public Set columnKeySet() {
        Set<Object> set = this.columnKeySet;
        if (set != null) {
            return set;
        }
        e eVar = new e();
        this.columnKeySet = eVar;
        return eVar;
    }

    @Override // com.google.common.collect.Table
    public Map columnMap() {
        com.google.common.collect.M.f fVar = this.columnMap;
        if (fVar != null) {
            return fVar;
        }
        f fVar2 = new f();
        this.columnMap = fVar2;
        return fVar2;
    }

    @Override // com.google.common.collect.AbstractC1960j, com.google.common.collect.Table
    public boolean contains(Object obj, Object obj2) {
        return (obj == null || obj2 == null || !super.contains(obj, obj2)) ? false : true;
    }

    @Override // com.google.common.collect.AbstractC1960j, com.google.common.collect.Table
    public boolean containsColumn(Object obj) {
        if (obj == null) {
            return false;
        }
        Iterator<Map<Object, Object>> it = this.backingMap.values().iterator();
        while (it.hasNext()) {
            if (Maps.safeContainsKey(it.next(), obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.common.collect.AbstractC1960j, com.google.common.collect.Table
    public boolean containsRow(Object obj) {
        return obj != null && Maps.safeContainsKey(this.backingMap, obj);
    }

    @Override // com.google.common.collect.AbstractC1960j, com.google.common.collect.Table
    public boolean containsValue(Object obj) {
        return obj != null && super.containsValue(obj);
    }

    public Iterator<Object> createColumnKeyIterator() {
        return new d();
    }

    public Map<Object, Map<Object, Object>> createRowMap() {
        return new h();
    }

    public final boolean e(Object obj, Object obj2, Object obj3) {
        if (!a(obj, obj2, obj3)) {
            return false;
        }
        remove(obj, obj2);
        return true;
    }

    @Override // com.google.common.collect.AbstractC1960j, com.google.common.collect.Table
    public Object get(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return null;
        }
        return super.get(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractC1960j, com.google.common.collect.Table
    public boolean isEmpty() {
        return this.backingMap.isEmpty();
    }

    @Override // com.google.common.collect.AbstractC1960j, com.google.common.collect.Table
    public Object put(Object obj, Object obj2, Object obj3) {
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(obj2);
        Preconditions.checkNotNull(obj3);
        return b(obj).put(obj2, obj3);
    }

    @Override // com.google.common.collect.Table
    public Object remove(Object obj, Object obj2) {
        Map map;
        if (obj == null || obj2 == null || (map = (Map) Maps.safeGet(this.backingMap, obj)) == null) {
            return null;
        }
        Object objRemove = map.remove(obj2);
        if (map.isEmpty()) {
            this.backingMap.remove(obj);
        }
        return objRemove;
    }

    @Override // com.google.common.collect.Table
    public Map row(Object obj) {
        return new g(obj);
    }

    @Override // com.google.common.collect.Table
    public Set rowKeySet() {
        return rowMap().keySet();
    }

    @Override // com.google.common.collect.Table
    public Map rowMap() {
        Map<Object, Map<Object, Object>> map = this.rowMap;
        if (map != null) {
            return map;
        }
        Map<Object, Map<Object, Object>> mapCreateRowMap = createRowMap();
        this.rowMap = mapCreateRowMap;
        return mapCreateRowMap;
    }

    @Override // com.google.common.collect.Table
    public int size() {
        Iterator<Map<Object, Object>> it = this.backingMap.values().iterator();
        int size = 0;
        while (it.hasNext()) {
            size += it.next().size();
        }
        return size;
    }

    @Override // com.google.common.collect.AbstractC1960j, com.google.common.collect.Table
    public Collection values() {
        return super.values();
    }
}
