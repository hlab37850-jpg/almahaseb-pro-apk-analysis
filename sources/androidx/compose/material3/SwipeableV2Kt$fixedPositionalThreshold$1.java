package androidx.compose.material3;

import androidx.compose.ui.unit.Density;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class SwipeableV2Kt$fixedPositionalThreshold$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ float $threshold;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeableV2Kt$fixedPositionalThreshold$1(float f) {
        super(2);
        this.$threshold = f;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        return invoke((Density) obj, ((Number) obj2).floatValue());
    }

    public final Float invoke(Density density, float f) {
        AbstractC4492zt.h(density, "$this$null");
        return Float.valueOf(density.mo333toPx0680j_4(this.$threshold));
    }
}
