package com.google.common.collect;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;

/* JADX INFO: renamed from: com.google.common.collect.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1964n extends ForwardingMultiset implements SortedMultiset {
    private transient Comparator<Object> comparator;
    private transient NavigableSet<Object> elementSet;
    private transient Set<Multiset.Entry<Object>> entrySet;

    /* JADX INFO: renamed from: com.google.common.collect.n$a */
    public class a extends Multisets.i {
        public a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return AbstractC1964n.this.entryIterator();
        }

        @Override // com.google.common.collect.Multisets.i
        public Multiset multiset() {
            return AbstractC1964n.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractC1964n.this.forwardMultiset().entrySet().size();
        }
    }

    @Override // com.google.common.collect.SortedMultiset, defpackage.InterfaceC2276gR
    public Comparator<Object> comparator() {
        Comparator<Object> comparator = this.comparator;
        if (comparator != null) {
            return comparator;
        }
        Ordering orderingReverse = Ordering.from(forwardMultiset().comparator()).reverse();
        this.comparator = orderingReverse;
        return orderingReverse;
    }

    public Set<Multiset.Entry<Object>> createEntrySet() {
        return new a();
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<Object> descendingMultiset() {
        return forwardMultiset();
    }

    public abstract Iterator<Multiset.Entry<Object>> entryIterator();

    @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
    public Set<Multiset.Entry<Object>> entrySet() {
        Set<Multiset.Entry<Object>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        Set<Multiset.Entry<Object>> setCreateEntrySet = createEntrySet();
        this.entrySet = setCreateEntrySet;
        return setCreateEntrySet;
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<Object> firstEntry() {
        return forwardMultiset().lastEntry();
    }

    public abstract SortedMultiset forwardMultiset();

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<Object> headMultiset(Object obj, BoundType boundType) {
        return forwardMultiset().tailMultiset(obj, boundType).descendingMultiset();
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable
    public Iterator<Object> iterator() {
        return Multisets.iteratorImpl(this);
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<Object> lastEntry() {
        return forwardMultiset().firstEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<Object> pollFirstEntry() {
        return forwardMultiset().pollLastEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<Object> pollLastEntry() {
        return forwardMultiset().pollFirstEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<Object> subMultiset(Object obj, BoundType boundType, Object obj2, BoundType boundType2) {
        return forwardMultiset().subMultiset(obj2, boundType2, obj, boundType).descendingMultiset();
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<Object> tailMultiset(Object obj, BoundType boundType) {
        return forwardMultiset().headMultiset(obj, boundType).descendingMultiset();
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
    public Object[] toArray() {
        return standardToArray();
    }

    @Override // com.google.common.collect.ForwardingObject
    public String toString() {
        return entrySet().toString();
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) standardToArray(tArr);
    }

    @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public Multiset<Object> delegate() {
        return forwardMultiset();
    }

    @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
    public NavigableSet<Object> elementSet() {
        NavigableSet<Object> navigableSet = this.elementSet;
        if (navigableSet != null) {
            return navigableSet;
        }
        J.b bVar = new J.b(this);
        this.elementSet = bVar;
        return bVar;
    }
}
