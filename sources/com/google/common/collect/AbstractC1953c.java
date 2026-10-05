package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import defpackage.AbstractC1163Zb;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: com.google.common.collect.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1953c extends AbstractC1955e implements Serializable {

    @GwtIncompatible
    private static final long serialVersionUID = 0;
    transient w backingMap;
    transient long size;

    /* JADX INFO: renamed from: com.google.common.collect.c$a */
    public class a extends AbstractC0240c {
        public a() {
            super();
        }

        @Override // com.google.common.collect.AbstractC1953c.AbstractC0240c
        public Object b(int i) {
            return AbstractC1953c.this.backingMap.i(i);
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.c$b */
    public class b extends AbstractC0240c {
        public b() {
            super();
        }

        @Override // com.google.common.collect.AbstractC1953c.AbstractC0240c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Multiset.Entry b(int i) {
            return AbstractC1953c.this.backingMap.g(i);
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.c$c, reason: collision with other inner class name */
    public abstract class AbstractC0240c implements Iterator {
        public int a;
        public int b = -1;
        public int c;

        public AbstractC0240c() {
            this.a = AbstractC1953c.this.backingMap.e();
            this.c = AbstractC1953c.this.backingMap.d;
        }

        public final void a() {
            if (AbstractC1953c.this.backingMap.d != this.c) {
                throw new ConcurrentModificationException();
            }
        }

        public abstract Object b(int i);

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.a >= 0;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Object objB = b(this.a);
            int i = this.a;
            this.b = i;
            this.a = AbstractC1953c.this.backingMap.s(i);
            return objB;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            AbstractC1163Zb.e(this.b != -1);
            AbstractC1953c abstractC1953c = AbstractC1953c.this;
            abstractC1953c.size -= (long) abstractC1953c.backingMap.x(this.b);
            this.a = AbstractC1953c.this.backingMap.t(this.a, this.b);
            this.b = -1;
            this.c = AbstractC1953c.this.backingMap.d;
        }
    }

    public AbstractC1953c(int i) {
        this.backingMap = newBackingMap(i);
    }

    @Override // com.google.common.collect.AbstractC1955e, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public final int add(Object obj, int i) {
        if (i == 0) {
            return count(obj);
        }
        Preconditions.checkArgument(i > 0, "occurrences cannot be negative: %s", i);
        int iM = this.backingMap.m(obj);
        if (iM == -1) {
            this.backingMap.u(obj, i);
            this.size += (long) i;
            return 0;
        }
        int iK = this.backingMap.k(iM);
        long j = i;
        long j2 = ((long) iK) + j;
        Preconditions.checkArgument(j2 <= 2147483647L, "too many occurrences: %s", j2);
        this.backingMap.B(iM, (int) j2);
        this.size += j;
        return iK;
    }

    public void addTo(Multiset<Object> multiset) {
        Preconditions.checkNotNull(multiset);
        int iE = this.backingMap.e();
        while (iE >= 0) {
            multiset.add(this.backingMap.i(iE), this.backingMap.k(iE));
            iE = this.backingMap.s(iE);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.backingMap.a();
        this.size = 0L;
    }

    @Override // com.google.common.collect.Multiset
    public final int count(Object obj) {
        return this.backingMap.f(obj);
    }

    @Override // com.google.common.collect.AbstractC1955e
    public final int distinctElements() {
        return this.backingMap.C();
    }

    @Override // com.google.common.collect.AbstractC1955e
    public final Iterator<Object> elementIterator() {
        return new a();
    }

    @Override // com.google.common.collect.AbstractC1955e
    public final Iterator<Multiset.Entry<Object>> entryIterator() {
        return new b();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public final Iterator<Object> iterator() {
        return Multisets.iteratorImpl(this);
    }

    public abstract w newBackingMap(int i);

    @Override // com.google.common.collect.AbstractC1955e, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public final int remove(Object obj, int i) {
        if (i == 0) {
            return count(obj);
        }
        Preconditions.checkArgument(i > 0, "occurrences cannot be negative: %s", i);
        int iM = this.backingMap.m(obj);
        if (iM == -1) {
            return 0;
        }
        int iK = this.backingMap.k(iM);
        if (iK > i) {
            this.backingMap.B(iM, iK - i);
        } else {
            this.backingMap.x(iM);
            i = iK;
        }
        this.size -= (long) i;
        return iK;
    }

    @Override // com.google.common.collect.AbstractC1955e, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public final int setCount(Object obj, int i) {
        AbstractC1163Zb.b(i, "count");
        w wVar = this.backingMap;
        int iV = i == 0 ? wVar.v(obj) : wVar.u(obj, i);
        this.size += (long) (i - iV);
        return iV;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public final int size() {
        return Ints.saturatedCast(this.size);
    }

    @Override // com.google.common.collect.AbstractC1955e, com.google.common.collect.Multiset
    public final boolean setCount(Object obj, int i, int i2) {
        AbstractC1163Zb.b(i, "oldCount");
        AbstractC1163Zb.b(i2, "newCount");
        int iM = this.backingMap.m(obj);
        if (iM == -1) {
            if (i != 0) {
                return false;
            }
            if (i2 > 0) {
                this.backingMap.u(obj, i2);
                this.size += (long) i2;
            }
            return true;
        }
        if (this.backingMap.k(iM) != i) {
            return false;
        }
        if (i2 == 0) {
            this.backingMap.x(iM);
            this.size -= (long) i;
        } else {
            this.backingMap.B(iM, i2);
            this.size += (long) (i2 - i);
        }
        return true;
    }
}
