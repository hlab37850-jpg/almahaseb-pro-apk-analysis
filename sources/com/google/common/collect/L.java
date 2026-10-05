package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes3.dex */
public class L extends M implements RowSortedTable {
    private static final long serialVersionUID = 0;

    public class b extends M.h implements SortedMap {
        public b() {
            super();
        }

        @Override // java.util.SortedMap
        public Comparator comparator() {
            return L.this.f().comparator();
        }

        @Override // com.google.common.collect.Maps.Q
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public SortedSet g() {
            return new Maps.F(this);
        }

        @Override // java.util.SortedMap
        public Object firstKey() {
            return L.this.f().firstKey();
        }

        @Override // com.google.common.collect.Maps.Q, java.util.AbstractMap, java.util.Map, java.util.SortedMap
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public SortedSet keySet() {
            return (SortedSet) super.keySet();
        }

        @Override // java.util.SortedMap
        public SortedMap headMap(Object obj) {
            Preconditions.checkNotNull(obj);
            return new L(L.this.f().headMap(obj), L.this.factory).rowMap();
        }

        @Override // java.util.SortedMap
        public Object lastKey() {
            return L.this.f().lastKey();
        }

        @Override // java.util.SortedMap
        public SortedMap subMap(Object obj, Object obj2) {
            Preconditions.checkNotNull(obj);
            Preconditions.checkNotNull(obj2);
            return new L(L.this.f().subMap(obj, obj2), L.this.factory).rowMap();
        }

        @Override // java.util.SortedMap
        public SortedMap tailMap(Object obj) {
            Preconditions.checkNotNull(obj);
            return new L(L.this.f().tailMap(obj), L.this.factory).rowMap();
        }
    }

    public L(SortedMap sortedMap, Supplier supplier) {
        super(sortedMap, supplier);
    }

    public final SortedMap f() {
        return (SortedMap) this.backingMap;
    }

    @Override // com.google.common.collect.M
    public SortedMap<Object, Map<Object, Object>> createRowMap() {
        return new b();
    }

    @Override // com.google.common.collect.M, com.google.common.collect.Table
    public SortedSet rowKeySet() {
        return (SortedSet) rowMap().keySet();
    }

    @Override // com.google.common.collect.M, com.google.common.collect.Table
    public SortedMap rowMap() {
        return (SortedMap) super.rowMap();
    }
}
