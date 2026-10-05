package androidx.compose.material.pullrefresh;

import androidx.compose.animation.core.EasingKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class PullRefreshIndicatorTransformKt$pullRefreshIndicatorTransform$2$2 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ boolean $scale;
    final /* synthetic */ PullRefreshState $state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PullRefreshIndicatorTransformKt$pullRefreshIndicatorTransform$2$2(PullRefreshState pullRefreshState, boolean z) {
        super(1);
        this.$state = pullRefreshState;
        this.$scale = z;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GraphicsLayerScope) obj);
        return FW.a;
    }

    public final void invoke(GraphicsLayerScope graphicsLayerScope) {
        AbstractC4492zt.h(graphicsLayerScope, "$this$graphicsLayer");
        graphicsLayerScope.setTranslationY(this.$state.getPosition$material_release() - Size.m2864getHeightimpl(graphicsLayerScope.mo3195getSizeNHjbRc()));
        if (!this.$scale || this.$state.getRefreshing$material_release()) {
            return;
        }
        float fK = AbstractC3871sJ.k(EasingKt.getLinearOutSlowInEasing().transform(this.$state.getPosition$material_release() / this.$state.getThreshold$material_release()), 0.0f, 1.0f);
        graphicsLayerScope.setScaleX(fK);
        graphicsLayerScope.setScaleY(fK);
    }
}
