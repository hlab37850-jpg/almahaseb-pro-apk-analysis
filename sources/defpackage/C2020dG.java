package defpackage;

import java.io.Serializable;

/* JADX INFO: renamed from: dG, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C2020dG implements Serializable {
    public final Object a;
    public final Object b;

    public C2020dG(Object obj, Object obj2) {
        this.a = obj;
        this.b = obj2;
    }

    public final Object a() {
        return this.a;
    }

    public final Object b() {
        return this.b;
    }

    public final Object c() {
        return this.a;
    }

    public final Object e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2020dG)) {
            return false;
        }
        C2020dG c2020dG = (C2020dG) obj;
        return AbstractC4492zt.d(this.a, c2020dG.a) && AbstractC4492zt.d(this.b, c2020dG.b);
    }

    public int hashCode() {
        Object obj = this.a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.b;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.a + ", " + this.b + ')';
    }
}
