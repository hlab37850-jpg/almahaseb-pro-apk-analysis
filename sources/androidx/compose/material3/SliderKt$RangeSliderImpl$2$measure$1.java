package androidx.compose.material3;

import androidx.compose.ui.layout.Placeable;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SliderKt$RangeSliderImpl$2$measure$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ int $endThumbOffsetX;
    final /* synthetic */ int $endThumbOffsetY;
    final /* synthetic */ Placeable $endThumbPlaceable;
    final /* synthetic */ int $startThumbOffsetX;
    final /* synthetic */ int $startThumbOffsetY;
    final /* synthetic */ Placeable $startThumbPlaceable;
    final /* synthetic */ int $trackOffsetX;
    final /* synthetic */ int $trackOffsetY;
    final /* synthetic */ Placeable $trackPlaceable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SliderKt$RangeSliderImpl$2$measure$1(Placeable placeable, int i, int i2, Placeable placeable2, int i3, int i4, Placeable placeable3, int i5, int i6) {
        super(1);
        this.$trackPlaceable = placeable;
        this.$trackOffsetX = i;
        this.$trackOffsetY = i2;
        this.$startThumbPlaceable = placeable2;
        this.$startThumbOffsetX = i3;
        this.$startThumbOffsetY = i4;
        this.$endThumbPlaceable = placeable3;
        this.$endThumbOffsetX = i5;
        this.$endThumbOffsetY = i6;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return FW.a;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        AbstractC4492zt.h(placementScope, "$this$layout");
        Placeable.PlacementScope.placeRelative$default(placementScope, this.$trackPlaceable, this.$trackOffsetX, this.$trackOffsetY, 0.0f, 4, null);
        Placeable.PlacementScope.placeRelative$default(placementScope, this.$startThumbPlaceable, this.$startThumbOffsetX, this.$startThumbOffsetY, 0.0f, 4, null);
        Placeable.PlacementScope.placeRelative$default(placementScope, this.$endThumbPlaceable, this.$endThumbOffsetX, this.$endThumbOffsetY, 0.0f, 4, null);
    }
}
