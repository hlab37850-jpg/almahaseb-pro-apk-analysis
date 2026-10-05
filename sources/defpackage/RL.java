package defpackage;

import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import java.io.Serializable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class RL extends Ordering implements Serializable {
    public static final RL a = new RL();

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Comparable comparable, Comparable comparable2) {
        Preconditions.checkNotNull(comparable);
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    @Override // com.google.common.collect.Ordering
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Comparable max(Comparable comparable, Comparable comparable2) {
        return (Comparable) C1859cD.c.min(comparable, comparable2);
    }

    @Override // com.google.common.collect.Ordering
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Comparable max(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable... comparableArr) {
        return (Comparable) C1859cD.c.min(comparable, comparable2, comparable3, comparableArr);
    }

    @Override // com.google.common.collect.Ordering
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Comparable max(Iterable iterable) {
        return (Comparable) C1859cD.c.min(iterable);
    }

    @Override // com.google.common.collect.Ordering
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Comparable max(Iterator it) {
        return (Comparable) C1859cD.c.min(it);
    }

    @Override // com.google.common.collect.Ordering
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public Comparable min(Comparable comparable, Comparable comparable2) {
        return (Comparable) C1859cD.c.max(comparable, comparable2);
    }

    @Override // com.google.common.collect.Ordering
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public Comparable min(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable... comparableArr) {
        return (Comparable) C1859cD.c.max(comparable, comparable2, comparable3, comparableArr);
    }

    @Override // com.google.common.collect.Ordering
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public Comparable min(Iterable iterable) {
        return (Comparable) C1859cD.c.max(iterable);
    }

    @Override // com.google.common.collect.Ordering
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public Comparable min(Iterator it) {
        return (Comparable) C1859cD.c.max(it);
    }

    @Override // com.google.common.collect.Ordering
    public Ordering reverse() {
        return Ordering.natural();
    }

    public String toString() {
        return "Ordering.natural().reverse()";
    }
}
