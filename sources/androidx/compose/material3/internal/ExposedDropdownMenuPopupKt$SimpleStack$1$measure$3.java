package androidx.compose.material3.internal;

import androidx.compose.ui.layout.Placeable;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ExposedDropdownMenuPopupKt$SimpleStack$1$measure$3 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ List<Placeable> $placeables;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ExposedDropdownMenuPopupKt$SimpleStack$1$measure$3(List<? extends Placeable> list) {
        super(1);
        this.$placeables = list;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return FW.a;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        AbstractC4492zt.h(placementScope, "$this$layout");
        int iO = AbstractC1886cc.o(this.$placeables);
        if (iO < 0) {
            return;
        }
        int i = 0;
        while (true) {
            Placeable.PlacementScope.placeRelative$default(placementScope, this.$placeables.get(i), 0, 0, 0.0f, 4, null);
            if (i == iO) {
                return;
            } else {
                i++;
            }
        }
    }
}
