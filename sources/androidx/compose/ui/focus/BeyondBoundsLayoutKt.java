package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class BeyondBoundsLayoutKt {
    /* JADX INFO: renamed from: searchBeyondBounds--OM-vw8, reason: not valid java name */
    public static final <T> T m2710searchBeyondBoundsOMvw8(FocusTargetNode focusTargetNode, int i, InterfaceC3750qp interfaceC3750qp) {
        Modifier.Node nodePop;
        BeyondBoundsLayout beyondBoundsLayoutParent;
        int iM4145getBeforehoxUOeE;
        NodeChain nodes$ui_release;
        AbstractC4492zt.h(focusTargetNode, "$this$searchBeyondBounds");
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        int iM4378constructorimpl = NodeKind.m4378constructorimpl(1024);
        if (!focusTargetNode.getNode().isAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node parent$ui_release = focusTargetNode.getNode().getParent$ui_release();
        LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
        loop0: while (true) {
            if (layoutNodeRequireLayoutNode == null) {
                nodePop = null;
                break;
            }
            if ((layoutNodeRequireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & iM4378constructorimpl) != 0) {
                while (parent$ui_release != null) {
                    if ((parent$ui_release.getKindSet$ui_release() & iM4378constructorimpl) != 0) {
                        nodePop = parent$ui_release;
                        MutableVector mutableVector = null;
                        while (nodePop != null) {
                            if (nodePop instanceof FocusTargetNode) {
                                break loop0;
                            }
                            if ((nodePop.getKindSet$ui_release() & iM4378constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                                int i2 = 0;
                                for (Modifier.Node delegate$ui_release = ((DelegatingNode) nodePop).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                    if ((delegate$ui_release.getKindSet$ui_release() & iM4378constructorimpl) != 0) {
                                        i2++;
                                        if (i2 == 1) {
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
                                if (i2 == 1) {
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
        FocusTargetNode focusTargetNode2 = (FocusTargetNode) nodePop;
        if ((focusTargetNode2 != null && AbstractC4492zt.d(focusTargetNode2.getBeyondBoundsLayoutParent(), focusTargetNode.getBeyondBoundsLayoutParent())) || (beyondBoundsLayoutParent = focusTargetNode.getBeyondBoundsLayoutParent()) == null) {
            return null;
        }
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (FocusDirection.m2714equalsimpl0(i, companion.m2731getUpdhqQ8s())) {
            iM4145getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.Companion.m4143getAbovehoxUOeE();
        } else if (FocusDirection.m2714equalsimpl0(i, companion.m2722getDowndhqQ8s())) {
            iM4145getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.Companion.m4146getBelowhoxUOeE();
        } else if (FocusDirection.m2714equalsimpl0(i, companion.m2726getLeftdhqQ8s())) {
            iM4145getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.Companion.m4147getLefthoxUOeE();
        } else if (FocusDirection.m2714equalsimpl0(i, companion.m2730getRightdhqQ8s())) {
            iM4145getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.Companion.m4148getRighthoxUOeE();
        } else if (FocusDirection.m2714equalsimpl0(i, companion.m2727getNextdhqQ8s())) {
            iM4145getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.Companion.m4144getAfterhoxUOeE();
        } else {
            if (!FocusDirection.m2714equalsimpl0(i, companion.m2729getPreviousdhqQ8s())) {
                throw new IllegalStateException("Unsupported direction for beyond bounds layout");
            }
            iM4145getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.Companion.m4145getBeforehoxUOeE();
        }
        return (T) beyondBoundsLayoutParent.mo637layouto7g1Pn8(iM4145getBeforehoxUOeE, interfaceC3750qp);
    }
}
