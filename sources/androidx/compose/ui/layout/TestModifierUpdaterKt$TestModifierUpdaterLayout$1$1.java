package androidx.compose.ui.layout;

import androidx.compose.ui.node.LayoutNode;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class TestModifierUpdaterKt$TestModifierUpdaterLayout$1$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ InterfaceC3750qp $onAttached;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TestModifierUpdaterKt$TestModifierUpdaterLayout$1$1(InterfaceC3750qp interfaceC3750qp) {
        super(1);
        this.$onAttached = interfaceC3750qp;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LayoutNode) obj);
        return FW.a;
    }

    public final void invoke(LayoutNode layoutNode) {
        AbstractC4492zt.h(layoutNode, "$this$init");
        this.$onAttached.invoke(new TestModifierUpdater(layoutNode));
    }
}
