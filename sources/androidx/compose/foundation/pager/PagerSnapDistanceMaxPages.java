package androidx.compose.foundation.pager;

import defpackage.AbstractC3871sJ;

/* JADX INFO: loaded from: classes.dex */
public final class PagerSnapDistanceMaxPages implements PagerSnapDistance {
    private final int pagesLimit;

    public PagerSnapDistanceMaxPages(int i) {
        this.pagesLimit = i;
    }

    @Override // androidx.compose.foundation.pager.PagerSnapDistance
    public int calculateTargetPage(int i, int i2, float f, int i3, int i4) {
        int i5 = this.pagesLimit;
        return AbstractC3871sJ.l(i2, i - i5, i + i5);
    }

    public boolean equals(Object obj) {
        return (obj instanceof PagerSnapDistanceMaxPages) && this.pagesLimit == ((PagerSnapDistanceMaxPages) obj).pagesLimit;
    }

    public int hashCode() {
        return this.pagesLimit;
    }
}
