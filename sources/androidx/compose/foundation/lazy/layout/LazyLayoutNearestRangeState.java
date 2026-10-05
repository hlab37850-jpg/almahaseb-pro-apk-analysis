package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC3871sJ;
import defpackage.C1001Vs;

/* JADX INFO: loaded from: classes.dex */
public final class LazyLayoutNearestRangeState implements State<C1001Vs> {
    private static final Companion Companion = new Companion(null);
    private final int extraItemCount;
    private int lastFirstVisibleItem;
    private final int slidingWindowSize;
    private final MutableState value$delegate;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final C1001Vs calculateNearestItemsRange(int i, int i2, int i3) {
            int i4 = (i / i2) * i2;
            return AbstractC3871sJ.s(Math.max(i4 - i3, 0), i4 + i2 + i3);
        }

        private Companion() {
        }
    }

    public LazyLayoutNearestRangeState(int i, int i2, int i3) {
        this.slidingWindowSize = i2;
        this.extraItemCount = i3;
        this.value$delegate = SnapshotStateKt.mutableStateOf(Companion.calculateNearestItemsRange(i, i2, i3), SnapshotStateKt.structuralEqualityPolicy());
        this.lastFirstVisibleItem = i;
    }

    private void setValue(C1001Vs c1001Vs) {
        this.value$delegate.setValue(c1001Vs);
    }

    public final void update(int i) {
        if (i != this.lastFirstVisibleItem) {
            this.lastFirstVisibleItem = i;
            setValue(Companion.calculateNearestItemsRange(i, this.slidingWindowSize, this.extraItemCount));
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.runtime.State
    public C1001Vs getValue() {
        return (C1001Vs) this.value$delegate.getValue();
    }
}
