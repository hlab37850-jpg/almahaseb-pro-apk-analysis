package defpackage;

import com.google.common.base.Equivalence;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Iterator;

/* JADX INFO: renamed from: gG, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2265gG extends Equivalence implements Serializable {
    public final Equivalence a;

    public C2265gG(Equivalence equivalence) {
        this.a = (Equivalence) Preconditions.checkNotNull(equivalence);
    }

    @Override // com.google.common.base.Equivalence
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean doEquivalent(Iterable iterable, Iterable iterable2) {
        Iterator it = iterable.iterator();
        Iterator it2 = iterable2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            if (!this.a.equivalent(it.next(), it2.next())) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    @Override // com.google.common.base.Equivalence
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public int doHash(Iterable iterable) {
        Iterator it = iterable.iterator();
        int iHash = 78721;
        while (it.hasNext()) {
            iHash = (iHash * 24943) + this.a.hash(it.next());
        }
        return iHash;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C2265gG) {
            return this.a.equals(((C2265gG) obj).a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() ^ 1185147655;
    }

    public String toString() {
        String strValueOf = String.valueOf(this.a);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 11);
        sb.append(strValueOf);
        sb.append(".pairwise()");
        return sb.toString();
    }
}
