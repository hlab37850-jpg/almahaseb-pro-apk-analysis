package androidx.compose.material3;

import androidx.compose.runtime.saveable.SaverScope;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class StateData$Companion$Saver$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    public static final StateData$Companion$Saver$1 INSTANCE = new StateData$Companion$Saver$1();

    public StateData$Companion$Saver$1() {
        super(2);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final List<Object> mo13invoke(SaverScope saverScope, StateData stateData) {
        AbstractC4492zt.h(saverScope, "$this$listSaver");
        AbstractC4492zt.h(stateData, "it");
        CalendarDate value = stateData.getSelectedStartDate().getValue();
        Long lValueOf = value != null ? Long.valueOf(value.getUtcTimeMillis()) : null;
        CalendarDate value2 = stateData.getSelectedEndDate().getValue();
        return AbstractC1886cc.p(lValueOf, value2 != null ? Long.valueOf(value2.getUtcTimeMillis()) : null, Long.valueOf(stateData.getDisplayedMonth().getStartUtcTimeMillis()), Integer.valueOf(stateData.getYearRange().b()), Integer.valueOf(stateData.getYearRange().c()), Integer.valueOf(stateData.getDisplayMode().getValue().m1535unboximpl()));
    }
}
