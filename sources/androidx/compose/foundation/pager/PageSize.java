package androidx.compose.foundation.pager;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.unit.Density;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@Stable
@ExperimentalFoundationApi
public interface PageSize {

    @StabilityInferred(parameters = 0)
    @ExperimentalFoundationApi
    public static final class Fill implements PageSize {
        public static final int $stable = 0;
        public static final Fill INSTANCE = new Fill();

        private Fill() {
        }

        @Override // androidx.compose.foundation.pager.PageSize
        public int calculateMainAxisPageSize(Density density, int i, int i2) {
            AbstractC4492zt.h(density, "<this>");
            return i;
        }
    }

    @StabilityInferred(parameters = 0)
    @ExperimentalFoundationApi
    public static final class Fixed implements PageSize {
        public static final int $stable = 0;
        private final float pageSize;

        public /* synthetic */ Fixed(float f, AbstractC0419Di abstractC0419Di) {
            this(f);
        }

        @Override // androidx.compose.foundation.pager.PageSize
        public int calculateMainAxisPageSize(Density density, int i, int i2) {
            AbstractC4492zt.h(density, "<this>");
            return density.mo327roundToPx0680j_4(this.pageSize);
        }

        /* JADX INFO: renamed from: getPageSize-D9Ej5fM, reason: not valid java name */
        public final float m691getPageSizeD9Ej5fM() {
            return this.pageSize;
        }

        private Fixed(float f) {
            this.pageSize = f;
        }
    }

    int calculateMainAxisPageSize(Density density, int i, int i2);
}
