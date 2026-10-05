package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import defpackage.AbstractC1163Zb;
import defpackage.AbstractC2362hV;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public final class Multisets {

    public class a extends n {
        public final /* synthetic */ Multiset a;
        public final /* synthetic */ Multiset b;

        /* JADX INFO: renamed from: com.google.common.collect.Multisets$a$a, reason: collision with other inner class name */
        public class C0230a extends AbstractIterator {
            public final /* synthetic */ Iterator a;
            public final /* synthetic */ Iterator b;

            public C0230a(Iterator it, Iterator it2) {
                this.a = it;
                this.b = it2;
            }

            @Override // com.google.common.collect.AbstractIterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Multiset.Entry computeNext() {
                if (this.a.hasNext()) {
                    Multiset.Entry entry = (Multiset.Entry) this.a.next();
                    Object element = entry.getElement();
                    return Multisets.immutableEntry(element, Math.max(entry.getCount(), a.this.b.count(element)));
                }
                while (this.b.hasNext()) {
                    Multiset.Entry entry2 = (Multiset.Entry) this.b.next();
                    Object element2 = entry2.getElement();
                    if (!a.this.a.contains(element2)) {
                        return Multisets.immutableEntry(element2, entry2.getCount());
                    }
                }
                return (Multiset.Entry) endOfData();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Multiset multiset, Multiset multiset2) {
            super(null);
            this.a = multiset;
            this.b = multiset2;
        }

        @Override // com.google.common.collect.AbstractC1955e, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
        public boolean contains(Object obj) {
            return this.a.contains(obj) || this.b.contains(obj);
        }

        @Override // com.google.common.collect.Multiset
        public int count(Object obj) {
            return Math.max(this.a.count(obj), this.b.count(obj));
        }

        @Override // com.google.common.collect.AbstractC1955e
        public Set createElementSet() {
            return Sets.union(this.a.elementSet(), this.b.elementSet());
        }

        @Override // com.google.common.collect.AbstractC1955e
        public Iterator elementIterator() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.AbstractC1955e
        public Iterator entryIterator() {
            return new C0230a(this.a.entrySet().iterator(), this.b.entrySet().iterator());
        }

        @Override // com.google.common.collect.AbstractC1955e, java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.a.isEmpty() && this.b.isEmpty();
        }
    }

    public class b extends n {
        public final /* synthetic */ Multiset a;
        public final /* synthetic */ Multiset b;

        public class a extends AbstractIterator {
            public final /* synthetic */ Iterator a;

            public a(Iterator it) {
                this.a = it;
            }

            @Override // com.google.common.collect.AbstractIterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Multiset.Entry computeNext() {
                while (this.a.hasNext()) {
                    Multiset.Entry entry = (Multiset.Entry) this.a.next();
                    Object element = entry.getElement();
                    int iMin = Math.min(entry.getCount(), b.this.b.count(element));
                    if (iMin > 0) {
                        return Multisets.immutableEntry(element, iMin);
                    }
                }
                return (Multiset.Entry) endOfData();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Multiset multiset, Multiset multiset2) {
            super(null);
            this.a = multiset;
            this.b = multiset2;
        }

        @Override // com.google.common.collect.Multiset
        public int count(Object obj) {
            int iCount = this.a.count(obj);
            if (iCount == 0) {
                return 0;
            }
            return Math.min(iCount, this.b.count(obj));
        }

        @Override // com.google.common.collect.AbstractC1955e
        public Set createElementSet() {
            return Sets.intersection(this.a.elementSet(), this.b.elementSet());
        }

        @Override // com.google.common.collect.AbstractC1955e
        public Iterator elementIterator() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.AbstractC1955e
        public Iterator entryIterator() {
            return new a(this.a.entrySet().iterator());
        }
    }

    public class c extends n {
        public final /* synthetic */ Multiset a;
        public final /* synthetic */ Multiset b;

        public class a extends AbstractIterator {
            public final /* synthetic */ Iterator a;
            public final /* synthetic */ Iterator b;

            public a(Iterator it, Iterator it2) {
                this.a = it;
                this.b = it2;
            }

            @Override // com.google.common.collect.AbstractIterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Multiset.Entry computeNext() {
                if (this.a.hasNext()) {
                    Multiset.Entry entry = (Multiset.Entry) this.a.next();
                    Object element = entry.getElement();
                    return Multisets.immutableEntry(element, entry.getCount() + c.this.b.count(element));
                }
                while (this.b.hasNext()) {
                    Multiset.Entry entry2 = (Multiset.Entry) this.b.next();
                    Object element2 = entry2.getElement();
                    if (!c.this.a.contains(element2)) {
                        return Multisets.immutableEntry(element2, entry2.getCount());
                    }
                }
                return (Multiset.Entry) endOfData();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Multiset multiset, Multiset multiset2) {
            super(null);
            this.a = multiset;
            this.b = multiset2;
        }

        @Override // com.google.common.collect.AbstractC1955e, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
        public boolean contains(Object obj) {
            return this.a.contains(obj) || this.b.contains(obj);
        }

        @Override // com.google.common.collect.Multiset
        public int count(Object obj) {
            return this.a.count(obj) + this.b.count(obj);
        }

        @Override // com.google.common.collect.AbstractC1955e
        public Set createElementSet() {
            return Sets.union(this.a.elementSet(), this.b.elementSet());
        }

        @Override // com.google.common.collect.AbstractC1955e
        public Iterator elementIterator() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.AbstractC1955e
        public Iterator entryIterator() {
            return new a(this.a.entrySet().iterator(), this.b.entrySet().iterator());
        }

        @Override // com.google.common.collect.AbstractC1955e, java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.a.isEmpty() && this.b.isEmpty();
        }

        @Override // com.google.common.collect.Multisets.n, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
        public int size() {
            return IntMath.saturatedAdd(this.a.size(), this.b.size());
        }
    }

    public class d extends n {
        public final /* synthetic */ Multiset a;
        public final /* synthetic */ Multiset b;

        public class a extends AbstractIterator {
            public final /* synthetic */ Iterator a;

            public a(Iterator it) {
                this.a = it;
            }

            @Override // com.google.common.collect.AbstractIterator
            public Object computeNext() {
                while (this.a.hasNext()) {
                    Multiset.Entry entry = (Multiset.Entry) this.a.next();
                    Object element = entry.getElement();
                    if (entry.getCount() > d.this.b.count(element)) {
                        return element;
                    }
                }
                return endOfData();
            }
        }

        public class b extends AbstractIterator {
            public final /* synthetic */ Iterator a;

            public b(Iterator it) {
                this.a = it;
            }

            @Override // com.google.common.collect.AbstractIterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Multiset.Entry computeNext() {
                while (this.a.hasNext()) {
                    Multiset.Entry entry = (Multiset.Entry) this.a.next();
                    Object element = entry.getElement();
                    int count = entry.getCount() - d.this.b.count(element);
                    if (count > 0) {
                        return Multisets.immutableEntry(element, count);
                    }
                }
                return (Multiset.Entry) endOfData();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Multiset multiset, Multiset multiset2) {
            super(null);
            this.a = multiset;
            this.b = multiset2;
        }

        @Override // com.google.common.collect.Multisets.n, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multiset
        public int count(Object obj) {
            int iCount = this.a.count(obj);
            if (iCount == 0) {
                return 0;
            }
            return Math.max(0, iCount - this.b.count(obj));
        }

        @Override // com.google.common.collect.Multisets.n, com.google.common.collect.AbstractC1955e
        public int distinctElements() {
            return Iterators.size(entryIterator());
        }

        @Override // com.google.common.collect.AbstractC1955e
        public Iterator elementIterator() {
            return new a(this.a.entrySet().iterator());
        }

        @Override // com.google.common.collect.AbstractC1955e
        public Iterator entryIterator() {
            return new b(this.a.entrySet().iterator());
        }
    }

    public class e extends AbstractC2362hV {
        public e(Iterator it) {
            super(it);
        }

        @Override // defpackage.AbstractC2362hV
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Object a(Multiset.Entry entry) {
            return entry.getElement();
        }
    }

    public static abstract class f implements Multiset.Entry {
        @Override // com.google.common.collect.Multiset.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Multiset.Entry)) {
                return false;
            }
            Multiset.Entry entry = (Multiset.Entry) obj;
            return getCount() == entry.getCount() && Objects.equal(getElement(), entry.getElement());
        }

        @Override // com.google.common.collect.Multiset.Entry
        public int hashCode() {
            Object element = getElement();
            return (element == null ? 0 : element.hashCode()) ^ getCount();
        }

        @Override // com.google.common.collect.Multiset.Entry
        public String toString() {
            String strValueOf = String.valueOf(getElement());
            int count = getCount();
            if (count == 1) {
                return strValueOf;
            }
            StringBuilder sb = new StringBuilder(strValueOf.length() + 14);
            sb.append(strValueOf);
            sb.append(" x ");
            sb.append(count);
            return sb.toString();
        }
    }

    public static final class g implements Comparator {
        public static final g a = new g();

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Multiset.Entry entry, Multiset.Entry entry2) {
            return entry2.getCount() - entry.getCount();
        }
    }

    public static abstract class h extends Sets.k {
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            multiset().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return multiset().contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return multiset().containsAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return multiset().isEmpty();
        }

        public abstract Multiset multiset();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return multiset().remove(obj, Integer.MAX_VALUE) > 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return multiset().entrySet().size();
        }
    }

    public static abstract class i extends Sets.k {
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            multiset().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Multiset.Entry)) {
                return false;
            }
            Multiset.Entry entry = (Multiset.Entry) obj;
            return entry.getCount() > 0 && multiset().count(entry.getElement()) == entry.getCount();
        }

        public abstract Multiset multiset();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (obj instanceof Multiset.Entry) {
                Multiset.Entry entry = (Multiset.Entry) obj;
                Object element = entry.getElement();
                int count = entry.getCount();
                if (count != 0) {
                    return multiset().setCount(element, count, 0);
                }
            }
            return false;
        }
    }

    public static final class j extends n {
        public final Multiset a;
        public final Predicate b;

        public class a implements Predicate {
            public a() {
            }

            @Override // com.google.common.base.Predicate
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean apply(Multiset.Entry entry) {
                return j.this.b.apply(entry.getElement());
            }
        }

        public j(Multiset multiset, Predicate predicate) {
            super(null);
            this.a = (Multiset) Preconditions.checkNotNull(multiset);
            this.b = (Predicate) Preconditions.checkNotNull(predicate);
        }

        @Override // com.google.common.collect.Multisets.n, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public UnmodifiableIterator iterator() {
            return Iterators.filter(this.a.iterator(), this.b);
        }

        @Override // com.google.common.collect.AbstractC1955e, com.google.common.collect.Multiset
        public int add(Object obj, int i) {
            Preconditions.checkArgument(this.b.apply(obj), "Element %s does not match predicate %s", obj, this.b);
            return this.a.add(obj, i);
        }

        @Override // com.google.common.collect.Multiset
        public int count(Object obj) {
            int iCount = this.a.count(obj);
            if (iCount <= 0 || !this.b.apply(obj)) {
                return 0;
            }
            return iCount;
        }

        @Override // com.google.common.collect.AbstractC1955e
        public Set createElementSet() {
            return Sets.filter(this.a.elementSet(), this.b);
        }

        @Override // com.google.common.collect.AbstractC1955e
        public Set createEntrySet() {
            return Sets.filter(this.a.entrySet(), new a());
        }

        @Override // com.google.common.collect.AbstractC1955e
        public Iterator elementIterator() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.AbstractC1955e
        public Iterator entryIterator() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.AbstractC1955e, com.google.common.collect.Multiset
        public int remove(Object obj, int i) {
            AbstractC1163Zb.b(i, "occurrences");
            if (i == 0) {
                return count(obj);
            }
            if (contains(obj)) {
                return this.a.remove(obj, i);
            }
            return 0;
        }
    }

    public static class k extends f implements Serializable {
        public final Object a;
        public final int b;

        public k(Object obj, int i) {
            this.a = obj;
            this.b = i;
            AbstractC1163Zb.b(i, "count");
        }

        @Override // com.google.common.collect.Multiset.Entry
        public final int getCount() {
            return this.b;
        }

        @Override // com.google.common.collect.Multiset.Entry
        public final Object getElement() {
            return this.a;
        }
    }

    public static final class l implements Iterator {
        public final Multiset a;
        public final Iterator b;
        public Multiset.Entry c;
        public int d;
        public int e;
        public boolean f;

        public l(Multiset multiset, Iterator it) {
            this.a = multiset;
            this.b = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.d > 0 || this.b.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (this.d == 0) {
                Multiset.Entry entry = (Multiset.Entry) this.b.next();
                this.c = entry;
                int count = entry.getCount();
                this.d = count;
                this.e = count;
            }
            this.d--;
            this.f = true;
            Multiset.Entry entry2 = this.c;
            java.util.Objects.requireNonNull(entry2);
            return entry2.getElement();
        }

        @Override // java.util.Iterator
        public void remove() {
            AbstractC1163Zb.e(this.f);
            if (this.e == 1) {
                this.b.remove();
            } else {
                Multiset multiset = this.a;
                Multiset.Entry entry = this.c;
                java.util.Objects.requireNonNull(entry);
                multiset.remove(entry.getElement());
            }
            this.e--;
            this.f = false;
        }
    }

    public static class m extends ForwardingMultiset implements Serializable {
        public final Multiset a;
        public transient Set b;
        public transient Set c;

        public m(Multiset multiset) {
            this.a = multiset;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
        public boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        public Set c() {
            return Collections.unmodifiableSet(this.a.elementSet());
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public Set elementSet() {
            Set set = this.b;
            if (set != null) {
                return set;
            }
            Set setC = c();
            this.b = setC;
            return setC;
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public Set entrySet() {
            Set set = this.c;
            if (set != null) {
                return set;
            }
            Set setUnmodifiableSet = Collections.unmodifiableSet(this.a.entrySet());
            this.c = setUnmodifiableSet;
            return setUnmodifiableSet;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return Iterators.unmodifiableIterator(this.a.iterator());
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public boolean retainAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public int setCount(Object obj, int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public int add(Object obj, int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public int remove(Object obj, int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
        public boolean setCount(Object obj, int i, int i2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Multiset delegate() {
            return this.a;
        }
    }

    public static abstract class n extends AbstractC1955e {
        public n() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            elementSet().clear();
        }

        @Override // com.google.common.collect.AbstractC1955e
        public int distinctElements() {
            return elementSet().size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
        public Iterator iterator() {
            return Multisets.iteratorImpl(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
        public int size() {
            return Multisets.linearTimeSizeImpl(this);
        }

        public /* synthetic */ n(a aVar) {
            this();
        }
    }

    private Multisets() {
    }

    public static <E> boolean addAllImpl(Multiset<E> multiset, Collection<? extends E> collection) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(collection);
        if (collection instanceof Multiset) {
            return addAllImpl((Multiset) multiset, cast(collection));
        }
        if (collection.isEmpty()) {
            return false;
        }
        return Iterators.addAll(multiset, collection.iterator());
    }

    public static <T> Multiset<T> cast(Iterable<T> iterable) {
        return (Multiset) iterable;
    }

    @CanIgnoreReturnValue
    public static boolean containsOccurrences(Multiset<?> multiset, Multiset<?> multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        for (Multiset.Entry<?> entry : multiset2.entrySet()) {
            if (multiset.count(entry.getElement()) < entry.getCount()) {
                return false;
            }
        }
        return true;
    }

    @Beta
    public static <E> ImmutableMultiset<E> copyHighestCountFirst(Multiset<E> multiset) {
        Multiset.Entry[] entryArr = (Multiset.Entry[]) multiset.entrySet().toArray(new Multiset.Entry[0]);
        Arrays.sort(entryArr, g.a);
        return ImmutableMultiset.copyFromEntries(Arrays.asList(entryArr));
    }

    @Beta
    public static <E> Multiset<E> difference(Multiset<E> multiset, Multiset<?> multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        return new d(multiset, multiset2);
    }

    public static <E> Iterator<E> elementIterator(Iterator<Multiset.Entry<E>> it) {
        return new e(it);
    }

    public static boolean equalsImpl(Multiset<?> multiset, Object obj) {
        if (obj == multiset) {
            return true;
        }
        if (obj instanceof Multiset) {
            Multiset multiset2 = (Multiset) obj;
            if (multiset.size() == multiset2.size() && multiset.entrySet().size() == multiset2.entrySet().size()) {
                for (Multiset.Entry entry : multiset2.entrySet()) {
                    if (multiset.count(entry.getElement()) != entry.getCount()) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Beta
    public static <E> Multiset<E> filter(Multiset<E> multiset, Predicate<? super E> predicate) {
        if (!(multiset instanceof j)) {
            return new j(multiset, predicate);
        }
        j jVar = (j) multiset;
        return new j(jVar.a, Predicates.and(jVar.b, predicate));
    }

    public static <E> Multiset.Entry<E> immutableEntry(E e2, int i2) {
        return new k(e2, i2);
    }

    public static int inferDistinctElements(Iterable<?> iterable) {
        if (iterable instanceof Multiset) {
            return ((Multiset) iterable).elementSet().size();
        }
        return 11;
    }

    public static <E> Multiset<E> intersection(Multiset<E> multiset, Multiset<?> multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        return new b(multiset, multiset2);
    }

    public static <E> Iterator<E> iteratorImpl(Multiset<E> multiset) {
        return new l(multiset, multiset.entrySet().iterator());
    }

    public static int linearTimeSizeImpl(Multiset<?> multiset) {
        Iterator<Multiset.Entry<?>> it = multiset.entrySet().iterator();
        long count = 0;
        while (it.hasNext()) {
            count += (long) it.next().getCount();
        }
        return Ints.saturatedCast(count);
    }

    public static boolean removeAllImpl(Multiset<?> multiset, Collection<?> collection) {
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).elementSet();
        }
        return multiset.elementSet().removeAll(collection);
    }

    @CanIgnoreReturnValue
    public static boolean removeOccurrences(Multiset<?> multiset, Iterable<?> iterable) {
        if (iterable instanceof Multiset) {
            return removeOccurrences(multiset, (Multiset<?>) iterable);
        }
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(iterable);
        Iterator<?> it = iterable.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= multiset.remove(it.next());
        }
        return zRemove;
    }

    public static boolean retainAllImpl(Multiset<?> multiset, Collection<?> collection) {
        Preconditions.checkNotNull(collection);
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).elementSet();
        }
        return multiset.elementSet().retainAll(collection);
    }

    @CanIgnoreReturnValue
    public static boolean retainOccurrences(Multiset<?> multiset, Multiset<?> multiset2) {
        return retainOccurrencesImpl(multiset, multiset2);
    }

    private static <E> boolean retainOccurrencesImpl(Multiset<E> multiset, Multiset<?> multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        Iterator<Multiset.Entry<E>> it = multiset.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            Multiset.Entry<E> next = it.next();
            int iCount = multiset2.count(next.getElement());
            if (iCount == 0) {
                it.remove();
            } else if (iCount < next.getCount()) {
                multiset.setCount(next.getElement(), iCount);
            }
            z = true;
        }
        return z;
    }

    public static <E> int setCountImpl(Multiset<E> multiset, E e2, int i2) {
        AbstractC1163Zb.b(i2, "count");
        int iCount = multiset.count(e2);
        int i3 = i2 - iCount;
        if (i3 > 0) {
            multiset.add(e2, i3);
        } else if (i3 < 0) {
            multiset.remove(e2, -i3);
        }
        return iCount;
    }

    @Beta
    public static <E> Multiset<E> sum(Multiset<? extends E> multiset, Multiset<? extends E> multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        return new c(multiset, multiset2);
    }

    @Beta
    public static <E> Multiset<E> union(Multiset<? extends E> multiset, Multiset<? extends E> multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        return new a(multiset, multiset2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> Multiset<E> unmodifiableMultiset(Multiset<? extends E> multiset) {
        return ((multiset instanceof m) || (multiset instanceof ImmutableMultiset)) ? multiset : new m((Multiset) Preconditions.checkNotNull(multiset));
    }

    @Beta
    public static <E> SortedMultiset<E> unmodifiableSortedMultiset(SortedMultiset<E> sortedMultiset) {
        return new O((SortedMultiset) Preconditions.checkNotNull(sortedMultiset));
    }

    @Deprecated
    public static <E> Multiset<E> unmodifiableMultiset(ImmutableMultiset<E> immutableMultiset) {
        return (Multiset) Preconditions.checkNotNull(immutableMultiset);
    }

    public static <E> boolean setCountImpl(Multiset<E> multiset, E e2, int i2, int i3) {
        AbstractC1163Zb.b(i2, "oldCount");
        AbstractC1163Zb.b(i3, "newCount");
        if (multiset.count(e2) != i2) {
            return false;
        }
        multiset.setCount(e2, i3);
        return true;
    }

    private static <E> boolean addAllImpl(Multiset<E> multiset, Multiset<? extends E> multiset2) {
        if (multiset2 instanceof AbstractC1953c) {
            return addAllImpl((Multiset) multiset, (AbstractC1953c) multiset2);
        }
        if (multiset2.isEmpty()) {
            return false;
        }
        for (Multiset.Entry<? extends E> entry : multiset2.entrySet()) {
            multiset.add(entry.getElement(), entry.getCount());
        }
        return true;
    }

    @CanIgnoreReturnValue
    public static boolean removeOccurrences(Multiset<?> multiset, Multiset<?> multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        Iterator<Multiset.Entry<?>> it = multiset.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            Multiset.Entry<?> next = it.next();
            int iCount = multiset2.count(next.getElement());
            if (iCount >= next.getCount()) {
                it.remove();
            } else if (iCount > 0) {
                multiset.remove(next.getElement(), iCount);
            }
            z = true;
        }
        return z;
    }

    private static <E> boolean addAllImpl(Multiset<E> multiset, AbstractC1953c abstractC1953c) {
        if (abstractC1953c.isEmpty()) {
            return false;
        }
        abstractC1953c.addTo(multiset);
        return true;
    }
}
