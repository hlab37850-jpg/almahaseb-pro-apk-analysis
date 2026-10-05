package androidx.compose.ui.platform;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidComposeViewAccessibilityDelegateCompat_androidKt$excludeLineAndPageGranularities$ancestor$1 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final AndroidComposeViewAccessibilityDelegateCompat_androidKt$excludeLineAndPageGranularities$ancestor$1 INSTANCE = new AndroidComposeViewAccessibilityDelegateCompat_androidKt$excludeLineAndPageGranularities$ancestor$1();

    public AndroidComposeViewAccessibilityDelegateCompat_androidKt$excludeLineAndPageGranularities$ancestor$1() {
        super(1);
    }

    /* JADX WARN: Code duplicated, block: B:9:0x001f  */
    @Override // defpackage.InterfaceC3750qp
    public final Boolean invoke(LayoutNode layoutNode) {
        boolean z;
        AbstractC4492zt.h(layoutNode, "it");
        SemanticsConfiguration collapsedSemantics$ui_release = layoutNode.getCollapsedSemantics$ui_release();
        if (collapsedSemantics$ui_release != null) {
            z = collapsedSemantics$ui_release.isMergingSemanticsOfDescendants() && collapsedSemantics$ui_release.contains(SemanticsActions.INSTANCE.getSetText());
        }
        return Boolean.valueOf(z);
    }
}
