package androidx.compose.material;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class CheckboxKt$CheckboxImpl$1$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ State<Color> $borderColor$delegate;
    final /* synthetic */ State<Color> $boxColor$delegate;
    final /* synthetic */ CheckDrawingCache $checkCache;
    final /* synthetic */ State<Float> $checkCenterGravitationShiftFraction$delegate;
    final /* synthetic */ State<Color> $checkColor$delegate;
    final /* synthetic */ State<Float> $checkDrawFraction$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckboxKt$CheckboxImpl$1$1(CheckDrawingCache checkDrawingCache, State<Color> state, State<Color> state2, State<Color> state3, State<Float> state4, State<Float> state5) {
        super(1);
        this.$checkCache = checkDrawingCache;
        this.$boxColor$delegate = state;
        this.$borderColor$delegate = state2;
        this.$checkColor$delegate = state3;
        this.$checkDrawFraction$delegate = state4;
        this.$checkCenterGravitationShiftFraction$delegate = state5;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return FW.a;
    }

    public final void invoke(DrawScope drawScope) {
        AbstractC4492zt.h(drawScope, "$this$Canvas");
        float fFloor = (float) Math.floor(drawScope.mo333toPx0680j_4(CheckboxKt.StrokeWidth));
        CheckboxKt.m1031drawBox1wkBAMs(drawScope, CheckboxKt.CheckboxImpl$lambda$9(this.$boxColor$delegate), CheckboxKt.CheckboxImpl$lambda$10(this.$borderColor$delegate), drawScope.mo333toPx0680j_4(CheckboxKt.RadiusSize), fFloor);
        CheckboxKt.m1032drawCheck3IgeMak(drawScope, CheckboxKt.CheckboxImpl$lambda$8(this.$checkColor$delegate), CheckboxKt.CheckboxImpl$lambda$4(this.$checkDrawFraction$delegate), CheckboxKt.CheckboxImpl$lambda$6(this.$checkCenterGravitationShiftFraction$delegate), fFloor, this.$checkCache);
    }
}
