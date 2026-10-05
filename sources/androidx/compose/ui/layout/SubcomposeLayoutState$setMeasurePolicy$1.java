package androidx.compose.ui.layout;

import androidx.compose.ui.node.LayoutNode;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class SubcomposeLayoutState$setMeasurePolicy$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ SubcomposeLayoutState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubcomposeLayoutState$setMeasurePolicy$1(SubcomposeLayoutState subcomposeLayoutState) {
        super(2);
        this.this$0 = subcomposeLayoutState;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        invoke((LayoutNode) obj, (InterfaceC0526Fp) obj2);
        return FW.a;
    }

    public final void invoke(LayoutNode layoutNode, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(layoutNode, "$this$null");
        AbstractC4492zt.h(interfaceC0526Fp, "it");
        layoutNode.setMeasurePolicy(this.this$0.getState().createMeasurePolicy(interfaceC0526Fp));
    }
}
