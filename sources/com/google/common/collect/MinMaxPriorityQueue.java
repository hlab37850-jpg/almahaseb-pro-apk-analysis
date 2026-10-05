package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import defpackage.AbstractC1163Zb;
import java.util.AbstractQueue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Queue;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtCompatible
public final class MinMaxPriorityQueue<E> extends AbstractQueue<E> {
    private static final int DEFAULT_CAPACITY = 11;
    private static final int EVEN_POWERS_OF_TWO = 1431655765;
    private static final int ODD_POWERS_OF_TWO = -1431655766;
    private final MinMaxPriorityQueue<E>.b maxHeap;

    @VisibleForTesting
    final int maximumSize;
    private final MinMaxPriorityQueue<E>.b minHeap;
    private int modCount;
    private Object[] queue;
    private int size;

    @Beta
    public static final class Builder<B> {
        private static final int UNSET_EXPECTED_SIZE = -1;
        private final Comparator<B> comparator;
        private int expectedSize;
        private int maximumSize;

        /* JADX INFO: Access modifiers changed from: private */
        public <T extends B> Ordering<T> ordering() {
            return Ordering.from(this.comparator);
        }

        public <T extends B> MinMaxPriorityQueue<T> create() {
            return create(Collections.emptySet());
        }

        @CanIgnoreReturnValue
        public Builder<B> expectedSize(int i) {
            Preconditions.checkArgument(i >= 0);
            this.expectedSize = i;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<B> maximumSize(int i) {
            Preconditions.checkArgument(i > 0);
            this.maximumSize = i;
            return this;
        }

        private Builder(Comparator<B> comparator) {
            this.expectedSize = -1;
            this.maximumSize = Integer.MAX_VALUE;
            this.comparator = (Comparator) Preconditions.checkNotNull(comparator);
        }

        public <T extends B> MinMaxPriorityQueue<T> create(Iterable<? extends T> iterable) {
            MinMaxPriorityQueue<T> minMaxPriorityQueue = new MinMaxPriorityQueue<>(this, MinMaxPriorityQueue.initialQueueSize(this.expectedSize, this.maximumSize, iterable));
            Iterator<? extends T> it = iterable.iterator();
            while (it.hasNext()) {
                minMaxPriorityQueue.offer(it.next());
            }
            return minMaxPriorityQueue;
        }
    }

    public class b {
        public final Ordering a;
        public b b;

        public b(Ordering ordering) {
            this.a = ordering;
        }

        public void b(int i, Object obj) {
            b bVar;
            int iF = f(i, obj);
            if (iF == i) {
                iF = i;
                bVar = this;
            } else {
                bVar = this.b;
            }
            bVar.c(iF, obj);
        }

        public int c(int i, Object obj) {
            while (i > 2) {
                int iK = k(i);
                Object objElementData = MinMaxPriorityQueue.this.elementData(iK);
                if (this.a.compare(objElementData, obj) <= 0) {
                    break;
                }
                MinMaxPriorityQueue.this.queue[i] = objElementData;
                i = iK;
            }
            MinMaxPriorityQueue.this.queue[i] = obj;
            return i;
        }

        public int d(int i, int i2) {
            return this.a.compare(MinMaxPriorityQueue.this.elementData(i), MinMaxPriorityQueue.this.elementData(i2));
        }

        public int e(int i, Object obj) {
            int i2 = i(i);
            if (i2 <= 0 || this.a.compare(MinMaxPriorityQueue.this.elementData(i2), obj) >= 0) {
                return f(i, obj);
            }
            MinMaxPriorityQueue.this.queue[i] = MinMaxPriorityQueue.this.elementData(i2);
            MinMaxPriorityQueue.this.queue[i2] = obj;
            return i2;
        }

        public int f(int i, Object obj) {
            int iN;
            if (i == 0) {
                MinMaxPriorityQueue.this.queue[0] = obj;
                return 0;
            }
            int iM = m(i);
            Object objElementData = MinMaxPriorityQueue.this.elementData(iM);
            if (iM != 0 && (iN = n(m(iM))) != iM && l(iN) >= MinMaxPriorityQueue.this.size) {
                Object objElementData2 = MinMaxPriorityQueue.this.elementData(iN);
                if (this.a.compare(objElementData2, objElementData) < 0) {
                    iM = iN;
                    objElementData = objElementData2;
                }
            }
            if (this.a.compare(objElementData, obj) >= 0) {
                MinMaxPriorityQueue.this.queue[i] = obj;
                return i;
            }
            MinMaxPriorityQueue.this.queue[i] = objElementData;
            MinMaxPriorityQueue.this.queue[iM] = obj;
            return iM;
        }

        public int g(int i) {
            while (true) {
                int iJ = j(i);
                if (iJ <= 0) {
                    return i;
                }
                MinMaxPriorityQueue.this.queue[i] = MinMaxPriorityQueue.this.elementData(iJ);
                i = iJ;
            }
        }

        public int h(int i, int i2) {
            if (i >= MinMaxPriorityQueue.this.size) {
                return -1;
            }
            Preconditions.checkState(i > 0);
            int iMin = Math.min(i, MinMaxPriorityQueue.this.size - i2) + i2;
            for (int i3 = i + 1; i3 < iMin; i3++) {
                if (d(i3, i) < 0) {
                    i = i3;
                }
            }
            return i;
        }

        public int i(int i) {
            return h(l(i), 2);
        }

        public int j(int i) {
            int iL = l(i);
            if (iL < 0) {
                return -1;
            }
            return h(l(iL), 4);
        }

        public final int k(int i) {
            return m(m(i));
        }

        public final int l(int i) {
            return (i * 2) + 1;
        }

        public final int m(int i) {
            return (i - 1) / 2;
        }

        public final int n(int i) {
            return (i * 2) + 2;
        }

        public int o(Object obj) {
            int iN;
            int iM = m(MinMaxPriorityQueue.this.size);
            if (iM != 0 && (iN = n(m(iM))) != iM && l(iN) >= MinMaxPriorityQueue.this.size) {
                Object objElementData = MinMaxPriorityQueue.this.elementData(iN);
                if (this.a.compare(objElementData, obj) < 0) {
                    MinMaxPriorityQueue.this.queue[iN] = obj;
                    MinMaxPriorityQueue.this.queue[MinMaxPriorityQueue.this.size] = objElementData;
                    return iN;
                }
            }
            return MinMaxPriorityQueue.this.size;
        }

        public c p(int i, int i2, Object obj) {
            int iE = e(i2, obj);
            if (iE == i2) {
                return null;
            }
            Object objElementData = iE < i ? MinMaxPriorityQueue.this.elementData(i) : MinMaxPriorityQueue.this.elementData(m(i));
            if (this.b.c(iE, obj) < i) {
                return new c(obj, objElementData);
            }
            return null;
        }

        public final boolean q(int i) {
            if (l(i) < MinMaxPriorityQueue.this.size && d(i, l(i)) > 0) {
                return false;
            }
            if (n(i) < MinMaxPriorityQueue.this.size && d(i, n(i)) > 0) {
                return false;
            }
            if (i <= 0 || d(i, m(i)) <= 0) {
                return i <= 2 || d(k(i), i) <= 0;
            }
            return false;
        }
    }

    public static class c {
        public final Object a;
        public final Object b;

        public c(Object obj, Object obj2) {
            this.a = obj;
            this.b = obj2;
        }
    }

    public class d implements Iterator {
        public int a;
        public int b;
        public int c;
        public Queue d;
        public List e;
        public Object f;
        public boolean g;

        public d() {
            this.a = -1;
            this.b = -1;
            this.c = MinMaxPriorityQueue.this.modCount;
        }

        public final void a() {
            if (MinMaxPriorityQueue.this.modCount != this.c) {
                throw new ConcurrentModificationException();
            }
        }

        public final boolean b(Iterable iterable, Object obj) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                if (it.next() == obj) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }

        public final void c(int i) {
            if (this.b < i) {
                if (this.e != null) {
                    while (i < MinMaxPriorityQueue.this.size() && b(this.e, MinMaxPriorityQueue.this.elementData(i))) {
                        i++;
                    }
                }
                this.b = i;
            }
        }

        public final boolean d(Object obj) {
            for (int i = 0; i < MinMaxPriorityQueue.this.size; i++) {
                if (MinMaxPriorityQueue.this.queue[i] == obj) {
                    MinMaxPriorityQueue.this.removeAt(i);
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            c(this.a + 1);
            if (this.b < MinMaxPriorityQueue.this.size()) {
                return true;
            }
            Queue queue = this.d;
            return (queue == null || queue.isEmpty()) ? false : true;
        }

        @Override // java.util.Iterator
        public Object next() {
            a();
            c(this.a + 1);
            if (this.b < MinMaxPriorityQueue.this.size()) {
                int i = this.b;
                this.a = i;
                this.g = true;
                return MinMaxPriorityQueue.this.elementData(i);
            }
            if (this.d != null) {
                this.a = MinMaxPriorityQueue.this.size();
                Object objPoll = this.d.poll();
                this.f = objPoll;
                if (objPoll != null) {
                    this.g = true;
                    return objPoll;
                }
            }
            throw new NoSuchElementException("iterator moved past last element in queue.");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Iterator
        public void remove() {
            AbstractC1163Zb.e(this.g);
            a();
            this.g = false;
            this.c++;
            if (this.a >= MinMaxPriorityQueue.this.size()) {
                Object obj = this.f;
                Objects.requireNonNull(obj);
                Preconditions.checkState(d(obj));
                this.f = null;
                return;
            }
            c cVarRemoveAt = MinMaxPriorityQueue.this.removeAt(this.a);
            if (cVarRemoveAt != null) {
                if (this.d == null || this.e == null) {
                    this.d = new ArrayDeque();
                    this.e = new ArrayList(3);
                }
                if (!b(this.e, cVarRemoveAt.a)) {
                    this.d.add(cVarRemoveAt.a);
                }
                if (!b(this.d, cVarRemoveAt.b)) {
                    this.e.add(cVarRemoveAt.b);
                }
            }
            this.a--;
            this.b--;
        }
    }

    private int calculateNewCapacity() {
        int length = this.queue.length;
        return capAtMaximumSize(length < 64 ? (length + 1) * 2 : IntMath.checkedMultiply(length / 2, 3), this.maximumSize);
    }

    private static int capAtMaximumSize(int i, int i2) {
        return Math.min(i - 1, i2) + 1;
    }

    public static <E extends Comparable<E>> MinMaxPriorityQueue<E> create() {
        return new Builder(Ordering.natural()).create();
    }

    public static Builder<Comparable> expectedSize(int i) {
        return new Builder(Ordering.natural()).expectedSize(i);
    }

    private c fillHole(int i, E e) {
        MinMaxPriorityQueue<E>.b bVarHeapForIndex = heapForIndex(i);
        int iG = bVarHeapForIndex.g(i);
        int iC = bVarHeapForIndex.c(iG, e);
        if (iC == iG) {
            return bVarHeapForIndex.p(i, iG, e);
        }
        if (iC < i) {
            return new c(e, elementData(i));
        }
        return null;
    }

    private int getMaxElementIndex() {
        int i = this.size;
        if (i != 1) {
            return (i == 2 || this.maxHeap.d(1, 2) <= 0) ? 1 : 2;
        }
        return 0;
    }

    private void growIfNeeded() {
        if (this.size > this.queue.length) {
            Object[] objArr = new Object[calculateNewCapacity()];
            Object[] objArr2 = this.queue;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.queue = objArr;
        }
    }

    private MinMaxPriorityQueue<E>.b heapForIndex(int i) {
        return isEvenLevel(i) ? this.minHeap : this.maxHeap;
    }

    @VisibleForTesting
    public static int initialQueueSize(int i, int i2, Iterable<?> iterable) {
        if (i == -1) {
            i = 11;
        }
        if (iterable instanceof Collection) {
            i = Math.max(i, ((Collection) iterable).size());
        }
        return capAtMaximumSize(i, i2);
    }

    @VisibleForTesting
    public static boolean isEvenLevel(int i) {
        int i2 = ~(~(i + 1));
        Preconditions.checkState(i2 > 0, "negative index");
        return (EVEN_POWERS_OF_TWO & i2) > (i2 & ODD_POWERS_OF_TWO);
    }

    public static Builder<Comparable> maximumSize(int i) {
        return new Builder(Ordering.natural()).maximumSize(i);
    }

    public static <B> Builder<B> orderedBy(Comparator<B> comparator) {
        return new Builder<>(comparator);
    }

    private E removeAndGet(int i) {
        E eElementData = elementData(i);
        removeAt(i);
        return eElementData;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
    @CanIgnoreReturnValue
    public boolean add(E e) {
        offer(e);
        return true;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    public boolean addAll(Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            offer(it.next());
            z = true;
        }
        return z;
    }

    @VisibleForTesting
    public int capacity() {
        return this.queue.length;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        for (int i = 0; i < this.size; i++) {
            this.queue[i] = null;
        }
        this.size = 0;
    }

    public Comparator<? super E> comparator() {
        return this.minHeap.a;
    }

    public E elementData(int i) {
        E e = (E) this.queue[i];
        Objects.requireNonNull(e);
        return e;
    }

    @VisibleForTesting
    public boolean isIntact() {
        for (int i = 1; i < this.size; i++) {
            if (!heapForIndex(i).q(i)) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new d();
    }

    @Override // java.util.Queue
    @CanIgnoreReturnValue
    public boolean offer(E e) {
        Preconditions.checkNotNull(e);
        this.modCount++;
        int i = this.size;
        this.size = i + 1;
        growIfNeeded();
        heapForIndex(i).b(i, e);
        return this.size <= this.maximumSize || pollLast() != e;
    }

    @Override // java.util.Queue
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return elementData(0);
    }

    public E peekFirst() {
        return peek();
    }

    public E peekLast() {
        if (isEmpty()) {
            return null;
        }
        return elementData(getMaxElementIndex());
    }

    @Override // java.util.Queue
    @CanIgnoreReturnValue
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        return removeAndGet(0);
    }

    @CanIgnoreReturnValue
    public E pollFirst() {
        return poll();
    }

    @CanIgnoreReturnValue
    public E pollLast() {
        if (isEmpty()) {
            return null;
        }
        return removeAndGet(getMaxElementIndex());
    }

    @VisibleForTesting
    @CanIgnoreReturnValue
    public c removeAt(int i) {
        Preconditions.checkPositionIndex(i, this.size);
        this.modCount++;
        int i2 = this.size - 1;
        this.size = i2;
        if (i2 == i) {
            this.queue[i2] = null;
            return null;
        }
        E eElementData = elementData(i2);
        int iO = heapForIndex(this.size).o(eElementData);
        if (iO == i) {
            this.queue[this.size] = null;
            return null;
        }
        E eElementData2 = elementData(this.size);
        this.queue[this.size] = null;
        c cVarFillHole = fillHole(i, eElementData2);
        if (iO < i) {
            return cVarFillHole == null ? new c(eElementData, eElementData2) : new c(eElementData, cVarFillHole.b);
        }
        return cVarFillHole;
    }

    @CanIgnoreReturnValue
    public E removeFirst() {
        return remove();
    }

    @CanIgnoreReturnValue
    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return removeAndGet(getMaxElementIndex());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        int i = this.size;
        Object[] objArr = new Object[i];
        System.arraycopy(this.queue, 0, objArr, 0, i);
        return objArr;
    }

    private MinMaxPriorityQueue(Builder<? super E> builder, int i) {
        Ordering ordering = builder.ordering();
        MinMaxPriorityQueue<E>.b bVar = new b(ordering);
        this.minHeap = bVar;
        MinMaxPriorityQueue<E>.b bVar2 = new b(ordering.reverse());
        this.maxHeap = bVar2;
        bVar.b = bVar2;
        bVar2.b = bVar;
        this.maximumSize = ((Builder) builder).maximumSize;
        this.queue = new Object[i];
    }

    public static <E extends Comparable<E>> MinMaxPriorityQueue<E> create(Iterable<? extends E> iterable) {
        return new Builder(Ordering.natural()).create(iterable);
    }
}
