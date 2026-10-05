package androidx.compose.material3;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0552Gp;

/* JADX INFO: renamed from: androidx.compose.material3.ComposableSingletons$BottomSheetScaffoldKt$lambda-2$1, reason: invalid class name */
/* JADX INFO: loaded from: classes.dex */
public final class ComposableSingletons$BottomSheetScaffoldKt$lambda2$1 extends AbstractC2233fv implements InterfaceC0552Gp {
    public static final ComposableSingletons$BottomSheetScaffoldKt$lambda2$1 INSTANCE = new ComposableSingletons$BottomSheetScaffoldKt$lambda2$1();

    public ComposableSingletons$BottomSheetScaffoldKt$lambda2$1() {
        super(3);
    }

    @Override // defpackage.InterfaceC0552Gp
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((SnackbarHostState) obj, (Composer) obj2, ((Number) obj3).intValue());
        return FW.a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(SnackbarHostState snackbarHostState, Composer composer, int i) {
        AbstractC4492zt.h(snackbarHostState, "it");
        if ((i & 14) == 0) {
            i |= composer.changed(snackbarHostState) ? 4 : 2;
        }
        if ((i & 91) == 18 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-928941170, i, -1, "androidx.compose.material3.ComposableSingletons$BottomSheetScaffoldKt.lambda-2.<anonymous> (BottomSheetScaffold.kt:109)");
        }
        SnackbarHostKt.SnackbarHost(snackbarHostState, null, null, composer, i & 14, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
