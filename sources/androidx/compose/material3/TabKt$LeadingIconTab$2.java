package androidx.compose.material3;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material3.tokens.PrimaryNavigationTabTokens;
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
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class TabKt$LeadingIconTab$2 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ InterfaceC0526Fp $icon;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ InterfaceC3588op $onClick;
    final /* synthetic */ Indication $ripple;
    final /* synthetic */ boolean $selected;
    final /* synthetic */ InterfaceC0526Fp $text;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabKt$LeadingIconTab$2(Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z2, InterfaceC3588op interfaceC3588op, InterfaceC0526Fp interfaceC0526Fp, int i, InterfaceC0526Fp interfaceC0526Fp2) {
        super(2);
        this.$modifier = modifier;
        this.$selected = z;
        this.$interactionSource = mutableInteractionSource;
        this.$ripple = indication;
        this.$enabled = z2;
        this.$onClick = interfaceC3588op;
        this.$icon = interfaceC0526Fp;
        this.$$dirty = i;
        this.$text = interfaceC0526Fp2;
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
            ComposerKt.traceEventStart(-429037564, i, -1, "androidx.compose.material3.LeadingIconTab.<anonymous> (Tab.kt:170)");
        }
        Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m487paddingVpY3zN4$default(SelectableKt.m707selectableO2vRcR0(SizeKt.m518height3ABfNKs(this.$modifier, TabKt.SmallTabHeight), this.$selected, this.$interactionSource, this.$ripple, this.$enabled, Role.m4543boximpl(Role.Companion.m4556getTabo7Vup1c()), this.$onClick), TabKt.HorizontalTextPadding, 0.0f, 2, null), 0.0f, 1, null);
        Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
        Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
        InterfaceC0526Fp interfaceC0526Fp = this.$icon;
        int i2 = this.$$dirty;
        InterfaceC0526Fp interfaceC0526Fp2 = this.$text;
        composer.startReplaceableGroup(693286680);
        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer, 54);
        composer.startReplaceableGroup(-1323940314);
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
        InterfaceC3588op constructor = companion.getConstructor();
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
        Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy, companion.getSetMeasurePolicy());
        Updater.m2668setimpl(composerM2661constructorimpl, density, companion.getSetDensity());
        Updater.m2668setimpl(composerM2661constructorimpl, layoutDirection, companion.getSetLayoutDirection());
        Updater.m2668setimpl(composerM2661constructorimpl, viewConfiguration, companion.getSetViewConfiguration());
        composer.enableReusing();
        interfaceC0552GpMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer)), composer, 0);
        composer.startReplaceableGroup(2058660585);
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        interfaceC0526Fp.mo13invoke(composer, Integer.valueOf((i2 >> 9) & 14));
        SpacerKt.Spacer(SizeKt.m529requiredWidth3ABfNKs(Modifier.Companion, TabKt.TextDistanceFromLeadingIcon), composer, 6);
        TextStyle textStyleFromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer, 6), PrimaryNavigationTabTokens.INSTANCE.getLabelTextFont());
        TextKt.ProvideTextStyle(textStyleFromToken.m4719copyCXVQc50((4128601 & 1) != 0 ? textStyleFromToken.spanStyle.m4664getColor0d7_KjU() : 0L, (4128601 & 2) != 0 ? textStyleFromToken.spanStyle.m4665getFontSizeXSAIIZE() : 0L, (4128601 & 4) != 0 ? textStyleFromToken.spanStyle.getFontWeight() : null, (4128601 & 8) != 0 ? textStyleFromToken.spanStyle.m4666getFontStyle4Lr2A7w() : null, (4128601 & 16) != 0 ? textStyleFromToken.spanStyle.m4667getFontSynthesisZQGJjVo() : null, (4128601 & 32) != 0 ? textStyleFromToken.spanStyle.getFontFamily() : null, (4128601 & 64) != 0 ? textStyleFromToken.spanStyle.getFontFeatureSettings() : null, (4128601 & 128) != 0 ? textStyleFromToken.spanStyle.m4668getLetterSpacingXSAIIZE() : 0L, (4128601 & 256) != 0 ? textStyleFromToken.spanStyle.m4663getBaselineShift5SSeXJ0() : null, (4128601 & 512) != 0 ? textStyleFromToken.spanStyle.getTextGeometricTransform() : null, (4128601 & 1024) != 0 ? textStyleFromToken.spanStyle.getLocaleList() : null, (4128601 & 2048) != 0 ? textStyleFromToken.spanStyle.m4662getBackground0d7_KjU() : 0L, (4128601 & 4096) != 0 ? textStyleFromToken.spanStyle.getTextDecoration() : null, (4128601 & 8192) != 0 ? textStyleFromToken.spanStyle.getShadow() : null, (4128601 & 16384) != 0 ? textStyleFromToken.paragraphStyle.m4620getTextAlignbuA522U() : TextAlign.m5059boximpl(TextAlign.Companion.m5066getCentere0LSkKk()), (4128601 & 32768) != 0 ? textStyleFromToken.paragraphStyle.m4622getTextDirectionmmuk1to() : null, (4128601 & 65536) != 0 ? textStyleFromToken.paragraphStyle.m4619getLineHeightXSAIIZE() : 0L, (4128601 & 131072) != 0 ? textStyleFromToken.paragraphStyle.getTextIndent() : null, (4128601 & 262144) != 0 ? textStyleFromToken.platformStyle : null, (4128601 & 524288) != 0 ? textStyleFromToken.paragraphStyle.getLineHeightStyle() : null, (4128601 & 1048576) != 0 ? textStyleFromToken.paragraphStyle.m4617getLineBreakLgCVezo() : null, (4128601 & 2097152) != 0 ? textStyleFromToken.paragraphStyle.m4615getHyphensEaSxIns() : null), interfaceC0526Fp2, composer, (i2 >> 3) & 112);
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
