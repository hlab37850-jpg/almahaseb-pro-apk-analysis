package androidx.compose.material3;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SearchBarKt$SearchBar$4$1$1$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ State<Float> $animationProgress;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchBarKt$SearchBar$4$1$1$1(State<Float> state) {
        super(1);
        this.$animationProgress = state;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GraphicsLayerScope) obj);
        return FW.a;
    }

    public final void invoke(GraphicsLayerScope graphicsLayerScope) {
        AbstractC4492zt.h(graphicsLayerScope, "$this$graphicsLayer");
        graphicsLayerScope.setAlpha(this.$animationProgress.getValue().floatValue());
    }
}
