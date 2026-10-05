package com.google.common.collect;

import com.google.j2objc.annotations.Weak;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes3.dex */
public abstract class J {

    public static class a extends Multisets.h implements SortedSet {

        @Weak
        private final SortedMultiset<Object> multiset;

        public a(SortedMultiset sortedMultiset) {
            this.multiset = sortedMultiset;
        }

        @Override // java.util.SortedSet
        public Comparator<Object> comparator() {
            return multiset().comparator();
        }

        @Override // java.util.SortedSet
        public Object first() {
            return J.d(multiset().firstEntry());
        }

        @Override // java.util.SortedSet
        public SortedSet<Object> headSet(Object obj) {
            return multiset().headMultiset(obj, BoundType.OPEN).elementSet();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Object> iterator() {
            return Multisets.elementIterator(multiset().entrySet().iterator());
        }

        @Override // java.util.SortedSet
        public Object last() {
            return J.d(multiset().lastEntry());
        }

        @Override // java.util.SortedSet
        public SortedSet<Object> subSet(Object obj, Object obj2) {
            return multiset().subMultiset(obj, BoundType.CLOSED, obj2, BoundType.OPEN).elementSet();
        }

        @Override // java.util.SortedSet
        public SortedSet<Object> tailSet(Object obj) {
            return multiset().tailMultiset(obj, BoundType.CLOSED).elementSet();
        }

        @Override // com.google.common.collect.Multisets.h
        public final SortedMultiset<Object> multiset() {
            return this.multiset;
        }
    }

    public static class b extends a implements NavigableSet {
        public b(SortedMultiset sortedMultiset) {
            super(sortedMultiset);
        }

        @Override // java.util.NavigableSet
        public Object ceiling(Object obj) {
            return J.c(multiset().tailMultiset(obj, BoundType.CLOSED).firstEntry());
        }

        @Override // java.util.NavigableSet
        public Iterator<Object> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<Object> descendingSet() {
            return new b(multiset().descendingMultiset());
        }

        @Override // java.util.NavigableSet
        public Object floor(Object obj) {
            return J.c(multiset().headMultiset(obj, BoundType.CLOSED).lastEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<Object> headSet(Object obj, boolean z) {
            return new b(multiset().headMultiset(obj, BoundType.forBoolean(z)));
        }

        @Override // java.util.NavigableSet
        public Object higher(Object obj) {
            return J.c(multiset().tailMultiset(obj, BoundType.OPEN).firstEntry());
        }

        @Override // java.util.NavigableSet
        public Object lower(Object obj) {
            return J.c(multiset().headMultiset(obj, BoundType.OPEN).lastEntry());
        }

        @Override // java.util.NavigableSet
        public Object pollFirst() {
            return J.c(multiset().pollFirstEntry());
        }

        @Override // java.util.NavigableSet
        public Object pollLast() {
            return J.c(multiset().pollLastEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<Object> subSet(Object obj, boolean z, Object obj2, boolean z2) {
            return new b(multiset().subMultiset(obj, BoundType.forBoolean(z), obj2, BoundType.forBoolean(z2)));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<Object> tailSet(Object obj, boolean z) {
            return new b(multiset().tailMultiset(obj, BoundType.forBoolean(z)));
        }
    }

    public static Object c(Multiset.Entry entry) {
        if (entry == null) {
            return null;
        }
        return entry.getElement();
    }

    public static Object d(Multiset.Entry entry) {
        if (entry != null) {
            return entry.getElement();
        }
        throw new NoSuchElementException();
    }
}
