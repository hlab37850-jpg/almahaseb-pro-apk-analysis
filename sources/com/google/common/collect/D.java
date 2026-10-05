package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.util.Comparator;

/* JADX INFO: loaded from: classes3.dex */
public final class D extends ImmutableSortedMultiset {
    public static final long[] e = {0};
    public static final ImmutableSortedMultiset f = new D(Ordering.natural());
    public final transient E a;
    public final transient long[] b;
    public final transient int c;
    public final transient int d;

    public D(Comparator comparator) {
        this.a = ImmutableSortedSet.emptySet(comparator);
        this.b = e;
        this.c = 0;
        this.d = 0;
    }

    public final int a(int i) {
        long[] jArr = this.b;
        int i2 = this.c;
        return (int) (jArr[(i2 + i) + 1] - jArr[i2 + i]);
    }

    public ImmutableSortedMultiset b(int i, int i2) {
        Preconditions.checkPositionIndexes(i, i2, this.d);
        if (i == i2) {
            return ImmutableSortedMultiset.emptyMultiset(comparator());
        }
        return (i == 0 && i2 == this.d) ? this : new D(this.a.a(i, i2), this.b, this.c + i, i2 - i);
    }

    @Override // com.google.common.collect.Multiset
    public int count(Object obj) {
        int iIndexOf = this.a.indexOf(obj);
        if (iIndexOf >= 0) {
            return a(iIndexOf);
        }
        return 0;
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return getEntry(0);
    }

    @Override // com.google.common.collect.ImmutableMultiset
    public Multiset.Entry getEntry(int i) {
        return Multisets.immutableEntry(this.a.asList().get(i), a(i));
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return this.c > 0 || this.d < this.b.length - 1;
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return getEntry(this.d - 1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        long[] jArr = this.b;
        int i = this.c;
        return Ints.saturatedCast(jArr[this.d + i] - jArr[i]);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public ImmutableSortedMultiset headMultiset(Object obj, BoundType boundType) {
        return b(0, this.a.b(obj, Preconditions.checkNotNull(boundType) == BoundType.CLOSED));
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public ImmutableSortedMultiset tailMultiset(Object obj, BoundType boundType) {
        return b(this.a.c(obj, Preconditions.checkNotNull(boundType) == BoundType.CLOSED), this.d);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public ImmutableSortedSet elementSet() {
        return this.a;
    }

    public D(E e2, long[] jArr, int i, int i2) {
        this.a = e2;
        this.b = jArr;
        this.c = i;
        this.d = i2;
    }
}
