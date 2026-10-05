package androidx.compose.ui.layout;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC2342hB;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public abstract class Placeable implements Measured {
    public static final int $stable = 8;
    private int height;
    private int width;
    private long measuredSize = IntSizeKt.IntSize(0, 0);
    private long measurementConstraints = PlaceableKt.DefaultConstraints;
    private long apparentToRealOffset = IntOffset.Companion.m5288getZeronOccac();

    @StabilityInferred(parameters = 0)
    public static abstract class PlacementScope {
        public static final int $stable = 0;
        private static LayoutCoordinates _coordinates;
        private static LayoutNodeLayoutDelegate layoutDelegate;
        private static int parentWidth;
        public static final Companion Companion = new Companion(null);
        private static LayoutDirection parentLayoutDirection = LayoutDirection.Ltr;

        public static final class Companion extends PlacementScope {
            public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final boolean configureForPlacingForAlignment(LookaheadCapablePlaceable lookaheadCapablePlaceable) {
                if (lookaheadCapablePlaceable == null) {
                    PlacementScope._coordinates = null;
                    PlacementScope.layoutDelegate = null;
                    return false;
                }
                boolean zIsPlacingForAlignment$ui_release = lookaheadCapablePlaceable.isPlacingForAlignment$ui_release();
                LookaheadCapablePlaceable parent = lookaheadCapablePlaceable.getParent();
                if (parent != null && parent.isPlacingForAlignment$ui_release()) {
                    lookaheadCapablePlaceable.setPlacingForAlignment$ui_release(true);
                }
                PlacementScope.layoutDelegate = lookaheadCapablePlaceable.getLayoutNode().getLayoutDelegate$ui_release();
                if (lookaheadCapablePlaceable.isPlacingForAlignment$ui_release() || lookaheadCapablePlaceable.isShallowPlacing$ui_release()) {
                    PlacementScope._coordinates = null;
                } else {
                    PlacementScope._coordinates = lookaheadCapablePlaceable.getCoordinates();
                }
                return zIsPlacingForAlignment$ui_release;
            }

            public final void executeWithRtlMirroringValues(int i, LayoutDirection layoutDirection, LookaheadCapablePlaceable lookaheadCapablePlaceable, InterfaceC3750qp interfaceC3750qp) {
                AbstractC4492zt.h(layoutDirection, "parentLayoutDirection");
                AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
                LayoutCoordinates layoutCoordinates = PlacementScope._coordinates;
                Companion companion = PlacementScope.Companion;
                int parentWidth = companion.getParentWidth();
                LayoutDirection parentLayoutDirection = companion.getParentLayoutDirection();
                LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = PlacementScope.layoutDelegate;
                PlacementScope.parentWidth = i;
                PlacementScope.parentLayoutDirection = layoutDirection;
                boolean zConfigureForPlacingForAlignment = configureForPlacingForAlignment(lookaheadCapablePlaceable);
                interfaceC3750qp.invoke(this);
                if (lookaheadCapablePlaceable != null) {
                    lookaheadCapablePlaceable.setPlacingForAlignment$ui_release(zConfigureForPlacingForAlignment);
                }
                PlacementScope.parentWidth = parentWidth;
                PlacementScope.parentLayoutDirection = parentLayoutDirection;
                PlacementScope._coordinates = layoutCoordinates;
                PlacementScope.layoutDelegate = layoutNodeLayoutDelegate;
            }

            @Override // androidx.compose.ui.layout.Placeable.PlacementScope
            public LayoutCoordinates getCoordinates() {
                LayoutNodeLayoutDelegate layoutNodeLayoutDelegate;
                if (PlacementScope._coordinates == null && (layoutNodeLayoutDelegate = PlacementScope.layoutDelegate) != null) {
                    layoutNodeLayoutDelegate.onCoordinatesUsed();
                }
                return PlacementScope._coordinates;
            }

            @Override // androidx.compose.ui.layout.Placeable.PlacementScope
            public LayoutDirection getParentLayoutDirection() {
                return PlacementScope.parentLayoutDirection;
            }

            @Override // androidx.compose.ui.layout.Placeable.PlacementScope
            public int getParentWidth() {
                return PlacementScope.parentWidth;
            }

            private Companion() {
            }
        }

        public static /* synthetic */ void place$default(PlacementScope placementScope, Placeable placeable, int i, int i2, float f, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: place");
            }
            if ((i3 & 4) != 0) {
                f = 0.0f;
            }
            placementScope.place(placeable, i, i2, f);
        }

        /* JADX INFO: renamed from: place-70tqf50$default, reason: not valid java name */
        public static /* synthetic */ void m4203place70tqf50$default(PlacementScope placementScope, Placeable placeable, long j, float f, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: place-70tqf50");
            }
            if ((i & 2) != 0) {
                f = 0.0f;
            }
            placementScope.m4207place70tqf50(placeable, j, f);
        }

        public static /* synthetic */ void placeRelative$default(PlacementScope placementScope, Placeable placeable, int i, int i2, float f, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelative");
            }
            if ((i3 & 4) != 0) {
                f = 0.0f;
            }
            placementScope.placeRelative(placeable, i, i2, f);
        }

        /* JADX INFO: renamed from: placeRelative-70tqf50$default, reason: not valid java name */
        public static /* synthetic */ void m4204placeRelative70tqf50$default(PlacementScope placementScope, Placeable placeable, long j, float f, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelative-70tqf50");
            }
            if ((i & 2) != 0) {
                f = 0.0f;
            }
            placementScope.m4210placeRelative70tqf50(placeable, j, f);
        }

        public static /* synthetic */ void placeRelativeWithLayer$default(PlacementScope placementScope, Placeable placeable, int i, int i2, float f, InterfaceC3750qp interfaceC3750qp, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer");
            }
            float f2 = (i3 & 4) != 0 ? 0.0f : f;
            if ((i3 & 8) != 0) {
                interfaceC3750qp = PlaceableKt.DefaultLayerBlock;
            }
            placementScope.placeRelativeWithLayer(placeable, i, i2, f2, interfaceC3750qp);
        }

        /* JADX INFO: renamed from: placeRelativeWithLayer-aW-9-wM$default, reason: not valid java name */
        public static /* synthetic */ void m4205placeRelativeWithLayeraW9wM$default(PlacementScope placementScope, Placeable placeable, long j, float f, InterfaceC3750qp interfaceC3750qp, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer-aW-9-wM");
            }
            float f2 = (i & 2) != 0 ? 0.0f : f;
            if ((i & 4) != 0) {
                interfaceC3750qp = PlaceableKt.DefaultLayerBlock;
            }
            placementScope.m4211placeRelativeWithLayeraW9wM(placeable, j, f2, interfaceC3750qp);
        }

        public static /* synthetic */ void placeWithLayer$default(PlacementScope placementScope, Placeable placeable, int i, int i2, float f, InterfaceC3750qp interfaceC3750qp, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer");
            }
            float f2 = (i3 & 4) != 0 ? 0.0f : f;
            if ((i3 & 8) != 0) {
                interfaceC3750qp = PlaceableKt.DefaultLayerBlock;
            }
            placementScope.placeWithLayer(placeable, i, i2, f2, interfaceC3750qp);
        }

        /* JADX INFO: renamed from: placeWithLayer-aW-9-wM$default, reason: not valid java name */
        public static /* synthetic */ void m4206placeWithLayeraW9wM$default(PlacementScope placementScope, Placeable placeable, long j, float f, InterfaceC3750qp interfaceC3750qp, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer-aW-9-wM");
            }
            float f2 = (i & 2) != 0 ? 0.0f : f;
            if ((i & 4) != 0) {
                interfaceC3750qp = PlaceableKt.DefaultLayerBlock;
            }
            placementScope.m4212placeWithLayeraW9wM(placeable, j, f2, interfaceC3750qp);
        }

        public LayoutCoordinates getCoordinates() {
            return null;
        }

        public abstract LayoutDirection getParentLayoutDirection();

        public abstract int getParentWidth();

        public final void place(Placeable placeable, int i, int i2, float f) {
            AbstractC4492zt.h(placeable, "<this>");
            long jIntOffset = IntOffsetKt.IntOffset(i, i2);
            long j = placeable.apparentToRealOffset;
            placeable.mo4160placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(jIntOffset) + IntOffset.m5278getXimpl(j), IntOffset.m5279getYimpl(jIntOffset) + IntOffset.m5279getYimpl(j)), f, null);
        }

        /* JADX INFO: renamed from: place-70tqf50, reason: not valid java name */
        public final void m4207place70tqf50(Placeable placeable, long j, float f) {
            AbstractC4492zt.h(placeable, "$this$place");
            long j2 = placeable.apparentToRealOffset;
            placeable.mo4160placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(j) + IntOffset.m5278getXimpl(j2), IntOffset.m5279getYimpl(j) + IntOffset.m5279getYimpl(j2)), f, null);
        }

        /* JADX INFO: renamed from: placeApparentToRealOffset-aW-9-wM$ui_release, reason: not valid java name */
        public final void m4208placeApparentToRealOffsetaW9wM$ui_release(Placeable placeable, long j, float f, InterfaceC3750qp interfaceC3750qp) {
            AbstractC4492zt.h(placeable, "$this$placeApparentToRealOffset");
            long j2 = placeable.apparentToRealOffset;
            placeable.mo4160placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(j) + IntOffset.m5278getXimpl(j2), IntOffset.m5279getYimpl(j) + IntOffset.m5279getYimpl(j2)), f, interfaceC3750qp);
        }

        /* JADX INFO: renamed from: placeAutoMirrored-aW-9-wM$ui_release, reason: not valid java name */
        public final void m4209placeAutoMirroredaW9wM$ui_release(Placeable placeable, long j, float f, InterfaceC3750qp interfaceC3750qp) {
            AbstractC4492zt.h(placeable, "$this$placeAutoMirrored");
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                long j2 = placeable.apparentToRealOffset;
                placeable.mo4160placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(j) + IntOffset.m5278getXimpl(j2), IntOffset.m5279getYimpl(j) + IntOffset.m5279getYimpl(j2)), f, interfaceC3750qp);
            } else {
                long jIntOffset = IntOffsetKt.IntOffset((getParentWidth() - placeable.getWidth()) - IntOffset.m5278getXimpl(j), IntOffset.m5279getYimpl(j));
                long j3 = placeable.apparentToRealOffset;
                placeable.mo4160placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(jIntOffset) + IntOffset.m5278getXimpl(j3), IntOffset.m5279getYimpl(jIntOffset) + IntOffset.m5279getYimpl(j3)), f, interfaceC3750qp);
            }
        }

        public final void placeRelative(Placeable placeable, int i, int i2, float f) {
            AbstractC4492zt.h(placeable, "<this>");
            long jIntOffset = IntOffsetKt.IntOffset(i, i2);
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                long j = placeable.apparentToRealOffset;
                placeable.mo4160placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(jIntOffset) + IntOffset.m5278getXimpl(j), IntOffset.m5279getYimpl(jIntOffset) + IntOffset.m5279getYimpl(j)), f, null);
            } else {
                long jIntOffset2 = IntOffsetKt.IntOffset((getParentWidth() - placeable.getWidth()) - IntOffset.m5278getXimpl(jIntOffset), IntOffset.m5279getYimpl(jIntOffset));
                long j2 = placeable.apparentToRealOffset;
                placeable.mo4160placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(jIntOffset2) + IntOffset.m5278getXimpl(j2), IntOffset.m5279getYimpl(jIntOffset2) + IntOffset.m5279getYimpl(j2)), f, null);
            }
        }

        /* JADX INFO: renamed from: placeRelative-70tqf50, reason: not valid java name */
        public final void m4210placeRelative70tqf50(Placeable placeable, long j, float f) {
            AbstractC4492zt.h(placeable, "$this$placeRelative");
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                long j2 = placeable.apparentToRealOffset;
                placeable.mo4160placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(j) + IntOffset.m5278getXimpl(j2), IntOffset.m5279getYimpl(j) + IntOffset.m5279getYimpl(j2)), f, null);
            } else {
                long jIntOffset = IntOffsetKt.IntOffset((getParentWidth() - placeable.getWidth()) - IntOffset.m5278getXimpl(j), IntOffset.m5279getYimpl(j));
                long j3 = placeable.apparentToRealOffset;
                placeable.mo4160placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(jIntOffset) + IntOffset.m5278getXimpl(j3), IntOffset.m5279getYimpl(jIntOffset) + IntOffset.m5279getYimpl(j3)), f, null);
            }
        }

        public final void placeRelativeWithLayer(Placeable placeable, int i, int i2, float f, InterfaceC3750qp interfaceC3750qp) {
            AbstractC4492zt.h(placeable, "<this>");
            AbstractC4492zt.h(interfaceC3750qp, "layerBlock");
            long jIntOffset = IntOffsetKt.IntOffset(i, i2);
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                long j = placeable.apparentToRealOffset;
                placeable.mo4160placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(jIntOffset) + IntOffset.m5278getXimpl(j), IntOffset.m5279getYimpl(jIntOffset) + IntOffset.m5279getYimpl(j)), f, interfaceC3750qp);
            } else {
                long jIntOffset2 = IntOffsetKt.IntOffset((getParentWidth() - placeable.getWidth()) - IntOffset.m5278getXimpl(jIntOffset), IntOffset.m5279getYimpl(jIntOffset));
                long j2 = placeable.apparentToRealOffset;
                placeable.mo4160placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(jIntOffset2) + IntOffset.m5278getXimpl(j2), IntOffset.m5279getYimpl(jIntOffset2) + IntOffset.m5279getYimpl(j2)), f, interfaceC3750qp);
            }
        }

        /* JADX INFO: renamed from: placeRelativeWithLayer-aW-9-wM, reason: not valid java name */
        public final void m4211placeRelativeWithLayeraW9wM(Placeable placeable, long j, float f, InterfaceC3750qp interfaceC3750qp) {
            AbstractC4492zt.h(placeable, "$this$placeRelativeWithLayer");
            AbstractC4492zt.h(interfaceC3750qp, "layerBlock");
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                long j2 = placeable.apparentToRealOffset;
                placeable.mo4160placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(j) + IntOffset.m5278getXimpl(j2), IntOffset.m5279getYimpl(j) + IntOffset.m5279getYimpl(j2)), f, interfaceC3750qp);
            } else {
                long jIntOffset = IntOffsetKt.IntOffset((getParentWidth() - placeable.getWidth()) - IntOffset.m5278getXimpl(j), IntOffset.m5279getYimpl(j));
                long j3 = placeable.apparentToRealOffset;
                placeable.mo4160placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(jIntOffset) + IntOffset.m5278getXimpl(j3), IntOffset.m5279getYimpl(jIntOffset) + IntOffset.m5279getYimpl(j3)), f, interfaceC3750qp);
            }
        }

        public final void placeWithLayer(Placeable placeable, int i, int i2, float f, InterfaceC3750qp interfaceC3750qp) {
            AbstractC4492zt.h(placeable, "<this>");
            AbstractC4492zt.h(interfaceC3750qp, "layerBlock");
            long jIntOffset = IntOffsetKt.IntOffset(i, i2);
            long j = placeable.apparentToRealOffset;
            placeable.mo4160placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(jIntOffset) + IntOffset.m5278getXimpl(j), IntOffset.m5279getYimpl(jIntOffset) + IntOffset.m5279getYimpl(j)), f, interfaceC3750qp);
        }

        /* JADX INFO: renamed from: placeWithLayer-aW-9-wM, reason: not valid java name */
        public final void m4212placeWithLayeraW9wM(Placeable placeable, long j, float f, InterfaceC3750qp interfaceC3750qp) {
            AbstractC4492zt.h(placeable, "$this$placeWithLayer");
            AbstractC4492zt.h(interfaceC3750qp, "layerBlock");
            long j2 = placeable.apparentToRealOffset;
            placeable.mo4160placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(j) + IntOffset.m5278getXimpl(j2), IntOffset.m5279getYimpl(j) + IntOffset.m5279getYimpl(j2)), f, interfaceC3750qp);
        }
    }

    private final void onMeasuredSizeChanged() {
        this.width = AbstractC3871sJ.l(IntSize.m5320getWidthimpl(this.measuredSize), Constraints.m5130getMinWidthimpl(this.measurementConstraints), Constraints.m5128getMaxWidthimpl(this.measurementConstraints));
        this.height = AbstractC3871sJ.l(IntSize.m5319getHeightimpl(this.measuredSize), Constraints.m5129getMinHeightimpl(this.measurementConstraints), Constraints.m5127getMaxHeightimpl(this.measurementConstraints));
        this.apparentToRealOffset = IntOffsetKt.IntOffset((this.width - IntSize.m5320getWidthimpl(this.measuredSize)) / 2, (this.height - IntSize.m5319getHeightimpl(this.measuredSize)) / 2);
    }

    /* JADX INFO: renamed from: getApparentToRealOffset-nOcc-ac, reason: not valid java name */
    public final long m4198getApparentToRealOffsetnOccac() {
        return this.apparentToRealOffset;
    }

    public final int getHeight() {
        return this.height;
    }

    @Override // androidx.compose.ui.layout.Measured
    public int getMeasuredHeight() {
        return IntSize.m5319getHeightimpl(this.measuredSize);
    }

    /* JADX INFO: renamed from: getMeasuredSize-YbymL2g, reason: not valid java name */
    public final long m4199getMeasuredSizeYbymL2g() {
        return this.measuredSize;
    }

    @Override // androidx.compose.ui.layout.Measured
    public int getMeasuredWidth() {
        return IntSize.m5320getWidthimpl(this.measuredSize);
    }

    /* JADX INFO: renamed from: getMeasurementConstraints-msEJaDk, reason: not valid java name */
    public final long m4200getMeasurementConstraintsmsEJaDk() {
        return this.measurementConstraints;
    }

    @Override // androidx.compose.ui.layout.Measured, androidx.compose.ui.layout.IntrinsicMeasurable
    public /* synthetic */ Object getParentData() {
        return AbstractC2342hB.a(this);
    }

    public final int getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: placeAt-f8xVGno */
    public abstract void mo4160placeAtf8xVGno(long j, float f, InterfaceC3750qp interfaceC3750qp);

    /* JADX INFO: renamed from: setMeasuredSize-ozmzZPI, reason: not valid java name */
    public final void m4201setMeasuredSizeozmzZPI(long j) {
        if (IntSize.m5318equalsimpl0(this.measuredSize, j)) {
            return;
        }
        this.measuredSize = j;
        onMeasuredSizeChanged();
    }

    /* JADX INFO: renamed from: setMeasurementConstraints-BRTryo0, reason: not valid java name */
    public final void m4202setMeasurementConstraintsBRTryo0(long j) {
        if (Constraints.m5121equalsimpl0(this.measurementConstraints, j)) {
            return;
        }
        this.measurementConstraints = j;
        onMeasuredSizeChanged();
    }
}
