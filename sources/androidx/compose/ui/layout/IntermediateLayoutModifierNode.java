package androidx.compose.ui.layout;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.node.LookaheadDelegate;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.NodeMeasuringIntrinsics;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import defpackage.AbstractC1819bj;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0578Hp;
import defpackage.InterfaceC0988Vf;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class IntermediateLayoutModifierNode extends Modifier.Node implements LayoutModifierNode {
    private LookaheadScope closestLookaheadScope;
    private IntermediateMeasurablePlaceable intermediateMeasurable;
    private final IntermediateMeasureScopeImpl intermediateMeasureScope;
    private boolean isIntermediateChangeActive;
    private final LookaheadScopeImpl localLookaheadScope;
    private Constraints lookaheadConstraints;
    private InterfaceC0552Gp measureBlock;

    public final class IntermediateMeasurablePlaceable extends Placeable implements Measurable {
        final /* synthetic */ IntermediateLayoutModifierNode this$0;
        private Measurable wrappedMeasurable;
        private Placeable wrappedPlaceable;

        public IntermediateMeasurablePlaceable(IntermediateLayoutModifierNode intermediateLayoutModifierNode, Measurable measurable) {
            AbstractC4492zt.h(measurable, "wrappedMeasurable");
            this.this$0 = intermediateLayoutModifierNode;
            this.wrappedMeasurable = measurable;
        }

        @Override // androidx.compose.ui.layout.Measured
        public int get(AlignmentLine alignmentLine) {
            AbstractC4492zt.h(alignmentLine, "alignmentLine");
            Placeable placeable = this.wrappedPlaceable;
            AbstractC4492zt.e(placeable);
            return placeable.get(alignmentLine);
        }

        @Override // androidx.compose.ui.layout.Placeable, androidx.compose.ui.layout.Measured, androidx.compose.ui.layout.IntrinsicMeasurable
        public Object getParentData() {
            return this.wrappedMeasurable.getParentData();
        }

        public final Measurable getWrappedMeasurable() {
            return this.wrappedMeasurable;
        }

        public final Placeable getWrappedPlaceable() {
            return this.wrappedPlaceable;
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public int maxIntrinsicHeight(int i) {
            return this.wrappedMeasurable.maxIntrinsicHeight(i);
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public int maxIntrinsicWidth(int i) {
            return this.wrappedMeasurable.maxIntrinsicWidth(i);
        }

        @Override // androidx.compose.ui.layout.Measurable
        /* JADX INFO: renamed from: measure-BRTryo0 */
        public Placeable mo4159measureBRTryo0(long j) {
            Placeable placeableMo4159measureBRTryo0;
            if (this.this$0.isIntermediateChangeActive()) {
                placeableMo4159measureBRTryo0 = this.wrappedMeasurable.mo4159measureBRTryo0(j);
                m4202setMeasurementConstraintsBRTryo0(j);
                m4201setMeasuredSizeozmzZPI(IntSizeKt.IntSize(placeableMo4159measureBRTryo0.getWidth(), placeableMo4159measureBRTryo0.getHeight()));
            } else {
                Measurable measurable = this.wrappedMeasurable;
                Constraints constraints = this.this$0.lookaheadConstraints;
                AbstractC4492zt.e(constraints);
                placeableMo4159measureBRTryo0 = measurable.mo4159measureBRTryo0(constraints.m5134unboximpl());
                IntermediateLayoutModifierNode intermediateLayoutModifierNode = this.this$0;
                Constraints constraints2 = intermediateLayoutModifierNode.lookaheadConstraints;
                AbstractC4492zt.e(constraints2);
                m4202setMeasurementConstraintsBRTryo0(constraints2.m5134unboximpl());
                m4201setMeasuredSizeozmzZPI(intermediateLayoutModifierNode.isIntermediateChangeActive() ? IntSizeKt.IntSize(placeableMo4159measureBRTryo0.getWidth(), placeableMo4159measureBRTryo0.getHeight()) : intermediateLayoutModifierNode.intermediateMeasureScope.mo4162getLookaheadSizeYbymL2g());
            }
            this.wrappedPlaceable = placeableMo4159measureBRTryo0;
            return this;
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public int minIntrinsicHeight(int i) {
            return this.wrappedMeasurable.minIntrinsicHeight(i);
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public int minIntrinsicWidth(int i) {
            return this.wrappedMeasurable.minIntrinsicWidth(i);
        }

        @Override // androidx.compose.ui.layout.Placeable
        /* JADX INFO: renamed from: placeAt-f8xVGno */
        public void mo4160placeAtf8xVGno(long j, float f, InterfaceC3750qp interfaceC3750qp) {
            FW fw;
            if (!this.this$0.isIntermediateChangeActive()) {
                j = IntOffset.Companion.m5288getZeronOccac();
            }
            if (interfaceC3750qp != null) {
                Placeable placeable = this.wrappedPlaceable;
                if (placeable != null) {
                    Placeable.PlacementScope.Companion.m4212placeWithLayeraW9wM(placeable, j, f, interfaceC3750qp);
                    fw = FW.a;
                } else {
                    fw = null;
                }
                if (fw != null) {
                    return;
                }
            }
            Placeable placeable2 = this.wrappedPlaceable;
            if (placeable2 != null) {
                Placeable.PlacementScope.Companion.m4207place70tqf50(placeable2, j, f);
                FW fw2 = FW.a;
            }
        }

        public final void setWrappedMeasurable(Measurable measurable) {
            AbstractC4492zt.h(measurable, "<set-?>");
            this.wrappedMeasurable = measurable;
        }

        public final void setWrappedPlaceable(Placeable placeable) {
            this.wrappedPlaceable = placeable;
        }
    }

    @ExperimentalComposeUiApi
    public final class IntermediateMeasureScopeImpl implements IntermediateMeasureScope, InterfaceC2052dg {
        private long lookaheadSize = IntSize.Companion.m5325getZeroYbymL2g();

        public IntermediateMeasureScopeImpl() {
        }

        @Override // androidx.compose.ui.layout.IntermediateMeasureScope, defpackage.InterfaceC2052dg
        public InterfaceC0988Vf getCoroutineContext() {
            return IntermediateLayoutModifierNode.this.getCoroutineScope().getCoroutineContext();
        }

        @Override // androidx.compose.ui.unit.Density
        public float getDensity() {
            NodeCoordinator coordinator$ui_release = IntermediateLayoutModifierNode.this.getCoordinator$ui_release();
            AbstractC4492zt.e(coordinator$ui_release);
            return coordinator$ui_release.getDensity();
        }

        @Override // androidx.compose.ui.unit.Density
        public float getFontScale() {
            NodeCoordinator coordinator$ui_release = IntermediateLayoutModifierNode.this.getCoordinator$ui_release();
            AbstractC4492zt.e(coordinator$ui_release);
            return coordinator$ui_release.getFontScale();
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
        public LayoutDirection getLayoutDirection() {
            NodeCoordinator coordinator$ui_release = IntermediateLayoutModifierNode.this.getCoordinator$ui_release();
            AbstractC4492zt.e(coordinator$ui_release);
            return coordinator$ui_release.getLayoutDirection();
        }

        @Override // androidx.compose.ui.layout.LookaheadScope
        public LayoutCoordinates getLookaheadScopeCoordinates(Placeable.PlacementScope placementScope) {
            AbstractC4492zt.h(placementScope, "<this>");
            return IntermediateLayoutModifierNode.this.closestLookaheadScope.getLookaheadScopeCoordinates(placementScope);
        }

        @Override // androidx.compose.ui.layout.IntermediateMeasureScope
        /* JADX INFO: renamed from: getLookaheadSize-YbymL2g, reason: not valid java name */
        public long mo4162getLookaheadSizeYbymL2g() {
            return this.lookaheadSize;
        }

        @Override // androidx.compose.ui.layout.LookaheadScope
        public /* synthetic */ Modifier intermediateLayout(Modifier modifier, InterfaceC0578Hp interfaceC0578Hp) {
            return LookaheadScope.CC.a(this, modifier, interfaceC0578Hp);
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
        public boolean isLookingAhead() {
            return false;
        }

        @Override // androidx.compose.ui.layout.MeasureScope
        public MeasureResult layout(final int i, final int i2, final Map<AlignmentLine, Integer> map, final InterfaceC3750qp interfaceC3750qp) {
            AbstractC4492zt.h(map, "alignmentLines");
            AbstractC4492zt.h(interfaceC3750qp, "placementBlock");
            final IntermediateLayoutModifierNode intermediateLayoutModifierNode = IntermediateLayoutModifierNode.this;
            return new MeasureResult(i, i2, map, this, intermediateLayoutModifierNode, interfaceC3750qp) { // from class: androidx.compose.ui.layout.IntermediateLayoutModifierNode$IntermediateMeasureScopeImpl$layout$1
                final /* synthetic */ InterfaceC3750qp $placementBlock;
                final /* synthetic */ int $width;
                private final Map<AlignmentLine, Integer> alignmentLines;
                private final int height;
                final /* synthetic */ IntermediateLayoutModifierNode.IntermediateMeasureScopeImpl this$0;
                final /* synthetic */ IntermediateLayoutModifierNode this$1;
                private final int width;

                {
                    this.$width = i;
                    this.this$0 = this;
                    this.this$1 = intermediateLayoutModifierNode;
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
                    NodeCoordinator coordinator$ui_release = this.this$1.getCoordinator$ui_release();
                    InterfaceC3750qp interfaceC3750qp2 = this.$placementBlock;
                    LayoutCoordinates layoutCoordinates = Placeable.PlacementScope._coordinates;
                    int parentWidth = companion.getParentWidth();
                    LayoutDirection parentLayoutDirection = companion.getParentLayoutDirection();
                    LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = Placeable.PlacementScope.layoutDelegate;
                    Placeable.PlacementScope.parentWidth = i3;
                    Placeable.PlacementScope.parentLayoutDirection = layoutDirection;
                    boolean zConfigureForPlacingForAlignment = companion.configureForPlacingForAlignment(coordinator$ui_release);
                    interfaceC3750qp2.invoke(companion);
                    if (coordinator$ui_release != null) {
                        coordinator$ui_release.setPlacingForAlignment$ui_release(zConfigureForPlacingForAlignment);
                    }
                    Placeable.PlacementScope.parentWidth = parentWidth;
                    Placeable.PlacementScope.parentLayoutDirection = parentLayoutDirection;
                    Placeable.PlacementScope._coordinates = layoutCoordinates;
                    Placeable.PlacementScope.layoutDelegate = layoutNodeLayoutDelegate;
                }
            };
        }

        @Override // androidx.compose.ui.layout.LookaheadScope
        /* JADX INFO: renamed from: localLookaheadPositionOf-dBAh8RU, reason: not valid java name */
        public /* synthetic */ long mo4163localLookaheadPositionOfdBAh8RU(LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2) {
            return LookaheadScope.CC.b(this, layoutCoordinates, layoutCoordinates2);
        }

        @Override // androidx.compose.ui.layout.LookaheadScope
        public Modifier onPlaced(Modifier modifier, InterfaceC0526Fp interfaceC0526Fp) {
            AbstractC4492zt.h(modifier, "<this>");
            AbstractC4492zt.h(interfaceC0526Fp, "onPlaced");
            return IntermediateLayoutModifierNode.this.closestLookaheadScope.onPlaced(modifier, interfaceC0526Fp);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: roundToPx--R2X_6o */
        public /* synthetic */ int mo326roundToPxR2X_6o(long j) {
            return AbstractC1819bj.a(this, j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: roundToPx-0680j_4 */
        public /* synthetic */ int mo327roundToPx0680j_4(float f) {
            return AbstractC1819bj.b(this, f);
        }

        /* JADX INFO: renamed from: setLookaheadSize-ozmzZPI, reason: not valid java name */
        public void m4164setLookaheadSizeozmzZPI(long j) {
            this.lookaheadSize = j;
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toDp-GaN1DYA */
        public /* synthetic */ float mo328toDpGaN1DYA(long j) {
            return AbstractC1819bj.c(this, j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toDp-u2uoSUM */
        public /* synthetic */ float mo329toDpu2uoSUM(float f) {
            return AbstractC1819bj.d(this, f);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toDpSize-k-rfVVM */
        public /* synthetic */ long mo331toDpSizekrfVVM(long j) {
            return AbstractC1819bj.f(this, j);
        }

        @Override // androidx.compose.ui.layout.LookaheadScope
        public LayoutCoordinates toLookaheadCoordinates(LayoutCoordinates layoutCoordinates) {
            AbstractC4492zt.h(layoutCoordinates, "<this>");
            return IntermediateLayoutModifierNode.this.closestLookaheadScope.toLookaheadCoordinates(layoutCoordinates);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toPx--R2X_6o */
        public /* synthetic */ float mo332toPxR2X_6o(long j) {
            return AbstractC1819bj.g(this, j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toPx-0680j_4 */
        public /* synthetic */ float mo333toPx0680j_4(float f) {
            return AbstractC1819bj.h(this, f);
        }

        @Override // androidx.compose.ui.unit.Density
        public /* synthetic */ Rect toRect(DpRect dpRect) {
            return AbstractC1819bj.i(this, dpRect);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toSize-XkaWNTQ */
        public /* synthetic */ long mo334toSizeXkaWNTQ(long j) {
            return AbstractC1819bj.j(this, j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toSp-0xMU5do */
        public /* synthetic */ long mo335toSp0xMU5do(float f) {
            return AbstractC1819bj.k(this, f);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toSp-kPz2Gy4 */
        public /* synthetic */ long mo336toSpkPz2Gy4(float f) {
            return AbstractC1819bj.l(this, f);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toDp-u2uoSUM */
        public /* synthetic */ float mo330toDpu2uoSUM(int i) {
            return AbstractC1819bj.e(this, i);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toSp-kPz2Gy4 */
        public /* synthetic */ long mo337toSpkPz2Gy4(int i) {
            return AbstractC1819bj.m(this, i);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.layout.IntermediateLayoutModifierNode$onAttach$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3588op {
        final /* synthetic */ LayoutNode $closestLookaheadRoot;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(LayoutNode layoutNode) {
            super(0);
            this.$closestLookaheadRoot = layoutNode;
        }

        @Override // defpackage.InterfaceC3588op
        public final LayoutCoordinates invoke() {
            LayoutNode parent$ui_release = this.$closestLookaheadRoot.getParent$ui_release();
            AbstractC4492zt.e(parent$ui_release);
            return parent$ui_release.getInnerCoordinator$ui_release().getCoordinates();
        }
    }

    public IntermediateLayoutModifierNode(InterfaceC0552Gp interfaceC0552Gp) {
        AbstractC4492zt.h(interfaceC0552Gp, "measureBlock");
        this.measureBlock = interfaceC0552Gp;
        this.intermediateMeasureScope = new IntermediateMeasureScopeImpl();
        LookaheadScopeImpl lookaheadScopeImpl = new LookaheadScopeImpl(new IntermediateLayoutModifierNode$localLookaheadScope$1(this));
        this.localLookaheadScope = lookaheadScopeImpl;
        this.closestLookaheadScope = lookaheadScopeImpl;
        this.isIntermediateChangeActive = true;
    }

    public final InterfaceC0552Gp getMeasureBlock$ui_release() {
        return this.measureBlock;
    }

    /* JADX INFO: renamed from: intermediateMeasure-Te-uZzU, reason: not valid java name */
    public final MeasureResult m4161intermediateMeasureTeuZzU(MeasureScope measureScope, Measurable measurable, long j, long j2, long j3) {
        AbstractC4492zt.h(measureScope, "$this$intermediateMeasure");
        AbstractC4492zt.h(measurable, "measurable");
        this.intermediateMeasureScope.m4164setLookaheadSizeozmzZPI(j2);
        this.lookaheadConstraints = Constraints.m5116boximpl(j3);
        IntermediateMeasurablePlaceable intermediateMeasurablePlaceable = this.intermediateMeasurable;
        if (intermediateMeasurablePlaceable == null) {
            intermediateMeasurablePlaceable = new IntermediateMeasurablePlaceable(this, measurable);
        }
        this.intermediateMeasurable = intermediateMeasurablePlaceable;
        intermediateMeasurablePlaceable.setWrappedMeasurable(measurable);
        return (MeasureResult) this.measureBlock.invoke(this.intermediateMeasureScope, intermediateMeasurablePlaceable, Constraints.m5116boximpl(j));
    }

    public final boolean isIntermediateChangeActive() {
        return this.isIntermediateChangeActive;
    }

    public final int maxIntermediateIntrinsicHeight$ui_release(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
        AbstractC4492zt.h(intrinsicMeasurable, "measurable");
        return NodeMeasuringIntrinsics.INSTANCE.maxHeight$ui_release(new NodeMeasuringIntrinsics.MeasureBlock() { // from class: androidx.compose.ui.layout.IntermediateLayoutModifierNode$maxIntermediateIntrinsicHeight$1
            @Override // androidx.compose.ui.node.NodeMeasuringIntrinsics.MeasureBlock
            /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
            public final MeasureResult mo4165measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                AbstractC4492zt.h(measureScope, "$this$maxHeight");
                AbstractC4492zt.h(measurable, "intrinsicMeasurable");
                return (MeasureResult) this.this$0.getMeasureBlock$ui_release().invoke(this.this$0.intermediateMeasureScope, measurable, Constraints.m5116boximpl(j));
            }
        }, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public final int maxIntermediateIntrinsicWidth$ui_release(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
        AbstractC4492zt.h(intrinsicMeasurable, "measurable");
        return NodeMeasuringIntrinsics.INSTANCE.maxWidth$ui_release(new NodeMeasuringIntrinsics.MeasureBlock() { // from class: androidx.compose.ui.layout.IntermediateLayoutModifierNode$maxIntermediateIntrinsicWidth$1
            @Override // androidx.compose.ui.node.NodeMeasuringIntrinsics.MeasureBlock
            /* JADX INFO: renamed from: measure-3p2s80s */
            public final MeasureResult mo4165measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                AbstractC4492zt.h(measureScope, "$this$maxWidth");
                AbstractC4492zt.h(measurable, "intrinsicMeasurable");
                return (MeasureResult) this.this$0.getMeasureBlock$ui_release().invoke(this.this$0.intermediateMeasureScope, measurable, Constraints.m5116boximpl(j));
            }
        }, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return LayoutModifierNode.CC.a(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return LayoutModifierNode.CC.b(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo248measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        AbstractC4492zt.h(measureScope, "$this$measure");
        AbstractC4492zt.h(measurable, "measurable");
        Placeable placeableMo4159measureBRTryo0 = measurable.mo4159measureBRTryo0(j);
        return MeasureScope.CC.q(measureScope, placeableMo4159measureBRTryo0.getWidth(), placeableMo4159measureBRTryo0.getHeight(), null, new IntermediateLayoutModifierNode$measure$1$1(placeableMo4159measureBRTryo0), 4, null);
    }

    public final int minIntermediateIntrinsicHeight$ui_release(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
        AbstractC4492zt.h(intrinsicMeasurable, "measurable");
        return NodeMeasuringIntrinsics.INSTANCE.minHeight$ui_release(new NodeMeasuringIntrinsics.MeasureBlock() { // from class: androidx.compose.ui.layout.IntermediateLayoutModifierNode$minIntermediateIntrinsicHeight$1
            @Override // androidx.compose.ui.node.NodeMeasuringIntrinsics.MeasureBlock
            /* JADX INFO: renamed from: measure-3p2s80s */
            public final MeasureResult mo4165measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                AbstractC4492zt.h(measureScope, "$this$minHeight");
                AbstractC4492zt.h(measurable, "intrinsicMeasurable");
                return (MeasureResult) this.this$0.getMeasureBlock$ui_release().invoke(this.this$0.intermediateMeasureScope, measurable, Constraints.m5116boximpl(j));
            }
        }, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public final int minIntermediateIntrinsicWidth$ui_release(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
        AbstractC4492zt.h(intrinsicMeasurable, "measurable");
        return NodeMeasuringIntrinsics.INSTANCE.minWidth$ui_release(new NodeMeasuringIntrinsics.MeasureBlock() { // from class: androidx.compose.ui.layout.IntermediateLayoutModifierNode$minIntermediateIntrinsicWidth$1
            @Override // androidx.compose.ui.node.NodeMeasuringIntrinsics.MeasureBlock
            /* JADX INFO: renamed from: measure-3p2s80s */
            public final MeasureResult mo4165measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                AbstractC4492zt.h(measureScope, "$this$minWidth");
                AbstractC4492zt.h(measurable, "intrinsicMeasurable");
                return (MeasureResult) this.this$0.getMeasureBlock$ui_release().invoke(this.this$0.intermediateMeasureScope, measurable, Constraints.m5116boximpl(j));
            }
        }, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return LayoutModifierNode.CC.c(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return LayoutModifierNode.CC.d(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        LookaheadScopeImpl lookaheadScopeImpl;
        LookaheadScopeImpl lookaheadScopeImpl2;
        NodeChain nodes$ui_release;
        NodeCoordinator coordinator$ui_release = getCoordinator$ui_release();
        AbstractC4492zt.e(coordinator$ui_release);
        LayoutNode layoutNode = coordinator$ui_release.getLayoutNode();
        NodeCoordinator coordinator$ui_release2 = getCoordinator$ui_release();
        AbstractC4492zt.e(coordinator$ui_release2);
        LookaheadDelegate lookaheadDelegate = coordinator$ui_release2.getLookaheadDelegate();
        if ((lookaheadDelegate != null ? lookaheadDelegate.getLookaheadLayoutCoordinates() : null) == null) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        LayoutNode lookaheadRoot$ui_release = layoutNode.getLookaheadRoot$ui_release();
        if (lookaheadRoot$ui_release == null || !lookaheadRoot$ui_release.isVirtualLookaheadRoot$ui_release()) {
            int iM4378constructorimpl = NodeKind.m4378constructorimpl(512);
            if (!getNode().isAttached()) {
                throw new IllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node parent$ui_release = getNode().getParent$ui_release();
            LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(this);
            IntermediateLayoutModifierNode intermediateLayoutModifierNode = null;
            while (layoutNodeRequireLayoutNode != null) {
                if ((layoutNodeRequireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & iM4378constructorimpl) != 0) {
                    while (parent$ui_release != null) {
                        if ((parent$ui_release.getKindSet$ui_release() & iM4378constructorimpl) != 0) {
                            MutableVector mutableVector = null;
                            Modifier.Node nodePop = parent$ui_release;
                            while (nodePop != null) {
                                if (nodePop instanceof IntermediateLayoutModifierNode) {
                                    intermediateLayoutModifierNode = (IntermediateLayoutModifierNode) nodePop;
                                } else if ((nodePop.getKindSet$ui_release() & iM4378constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                                    int i = 0;
                                    for (Modifier.Node delegate$ui_release = ((DelegatingNode) nodePop).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                        if ((delegate$ui_release.getKindSet$ui_release() & iM4378constructorimpl) != 0) {
                                            i++;
                                            if (i == 1) {
                                                nodePop = delegate$ui_release;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (nodePop != null) {
                                                    mutableVector.add(nodePop);
                                                    nodePop = null;
                                                }
                                                mutableVector.add(delegate$ui_release);
                                            }
                                        }
                                    }
                                    if (i == 1) {
                                    }
                                }
                                nodePop = DelegatableNodeKt.pop(mutableVector);
                            }
                        }
                        parent$ui_release = parent$ui_release.getParent$ui_release();
                    }
                }
                layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
                parent$ui_release = (layoutNodeRequireLayoutNode == null || (nodes$ui_release = layoutNodeRequireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
            }
            if (intermediateLayoutModifierNode == null || (lookaheadScopeImpl = intermediateLayoutModifierNode.localLookaheadScope) == null) {
                lookaheadScopeImpl = this.localLookaheadScope;
            }
            lookaheadScopeImpl2 = lookaheadScopeImpl;
        } else {
            lookaheadScopeImpl2 = new LookaheadScopeImpl(new AnonymousClass1(lookaheadRoot$ui_release));
        }
        this.closestLookaheadScope = lookaheadScopeImpl2;
    }

    public final void setIntermediateChangeActive(boolean z) {
        this.isIntermediateChangeActive = z;
    }

    public final void setMeasureBlock$ui_release(InterfaceC0552Gp interfaceC0552Gp) {
        AbstractC4492zt.h(interfaceC0552Gp, "<set-?>");
        this.measureBlock = interfaceC0552Gp;
    }
}
