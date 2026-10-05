package androidx.compose.material3;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class SwipeToDismissDefaults$FixedPositionalThreshold$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    public static final SwipeToDismissDefaults$FixedPositionalThreshold$1 INSTANCE = new SwipeToDismissDefaults$FixedPositionalThreshold$1();

    public SwipeToDismissDefaults$FixedPositionalThreshold$1() {
        super(2);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        return invoke((Density) obj, ((Number) obj2).floatValue());
    }

    public final Float invoke(Density density, float f) {
        AbstractC4492zt.h(density, "$this$null");
        return Float.valueOf(density.mo333toPx0680j_4(Dp.m5160constructorimpl(56)));
    }
}
