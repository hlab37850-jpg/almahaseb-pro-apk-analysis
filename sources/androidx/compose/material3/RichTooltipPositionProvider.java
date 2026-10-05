package androidx.compose.material3;

import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
final class RichTooltipPositionProvider implements PopupPositionProvider {
    private final int tooltipAnchorPadding;

    public RichTooltipPositionProvider(int i) {
        this.tooltipAnchorPadding = i;
    }

    public static /* synthetic */ RichTooltipPositionProvider copy$default(RichTooltipPositionProvider richTooltipPositionProvider, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = richTooltipPositionProvider.tooltipAnchorPadding;
        }
        return richTooltipPositionProvider.copy(i);
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    /* JADX INFO: renamed from: calculatePosition-llwVHH4 */
    public long mo883calculatePositionllwVHH4(IntRect intRect, long j, LayoutDirection layoutDirection, long j2) {
        AbstractC4492zt.h(intRect, "anchorBounds");
        AbstractC4492zt.h(layoutDirection, "layoutDirection");
        int right = intRect.getRight();
        if (IntSize.m5320getWidthimpl(j2) + right > IntSize.m5320getWidthimpl(j) && (right = intRect.getLeft() - IntSize.m5320getWidthimpl(j2)) < 0) {
            right = intRect.getLeft() + ((intRect.getWidth() - IntSize.m5320getWidthimpl(j2)) / 2);
        }
        int top = (intRect.getTop() - IntSize.m5319getHeightimpl(j2)) - this.tooltipAnchorPadding;
        if (top < 0) {
            top = this.tooltipAnchorPadding + intRect.getBottom();
        }
        return IntOffsetKt.IntOffset(right, top);
    }

    public final int component1() {
        return this.tooltipAnchorPadding;
    }

    public final RichTooltipPositionProvider copy(int i) {
        return new RichTooltipPositionProvider(i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RichTooltipPositionProvider) && this.tooltipAnchorPadding == ((RichTooltipPositionProvider) obj).tooltipAnchorPadding;
    }

    public final int getTooltipAnchorPadding() {
        return this.tooltipAnchorPadding;
    }

    public int hashCode() {
        return this.tooltipAnchorPadding;
    }

    public String toString() {
        return "RichTooltipPositionProvider(tooltipAnchorPadding=" + this.tooltipAnchorPadding + ')';
    }
}
