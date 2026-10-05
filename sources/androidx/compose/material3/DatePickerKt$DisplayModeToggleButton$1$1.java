package androidx.compose.material3;

import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class DatePickerKt$DisplayModeToggleButton$1$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ InterfaceC3750qp $onDisplayModeChange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DatePickerKt$DisplayModeToggleButton$1$1(InterfaceC3750qp interfaceC3750qp) {
        super(0);
        this.$onDisplayModeChange = interfaceC3750qp;
    }

    @Override // defpackage.InterfaceC3588op
    public /* bridge */ /* synthetic */ Object invoke() {
        m1507invoke();
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1507invoke() {
        this.$onDisplayModeChange.invoke(DisplayMode.m1529boximpl(DisplayMode.Companion.m1536getInputjFl4v0()));
    }
}
