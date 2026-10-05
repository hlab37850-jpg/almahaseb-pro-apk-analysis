package androidx.compose.runtime;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0552Gp;

/* JADX INFO: loaded from: classes.dex */
public final class ComposerKt$skipToGroupEndInstance$1 extends AbstractC2233fv implements InterfaceC0552Gp {
    public static final ComposerKt$skipToGroupEndInstance$1 INSTANCE = new ComposerKt$skipToGroupEndInstance$1();

    public ComposerKt$skipToGroupEndInstance$1() {
        super(3);
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
        slotWriter.skipToGroupEnd();
    }
}
