package androidx.compose.ui.graphics.drawscope;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.unit.DpRect;
import defpackage.AbstractC1819bj;
import defpackage.AbstractC3255kk;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public interface ContentDrawScope extends DrawScope {

    public static final class DefaultImpls {
        @Deprecated
        /* JADX INFO: renamed from: drawImage-AZ2fEMs, reason: not valid java name */
        public static void m3484drawImageAZ2fEMs(ContentDrawScope contentDrawScope, ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2) {
            AbstractC4492zt.h(imageBitmap, "image");
            AbstractC4492zt.h(drawStyle, "style");
            AbstractC3255kk.a(contentDrawScope, imageBitmap, j, j2, j3, j4, f, drawStyle, colorFilter, i, i2);
        }

        @Deprecated
        /* JADX INFO: renamed from: getCenter-F1C5BW0, reason: not valid java name */
        public static long m3485getCenterF1C5BW0(ContentDrawScope contentDrawScope) {
            return AbstractC3255kk.b(contentDrawScope);
        }

        @Deprecated
        /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
        public static long m3486getSizeNHjbRc(ContentDrawScope contentDrawScope) {
            return AbstractC3255kk.c(contentDrawScope);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m3487roundToPxR2X_6o(ContentDrawScope contentDrawScope, long j) {
            return AbstractC1819bj.a(contentDrawScope, j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m3488roundToPx0680j_4(ContentDrawScope contentDrawScope, float f) {
            return AbstractC1819bj.b(contentDrawScope, f);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m3489toDpGaN1DYA(ContentDrawScope contentDrawScope, long j) {
            return AbstractC1819bj.c(contentDrawScope, j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m3490toDpu2uoSUM(ContentDrawScope contentDrawScope, float f) {
            return AbstractC1819bj.d(contentDrawScope, f);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m3492toDpSizekrfVVM(ContentDrawScope contentDrawScope, long j) {
            return AbstractC1819bj.f(contentDrawScope, j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m3493toPxR2X_6o(ContentDrawScope contentDrawScope, long j) {
            return AbstractC1819bj.g(contentDrawScope, j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m3494toPx0680j_4(ContentDrawScope contentDrawScope, float f) {
            return AbstractC1819bj.h(contentDrawScope, f);
        }

        @Stable
        @Deprecated
        public static Rect toRect(ContentDrawScope contentDrawScope, DpRect dpRect) {
            AbstractC4492zt.h(dpRect, "$receiver");
            return AbstractC1819bj.i(contentDrawScope, dpRect);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m3495toSizeXkaWNTQ(ContentDrawScope contentDrawScope, long j) {
            return AbstractC1819bj.j(contentDrawScope, j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m3496toSp0xMU5do(ContentDrawScope contentDrawScope, float f) {
            return AbstractC1819bj.k(contentDrawScope, f);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m3497toSpkPz2Gy4(ContentDrawScope contentDrawScope, float f) {
            return AbstractC1819bj.l(contentDrawScope, f);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m3491toDpu2uoSUM(ContentDrawScope contentDrawScope, int i) {
            return AbstractC1819bj.e(contentDrawScope, i);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m3498toSpkPz2Gy4(ContentDrawScope contentDrawScope, int i) {
            return AbstractC1819bj.m(contentDrawScope, i);
        }
    }

    void drawContent();
}
