package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;

/* JADX INFO: renamed from: com.google.common.collect.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1958h extends AbstractC1955e implements SortedMultiset {
    final Comparator<Object> comparator;
    private transient SortedMultiset<Object> descendingMultiset;

    /* JADX INFO: renamed from: com.google.common.collect.h$a */
    public class a extends AbstractC1964n {
        public a() {
        }

        @Override // com.google.common.collect.AbstractC1964n
        public Iterator entryIterator() {
            return AbstractC1958h.this.descendingEntryIterator();
        }

        @Override // com.google.common.collect.AbstractC1964n
        public SortedMultiset forwardMultiset() {
            return AbstractC1958h.this;
        }

        @Override // com.google.common.collect.AbstractC1964n, com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return AbstractC1958h.this.descendingIterator();
        }
    }

    public AbstractC1958h() {
        this(Ordering.natural());
    }

    public Comparator comparator() {
        return this.comparator;
    }

    public SortedMultiset<Object> createDescendingMultiset() {
        return new a();
    }

    public abstract Iterator descendingEntryIterator();

    public Iterator<Object> descendingIterator() {
        return Multisets.iteratorImpl(descendingMultiset());
    }

    public SortedMultiset descendingMultiset() {
        SortedMultiset<Object> sortedMultiset = this.descendingMultiset;
        if (sortedMultiset != null) {
            return sortedMultiset;
        }
        SortedMultiset<Object> sortedMultisetCreateDescendingMultiset = createDescendingMultiset();
        this.descendingMultiset = sortedMultisetCreateDescendingMultiset;
        return sortedMultisetCreateDescendingMultiset;
    }

    public Multiset.Entry firstEntry() {
        Iterator itEntryIterator = entryIterator();
        if (itEntryIterator.hasNext()) {
            return (Multiset.Entry) itEntryIterator.next();
        }
        return null;
    }

    public Multiset.Entry lastEntry() {
        Iterator itDescendingEntryIterator = descendingEntryIterator();
        if (itDescendingEntryIterator.hasNext()) {
            return (Multiset.Entry) itDescendingEntryIterator.next();
        }
        return null;
    }

    public Multiset.Entry pollFirstEntry() {
        Iterator itEntryIterator = entryIterator();
        if (!itEntryIterator.hasNext()) {
            return null;
        }
        Multiset.Entry entry = (Multiset.Entry) itEntryIterator.next();
        Multiset.Entry entryImmutableEntry = Multisets.immutableEntry(entry.getElement(), entry.getCount());
        itEntryIterator.remove();
        return entryImmutableEntry;
    }

    public Multiset.Entry pollLastEntry() {
        Iterator itDescendingEntryIterator = descendingEntryIterator();
        if (!itDescendingEntryIterator.hasNext()) {
            return null;
        }
        Multiset.Entry entry = (Multiset.Entry) itDescendingEntryIterator.next();
        Multiset.Entry entryImmutableEntry = Multisets.immutableEntry(entry.getElement(), entry.getCount());
        itDescendingEntryIterator.remove();
        return entryImmutableEntry;
    }

    public SortedMultiset subMultiset(Object obj, BoundType boundType, Object obj2, BoundType boundType2) {
        Preconditions.checkNotNull(boundType);
        Preconditions.checkNotNull(boundType2);
        return tailMultiset(obj, boundType).headMultiset(obj2, boundType2);
    }

    public AbstractC1958h(Comparator comparator) {
        this.comparator = (Comparator) Preconditions.checkNotNull(comparator);
    }

    @Override // com.google.common.collect.AbstractC1955e
    public NavigableSet<Object> createElementSet() {
        return new J.b(this);
    }

    @Override // com.google.common.collect.AbstractC1955e, com.google.common.collect.Multiset
    public NavigableSet elementSet() {
        return (NavigableSet) super.elementSet();
    }
}
