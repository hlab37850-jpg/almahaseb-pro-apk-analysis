package androidx.compose.foundation.pager;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.gestures.Orientation;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalFoundationApi
public interface PagerLayoutInfo {
    int getAfterContentPadding();

    int getBeforeContentPadding();

    PageInfo getClosestPageToSnapPosition();

    Orientation getOrientation();

    int getPageSize();

    int getPageSpacing();

    int getPagesCount();

    boolean getReverseLayout();

    int getViewportEndOffset();

    /* JADX INFO: renamed from: getViewportSize-YbymL2g, reason: not valid java name */
    long mo697getViewportSizeYbymL2g();

    int getViewportStartOffset();

    List<PageInfo> getVisiblePagesInfo();
}
