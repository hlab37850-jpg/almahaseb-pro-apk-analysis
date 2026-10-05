package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.F;
import com.google.common.collect.Table;
import defpackage.AbstractC0455Es;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class F extends ImmutableTable {

    public final class b extends AbstractC0455Es {
        public b() {
        }

        @Override // defpackage.AbstractC0455Es
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Table.Cell get(int i) {
            return F.this.getCell(i);
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Table.Cell)) {
                return false;
            }
            Table.Cell cell = (Table.Cell) obj;
            Object obj2 = F.this.get(cell.getRowKey(), cell.getColumnKey());
            return obj2 != null && obj2.equals(cell.getValue());
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return F.this.size();
        }
    }

    public final class c extends ImmutableList {
        public c() {
        }

        @Override // java.util.List
        public Object get(int i) {
            return F.this.getValue(i);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return F.this.size();
        }
    }

    public static F c(List list, final Comparator comparator, final Comparator comparator2) {
        Preconditions.checkNotNull(list);
        if (comparator != null || comparator2 != null) {
            Collections.sort(list, new Comparator() { // from class: UJ
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return F.h(comparator, comparator2, (Table.Cell) obj, (Table.Cell) obj2);
                }
            });
        }
        return e(list, comparator, comparator2);
    }

    public static F e(Iterable iterable, Comparator comparator, Comparator comparator2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        ImmutableList immutableListCopyOf = ImmutableList.copyOf(iterable);
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Table.Cell cell = (Table.Cell) it.next();
            linkedHashSet.add(cell.getRowKey());
            linkedHashSet2.add(cell.getColumnKey());
        }
        return f(immutableListCopyOf, comparator == null ? ImmutableSet.copyOf((Collection) linkedHashSet) : ImmutableSet.copyOf((Collection) ImmutableList.sortedCopyOf(comparator, linkedHashSet)), comparator2 == null ? ImmutableSet.copyOf((Collection) linkedHashSet2) : ImmutableSet.copyOf((Collection) ImmutableList.sortedCopyOf(comparator2, linkedHashSet2)));
    }

    public static F f(ImmutableList immutableList, ImmutableSet immutableSet, ImmutableSet immutableSet2) {
        return ((long) immutableList.size()) > (((long) immutableSet.size()) * ((long) immutableSet2.size())) / 2 ? new C1962l(immutableList, immutableSet, immutableSet2) : new K(immutableList, immutableSet, immutableSet2);
    }

    public static /* synthetic */ int h(Comparator comparator, Comparator comparator2, Table.Cell cell, Table.Cell cell2) {
        int iCompare = comparator == null ? 0 : comparator.compare(cell.getRowKey(), cell2.getRowKey());
        if (iCompare != 0) {
            return iCompare;
        }
        if (comparator2 == null) {
            return 0;
        }
        return comparator2.compare(cell.getColumnKey(), cell2.getColumnKey());
    }

    public final void b(Object obj, Object obj2, Object obj3, Object obj4) {
        Preconditions.checkArgument(obj3 == null, "Duplicate key: (row=%s, column=%s), values: [%s, %s].", obj, obj2, obj4, obj3);
    }

    public abstract Table.Cell getCell(int i);

    public abstract Object getValue(int i);

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.AbstractC1960j
    public final ImmutableSet createCellSet() {
        return isEmpty() ? ImmutableSet.of() : new b();
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.AbstractC1960j
    public final ImmutableCollection createValues() {
        return isEmpty() ? ImmutableList.of() : new c();
    }
}
