package defpackage;

import com.google.common.collect.Ordering;
import java.io.Serializable;

/* JADX INFO: renamed from: aE, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1213aE extends Ordering implements Serializable {
    public final Ordering a;

    public C1213aE(Ordering ordering) {
        this.a = ordering;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        if (obj == obj2) {
            return 0;
        }
        if (obj == null) {
            return 1;
        }
        if (obj2 == null) {
            return -1;
        }
        return this.a.compare(obj, obj2);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C1213aE) {
            return this.a.equals(((C1213aE) obj).a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() ^ (-921210296);
    }

    @Override // com.google.common.collect.Ordering
    public Ordering nullsFirst() {
        return this.a.nullsFirst();
    }

    @Override // com.google.common.collect.Ordering
    public Ordering reverse() {
        return this.a.reverse().nullsFirst();
    }

    public String toString() {
        String strValueOf = String.valueOf(this.a);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 12);
        sb.append(strValueOf);
        sb.append(".nullsLast()");
        return sb.toString();
    }

    @Override // com.google.common.collect.Ordering
    public Ordering nullsLast() {
        return this;
    }
}
