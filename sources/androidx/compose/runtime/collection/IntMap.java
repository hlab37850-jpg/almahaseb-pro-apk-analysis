package androidx.compose.runtime.collection;

import android.util.SparseArray;
import defpackage.AbstractC0419Di;

/* JADX INFO: loaded from: classes.dex */
public final class IntMap<E> {
    private final SparseArray<E> sparseArray;

    private IntMap(SparseArray<E> sparseArray) {
        this.sparseArray = sparseArray;
    }

    public final void clear() {
        this.sparseArray.clear();
    }

    public final boolean contains(int i) {
        return this.sparseArray.indexOfKey(i) >= 0;
    }

    public final E get(int i) {
        return this.sparseArray.get(i);
    }

    public final int getSize() {
        return this.sparseArray.size();
    }

    public final void remove(int i) {
        this.sparseArray.remove(i);
    }

    public final void set(int i, E e) {
        this.sparseArray.put(i, e);
    }

    public final E get(int i, E e) {
        return this.sparseArray.get(i, e);
    }

    public IntMap(int i) {
        this(new SparseArray(i));
    }

    public /* synthetic */ IntMap(int i, int i2, AbstractC0419Di abstractC0419Di) {
        this((i2 & 1) != 0 ? 10 : i);
    }
}
