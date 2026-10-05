package androidx.compose.material;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class BottomSheetScaffoldKt$BottomSheetScaffold$child$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ int $$dirty2;
    final /* synthetic */ InterfaceC0552Gp $content;
    final /* synthetic */ InterfaceC0526Fp $floatingActionButton;
    final /* synthetic */ int $floatingActionButtonPosition;
    final /* synthetic */ float $peekHeightPx;
    final /* synthetic */ BottomSheetScaffoldState $scaffoldState;
    final /* synthetic */ long $sheetBackgroundColor;
    final /* synthetic */ InterfaceC0552Gp $sheetContent;
    final /* synthetic */ long $sheetContentColor;
    final /* synthetic */ float $sheetElevation;
    final /* synthetic */ boolean $sheetGesturesEnabled;
    final /* synthetic */ float $sheetPeekHeight;
    final /* synthetic */ Shape $sheetShape;
    final /* synthetic */ InterfaceC0552Gp $snackbarHost;
    final /* synthetic */ InterfaceC0526Fp $topBar;

    /* JADX INFO: renamed from: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$child$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ int $$dirty1;
        final /* synthetic */ float $peekHeightPx;
        final /* synthetic */ BottomSheetScaffoldState $scaffoldState;
        final /* synthetic */ long $sheetBackgroundColor;
        final /* synthetic */ InterfaceC0552Gp $sheetContent;
        final /* synthetic */ long $sheetContentColor;
        final /* synthetic */ float $sheetElevation;
        final /* synthetic */ boolean $sheetGesturesEnabled;
        final /* synthetic */ float $sheetPeekHeight;
        final /* synthetic */ Shape $sheetShape;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z, BottomSheetScaffoldState bottomSheetScaffoldState, float f, float f2, Shape shape, float f3, long j, long j2, InterfaceC0552Gp interfaceC0552Gp, int i, int i2) {
            super(3);
            this.$sheetGesturesEnabled = z;
            this.$scaffoldState = bottomSheetScaffoldState;
            this.$sheetPeekHeight = f;
            this.$peekHeightPx = f2;
            this.$sheetShape = shape;
            this.$sheetElevation = f3;
            this.$sheetBackgroundColor = j;
            this.$sheetContentColor = j2;
            this.$sheetContent = interfaceC0552Gp;
            this.$$dirty = i;
            this.$$dirty1 = i2;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke(((Number) obj).intValue(), (Composer) obj2, ((Number) obj3).intValue());
            return FW.a;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void invoke(int i, Composer composer, int i2) {
            int i3;
            Modifier modifierNestedScroll$default;
            if ((i2 & 14) == 0) {
                i3 = i2 | (composer.changed(i) ? 4 : 2);
            } else {
                i3 = i2;
            }
            if ((i3 & 91) == 18 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1378534681, i3, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous>.<anonymous> (BottomSheetScaffold.kt:452)");
            }
            composer.startReplaceableGroup(-816851374);
            if (this.$sheetGesturesEnabled) {
                Modifier.Companion companion = Modifier.Companion;
                AnchoredDraggableState<BottomSheetValue> anchoredDraggableState$material_release = this.$scaffoldState.getBottomSheetState().getAnchoredDraggableState$material_release();
                BottomSheetScaffoldState bottomSheetScaffoldState = this.$scaffoldState;
                composer.startReplaceableGroup(1157296644);
                boolean zChanged = composer.changed(anchoredDraggableState$material_release);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = BottomSheetScaffoldKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(bottomSheetScaffoldState.getBottomSheetState().getAnchoredDraggableState$material_release(), Orientation.Vertical);
                    composer.updateRememberedValue(objRememberedValue);
                }
                composer.endReplaceableGroup();
                modifierNestedScroll$default = NestedScrollModifierKt.nestedScroll$default(companion, (NestedScrollConnection) objRememberedValue, null, 2, null);
            } else {
                modifierNestedScroll$default = Modifier.Companion;
            }
            composer.endReplaceableGroup();
            BottomSheetState bottomSheetState = this.$scaffoldState.getBottomSheetState();
            Modifier modifierM523requiredHeightInVpY3zN4$default = SizeKt.m523requiredHeightInVpY3zN4$default(SizeKt.fillMaxWidth$default(modifierNestedScroll$default, 0.0f, 1, null), this.$sheetPeekHeight, 0.0f, 2, null);
            boolean z = this.$sheetGesturesEnabled;
            Integer numValueOf = Integer.valueOf(i);
            Float fValueOf = Float.valueOf(this.$peekHeightPx);
            float f = this.$peekHeightPx;
            composer.startReplaceableGroup(511388516);
            boolean zChanged2 = composer.changed(numValueOf) | composer.changed(fValueOf);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new BottomSheetScaffoldKt$BottomSheetScaffold$child$1$1$1$1(i, f);
                composer.updateRememberedValue(objRememberedValue2);
            }
            composer.endReplaceableGroup();
            InterfaceC3750qp interfaceC3750qp = (InterfaceC3750qp) objRememberedValue2;
            Shape shape = this.$sheetShape;
            float f2 = this.$sheetElevation;
            long j = this.$sheetBackgroundColor;
            long j2 = this.$sheetContentColor;
            InterfaceC0552Gp interfaceC0552Gp = this.$sheetContent;
            int i4 = this.$$dirty;
            int i5 = this.$$dirty1;
            BottomSheetScaffoldKt.m1006BottomSheet0cLKjW4(bottomSheetState, z, interfaceC3750qp, shape, f2, j, j2, modifierM523requiredHeightInVpY3zN4$default, interfaceC0552Gp, composer, ((i4 >> 18) & 112) | ((i4 >> 15) & 7168) | ((i4 >> 15) & 57344) | ((i5 << 15) & 458752) | ((i5 << 15) & 3670016) | ((i4 << 24) & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$child$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ BottomSheetScaffoldState $scaffoldState;
        final /* synthetic */ InterfaceC0552Gp $snackbarHost;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(InterfaceC0552Gp interfaceC0552Gp, BottomSheetScaffoldState bottomSheetScaffoldState, int i) {
            super(2);
            this.$snackbarHost = interfaceC0552Gp;
            this.$scaffoldState = bottomSheetScaffoldState;
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
                ComposerKt.traceEventStart(-486138068, i, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous>.<anonymous> (BottomSheetScaffold.kt:490)");
            }
            this.$snackbarHost.invoke(this.$scaffoldState.getSnackbarHostState(), composer, Integer.valueOf((this.$$dirty >> 9) & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomSheetScaffoldKt$BottomSheetScaffold$child$1(BottomSheetScaffoldState bottomSheetScaffoldState, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0552Gp interfaceC0552Gp, InterfaceC0526Fp interfaceC0526Fp2, float f, int i, int i2, int i3, int i4, boolean z, float f2, Shape shape, float f3, long j, long j2, InterfaceC0552Gp interfaceC0552Gp2, InterfaceC0552Gp interfaceC0552Gp3) {
        super(2);
        this.$scaffoldState = bottomSheetScaffoldState;
        this.$topBar = interfaceC0526Fp;
        this.$content = interfaceC0552Gp;
        this.$floatingActionButton = interfaceC0526Fp2;
        this.$sheetPeekHeight = f;
        this.$floatingActionButtonPosition = i;
        this.$$dirty = i2;
        this.$$dirty2 = i3;
        this.$$dirty1 = i4;
        this.$sheetGesturesEnabled = z;
        this.$peekHeightPx = f2;
        this.$sheetShape = shape;
        this.$sheetElevation = f3;
        this.$sheetBackgroundColor = j;
        this.$sheetContentColor = j2;
        this.$sheetContent = interfaceC0552Gp2;
        this.$snackbarHost = interfaceC0552Gp3;
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
            ComposerKt.traceEventStart(893101063, i, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous> (BottomSheetScaffold.kt:448)");
        }
        BottomSheetState bottomSheetState = this.$scaffoldState.getBottomSheetState();
        InterfaceC0526Fp interfaceC0526Fp = this.$topBar;
        InterfaceC0552Gp interfaceC0552Gp = this.$content;
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, -1378534681, true, new AnonymousClass1(this.$sheetGesturesEnabled, this.$scaffoldState, this.$sheetPeekHeight, this.$peekHeightPx, this.$sheetShape, this.$sheetElevation, this.$sheetBackgroundColor, this.$sheetContentColor, this.$sheetContent, this.$$dirty, this.$$dirty1));
        InterfaceC0526Fp interfaceC0526Fp2 = this.$floatingActionButton;
        ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composer, -486138068, true, new AnonymousClass2(this.$snackbarHost, this.$scaffoldState, this.$$dirty));
        float f = this.$sheetPeekHeight;
        int i2 = this.$floatingActionButtonPosition;
        BottomSheetScaffoldState bottomSheetScaffoldState = this.$scaffoldState;
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(bottomSheetScaffoldState);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$child$1$3$1(bottomSheetScaffoldState);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        int i3 = this.$$dirty;
        BottomSheetScaffoldKt.m1008BottomSheetScaffoldLayoutKCBPh4w(interfaceC0526Fp, interfaceC0552Gp, composableLambda, interfaceC0526Fp2, composableLambda2, f, i2, (InterfaceC3588op) objRememberedValue, bottomSheetState, composer, ((i3 >> 9) & 14) | 24960 | ((this.$$dirty2 >> 3) & 112) | ((i3 >> 6) & 7168) | ((this.$$dirty1 << 9) & 458752) | (i3 & 3670016));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
