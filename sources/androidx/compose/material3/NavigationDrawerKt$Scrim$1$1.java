package androidx.compose.material3;

import androidx.compose.ui.graphics.drawscope.DrawScope;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3255kk;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class NavigationDrawerKt$Scrim$1$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ long $color;
    final /* synthetic */ InterfaceC3588op $fraction;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavigationDrawerKt$Scrim$1$1(long j, InterfaceC3588op interfaceC3588op) {
        super(1);
        this.$color = j;
        this.$fraction = interfaceC3588op;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return FW.a;
    }

    public final void invoke(DrawScope drawScope) {
        AbstractC4492zt.h(drawScope, "$this$Canvas");
        AbstractC3255kk.K(drawScope, this.$color, 0L, 0L, ((Number) this.$fraction.invoke()).floatValue(), null, null, 0, 118, null);
    }
}
