package androidx.paging;

import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes2.dex */
public final class AdjacentItems<T> {
    private final T after;
    private final T before;

    public AdjacentItems(T t, T t2) {
        this.before = t;
        this.after = t2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AdjacentItems copy$default(AdjacentItems adjacentItems, Object obj, Object obj2, int i, Object obj3) {
        if ((i & 1) != 0) {
            obj = adjacentItems.before;
        }
        if ((i & 2) != 0) {
            obj2 = adjacentItems.after;
        }
        return adjacentItems.copy(obj, obj2);
    }

    public final T component1() {
        return this.before;
    }

    public final T component2() {
        return this.after;
    }

    public final AdjacentItems<T> copy(T t, T t2) {
        return new AdjacentItems<>(t, t2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdjacentItems)) {
            return false;
        }
        AdjacentItems adjacentItems = (AdjacentItems) obj;
        return AbstractC4492zt.d(this.before, adjacentItems.before) && AbstractC4492zt.d(this.after, adjacentItems.after);
    }

    public final T getAfter() {
        return this.after;
    }

    public final T getBefore() {
        return this.before;
    }

    public int hashCode() {
        T t = this.before;
        int iHashCode = (t == null ? 0 : t.hashCode()) * 31;
        T t2 = this.after;
        return iHashCode + (t2 != null ? t2.hashCode() : 0);
    }

    public String toString() {
        return "AdjacentItems(before=" + this.before + ", after=" + this.after + ')';
    }
}
