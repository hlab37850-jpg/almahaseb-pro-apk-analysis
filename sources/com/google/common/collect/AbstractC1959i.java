package com.google.common.collect;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.NavigableSet;
import java.util.SortedSet;

/* JADX INFO: renamed from: com.google.common.collect.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1959i extends AbstractC1957g implements SortedSetMultimap {
    private static final long serialVersionUID = 430848587173315748L;

    public AbstractC1959i(Map map) {
        super(map);
    }

    @Override // com.google.common.collect.AbstractC1957g, com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Map asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.AbstractC1952b
    public abstract SortedSet createCollection();

    @Override // com.google.common.collect.AbstractC1952b, com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap
    public Collection values() {
        return super.values();
    }

    @Override // com.google.common.collect.AbstractC1957g, com.google.common.collect.AbstractC1952b
    public Collection<Object> wrapCollection(Object obj, Collection<Object> collection) {
        return collection instanceof NavigableSet ? new AbstractC1952b.m(obj, (NavigableSet) collection, null) : new AbstractC1952b.o(obj, (SortedSet) collection, null);
    }

    @Override // com.google.common.collect.AbstractC1957g, com.google.common.collect.AbstractC1952b
    public <E> SortedSet<E> unmodifiableCollectionSubclass(Collection<E> collection) {
        return collection instanceof NavigableSet ? Sets.unmodifiableNavigableSet((NavigableSet) collection) : Collections.unmodifiableSortedSet((SortedSet) collection);
    }

    @Override // com.google.common.collect.AbstractC1957g, com.google.common.collect.AbstractC1952b
    public SortedSet<Object> createUnmodifiableEmptyCollection() {
        return unmodifiableCollectionSubclass((Collection) createCollection());
    }

    @Override // com.google.common.collect.AbstractC1957g, com.google.common.collect.AbstractC1952b, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public SortedSet get(Object obj) {
        return (SortedSet) super.get(obj);
    }

    @Override // com.google.common.collect.AbstractC1957g, com.google.common.collect.AbstractC1952b, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public SortedSet removeAll(Object obj) {
        return (SortedSet) super.removeAll(obj);
    }

    @Override // com.google.common.collect.AbstractC1957g, com.google.common.collect.AbstractC1952b, com.google.common.collect.AbstractC1954d, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public SortedSet replaceValues(Object obj, Iterable iterable) {
        return (SortedSet) super.replaceValues(obj, iterable);
    }
}
