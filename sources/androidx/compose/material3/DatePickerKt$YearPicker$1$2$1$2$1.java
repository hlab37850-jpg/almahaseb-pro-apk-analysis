package androidx.compose.material3;

import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class DatePickerKt$YearPicker$1$2$1$2$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ InterfaceC3750qp $onYearSelected;
    final /* synthetic */ int $selectedYear;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DatePickerKt$YearPicker$1$2$1$2$1(InterfaceC3750qp interfaceC3750qp, int i) {
        super(0);
        this.$onYearSelected = interfaceC3750qp;
        this.$selectedYear = i;
    }

    @Override // defpackage.InterfaceC3588op
    public /* bridge */ /* synthetic */ Object invoke() {
        m1511invoke();
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1511invoke() {
        this.$onYearSelected.invoke(Integer.valueOf(this.$selectedYear));
    }
}
