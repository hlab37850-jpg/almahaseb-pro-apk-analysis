package androidx.compose.ui.node;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class BackwardsCompatNodeKt$updateModifierLocalConsumer$1 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final BackwardsCompatNodeKt$updateModifierLocalConsumer$1 INSTANCE = new BackwardsCompatNodeKt$updateModifierLocalConsumer$1();

    public BackwardsCompatNodeKt$updateModifierLocalConsumer$1() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BackwardsCompatNode) obj);
        return FW.a;
    }

    public final void invoke(BackwardsCompatNode backwardsCompatNode) {
        AbstractC4492zt.h(backwardsCompatNode, "it");
        backwardsCompatNode.updateModifierLocalConsumer();
    }
}
