package androidx.compose.foundation.pager;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.unit.IntSize;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class PagerLayoutInfoKt {
    public static final int getMainAxisViewportSize(PagerLayoutInfo pagerLayoutInfo) {
        AbstractC4492zt.h(pagerLayoutInfo, "<this>");
        return pagerLayoutInfo.getOrientation() == Orientation.Vertical ? IntSize.m5319getHeightimpl(pagerLayoutInfo.mo697getViewportSizeYbymL2g()) : IntSize.m5320getWidthimpl(pagerLayoutInfo.mo697getViewportSizeYbymL2g());
    }

    @ExperimentalFoundationApi
    public static /* synthetic */ void getMainAxisViewportSize$annotations(PagerLayoutInfo pagerLayoutInfo) {
    }
}
