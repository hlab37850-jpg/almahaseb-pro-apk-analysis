package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import defpackage.WD;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public final class Tables {
    private static final Function<? extends Map<?, ?>, ? extends Map<?, ?>> UNMODIFIABLE_WRAPPER = new a();

    public class a implements Function {
        @Override // com.google.common.base.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map apply(Map map) {
            return Collections.unmodifiableMap(map);
        }
    }

    public static abstract class b implements Table.Cell {
        @Override // com.google.common.collect.Table.Cell
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Table.Cell)) {
                return false;
            }
            Table.Cell cell = (Table.Cell) obj;
            return Objects.equal(getRowKey(), cell.getRowKey()) && Objects.equal(getColumnKey(), cell.getColumnKey()) && Objects.equal(getValue(), cell.getValue());
        }

        @Override // com.google.common.collect.Table.Cell
        public int hashCode() {
            return Objects.hashCode(getRowKey(), getColumnKey(), getValue());
        }

        public String toString() {
            String strValueOf = String.valueOf(getRowKey());
            String strValueOf2 = String.valueOf(getColumnKey());
            String strValueOf3 = String.valueOf(getValue());
            StringBuilder sb = new StringBuilder(strValueOf.length() + 4 + strValueOf2.length() + strValueOf3.length());
            sb.append("(");
            sb.append(strValueOf);
            sb.append(",");
            sb.append(strValueOf2);
            sb.append(")=");
            sb.append(strValueOf3);
            return sb.toString();
        }
    }

    public static final class c extends b implements Serializable {
        public final Object a;
        public final Object b;
        public final Object c;

        public c(Object obj, Object obj2, Object obj3) {
            this.a = obj;
            this.b = obj2;
            this.c = obj3;
        }

        @Override // com.google.common.collect.Table.Cell
        public Object getColumnKey() {
            return this.b;
        }

        @Override // com.google.common.collect.Table.Cell
        public Object getRowKey() {
            return this.a;
        }

        @Override // com.google.common.collect.Table.Cell
        public Object getValue() {
            return this.c;
        }
    }

    public static class d extends AbstractC1960j {
        public final Table a;
        public final Function b;

        public class a implements Function {
            public a() {
            }

            @Override // com.google.common.base.Function
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Table.Cell apply(Table.Cell cell) {
                return Tables.immutableCell(cell.getRowKey(), cell.getColumnKey(), d.this.b.apply(cell.getValue()));
            }
        }

        public class b implements Function {
            public b() {
            }

            @Override // com.google.common.base.Function
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map apply(Map map) {
                return Maps.transformValues(map, d.this.b);
            }
        }

        public class c implements Function {
            public c() {
            }

            @Override // com.google.common.base.Function
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map apply(Map map) {
                return Maps.transformValues(map, d.this.b);
            }
        }

        public d(Table table, Function function) {
            this.a = (Table) Preconditions.checkNotNull(table);
            this.b = (Function) Preconditions.checkNotNull(function);
        }

        public Function a() {
            return new a();
        }

        @Override // com.google.common.collect.AbstractC1960j
        public Iterator cellIterator() {
            return Iterators.transform(this.a.cellSet().iterator(), a());
        }

        @Override // com.google.common.collect.AbstractC1960j, com.google.common.collect.Table
        public void clear() {
            this.a.clear();
        }

        @Override // com.google.common.collect.Table
        public Map column(Object obj) {
            return Maps.transformValues(this.a.column(obj), this.b);
        }

        @Override // com.google.common.collect.Table
        public Set columnKeySet() {
            return this.a.columnKeySet();
        }

        @Override // com.google.common.collect.Table
        public Map columnMap() {
            return Maps.transformValues(this.a.columnMap(), new c());
        }

        @Override // com.google.common.collect.AbstractC1960j, com.google.common.collect.Table
        public boolean contains(Object obj, Object obj2) {
            return this.a.contains(obj, obj2);
        }

        @Override // com.google.common.collect.AbstractC1960j
        public Collection createValues() {
            return Collections2.transform(this.a.values(), this.b);
        }

        @Override // com.google.common.collect.AbstractC1960j, com.google.common.collect.Table
        public Object get(Object obj, Object obj2) {
            if (contains(obj, obj2)) {
                return this.b.apply(WD.a(this.a.get(obj, obj2)));
            }
            return null;
        }

        @Override // com.google.common.collect.AbstractC1960j, com.google.common.collect.Table
        public Object put(Object obj, Object obj2, Object obj3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.AbstractC1960j, com.google.common.collect.Table
        public void putAll(Table table) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Table
        public Object remove(Object obj, Object obj2) {
            if (contains(obj, obj2)) {
                return this.b.apply(WD.a(this.a.remove(obj, obj2)));
            }
            return null;
        }

        @Override // com.google.common.collect.Table
        public Map row(Object obj) {
            return Maps.transformValues(this.a.row(obj), this.b);
        }

        @Override // com.google.common.collect.Table
        public Set rowKeySet() {
            return this.a.rowKeySet();
        }

        @Override // com.google.common.collect.Table
        public Map rowMap() {
            return Maps.transformValues(this.a.rowMap(), new b());
        }

        @Override // com.google.common.collect.Table
        public int size() {
            return this.a.size();
        }
    }

    public static class e extends AbstractC1960j {
        public static final Function b = new a();
        public final Table a;

        public class a implements Function {
            @Override // com.google.common.base.Function
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Table.Cell apply(Table.Cell cell) {
                return Tables.immutableCell(cell.getColumnKey(), cell.getRowKey(), cell.getValue());
            }
        }

        public e(Table table) {
            this.a = (Table) Preconditions.checkNotNull(table);
        }

        @Override // com.google.common.collect.AbstractC1960j
        public Iterator cellIterator() {
            return Iterators.transform(this.a.cellSet().iterator(), b);
        }

        @Override // com.google.common.collect.AbstractC1960j, com.google.common.collect.Table
        public void clear() {
            this.a.clear();
        }

        @Override // com.google.common.collect.Table
        public Map column(Object obj) {
            return this.a.row(obj);
        }

        @Override // com.google.common.collect.Table
        public Set columnKeySet() {
            return this.a.rowKeySet();
        }

        @Override // com.google.common.collect.Table
        public Map columnMap() {
            return this.a.rowMap();
        }

        @Override // com.google.common.collect.AbstractC1960j, com.google.common.collect.Table
        public boolean contains(Object obj, Object obj2) {
            return this.a.contains(obj2, obj);
        }

        @Override // com.google.common.collect.AbstractC1960j, com.google.common.collect.Table
        public boolean containsColumn(Object obj) {
            return this.a.containsRow(obj);
        }

        @Override // com.google.common.collect.AbstractC1960j, com.google.common.collect.Table
        public boolean containsRow(Object obj) {
            return this.a.containsColumn(obj);
        }

        @Override // com.google.common.collect.AbstractC1960j, com.google.common.collect.Table
        public boolean containsValue(Object obj) {
            return this.a.containsValue(obj);
        }

        @Override // com.google.common.collect.AbstractC1960j, com.google.common.collect.Table
        public Object get(Object obj, Object obj2) {
            return this.a.get(obj2, obj);
        }

        @Override // com.google.common.collect.AbstractC1960j, com.google.common.collect.Table
        public Object put(Object obj, Object obj2, Object obj3) {
            return this.a.put(obj2, obj, obj3);
        }

        @Override // com.google.common.collect.AbstractC1960j, com.google.common.collect.Table
        public void putAll(Table table) {
            this.a.putAll(Tables.transpose(table));
        }

        @Override // com.google.common.collect.Table
        public Object remove(Object obj, Object obj2) {
            return this.a.remove(obj2, obj);
        }

        @Override // com.google.common.collect.Table
        public Map row(Object obj) {
            return this.a.column(obj);
        }

        @Override // com.google.common.collect.Table
        public Set rowKeySet() {
            return this.a.columnKeySet();
        }

        @Override // com.google.common.collect.Table
        public Map rowMap() {
            return this.a.columnMap();
        }

        @Override // com.google.common.collect.Table
        public int size() {
            return this.a.size();
        }

        @Override // com.google.common.collect.AbstractC1960j, com.google.common.collect.Table
        public Collection values() {
            return this.a.values();
        }
    }

    public static final class f extends g implements RowSortedTable {
        public f(RowSortedTable rowSortedTable) {
            super(rowSortedTable);
        }

        @Override // com.google.common.collect.Tables.g, com.google.common.collect.ForwardingTable, com.google.common.collect.ForwardingObject
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public RowSortedTable delegate() {
            return (RowSortedTable) super.delegate();
        }

        @Override // com.google.common.collect.Tables.g, com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public SortedSet rowKeySet() {
            return Collections.unmodifiableSortedSet(delegate().rowKeySet());
        }

        @Override // com.google.common.collect.Tables.g, com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public SortedMap rowMap() {
            return Collections.unmodifiableSortedMap(Maps.transformValues(delegate().rowMap(), Tables.unmodifiableWrapper()));
        }
    }

    public static class g extends ForwardingTable implements Serializable {
        public final Table a;

        public g(Table table) {
            this.a = (Table) Preconditions.checkNotNull(table);
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public Set cellSet() {
            return Collections.unmodifiableSet(super.cellSet());
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public Map column(Object obj) {
            return Collections.unmodifiableMap(super.column(obj));
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public Set columnKeySet() {
            return Collections.unmodifiableSet(super.columnKeySet());
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public Map columnMap() {
            return Collections.unmodifiableMap(Maps.transformValues(super.columnMap(), Tables.unmodifiableWrapper()));
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public Object put(Object obj, Object obj2, Object obj3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public void putAll(Table table) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public Object remove(Object obj, Object obj2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public Map row(Object obj) {
            return Collections.unmodifiableMap(super.row(obj));
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public Set rowKeySet() {
            return Collections.unmodifiableSet(super.rowKeySet());
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public Map rowMap() {
            return Collections.unmodifiableMap(Maps.transformValues(super.rowMap(), Tables.unmodifiableWrapper()));
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.Table
        public Collection values() {
            return Collections.unmodifiableCollection(super.values());
        }

        @Override // com.google.common.collect.ForwardingTable, com.google.common.collect.ForwardingObject
        public Table delegate() {
            return this.a;
        }
    }

    private Tables() {
    }

    public static boolean equalsImpl(Table<?, ?, ?> table, Object obj) {
        if (obj == table) {
            return true;
        }
        if (obj instanceof Table) {
            return table.cellSet().equals(((Table) obj).cellSet());
        }
        return false;
    }

    public static <R, C, V> Table.Cell<R, C, V> immutableCell(R r, C c2, V v) {
        return new c(r, c2, v);
    }

    @Beta
    public static <R, C, V> Table<R, C, V> newCustomTable(Map<R, Map<C, V>> map, Supplier<? extends Map<C, V>> supplier) {
        Preconditions.checkArgument(map.isEmpty());
        Preconditions.checkNotNull(supplier);
        return new M(map, supplier);
    }

    public static <R, C, V> Table<R, C, V> synchronizedTable(Table<R, C, V> table) {
        return N.y(table, null);
    }

    @Beta
    public static <R, C, V1, V2> Table<R, C, V2> transformValues(Table<R, C, V1> table, Function<? super V1, V2> function) {
        return new d(table, function);
    }

    public static <R, C, V> Table<C, R, V> transpose(Table<R, C, V> table) {
        return table instanceof e ? ((e) table).a : new e(table);
    }

    @Beta
    public static <R, C, V> RowSortedTable<R, C, V> unmodifiableRowSortedTable(RowSortedTable<R, ? extends C, ? extends V> rowSortedTable) {
        return new f(rowSortedTable);
    }

    public static <R, C, V> Table<R, C, V> unmodifiableTable(Table<? extends R, ? extends C, ? extends V> table) {
        return new g(table);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> Function<Map<K, V>, Map<K, V>> unmodifiableWrapper() {
        return (Function<Map<K, V>, Map<K, V>>) UNMODIFIABLE_WRAPPER;
    }
}
