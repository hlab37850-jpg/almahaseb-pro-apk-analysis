package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;
import defpackage.LJ;
import defpackage.MJ;

/* JADX INFO: loaded from: classes.dex */
public final class AppBarKt$TwoRowsTopAppBar$3 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ InterfaceC0526Fp $actionsRow;
    final /* synthetic */ float $bottomTitleAlpha;
    final /* synthetic */ TopAppBarColors $colors;
    final /* synthetic */ boolean $hideBottomRowSemantics;
    final /* synthetic */ boolean $hideTopRowSemantics;
    final /* synthetic */ LJ $maxHeightPx;
    final /* synthetic */ InterfaceC0526Fp $navigationIcon;
    final /* synthetic */ LJ $pinnedHeightPx;
    final /* synthetic */ TopAppBarScrollBehavior $scrollBehavior;
    final /* synthetic */ InterfaceC0526Fp $smallTitle;
    final /* synthetic */ TextStyle $smallTitleTextStyle;
    final /* synthetic */ InterfaceC0526Fp $title;
    final /* synthetic */ MJ $titleBottomPaddingPx;
    final /* synthetic */ TextStyle $titleTextStyle;
    final /* synthetic */ float $topTitleAlpha;
    final /* synthetic */ WindowInsets $windowInsets;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppBarKt$TwoRowsTopAppBar$3(WindowInsets windowInsets, LJ lj, TopAppBarColors topAppBarColors, InterfaceC0526Fp interfaceC0526Fp, TextStyle textStyle, float f, boolean z, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, int i, LJ lj2, TopAppBarScrollBehavior topAppBarScrollBehavior, InterfaceC0526Fp interfaceC0526Fp4, TextStyle textStyle2, float f2, MJ mj, boolean z2) {
        super(2);
        this.$windowInsets = windowInsets;
        this.$pinnedHeightPx = lj;
        this.$colors = topAppBarColors;
        this.$smallTitle = interfaceC0526Fp;
        this.$smallTitleTextStyle = textStyle;
        this.$topTitleAlpha = f;
        this.$hideTopRowSemantics = z;
        this.$navigationIcon = interfaceC0526Fp2;
        this.$actionsRow = interfaceC0526Fp3;
        this.$$dirty = i;
        this.$maxHeightPx = lj2;
        this.$scrollBehavior = topAppBarScrollBehavior;
        this.$title = interfaceC0526Fp4;
        this.$titleTextStyle = textStyle2;
        this.$bottomTitleAlpha = f2;
        this.$titleBottomPaddingPx = mj;
        this.$hideBottomRowSemantics = z2;
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
        TopAppBarState state;
        if ((i & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1985938853, i, -1, "androidx.compose.material3.TwoRowsTopAppBar.<anonymous> (AppBar.kt:1203)");
        }
        WindowInsets windowInsets = this.$windowInsets;
        LJ lj = this.$pinnedHeightPx;
        TopAppBarColors topAppBarColors = this.$colors;
        InterfaceC0526Fp interfaceC0526Fp = this.$smallTitle;
        TextStyle textStyle = this.$smallTitleTextStyle;
        float f = this.$topTitleAlpha;
        boolean z = this.$hideTopRowSemantics;
        InterfaceC0526Fp interfaceC0526Fp2 = this.$navigationIcon;
        InterfaceC0526Fp interfaceC0526Fp3 = this.$actionsRow;
        int i2 = this.$$dirty;
        LJ lj2 = this.$maxHeightPx;
        TopAppBarScrollBehavior topAppBarScrollBehavior = this.$scrollBehavior;
        InterfaceC0526Fp interfaceC0526Fp4 = this.$title;
        TextStyle textStyle2 = this.$titleTextStyle;
        float f2 = this.$bottomTitleAlpha;
        MJ mj = this.$titleBottomPaddingPx;
        boolean z2 = this.$hideBottomRowSemantics;
        composer.startReplaceableGroup(-483455358);
        Modifier.Companion companion = Modifier.Companion;
        Arrangement arrangement = Arrangement.INSTANCE;
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), Alignment.Companion.getStart(), composer, 0);
        composer.startReplaceableGroup(-1323940314);
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
        InterfaceC3588op constructor = companion2.getConstructor();
        InterfaceC0552Gp interfaceC0552GpMaterializerOf = LayoutKt.materializerOf(companion);
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
        Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
        Updater.m2668setimpl(composerM2661constructorimpl, density, companion2.getSetDensity());
        Updater.m2668setimpl(composerM2661constructorimpl, layoutDirection, companion2.getSetLayoutDirection());
        Updater.m2668setimpl(composerM2661constructorimpl, viewConfiguration, companion2.getSetViewConfiguration());
        composer.enableReusing();
        interfaceC0552GpMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer)), composer, 0);
        composer.startReplaceableGroup(2058660585);
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        int i3 = i2 << 3;
        AppBarKt.m1331TopAppBarLayoutkXwM9vE(ClipKt.clipToBounds(WindowInsetsPaddingKt.windowInsetsPadding(companion, windowInsets)), lj.a, topAppBarColors.m2056getNavigationIconContentColor0d7_KjU$material3_release(), topAppBarColors.m2057getTitleContentColor0d7_KjU$material3_release(), topAppBarColors.m2055getActionIconContentColor0d7_KjU$material3_release(), interfaceC0526Fp, textStyle, f, arrangement.getCenter(), arrangement.getStart(), 0, z, interfaceC0526Fp2, interfaceC0526Fp3, composer, (i3 & 458752) | 905969664 | (i3 & 3670016), ((i2 >> 12) & 896) | 3078);
        Modifier modifierClipToBounds = ClipKt.clipToBounds(WindowInsetsPaddingKt.windowInsetsPadding(companion, WindowInsetsKt.m558onlybOOhFvg(windowInsets, WindowInsetsSides.Companion.m578getHorizontalJoeWqyM())));
        float heightOffset = ((topAppBarScrollBehavior == null || (state = topAppBarScrollBehavior.getState()) == null) ? 0.0f : state.getHeightOffset()) + (lj2.a - lj.a);
        long jM2056getNavigationIconContentColor0d7_KjU$material3_release = topAppBarColors.m2056getNavigationIconContentColor0d7_KjU$material3_release();
        long jM2057getTitleContentColor0d7_KjU$material3_release = topAppBarColors.m2057getTitleContentColor0d7_KjU$material3_release();
        long jM2055getActionIconContentColor0d7_KjU$material3_release = topAppBarColors.m2055getActionIconContentColor0d7_KjU$material3_release();
        Arrangement.Vertical bottom = arrangement.getBottom();
        Arrangement.Horizontal start = arrangement.getStart();
        int i4 = mj.a;
        ComposableSingletons$AppBarKt composableSingletons$AppBarKt = ComposableSingletons$AppBarKt.INSTANCE;
        InterfaceC0526Fp interfaceC0526FpM1457getLambda11$material3_release = composableSingletons$AppBarKt.m1457getLambda11$material3_release();
        InterfaceC0526Fp interfaceC0526FpM1458getLambda12$material3_release = composableSingletons$AppBarKt.m1458getLambda12$material3_release();
        int i5 = i2 << 12;
        AppBarKt.m1331TopAppBarLayoutkXwM9vE(modifierClipToBounds, heightOffset, jM2056getNavigationIconContentColor0d7_KjU$material3_release, jM2057getTitleContentColor0d7_KjU$material3_release, jM2055getActionIconContentColor0d7_KjU$material3_release, interfaceC0526Fp4, textStyle2, f2, bottom, start, i4, z2, interfaceC0526FpM1457getLambda11$material3_release, interfaceC0526FpM1458getLambda12$material3_release, composer, (i5 & 458752) | 905969664 | (i5 & 3670016), 3456);
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
