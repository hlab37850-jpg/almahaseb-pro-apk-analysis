package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC3871sJ;

/* JADX INFO: loaded from: classes.dex */
@Stable
@ExperimentalMaterial3Api
public final class TopAppBarState {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final Saver<TopAppBarState, ?> Saver = ListSaverKt.listSaver(TopAppBarState$Companion$Saver$1.INSTANCE, TopAppBarState$Companion$Saver$2.INSTANCE);
    private MutableState<Float> _heightOffset;
    private final MutableState contentOffset$delegate;
    private final MutableState heightOffsetLimit$delegate;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final Saver<TopAppBarState, ?> getSaver() {
            return TopAppBarState.Saver;
        }

        private Companion() {
        }
    }

    public TopAppBarState(float f, float f2, float f3) {
        this.heightOffsetLimit$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(f), null, 2, null);
        this.contentOffset$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(f3), null, 2, null);
        this._heightOffset = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(f2), null, 2, null);
    }

    public final float getCollapsedFraction() {
        if (getHeightOffsetLimit() == 0.0f) {
            return 0.0f;
        }
        return getHeightOffset() / getHeightOffsetLimit();
    }

    public final float getContentOffset() {
        return ((Number) this.contentOffset$delegate.getValue()).floatValue();
    }

    public final float getHeightOffset() {
        return this._heightOffset.getValue().floatValue();
    }

    public final float getHeightOffsetLimit() {
        return ((Number) this.heightOffsetLimit$delegate.getValue()).floatValue();
    }

    public final float getOverlappedFraction() {
        if (getHeightOffsetLimit() == 0.0f) {
            return 0.0f;
        }
        return 1 - (AbstractC3871sJ.k(getHeightOffsetLimit() - getContentOffset(), getHeightOffsetLimit(), 0.0f) / getHeightOffsetLimit());
    }

    public final void setContentOffset(float f) {
        this.contentOffset$delegate.setValue(Float.valueOf(f));
    }

    public final void setHeightOffset(float f) {
        this._heightOffset.setValue(Float.valueOf(AbstractC3871sJ.k(f, getHeightOffsetLimit(), 0.0f)));
    }

    public final void setHeightOffsetLimit(float f) {
        this.heightOffsetLimit$delegate.setValue(Float.valueOf(f));
    }
}
