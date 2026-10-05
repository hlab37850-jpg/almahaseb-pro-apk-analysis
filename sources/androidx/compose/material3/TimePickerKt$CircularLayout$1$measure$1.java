package androidx.compose.material3;

import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import defpackage.AbstractC1210aB;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class TimePickerKt$CircularLayout$1$measure$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ long $constraints;
    final /* synthetic */ Placeable $innerCirclePlaceable;
    final /* synthetic */ List<Placeable> $placeables;
    final /* synthetic */ float $radiusPx;
    final /* synthetic */ Placeable $selectorPlaceable;
    final /* synthetic */ float $theta;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TimePickerKt$CircularLayout$1$measure$1(Placeable placeable, List<? extends Placeable> list, Placeable placeable2, long j, float f, float f2) {
        super(1);
        this.$selectorPlaceable = placeable;
        this.$placeables = list;
        this.$innerCirclePlaceable = placeable2;
        this.$constraints = j;
        this.$radiusPx = f;
        this.$theta = f2;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return FW.a;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        AbstractC4492zt.h(placementScope, "$this$layout");
        Placeable placeable = this.$selectorPlaceable;
        if (placeable != null) {
            Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        }
        List<Placeable> list = this.$placeables;
        long j = this.$constraints;
        float f = this.$radiusPx;
        float f2 = this.$theta;
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            int i2 = i + 1;
            if (i < 0) {
                AbstractC1886cc.w();
            }
            Placeable placeable2 = (Placeable) next;
            double d = f;
            Iterator it2 = it;
            double d2 = ((double) (i * f2)) - 1.5707963267948966d;
            Placeable.PlacementScope.place$default(placementScope, placeable2, AbstractC1210aB.b((Math.cos(d2) * d) + ((double) ((Constraints.m5128getMaxWidthimpl(j) / 2) - (placeable2.getWidth() / 2)))), AbstractC1210aB.b((d * Math.sin(d2)) + ((double) ((Constraints.m5127getMaxHeightimpl(j) / 2) - (placeable2.getHeight() / 2)))), 0.0f, 4, null);
            i = i2;
            it = it2;
        }
        Placeable placeable3 = this.$innerCirclePlaceable;
        if (placeable3 != null) {
            Placeable.PlacementScope.place$default(placementScope, placeable3, (Constraints.m5130getMinWidthimpl(this.$constraints) - this.$innerCirclePlaceable.getWidth()) / 2, (Constraints.m5129getMinHeightimpl(this.$constraints) - this.$innerCirclePlaceable.getHeight()) / 2, 0.0f, 4, null);
        }
    }
}
