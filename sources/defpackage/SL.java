package defpackage;

import java.util.Comparator;

/* JADX INFO: loaded from: classes3.dex */
public final class SL implements Comparator {
    public static final SL a = new SL();

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Comparable comparable, Comparable comparable2) {
        AbstractC4492zt.h(comparable, "a");
        AbstractC4492zt.h(comparable2, "b");
        return comparable2.compareTo(comparable);
    }

    @Override // java.util.Comparator
    public final Comparator reversed() {
        return C1778bD.a;
    }
}
