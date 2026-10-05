package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.window.DialogProperties;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class DatePickerDialog_androidKt$DatePickerDialog$2 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ DatePickerColors $colors;
    final /* synthetic */ InterfaceC0526Fp $confirmButton;
    final /* synthetic */ InterfaceC0552Gp $content;
    final /* synthetic */ InterfaceC0526Fp $dismissButton;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ InterfaceC3588op $onDismissRequest;
    final /* synthetic */ DialogProperties $properties;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ float $tonalElevation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DatePickerDialog_androidKt$DatePickerDialog$2(InterfaceC3588op interfaceC3588op, InterfaceC0526Fp interfaceC0526Fp, Modifier modifier, InterfaceC0526Fp interfaceC0526Fp2, Shape shape, float f, DatePickerColors datePickerColors, DialogProperties dialogProperties, InterfaceC0552Gp interfaceC0552Gp, int i, int i2) {
        super(2);
        this.$onDismissRequest = interfaceC3588op;
        this.$confirmButton = interfaceC0526Fp;
        this.$modifier = modifier;
        this.$dismissButton = interfaceC0526Fp2;
        this.$shape = shape;
        this.$tonalElevation = f;
        this.$colors = datePickerColors;
        this.$properties = dialogProperties;
        this.$content = interfaceC0552Gp;
        this.$$changed = i;
        this.$$default = i2;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return FW.a;
    }

    public final void invoke(Composer composer, int i) {
        DatePickerDialog_androidKt.m1498DatePickerDialogGmEhDVc(this.$onDismissRequest, this.$confirmButton, this.$modifier, this.$dismissButton, this.$shape, this.$tonalElevation, this.$colors, this.$properties, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
