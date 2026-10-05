package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.Placeable;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class FlowLayoutKt$breakDownItems$nextSize$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ Placeable[] $placeables;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowLayoutKt$breakDownItems$nextSize$1(Placeable[] placeableArr) {
        super(1);
        this.$placeables = placeableArr;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable) obj);
        return FW.a;
    }

    public final void invoke(Placeable placeable) {
        this.$placeables[0] = placeable;
    }
}
