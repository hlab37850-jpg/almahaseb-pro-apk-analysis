package androidx.compose.material3;

import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class DatePickerKt$DatePicker$5$1$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ DatePickerState $state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DatePickerKt$DatePicker$5$1$1(DatePickerState datePickerState) {
        super(1);
        this.$state = datePickerState;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m1503invokevCnGnXg(((DisplayMode) obj).m1535unboximpl());
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke-vCnGnXg, reason: not valid java name */
    public final void m1503invokevCnGnXg(int i) {
        this.$state.getStateData$material3_release().m1769switchDisplayModevCnGnXg(i);
    }
}
