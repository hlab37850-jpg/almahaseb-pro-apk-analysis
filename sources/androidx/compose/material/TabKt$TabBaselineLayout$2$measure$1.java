package androidx.compose.material;

import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class TabKt$TabBaselineLayout$2$measure$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ Integer $firstBaseline;
    final /* synthetic */ Placeable $iconPlaceable;
    final /* synthetic */ Integer $lastBaseline;
    final /* synthetic */ int $tabHeight;
    final /* synthetic */ int $tabWidth;
    final /* synthetic */ Placeable $textPlaceable;
    final /* synthetic */ MeasureScope $this_Layout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabKt$TabBaselineLayout$2$measure$1(Placeable placeable, Placeable placeable2, MeasureScope measureScope, int i, int i2, Integer num, Integer num2) {
        super(1);
        this.$textPlaceable = placeable;
        this.$iconPlaceable = placeable2;
        this.$this_Layout = measureScope;
        this.$tabWidth = i;
        this.$tabHeight = i2;
        this.$firstBaseline = num;
        this.$lastBaseline = num2;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return FW.a;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        Placeable placeable;
        AbstractC4492zt.h(placementScope, "$this$layout");
        Placeable placeable2 = this.$textPlaceable;
        if (placeable2 == null || (placeable = this.$iconPlaceable) == null) {
            if (placeable2 != null) {
                TabKt.placeTextOrIcon(placementScope, placeable2, this.$tabHeight);
                return;
            }
            Placeable placeable3 = this.$iconPlaceable;
            if (placeable3 != null) {
                TabKt.placeTextOrIcon(placementScope, placeable3, this.$tabHeight);
                return;
            }
            return;
        }
        MeasureScope measureScope = this.$this_Layout;
        int i = this.$tabWidth;
        int i2 = this.$tabHeight;
        Integer num = this.$firstBaseline;
        AbstractC4492zt.e(num);
        int iIntValue = num.intValue();
        Integer num2 = this.$lastBaseline;
        AbstractC4492zt.e(num2);
        TabKt.placeTextAndIcon(placementScope, measureScope, placeable2, placeable, i, i2, iIntValue, num2.intValue());
    }
}
