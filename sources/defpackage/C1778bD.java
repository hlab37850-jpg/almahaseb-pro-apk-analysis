package defpackage;

import java.util.Comparator;

/* JADX INFO: renamed from: bD, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1778bD implements Comparator {
    public static final C1778bD a = new C1778bD();

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Comparable comparable, Comparable comparable2) {
        AbstractC4492zt.h(comparable, "a");
        AbstractC4492zt.h(comparable2, "b");
        return comparable.compareTo(comparable2);
    }

    @Override // java.util.Comparator
    public final Comparator reversed() {
        return SL.a;
    }
}
