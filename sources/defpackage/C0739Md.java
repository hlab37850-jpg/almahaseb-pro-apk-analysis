package defpackage;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: renamed from: Md, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0739Md extends AbstractMap implements Serializable {
    public static final Object j = new Object();
    public transient Object a;
    public transient int[] b;
    public transient Object[] c;
    public transient Object[] d;
    public transient int e;
    public transient int f;
    public transient Set g;
    public transient Set h;
    public transient Collection i;

    /* JADX INFO: renamed from: Md$a */
    public class a extends e {
        public a() {
            super(C0739Md.this, null);
        }

        @Override // defpackage.C0739Md.e
        public Object b(int i) {
            return C0739Md.this.K(i);
        }
    }

    /* JADX INFO: renamed from: Md$b */
    public class b extends e {
        public b() {
            super(C0739Md.this, null);
        }

        @Override // defpackage.C0739Md.e
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map.Entry b(int i) {
            return C0739Md.this.new g(i);
        }
    }

    /* JADX INFO: renamed from: Md$c */
    public class c extends e {
        public c() {
            super(C0739Md.this, null);
        }

        @Override // defpackage.C0739Md.e
        public Object b(int i) {
            return C0739Md.this.a0(i);
        }
    }

    /* JADX INFO: renamed from: Md$d */
    public class d extends AbstractSet {
        public d() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            C0739Md.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map mapA = C0739Md.this.A();
            if (mapA != null) {
                return mapA.entrySet().contains(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int iH = C0739Md.this.H(entry.getKey());
            return iH != -1 && Objects.equal(C0739Md.this.a0(iH), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return C0739Md.this.C();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map mapA = C0739Md.this.A();
            if (mapA != null) {
                return mapA.entrySet().remove(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (C0739Md.this.N()) {
                return false;
            }
            int iF = C0739Md.this.F();
            int iF2 = AbstractC0791Od.f(entry.getKey(), entry.getValue(), iF, C0739Md.this.R(), C0739Md.this.P(), C0739Md.this.Q(), C0739Md.this.S());
            if (iF2 == -1) {
                return false;
            }
            C0739Md.this.M(iF2, iF);
            C0739Md.f(C0739Md.this);
            C0739Md.this.G();
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return C0739Md.this.size();
        }
    }

    /* JADX INFO: renamed from: Md$f */
    public class f extends AbstractSet {
        public f() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            C0739Md.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return C0739Md.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return C0739Md.this.L();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map mapA = C0739Md.this.A();
            if (mapA != null) {
                return mapA.keySet().remove(obj);
            }
            return C0739Md.this.O(obj) != C0739Md.j;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return C0739Md.this.size();
        }
    }

    /* JADX INFO: renamed from: Md$g */
    public final class g extends Y {
        public final Object a;
        public int b;

        public g(int i) {
            this.a = C0739Md.this.K(i);
            this.b = i;
        }

        public final void f() {
            int i = this.b;
            if (i == -1 || i >= C0739Md.this.size() || !Objects.equal(this.a, C0739Md.this.K(this.b))) {
                this.b = C0739Md.this.H(this.a);
            }
        }

        @Override // defpackage.Y, java.util.Map.Entry
        public Object getKey() {
            return this.a;
        }

        @Override // defpackage.Y, java.util.Map.Entry
        public Object getValue() {
            Map mapA = C0739Md.this.A();
            if (mapA != null) {
                return WD.a(mapA.get(this.a));
            }
            f();
            int i = this.b;
            return i == -1 ? WD.b() : C0739Md.this.a0(i);
        }

        @Override // defpackage.Y, java.util.Map.Entry
        public Object setValue(Object obj) {
            Map mapA = C0739Md.this.A();
            if (mapA != null) {
                return WD.a(mapA.put(this.a, obj));
            }
            f();
            int i = this.b;
            if (i == -1) {
                C0739Md.this.put(this.a, obj);
                return WD.b();
            }
            Object objA0 = C0739Md.this.a0(i);
            C0739Md.this.Z(this.b, obj);
            return objA0;
        }
    }

    /* JADX INFO: renamed from: Md$h */
    public class h extends AbstractCollection {
        public h() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            C0739Md.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return C0739Md.this.b0();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return C0739Md.this.size();
        }
    }

    public C0739Md() {
        I(3);
    }

    public static /* synthetic */ int f(C0739Md c0739Md) {
        int i = c0739Md.f;
        c0739Md.f = i - 1;
        return i;
    }

    public static C0739Md u() {
        return new C0739Md();
    }

    public static C0739Md z(int i) {
        return new C0739Md(i);
    }

    public Map A() {
        Object obj = this.a;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    public final int B(int i) {
        return P()[i];
    }

    public Iterator C() {
        Map mapA = A();
        return mapA != null ? mapA.entrySet().iterator() : new b();
    }

    public int D() {
        return isEmpty() ? -1 : 0;
    }

    public int E(int i) {
        int i2 = i + 1;
        if (i2 < this.f) {
            return i2;
        }
        return -1;
    }

    public final int F() {
        return (1 << (this.e & 31)) - 1;
    }

    public void G() {
        this.e += 32;
    }

    public final int H(Object obj) {
        if (N()) {
            return -1;
        }
        int iD = AbstractC3590or.d(obj);
        int iF = F();
        int iH = AbstractC0791Od.h(R(), iD & iF);
        if (iH == 0) {
            return -1;
        }
        int iB = AbstractC0791Od.b(iD, iF);
        do {
            int i = iH - 1;
            int iB2 = B(i);
            if (AbstractC0791Od.b(iB2, iF) == iB && Objects.equal(obj, K(i))) {
                return i;
            }
            iH = AbstractC0791Od.c(iB2, iF);
        } while (iH != 0);
        return -1;
    }

    public void I(int i) {
        Preconditions.checkArgument(i >= 0, "Expected size must be >= 0");
        this.e = Ints.constrainToRange(i, 1, 1073741823);
    }

    public void J(int i, Object obj, Object obj2, int i2, int i3) {
        W(i, AbstractC0791Od.d(i2, 0, i3));
        Y(i, obj);
        Z(i, obj2);
    }

    public final Object K(int i) {
        return Q()[i];
    }

    public Iterator L() {
        Map mapA = A();
        return mapA != null ? mapA.keySet().iterator() : new a();
    }

    public void M(int i, int i2) {
        Object objR = R();
        int[] iArrP = P();
        Object[] objArrQ = Q();
        Object[] objArrS = S();
        int size = size();
        int i3 = size - 1;
        if (i >= i3) {
            objArrQ[i] = null;
            objArrS[i] = null;
            iArrP[i] = 0;
            return;
        }
        Object obj = objArrQ[i3];
        objArrQ[i] = obj;
        objArrS[i] = objArrS[i3];
        objArrQ[i3] = null;
        objArrS[i3] = null;
        iArrP[i] = iArrP[i3];
        iArrP[i3] = 0;
        int iD = AbstractC3590or.d(obj) & i2;
        int iH = AbstractC0791Od.h(objR, iD);
        if (iH == size) {
            AbstractC0791Od.i(objR, iD, i + 1);
            return;
        }
        while (true) {
            int i4 = iH - 1;
            int i5 = iArrP[i4];
            int iC = AbstractC0791Od.c(i5, i2);
            if (iC == size) {
                iArrP[i4] = AbstractC0791Od.d(i5, i + 1, i2);
                return;
            }
            iH = iC;
        }
    }

    public boolean N() {
        return this.a == null;
    }

    public final Object O(Object obj) {
        if (N()) {
            return j;
        }
        int iF = F();
        int iF2 = AbstractC0791Od.f(obj, null, iF, R(), P(), Q(), null);
        if (iF2 == -1) {
            return j;
        }
        Object objA0 = a0(iF2);
        M(iF2, iF);
        this.f--;
        G();
        return objA0;
    }

    public final int[] P() {
        int[] iArr = this.b;
        java.util.Objects.requireNonNull(iArr);
        return iArr;
    }

    public final Object[] Q() {
        Object[] objArr = this.c;
        java.util.Objects.requireNonNull(objArr);
        return objArr;
    }

    public final Object R() {
        Object obj = this.a;
        java.util.Objects.requireNonNull(obj);
        return obj;
    }

    public final Object[] S() {
        Object[] objArr = this.d;
        java.util.Objects.requireNonNull(objArr);
        return objArr;
    }

    public void T(int i) {
        this.b = Arrays.copyOf(P(), i);
        this.c = Arrays.copyOf(Q(), i);
        this.d = Arrays.copyOf(S(), i);
    }

    public final void U(int i) {
        int iMin;
        int length = P().length;
        if (i <= length || (iMin = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) == length) {
            return;
        }
        T(iMin);
    }

    public final int V(int i, int i2, int i3, int i4) {
        Object objA = AbstractC0791Od.a(i2);
        int i5 = i2 - 1;
        if (i4 != 0) {
            AbstractC0791Od.i(objA, i3 & i5, i4 + 1);
        }
        Object objR = R();
        int[] iArrP = P();
        for (int i6 = 0; i6 <= i; i6++) {
            int iH = AbstractC0791Od.h(objR, i6);
            while (iH != 0) {
                int i7 = iH - 1;
                int i8 = iArrP[i7];
                int iB = AbstractC0791Od.b(i8, i) | i6;
                int i9 = iB & i5;
                int iH2 = AbstractC0791Od.h(objA, i9);
                AbstractC0791Od.i(objA, i9, iH);
                iArrP[i7] = AbstractC0791Od.d(iB, iH2, i5);
                iH = AbstractC0791Od.c(i8, i);
            }
        }
        this.a = objA;
        X(i5);
        return i5;
    }

    public final void W(int i, int i2) {
        P()[i] = i2;
    }

    public final void X(int i) {
        this.e = AbstractC0791Od.d(this.e, 32 - Integer.numberOfLeadingZeros(i), 31);
    }

    public final void Y(int i, Object obj) {
        Q()[i] = obj;
    }

    public final void Z(int i, Object obj) {
        S()[i] = obj;
    }

    public final Object a0(int i) {
        return S()[i];
    }

    public Iterator b0() {
        Map mapA = A();
        return mapA != null ? mapA.values().iterator() : new c();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        if (N()) {
            return;
        }
        G();
        Map mapA = A();
        if (mapA != null) {
            this.e = Ints.constrainToRange(size(), 3, 1073741823);
            mapA.clear();
            this.a = null;
            this.f = 0;
            return;
        }
        Arrays.fill(Q(), 0, this.f, (Object) null);
        Arrays.fill(S(), 0, this.f, (Object) null);
        AbstractC0791Od.g(R());
        Arrays.fill(P(), 0, this.f, 0);
        this.f = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Map mapA = A();
        if (mapA != null) {
            return mapA.containsKey(obj);
        }
        return H(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        Map mapA = A();
        if (mapA != null) {
            return mapA.containsValue(obj);
        }
        for (int i = 0; i < this.f; i++) {
            if (Objects.equal(obj, a0(i))) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        Set set = this.h;
        if (set != null) {
            return set;
        }
        Set setV = v();
        this.h = setV;
        return setV;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        Map mapA = A();
        if (mapA != null) {
            return mapA.get(obj);
        }
        int iH = H(obj);
        if (iH == -1) {
            return null;
        }
        q(iH);
        return a0(iH);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        Set set = this.g;
        if (set != null) {
            return set;
        }
        Set setX = x();
        this.g = setX;
        return setX;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        int iV;
        int i;
        if (N()) {
            s();
        }
        Map mapA = A();
        if (mapA != null) {
            return mapA.put(obj, obj2);
        }
        int[] iArrP = P();
        Object[] objArrQ = Q();
        Object[] objArrS = S();
        int i2 = this.f;
        int i3 = i2 + 1;
        int iD = AbstractC3590or.d(obj);
        int iF = F();
        int i4 = iD & iF;
        int iH = AbstractC0791Od.h(R(), i4);
        if (iH != 0) {
            int iB = AbstractC0791Od.b(iD, iF);
            int i5 = 0;
            while (true) {
                int i6 = iH - 1;
                int i7 = iArrP[i6];
                if (AbstractC0791Od.b(i7, iF) == iB && Objects.equal(obj, objArrQ[i6])) {
                    Object obj3 = objArrS[i6];
                    objArrS[i6] = obj2;
                    q(i6);
                    return obj3;
                }
                int iC = AbstractC0791Od.c(i7, iF);
                i5++;
                if (iC != 0) {
                    iH = iC;
                } else {
                    if (i5 >= 9) {
                        return t().put(obj, obj2);
                    }
                    if (i3 > iF) {
                        iV = V(iF, AbstractC0791Od.e(iF), iD, i2);
                        i = iV;
                    } else {
                        iArrP[i6] = AbstractC0791Od.d(i7, i3, iF);
                        i = iF;
                    }
                }
            }
        } else if (i3 > iF) {
            iV = V(iF, AbstractC0791Od.e(iF), iD, i2);
            i = iV;
        } else {
            AbstractC0791Od.i(R(), i4, i3);
            i = iF;
        }
        U(i3);
        J(i2, obj, obj2, iD, i);
        this.f = i3;
        G();
        return null;
    }

    public int r(int i, int i2) {
        return i - 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        Map mapA = A();
        if (mapA != null) {
            return mapA.remove(obj);
        }
        Object objO = O(obj);
        if (objO == j) {
            return null;
        }
        return objO;
    }

    public int s() {
        Preconditions.checkState(N(), "Arrays already allocated");
        int i = this.e;
        int iJ = AbstractC0791Od.j(i);
        this.a = AbstractC0791Od.a(iJ);
        X(iJ - 1);
        this.b = new int[i];
        this.c = new Object[i];
        this.d = new Object[i];
        return i;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        Map mapA = A();
        return mapA != null ? mapA.size() : this.f;
    }

    public Map t() {
        Map mapW = w(F() + 1);
        int iD = D();
        while (iD >= 0) {
            mapW.put(K(iD), a0(iD));
            iD = E(iD);
        }
        this.a = mapW;
        this.b = null;
        this.c = null;
        this.d = null;
        G();
        return mapW;
    }

    public Set v() {
        return new d();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection values() {
        Collection collection = this.i;
        if (collection != null) {
            return collection;
        }
        Collection collectionY = y();
        this.i = collectionY;
        return collectionY;
    }

    public Map w(int i) {
        return new LinkedHashMap(i, 1.0f);
    }

    public Set x() {
        return new f();
    }

    public Collection y() {
        return new h();
    }

    public C0739Md(int i) {
        I(i);
    }

    /* JADX INFO: renamed from: Md$e */
    public abstract class e implements Iterator {
        public int a;
        public int b;
        public int c;

        public e() {
            this.a = C0739Md.this.e;
            this.b = C0739Md.this.D();
            this.c = -1;
        }

        public final void a() {
            if (C0739Md.this.e != this.a) {
                throw new ConcurrentModificationException();
            }
        }

        public abstract Object b(int i);

        public void c() {
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
            Object objB = b(i);
            this.b = C0739Md.this.E(this.b);
            return objB;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            AbstractC1163Zb.e(this.c >= 0);
            c();
            C0739Md c0739Md = C0739Md.this;
            c0739Md.remove(c0739Md.K(this.c));
            this.b = C0739Md.this.r(this.b, this.c);
            this.c = -1;
        }

        public /* synthetic */ e(C0739Md c0739Md, a aVar) {
            this();
        }
    }

    public void q(int i) {
    }
}
