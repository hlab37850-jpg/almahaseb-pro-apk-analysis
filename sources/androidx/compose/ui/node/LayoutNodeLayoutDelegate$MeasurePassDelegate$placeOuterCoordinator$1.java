package androidx.compose.ui.node;

import androidx.compose.ui.layout.Placeable;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class LayoutNodeLayoutDelegate$MeasurePassDelegate$placeOuterCoordinator$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ InterfaceC3750qp $layerBlock;
    final /* synthetic */ long $position;
    final /* synthetic */ float $zIndex;
    final /* synthetic */ LayoutNodeLayoutDelegate this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LayoutNodeLayoutDelegate$MeasurePassDelegate$placeOuterCoordinator$1(InterfaceC3750qp interfaceC3750qp, LayoutNodeLayoutDelegate layoutNodeLayoutDelegate, long j, float f) {
        super(0);
        this.$layerBlock = interfaceC3750qp;
        this.this$0 = layoutNodeLayoutDelegate;
        this.$position = j;
        this.$zIndex = f;
    }

    @Override // defpackage.InterfaceC3588op
    public /* bridge */ /* synthetic */ Object invoke() {
        m4318invoke();
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m4318invoke() {
        Placeable.PlacementScope.Companion companion = Placeable.PlacementScope.Companion;
        InterfaceC3750qp interfaceC3750qp = this.$layerBlock;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.this$0;
        long j = this.$position;
        float f = this.$zIndex;
        if (interfaceC3750qp == null) {
            companion.m4207place70tqf50(layoutNodeLayoutDelegate.getOuterCoordinator(), j, f);
        } else {
            companion.m4212placeWithLayeraW9wM(layoutNodeLayoutDelegate.getOuterCoordinator(), j, f, interfaceC3750qp);
        }
    }
}
