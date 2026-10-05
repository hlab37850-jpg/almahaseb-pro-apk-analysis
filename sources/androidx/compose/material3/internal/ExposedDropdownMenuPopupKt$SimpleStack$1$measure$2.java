package androidx.compose.material3.internal;

import androidx.compose.ui.layout.Placeable;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class ExposedDropdownMenuPopupKt$SimpleStack$1$measure$2 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ Placeable $p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExposedDropdownMenuPopupKt$SimpleStack$1$measure$2(Placeable placeable) {
        super(1);
        this.$p = placeable;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return FW.a;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        AbstractC4492zt.h(placementScope, "$this$layout");
        Placeable.PlacementScope.placeRelative$default(placementScope, this.$p, 0, 0, 0.0f, 4, null);
    }
}
