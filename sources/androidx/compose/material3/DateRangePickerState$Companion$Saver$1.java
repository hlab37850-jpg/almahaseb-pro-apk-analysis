package androidx.compose.material3;

import androidx.compose.runtime.saveable.SaverScope;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class DateRangePickerState$Companion$Saver$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    public static final DateRangePickerState$Companion$Saver$1 INSTANCE = new DateRangePickerState$Companion$Saver$1();

    public DateRangePickerState$Companion$Saver$1() {
        super(2);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo13invoke(SaverScope saverScope, DateRangePickerState dateRangePickerState) {
        AbstractC4492zt.h(saverScope, "$this$Saver");
        AbstractC4492zt.h(dateRangePickerState, "it");
        return StateData.Companion.Saver().save(saverScope, dateRangePickerState.getStateData$material3_release());
    }
}
