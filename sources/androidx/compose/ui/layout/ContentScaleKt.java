package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Size;

/* JADX INFO: loaded from: classes.dex */
public final class ContentScaleKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: computeFillHeight-iLBOSCw, reason: not valid java name */
    public static final float m4155computeFillHeightiLBOSCw(long j, long j2) {
        return Size.m2864getHeightimpl(j2) / Size.m2864getHeightimpl(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: computeFillMaxDimension-iLBOSCw, reason: not valid java name */
    public static final float m4156computeFillMaxDimensioniLBOSCw(long j, long j2) {
        return Math.max(m4158computeFillWidthiLBOSCw(j, j2), m4155computeFillHeightiLBOSCw(j, j2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: computeFillMinDimension-iLBOSCw, reason: not valid java name */
    public static final float m4157computeFillMinDimensioniLBOSCw(long j, long j2) {
        return Math.min(m4158computeFillWidthiLBOSCw(j, j2), m4155computeFillHeightiLBOSCw(j, j2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: computeFillWidth-iLBOSCw, reason: not valid java name */
    public static final float m4158computeFillWidthiLBOSCw(long j, long j2) {
        return Size.m2867getWidthimpl(j2) / Size.m2867getWidthimpl(j);
    }
}
