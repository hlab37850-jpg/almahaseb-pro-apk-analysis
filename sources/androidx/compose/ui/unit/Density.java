package androidx.compose.ui.unit;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Rect;
import defpackage.AbstractC1819bj;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@Immutable
public interface Density {

    public static final class DefaultImpls {
        @Stable
        public static /* synthetic */ void getDensity$annotations() {
        }

        @Stable
        public static /* synthetic */ void getFontScale$annotations() {
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m5146roundToPxR2X_6o(Density density, long j) {
            return AbstractC1819bj.a(density, j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m5147roundToPx0680j_4(Density density, float f) {
            return AbstractC1819bj.b(density, f);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m5148toDpGaN1DYA(Density density, long j) {
            return AbstractC1819bj.c(density, j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m5150toDpu2uoSUM(Density density, int i) {
            return AbstractC1819bj.e(density, i);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m5151toDpSizekrfVVM(Density density, long j) {
            return AbstractC1819bj.f(density, j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m5152toPxR2X_6o(Density density, long j) {
            return AbstractC1819bj.g(density, j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m5153toPx0680j_4(Density density, float f) {
            return AbstractC1819bj.h(density, f);
        }

        @Stable
        @Deprecated
        public static Rect toRect(Density density, DpRect dpRect) {
            AbstractC4492zt.h(dpRect, "$receiver");
            return AbstractC1819bj.i(density, dpRect);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m5154toSizeXkaWNTQ(Density density, long j) {
            return AbstractC1819bj.j(density, j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m5155toSp0xMU5do(Density density, float f) {
            return AbstractC1819bj.k(density, f);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m5157toSpkPz2Gy4(Density density, int i) {
            return AbstractC1819bj.m(density, i);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m5149toDpu2uoSUM(Density density, float f) {
            return AbstractC1819bj.d(density, f);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m5156toSpkPz2Gy4(Density density, float f) {
            return AbstractC1819bj.l(density, f);
        }
    }

    float getDensity();

    float getFontScale();

    @Stable
    /* JADX INFO: renamed from: roundToPx--R2X_6o */
    int mo326roundToPxR2X_6o(long j);

    @Stable
    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    int mo327roundToPx0680j_4(float f);

    @Stable
    /* JADX INFO: renamed from: toDp-GaN1DYA */
    float mo328toDpGaN1DYA(long j);

    @Stable
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    float mo329toDpu2uoSUM(float f);

    @Stable
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    float mo330toDpu2uoSUM(int i);

    @Stable
    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    long mo331toDpSizekrfVVM(long j);

    @Stable
    /* JADX INFO: renamed from: toPx--R2X_6o */
    float mo332toPxR2X_6o(long j);

    @Stable
    /* JADX INFO: renamed from: toPx-0680j_4 */
    float mo333toPx0680j_4(float f);

    @Stable
    Rect toRect(DpRect dpRect);

    @Stable
    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    long mo334toSizeXkaWNTQ(long j);

    @Stable
    /* JADX INFO: renamed from: toSp-0xMU5do */
    long mo335toSp0xMU5do(float f);

    @Stable
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    long mo336toSpkPz2Gy4(float f);

    @Stable
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    long mo337toSpkPz2Gy4(int i);
}
