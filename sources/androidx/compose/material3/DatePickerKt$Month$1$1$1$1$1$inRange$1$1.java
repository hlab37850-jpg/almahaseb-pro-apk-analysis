package androidx.compose.material3;

import androidx.core.location.LocationRequestCompat;
import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class DatePickerKt$Month$1$1$1$1$1$inRange$1$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ long $dateInMillis;
    final /* synthetic */ boolean $rangeSelectionEnabled;
    final /* synthetic */ StateData $stateData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DatePickerKt$Month$1$1$1$1$1$inRange$1$1(StateData stateData, boolean z, long j) {
        super(0);
        this.$stateData = stateData;
        this.$rangeSelectionEnabled = z;
        this.$dateInMillis = j;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x003b  */
    @Override // defpackage.InterfaceC3588op
    public final Boolean invoke() {
        boolean z;
        StateData stateData = this.$stateData;
        boolean z2 = this.$rangeSelectionEnabled;
        long j = this.$dateInMillis;
        if (z2) {
            CalendarDate value = stateData.getSelectedStartDate().getValue();
            if (j < (value != null ? value.getUtcTimeMillis() : LocationRequestCompat.PASSIVE_INTERVAL)) {
                z = false;
            } else {
                CalendarDate value2 = stateData.getSelectedEndDate().getValue();
                if (j <= (value2 != null ? value2.getUtcTimeMillis() : Long.MIN_VALUE)) {
                    z = true;
                } else {
                    z = false;
                }
            }
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
