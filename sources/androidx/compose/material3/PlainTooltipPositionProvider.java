package androidx.compose.material3;

import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
final class PlainTooltipPositionProvider implements PopupPositionProvider {
    private final int tooltipAnchorPadding;

    public PlainTooltipPositionProvider(int i) {
        this.tooltipAnchorPadding = i;
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    /* JADX INFO: renamed from: calculatePosition-llwVHH4 */
    public long mo883calculatePositionllwVHH4(IntRect intRect, long j, LayoutDirection layoutDirection, long j2) {
        AbstractC4492zt.h(intRect, "anchorBounds");
        AbstractC4492zt.h(layoutDirection, "layoutDirection");
        int left = intRect.getLeft() + ((intRect.getWidth() - IntSize.m5320getWidthimpl(j2)) / 2);
        int top = (intRect.getTop() - IntSize.m5319getHeightimpl(j2)) - this.tooltipAnchorPadding;
        if (top < 0) {
            top = this.tooltipAnchorPadding + intRect.getBottom();
        }
        return IntOffsetKt.IntOffset(left, top);
    }

    public final int getTooltipAnchorPadding() {
        return this.tooltipAnchorPadding;
    }
}
