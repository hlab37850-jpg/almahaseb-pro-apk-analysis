package androidx.compose.material3;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class TooltipKt$PlainTooltipBox$2 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ InterfaceC0526Fp $tooltip;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TooltipKt$PlainTooltipBox$2(long j, InterfaceC0526Fp interfaceC0526Fp, int i) {
        super(2);
        this.$contentColor = j;
        this.$tooltip = interfaceC0526Fp;
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
            ComposerKt.traceEventStart(-785135750, i, -1, "androidx.compose.material3.PlainTooltipBox.<anonymous> (Tooltip.kt:107)");
        }
        long j = this.$contentColor;
        InterfaceC0526Fp interfaceC0526Fp = this.$tooltip;
        int i2 = this.$$dirty;
        TooltipKt.m2046PlainTooltipImplIv8Zu3U(j, interfaceC0526Fp, composer, ((i2 << 3) & 112) | ((i2 >> 15) & 14));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
