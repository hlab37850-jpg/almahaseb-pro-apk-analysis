package androidx.compose.material3;

import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class DatePickerKt$Month$rangeSelectionInfo$1$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ CalendarMonth $month;
    final /* synthetic */ boolean $rangeSelectionEnabled;
    final /* synthetic */ StateData $stateData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DatePickerKt$Month$rangeSelectionInfo$1$1(boolean z, CalendarMonth calendarMonth, StateData stateData) {
        super(0);
        this.$rangeSelectionEnabled = z;
        this.$month = calendarMonth;
        this.$stateData = stateData;
    }

    @Override // defpackage.InterfaceC3588op
    public final SelectedRangeInfo invoke() {
        if (this.$rangeSelectionEnabled) {
            return SelectedRangeInfo.Companion.calculateRangeInfo(this.$month, this.$stateData.getSelectedStartDate().getValue(), this.$stateData.getSelectedEndDate().getValue());
        }
        return null;
    }
}
