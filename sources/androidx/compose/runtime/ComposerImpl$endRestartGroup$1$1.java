package androidx.compose.runtime;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class ComposerImpl$endRestartGroup$1$1 extends AbstractC2233fv implements InterfaceC0552Gp {
    final /* synthetic */ InterfaceC3750qp $it;
    final /* synthetic */ ComposerImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposerImpl$endRestartGroup$1$1(InterfaceC3750qp interfaceC3750qp, ComposerImpl composerImpl) {
        super(3);
        this.$it = interfaceC3750qp;
        this.this$0 = composerImpl;
    }

    @Override // defpackage.InterfaceC0552Gp
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((Applier<?>) obj, (SlotWriter) obj2, (RememberManager) obj3);
        return FW.a;
    }

    public final void invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
        AbstractC4492zt.h(applier, "<anonymous parameter 0>");
        AbstractC4492zt.h(slotWriter, "<anonymous parameter 1>");
        AbstractC4492zt.h(rememberManager, "<anonymous parameter 2>");
        this.$it.invoke(this.this$0.getComposition());
    }
}
