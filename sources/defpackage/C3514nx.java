package defpackage;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.itextpdf.tool.xml.html.HTML;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: renamed from: nx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3514nx implements Map, Serializable, InterfaceC0834Pu {
    public static final a p = new a(null);
    public static final C3514nx q;
    public Object[] a;
    public Object[] b;
    public int[] c;
    public int[] d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public C3677px j;
    public C3758qx k;
    public C3596ox l;
    public boolean n;

    /* JADX INFO: renamed from: nx$a */
    public static final class a {
        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final int c(int i) {
            return Integer.highestOneBit(AbstractC3871sJ.d(i, 1) * 3);
        }

        public final int d(int i) {
            return Integer.numberOfLeadingZeros(i) + 1;
        }

        public final C3514nx e() {
            return C3514nx.q;
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: nx$b */
    public static final class b extends d implements Iterator, InterfaceC0756Mu {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(C3514nx c3514nx) {
            super(c3514nx);
            AbstractC4492zt.h(c3514nx, HTML.Tag.MAP);
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public c next() {
            a();
            if (b() >= d().f) {
                throw new NoSuchElementException();
            }
            int iB = b();
            f(iB + 1);
            g(iB);
            c cVar = new c(d(), c());
            e();
            return cVar;
        }

        public final void j(StringBuilder sb) {
            AbstractC4492zt.h(sb, "sb");
            if (b() >= d().f) {
                throw new NoSuchElementException();
            }
            int iB = b();
            f(iB + 1);
            g(iB);
            Object obj = d().a[c()];
            if (obj == d()) {
                sb.append("(this Map)");
            } else {
                sb.append(obj);
            }
            sb.append('=');
            Object[] objArr = d().b;
            AbstractC4492zt.e(objArr);
            Object obj2 = objArr[c()];
            if (obj2 == d()) {
                sb.append("(this Map)");
            } else {
                sb.append(obj2);
            }
            e();
        }

        public final int k() {
            if (b() >= d().f) {
                throw new NoSuchElementException();
            }
            int iB = b();
            f(iB + 1);
            g(iB);
            Object obj = d().a[c()];
            int iHashCode = obj != null ? obj.hashCode() : 0;
            Object[] objArr = d().b;
            AbstractC4492zt.e(objArr);
            Object obj2 = objArr[c()];
            int iHashCode2 = iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
            e();
            return iHashCode2;
        }
    }

    /* JADX INFO: renamed from: nx$c */
    public static final class c implements Map.Entry, InterfaceC0834Pu.a {
        public final C3514nx a;
        public final int b;

        public c(C3514nx c3514nx, int i) {
            AbstractC4492zt.h(c3514nx, HTML.Tag.MAP);
            this.a = c3514nx;
            this.b = i;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                if (AbstractC4492zt.d(entry.getKey(), getKey()) && AbstractC4492zt.d(entry.getValue(), getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.a.a[this.b];
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            Object[] objArr = this.a.b;
            AbstractC4492zt.e(objArr);
            return objArr[this.b];
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Object key = getKey();
            int iHashCode = key != null ? key.hashCode() : 0;
            Object value = getValue();
            return iHashCode ^ (value != null ? value.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            this.a.o();
            Object[] objArrM = this.a.m();
            int i = this.b;
            Object obj2 = objArrM[i];
            objArrM[i] = obj;
            return obj2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getKey());
            sb.append('=');
            sb.append(getValue());
            return sb.toString();
        }
    }

    /* JADX INFO: renamed from: nx$d */
    public static class d {
        public final C3514nx a;
        public int b;
        public int c;
        public int d;

        public d(C3514nx c3514nx) {
            AbstractC4492zt.h(c3514nx, HTML.Tag.MAP);
            this.a = c3514nx;
            this.c = -1;
            this.d = c3514nx.h;
            e();
        }

        public final void a() {
            if (this.a.h != this.d) {
                throw new ConcurrentModificationException();
            }
        }

        public final int b() {
            return this.b;
        }

        public final int c() {
            return this.c;
        }

        public final C3514nx d() {
            return this.a;
        }

        public final void e() {
            while (this.b < this.a.f) {
                int[] iArr = this.a.c;
                int i = this.b;
                if (iArr[i] >= 0) {
                    return;
                } else {
                    this.b = i + 1;
                }
            }
        }

        public final void f(int i) {
            this.b = i;
        }

        public final void g(int i) {
            this.c = i;
        }

        public final boolean hasNext() {
            return this.b < this.a.f;
        }

        public final void remove() {
            a();
            if (this.c == -1) {
                throw new IllegalStateException("Call next() before removing element from the iterator.");
            }
            this.a.o();
            this.a.M(this.c);
            this.c = -1;
            this.d = this.a.h;
        }
    }

    /* JADX INFO: renamed from: nx$e */
    public static final class e extends d implements Iterator, InterfaceC0756Mu {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(C3514nx c3514nx) {
            super(c3514nx);
            AbstractC4492zt.h(c3514nx, HTML.Tag.MAP);
        }

        @Override // java.util.Iterator
        public Object next() {
            a();
            if (b() >= d().f) {
                throw new NoSuchElementException();
            }
            int iB = b();
            f(iB + 1);
            g(iB);
            Object obj = d().a[c()];
            e();
            return obj;
        }
    }

    /* JADX INFO: renamed from: nx$f */
    public static final class f extends d implements Iterator, InterfaceC0756Mu {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(C3514nx c3514nx) {
            super(c3514nx);
            AbstractC4492zt.h(c3514nx, HTML.Tag.MAP);
        }

        @Override // java.util.Iterator
        public Object next() {
            a();
            if (b() >= d().f) {
                throw new NoSuchElementException();
            }
            int iB = b();
            f(iB + 1);
            g(iB);
            Object[] objArr = d().b;
            AbstractC4492zt.e(objArr);
            Object obj = objArr[c()];
            e();
            return obj;
        }
    }

    static {
        C3514nx c3514nx = new C3514nx(0);
        c3514nx.n = true;
        q = c3514nx;
    }

    public C3514nx(Object[] objArr, Object[] objArr2, int[] iArr, int[] iArr2, int i, int i2) {
        this.a = objArr;
        this.b = objArr2;
        this.c = iArr;
        this.d = iArr2;
        this.e = i;
        this.f = i2;
        this.g = p.d(A());
    }

    private final void J() {
        this.h++;
    }

    private final void t(int i) {
        if (i < 0) {
            throw new OutOfMemoryError();
        }
        if (i > y()) {
            int iE = V.Companion.e(y(), i);
            this.a = AbstractC0636Jv.e(this.a, iE);
            Object[] objArr = this.b;
            this.b = objArr != null ? AbstractC0636Jv.e(objArr, iE) : null;
            int[] iArrCopyOf = Arrays.copyOf(this.c, iE);
            AbstractC4492zt.g(iArrCopyOf, "copyOf(...)");
            this.c = iArrCopyOf;
            int iC = p.c(iE);
            if (iC > A()) {
                K(iC);
            }
        }
    }

    private final void u(int i) {
        if (Q(i)) {
            p(true);
        } else {
            t(this.f + i);
        }
    }

    public final int A() {
        return this.d.length;
    }

    public Set B() {
        C3677px c3677px = this.j;
        if (c3677px != null) {
            return c3677px;
        }
        C3677px c3677px2 = new C3677px(this);
        this.j = c3677px2;
        return c3677px2;
    }

    public int C() {
        return this.i;
    }

    public Collection D() {
        C3758qx c3758qx = this.k;
        if (c3758qx != null) {
            return c3758qx;
        }
        C3758qx c3758qx2 = new C3758qx(this);
        this.k = c3758qx2;
        return c3758qx2;
    }

    public final int E(Object obj) {
        return ((obj != null ? obj.hashCode() : 0) * (-1640531527)) >>> this.g;
    }

    public final e F() {
        return new e(this);
    }

    public final boolean G(Collection collection) {
        boolean z = false;
        if (collection.isEmpty()) {
            return false;
        }
        u(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (H((Map.Entry) it.next())) {
                z = true;
            }
        }
        return z;
    }

    public final boolean H(Map.Entry entry) {
        int iL = l(entry.getKey());
        Object[] objArrM = m();
        if (iL >= 0) {
            objArrM[iL] = entry.getValue();
            return true;
        }
        int i = (-iL) - 1;
        if (AbstractC4492zt.d(entry.getValue(), objArrM[i])) {
            return false;
        }
        objArrM[i] = entry.getValue();
        return true;
    }

    public final boolean I(int i) {
        int iE = E(this.a[i]);
        int i2 = this.e;
        while (true) {
            int[] iArr = this.d;
            if (iArr[iE] == 0) {
                iArr[iE] = i + 1;
                this.c[i] = iE;
                return true;
            }
            i2--;
            if (i2 < 0) {
                return false;
            }
            iE = iE == 0 ? A() - 1 : iE - 1;
        }
    }

    public final void K(int i) {
        J();
        int i2 = 0;
        if (this.f > size()) {
            p(false);
        }
        this.d = new int[i];
        this.g = p.d(i);
        while (i2 < this.f) {
            int i3 = i2 + 1;
            if (!I(i2)) {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
            i2 = i3;
        }
    }

    public final boolean L(Map.Entry entry) {
        AbstractC4492zt.h(entry, "entry");
        o();
        int iW = w(entry.getKey());
        if (iW < 0) {
            return false;
        }
        Object[] objArr = this.b;
        AbstractC4492zt.e(objArr);
        if (!AbstractC4492zt.d(objArr[iW], entry.getValue())) {
            return false;
        }
        M(iW);
        return true;
    }

    public final void M(int i) {
        AbstractC0636Jv.f(this.a, i);
        Object[] objArr = this.b;
        if (objArr != null) {
            AbstractC0636Jv.f(objArr, i);
        }
        N(this.c[i]);
        this.c[i] = -1;
        this.i = size() - 1;
        J();
    }

    public final void N(int i) {
        int iG = AbstractC3871sJ.g(this.e * 2, A() / 2);
        int i2 = 0;
        int i3 = i;
        do {
            i = i == 0 ? A() - 1 : i - 1;
            i2++;
            if (i2 > this.e) {
                this.d[i3] = 0;
                return;
            }
            int[] iArr = this.d;
            int i4 = iArr[i];
            if (i4 == 0) {
                iArr[i3] = 0;
                return;
            }
            if (i4 < 0) {
                iArr[i3] = -1;
            } else {
                int i5 = i4 - 1;
                if (((E(this.a[i5]) - i) & (A() - 1)) >= i2) {
                    this.d[i3] = i4;
                    this.c[i5] = i3;
                }
                iG--;
            }
            i3 = i;
            i2 = 0;
            iG--;
        } while (iG >= 0);
        this.d[i3] = -1;
    }

    public final boolean O(Object obj) {
        o();
        int iW = w(obj);
        if (iW < 0) {
            return false;
        }
        M(iW);
        return true;
    }

    public final boolean P(Object obj) {
        o();
        int iX = x(obj);
        if (iX < 0) {
            return false;
        }
        M(iX);
        return true;
    }

    public final boolean Q(int i) {
        int iY = y();
        int i2 = this.f;
        int i3 = iY - i2;
        int size = i2 - size();
        return i3 < i && i3 + size >= i && size >= y() / 4;
    }

    public final f R() {
        return new f(this);
    }

    @Override // java.util.Map
    public void clear() {
        o();
        int i = this.f - 1;
        if (i >= 0) {
            int i2 = 0;
            while (true) {
                int[] iArr = this.c;
                int i3 = iArr[i2];
                if (i3 >= 0) {
                    this.d[i3] = 0;
                    iArr[i2] = -1;
                }
                if (i2 == i) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        AbstractC0636Jv.g(this.a, 0, this.f);
        Object[] objArr = this.b;
        if (objArr != null) {
            AbstractC0636Jv.g(objArr, 0, this.f);
        }
        this.i = 0;
        this.f = 0;
        J();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return w(obj) >= 0;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return x(obj) >= 0;
    }

    @Override // java.util.Map
    public final /* bridge */ Set entrySet() {
        return z();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof Map) && s((Map) obj));
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        int iW = w(obj);
        if (iW < 0) {
            return null;
        }
        Object[] objArr = this.b;
        AbstractC4492zt.e(objArr);
        return objArr[iW];
    }

    @Override // java.util.Map
    public int hashCode() {
        b bVarV = v();
        int iK = 0;
        while (bVarV.hasNext()) {
            iK += bVarV.k();
        }
        return iK;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final /* bridge */ Set keySet() {
        return B();
    }

    public final int l(Object obj) {
        o();
        while (true) {
            int iE = E(obj);
            int iG = AbstractC3871sJ.g(this.e * 2, A() / 2);
            int i = 0;
            while (true) {
                int i2 = this.d[iE];
                if (i2 <= 0) {
                    if (this.f >= y()) {
                        u(1);
                        break;
                    }
                    int i3 = this.f;
                    int i4 = i3 + 1;
                    this.f = i4;
                    this.a[i3] = obj;
                    this.c[i3] = iE;
                    this.d[iE] = i4;
                    this.i = size() + 1;
                    J();
                    if (i > this.e) {
                        this.e = i;
                    }
                    return i3;
                }
                if (AbstractC4492zt.d(this.a[i2 - 1], obj)) {
                    return -i2;
                }
                i++;
                if (i > iG) {
                    K(A() * 2);
                    break;
                }
                iE = iE == 0 ? A() - 1 : iE - 1;
            }
        }
    }

    public final Object[] m() {
        Object[] objArr = this.b;
        if (objArr != null) {
            return objArr;
        }
        Object[] objArrD = AbstractC0636Jv.d(y());
        this.b = objArrD;
        return objArrD;
    }

    public final Map n() {
        o();
        this.n = true;
        if (size() > 0) {
            return this;
        }
        C3514nx c3514nx = q;
        AbstractC4492zt.f(c3514nx, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        return c3514nx;
    }

    public final void o() {
        if (this.n) {
            throw new UnsupportedOperationException();
        }
    }

    public final void p(boolean z) {
        int i;
        Object[] objArr = this.b;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = this.f;
            if (i2 >= i) {
                break;
            }
            int[] iArr = this.c;
            int i4 = iArr[i2];
            if (i4 >= 0) {
                Object[] objArr2 = this.a;
                objArr2[i3] = objArr2[i2];
                if (objArr != null) {
                    objArr[i3] = objArr[i2];
                }
                if (z) {
                    iArr[i3] = i4;
                    this.d[i4] = i3 + 1;
                }
                i3++;
            }
            i2++;
        }
        AbstractC0636Jv.g(this.a, i3, i);
        if (objArr != null) {
            AbstractC0636Jv.g(objArr, i3, this.f);
        }
        this.f = i3;
    }

    @Override // java.util.Map
    public Object put(Object obj, Object obj2) {
        o();
        int iL = l(obj);
        Object[] objArrM = m();
        if (iL >= 0) {
            objArrM[iL] = obj2;
            return null;
        }
        int i = (-iL) - 1;
        Object obj3 = objArrM[i];
        objArrM[i] = obj2;
        return obj3;
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        AbstractC4492zt.h(map, TypedValues.TransitionType.S_FROM);
        o();
        G(map.entrySet());
    }

    public final boolean q(Collection collection) {
        AbstractC4492zt.h(collection, "m");
        for (Object obj : collection) {
            if (obj != null) {
                try {
                    if (!r((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean r(Map.Entry entry) {
        AbstractC4492zt.h(entry, "entry");
        int iW = w(entry.getKey());
        if (iW < 0) {
            return false;
        }
        Object[] objArr = this.b;
        AbstractC4492zt.e(objArr);
        return AbstractC4492zt.d(objArr[iW], entry.getValue());
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        o();
        int iW = w(obj);
        if (iW < 0) {
            return null;
        }
        Object[] objArr = this.b;
        AbstractC4492zt.e(objArr);
        Object obj2 = objArr[iW];
        M(iW);
        return obj2;
    }

    public final boolean s(Map map) {
        return size() == map.size() && q(map.entrySet());
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return C();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((size() * 3) + 2);
        sb.append("{");
        b bVarV = v();
        int i = 0;
        while (bVarV.hasNext()) {
            if (i > 0) {
                sb.append(", ");
            }
            bVarV.j(sb);
            i++;
        }
        sb.append("}");
        String string = sb.toString();
        AbstractC4492zt.g(string, "toString(...)");
        return string;
    }

    public final b v() {
        return new b(this);
    }

    @Override // java.util.Map
    public final /* bridge */ Collection values() {
        return D();
    }

    public final int w(Object obj) {
        int iE = E(obj);
        int i = this.e;
        while (true) {
            int i2 = this.d[iE];
            if (i2 == 0) {
                return -1;
            }
            if (i2 > 0) {
                int i3 = i2 - 1;
                if (AbstractC4492zt.d(this.a[i3], obj)) {
                    return i3;
                }
            }
            i--;
            if (i < 0) {
                return -1;
            }
            iE = iE == 0 ? A() - 1 : iE - 1;
        }
    }

    public final int x(Object obj) {
        int i = this.f;
        while (true) {
            i--;
            if (i < 0) {
                return -1;
            }
            if (this.c[i] >= 0) {
                Object[] objArr = this.b;
                AbstractC4492zt.e(objArr);
                if (AbstractC4492zt.d(objArr[i], obj)) {
                    return i;
                }
            }
        }
    }

    public final int y() {
        return this.a.length;
    }

    public Set z() {
        C3596ox c3596ox = this.l;
        if (c3596ox != null) {
            return c3596ox;
        }
        C3596ox c3596ox2 = new C3596ox(this);
        this.l = c3596ox2;
        return c3596ox2;
    }

    public C3514nx() {
        this(8);
    }

    public C3514nx(int i) {
        this(AbstractC0636Jv.d(i), null, new int[i], new int[p.c(i)], 2, 0);
    }
}
