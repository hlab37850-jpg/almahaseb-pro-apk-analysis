package androidx.compose.material3;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class TimePickerState$Companion$Saver$2 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final TimePickerState$Companion$Saver$2 INSTANCE = new TimePickerState$Companion$Saver$2();

    public TimePickerState$Companion$Saver$2() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public final TimePickerState invoke(List<? extends Object> list) {
        AbstractC4492zt.h(list, "value");
        Object obj = list.get(0);
        AbstractC4492zt.f(obj, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue = ((Integer) obj).intValue();
        Object obj2 = list.get(1);
        AbstractC4492zt.f(obj2, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue2 = ((Integer) obj2).intValue();
        Object obj3 = list.get(2);
        AbstractC4492zt.f(obj3, "null cannot be cast to non-null type kotlin.Boolean");
        return new TimePickerState(iIntValue, iIntValue2, ((Boolean) obj3).booleanValue());
    }
}
