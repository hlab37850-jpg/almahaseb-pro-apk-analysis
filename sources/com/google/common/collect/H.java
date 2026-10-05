package com.google.common.collect;

import com.google.common.base.Preconditions;

/* JADX INFO: loaded from: classes3.dex */
public class H extends ImmutableTable {
    public final Object a;
    public final Object b;
    public final Object c;

    public H(Object obj, Object obj2, Object obj3) {
        this.a = Preconditions.checkNotNull(obj);
        this.b = Preconditions.checkNotNull(obj2);
        this.c = Preconditions.checkNotNull(obj3);
    }

    @Override // com.google.common.collect.ImmutableTable
    public ImmutableTable.a createSerializedForm() {
        return ImmutableTable.a.a(this, new int[]{0}, new int[]{0});
    }

    @Override // com.google.common.collect.Table
    public int size() {
        return 1;
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public ImmutableMap column(Object obj) {
        Preconditions.checkNotNull(obj);
        return containsColumn(obj) ? ImmutableMap.of(this.a, this.c) : ImmutableMap.of();
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public ImmutableMap columnMap() {
        return ImmutableMap.of(this.b, ImmutableMap.of(this.a, this.c));
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.AbstractC1960j
    public ImmutableSet createCellSet() {
        return ImmutableSet.of(ImmutableTable.cellOf(this.a, this.b, this.c));
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.AbstractC1960j
    public ImmutableCollection createValues() {
        return ImmutableSet.of(this.c);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public ImmutableMap rowMap() {
        return ImmutableMap.of(this.a, ImmutableMap.of(this.b, this.c));
    }

    public H(Table.Cell cell) {
        this(cell.getRowKey(), cell.getColumnKey(), cell.getValue());
    }
}
