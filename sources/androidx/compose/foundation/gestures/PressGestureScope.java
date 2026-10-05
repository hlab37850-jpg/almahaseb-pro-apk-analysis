package androidx.compose.foundation.gestures;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import defpackage.AbstractC1819bj;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0793Of;

/* JADX INFO: loaded from: classes.dex */
public interface PressGestureScope extends Density {

    public static final class DefaultImpls {
        @Stable
        @Deprecated
        /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m314roundToPxR2X_6o(PressGestureScope pressGestureScope, long j) {
            return AbstractC1819bj.a(pressGestureScope, j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m315roundToPx0680j_4(PressGestureScope pressGestureScope, float f) {
            return AbstractC1819bj.b(pressGestureScope, f);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m316toDpGaN1DYA(PressGestureScope pressGestureScope, long j) {
            return AbstractC1819bj.c(pressGestureScope, j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m317toDpu2uoSUM(PressGestureScope pressGestureScope, float f) {
            return AbstractC1819bj.d(pressGestureScope, f);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m319toDpSizekrfVVM(PressGestureScope pressGestureScope, long j) {
            return AbstractC1819bj.f(pressGestureScope, j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m320toPxR2X_6o(PressGestureScope pressGestureScope, long j) {
            return AbstractC1819bj.g(pressGestureScope, j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m321toPx0680j_4(PressGestureScope pressGestureScope, float f) {
            return AbstractC1819bj.h(pressGestureScope, f);
        }

        @Stable
        @Deprecated
        public static Rect toRect(PressGestureScope pressGestureScope, DpRect dpRect) {
            AbstractC4492zt.h(dpRect, "$receiver");
            return AbstractC1819bj.i(pressGestureScope, dpRect);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m322toSizeXkaWNTQ(PressGestureScope pressGestureScope, long j) {
            return AbstractC1819bj.j(pressGestureScope, j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m323toSp0xMU5do(PressGestureScope pressGestureScope, float f) {
            return AbstractC1819bj.k(pressGestureScope, f);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m324toSpkPz2Gy4(PressGestureScope pressGestureScope, float f) {
            return AbstractC1819bj.l(pressGestureScope, f);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m318toDpu2uoSUM(PressGestureScope pressGestureScope, int i) {
            return AbstractC1819bj.e(pressGestureScope, i);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m325toSpkPz2Gy4(PressGestureScope pressGestureScope, int i) {
            return AbstractC1819bj.m(pressGestureScope, i);
        }
    }

    Object awaitRelease(InterfaceC0793Of interfaceC0793Of);

    Object tryAwaitRelease(InterfaceC0793Of interfaceC0793Of);
}
