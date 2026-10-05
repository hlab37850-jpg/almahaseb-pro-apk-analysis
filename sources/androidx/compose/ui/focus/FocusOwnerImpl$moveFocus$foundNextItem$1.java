package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import com.itextpdf.text.Annotation;
import defpackage.AD;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;
import defpackage.KJ;

/* JADX INFO: loaded from: classes.dex */
public final class FocusOwnerImpl$moveFocus$foundNextItem$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ int $focusDirection;
    final /* synthetic */ KJ $isCancelled;
    final /* synthetic */ FocusTargetNode $source;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CustomDestinationResult.values().length];
            try {
                iArr[CustomDestinationResult.Redirected.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CustomDestinationResult.Cancelled.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CustomDestinationResult.RedirectCancelled.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CustomDestinationResult.None.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FocusOwnerImpl$moveFocus$foundNextItem$1(FocusTargetNode focusTargetNode, int i, KJ kj) {
        super(1);
        this.$source = focusTargetNode;
        this.$focusDirection = i;
        this.$isCancelled = kj;
    }

    @Override // defpackage.InterfaceC3750qp
    public final Boolean invoke(FocusTargetNode focusTargetNode) {
        Modifier.Node node;
        boolean zPerformRequestFocus;
        NodeChain nodes$ui_release;
        AbstractC4492zt.h(focusTargetNode, Annotation.DESTINATION);
        if (AbstractC4492zt.d(focusTargetNode, this.$source)) {
            return Boolean.FALSE;
        }
        int iM4378constructorimpl = NodeKind.m4378constructorimpl(1024);
        if (!focusTargetNode.getNode().isAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node parent$ui_release = focusTargetNode.getNode().getParent$ui_release();
        LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
        loop0: while (true) {
            node = null;
            zPerformRequestFocus = true;
            if (layoutNodeRequireLayoutNode == null) {
                break;
            }
            if ((layoutNodeRequireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & iM4378constructorimpl) != 0) {
                while (parent$ui_release != null) {
                    if ((parent$ui_release.getKindSet$ui_release() & iM4378constructorimpl) != 0) {
                        Modifier.Node nodePop = parent$ui_release;
                        MutableVector mutableVector = null;
                        while (nodePop != null) {
                            if (nodePop instanceof FocusTargetNode) {
                                node = nodePop;
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
                    }
                    parent$ui_release = parent$ui_release.getParent$ui_release();
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
            parent$ui_release = (layoutNodeRequireLayoutNode == null || (nodes$ui_release = layoutNodeRequireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
        }
        if (node == null) {
            throw new IllegalStateException("Focus search landed at the root.");
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[FocusTransactionsKt.m2748performCustomRequestFocusMxy_nc0(focusTargetNode, this.$focusDirection).ordinal()];
        if (i2 != 1) {
            if (i2 == 2 || i2 == 3) {
                this.$isCancelled.a = true;
            } else {
                if (i2 != 4) {
                    throw new AD();
                }
                zPerformRequestFocus = FocusTransactionsKt.performRequestFocus(focusTargetNode);
            }
        }
        return Boolean.valueOf(zPerformRequestFocus);
    }
}
