package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.text.TextStyle;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class ChipKt$SelectableChip$2 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ InterfaceC0526Fp $avatar;
    final /* synthetic */ SelectableChipColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ InterfaceC0526Fp $label;
    final /* synthetic */ TextStyle $labelTextStyle;
    final /* synthetic */ InterfaceC0526Fp $leadingIcon;
    final /* synthetic */ float $minHeight;
    final /* synthetic */ PaddingValues $paddingValues;
    final /* synthetic */ boolean $selected;
    final /* synthetic */ InterfaceC0526Fp $trailingIcon;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChipKt$SelectableChip$2(SelectableChipColors selectableChipColors, boolean z, boolean z2, int i, int i2, InterfaceC0526Fp interfaceC0526Fp, TextStyle textStyle, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, InterfaceC0526Fp interfaceC0526Fp4, float f, PaddingValues paddingValues) {
        super(2);
        this.$colors = selectableChipColors;
        this.$enabled = z;
        this.$selected = z2;
        this.$$dirty = i;
        this.$$dirty1 = i2;
        this.$label = interfaceC0526Fp;
        this.$labelTextStyle = textStyle;
        this.$leadingIcon = interfaceC0526Fp2;
        this.$avatar = interfaceC0526Fp3;
        this.$trailingIcon = interfaceC0526Fp4;
        this.$minHeight = f;
        this.$paddingValues = paddingValues;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return FW.a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(Composer composer, int i) {
        if ((i & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-577614814, i, -1, "androidx.compose.material3.SelectableChip.<anonymous> (Chip.kt:1378)");
        }
        SelectableChipColors selectableChipColors = this.$colors;
        boolean z = this.$enabled;
        boolean z2 = this.$selected;
        int i2 = this.$$dirty;
        long jM3042unboximpl = selectableChipColors.labelColor$material3_release(z, z2, composer, ((i2 << 3) & 112) | ((i2 >> 9) & 14) | ((this.$$dirty1 << 6) & 896)).getValue().m3042unboximpl();
        SelectableChipColors selectableChipColors2 = this.$colors;
        boolean z3 = this.$enabled;
        boolean z4 = this.$selected;
        int i3 = this.$$dirty;
        long jM3042unboximpl2 = selectableChipColors2.leadingIconContentColor$material3_release(z3, z4, composer, ((i3 << 3) & 112) | ((i3 >> 9) & 14) | ((this.$$dirty1 << 6) & 896)).getValue().m3042unboximpl();
        SelectableChipColors selectableChipColors3 = this.$colors;
        boolean z5 = this.$enabled;
        boolean z6 = this.$selected;
        int i4 = this.$$dirty;
        long jM3042unboximpl3 = selectableChipColors3.trailingIconContentColor$material3_release(z5, z6, composer, ((i4 << 3) & 112) | ((i4 >> 9) & 14) | ((this.$$dirty1 << 6) & 896)).getValue().m3042unboximpl();
        InterfaceC0526Fp interfaceC0526Fp = this.$label;
        TextStyle textStyle = this.$labelTextStyle;
        InterfaceC0526Fp interfaceC0526Fp2 = this.$leadingIcon;
        InterfaceC0526Fp interfaceC0526Fp3 = this.$avatar;
        InterfaceC0526Fp interfaceC0526Fp4 = this.$trailingIcon;
        float f = this.$minHeight;
        PaddingValues paddingValues = this.$paddingValues;
        int i5 = this.$$dirty;
        int i6 = ((i5 >> 12) & 14) | ((i5 >> 12) & 112) | ((i5 >> 9) & 7168) | ((i5 >> 9) & 57344) | ((i5 >> 9) & 458752);
        int i7 = this.$$dirty1;
        ChipKt.m1381ChipContentfe0OD_I(interfaceC0526Fp, textStyle, jM3042unboximpl, interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp4, jM3042unboximpl2, jM3042unboximpl3, f, paddingValues, composer, ((i7 << 15) & 1879048192) | i6 | ((i7 << 15) & 234881024));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
