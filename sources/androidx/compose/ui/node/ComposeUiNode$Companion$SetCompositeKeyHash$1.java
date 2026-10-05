package androidx.compose.ui.node;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class ComposeUiNode$Companion$SetCompositeKeyHash$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    public static final ComposeUiNode$Companion$SetCompositeKeyHash$1 INSTANCE = new ComposeUiNode$Companion$SetCompositeKeyHash$1();

    public ComposeUiNode$Companion$SetCompositeKeyHash$1() {
        super(2);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        invoke((ComposeUiNode) obj, ((Number) obj2).intValue());
        return FW.a;
    }

    public final void invoke(ComposeUiNode composeUiNode, int i) {
        AbstractC4492zt.h(composeUiNode, "$this$null");
        composeUiNode.setCompositeKeyHash(i);
    }
}
