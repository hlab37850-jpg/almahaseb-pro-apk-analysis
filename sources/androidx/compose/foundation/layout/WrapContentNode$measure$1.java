package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class WrapContentNode$measure$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ Placeable $placeable;
    final /* synthetic */ MeasureScope $this_measure;
    final /* synthetic */ int $wrapperHeight;
    final /* synthetic */ int $wrapperWidth;
    final /* synthetic */ WrapContentNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WrapContentNode$measure$1(WrapContentNode wrapContentNode, int i, Placeable placeable, int i2, MeasureScope measureScope) {
        super(1);
        this.this$0 = wrapContentNode;
        this.$wrapperWidth = i;
        this.$placeable = placeable;
        this.$wrapperHeight = i2;
        this.$this_measure = measureScope;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return FW.a;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        AbstractC4492zt.h(placementScope, "$this$layout");
        Placeable.PlacementScope.m4203place70tqf50$default(placementScope, this.$placeable, ((IntOffset) this.this$0.getAlignmentCallback().mo13invoke(IntSize.m5312boximpl(IntSizeKt.IntSize(this.$wrapperWidth - this.$placeable.getWidth(), this.$wrapperHeight - this.$placeable.getHeight())), this.$this_measure.getLayoutDirection())).m5287unboximpl(), 0.0f, 2, null);
    }
}
