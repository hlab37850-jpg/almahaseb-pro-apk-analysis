package androidx.compose.runtime;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0552Gp;
import defpackage.MJ;

/* JADX INFO: loaded from: classes.dex */
public final class ComposerImpl$insertMovableContentGuarded$1$1$1 extends AbstractC2233fv implements InterfaceC0552Gp {
    final /* synthetic */ Anchor $anchor;
    final /* synthetic */ MJ $effectiveNodeIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposerImpl$insertMovableContentGuarded$1$1$1(MJ mj, Anchor anchor) {
        super(3);
        this.$effectiveNodeIndex = mj;
        this.$anchor = anchor;
    }

    @Override // defpackage.InterfaceC0552Gp
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((Applier<?>) obj, (SlotWriter) obj2, (RememberManager) obj3);
        return FW.a;
    }

    public final void invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
        AbstractC4492zt.h(applier, "applier");
        AbstractC4492zt.h(slotWriter, "slots");
        AbstractC4492zt.h(rememberManager, "<anonymous parameter 2>");
        this.$effectiveNodeIndex.a = ComposerImpl.insertMovableContentGuarded$positionToInsert(slotWriter, this.$anchor, applier);
    }
}
