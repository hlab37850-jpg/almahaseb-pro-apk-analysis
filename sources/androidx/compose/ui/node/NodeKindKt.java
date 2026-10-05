package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.focus.FocusEventModifier;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusEventModifierNodeKt;
import androidx.compose.ui.focus.FocusOrderModifier;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.focus.FocusPropertiesModifierNodeKt;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.focus.FocusTargetNodeKt;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode;
import androidx.compose.ui.input.pointer.PointerInputModifier;
import androidx.compose.ui.input.rotary.RotaryInputModifierNode;
import androidx.compose.ui.layout.IntermediateLayoutModifierNode;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.layout.OnRemeasuredModifier;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.semantics.SemanticsModifier;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class NodeKindKt {
    private static final int Inserted = 1;
    private static final int Removed = 2;
    private static final int Updated = 0;

    public static final void autoInvalidateInsertedNode(Modifier.Node node) {
        AbstractC4492zt.h(node, "node");
        if (!node.isAttached()) {
            throw new IllegalStateException("Check failed.");
        }
        autoInvalidateNodeIncludingDelegates(node, -1, 1);
    }

    public static final void autoInvalidateNodeIncludingDelegates(Modifier.Node node, int i, int i2) {
        AbstractC4492zt.h(node, "node");
        if (!(node instanceof DelegatingNode)) {
            autoInvalidateNodeSelf(node, i & node.getKindSet$ui_release(), i2);
            return;
        }
        DelegatingNode delegatingNode = (DelegatingNode) node;
        autoInvalidateNodeSelf(node, delegatingNode.getSelfKindSet$ui_release() & i, i2);
        int i3 = (~delegatingNode.getSelfKindSet$ui_release()) & i;
        for (Modifier.Node delegate$ui_release = delegatingNode.getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
            autoInvalidateNodeIncludingDelegates(delegate$ui_release, i3, i2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void autoInvalidateNodeSelf(Modifier.Node node, int i, int i2) {
        if (i2 != 0 || node.getShouldAutoInvalidate()) {
            if ((NodeKind.m4378constructorimpl(2) & i) != 0 && (node instanceof LayoutModifierNode)) {
                LayoutModifierNodeKt.invalidateMeasurement((LayoutModifierNode) node);
                if (i2 == 2) {
                    DelegatableNodeKt.m4263requireCoordinator64DMado(node, NodeKind.m4378constructorimpl(2)).onRelease();
                }
            }
            if ((NodeKind.m4378constructorimpl(256) & i) != 0 && (node instanceof GlobalPositionAwareModifierNode)) {
                DelegatableNodeKt.requireLayoutNode(node).invalidateMeasurements$ui_release();
            }
            if ((NodeKind.m4378constructorimpl(4) & i) != 0 && (node instanceof DrawModifierNode)) {
                DrawModifierNodeKt.invalidateDraw((DrawModifierNode) node);
            }
            if ((NodeKind.m4378constructorimpl(8) & i) != 0 && (node instanceof SemanticsModifierNode)) {
                SemanticsModifierNodeKt.invalidateSemantics((SemanticsModifierNode) node);
            }
            if ((NodeKind.m4378constructorimpl(64) & i) != 0 && (node instanceof ParentDataModifierNode)) {
                ParentDataModifierNodeKt.invalidateParentData((ParentDataModifierNode) node);
            }
            if ((NodeKind.m4378constructorimpl(1024) & i) != 0 && (node instanceof FocusTargetNode)) {
                if (i2 == 2) {
                    node.onReset();
                } else {
                    DelegatableNodeKt.requireOwner(node).getFocusOwner().scheduleInvalidation((FocusTargetNode) node);
                }
            }
            if ((NodeKind.m4378constructorimpl(2048) & i) != 0 && (node instanceof FocusPropertiesModifierNode)) {
                FocusPropertiesModifierNode focusPropertiesModifierNode = (FocusPropertiesModifierNode) node;
                if (specifiesCanFocusProperty(focusPropertiesModifierNode)) {
                    if (i2 == 2) {
                        scheduleInvalidationOfAssociatedFocusTargets(focusPropertiesModifierNode);
                    } else {
                        FocusPropertiesModifierNodeKt.invalidateFocusProperties(focusPropertiesModifierNode);
                    }
                }
            }
            if ((i & NodeKind.m4378constructorimpl(4096)) == 0 || !(node instanceof FocusEventModifierNode)) {
                return;
            }
            FocusEventModifierNodeKt.invalidateFocusEvent((FocusEventModifierNode) node);
        }
    }

    public static final void autoInvalidateRemovedNode(Modifier.Node node) {
        AbstractC4492zt.h(node, "node");
        if (!node.isAttached()) {
            throw new IllegalStateException("Check failed.");
        }
        autoInvalidateNodeIncludingDelegates(node, -1, 2);
    }

    public static final void autoInvalidateUpdatedNode(Modifier.Node node) {
        AbstractC4492zt.h(node, "node");
        if (!node.isAttached()) {
            throw new IllegalStateException("Check failed.");
        }
        autoInvalidateNodeIncludingDelegates(node, -1, 0);
    }

    public static final int calculateNodeKindSetFrom(Modifier.Node node) {
        AbstractC4492zt.h(node, "node");
        if (node.getKindSet$ui_release() != 0) {
            return node.getKindSet$ui_release();
        }
        int iM4378constructorimpl = NodeKind.m4378constructorimpl(1);
        if (node instanceof LayoutModifierNode) {
            iM4378constructorimpl |= NodeKind.m4378constructorimpl(2);
        }
        if (node instanceof DrawModifierNode) {
            iM4378constructorimpl |= NodeKind.m4378constructorimpl(4);
        }
        if (node instanceof SemanticsModifierNode) {
            iM4378constructorimpl |= NodeKind.m4378constructorimpl(8);
        }
        if (node instanceof PointerInputModifierNode) {
            iM4378constructorimpl |= NodeKind.m4378constructorimpl(16);
        }
        if (node instanceof ModifierLocalModifierNode) {
            iM4378constructorimpl |= NodeKind.m4378constructorimpl(32);
        }
        if (node instanceof ParentDataModifierNode) {
            iM4378constructorimpl |= NodeKind.m4378constructorimpl(64);
        }
        if (node instanceof LayoutAwareModifierNode) {
            iM4378constructorimpl |= NodeKind.m4378constructorimpl(128);
        }
        if (node instanceof GlobalPositionAwareModifierNode) {
            iM4378constructorimpl |= NodeKind.m4378constructorimpl(256);
        }
        if (node instanceof IntermediateLayoutModifierNode) {
            iM4378constructorimpl |= NodeKind.m4378constructorimpl(512);
        }
        if (node instanceof FocusTargetNode) {
            iM4378constructorimpl |= NodeKind.m4378constructorimpl(1024);
        }
        if (node instanceof FocusPropertiesModifierNode) {
            iM4378constructorimpl |= NodeKind.m4378constructorimpl(2048);
        }
        if (node instanceof FocusEventModifierNode) {
            iM4378constructorimpl |= NodeKind.m4378constructorimpl(4096);
        }
        if (node instanceof KeyInputModifierNode) {
            iM4378constructorimpl |= NodeKind.m4378constructorimpl(8192);
        }
        if (node instanceof RotaryInputModifierNode) {
            iM4378constructorimpl |= NodeKind.m4378constructorimpl(16384);
        }
        if (node instanceof CompositionLocalConsumerModifierNode) {
            iM4378constructorimpl |= NodeKind.m4378constructorimpl(32768);
        }
        return node instanceof SoftKeyboardInterceptionModifierNode ? iM4378constructorimpl | NodeKind.m4378constructorimpl(131072) : iM4378constructorimpl;
    }

    public static final int calculateNodeKindSetFromIncludingDelegates(Modifier.Node node) {
        AbstractC4492zt.h(node, "node");
        if (!(node instanceof DelegatingNode)) {
            return calculateNodeKindSetFrom(node);
        }
        DelegatingNode delegatingNode = (DelegatingNode) node;
        int selfKindSet$ui_release = delegatingNode.getSelfKindSet$ui_release();
        for (Modifier.Node delegate$ui_release = delegatingNode.getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
            selfKindSet$ui_release |= calculateNodeKindSetFromIncludingDelegates(delegate$ui_release);
        }
        return selfKindSet$ui_release;
    }

    /* JADX INFO: renamed from: contains-64DMado, reason: not valid java name */
    public static final boolean m4386contains64DMado(int i, int i2) {
        return (i & i2) != 0;
    }

    /* JADX INFO: renamed from: getIncludeSelfInTraversal-H91voCI, reason: not valid java name */
    public static final boolean m4387getIncludeSelfInTraversalH91voCI(int i) {
        return (i & NodeKind.m4378constructorimpl(128)) != 0;
    }

    private static /* synthetic */ void getInserted$annotations() {
    }

    private static /* synthetic */ void getRemoved$annotations() {
    }

    private static /* synthetic */ void getUpdated$annotations() {
    }

    /* JADX INFO: renamed from: or-64DMado, reason: not valid java name */
    public static final int m4388or64DMado(int i, int i2) {
        return i | i2;
    }

    private static final void scheduleInvalidationOfAssociatedFocusTargets(FocusPropertiesModifierNode focusPropertiesModifierNode) {
        int iM4378constructorimpl = NodeKind.m4378constructorimpl(1024);
        if (!focusPropertiesModifierNode.getNode().isAttached()) {
            throw new IllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = focusPropertiesModifierNode.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, focusPropertiesModifierNode.getNode());
        } else {
            mutableVector.add(child$ui_release);
        }
        while (mutableVector.isNotEmpty()) {
            Modifier.Node nodePop = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((nodePop.getAggregateChildKindSet$ui_release() & iM4378constructorimpl) == 0) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector, nodePop);
            } else {
                while (nodePop != null) {
                    if ((nodePop.getKindSet$ui_release() & iM4378constructorimpl) != 0) {
                        MutableVector mutableVector2 = null;
                        while (nodePop != null) {
                            if (nodePop instanceof FocusTargetNode) {
                                FocusTargetNodeKt.invalidateFocusTarget((FocusTargetNode) nodePop);
                            } else if ((nodePop.getKindSet$ui_release() & iM4378constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate$ui_release = ((DelegatingNode) nodePop).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                    if ((delegate$ui_release.getKindSet$ui_release() & iM4378constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            nodePop = delegate$ui_release;
                                        } else {
                                            if (mutableVector2 == null) {
                                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (nodePop != null) {
                                                mutableVector2.add(nodePop);
                                                nodePop = null;
                                            }
                                            mutableVector2.add(delegate$ui_release);
                                        }
                                    }
                                }
                                if (i == 1) {
                                }
                            }
                            nodePop = DelegatableNodeKt.pop(mutableVector2);
                        }
                        break;
                    }
                    nodePop = nodePop.getChild$ui_release();
                }
            }
        }
    }

    private static final boolean specifiesCanFocusProperty(FocusPropertiesModifierNode focusPropertiesModifierNode) {
        CanFocusChecker canFocusChecker = CanFocusChecker.INSTANCE;
        canFocusChecker.reset();
        focusPropertiesModifierNode.applyFocusProperties(canFocusChecker);
        return canFocusChecker.isCanFocusSet();
    }

    public static final int calculateNodeKindSetFrom(Modifier.Element element) {
        AbstractC4492zt.h(element, "element");
        int iM4378constructorimpl = NodeKind.m4378constructorimpl(1);
        if (element instanceof LayoutModifier) {
            iM4378constructorimpl |= NodeKind.m4378constructorimpl(2);
        }
        if (element instanceof DrawModifier) {
            iM4378constructorimpl |= NodeKind.m4378constructorimpl(4);
        }
        if (element instanceof SemanticsModifier) {
            iM4378constructorimpl |= NodeKind.m4378constructorimpl(8);
        }
        if (element instanceof PointerInputModifier) {
            iM4378constructorimpl |= NodeKind.m4378constructorimpl(16);
        }
        if ((element instanceof ModifierLocalConsumer) || (element instanceof ModifierLocalProvider)) {
            iM4378constructorimpl |= NodeKind.m4378constructorimpl(32);
        }
        if (element instanceof FocusEventModifier) {
            iM4378constructorimpl |= NodeKind.m4378constructorimpl(4096);
        }
        if (element instanceof FocusOrderModifier) {
            iM4378constructorimpl |= NodeKind.m4378constructorimpl(2048);
        }
        if (element instanceof OnGloballyPositionedModifier) {
            iM4378constructorimpl |= NodeKind.m4378constructorimpl(256);
        }
        if (element instanceof ParentDataModifier) {
            iM4378constructorimpl |= NodeKind.m4378constructorimpl(64);
        }
        return ((element instanceof OnPlacedModifier) || (element instanceof OnRemeasuredModifier)) ? iM4378constructorimpl | NodeKind.m4378constructorimpl(128) : iM4378constructorimpl;
    }
}
