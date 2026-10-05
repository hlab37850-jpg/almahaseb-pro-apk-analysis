package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Shape;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;

/* JADX INFO: loaded from: classes.dex */
public final class BottomSheetScaffoldKt$BottomSheetScaffold$2 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ InterfaceC0526Fp $child;
    final /* synthetic */ long $drawerBackgroundColor;
    final /* synthetic */ InterfaceC0552Gp $drawerContent;
    final /* synthetic */ long $drawerContentColor;
    final /* synthetic */ float $drawerElevation;
    final /* synthetic */ boolean $drawerGesturesEnabled;
    final /* synthetic */ long $drawerScrimColor;
    final /* synthetic */ Shape $drawerShape;
    final /* synthetic */ BottomSheetScaffoldState $scaffoldState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomSheetScaffoldKt$BottomSheetScaffold$2(InterfaceC0552Gp interfaceC0552Gp, InterfaceC0526Fp interfaceC0526Fp, BottomSheetScaffoldState bottomSheetScaffoldState, boolean z, Shape shape, float f, long j, long j2, long j3, int i) {
        super(2);
        this.$drawerContent = interfaceC0552Gp;
        this.$child = interfaceC0526Fp;
        this.$scaffoldState = bottomSheetScaffoldState;
        this.$drawerGesturesEnabled = z;
        this.$drawerShape = shape;
        this.$drawerElevation = f;
        this.$drawerBackgroundColor = j;
        this.$drawerContentColor = j2;
        this.$drawerScrimColor = j3;
        this.$$dirty1 = i;
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
            ComposerKt.traceEventStart(1273816607, i, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous> (BottomSheetScaffold.kt:504)");
        }
        if (this.$drawerContent == null) {
            composer.startReplaceableGroup(-249540336);
            this.$child.mo13invoke(composer, 6);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-249540299);
            InterfaceC0552Gp interfaceC0552Gp = this.$drawerContent;
            DrawerState drawerState = this.$scaffoldState.getDrawerState();
            boolean z = this.$drawerGesturesEnabled;
            Shape shape = this.$drawerShape;
            float f = this.$drawerElevation;
            long j = this.$drawerBackgroundColor;
            long j2 = this.$drawerContentColor;
            long j3 = this.$drawerScrimColor;
            InterfaceC0526Fp interfaceC0526Fp = this.$child;
            int i2 = this.$$dirty1;
            DrawerKt.m1094ModalDrawerGs3lGvM(interfaceC0552Gp, null, drawerState, z, shape, f, j, j2, j3, interfaceC0526Fp, composer, ((i2 >> 3) & 7168) | ((i2 >> 9) & 14) | 805306368 | ((i2 >> 3) & 57344) | ((i2 >> 3) & 458752) | ((i2 >> 3) & 3670016) | ((i2 >> 3) & 29360128) | ((i2 >> 3) & 234881024), 2);
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
