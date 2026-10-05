package androidx.compose.material;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class AnchoredDraggableDefaults$velocityThreshold$1$1$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ Density $this_with;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchoredDraggableDefaults$velocityThreshold$1$1$1(Density density) {
        super(0);
        this.$this_with = density;
    }

    @Override // defpackage.InterfaceC3588op
    public final Float invoke() {
        return Float.valueOf(this.$this_with.mo333toPx0680j_4(Dp.m5160constructorimpl(125)));
    }
}
