package androidx.compose.ui.semantics;

import androidx.compose.ui.node.LayoutNode;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SemanticsNode$parent$1 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final SemanticsNode$parent$1 INSTANCE = new SemanticsNode$parent$1();

    public SemanticsNode$parent$1() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public final Boolean invoke(LayoutNode layoutNode) {
        AbstractC4492zt.h(layoutNode, "it");
        SemanticsConfiguration collapsedSemantics$ui_release = layoutNode.getCollapsedSemantics$ui_release();
        boolean z = false;
        if (collapsedSemantics$ui_release != null && collapsedSemantics$ui_release.isMergingSemanticsOfDescendants()) {
            z = true;
        }
        return Boolean.valueOf(z);
    }
}
