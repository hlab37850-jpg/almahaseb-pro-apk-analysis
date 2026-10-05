package androidx.compose.animation;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class EnterExitTransitionKt$createModifier$1$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ State<Float> $alpha$delegate;
    final /* synthetic */ State<Float> $scale$delegate;
    final /* synthetic */ State<TransformOrigin> $transformOrigin$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnterExitTransitionKt$createModifier$1$1(State<Float> state, State<Float> state2, State<TransformOrigin> state3) {
        super(1);
        this.$alpha$delegate = state;
        this.$scale$delegate = state2;
        this.$transformOrigin$delegate = state3;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GraphicsLayerScope) obj);
        return FW.a;
    }

    public final void invoke(GraphicsLayerScope graphicsLayerScope) {
        AbstractC4492zt.h(graphicsLayerScope, "$this$graphicsLayer");
        graphicsLayerScope.setAlpha(EnterExitTransitionKt.createModifier$lambda$8(this.$alpha$delegate));
        graphicsLayerScope.setScaleX(EnterExitTransitionKt.createModifier$lambda$11(this.$scale$delegate));
        graphicsLayerScope.setScaleY(EnterExitTransitionKt.createModifier$lambda$11(this.$scale$delegate));
        graphicsLayerScope.mo3201setTransformOrigin__ExYCQ(EnterExitTransitionKt.createModifier$lambda$13(this.$transformOrigin$delegate));
    }
}
