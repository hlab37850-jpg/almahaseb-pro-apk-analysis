package defpackage;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ObjectArrays;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: renamed from: Nd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0765Nd extends AbstractSet implements Serializable {
    public transient Object a;
    public transient int[] b;
    public transient Object[] c;
    public transient int d;
    public transient int e;

    /* JADX INFO: renamed from: Nd$a */
    public class a implements Iterator {
        public int a;
        public int b;
        public int c = -1;

        public a() {
            this.a = C0765Nd.this.d;
            this.b = C0765Nd.this.n();
        }

        public final void a() {
            if (C0765Nd.this.d != this.a) {
                throw new ConcurrentModificationException();
            }
        }

        public void b() {
            this.a += 32;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b >= 0;
        }

        @Override // java.util.Iterator
        public Object next() {
            a();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i = this.b;
            this.c = i;
            Object objL = C0765Nd.this.l(i);
            this.b = C0765Nd.this.o(this.b);
            return objL;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            AbstractC1163Zb.e(this.c >= 0);
            b();
            C0765Nd c0765Nd = C0765Nd.this;
            c0765Nd.remove(c0765Nd.l(this.c));
            this.b = C0765Nd.this.c(this.b, this.c);
            this.c = -1;
        }
    }

    public C0765Nd() {
        r(3);
    }

    public static C0765Nd h() {
        return new C0765Nd();
    }

    public static C0765Nd j(int i) {
        return new C0765Nd(i);
    }

    public final int A(int i, int i2, int i3, int i4) {
        Object objA = AbstractC0791Od.a(i2);
        int i5 = i2 - 1;
        if (i4 != 0) {
            AbstractC0791Od.i(objA, i3 & i5, i4 + 1);
        }
        Object objX = x();
        int[] iArrW = w();
        for (int i6 = 0; i6 <= i; i6++) {
            int iH = AbstractC0791Od.h(objX, i6);
            while (iH != 0) {
                int i7 = iH - 1;
                int i8 = iArrW[i7];
                int iB = AbstractC0791Od.b(i8, i) | i6;
                int i9 = iB & i5;
                int iH2 = AbstractC0791Od.h(objA, i9);
                AbstractC0791Od.i(objA, i9, iH);
                iArrW[i7] = AbstractC0791Od.d(iB, iH2, i5);
                iH = AbstractC0791Od.c(i8, i);
            }
        }
        this.a = objA;
        D(i5);
        return i5;
    }

    public final void B(int i, Object obj) {
        v()[i] = obj;
    }

    public final void C(int i, int i2) {
        w()[i] = i2;
    }

    public final void D(int i) {
        this.d = AbstractC0791Od.d(this.d, 32 - Integer.numberOfLeadingZeros(i), 31);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        if (u()) {
            e();
        }
        Set setK = k();
        if (setK != null) {
            return setK.add(obj);
        }
        int[] iArrW = w();
        Object[] objArrV = v();
        int i = this.e;
        int i2 = i + 1;
        int iD = AbstractC3590or.d(obj);
        int iP = p();
        int i3 = iD & iP;
        int iH = AbstractC0791Od.h(x(), i3);
        if (iH != 0) {
            int iB = AbstractC0791Od.b(iD, iP);
            int i4 = 0;
            while (true) {
                int i5 = iH - 1;
                int i6 = iArrW[i5];
                if (AbstractC0791Od.b(i6, iP) == iB && Objects.equal(obj, objArrV[i5])) {
                    return false;
                }
                int iC = AbstractC0791Od.c(i6, iP);
                i4++;
                if (iC != 0) {
                    iH = iC;
                } else {
                    if (i4 >= 9) {
                        return f().add(obj);
                    }
                    if (i2 > iP) {
                        iP = A(iP, AbstractC0791Od.e(iP), iD, i);
                    } else {
                        iArrW[i5] = AbstractC0791Od.d(i6, i2, iP);
                    }
                }
            }
        } else if (i2 > iP) {
            iP = A(iP, AbstractC0791Od.e(iP), iD, i);
        } else {
            AbstractC0791Od.i(x(), i3, i2);
        }
        z(i2);
        s(i, obj, iD, iP);
        this.e = i2;
        q();
        return true;
    }

    public int c(int i, int i2) {
        return i - 1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (u()) {
            return;
        }
        q();
        Set setK = k();
        if (setK != null) {
            this.d = Ints.constrainToRange(size(), 3, 1073741823);
            setK.clear();
            this.a = null;
            this.e = 0;
            return;
        }
        Arrays.fill(v(), 0, this.e, (Object) null);
        AbstractC0791Od.g(x());
        Arrays.fill(w(), 0, this.e, 0);
        this.e = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (u()) {
            return false;
        }
        Set setK = k();
        if (setK != null) {
            return setK.contains(obj);
        }
        int iD = AbstractC3590or.d(obj);
        int iP = p();
        int iH = AbstractC0791Od.h(x(), iD & iP);
        if (iH == 0) {
            return false;
        }
        int iB = AbstractC0791Od.b(iD, iP);
        do {
            int i = iH - 1;
            int iM = m(i);
            if (AbstractC0791Od.b(iM, iP) == iB && Objects.equal(obj, l(i))) {
                return true;
            }
            iH = AbstractC0791Od.c(iM, iP);
        } while (iH != 0);
        return false;
    }

    public int e() {
        Preconditions.checkState(u(), "Arrays already allocated");
        int i = this.d;
        int iJ = AbstractC0791Od.j(i);
        this.a = AbstractC0791Od.a(iJ);
        D(iJ - 1);
        this.b = new int[i];
        this.c = new Object[i];
        return i;
    }

    public Set f() {
        Set setI = i(p() + 1);
        int iN = n();
        while (iN >= 0) {
            setI.add(l(iN));
            iN = o(iN);
        }
        this.a = setI;
        this.b = null;
        this.c = null;
        q();
        return setI;
    }

    public final Set i(int i) {
        return new LinkedHashSet(i, 1.0f);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        Set setK = k();
        return setK != null ? setK.iterator() : new a();
    }

    public Set k() {
        Object obj = this.a;
        if (obj instanceof Set) {
            return (Set) obj;
        }
        return null;
    }

    public final Object l(int i) {
        return v()[i];
    }

    public final int m(int i) {
        return w()[i];
    }

    public int n() {
        return isEmpty() ? -1 : 0;
    }

    public int o(int i) {
        int i2 = i + 1;
        if (i2 < this.e) {
            return i2;
        }
        return -1;
    }

    public final int p() {
        return (1 << (this.d & 31)) - 1;
    }

    public void q() {
        this.d += 32;
    }

    public void r(int i) {
        Preconditions.checkArgument(i >= 0, "Expected size must be >= 0");
        this.d = Ints.constrainToRange(i, 1, 1073741823);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        if (u()) {
            return false;
        }
        Set setK = k();
        if (setK != null) {
            return setK.remove(obj);
        }
        int iP = p();
        int iF = AbstractC0791Od.f(obj, null, iP, x(), w(), v(), null);
        if (iF == -1) {
            return false;
        }
        t(iF, iP);
        this.e--;
        q();
        return true;
    }

    public void s(int i, Object obj, int i2, int i3) {
        C(i, AbstractC0791Od.d(i2, 0, i3));
        B(i, obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        Set setK = k();
        return setK != null ? setK.size() : this.e;
    }

    public void t(int i, int i2) {
        Object objX = x();
        int[] iArrW = w();
        Object[] objArrV = v();
        int size = size();
        int i3 = size - 1;
        if (i >= i3) {
            objArrV[i] = null;
            iArrW[i] = 0;
            return;
        }
        Object obj = objArrV[i3];
        objArrV[i] = obj;
        objArrV[i3] = null;
        iArrW[i] = iArrW[i3];
        iArrW[i3] = 0;
        int iD = AbstractC3590or.d(obj) & i2;
        int iH = AbstractC0791Od.h(objX, iD);
        if (iH == size) {
            AbstractC0791Od.i(objX, iD, i + 1);
            return;
        }
        while (true) {
            int i4 = iH - 1;
            int i5 = iArrW[i4];
            int iC = AbstractC0791Od.c(i5, i2);
            if (iC == size) {
                iArrW[i4] = AbstractC0791Od.d(i5, i + 1, i2);
                return;
            }
            iH = iC;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        if (u()) {
            return new Object[0];
        }
        Set setK = k();
        return setK != null ? setK.toArray() : Arrays.copyOf(v(), this.e);
    }

    public boolean u() {
        return this.a == null;
    }

    public final Object[] v() {
        Object[] objArr = this.c;
        java.util.Objects.requireNonNull(objArr);
        return objArr;
    }

    public final int[] w() {
        int[] iArr = this.b;
        java.util.Objects.requireNonNull(iArr);
        return iArr;
    }

    public final Object x() {
        Object obj = this.a;
        java.util.Objects.requireNonNull(obj);
        return obj;
    }

    public void y(int i) {
        this.b = Arrays.copyOf(w(), i);
        this.c = Arrays.copyOf(v(), i);
    }

    public final void z(int i) {
        int iMin;
        int length = w().length;
        if (i <= length || (iMin = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) == length) {
            return;
        }
        y(iMin);
    }

    public C0765Nd(int i) {
        r(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray(Object[] objArr) {
        if (u()) {
            if (objArr.length > 0) {
                objArr[0] = null;
            }
            return objArr;
        }
        Set setK = k();
        if (setK != null) {
            return setK.toArray(objArr);
        }
        return ObjectArrays.toArrayImpl(v(), 0, this.e, objArr);
    }
}
