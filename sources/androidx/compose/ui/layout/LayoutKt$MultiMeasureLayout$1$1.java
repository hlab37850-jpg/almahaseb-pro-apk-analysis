package androidx.compose.ui.layout;

import androidx.compose.ui.node.LayoutNode;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class LayoutKt$MultiMeasureLayout$1$1 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final LayoutKt$MultiMeasureLayout$1$1 INSTANCE = new LayoutKt$MultiMeasureLayout$1$1();

    public LayoutKt$MultiMeasureLayout$1$1() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LayoutNode) obj);
        return FW.a;
    }

    public final void invoke(LayoutNode layoutNode) {
        AbstractC4492zt.h(layoutNode, "$this$init");
        layoutNode.setCanMultiMeasure$ui_release(true);
    }
}
