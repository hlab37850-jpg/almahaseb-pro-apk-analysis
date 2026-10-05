package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import defpackage.AbstractC2217fh;
import defpackage.AbstractC2321h0;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtIncompatible
public class TreeRangeSet<C extends Comparable<?>> extends AbstractC2321h0 implements Serializable {
    private transient Set<Range<C>> asDescendingSetOfRanges;
    private transient Set<Range<C>> asRanges;
    private transient RangeSet<C> complement;

    @VisibleForTesting
    final NavigableMap<AbstractC2217fh, Range<C>> rangesByLowerBound;

    public final class b extends ForwardingCollection implements Set {
        public final Collection a;

        public b(TreeRangeSet treeRangeSet, Collection collection) {
            this.a = collection;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return Sets.equalsImpl(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return Sets.hashCodeImpl(this);
        }

        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Collection delegate() {
            return this.a;
        }
    }

    public final class c extends TreeRangeSet {
        public c() {
            super(new d(TreeRangeSet.this.rangesByLowerBound));
        }

        @Override // com.google.common.collect.TreeRangeSet, defpackage.AbstractC2321h0, com.google.common.collect.RangeSet
        public void add(Range range) {
            TreeRangeSet.this.remove(range);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.RangeSet
        public RangeSet complement() {
            return TreeRangeSet.this;
        }

        @Override // com.google.common.collect.TreeRangeSet, defpackage.AbstractC2321h0, com.google.common.collect.RangeSet
        public boolean contains(Comparable comparable) {
            return !TreeRangeSet.this.contains(comparable);
        }

        @Override // com.google.common.collect.TreeRangeSet, defpackage.AbstractC2321h0, com.google.common.collect.RangeSet
        public void remove(Range range) {
            TreeRangeSet.this.add(range);
        }
    }

    public static final class d extends AbstractC1956f {
        public final NavigableMap a;
        public final NavigableMap b;
        public final Range c;

        public class a extends AbstractIterator {
            public AbstractC2217fh a;
            public final /* synthetic */ AbstractC2217fh b;
            public final /* synthetic */ PeekingIterator c;

            public a(AbstractC2217fh abstractC2217fh, PeekingIterator peekingIterator) {
                this.b = abstractC2217fh;
                this.c = peekingIterator;
                this.a = abstractC2217fh;
            }

            @Override // com.google.common.collect.AbstractIterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry computeNext() {
                Range rangeCreate;
                if (d.this.c.upperBound.m(this.a) || this.a == AbstractC2217fh.a()) {
                    return (Map.Entry) endOfData();
                }
                if (this.c.hasNext()) {
                    Range range = (Range) this.c.next();
                    rangeCreate = Range.create(this.a, range.lowerBound);
                    this.a = range.upperBound;
                } else {
                    rangeCreate = Range.create(this.a, AbstractC2217fh.a());
                    this.a = AbstractC2217fh.a();
                }
                return Maps.immutableEntry(rangeCreate.lowerBound, rangeCreate);
            }
        }

        public class b extends AbstractIterator {
            public AbstractC2217fh a;
            public final /* synthetic */ AbstractC2217fh b;
            public final /* synthetic */ PeekingIterator c;

            public b(AbstractC2217fh abstractC2217fh, PeekingIterator peekingIterator) {
                this.b = abstractC2217fh;
                this.c = peekingIterator;
                this.a = abstractC2217fh;
            }

            @Override // com.google.common.collect.AbstractIterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry computeNext() {
                if (this.a == AbstractC2217fh.c()) {
                    return (Map.Entry) endOfData();
                }
                if (this.c.hasNext()) {
                    Range range = (Range) this.c.next();
                    Range rangeCreate = Range.create(range.upperBound, this.a);
                    this.a = range.lowerBound;
                    if (d.this.c.lowerBound.m(rangeCreate.lowerBound)) {
                        return Maps.immutableEntry(rangeCreate.lowerBound, rangeCreate);
                    }
                } else if (d.this.c.lowerBound.m(AbstractC2217fh.c())) {
                    Range rangeCreate2 = Range.create(AbstractC2217fh.c(), this.a);
                    this.a = AbstractC2217fh.c();
                    return Maps.immutableEntry(AbstractC2217fh.c(), rangeCreate2);
                }
                return (Map.Entry) endOfData();
            }
        }

        public d(NavigableMap navigableMap) {
            this(navigableMap, Range.all());
        }

        @Override // com.google.common.collect.Maps.z
        public Iterator a() {
            Collection collectionValues;
            AbstractC2217fh abstractC2217fhC;
            if (this.c.hasLowerBound()) {
                collectionValues = this.b.tailMap((AbstractC2217fh) this.c.lowerEndpoint(), this.c.lowerBoundType() == BoundType.CLOSED).values();
            } else {
                collectionValues = this.b.values();
            }
            PeekingIterator peekingIterator = Iterators.peekingIterator(collectionValues.iterator());
            if (this.c.contains(AbstractC2217fh.c()) && (!peekingIterator.hasNext() || ((Range) peekingIterator.peek()).lowerBound != AbstractC2217fh.c())) {
                abstractC2217fhC = AbstractC2217fh.c();
            } else {
                if (!peekingIterator.hasNext()) {
                    return Iterators.emptyIterator();
                }
                abstractC2217fhC = ((Range) peekingIterator.next()).upperBound;
            }
            return new a(abstractC2217fhC, peekingIterator);
        }

        @Override // com.google.common.collect.AbstractC1956f
        public Iterator b() {
            AbstractC2217fh abstractC2217fh;
            PeekingIterator peekingIterator = Iterators.peekingIterator(this.b.headMap(this.c.hasUpperBound() ? (AbstractC2217fh) this.c.upperEndpoint() : AbstractC2217fh.a(), this.c.hasUpperBound() && this.c.upperBoundType() == BoundType.CLOSED).descendingMap().values().iterator());
            if (peekingIterator.hasNext()) {
                abstractC2217fh = ((Range) peekingIterator.peek()).upperBound == AbstractC2217fh.a() ? ((Range) peekingIterator.next()).lowerBound : (AbstractC2217fh) this.a.higherKey(((Range) peekingIterator.peek()).upperBound);
            } else {
                if (!this.c.contains(AbstractC2217fh.c()) || this.a.containsKey(AbstractC2217fh.c())) {
                    return Iterators.emptyIterator();
                }
                abstractC2217fh = (AbstractC2217fh) this.a.higherKey(AbstractC2217fh.c());
            }
            return new b((AbstractC2217fh) MoreObjects.firstNonNull(abstractC2217fh, AbstractC2217fh.a()), peekingIterator);
        }

        @Override // java.util.SortedMap
        public Comparator comparator() {
            return Ordering.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return get(obj) != null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Range get(Object obj) {
            if (obj instanceof AbstractC2217fh) {
                try {
                    AbstractC2217fh abstractC2217fh = (AbstractC2217fh) obj;
                    Map.Entry entryFirstEntry = tailMap(abstractC2217fh, true).firstEntry();
                    if (entryFirstEntry != null && ((AbstractC2217fh) entryFirstEntry.getKey()).equals(abstractC2217fh)) {
                        return (Range) entryFirstEntry.getValue();
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public NavigableMap headMap(AbstractC2217fh abstractC2217fh, boolean z) {
            return g(Range.upTo(abstractC2217fh, BoundType.forBoolean(z)));
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public NavigableMap subMap(AbstractC2217fh abstractC2217fh, boolean z, AbstractC2217fh abstractC2217fh2, boolean z2) {
            return g(Range.range(abstractC2217fh, BoundType.forBoolean(z), abstractC2217fh2, BoundType.forBoolean(z2)));
        }

        public final NavigableMap g(Range range) {
            if (!this.c.isConnected(range)) {
                return ImmutableSortedMap.of();
            }
            return new d(this.a, range.intersection(this.c));
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public NavigableMap tailMap(AbstractC2217fh abstractC2217fh, boolean z) {
            return g(Range.downTo(abstractC2217fh, BoundType.forBoolean(z)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return Iterators.size(a());
        }

        public d(NavigableMap navigableMap, Range range) {
            this.a = navigableMap;
            this.b = new e(navigableMap);
            this.c = range;
        }
    }

    public final class f extends TreeRangeSet {
        public final Range a;

        /* JADX WARN: Illegal instructions before constructor call */
        public f(Range range) {
            super(new g(Range.all(), range, TreeRangeSet.this.rangesByLowerBound));
            this.a = range;
        }

        @Override // com.google.common.collect.TreeRangeSet, defpackage.AbstractC2321h0, com.google.common.collect.RangeSet
        public void add(Range range) {
            Preconditions.checkArgument(this.a.encloses(range), "Cannot add range %s to subRangeSet(%s)", range, this.a);
            TreeRangeSet.this.add(range);
        }

        @Override // com.google.common.collect.TreeRangeSet, defpackage.AbstractC2321h0, com.google.common.collect.RangeSet
        public void clear() {
            TreeRangeSet.this.remove(this.a);
        }

        @Override // com.google.common.collect.TreeRangeSet, defpackage.AbstractC2321h0, com.google.common.collect.RangeSet
        public boolean contains(Comparable comparable) {
            return this.a.contains(comparable) && TreeRangeSet.this.contains(comparable);
        }

        @Override // com.google.common.collect.TreeRangeSet, defpackage.AbstractC2321h0, com.google.common.collect.RangeSet
        public boolean encloses(Range range) {
            Range rangeRangeEnclosing;
            return (this.a.isEmpty() || !this.a.encloses(range) || (rangeRangeEnclosing = TreeRangeSet.this.rangeEnclosing(range)) == null || rangeRangeEnclosing.intersection(this.a).isEmpty()) ? false : true;
        }

        @Override // com.google.common.collect.TreeRangeSet, defpackage.AbstractC2321h0, com.google.common.collect.RangeSet
        public Range rangeContaining(Comparable comparable) {
            Range<C> rangeRangeContaining;
            if (this.a.contains(comparable) && (rangeRangeContaining = TreeRangeSet.this.rangeContaining(comparable)) != null) {
                return rangeRangeContaining.intersection(this.a);
            }
            return null;
        }

        @Override // com.google.common.collect.TreeRangeSet, defpackage.AbstractC2321h0, com.google.common.collect.RangeSet
        public void remove(Range range) {
            if (range.isConnected(this.a)) {
                TreeRangeSet.this.remove(range.intersection(this.a));
            }
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.RangeSet
        public RangeSet subRangeSet(Range range) {
            if (range.encloses(this.a)) {
                return this;
            }
            return range.isConnected(this.a) ? new f(this.a.intersection(range)) : ImmutableRangeSet.of();
        }
    }

    public static final class g extends AbstractC1956f {
        public final Range a;
        public final Range b;
        public final NavigableMap c;
        public final NavigableMap d;

        public class a extends AbstractIterator {
            public final /* synthetic */ Iterator a;
            public final /* synthetic */ AbstractC2217fh b;

            public a(Iterator it, AbstractC2217fh abstractC2217fh) {
                this.a = it;
                this.b = abstractC2217fh;
            }

            @Override // com.google.common.collect.AbstractIterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry computeNext() {
                if (!this.a.hasNext()) {
                    return (Map.Entry) endOfData();
                }
                Range range = (Range) this.a.next();
                if (this.b.m(range.lowerBound)) {
                    return (Map.Entry) endOfData();
                }
                Range rangeIntersection = range.intersection(g.this.b);
                return Maps.immutableEntry(rangeIntersection.lowerBound, rangeIntersection);
            }
        }

        public class b extends AbstractIterator {
            public final /* synthetic */ Iterator a;

            public b(Iterator it) {
                this.a = it;
            }

            @Override // com.google.common.collect.AbstractIterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry computeNext() {
                if (!this.a.hasNext()) {
                    return (Map.Entry) endOfData();
                }
                Range range = (Range) this.a.next();
                if (g.this.b.lowerBound.compareTo(range.upperBound) >= 0) {
                    return (Map.Entry) endOfData();
                }
                Range rangeIntersection = range.intersection(g.this.b);
                return g.this.a.contains(rangeIntersection.lowerBound) ? Maps.immutableEntry(rangeIntersection.lowerBound, rangeIntersection) : (Map.Entry) endOfData();
            }
        }

        private NavigableMap h(Range range) {
            return !range.isConnected(this.a) ? ImmutableSortedMap.of() : new g(this.a.intersection(range), this.b, this.c);
        }

        @Override // com.google.common.collect.Maps.z
        public Iterator a() {
            Iterator it;
            if (this.b.isEmpty()) {
                return Iterators.emptyIterator();
            }
            if (this.a.upperBound.m(this.b.lowerBound)) {
                return Iterators.emptyIterator();
            }
            if (this.a.lowerBound.m(this.b.lowerBound)) {
                it = this.d.tailMap(this.b.lowerBound, false).values().iterator();
            } else {
                it = this.c.tailMap((AbstractC2217fh) this.a.lowerBound.k(), this.a.lowerBoundType() == BoundType.CLOSED).values().iterator();
            }
            return new a(it, (AbstractC2217fh) Ordering.natural().min(this.a.upperBound, AbstractC2217fh.e(this.b.upperBound)));
        }

        @Override // com.google.common.collect.AbstractC1956f
        public Iterator b() {
            if (this.b.isEmpty()) {
                return Iterators.emptyIterator();
            }
            AbstractC2217fh abstractC2217fh = (AbstractC2217fh) Ordering.natural().min(this.a.upperBound, AbstractC2217fh.e(this.b.upperBound));
            return new b(this.c.headMap((AbstractC2217fh) abstractC2217fh.k(), abstractC2217fh.p() == BoundType.CLOSED).descendingMap().values().iterator());
        }

        @Override // java.util.SortedMap
        public Comparator comparator() {
            return Ordering.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return get(obj) != null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Range get(Object obj) {
            if (obj instanceof AbstractC2217fh) {
                try {
                    AbstractC2217fh abstractC2217fh = (AbstractC2217fh) obj;
                    if (this.a.contains(abstractC2217fh) && abstractC2217fh.compareTo(this.b.lowerBound) >= 0 && abstractC2217fh.compareTo(this.b.upperBound) < 0) {
                        if (abstractC2217fh.equals(this.b.lowerBound)) {
                            Range range = (Range) Maps.valueOrNull(this.c.floorEntry(abstractC2217fh));
                            if (range != null && range.upperBound.compareTo(this.b.lowerBound) > 0) {
                                return range.intersection(this.b);
                            }
                        } else {
                            Range range2 = (Range) this.c.get(abstractC2217fh);
                            if (range2 != null) {
                                return range2.intersection(this.b);
                            }
                        }
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public NavigableMap headMap(AbstractC2217fh abstractC2217fh, boolean z) {
            return h(Range.upTo(abstractC2217fh, BoundType.forBoolean(z)));
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public NavigableMap subMap(AbstractC2217fh abstractC2217fh, boolean z, AbstractC2217fh abstractC2217fh2, boolean z2) {
            return h(Range.range(abstractC2217fh, BoundType.forBoolean(z), abstractC2217fh2, BoundType.forBoolean(z2)));
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public NavigableMap tailMap(AbstractC2217fh abstractC2217fh, boolean z) {
            return h(Range.downTo(abstractC2217fh, BoundType.forBoolean(z)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return Iterators.size(a());
        }

        public g(Range range, Range range2, NavigableMap navigableMap) {
            this.a = (Range) Preconditions.checkNotNull(range);
            this.b = (Range) Preconditions.checkNotNull(range2);
            this.c = (NavigableMap) Preconditions.checkNotNull(navigableMap);
            this.d = new e(navigableMap);
        }
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create() {
        return new TreeRangeSet<>(new TreeMap());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Range<C> rangeEnclosing(Range<C> range) {
        Preconditions.checkNotNull(range);
        Map.Entry<AbstractC2217fh, Range<C>> entryFloorEntry = this.rangesByLowerBound.floorEntry(range.lowerBound);
        if (entryFloorEntry == null || !entryFloorEntry.getValue().encloses(range)) {
            return null;
        }
        return entryFloorEntry.getValue();
    }

    private void replaceRangeWithSameLowerBound(Range<C> range) {
        if (range.isEmpty()) {
            this.rangesByLowerBound.remove(range.lowerBound);
        } else {
            this.rangesByLowerBound.put(range.lowerBound, range);
        }
    }

    @Override // defpackage.AbstractC2321h0, com.google.common.collect.RangeSet
    public void add(Range<C> range) {
        Preconditions.checkNotNull(range);
        if (range.isEmpty()) {
            return;
        }
        AbstractC2217fh abstractC2217fh = range.lowerBound;
        AbstractC2217fh abstractC2217fh2 = range.upperBound;
        Map.Entry<AbstractC2217fh, Range<C>> entryLowerEntry = this.rangesByLowerBound.lowerEntry(abstractC2217fh);
        if (entryLowerEntry != null) {
            Range<C> value = entryLowerEntry.getValue();
            if (value.upperBound.compareTo(abstractC2217fh) >= 0) {
                if (value.upperBound.compareTo(abstractC2217fh2) >= 0) {
                    abstractC2217fh2 = value.upperBound;
                }
                abstractC2217fh = value.lowerBound;
            }
        }
        Map.Entry<AbstractC2217fh, Range<C>> entryFloorEntry = this.rangesByLowerBound.floorEntry(abstractC2217fh2);
        if (entryFloorEntry != null) {
            Range<C> value2 = entryFloorEntry.getValue();
            if (value2.upperBound.compareTo(abstractC2217fh2) >= 0) {
                abstractC2217fh2 = value2.upperBound;
            }
        }
        this.rangesByLowerBound.subMap(abstractC2217fh, abstractC2217fh2).clear();
        replaceRangeWithSameLowerBound(Range.create(abstractC2217fh, abstractC2217fh2));
    }

    @Override // defpackage.AbstractC2321h0, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void addAll(RangeSet rangeSet) {
        super.addAll(rangeSet);
    }

    @Override // com.google.common.collect.RangeSet
    public Set<Range<C>> asDescendingSetOfRanges() {
        Set<Range<C>> set = this.asDescendingSetOfRanges;
        if (set != null) {
            return set;
        }
        b bVar = new b(this, this.rangesByLowerBound.descendingMap().values());
        this.asDescendingSetOfRanges = bVar;
        return bVar;
    }

    @Override // com.google.common.collect.RangeSet
    public Set<Range<C>> asRanges() {
        Set<Range<C>> set = this.asRanges;
        if (set != null) {
            return set;
        }
        b bVar = new b(this, this.rangesByLowerBound.values());
        this.asRanges = bVar;
        return bVar;
    }

    @Override // defpackage.AbstractC2321h0, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.RangeSet
    public RangeSet<C> complement() {
        RangeSet<C> rangeSet = this.complement;
        if (rangeSet != null) {
            return rangeSet;
        }
        c cVar = new c();
        this.complement = cVar;
        return cVar;
    }

    @Override // defpackage.AbstractC2321h0, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return super.contains(comparable);
    }

    @Override // defpackage.AbstractC2321h0, com.google.common.collect.RangeSet
    public boolean encloses(Range<C> range) {
        Preconditions.checkNotNull(range);
        Map.Entry<AbstractC2217fh, Range<C>> entryFloorEntry = this.rangesByLowerBound.floorEntry(range.lowerBound);
        return entryFloorEntry != null && entryFloorEntry.getValue().encloses(range);
    }

    @Override // defpackage.AbstractC2321h0, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean enclosesAll(RangeSet rangeSet) {
        return super.enclosesAll(rangeSet);
    }

    @Override // defpackage.AbstractC2321h0, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.RangeSet
    public boolean intersects(Range<C> range) {
        Preconditions.checkNotNull(range);
        Map.Entry<AbstractC2217fh, Range<C>> entryCeilingEntry = this.rangesByLowerBound.ceilingEntry(range.lowerBound);
        if (entryCeilingEntry != null && entryCeilingEntry.getValue().isConnected(range) && !entryCeilingEntry.getValue().intersection(range).isEmpty()) {
            return true;
        }
        Map.Entry<AbstractC2217fh, Range<C>> entryLowerEntry = this.rangesByLowerBound.lowerEntry(range.lowerBound);
        return (entryLowerEntry == null || !entryLowerEntry.getValue().isConnected(range) || entryLowerEntry.getValue().intersection(range).isEmpty()) ? false : true;
    }

    @Override // defpackage.AbstractC2321h0, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // defpackage.AbstractC2321h0, com.google.common.collect.RangeSet
    public Range<C> rangeContaining(C c2) {
        Preconditions.checkNotNull(c2);
        Map.Entry<AbstractC2217fh, Range<C>> entryFloorEntry = this.rangesByLowerBound.floorEntry(AbstractC2217fh.e(c2));
        if (entryFloorEntry == null || !entryFloorEntry.getValue().contains(c2)) {
            return null;
        }
        return entryFloorEntry.getValue();
    }

    @Override // defpackage.AbstractC2321h0, com.google.common.collect.RangeSet
    public void remove(Range<C> range) {
        Preconditions.checkNotNull(range);
        if (range.isEmpty()) {
            return;
        }
        Map.Entry<AbstractC2217fh, Range<C>> entryLowerEntry = this.rangesByLowerBound.lowerEntry(range.lowerBound);
        if (entryLowerEntry != null) {
            Range<C> value = entryLowerEntry.getValue();
            if (value.upperBound.compareTo(range.lowerBound) >= 0) {
                if (range.hasUpperBound() && value.upperBound.compareTo(range.upperBound) >= 0) {
                    replaceRangeWithSameLowerBound(Range.create(range.upperBound, value.upperBound));
                }
                replaceRangeWithSameLowerBound(Range.create(value.lowerBound, range.lowerBound));
            }
        }
        Map.Entry<AbstractC2217fh, Range<C>> entryFloorEntry = this.rangesByLowerBound.floorEntry(range.upperBound);
        if (entryFloorEntry != null) {
            Range<C> value2 = entryFloorEntry.getValue();
            if (range.hasUpperBound() && value2.upperBound.compareTo(range.upperBound) >= 0) {
                replaceRangeWithSameLowerBound(Range.create(range.upperBound, value2.upperBound));
            }
        }
        this.rangesByLowerBound.subMap(range.lowerBound, range.upperBound).clear();
    }

    @Override // defpackage.AbstractC2321h0, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void removeAll(RangeSet rangeSet) {
        super.removeAll(rangeSet);
    }

    @Override // com.google.common.collect.RangeSet
    public Range<C> span() {
        Map.Entry<AbstractC2217fh, Range<C>> entryFirstEntry = this.rangesByLowerBound.firstEntry();
        Map.Entry<AbstractC2217fh, Range<C>> entryLastEntry = this.rangesByLowerBound.lastEntry();
        if (entryFirstEntry == null || entryLastEntry == null) {
            throw new NoSuchElementException();
        }
        return Range.create(entryFirstEntry.getValue().lowerBound, entryLastEntry.getValue().upperBound);
    }

    @Override // com.google.common.collect.RangeSet
    public RangeSet<C> subRangeSet(Range<C> range) {
        return range.equals(Range.all()) ? this : new f(range);
    }

    private TreeRangeSet(NavigableMap<AbstractC2217fh, Range<C>> navigableMap) {
        this.rangesByLowerBound = navigableMap;
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create(RangeSet<C> rangeSet) {
        TreeRangeSet<C> treeRangeSetCreate = create();
        treeRangeSetCreate.addAll(rangeSet);
        return treeRangeSetCreate;
    }

    @Override // defpackage.AbstractC2321h0, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void addAll(Iterable iterable) {
        super.addAll(iterable);
    }

    @Override // defpackage.AbstractC2321h0, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean enclosesAll(Iterable iterable) {
        return super.enclosesAll(iterable);
    }

    @Override // defpackage.AbstractC2321h0, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void removeAll(Iterable iterable) {
        super.removeAll(iterable);
    }

    public static final class e extends AbstractC1956f {
        public final NavigableMap a;
        public final Range b;

        public class a extends AbstractIterator {
            public final /* synthetic */ Iterator a;

            public a(Iterator it) {
                this.a = it;
            }

            @Override // com.google.common.collect.AbstractIterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry computeNext() {
                if (!this.a.hasNext()) {
                    return (Map.Entry) endOfData();
                }
                Range range = (Range) this.a.next();
                return e.this.b.upperBound.m(range.upperBound) ? (Map.Entry) endOfData() : Maps.immutableEntry(range.upperBound, range);
            }
        }

        public class b extends AbstractIterator {
            public final /* synthetic */ PeekingIterator a;

            public b(PeekingIterator peekingIterator) {
                this.a = peekingIterator;
            }

            @Override // com.google.common.collect.AbstractIterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry computeNext() {
                if (!this.a.hasNext()) {
                    return (Map.Entry) endOfData();
                }
                Range range = (Range) this.a.next();
                return e.this.b.lowerBound.m(range.upperBound) ? Maps.immutableEntry(range.upperBound, range) : (Map.Entry) endOfData();
            }
        }

        public e(NavigableMap navigableMap) {
            this.a = navigableMap;
            this.b = Range.all();
        }

        private NavigableMap g(Range range) {
            return range.isConnected(this.b) ? new e(this.a, range.intersection(this.b)) : ImmutableSortedMap.of();
        }

        @Override // com.google.common.collect.Maps.z
        public Iterator a() {
            Map.Entry entryLowerEntry;
            Iterator it;
            if (this.b.hasLowerBound() && (entryLowerEntry = this.a.lowerEntry((AbstractC2217fh) this.b.lowerEndpoint())) != null) {
                it = this.b.lowerBound.m(((Range) entryLowerEntry.getValue()).upperBound) ? this.a.tailMap((AbstractC2217fh) entryLowerEntry.getKey(), true).values().iterator() : this.a.tailMap((AbstractC2217fh) this.b.lowerEndpoint(), true).values().iterator();
            } else {
                it = this.a.values().iterator();
            }
            return new a(it);
        }

        @Override // com.google.common.collect.AbstractC1956f
        public Iterator b() {
            PeekingIterator peekingIterator = Iterators.peekingIterator((this.b.hasUpperBound() ? this.a.headMap((AbstractC2217fh) this.b.upperEndpoint(), false).descendingMap().values() : this.a.descendingMap().values()).iterator());
            if (peekingIterator.hasNext() && this.b.upperBound.m(((Range) peekingIterator.peek()).upperBound)) {
                peekingIterator.next();
            }
            return new b(peekingIterator);
        }

        @Override // java.util.SortedMap
        public Comparator comparator() {
            return Ordering.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return get(obj) != null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Range get(Object obj) {
            Map.Entry entryLowerEntry;
            if (obj instanceof AbstractC2217fh) {
                try {
                    AbstractC2217fh abstractC2217fh = (AbstractC2217fh) obj;
                    if (this.b.contains(abstractC2217fh) && (entryLowerEntry = this.a.lowerEntry(abstractC2217fh)) != null && ((Range) entryLowerEntry.getValue()).upperBound.equals(abstractC2217fh)) {
                        return (Range) entryLowerEntry.getValue();
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public NavigableMap headMap(AbstractC2217fh abstractC2217fh, boolean z) {
            return g(Range.upTo(abstractC2217fh, BoundType.forBoolean(z)));
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public NavigableMap subMap(AbstractC2217fh abstractC2217fh, boolean z, AbstractC2217fh abstractC2217fh2, boolean z2) {
            return g(Range.range(abstractC2217fh, BoundType.forBoolean(z), abstractC2217fh2, BoundType.forBoolean(z2)));
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public NavigableMap tailMap(AbstractC2217fh abstractC2217fh, boolean z) {
            return g(Range.downTo(abstractC2217fh, BoundType.forBoolean(z)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            if (this.b.equals(Range.all())) {
                return this.a.isEmpty();
            }
            return !a().hasNext();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.b.equals(Range.all()) ? this.a.size() : Iterators.size(a());
        }

        public e(NavigableMap navigableMap, Range range) {
            this.a = navigableMap;
            this.b = range;
        }
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create(Iterable<Range<C>> iterable) {
        TreeRangeSet<C> treeRangeSetCreate = create();
        treeRangeSetCreate.addAll(iterable);
        return treeRangeSetCreate;
    }
}
