package androidx.compose.material3;

import defpackage.AbstractC2233fv;
import defpackage.C1001Vs;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class DatePickerKt$rememberDatePickerState$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ int $initialDisplayMode;
    final /* synthetic */ Long $initialDisplayedMonthMillis;
    final /* synthetic */ Long $initialSelectedDateMillis;
    final /* synthetic */ C1001Vs $yearRange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DatePickerKt$rememberDatePickerState$1(Long l, Long l2, C1001Vs c1001Vs, int i) {
        super(0);
        this.$initialSelectedDateMillis = l;
        this.$initialDisplayedMonthMillis = l2;
        this.$yearRange = c1001Vs;
        this.$initialDisplayMode = i;
    }

    @Override // defpackage.InterfaceC3588op
    public final DatePickerState invoke() {
        return new DatePickerState(this.$initialSelectedDateMillis, this.$initialDisplayedMonthMillis, this.$yearRange, this.$initialDisplayMode, null);
    }
}
