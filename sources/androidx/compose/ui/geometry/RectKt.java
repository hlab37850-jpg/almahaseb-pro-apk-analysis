package androidx.compose.ui.geometry;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.util.MathHelpersKt;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class RectKt {
    @Stable
    /* JADX INFO: renamed from: Rect-0a9Yr6o, reason: not valid java name */
    public static final Rect m2836Rect0a9Yr6o(long j, long j2) {
        return new Rect(Offset.m2798getXimpl(j), Offset.m2799getYimpl(j), Offset.m2798getXimpl(j2), Offset.m2799getYimpl(j2));
    }

    @Stable
    /* JADX INFO: renamed from: Rect-3MmeM6k, reason: not valid java name */
    public static final Rect m2837Rect3MmeM6k(long j, float f) {
        return new Rect(Offset.m2798getXimpl(j) - f, Offset.m2799getYimpl(j) - f, Offset.m2798getXimpl(j) + f, Offset.m2799getYimpl(j) + f);
    }

    @Stable
    /* JADX INFO: renamed from: Rect-tz77jQw, reason: not valid java name */
    public static final Rect m2838Recttz77jQw(long j, long j2) {
        return new Rect(Offset.m2798getXimpl(j), Offset.m2799getYimpl(j), Offset.m2798getXimpl(j) + Size.m2867getWidthimpl(j2), Offset.m2799getYimpl(j) + Size.m2864getHeightimpl(j2));
    }

    @Stable
    public static final Rect lerp(Rect rect, Rect rect2, float f) {
        AbstractC4492zt.h(rect, HTML.Attribute.START);
        AbstractC4492zt.h(rect2, "stop");
        return new Rect(MathHelpersKt.lerp(rect.getLeft(), rect2.getLeft(), f), MathHelpersKt.lerp(rect.getTop(), rect2.getTop(), f), MathHelpersKt.lerp(rect.getRight(), rect2.getRight(), f), MathHelpersKt.lerp(rect.getBottom(), rect2.getBottom(), f));
    }
}
