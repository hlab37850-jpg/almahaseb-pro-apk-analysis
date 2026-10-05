package androidx.compose.ui.unit;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.SizeKt;

/* JADX INFO: loaded from: classes.dex */
public final class IntSizeKt {
    @Stable
    public static final long IntSize(int i, int i2) {
        return IntSize.m5315constructorimpl((((long) i2) & 4294967295L) | (((long) i) << 32));
    }

    /* JADX INFO: renamed from: getCenter-ozmzZPI, reason: not valid java name */
    public static final long m5326getCenterozmzZPI(long j) {
        return IntOffsetKt.IntOffset(IntSize.m5320getWidthimpl(j) / 2, IntSize.m5319getHeightimpl(j) / 2);
    }

    @Stable
    /* JADX INFO: renamed from: getCenter-ozmzZPI$annotations, reason: not valid java name */
    public static /* synthetic */ void m5327getCenterozmzZPI$annotations(long j) {
    }

    @Stable
    /* JADX INFO: renamed from: times-O0kMr_c, reason: not valid java name */
    public static final long m5328timesO0kMr_c(int i, long j) {
        return IntSize.m5322timesYEO4UFw(j, i);
    }

    @Stable
    /* JADX INFO: renamed from: toIntRect-ozmzZPI, reason: not valid java name */
    public static final IntRect m5329toIntRectozmzZPI(long j) {
        return IntRectKt.m5310IntRectVbeCjmY(IntOffset.Companion.m5288getZeronOccac(), j);
    }

    @Stable
    /* JADX INFO: renamed from: toSize-ozmzZPI, reason: not valid java name */
    public static final long m5330toSizeozmzZPI(long j) {
        return SizeKt.Size(IntSize.m5320getWidthimpl(j), IntSize.m5319getHeightimpl(j));
    }
}
