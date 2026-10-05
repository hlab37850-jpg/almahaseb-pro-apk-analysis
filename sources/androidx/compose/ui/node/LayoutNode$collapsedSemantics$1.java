package androidx.compose.ui.node;

import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC3588op;
import defpackage.OJ;

/* JADX INFO: loaded from: classes.dex */
public final class LayoutNode$collapsedSemantics$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ OJ $config;
    final /* synthetic */ LayoutNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LayoutNode$collapsedSemantics$1(LayoutNode layoutNode, OJ oj) {
        super(0);
        this.this$0 = layoutNode;
        this.$config = oj;
    }

    @Override // defpackage.InterfaceC3588op
    public /* bridge */ /* synthetic */ Object invoke() {
        m4300invoke();
        return FW.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6 */
    /*  JADX ERROR: NullPointerException in pass: PrepareForCodeGen
        java.lang.NullPointerException
        */
    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m4300invoke() {
        /*
            r11 = this;
            androidx.compose.ui.node.LayoutNode r0 = r11.this$0
            androidx.compose.ui.node.NodeChain r0 = r0.getNodes$ui_release()
            r1 = 8
            int r1 = androidx.compose.ui.node.NodeKind.m4378constructorimpl(r1)
            OJ r2 = r11.$config
            int r3 = androidx.compose.ui.node.NodeChain.access$getAggregateChildKindSet(r0)
            r3 = r3 & r1
            if (r3 == 0) goto L9d
            androidx.compose.ui.Modifier$Node r0 = r0.getTail$ui_release()
        L19:
            if (r0 == 0) goto L9d
            int r3 = r0.getKindSet$ui_release()
            r3 = r3 & r1
            if (r3 == 0) goto L97
            r3 = 0
            r4 = r0
            r5 = r3
        L25:
            if (r4 == 0) goto L97
            boolean r6 = r4 instanceof androidx.compose.ui.node.SemanticsModifierNode
            r7 = 1
            if (r6 == 0) goto L53
            androidx.compose.ui.node.SemanticsModifierNode r4 = (androidx.compose.ui.node.SemanticsModifierNode) r4
            boolean r6 = r4.getShouldClearDescendantSemantics()
            if (r6 == 0) goto L3e
            androidx.compose.ui.semantics.SemanticsConfiguration r6 = new androidx.compose.ui.semantics.SemanticsConfiguration
            r6.<init>()
            r2.a = r6
            r6.setClearingSemantics(r7)
        L3e:
            boolean r6 = r4.getShouldMergeDescendantSemantics()
            if (r6 == 0) goto L4b
            java.lang.Object r6 = r2.a
            androidx.compose.ui.semantics.SemanticsConfiguration r6 = (androidx.compose.ui.semantics.SemanticsConfiguration) r6
            r6.setMergingSemanticsOfDescendants(r7)
        L4b:
            java.lang.Object r6 = r2.a
            androidx.compose.ui.semantics.SemanticsConfiguration r6 = (androidx.compose.ui.semantics.SemanticsConfiguration) r6
            r4.applySemantics(r6)
            goto L92
        L53:
            int r6 = r4.getKindSet$ui_release()
            r6 = r6 & r1
            if (r6 == 0) goto L92
            boolean r6 = r4 instanceof androidx.compose.ui.node.DelegatingNode
            if (r6 == 0) goto L92
            r6 = r4
            androidx.compose.ui.node.DelegatingNode r6 = (androidx.compose.ui.node.DelegatingNode) r6
            androidx.compose.ui.Modifier$Node r6 = r6.getDelegate$ui_release()
            r8 = 0
            r9 = 0
        L67:
            if (r6 == 0) goto L8f
            int r10 = r6.getKindSet$ui_release()
            r10 = r10 & r1
            if (r10 == 0) goto L8a
            int r9 = r9 + 1
            if (r9 != r7) goto L76
            r4 = r6
            goto L8a
        L76:
            if (r5 != 0) goto L81
            androidx.compose.runtime.collection.MutableVector r5 = new androidx.compose.runtime.collection.MutableVector
            r10 = 16
            androidx.compose.ui.Modifier$Node[] r10 = new androidx.compose.ui.Modifier.Node[r10]
            r5.<init>(r10, r8)
        L81:
            if (r4 == 0) goto L87
            r5.add(r4)
            r4 = r3
        L87:
            r5.add(r6)
        L8a:
            androidx.compose.ui.Modifier$Node r6 = r6.getChild$ui_release()
            goto L67
        L8f:
            if (r9 != r7) goto L92
            goto L25
        L92:
            androidx.compose.ui.Modifier$Node r4 = androidx.compose.ui.node.DelegatableNodeKt.access$pop(r5)
            goto L25
        L97:
            androidx.compose.ui.Modifier$Node r0 = r0.getParent$ui_release()
            goto L19
        L9d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutNode$collapsedSemantics$1.m4300invoke():void");
    }
}
