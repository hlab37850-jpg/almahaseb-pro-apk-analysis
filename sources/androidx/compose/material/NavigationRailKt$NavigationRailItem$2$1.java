package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;

/* JADX INFO: loaded from: classes.dex */
public final class NavigationRailKt$NavigationRailItem$2$1 extends AbstractC2233fv implements InterfaceC0552Gp {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ boolean $alwaysShowLabel;
    final /* synthetic */ InterfaceC0526Fp $icon;
    final /* synthetic */ InterfaceC0526Fp $styledLabel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavigationRailKt$NavigationRailItem$2$1(boolean z, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, int i) {
        super(3);
        this.$alwaysShowLabel = z;
        this.$icon = interfaceC0526Fp;
        this.$styledLabel = interfaceC0526Fp2;
        this.$$dirty = i;
    }

    @Override // defpackage.InterfaceC0552Gp
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke(((Number) obj).floatValue(), (Composer) obj2, ((Number) obj3).intValue());
        return FW.a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(float f, Composer composer, int i) {
        int i2;
        if ((i & 14) == 0) {
            i2 = (composer.changed(f) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 91) == 18 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(670576792, i, -1, "androidx.compose.material.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:191)");
        }
        if (this.$alwaysShowLabel) {
            f = 1.0f;
        }
        NavigationRailKt.NavigationRailItemBaselineLayout(this.$icon, this.$styledLabel, f, composer, (this.$$dirty >> 6) & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
