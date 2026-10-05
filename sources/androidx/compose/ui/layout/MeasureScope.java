package androidx.compose.ui.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.LayoutDirection;
import defpackage.AbstractC1819bj;
import defpackage.AbstractC4243wx;
import defpackage.AbstractC4411yt;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface MeasureScope extends IntrinsicMeasureScope {

    /* JADX INFO: renamed from: androidx.compose.ui.layout.MeasureScope$-CC, reason: invalid class name */
    public abstract /* synthetic */ class CC {
        public static MeasureResult a(MeasureScope measureScope, int i, int i2, Map map, InterfaceC3750qp interfaceC3750qp) {
            AbstractC4492zt.h(map, "alignmentLines");
            AbstractC4492zt.h(interfaceC3750qp, "placementBlock");
            return new MeasureResult(i, i2, map, measureScope, interfaceC3750qp) { // from class: androidx.compose.ui.layout.MeasureScope.layout.1
                final /* synthetic */ InterfaceC3750qp $placementBlock;
                final /* synthetic */ int $width;
                private final Map<AlignmentLine, Integer> alignmentLines;
                private final int height;
                final /* synthetic */ MeasureScope this$0;
                private final int width;

                {
                    this.$width = i;
                    this.this$0 = measureScope;
                    this.$placementBlock = interfaceC3750qp;
                    this.width = i;
                    this.height = i2;
                    this.alignmentLines = map;
                }

                @Override // androidx.compose.ui.layout.MeasureResult
                public Map<AlignmentLine, Integer> getAlignmentLines() {
                    return this.alignmentLines;
                }

                @Override // androidx.compose.ui.layout.MeasureResult
                public int getHeight() {
                    return this.height;
                }

                @Override // androidx.compose.ui.layout.MeasureResult
                public int getWidth() {
                    return this.width;
                }

                @Override // androidx.compose.ui.layout.MeasureResult
                public void placeChildren() {
                    Placeable.PlacementScope.Companion companion = Placeable.PlacementScope.Companion;
                    int i3 = this.$width;
                    LayoutDirection layoutDirection = this.this$0.getLayoutDirection();
                    MeasureScope measureScope2 = this.this$0;
                    LookaheadCapablePlaceable lookaheadCapablePlaceable = measureScope2 instanceof LookaheadCapablePlaceable ? (LookaheadCapablePlaceable) measureScope2 : null;
                    InterfaceC3750qp interfaceC3750qp2 = this.$placementBlock;
                    LayoutCoordinates layoutCoordinates = Placeable.PlacementScope._coordinates;
                    int parentWidth = companion.getParentWidth();
                    LayoutDirection parentLayoutDirection = companion.getParentLayoutDirection();
                    LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = Placeable.PlacementScope.layoutDelegate;
                    Placeable.PlacementScope.parentWidth = i3;
                    Placeable.PlacementScope.parentLayoutDirection = layoutDirection;
                    boolean zConfigureForPlacingForAlignment = companion.configureForPlacingForAlignment(lookaheadCapablePlaceable);
                    interfaceC3750qp2.invoke(companion);
                    if (lookaheadCapablePlaceable != null) {
                        lookaheadCapablePlaceable.setPlacingForAlignment$ui_release(zConfigureForPlacingForAlignment);
                    }
                    Placeable.PlacementScope.parentWidth = parentWidth;
                    Placeable.PlacementScope.parentLayoutDirection = parentLayoutDirection;
                    Placeable.PlacementScope._coordinates = layoutCoordinates;
                    Placeable.PlacementScope.layoutDelegate = layoutNodeLayoutDelegate;
                }
            };
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MeasureResult q(MeasureScope measureScope, int i, int i2, Map map, InterfaceC3750qp interfaceC3750qp, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: layout");
            }
            if ((i3 & 4) != 0) {
                map = AbstractC4243wx.g();
            }
            return measureScope.layout(i, i2, map, interfaceC3750qp);
        }
    }

    public static final class DefaultImpls {
        @ExperimentalComposeUiApi
        @Deprecated
        public static boolean isLookingAhead(MeasureScope measureScope) {
            return AbstractC4411yt.a(measureScope);
        }

        @Deprecated
        public static MeasureResult layout(MeasureScope measureScope, int i, int i2, Map<AlignmentLine, Integer> map, InterfaceC3750qp interfaceC3750qp) {
            AbstractC4492zt.h(map, "alignmentLines");
            AbstractC4492zt.h(interfaceC3750qp, "placementBlock");
            return CC.a(measureScope, i, i2, map, interfaceC3750qp);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m4183roundToPxR2X_6o(MeasureScope measureScope, long j) {
            return AbstractC1819bj.a(measureScope, j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m4184roundToPx0680j_4(MeasureScope measureScope, float f) {
            return AbstractC1819bj.b(measureScope, f);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m4185toDpGaN1DYA(MeasureScope measureScope, long j) {
            return AbstractC1819bj.c(measureScope, j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m4186toDpu2uoSUM(MeasureScope measureScope, float f) {
            return AbstractC1819bj.d(measureScope, f);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m4188toDpSizekrfVVM(MeasureScope measureScope, long j) {
            return AbstractC1819bj.f(measureScope, j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m4189toPxR2X_6o(MeasureScope measureScope, long j) {
            return AbstractC1819bj.g(measureScope, j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m4190toPx0680j_4(MeasureScope measureScope, float f) {
            return AbstractC1819bj.h(measureScope, f);
        }

        @Stable
        @Deprecated
        public static Rect toRect(MeasureScope measureScope, DpRect dpRect) {
            AbstractC4492zt.h(dpRect, "$receiver");
            return AbstractC1819bj.i(measureScope, dpRect);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m4191toSizeXkaWNTQ(MeasureScope measureScope, long j) {
            return AbstractC1819bj.j(measureScope, j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m4192toSp0xMU5do(MeasureScope measureScope, float f) {
            return AbstractC1819bj.k(measureScope, f);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m4193toSpkPz2Gy4(MeasureScope measureScope, float f) {
            return AbstractC1819bj.l(measureScope, f);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m4187toDpu2uoSUM(MeasureScope measureScope, int i) {
            return AbstractC1819bj.e(measureScope, i);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m4194toSpkPz2Gy4(MeasureScope measureScope, int i) {
            return AbstractC1819bj.m(measureScope, i);
        }
    }

    MeasureResult layout(int i, int i2, Map<AlignmentLine, Integer> map, InterfaceC3750qp interfaceC3750qp);
}
