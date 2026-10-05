package androidx.compose.ui.viewinterop;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Density;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidView_androidKt$updateViewHolderParams$2 extends AbstractC2233fv implements InterfaceC0526Fp {
    public static final AndroidView_androidKt$updateViewHolderParams$2 INSTANCE = new AndroidView_androidKt$updateViewHolderParams$2();

    public AndroidView_androidKt$updateViewHolderParams$2() {
        super(2);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        invoke((LayoutNode) obj, (Density) obj2);
        return FW.a;
    }

    public final void invoke(LayoutNode layoutNode, Density density) {
        AbstractC4492zt.h(layoutNode, "$this$set");
        AbstractC4492zt.h(density, "it");
        AndroidView_androidKt.requireViewFactoryHolder(layoutNode).setDensity(density);
    }
}
