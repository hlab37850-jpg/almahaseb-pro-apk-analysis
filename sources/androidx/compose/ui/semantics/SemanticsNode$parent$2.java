package androidx.compose.ui.semantics;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeKind;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SemanticsNode$parent$2 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final SemanticsNode$parent$2 INSTANCE = new SemanticsNode$parent$2();

    public SemanticsNode$parent$2() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public final Boolean invoke(LayoutNode layoutNode) {
        AbstractC4492zt.h(layoutNode, "it");
        return Boolean.valueOf(layoutNode.getNodes$ui_release().m4335hasH91voCI$ui_release(NodeKind.m4378constructorimpl(8)));
    }
}
