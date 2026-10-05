package defpackage;

import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: renamed from: Rd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0878Rd extends Ordering implements Serializable {
    public final Comparator a;

    public C0878Rd(Comparator comparator) {
        this.a = (Comparator) Preconditions.checkNotNull(comparator);
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return this.a.compare(obj, obj2);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0878Rd) {
            return this.a.equals(((C0878Rd) obj).a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.a.toString();
    }
}
