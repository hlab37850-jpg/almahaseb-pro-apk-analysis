package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import com.google.common.math.IntMath;
import com.google.common.util.concurrent.Striped;
import defpackage.AbstractConditionC0775Nn;
import defpackage.AbstractLockC0862Qn;
import defpackage.CS;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtIncompatible
public abstract class Striped<L> {
    private static final int ALL_SET = -1;
    private static final int LARGE_LAZY_CUTOFF = 1024;

    public static class b extends f {
        public final Object[] b;

        @Override // com.google.common.util.concurrent.Striped
        public Object getAt(int i) {
            return this.b[i];
        }

        @Override // com.google.common.util.concurrent.Striped
        public int size() {
            return this.b.length;
        }

        public b(int i, Supplier supplier) {
            super(i);
            int i2 = 0;
            Preconditions.checkArgument(i <= 1073741824, "Stripes must be <= 2^30)");
            this.b = new Object[this.a + 1];
            while (true) {
                Object[] objArr = this.b;
                if (i2 >= objArr.length) {
                    return;
                }
                objArr[i2] = supplier.get();
                i2++;
            }
        }
    }

    public static class c extends f {
        public final ConcurrentMap b;
        public final Supplier c;
        public final int d;

        public c(int i, Supplier supplier) {
            super(i);
            int i2 = this.a;
            this.d = i2 == -1 ? Integer.MAX_VALUE : i2 + 1;
            this.c = supplier;
            this.b = new MapMaker().weakValues().makeMap();
        }

        @Override // com.google.common.util.concurrent.Striped
        public Object getAt(int i) {
            if (this.d != Integer.MAX_VALUE) {
                Preconditions.checkElementIndex(i, size());
            }
            Object obj = this.b.get(Integer.valueOf(i));
            if (obj != null) {
                return obj;
            }
            Object obj2 = this.c.get();
            return MoreObjects.firstNonNull(this.b.putIfAbsent(Integer.valueOf(i), obj2), obj2);
        }

        @Override // com.google.common.util.concurrent.Striped
        public int size() {
            return this.d;
        }
    }

    public static class d extends ReentrantLock {
        public d() {
            super(false);
        }
    }

    public static class e extends Semaphore {
        public e(int i) {
            super(i, false);
        }
    }

    public static abstract class f extends Striped {
        public final int a;

        public f(int i) {
            super();
            Preconditions.checkArgument(i > 0, "Stripes must be positive");
            this.a = i > 1073741824 ? -1 : Striped.ceilToPowerOfTwo(i) - 1;
        }

        @Override // com.google.common.util.concurrent.Striped
        public final Object get(Object obj) {
            return getAt(indexFor(obj));
        }

        @Override // com.google.common.util.concurrent.Striped
        public final int indexFor(Object obj) {
            return Striped.smear(obj.hashCode()) & this.a;
        }
    }

    public static class g extends f {
        public final AtomicReferenceArray b;
        public final Supplier c;
        public final int d;
        public final ReferenceQueue e;

        public static final class a extends WeakReference {
            public final int a;

            public a(Object obj, int i, ReferenceQueue referenceQueue) {
                super(obj, referenceQueue);
                this.a = i;
            }
        }

        public g(int i, Supplier supplier) {
            super(i);
            this.e = new ReferenceQueue();
            int i2 = this.a;
            int i3 = i2 == -1 ? Integer.MAX_VALUE : i2 + 1;
            this.d = i3;
            this.b = new AtomicReferenceArray(i3);
            this.c = supplier;
        }

        public final void d() {
            while (true) {
                Reference referencePoll = this.e.poll();
                if (referencePoll == null) {
                    return;
                }
                a aVar = (a) referencePoll;
                CS.a(this.b, aVar.a, aVar, null);
            }
        }

        @Override // com.google.common.util.concurrent.Striped
        public Object getAt(int i) {
            if (this.d != Integer.MAX_VALUE) {
                Preconditions.checkElementIndex(i, size());
            }
            a aVar = (a) this.b.get(i);
            Object obj = aVar == null ? null : aVar.get();
            if (obj != null) {
                return obj;
            }
            Object obj2 = this.c.get();
            a aVar2 = new a(obj2, i, this.e);
            while (!CS.a(this.b, i, aVar, aVar2)) {
                aVar = (a) this.b.get(i);
                Object obj3 = aVar == null ? null : aVar.get();
                if (obj3 != null) {
                    return obj3;
                }
            }
            d();
            return obj2;
        }

        @Override // com.google.common.util.concurrent.Striped
        public int size() {
            return this.d;
        }
    }

    public static final class h extends AbstractConditionC0775Nn {
        public final Condition a;
        public final j b;

        public h(Condition condition, j jVar) {
            this.a = condition;
            this.b = jVar;
        }

        @Override // defpackage.AbstractConditionC0775Nn
        public Condition a() {
            return this.a;
        }
    }

    public static final class i extends AbstractLockC0862Qn {
        public final Lock a;
        public final j b;

        public i(Lock lock, j jVar) {
            this.a = lock;
            this.b = jVar;
        }

        @Override // defpackage.AbstractLockC0862Qn
        public Lock a() {
            return this.a;
        }

        @Override // java.util.concurrent.locks.Lock
        public Condition newCondition() {
            return new h(this.a.newCondition(), this.b);
        }
    }

    public static final class j implements ReadWriteLock {
        public final ReadWriteLock a = new ReentrantReadWriteLock();

        @Override // java.util.concurrent.locks.ReadWriteLock
        public Lock readLock() {
            return new i(this.a.readLock(), this);
        }

        @Override // java.util.concurrent.locks.ReadWriteLock
        public Lock writeLock() {
            return new i(this.a.writeLock(), this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int ceilToPowerOfTwo(int i2) {
        return 1 << IntMath.log2(i2, RoundingMode.CEILING);
    }

    public static <L> Striped<L> custom(int i2, Supplier<L> supplier) {
        return new b(i2, supplier);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Lock lambda$lazyWeakLock$0() {
        return new ReentrantLock(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Semaphore lambda$lazyWeakSemaphore$2(int i2) {
        return new Semaphore(i2, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Semaphore lambda$semaphore$1(int i2) {
        return new e(i2);
    }

    private static <L> Striped<L> lazy(int i2, Supplier<L> supplier) {
        return i2 < 1024 ? new g(i2, supplier) : new c(i2, supplier);
    }

    public static Striped<Lock> lazyWeakLock(int i2) {
        return lazy(i2, new Supplier() { // from class: AS
            @Override // com.google.common.base.Supplier
            public final Object get() {
                return Striped.lambda$lazyWeakLock$0();
            }
        });
    }

    public static Striped<ReadWriteLock> lazyWeakReadWriteLock(int i2) {
        return lazy(i2, new Supplier() { // from class: wS
            @Override // com.google.common.base.Supplier
            public final Object get() {
                return new Striped.j();
            }
        });
    }

    public static Striped<Semaphore> lazyWeakSemaphore(int i2, final int i3) {
        return lazy(i2, new Supplier() { // from class: zS
            @Override // com.google.common.base.Supplier
            public final Object get() {
                return Striped.lambda$lazyWeakSemaphore$2(i3);
            }
        });
    }

    public static Striped<Lock> lock(int i2) {
        return custom(i2, new Supplier() { // from class: xS
            @Override // com.google.common.base.Supplier
            public final Object get() {
                return new Striped.d();
            }
        });
    }

    public static Striped<ReadWriteLock> readWriteLock(int i2) {
        return custom(i2, new Supplier() { // from class: BS
            @Override // com.google.common.base.Supplier
            public final Object get() {
                return new ReentrantReadWriteLock();
            }
        });
    }

    public static Striped<Semaphore> semaphore(int i2, final int i3) {
        return custom(i2, new Supplier() { // from class: yS
            @Override // com.google.common.base.Supplier
            public final Object get() {
                return Striped.lambda$semaphore$1(i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int smear(int i2) {
        int i3 = i2 ^ ((i2 >>> 20) ^ (i2 >>> 12));
        return (i3 >>> 4) ^ ((i3 >>> 7) ^ i3);
    }

    public Iterable<L> bulkGet(Iterable<? extends Object> iterable) {
        ArrayList arrayListNewArrayList = Lists.newArrayList(iterable);
        if (arrayListNewArrayList.isEmpty()) {
            return ImmutableList.of();
        }
        int[] iArr = new int[arrayListNewArrayList.size()];
        for (int i2 = 0; i2 < arrayListNewArrayList.size(); i2++) {
            iArr[i2] = indexFor(arrayListNewArrayList.get(i2));
        }
        Arrays.sort(iArr);
        int i3 = iArr[0];
        arrayListNewArrayList.set(0, getAt(i3));
        for (int i4 = 1; i4 < arrayListNewArrayList.size(); i4++) {
            int i5 = iArr[i4];
            if (i5 == i3) {
                arrayListNewArrayList.set(i4, arrayListNewArrayList.get(i4 - 1));
            } else {
                arrayListNewArrayList.set(i4, getAt(i5));
                i3 = i5;
            }
        }
        return Collections.unmodifiableList(arrayListNewArrayList);
    }

    public abstract L get(Object obj);

    public abstract L getAt(int i2);

    public abstract int indexFor(Object obj);

    public abstract int size();

    private Striped() {
    }
}
