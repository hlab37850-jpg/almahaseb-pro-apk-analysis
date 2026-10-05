package androidx.compose.runtime;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0552Gp;
import defpackage.MJ;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ComposerImpl$insertMovableContentGuarded$1$1$5$1$2 extends AbstractC2233fv implements InterfaceC0552Gp {
    final /* synthetic */ MJ $effectiveNodeIndex;
    final /* synthetic */ List<InterfaceC0552Gp> $offsetChanges;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposerImpl$insertMovableContentGuarded$1$1$5$1$2(MJ mj, List<InterfaceC0552Gp> list) {
        super(3);
        this.$effectiveNodeIndex = mj;
        this.$offsetChanges = list;
    }

    @Override // defpackage.InterfaceC0552Gp
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((Applier<?>) obj, (SlotWriter) obj2, (RememberManager) obj3);
        return FW.a;
    }

    public final void invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
        AbstractC4492zt.h(applier, "applier");
        AbstractC4492zt.h(slotWriter, "slots");
        AbstractC4492zt.h(rememberManager, "rememberManager");
        int i = this.$effectiveNodeIndex.a;
        if (i > 0) {
            applier = new OffsetApplier(applier, i);
        }
        List<InterfaceC0552Gp> list = this.$offsetChanges;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            list.get(i2).invoke(applier, slotWriter, rememberManager);
        }
    }
}
