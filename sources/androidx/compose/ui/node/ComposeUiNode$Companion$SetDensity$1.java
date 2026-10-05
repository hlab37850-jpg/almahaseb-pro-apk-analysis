package androidx.compose.ui.node;

import androidx.compose.ui.unit.Density;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class ComposeUiNode$Companion$SetDensity$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    public static final ComposeUiNode$Companion$SetDensity$1 INSTANCE = new ComposeUiNode$Companion$SetDensity$1();

    public ComposeUiNode$Companion$SetDensity$1() {
        super(2);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        invoke((ComposeUiNode) obj, (Density) obj2);
        return FW.a;
    }

    public final void invoke(ComposeUiNode composeUiNode, Density density) {
        AbstractC4492zt.h(composeUiNode, "$this$null");
        AbstractC4492zt.h(density, "it");
        composeUiNode.setDensity(density);
    }
}
