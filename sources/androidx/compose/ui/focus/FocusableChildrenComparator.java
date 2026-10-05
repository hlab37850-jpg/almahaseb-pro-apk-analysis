package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import defpackage.AbstractC4492zt;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
final class FocusableChildrenComparator implements Comparator<FocusTargetNode> {
    public static final FocusableChildrenComparator INSTANCE = new FocusableChildrenComparator();

    private FocusableChildrenComparator() {
    }

    private final MutableVector<LayoutNode> pathFromRoot(LayoutNode layoutNode) {
        MutableVector<LayoutNode> mutableVector = new MutableVector<>(new LayoutNode[16], 0);
        while (layoutNode != null) {
            mutableVector.add(0, layoutNode);
            layoutNode = layoutNode.getParent$ui_release();
        }
        return mutableVector;
    }

    @Override // java.util.Comparator
    public int compare(FocusTargetNode focusTargetNode, FocusTargetNode focusTargetNode2) {
        if (focusTargetNode == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        if (focusTargetNode2 == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        int i = 0;
        if (!FocusTraversalKt.isEligibleForFocusSearch(focusTargetNode) || !FocusTraversalKt.isEligibleForFocusSearch(focusTargetNode2)) {
            if (FocusTraversalKt.isEligibleForFocusSearch(focusTargetNode)) {
                return -1;
            }
            return FocusTraversalKt.isEligibleForFocusSearch(focusTargetNode2) ? 1 : 0;
        }
        NodeCoordinator coordinator$ui_release = focusTargetNode.getCoordinator$ui_release();
        LayoutNode layoutNode = coordinator$ui_release != null ? coordinator$ui_release.getLayoutNode() : null;
        if (layoutNode == null) {
            throw new IllegalStateException("Required value was null.");
        }
        NodeCoordinator coordinator$ui_release2 = focusTargetNode2.getCoordinator$ui_release();
        LayoutNode layoutNode2 = coordinator$ui_release2 != null ? coordinator$ui_release2.getLayoutNode() : null;
        if (layoutNode2 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        if (AbstractC4492zt.d(layoutNode, layoutNode2)) {
            return 0;
        }
        MutableVector<LayoutNode> mutableVectorPathFromRoot = pathFromRoot(layoutNode);
        MutableVector<LayoutNode> mutableVectorPathFromRoot2 = pathFromRoot(layoutNode2);
        int iMin = Math.min(mutableVectorPathFromRoot.getSize() - 1, mutableVectorPathFromRoot2.getSize() - 1);
        if (iMin >= 0) {
            while (AbstractC4492zt.d(mutableVectorPathFromRoot.getContent()[i], mutableVectorPathFromRoot2.getContent()[i])) {
                if (i != iMin) {
                    i++;
                }
            }
            return AbstractC4492zt.j(mutableVectorPathFromRoot.getContent()[i].getPlaceOrder$ui_release(), mutableVectorPathFromRoot2.getContent()[i].getPlaceOrder$ui_release());
        }
        throw new IllegalStateException("Could not find a common ancestor between the two FocusModifiers.");
    }
}
