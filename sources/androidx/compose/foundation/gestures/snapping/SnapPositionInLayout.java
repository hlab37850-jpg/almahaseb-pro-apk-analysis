package androidx.compose.foundation.gestures.snapping;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.ui.unit.Density;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalFoundationApi
public interface SnapPositionInLayout {
    public static final Companion Companion = Companion.$$INSTANCE;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final SnapPositionInLayout CenterToCenter = new SnapPositionInLayout() { // from class: androidx.compose.foundation.gestures.snapping.SnapPositionInLayout$Companion$CenterToCenter$1
            @Override // androidx.compose.foundation.gestures.snapping.SnapPositionInLayout
            public final int position(Density density, int i, int i2, int i3) {
                AbstractC4492zt.h(density, "$this$SnapPositionInLayout");
                return (i / 2) - (i2 / 2);
            }
        };

        private Companion() {
        }

        public final SnapPositionInLayout getCenterToCenter() {
            return CenterToCenter;
        }
    }

    int position(Density density, int i, int i2, int i3);
}
