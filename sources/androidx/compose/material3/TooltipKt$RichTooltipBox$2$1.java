package androidx.compose.material3;

import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class TooltipKt$RichTooltipBox$2$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ InterfaceC0526Fp $action;
    final /* synthetic */ RichTooltipState $tooltipState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TooltipKt$RichTooltipBox$2$1(RichTooltipState richTooltipState, InterfaceC0526Fp interfaceC0526Fp) {
        super(0);
        this.$tooltipState = richTooltipState;
        this.$action = interfaceC0526Fp;
    }

    @Override // defpackage.InterfaceC3588op
    public /* bridge */ /* synthetic */ Object invoke() {
        m2050invoke();
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m2050invoke() {
        this.$tooltipState.setPersistent$material3_release(this.$action != null);
    }
}
