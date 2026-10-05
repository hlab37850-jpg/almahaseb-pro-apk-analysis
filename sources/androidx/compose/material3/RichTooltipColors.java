package androidx.compose.material3;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.graphics.Color;
import defpackage.AbstractC0419Di;

/* JADX INFO: loaded from: classes.dex */
@Stable
@Immutable
@ExperimentalMaterial3Api
public final class RichTooltipColors {
    public static final int $stable = 0;
    private final long actionContentColor;
    private final long containerColor;
    private final long contentColor;
    private final long titleContentColor;

    public /* synthetic */ RichTooltipColors(long j, long j2, long j3, long j4, AbstractC0419Di abstractC0419Di) {
        this(j, j2, j3, j4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RichTooltipColors)) {
            return false;
        }
        RichTooltipColors richTooltipColors = (RichTooltipColors) obj;
        return Color.m3033equalsimpl0(this.containerColor, richTooltipColors.containerColor) && Color.m3033equalsimpl0(this.contentColor, richTooltipColors.contentColor) && Color.m3033equalsimpl0(this.titleContentColor, richTooltipColors.titleContentColor) && Color.m3033equalsimpl0(this.actionContentColor, richTooltipColors.actionContentColor);
    }

    /* JADX INFO: renamed from: getActionContentColor-0d7_KjU, reason: not valid java name */
    public final long m1721getActionContentColor0d7_KjU() {
        return this.actionContentColor;
    }

    /* JADX INFO: renamed from: getContainerColor-0d7_KjU, reason: not valid java name */
    public final long m1722getContainerColor0d7_KjU() {
        return this.containerColor;
    }

    /* JADX INFO: renamed from: getContentColor-0d7_KjU, reason: not valid java name */
    public final long m1723getContentColor0d7_KjU() {
        return this.contentColor;
    }

    /* JADX INFO: renamed from: getTitleContentColor-0d7_KjU, reason: not valid java name */
    public final long m1724getTitleContentColor0d7_KjU() {
        return this.titleContentColor;
    }

    public int hashCode() {
        return (((((Color.m3039hashCodeimpl(this.containerColor) * 31) + Color.m3039hashCodeimpl(this.contentColor)) * 31) + Color.m3039hashCodeimpl(this.titleContentColor)) * 31) + Color.m3039hashCodeimpl(this.actionContentColor);
    }

    private RichTooltipColors(long j, long j2, long j3, long j4) {
        this.containerColor = j;
        this.contentColor = j2;
        this.titleContentColor = j3;
        this.actionContentColor = j4;
    }
}
