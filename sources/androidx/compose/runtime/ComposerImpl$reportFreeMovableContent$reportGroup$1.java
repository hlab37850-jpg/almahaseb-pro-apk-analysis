package androidx.compose.runtime;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0552Gp;

/* JADX INFO: loaded from: classes.dex */
public final class ComposerImpl$reportFreeMovableContent$reportGroup$1 extends AbstractC2233fv implements InterfaceC0552Gp {
    final /* synthetic */ MovableContentStateReference $reference;
    final /* synthetic */ ComposerImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposerImpl$reportFreeMovableContent$reportGroup$1(ComposerImpl composerImpl, MovableContentStateReference movableContentStateReference) {
        super(3);
        this.this$0 = composerImpl;
        this.$reference = movableContentStateReference;
    }

    @Override // defpackage.InterfaceC0552Gp
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((Applier<?>) obj, (SlotWriter) obj2, (RememberManager) obj3);
        return FW.a;
    }

    public final void invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
        AbstractC4492zt.h(applier, "<anonymous parameter 0>");
        AbstractC4492zt.h(slotWriter, "slots");
        AbstractC4492zt.h(rememberManager, "<anonymous parameter 2>");
        this.this$0.releaseMovableGroupAtCurrent(this.$reference, slotWriter);
    }
}
