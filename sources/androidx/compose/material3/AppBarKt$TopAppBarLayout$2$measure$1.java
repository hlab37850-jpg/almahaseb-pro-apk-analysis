package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class AppBarKt$TopAppBarLayout$2$measure$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ Placeable $actionIconsPlaceable;
    final /* synthetic */ long $constraints;
    final /* synthetic */ int $layoutHeight;
    final /* synthetic */ Placeable $navigationIconPlaceable;
    final /* synthetic */ MeasureScope $this_Layout;
    final /* synthetic */ int $titleBaseline;
    final /* synthetic */ int $titleBottomPadding;
    final /* synthetic */ Arrangement.Horizontal $titleHorizontalArrangement;
    final /* synthetic */ Placeable $titlePlaceable;
    final /* synthetic */ Arrangement.Vertical $titleVerticalArrangement;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppBarKt$TopAppBarLayout$2$measure$1(Placeable placeable, int i, Placeable placeable2, Arrangement.Horizontal horizontal, long j, Placeable placeable3, MeasureScope measureScope, Arrangement.Vertical vertical, int i2, int i3) {
        super(1);
        this.$navigationIconPlaceable = placeable;
        this.$layoutHeight = i;
        this.$titlePlaceable = placeable2;
        this.$titleHorizontalArrangement = horizontal;
        this.$constraints = j;
        this.$actionIconsPlaceable = placeable3;
        this.$this_Layout = measureScope;
        this.$titleVerticalArrangement = vertical;
        this.$titleBottomPadding = i2;
        this.$titleBaseline = i3;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return FW.a;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        int iM5128getMaxWidthimpl;
        int i;
        int height;
        int iMax;
        int height2;
        AbstractC4492zt.h(placementScope, "$this$layout");
        Placeable placeable = this.$navigationIconPlaceable;
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, (this.$layoutHeight - placeable.getHeight()) / 2, 0.0f, 4, null);
        Placeable placeable2 = this.$titlePlaceable;
        Arrangement.Horizontal horizontal = this.$titleHorizontalArrangement;
        Arrangement arrangement = Arrangement.INSTANCE;
        if (AbstractC4492zt.d(horizontal, arrangement.getCenter())) {
            iM5128getMaxWidthimpl = (Constraints.m5128getMaxWidthimpl(this.$constraints) - this.$titlePlaceable.getWidth()) / 2;
        } else {
            iM5128getMaxWidthimpl = AbstractC4492zt.d(horizontal, arrangement.getEnd()) ? (Constraints.m5128getMaxWidthimpl(this.$constraints) - this.$titlePlaceable.getWidth()) - this.$actionIconsPlaceable.getWidth() : Math.max(this.$this_Layout.mo327roundToPx0680j_4(AppBarKt.TopAppBarTitleInset), this.$navigationIconPlaceable.getWidth());
        }
        int i2 = iM5128getMaxWidthimpl;
        Arrangement.Vertical vertical = this.$titleVerticalArrangement;
        if (!AbstractC4492zt.d(vertical, arrangement.getCenter())) {
            if (AbstractC4492zt.d(vertical, arrangement.getBottom())) {
                if (this.$titleBottomPadding == 0) {
                    height = this.$layoutHeight;
                    iMax = this.$titlePlaceable.getHeight();
                } else {
                    height = this.$layoutHeight - this.$titlePlaceable.getHeight();
                    iMax = Math.max(0, (this.$titleBottomPadding - this.$titlePlaceable.getHeight()) + this.$titleBaseline);
                }
                height2 = height - iMax;
            } else {
                i = 0;
            }
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i2, i, 0.0f, 4, null);
            Placeable.PlacementScope.placeRelative$default(placementScope, this.$actionIconsPlaceable, Constraints.m5128getMaxWidthimpl(this.$constraints) - this.$actionIconsPlaceable.getWidth(), (this.$layoutHeight - this.$actionIconsPlaceable.getHeight()) / 2, 0.0f, 4, null);
        }
        height2 = (this.$layoutHeight - this.$titlePlaceable.getHeight()) / 2;
        i = height2;
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i2, i, 0.0f, 4, null);
        Placeable.PlacementScope.placeRelative$default(placementScope, this.$actionIconsPlaceable, Constraints.m5128getMaxWidthimpl(this.$constraints) - this.$actionIconsPlaceable.getWidth(), (this.$layoutHeight - this.$actionIconsPlaceable.getHeight()) / 2, 0.0f, 4, null);
    }
}
