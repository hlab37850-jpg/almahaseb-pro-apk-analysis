package com.google.common.cache;

import androidx.core.location.LocationRequestCompat;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Ticker;
import com.google.common.collect.AbstractSequentialIterator;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;
import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.common.util.concurrent.Uninterruptibles;
import java.io.Serializable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public class a extends AbstractMap implements ConcurrentMap {
    public static final Logger A = Logger.getLogger(a.class.getName());
    public static final y B = new C0208a();
    public static final Queue C = new C1925b();
    public final int a;
    public final int b;
    public final p[] c;
    public final int d;
    public final Equivalence e;
    public final Equivalence f;
    public final r g;
    public final r h;
    public final long i;
    public final Weigher j;
    public final long k;
    public final long l;
    public final long n;
    public final Queue p;
    public final RemovalListener q;
    public final Ticker t;
    public final EnumC1929f u;
    public final AbstractCache.StatsCounter v;
    public final CacheLoader w;
    public Set x;
    public Collection y;
    public Set z;

    public static final class A extends C {
        public volatile long d;
        public b e;
        public b f;

        public A(ReferenceQueue referenceQueue, Object obj, int i, b bVar) {
            super(referenceQueue, obj, i, bVar);
            this.d = LocationRequestCompat.PASSIVE_INTERVAL;
            this.e = a.x();
            this.f = a.x();
        }

        @Override // com.google.common.cache.a.C, com.google.common.cache.b
        public b c() {
            return this.f;
        }

        @Override // com.google.common.cache.a.C, com.google.common.cache.b
        public void h(long j) {
            this.d = j;
        }

        @Override // com.google.common.cache.a.C, com.google.common.cache.b
        public long j() {
            return this.d;
        }

        @Override // com.google.common.cache.a.C, com.google.common.cache.b
        public b l() {
            return this.e;
        }

        @Override // com.google.common.cache.a.C, com.google.common.cache.b
        public void m(b bVar) {
            this.e = bVar;
        }

        @Override // com.google.common.cache.a.C, com.google.common.cache.b
        public void p(b bVar) {
            this.f = bVar;
        }
    }

    public static final class B extends C {
        public volatile long d;
        public b e;
        public b f;
        public volatile long g;
        public b h;
        public b i;

        public B(ReferenceQueue referenceQueue, Object obj, int i, b bVar) {
            super(referenceQueue, obj, i, bVar);
            this.d = LocationRequestCompat.PASSIVE_INTERVAL;
            this.e = a.x();
            this.f = a.x();
            this.g = LocationRequestCompat.PASSIVE_INTERVAL;
            this.h = a.x();
            this.i = a.x();
        }

        @Override // com.google.common.cache.a.C, com.google.common.cache.b
        public b c() {
            return this.f;
        }

        @Override // com.google.common.cache.a.C, com.google.common.cache.b
        public long f() {
            return this.g;
        }

        @Override // com.google.common.cache.a.C, com.google.common.cache.b
        public void h(long j) {
            this.d = j;
        }

        @Override // com.google.common.cache.a.C, com.google.common.cache.b
        public b i() {
            return this.h;
        }

        @Override // com.google.common.cache.a.C, com.google.common.cache.b
        public long j() {
            return this.d;
        }

        @Override // com.google.common.cache.a.C, com.google.common.cache.b
        public void k(long j) {
            this.g = j;
        }

        @Override // com.google.common.cache.a.C, com.google.common.cache.b
        public b l() {
            return this.e;
        }

        @Override // com.google.common.cache.a.C, com.google.common.cache.b
        public void m(b bVar) {
            this.e = bVar;
        }

        @Override // com.google.common.cache.a.C, com.google.common.cache.b
        public void n(b bVar) {
            this.h = bVar;
        }

        @Override // com.google.common.cache.a.C, com.google.common.cache.b
        public void o(b bVar) {
            this.i = bVar;
        }

        @Override // com.google.common.cache.a.C, com.google.common.cache.b
        public void p(b bVar) {
            this.f = bVar;
        }

        @Override // com.google.common.cache.a.C, com.google.common.cache.b
        public b q() {
            return this.i;
        }
    }

    public static class C extends WeakReference implements b {
        public final int a;
        public final b b;
        public volatile y c;

        public C(ReferenceQueue referenceQueue, Object obj, int i, b bVar) {
            super(obj, referenceQueue);
            this.c = a.L();
            this.a = i;
            this.b = bVar;
        }

        @Override // com.google.common.cache.b
        public y a() {
            return this.c;
        }

        @Override // com.google.common.cache.b
        public int b() {
            return this.a;
        }

        public b c() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.b
        public void e(y yVar) {
            this.c = yVar;
        }

        public long f() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.b
        public Object getKey() {
            return get();
        }

        @Override // com.google.common.cache.b
        public b getNext() {
            return this.b;
        }

        public void h(long j) {
            throw new UnsupportedOperationException();
        }

        public b i() {
            throw new UnsupportedOperationException();
        }

        public long j() {
            throw new UnsupportedOperationException();
        }

        public void k(long j) {
            throw new UnsupportedOperationException();
        }

        public b l() {
            throw new UnsupportedOperationException();
        }

        public void m(b bVar) {
            throw new UnsupportedOperationException();
        }

        public void n(b bVar) {
            throw new UnsupportedOperationException();
        }

        public void o(b bVar) {
            throw new UnsupportedOperationException();
        }

        public void p(b bVar) {
            throw new UnsupportedOperationException();
        }

        public b q() {
            throw new UnsupportedOperationException();
        }
    }

    public static class D extends WeakReference implements y {
        public final b a;

        public D(ReferenceQueue referenceQueue, Object obj, b bVar) {
            super(obj, referenceQueue);
            this.a = bVar;
        }

        @Override // com.google.common.cache.a.y
        public b a() {
            return this.a;
        }

        @Override // com.google.common.cache.a.y
        public void b(Object obj) {
        }

        @Override // com.google.common.cache.a.y
        public boolean c() {
            return false;
        }

        @Override // com.google.common.cache.a.y
        public Object d() {
            return get();
        }

        @Override // com.google.common.cache.a.y
        public y e(ReferenceQueue referenceQueue, Object obj, b bVar) {
            return new D(referenceQueue, obj, bVar);
        }

        @Override // com.google.common.cache.a.y
        public int getWeight() {
            return 1;
        }

        @Override // com.google.common.cache.a.y
        public boolean isActive() {
            return true;
        }
    }

    public static final class E extends C {
        public volatile long d;
        public b e;
        public b f;

        public E(ReferenceQueue referenceQueue, Object obj, int i, b bVar) {
            super(referenceQueue, obj, i, bVar);
            this.d = LocationRequestCompat.PASSIVE_INTERVAL;
            this.e = a.x();
            this.f = a.x();
        }

        @Override // com.google.common.cache.a.C, com.google.common.cache.b
        public long f() {
            return this.d;
        }

        @Override // com.google.common.cache.a.C, com.google.common.cache.b
        public b i() {
            return this.e;
        }

        @Override // com.google.common.cache.a.C, com.google.common.cache.b
        public void k(long j) {
            this.d = j;
        }

        @Override // com.google.common.cache.a.C, com.google.common.cache.b
        public void n(b bVar) {
            this.e = bVar;
        }

        @Override // com.google.common.cache.a.C, com.google.common.cache.b
        public void o(b bVar) {
            this.f = bVar;
        }

        @Override // com.google.common.cache.a.C, com.google.common.cache.b
        public b q() {
            return this.f;
        }
    }

    public static final class F extends q {
        public final int b;

        public F(ReferenceQueue referenceQueue, Object obj, b bVar, int i) {
            super(referenceQueue, obj, bVar);
            this.b = i;
        }

        @Override // com.google.common.cache.a.q, com.google.common.cache.a.y
        public y e(ReferenceQueue referenceQueue, Object obj, b bVar) {
            return new F(referenceQueue, obj, bVar, this.b);
        }

        @Override // com.google.common.cache.a.q, com.google.common.cache.a.y
        public int getWeight() {
            return this.b;
        }
    }

    public static final class G extends v {
        public final int b;

        public G(Object obj, int i) {
            super(obj);
            this.b = i;
        }

        @Override // com.google.common.cache.a.v, com.google.common.cache.a.y
        public int getWeight() {
            return this.b;
        }
    }

    public static final class H extends D {
        public final int b;

        public H(ReferenceQueue referenceQueue, Object obj, b bVar, int i) {
            super(referenceQueue, obj, bVar);
            this.b = i;
        }

        @Override // com.google.common.cache.a.D, com.google.common.cache.a.y
        public y e(ReferenceQueue referenceQueue, Object obj, b bVar) {
            return new H(referenceQueue, obj, bVar, this.b);
        }

        @Override // com.google.common.cache.a.D, com.google.common.cache.a.y
        public int getWeight() {
            return this.b;
        }
    }

    public static final class I extends AbstractQueue {
        public final com.google.common.cache.b a = new C0207a(this);

        /* JADX INFO: renamed from: com.google.common.cache.a$I$a, reason: collision with other inner class name */
        public class C0207a extends AbstractC1927d {
            public com.google.common.cache.b a = this;
            public com.google.common.cache.b b = this;

            public C0207a(I i) {
            }

            @Override // com.google.common.cache.a.AbstractC1927d, com.google.common.cache.b
            public long f() {
                return LocationRequestCompat.PASSIVE_INTERVAL;
            }

            @Override // com.google.common.cache.a.AbstractC1927d, com.google.common.cache.b
            public com.google.common.cache.b i() {
                return this.a;
            }

            @Override // com.google.common.cache.a.AbstractC1927d, com.google.common.cache.b
            public void k(long j) {
            }

            @Override // com.google.common.cache.a.AbstractC1927d, com.google.common.cache.b
            public void n(com.google.common.cache.b bVar) {
                this.a = bVar;
            }

            @Override // com.google.common.cache.a.AbstractC1927d, com.google.common.cache.b
            public void o(com.google.common.cache.b bVar) {
                this.b = bVar;
            }

            @Override // com.google.common.cache.a.AbstractC1927d, com.google.common.cache.b
            public com.google.common.cache.b q() {
                return this.b;
            }
        }

        public class b extends AbstractSequentialIterator {
            public b(com.google.common.cache.b bVar) {
                super(bVar);
            }

            @Override // com.google.common.collect.AbstractSequentialIterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public com.google.common.cache.b computeNext(com.google.common.cache.b bVar) {
                com.google.common.cache.b bVarI = bVar.i();
                if (bVarI == I.this.a) {
                    return null;
                }
                return bVarI;
            }
        }

        @Override // java.util.Queue
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean offer(com.google.common.cache.b bVar) {
            a.d(bVar.q(), bVar.i());
            a.d(this.a.q(), bVar);
            a.d(bVar, this.a);
            return true;
        }

        @Override // java.util.Queue
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.common.cache.b peek() {
            com.google.common.cache.b bVarI = this.a.i();
            if (bVarI == this.a) {
                return null;
            }
            return bVarI;
        }

        @Override // java.util.Queue
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.google.common.cache.b poll() {
            com.google.common.cache.b bVarI = this.a.i();
            if (bVarI == this.a) {
                return null;
            }
            remove(bVarI);
            return bVarI;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            com.google.common.cache.b bVarI = this.a.i();
            while (true) {
                com.google.common.cache.b bVar = this.a;
                if (bVarI == bVar) {
                    bVar.n(bVar);
                    com.google.common.cache.b bVar2 = this.a;
                    bVar2.o(bVar2);
                    return;
                } else {
                    com.google.common.cache.b bVarI2 = bVarI.i();
                    a.z(bVarI);
                    bVarI = bVarI2;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return ((com.google.common.cache.b) obj).i() != o.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.a.i() == this.a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new b(peek());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            com.google.common.cache.b bVar = (com.google.common.cache.b) obj;
            com.google.common.cache.b bVarQ = bVar.q();
            com.google.common.cache.b bVarI = bVar.i();
            a.d(bVarQ, bVarI);
            a.z(bVar);
            return bVarI != o.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            int i = 0;
            for (com.google.common.cache.b bVarI = this.a.i(); bVarI != this.a; bVarI = bVarI.i()) {
                i++;
            }
            return i;
        }
    }

    public final class J implements Map.Entry {
        public final Object a;
        public Object b;

        public J(Object obj, Object obj2) {
            this.a = obj;
            this.b = obj2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.a.equals(entry.getKey()) && this.b.equals(entry.getValue());
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.a;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.a.hashCode() ^ this.b.hashCode();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            Object objPut = a.this.put(this.a, obj);
            this.b = obj;
            return objPut;
        }

        public String toString() {
            String strValueOf = String.valueOf(getKey());
            String strValueOf2 = String.valueOf(getValue());
            StringBuilder sb = new StringBuilder(strValueOf.length() + 1 + strValueOf2.length());
            sb.append(strValueOf);
            sb.append("=");
            sb.append(strValueOf2);
            return sb.toString();
        }
    }

    /* JADX INFO: renamed from: com.google.common.cache.a$a, reason: collision with other inner class name */
    public class C0208a implements y {
        @Override // com.google.common.cache.a.y
        public b a() {
            return null;
        }

        @Override // com.google.common.cache.a.y
        public void b(Object obj) {
        }

        @Override // com.google.common.cache.a.y
        public boolean c() {
            return false;
        }

        @Override // com.google.common.cache.a.y
        public Object d() {
            return null;
        }

        @Override // com.google.common.cache.a.y
        public y e(ReferenceQueue referenceQueue, Object obj, b bVar) {
            return this;
        }

        @Override // com.google.common.cache.a.y
        public Object get() {
            return null;
        }

        @Override // com.google.common.cache.a.y
        public int getWeight() {
            return 0;
        }

        @Override // com.google.common.cache.a.y
        public boolean isActive() {
            return false;
        }
    }

    /* JADX INFO: renamed from: com.google.common.cache.a$b, reason: case insensitive filesystem */
    public class C1925b extends AbstractQueue {
        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return ImmutableSet.of().iterator();
        }

        @Override // java.util.Queue
        public boolean offer(Object obj) {
            return true;
        }

        @Override // java.util.Queue
        public Object peek() {
            return null;
        }

        @Override // java.util.Queue
        public Object poll() {
            return null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return 0;
        }
    }

    /* JADX INFO: renamed from: com.google.common.cache.a$c, reason: case insensitive filesystem */
    public abstract class AbstractC1926c extends AbstractSet {
        public AbstractC1926c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            a.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return a.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return a.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return a.K(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray(Object[] objArr) {
            return a.K(this).toArray(objArr);
        }
    }

    /* JADX INFO: renamed from: com.google.common.cache.a$d, reason: case insensitive filesystem */
    public static abstract class AbstractC1927d implements b {
        @Override // com.google.common.cache.b
        public y a() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.b
        public int b() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.b
        public b c() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.b
        public void e(y yVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.b
        public long f() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.b
        public Object getKey() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.b
        public b getNext() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.b
        public void h(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.b
        public b i() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.b
        public long j() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.b
        public void k(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.b
        public b l() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.b
        public void m(b bVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.b
        public void n(b bVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.b
        public void o(b bVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.b
        public void p(b bVar) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.b
        public b q() {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: renamed from: com.google.common.cache.a$e, reason: case insensitive filesystem */
    public static final class C1928e extends AbstractQueue {
        public final com.google.common.cache.b a = new C0209a(this);

        /* JADX INFO: renamed from: com.google.common.cache.a$e$a, reason: collision with other inner class name */
        public class C0209a extends AbstractC1927d {
            public com.google.common.cache.b a = this;
            public com.google.common.cache.b b = this;

            public C0209a(C1928e c1928e) {
            }

            @Override // com.google.common.cache.a.AbstractC1927d, com.google.common.cache.b
            public com.google.common.cache.b c() {
                return this.b;
            }

            @Override // com.google.common.cache.a.AbstractC1927d, com.google.common.cache.b
            public void h(long j) {
            }

            @Override // com.google.common.cache.a.AbstractC1927d, com.google.common.cache.b
            public long j() {
                return LocationRequestCompat.PASSIVE_INTERVAL;
            }

            @Override // com.google.common.cache.a.AbstractC1927d, com.google.common.cache.b
            public com.google.common.cache.b l() {
                return this.a;
            }

            @Override // com.google.common.cache.a.AbstractC1927d, com.google.common.cache.b
            public void m(com.google.common.cache.b bVar) {
                this.a = bVar;
            }

            @Override // com.google.common.cache.a.AbstractC1927d, com.google.common.cache.b
            public void p(com.google.common.cache.b bVar) {
                this.b = bVar;
            }
        }

        /* JADX INFO: renamed from: com.google.common.cache.a$e$b */
        public class b extends AbstractSequentialIterator {
            public b(com.google.common.cache.b bVar) {
                super(bVar);
            }

            @Override // com.google.common.collect.AbstractSequentialIterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public com.google.common.cache.b computeNext(com.google.common.cache.b bVar) {
                com.google.common.cache.b bVarL = bVar.l();
                if (bVarL == C1928e.this.a) {
                    return null;
                }
                return bVarL;
            }
        }

        @Override // java.util.Queue
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean offer(com.google.common.cache.b bVar) {
            a.c(bVar.c(), bVar.l());
            a.c(this.a.c(), bVar);
            a.c(bVar, this.a);
            return true;
        }

        @Override // java.util.Queue
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.common.cache.b peek() {
            com.google.common.cache.b bVarL = this.a.l();
            if (bVarL == this.a) {
                return null;
            }
            return bVarL;
        }

        @Override // java.util.Queue
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.google.common.cache.b poll() {
            com.google.common.cache.b bVarL = this.a.l();
            if (bVarL == this.a) {
                return null;
            }
            remove(bVarL);
            return bVarL;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            com.google.common.cache.b bVarL = this.a.l();
            while (true) {
                com.google.common.cache.b bVar = this.a;
                if (bVarL == bVar) {
                    bVar.m(bVar);
                    com.google.common.cache.b bVar2 = this.a;
                    bVar2.p(bVar2);
                    return;
                } else {
                    com.google.common.cache.b bVarL2 = bVarL.l();
                    a.y(bVarL);
                    bVarL = bVarL2;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return ((com.google.common.cache.b) obj).l() != o.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.a.l() == this.a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new b(peek());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            com.google.common.cache.b bVar = (com.google.common.cache.b) obj;
            com.google.common.cache.b bVarC = bVar.c();
            com.google.common.cache.b bVarL = bVar.l();
            a.c(bVarC, bVarL);
            a.y(bVar);
            return bVarL != o.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            int i = 0;
            for (com.google.common.cache.b bVarL = this.a.l(); bVarL != this.a; bVarL = bVarL.l()) {
                i++;
            }
            return i;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: renamed from: com.google.common.cache.a$f, reason: case insensitive filesystem */
    public static abstract class EnumC1929f {
        public static final EnumC1929f a;
        public static final EnumC1929f b;
        public static final EnumC1929f c;
        public static final EnumC1929f d;
        public static final EnumC1929f e;
        public static final EnumC1929f f;
        public static final EnumC1929f g;
        public static final EnumC1929f h;
        public static final EnumC1929f[] i;
        public static final /* synthetic */ EnumC1929f[] j;

        /* JADX INFO: renamed from: com.google.common.cache.a$f$a, reason: collision with other inner class name */
        public final enum C0210a extends EnumC1929f {
            public C0210a(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.cache.a.EnumC1929f
            public com.google.common.cache.b h(p pVar, Object obj, int i, com.google.common.cache.b bVar) {
                return new u(obj, i, bVar);
            }
        }

        /* JADX INFO: renamed from: com.google.common.cache.a$f$b */
        public final enum b extends EnumC1929f {
            public b(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.cache.a.EnumC1929f
            public com.google.common.cache.b c(p pVar, com.google.common.cache.b bVar, com.google.common.cache.b bVar2) {
                com.google.common.cache.b bVarC = super.c(pVar, bVar, bVar2);
                b(bVar, bVarC);
                return bVarC;
            }

            @Override // com.google.common.cache.a.EnumC1929f
            public com.google.common.cache.b h(p pVar, Object obj, int i, com.google.common.cache.b bVar) {
                return new s(obj, i, bVar);
            }
        }

        /* JADX INFO: renamed from: com.google.common.cache.a$f$c */
        public final enum c extends EnumC1929f {
            public c(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.cache.a.EnumC1929f
            public com.google.common.cache.b c(p pVar, com.google.common.cache.b bVar, com.google.common.cache.b bVar2) {
                com.google.common.cache.b bVarC = super.c(pVar, bVar, bVar2);
                e(bVar, bVarC);
                return bVarC;
            }

            @Override // com.google.common.cache.a.EnumC1929f
            public com.google.common.cache.b h(p pVar, Object obj, int i, com.google.common.cache.b bVar) {
                return new w(obj, i, bVar);
            }
        }

        /* JADX INFO: renamed from: com.google.common.cache.a$f$d */
        public final enum d extends EnumC1929f {
            public d(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.cache.a.EnumC1929f
            public com.google.common.cache.b c(p pVar, com.google.common.cache.b bVar, com.google.common.cache.b bVar2) {
                com.google.common.cache.b bVarC = super.c(pVar, bVar, bVar2);
                b(bVar, bVarC);
                e(bVar, bVarC);
                return bVarC;
            }

            @Override // com.google.common.cache.a.EnumC1929f
            public com.google.common.cache.b h(p pVar, Object obj, int i, com.google.common.cache.b bVar) {
                return new t(obj, i, bVar);
            }
        }

        /* JADX INFO: renamed from: com.google.common.cache.a$f$e */
        public final enum e extends EnumC1929f {
            public e(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.cache.a.EnumC1929f
            public com.google.common.cache.b h(p pVar, Object obj, int i, com.google.common.cache.b bVar) {
                return new C(pVar.h, obj, i, bVar);
            }
        }

        /* JADX INFO: renamed from: com.google.common.cache.a$f$f, reason: collision with other inner class name */
        public final enum C0211f extends EnumC1929f {
            public C0211f(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.cache.a.EnumC1929f
            public com.google.common.cache.b c(p pVar, com.google.common.cache.b bVar, com.google.common.cache.b bVar2) {
                com.google.common.cache.b bVarC = super.c(pVar, bVar, bVar2);
                b(bVar, bVarC);
                return bVarC;
            }

            @Override // com.google.common.cache.a.EnumC1929f
            public com.google.common.cache.b h(p pVar, Object obj, int i, com.google.common.cache.b bVar) {
                return new A(pVar.h, obj, i, bVar);
            }
        }

        /* JADX INFO: renamed from: com.google.common.cache.a$f$g */
        public final enum g extends EnumC1929f {
            public g(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.cache.a.EnumC1929f
            public com.google.common.cache.b c(p pVar, com.google.common.cache.b bVar, com.google.common.cache.b bVar2) {
                com.google.common.cache.b bVarC = super.c(pVar, bVar, bVar2);
                e(bVar, bVarC);
                return bVarC;
            }

            @Override // com.google.common.cache.a.EnumC1929f
            public com.google.common.cache.b h(p pVar, Object obj, int i, com.google.common.cache.b bVar) {
                return new E(pVar.h, obj, i, bVar);
            }
        }

        /* JADX INFO: renamed from: com.google.common.cache.a$f$h */
        public final enum h extends EnumC1929f {
            public h(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.cache.a.EnumC1929f
            public com.google.common.cache.b c(p pVar, com.google.common.cache.b bVar, com.google.common.cache.b bVar2) {
                com.google.common.cache.b bVarC = super.c(pVar, bVar, bVar2);
                b(bVar, bVarC);
                e(bVar, bVarC);
                return bVarC;
            }

            @Override // com.google.common.cache.a.EnumC1929f
            public com.google.common.cache.b h(p pVar, Object obj, int i, com.google.common.cache.b bVar) {
                return new B(pVar.h, obj, i, bVar);
            }
        }

        static {
            C0210a c0210a = new C0210a("STRONG", 0);
            a = c0210a;
            b bVar = new b("STRONG_ACCESS", 1);
            b = bVar;
            c cVar = new c("STRONG_WRITE", 2);
            c = cVar;
            d dVar = new d("STRONG_ACCESS_WRITE", 3);
            d = dVar;
            e eVar = new e("WEAK", 4);
            e = eVar;
            C0211f c0211f = new C0211f("WEAK_ACCESS", 5);
            f = c0211f;
            g gVar = new g("WEAK_WRITE", 6);
            g = gVar;
            h hVar = new h("WEAK_ACCESS_WRITE", 7);
            h = hVar;
            j = a();
            i = new EnumC1929f[]{c0210a, bVar, cVar, dVar, eVar, c0211f, gVar, hVar};
        }

        public EnumC1929f(String str, int i2) {
            super(str, i2);
        }

        public static /* synthetic */ EnumC1929f[] a() {
            return new EnumC1929f[]{a, b, c, d, e, f, g, h};
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static EnumC1929f f(r rVar, boolean z, boolean z2) {
            return i[((rVar == r.c ? (char) 4 : (char) 0) | (z ? 1 : 0) ? 1 : 0) | (z2 ? 2 : 0)];
        }

        public static EnumC1929f valueOf(String str) {
            return (EnumC1929f) Enum.valueOf(EnumC1929f.class, str);
        }

        public static EnumC1929f[] values() {
            return (EnumC1929f[]) j.clone();
        }

        public void b(com.google.common.cache.b bVar, com.google.common.cache.b bVar2) {
            bVar2.h(bVar.j());
            a.c(bVar.c(), bVar2);
            a.c(bVar2, bVar.l());
            a.y(bVar);
        }

        public com.google.common.cache.b c(p pVar, com.google.common.cache.b bVar, com.google.common.cache.b bVar2) {
            return h(pVar, bVar.getKey(), bVar.b(), bVar2);
        }

        public void e(com.google.common.cache.b bVar, com.google.common.cache.b bVar2) {
            bVar2.k(bVar.f());
            a.d(bVar.q(), bVar2);
            a.d(bVar2, bVar.i());
            a.z(bVar);
        }

        public abstract com.google.common.cache.b h(p pVar, Object obj, int i2, com.google.common.cache.b bVar);

        public /* synthetic */ EnumC1929f(String str, int i2, C0208a c0208a) {
            this(str, i2);
        }
    }

    /* JADX INFO: renamed from: com.google.common.cache.a$g, reason: case insensitive filesystem */
    public final class C1930g extends AbstractC1932i {
        public C1930g(a aVar) {
            super();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            return c();
        }
    }

    /* JADX INFO: renamed from: com.google.common.cache.a$h, reason: case insensitive filesystem */
    public final class C1931h extends AbstractC1926c {
        public C1931h() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = a.this.get(key)) != null && a.this.f.equivalent(entry.getValue(), obj2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new C1930g(a.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && a.this.remove(key, entry.getValue());
        }
    }

    /* JADX INFO: renamed from: com.google.common.cache.a$i, reason: case insensitive filesystem */
    public abstract class AbstractC1932i implements Iterator {
        public int a;
        public int b = -1;
        public p c;
        public AtomicReferenceArray d;
        public b e;
        public J f;
        public J g;

        public AbstractC1932i() {
            this.a = a.this.c.length - 1;
            a();
        }

        public final void a() {
            this.f = null;
            if (d() || e()) {
                return;
            }
            while (true) {
                int i = this.a;
                if (i < 0) {
                    return;
                }
                p[] pVarArr = a.this.c;
                this.a = i - 1;
                p pVar = pVarArr[i];
                this.c = pVar;
                if (pVar.b != 0) {
                    AtomicReferenceArray atomicReferenceArray = this.c.f;
                    this.d = atomicReferenceArray;
                    this.b = atomicReferenceArray.length() - 1;
                    if (e()) {
                        return;
                    }
                }
            }
        }

        public boolean b(b bVar) {
            p pVar;
            try {
                long j = a.this.t.read();
                Object key = bVar.getKey();
                Object objP = a.this.p(bVar, j);
                if (objP == null) {
                    return false;
                }
                this.f = a.this.new J(key, objP);
                return true;
            } finally {
                this.c.G();
            }
        }

        public J c() {
            J j = this.f;
            if (j == null) {
                throw new NoSuchElementException();
            }
            this.g = j;
            a();
            return this.g;
        }

        public boolean d() {
            b bVar = this.e;
            if (bVar == null) {
                return false;
            }
            while (true) {
                this.e = bVar.getNext();
                b bVar2 = this.e;
                if (bVar2 == null) {
                    return false;
                }
                if (b(bVar2)) {
                    return true;
                }
                bVar = this.e;
            }
        }

        public boolean e() {
            while (true) {
                int i = this.b;
                if (i < 0) {
                    return false;
                }
                AtomicReferenceArray atomicReferenceArray = this.d;
                this.b = i - 1;
                b bVar = (b) atomicReferenceArray.get(i);
                this.e = bVar;
                if (bVar != null && (b(bVar) || d())) {
                    return true;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            Preconditions.checkState(this.g != null);
            a.this.remove(this.g.getKey());
            this.g = null;
        }
    }

    /* JADX INFO: renamed from: com.google.common.cache.a$j, reason: case insensitive filesystem */
    public final class C1933j extends AbstractC1932i {
        public C1933j(a aVar) {
            super();
        }

        @Override // java.util.Iterator
        public Object next() {
            return c().getKey();
        }
    }

    public final class k extends AbstractC1926c {
        public k() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return a.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new C1933j(a.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return a.this.remove(obj) != null;
        }
    }

    public static class l implements y {
        public volatile y a;
        public final SettableFuture b;
        public final Stopwatch c;

        /* JADX INFO: renamed from: com.google.common.cache.a$l$a, reason: collision with other inner class name */
        public class C0212a implements Function {
            public C0212a() {
            }

            @Override // com.google.common.base.Function
            public Object apply(Object obj) {
                l.this.j(obj);
                return obj;
            }
        }

        public l() {
            this(a.L());
        }

        @Override // com.google.common.cache.a.y
        public b a() {
            return null;
        }

        @Override // com.google.common.cache.a.y
        public void b(Object obj) {
            if (obj != null) {
                j(obj);
            } else {
                this.a = a.L();
            }
        }

        @Override // com.google.common.cache.a.y
        public boolean c() {
            return true;
        }

        @Override // com.google.common.cache.a.y
        public Object d() {
            return Uninterruptibles.getUninterruptibly(this.b);
        }

        @Override // com.google.common.cache.a.y
        public y e(ReferenceQueue referenceQueue, Object obj, b bVar) {
            return this;
        }

        public long f() {
            return this.c.elapsed(TimeUnit.NANOSECONDS);
        }

        public final ListenableFuture g(Throwable th) {
            return Futures.immediateFailedFuture(th);
        }

        @Override // com.google.common.cache.a.y
        public Object get() {
            return this.a.get();
        }

        @Override // com.google.common.cache.a.y
        public int getWeight() {
            return this.a.getWeight();
        }

        public y h() {
            return this.a;
        }

        public ListenableFuture i(Object obj, CacheLoader cacheLoader) {
            try {
                this.c.start();
                Object obj2 = this.a.get();
                if (obj2 == null) {
                    Object objLoad = cacheLoader.load(obj);
                    return j(objLoad) ? this.b : Futures.immediateFuture(objLoad);
                }
                ListenableFuture listenableFutureReload = cacheLoader.reload(obj, obj2);
                return listenableFutureReload == null ? Futures.immediateFuture(null) : Futures.transform(listenableFutureReload, new C0212a(), MoreExecutors.directExecutor());
            } catch (Throwable th) {
                ListenableFuture listenableFutureG = k(th) ? this.b : g(th);
                if (th instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                return listenableFutureG;
            }
        }

        @Override // com.google.common.cache.a.y
        public boolean isActive() {
            return this.a.isActive();
        }

        public boolean j(Object obj) {
            return this.b.set(obj);
        }

        public boolean k(Throwable th) {
            return this.b.setException(th);
        }

        public l(y yVar) {
            this.b = SettableFuture.create();
            this.c = Stopwatch.createUnstarted();
            this.a = yVar;
        }
    }

    public static class m extends n implements LoadingCache {
        public m(CacheBuilder cacheBuilder, CacheLoader cacheLoader) {
            super(new a(cacheBuilder, (CacheLoader) Preconditions.checkNotNull(cacheLoader)), null);
        }

        @Override // com.google.common.cache.LoadingCache, com.google.common.base.Function
        public final Object apply(Object obj) {
            return getUnchecked(obj);
        }

        @Override // com.google.common.cache.LoadingCache
        public Object get(Object obj) {
            return this.a.q(obj);
        }

        @Override // com.google.common.cache.LoadingCache
        public ImmutableMap getAll(Iterable iterable) {
            return this.a.m(iterable);
        }

        @Override // com.google.common.cache.LoadingCache
        public Object getUnchecked(Object obj) {
            try {
                return get(obj);
            } catch (ExecutionException e) {
                throw new UncheckedExecutionException(e.getCause());
            }
        }

        @Override // com.google.common.cache.LoadingCache
        public void refresh(Object obj) {
            this.a.G(obj);
        }
    }

    public static class n implements Cache, Serializable {
        public final a a;

        /* JADX INFO: renamed from: com.google.common.cache.a$n$a, reason: collision with other inner class name */
        public class C0213a extends CacheLoader {
            public final /* synthetic */ Callable a;

            public C0213a(n nVar, Callable callable) {
                this.a = callable;
            }

            @Override // com.google.common.cache.CacheLoader
            public Object load(Object obj) {
                return this.a.call();
            }
        }

        public /* synthetic */ n(a aVar, C0208a c0208a) {
            this(aVar);
        }

        @Override // com.google.common.cache.Cache
        public ConcurrentMap asMap() {
            return this.a;
        }

        @Override // com.google.common.cache.Cache
        public void cleanUp() {
            this.a.b();
        }

        @Override // com.google.common.cache.Cache
        public Object get(Object obj, Callable callable) {
            Preconditions.checkNotNull(callable);
            return this.a.l(obj, new C0213a(this, callable));
        }

        @Override // com.google.common.cache.Cache
        public ImmutableMap getAllPresent(Iterable iterable) {
            return this.a.n(iterable);
        }

        @Override // com.google.common.cache.Cache
        public Object getIfPresent(Object obj) {
            return this.a.o(obj);
        }

        @Override // com.google.common.cache.Cache
        public void invalidate(Object obj) {
            Preconditions.checkNotNull(obj);
            this.a.remove(obj);
        }

        @Override // com.google.common.cache.Cache
        public void invalidateAll(Iterable iterable) {
            this.a.s(iterable);
        }

        @Override // com.google.common.cache.Cache
        public void put(Object obj, Object obj2) {
            this.a.put(obj, obj2);
        }

        @Override // com.google.common.cache.Cache
        public void putAll(Map map) {
            this.a.putAll(map);
        }

        @Override // com.google.common.cache.Cache
        public long size() {
            return this.a.v();
        }

        @Override // com.google.common.cache.Cache
        public CacheStats stats() {
            AbstractCache.SimpleStatsCounter simpleStatsCounter = new AbstractCache.SimpleStatsCounter();
            simpleStatsCounter.incrementBy(this.a.v);
            for (p pVar : this.a.c) {
                simpleStatsCounter.incrementBy(pVar.p);
            }
            return simpleStatsCounter.snapshot();
        }

        public n(CacheBuilder cacheBuilder) {
            this(new a(cacheBuilder, null));
        }

        @Override // com.google.common.cache.Cache
        public void invalidateAll() {
            this.a.clear();
        }

        public n(a aVar) {
            this.a = aVar;
        }
    }

    public enum o implements b {
        INSTANCE;

        @Override // com.google.common.cache.b
        public y a() {
            return null;
        }

        @Override // com.google.common.cache.b
        public int b() {
            return 0;
        }

        @Override // com.google.common.cache.b
        public b c() {
            return this;
        }

        @Override // com.google.common.cache.b
        public void e(y yVar) {
        }

        @Override // com.google.common.cache.b
        public long f() {
            return 0L;
        }

        @Override // com.google.common.cache.b
        public Object getKey() {
            return null;
        }

        @Override // com.google.common.cache.b
        public b getNext() {
            return null;
        }

        @Override // com.google.common.cache.b
        public void h(long j) {
        }

        @Override // com.google.common.cache.b
        public b i() {
            return this;
        }

        @Override // com.google.common.cache.b
        public long j() {
            return 0L;
        }

        @Override // com.google.common.cache.b
        public void k(long j) {
        }

        @Override // com.google.common.cache.b
        public b l() {
            return this;
        }

        @Override // com.google.common.cache.b
        public void m(b bVar) {
        }

        @Override // com.google.common.cache.b
        public void n(b bVar) {
        }

        @Override // com.google.common.cache.b
        public void o(b bVar) {
        }

        @Override // com.google.common.cache.b
        public void p(b bVar) {
        }

        @Override // com.google.common.cache.b
        public b q() {
            return this;
        }
    }

    public static class p extends ReentrantLock {
        public final a a;
        public volatile int b;
        public long c;
        public int d;
        public int e;
        public volatile AtomicReferenceArray f;
        public final long g;
        public final ReferenceQueue h;
        public final ReferenceQueue i;
        public final Queue j;
        public final AtomicInteger k = new AtomicInteger();
        public final Queue l;
        public final Queue n;
        public final AbstractCache.StatsCounter p;

        /* JADX INFO: renamed from: com.google.common.cache.a$p$a, reason: collision with other inner class name */
        public class RunnableC0214a implements Runnable {
            public final /* synthetic */ Object a;
            public final /* synthetic */ int b;
            public final /* synthetic */ l c;
            public final /* synthetic */ ListenableFuture d;

            public RunnableC0214a(Object obj, int i, l lVar, ListenableFuture listenableFuture) {
                this.a = obj;
                this.b = i;
                this.c = lVar;
                this.d = listenableFuture;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    p.this.t(this.a, this.b, this.c, this.d);
                } catch (Throwable th) {
                    a.A.log(Level.WARNING, "Exception thrown during refresh", th);
                    this.c.k(th);
                }
            }
        }

        public p(a aVar, int i, long j, AbstractCache.StatsCounter statsCounter) {
            this.a = aVar;
            this.g = j;
            this.p = (AbstractCache.StatsCounter) Preconditions.checkNotNull(statsCounter);
            z(F(i));
            this.h = aVar.O() ? new ReferenceQueue() : null;
            this.i = aVar.P() ? new ReferenceQueue() : null;
            this.j = aVar.N() ? new ConcurrentLinkedQueue() : a.g();
            this.l = aVar.R() ? new I() : a.g();
            this.n = aVar.N() ? new C1928e() : a.g();
        }

        public l A(Object obj, int i, boolean z) {
            lock();
            try {
                long j = this.a.t.read();
                I(j);
                AtomicReferenceArray atomicReferenceArray = this.f;
                int length = (atomicReferenceArray.length() - 1) & i;
                b bVar = (b) atomicReferenceArray.get(length);
                for (b next = bVar; next != null; next = next.getNext()) {
                    Object key = next.getKey();
                    if (next.b() == i && key != null && this.a.e.equivalent(obj, key)) {
                        y yVarA = next.a();
                        if (!yVarA.c() && (!z || j - next.f() >= this.a.n)) {
                            this.d++;
                            l lVar = new l(yVarA);
                            next.e(lVar);
                            return lVar;
                        }
                        return null;
                    }
                }
                this.d++;
                l lVar2 = new l();
                b bVarE = E(obj, i, bVar);
                bVarE.e(lVar2);
                atomicReferenceArray.set(length, bVarE);
                return lVar2;
            } finally {
                unlock();
                H();
            }
        }

        public ListenableFuture B(Object obj, int i, l lVar, CacheLoader cacheLoader) {
            ListenableFuture listenableFutureI = lVar.i(obj, cacheLoader);
            listenableFutureI.addListener(new RunnableC0214a(obj, i, lVar, listenableFutureI), MoreExecutors.directExecutor());
            return listenableFutureI;
        }

        public Object C(Object obj, int i, l lVar, CacheLoader cacheLoader) {
            return t(obj, i, lVar, lVar.i(obj, cacheLoader));
        }

        public Object D(Object obj, int i, CacheLoader cacheLoader) {
            l lVar;
            y yVar;
            boolean z;
            Object objC;
            lock();
            try {
                long j = this.a.t.read();
                I(j);
                int i2 = this.b - 1;
                AtomicReferenceArray atomicReferenceArray = this.f;
                int length = i & (atomicReferenceArray.length() - 1);
                b bVar = (b) atomicReferenceArray.get(length);
                b bVarE = bVar;
                while (true) {
                    lVar = null;
                    if (bVarE != null) {
                        Object key = bVarE.getKey();
                        if (bVarE.b() == i && key != null && this.a.e.equivalent(obj, key)) {
                            y yVarA = bVarE.a();
                            if (yVarA.c()) {
                                z = false;
                                yVar = yVarA;
                                break;
                            }
                            Object obj2 = yVarA.get();
                            if (obj2 == null) {
                                n(key, i, obj2, yVarA.getWeight(), RemovalCause.COLLECTED);
                            } else {
                                if (!this.a.t(bVarE, j)) {
                                    M(bVarE, j);
                                    this.p.recordHits(1);
                                    unlock();
                                    H();
                                    return obj2;
                                }
                                n(key, i, obj2, yVarA.getWeight(), RemovalCause.EXPIRED);
                            }
                            this.l.remove(bVarE);
                            this.n.remove(bVarE);
                            this.b = i2;
                            yVar = yVarA;
                        } else {
                            bVarE = bVarE.getNext();
                        }
                    } else {
                        yVar = null;
                    }
                    z = true;
                    break;
                }
                if (z) {
                    lVar = new l();
                    if (bVarE == null) {
                        bVarE = E(obj, i, bVar);
                        bVarE.e(lVar);
                        atomicReferenceArray.set(length, bVarE);
                    } else {
                        bVarE.e(lVar);
                    }
                }
                unlock();
                H();
                if (!z) {
                    return g0(bVarE, obj, yVar);
                }
                try {
                    synchronized (bVarE) {
                        objC = C(obj, i, lVar, cacheLoader);
                    }
                    this.p.recordMisses(1);
                    return objC;
                } catch (Throwable th) {
                    this.p.recordMisses(1);
                    throw th;
                }
            } catch (Throwable th2) {
                unlock();
                H();
                throw th2;
            }
        }

        public b E(Object obj, int i, b bVar) {
            return this.a.u.h(this, Preconditions.checkNotNull(obj), i, bVar);
        }

        public AtomicReferenceArray F(int i) {
            return new AtomicReferenceArray(i);
        }

        public void G() {
            if ((this.k.incrementAndGet() & 63) == 0) {
                a();
            }
        }

        public void H() {
            a0();
        }

        public void I(long j) {
            Z(j);
        }

        public Object J(Object obj, int i, Object obj2, boolean z) {
            int i2;
            lock();
            try {
                long j = this.a.t.read();
                I(j);
                if (this.b + 1 > this.e) {
                    p();
                }
                AtomicReferenceArray atomicReferenceArray = this.f;
                int length = i & (atomicReferenceArray.length() - 1);
                b bVar = (b) atomicReferenceArray.get(length);
                for (b next = bVar; next != null; next = next.getNext()) {
                    Object key = next.getKey();
                    if (next.b() == i && key != null && this.a.e.equivalent(obj, key)) {
                        y yVarA = next.a();
                        Object obj3 = yVarA.get();
                        if (obj3 != null) {
                            if (z) {
                                M(next, j);
                            } else {
                                this.d++;
                                n(obj, i, obj3, yVarA.getWeight(), RemovalCause.REPLACED);
                                c0(next, obj, obj2, j);
                                o(next);
                            }
                            return obj3;
                        }
                        this.d++;
                        if (yVarA.isActive()) {
                            n(obj, i, obj3, yVarA.getWeight(), RemovalCause.COLLECTED);
                            c0(next, obj, obj2, j);
                            i2 = this.b;
                        } else {
                            c0(next, obj, obj2, j);
                            i2 = this.b + 1;
                        }
                        this.b = i2;
                        o(next);
                        return null;
                    }
                }
                this.d++;
                b bVarE = E(obj, i, bVar);
                c0(bVarE, obj, obj2, j);
                atomicReferenceArray.set(length, bVarE);
                this.b++;
                o(bVarE);
                return null;
            } finally {
                unlock();
                H();
            }
        }

        public boolean K(b bVar, int i) {
            lock();
            try {
                AtomicReferenceArray atomicReferenceArray = this.f;
                int length = (atomicReferenceArray.length() - 1) & i;
                b bVar2 = (b) atomicReferenceArray.get(length);
                for (b next = bVar2; next != null; next = next.getNext()) {
                    if (next == bVar) {
                        this.d++;
                        b bVarW = W(bVar2, next, next.getKey(), i, next.a().get(), next.a(), RemovalCause.COLLECTED);
                        int i2 = this.b - 1;
                        atomicReferenceArray.set(length, bVarW);
                        this.b = i2;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
                H();
            }
        }

        public boolean L(Object obj, int i, y yVar) {
            lock();
            try {
                AtomicReferenceArray atomicReferenceArray = this.f;
                int length = (atomicReferenceArray.length() - 1) & i;
                b bVar = (b) atomicReferenceArray.get(length);
                for (b next = bVar; next != null; next = next.getNext()) {
                    Object key = next.getKey();
                    if (next.b() == i && key != null && this.a.e.equivalent(obj, key)) {
                        if (next.a() != yVar) {
                            return false;
                        }
                        this.d++;
                        b bVarW = W(bVar, next, key, i, yVar.get(), yVar, RemovalCause.COLLECTED);
                        int i2 = this.b - 1;
                        atomicReferenceArray.set(length, bVarW);
                        this.b = i2;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
                if (!isHeldByCurrentThread()) {
                    H();
                }
            }
        }

        public void M(b bVar, long j) {
            if (this.a.D()) {
                bVar.h(j);
            }
            this.n.add(bVar);
        }

        public void N(b bVar, long j) {
            if (this.a.D()) {
                bVar.h(j);
            }
            this.j.add(bVar);
        }

        public void O(b bVar, int i, long j) {
            k();
            this.c += (long) i;
            if (this.a.D()) {
                bVar.h(j);
            }
            if (this.a.F()) {
                bVar.k(j);
            }
            this.n.add(bVar);
            this.l.add(bVar);
        }

        public Object P(Object obj, int i, CacheLoader cacheLoader, boolean z) {
            l lVarA = A(obj, i, z);
            if (lVarA == null) {
                return null;
            }
            ListenableFuture listenableFutureB = B(obj, i, lVarA, cacheLoader);
            if (listenableFutureB.isDone()) {
                try {
                    return Uninterruptibles.getUninterruptibly(listenableFutureB);
                } catch (Throwable unused) {
                }
            }
            return null;
        }

        public Object Q(Object obj, int i) {
            RemovalCause removalCause;
            lock();
            try {
                I(this.a.t.read());
                AtomicReferenceArray atomicReferenceArray = this.f;
                int length = (atomicReferenceArray.length() - 1) & i;
                b bVar = (b) atomicReferenceArray.get(length);
                for (b next = bVar; next != null; next = next.getNext()) {
                    Object key = next.getKey();
                    if (next.b() == i && key != null && this.a.e.equivalent(obj, key)) {
                        y yVarA = next.a();
                        Object obj2 = yVarA.get();
                        if (obj2 == null) {
                            if (!yVarA.isActive()) {
                                break;
                            }
                            removalCause = RemovalCause.COLLECTED;
                        } else {
                            removalCause = RemovalCause.EXPLICIT;
                        }
                        RemovalCause removalCause2 = removalCause;
                        this.d++;
                        b bVarW = W(bVar, next, key, i, obj2, yVarA, removalCause2);
                        int i2 = this.b - 1;
                        atomicReferenceArray.set(length, bVarW);
                        this.b = i2;
                        return obj2;
                    }
                }
                return null;
            } finally {
                unlock();
                H();
            }
        }

        public boolean R(Object obj, int i, Object obj2) {
            RemovalCause removalCause;
            lock();
            try {
                I(this.a.t.read());
                AtomicReferenceArray atomicReferenceArray = this.f;
                int length = (atomicReferenceArray.length() - 1) & i;
                b bVar = (b) atomicReferenceArray.get(length);
                for (b next = bVar; next != null; next = next.getNext()) {
                    Object key = next.getKey();
                    if (next.b() == i && key != null && this.a.e.equivalent(obj, key)) {
                        y yVarA = next.a();
                        Object obj3 = yVarA.get();
                        if (!this.a.f.equivalent(obj2, obj3)) {
                            if (obj3 != null || !yVarA.isActive()) {
                                break;
                                break;
                            }
                            removalCause = RemovalCause.COLLECTED;
                        } else {
                            removalCause = RemovalCause.EXPLICIT;
                        }
                        this.d++;
                        b bVarW = W(bVar, next, key, i, obj3, yVarA, removalCause);
                        int i2 = this.b - 1;
                        atomicReferenceArray.set(length, bVarW);
                        this.b = i2;
                        return removalCause == RemovalCause.EXPLICIT;
                    }
                }
                return false;
            } finally {
                unlock();
                H();
            }
        }

        public void S(b bVar) {
            n(bVar.getKey(), bVar.b(), bVar.a().get(), bVar.a().getWeight(), RemovalCause.COLLECTED);
            this.l.remove(bVar);
            this.n.remove(bVar);
        }

        public boolean T(b bVar, int i, RemovalCause removalCause) {
            AtomicReferenceArray atomicReferenceArray = this.f;
            int length = (atomicReferenceArray.length() - 1) & i;
            b bVar2 = (b) atomicReferenceArray.get(length);
            for (b next = bVar2; next != null; next = next.getNext()) {
                if (next == bVar) {
                    this.d++;
                    b bVarW = W(bVar2, next, next.getKey(), i, next.a().get(), next.a(), removalCause);
                    int i2 = this.b - 1;
                    atomicReferenceArray.set(length, bVarW);
                    this.b = i2;
                    return true;
                }
            }
            return false;
        }

        public b U(b bVar, b bVar2) {
            int i = this.b;
            b next = bVar2.getNext();
            while (bVar != bVar2) {
                b bVarI = i(bVar, next);
                if (bVarI != null) {
                    next = bVarI;
                } else {
                    S(bVar);
                    i--;
                }
                bVar = bVar.getNext();
            }
            this.b = i;
            return next;
        }

        public boolean V(Object obj, int i, l lVar) {
            lock();
            try {
                AtomicReferenceArray atomicReferenceArray = this.f;
                int length = (atomicReferenceArray.length() - 1) & i;
                b bVar = (b) atomicReferenceArray.get(length);
                for (b next = bVar; next != null; next = next.getNext()) {
                    Object key = next.getKey();
                    if (next.b() == i && key != null && this.a.e.equivalent(obj, key)) {
                        if (next.a() != lVar) {
                            break;
                        }
                        if (lVar.isActive()) {
                            next.e(lVar.h());
                        } else {
                            atomicReferenceArray.set(length, U(bVar, next));
                        }
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
                H();
            }
        }

        public b W(b bVar, b bVar2, Object obj, int i, Object obj2, y yVar, RemovalCause removalCause) {
            n(obj, i, obj2, yVar.getWeight(), removalCause);
            this.l.remove(bVar2);
            this.n.remove(bVar2);
            if (!yVar.c()) {
                return U(bVar, bVar2);
            }
            yVar.b(null);
            return bVar;
        }

        public Object X(Object obj, int i, Object obj2) {
            lock();
            try {
                long j = this.a.t.read();
                I(j);
                AtomicReferenceArray atomicReferenceArray = this.f;
                int length = i & (atomicReferenceArray.length() - 1);
                b bVar = (b) atomicReferenceArray.get(length);
                for (b next = bVar; next != null; next = next.getNext()) {
                    Object key = next.getKey();
                    if (next.b() == i && key != null) {
                        if (this.a.e.equivalent(obj, key)) {
                            y yVarA = next.a();
                            Object obj3 = yVarA.get();
                            if (obj3 != null) {
                                this.d++;
                                n(obj, i, obj3, yVarA.getWeight(), RemovalCause.REPLACED);
                                c0(next, obj, obj2, j);
                                o(next);
                                return obj3;
                            }
                            if (!yVarA.isActive()) {
                                break;
                            }
                            this.d++;
                            b bVarW = W(bVar, next, key, i, obj3, yVarA, RemovalCause.COLLECTED);
                            int i2 = this.b - 1;
                            atomicReferenceArray.set(length, bVarW);
                            this.b = i2;
                            break;
                        }
                    }
                }
                return null;
            } finally {
                unlock();
                H();
            }
        }

        public boolean Y(Object obj, int i, Object obj2, Object obj3) {
            lock();
            try {
                long j = this.a.t.read();
                I(j);
                AtomicReferenceArray atomicReferenceArray = this.f;
                int length = i & (atomicReferenceArray.length() - 1);
                b bVar = (b) atomicReferenceArray.get(length);
                for (b next = bVar; next != null; next = next.getNext()) {
                    Object key = next.getKey();
                    if (next.b() == i && key != null) {
                        if (this.a.e.equivalent(obj, key)) {
                            y yVarA = next.a();
                            Object obj4 = yVarA.get();
                            if (obj4 != null) {
                                if (!this.a.f.equivalent(obj2, obj4)) {
                                    M(next, j);
                                    break;
                                }
                                this.d++;
                                n(obj, i, obj4, yVarA.getWeight(), RemovalCause.REPLACED);
                                c0(next, obj, obj3, j);
                                o(next);
                                return true;
                            }
                            if (!yVarA.isActive()) {
                                break;
                            }
                            this.d++;
                            b bVarW = W(bVar, next, key, i, obj4, yVarA, RemovalCause.COLLECTED);
                            int i2 = this.b - 1;
                            atomicReferenceArray.set(length, bVarW);
                            this.b = i2;
                            break;
                        }
                    }
                }
                return false;
            } finally {
                unlock();
                H();
            }
        }

        public void Z(long j) {
            if (tryLock()) {
                try {
                    l();
                    q(j);
                    this.k.set(0);
                } finally {
                    unlock();
                }
            }
        }

        public void a() {
            Z(this.a.t.read());
            a0();
        }

        public void a0() {
            if (isHeldByCurrentThread()) {
                return;
            }
            this.a.A();
        }

        public void b() {
            if (this.b != 0) {
                lock();
                try {
                    I(this.a.t.read());
                    AtomicReferenceArray atomicReferenceArray = this.f;
                    for (int i = 0; i < atomicReferenceArray.length(); i++) {
                        for (b next = (b) atomicReferenceArray.get(i); next != null; next = next.getNext()) {
                            if (next.a().isActive()) {
                                Object key = next.getKey();
                                Object obj = next.a().get();
                                n(key, next.b(), obj, next.a().getWeight(), (key == null || obj == null) ? RemovalCause.COLLECTED : RemovalCause.EXPLICIT);
                            }
                        }
                    }
                    for (int i2 = 0; i2 < atomicReferenceArray.length(); i2++) {
                        atomicReferenceArray.set(i2, null);
                    }
                    e();
                    this.l.clear();
                    this.n.clear();
                    this.k.set(0);
                    this.d++;
                    this.b = 0;
                } finally {
                    unlock();
                    H();
                }
            }
        }

        public Object b0(b bVar, Object obj, int i, Object obj2, long j, CacheLoader cacheLoader) {
            Object objP;
            return (!this.a.H() || j - bVar.f() <= this.a.n || bVar.a().c() || (objP = P(obj, i, cacheLoader, true)) == null) ? obj2 : objP;
        }

        public void c() {
            while (this.h.poll() != null) {
            }
        }

        public void c0(b bVar, Object obj, Object obj2, long j) {
            y yVarA = bVar.a();
            int iWeigh = this.a.j.weigh(obj, obj2);
            Preconditions.checkState(iWeigh >= 0, "Weights must be non-negative");
            bVar.e(this.a.h.c(this, bVar, obj2, iWeigh));
            O(bVar, iWeigh, j);
            yVarA.b(obj2);
        }

        public boolean d0(Object obj, int i, l lVar, Object obj2) {
            lock();
            try {
                long j = this.a.t.read();
                I(j);
                int i2 = this.b + 1;
                if (i2 > this.e) {
                    p();
                    i2 = this.b + 1;
                }
                int i3 = i2;
                AtomicReferenceArray atomicReferenceArray = this.f;
                int length = i & (atomicReferenceArray.length() - 1);
                b bVar = (b) atomicReferenceArray.get(length);
                for (b next = bVar; next != null; next = next.getNext()) {
                    Object key = next.getKey();
                    if (next.b() == i && key != null && this.a.e.equivalent(obj, key)) {
                        y yVarA = next.a();
                        Object obj3 = yVarA.get();
                        if (lVar != yVarA && (obj3 != null || yVarA == a.B)) {
                            n(obj, i, obj2, 0, RemovalCause.REPLACED);
                            return false;
                        }
                        this.d++;
                        if (lVar.isActive()) {
                            n(obj, i, obj3, lVar.getWeight(), obj3 == null ? RemovalCause.COLLECTED : RemovalCause.REPLACED);
                            i3--;
                        }
                        c0(next, obj, obj2, j);
                        this.b = i3;
                        o(next);
                        return true;
                    }
                }
                this.d++;
                b bVarE = E(obj, i, bVar);
                c0(bVarE, obj, obj2, j);
                atomicReferenceArray.set(length, bVarE);
                this.b = i3;
                o(bVarE);
                return true;
            } finally {
                unlock();
                H();
            }
        }

        public void e() {
            if (this.a.O()) {
                c();
            }
            if (this.a.P()) {
                f();
            }
        }

        public void e0() {
            if (tryLock()) {
                try {
                    l();
                } finally {
                    unlock();
                }
            }
        }

        public void f() {
            while (this.i.poll() != null) {
            }
        }

        public void f0(long j) {
            if (tryLock()) {
                try {
                    q(j);
                } finally {
                    unlock();
                }
            }
        }

        public Object g0(b bVar, Object obj, y yVar) {
            if (!yVar.c()) {
                throw new AssertionError();
            }
            Preconditions.checkState(!Thread.holdsLock(bVar), "Recursive load of: %s", obj);
            try {
                Object objD = yVar.d();
                if (objD != null) {
                    N(bVar, this.a.t.read());
                    this.p.recordMisses(1);
                    return objD;
                }
                String strValueOf = String.valueOf(obj);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 35);
                sb.append("CacheLoader returned null for key ");
                sb.append(strValueOf);
                sb.append(".");
                throw new CacheLoader.InvalidCacheLoadException(sb.toString());
            } catch (Throwable th) {
                this.p.recordMisses(1);
                throw th;
            }
        }

        public boolean h(Object obj, int i) {
            try {
                if (this.b == 0) {
                    return false;
                }
                b bVarW = w(obj, i, this.a.t.read());
                if (bVarW == null) {
                    return false;
                }
                return bVarW.a().get() != null;
            } finally {
                G();
            }
        }

        public b i(b bVar, b bVar2) {
            if (bVar.getKey() == null) {
                return null;
            }
            y yVarA = bVar.a();
            Object obj = yVarA.get();
            if (obj == null && yVarA.isActive()) {
                return null;
            }
            b bVarC = this.a.u.c(this, bVar, bVar2);
            bVarC.e(yVarA.e(this.i, obj, bVarC));
            return bVarC;
        }

        public void j() {
            int i = 0;
            do {
                Object objPoll = this.h.poll();
                if (objPoll == null) {
                    return;
                }
                this.a.B((b) objPoll);
                i++;
            } while (i != 16);
        }

        public void k() {
            while (true) {
                b bVar = (b) this.j.poll();
                if (bVar == null) {
                    return;
                }
                if (this.n.contains(bVar)) {
                    this.n.add(bVar);
                }
            }
        }

        public void l() {
            if (this.a.O()) {
                j();
            }
            if (this.a.P()) {
                m();
            }
        }

        public void m() {
            int i = 0;
            do {
                Object objPoll = this.i.poll();
                if (objPoll == null) {
                    return;
                }
                this.a.C((y) objPoll);
                i++;
            } while (i != 16);
        }

        public void n(Object obj, int i, Object obj2, int i2, RemovalCause removalCause) {
            this.c -= (long) i2;
            if (removalCause.wasEvicted()) {
                this.p.recordEviction();
            }
            if (this.a.p != a.C) {
                this.a.p.offer(RemovalNotification.create(obj, obj2, removalCause));
            }
        }

        public void o(b bVar) {
            if (this.a.h()) {
                k();
                if (bVar.a().getWeight() > this.g && !T(bVar, bVar.b(), RemovalCause.SIZE)) {
                    throw new AssertionError();
                }
                while (this.c > this.g) {
                    b bVarY = y();
                    if (!T(bVarY, bVarY.b(), RemovalCause.SIZE)) {
                        throw new AssertionError();
                    }
                }
            }
        }

        public void p() {
            AtomicReferenceArray atomicReferenceArray = this.f;
            int length = atomicReferenceArray.length();
            if (length >= 1073741824) {
                return;
            }
            int i = this.b;
            AtomicReferenceArray atomicReferenceArrayF = F(length << 1);
            this.e = (atomicReferenceArrayF.length() * 3) / 4;
            int length2 = atomicReferenceArrayF.length() - 1;
            for (int i2 = 0; i2 < length; i2++) {
                b next = (b) atomicReferenceArray.get(i2);
                if (next != null) {
                    b next2 = next.getNext();
                    int iB = next.b() & length2;
                    if (next2 == null) {
                        atomicReferenceArrayF.set(iB, next);
                    } else {
                        b bVar = next;
                        while (next2 != null) {
                            int iB2 = next2.b() & length2;
                            if (iB2 != iB) {
                                bVar = next2;
                                iB = iB2;
                            }
                            next2 = next2.getNext();
                        }
                        atomicReferenceArrayF.set(iB, bVar);
                        while (next != bVar) {
                            int iB3 = next.b() & length2;
                            b bVarI = i(next, (b) atomicReferenceArrayF.get(iB3));
                            if (bVarI != null) {
                                atomicReferenceArrayF.set(iB3, bVarI);
                            } else {
                                S(next);
                                i--;
                            }
                            next = next.getNext();
                        }
                    }
                }
            }
            this.f = atomicReferenceArrayF;
            this.b = i;
        }

        public void q(long j) {
            b bVar;
            b bVar2;
            k();
            do {
                bVar = (b) this.l.peek();
                if (bVar == null || !this.a.t(bVar, j)) {
                    do {
                        bVar2 = (b) this.n.peek();
                        if (bVar2 == null || !this.a.t(bVar2, j)) {
                            return;
                        }
                    } while (T(bVar2, bVar2.b(), RemovalCause.EXPIRED));
                    throw new AssertionError();
                }
            } while (T(bVar, bVar.b(), RemovalCause.EXPIRED));
            throw new AssertionError();
        }

        public Object r(Object obj, int i) {
            try {
                if (this.b != 0) {
                    long j = this.a.t.read();
                    b bVarW = w(obj, i, j);
                    if (bVarW == null) {
                        return null;
                    }
                    Object obj2 = bVarW.a().get();
                    if (obj2 != null) {
                        N(bVarW, j);
                        return b0(bVarW, bVarW.getKey(), i, obj2, j, this.a.w);
                    }
                    e0();
                }
                return null;
            } finally {
                G();
            }
        }

        public Object s(Object obj, int i, CacheLoader cacheLoader) {
            b bVarU;
            Preconditions.checkNotNull(obj);
            Preconditions.checkNotNull(cacheLoader);
            try {
                try {
                    if (this.b != 0 && (bVarU = u(obj, i)) != null) {
                        long j = this.a.t.read();
                        Object objX = x(bVarU, j);
                        if (objX != null) {
                            N(bVarU, j);
                            this.p.recordHits(1);
                            Object objB0 = b0(bVarU, obj, i, objX, j, cacheLoader);
                            G();
                            return objB0;
                        }
                        y yVarA = bVarU.a();
                        if (yVarA.c()) {
                            Object objG0 = g0(bVarU, obj, yVarA);
                            G();
                            return objG0;
                        }
                    }
                    Object objD = D(obj, i, cacheLoader);
                    G();
                    return objD;
                } catch (ExecutionException e) {
                    Throwable cause = e.getCause();
                    if (cause instanceof Error) {
                        throw new ExecutionError((Error) cause);
                    }
                    if (cause instanceof RuntimeException) {
                        throw new UncheckedExecutionException(cause);
                    }
                    throw e;
                }
            } catch (Throwable th) {
                G();
                throw th;
            }
        }

        public Object t(Object obj, int i, l lVar, ListenableFuture listenableFuture) throws Throwable {
            Object uninterruptibly;
            try {
                uninterruptibly = Uninterruptibles.getUninterruptibly(listenableFuture);
                try {
                    if (uninterruptibly != null) {
                        this.p.recordLoadSuccess(lVar.f());
                        d0(obj, i, lVar, uninterruptibly);
                        return uninterruptibly;
                    }
                    String strValueOf = String.valueOf(obj);
                    StringBuilder sb = new StringBuilder(strValueOf.length() + 35);
                    sb.append("CacheLoader returned null for key ");
                    sb.append(strValueOf);
                    sb.append(".");
                    throw new CacheLoader.InvalidCacheLoadException(sb.toString());
                } catch (Throwable th) {
                    th = th;
                    if (uninterruptibly == null) {
                        this.p.recordLoadException(lVar.f());
                        V(obj, i, lVar);
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                uninterruptibly = null;
            }
        }

        public b u(Object obj, int i) {
            for (b bVarV = v(i); bVarV != null; bVarV = bVarV.getNext()) {
                if (bVarV.b() == i) {
                    Object key = bVarV.getKey();
                    if (key == null) {
                        e0();
                    } else if (this.a.e.equivalent(obj, key)) {
                        return bVarV;
                    }
                }
            }
            return null;
        }

        public b v(int i) {
            AtomicReferenceArray atomicReferenceArray = this.f;
            return (b) atomicReferenceArray.get(i & (atomicReferenceArray.length() - 1));
        }

        public b w(Object obj, int i, long j) {
            b bVarU = u(obj, i);
            if (bVarU == null) {
                return null;
            }
            if (!this.a.t(bVarU, j)) {
                return bVarU;
            }
            f0(j);
            return null;
        }

        public Object x(b bVar, long j) {
            if (bVar.getKey() == null) {
                e0();
                return null;
            }
            Object obj = bVar.a().get();
            if (obj == null) {
                e0();
                return null;
            }
            if (!this.a.t(bVar, j)) {
                return obj;
            }
            f0(j);
            return null;
        }

        public b y() {
            for (b bVar : this.n) {
                if (bVar.a().getWeight() > 0) {
                    return bVar;
                }
            }
            throw new AssertionError();
        }

        public void z(AtomicReferenceArray atomicReferenceArray) {
            this.e = (atomicReferenceArray.length() * 3) / 4;
            if (!this.a.f()) {
                int i = this.e;
                if (i == this.g) {
                    this.e = i + 1;
                }
            }
            this.f = atomicReferenceArray;
        }
    }

    public static class q extends SoftReference implements y {
        public final b a;

        public q(ReferenceQueue referenceQueue, Object obj, b bVar) {
            super(obj, referenceQueue);
            this.a = bVar;
        }

        @Override // com.google.common.cache.a.y
        public b a() {
            return this.a;
        }

        @Override // com.google.common.cache.a.y
        public void b(Object obj) {
        }

        @Override // com.google.common.cache.a.y
        public boolean c() {
            return false;
        }

        @Override // com.google.common.cache.a.y
        public Object d() {
            return get();
        }

        public y e(ReferenceQueue referenceQueue, Object obj, b bVar) {
            return new q(referenceQueue, obj, bVar);
        }

        public int getWeight() {
            return 1;
        }

        @Override // com.google.common.cache.a.y
        public boolean isActive() {
            return true;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class r {
        public static final r a = new C0215a("STRONG", 0);
        public static final r b = new b("SOFT", 1);
        public static final r c = new c("WEAK", 2);
        public static final /* synthetic */ r[] d = a();

        /* JADX INFO: renamed from: com.google.common.cache.a$r$a, reason: collision with other inner class name */
        public final enum C0215a extends r {
            public C0215a(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.cache.a.r
            public Equivalence b() {
                return Equivalence.equals();
            }

            @Override // com.google.common.cache.a.r
            public y c(p pVar, com.google.common.cache.b bVar, Object obj, int i) {
                return i == 1 ? new v(obj) : new G(obj, i);
            }
        }

        public final enum b extends r {
            public b(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.cache.a.r
            public Equivalence b() {
                return Equivalence.identity();
            }

            @Override // com.google.common.cache.a.r
            public y c(p pVar, com.google.common.cache.b bVar, Object obj, int i) {
                return i == 1 ? new q(pVar.i, obj, bVar) : new F(pVar.i, obj, bVar, i);
            }
        }

        public final enum c extends r {
            public c(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.cache.a.r
            public Equivalence b() {
                return Equivalence.identity();
            }

            @Override // com.google.common.cache.a.r
            public y c(p pVar, com.google.common.cache.b bVar, Object obj, int i) {
                return i == 1 ? new D(pVar.i, obj, bVar) : new H(pVar.i, obj, bVar, i);
            }
        }

        public r(String str, int i) {
            super(str, i);
        }

        public static /* synthetic */ r[] a() {
            return new r[]{a, b, c};
        }

        public static r valueOf(String str) {
            return (r) Enum.valueOf(r.class, str);
        }

        public static r[] values() {
            return (r[]) d.clone();
        }

        public abstract Equivalence b();

        public abstract y c(p pVar, com.google.common.cache.b bVar, Object obj, int i);

        public /* synthetic */ r(String str, int i, C0208a c0208a) {
            this(str, i);
        }
    }

    public static final class s extends u {
        public volatile long e;
        public b f;
        public b g;

        public s(Object obj, int i, b bVar) {
            super(obj, i, bVar);
            this.e = LocationRequestCompat.PASSIVE_INTERVAL;
            this.f = a.x();
            this.g = a.x();
        }

        @Override // com.google.common.cache.a.AbstractC1927d, com.google.common.cache.b
        public b c() {
            return this.g;
        }

        @Override // com.google.common.cache.a.AbstractC1927d, com.google.common.cache.b
        public void h(long j) {
            this.e = j;
        }

        @Override // com.google.common.cache.a.AbstractC1927d, com.google.common.cache.b
        public long j() {
            return this.e;
        }

        @Override // com.google.common.cache.a.AbstractC1927d, com.google.common.cache.b
        public b l() {
            return this.f;
        }

        @Override // com.google.common.cache.a.AbstractC1927d, com.google.common.cache.b
        public void m(b bVar) {
            this.f = bVar;
        }

        @Override // com.google.common.cache.a.AbstractC1927d, com.google.common.cache.b
        public void p(b bVar) {
            this.g = bVar;
        }
    }

    public static final class t extends u {
        public volatile long e;
        public b f;
        public b g;
        public volatile long h;
        public b i;
        public b j;

        public t(Object obj, int i, b bVar) {
            super(obj, i, bVar);
            this.e = LocationRequestCompat.PASSIVE_INTERVAL;
            this.f = a.x();
            this.g = a.x();
            this.h = LocationRequestCompat.PASSIVE_INTERVAL;
            this.i = a.x();
            this.j = a.x();
        }

        @Override // com.google.common.cache.a.AbstractC1927d, com.google.common.cache.b
        public b c() {
            return this.g;
        }

        @Override // com.google.common.cache.a.AbstractC1927d, com.google.common.cache.b
        public long f() {
            return this.h;
        }

        @Override // com.google.common.cache.a.AbstractC1927d, com.google.common.cache.b
        public void h(long j) {
            this.e = j;
        }

        @Override // com.google.common.cache.a.AbstractC1927d, com.google.common.cache.b
        public b i() {
            return this.i;
        }

        @Override // com.google.common.cache.a.AbstractC1927d, com.google.common.cache.b
        public long j() {
            return this.e;
        }

        @Override // com.google.common.cache.a.AbstractC1927d, com.google.common.cache.b
        public void k(long j) {
            this.h = j;
        }

        @Override // com.google.common.cache.a.AbstractC1927d, com.google.common.cache.b
        public b l() {
            return this.f;
        }

        @Override // com.google.common.cache.a.AbstractC1927d, com.google.common.cache.b
        public void m(b bVar) {
            this.f = bVar;
        }

        @Override // com.google.common.cache.a.AbstractC1927d, com.google.common.cache.b
        public void n(b bVar) {
            this.i = bVar;
        }

        @Override // com.google.common.cache.a.AbstractC1927d, com.google.common.cache.b
        public void o(b bVar) {
            this.j = bVar;
        }

        @Override // com.google.common.cache.a.AbstractC1927d, com.google.common.cache.b
        public void p(b bVar) {
            this.g = bVar;
        }

        @Override // com.google.common.cache.a.AbstractC1927d, com.google.common.cache.b
        public b q() {
            return this.j;
        }
    }

    public static class u extends AbstractC1927d {
        public final Object a;
        public final int b;
        public final b c;
        public volatile y d = a.L();

        public u(Object obj, int i, b bVar) {
            this.a = obj;
            this.b = i;
            this.c = bVar;
        }

        @Override // com.google.common.cache.a.AbstractC1927d, com.google.common.cache.b
        public y a() {
            return this.d;
        }

        @Override // com.google.common.cache.a.AbstractC1927d, com.google.common.cache.b
        public int b() {
            return this.b;
        }

        @Override // com.google.common.cache.a.AbstractC1927d, com.google.common.cache.b
        public void e(y yVar) {
            this.d = yVar;
        }

        @Override // com.google.common.cache.a.AbstractC1927d, com.google.common.cache.b
        public Object getKey() {
            return this.a;
        }

        @Override // com.google.common.cache.a.AbstractC1927d, com.google.common.cache.b
        public b getNext() {
            return this.c;
        }
    }

    public static class v implements y {
        public final Object a;

        public v(Object obj) {
            this.a = obj;
        }

        @Override // com.google.common.cache.a.y
        public b a() {
            return null;
        }

        @Override // com.google.common.cache.a.y
        public void b(Object obj) {
        }

        @Override // com.google.common.cache.a.y
        public boolean c() {
            return false;
        }

        @Override // com.google.common.cache.a.y
        public Object d() {
            return get();
        }

        @Override // com.google.common.cache.a.y
        public y e(ReferenceQueue referenceQueue, Object obj, b bVar) {
            return this;
        }

        @Override // com.google.common.cache.a.y
        public Object get() {
            return this.a;
        }

        @Override // com.google.common.cache.a.y
        public int getWeight() {
            return 1;
        }

        @Override // com.google.common.cache.a.y
        public boolean isActive() {
            return true;
        }
    }

    public static final class w extends u {
        public volatile long e;
        public b f;
        public b g;

        public w(Object obj, int i, b bVar) {
            super(obj, i, bVar);
            this.e = LocationRequestCompat.PASSIVE_INTERVAL;
            this.f = a.x();
            this.g = a.x();
        }

        @Override // com.google.common.cache.a.AbstractC1927d, com.google.common.cache.b
        public long f() {
            return this.e;
        }

        @Override // com.google.common.cache.a.AbstractC1927d, com.google.common.cache.b
        public b i() {
            return this.f;
        }

        @Override // com.google.common.cache.a.AbstractC1927d, com.google.common.cache.b
        public void k(long j) {
            this.e = j;
        }

        @Override // com.google.common.cache.a.AbstractC1927d, com.google.common.cache.b
        public void n(b bVar) {
            this.f = bVar;
        }

        @Override // com.google.common.cache.a.AbstractC1927d, com.google.common.cache.b
        public void o(b bVar) {
            this.g = bVar;
        }

        @Override // com.google.common.cache.a.AbstractC1927d, com.google.common.cache.b
        public b q() {
            return this.g;
        }
    }

    public final class x extends AbstractC1932i {
        public x(a aVar) {
            super();
        }

        @Override // java.util.Iterator
        public Object next() {
            return c().getValue();
        }
    }

    public interface y {
        b a();

        void b(Object obj);

        boolean c();

        Object d();

        y e(ReferenceQueue referenceQueue, Object obj, b bVar);

        Object get();

        int getWeight();

        boolean isActive();
    }

    public final class z extends AbstractCollection {
        public z() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            a.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return a.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return a.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new x(a.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return a.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return a.K(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            return a.K(this).toArray(objArr);
        }
    }

    public a(CacheBuilder cacheBuilder, CacheLoader cacheLoader) {
        this.d = Math.min(cacheBuilder.getConcurrencyLevel(), 65536);
        r keyStrength = cacheBuilder.getKeyStrength();
        this.g = keyStrength;
        this.h = cacheBuilder.getValueStrength();
        this.e = cacheBuilder.getKeyEquivalence();
        this.f = cacheBuilder.getValueEquivalence();
        long maximumWeight = cacheBuilder.getMaximumWeight();
        this.i = maximumWeight;
        this.j = cacheBuilder.getWeigher();
        this.k = cacheBuilder.getExpireAfterAccessNanos();
        this.l = cacheBuilder.getExpireAfterWriteNanos();
        this.n = cacheBuilder.getRefreshNanos();
        RemovalListener removalListener = cacheBuilder.getRemovalListener();
        this.q = removalListener;
        this.p = removalListener == CacheBuilder.d.INSTANCE ? g() : new ConcurrentLinkedQueue();
        this.t = cacheBuilder.getTicker(E());
        this.u = EnumC1929f.f(keyStrength, M(), Q());
        this.v = cacheBuilder.getStatsCounterSupplier().get();
        this.w = cacheLoader;
        int iMin = Math.min(cacheBuilder.getInitialCapacity(), 1073741824);
        if (h() && !f()) {
            iMin = (int) Math.min(iMin, maximumWeight);
        }
        int i = 0;
        int i2 = 1;
        int i3 = 1;
        int i4 = 0;
        while (i3 < this.d && (!h() || i3 * 20 <= this.i)) {
            i4++;
            i3 <<= 1;
        }
        this.b = 32 - i4;
        this.a = i3 - 1;
        this.c = w(i3);
        int i5 = iMin / i3;
        while (i2 < (i5 * i3 < iMin ? i5 + 1 : i5)) {
            i2 <<= 1;
        }
        if (h()) {
            long j = this.i;
            long j2 = i3;
            long j3 = (j / j2) + 1;
            long j4 = j % j2;
            while (true) {
                p[] pVarArr = this.c;
                if (i >= pVarArr.length) {
                    return;
                }
                if (i == j4) {
                    j3--;
                }
                pVarArr[i] = e(i2, j3, cacheBuilder.getStatsCounterSupplier().get());
                i++;
            }
        } else {
            while (true) {
                p[] pVarArr2 = this.c;
                if (i >= pVarArr2.length) {
                    return;
                }
                pVarArr2[i] = e(i2, -1L, cacheBuilder.getStatsCounterSupplier().get());
                i++;
            }
        }
    }

    public static int I(int i) {
        int i2 = i + ((i << 15) ^ (-12931));
        int i3 = i2 ^ (i2 >>> 10);
        int i4 = i3 + (i3 << 3);
        int i5 = i4 ^ (i4 >>> 6);
        int i6 = i5 + (i5 << 2) + (i5 << 14);
        return i6 ^ (i6 >>> 16);
    }

    public static ArrayList K(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterators.addAll(arrayList, collection.iterator());
        return arrayList;
    }

    public static y L() {
        return B;
    }

    public static void c(b bVar, b bVar2) {
        bVar.m(bVar2);
        bVar2.p(bVar);
    }

    public static void d(b bVar, b bVar2) {
        bVar.n(bVar2);
        bVar2.o(bVar);
    }

    public static Queue g() {
        return C;
    }

    public static b x() {
        return o.INSTANCE;
    }

    public static void y(b bVar) {
        b bVarX = x();
        bVar.m(bVarX);
        bVar.p(bVarX);
    }

    public static void z(b bVar) {
        b bVarX = x();
        bVar.n(bVarX);
        bVar.o(bVarX);
    }

    public void A() {
        while (true) {
            RemovalNotification removalNotification = (RemovalNotification) this.p.poll();
            if (removalNotification == null) {
                return;
            }
            try {
                this.q.onRemoval(removalNotification);
            } catch (Throwable th) {
                A.log(Level.WARNING, "Exception thrown by removal listener", th);
            }
        }
    }

    public void B(b bVar) {
        int iB = bVar.b();
        J(iB).K(bVar, iB);
    }

    public void C(y yVar) {
        b bVarA = yVar.a();
        int iB = bVarA.b();
        J(iB).L(bVarA.getKey(), iB, yVar);
    }

    public boolean D() {
        return j();
    }

    public boolean E() {
        return F() || D();
    }

    public boolean F() {
        return k() || H();
    }

    public void G(Object obj) {
        int iR = r(Preconditions.checkNotNull(obj));
        J(iR).P(obj, iR, this.w, false);
    }

    public boolean H() {
        return this.n > 0;
    }

    public p J(int i) {
        return this.c[(i >>> this.b) & this.a];
    }

    public boolean M() {
        return N() || D();
    }

    public boolean N() {
        return j() || h();
    }

    public boolean O() {
        return this.g != r.a;
    }

    public boolean P() {
        return this.h != r.a;
    }

    public boolean Q() {
        return R() || F();
    }

    public boolean R() {
        return k();
    }

    public void b() {
        for (p pVar : this.c) {
            pVar.a();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (p pVar : this.c) {
            pVar.b();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (obj == null) {
            return false;
        }
        int iR = r(obj);
        return J(iR).h(obj, iR);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        if (obj == null) {
            return false;
        }
        long j = this.t.read();
        p[] pVarArr = this.c;
        long j2 = -1;
        int i = 0;
        while (i < 3) {
            int length = pVarArr.length;
            long j3 = 0;
            int i2 = 0;
            while (i2 < length) {
                p pVar = pVarArr[i2];
                int i3 = pVar.b;
                AtomicReferenceArray atomicReferenceArray = pVar.f;
                for (int i4 = 0; i4 < atomicReferenceArray.length(); i4++) {
                    b next = (b) atomicReferenceArray.get(i4);
                    while (next != null) {
                        p[] pVarArr2 = pVarArr;
                        Object objX = pVar.x(next, j);
                        long j4 = j;
                        if (objX != null && this.f.equivalent(obj, objX)) {
                            return true;
                        }
                        next = next.getNext();
                        pVarArr = pVarArr2;
                        j = j4;
                    }
                }
                j3 += (long) pVar.d;
                i2++;
                j = j;
            }
            long j5 = j;
            p[] pVarArr3 = pVarArr;
            if (j3 == j2) {
                return false;
            }
            i++;
            j2 = j3;
            pVarArr = pVarArr3;
            j = j5;
        }
        return false;
    }

    public p e(int i, long j, AbstractCache.StatsCounter statsCounter) {
        return new p(this, i, j, statsCounter);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        Set set = this.z;
        if (set != null) {
            return set;
        }
        C1931h c1931h = new C1931h();
        this.z = c1931h;
        return c1931h;
    }

    public boolean f() {
        return this.j != CacheBuilder.e.INSTANCE;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        if (obj == null) {
            return null;
        }
        int iR = r(obj);
        return J(iR).r(obj, iR);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    public boolean h() {
        return this.i >= 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        p[] pVarArr = this.c;
        long j = 0;
        for (int i = 0; i < pVarArr.length; i++) {
            if (pVarArr[i].b != 0) {
                return false;
            }
            j += (long) pVarArr[i].d;
        }
        if (j == 0) {
            return true;
        }
        for (int i2 = 0; i2 < pVarArr.length; i2++) {
            if (pVarArr[i2].b != 0) {
                return false;
            }
            j -= (long) pVarArr[i2].d;
        }
        return j == 0;
    }

    public boolean j() {
        return this.k > 0;
    }

    public boolean k() {
        return this.l > 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        Set set = this.x;
        if (set != null) {
            return set;
        }
        k kVar = new k();
        this.x = kVar;
        return kVar;
    }

    public Object l(Object obj, CacheLoader cacheLoader) {
        int iR = r(Preconditions.checkNotNull(obj));
        return J(iR).s(obj, iR, cacheLoader);
    }

    public ImmutableMap m(Iterable iterable) {
        LinkedHashMap linkedHashMapNewLinkedHashMap = Maps.newLinkedHashMap();
        LinkedHashSet linkedHashSetNewLinkedHashSet = Sets.newLinkedHashSet();
        int i = 0;
        int i2 = 0;
        for (Object obj : iterable) {
            Object obj2 = get(obj);
            if (!linkedHashMapNewLinkedHashMap.containsKey(obj)) {
                linkedHashMapNewLinkedHashMap.put(obj, obj2);
                if (obj2 == null) {
                    i2++;
                    linkedHashSetNewLinkedHashSet.add(obj);
                } else {
                    i++;
                }
            }
        }
        try {
            if (!linkedHashSetNewLinkedHashSet.isEmpty()) {
                try {
                    Map mapU = u(Collections.unmodifiableSet(linkedHashSetNewLinkedHashSet), this.w);
                    for (Object obj3 : linkedHashSetNewLinkedHashSet) {
                        Object obj4 = mapU.get(obj3);
                        if (obj4 == null) {
                            String strValueOf = String.valueOf(obj3);
                            StringBuilder sb = new StringBuilder(strValueOf.length() + 37);
                            sb.append("loadAll failed to return a value for ");
                            sb.append(strValueOf);
                            throw new CacheLoader.InvalidCacheLoadException(sb.toString());
                        }
                        linkedHashMapNewLinkedHashMap.put(obj3, obj4);
                    }
                } catch (CacheLoader.UnsupportedLoadingOperationException unused) {
                    for (Object obj5 : linkedHashSetNewLinkedHashSet) {
                        i2--;
                        linkedHashMapNewLinkedHashMap.put(obj5, l(obj5, this.w));
                    }
                }
            }
            ImmutableMap immutableMapCopyOf = ImmutableMap.copyOf((Map) linkedHashMapNewLinkedHashMap);
            this.v.recordHits(i);
            this.v.recordMisses(i2);
            return immutableMapCopyOf;
        } catch (Throwable th) {
            this.v.recordHits(i);
            this.v.recordMisses(i2);
            throw th;
        }
    }

    public ImmutableMap n(Iterable iterable) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        int i = 0;
        int i2 = 0;
        for (Object obj : iterable) {
            Object obj2 = get(obj);
            if (obj2 == null) {
                i2++;
            } else {
                builder.put(obj, obj2);
                i++;
            }
        }
        this.v.recordHits(i);
        this.v.recordMisses(i2);
        return builder.buildKeepingLast();
    }

    public Object o(Object obj) {
        int iR = r(Preconditions.checkNotNull(obj));
        Object objR = J(iR).r(obj, iR);
        if (objR == null) {
            this.v.recordMisses(1);
        } else {
            this.v.recordHits(1);
        }
        return objR;
    }

    public Object p(b bVar, long j) {
        Object obj;
        if (bVar.getKey() == null || (obj = bVar.a().get()) == null || t(bVar, j)) {
            return null;
        }
        return obj;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(obj2);
        int iR = r(obj);
        return J(iR).J(obj, iR, obj2, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public Object putIfAbsent(Object obj, Object obj2) {
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(obj2);
        int iR = r(obj);
        return J(iR).J(obj, iR, obj2, true);
    }

    public Object q(Object obj) {
        return l(obj, this.w);
    }

    public int r(Object obj) {
        return I(this.e.hash(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        if (obj == null) {
            return null;
        }
        int iR = r(obj);
        return J(iR).Q(obj, iR);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(Object obj, Object obj2, Object obj3) {
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(obj3);
        if (obj2 == null) {
            return false;
        }
        int iR = r(obj);
        return J(iR).Y(obj, iR, obj2, obj3);
    }

    public void s(Iterable iterable) {
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return Ints.saturatedCast(v());
    }

    public boolean t(b bVar, long j) {
        Preconditions.checkNotNull(bVar);
        if (!j() || j - bVar.j() < this.k) {
            return k() && j - bVar.f() >= this.l;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00cd  */
    public Map u(Set set, CacheLoader cacheLoader) throws Throwable {
        Preconditions.checkNotNull(cacheLoader);
        Preconditions.checkNotNull(set);
        Stopwatch stopwatchCreateStarted = Stopwatch.createStarted();
        boolean z2 = true;
        boolean z3 = false;
        try {
            try {
                try {
                    try {
                        try {
                            Map mapLoadAll = cacheLoader.loadAll(set);
                            if (mapLoadAll == null) {
                                this.v.recordLoadException(stopwatchCreateStarted.elapsed(TimeUnit.NANOSECONDS));
                                String strValueOf = String.valueOf(cacheLoader);
                                StringBuilder sb = new StringBuilder(strValueOf.length() + 31);
                                sb.append(strValueOf);
                                sb.append(" returned null map from loadAll");
                                throw new CacheLoader.InvalidCacheLoadException(sb.toString());
                            }
                            stopwatchCreateStarted.stop();
                            for (Map.Entry entry : mapLoadAll.entrySet()) {
                                Object key = entry.getKey();
                                Object value = entry.getValue();
                                if (key == null || value == null) {
                                    z3 = true;
                                } else {
                                    put(key, value);
                                }
                            }
                            if (!z3) {
                                this.v.recordLoadSuccess(stopwatchCreateStarted.elapsed(TimeUnit.NANOSECONDS));
                                return mapLoadAll;
                            }
                            this.v.recordLoadException(stopwatchCreateStarted.elapsed(TimeUnit.NANOSECONDS));
                            String strValueOf2 = String.valueOf(cacheLoader);
                            StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 42);
                            sb2.append(strValueOf2);
                            sb2.append(" returned null keys or values from loadAll");
                            throw new CacheLoader.InvalidCacheLoadException(sb2.toString());
                        } catch (RuntimeException e) {
                            throw new UncheckedExecutionException(e);
                        }
                    } catch (InterruptedException e2) {
                        Thread.currentThread().interrupt();
                        throw new ExecutionException(e2);
                    }
                } catch (Error e3) {
                    throw new ExecutionError(e3);
                }
            } catch (CacheLoader.UnsupportedLoadingOperationException e4) {
                try {
                    throw e4;
                } catch (Throwable th) {
                    th = th;
                    if (!z2) {
                        this.v.recordLoadException(stopwatchCreateStarted.elapsed(TimeUnit.NANOSECONDS));
                    }
                    throw th;
                }
            } catch (Exception e5) {
                throw new ExecutionException(e5);
            }
        } catch (Throwable th2) {
            th = th2;
            z2 = false;
            if (!z2) {
                this.v.recordLoadException(stopwatchCreateStarted.elapsed(TimeUnit.NANOSECONDS));
            }
            throw th;
        }
    }

    public long v() {
        long jMax = 0;
        for (p pVar : this.c) {
            jMax += (long) Math.max(0, pVar.b);
        }
        return jMax;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection values() {
        Collection collection = this.y;
        if (collection != null) {
            return collection;
        }
        z zVar = new z();
        this.y = zVar;
        return zVar;
    }

    public final p[] w(int i) {
        return new p[i];
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int iR = r(obj);
        return J(iR).R(obj, iR, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public Object replace(Object obj, Object obj2) {
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(obj2);
        int iR = r(obj);
        return J(iR).X(obj, iR, obj2);
    }
}
