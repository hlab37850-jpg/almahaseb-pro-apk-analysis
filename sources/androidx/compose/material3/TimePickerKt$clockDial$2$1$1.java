package androidx.compose.material3;

import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class TimePickerKt$clockDial$2$1$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ TimePickerState $state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimePickerKt$clockDial$2$1$1(TimePickerState timePickerState) {
        super(1);
        this.$state = timePickerState;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m1959invokeozmzZPI(((IntSize) obj).m5324unboximpl());
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
    public final void m1959invokeozmzZPI(long j) {
        this.$state.m1976setCentergyyYBs$material3_release(IntSizeKt.m5326getCenterozmzZPI(j));
    }
}
