package androidx.compose.runtime;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;

/* JADX INFO: loaded from: classes.dex */
public final class ComposerImpl$apply$operation$1 extends AbstractC2233fv implements InterfaceC0552Gp {
    final /* synthetic */ InterfaceC0526Fp $block;
    final /* synthetic */ V $value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposerImpl$apply$operation$1(InterfaceC0526Fp interfaceC0526Fp, V v) {
        super(3);
        this.$block = interfaceC0526Fp;
        this.$value = v;
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
        this.$block.mo13invoke(applier.getCurrent(), this.$value);
    }
}
