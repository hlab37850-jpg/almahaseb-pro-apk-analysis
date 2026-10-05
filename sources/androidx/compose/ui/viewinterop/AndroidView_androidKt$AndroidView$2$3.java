package androidx.compose.ui.viewinterop;

import androidx.compose.ui.node.LayoutNode;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidView_androidKt$AndroidView$2$3 extends AbstractC2233fv implements InterfaceC0526Fp {
    public static final AndroidView_androidKt$AndroidView$2$3 INSTANCE = new AndroidView_androidKt$AndroidView$2$3();

    public AndroidView_androidKt$AndroidView$2$3() {
        super(2);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        invoke((LayoutNode) obj, (InterfaceC3750qp) obj2);
        return FW.a;
    }

    public final void invoke(LayoutNode layoutNode, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(layoutNode, "$this$set");
        AbstractC4492zt.h(interfaceC3750qp, "it");
        AndroidView_androidKt.requireViewFactoryHolder(layoutNode).setReleaseBlock(interfaceC3750qp);
    }
}
