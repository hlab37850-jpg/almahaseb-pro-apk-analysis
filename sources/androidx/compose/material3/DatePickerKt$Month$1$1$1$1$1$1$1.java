package androidx.compose.material3;

import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class DatePickerKt$Month$1$1$1$1$1$1$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ long $dateInMillis;
    final /* synthetic */ InterfaceC3750qp $onDateSelected;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DatePickerKt$Month$1$1$1$1$1$1$1(InterfaceC3750qp interfaceC3750qp, long j) {
        super(0);
        this.$onDateSelected = interfaceC3750qp;
        this.$dateInMillis = j;
    }

    @Override // defpackage.InterfaceC3588op
    public /* bridge */ /* synthetic */ Object invoke() {
        m1509invoke();
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1509invoke() {
        this.$onDateSelected.invoke(Long.valueOf(this.$dateInMillis));
    }
}
