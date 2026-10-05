package androidx.compose.material;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class BackdropScaffoldKt$BackdropScaffold$backLayer$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ InterfaceC0526Fp $appBar;
    final /* synthetic */ InterfaceC0526Fp $backLayerContent;
    final /* synthetic */ boolean $persistentAppBar;
    final /* synthetic */ BackdropScaffoldState $scaffoldState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackdropScaffoldKt$BackdropScaffold$backLayer$1(boolean z, BackdropScaffoldState backdropScaffoldState, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, int i) {
        super(2);
        this.$persistentAppBar = z;
        this.$scaffoldState = backdropScaffoldState;
        this.$appBar = interfaceC0526Fp;
        this.$backLayerContent = interfaceC0526Fp2;
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
            ComposerKt.traceEventStart(1744778315, i, -1, "androidx.compose.material.BackdropScaffold.<anonymous> (BackdropScaffold.kt:278)");
        }
        if (this.$persistentAppBar) {
            composer.startReplaceableGroup(-1017265331);
            InterfaceC0526Fp interfaceC0526Fp = this.$appBar;
            int i2 = this.$$dirty;
            InterfaceC0526Fp interfaceC0526Fp2 = this.$backLayerContent;
            composer.startReplaceableGroup(-483455358);
            Modifier.Companion companion = Modifier.Companion;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer, 0);
            composer.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
            InterfaceC3588op constructor = companion2.getConstructor();
            InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
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
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            InterfaceC0526Fp setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (composerM2661constructorimpl.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            interfaceC0552GpModifierMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer)), composer, 0);
            composer.startReplaceableGroup(2058660585);
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            interfaceC0526Fp.mo13invoke(composer, Integer.valueOf(i2 & 14));
            interfaceC0526Fp2.mo13invoke(composer, Integer.valueOf((i2 >> 3) & 14));
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-1017265219);
            BackdropValue targetValue = this.$scaffoldState.getTargetValue();
            InterfaceC0526Fp interfaceC0526Fp3 = this.$appBar;
            InterfaceC0526Fp interfaceC0526Fp4 = this.$backLayerContent;
            int i3 = this.$$dirty;
            BackdropScaffoldKt.BackLayerTransition(targetValue, interfaceC0526Fp3, interfaceC0526Fp4, composer, ((i3 << 3) & 896) | ((i3 << 3) & 112));
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
