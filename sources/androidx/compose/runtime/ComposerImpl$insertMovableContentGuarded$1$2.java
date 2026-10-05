package androidx.compose.runtime;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0552Gp;

/* JADX INFO: loaded from: classes.dex */
public final class ComposerImpl$insertMovableContentGuarded$1$2 extends AbstractC2233fv implements InterfaceC0552Gp {
    public static final ComposerImpl$insertMovableContentGuarded$1$2 INSTANCE = new ComposerImpl$insertMovableContentGuarded$1$2();

    public ComposerImpl$insertMovableContentGuarded$1$2() {
        super(3);
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
        ComposerImpl.insertMovableContentGuarded$positionToParentOf(slotWriter, applier, 0);
        slotWriter.endGroup();
    }
}
