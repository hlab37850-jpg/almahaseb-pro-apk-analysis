package androidx.compose.material3;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class ModalBottomSheet_androidKt$ModalBottomSheet$2 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ AnchorChangeHandler<SheetValue> $anchorChangeHandler;
    final /* synthetic */ InterfaceC3588op $animateToDismiss;
    final /* synthetic */ long $containerColor;
    final /* synthetic */ InterfaceC0552Gp $content;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ InterfaceC0526Fp $dragHandle;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ InterfaceC2052dg $scope;
    final /* synthetic */ long $scrimColor;
    final /* synthetic */ InterfaceC3750qp $settleToDismiss;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ SheetState $sheetState;
    final /* synthetic */ float $tonalElevation;

    /* JADX INFO: renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ int $$dirty1;
        final /* synthetic */ AnchorChangeHandler<SheetValue> $anchorChangeHandler;
        final /* synthetic */ InterfaceC3588op $animateToDismiss;
        final /* synthetic */ long $containerColor;
        final /* synthetic */ InterfaceC0552Gp $content;
        final /* synthetic */ long $contentColor;
        final /* synthetic */ InterfaceC0526Fp $dragHandle;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ InterfaceC2052dg $scope;
        final /* synthetic */ long $scrimColor;
        final /* synthetic */ InterfaceC3750qp $settleToDismiss;
        final /* synthetic */ Shape $shape;
        final /* synthetic */ SheetState $sheetState;
        final /* synthetic */ float $tonalElevation;

        /* JADX INFO: renamed from: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$2$1$5, reason: invalid class name */
        public static final class AnonymousClass5 extends AbstractC2233fv implements InterfaceC0526Fp {
            final /* synthetic */ int $$dirty;
            final /* synthetic */ int $$dirty1;
            final /* synthetic */ InterfaceC3588op $animateToDismiss;
            final /* synthetic */ InterfaceC0552Gp $content;
            final /* synthetic */ InterfaceC0526Fp $dragHandle;
            final /* synthetic */ InterfaceC2052dg $scope;
            final /* synthetic */ SheetState $sheetState;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass5(InterfaceC0526Fp interfaceC0526Fp, InterfaceC0552Gp interfaceC0552Gp, int i, SheetState sheetState, InterfaceC3588op interfaceC3588op, InterfaceC2052dg interfaceC2052dg, int i2) {
                super(2);
                this.$dragHandle = interfaceC0526Fp;
                this.$content = interfaceC0552Gp;
                this.$$dirty1 = i;
                this.$sheetState = sheetState;
                this.$animateToDismiss = interfaceC3588op;
                this.$scope = interfaceC2052dg;
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
                int i2;
                if ((i & 11) == 2 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1371274015, i, -1, "androidx.compose.material3.ModalBottomSheet.<anonymous>.<anonymous>.<anonymous> (ModalBottomSheet.android.kt:220)");
                }
                Modifier.Companion companion = Modifier.Companion;
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                InterfaceC0526Fp interfaceC0526Fp = this.$dragHandle;
                InterfaceC0552Gp interfaceC0552Gp = this.$content;
                int i3 = this.$$dirty1;
                SheetState sheetState = this.$sheetState;
                InterfaceC3588op interfaceC3588op = this.$animateToDismiss;
                InterfaceC2052dg interfaceC2052dg = this.$scope;
                int i4 = this.$$dirty;
                composer.startReplaceableGroup(-483455358);
                Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
                Alignment.Companion companion2 = Alignment.Companion;
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composer, 0);
                composer.startReplaceableGroup(-1323940314);
                Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
                InterfaceC3588op constructor = companion3.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf = LayoutKt.materializerOf(modifierFillMaxWidth$default);
                if (!(composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor);
                } else {
                    composer.useNode();
                }
                composer.disableReusing();
                Composer composerM2661constructorimpl = Updater.m2661constructorimpl(composer);
                Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, density, companion3.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl, layoutDirection, companion3.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl, viewConfiguration, companion3.getSetViewConfiguration());
                composer.enableReusing();
                interfaceC0552GpMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer)), composer, 0);
                composer.startReplaceableGroup(2058660585);
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                composer.startReplaceableGroup(-11289811);
                if (interfaceC0526Fp != null) {
                    Strings.Companion companion4 = Strings.Companion;
                    String strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(companion4.m1782getBottomSheetPartialExpandDescriptionadMyvUU(), composer, 6);
                    i2 = 6;
                    Modifier modifierSemantics = SemanticsModifierKt.semantics(columnScopeInstance.align(companion, companion2.getCenterHorizontally()), true, new ModalBottomSheet_androidKt$ModalBottomSheet$2$1$5$1$1(sheetState, Strings_androidKt.m1841getStringNWtq28(companion4.m1778getBottomSheetDismissDescriptionadMyvUU(), composer, 6), Strings_androidKt.m1841getStringNWtq28(companion4.m1780getBottomSheetExpandDescriptionadMyvUU(), composer, 6), strM1841getStringNWtq28, interfaceC3588op, interfaceC2052dg));
                    composer.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composer, 0);
                    composer.startReplaceableGroup(-1323940314);
                    Density density2 = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection2 = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    InterfaceC3588op constructor2 = companion3.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpMaterializerOf2 = LayoutKt.materializerOf(modifierSemantics);
                    if (!(composer.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        composer.createNode(constructor2);
                    } else {
                        composer.useNode();
                    }
                    composer.disableReusing();
                    Composer composerM2661constructorimpl2 = Updater.m2661constructorimpl(composer);
                    Updater.m2668setimpl(composerM2661constructorimpl2, measurePolicyRememberBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl2, density2, companion3.getSetDensity());
                    Updater.m2668setimpl(composerM2661constructorimpl2, layoutDirection2, companion3.getSetLayoutDirection());
                    Updater.m2668setimpl(composerM2661constructorimpl2, viewConfiguration2, companion3.getSetViewConfiguration());
                    composer.enableReusing();
                    interfaceC0552GpMaterializerOf2.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer)), composer, 0);
                    composer.startReplaceableGroup(2058660585);
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    interfaceC0526Fp.mo13invoke(composer, Integer.valueOf((i4 >> 24) & 14));
                    composer.endReplaceableGroup();
                    composer.endNode();
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                } else {
                    i2 = 6;
                }
                composer.endReplaceableGroup();
                interfaceC0552Gp.invoke(columnScopeInstance, composer, Integer.valueOf(i2 | ((i3 << 3) & 112)));
                composer.endReplaceableGroup();
                composer.endNode();
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, InterfaceC3588op interfaceC3588op, SheetState sheetState, int i, Modifier modifier, AnchorChangeHandler<SheetValue> anchorChangeHandler, InterfaceC3750qp interfaceC3750qp, Shape shape, long j2, long j3, float f, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0552Gp interfaceC0552Gp, int i2, InterfaceC2052dg interfaceC2052dg) {
            super(3);
            this.$scrimColor = j;
            this.$animateToDismiss = interfaceC3588op;
            this.$sheetState = sheetState;
            this.$$dirty = i;
            this.$modifier = modifier;
            this.$anchorChangeHandler = anchorChangeHandler;
            this.$settleToDismiss = interfaceC3750qp;
            this.$shape = shape;
            this.$containerColor = j2;
            this.$contentColor = j3;
            this.$tonalElevation = f;
            this.$dragHandle = interfaceC0526Fp;
            this.$content = interfaceC0552Gp;
            this.$$dirty1 = i2;
            this.$scope = interfaceC2052dg;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
            return FW.a;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, int i) {
            int i2;
            AbstractC4492zt.h(boxWithConstraintsScope, "$this$BoxWithConstraints");
            if ((i & 14) == 0) {
                i2 = (composer.changed(boxWithConstraintsScope) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i2 & 91) == 18 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(574030426, i, -1, "androidx.compose.material3.ModalBottomSheet.<anonymous>.<anonymous> (ModalBottomSheet.android.kt:177)");
            }
            int iM5127getMaxHeightimpl = Constraints.m5127getMaxHeightimpl(boxWithConstraintsScope.mo423getConstraintsmsEJaDk());
            ModalBottomSheet_androidKt.m1648Scrim3JVO9M(this.$scrimColor, this.$animateToDismiss, this.$sheetState.getTargetValue() != SheetValue.Hidden, composer, (this.$$dirty >> 21) & 14);
            String strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1781getBottomSheetPaneTitleadMyvUU(), composer, 6);
            Modifier modifierAlign = boxWithConstraintsScope.align(SizeKt.fillMaxWidth$default(SizeKt.m539widthInVpY3zN4$default(this.$modifier, 0.0f, SheetDefaultsKt.getBottomSheetMaxWidth(), 1, null), 0.0f, 1, null), Alignment.Companion.getTopCenter());
            composer.startReplaceableGroup(1157296644);
            boolean zChanged = composer.changed(strM1841getStringNWtq28);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new ModalBottomSheet_androidKt$ModalBottomSheet$2$1$1$1(strM1841getStringNWtq28);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierAlign, false, (InterfaceC3750qp) objRememberedValue, 1, null);
            SheetState sheetState = this.$sheetState;
            composer.startReplaceableGroup(1157296644);
            boolean zChanged2 = composer.changed(sheetState);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new ModalBottomSheet_androidKt$ModalBottomSheet$2$1$2$1(sheetState);
                composer.updateRememberedValue(objRememberedValue2);
            }
            composer.endReplaceableGroup();
            Modifier modifierOffset = OffsetKt.offset(modifierSemantics$default, (InterfaceC3750qp) objRememberedValue2);
            SheetState sheetState2 = this.$sheetState;
            InterfaceC3750qp interfaceC3750qp = this.$settleToDismiss;
            composer.startReplaceableGroup(1157296644);
            boolean zChanged3 = composer.changed(sheetState2);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChanged3 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                objRememberedValue3 = SheetDefaultsKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(sheetState2, Orientation.Vertical, interfaceC3750qp);
                composer.updateRememberedValue(objRememberedValue3);
            }
            composer.endReplaceableGroup();
            Modifier modifierNestedScroll$default = NestedScrollModifierKt.nestedScroll$default(modifierOffset, (NestedScrollConnection) objRememberedValue3, null, 2, null);
            SheetState sheetState3 = this.$sheetState;
            AnchorChangeHandler<SheetValue> anchorChangeHandler = this.$anchorChangeHandler;
            float f = iM5127getMaxHeightimpl;
            InterfaceC3750qp interfaceC3750qp2 = this.$settleToDismiss;
            composer.startReplaceableGroup(1157296644);
            boolean zChanged4 = composer.changed(interfaceC3750qp2);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChanged4 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                objRememberedValue4 = new ModalBottomSheet_androidKt$ModalBottomSheet$2$1$4$1(interfaceC3750qp2);
                composer.updateRememberedValue(objRememberedValue4);
            }
            composer.endReplaceableGroup();
            Modifier modifierModalBottomSheetSwipeable = ModalBottomSheet_androidKt.modalBottomSheetSwipeable(modifierNestedScroll$default, sheetState3, anchorChangeHandler, f, (InterfaceC0526Fp) objRememberedValue4);
            Shape shape = this.$shape;
            long j = this.$containerColor;
            long j2 = this.$contentColor;
            float f2 = this.$tonalElevation;
            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, 1371274015, true, new AnonymousClass5(this.$dragHandle, this.$content, this.$$dirty1, this.$sheetState, this.$animateToDismiss, this.$scope, this.$$dirty));
            int i3 = this.$$dirty;
            SurfaceKt.m1850SurfaceT9BRK9s(modifierModalBottomSheetSwipeable, shape, j, j2, f2, 0.0f, null, composableLambda, composer, ((i3 >> 6) & 112) | 12582912 | ((i3 >> 6) & 896) | ((i3 >> 6) & 7168) | ((i3 >> 6) & 57344), 96);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModalBottomSheet_androidKt$ModalBottomSheet$2(long j, InterfaceC3588op interfaceC3588op, SheetState sheetState, int i, Modifier modifier, AnchorChangeHandler<SheetValue> anchorChangeHandler, InterfaceC3750qp interfaceC3750qp, Shape shape, long j2, long j3, float f, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0552Gp interfaceC0552Gp, int i2, InterfaceC2052dg interfaceC2052dg) {
        super(2);
        this.$scrimColor = j;
        this.$animateToDismiss = interfaceC3588op;
        this.$sheetState = sheetState;
        this.$$dirty = i;
        this.$modifier = modifier;
        this.$anchorChangeHandler = anchorChangeHandler;
        this.$settleToDismiss = interfaceC3750qp;
        this.$shape = shape;
        this.$containerColor = j2;
        this.$contentColor = j3;
        this.$tonalElevation = f;
        this.$dragHandle = interfaceC0526Fp;
        this.$content = interfaceC0552Gp;
        this.$$dirty1 = i2;
        this.$scope = interfaceC2052dg;
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
            ComposerKt.traceEventStart(1424497392, i, -1, "androidx.compose.material3.ModalBottomSheet.<anonymous> (ModalBottomSheet.android.kt:176)");
        }
        BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), null, false, ComposableLambdaKt.composableLambda(composer, 574030426, true, new AnonymousClass1(this.$scrimColor, this.$animateToDismiss, this.$sheetState, this.$$dirty, this.$modifier, this.$anchorChangeHandler, this.$settleToDismiss, this.$shape, this.$containerColor, this.$contentColor, this.$tonalElevation, this.$dragHandle, this.$content, this.$$dirty1, this.$scope)), composer, 3078, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
