package androidx.compose.material;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
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
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
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
public final class DrawerKt$ModalDrawer$1 extends AbstractC2233fv implements InterfaceC0552Gp {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ InterfaceC0526Fp $content;
    final /* synthetic */ long $drawerBackgroundColor;
    final /* synthetic */ InterfaceC0552Gp $drawerContent;
    final /* synthetic */ long $drawerContentColor;
    final /* synthetic */ float $drawerElevation;
    final /* synthetic */ Shape $drawerShape;
    final /* synthetic */ DrawerState $drawerState;
    final /* synthetic */ boolean $gesturesEnabled;
    final /* synthetic */ InterfaceC2052dg $scope;
    final /* synthetic */ long $scrimColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawerKt$ModalDrawer$1(DrawerState drawerState, boolean z, int i, long j, Shape shape, long j2, long j3, float f, InterfaceC0526Fp interfaceC0526Fp, InterfaceC2052dg interfaceC2052dg, InterfaceC0552Gp interfaceC0552Gp) {
        super(3);
        this.$drawerState = drawerState;
        this.$gesturesEnabled = z;
        this.$$dirty = i;
        this.$scrimColor = j;
        this.$drawerShape = shape;
        this.$drawerBackgroundColor = j2;
        this.$drawerContentColor = j3;
        this.$drawerElevation = f;
        this.$content = interfaceC0526Fp;
        this.$scope = interfaceC2052dg;
        this.$drawerContent = interfaceC0552Gp;
    }

    @Override // defpackage.InterfaceC0552Gp
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return FW.a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, int i) {
        AbstractC4492zt.h(boxWithConstraintsScope, "$this$BoxWithConstraints");
        if ((((i & 14) == 0 ? (composer.changed(boxWithConstraintsScope) ? 4 : 2) | i : i) & 91) == 18 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(816674999, i, -1, "androidx.compose.material.ModalDrawer.<anonymous> (Drawer.kt:522)");
        }
        long jMo423getConstraintsmsEJaDk = boxWithConstraintsScope.mo423getConstraintsmsEJaDk();
        if (!Constraints.m5124getHasBoundedWidthimpl(jMo423getConstraintsmsEJaDk)) {
            throw new IllegalStateException("Drawer shouldn't have infinite width");
        }
        float f = -Constraints.m5128getMaxWidthimpl(jMo423getConstraintsmsEJaDk);
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        Object[] objArr = {this.$drawerState, density, Float.valueOf(f), Float.valueOf(0.0f)};
        DrawerState drawerState = this.$drawerState;
        composer.startReplaceableGroup(-568225417);
        boolean zChanged = false;
        for (int i2 = 0; i2 < 4; i2++) {
            zChanged |= composer.changed(objArr[i2]);
        }
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new DrawerKt$ModalDrawer$1$1$1(drawerState, density, f, 0.0f);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        EffectsKt.SideEffect((InterfaceC3588op) objRememberedValue, composer, 0);
        boolean z = composer.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl;
        Modifier.Companion companion = Modifier.Companion;
        Modifier modifierAnchoredDraggable$default = AnchoredDraggableKt.anchoredDraggable$default(companion, this.$drawerState.getAnchoredDraggableState$material_release(), Orientation.Horizontal, this.$gesturesEnabled, z, null, 16, null);
        DrawerState drawerState2 = this.$drawerState;
        int i3 = this.$$dirty;
        long j = this.$scrimColor;
        Shape shape = this.$drawerShape;
        long j2 = this.$drawerBackgroundColor;
        long j3 = this.$drawerContentColor;
        float f2 = this.$drawerElevation;
        InterfaceC0526Fp interfaceC0526Fp = this.$content;
        boolean z2 = this.$gesturesEnabled;
        InterfaceC2052dg interfaceC2052dg = this.$scope;
        InterfaceC0552Gp interfaceC0552Gp = this.$drawerContent;
        composer.startReplaceableGroup(733328855);
        Alignment.Companion companion2 = Alignment.Companion;
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composer, 0);
        composer.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
        InterfaceC3588op constructor = companion3.getConstructor();
        InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifierAnchoredDraggable$default);
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
        Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion3.getSetMeasurePolicy());
        Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
        InterfaceC0526Fp setCompositeKeyHash = companion3.getSetCompositeKeyHash();
        if (composerM2661constructorimpl.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        interfaceC0552GpModifierMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer)), composer, 0);
        composer.startReplaceableGroup(2058660585);
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        composer.startReplaceableGroup(733328855);
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composer, 0);
        composer.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
        InterfaceC3588op constructor2 = companion3.getConstructor();
        InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion);
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor2);
        } else {
            composer.useNode();
        }
        Composer composerM2661constructorimpl2 = Updater.m2661constructorimpl(composer);
        Updater.m2668setimpl(composerM2661constructorimpl2, measurePolicyRememberBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
        Updater.m2668setimpl(composerM2661constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
        InterfaceC0526Fp setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
        if (composerM2661constructorimpl2.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
            composerM2661constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            composerM2661constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
        }
        interfaceC0552GpModifierMaterializerOf2.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer)), composer, 0);
        composer.startReplaceableGroup(2058660585);
        interfaceC0526Fp.mo13invoke(composer, Integer.valueOf((i3 >> 27) & 14));
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        boolean zIsOpen = drawerState2.isOpen();
        DrawerKt$ModalDrawer$1$2$2 drawerKt$ModalDrawer$1$2$2 = new DrawerKt$ModalDrawer$1$2$2(z2, drawerState2, interfaceC2052dg);
        Object objValueOf = Float.valueOf(f);
        Object objValueOf2 = Float.valueOf(0.0f);
        composer.startReplaceableGroup(1618982084);
        boolean zChanged2 = composer.changed(objValueOf) | composer.changed(objValueOf2) | composer.changed(drawerState2);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
            objRememberedValue2 = new DrawerKt$ModalDrawer$1$2$3$1(f, 0.0f, drawerState2);
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceableGroup();
        DrawerKt.m1095ScrimBx497Mc(zIsOpen, drawerKt$ModalDrawer$1$2$2, (InterfaceC3588op) objRememberedValue2, j, composer, (i3 >> 15) & 7168);
        String strM1225getString4foXLRw = Strings_androidKt.m1225getString4foXLRw(Strings.Companion.m1222getNavigationMenuUdPEhr4(), composer, 6);
        Density density2 = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        Modifier modifierM535sizeInqDBjuR0 = SizeKt.m535sizeInqDBjuR0(companion, density2.mo330toDpu2uoSUM(Constraints.m5130getMinWidthimpl(jMo423getConstraintsmsEJaDk)), density2.mo330toDpu2uoSUM(Constraints.m5129getMinHeightimpl(jMo423getConstraintsmsEJaDk)), density2.mo330toDpu2uoSUM(Constraints.m5128getMaxWidthimpl(jMo423getConstraintsmsEJaDk)), density2.mo330toDpu2uoSUM(Constraints.m5127getMaxHeightimpl(jMo423getConstraintsmsEJaDk)));
        composer.startReplaceableGroup(1157296644);
        boolean zChanged3 = composer.changed(drawerState2);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChanged3 || objRememberedValue3 == Composer.Companion.getEmpty()) {
            objRememberedValue3 = new DrawerKt$ModalDrawer$1$2$5$1(drawerState2);
            composer.updateRememberedValue(objRememberedValue3);
        }
        composer.endReplaceableGroup();
        int i4 = i3 >> 12;
        SurfaceKt.m1227SurfaceFjzlyU(SemanticsModifierKt.semantics$default(PaddingKt.m489paddingqDBjuR0$default(OffsetKt.offset(modifierM535sizeInqDBjuR0, (InterfaceC3750qp) objRememberedValue3), 0.0f, 0.0f, DrawerKt.EndDrawerPadding, 0.0f, 11, null), false, new DrawerKt$ModalDrawer$1$2$6(strM1225getString4foXLRw, drawerState2, interfaceC2052dg), 1, null), shape, j2, j3, null, f2, ComposableLambdaKt.composableLambda(composer, -1941234439, true, new DrawerKt$ModalDrawer$1$2$7(interfaceC0552Gp, i3)), composer, ((i3 >> 9) & 112) | 1572864 | (i4 & 896) | (i4 & 7168) | (458752 & i3), 16);
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
