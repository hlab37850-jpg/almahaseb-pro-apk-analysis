package androidx.compose.foundation.text.selection;

import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import defpackage.AD;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class HandlePositionProvider implements PopupPositionProvider {
    private final HandleReferencePoint handleReferencePoint;
    private final long offset;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HandleReferencePoint.values().length];
            try {
                iArr[HandleReferencePoint.TopLeft.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HandleReferencePoint.TopRight.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[HandleReferencePoint.TopMiddle.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ HandlePositionProvider(HandleReferencePoint handleReferencePoint, long j, AbstractC0419Di abstractC0419Di) {
        this(handleReferencePoint, j);
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    /* JADX INFO: renamed from: calculatePosition-llwVHH4, reason: not valid java name */
    public long mo883calculatePositionllwVHH4(IntRect intRect, long j, LayoutDirection layoutDirection, long j2) {
        AbstractC4492zt.h(intRect, "anchorBounds");
        AbstractC4492zt.h(layoutDirection, "layoutDirection");
        int i = WhenMappings.$EnumSwitchMapping$0[this.handleReferencePoint.ordinal()];
        if (i == 1) {
            return IntOffsetKt.IntOffset(intRect.getLeft() + IntOffset.m5278getXimpl(this.offset), intRect.getTop() + IntOffset.m5279getYimpl(this.offset));
        }
        if (i == 2) {
            return IntOffsetKt.IntOffset((intRect.getLeft() + IntOffset.m5278getXimpl(this.offset)) - IntSize.m5320getWidthimpl(j2), intRect.getTop() + IntOffset.m5279getYimpl(this.offset));
        }
        if (i == 3) {
            return IntOffsetKt.IntOffset((intRect.getLeft() + IntOffset.m5278getXimpl(this.offset)) - (IntSize.m5320getWidthimpl(j2) / 2), intRect.getTop() + IntOffset.m5279getYimpl(this.offset));
        }
        throw new AD();
    }

    private HandlePositionProvider(HandleReferencePoint handleReferencePoint, long j) {
        AbstractC4492zt.h(handleReferencePoint, "handleReferencePoint");
        this.handleReferencePoint = handleReferencePoint;
        this.offset = j;
    }
}
