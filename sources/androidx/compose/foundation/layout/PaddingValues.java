package androidx.compose.foundation.layout;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@Stable
public interface PaddingValues {

    @Immutable
    public static final class Absolute implements PaddingValues {
        public static final int $stable = 0;
        private final float bottom;
        private final float left;
        private final float right;
        private final float top;

        public /* synthetic */ Absolute(float f, float f2, float f3, float f4, AbstractC0419Di abstractC0419Di) {
            this(f, f2, f3, f4);
        }

        @Stable
        /* JADX INFO: renamed from: getBottom-D9Ej5fM$annotations, reason: not valid java name */
        private static /* synthetic */ void m498getBottomD9Ej5fM$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getLeft-D9Ej5fM$annotations, reason: not valid java name */
        private static /* synthetic */ void m499getLeftD9Ej5fM$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getRight-D9Ej5fM$annotations, reason: not valid java name */
        private static /* synthetic */ void m500getRightD9Ej5fM$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getTop-D9Ej5fM$annotations, reason: not valid java name */
        private static /* synthetic */ void m501getTopD9Ej5fM$annotations() {
        }

        @Override // androidx.compose.foundation.layout.PaddingValues
        /* JADX INFO: renamed from: calculateBottomPadding-D9Ej5fM */
        public float mo435calculateBottomPaddingD9Ej5fM() {
            return this.bottom;
        }

        @Override // androidx.compose.foundation.layout.PaddingValues
        /* JADX INFO: renamed from: calculateLeftPadding-u2uoSUM */
        public float mo436calculateLeftPaddingu2uoSUM(LayoutDirection layoutDirection) {
            AbstractC4492zt.h(layoutDirection, "layoutDirection");
            return this.left;
        }

        @Override // androidx.compose.foundation.layout.PaddingValues
        /* JADX INFO: renamed from: calculateRightPadding-u2uoSUM */
        public float mo437calculateRightPaddingu2uoSUM(LayoutDirection layoutDirection) {
            AbstractC4492zt.h(layoutDirection, "layoutDirection");
            return this.right;
        }

        @Override // androidx.compose.foundation.layout.PaddingValues
        /* JADX INFO: renamed from: calculateTopPadding-D9Ej5fM */
        public float mo438calculateTopPaddingD9Ej5fM() {
            return this.top;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Absolute)) {
                return false;
            }
            Absolute absolute = (Absolute) obj;
            return Dp.m5165equalsimpl0(this.left, absolute.left) && Dp.m5165equalsimpl0(this.top, absolute.top) && Dp.m5165equalsimpl0(this.right, absolute.right) && Dp.m5165equalsimpl0(this.bottom, absolute.bottom);
        }

        public int hashCode() {
            return (((((Dp.m5166hashCodeimpl(this.left) * 31) + Dp.m5166hashCodeimpl(this.top)) * 31) + Dp.m5166hashCodeimpl(this.right)) * 31) + Dp.m5166hashCodeimpl(this.bottom);
        }

        public String toString() {
            return "PaddingValues.Absolute(left=" + ((Object) Dp.m5171toStringimpl(this.left)) + ", top=" + ((Object) Dp.m5171toStringimpl(this.top)) + ", right=" + ((Object) Dp.m5171toStringimpl(this.right)) + ", bottom=" + ((Object) Dp.m5171toStringimpl(this.bottom)) + ')';
        }

        private Absolute(float f, float f2, float f3, float f4) {
            this.left = f;
            this.top = f2;
            this.right = f3;
            this.bottom = f4;
        }

        public /* synthetic */ Absolute(float f, float f2, float f3, float f4, int i, AbstractC0419Di abstractC0419Di) {
            this((i & 1) != 0 ? Dp.m5160constructorimpl(0) : f, (i & 2) != 0 ? Dp.m5160constructorimpl(0) : f2, (i & 4) != 0 ? Dp.m5160constructorimpl(0) : f3, (i & 8) != 0 ? Dp.m5160constructorimpl(0) : f4, null);
        }
    }

    /* JADX INFO: renamed from: calculateBottomPadding-D9Ej5fM */
    float mo435calculateBottomPaddingD9Ej5fM();

    /* JADX INFO: renamed from: calculateLeftPadding-u2uoSUM */
    float mo436calculateLeftPaddingu2uoSUM(LayoutDirection layoutDirection);

    /* JADX INFO: renamed from: calculateRightPadding-u2uoSUM */
    float mo437calculateRightPaddingu2uoSUM(LayoutDirection layoutDirection);

    /* JADX INFO: renamed from: calculateTopPadding-D9Ej5fM */
    float mo438calculateTopPaddingD9Ej5fM();
}
