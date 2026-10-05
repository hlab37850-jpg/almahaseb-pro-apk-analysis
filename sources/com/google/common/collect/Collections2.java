package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.math.IntMath;
import defpackage.AbstractC1163Zb;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public final class Collections2 {

    public static class a extends AbstractCollection {
        public final Collection a;
        public final Predicate b;

        public a(Collection collection, Predicate predicate) {
            this.a = collection;
            this.b = predicate;
        }

        public a a(Predicate predicate) {
            return new a(this.a, Predicates.and(this.b, predicate));
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(Object obj) {
            Preconditions.checkArgument(this.b.apply(obj));
            return this.a.add(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                Preconditions.checkArgument(this.b.apply(it.next()));
            }
            return this.a.addAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Iterables.removeIf(this.a, this.b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (Collections2.safeContains(this.a, obj)) {
                return this.b.apply(obj);
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection collection) {
            return Collections2.containsAllImpl(this, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return !Iterables.any(this.a, this.b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return Iterators.filter(this.a.iterator(), this.b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            return contains(obj) && this.a.remove(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection collection) {
            Iterator it = this.a.iterator();
            boolean z = false;
            while (it.hasNext()) {
                Object next = it.next();
                if (this.b.apply(next) && collection.contains(next)) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection collection) {
            Iterator it = this.a.iterator();
            boolean z = false;
            while (it.hasNext()) {
                Object next = it.next();
                if (this.b.apply(next) && !collection.contains(next)) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            Iterator it = this.a.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (this.b.apply(it.next())) {
                    i++;
                }
            }
            return i;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return Lists.newArrayList(iterator()).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            return Lists.newArrayList(iterator()).toArray(objArr);
        }
    }

    public static final class b extends AbstractCollection {
        public final ImmutableList a;
        public final Comparator b;
        public final int c;

        public b(Iterable iterable, Comparator comparator) {
            ImmutableList immutableListSortedCopyOf = ImmutableList.sortedCopyOf(comparator, iterable);
            this.a = immutableListSortedCopyOf;
            this.b = comparator;
            this.c = a(immutableListSortedCopyOf, comparator);
        }

        public static int a(List list, Comparator comparator) {
            int i = 1;
            int iSaturatedMultiply = 1;
            int i2 = 1;
            while (i < list.size()) {
                if (comparator.compare(list.get(i - 1), list.get(i)) < 0) {
                    iSaturatedMultiply = IntMath.saturatedMultiply(iSaturatedMultiply, IntMath.binomial(i, i2));
                    if (iSaturatedMultiply == Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                    i2 = 0;
                }
                i++;
                i2++;
            }
            return IntMath.saturatedMultiply(iSaturatedMultiply, IntMath.binomial(i, i2));
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof List)) {
                return false;
            }
            return Collections2.isPermutation(this.a, (List) obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new c(this.a, this.b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.c;
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            String strValueOf = String.valueOf(this.a);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 30);
            sb.append("orderedPermutationCollection(");
            sb.append(strValueOf);
            sb.append(")");
            return sb.toString();
        }
    }

    public static final class c extends AbstractIterator {
        public List a;
        public final Comparator b;

        public c(List list, Comparator comparator) {
            this.a = Lists.newArrayList(list);
            this.b = comparator;
        }

        public void a() {
            int iC = c();
            if (iC == -1) {
                this.a = null;
                return;
            }
            Objects.requireNonNull(this.a);
            Collections.swap(this.a, iC, d(iC));
            Collections.reverse(this.a.subList(iC + 1, this.a.size()));
        }

        @Override // com.google.common.collect.AbstractIterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public List computeNext() {
            List list = this.a;
            if (list == null) {
                return (List) endOfData();
            }
            ImmutableList immutableListCopyOf = ImmutableList.copyOf((Collection) list);
            a();
            return immutableListCopyOf;
        }

        public int c() {
            Objects.requireNonNull(this.a);
            for (int size = this.a.size() - 2; size >= 0; size--) {
                if (this.b.compare(this.a.get(size), this.a.get(size + 1)) < 0) {
                    return size;
                }
            }
            return -1;
        }

        public int d(int i) {
            Objects.requireNonNull(this.a);
            Object obj = this.a.get(i);
            for (int size = this.a.size() - 1; size > i; size--) {
                if (this.b.compare(obj, this.a.get(size)) < 0) {
                    return size;
                }
            }
            throw new AssertionError("this statement should be unreachable");
        }
    }

    public static final class d extends AbstractCollection {
        public final ImmutableList a;

        public d(ImmutableList immutableList) {
            this.a = immutableList;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof List)) {
                return false;
            }
            return Collections2.isPermutation(this.a, (List) obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new e(this.a);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return IntMath.factorial(this.a.size());
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            String strValueOf = String.valueOf(this.a);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 14);
            sb.append("permutations(");
            sb.append(strValueOf);
            sb.append(")");
            return sb.toString();
        }
    }

    public static class e extends AbstractIterator {
        public final List a;
        public final int[] b;
        public final int[] c;
        public int d;

        public e(List list) {
            this.a = new ArrayList(list);
            int size = list.size();
            int[] iArr = new int[size];
            this.b = iArr;
            int[] iArr2 = new int[size];
            this.c = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 1);
            this.d = Integer.MAX_VALUE;
        }

        public void a() {
            int size = this.a.size() - 1;
            this.d = size;
            if (size == -1) {
                return;
            }
            int i = 0;
            while (true) {
                int[] iArr = this.b;
                int i2 = this.d;
                int i3 = iArr[i2];
                int i4 = this.c[i2] + i3;
                if (i4 < 0) {
                    c();
                } else if (i4 != i2 + 1) {
                    Collections.swap(this.a, (i2 - i3) + i, (i2 - i4) + i);
                    this.b[this.d] = i4;
                    return;
                } else {
                    if (i2 == 0) {
                        return;
                    }
                    i++;
                    c();
                }
            }
        }

        @Override // com.google.common.collect.AbstractIterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public List computeNext() {
            if (this.d <= 0) {
                return (List) endOfData();
            }
            ImmutableList immutableListCopyOf = ImmutableList.copyOf((Collection) this.a);
            a();
            return immutableListCopyOf;
        }

        public void c() {
            int[] iArr = this.c;
            int i = this.d;
            iArr[i] = -iArr[i];
            this.d = i - 1;
        }
    }

    public static class f extends AbstractCollection {
        public final Collection a;
        public final Function b;

        public f(Collection collection, Function function) {
            this.a = (Collection) Preconditions.checkNotNull(collection);
            this.b = (Function) Preconditions.checkNotNull(function);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.a.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return Iterators.transform(this.a.iterator(), this.b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.a.size();
        }
    }

    private Collections2() {
    }

    public static boolean containsAllImpl(Collection<?> collection, Collection<?> collection2) {
        Iterator<?> it = collection2.iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    private static <E> w counts(Collection<E> collection) {
        w wVar = new w();
        for (E e2 : collection) {
            wVar.u(e2, wVar.f(e2) + 1);
        }
        return wVar;
    }

    public static <E> Collection<E> filter(Collection<E> collection, Predicate<? super E> predicate) {
        return collection instanceof a ? ((a) collection).a(predicate) : new a((Collection) Preconditions.checkNotNull(collection), (Predicate) Preconditions.checkNotNull(predicate));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isPermutation(List<?> list, List<?> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        w wVarCounts = counts(list);
        w wVarCounts2 = counts(list2);
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (wVarCounts.k(i) != wVarCounts2.f(wVarCounts.i(i))) {
                return false;
            }
        }
        return true;
    }

    public static StringBuilder newStringBuilderForCollection(int i) {
        AbstractC1163Zb.b(i, "size");
        return new StringBuilder((int) Math.min(((long) i) * 8, 1073741824L));
    }

    @Beta
    public static <E extends Comparable<? super E>> Collection<List<E>> orderedPermutations(Iterable<E> iterable) {
        return orderedPermutations(iterable, Ordering.natural());
    }

    @Beta
    public static <E> Collection<List<E>> permutations(Collection<E> collection) {
        return new d(ImmutableList.copyOf((Collection) collection));
    }

    public static boolean safeContains(Collection<?> collection, Object obj) {
        Preconditions.checkNotNull(collection);
        try {
            return collection.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static boolean safeRemove(Collection<?> collection, Object obj) {
        Preconditions.checkNotNull(collection);
        try {
            return collection.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static String toStringImpl(Collection<?> collection) {
        StringBuilder sbNewStringBuilderForCollection = newStringBuilderForCollection(collection.size());
        sbNewStringBuilderForCollection.append('[');
        boolean z = true;
        for (Object obj : collection) {
            if (!z) {
                sbNewStringBuilderForCollection.append(", ");
            }
            if (obj == collection) {
                sbNewStringBuilderForCollection.append("(this Collection)");
            } else {
                sbNewStringBuilderForCollection.append(obj);
            }
            z = false;
        }
        sbNewStringBuilderForCollection.append(']');
        return sbNewStringBuilderForCollection.toString();
    }

    public static <F, T> Collection<T> transform(Collection<F> collection, Function<? super F, T> function) {
        return new f(collection, function);
    }

    @Beta
    public static <E> Collection<List<E>> orderedPermutations(Iterable<E> iterable, Comparator<? super E> comparator) {
        return new b(iterable, comparator);
    }
}
