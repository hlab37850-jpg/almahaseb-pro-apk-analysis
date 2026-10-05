package androidx.compose.foundation.shape;

import androidx.compose.runtime.Stable;

/* JADX INFO: loaded from: classes.dex */
public final class CornerSizeKt {
    private static final CornerSize ZeroCornerSize = new CornerSizeKt$ZeroCornerSize$1();

    @Stable
    public static final CornerSize CornerSize(float f) {
        return new PxCornerSize(f);
    }

    @Stable
    /* JADX INFO: renamed from: CornerSize-0680j_4, reason: not valid java name */
    public static final CornerSize m729CornerSize0680j_4(float f) {
        return new DpCornerSize(f, null);
    }

    public static final CornerSize getZeroCornerSize() {
        return ZeroCornerSize;
    }

    @Stable
    public static /* synthetic */ void getZeroCornerSize$annotations() {
    }

    @Stable
    public static final CornerSize CornerSize(int i) {
        return new PercentCornerSize(i);
    }
}
