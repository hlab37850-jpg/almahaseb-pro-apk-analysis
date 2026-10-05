package androidx.compose.material3;

import defpackage.AbstractC2233fv;
import defpackage.C1001Vs;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class DateRangePickerKt$rememberDateRangePickerState$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ int $initialDisplayMode;
    final /* synthetic */ Long $initialDisplayedMonthMillis;
    final /* synthetic */ Long $initialSelectedEndDateMillis;
    final /* synthetic */ Long $initialSelectedStartDateMillis;
    final /* synthetic */ C1001Vs $yearRange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DateRangePickerKt$rememberDateRangePickerState$1(Long l, Long l2, Long l3, C1001Vs c1001Vs, int i) {
        super(0);
        this.$initialSelectedStartDateMillis = l;
        this.$initialSelectedEndDateMillis = l2;
        this.$initialDisplayedMonthMillis = l3;
        this.$yearRange = c1001Vs;
        this.$initialDisplayMode = i;
    }

    @Override // defpackage.InterfaceC3588op
    public final DateRangePickerState invoke() {
        return new DateRangePickerState(this.$initialSelectedStartDateMillis, this.$initialSelectedEndDateMillis, this.$initialDisplayedMonthMillis, this.$yearRange, this.$initialDisplayMode, null);
    }
}
