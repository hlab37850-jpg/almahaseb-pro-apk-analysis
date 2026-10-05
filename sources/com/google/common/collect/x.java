package com.google.common.collect;

import com.google.common.base.Preconditions;
import defpackage.AbstractC3345ls;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class x extends ContiguousSet {
    public final Range a;

    public class a extends AbstractSequentialIterator {
        public final Comparable a;

        public a(Comparable comparable) {
            super(comparable);
            this.a = x.this.last();
        }

        @Override // com.google.common.collect.AbstractSequentialIterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Comparable computeNext(Comparable comparable) {
            if (x.b(comparable, this.a)) {
                return null;
            }
            return x.this.domain.next(comparable);
        }
    }

    public class b extends AbstractSequentialIterator {
        public final Comparable a;

        public b(Comparable comparable) {
            super(comparable);
            this.a = x.this.first();
        }

        @Override // com.google.common.collect.AbstractSequentialIterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Comparable computeNext(Comparable comparable) {
            if (x.b(comparable, this.a)) {
                return null;
            }
            return x.this.domain.previous(comparable);
        }
    }

    public class c extends AbstractC3345ls {
        public c() {
        }

        @Override // defpackage.AbstractC3345ls
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ImmutableSortedSet a() {
            return x.this;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java.util.List
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Comparable get(int i) {
            Preconditions.checkElementIndex(i, size());
            x xVar = x.this;
            return xVar.domain.offset(xVar.first(), i);
        }
    }

    public static final class d implements Serializable {
        public final Range a;
        public final DiscreteDomain b;

        public /* synthetic */ d(Range range, DiscreteDomain discreteDomain, a aVar) {
            this(range, discreteDomain);
        }

        public d(Range range, DiscreteDomain discreteDomain) {
            this.a = range;
            this.b = discreteDomain;
        }
    }

    public x(Range range, DiscreteDomain discreteDomain) {
        super(discreteDomain);
        this.a = range;
    }

    public static boolean b(Comparable comparable, Comparable comparable2) {
        return comparable2 != null && Range.compareOrThrow(comparable, comparable2) == 0;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Comparable first() {
        Comparable comparableN = this.a.lowerBound.n(this.domain);
        Objects.requireNonNull(comparableN);
        return comparableN;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return this.a.contains((Comparable) obj);
        } catch (ClassCastException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection collection) {
        return Collections2.containsAllImpl(this, collection);
    }

    @Override // com.google.common.collect.ImmutableSet
    public ImmutableList createAsList() {
        return this.domain.supportsFastOffset ? new c() : super.createAsList();
    }

    public final ContiguousSet e(Range range) {
        return this.a.isConnected(range) ? ContiguousSet.create(this.a.intersection(range), this.domain) : new C1965o(this.domain);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof x) {
            x xVar = (x) obj;
            if (this.domain.equals(xVar.domain)) {
                return first().equals(xVar.first()) && last().equals(xVar.last());
            }
        }
        return super.equals(obj);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Comparable last() {
        Comparable comparableL = this.a.upperBound.l(this.domain);
        Objects.requireNonNull(comparableL);
        return comparableL;
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return Sets.hashCodeImpl(this);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    public int indexOf(Object obj) {
        if (!contains(obj)) {
            return -1;
        }
        DiscreteDomain<C> discreteDomain = this.domain;
        Comparable comparableFirst = first();
        Objects.requireNonNull(obj);
        return (int) discreteDomain.distance(comparableFirst, (Comparable) obj);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.common.collect.ContiguousSet
    public ContiguousSet intersection(ContiguousSet contiguousSet) {
        Preconditions.checkNotNull(contiguousSet);
        Preconditions.checkArgument(this.domain.equals(contiguousSet.domain));
        if (contiguousSet.isEmpty()) {
            return contiguousSet;
        }
        Comparable comparable = (Comparable) Ordering.natural().max(first(), (Comparable) contiguousSet.first());
        Comparable comparable2 = (Comparable) Ordering.natural().min(last(), (Comparable) contiguousSet.last());
        return comparable.compareTo(comparable2) <= 0 ? ContiguousSet.create(Range.closed(comparable, comparable2), this.domain) : new C1965o(this.domain);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ContiguousSet
    public Range range() {
        BoundType boundType = BoundType.CLOSED;
        return range(boundType, boundType);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        long jDistance = this.domain.distance(first(), last());
        if (jDistance >= 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return ((int) jDistance) + 1;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new d(this.a, this.domain, null);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public UnmodifiableIterator descendingIterator() {
        return new b(last());
    }

    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    public ContiguousSet headSetImpl(Comparable comparable, boolean z) {
        return e(Range.upTo(comparable, BoundType.forBoolean(z)));
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public UnmodifiableIterator iterator() {
        return new a(first());
    }

    @Override // com.google.common.collect.ContiguousSet
    public Range range(BoundType boundType, BoundType boundType2) {
        return Range.create(this.a.lowerBound.q(boundType, this.domain), this.a.upperBound.r(boundType2, this.domain));
    }

    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    public ContiguousSet subSetImpl(Comparable comparable, boolean z, Comparable comparable2, boolean z2) {
        return (comparable.compareTo(comparable2) != 0 || z || z2) ? e(Range.range(comparable, BoundType.forBoolean(z), comparable2, BoundType.forBoolean(z2))) : new C1965o(this.domain);
    }

    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    public ContiguousSet tailSetImpl(Comparable comparable, boolean z) {
        return e(Range.downTo(comparable, BoundType.forBoolean(z)));
    }
}
