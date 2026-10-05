package androidx.compose.material3;

import androidx.compose.animation.core.Transition;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class TooltipKt$TooltipBox$1$2 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ long $containerColor;
    final /* synthetic */ float $elevation;
    final /* synthetic */ float $maxWidth;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ InterfaceC0526Fp $tooltipContent;
    final /* synthetic */ String $tooltipPaneDescription;
    final /* synthetic */ Transition<Boolean> $transition;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TooltipKt$TooltipBox$1$2(Modifier modifier, float f, Transition<Boolean> transition, String str, Shape shape, long j, float f2, InterfaceC0526Fp interfaceC0526Fp, int i) {
        super(2);
        this.$modifier = modifier;
        this.$maxWidth = f;
        this.$transition = transition;
        this.$tooltipPaneDescription = str;
        this.$shape = shape;
        this.$containerColor = j;
        this.$elevation = f2;
        this.$tooltipContent = interfaceC0526Fp;
        this.$$dirty = i;
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
            ComposerKt.traceEventStart(-442150991, i, -1, "androidx.compose.material3.TooltipBox.<anonymous>.<anonymous> (Tooltip.kt:256)");
        }
        Modifier modifierAnimateTooltip = TooltipKt.animateTooltip(SizeKt.m536sizeInqDBjuR0$default(this.$modifier, TooltipKt.getTooltipMinWidth(), TooltipKt.getTooltipMinHeight(), this.$maxWidth, 0.0f, 8, null), this.$transition);
        String str = this.$tooltipPaneDescription;
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(str);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new TooltipKt$TooltipBox$1$2$1$1(str);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierAnimateTooltip, false, (InterfaceC3750qp) objRememberedValue, 1, null);
        Shape shape = this.$shape;
        long j = this.$containerColor;
        float f = this.$elevation;
        InterfaceC0526Fp interfaceC0526Fp = this.$tooltipContent;
        int i2 = this.$$dirty;
        SurfaceKt.m1850SurfaceT9BRK9s(modifierSemantics$default, shape, j, 0L, f, f, null, interfaceC0526Fp, composer, ((i2 >> 6) & 112) | ((i2 >> 9) & 896) | (57344 & (i2 >> 6)) | ((i2 >> 3) & 458752) | ((i2 << 21) & 29360128), 72);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
