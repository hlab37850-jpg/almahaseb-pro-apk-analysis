package androidx.compose.material;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4243wx;
import defpackage.FW;
import defpackage.HV;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class SwitchKt$Switch$2$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ AnchoredDraggableState<Boolean> $anchoredDraggableState;
    final /* synthetic */ float $maxBound;
    final /* synthetic */ float $minBound;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwitchKt$Switch$2$1(AnchoredDraggableState<Boolean> anchoredDraggableState, float f, float f2) {
        super(0);
        this.$anchoredDraggableState = anchoredDraggableState;
        this.$minBound = f;
        this.$maxBound = f2;
    }

    @Override // defpackage.InterfaceC3588op
    public /* bridge */ /* synthetic */ Object invoke() {
        m1242invoke();
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1242invoke() {
        AnchoredDraggableState.updateAnchors$material_release$default(this.$anchoredDraggableState, AbstractC4243wx.j(HV.a(Boolean.FALSE, Float.valueOf(this.$minBound)), HV.a(Boolean.TRUE, Float.valueOf(this.$maxBound))), null, 2, null);
    }
}
