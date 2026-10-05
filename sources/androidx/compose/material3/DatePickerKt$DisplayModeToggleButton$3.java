package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class DatePickerKt$DisplayModeToggleButton$3 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $displayMode;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ InterfaceC3750qp $onDisplayModeChange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DatePickerKt$DisplayModeToggleButton$3(Modifier modifier, int i, InterfaceC3750qp interfaceC3750qp, int i2) {
        super(2);
        this.$modifier = modifier;
        this.$displayMode = i;
        this.$onDisplayModeChange = interfaceC3750qp;
        this.$$changed = i2;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return FW.a;
    }

    public final void invoke(Composer composer, int i) {
        DatePickerKt.m1501DisplayModeToggleButtontER2X8s(this.$modifier, this.$displayMode, this.$onDisplayModeChange, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
