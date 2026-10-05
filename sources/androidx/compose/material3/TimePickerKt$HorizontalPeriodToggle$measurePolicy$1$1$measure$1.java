package androidx.compose.material3;

import androidx.compose.ui.layout.Placeable;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class TimePickerKt$HorizontalPeriodToggle$measurePolicy$1$1$measure$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ List<Placeable> $items;
    final /* synthetic */ Placeable $spacerPlaceable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TimePickerKt$HorizontalPeriodToggle$measurePolicy$1$1$measure$1(List<? extends Placeable> list, Placeable placeable) {
        super(1);
        this.$items = list;
        this.$spacerPlaceable = placeable;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return FW.a;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        AbstractC4492zt.h(placementScope, "$this$layout");
        Placeable.PlacementScope.place$default(placementScope, this.$items.get(0), 0, 0, 0.0f, 4, null);
        Placeable.PlacementScope.place$default(placementScope, this.$items.get(1), this.$items.get(0).getWidth(), 0, 0.0f, 4, null);
        Placeable.PlacementScope.place$default(placementScope, this.$spacerPlaceable, this.$items.get(0).getWidth() - (this.$spacerPlaceable.getWidth() / 2), 0, 0.0f, 4, null);
    }
}
