package androidx.compose.material3;

import androidx.compose.runtime.saveable.SaverScope;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class TimePickerState$Companion$Saver$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    public static final TimePickerState$Companion$Saver$1 INSTANCE = new TimePickerState$Companion$Saver$1();

    public TimePickerState$Companion$Saver$1() {
        super(2);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final List<Object> mo13invoke(SaverScope saverScope, TimePickerState timePickerState) {
        AbstractC4492zt.h(saverScope, "$this$Saver");
        AbstractC4492zt.h(timePickerState, "it");
        return AbstractC1886cc.p(Integer.valueOf(timePickerState.getHour()), Integer.valueOf(timePickerState.getMinute()), Boolean.valueOf(timePickerState.is24hour()));
    }
}
