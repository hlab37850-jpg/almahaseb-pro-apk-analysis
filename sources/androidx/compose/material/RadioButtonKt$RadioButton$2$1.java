package androidx.compose.material;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.unit.Dp;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3255kk;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class RadioButtonKt$RadioButton$2$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ State<Dp> $dotRadius;
    final /* synthetic */ State<Color> $radioColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RadioButtonKt$RadioButton$2$1(State<Color> state, State<Dp> state2) {
        super(1);
        this.$radioColor = state;
        this.$dotRadius = state2;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return FW.a;
    }

    public final void invoke(DrawScope drawScope) {
        AbstractC4492zt.h(drawScope, "$this$Canvas");
        float fMo333toPx0680j_4 = drawScope.mo333toPx0680j_4(RadioButtonKt.RadioStrokeWidth);
        float f = fMo333toPx0680j_4 / 2;
        AbstractC3255kk.x(drawScope, this.$radioColor.getValue().m3042unboximpl(), drawScope.mo333toPx0680j_4(RadioButtonKt.RadioRadius) - f, 0L, 0.0f, new Stroke(fMo333toPx0680j_4, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
        if (Dp.m5159compareTo0680j_4(this.$dotRadius.getValue().m5174unboximpl(), Dp.m5160constructorimpl(0)) > 0) {
            AbstractC3255kk.x(drawScope, this.$radioColor.getValue().m3042unboximpl(), drawScope.mo333toPx0680j_4(this.$dotRadius.getValue().m5174unboximpl()) - f, 0L, 0.0f, Fill.INSTANCE, null, 0, 108, null);
        }
    }
}
