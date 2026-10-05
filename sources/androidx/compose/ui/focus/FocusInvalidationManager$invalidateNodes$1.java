package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC3588op;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class FocusInvalidationManager$invalidateNodes$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ FocusInvalidationManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FocusInvalidationManager$invalidateNodes$1(FocusInvalidationManager focusInvalidationManager) {
        super(0);
        this.this$0 = focusInvalidationManager;
    }

    @Override // defpackage.InterfaceC3588op
    public /* bridge */ /* synthetic */ Object invoke() {
        m2732invoke();
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m2732invoke() {
        FocusState focusState;
        Set set = this.this$0.focusPropertiesNodes;
        FocusInvalidationManager focusInvalidationManager = this.this$0;
        Iterator it = set.iterator();
        while (true) {
            int i = 1024;
            int i2 = 16;
            int i3 = 0;
            int i4 = 1;
            if (!it.hasNext()) {
                this.this$0.focusPropertiesNodes.clear();
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                Set<FocusEventModifierNode> set2 = this.this$0.focusEventNodes;
                FocusInvalidationManager focusInvalidationManager2 = this.this$0;
                for (FocusEventModifierNode focusEventModifierNode : set2) {
                    if (focusEventModifierNode.getNode().isAttached()) {
                        int iM4378constructorimpl = NodeKind.m4378constructorimpl(i);
                        Modifier.Node node = focusEventModifierNode.getNode();
                        FocusTargetNode focusTargetNode = null;
                        MutableVector mutableVector = null;
                        boolean z = true;
                        boolean z2 = false;
                        while (node != null) {
                            if (node instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode2 = (FocusTargetNode) node;
                                if (focusTargetNode != null) {
                                    z2 = true;
                                }
                                if (focusInvalidationManager2.focusTargetNodes.contains(focusTargetNode2)) {
                                    linkedHashSet.add(focusTargetNode2);
                                    z = false;
                                }
                                focusTargetNode = focusTargetNode2;
                            } else {
                                if ((node.getKindSet$ui_release() & iM4378constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                    Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release();
                                    int i5 = 0;
                                    while (delegate$ui_release != null) {
                                        if ((delegate$ui_release.getKindSet$ui_release() & iM4378constructorimpl) != 0) {
                                            i5++;
                                            if (i5 == i4) {
                                                node = delegate$ui_release;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[i2], i3);
                                                }
                                                if (node != null) {
                                                    mutableVector.add(node);
                                                    node = null;
                                                }
                                                mutableVector.add(delegate$ui_release);
                                            }
                                        }
                                        delegate$ui_release = delegate$ui_release.getChild$ui_release();
                                        i4 = 1;
                                    }
                                    if (i5 == 1) {
                                    }
                                }
                                i4 = 1;
                            }
                            node = DelegatableNodeKt.pop(mutableVector);
                            i4 = 1;
                        }
                        if (!focusEventModifierNode.getNode().isAttached()) {
                            throw new IllegalStateException("visitChildren called on an unattached node");
                        }
                        MutableVector mutableVector2 = new MutableVector(new Modifier.Node[i2], i3);
                        Modifier.Node child$ui_release = focusEventModifierNode.getNode().getChild$ui_release();
                        if (child$ui_release == null) {
                            DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, focusEventModifierNode.getNode());
                        } else {
                            mutableVector2.add(child$ui_release);
                        }
                        while (mutableVector2.isNotEmpty()) {
                            Modifier.Node nodePop = (Modifier.Node) mutableVector2.removeAt(mutableVector2.getSize() - 1);
                            if ((nodePop.getAggregateChildKindSet$ui_release() & iM4378constructorimpl) == 0) {
                                DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, nodePop);
                            } else {
                                while (true) {
                                    if (nodePop != null) {
                                        if ((nodePop.getKindSet$ui_release() & iM4378constructorimpl) != 0) {
                                            MutableVector mutableVector3 = null;
                                            while (nodePop != null) {
                                                if (nodePop instanceof FocusTargetNode) {
                                                    FocusTargetNode focusTargetNode3 = (FocusTargetNode) nodePop;
                                                    if (focusTargetNode != null) {
                                                        z2 = true;
                                                    }
                                                    if (focusInvalidationManager2.focusTargetNodes.contains(focusTargetNode3)) {
                                                        linkedHashSet.add(focusTargetNode3);
                                                        z = false;
                                                    }
                                                    focusTargetNode = focusTargetNode3;
                                                } else {
                                                    if ((nodePop.getKindSet$ui_release() & iM4378constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
                                                        Modifier.Node delegate$ui_release2 = ((DelegatingNode) nodePop).getDelegate$ui_release();
                                                        int i6 = 0;
                                                        while (delegate$ui_release2 != null) {
                                                            if ((delegate$ui_release2.getKindSet$ui_release() & iM4378constructorimpl) != 0) {
                                                                i6++;
                                                                if (i6 == 1) {
                                                                    nodePop = delegate$ui_release2;
                                                                } else {
                                                                    if (mutableVector3 == null) {
                                                                        mutableVector3 = new MutableVector(new Modifier.Node[i2], 0);
                                                                    }
                                                                    if (nodePop != null) {
                                                                        mutableVector3.add(nodePop);
                                                                        nodePop = null;
                                                                    }
                                                                    mutableVector3.add(delegate$ui_release2);
                                                                }
                                                            }
                                                            delegate$ui_release2 = delegate$ui_release2.getChild$ui_release();
                                                            i2 = 16;
                                                        }
                                                        if (i6 == 1) {
                                                        }
                                                        i2 = 16;
                                                    }
                                                    nodePop = DelegatableNodeKt.pop(mutableVector3);
                                                    i2 = 16;
                                                }
                                                nodePop = DelegatableNodeKt.pop(mutableVector3);
                                                i2 = 16;
                                            }
                                        } else {
                                            nodePop = nodePop.getChild$ui_release();
                                            i2 = 16;
                                        }
                                    }
                                }
                            }
                            i2 = 16;
                        }
                        if (z) {
                            if (z2) {
                                focusState = FocusEventModifierNodeKt.getFocusState(focusEventModifierNode);
                            } else if (focusTargetNode == null || (focusState = focusTargetNode.getFocusState()) == null) {
                                focusState = FocusStateImpl.Inactive;
                            }
                            focusEventModifierNode.onFocusEvent(focusState);
                        }
                    } else {
                        focusEventModifierNode.onFocusEvent(FocusStateImpl.Inactive);
                    }
                    i = 1024;
                    i2 = 16;
                    i3 = 0;
                    i4 = 1;
                }
                this.this$0.focusEventNodes.clear();
                for (FocusTargetNode focusTargetNode4 : this.this$0.focusTargetNodes) {
                    if (focusTargetNode4.isAttached()) {
                        FocusStateImpl focusState2 = focusTargetNode4.getFocusState();
                        focusTargetNode4.invalidateFocus$ui_release();
                        if (focusState2 != focusTargetNode4.getFocusState() || linkedHashSet.contains(focusTargetNode4)) {
                            FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode4);
                        }
                    }
                }
                this.this$0.focusTargetNodes.clear();
                linkedHashSet.clear();
                if (!this.this$0.focusPropertiesNodes.isEmpty()) {
                    throw new IllegalStateException("Unprocessed FocusProperties nodes");
                }
                if (!this.this$0.focusEventNodes.isEmpty()) {
                    throw new IllegalStateException("Unprocessed FocusEvent nodes");
                }
                if (!this.this$0.focusTargetNodes.isEmpty()) {
                    throw new IllegalStateException("Unprocessed FocusTarget nodes");
                }
                return;
            }
            FocusPropertiesModifierNode focusPropertiesModifierNode = (FocusPropertiesModifierNode) it.next();
            if (focusPropertiesModifierNode.getNode().isAttached()) {
                int iM4378constructorimpl2 = NodeKind.m4378constructorimpl(1024);
                Modifier.Node node2 = focusPropertiesModifierNode.getNode();
                MutableVector mutableVector4 = null;
                while (node2 != null) {
                    if (node2 instanceof FocusTargetNode) {
                        focusInvalidationManager.focusTargetNodes.add((FocusTargetNode) node2);
                    } else if ((node2.getKindSet$ui_release() & iM4378constructorimpl2) != 0 && (node2 instanceof DelegatingNode)) {
                        int i7 = 0;
                        for (Modifier.Node delegate$ui_release3 = ((DelegatingNode) node2).getDelegate$ui_release(); delegate$ui_release3 != null; delegate$ui_release3 = delegate$ui_release3.getChild$ui_release()) {
                            if ((delegate$ui_release3.getKindSet$ui_release() & iM4378constructorimpl2) != 0) {
                                i7++;
                                if (i7 == 1) {
                                    node2 = delegate$ui_release3;
                                } else {
                                    if (mutableVector4 == null) {
                                        mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                    }
                                    if (node2 != null) {
                                        mutableVector4.add(node2);
                                        node2 = null;
                                    }
                                    mutableVector4.add(delegate$ui_release3);
                                }
                            }
                        }
                        if (i7 == 1) {
                        }
                    }
                    node2 = DelegatableNodeKt.pop(mutableVector4);
                }
                if (!focusPropertiesModifierNode.getNode().isAttached()) {
                    throw new IllegalStateException("visitChildren called on an unattached node");
                }
                MutableVector mutableVector5 = new MutableVector(new Modifier.Node[16], 0);
                Modifier.Node child$ui_release2 = focusPropertiesModifierNode.getNode().getChild$ui_release();
                if (child$ui_release2 == null) {
                    DelegatableNodeKt.addLayoutNodeChildren(mutableVector5, focusPropertiesModifierNode.getNode());
                } else {
                    mutableVector5.add(child$ui_release2);
                }
                while (mutableVector5.isNotEmpty()) {
                    Modifier.Node nodePop2 = (Modifier.Node) mutableVector5.removeAt(mutableVector5.getSize() - 1);
                    if ((nodePop2.getAggregateChildKindSet$ui_release() & iM4378constructorimpl2) == 0) {
                        DelegatableNodeKt.addLayoutNodeChildren(mutableVector5, nodePop2);
                    } else {
                        while (nodePop2 != null) {
                            if ((nodePop2.getKindSet$ui_release() & iM4378constructorimpl2) != 0) {
                                MutableVector mutableVector6 = null;
                                while (nodePop2 != null) {
                                    if (nodePop2 instanceof FocusTargetNode) {
                                        focusInvalidationManager.focusTargetNodes.add((FocusTargetNode) nodePop2);
                                    } else if ((nodePop2.getKindSet$ui_release() & iM4378constructorimpl2) != 0 && (nodePop2 instanceof DelegatingNode)) {
                                        int i8 = 0;
                                        for (Modifier.Node delegate$ui_release4 = ((DelegatingNode) nodePop2).getDelegate$ui_release(); delegate$ui_release4 != null; delegate$ui_release4 = delegate$ui_release4.getChild$ui_release()) {
                                            if ((delegate$ui_release4.getKindSet$ui_release() & iM4378constructorimpl2) != 0) {
                                                i8++;
                                                if (i8 == 1) {
                                                    nodePop2 = delegate$ui_release4;
                                                } else {
                                                    if (mutableVector6 == null) {
                                                        mutableVector6 = new MutableVector(new Modifier.Node[16], 0);
                                                    }
                                                    if (nodePop2 != null) {
                                                        mutableVector6.add(nodePop2);
                                                        nodePop2 = null;
                                                    }
                                                    mutableVector6.add(delegate$ui_release4);
                                                }
                                            }
                                        }
                                        if (i8 == 1) {
                                        }
                                    }
                                    nodePop2 = DelegatableNodeKt.pop(mutableVector6);
                                }
                                break;
                            }
                            nodePop2 = nodePop2.getChild$ui_release();
                        }
                    }
                }
            }
        }
    }
}
