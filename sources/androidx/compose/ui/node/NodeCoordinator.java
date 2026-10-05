package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.MutableRectKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LookaheadLayoutCoordinatesImpl;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.OJ;
import defpackage.QO;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class NodeCoordinator extends LookaheadCapablePlaceable implements Measurable, LayoutCoordinates, OwnerScope, InterfaceC3750qp {
    public static final String ExpectAttachedLayoutCoordinates = "LayoutCoordinate operations are only valid when isAttached is true";
    public static final String UnmeasuredError = "Asking for measurement result of unmeasured layout modifier";
    private MeasureResult _measureResult;
    private MutableRect _rectCache;
    private final InterfaceC3588op invalidateParentLayer;
    private boolean isClipping;
    private float lastLayerAlpha;
    private boolean lastLayerDrawingWasSkipped;
    private OwnedLayer layer;
    private InterfaceC3750qp layerBlock;
    private Density layerDensity;
    private LayoutDirection layerLayoutDirection;
    private LayerPositionalProperties layerPositionalProperties;
    private final LayoutNode layoutNode;
    private Map<AlignmentLine, Integer> oldAlignmentLines;
    private long position;
    private boolean released;
    private NodeCoordinator wrapped;
    private NodeCoordinator wrappedBy;
    private float zIndex;
    public static final Companion Companion = new Companion(null);
    private static final InterfaceC3750qp onCommitAffectingLayerParams = NodeCoordinator$Companion$onCommitAffectingLayerParams$1.INSTANCE;
    private static final InterfaceC3750qp onCommitAffectingLayer = NodeCoordinator$Companion$onCommitAffectingLayer$1.INSTANCE;
    private static final ReusableGraphicsLayerScope graphicsLayerScope = new ReusableGraphicsLayerScope();
    private static final LayerPositionalProperties tmpLayerPositionalProperties = new LayerPositionalProperties();
    private static final float[] tmpMatrix = Matrix.m3237constructorimpl$default(null, 1, null);
    private static final HitTestSource PointerInputSource = new HitTestSource() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$PointerInputSource$1
        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* JADX INFO: renamed from: childHitTest-YqVAtuI, reason: not valid java name */
        public void mo4367childHitTestYqVAtuI(LayoutNode layoutNode, long j, HitTestResult hitTestResult, boolean z, boolean z2) {
            AbstractC4492zt.h(layoutNode, "layoutNode");
            AbstractC4492zt.h(hitTestResult, "hitTestResult");
            layoutNode.m4289hitTestM_7yMNQ$ui_release(j, hitTestResult, z, z2);
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* JADX INFO: renamed from: entityType-OLwlOKw, reason: not valid java name */
        public int mo4368entityTypeOLwlOKw() {
            return NodeKind.m4378constructorimpl(16);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v7 */
        /*  JADX ERROR: NullPointerException in pass: PrepareForCodeGen
            java.lang.NullPointerException
            */
        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean interceptOutOfBoundsChildEvents(androidx.compose.ui.Modifier.Node r10) {
            /*
                r9 = this;
                java.lang.String r0 = "node"
                defpackage.AbstractC4492zt.h(r10, r0)
                r0 = 16
                int r1 = androidx.compose.ui.node.NodeKind.m4378constructorimpl(r0)
                r2 = 0
                r3 = r2
            Ld:
                r4 = 0
                if (r10 == 0) goto L5f
                boolean r5 = r10 instanceof androidx.compose.ui.node.PointerInputModifierNode
                r6 = 1
                if (r5 == 0) goto L1e
                androidx.compose.ui.node.PointerInputModifierNode r10 = (androidx.compose.ui.node.PointerInputModifierNode) r10
                boolean r10 = r10.interceptOutOfBoundsChildEvents()
                if (r10 == 0) goto L5a
                return r6
            L1e:
                int r5 = r10.getKindSet$ui_release()
                r5 = r5 & r1
                if (r5 == 0) goto L5a
                boolean r5 = r10 instanceof androidx.compose.ui.node.DelegatingNode
                if (r5 == 0) goto L5a
                r5 = r10
                androidx.compose.ui.node.DelegatingNode r5 = (androidx.compose.ui.node.DelegatingNode) r5
                androidx.compose.ui.Modifier$Node r5 = r5.getDelegate$ui_release()
                r7 = 0
            L31:
                if (r5 == 0) goto L57
                int r8 = r5.getKindSet$ui_release()
                r8 = r8 & r1
                if (r8 == 0) goto L52
                int r7 = r7 + 1
                if (r7 != r6) goto L40
                r10 = r5
                goto L52
            L40:
                if (r3 != 0) goto L49
                androidx.compose.runtime.collection.MutableVector r3 = new androidx.compose.runtime.collection.MutableVector
                androidx.compose.ui.Modifier$Node[] r8 = new androidx.compose.ui.Modifier.Node[r0]
                r3.<init>(r8, r4)
            L49:
                if (r10 == 0) goto L4f
                r3.add(r10)
                r10 = r2
            L4f:
                r3.add(r5)
            L52:
                androidx.compose.ui.Modifier$Node r5 = r5.getChild$ui_release()
                goto L31
            L57:
                if (r7 != r6) goto L5a
                goto Ld
            L5a:
                androidx.compose.ui.Modifier$Node r10 = androidx.compose.ui.node.DelegatableNodeKt.access$pop(r3)
                goto Ld
            L5f:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.NodeCoordinator$Companion$PointerInputSource$1.interceptOutOfBoundsChildEvents(androidx.compose.ui.Modifier$Node):boolean");
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean shouldHitTestChildren(LayoutNode layoutNode) {
            AbstractC4492zt.h(layoutNode, "parentLayoutNode");
            return true;
        }
    };
    private static final HitTestSource SemanticsSource = new HitTestSource() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$SemanticsSource$1
        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* JADX INFO: renamed from: childHitTest-YqVAtuI */
        public void mo4367childHitTestYqVAtuI(LayoutNode layoutNode, long j, HitTestResult hitTestResult, boolean z, boolean z2) {
            AbstractC4492zt.h(layoutNode, "layoutNode");
            AbstractC4492zt.h(hitTestResult, "hitTestResult");
            layoutNode.m4290hitTestSemanticsM_7yMNQ$ui_release(j, hitTestResult, z, z2);
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* JADX INFO: renamed from: entityType-OLwlOKw */
        public int mo4368entityTypeOLwlOKw() {
            return NodeKind.m4378constructorimpl(8);
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean interceptOutOfBoundsChildEvents(Modifier.Node node) {
            AbstractC4492zt.h(node, "node");
            return false;
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean shouldHitTestChildren(LayoutNode layoutNode) {
            AbstractC4492zt.h(layoutNode, "parentLayoutNode");
            SemanticsConfiguration collapsedSemantics$ui_release = layoutNode.getCollapsedSemantics$ui_release();
            boolean z = false;
            if (collapsedSemantics$ui_release != null && collapsedSemantics$ui_release.isClearingSemantics()) {
                z = true;
            }
            return !z;
        }
    };

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final HitTestSource getPointerInputSource() {
            return NodeCoordinator.PointerInputSource;
        }

        public final HitTestSource getSemanticsSource() {
            return NodeCoordinator.SemanticsSource;
        }

        private Companion() {
        }
    }

    public interface HitTestSource {
        /* JADX INFO: renamed from: childHitTest-YqVAtuI */
        void mo4367childHitTestYqVAtuI(LayoutNode layoutNode, long j, HitTestResult hitTestResult, boolean z, boolean z2);

        /* JADX INFO: renamed from: entityType-OLwlOKw */
        int mo4368entityTypeOLwlOKw();

        boolean interceptOutOfBoundsChildEvents(Modifier.Node node);

        boolean shouldHitTestChildren(LayoutNode layoutNode);
    }

    /* JADX INFO: renamed from: androidx.compose.ui.node.NodeCoordinator$invoke$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3588op {
        final /* synthetic */ Canvas $canvas;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Canvas canvas) {
            super(0);
            this.$canvas = canvas;
        }

        @Override // defpackage.InterfaceC3588op
        public /* bridge */ /* synthetic */ Object invoke() {
            m4372invoke();
            return FW.a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m4372invoke() {
            NodeCoordinator.this.drawContainedDrawModifiers(this.$canvas);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.node.NodeCoordinator$updateLayerParameters$1, reason: invalid class name and case insensitive filesystem */
    public static final class C16551 extends AbstractC2233fv implements InterfaceC3588op {
        final /* synthetic */ InterfaceC3750qp $layerBlock;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16551(InterfaceC3750qp interfaceC3750qp) {
            super(0);
            this.$layerBlock = interfaceC3750qp;
        }

        @Override // defpackage.InterfaceC3588op
        public /* bridge */ /* synthetic */ Object invoke() {
            m4374invoke();
            return FW.a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m4374invoke() {
            this.$layerBlock.invoke(NodeCoordinator.graphicsLayerScope);
        }
    }

    public NodeCoordinator(LayoutNode layoutNode) {
        AbstractC4492zt.h(layoutNode, "layoutNode");
        this.layoutNode = layoutNode;
        this.layerDensity = getLayoutNode().getDensity();
        this.layerLayoutDirection = getLayoutNode().getLayoutDirection();
        this.lastLayerAlpha = 0.8f;
        this.position = IntOffset.Companion.m5288getZeronOccac();
        this.invalidateParentLayer = new NodeCoordinator$invalidateParentLayer$1(this);
    }

    private final void ancestorToLocal(NodeCoordinator nodeCoordinator, MutableRect mutableRect, boolean z) {
        if (nodeCoordinator == this) {
            return;
        }
        NodeCoordinator nodeCoordinator2 = this.wrappedBy;
        if (nodeCoordinator2 != null) {
            nodeCoordinator2.ancestorToLocal(nodeCoordinator, mutableRect, z);
        }
        fromParentRect(mutableRect, z);
    }

    /* JADX INFO: renamed from: ancestorToLocal-R5De75A, reason: not valid java name */
    private final long m4344ancestorToLocalR5De75A(NodeCoordinator nodeCoordinator, long j) {
        if (nodeCoordinator == this) {
            return j;
        }
        NodeCoordinator nodeCoordinator2 = this.wrappedBy;
        return (nodeCoordinator2 == null || AbstractC4492zt.d(nodeCoordinator, nodeCoordinator2)) ? m4355fromParentPositionMKHz9U(j) : m4355fromParentPositionMKHz9U(nodeCoordinator2.m4344ancestorToLocalR5De75A(nodeCoordinator, j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void drawContainedDrawModifiers(Canvas canvas) {
        Modifier.Node nodeM4358headH91voCI = m4358headH91voCI(NodeKind.m4378constructorimpl(4));
        if (nodeM4358headH91voCI == null) {
            performDraw(canvas);
        } else {
            getLayoutNode().getMDrawScope$ui_release().m4301drawx_KDEd0$ui_release(canvas, IntSizeKt.m5330toSizeozmzZPI(mo4166getSizeYbymL2g()), this, nodeM4358headH91voCI);
        }
    }

    private final void fromParentRect(MutableRect mutableRect, boolean z) {
        float fM5278getXimpl = IntOffset.m5278getXimpl(mo4321getPositionnOccac());
        mutableRect.setLeft(mutableRect.getLeft() - fM5278getXimpl);
        mutableRect.setRight(mutableRect.getRight() - fM5278getXimpl);
        float fM5279getYimpl = IntOffset.m5279getYimpl(mo4321getPositionnOccac());
        mutableRect.setTop(mutableRect.getTop() - fM5279getYimpl);
        mutableRect.setBottom(mutableRect.getBottom() - fM5279getYimpl);
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.mapBounds(mutableRect, true);
            if (this.isClipping && z) {
                mutableRect.intersect(0.0f, 0.0f, IntSize.m5320getWidthimpl(mo4166getSizeYbymL2g()), IntSize.m5319getHeightimpl(mo4166getSizeYbymL2g()));
                mutableRect.isEmpty();
            }
        }
    }

    private final OwnerSnapshotObserver getSnapshotObserver() {
        return LayoutNodeKt.requireOwner(getLayoutNode()).getSnapshotObserver();
    }

    /* JADX INFO: renamed from: hasNode-H91voCI, reason: not valid java name */
    private final boolean m4345hasNodeH91voCI(int i) {
        Modifier.Node nodeHeadNode = headNode(NodeKindKt.m4387getIncludeSelfInTraversalH91voCI(i));
        return nodeHeadNode != null && DelegatableNodeKt.m4261has64DMado(nodeHeadNode, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Modifier.Node headNode(boolean z) {
        Modifier.Node tail;
        if (getLayoutNode().getOuterCoordinator$ui_release() == this) {
            return getLayoutNode().getNodes$ui_release().getHead$ui_release();
        }
        if (z) {
            NodeCoordinator nodeCoordinator = this.wrappedBy;
            if (nodeCoordinator != null && (tail = nodeCoordinator.getTail()) != null) {
                return tail.getChild$ui_release();
            }
        } else {
            NodeCoordinator nodeCoordinator2 = this.wrappedBy;
            if (nodeCoordinator2 != null) {
                return nodeCoordinator2.getTail();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: hit-1hIXUjU, reason: not valid java name */
    public final void m4346hit1hIXUjU(Modifier.Node node, HitTestSource hitTestSource, long j, HitTestResult hitTestResult, boolean z, boolean z2) {
        if (node == null) {
            mo4284hitTestChildYqVAtuI(hitTestSource, j, hitTestResult, z, z2);
        } else {
            hitTestResult.hit(node, z2, new NodeCoordinator$hit$1(this, node, hitTestSource, j, hitTestResult, z, z2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: hitNear-JHbHoSQ, reason: not valid java name */
    public final void m4347hitNearJHbHoSQ(Modifier.Node node, HitTestSource hitTestSource, long j, HitTestResult hitTestResult, boolean z, boolean z2, float f) {
        if (node == null) {
            mo4284hitTestChildYqVAtuI(hitTestSource, j, hitTestResult, z, z2);
        } else {
            hitTestResult.hitInMinimumTouchTarget(node, f, z2, new NodeCoordinator$hitNear$1(this, node, hitTestSource, j, hitTestResult, z, z2, f));
        }
    }

    /* JADX INFO: renamed from: offsetFromEdge-MK-Hz9U, reason: not valid java name */
    private final long m4348offsetFromEdgeMKHz9U(long j) {
        float fM2798getXimpl = Offset.m2798getXimpl(j);
        float fMax = Math.max(0.0f, fM2798getXimpl < 0.0f ? -fM2798getXimpl : fM2798getXimpl - getMeasuredWidth());
        float fM2799getYimpl = Offset.m2799getYimpl(j);
        return OffsetKt.Offset(fMax, Math.max(0.0f, fM2799getYimpl < 0.0f ? -fM2799getYimpl : fM2799getYimpl - getMeasuredHeight()));
    }

    /* JADX INFO: renamed from: placeSelf-f8xVGno, reason: not valid java name */
    private final void m4349placeSelff8xVGno(long j, float f, InterfaceC3750qp interfaceC3750qp) {
        updateLayerBlock$default(this, interfaceC3750qp, false, 2, null);
        if (!IntOffset.m5277equalsimpl0(mo4321getPositionnOccac(), j)) {
            m4363setPositiongyyYBs(j);
            getLayoutNode().getLayoutDelegate$ui_release().getMeasurePassDelegate$ui_release().notifyChildrenUsingCoordinatesWhilePlacing();
            OwnedLayer ownedLayer = this.layer;
            if (ownedLayer != null) {
                ownedLayer.mo4426movegyyYBs(j);
            } else {
                NodeCoordinator nodeCoordinator = this.wrappedBy;
                if (nodeCoordinator != null) {
                    nodeCoordinator.invalidateLayer();
                }
            }
            invalidateAlignmentLinesFromPositionChange(this);
            Owner owner$ui_release = getLayoutNode().getOwner$ui_release();
            if (owner$ui_release != null) {
                owner$ui_release.onLayoutChange(getLayoutNode());
            }
        }
        this.zIndex = f;
    }

    public static /* synthetic */ Object propagateRelocationRequest$suspendImpl(NodeCoordinator nodeCoordinator, Rect rect, InterfaceC0793Of interfaceC0793Of) {
        NodeCoordinator nodeCoordinator2 = nodeCoordinator.wrappedBy;
        if (nodeCoordinator2 == null) {
            return FW.a;
        }
        Object objPropagateRelocationRequest = nodeCoordinator2.propagateRelocationRequest(rect.m2835translatek4lQ0M(nodeCoordinator2.localBoundingBoxOf(nodeCoordinator, false).m2833getTopLeftF1C5BW0()), interfaceC0793Of);
        return objPropagateRelocationRequest == AbstractC0378Bt.d() ? objPropagateRelocationRequest : FW.a;
    }

    public static /* synthetic */ void rectInParent$ui_release$default(NodeCoordinator nodeCoordinator, MutableRect mutableRect, boolean z, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: rectInParent");
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        nodeCoordinator.rectInParent$ui_release(mutableRect, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: speculativeHit-JHbHoSQ, reason: not valid java name */
    public final void m4350speculativeHitJHbHoSQ(Modifier.Node node, HitTestSource hitTestSource, long j, HitTestResult hitTestResult, boolean z, boolean z2, float f) {
        if (node == null) {
            mo4284hitTestChildYqVAtuI(hitTestSource, j, hitTestResult, z, z2);
        } else if (hitTestSource.interceptOutOfBoundsChildEvents(node)) {
            hitTestResult.speculativeHit(node, f, z2, new NodeCoordinator$speculativeHit$1(this, node, hitTestSource, j, hitTestResult, z, z2, f));
        } else {
            m4350speculativeHitJHbHoSQ(NodeCoordinatorKt.m4376nextUntilhw7D004(node, hitTestSource.mo4368entityTypeOLwlOKw(), NodeKind.m4378constructorimpl(2)), hitTestSource, j, hitTestResult, z, z2, f);
        }
    }

    private final NodeCoordinator toCoordinator(LayoutCoordinates layoutCoordinates) {
        NodeCoordinator coordinator;
        LookaheadLayoutCoordinatesImpl lookaheadLayoutCoordinatesImpl = layoutCoordinates instanceof LookaheadLayoutCoordinatesImpl ? (LookaheadLayoutCoordinatesImpl) layoutCoordinates : null;
        if (lookaheadLayoutCoordinatesImpl != null && (coordinator = lookaheadLayoutCoordinatesImpl.getCoordinator()) != null) {
            return coordinator;
        }
        AbstractC4492zt.f(layoutCoordinates, "null cannot be cast to non-null type androidx.compose.ui.node.NodeCoordinator");
        return (NodeCoordinator) layoutCoordinates;
    }

    /* JADX INFO: renamed from: transformFromAncestor-EL8BTi8, reason: not valid java name */
    private final void m4351transformFromAncestorEL8BTi8(NodeCoordinator nodeCoordinator, float[] fArr) {
        if (AbstractC4492zt.d(nodeCoordinator, this)) {
            return;
        }
        NodeCoordinator nodeCoordinator2 = this.wrappedBy;
        AbstractC4492zt.e(nodeCoordinator2);
        nodeCoordinator2.m4351transformFromAncestorEL8BTi8(nodeCoordinator, fArr);
        if (!IntOffset.m5277equalsimpl0(mo4321getPositionnOccac(), IntOffset.Companion.m5288getZeronOccac())) {
            float[] fArr2 = tmpMatrix;
            Matrix.m3246resetimpl(fArr2);
            Matrix.m3257translateimpl$default(fArr2, -IntOffset.m5278getXimpl(mo4321getPositionnOccac()), -IntOffset.m5279getYimpl(mo4321getPositionnOccac()), 0.0f, 4, null);
            Matrix.m3254timesAssign58bKbWc(fArr, fArr2);
        }
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.mo4423inverseTransform58bKbWc(fArr);
        }
    }

    /* JADX INFO: renamed from: transformToAncestor-EL8BTi8, reason: not valid java name */
    private final void m4352transformToAncestorEL8BTi8(NodeCoordinator nodeCoordinator, float[] fArr) {
        NodeCoordinator nodeCoordinator2 = this;
        while (!AbstractC4492zt.d(nodeCoordinator2, nodeCoordinator)) {
            OwnedLayer ownedLayer = nodeCoordinator2.layer;
            if (ownedLayer != null) {
                ownedLayer.mo4428transform58bKbWc(fArr);
            }
            long jMo4321getPositionnOccac = nodeCoordinator2.mo4321getPositionnOccac();
            if (!IntOffset.m5277equalsimpl0(jMo4321getPositionnOccac, IntOffset.Companion.m5288getZeronOccac())) {
                float[] fArr2 = tmpMatrix;
                Matrix.m3246resetimpl(fArr2);
                Matrix.m3257translateimpl$default(fArr2, IntOffset.m5278getXimpl(jMo4321getPositionnOccac), IntOffset.m5279getYimpl(jMo4321getPositionnOccac), 0.0f, 4, null);
                Matrix.m3254timesAssign58bKbWc(fArr, fArr2);
            }
            nodeCoordinator2 = nodeCoordinator2.wrappedBy;
            AbstractC4492zt.e(nodeCoordinator2);
        }
    }

    public static /* synthetic */ void updateLayerBlock$default(NodeCoordinator nodeCoordinator, InterfaceC3750qp interfaceC3750qp, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLayerBlock");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        nodeCoordinator.updateLayerBlock(interfaceC3750qp, z);
    }

    private final void updateLayerParameters(boolean z) {
        Owner owner$ui_release;
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer == null) {
            if (this.layerBlock != null) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            return;
        }
        InterfaceC3750qp interfaceC3750qp = this.layerBlock;
        if (interfaceC3750qp == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        ReusableGraphicsLayerScope reusableGraphicsLayerScope = graphicsLayerScope;
        reusableGraphicsLayerScope.reset();
        reusableGraphicsLayerScope.setGraphicsDensity$ui_release(getLayoutNode().getDensity());
        reusableGraphicsLayerScope.m3315setSizeuvyYCjk(IntSizeKt.m5330toSizeozmzZPI(mo4166getSizeYbymL2g()));
        getSnapshotObserver().observeReads$ui_release(this, onCommitAffectingLayerParams, new C16551(interfaceC3750qp));
        LayerPositionalProperties layerPositionalProperties = this.layerPositionalProperties;
        if (layerPositionalProperties == null) {
            layerPositionalProperties = new LayerPositionalProperties();
            this.layerPositionalProperties = layerPositionalProperties;
        }
        layerPositionalProperties.copyFrom(reusableGraphicsLayerScope);
        ownedLayer.mo4429updateLayerPropertiesdDxrwY(reusableGraphicsLayerScope.getScaleX(), reusableGraphicsLayerScope.getScaleY(), reusableGraphicsLayerScope.getAlpha(), reusableGraphicsLayerScope.getTranslationX(), reusableGraphicsLayerScope.getTranslationY(), reusableGraphicsLayerScope.getShadowElevation(), reusableGraphicsLayerScope.getRotationX(), reusableGraphicsLayerScope.getRotationY(), reusableGraphicsLayerScope.getRotationZ(), reusableGraphicsLayerScope.getCameraDistance(), reusableGraphicsLayerScope.mo3197getTransformOriginSzJe1aQ(), reusableGraphicsLayerScope.getShape(), reusableGraphicsLayerScope.getClip(), reusableGraphicsLayerScope.getRenderEffect(), reusableGraphicsLayerScope.mo3193getAmbientShadowColor0d7_KjU(), reusableGraphicsLayerScope.mo3196getSpotShadowColor0d7_KjU(), reusableGraphicsLayerScope.mo3194getCompositingStrategyNrFUSI(), getLayoutNode().getLayoutDirection(), getLayoutNode().getDensity());
        this.isClipping = reusableGraphicsLayerScope.getClip();
        this.lastLayerAlpha = reusableGraphicsLayerScope.getAlpha();
        if (!z || (owner$ui_release = getLayoutNode().getOwner$ui_release()) == null) {
            return;
        }
        owner$ui_release.onLayoutChange(getLayoutNode());
    }

    public static /* synthetic */ void updateLayerParameters$default(NodeCoordinator nodeCoordinator, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLayerParameters");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        nodeCoordinator.updateLayerParameters(z);
    }

    /* JADX INFO: renamed from: calculateMinimumTouchTargetPadding-E7KxVPU, reason: not valid java name */
    public final long m4353calculateMinimumTouchTargetPaddingE7KxVPU(long j) {
        return SizeKt.Size(Math.max(0.0f, (Size.m2867getWidthimpl(j) - getMeasuredWidth()) / 2.0f), Math.max(0.0f, (Size.m2864getHeightimpl(j) - getMeasuredHeight()) / 2.0f));
    }

    /* JADX INFO: renamed from: distanceInMinimumTouchTarget-tz77jQw, reason: not valid java name */
    public final float m4354distanceInMinimumTouchTargettz77jQw(long j, long j2) {
        if (getMeasuredWidth() >= Size.m2867getWidthimpl(j2) && getMeasuredHeight() >= Size.m2864getHeightimpl(j2)) {
            return Float.POSITIVE_INFINITY;
        }
        long jM4353calculateMinimumTouchTargetPaddingE7KxVPU = m4353calculateMinimumTouchTargetPaddingE7KxVPU(j2);
        float fM2867getWidthimpl = Size.m2867getWidthimpl(jM4353calculateMinimumTouchTargetPaddingE7KxVPU);
        float fM2864getHeightimpl = Size.m2864getHeightimpl(jM4353calculateMinimumTouchTargetPaddingE7KxVPU);
        long jM4348offsetFromEdgeMKHz9U = m4348offsetFromEdgeMKHz9U(j);
        if ((fM2867getWidthimpl > 0.0f || fM2864getHeightimpl > 0.0f) && Offset.m2798getXimpl(jM4348offsetFromEdgeMKHz9U) <= fM2867getWidthimpl && Offset.m2799getYimpl(jM4348offsetFromEdgeMKHz9U) <= fM2864getHeightimpl) {
            return Offset.m2797getDistanceSquaredimpl(jM4348offsetFromEdgeMKHz9U);
        }
        return Float.POSITIVE_INFINITY;
    }

    public final void draw(Canvas canvas) {
        AbstractC4492zt.h(canvas, HTML.Tag.CANVAS);
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.drawLayer(canvas);
            return;
        }
        float fM5278getXimpl = IntOffset.m5278getXimpl(mo4321getPositionnOccac());
        float fM5279getYimpl = IntOffset.m5279getYimpl(mo4321getPositionnOccac());
        canvas.translate(fM5278getXimpl, fM5279getYimpl);
        drawContainedDrawModifiers(canvas);
        canvas.translate(-fM5278getXimpl, -fM5279getYimpl);
    }

    public final void drawBorder(Canvas canvas, Paint paint) {
        AbstractC4492zt.h(canvas, HTML.Tag.CANVAS);
        AbstractC4492zt.h(paint, "paint");
        canvas.drawRect(new Rect(0.5f, 0.5f, IntSize.m5320getWidthimpl(m4199getMeasuredSizeYbymL2g()) - 0.5f, IntSize.m5319getHeightimpl(m4199getMeasuredSizeYbymL2g()) - 0.5f), paint);
    }

    public abstract void ensureLookaheadDelegateCreated();

    public final NodeCoordinator findCommonAncestor$ui_release(NodeCoordinator nodeCoordinator) {
        AbstractC4492zt.h(nodeCoordinator, "other");
        LayoutNode layoutNode = nodeCoordinator.getLayoutNode();
        LayoutNode layoutNode2 = getLayoutNode();
        if (layoutNode == layoutNode2) {
            Modifier.Node tail = nodeCoordinator.getTail();
            Modifier.Node tail2 = getTail();
            int iM4378constructorimpl = NodeKind.m4378constructorimpl(2);
            if (!tail2.getNode().isAttached()) {
                throw new IllegalStateException("visitLocalAncestors called on an unattached node");
            }
            for (Modifier.Node parent$ui_release = tail2.getNode().getParent$ui_release(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent$ui_release()) {
                if ((parent$ui_release.getKindSet$ui_release() & iM4378constructorimpl) != 0 && parent$ui_release == tail) {
                    return nodeCoordinator;
                }
            }
            return this;
        }
        while (layoutNode.getDepth$ui_release() > layoutNode2.getDepth$ui_release()) {
            layoutNode = layoutNode.getParent$ui_release();
            AbstractC4492zt.e(layoutNode);
        }
        while (layoutNode2.getDepth$ui_release() > layoutNode.getDepth$ui_release()) {
            layoutNode2 = layoutNode2.getParent$ui_release();
            AbstractC4492zt.e(layoutNode2);
        }
        while (layoutNode != layoutNode2) {
            layoutNode = layoutNode.getParent$ui_release();
            layoutNode2 = layoutNode2.getParent$ui_release();
            if (layoutNode == null || layoutNode2 == null) {
                throw new IllegalArgumentException("layouts are not part of the same hierarchy");
            }
        }
        if (layoutNode2 == getLayoutNode()) {
            return this;
        }
        return layoutNode == nodeCoordinator.getLayoutNode() ? nodeCoordinator : layoutNode.getInnerCoordinator$ui_release();
    }

    /* JADX INFO: renamed from: fromParentPosition-MK-Hz9U, reason: not valid java name */
    public long m4355fromParentPositionMKHz9U(long j) {
        long jM5290minusNvtHpc = IntOffsetKt.m5290minusNvtHpc(j, mo4321getPositionnOccac());
        OwnedLayer ownedLayer = this.layer;
        return ownedLayer != null ? ownedLayer.mo4425mapOffset8S9VItk(jM5290minusNvtHpc, true) : jM5290minusNvtHpc;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public AlignmentLinesOwner getAlignmentLinesOwner() {
        return getLayoutNode().getLayoutDelegate$ui_release().getAlignmentLinesOwner$ui_release();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LookaheadCapablePlaceable getChild() {
        return this.wrapped;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LayoutCoordinates getCoordinates() {
        return this;
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return getLayoutNode().getDensity().getDensity();
    }

    @Override // androidx.compose.ui.unit.Density
    public float getFontScale() {
        return getLayoutNode().getDensity().getFontScale();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public boolean getHasMeasureResult() {
        return this._measureResult != null;
    }

    public final boolean getLastLayerDrawingWasSkipped$ui_release() {
        return this.lastLayerDrawingWasSkipped;
    }

    /* JADX INFO: renamed from: getLastMeasurementConstraints-msEJaDk$ui_release, reason: not valid java name */
    public final long m4356getLastMeasurementConstraintsmsEJaDk$ui_release() {
        return m4200getMeasurementConstraintsmsEJaDk();
    }

    public final OwnedLayer getLayer() {
        return this.layer;
    }

    public final InterfaceC3750qp getLayerBlock() {
        return this.layerBlock;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public LayoutDirection getLayoutDirection() {
        return getLayoutNode().getLayoutDirection();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable, androidx.compose.ui.node.MeasureScopeWithLayoutNode
    public LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    public abstract LookaheadDelegate getLookaheadDelegate();

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public MeasureResult getMeasureResult$ui_release() {
        MeasureResult measureResult = this._measureResult;
        if (measureResult != null) {
            return measureResult;
        }
        throw new IllegalStateException(UnmeasuredError);
    }

    /* JADX INFO: renamed from: getMinimumTouchTargetSize-NH-jbRc, reason: not valid java name */
    public final long m4357getMinimumTouchTargetSizeNHjbRc() {
        return this.layerDensity.mo334toSizeXkaWNTQ(getLayoutNode().getViewConfiguration().mo4293getMinimumTouchTargetSizeMYxV2XQ());
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LookaheadCapablePlaceable getParent() {
        return this.wrappedBy;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final LayoutCoordinates getParentCoordinates() {
        if (!isAttached()) {
            throw new IllegalStateException(ExpectAttachedLayoutCoordinates);
        }
        onCoordinatesUsed$ui_release();
        return this.wrappedBy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v8 */
    @Override // androidx.compose.ui.layout.Placeable, androidx.compose.ui.layout.Measured, androidx.compose.ui.layout.IntrinsicMeasurable
    public Object getParentData() {
        if (!getLayoutNode().getNodes$ui_release().m4335hasH91voCI$ui_release(NodeKind.m4378constructorimpl(64))) {
            return null;
        }
        getTail();
        OJ oj = new OJ();
        for (Modifier.Node tail$ui_release = getLayoutNode().getNodes$ui_release().getTail$ui_release(); tail$ui_release != null; tail$ui_release = tail$ui_release.getParent$ui_release()) {
            if ((NodeKind.m4378constructorimpl(64) & tail$ui_release.getKindSet$ui_release()) != 0) {
                int iM4378constructorimpl = NodeKind.m4378constructorimpl(64);
                MutableVector mutableVector = null;
                Modifier.Node nodePop = tail$ui_release;
                while (nodePop != 0) {
                    if (nodePop instanceof ParentDataModifierNode) {
                        oj.a = ((ParentDataModifierNode) nodePop).modifyParentData(getLayoutNode().getDensity(), oj.a);
                    } else if ((nodePop.getKindSet$ui_release() & iM4378constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                        Modifier.Node delegate$ui_release = ((DelegatingNode) nodePop).getDelegate$ui_release();
                        int i = 0;
                        nodePop = nodePop;
                        while (delegate$ui_release != null) {
                            if ((delegate$ui_release.getKindSet$ui_release() & iM4378constructorimpl) != 0) {
                                i++;
                                if (i == 1) {
                                    nodePop = delegate$ui_release;
                                } else {
                                    if (mutableVector == null) {
                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                    }
                                    if (nodePop != 0) {
                                        mutableVector.add(nodePop);
                                        nodePop = 0;
                                    }
                                    mutableVector.add(delegate$ui_release);
                                }
                            }
                            delegate$ui_release = delegate$ui_release.getChild$ui_release();
                            nodePop = nodePop;
                        }
                        if (i == 1) {
                        }
                    }
                    nodePop = DelegatableNodeKt.pop(mutableVector);
                }
            }
        }
        return oj.a;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final LayoutCoordinates getParentLayoutCoordinates() {
        if (!isAttached()) {
            throw new IllegalStateException(ExpectAttachedLayoutCoordinates);
        }
        onCoordinatesUsed$ui_release();
        return getLayoutNode().getOuterCoordinator$ui_release().wrappedBy;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    /* JADX INFO: renamed from: getPosition-nOcc-ac */
    public long mo4321getPositionnOccac() {
        return this.position;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public Set<AlignmentLine> getProvidedAlignmentLines() {
        LinkedHashSet linkedHashSet = null;
        for (NodeCoordinator nodeCoordinator = this; nodeCoordinator != null; nodeCoordinator = nodeCoordinator.wrapped) {
            MeasureResult measureResult = nodeCoordinator._measureResult;
            Map<AlignmentLine, Integer> alignmentLines = measureResult != null ? measureResult.getAlignmentLines() : null;
            if (alignmentLines != null && (!alignmentLines.isEmpty())) {
                if (linkedHashSet == null) {
                    linkedHashSet = new LinkedHashSet();
                }
                linkedHashSet.addAll(alignmentLines.keySet());
            }
        }
        return linkedHashSet == null ? QO.e() : linkedHashSet;
    }

    public final MutableRect getRectCache() {
        MutableRect mutableRect = this._rectCache;
        if (mutableRect != null) {
            return mutableRect;
        }
        MutableRect mutableRect2 = new MutableRect(0.0f, 0.0f, 0.0f, 0.0f);
        this._rectCache = mutableRect2;
        return mutableRect2;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: getSize-YbymL2g */
    public final long mo4166getSizeYbymL2g() {
        return m4199getMeasuredSizeYbymL2g();
    }

    public abstract Modifier.Node getTail();

    public final NodeCoordinator getWrapped$ui_release() {
        return this.wrapped;
    }

    public final NodeCoordinator getWrappedBy$ui_release() {
        return this.wrappedBy;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    /* JADX INFO: renamed from: head-H91voCI, reason: not valid java name */
    public final Modifier.Node m4358headH91voCI(int i) {
        boolean zM4387getIncludeSelfInTraversalH91voCI = NodeKindKt.m4387getIncludeSelfInTraversalH91voCI(i);
        Modifier.Node tail = getTail();
        if (!zM4387getIncludeSelfInTraversalH91voCI && (tail = tail.getParent$ui_release()) == null) {
            return null;
        }
        for (Modifier.Node nodeHeadNode = headNode(zM4387getIncludeSelfInTraversalH91voCI); nodeHeadNode != null && (nodeHeadNode.getAggregateChildKindSet$ui_release() & i) != 0; nodeHeadNode = nodeHeadNode.getChild$ui_release()) {
            if ((nodeHeadNode.getKindSet$ui_release() & i) != 0) {
                return nodeHeadNode;
            }
            if (nodeHeadNode == tail) {
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: hitTest-YqVAtuI, reason: not valid java name */
    public final void m4359hitTestYqVAtuI(HitTestSource hitTestSource, long j, HitTestResult hitTestResult, boolean z, boolean z2) {
        AbstractC4492zt.h(hitTestSource, "hitTestSource");
        AbstractC4492zt.h(hitTestResult, "hitTestResult");
        Modifier.Node nodeM4358headH91voCI = m4358headH91voCI(hitTestSource.mo4368entityTypeOLwlOKw());
        if (!m4366withinLayerBoundsk4lQ0M(j)) {
            if (z) {
                float fM4354distanceInMinimumTouchTargettz77jQw = m4354distanceInMinimumTouchTargettz77jQw(j, m4357getMinimumTouchTargetSizeNHjbRc());
                if (Float.isInfinite(fM4354distanceInMinimumTouchTargettz77jQw) || Float.isNaN(fM4354distanceInMinimumTouchTargettz77jQw) || !hitTestResult.isHitInMinimumTouchTargetBetter(fM4354distanceInMinimumTouchTargettz77jQw, false)) {
                    return;
                }
                m4347hitNearJHbHoSQ(nodeM4358headH91voCI, hitTestSource, j, hitTestResult, z, false, fM4354distanceInMinimumTouchTargettz77jQw);
                return;
            }
            return;
        }
        if (nodeM4358headH91voCI == null) {
            mo4284hitTestChildYqVAtuI(hitTestSource, j, hitTestResult, z, z2);
            return;
        }
        if (m4360isPointerInBoundsk4lQ0M(j)) {
            m4346hit1hIXUjU(nodeM4358headH91voCI, hitTestSource, j, hitTestResult, z, z2);
            return;
        }
        float fM4354distanceInMinimumTouchTargettz77jQw2 = !z ? Float.POSITIVE_INFINITY : m4354distanceInMinimumTouchTargettz77jQw(j, m4357getMinimumTouchTargetSizeNHjbRc());
        if (!Float.isInfinite(fM4354distanceInMinimumTouchTargettz77jQw2) && !Float.isNaN(fM4354distanceInMinimumTouchTargettz77jQw2)) {
            if (hitTestResult.isHitInMinimumTouchTargetBetter(fM4354distanceInMinimumTouchTargettz77jQw2, z2)) {
                m4347hitNearJHbHoSQ(nodeM4358headH91voCI, hitTestSource, j, hitTestResult, z, z2, fM4354distanceInMinimumTouchTargettz77jQw2);
                return;
            }
        }
        m4350speculativeHitJHbHoSQ(nodeM4358headH91voCI, hitTestSource, j, hitTestResult, z, z2, fM4354distanceInMinimumTouchTargettz77jQw2);
    }

    /* JADX INFO: renamed from: hitTestChild-YqVAtuI */
    public void mo4284hitTestChildYqVAtuI(HitTestSource hitTestSource, long j, HitTestResult hitTestResult, boolean z, boolean z2) {
        AbstractC4492zt.h(hitTestSource, "hitTestSource");
        AbstractC4492zt.h(hitTestResult, "hitTestResult");
        NodeCoordinator nodeCoordinator = this.wrapped;
        if (nodeCoordinator != null) {
            nodeCoordinator.m4359hitTestYqVAtuI(hitTestSource, nodeCoordinator.m4355fromParentPositionMKHz9U(j), hitTestResult, z, z2);
        }
    }

    public void invalidateLayer() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
            return;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            nodeCoordinator.invalidateLayer();
        }
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Canvas) obj);
        return FW.a;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public boolean isAttached() {
        return !this.released && getLayoutNode().isAttached();
    }

    /* JADX INFO: renamed from: isPointerInBounds-k-4lQ0M, reason: not valid java name */
    public final boolean m4360isPointerInBoundsk4lQ0M(long j) {
        float fM2798getXimpl = Offset.m2798getXimpl(j);
        float fM2799getYimpl = Offset.m2799getYimpl(j);
        return fM2798getXimpl >= 0.0f && fM2799getYimpl >= 0.0f && fM2798getXimpl < ((float) getMeasuredWidth()) && fM2799getYimpl < ((float) getMeasuredHeight());
    }

    public final boolean isTransparent() {
        if (this.layer != null && this.lastLayerAlpha <= 0.0f) {
            return true;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            return nodeCoordinator.isTransparent();
        }
        return false;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public boolean isValidOwnerScope() {
        return this.layer != null && isAttached();
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public Rect localBoundingBoxOf(LayoutCoordinates layoutCoordinates, boolean z) {
        AbstractC4492zt.h(layoutCoordinates, "sourceCoordinates");
        if (!isAttached()) {
            throw new IllegalStateException(ExpectAttachedLayoutCoordinates);
        }
        if (!layoutCoordinates.isAttached()) {
            throw new IllegalStateException(("LayoutCoordinates " + layoutCoordinates + " is not attached!").toString());
        }
        NodeCoordinator coordinator = toCoordinator(layoutCoordinates);
        coordinator.onCoordinatesUsed$ui_release();
        NodeCoordinator nodeCoordinatorFindCommonAncestor$ui_release = findCommonAncestor$ui_release(coordinator);
        MutableRect rectCache = getRectCache();
        rectCache.setLeft(0.0f);
        rectCache.setTop(0.0f);
        rectCache.setRight(IntSize.m5320getWidthimpl(layoutCoordinates.mo4166getSizeYbymL2g()));
        rectCache.setBottom(IntSize.m5319getHeightimpl(layoutCoordinates.mo4166getSizeYbymL2g()));
        while (coordinator != nodeCoordinatorFindCommonAncestor$ui_release) {
            rectInParent$ui_release$default(coordinator, rectCache, z, false, 4, null);
            if (rectCache.isEmpty()) {
                return Rect.Companion.getZero();
            }
            coordinator = coordinator.wrappedBy;
            AbstractC4492zt.e(coordinator);
        }
        ancestorToLocal(nodeCoordinatorFindCommonAncestor$ui_release, rectCache, z);
        return MutableRectKt.toRect(rectCache);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localPositionOf-R5De75A */
    public long mo4167localPositionOfR5De75A(LayoutCoordinates layoutCoordinates, long j) {
        AbstractC4492zt.h(layoutCoordinates, "sourceCoordinates");
        if (layoutCoordinates instanceof LookaheadLayoutCoordinatesImpl) {
            return Offset.m2807unaryMinusF1C5BW0(layoutCoordinates.mo4167localPositionOfR5De75A(this, Offset.m2807unaryMinusF1C5BW0(j)));
        }
        NodeCoordinator coordinator = toCoordinator(layoutCoordinates);
        coordinator.onCoordinatesUsed$ui_release();
        NodeCoordinator nodeCoordinatorFindCommonAncestor$ui_release = findCommonAncestor$ui_release(coordinator);
        while (coordinator != nodeCoordinatorFindCommonAncestor$ui_release) {
            j = coordinator.m4364toParentPositionMKHz9U(j);
            coordinator = coordinator.wrappedBy;
            AbstractC4492zt.e(coordinator);
        }
        return m4344ancestorToLocalR5De75A(nodeCoordinatorFindCommonAncestor$ui_release, j);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localToRoot-MK-Hz9U */
    public long mo4168localToRootMKHz9U(long j) {
        if (!isAttached()) {
            throw new IllegalStateException(ExpectAttachedLayoutCoordinates);
        }
        onCoordinatesUsed$ui_release();
        for (NodeCoordinator nodeCoordinator = this; nodeCoordinator != null; nodeCoordinator = nodeCoordinator.wrappedBy) {
            j = nodeCoordinator.m4364toParentPositionMKHz9U(j);
        }
        return j;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: localToWindow-MK-Hz9U */
    public long mo4169localToWindowMKHz9U(long j) {
        return LayoutNodeKt.requireOwner(getLayoutNode()).mo4431calculatePositionInWindowMKHz9U(mo4168localToRootMKHz9U(j));
    }

    public final void onCoordinatesUsed$ui_release() {
        getLayoutNode().getLayoutDelegate$ui_release().onCoordinatesUsed();
    }

    public void onLayoutModifierNodeChanged() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
        }
    }

    public final void onLayoutNodeAttach() {
        updateLayerBlock(this.layerBlock, true);
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v6 */
    public void onMeasureResultChanged(int i, int i2) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.mo4427resizeozmzZPI(IntSizeKt.IntSize(i, i2));
        } else {
            NodeCoordinator nodeCoordinator = this.wrappedBy;
            if (nodeCoordinator != null) {
                nodeCoordinator.invalidateLayer();
            }
        }
        m4201setMeasuredSizeozmzZPI(IntSizeKt.IntSize(i, i2));
        updateLayerParameters(false);
        int iM4378constructorimpl = NodeKind.m4378constructorimpl(4);
        boolean zM4387getIncludeSelfInTraversalH91voCI = NodeKindKt.m4387getIncludeSelfInTraversalH91voCI(iM4378constructorimpl);
        Modifier.Node tail = getTail();
        if (zM4387getIncludeSelfInTraversalH91voCI || (tail = tail.getParent$ui_release()) != null) {
            for (Modifier.Node nodeHeadNode = headNode(zM4387getIncludeSelfInTraversalH91voCI); nodeHeadNode != null && (nodeHeadNode.getAggregateChildKindSet$ui_release() & iM4378constructorimpl) != 0; nodeHeadNode = nodeHeadNode.getChild$ui_release()) {
                if ((nodeHeadNode.getKindSet$ui_release() & iM4378constructorimpl) != 0) {
                    Modifier.Node nodePop = nodeHeadNode;
                    MutableVector mutableVector = null;
                    while (nodePop != 0) {
                        if (nodePop instanceof DrawModifierNode) {
                            ((DrawModifierNode) nodePop).onMeasureResultChanged();
                        } else if ((nodePop.getKindSet$ui_release() & iM4378constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                            Modifier.Node delegate$ui_release = ((DelegatingNode) nodePop).getDelegate$ui_release();
                            int i3 = 0;
                            nodePop = nodePop;
                            while (delegate$ui_release != null) {
                                if ((delegate$ui_release.getKindSet$ui_release() & iM4378constructorimpl) != 0) {
                                    i3++;
                                    if (i3 == 1) {
                                        nodePop = delegate$ui_release;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (nodePop != 0) {
                                            mutableVector.add(nodePop);
                                            nodePop = 0;
                                        }
                                        mutableVector.add(delegate$ui_release);
                                    }
                                }
                                delegate$ui_release = delegate$ui_release.getChild$ui_release();
                                nodePop = nodePop;
                            }
                            if (i3 == 1) {
                            }
                        }
                        nodePop = DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if (nodeHeadNode == tail) {
                    break;
                }
            }
        }
        Owner owner$ui_release = getLayoutNode().getOwner$ui_release();
        if (owner$ui_release != null) {
            owner$ui_release.onLayoutChange(getLayoutNode());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v6 */
    /*  JADX ERROR: NullPointerException in pass: PrepareForCodeGen
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.RegisterArg.getSVar()" because "result" is null
        	at jadx.core.dex.visitors.PrepareForCodeGen.removeInstructions(PrepareForCodeGen.java:118)
        	at jadx.core.dex.visitors.PrepareForCodeGen.visit(PrepareForCodeGen.java:85)
        */
    public final void onMeasured() {
        /*
            r13 = this;
            r0 = 1
            r1 = 128(0x80, float:1.8E-43)
            int r2 = androidx.compose.ui.node.NodeKind.m4378constructorimpl(r1)
            boolean r2 = r13.m4345hasNodeH91voCI(r2)
            if (r2 == 0) goto Lb9
            androidx.compose.runtime.snapshots.Snapshot$Companion r2 = androidx.compose.runtime.snapshots.Snapshot.Companion
            androidx.compose.runtime.snapshots.Snapshot r2 = r2.createNonObservableSnapshot()
            androidx.compose.runtime.snapshots.Snapshot r3 = r2.makeCurrent()     // Catch: java.lang.Throwable -> Laf
            int r1 = androidx.compose.ui.node.NodeKind.m4378constructorimpl(r1)     // Catch: java.lang.Throwable -> L26
            boolean r4 = androidx.compose.ui.node.NodeKindKt.m4387getIncludeSelfInTraversalH91voCI(r1)     // Catch: java.lang.Throwable -> L26
            if (r4 == 0) goto L29
            androidx.compose.ui.Modifier$Node r5 = r13.getTail()     // Catch: java.lang.Throwable -> L26
            goto L35
        L26:
            r0 = move-exception
            goto Lb1
        L29:
            androidx.compose.ui.Modifier$Node r5 = r13.getTail()     // Catch: java.lang.Throwable -> L26
            androidx.compose.ui.Modifier$Node r5 = r5.getParent$ui_release()     // Catch: java.lang.Throwable -> L26
            if (r5 != 0) goto L35
            goto La6
        L35:
            androidx.compose.ui.Modifier$Node r4 = access$headNode(r13, r4)     // Catch: java.lang.Throwable -> L26
        L39:
            if (r4 == 0) goto La6
            int r6 = r4.getAggregateChildKindSet$ui_release()     // Catch: java.lang.Throwable -> L26
            r6 = r6 & r1
            if (r6 == 0) goto La6
            int r6 = r4.getKindSet$ui_release()     // Catch: java.lang.Throwable -> L26
            r6 = r6 & r1
            if (r6 == 0) goto L9f
            r6 = 0
            r7 = r4
            r8 = r6
        L4c:
            if (r7 == 0) goto L9f
            boolean r9 = r7 instanceof androidx.compose.ui.node.LayoutAwareModifierNode     // Catch: java.lang.Throwable -> L26
            if (r9 == 0) goto L5c
            androidx.compose.ui.node.LayoutAwareModifierNode r7 = (androidx.compose.ui.node.LayoutAwareModifierNode) r7     // Catch: java.lang.Throwable -> L26
            long r9 = r13.m4199getMeasuredSizeYbymL2g()     // Catch: java.lang.Throwable -> L26
            r7.mo222onRemeasuredozmzZPI(r9)     // Catch: java.lang.Throwable -> L26
            goto L9a
        L5c:
            int r9 = r7.getKindSet$ui_release()     // Catch: java.lang.Throwable -> L26
            r9 = r9 & r1
            if (r9 == 0) goto L9a
            boolean r9 = r7 instanceof androidx.compose.ui.node.DelegatingNode     // Catch: java.lang.Throwable -> L26
            if (r9 == 0) goto L9a
            r9 = r7
            androidx.compose.ui.node.DelegatingNode r9 = (androidx.compose.ui.node.DelegatingNode) r9     // Catch: java.lang.Throwable -> L26
            androidx.compose.ui.Modifier$Node r9 = r9.getDelegate$ui_release()     // Catch: java.lang.Throwable -> L26
            r10 = 0
            r11 = 0
        L70:
            if (r9 == 0) goto L97
            int r12 = r9.getKindSet$ui_release()     // Catch: java.lang.Throwable -> L26
            r12 = r12 & r1
            if (r12 == 0) goto L92
            int r11 = r11 + r0
            if (r11 != r0) goto L7e
            r7 = r9
            goto L92
        L7e:
            if (r8 != 0) goto L89
            androidx.compose.runtime.collection.MutableVector r8 = new androidx.compose.runtime.collection.MutableVector     // Catch: java.lang.Throwable -> L26
            r12 = 16
            androidx.compose.ui.Modifier$Node[] r12 = new androidx.compose.ui.Modifier.Node[r12]     // Catch: java.lang.Throwable -> L26
            r8.<init>(r12, r10)     // Catch: java.lang.Throwable -> L26
        L89:
            if (r7 == 0) goto L8f
            r8.add(r7)     // Catch: java.lang.Throwable -> L26
            r7 = r6
        L8f:
            r8.add(r9)     // Catch: java.lang.Throwable -> L26
        L92:
            androidx.compose.ui.Modifier$Node r9 = r9.getChild$ui_release()     // Catch: java.lang.Throwable -> L26
            goto L70
        L97:
            if (r11 != r0) goto L9a
            goto L4c
        L9a:
            androidx.compose.ui.Modifier$Node r7 = androidx.compose.ui.node.DelegatableNodeKt.access$pop(r8)     // Catch: java.lang.Throwable -> L26
            goto L4c
        L9f:
            if (r4 == r5) goto La6
            androidx.compose.ui.Modifier$Node r4 = r4.getChild$ui_release()     // Catch: java.lang.Throwable -> L26
            goto L39
        La6:
            FW r0 = defpackage.FW.a     // Catch: java.lang.Throwable -> L26
            r2.restoreCurrent(r3)     // Catch: java.lang.Throwable -> Laf
            r2.dispose()
            goto Lb9
        Laf:
            r0 = move-exception
            goto Lb5
        Lb1:
            r2.restoreCurrent(r3)     // Catch: java.lang.Throwable -> Laf
            throw r0     // Catch: java.lang.Throwable -> Laf
        Lb5:
            r2.dispose()
            throw r0
        Lb9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.NodeCoordinator.onMeasured():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6 */
    public final void onPlaced() {
        int iM4378constructorimpl = NodeKind.m4378constructorimpl(128);
        boolean zM4387getIncludeSelfInTraversalH91voCI = NodeKindKt.m4387getIncludeSelfInTraversalH91voCI(iM4378constructorimpl);
        Modifier.Node tail = getTail();
        if (!zM4387getIncludeSelfInTraversalH91voCI && (tail = tail.getParent$ui_release()) == null) {
            return;
        }
        for (Modifier.Node nodeHeadNode = headNode(zM4387getIncludeSelfInTraversalH91voCI); nodeHeadNode != null && (nodeHeadNode.getAggregateChildKindSet$ui_release() & iM4378constructorimpl) != 0; nodeHeadNode = nodeHeadNode.getChild$ui_release()) {
            if ((nodeHeadNode.getKindSet$ui_release() & iM4378constructorimpl) != 0) {
                Modifier.Node nodePop = nodeHeadNode;
                MutableVector mutableVector = null;
                while (nodePop != 0) {
                    if (nodePop instanceof LayoutAwareModifierNode) {
                        ((LayoutAwareModifierNode) nodePop).onPlaced(this);
                    } else if ((nodePop.getKindSet$ui_release() & iM4378constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                        Modifier.Node delegate$ui_release = ((DelegatingNode) nodePop).getDelegate$ui_release();
                        int i = 0;
                        nodePop = nodePop;
                        while (delegate$ui_release != null) {
                            if ((delegate$ui_release.getKindSet$ui_release() & iM4378constructorimpl) != 0) {
                                i++;
                                if (i == 1) {
                                    nodePop = delegate$ui_release;
                                } else {
                                    if (mutableVector == null) {
                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                    }
                                    if (nodePop != 0) {
                                        mutableVector.add(nodePop);
                                        nodePop = 0;
                                    }
                                    mutableVector.add(delegate$ui_release);
                                }
                            }
                            delegate$ui_release = delegate$ui_release.getChild$ui_release();
                            nodePop = nodePop;
                        }
                        if (i == 1) {
                        }
                    }
                    nodePop = DelegatableNodeKt.pop(mutableVector);
                }
            }
            if (nodeHeadNode == tail) {
                return;
            }
        }
    }

    public final void onRelease() {
        this.released = true;
        if (this.layer != null) {
            updateLayerBlock$default(this, null, false, 2, null);
        }
    }

    public void performDraw(Canvas canvas) {
        AbstractC4492zt.h(canvas, HTML.Tag.CANVAS);
        NodeCoordinator nodeCoordinator = this.wrapped;
        if (nodeCoordinator != null) {
            nodeCoordinator.draw(canvas);
        }
    }

    /* JADX INFO: renamed from: performingMeasure-K40F9xA, reason: not valid java name */
    public final Placeable m4361performingMeasureK40F9xA(long j, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3588op, CSS.Value.BLOCK);
        m4202setMeasurementConstraintsBRTryo0(j);
        return (Placeable) interfaceC3588op.invoke();
    }

    @Override // androidx.compose.ui.layout.Placeable
    /* JADX INFO: renamed from: placeAt-f8xVGno */
    public void mo4160placeAtf8xVGno(long j, float f, InterfaceC3750qp interfaceC3750qp) {
        m4349placeSelff8xVGno(j, f, interfaceC3750qp);
    }

    /* JADX INFO: renamed from: placeSelfApparentToRealOffset-f8xVGno, reason: not valid java name */
    public final void m4362placeSelfApparentToRealOffsetf8xVGno(long j, float f, InterfaceC3750qp interfaceC3750qp) {
        long jM4198getApparentToRealOffsetnOccac = m4198getApparentToRealOffsetnOccac();
        m4349placeSelff8xVGno(IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(j) + IntOffset.m5278getXimpl(jM4198getApparentToRealOffsetnOccac), IntOffset.m5279getYimpl(j) + IntOffset.m5279getYimpl(jM4198getApparentToRealOffsetnOccac)), f, interfaceC3750qp);
    }

    public Object propagateRelocationRequest(Rect rect, InterfaceC0793Of interfaceC0793Of) {
        return propagateRelocationRequest$suspendImpl(this, rect, interfaceC0793Of);
    }

    public final void rectInParent$ui_release(MutableRect mutableRect, boolean z, boolean z2) {
        AbstractC4492zt.h(mutableRect, "bounds");
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            if (this.isClipping) {
                if (z2) {
                    long jM4357getMinimumTouchTargetSizeNHjbRc = m4357getMinimumTouchTargetSizeNHjbRc();
                    float fM2867getWidthimpl = Size.m2867getWidthimpl(jM4357getMinimumTouchTargetSizeNHjbRc) / 2.0f;
                    float fM2864getHeightimpl = Size.m2864getHeightimpl(jM4357getMinimumTouchTargetSizeNHjbRc) / 2.0f;
                    mutableRect.intersect(-fM2867getWidthimpl, -fM2864getHeightimpl, IntSize.m5320getWidthimpl(mo4166getSizeYbymL2g()) + fM2867getWidthimpl, IntSize.m5319getHeightimpl(mo4166getSizeYbymL2g()) + fM2864getHeightimpl);
                } else if (z) {
                    mutableRect.intersect(0.0f, 0.0f, IntSize.m5320getWidthimpl(mo4166getSizeYbymL2g()), IntSize.m5319getHeightimpl(mo4166getSizeYbymL2g()));
                }
                if (mutableRect.isEmpty()) {
                    return;
                }
            }
            ownedLayer.mapBounds(mutableRect, false);
        }
        float fM5278getXimpl = IntOffset.m5278getXimpl(mo4321getPositionnOccac());
        mutableRect.setLeft(mutableRect.getLeft() + fM5278getXimpl);
        mutableRect.setRight(mutableRect.getRight() + fM5278getXimpl);
        float fM5279getYimpl = IntOffset.m5279getYimpl(mo4321getPositionnOccac());
        mutableRect.setTop(mutableRect.getTop() + fM5279getYimpl);
        mutableRect.setBottom(mutableRect.getBottom() + fM5279getYimpl);
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public void replace$ui_release() {
        mo4160placeAtf8xVGno(mo4321getPositionnOccac(), this.zIndex, this.layerBlock);
    }

    public abstract void setLookaheadDelegate(LookaheadDelegate lookaheadDelegate);

    public void setMeasureResult$ui_release(MeasureResult measureResult) {
        AbstractC4492zt.h(measureResult, "value");
        MeasureResult measureResult2 = this._measureResult;
        if (measureResult != measureResult2) {
            this._measureResult = measureResult;
            if (measureResult2 == null || measureResult.getWidth() != measureResult2.getWidth() || measureResult.getHeight() != measureResult2.getHeight()) {
                onMeasureResultChanged(measureResult.getWidth(), measureResult.getHeight());
            }
            Map<AlignmentLine, Integer> map = this.oldAlignmentLines;
            if (((map == null || map.isEmpty()) && measureResult.getAlignmentLines().isEmpty()) || AbstractC4492zt.d(measureResult.getAlignmentLines(), this.oldAlignmentLines)) {
                return;
            }
            getAlignmentLinesOwner().getAlignmentLines().onAlignmentsChanged();
            Map linkedHashMap = this.oldAlignmentLines;
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap();
                this.oldAlignmentLines = linkedHashMap;
            }
            linkedHashMap.clear();
            linkedHashMap.putAll(measureResult.getAlignmentLines());
        }
    }

    /* JADX INFO: renamed from: setPosition--gyyYBs, reason: not valid java name */
    public void m4363setPositiongyyYBs(long j) {
        this.position = j;
    }

    public final void setWrapped$ui_release(NodeCoordinator nodeCoordinator) {
        this.wrapped = nodeCoordinator;
    }

    public final void setWrappedBy$ui_release(NodeCoordinator nodeCoordinator) {
        this.wrappedBy = nodeCoordinator;
    }

    public final void setZIndex(float f) {
        this.zIndex = f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v7 */
    /*  JADX ERROR: NullPointerException in pass: PrepareForCodeGen
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.RegisterArg.getSVar()" because "result" is null
        	at jadx.core.dex.visitors.PrepareForCodeGen.removeInstructions(PrepareForCodeGen.java:118)
        	at jadx.core.dex.visitors.PrepareForCodeGen.visit(PrepareForCodeGen.java:85)
        */
    public final boolean shouldSharePointerInputWithSiblings() {
        /*
            r11 = this;
            r0 = 16
            int r1 = androidx.compose.ui.node.NodeKind.m4378constructorimpl(r0)
            boolean r1 = androidx.compose.ui.node.NodeKindKt.m4387getIncludeSelfInTraversalH91voCI(r1)
            androidx.compose.ui.Modifier$Node r1 = r11.headNode(r1)
            r2 = 0
            if (r1 != 0) goto L12
            return r2
        L12:
            int r3 = androidx.compose.ui.node.NodeKind.m4378constructorimpl(r0)
            androidx.compose.ui.Modifier$Node r4 = r1.getNode()
            boolean r4 = r4.isAttached()
            if (r4 == 0) goto L92
            androidx.compose.ui.Modifier$Node r1 = r1.getNode()
            int r4 = r1.getAggregateChildKindSet$ui_release()
            r4 = r4 & r3
            if (r4 == 0) goto L91
            androidx.compose.ui.Modifier$Node r1 = r1.getChild$ui_release()
        L2f:
            if (r1 == 0) goto L91
            int r4 = r1.getKindSet$ui_release()
            r4 = r4 & r3
            if (r4 == 0) goto L8c
            r4 = 0
            r5 = r1
            r6 = r4
        L3b:
            if (r5 == 0) goto L8c
            boolean r7 = r5 instanceof androidx.compose.ui.node.PointerInputModifierNode
            r8 = 1
            if (r7 == 0) goto L4b
            androidx.compose.ui.node.PointerInputModifierNode r5 = (androidx.compose.ui.node.PointerInputModifierNode) r5
            boolean r5 = r5.sharePointerInputWithSiblings()
            if (r5 == 0) goto L87
            return r8
        L4b:
            int r7 = r5.getKindSet$ui_release()
            r7 = r7 & r3
            if (r7 == 0) goto L87
            boolean r7 = r5 instanceof androidx.compose.ui.node.DelegatingNode
            if (r7 == 0) goto L87
            r7 = r5
            androidx.compose.ui.node.DelegatingNode r7 = (androidx.compose.ui.node.DelegatingNode) r7
            androidx.compose.ui.Modifier$Node r7 = r7.getDelegate$ui_release()
            r9 = 0
        L5e:
            if (r7 == 0) goto L84
            int r10 = r7.getKindSet$ui_release()
            r10 = r10 & r3
            if (r10 == 0) goto L7f
            int r9 = r9 + 1
            if (r9 != r8) goto L6d
            r5 = r7
            goto L7f
        L6d:
            if (r6 != 0) goto L76
            androidx.compose.runtime.collection.MutableVector r6 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r10 = new androidx.compose.ui.Modifier.Node[r0]
            r6.<init>(r10, r2)
        L76:
            if (r5 == 0) goto L7c
            r6.add(r5)
            r5 = r4
        L7c:
            r6.add(r7)
        L7f:
            androidx.compose.ui.Modifier$Node r7 = r7.getChild$ui_release()
            goto L5e
        L84:
            if (r9 != r8) goto L87
            goto L3b
        L87:
            androidx.compose.ui.Modifier$Node r5 = androidx.compose.ui.node.DelegatableNodeKt.access$pop(r6)
            goto L3b
        L8c:
            androidx.compose.ui.Modifier$Node r1 = r1.getChild$ui_release()
            goto L2f
        L91:
            return r2
        L92:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "visitLocalDescendants called on an unattached node"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.NodeCoordinator.shouldSharePointerInputWithSiblings():boolean");
    }

    /* JADX INFO: renamed from: toParentPosition-MK-Hz9U, reason: not valid java name */
    public long m4364toParentPositionMKHz9U(long j) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            j = ownedLayer.mo4425mapOffset8S9VItk(j, false);
        }
        return IntOffsetKt.m5292plusNvtHpc(j, mo4321getPositionnOccac());
    }

    public final Rect touchBoundsInRoot() {
        if (!isAttached()) {
            return Rect.Companion.getZero();
        }
        LayoutCoordinates layoutCoordinatesFindRootCoordinates = LayoutCoordinatesKt.findRootCoordinates(this);
        MutableRect rectCache = getRectCache();
        long jM4353calculateMinimumTouchTargetPaddingE7KxVPU = m4353calculateMinimumTouchTargetPaddingE7KxVPU(m4357getMinimumTouchTargetSizeNHjbRc());
        rectCache.setLeft(-Size.m2867getWidthimpl(jM4353calculateMinimumTouchTargetPaddingE7KxVPU));
        rectCache.setTop(-Size.m2864getHeightimpl(jM4353calculateMinimumTouchTargetPaddingE7KxVPU));
        rectCache.setRight(getMeasuredWidth() + Size.m2867getWidthimpl(jM4353calculateMinimumTouchTargetPaddingE7KxVPU));
        rectCache.setBottom(getMeasuredHeight() + Size.m2864getHeightimpl(jM4353calculateMinimumTouchTargetPaddingE7KxVPU));
        NodeCoordinator nodeCoordinator = this;
        while (nodeCoordinator != layoutCoordinatesFindRootCoordinates) {
            nodeCoordinator.rectInParent$ui_release(rectCache, false, true);
            if (rectCache.isEmpty()) {
                return Rect.Companion.getZero();
            }
            nodeCoordinator = nodeCoordinator.wrappedBy;
            AbstractC4492zt.e(nodeCoordinator);
        }
        return MutableRectKt.toRect(rectCache);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: transformFrom-EL8BTi8 */
    public void mo4170transformFromEL8BTi8(LayoutCoordinates layoutCoordinates, float[] fArr) {
        AbstractC4492zt.h(layoutCoordinates, "sourceCoordinates");
        AbstractC4492zt.h(fArr, "matrix");
        NodeCoordinator coordinator = toCoordinator(layoutCoordinates);
        coordinator.onCoordinatesUsed$ui_release();
        NodeCoordinator nodeCoordinatorFindCommonAncestor$ui_release = findCommonAncestor$ui_release(coordinator);
        Matrix.m3246resetimpl(fArr);
        coordinator.m4352transformToAncestorEL8BTi8(nodeCoordinatorFindCommonAncestor$ui_release, fArr);
        m4351transformFromAncestorEL8BTi8(nodeCoordinatorFindCommonAncestor$ui_release, fArr);
    }

    public final void updateLayerBlock(InterfaceC3750qp interfaceC3750qp, boolean z) {
        Owner owner$ui_release;
        LayoutNode layoutNode = getLayoutNode();
        boolean z2 = (!z && this.layerBlock == interfaceC3750qp && AbstractC4492zt.d(this.layerDensity, layoutNode.getDensity()) && this.layerLayoutDirection == layoutNode.getLayoutDirection()) ? false : true;
        this.layerBlock = interfaceC3750qp;
        this.layerDensity = layoutNode.getDensity();
        this.layerLayoutDirection = layoutNode.getLayoutDirection();
        if (!isAttached() || interfaceC3750qp == null) {
            OwnedLayer ownedLayer = this.layer;
            if (ownedLayer != null) {
                ownedLayer.destroy();
                layoutNode.setInnerLayerCoordinatorIsDirty$ui_release(true);
                this.invalidateParentLayer.invoke();
                if (isAttached() && (owner$ui_release = layoutNode.getOwner$ui_release()) != null) {
                    owner$ui_release.onLayoutChange(layoutNode);
                }
            }
            this.layer = null;
            this.lastLayerDrawingWasSkipped = false;
            return;
        }
        if (this.layer != null) {
            if (z2) {
                updateLayerParameters$default(this, false, 1, null);
                return;
            }
            return;
        }
        OwnedLayer ownedLayerCreateLayer = LayoutNodeKt.requireOwner(layoutNode).createLayer(this, this.invalidateParentLayer);
        ownedLayerCreateLayer.mo4427resizeozmzZPI(m4199getMeasuredSizeYbymL2g());
        ownedLayerCreateLayer.mo4426movegyyYBs(mo4321getPositionnOccac());
        this.layer = ownedLayerCreateLayer;
        updateLayerParameters$default(this, false, 1, null);
        layoutNode.setInnerLayerCoordinatorIsDirty$ui_release(true);
        this.invalidateParentLayer.invoke();
    }

    public final void visitNodes(int i, boolean z, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        Modifier.Node tail = getTail();
        if (!z && (tail = tail.getParent$ui_release()) == null) {
            return;
        }
        for (Modifier.Node nodeHeadNode = headNode(z); nodeHeadNode != null && (nodeHeadNode.getAggregateChildKindSet$ui_release() & i) != 0; nodeHeadNode = nodeHeadNode.getChild$ui_release()) {
            if ((nodeHeadNode.getKindSet$ui_release() & i) != 0) {
                interfaceC3750qp.invoke(nodeHeadNode);
            }
            if (nodeHeadNode == tail) {
                return;
            }
        }
    }

    /* JADX INFO: renamed from: visitNodes-aLcG6gQ, reason: not valid java name */
    public final /* synthetic */ <T> void m4365visitNodesaLcG6gQ(int i, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        boolean zM4387getIncludeSelfInTraversalH91voCI = NodeKindKt.m4387getIncludeSelfInTraversalH91voCI(i);
        Modifier.Node tail = getTail();
        if (!zM4387getIncludeSelfInTraversalH91voCI && (tail = tail.getParent$ui_release()) == null) {
            return;
        }
        for (Modifier.Node nodeHeadNode = headNode(zM4387getIncludeSelfInTraversalH91voCI); nodeHeadNode != null && (nodeHeadNode.getAggregateChildKindSet$ui_release() & i) != 0; nodeHeadNode = nodeHeadNode.getChild$ui_release()) {
            if ((nodeHeadNode.getKindSet$ui_release() & i) != 0) {
                for (Modifier.Node nodePop = nodeHeadNode; nodePop != null; nodePop = DelegatableNodeKt.pop(null)) {
                    AbstractC4492zt.m(3, "T");
                    interfaceC3750qp.invoke(nodePop);
                }
            }
            if (nodeHeadNode == tail) {
                return;
            }
        }
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* JADX INFO: renamed from: windowToLocal-MK-Hz9U */
    public long mo4171windowToLocalMKHz9U(long j) {
        if (!isAttached()) {
            throw new IllegalStateException(ExpectAttachedLayoutCoordinates);
        }
        LayoutCoordinates layoutCoordinatesFindRootCoordinates = LayoutCoordinatesKt.findRootCoordinates(this);
        return mo4167localPositionOfR5De75A(layoutCoordinatesFindRootCoordinates, Offset.m2802minusMKHz9U(LayoutNodeKt.requireOwner(getLayoutNode()).mo4430calculateLocalPositionMKHz9U(j), LayoutCoordinatesKt.positionInRoot(layoutCoordinatesFindRootCoordinates)));
    }

    public final void withPositionTranslation(Canvas canvas, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(canvas, HTML.Tag.CANVAS);
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        float fM5278getXimpl = IntOffset.m5278getXimpl(mo4321getPositionnOccac());
        float fM5279getYimpl = IntOffset.m5279getYimpl(mo4321getPositionnOccac());
        canvas.translate(fM5278getXimpl, fM5279getYimpl);
        interfaceC3750qp.invoke(canvas);
        canvas.translate(-fM5278getXimpl, -fM5279getYimpl);
    }

    /* JADX INFO: renamed from: withinLayerBounds-k-4lQ0M, reason: not valid java name */
    public final boolean m4366withinLayerBoundsk4lQ0M(long j) {
        if (!OffsetKt.m2815isFinitek4lQ0M(j)) {
            return false;
        }
        OwnedLayer ownedLayer = this.layer;
        return ownedLayer == null || !this.isClipping || ownedLayer.mo4424isInLayerk4lQ0M(j);
    }

    public void invoke(Canvas canvas) {
        AbstractC4492zt.h(canvas, HTML.Tag.CANVAS);
        if (!getLayoutNode().isPlaced()) {
            this.lastLayerDrawingWasSkipped = true;
        } else {
            getSnapshotObserver().observeReads$ui_release(this, onCommitAffectingLayer, new AnonymousClass1(canvas));
            this.lastLayerDrawingWasSkipped = false;
        }
    }
}
