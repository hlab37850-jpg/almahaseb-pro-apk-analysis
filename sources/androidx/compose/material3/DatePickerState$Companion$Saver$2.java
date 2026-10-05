package androidx.compose.material3;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class DatePickerState$Companion$Saver$2 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final DatePickerState$Companion$Saver$2 INSTANCE = new DatePickerState$Companion$Saver$2();

    public DatePickerState$Companion$Saver$2() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public final DatePickerState invoke(Object obj) {
        AbstractC4492zt.h(obj, "value");
        StateData stateDataRestore = StateData.Companion.Saver().restore(obj);
        AbstractC4492zt.e(stateDataRestore);
        return new DatePickerState(stateDataRestore, null);
    }
}
