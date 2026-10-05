package defpackage;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
public final class Y4 extends AbstractC1755b0 {
    public static final a d = new a(null);
    public static final Object[] e = new Object[0];
    public int a;
    public Object[] b;
    public int c;

    public static final class a {
        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public a() {
        }
    }

    public Y4(int i) {
        Object[] objArr;
        if (i == 0) {
            objArr = e;
        } else {
            if (i <= 0) {
                throw new IllegalArgumentException("Illegal Capacity: " + i);
            }
            objArr = new Object[i];
        }
        this.b = objArr;
    }

    private final void e(int i) {
        if (i < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.b;
        if (i <= objArr.length) {
            return;
        }
        if (objArr == e) {
            this.b = new Object[AbstractC3871sJ.d(i, 10)];
        } else {
            b(V.Companion.e(objArr.length, i));
        }
    }

    public final void a(int i, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.b.length;
        while (i < length && it.hasNext()) {
            this.b[i] = it.next();
            i++;
        }
        int i2 = this.a;
        for (int i3 = 0; i3 < i2 && it.hasNext(); i3++) {
            this.b[i3] = it.next();
        }
        this.c = size() + collection.size();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        AbstractC4492zt.h(collection, "elements");
        if (collection.isEmpty()) {
            return false;
        }
        n();
        e(size() + collection.size());
        a(m(this.a + size()), collection);
        return true;
    }

    public final void addFirst(Object obj) {
        n();
        e(size() + 1);
        int iC = c(this.a);
        this.a = iC;
        this.b[iC] = obj;
        this.c = size() + 1;
    }

    public final void addLast(Object obj) {
        n();
        e(size() + 1);
        this.b[m(this.a + size())] = obj;
        this.c = size() + 1;
    }

    public final void b(int i) {
        Object[] objArr = new Object[i];
        Object[] objArr2 = this.b;
        Q5.i(objArr2, objArr, 0, this.a, objArr2.length);
        Object[] objArr3 = this.b;
        int length = objArr3.length;
        int i2 = this.a;
        Q5.i(objArr3, objArr, length - i2, 0, i2);
        this.a = 0;
        this.b = objArr;
    }

    public final int c(int i) {
        return i == 0 ? R5.O(this.b) : i - 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        if (!isEmpty()) {
            n();
            l(this.a, m(this.a + size()));
        }
        this.a = 0;
        this.c = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final Object f() {
        if (isEmpty()) {
            return null;
        }
        return this.b[this.a];
    }

    public final Object first() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return this.b[this.a];
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i) {
        V.Companion.b(i, size());
        return this.b[m(this.a + i)];
    }

    @Override // defpackage.AbstractC1755b0
    public int getSize() {
        return this.c;
    }

    public final int h(int i) {
        if (i == R5.O(this.b)) {
            return 0;
        }
        return i + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        int i;
        int iM = m(this.a + size());
        int length = this.a;
        if (length < iM) {
            while (length < iM) {
                if (AbstractC4492zt.d(obj, this.b[length])) {
                    i = this.a;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < iM) {
            return -1;
        }
        int length2 = this.b.length;
        while (length < length2) {
            if (AbstractC4492zt.d(obj, this.b[length])) {
                i = this.a;
            } else {
                length++;
            }
        }
        for (int i2 = 0; i2 < iM; i2++) {
            if (AbstractC4492zt.d(obj, this.b[i2])) {
                length = i2 + this.b.length;
                i = this.a;
            }
        }
        return -1;
        return length - i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    public final Object j() {
        if (isEmpty()) {
            return null;
        }
        return this.b[m(this.a + AbstractC1886cc.o(this))];
    }

    public final int k(int i) {
        return i < 0 ? i + this.b.length : i;
    }

    public final void l(int i, int i2) {
        if (i < i2) {
            Q5.r(this.b, null, i, i2);
            return;
        }
        Object[] objArr = this.b;
        Q5.r(objArr, null, i, objArr.length);
        Q5.r(this.b, null, 0, i2);
    }

    public final Object last() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return this.b[m(this.a + AbstractC1886cc.o(this))];
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        int iO;
        int i;
        int iM = m(this.a + size());
        int i2 = this.a;
        if (i2 < iM) {
            iO = iM - 1;
            if (i2 <= iO) {
                while (!AbstractC4492zt.d(obj, this.b[iO])) {
                    if (iO != i2) {
                        iO--;
                    }
                }
                i = this.a;
                return iO - i;
            }
            return -1;
        }
        if (i2 > iM) {
            for (int i3 = iM - 1; -1 < i3; i3--) {
                if (AbstractC4492zt.d(obj, this.b[i3])) {
                    iO = i3 + this.b.length;
                    i = this.a;
                    return iO - i;
                }
            }
            iO = R5.O(this.b);
            int i4 = this.a;
            if (i4 <= iO) {
                while (!AbstractC4492zt.d(obj, this.b[iO])) {
                    if (iO != i4) {
                        iO--;
                    }
                }
                i = this.a;
                return iO - i;
            }
        }
        return -1;
    }

    public final int m(int i) {
        Object[] objArr = this.b;
        return i >= objArr.length ? i - objArr.length : i;
    }

    public final void n() {
        ((AbstractList) this).modCount++;
    }

    public final Object o() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    public final void p(int i, int i2) {
        int iM = m(this.a + (i - 1));
        int iM2 = m(this.a + (i2 - 1));
        while (i > 0) {
            int i3 = iM + 1;
            int iMin = Math.min(i, Math.min(i3, iM2 + 1));
            Object[] objArr = this.b;
            int i4 = iM2 - iMin;
            int i5 = iM - iMin;
            Q5.i(objArr, objArr, i4 + 1, i5 + 1, i3);
            iM = k(i5);
            iM2 = k(i4);
            i -= iMin;
        }
    }

    public final void q(int i, int i2) {
        int iM = m(this.a + i2);
        int iM2 = m(this.a + i);
        int size = size();
        while (true) {
            size -= i2;
            if (size <= 0) {
                return;
            }
            Object[] objArr = this.b;
            i2 = Math.min(size, Math.min(objArr.length - iM, objArr.length - iM2));
            Object[] objArr2 = this.b;
            int i3 = iM + i2;
            Q5.i(objArr2, objArr2, iM2, iM, i3);
            iM = m(i3);
            iM2 = m(iM2 + i2);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        remove(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection collection) {
        int iM;
        AbstractC4492zt.h(collection, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.b.length != 0) {
            int iM2 = m(this.a + size());
            int i = this.a;
            if (i < iM2) {
                iM = i;
                while (i < iM2) {
                    Object obj = this.b[i];
                    if (collection.contains(obj)) {
                        z = true;
                    } else {
                        this.b[iM] = obj;
                        iM++;
                    }
                    i++;
                }
                Q5.r(this.b, null, iM, iM2);
            } else {
                int length = this.b.length;
                int i2 = i;
                boolean z2 = false;
                while (i < length) {
                    Object[] objArr = this.b;
                    Object obj2 = objArr[i];
                    objArr[i] = null;
                    if (collection.contains(obj2)) {
                        z2 = true;
                    } else {
                        this.b[i2] = obj2;
                        i2++;
                    }
                    i++;
                }
                iM = m(i2);
                for (int i3 = 0; i3 < iM2; i3++) {
                    Object[] objArr2 = this.b;
                    Object obj3 = objArr2[i3];
                    objArr2[i3] = null;
                    if (collection.contains(obj3)) {
                        z2 = true;
                    } else {
                        this.b[iM] = obj3;
                        iM = h(iM);
                    }
                }
                z = z2;
            }
            if (z) {
                n();
                this.c = k(iM - this.a);
            }
        }
        return z;
    }

    @Override // defpackage.AbstractC1755b0
    public Object removeAt(int i) {
        V.Companion.b(i, size());
        if (i == AbstractC1886cc.o(this)) {
            return removeLast();
        }
        if (i == 0) {
            return removeFirst();
        }
        n();
        int iM = m(this.a + i);
        Object obj = this.b[iM];
        if (i < (size() >> 1)) {
            int i2 = this.a;
            if (iM >= i2) {
                Object[] objArr = this.b;
                Q5.i(objArr, objArr, i2 + 1, i2, iM);
            } else {
                Object[] objArr2 = this.b;
                Q5.i(objArr2, objArr2, 1, 0, iM);
                Object[] objArr3 = this.b;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i3 = this.a;
                Q5.i(objArr3, objArr3, i3 + 1, i3, objArr3.length - 1);
            }
            Object[] objArr4 = this.b;
            int i4 = this.a;
            objArr4[i4] = null;
            this.a = h(i4);
        } else {
            int iM2 = m(this.a + AbstractC1886cc.o(this));
            if (iM <= iM2) {
                Object[] objArr5 = this.b;
                Q5.i(objArr5, objArr5, iM, iM + 1, iM2 + 1);
            } else {
                Object[] objArr6 = this.b;
                Q5.i(objArr6, objArr6, iM, iM + 1, objArr6.length);
                Object[] objArr7 = this.b;
                objArr7[objArr7.length - 1] = objArr7[0];
                Q5.i(objArr7, objArr7, 0, 1, iM2 + 1);
            }
            this.b[iM2] = null;
        }
        this.c = size() - 1;
        return obj;
    }

    public final Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        n();
        Object[] objArr = this.b;
        int i = this.a;
        Object obj = objArr[i];
        objArr[i] = null;
        this.a = h(i);
        this.c = size() - 1;
        return obj;
    }

    public final Object removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        n();
        int iM = m(this.a + AbstractC1886cc.o(this));
        Object[] objArr = this.b;
        Object obj = objArr[iM];
        objArr[iM] = null;
        this.c = size() - 1;
        return obj;
    }

    @Override // java.util.AbstractList
    public void removeRange(int i, int i2) {
        V.Companion.d(i, i2, size());
        int i3 = i2 - i;
        if (i3 == 0) {
            return;
        }
        if (i3 == size()) {
            clear();
            return;
        }
        if (i3 == 1) {
            remove(i);
            return;
        }
        n();
        if (i < size() - i2) {
            p(i, i2);
            int iM = m(this.a + i3);
            l(this.a, iM);
            this.a = iM;
        } else {
            q(i, i2);
            int iM2 = m(this.a + size());
            l(k(iM2 - i3), iM2);
        }
        this.c = size() - i3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection collection) {
        int iM;
        AbstractC4492zt.h(collection, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.b.length != 0) {
            int iM2 = m(this.a + size());
            int i = this.a;
            if (i < iM2) {
                iM = i;
                while (i < iM2) {
                    Object obj = this.b[i];
                    if (collection.contains(obj)) {
                        this.b[iM] = obj;
                        iM++;
                    } else {
                        z = true;
                    }
                    i++;
                }
                Q5.r(this.b, null, iM, iM2);
            } else {
                int length = this.b.length;
                int i2 = i;
                boolean z2 = false;
                while (i < length) {
                    Object[] objArr = this.b;
                    Object obj2 = objArr[i];
                    objArr[i] = null;
                    if (collection.contains(obj2)) {
                        this.b[i2] = obj2;
                        i2++;
                    } else {
                        z2 = true;
                    }
                    i++;
                }
                iM = m(i2);
                for (int i3 = 0; i3 < iM2; i3++) {
                    Object[] objArr2 = this.b;
                    Object obj3 = objArr2[i3];
                    objArr2[i3] = null;
                    if (collection.contains(obj3)) {
                        this.b[iM] = obj3;
                        iM = h(iM);
                    } else {
                        z2 = true;
                    }
                }
                z = z2;
            }
            if (z) {
                n();
                this.c = k(iM - this.a);
            }
        }
        return z;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i, Object obj) {
        V.Companion.b(i, size());
        int iM = m(this.a + i);
        Object[] objArr = this.b;
        Object obj2 = objArr[iM];
        objArr[iM] = obj;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray(Object[] objArr) {
        AbstractC4492zt.h(objArr, "array");
        if (objArr.length < size()) {
            objArr = O5.a(objArr, size());
        }
        int iM = m(this.a + size());
        int i = this.a;
        if (i < iM) {
            Q5.m(this.b, objArr, 0, i, iM, 2, null);
        } else if (!isEmpty()) {
            Object[] objArr2 = this.b;
            Q5.i(objArr2, objArr, 0, this.a, objArr2.length);
            Object[] objArr3 = this.b;
            Q5.i(objArr3, objArr, objArr3.length - this.a, 0, iM);
        }
        return AbstractC1805bc.f(size(), objArr);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, Object obj) {
        V.Companion.c(i, size());
        if (i == size()) {
            addLast(obj);
            return;
        }
        if (i == 0) {
            addFirst(obj);
            return;
        }
        n();
        e(size() + 1);
        int iM = m(this.a + i);
        if (i < ((size() + 1) >> 1)) {
            int iC = c(iM);
            int iC2 = c(this.a);
            int i2 = this.a;
            if (iC >= i2) {
                Object[] objArr = this.b;
                objArr[iC2] = objArr[i2];
                Q5.i(objArr, objArr, i2, i2 + 1, iC + 1);
            } else {
                Object[] objArr2 = this.b;
                Q5.i(objArr2, objArr2, i2 - 1, i2, objArr2.length);
                Object[] objArr3 = this.b;
                objArr3[objArr3.length - 1] = objArr3[0];
                Q5.i(objArr3, objArr3, 0, 1, iC + 1);
            }
            this.b[iC] = obj;
            this.a = iC2;
        } else {
            int iM2 = m(this.a + size());
            if (iM < iM2) {
                Object[] objArr4 = this.b;
                Q5.i(objArr4, objArr4, iM + 1, iM, iM2);
            } else {
                Object[] objArr5 = this.b;
                Q5.i(objArr5, objArr5, 1, 0, iM2);
                Object[] objArr6 = this.b;
                objArr6[0] = objArr6[objArr6.length - 1];
                Q5.i(objArr6, objArr6, iM + 1, iM, objArr6.length - 1);
            }
            this.b[iM] = obj;
        }
        this.c = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection collection) {
        AbstractC4492zt.h(collection, "elements");
        V.Companion.c(i, size());
        if (collection.isEmpty()) {
            return false;
        }
        if (i == size()) {
            return addAll(collection);
        }
        n();
        e(size() + collection.size());
        int iM = m(this.a + size());
        int iM2 = m(this.a + i);
        int size = collection.size();
        if (i < ((size() + 1) >> 1)) {
            int i2 = this.a;
            int length = i2 - size;
            if (iM2 < i2) {
                Object[] objArr = this.b;
                Q5.i(objArr, objArr, length, i2, objArr.length);
                if (size >= iM2) {
                    Object[] objArr2 = this.b;
                    Q5.i(objArr2, objArr2, objArr2.length - size, 0, iM2);
                } else {
                    Object[] objArr3 = this.b;
                    Q5.i(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.b;
                    Q5.i(objArr4, objArr4, 0, size, iM2);
                }
            } else if (length >= 0) {
                Object[] objArr5 = this.b;
                Q5.i(objArr5, objArr5, length, i2, iM2);
            } else {
                Object[] objArr6 = this.b;
                length += objArr6.length;
                int i3 = iM2 - i2;
                int length2 = objArr6.length - length;
                if (length2 >= i3) {
                    Q5.i(objArr6, objArr6, length, i2, iM2);
                } else {
                    Q5.i(objArr6, objArr6, length, i2, i2 + length2);
                    Object[] objArr7 = this.b;
                    Q5.i(objArr7, objArr7, 0, this.a + length2, iM2);
                }
            }
            this.a = length;
            a(k(iM2 - size), collection);
        } else {
            int i4 = iM2 + size;
            if (iM2 < iM) {
                int i5 = size + iM;
                Object[] objArr8 = this.b;
                if (i5 <= objArr8.length) {
                    Q5.i(objArr8, objArr8, i4, iM2, iM);
                } else if (i4 >= objArr8.length) {
                    Q5.i(objArr8, objArr8, i4 - objArr8.length, iM2, iM);
                } else {
                    int length3 = iM - (i5 - objArr8.length);
                    Q5.i(objArr8, objArr8, 0, length3, iM);
                    Object[] objArr9 = this.b;
                    Q5.i(objArr9, objArr9, i4, iM2, length3);
                }
            } else {
                Object[] objArr10 = this.b;
                Q5.i(objArr10, objArr10, size, 0, iM);
                Object[] objArr11 = this.b;
                if (i4 >= objArr11.length) {
                    Q5.i(objArr11, objArr11, i4 - objArr11.length, iM2, objArr11.length);
                } else {
                    Q5.i(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.b;
                    Q5.i(objArr12, objArr12, i4, iM2, objArr12.length - size);
                }
            }
            a(iM2, collection);
        }
        return true;
    }

    public Y4() {
        this.b = e;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
