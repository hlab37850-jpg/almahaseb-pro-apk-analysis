package com.google.common.collect;

/* JADX INFO: renamed from: com.google.common.collect.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1963m extends ImmutableSortedMultiset {
    public final transient ImmutableSortedMultiset a;

    public C1963m(ImmutableSortedMultiset immutableSortedMultiset) {
        this.a = immutableSortedMultiset;
    }

    @Override // com.google.common.collect.Multiset
    public int count(Object obj) {
        return this.a.count(obj);
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry firstEntry() {
        return this.a.lastEntry();
    }

    @Override // com.google.common.collect.ImmutableMultiset
    public Multiset.Entry getEntry(int i) {
        return (Multiset.Entry) this.a.entrySet().asList().reverse().get(i);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return this.a.isPartialView();
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry lastEntry() {
        return this.a.firstEntry();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        return this.a.size();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public ImmutableSortedMultiset descendingMultiset() {
        return this.a;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public ImmutableSortedMultiset headMultiset(Object obj, BoundType boundType) {
        return this.a.tailMultiset(obj, boundType).descendingMultiset();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    public ImmutableSortedMultiset tailMultiset(Object obj, BoundType boundType) {
        return this.a.headMultiset(obj, boundType).descendingMultiset();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public ImmutableSortedSet elementSet() {
        return this.a.elementSet().descendingSet();
    }
}
