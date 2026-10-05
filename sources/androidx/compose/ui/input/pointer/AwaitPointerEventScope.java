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
import defpackage.J6;

/* JADX INFO: loaded from: classes.dex */
public interface AwaitPointerEventScope extends Density {

    public static final class DefaultImpls {
        @Deprecated
        /* JADX INFO: renamed from: getExtendedTouchPadding-NH-jbRc, reason: not valid java name */
        public static long m3968getExtendedTouchPaddingNHjbRc(AwaitPointerEventScope awaitPointerEventScope) {
            return J6.a(awaitPointerEventScope);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m3969roundToPxR2X_6o(AwaitPointerEventScope awaitPointerEventScope, long j) {
            return AbstractC1819bj.a(awaitPointerEventScope, j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m3970roundToPx0680j_4(AwaitPointerEventScope awaitPointerEventScope, float f) {
            return AbstractC1819bj.b(awaitPointerEventScope, f);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m3971toDpGaN1DYA(AwaitPointerEventScope awaitPointerEventScope, long j) {
            return AbstractC1819bj.c(awaitPointerEventScope, j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m3972toDpu2uoSUM(AwaitPointerEventScope awaitPointerEventScope, float f) {
            return AbstractC1819bj.d(awaitPointerEventScope, f);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m3974toDpSizekrfVVM(AwaitPointerEventScope awaitPointerEventScope, long j) {
            return AbstractC1819bj.f(awaitPointerEventScope, j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m3975toPxR2X_6o(AwaitPointerEventScope awaitPointerEventScope, long j) {
            return AbstractC1819bj.g(awaitPointerEventScope, j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m3976toPx0680j_4(AwaitPointerEventScope awaitPointerEventScope, float f) {
            return AbstractC1819bj.h(awaitPointerEventScope, f);
        }

        @Stable
        @Deprecated
        public static Rect toRect(AwaitPointerEventScope awaitPointerEventScope, DpRect dpRect) {
            AbstractC4492zt.h(dpRect, "$receiver");
            return AbstractC1819bj.i(awaitPointerEventScope, dpRect);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m3977toSizeXkaWNTQ(AwaitPointerEventScope awaitPointerEventScope, long j) {
            return AbstractC1819bj.j(awaitPointerEventScope, j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m3978toSp0xMU5do(AwaitPointerEventScope awaitPointerEventScope, float f) {
            return AbstractC1819bj.k(awaitPointerEventScope, f);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m3979toSpkPz2Gy4(AwaitPointerEventScope awaitPointerEventScope, float f) {
            return AbstractC1819bj.l(awaitPointerEventScope, f);
        }

        @Deprecated
        public static <T> Object withTimeout(AwaitPointerEventScope awaitPointerEventScope, long j, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of) {
            return J6.b(awaitPointerEventScope, j, interfaceC0526Fp, interfaceC0793Of);
        }

        @Deprecated
        public static <T> Object withTimeoutOrNull(AwaitPointerEventScope awaitPointerEventScope, long j, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of) {
            return J6.c(awaitPointerEventScope, j, interfaceC0526Fp, interfaceC0793Of);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m3973toDpu2uoSUM(AwaitPointerEventScope awaitPointerEventScope, int i) {
            return AbstractC1819bj.e(awaitPointerEventScope, i);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m3980toSpkPz2Gy4(AwaitPointerEventScope awaitPointerEventScope, int i) {
            return AbstractC1819bj.m(awaitPointerEventScope, i);
        }
    }

    Object awaitPointerEvent(PointerEventPass pointerEventPass, InterfaceC0793Of interfaceC0793Of);

    PointerEvent getCurrentEvent();

    /* JADX INFO: renamed from: getExtendedTouchPadding-NH-jbRc, reason: not valid java name */
    long mo3966getExtendedTouchPaddingNHjbRc();

    /* JADX INFO: renamed from: getSize-YbymL2g, reason: not valid java name */
    long mo3967getSizeYbymL2g();

    ViewConfiguration getViewConfiguration();

    <T> Object withTimeout(long j, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of);

    <T> Object withTimeoutOrNull(long j, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of);
}
