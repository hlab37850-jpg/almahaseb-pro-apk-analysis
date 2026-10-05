package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import defpackage.AbstractC1819bj;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.SG;

/* JADX INFO: loaded from: classes.dex */
public interface PointerInputScope extends Density {

    public static final class DefaultImpls {
        @Deprecated
        /* JADX INFO: renamed from: getExtendedTouchPadding-NH-jbRc, reason: not valid java name */
        public static long m4078getExtendedTouchPaddingNHjbRc(PointerInputScope pointerInputScope) {
            return SG.a(pointerInputScope);
        }

        @Deprecated
        public static boolean getInterceptOutOfBoundsChildEvents(PointerInputScope pointerInputScope) {
            return SG.b(pointerInputScope);
        }

        public static /* synthetic */ void getInterceptOutOfBoundsChildEvents$annotations() {
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m4079roundToPxR2X_6o(PointerInputScope pointerInputScope, long j) {
            return AbstractC1819bj.a(pointerInputScope, j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m4080roundToPx0680j_4(PointerInputScope pointerInputScope, float f) {
            return AbstractC1819bj.b(pointerInputScope, f);
        }

        @Deprecated
        public static void setInterceptOutOfBoundsChildEvents(PointerInputScope pointerInputScope, boolean z) {
            SG.c(pointerInputScope, z);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m4081toDpGaN1DYA(PointerInputScope pointerInputScope, long j) {
            return AbstractC1819bj.c(pointerInputScope, j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m4082toDpu2uoSUM(PointerInputScope pointerInputScope, float f) {
            return AbstractC1819bj.d(pointerInputScope, f);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m4084toDpSizekrfVVM(PointerInputScope pointerInputScope, long j) {
            return AbstractC1819bj.f(pointerInputScope, j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m4085toPxR2X_6o(PointerInputScope pointerInputScope, long j) {
            return AbstractC1819bj.g(pointerInputScope, j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m4086toPx0680j_4(PointerInputScope pointerInputScope, float f) {
            return AbstractC1819bj.h(pointerInputScope, f);
        }

        @Stable
        @Deprecated
        public static Rect toRect(PointerInputScope pointerInputScope, DpRect dpRect) {
            AbstractC4492zt.h(dpRect, "$receiver");
            return AbstractC1819bj.i(pointerInputScope, dpRect);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m4087toSizeXkaWNTQ(PointerInputScope pointerInputScope, long j) {
            return AbstractC1819bj.j(pointerInputScope, j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m4088toSp0xMU5do(PointerInputScope pointerInputScope, float f) {
            return AbstractC1819bj.k(pointerInputScope, f);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m4089toSpkPz2Gy4(PointerInputScope pointerInputScope, float f) {
            return AbstractC1819bj.l(pointerInputScope, f);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m4083toDpu2uoSUM(PointerInputScope pointerInputScope, int i) {
            return AbstractC1819bj.e(pointerInputScope, i);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m4090toSpkPz2Gy4(PointerInputScope pointerInputScope, int i) {
            return AbstractC1819bj.m(pointerInputScope, i);
        }
    }

    <R> Object awaitPointerEventScope(InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of);

    /* JADX INFO: renamed from: getExtendedTouchPadding-NH-jbRc, reason: not valid java name */
    long mo4076getExtendedTouchPaddingNHjbRc();

    boolean getInterceptOutOfBoundsChildEvents();

    /* JADX INFO: renamed from: getSize-YbymL2g, reason: not valid java name */
    long mo4077getSizeYbymL2g();

    ViewConfiguration getViewConfiguration();

    void setInterceptOutOfBoundsChildEvents(boolean z);
}
