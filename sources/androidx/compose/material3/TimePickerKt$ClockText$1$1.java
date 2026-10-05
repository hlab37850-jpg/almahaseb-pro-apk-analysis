package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class TimePickerKt$ClockText$1$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ MutableState<Offset> $center$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimePickerKt$ClockText$1$1(MutableState<Offset> mutableState) {
        super(1);
        this.$center$delegate = mutableState;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LayoutCoordinates) obj);
        return FW.a;
    }

    public final void invoke(LayoutCoordinates layoutCoordinates) {
        AbstractC4492zt.h(layoutCoordinates, "it");
        TimePickerKt.ClockText$lambda$30(this.$center$delegate, LayoutCoordinatesKt.boundsInParent(layoutCoordinates).m2828getCenterF1C5BW0());
    }
}
