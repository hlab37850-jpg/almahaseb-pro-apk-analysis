package androidx.compose.runtime;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0552Gp;
import defpackage.MJ;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ComposerImpl$insertMovableContentGuarded$1$1$3 extends AbstractC2233fv implements InterfaceC0552Gp {
    final /* synthetic */ MJ $effectiveNodeIndex;
    final /* synthetic */ List<Object> $nodesToInsert;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposerImpl$insertMovableContentGuarded$1$1$3(MJ mj, List<? extends Object> list) {
        super(3);
        this.$effectiveNodeIndex = mj;
        this.$nodesToInsert = list;
    }

    @Override // defpackage.InterfaceC0552Gp
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((Applier<?>) obj, (SlotWriter) obj2, (RememberManager) obj3);
        return FW.a;
    }

    public final void invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
        AbstractC4492zt.h(applier, "applier");
        AbstractC4492zt.h(slotWriter, "<anonymous parameter 1>");
        AbstractC4492zt.h(rememberManager, "<anonymous parameter 2>");
        int i = this.$effectiveNodeIndex.a;
        List<Object> list = this.$nodesToInsert;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            int i3 = i + i2;
            applier.insertBottomUp(i3, obj);
            applier.insertTopDown(i3, obj);
        }
    }
}
