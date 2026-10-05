package androidx.compose.ui.semantics;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.SemanticsModifierNode;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class SemanticsOwner {
    public static final int $stable = 8;
    private final LayoutNode rootNode;

    public SemanticsOwner(LayoutNode layoutNode) {
        AbstractC4492zt.h(layoutNode, "rootNode");
        this.rootNode = layoutNode;
    }

    public final SemanticsNode getRootSemanticsNode() {
        return SemanticsNodeKt.SemanticsNode(this.rootNode, true);
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0077 A[LOOP:0: B:5:0x0019->B:36:0x0077, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:41:0x007c A[EDGE_INSN: B:41:0x007c->B:37:0x007c BREAK  A[LOOP:0: B:5:0x0019->B:36:0x0077], SYNTHETIC] */
    public final SemanticsNode getUnmergedRootSemanticsNode() {
        NodeChain nodes$ui_release = this.rootNode.getNodes$ui_release();
        int iM4378constructorimpl = NodeKind.m4378constructorimpl(8);
        Object obj = null;
        if ((nodes$ui_release.getAggregateChildKindSet() & iM4378constructorimpl) != 0) {
            loop0: for (Modifier.Node head$ui_release = nodes$ui_release.getHead$ui_release(); head$ui_release != null; head$ui_release = head$ui_release.getChild$ui_release()) {
                if ((head$ui_release.getKindSet$ui_release() & iM4378constructorimpl) == 0) {
                    if ((head$ui_release.getAggregateChildKindSet$ui_release() & iM4378constructorimpl) != 0) {
                        break;
                        break;
                    }
                } else {
                    Modifier.Node nodePop = head$ui_release;
                    MutableVector mutableVector = null;
                    while (nodePop != null) {
                        if (nodePop instanceof SemanticsModifierNode) {
                            obj = nodePop;
                            break loop0;
                        }
                        if ((nodePop.getKindSet$ui_release() & iM4378constructorimpl) != 0 && (nodePop instanceof DelegatingNode)) {
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
                    if ((head$ui_release.getAggregateChildKindSet$ui_release() & iM4378constructorimpl) != 0) {
                        break;
                    }
                }
            }
        }
        AbstractC4492zt.e(obj);
        return new SemanticsNode(((SemanticsModifierNode) obj).getNode(), false, this.rootNode, new SemanticsConfiguration());
    }
}
