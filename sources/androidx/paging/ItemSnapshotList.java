package androidx.paging;

import androidx.annotation.IntRange;
import defpackage.AbstractC4492zt;
import defpackage.V;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class ItemSnapshotList<T> extends V {
    private final List<T> items;
    private final int placeholdersAfter;
    private final int placeholdersBefore;

    /* JADX WARN: Multi-variable type inference failed */
    public ItemSnapshotList(@IntRange(from = 0) int i, @IntRange(from = 0) int i2, List<? extends T> list) {
        AbstractC4492zt.h(list, "items");
        this.placeholdersBefore = i;
        this.placeholdersAfter = i2;
        this.items = list;
    }

    @Override // defpackage.V, java.util.List
    public T get(int i) {
        if (i >= 0 && i < this.placeholdersBefore) {
            return null;
        }
        int i2 = this.placeholdersBefore;
        if (i < this.items.size() + i2 && i2 <= i) {
            return this.items.get(i - this.placeholdersBefore);
        }
        int size = this.placeholdersBefore + this.items.size();
        if (i < size() && size <= i) {
            return null;
        }
        throw new IndexOutOfBoundsException("Illegal attempt to access index " + i + " in ItemSnapshotList of size " + size());
    }

    public final List<T> getItems() {
        return this.items;
    }

    public final int getPlaceholdersAfter() {
        return this.placeholdersAfter;
    }

    public final int getPlaceholdersBefore() {
        return this.placeholdersBefore;
    }

    @Override // defpackage.V, defpackage.D
    public int getSize() {
        return this.placeholdersBefore + this.items.size() + this.placeholdersAfter;
    }
}
