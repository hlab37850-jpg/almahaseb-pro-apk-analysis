package androidx.compose.foundation;

import androidx.compose.ui.layout.Placeable;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class ScrollingLayoutNode$measure$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ Placeable $placeable;
    final /* synthetic */ int $side;
    final /* synthetic */ ScrollingLayoutNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollingLayoutNode$measure$1(ScrollingLayoutNode scrollingLayoutNode, int i, Placeable placeable) {
        super(1);
        this.this$0 = scrollingLayoutNode;
        this.$side = i;
        this.$placeable = placeable;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return FW.a;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        AbstractC4492zt.h(placementScope, "$this$layout");
        int iL = AbstractC3871sJ.l(this.this$0.getScrollerState().getValue(), 0, this.$side);
        int i = this.this$0.isReversed() ? iL - this.$side : -iL;
        Placeable.PlacementScope.placeRelativeWithLayer$default(placementScope, this.$placeable, this.this$0.isVertical() ? 0 : i, this.this$0.isVertical() ? i : 0, 0.0f, null, 12, null);
    }
}
