package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import defpackage.AbstractC4079uv;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface LazyListLayoutInfo {

    public static final class DefaultImpls {
        @Deprecated
        public static int getAfterContentPadding(LazyListLayoutInfo lazyListLayoutInfo) {
            return AbstractC4079uv.a(lazyListLayoutInfo);
        }

        @Deprecated
        public static int getBeforeContentPadding(LazyListLayoutInfo lazyListLayoutInfo) {
            return AbstractC4079uv.b(lazyListLayoutInfo);
        }

        @Deprecated
        public static int getMainAxisItemSpacing(LazyListLayoutInfo lazyListLayoutInfo) {
            return AbstractC4079uv.c(lazyListLayoutInfo);
        }

        @Deprecated
        public static Orientation getOrientation(LazyListLayoutInfo lazyListLayoutInfo) {
            return AbstractC4079uv.d(lazyListLayoutInfo);
        }

        @Deprecated
        public static boolean getReverseLayout(LazyListLayoutInfo lazyListLayoutInfo) {
            return AbstractC4079uv.e(lazyListLayoutInfo);
        }

        @Deprecated
        /* JADX INFO: renamed from: getViewportSize-YbymL2g, reason: not valid java name */
        public static long m589getViewportSizeYbymL2g(LazyListLayoutInfo lazyListLayoutInfo) {
            return AbstractC4079uv.f(lazyListLayoutInfo);
        }
    }

    int getAfterContentPadding();

    int getBeforeContentPadding();

    int getMainAxisItemSpacing();

    Orientation getOrientation();

    boolean getReverseLayout();

    int getTotalItemsCount();

    int getViewportEndOffset();

    /* JADX INFO: renamed from: getViewportSize-YbymL2g */
    long mo587getViewportSizeYbymL2g();

    int getViewportStartOffset();

    List<LazyListItemInfo> getVisibleItemsInfo();
}
