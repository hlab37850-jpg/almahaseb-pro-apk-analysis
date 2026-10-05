package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SearchBarKt$SearchBar$4 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ boolean $active;
    final /* synthetic */ State<Float> $animationProgress;
    final /* synthetic */ SearchBarColors $colors;
    final /* synthetic */ InterfaceC0552Gp $content;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ InterfaceC0526Fp $leadingIcon;
    final /* synthetic */ InterfaceC3750qp $onActiveChange;
    final /* synthetic */ InterfaceC3750qp $onQueryChange;
    final /* synthetic */ InterfaceC3750qp $onSearch;
    final /* synthetic */ InterfaceC0526Fp $placeholder;
    final /* synthetic */ String $query;
    final /* synthetic */ State<Dp> $topPadding;
    final /* synthetic */ InterfaceC0526Fp $trailingIcon;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchBarKt$SearchBar$4(String str, InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2, boolean z, InterfaceC3750qp interfaceC3750qp3, boolean z2, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, SearchBarColors searchBarColors, MutableInteractionSource mutableInteractionSource, int i, int i2, State<Float> state, State<Dp> state2, InterfaceC0552Gp interfaceC0552Gp) {
        super(2);
        this.$query = str;
        this.$onQueryChange = interfaceC3750qp;
        this.$onSearch = interfaceC3750qp2;
        this.$active = z;
        this.$onActiveChange = interfaceC3750qp3;
        this.$enabled = z2;
        this.$placeholder = interfaceC0526Fp;
        this.$leadingIcon = interfaceC0526Fp2;
        this.$trailingIcon = interfaceC0526Fp3;
        this.$colors = searchBarColors;
        this.$interactionSource = mutableInteractionSource;
        this.$$dirty = i;
        this.$$dirty1 = i2;
        this.$animationProgress = state;
        this.$topPadding = state2;
        this.$content = interfaceC0552Gp;
    }

    private static final boolean invoke$lambda$5$lambda$2(State<Boolean> state) {
        return state.getValue().booleanValue();
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
        State<Float> state;
        if ((i & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-867266817, i, -1, "androidx.compose.material3.SearchBar.<anonymous> (SearchBar.kt:250)");
        }
        String str = this.$query;
        InterfaceC3750qp interfaceC3750qp = this.$onQueryChange;
        InterfaceC3750qp interfaceC3750qp2 = this.$onSearch;
        boolean z = this.$active;
        InterfaceC3750qp interfaceC3750qp3 = this.$onActiveChange;
        boolean z2 = this.$enabled;
        InterfaceC0526Fp interfaceC0526Fp = this.$placeholder;
        InterfaceC0526Fp interfaceC0526Fp2 = this.$leadingIcon;
        InterfaceC0526Fp interfaceC0526Fp3 = this.$trailingIcon;
        SearchBarColors searchBarColors = this.$colors;
        MutableInteractionSource mutableInteractionSource = this.$interactionSource;
        int i2 = this.$$dirty;
        int i3 = this.$$dirty1;
        State<Float> state2 = this.$animationProgress;
        State<Dp> state3 = this.$topPadding;
        InterfaceC0552Gp interfaceC0552Gp = this.$content;
        composer.startReplaceableGroup(-483455358);
        Modifier.Companion companion = Modifier.Companion;
        Arrangement arrangement = Arrangement.INSTANCE;
        Arrangement.Vertical top = arrangement.getTop();
        Alignment.Companion companion2 = Alignment.Companion;
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composer, 0);
        composer.startReplaceableGroup(-1323940314);
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
        InterfaceC3588op constructor = companion3.getConstructor();
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
        Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
        Updater.m2668setimpl(composerM2661constructorimpl, density, companion3.getSetDensity());
        Updater.m2668setimpl(composerM2661constructorimpl, layoutDirection, companion3.getSetLayoutDirection());
        Updater.m2668setimpl(composerM2661constructorimpl, viewConfiguration, companion3.getSetViewConfiguration());
        composer.enableReusing();
        interfaceC0552GpMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer)), composer, 0);
        composer.startReplaceableGroup(2058660585);
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        Composer.Companion companion4 = Composer.Companion;
        if (objRememberedValue == companion4.getEmpty()) {
            objRememberedValue = new AnimatedPaddingValues(state2, state3);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        SearchBarKt.SearchBarInputField(str, interfaceC3750qp, interfaceC3750qp2, z, interfaceC3750qp3, PaddingKt.padding(companion, (AnimatedPaddingValues) objRememberedValue), z2, interfaceC0526Fp, interfaceC0526Fp2, interfaceC0526Fp3, searchBarColors.getInputFieldColors(), mutableInteractionSource, composer, (i2 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i2 & 112) | (i2 & 896) | (i2 & 7168) | (57344 & i2) | (3670016 & i2) | (29360128 & i2) | (234881024 & i2) | (1879048192 & i2), (i3 >> 9) & 112, 0);
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == companion4.getEmpty()) {
            state = state2;
            objRememberedValue2 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new SearchBarKt$SearchBar$4$1$showResults$2$1(state));
            composer.updateRememberedValue(objRememberedValue2);
        } else {
            state = state2;
        }
        composer.endReplaceableGroup();
        composer.startReplaceableGroup(551421060);
        if (invoke$lambda$5$lambda$2((State) objRememberedValue2)) {
            composer.startReplaceableGroup(1157296644);
            boolean zChanged = composer.changed(state);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChanged || objRememberedValue3 == companion4.getEmpty()) {
                objRememberedValue3 = new SearchBarKt$SearchBar$4$1$1$1(state);
                composer.updateRememberedValue(objRememberedValue3);
            }
            composer.endReplaceableGroup();
            Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(companion, (InterfaceC3750qp) objRememberedValue3);
            composer.startReplaceableGroup(-483455358);
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), composer, 0);
            composer.startReplaceableGroup(-1323940314);
            Density density2 = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            InterfaceC3588op constructor2 = companion3.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf2 = LayoutKt.materializerOf(modifierGraphicsLayer);
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
            Updater.m2668setimpl(composerM2661constructorimpl2, measurePolicyColumnMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl2, density2, companion3.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl2, layoutDirection2, companion3.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl2, viewConfiguration2, companion3.getSetViewConfiguration());
            composer.enableReusing();
            interfaceC0552GpMaterializerOf2.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer)), composer, 0);
            composer.startReplaceableGroup(2058660585);
            DividerKt.m1539Divider9IZ8Weo(null, 0.0f, searchBarColors.m1730getDividerColor0d7_KjU(), composer, 0, 3);
            interfaceC0552Gp.invoke(columnScopeInstance, composer, Integer.valueOf(((i3 >> 12) & 112) | 6));
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
        }
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
