package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
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

/* JADX INFO: loaded from: classes.dex */
public final class ChipKt$ChipContent$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ InterfaceC0526Fp $avatar;
    final /* synthetic */ InterfaceC0526Fp $label;
    final /* synthetic */ InterfaceC0526Fp $leadingIcon;
    final /* synthetic */ long $leadingIconColor;
    final /* synthetic */ float $minHeight;
    final /* synthetic */ PaddingValues $paddingValues;
    final /* synthetic */ InterfaceC0526Fp $trailingIcon;
    final /* synthetic */ long $trailingIconColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChipKt$ChipContent$1(float f, PaddingValues paddingValues, InterfaceC0526Fp interfaceC0526Fp, int i, InterfaceC0526Fp interfaceC0526Fp2, long j, InterfaceC0526Fp interfaceC0526Fp3, InterfaceC0526Fp interfaceC0526Fp4, long j2) {
        super(2);
        this.$minHeight = f;
        this.$paddingValues = paddingValues;
        this.$avatar = interfaceC0526Fp;
        this.$$dirty = i;
        this.$leadingIcon = interfaceC0526Fp2;
        this.$leadingIconColor = j;
        this.$label = interfaceC0526Fp3;
        this.$trailingIcon = interfaceC0526Fp4;
        this.$trailingIconColor = j2;
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
            ComposerKt.traceEventStart(1748799148, i, -1, "androidx.compose.material3.ChipContent.<anonymous> (Chip.kt:1410)");
        }
        Modifier.Companion companion = Modifier.Companion;
        Modifier modifierPadding = PaddingKt.padding(SizeKt.m517defaultMinSizeVpY3zN4$default(companion, 0.0f, this.$minHeight, 1, null), this.$paddingValues);
        Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
        Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
        InterfaceC0526Fp interfaceC0526Fp = this.$avatar;
        int i2 = this.$$dirty;
        InterfaceC0526Fp interfaceC0526Fp2 = this.$leadingIcon;
        long j = this.$leadingIconColor;
        InterfaceC0526Fp interfaceC0526Fp3 = this.$label;
        InterfaceC0526Fp interfaceC0526Fp4 = this.$trailingIcon;
        long j2 = this.$trailingIconColor;
        composer.startReplaceableGroup(693286680);
        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer, 54);
        composer.startReplaceableGroup(-1323940314);
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
        InterfaceC3588op constructor = companion2.getConstructor();
        InterfaceC0552Gp interfaceC0552GpMaterializerOf = LayoutKt.materializerOf(modifierPadding);
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
        Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy, companion2.getSetMeasurePolicy());
        Updater.m2668setimpl(composerM2661constructorimpl, density, companion2.getSetDensity());
        Updater.m2668setimpl(composerM2661constructorimpl, layoutDirection, companion2.getSetLayoutDirection());
        Updater.m2668setimpl(composerM2661constructorimpl, viewConfiguration, companion2.getSetViewConfiguration());
        composer.enableReusing();
        interfaceC0552GpMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer)), composer, 0);
        composer.startReplaceableGroup(2058660585);
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        if (interfaceC0526Fp != null) {
            composer.startReplaceableGroup(650988036);
            interfaceC0526Fp.mo13invoke(composer, Integer.valueOf((i2 >> 12) & 14));
            composer.endReplaceableGroup();
        } else if (interfaceC0526Fp2 != null) {
            composer.startReplaceableGroup(650988107);
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j))}, interfaceC0526Fp2, composer, ((i2 >> 6) & 112) | 8);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(650988269);
            composer.endReplaceableGroup();
        }
        SpacerKt.Spacer(SizeKt.m537width3ABfNKs(companion, ChipKt.HorizontalElementsPadding), composer, 6);
        interfaceC0526Fp3.mo13invoke(composer, Integer.valueOf(i2 & 14));
        SpacerKt.Spacer(SizeKt.m537width3ABfNKs(companion, ChipKt.HorizontalElementsPadding), composer, 6);
        composer.startReplaceableGroup(-313068567);
        if (interfaceC0526Fp4 != null) {
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j2))}, interfaceC0526Fp4, composer, ((i2 >> 12) & 112) | 8);
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
