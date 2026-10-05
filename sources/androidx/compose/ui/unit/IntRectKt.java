package androidx.compose.ui.unit;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.util.MathHelpersKt;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC1210aB;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class IntRectKt {
    @Stable
    /* JADX INFO: renamed from: IntRect-E1MhUcY, reason: not valid java name */
    public static final IntRect m5309IntRectE1MhUcY(long j, long j2) {
        return new IntRect(IntOffset.m5278getXimpl(j), IntOffset.m5279getYimpl(j), IntOffset.m5278getXimpl(j2), IntOffset.m5279getYimpl(j2));
    }

    @Stable
    /* JADX INFO: renamed from: IntRect-VbeCjmY, reason: not valid java name */
    public static final IntRect m5310IntRectVbeCjmY(long j, long j2) {
        return new IntRect(IntOffset.m5278getXimpl(j), IntOffset.m5279getYimpl(j), IntOffset.m5278getXimpl(j) + IntSize.m5320getWidthimpl(j2), IntOffset.m5279getYimpl(j) + IntSize.m5319getHeightimpl(j2));
    }

    @Stable
    /* JADX INFO: renamed from: IntRect-ar5cAso, reason: not valid java name */
    public static final IntRect m5311IntRectar5cAso(long j, int i) {
        return new IntRect(IntOffset.m5278getXimpl(j) - i, IntOffset.m5279getYimpl(j) - i, IntOffset.m5278getXimpl(j) + i, IntOffset.m5279getYimpl(j) + i);
    }

    @Stable
    public static final IntRect lerp(IntRect intRect, IntRect intRect2, float f) {
        AbstractC4492zt.h(intRect, HTML.Attribute.START);
        AbstractC4492zt.h(intRect2, "stop");
        return new IntRect(MathHelpersKt.lerp(intRect.getLeft(), intRect2.getLeft(), f), MathHelpersKt.lerp(intRect.getTop(), intRect2.getTop(), f), MathHelpersKt.lerp(intRect.getRight(), intRect2.getRight(), f), MathHelpersKt.lerp(intRect.getBottom(), intRect2.getBottom(), f));
    }

    @Stable
    public static final IntRect roundToIntRect(Rect rect) {
        AbstractC4492zt.h(rect, "<this>");
        return new IntRect(AbstractC1210aB.c(rect.getLeft()), AbstractC1210aB.c(rect.getTop()), AbstractC1210aB.c(rect.getRight()), AbstractC1210aB.c(rect.getBottom()));
    }

    @Stable
    public static final Rect toRect(IntRect intRect) {
        AbstractC4492zt.h(intRect, "<this>");
        return new Rect(intRect.getLeft(), intRect.getTop(), intRect.getRight(), intRect.getBottom());
    }
}
