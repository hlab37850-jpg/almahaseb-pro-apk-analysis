package androidx.compose.material;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SwitchKt$SwitchImpl$2$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ State<Color> $trackColor$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwitchKt$SwitchImpl$2$1(State<Color> state) {
        super(1);
        this.$trackColor$delegate = state;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return FW.a;
    }

    public final void invoke(DrawScope drawScope) {
        AbstractC4492zt.h(drawScope, "$this$Canvas");
        SwitchKt.m1241drawTrackRPmYEkk(drawScope, SwitchKt.SwitchImpl$lambda$16(this.$trackColor$delegate), drawScope.mo333toPx0680j_4(SwitchKt.getTrackWidth()), drawScope.mo333toPx0680j_4(SwitchKt.getTrackStrokeWidth()));
    }
}
