package androidx.compose.material3;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SearchBarKt$DockedSearchBar$2 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ boolean $active;
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
    final /* synthetic */ InterfaceC0526Fp $trailingIcon;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchBarKt$DockedSearchBar$2(String str, InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2, boolean z, InterfaceC3750qp interfaceC3750qp3, boolean z2, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, SearchBarColors searchBarColors, MutableInteractionSource mutableInteractionSource, int i, int i2, InterfaceC0552Gp interfaceC0552Gp) {
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
        this.$content = interfaceC0552Gp;
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
            ComposerKt.traceEventStart(-1764436203, i, -1, "androidx.compose.material3.DockedSearchBar.<anonymous> (SearchBar.kt:369)");
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
        InterfaceC0552Gp interfaceC0552Gp = this.$content;
        composer.startReplaceableGroup(-483455358);
        Modifier.Companion companion = Modifier.Companion;
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer, 0);
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
        SearchBarKt.SearchBarInputField(str, interfaceC3750qp, interfaceC3750qp2, z, interfaceC3750qp3, null, z2, interfaceC0526Fp, interfaceC0526Fp2, interfaceC0526Fp3, searchBarColors.getInputFieldColors(), mutableInteractionSource, composer, i2 & 2147024894, (i3 >> 6) & 112, 32);
        AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance, z, (Modifier) null, SearchBarKt.DockedEnterTransition, SearchBarKt.DockedExitTransition, (String) null, ComposableLambdaKt.composableLambda(composer, 393964167, true, new SearchBarKt$DockedSearchBar$2$1$1(searchBarColors, interfaceC0552Gp, i3)), composer, 1600518 | ((i2 >> 6) & 112), 18);
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
