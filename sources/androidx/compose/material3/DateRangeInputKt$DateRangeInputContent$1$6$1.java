package androidx.compose.material3;

import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class DateRangeInputKt$DateRangeInputContent$1$6$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ StateData $stateData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DateRangeInputKt$DateRangeInputContent$1$6$1(StateData stateData) {
        super(1);
        this.$stateData = stateData;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CalendarDate) obj);
        return FW.a;
    }

    public final void invoke(CalendarDate calendarDate) {
        this.$stateData.getSelectedEndDate().setValue(calendarDate);
    }
}
