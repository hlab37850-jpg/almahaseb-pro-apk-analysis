package androidx.compose.material;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4243wx;
import defpackage.AbstractC4492zt;
import defpackage.C1172Zk;
import defpackage.FW;
import defpackage.HV;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0578Hp;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class BackdropScaffoldKt$BackdropScaffold$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ InterfaceC0526Fp $backLayer;
    final /* synthetic */ InterfaceC3750qp $calculateBackLayerConstraints;
    final /* synthetic */ long $frontLayerBackgroundColor;
    final /* synthetic */ InterfaceC0526Fp $frontLayerContent;
    final /* synthetic */ long $frontLayerContentColor;
    final /* synthetic */ float $frontLayerElevation;
    final /* synthetic */ long $frontLayerScrimColor;
    final /* synthetic */ Shape $frontLayerShape;
    final /* synthetic */ boolean $gesturesEnabled;
    final /* synthetic */ float $headerHeight;
    final /* synthetic */ float $headerHeightPx;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ float $peekHeight;
    final /* synthetic */ float $peekHeightPx;
    final /* synthetic */ BackdropScaffoldState $scaffoldState;
    final /* synthetic */ InterfaceC0552Gp $snackbarHost;
    final /* synthetic */ boolean $stickyFrontLayer;

    /* JADX INFO: renamed from: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0578Hp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ int $$dirty1;
        final /* synthetic */ long $frontLayerBackgroundColor;
        final /* synthetic */ InterfaceC0526Fp $frontLayerContent;
        final /* synthetic */ long $frontLayerContentColor;
        final /* synthetic */ float $frontLayerElevation;
        final /* synthetic */ long $frontLayerScrimColor;
        final /* synthetic */ Shape $frontLayerShape;
        final /* synthetic */ boolean $gesturesEnabled;
        final /* synthetic */ float $headerHeight;
        final /* synthetic */ float $headerHeightPx;
        final /* synthetic */ float $peekHeight;
        final /* synthetic */ float $peekHeightPx;
        final /* synthetic */ BackdropScaffoldState $scaffoldState;
        final /* synthetic */ InterfaceC2052dg $scope;
        final /* synthetic */ InterfaceC0552Gp $snackbarHost;
        final /* synthetic */ boolean $stickyFrontLayer;

        /* JADX INFO: renamed from: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC0526Fp {
            final /* synthetic */ int $$dirty;
            final /* synthetic */ int $$dirty1;
            final /* synthetic */ InterfaceC0526Fp $frontLayerContent;
            final /* synthetic */ long $frontLayerScrimColor;
            final /* synthetic */ boolean $gesturesEnabled;
            final /* synthetic */ float $peekHeight;
            final /* synthetic */ BackdropScaffoldState $scaffoldState;
            final /* synthetic */ InterfaceC2052dg $scope;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(float f, InterfaceC0526Fp interfaceC0526Fp, int i, long j, BackdropScaffoldState backdropScaffoldState, int i2, boolean z, InterfaceC2052dg interfaceC2052dg) {
                super(2);
                this.$peekHeight = f;
                this.$frontLayerContent = interfaceC0526Fp;
                this.$$dirty = i;
                this.$frontLayerScrimColor = j;
                this.$scaffoldState = backdropScaffoldState;
                this.$$dirty1 = i2;
                this.$gesturesEnabled = z;
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
                    ComposerKt.traceEventStart(-1065299503, i, -1, "androidx.compose.material.BackdropScaffold.<anonymous>.<anonymous>.<anonymous> (BackdropScaffold.kt:350)");
                }
                Modifier modifierM489paddingqDBjuR0$default = PaddingKt.m489paddingqDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, this.$peekHeight, 7, null);
                InterfaceC0526Fp interfaceC0526Fp = this.$frontLayerContent;
                int i2 = this.$$dirty;
                long j = this.$frontLayerScrimColor;
                BackdropScaffoldState backdropScaffoldState = this.$scaffoldState;
                int i3 = this.$$dirty1;
                boolean z = this.$gesturesEnabled;
                InterfaceC2052dg interfaceC2052dg = this.$scope;
                composer.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer, 0);
                composer.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion companion = ComposeUiNode.Companion;
                InterfaceC3588op constructor = companion.getConstructor();
                InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifierM489paddingqDBjuR0$default);
                if (!(composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor);
                } else {
                    composer.useNode();
                }
                Composer composerM2661constructorimpl = Updater.m2661constructorimpl(composer);
                Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                InterfaceC0526Fp setCompositeKeyHash = companion.getSetCompositeKeyHash();
                if (composerM2661constructorimpl.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                interfaceC0552GpModifierMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer)), composer, 0);
                composer.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                interfaceC0526Fp.mo13invoke(composer, Integer.valueOf((i2 >> 6) & 14));
                BackdropScaffoldKt.m986Scrim3JVO9M(j, new BackdropScaffoldKt$BackdropScaffold$1$1$2$1$1(z, backdropScaffoldState, interfaceC2052dg), backdropScaffoldState.getTargetValue() == BackdropValue.Revealed, composer, (i3 >> 18) & 14);
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
        public AnonymousClass1(float f, boolean z, boolean z2, BackdropScaffoldState backdropScaffoldState, float f2, int i, Shape shape, long j, long j2, float f3, int i2, float f4, InterfaceC2052dg interfaceC2052dg, float f5, InterfaceC0526Fp interfaceC0526Fp, long j3, InterfaceC0552Gp interfaceC0552Gp) {
            super(4);
            this.$headerHeightPx = f;
            this.$stickyFrontLayer = z;
            this.$gesturesEnabled = z2;
            this.$scaffoldState = backdropScaffoldState;
            this.$peekHeightPx = f2;
            this.$$dirty = i;
            this.$frontLayerShape = shape;
            this.$frontLayerBackgroundColor = j;
            this.$frontLayerContentColor = j2;
            this.$frontLayerElevation = f3;
            this.$$dirty1 = i2;
            this.$headerHeight = f4;
            this.$scope = interfaceC2052dg;
            this.$peekHeight = f5;
            this.$frontLayerContent = interfaceC0526Fp;
            this.$frontLayerScrimColor = j3;
            this.$snackbarHost = interfaceC0552Gp;
        }

        @Override // defpackage.InterfaceC0578Hp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            m988invokejYbf7pk(((Constraints) obj).m5134unboximpl(), ((Number) obj2).floatValue(), (Composer) obj3, ((Number) obj4).intValue());
            return FW.a;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        /* JADX INFO: renamed from: invoke-jYbf7pk, reason: not valid java name */
        public final void m988invokejYbf7pk(long j, float f, Composer composer, int i) {
            int i2;
            if ((i & 14) == 0) {
                i2 = (composer.changed(j) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i & 112) == 0) {
                i2 |= composer.changed(f) ? 32 : 16;
            }
            if ((i2 & 731) == 146 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1800047509, i, -1, "androidx.compose.material.BackdropScaffold.<anonymous>.<anonymous> (BackdropScaffold.kt:302)");
            }
            float fM5127getMaxHeightimpl = Constraints.m5127getMaxHeightimpl(j);
            float fMin = fM5127getMaxHeightimpl - this.$headerHeightPx;
            if (this.$stickyFrontLayer) {
                fMin = Math.min(fMin, f);
            }
            float f2 = fMin;
            Modifier modifierNestedScroll$default = this.$gesturesEnabled ? NestedScrollModifierKt.nestedScroll$default(Modifier.Companion, this.$scaffoldState.getNestedScrollConnection$material_release(), null, 2, null) : Modifier.Companion;
            Modifier.Companion companion = Modifier.Companion;
            Modifier modifierThen = companion.then(modifierNestedScroll$default);
            BackdropScaffoldState backdropScaffoldState = this.$scaffoldState;
            Map mapJ = AbstractC4243wx.j(HV.a(Float.valueOf(this.$peekHeightPx), BackdropValue.Concealed), HV.a(Float.valueOf(f2), BackdropValue.Revealed));
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(SwipeableKt.m1237swipeablepPrIpRY(modifierThen, backdropScaffoldState, mapJ, Orientation.Vertical, (TIFFConstants.TIFFTAG_FREEOFFSETS & 8) != 0 ? true : this.$gesturesEnabled, (TIFFConstants.TIFFTAG_FREEOFFSETS & 16) != 0 ? false : false, (TIFFConstants.TIFFTAG_FREEOFFSETS & 32) != 0 ? null : null, (TIFFConstants.TIFFTAG_FREEOFFSETS & 64) != 0 ? SwipeableKt$swipeable$1.INSTANCE : null, (TIFFConstants.TIFFTAG_FREEOFFSETS & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, mapJ.keySet(), 0.0f, 0.0f, 6, null) : null, (TIFFConstants.TIFFTAG_FREEOFFSETS & 256) != 0 ? SwipeableDefaults.INSTANCE.m1236getVelocityThresholdD9Ej5fM() : 0.0f), false, new BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1(this.$scaffoldState, this.$scope), 1, null);
            BackdropScaffoldState backdropScaffoldState2 = this.$scaffoldState;
            composer.startReplaceableGroup(1157296644);
            boolean zChanged = composer.changed(backdropScaffoldState2);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new BackdropScaffoldKt$BackdropScaffold$1$1$1$1(backdropScaffoldState2);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            Modifier modifierThen2 = OffsetKt.offset(companion, (InterfaceC3750qp) objRememberedValue).then(modifierSemantics$default);
            Shape shape = this.$frontLayerShape;
            long j2 = this.$frontLayerBackgroundColor;
            long j3 = this.$frontLayerContentColor;
            float f3 = this.$frontLayerElevation;
            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, -1065299503, true, new AnonymousClass2(this.$peekHeight, this.$frontLayerContent, this.$$dirty, this.$frontLayerScrimColor, this.$scaffoldState, this.$$dirty1, this.$gesturesEnabled, this.$scope));
            int i3 = this.$$dirty1;
            SurfaceKt.m1227SurfaceFjzlyU(modifierThen2, shape, j2, j3, null, f3, composableLambda, composer, ((i3 >> 3) & 112) | 1572864 | ((i3 >> 6) & 896) | ((i3 >> 6) & 7168) | ((i3 << 6) & 458752), 16);
            Modifier modifierM489paddingqDBjuR0$default = PaddingKt.m489paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, (this.$scaffoldState.isRevealed() && f2 == fM5127getMaxHeightimpl - this.$headerHeightPx) ? this.$headerHeight : Dp.m5160constructorimpl(0), 7, null);
            Alignment bottomCenter = Alignment.Companion.getBottomCenter();
            InterfaceC0552Gp interfaceC0552Gp = this.$snackbarHost;
            BackdropScaffoldState backdropScaffoldState3 = this.$scaffoldState;
            int i4 = this.$$dirty1;
            composer.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(bottomCenter, false, composer, 6);
            composer.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
            InterfaceC3588op constructor = companion2.getConstructor();
            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifierM489paddingqDBjuR0$default);
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM2661constructorimpl = Updater.m2661constructorimpl(composer);
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            InterfaceC0526Fp setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (composerM2661constructorimpl.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            interfaceC0552GpModifierMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer)), composer, 0);
            composer.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            interfaceC0552Gp.invoke(backdropScaffoldState3.getSnackbarHostState(), composer, Integer.valueOf((i4 >> 18) & 112));
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
    public BackdropScaffoldKt$BackdropScaffold$1(Modifier modifier, InterfaceC0526Fp interfaceC0526Fp, InterfaceC3750qp interfaceC3750qp, float f, boolean z, boolean z2, BackdropScaffoldState backdropScaffoldState, float f2, int i, Shape shape, long j, long j2, float f3, int i2, float f4, float f5, InterfaceC0526Fp interfaceC0526Fp2, long j3, InterfaceC0552Gp interfaceC0552Gp) {
        super(2);
        this.$modifier = modifier;
        this.$backLayer = interfaceC0526Fp;
        this.$calculateBackLayerConstraints = interfaceC3750qp;
        this.$headerHeightPx = f;
        this.$stickyFrontLayer = z;
        this.$gesturesEnabled = z2;
        this.$scaffoldState = backdropScaffoldState;
        this.$peekHeightPx = f2;
        this.$$dirty = i;
        this.$frontLayerShape = shape;
        this.$frontLayerBackgroundColor = j;
        this.$frontLayerContentColor = j2;
        this.$frontLayerElevation = f3;
        this.$$dirty1 = i2;
        this.$headerHeight = f4;
        this.$peekHeight = f5;
        this.$frontLayerContent = interfaceC0526Fp2;
        this.$frontLayerScrimColor = j3;
        this.$snackbarHost = interfaceC0552Gp;
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
            ComposerKt.traceEventStart(-1049909631, i, -1, "androidx.compose.material.BackdropScaffold.<anonymous> (BackdropScaffold.kt:296)");
        }
        composer.startReplaceableGroup(773894976);
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composer));
            composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            objRememberedValue = compositionScopedCoroutineScopeCanceller;
        }
        composer.endReplaceableGroup();
        InterfaceC2052dg coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
        composer.endReplaceableGroup();
        BackdropScaffoldKt.BackdropStack(SizeKt.fillMaxSize$default(this.$modifier, 0.0f, 1, null), this.$backLayer, this.$calculateBackLayerConstraints, ComposableLambdaKt.composableLambda(composer, 1800047509, true, new AnonymousClass1(this.$headerHeightPx, this.$stickyFrontLayer, this.$gesturesEnabled, this.$scaffoldState, this.$peekHeightPx, this.$$dirty, this.$frontLayerShape, this.$frontLayerBackgroundColor, this.$frontLayerContentColor, this.$frontLayerElevation, this.$$dirty1, this.$headerHeight, coroutineScope, this.$peekHeight, this.$frontLayerContent, this.$frontLayerScrimColor, this.$snackbarHost)), composer, 3120);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
