package androidx.compose.material3;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.C1001Vs;
import defpackage.InterfaceC3750qp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class StateData$Companion$Saver$2 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final StateData$Companion$Saver$2 INSTANCE = new StateData$Companion$Saver$2();

    public StateData$Companion$Saver$2() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public final StateData invoke(List<? extends Object> list) {
        AbstractC4492zt.h(list, "value");
        Long l = (Long) list.get(0);
        Long l2 = (Long) list.get(1);
        Long l3 = (Long) list.get(2);
        Object obj = list.get(3);
        AbstractC4492zt.f(obj, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue = ((Integer) obj).intValue();
        Object obj2 = list.get(4);
        AbstractC4492zt.f(obj2, "null cannot be cast to non-null type kotlin.Int");
        C1001Vs c1001Vs = new C1001Vs(iIntValue, ((Integer) obj2).intValue());
        Object obj3 = list.get(5);
        AbstractC4492zt.f(obj3, "null cannot be cast to non-null type kotlin.Int");
        return new StateData(l, l2, l3, c1001Vs, DisplayMode.m1530constructorimpl(((Integer) obj3).intValue()), null);
    }
}
