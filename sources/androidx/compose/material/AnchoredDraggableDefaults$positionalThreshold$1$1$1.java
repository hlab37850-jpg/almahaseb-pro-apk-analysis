package androidx.compose.material;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class AnchoredDraggableDefaults$positionalThreshold$1$1$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ Density $this_with;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchoredDraggableDefaults$positionalThreshold$1$1$1(Density density) {
        super(1);
        this.$this_with = density;
    }

    public final Float invoke(float f) {
        return Float.valueOf(this.$this_with.mo333toPx0680j_4(Dp.m5160constructorimpl(56)));
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).floatValue());
    }
}
