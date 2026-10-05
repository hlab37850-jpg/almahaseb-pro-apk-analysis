package androidx.compose.foundation.text;

import androidx.compose.ui.layout.Placeable;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class EmptyMeasurePolicy$placementBlock$1 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final EmptyMeasurePolicy$placementBlock$1 INSTANCE = new EmptyMeasurePolicy$placementBlock$1();

    public EmptyMeasurePolicy$placementBlock$1() {
        super(1);
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        AbstractC4492zt.h(placementScope, "$this$null");
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return FW.a;
    }
}
