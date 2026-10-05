package androidx.compose.material;

import androidx.compose.ui.layout.Placeable;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SnackbarKt$TextOnlySnackbar$2$measure$4 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ int $containerHeight;
    final /* synthetic */ Placeable $textPlaceable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SnackbarKt$TextOnlySnackbar$2$measure$4(int i, Placeable placeable) {
        super(1);
        this.$containerHeight = i;
        this.$textPlaceable = placeable;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return FW.a;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        AbstractC4492zt.h(placementScope, "$this$layout");
        Placeable.PlacementScope.placeRelative$default(placementScope, this.$textPlaceable, 0, (this.$containerHeight - this.$textPlaceable.getHeight()) / 2, 0.0f, 4, null);
    }
}
