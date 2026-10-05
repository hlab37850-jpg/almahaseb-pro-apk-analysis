package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import defpackage.AbstractC2217fh;
import defpackage.AbstractC3547oJ;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public final class Range<C extends Comparable> extends AbstractC3547oJ implements Predicate<C>, Serializable {
    private static final Range<Comparable> ALL = new Range<>(AbstractC2217fh.c(), AbstractC2217fh.a());
    private static final long serialVersionUID = 0;
    final AbstractC2217fh lowerBound;
    final AbstractC2217fh upperBound;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[BoundType.values().length];
            a = iArr;
            try {
                iArr[BoundType.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[BoundType.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static class b implements Function {
        public static final b a = new b();

        @Override // com.google.common.base.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AbstractC2217fh apply(Range range) {
            return range.lowerBound;
        }
    }

    public static class c extends Ordering implements Serializable {
        public static final Ordering a = new c();

        @Override // com.google.common.collect.Ordering, java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Range range, Range range2) {
            return ComparisonChain.start().compare(range.lowerBound, range2.lowerBound).compare(range.upperBound, range2.upperBound).result();
        }
    }

    public static class d implements Function {
        public static final d a = new d();

        @Override // com.google.common.base.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AbstractC2217fh apply(Range range) {
            return range.upperBound;
        }
    }

    private Range(AbstractC2217fh abstractC2217fh, AbstractC2217fh abstractC2217fh2) {
        this.lowerBound = (AbstractC2217fh) Preconditions.checkNotNull(abstractC2217fh);
        this.upperBound = (AbstractC2217fh) Preconditions.checkNotNull(abstractC2217fh2);
        if (abstractC2217fh.compareTo(abstractC2217fh2) > 0 || abstractC2217fh == AbstractC2217fh.a() || abstractC2217fh2 == AbstractC2217fh.c()) {
            String strValueOf = String.valueOf(toString(abstractC2217fh, abstractC2217fh2));
            throw new IllegalArgumentException(strValueOf.length() != 0 ? "Invalid range: ".concat(strValueOf) : new String("Invalid range: "));
        }
    }

    public static <C extends Comparable<?>> Range<C> all() {
        return (Range<C>) ALL;
    }

    public static <C extends Comparable<?>> Range<C> atLeast(C c2) {
        return create(AbstractC2217fh.e(c2), AbstractC2217fh.a());
    }

    public static <C extends Comparable<?>> Range<C> atMost(C c2) {
        return create(AbstractC2217fh.c(), AbstractC2217fh.b(c2));
    }

    public static <C extends Comparable<?>> Range<C> closed(C c2, C c3) {
        return create(AbstractC2217fh.e(c2), AbstractC2217fh.b(c3));
    }

    public static <C extends Comparable<?>> Range<C> closedOpen(C c2, C c3) {
        return create(AbstractC2217fh.e(c2), AbstractC2217fh.e(c3));
    }

    public static int compareOrThrow(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    public static <C extends Comparable<?>> Range<C> create(AbstractC2217fh abstractC2217fh, AbstractC2217fh abstractC2217fh2) {
        return new Range<>(abstractC2217fh, abstractC2217fh2);
    }

    public static <C extends Comparable<?>> Range<C> downTo(C c2, BoundType boundType) {
        int i = a.a[boundType.ordinal()];
        if (i == 1) {
            return greaterThan(c2);
        }
        if (i == 2) {
            return atLeast(c2);
        }
        throw new AssertionError();
    }

    public static <C extends Comparable<?>> Range<C> encloseAll(Iterable<C> iterable) {
        Preconditions.checkNotNull(iterable);
        if (iterable instanceof SortedSet) {
            SortedSet sortedSet = (SortedSet) iterable;
            Comparator comparator = sortedSet.comparator();
            if (Ordering.natural().equals(comparator) || comparator == null) {
                return closed((Comparable) sortedSet.first(), (Comparable) sortedSet.last());
            }
        }
        Iterator<C> it = iterable.iterator();
        Comparable comparable = (Comparable) Preconditions.checkNotNull(it.next());
        Comparable comparable2 = comparable;
        while (it.hasNext()) {
            Comparable comparable3 = (Comparable) Preconditions.checkNotNull(it.next());
            comparable = (Comparable) Ordering.natural().min(comparable, comparable3);
            comparable2 = (Comparable) Ordering.natural().max(comparable2, comparable3);
        }
        return closed(comparable, comparable2);
    }

    public static <C extends Comparable<?>> Range<C> greaterThan(C c2) {
        return create(AbstractC2217fh.b(c2), AbstractC2217fh.a());
    }

    public static <C extends Comparable<?>> Range<C> lessThan(C c2) {
        return create(AbstractC2217fh.c(), AbstractC2217fh.e(c2));
    }

    public static <C extends Comparable<?>> Function<Range<C>, AbstractC2217fh> lowerBoundFn() {
        return b.a;
    }

    public static <C extends Comparable<?>> Range<C> open(C c2, C c3) {
        return create(AbstractC2217fh.b(c2), AbstractC2217fh.e(c3));
    }

    public static <C extends Comparable<?>> Range<C> openClosed(C c2, C c3) {
        return create(AbstractC2217fh.b(c2), AbstractC2217fh.b(c3));
    }

    public static <C extends Comparable<?>> Range<C> range(C c2, BoundType boundType, C c3, BoundType boundType2) {
        Preconditions.checkNotNull(boundType);
        Preconditions.checkNotNull(boundType2);
        BoundType boundType3 = BoundType.OPEN;
        return create(boundType == boundType3 ? AbstractC2217fh.b(c2) : AbstractC2217fh.e(c2), boundType2 == boundType3 ? AbstractC2217fh.e(c3) : AbstractC2217fh.b(c3));
    }

    public static <C extends Comparable<?>> Ordering<Range<C>> rangeLexOrdering() {
        return c.a;
    }

    public static <C extends Comparable<?>> Range<C> singleton(C c2) {
        return closed(c2, c2);
    }

    public static <C extends Comparable<?>> Range<C> upTo(C c2, BoundType boundType) {
        int i = a.a[boundType.ordinal()];
        if (i == 1) {
            return lessThan(c2);
        }
        if (i == 2) {
            return atMost(c2);
        }
        throw new AssertionError();
    }

    public static <C extends Comparable<?>> Function<Range<C>, AbstractC2217fh> upperBoundFn() {
        return d.a;
    }

    public Range<C> canonical(DiscreteDomain<C> discreteDomain) {
        Preconditions.checkNotNull(discreteDomain);
        AbstractC2217fh abstractC2217fhF = this.lowerBound.f(discreteDomain);
        AbstractC2217fh abstractC2217fhF2 = this.upperBound.f(discreteDomain);
        return (abstractC2217fhF == this.lowerBound && abstractC2217fhF2 == this.upperBound) ? this : create(abstractC2217fhF, abstractC2217fhF2);
    }

    public boolean contains(C c2) {
        Preconditions.checkNotNull(c2);
        return this.lowerBound.m(c2) && !this.upperBound.m(c2);
    }

    public boolean containsAll(Iterable<? extends C> iterable) {
        if (Iterables.isEmpty(iterable)) {
            return true;
        }
        if (iterable instanceof SortedSet) {
            SortedSet sortedSet = (SortedSet) iterable;
            Comparator comparator = sortedSet.comparator();
            if (Ordering.natural().equals(comparator) || comparator == null) {
                return contains((Comparable) sortedSet.first()) && contains((Comparable) sortedSet.last());
            }
        }
        Iterator<? extends C> it = iterable.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public boolean encloses(Range<C> range) {
        return this.lowerBound.compareTo(range.lowerBound) <= 0 && this.upperBound.compareTo(range.upperBound) >= 0;
    }

    @Override // com.google.common.base.Predicate
    public boolean equals(Object obj) {
        if (!(obj instanceof Range)) {
            return false;
        }
        Range range = (Range) obj;
        return this.lowerBound.equals(range.lowerBound) && this.upperBound.equals(range.upperBound);
    }

    public Range<C> gap(Range<C> range) {
        if (this.lowerBound.compareTo(range.upperBound) >= 0 || range.lowerBound.compareTo(this.upperBound) >= 0) {
            boolean z = this.lowerBound.compareTo(range.lowerBound) < 0;
            Range<C> range2 = z ? this : range;
            if (!z) {
                range = this;
            }
            return create(range2.upperBound, range.lowerBound);
        }
        String strValueOf = String.valueOf(this);
        String strValueOf2 = String.valueOf(range);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 39 + strValueOf2.length());
        sb.append("Ranges have a nonempty intersection: ");
        sb.append(strValueOf);
        sb.append(", ");
        sb.append(strValueOf2);
        throw new IllegalArgumentException(sb.toString());
    }

    public boolean hasLowerBound() {
        return this.lowerBound != AbstractC2217fh.c();
    }

    public boolean hasUpperBound() {
        return this.upperBound != AbstractC2217fh.a();
    }

    public int hashCode() {
        return (this.lowerBound.hashCode() * 31) + this.upperBound.hashCode();
    }

    public Range<C> intersection(Range<C> range) {
        int iCompareTo = this.lowerBound.compareTo(range.lowerBound);
        int iCompareTo2 = this.upperBound.compareTo(range.upperBound);
        if (iCompareTo >= 0 && iCompareTo2 <= 0) {
            return this;
        }
        if (iCompareTo <= 0 && iCompareTo2 >= 0) {
            return range;
        }
        AbstractC2217fh abstractC2217fh = iCompareTo >= 0 ? this.lowerBound : range.lowerBound;
        AbstractC2217fh abstractC2217fh2 = iCompareTo2 <= 0 ? this.upperBound : range.upperBound;
        Preconditions.checkArgument(abstractC2217fh.compareTo(abstractC2217fh2) <= 0, "intersection is undefined for disconnected ranges %s and %s", this, range);
        return create(abstractC2217fh, abstractC2217fh2);
    }

    public boolean isConnected(Range<C> range) {
        return this.lowerBound.compareTo(range.upperBound) <= 0 && range.lowerBound.compareTo(this.upperBound) <= 0;
    }

    public boolean isEmpty() {
        return this.lowerBound.equals(this.upperBound);
    }

    public BoundType lowerBoundType() {
        return this.lowerBound.o();
    }

    public C lowerEndpoint() {
        return (C) this.lowerBound.k();
    }

    public Object readResolve() {
        return equals(ALL) ? all() : this;
    }

    public Range<C> span(Range<C> range) {
        int iCompareTo = this.lowerBound.compareTo(range.lowerBound);
        int iCompareTo2 = this.upperBound.compareTo(range.upperBound);
        if (iCompareTo <= 0 && iCompareTo2 >= 0) {
            return this;
        }
        if (iCompareTo < 0 || iCompareTo2 > 0) {
            return create(iCompareTo <= 0 ? this.lowerBound : range.lowerBound, iCompareTo2 >= 0 ? this.upperBound : range.upperBound);
        }
        return range;
    }

    public String toString() {
        return toString(this.lowerBound, this.upperBound);
    }

    public BoundType upperBoundType() {
        return this.upperBound.p();
    }

    public C upperEndpoint() {
        return (C) this.upperBound.k();
    }

    private static String toString(AbstractC2217fh abstractC2217fh, AbstractC2217fh abstractC2217fh2) {
        StringBuilder sb = new StringBuilder(16);
        abstractC2217fh.i(sb);
        sb.append("..");
        abstractC2217fh2.j(sb);
        return sb.toString();
    }

    @Override // com.google.common.base.Predicate
    @Deprecated
    public boolean apply(C c2) {
        return contains(c2);
    }
}
