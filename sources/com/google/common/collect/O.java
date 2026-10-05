package com.google.common.collect;

import java.util.Comparator;
import java.util.NavigableSet;

/* JADX INFO: loaded from: classes3.dex */
public final class O extends Multisets.m implements SortedMultiset {
    public transient O d;

    public O(SortedMultiset sortedMultiset) {
        super(sortedMultiset);
    }

    @Override // com.google.common.collect.SortedMultiset, defpackage.InterfaceC2276gR
    public Comparator comparator() {
        return delegate().comparator();
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset descendingMultiset() {
        O o = this.d;
        if (o != null) {
            return o;
        }
        O o2 = new O(delegate().descendingMultiset());
        o2.d = this;
        this.d = o2;
        return o2;
    }

    @Override // com.google.common.collect.Multisets.m
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public NavigableSet c() {
        return Sets.unmodifiableNavigableSet(delegate().elementSet());
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry firstEntry() {
        return delegate().firstEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset headMultiset(Object obj, BoundType boundType) {
        return Multisets.unmodifiableSortedMultiset(delegate().headMultiset(obj, boundType));
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry lastEntry() {
        return delegate().lastEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset subMultiset(Object obj, BoundType boundType, Object obj2, BoundType boundType2) {
        return Multisets.unmodifiableSortedMultiset(delegate().subMultiset(obj, boundType, obj2, boundType2));
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset tailMultiset(Object obj, BoundType boundType) {
        return Multisets.unmodifiableSortedMultiset(delegate().tailMultiset(obj, boundType));
    }

    @Override // com.google.common.collect.Multisets.m, com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
    public NavigableSet elementSet() {
        return (NavigableSet) super.elementSet();
    }

    @Override // com.google.common.collect.Multisets.m, com.google.common.collect.ForwardingMultiset, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public SortedMultiset delegate() {
        return (SortedMultiset) super.delegate();
    }
}
