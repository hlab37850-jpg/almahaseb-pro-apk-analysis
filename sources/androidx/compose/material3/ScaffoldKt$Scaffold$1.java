package androidx.compose.material3;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;

/* JADX INFO: loaded from: classes.dex */
public final class ScaffoldKt$Scaffold$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ InterfaceC0526Fp $bottomBar;
    final /* synthetic */ InterfaceC0552Gp $content;
    final /* synthetic */ WindowInsets $contentWindowInsets;
    final /* synthetic */ InterfaceC0526Fp $floatingActionButton;
    final /* synthetic */ int $floatingActionButtonPosition;
    final /* synthetic */ InterfaceC0526Fp $snackbarHost;
    final /* synthetic */ InterfaceC0526Fp $topBar;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScaffoldKt$Scaffold$1(int i, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0552Gp interfaceC0552Gp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, WindowInsets windowInsets, InterfaceC0526Fp interfaceC0526Fp4, int i2) {
        super(2);
        this.$floatingActionButtonPosition = i;
        this.$topBar = interfaceC0526Fp;
        this.$content = interfaceC0552Gp;
        this.$snackbarHost = interfaceC0526Fp2;
        this.$floatingActionButton = interfaceC0526Fp3;
        this.$contentWindowInsets = windowInsets;
        this.$bottomBar = interfaceC0526Fp4;
        this.$$dirty = i2;
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
            ComposerKt.traceEventStart(-1979205334, i, -1, "androidx.compose.material3.Scaffold.<anonymous> (Scaffold.kt:85)");
        }
        int i2 = this.$floatingActionButtonPosition;
        InterfaceC0526Fp interfaceC0526Fp = this.$topBar;
        InterfaceC0552Gp interfaceC0552Gp = this.$content;
        InterfaceC0526Fp interfaceC0526Fp2 = this.$snackbarHost;
        InterfaceC0526Fp interfaceC0526Fp3 = this.$floatingActionButton;
        WindowInsets windowInsets = this.$contentWindowInsets;
        InterfaceC0526Fp interfaceC0526Fp4 = this.$bottomBar;
        int i3 = this.$$dirty;
        ScaffoldKt.m1726ScaffoldLayoutFMILGgc(i2, interfaceC0526Fp, interfaceC0552Gp, interfaceC0526Fp2, interfaceC0526Fp3, windowInsets, interfaceC0526Fp4, composer, ((i3 >> 15) & 14) | (i3 & 112) | ((i3 >> 21) & 896) | (i3 & 7168) | (57344 & i3) | ((i3 >> 9) & 458752) | ((i3 << 12) & 3670016));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
