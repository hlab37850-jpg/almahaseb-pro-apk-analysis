package androidx.compose.foundation.text;

import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.C2020dG;
import defpackage.FW;
import defpackage.InterfaceC3750qp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class TextMeasurePolicy$measure$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ List<C2020dG> $toPlace;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TextMeasurePolicy$measure$1(List<? extends C2020dG> list) {
        super(1);
        this.$toPlace = list;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return FW.a;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        AbstractC4492zt.h(placementScope, "$this$layout");
        List<C2020dG> list = this.$toPlace;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                C2020dG c2020dG = list.get(i);
                Placeable.PlacementScope.m4203place70tqf50$default(placementScope, (Placeable) c2020dG.a(), ((IntOffset) c2020dG.b()).m5287unboximpl(), 0.0f, 2, null);
            }
        }
    }
}
