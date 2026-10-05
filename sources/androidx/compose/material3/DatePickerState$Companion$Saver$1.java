package androidx.compose.material3;

import androidx.compose.runtime.saveable.SaverScope;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class DatePickerState$Companion$Saver$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    public static final DatePickerState$Companion$Saver$1 INSTANCE = new DatePickerState$Companion$Saver$1();

    public DatePickerState$Companion$Saver$1() {
        super(2);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo13invoke(SaverScope saverScope, DatePickerState datePickerState) {
        AbstractC4492zt.h(saverScope, "$this$Saver");
        AbstractC4492zt.h(datePickerState, "it");
        return StateData.Companion.Saver().save(saverScope, datePickerState.getStateData$material3_release());
    }
}
