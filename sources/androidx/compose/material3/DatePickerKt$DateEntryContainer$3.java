package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextStyle;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class DatePickerKt$DateEntryContainer$3 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ int $$changed;
    final /* synthetic */ DatePickerColors $colors;
    final /* synthetic */ InterfaceC0526Fp $content;
    final /* synthetic */ float $headerMinHeight;
    final /* synthetic */ InterfaceC0526Fp $headline;
    final /* synthetic */ TextStyle $headlineTextStyle;
    final /* synthetic */ InterfaceC0526Fp $modeToggleButton;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ InterfaceC0526Fp $title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DatePickerKt$DateEntryContainer$3(Modifier modifier, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, DatePickerColors datePickerColors, TextStyle textStyle, float f, InterfaceC0526Fp interfaceC0526Fp4, int i) {
        super(2);
        this.$modifier = modifier;
        this.$title = interfaceC0526Fp;
        this.$headline = interfaceC0526Fp2;
        this.$modeToggleButton = interfaceC0526Fp3;
        this.$colors = datePickerColors;
        this.$headlineTextStyle = textStyle;
        this.$headerMinHeight = f;
        this.$content = interfaceC0526Fp4;
        this.$$changed = i;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return FW.a;
    }

    public final void invoke(Composer composer, int i) {
        DatePickerKt.m1499DateEntryContainerau3_HiA(this.$modifier, this.$title, this.$headline, this.$modeToggleButton, this.$colors, this.$headlineTextStyle, this.$headerMinHeight, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
