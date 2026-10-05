package defpackage;

import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import java.io.Serializable;

/* JADX INFO: renamed from: cD, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1859cD extends Ordering implements Serializable {
    public static final C1859cD c = new C1859cD();
    public transient Ordering a;
    public transient Ordering b;

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Comparable comparable, Comparable comparable2) {
        Preconditions.checkNotNull(comparable);
        Preconditions.checkNotNull(comparable2);
        return comparable.compareTo(comparable2);
    }

    @Override // com.google.common.collect.Ordering
    public Ordering nullsFirst() {
        Ordering ordering = this.a;
        if (ordering != null) {
            return ordering;
        }
        Ordering orderingNullsFirst = super.nullsFirst();
        this.a = orderingNullsFirst;
        return orderingNullsFirst;
    }

    @Override // com.google.common.collect.Ordering
    public Ordering nullsLast() {
        Ordering ordering = this.b;
        if (ordering != null) {
            return ordering;
        }
        Ordering orderingNullsLast = super.nullsLast();
        this.b = orderingNullsLast;
        return orderingNullsLast;
    }

    @Override // com.google.common.collect.Ordering
    public Ordering reverse() {
        return RL.a;
    }

    public String toString() {
        return "Ordering.natural()";
    }
}
