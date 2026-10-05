package defpackage;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* JADX INFO: renamed from: Iv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0610Iv extends AbstractC1755b0 implements List, RandomAccess, Serializable, InterfaceC0782Nu {
    public static final b d = new b(null);
    public static final C0610Iv e;
    public Object[] a;
    public int b;
    public boolean c;

    /* JADX INFO: renamed from: Iv$a */
    public static final class a extends AbstractC1755b0 implements List, RandomAccess, Serializable, InterfaceC0782Nu {
        public Object[] a;
        public final int b;
        public int c;
        public final a d;
        public final C0610Iv e;

        /* JADX INFO: renamed from: Iv$a$a, reason: collision with other inner class name */
        public static final class C0010a implements ListIterator, InterfaceC0756Mu {
            public final a a;
            public int b;
            public int c;
            public int d;

            public C0010a(a aVar, int i) {
                AbstractC4492zt.h(aVar, "list");
                this.a = aVar;
                this.b = i;
                this.c = -1;
                this.d = ((AbstractList) aVar).modCount;
            }

            public final void a() {
                if (((AbstractList) this.a.e).modCount != this.d) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.ListIterator
            public void add(Object obj) {
                a();
                a aVar = this.a;
                int i = this.b;
                this.b = i + 1;
                aVar.add(i, obj);
                this.c = -1;
                this.d = ((AbstractList) this.a).modCount;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public boolean hasNext() {
                return this.b < this.a.c;
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return this.b > 0;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public Object next() {
                a();
                if (this.b >= this.a.c) {
                    throw new NoSuchElementException();
                }
                int i = this.b;
                this.b = i + 1;
                this.c = i;
                return this.a.a[this.a.b + this.c];
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.b;
            }

            @Override // java.util.ListIterator
            public Object previous() {
                a();
                int i = this.b;
                if (i <= 0) {
                    throw new NoSuchElementException();
                }
                int i2 = i - 1;
                this.b = i2;
                this.c = i2;
                return this.a.a[this.a.b + this.c];
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.b - 1;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public void remove() {
                a();
                int i = this.c;
                if (i == -1) {
                    throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
                }
                this.a.remove(i);
                this.b = this.c;
                this.c = -1;
                this.d = ((AbstractList) this.a).modCount;
            }

            @Override // java.util.ListIterator
            public void set(Object obj) {
                a();
                int i = this.c;
                if (i == -1) {
                    throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
                }
                this.a.set(i, obj);
            }
        }

        public a(Object[] objArr, int i, int i2, a aVar, C0610Iv c0610Iv) {
            AbstractC4492zt.h(objArr, "backing");
            AbstractC4492zt.h(c0610Iv, "root");
            this.a = objArr;
            this.b = i;
            this.c = i2;
            this.d = aVar;
            this.e = c0610Iv;
            ((AbstractList) this).modCount = ((AbstractList) c0610Iv).modCount;
        }

        private final void k() {
            if (((AbstractList) this.e).modCount != ((AbstractList) this).modCount) {
                throw new ConcurrentModificationException();
            }
        }

        private final void o() {
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean add(Object obj) {
            l();
            k();
            j(this.b + this.c, obj);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean addAll(Collection collection) {
            AbstractC4492zt.h(collection, "elements");
            l();
            k();
            int size = collection.size();
            h(this.b + this.c, collection, size);
            return size > 0;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            l();
            k();
            q(this.b, this.c);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            k();
            return obj == this || ((obj instanceof List) && m((List) obj));
        }

        @Override // java.util.AbstractList, java.util.List
        public Object get(int i) {
            k();
            V.Companion.b(i, this.c);
            return this.a[this.b + i];
        }

        @Override // defpackage.AbstractC1755b0
        public int getSize() {
            k();
            return this.c;
        }

        public final void h(int i, Collection collection, int i2) {
            o();
            a aVar = this.d;
            if (aVar != null) {
                aVar.h(i, collection, i2);
            } else {
                this.e.m(i, collection, i2);
            }
            this.a = this.e.a;
            this.c += i2;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            k();
            return AbstractC0636Jv.i(this.a, this.b, this.c);
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            k();
            for (int i = 0; i < this.c; i++) {
                if (AbstractC4492zt.d(this.a[this.b + i], obj)) {
                    return i;
                }
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            k();
            return this.c == 0;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator iterator() {
            return listIterator(0);
        }

        public final void j(int i, Object obj) {
            o();
            a aVar = this.d;
            if (aVar != null) {
                aVar.j(i, obj);
            } else {
                this.e.n(i, obj);
            }
            this.a = this.e.a;
            this.c++;
        }

        public final void l() {
            if (n()) {
                throw new UnsupportedOperationException();
            }
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            k();
            for (int i = this.c - 1; i >= 0; i--) {
                if (AbstractC4492zt.d(this.a[this.b + i], obj)) {
                    return i;
                }
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator listIterator() {
            return listIterator(0);
        }

        public final boolean m(List list) {
            return AbstractC0636Jv.h(this.a, this.b, this.c, list);
        }

        public final boolean n() {
            return this.e.c;
        }

        public final Object p(int i) {
            o();
            a aVar = this.d;
            Object objP = aVar != null ? aVar.p(i) : this.e.v(i);
            this.c--;
            return objP;
        }

        public final void q(int i, int i2) {
            if (i2 > 0) {
                o();
            }
            a aVar = this.d;
            if (aVar != null) {
                aVar.q(i, i2);
            } else {
                this.e.w(i, i2);
            }
            this.c -= i2;
        }

        public final int r(int i, int i2, Collection collection, boolean z) {
            a aVar = this.d;
            int iR = aVar != null ? aVar.r(i, i2, collection, z) : this.e.x(i, i2, collection, z);
            if (iR > 0) {
                o();
            }
            this.c -= iR;
            return iR;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean remove(Object obj) {
            l();
            k();
            int iIndexOf = indexOf(obj);
            if (iIndexOf >= 0) {
                remove(iIndexOf);
            }
            return iIndexOf >= 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean removeAll(Collection collection) {
            AbstractC4492zt.h(collection, "elements");
            l();
            k();
            return r(this.b, this.c, collection, false) > 0;
        }

        @Override // defpackage.AbstractC1755b0
        public Object removeAt(int i) {
            l();
            k();
            V.Companion.b(i, this.c);
            return p(this.b + i);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean retainAll(Collection collection) {
            AbstractC4492zt.h(collection, "elements");
            l();
            k();
            return r(this.b, this.c, collection, true) > 0;
        }

        @Override // java.util.AbstractList, java.util.List
        public Object set(int i, Object obj) {
            l();
            k();
            V.Companion.b(i, this.c);
            Object[] objArr = this.a;
            int i2 = this.b;
            Object obj2 = objArr[i2 + i];
            objArr[i2 + i] = obj;
            return obj2;
        }

        @Override // java.util.AbstractList, java.util.List
        public List subList(int i, int i2) {
            V.Companion.d(i, i2, this.c);
            return new a(this.a, this.b + i, i2 - i, this, this.e);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public Object[] toArray(Object[] objArr) {
            AbstractC4492zt.h(objArr, "array");
            k();
            int length = objArr.length;
            int i = this.c;
            if (length >= i) {
                Object[] objArr2 = this.a;
                int i2 = this.b;
                Q5.i(objArr2, objArr, 0, i2, i + i2);
                return AbstractC1805bc.f(this.c, objArr);
            }
            Object[] objArr3 = this.a;
            int i3 = this.b;
            Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr3, i3, i + i3, objArr.getClass());
            AbstractC4492zt.g(objArrCopyOfRange, "copyOfRange(...)");
            return objArrCopyOfRange;
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            k();
            return AbstractC0636Jv.j(this.a, this.b, this.c, this);
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator listIterator(int i) {
            k();
            V.Companion.c(i, this.c);
            return new C0010a(this, i);
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int i, Object obj) {
            l();
            k();
            V.Companion.c(i, this.c);
            j(this.b + i, obj);
        }

        @Override // java.util.AbstractList, java.util.List
        public boolean addAll(int i, Collection collection) {
            AbstractC4492zt.h(collection, "elements");
            l();
            k();
            V.Companion.c(i, this.c);
            int size = collection.size();
            h(this.b + i, collection, size);
            return size > 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public Object[] toArray() {
            k();
            Object[] objArr = this.a;
            int i = this.b;
            return Q5.o(objArr, i, this.c + i);
        }
    }

    /* JADX INFO: renamed from: Iv$b */
    public static final class b {
        public /* synthetic */ b(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public b() {
        }
    }

    /* JADX INFO: renamed from: Iv$c */
    public static final class c implements ListIterator, InterfaceC0756Mu {
        public final C0610Iv a;
        public int b;
        public int c;
        public int d;

        public c(C0610Iv c0610Iv, int i) {
            AbstractC4492zt.h(c0610Iv, "list");
            this.a = c0610Iv;
            this.b = i;
            this.c = -1;
            this.d = ((AbstractList) c0610Iv).modCount;
        }

        private final void a() {
            if (((AbstractList) this.a).modCount != this.d) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.ListIterator
        public void add(Object obj) {
            a();
            C0610Iv c0610Iv = this.a;
            int i = this.b;
            this.b = i + 1;
            c0610Iv.add(i, obj);
            this.c = -1;
            this.d = ((AbstractList) this.a).modCount;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.b < this.a.b;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.b > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public Object next() {
            a();
            if (this.b >= this.a.b) {
                throw new NoSuchElementException();
            }
            int i = this.b;
            this.b = i + 1;
            this.c = i;
            return this.a.a[this.c];
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.b;
        }

        @Override // java.util.ListIterator
        public Object previous() {
            a();
            int i = this.b;
            if (i <= 0) {
                throw new NoSuchElementException();
            }
            int i2 = i - 1;
            this.b = i2;
            this.c = i2;
            return this.a.a[this.c];
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            a();
            int i = this.c;
            if (i == -1) {
                throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
            }
            this.a.remove(i);
            this.b = this.c;
            this.c = -1;
            this.d = ((AbstractList) this.a).modCount;
        }

        @Override // java.util.ListIterator
        public void set(Object obj) {
            a();
            int i = this.c;
            if (i == -1) {
                throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
            }
            this.a.set(i, obj);
        }
    }

    static {
        C0610Iv c0610Iv = new C0610Iv(0);
        c0610Iv.c = true;
        e = c0610Iv;
    }

    public C0610Iv(int i) {
        this.a = AbstractC0636Jv.d(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(int i, Collection collection, int i2) {
        u();
        t(i, i2);
        Iterator it = collection.iterator();
        for (int i3 = 0; i3 < i2; i3++) {
            this.a[i + i3] = it.next();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(int i, Object obj) {
        u();
        t(i, 1);
        this.a[i] = obj;
    }

    private final void p() {
        if (this.c) {
            throw new UnsupportedOperationException();
        }
    }

    private final boolean q(List list) {
        return AbstractC0636Jv.h(this.a, 0, this.b, list);
    }

    private final void u() {
        ((AbstractList) this).modCount++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object v(int i) {
        u();
        Object[] objArr = this.a;
        Object obj = objArr[i];
        Q5.i(objArr, objArr, i, i + 1, this.b);
        AbstractC0636Jv.f(this.a, this.b - 1);
        this.b--;
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(int i, int i2) {
        if (i2 > 0) {
            u();
        }
        Object[] objArr = this.a;
        Q5.i(objArr, objArr, i, i + i2, this.b);
        Object[] objArr2 = this.a;
        int i3 = this.b;
        AbstractC0636Jv.g(objArr2, i3 - i2, i3);
        this.b -= i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int x(int i, int i2, Collection collection, boolean z) {
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            int i5 = i + i3;
            if (collection.contains(this.a[i5]) == z) {
                Object[] objArr = this.a;
                i3++;
                objArr[i4 + i] = objArr[i5];
                i4++;
            } else {
                i3++;
            }
        }
        int i6 = i2 - i4;
        Object[] objArr2 = this.a;
        Q5.i(objArr2, objArr2, i + i4, i2 + i, this.b);
        Object[] objArr3 = this.a;
        int i7 = this.b;
        AbstractC0636Jv.g(objArr3, i7 - i6, i7);
        if (i6 > 0) {
            u();
        }
        this.b -= i6;
        return i6;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        p();
        n(this.b, obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        AbstractC4492zt.h(collection, "elements");
        p();
        int size = collection.size();
        m(this.b, collection, size);
        return size > 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        p();
        w(0, this.b);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof List) && q((List) obj));
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i) {
        V.Companion.b(i, this.b);
        return this.a[i];
    }

    @Override // defpackage.AbstractC1755b0
    public int getSize() {
        return this.b;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        return AbstractC0636Jv.i(this.a, 0, this.b);
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        for (int i = 0; i < this.b; i++) {
            if (AbstractC4492zt.d(this.a[i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return this.b == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        for (int i = this.b - 1; i >= 0; i--) {
            if (AbstractC4492zt.d(this.a[i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator listIterator() {
        return listIterator(0);
    }

    public final List o() {
        p();
        this.c = true;
        return this.b > 0 ? this : e;
    }

    public final void r(int i) {
        if (i < 0) {
            throw new OutOfMemoryError();
        }
        Object[] objArr = this.a;
        if (i > objArr.length) {
            this.a = AbstractC0636Jv.e(this.a, V.Companion.e(objArr.length, i));
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        p();
        int iIndexOf = indexOf(obj);
        if (iIndexOf >= 0) {
            remove(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection collection) {
        AbstractC4492zt.h(collection, "elements");
        p();
        return x(0, this.b, collection, false) > 0;
    }

    @Override // defpackage.AbstractC1755b0
    public Object removeAt(int i) {
        p();
        V.Companion.b(i, this.b);
        return v(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection collection) {
        AbstractC4492zt.h(collection, "elements");
        p();
        return x(0, this.b, collection, true) > 0;
    }

    public final void s(int i) {
        r(this.b + i);
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i, Object obj) {
        p();
        V.Companion.b(i, this.b);
        Object[] objArr = this.a;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public List subList(int i, int i2) {
        V.Companion.d(i, i2, this.b);
        return new a(this.a, i, i2 - i, null, this);
    }

    public final void t(int i, int i2) {
        s(i2);
        Object[] objArr = this.a;
        Q5.i(objArr, objArr, i + i2, i, this.b);
        this.b += i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray(Object[] objArr) {
        AbstractC4492zt.h(objArr, "array");
        int length = objArr.length;
        int i = this.b;
        if (length >= i) {
            Q5.i(this.a, objArr, 0, 0, i);
            return AbstractC1805bc.f(this.b, objArr);
        }
        Object[] objArrCopyOfRange = Arrays.copyOfRange(this.a, 0, i, objArr.getClass());
        AbstractC4492zt.g(objArrCopyOfRange, "copyOfRange(...)");
        return objArrCopyOfRange;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return AbstractC0636Jv.j(this.a, 0, this.b, this);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator listIterator(int i) {
        V.Companion.c(i, this.b);
        return new c(this, i);
    }

    public /* synthetic */ C0610Iv(int i, int i2, AbstractC0419Di abstractC0419Di) {
        this((i2 & 1) != 0 ? 10 : i);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, Object obj) {
        p();
        V.Companion.c(i, this.b);
        n(i, obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection collection) {
        AbstractC4492zt.h(collection, "elements");
        p();
        V.Companion.c(i, this.b);
        int size = collection.size();
        m(i, collection, size);
        return size > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return Q5.o(this.a, 0, this.b);
    }
}
