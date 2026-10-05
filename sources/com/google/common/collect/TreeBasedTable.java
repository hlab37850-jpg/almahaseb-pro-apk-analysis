package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.TreeBasedTable;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(serializable = true)
public class TreeBasedTable<R, C, V> extends L {
    private static final long serialVersionUID = 0;
    private final Comparator<? super C> columnComparator;

    public class a extends AbstractIterator {
        public Object a;
        public final /* synthetic */ Iterator b;
        public final /* synthetic */ Comparator c;

        public a(TreeBasedTable treeBasedTable, Iterator it, Comparator comparator) {
            this.b = it;
            this.c = comparator;
        }

        @Override // com.google.common.collect.AbstractIterator
        public Object computeNext() {
            while (this.b.hasNext()) {
                Object next = this.b.next();
                Object obj = this.a;
                if (obj == null || this.c.compare(next, obj) != 0) {
                    this.a = next;
                    return next;
                }
            }
            this.a = null;
            return endOfData();
        }
    }

    public static class b implements Supplier, Serializable {
        public final Comparator a;

        public b(Comparator comparator) {
            this.a = comparator;
        }

        @Override // com.google.common.base.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TreeMap get() {
            return new TreeMap(this.a);
        }
    }

    public class c extends M.g implements SortedMap {
        public final Object d;
        public final Object e;
        public transient SortedMap f;

        public c(TreeBasedTable treeBasedTable, Object obj) {
            this(obj, null, null);
        }

        @Override // com.google.common.collect.M.g
        public void c() {
            k();
            SortedMap sortedMap = this.f;
            if (sortedMap == null || !sortedMap.isEmpty()) {
                return;
            }
            TreeBasedTable.this.backingMap.remove(this.a);
            this.f = null;
            this.b = null;
        }

        @Override // java.util.SortedMap
        public Comparator comparator() {
            return TreeBasedTable.this.columnComparator();
        }

        @Override // com.google.common.collect.M.g, java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return j(obj) && super.containsKey(obj);
        }

        public int f(Object obj, Object obj2) {
            return comparator().compare(obj, obj2);
        }

        @Override // java.util.SortedMap
        public Object firstKey() {
            d();
            Map map = this.b;
            if (map != null) {
                return ((SortedMap) map).firstKey();
            }
            throw new NoSuchElementException();
        }

        @Override // com.google.common.collect.M.g
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public SortedMap b() {
            k();
            SortedMap sortedMapTailMap = this.f;
            if (sortedMapTailMap == null) {
                return null;
            }
            Object obj = this.d;
            if (obj != null) {
                sortedMapTailMap = sortedMapTailMap.tailMap(obj);
            }
            Object obj2 = this.e;
            return obj2 != null ? sortedMapTailMap.headMap(obj2) : sortedMapTailMap;
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public SortedSet keySet() {
            return new Maps.F(this);
        }

        @Override // java.util.SortedMap
        public SortedMap headMap(Object obj) {
            Preconditions.checkArgument(j(Preconditions.checkNotNull(obj)));
            return new c(this.a, this.d, obj);
        }

        public boolean j(Object obj) {
            Object obj2;
            Object obj3;
            return obj != null && ((obj2 = this.d) == null || f(obj2, obj) <= 0) && ((obj3 = this.e) == null || f(obj3, obj) > 0);
        }

        public void k() {
            SortedMap sortedMap = this.f;
            if (sortedMap == null || (sortedMap.isEmpty() && TreeBasedTable.this.backingMap.containsKey(this.a))) {
                this.f = (SortedMap) TreeBasedTable.this.backingMap.get(this.a);
            }
        }

        @Override // java.util.SortedMap
        public Object lastKey() {
            d();
            Map map = this.b;
            if (map != null) {
                return ((SortedMap) map).lastKey();
            }
            throw new NoSuchElementException();
        }

        @Override // com.google.common.collect.M.g, java.util.AbstractMap, java.util.Map
        public Object put(Object obj, Object obj2) {
            Preconditions.checkArgument(j(Preconditions.checkNotNull(obj)));
            return super.put(obj, obj2);
        }

        @Override // java.util.SortedMap
        public SortedMap subMap(Object obj, Object obj2) {
            Preconditions.checkArgument(j(Preconditions.checkNotNull(obj)) && j(Preconditions.checkNotNull(obj2)));
            return new c(this.a, obj, obj2);
        }

        @Override // java.util.SortedMap
        public SortedMap tailMap(Object obj) {
            Preconditions.checkArgument(j(Preconditions.checkNotNull(obj)));
            return new c(this.a, obj, this.e);
        }

        public c(Object obj, Object obj2, Object obj3) {
            super(obj);
            this.d = obj2;
            this.e = obj3;
            Preconditions.checkArgument(obj2 == null || obj3 == null || f(obj2, obj3) <= 0);
        }
    }

    public TreeBasedTable(Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        super(new TreeMap(comparator), new b(comparator2));
        this.columnComparator = comparator2;
    }

    public static <R extends Comparable, C extends Comparable, V> TreeBasedTable<R, C, V> create() {
        return new TreeBasedTable<>(Ordering.natural(), Ordering.natural());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Iterator lambda$createColumnKeyIterator$0(Map map) {
        return map.keySet().iterator();
    }

    @Override // com.google.common.collect.M, com.google.common.collect.AbstractC1960j, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Set cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.M, com.google.common.collect.AbstractC1960j, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.M, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Map column(Object obj) {
        return super.column(obj);
    }

    @Deprecated
    public Comparator<? super C> columnComparator() {
        return this.columnComparator;
    }

    @Override // com.google.common.collect.M, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Set columnKeySet() {
        return super.columnKeySet();
    }

    @Override // com.google.common.collect.M, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Map columnMap() {
        return super.columnMap();
    }

    @Override // com.google.common.collect.M, com.google.common.collect.AbstractC1960j, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean contains(Object obj, Object obj2) {
        return super.contains(obj, obj2);
    }

    @Override // com.google.common.collect.M, com.google.common.collect.AbstractC1960j, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean containsColumn(Object obj) {
        return super.containsColumn(obj);
    }

    @Override // com.google.common.collect.M, com.google.common.collect.AbstractC1960j, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean containsRow(Object obj) {
        return super.containsRow(obj);
    }

    @Override // com.google.common.collect.M, com.google.common.collect.AbstractC1960j, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.common.collect.M
    public Iterator<C> createColumnKeyIterator() {
        Comparator<? super C> comparatorColumnComparator = columnComparator();
        return new a(this, Iterators.mergeSorted(Iterables.transform(this.backingMap.values(), new Function() { // from class: BV
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return TreeBasedTable.lambda$createColumnKeyIterator$0((Map) obj);
            }
        }), comparatorColumnComparator), comparatorColumnComparator);
    }

    @Override // com.google.common.collect.AbstractC1960j, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.M, com.google.common.collect.AbstractC1960j, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Object get(Object obj, Object obj2) {
        return super.get(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractC1960j, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.M, com.google.common.collect.AbstractC1960j, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.M, com.google.common.collect.AbstractC1960j, com.google.common.collect.Table
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2, Object obj3) {
        return super.put(obj, obj2, obj3);
    }

    @Override // com.google.common.collect.AbstractC1960j, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ void putAll(Table table) {
        super.putAll(table);
    }

    @Override // com.google.common.collect.M, com.google.common.collect.Table
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ Object remove(Object obj, Object obj2) {
        return super.remove(obj, obj2);
    }

    @Deprecated
    public Comparator<? super R> rowComparator() {
        Comparator<? super R> comparator = rowKeySet().comparator();
        Objects.requireNonNull(comparator);
        return comparator;
    }

    @Override // com.google.common.collect.M, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.AbstractC1960j
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.M, com.google.common.collect.AbstractC1960j, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    public static <R, C, V> TreeBasedTable<R, C, V> create(Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        Preconditions.checkNotNull(comparator);
        Preconditions.checkNotNull(comparator2);
        return new TreeBasedTable<>(comparator, comparator2);
    }

    @Override // com.google.common.collect.M, com.google.common.collect.Table
    public SortedMap<C, V> row(R r) {
        return new c(this, r);
    }

    @Override // com.google.common.collect.L, com.google.common.collect.M, com.google.common.collect.Table
    public SortedSet<R> rowKeySet() {
        return super.rowKeySet();
    }

    @Override // com.google.common.collect.L, com.google.common.collect.M, com.google.common.collect.Table
    public SortedMap<R, Map<C, V>> rowMap() {
        return super.rowMap();
    }

    public static <R, C, V> TreeBasedTable<R, C, V> create(TreeBasedTable<R, C, ? extends V> treeBasedTable) {
        TreeBasedTable<R, C, V> treeBasedTable2 = new TreeBasedTable<>(treeBasedTable.rowComparator(), treeBasedTable.columnComparator());
        treeBasedTable2.putAll(treeBasedTable);
        return treeBasedTable2;
    }
}
