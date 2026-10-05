package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import defpackage.AbstractC4492zt;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class NestedVectorStack<T> {
    private int lastIndex;
    private int current = -1;
    private int[] indexes = new int[16];
    private final MutableVector<MutableVector<T>> vectors = new MutableVector<>(new MutableVector[16], 0);

    private final void pushIndex(int i) {
        int i2 = this.lastIndex;
        int[] iArr = this.indexes;
        if (i2 >= iArr.length) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length * 2);
            AbstractC4492zt.g(iArrCopyOf, "copyOf(this, newSize)");
            this.indexes = iArrCopyOf;
        }
        int[] iArr2 = this.indexes;
        int i3 = this.lastIndex;
        this.lastIndex = i3 + 1;
        iArr2[i3] = i;
    }

    public final boolean isNotEmpty() {
        int i = this.current;
        return i >= 0 && this.indexes[i] >= 0;
    }

    public final T pop() {
        int i = this.current;
        int i2 = this.indexes[i];
        MutableVector<T> mutableVector = this.vectors.getContent()[i];
        if (i2 > 0) {
            int[] iArr = this.indexes;
            iArr[i] = iArr[i] - 1;
        } else if (i2 == 0) {
            this.vectors.removeAt(i);
            this.current--;
        }
        return mutableVector.getContent()[i2];
    }

    public final void push(MutableVector<T> mutableVector) {
        AbstractC4492zt.h(mutableVector, "vector");
        if (mutableVector.isNotEmpty()) {
            this.vectors.add(mutableVector);
            pushIndex(mutableVector.getSize() - 1);
            this.current++;
        }
    }
}
