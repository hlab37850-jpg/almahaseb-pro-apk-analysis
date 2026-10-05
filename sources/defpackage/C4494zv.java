package defpackage;

import com.google.common.collect.Ordering;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;

/* JADX INFO: renamed from: zv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C4494zv extends Ordering implements Serializable {
    public final Comparator a;

    public C4494zv(Comparator comparator) {
        this.a = comparator;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Iterable iterable, Iterable iterable2) {
        Iterator it = iterable.iterator();
        Iterator it2 = iterable2.iterator();
        while (it.hasNext()) {
            if (!it2.hasNext()) {
                return 1;
            }
            int iCompare = this.a.compare(it.next(), it2.next());
            if (iCompare != 0) {
                return iCompare;
            }
        }
        return it2.hasNext() ? -1 : 0;
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C4494zv) {
            return this.a.equals(((C4494zv) obj).a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() ^ 2075626741;
    }

    public String toString() {
        String strValueOf = String.valueOf(this.a);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 18);
        sb.append(strValueOf);
        sb.append(".lexicographical()");
        return sb.toString();
    }
}
