package androidx.compose.ui.node;

import androidx.compose.ui.platform.ViewConfiguration;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class ComposeUiNode$Companion$SetViewConfiguration$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    public static final ComposeUiNode$Companion$SetViewConfiguration$1 INSTANCE = new ComposeUiNode$Companion$SetViewConfiguration$1();

    public ComposeUiNode$Companion$SetViewConfiguration$1() {
        super(2);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        invoke((ComposeUiNode) obj, (ViewConfiguration) obj2);
        return FW.a;
    }

    public final void invoke(ComposeUiNode composeUiNode, ViewConfiguration viewConfiguration) {
        AbstractC4492zt.h(composeUiNode, "$this$null");
        AbstractC4492zt.h(viewConfiguration, "it");
        composeUiNode.setViewConfiguration(viewConfiguration);
    }
}
