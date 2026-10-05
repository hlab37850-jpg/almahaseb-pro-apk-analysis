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
public final class ChipKt$Chip$2 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ ChipColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ InterfaceC0526Fp $label;
    final /* synthetic */ long $labelColor;
    final /* synthetic */ TextStyle $labelTextStyle;
    final /* synthetic */ InterfaceC0526Fp $leadingIcon;
    final /* synthetic */ float $minHeight;
    final /* synthetic */ PaddingValues $paddingValues;
    final /* synthetic */ InterfaceC0526Fp $trailingIcon;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChipKt$Chip$2(InterfaceC0526Fp interfaceC0526Fp, TextStyle textStyle, long j, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, ChipColors chipColors, boolean z, int i, float f, PaddingValues paddingValues, int i2) {
        super(2);
        this.$label = interfaceC0526Fp;
        this.$labelTextStyle = textStyle;
        this.$labelColor = j;
        this.$leadingIcon = interfaceC0526Fp2;
        this.$trailingIcon = interfaceC0526Fp3;
        this.$colors = chipColors;
        this.$enabled = z;
        this.$$dirty = i;
        this.$minHeight = f;
        this.$paddingValues = paddingValues;
        this.$$dirty1 = i2;
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
            ComposerKt.traceEventStart(-1985962652, i, -1, "androidx.compose.material3.Chip.<anonymous> (Chip.kt:1328)");
        }
        InterfaceC0526Fp interfaceC0526Fp = this.$label;
        TextStyle textStyle = this.$labelTextStyle;
        long j = this.$labelColor;
        InterfaceC0526Fp interfaceC0526Fp2 = this.$leadingIcon;
        InterfaceC0526Fp interfaceC0526Fp3 = this.$trailingIcon;
        ChipColors chipColors = this.$colors;
        boolean z = this.$enabled;
        int i2 = this.$$dirty;
        long jM3042unboximpl = chipColors.leadingIconContentColor$material3_release(z, composer, ((i2 >> 24) & 112) | ((i2 >> 6) & 14)).getValue().m3042unboximpl();
        ChipColors chipColors2 = this.$colors;
        boolean z2 = this.$enabled;
        int i3 = this.$$dirty;
        long jM3042unboximpl2 = chipColors2.trailingIconContentColor$material3_release(z2, composer, ((i3 >> 24) & 112) | ((i3 >> 6) & 14)).getValue().m3042unboximpl();
        float f = this.$minHeight;
        PaddingValues paddingValues = this.$paddingValues;
        int i4 = this.$$dirty;
        int i5 = ((i4 >> 6) & 458752) | ((i4 >> 9) & 896) | ((i4 >> 9) & 14) | 24576 | ((i4 >> 9) & 112) | ((i4 >> 9) & 7168);
        int i6 = this.$$dirty1;
        ChipKt.m1381ChipContentfe0OD_I(interfaceC0526Fp, textStyle, j, interfaceC0526Fp2, null, interfaceC0526Fp3, jM3042unboximpl, jM3042unboximpl2, f, paddingValues, composer, i5 | ((i6 << 18) & 234881024) | ((i6 << 18) & 1879048192));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
