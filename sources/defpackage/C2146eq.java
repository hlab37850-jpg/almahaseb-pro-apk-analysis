package defpackage;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.BoundType;
import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: renamed from: eq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C2146eq implements Serializable {
    public final Comparator a;
    public final boolean b;
    public final Object c;
    public final BoundType d;
    public final boolean e;
    public final Object f;
    public final BoundType g;

    public C2146eq(Comparator comparator, boolean z, Object obj, BoundType boundType, boolean z2, Object obj2, BoundType boundType2) {
        this.a = (Comparator) Preconditions.checkNotNull(comparator);
        this.b = z;
        this.e = z2;
        this.c = obj;
        this.d = (BoundType) Preconditions.checkNotNull(boundType);
        this.f = obj2;
        this.g = (BoundType) Preconditions.checkNotNull(boundType2);
        if (z) {
            comparator.compare(WD.a(obj), WD.a(obj));
        }
        if (z2) {
            comparator.compare(WD.a(obj2), WD.a(obj2));
        }
        if (z && z2) {
            int iCompare = comparator.compare(WD.a(obj), WD.a(obj2));
            Preconditions.checkArgument(iCompare <= 0, "lowerEndpoint (%s) > upperEndpoint (%s)", obj, obj2);
            if (iCompare == 0) {
                BoundType boundType3 = BoundType.OPEN;
                Preconditions.checkArgument((boundType == boundType3 && boundType2 == boundType3) ? false : true);
            }
        }
    }

    public static C2146eq a(Comparator comparator) {
        BoundType boundType = BoundType.OPEN;
        return new C2146eq(comparator, false, null, boundType, false, null, boundType);
    }

    public static C2146eq e(Comparator comparator, Object obj, BoundType boundType) {
        return new C2146eq(comparator, true, obj, boundType, false, null, BoundType.OPEN);
    }

    public static C2146eq p(Comparator comparator, Object obj, BoundType boundType) {
        return new C2146eq(comparator, false, null, BoundType.OPEN, true, obj, boundType);
    }

    public Comparator b() {
        return this.a;
    }

    public boolean c(Object obj) {
        return (o(obj) || n(obj)) ? false : true;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2146eq)) {
            return false;
        }
        C2146eq c2146eq = (C2146eq) obj;
        return this.a.equals(c2146eq.a) && this.b == c2146eq.b && this.e == c2146eq.e && f().equals(c2146eq.f()) && i().equals(c2146eq.i()) && Objects.equal(h(), c2146eq.h()) && Objects.equal(j(), c2146eq.j());
    }

    public BoundType f() {
        return this.d;
    }

    public Object h() {
        return this.c;
    }

    public int hashCode() {
        return Objects.hashCode(this.a, h(), f(), j(), i());
    }

    public BoundType i() {
        return this.g;
    }

    public Object j() {
        return this.f;
    }

    public boolean k() {
        return this.b;
    }

    public boolean l() {
        return this.e;
    }

    public C2146eq m(C2146eq c2146eq) {
        int iCompare;
        int iCompare2;
        Object obj;
        BoundType boundType;
        BoundType boundType2;
        int iCompare3;
        BoundType boundType3;
        Preconditions.checkNotNull(c2146eq);
        Preconditions.checkArgument(this.a.equals(c2146eq.a));
        boolean z = this.b;
        Object objH = h();
        BoundType boundTypeF = f();
        if (!k()) {
            z = c2146eq.b;
            objH = c2146eq.h();
            boundTypeF = c2146eq.f();
        } else if (c2146eq.k() && ((iCompare = this.a.compare(h(), c2146eq.h())) < 0 || (iCompare == 0 && c2146eq.f() == BoundType.OPEN))) {
            objH = c2146eq.h();
            boundTypeF = c2146eq.f();
        }
        boolean z2 = z;
        boolean z3 = this.e;
        Object objJ = j();
        BoundType boundTypeI = i();
        if (!l()) {
            z3 = c2146eq.e;
            objJ = c2146eq.j();
            boundTypeI = c2146eq.i();
        } else if (c2146eq.l() && ((iCompare2 = this.a.compare(j(), c2146eq.j())) > 0 || (iCompare2 == 0 && c2146eq.i() == BoundType.OPEN))) {
            objJ = c2146eq.j();
            boundTypeI = c2146eq.i();
        }
        boolean z4 = z3;
        Object obj2 = objJ;
        if (z2 && z4 && ((iCompare3 = this.a.compare(objH, obj2)) > 0 || (iCompare3 == 0 && boundTypeF == (boundType3 = BoundType.OPEN) && boundTypeI == boundType3))) {
            boundType = BoundType.OPEN;
            boundType2 = BoundType.CLOSED;
            obj = obj2;
        } else {
            obj = objH;
            boundType = boundTypeF;
            boundType2 = boundTypeI;
        }
        return new C2146eq(this.a, z2, obj, boundType, z4, obj2, boundType2);
    }

    public boolean n(Object obj) {
        if (!l()) {
            return false;
        }
        int iCompare = this.a.compare(obj, WD.a(j()));
        return ((iCompare == 0) & (i() == BoundType.OPEN)) | (iCompare > 0);
    }

    public boolean o(Object obj) {
        if (!k()) {
            return false;
        }
        int iCompare = this.a.compare(obj, WD.a(h()));
        return ((iCompare == 0) & (f() == BoundType.OPEN)) | (iCompare < 0);
    }

    public String toString() {
        String strValueOf = String.valueOf(this.a);
        BoundType boundType = this.d;
        BoundType boundType2 = BoundType.CLOSED;
        char c = boundType == boundType2 ? '[' : '(';
        String strValueOf2 = String.valueOf(this.b ? this.c : "-∞");
        String strValueOf3 = String.valueOf(this.e ? this.f : "∞");
        char c2 = this.g == boundType2 ? ']' : ')';
        StringBuilder sb = new StringBuilder(strValueOf.length() + 4 + strValueOf2.length() + strValueOf3.length());
        sb.append(strValueOf);
        sb.append(":");
        sb.append(c);
        sb.append(strValueOf2);
        sb.append(',');
        sb.append(strValueOf3);
        sb.append(c2);
        return sb.toString();
    }
}
