package androidx.compose.ui.platform;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeKind;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1 INSTANCE = new AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1();

    public AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public final Boolean invoke(LayoutNode layoutNode) {
        AbstractC4492zt.h(layoutNode, "it");
        return Boolean.valueOf(layoutNode.getNodes$ui_release().m4335hasH91voCI$ui_release(NodeKind.m4378constructorimpl(8)));
    }
}
