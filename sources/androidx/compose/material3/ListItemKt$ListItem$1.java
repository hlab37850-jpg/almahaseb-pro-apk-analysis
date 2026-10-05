package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
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
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3955tM;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class ListItemKt$ListItem$1 extends AbstractC2233fv implements InterfaceC0552Gp {
    final /* synthetic */ Alignment.Vertical $boxAlignment;
    final /* synthetic */ Arrangement.Vertical $columnArrangement;
    final /* synthetic */ PaddingValues $contentPaddingValues;
    final /* synthetic */ InterfaceC0526Fp $decoratedHeadlineContent;
    final /* synthetic */ InterfaceC0552Gp $decoratedLeadingContent;
    final /* synthetic */ InterfaceC0526Fp $decoratedOverlineContent;
    final /* synthetic */ InterfaceC0526Fp $decoratedSupportingContent;
    final /* synthetic */ InterfaceC0552Gp $decoratedTrailingContent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListItemKt$ListItem$1(InterfaceC0552Gp interfaceC0552Gp, PaddingValues paddingValues, Alignment.Vertical vertical, Arrangement.Vertical vertical2, InterfaceC0552Gp interfaceC0552Gp2, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3) {
        super(3);
        this.$decoratedLeadingContent = interfaceC0552Gp;
        this.$contentPaddingValues = paddingValues;
        this.$boxAlignment = vertical;
        this.$columnArrangement = vertical2;
        this.$decoratedTrailingContent = interfaceC0552Gp2;
        this.$decoratedOverlineContent = interfaceC0526Fp;
        this.$decoratedHeadlineContent = interfaceC0526Fp2;
        this.$decoratedSupportingContent = interfaceC0526Fp3;
    }

    @Override // defpackage.InterfaceC0552Gp
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((RowScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return FW.a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(RowScope rowScope, Composer composer, int i) {
        AbstractC4492zt.h(rowScope, "$this$ListItem");
        if ((i & 14) == 0) {
            i |= composer.changed(rowScope) ? 4 : 2;
        }
        if ((i & 91) == 18 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1813277157, i, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:161)");
        }
        composer.startReplaceableGroup(1316674963);
        InterfaceC0552Gp interfaceC0552Gp = this.$decoratedLeadingContent;
        if (interfaceC0552Gp != null) {
            interfaceC0552Gp.invoke(rowScope, composer, Integer.valueOf(i & 14));
        }
        composer.endReplaceableGroup();
        Modifier modifierAlign = rowScope.align(PaddingKt.padding(AbstractC3955tM.a(rowScope, Modifier.Companion, 1.0f, false, 2, null), this.$contentPaddingValues), this.$boxAlignment);
        Arrangement.Vertical vertical = this.$columnArrangement;
        InterfaceC0526Fp interfaceC0526Fp = this.$decoratedOverlineContent;
        InterfaceC0526Fp interfaceC0526Fp2 = this.$decoratedHeadlineContent;
        InterfaceC0526Fp interfaceC0526Fp3 = this.$decoratedSupportingContent;
        composer.startReplaceableGroup(-483455358);
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(vertical, Alignment.Companion.getStart(), composer, 0);
        composer.startReplaceableGroup(-1323940314);
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
        InterfaceC3588op constructor = companion.getConstructor();
        InterfaceC0552Gp interfaceC0552GpMaterializerOf = LayoutKt.materializerOf(modifierAlign);
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
        Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyColumnMeasurePolicy, companion.getSetMeasurePolicy());
        Updater.m2668setimpl(composerM2661constructorimpl, density, companion.getSetDensity());
        Updater.m2668setimpl(composerM2661constructorimpl, layoutDirection, companion.getSetLayoutDirection());
        Updater.m2668setimpl(composerM2661constructorimpl, viewConfiguration, companion.getSetViewConfiguration());
        composer.enableReusing();
        interfaceC0552GpMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer)), composer, 0);
        composer.startReplaceableGroup(2058660585);
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        composer.startReplaceableGroup(984343928);
        if (interfaceC0526Fp != null) {
            interfaceC0526Fp.mo13invoke(composer, 0);
        }
        composer.endReplaceableGroup();
        interfaceC0526Fp2.mo13invoke(composer, 6);
        composer.startReplaceableGroup(1316675435);
        if (interfaceC0526Fp3 != null) {
            interfaceC0526Fp3.mo13invoke(composer, 0);
        }
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        InterfaceC0552Gp interfaceC0552Gp2 = this.$decoratedTrailingContent;
        if (interfaceC0552Gp2 != null) {
            interfaceC0552Gp2.invoke(rowScope, composer, Integer.valueOf(i & 14));
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
