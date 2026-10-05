package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;

/* JADX INFO: loaded from: classes.dex */
public final class ScaffoldKt$Scaffold$child$1 extends AbstractC2233fv implements InterfaceC0552Gp {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ long $backgroundColor;
    final /* synthetic */ InterfaceC0526Fp $bottomBar;
    final /* synthetic */ InterfaceC0552Gp $content;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ InterfaceC0526Fp $floatingActionButton;
    final /* synthetic */ int $floatingActionButtonPosition;
    final /* synthetic */ boolean $isFloatingActionButtonDocked;
    final /* synthetic */ ScaffoldState $scaffoldState;
    final /* synthetic */ InterfaceC0552Gp $snackbarHost;
    final /* synthetic */ InterfaceC0526Fp $topBar;

    /* JADX INFO: renamed from: androidx.compose.material.ScaffoldKt$Scaffold$child$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ int $$dirty1;
        final /* synthetic */ InterfaceC0526Fp $bottomBar;
        final /* synthetic */ InterfaceC0552Gp $content;
        final /* synthetic */ InterfaceC0526Fp $floatingActionButton;
        final /* synthetic */ int $floatingActionButtonPosition;
        final /* synthetic */ boolean $isFloatingActionButtonDocked;
        final /* synthetic */ ScaffoldState $scaffoldState;
        final /* synthetic */ InterfaceC0552Gp $snackbarHost;
        final /* synthetic */ InterfaceC0526Fp $topBar;

        /* JADX INFO: renamed from: androidx.compose.material.ScaffoldKt$Scaffold$child$1$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00811 extends AbstractC2233fv implements InterfaceC0526Fp {
            final /* synthetic */ int $$dirty;
            final /* synthetic */ ScaffoldState $scaffoldState;
            final /* synthetic */ InterfaceC0552Gp $snackbarHost;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00811(InterfaceC0552Gp interfaceC0552Gp, ScaffoldState scaffoldState, int i) {
                super(2);
                this.$snackbarHost = interfaceC0552Gp;
                this.$scaffoldState = scaffoldState;
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
                    ComposerKt.traceEventStart(533782017, i, -1, "androidx.compose.material.Scaffold.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:185)");
                }
                this.$snackbarHost.invoke(this.$scaffoldState.getSnackbarHostState(), composer, Integer.valueOf((this.$$dirty >> 9) & 112));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z, int i, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0552Gp interfaceC0552Gp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, int i2, int i3, InterfaceC0552Gp interfaceC0552Gp2, ScaffoldState scaffoldState) {
            super(2);
            this.$isFloatingActionButtonDocked = z;
            this.$floatingActionButtonPosition = i;
            this.$topBar = interfaceC0526Fp;
            this.$content = interfaceC0552Gp;
            this.$floatingActionButton = interfaceC0526Fp2;
            this.$bottomBar = interfaceC0526Fp3;
            this.$$dirty = i2;
            this.$$dirty1 = i3;
            this.$snackbarHost = interfaceC0552Gp2;
            this.$scaffoldState = scaffoldState;
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
                ComposerKt.traceEventStart(-1128984656, i, -1, "androidx.compose.material.Scaffold.<anonymous>.<anonymous> (Scaffold.kt:179)");
            }
            boolean z = this.$isFloatingActionButtonDocked;
            int i2 = this.$floatingActionButtonPosition;
            InterfaceC0526Fp interfaceC0526Fp = this.$topBar;
            InterfaceC0552Gp interfaceC0552Gp = this.$content;
            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, 533782017, true, new C00811(this.$snackbarHost, this.$scaffoldState, this.$$dirty));
            InterfaceC0526Fp interfaceC0526Fp2 = this.$floatingActionButton;
            InterfaceC0526Fp interfaceC0526Fp3 = this.$bottomBar;
            int i3 = this.$$dirty;
            ScaffoldKt.m1195ScaffoldLayoutMDYNRJg(z, i2, interfaceC0526Fp, interfaceC0552Gp, composableLambda, interfaceC0526Fp2, interfaceC0526Fp3, composer, ((i3 >> 21) & 14) | 24576 | ((i3 >> 15) & 112) | (i3 & 896) | ((this.$$dirty1 >> 12) & 7168) | (458752 & i3) | ((i3 << 9) & 3670016));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScaffoldKt$Scaffold$child$1(long j, long j2, int i, boolean z, int i2, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0552Gp interfaceC0552Gp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, int i3, InterfaceC0552Gp interfaceC0552Gp2, ScaffoldState scaffoldState) {
        super(3);
        this.$backgroundColor = j;
        this.$contentColor = j2;
        this.$$dirty1 = i;
        this.$isFloatingActionButtonDocked = z;
        this.$floatingActionButtonPosition = i2;
        this.$topBar = interfaceC0526Fp;
        this.$content = interfaceC0552Gp;
        this.$floatingActionButton = interfaceC0526Fp2;
        this.$bottomBar = interfaceC0526Fp3;
        this.$$dirty = i3;
        this.$snackbarHost = interfaceC0552Gp2;
        this.$scaffoldState = scaffoldState;
    }

    @Override // defpackage.InterfaceC0552Gp
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
        return FW.a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(Modifier modifier, Composer composer, int i) {
        int i2;
        AbstractC4492zt.h(modifier, "childModifier");
        if ((i & 14) == 0) {
            i2 = i | (composer.changed(modifier) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i2 & 91) == 18 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1823402604, i2, -1, "androidx.compose.material.Scaffold.<anonymous> (Scaffold.kt:178)");
        }
        long j = this.$backgroundColor;
        long j2 = this.$contentColor;
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, -1128984656, true, new AnonymousClass1(this.$isFloatingActionButtonDocked, this.$floatingActionButtonPosition, this.$topBar, this.$content, this.$floatingActionButton, this.$bottomBar, this.$$dirty, this.$$dirty1, this.$snackbarHost, this.$scaffoldState));
        int i3 = 1572864 | (i2 & 14);
        int i4 = this.$$dirty1;
        SurfaceKt.m1227SurfaceFjzlyU(modifier, null, j, j2, null, 0.0f, composableLambda, composer, i3 | ((i4 >> 9) & 896) | ((i4 >> 9) & 7168), 50);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
