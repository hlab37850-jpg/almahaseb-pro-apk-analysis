package androidx.compose.foundation;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.unit.Density;
import defpackage.AbstractC1210aB;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@Stable
@ExperimentalFoundationApi
public interface MarqueeSpacing {
    public static final Companion Companion = Companion.$$INSTANCE;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        @ExperimentalFoundationApi
        public final MarqueeSpacing fractionOfContainer(final float f) {
            return new MarqueeSpacing() { // from class: androidx.compose.foundation.MarqueeSpacing$Companion$fractionOfContainer$1
                @Override // androidx.compose.foundation.MarqueeSpacing
                public final int calculateSpacing(Density density, int i, int i2) {
                    AbstractC4492zt.h(density, "$this$MarqueeSpacing");
                    return AbstractC1210aB.c(f * i2);
                }
            };
        }
    }

    @ExperimentalFoundationApi
    int calculateSpacing(Density density, int i, int i2);
}
