package defpackage;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public final class DV implements Serializable {
    public final Object a;
    public final Object b;
    public final Object c;

    public DV(Object obj, Object obj2, Object obj3) {
        this.a = obj;
        this.b = obj2;
        this.c = obj3;
    }

    public final Object a() {
        return this.a;
    }

    public final Object b() {
        return this.b;
    }

    public final Object c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DV)) {
            return false;
        }
        DV dv = (DV) obj;
        return AbstractC4492zt.d(this.a, dv.a) && AbstractC4492zt.d(this.b, dv.b) && AbstractC4492zt.d(this.c, dv.c);
    }

    public int hashCode() {
        Object obj = this.a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.b;
        int iHashCode2 = (iHashCode + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Object obj3 = this.c;
        return iHashCode2 + (obj3 != null ? obj3.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.a + ", " + this.b + ", " + this.c + ')';
    }
}
