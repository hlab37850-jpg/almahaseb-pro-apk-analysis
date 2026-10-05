package androidx.compose.ui.window;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;
import org.apache.poi.ss.util.CellUtil;

/* JADX INFO: loaded from: classes.dex */
public final class AlignmentOffsetPositionProvider implements PopupPositionProvider {
    private final Alignment alignment;
    private final long offset;

    public /* synthetic */ AlignmentOffsetPositionProvider(Alignment alignment, long j, AbstractC0419Di abstractC0419Di) {
        this(alignment, j);
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    /* JADX INFO: renamed from: calculatePosition-llwVHH4 */
    public long mo883calculatePositionllwVHH4(IntRect intRect, long j, LayoutDirection layoutDirection, long j2) {
        AbstractC4492zt.h(intRect, "anchorBounds");
        AbstractC4492zt.h(layoutDirection, "layoutDirection");
        long jIntOffset = IntOffsetKt.IntOffset(0, 0);
        Alignment alignment = this.alignment;
        IntSize.Companion companion = IntSize.Companion;
        long jMo2684alignKFBX0sM = alignment.mo2684alignKFBX0sM(companion.m5325getZeroYbymL2g(), IntSizeKt.IntSize(intRect.getWidth(), intRect.getHeight()), layoutDirection);
        long jMo2684alignKFBX0sM2 = this.alignment.mo2684alignKFBX0sM(companion.m5325getZeroYbymL2g(), IntSizeKt.IntSize(IntSize.m5320getWidthimpl(j2), IntSize.m5319getHeightimpl(j2)), layoutDirection);
        long jIntOffset2 = IntOffsetKt.IntOffset(intRect.getLeft(), intRect.getTop());
        long jIntOffset3 = IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(jIntOffset) + IntOffset.m5278getXimpl(jIntOffset2), IntOffset.m5279getYimpl(jIntOffset) + IntOffset.m5279getYimpl(jIntOffset2));
        long jIntOffset4 = IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(jIntOffset3) + IntOffset.m5278getXimpl(jMo2684alignKFBX0sM), IntOffset.m5279getYimpl(jIntOffset3) + IntOffset.m5279getYimpl(jMo2684alignKFBX0sM));
        long jIntOffset5 = IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(jMo2684alignKFBX0sM2), IntOffset.m5279getYimpl(jMo2684alignKFBX0sM2));
        long jIntOffset6 = IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(jIntOffset4) - IntOffset.m5278getXimpl(jIntOffset5), IntOffset.m5279getYimpl(jIntOffset4) - IntOffset.m5279getYimpl(jIntOffset5));
        long jIntOffset7 = IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(this.offset) * (layoutDirection == LayoutDirection.Ltr ? 1 : -1), IntOffset.m5279getYimpl(this.offset));
        return IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(jIntOffset6) + IntOffset.m5278getXimpl(jIntOffset7), IntOffset.m5279getYimpl(jIntOffset6) + IntOffset.m5279getYimpl(jIntOffset7));
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }

    /* JADX INFO: renamed from: getOffset-nOcc-ac, reason: not valid java name */
    public final long m5405getOffsetnOccac() {
        return this.offset;
    }

    private AlignmentOffsetPositionProvider(Alignment alignment, long j) {
        AbstractC4492zt.h(alignment, CellUtil.ALIGNMENT);
        this.alignment = alignment;
        this.offset = j;
    }
}
