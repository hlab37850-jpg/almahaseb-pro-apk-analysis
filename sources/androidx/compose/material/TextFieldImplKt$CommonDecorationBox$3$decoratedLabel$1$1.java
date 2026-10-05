package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ InterfaceC0526Fp $it;
    final /* synthetic */ long $labelContentColor;
    final /* synthetic */ float $labelProgress;
    final /* synthetic */ long $labelTextStyleColor;
    final /* synthetic */ boolean $shouldOverrideTextStyleColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1(float f, long j, InterfaceC0526Fp interfaceC0526Fp, int i, boolean z, long j2) {
        super(2);
        this.$labelProgress = f;
        this.$labelContentColor = j;
        this.$it = interfaceC0526Fp;
        this.$$dirty = i;
        this.$shouldOverrideTextStyleColor = z;
        this.$labelTextStyleColor = j2;
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
            ComposerKt.traceEventStart(362863774, i, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:121)");
        }
        MaterialTheme materialTheme = MaterialTheme.INSTANCE;
        TextStyle textStyleLerp = TextStyleKt.lerp(materialTheme.getTypography(composer, 6).getSubtitle1(), materialTheme.getTypography(composer, 6).getCaption(), this.$labelProgress);
        TextFieldImplKt.m1278DecorationeuL9pac(this.$labelContentColor, this.$shouldOverrideTextStyleColor ? textStyleLerp.m4723copyv2rsoow((16252927 & 1) != 0 ? textStyleLerp.spanStyle.m4664getColor0d7_KjU() : this.$labelTextStyleColor, (16252927 & 2) != 0 ? textStyleLerp.spanStyle.m4665getFontSizeXSAIIZE() : 0L, (16252927 & 4) != 0 ? textStyleLerp.spanStyle.getFontWeight() : null, (16252927 & 8) != 0 ? textStyleLerp.spanStyle.m4666getFontStyle4Lr2A7w() : null, (16252927 & 16) != 0 ? textStyleLerp.spanStyle.m4667getFontSynthesisZQGJjVo() : null, (16252927 & 32) != 0 ? textStyleLerp.spanStyle.getFontFamily() : null, (16252927 & 64) != 0 ? textStyleLerp.spanStyle.getFontFeatureSettings() : null, (16252927 & 128) != 0 ? textStyleLerp.spanStyle.m4668getLetterSpacingXSAIIZE() : 0L, (16252927 & 256) != 0 ? textStyleLerp.spanStyle.m4663getBaselineShift5SSeXJ0() : null, (16252927 & 512) != 0 ? textStyleLerp.spanStyle.getTextGeometricTransform() : null, (16252927 & 1024) != 0 ? textStyleLerp.spanStyle.getLocaleList() : null, (16252927 & 2048) != 0 ? textStyleLerp.spanStyle.m4662getBackground0d7_KjU() : 0L, (16252927 & 4096) != 0 ? textStyleLerp.spanStyle.getTextDecoration() : null, (16252927 & 8192) != 0 ? textStyleLerp.spanStyle.getShadow() : null, (16252927 & 16384) != 0 ? textStyleLerp.spanStyle.getDrawStyle() : null, (16252927 & 32768) != 0 ? textStyleLerp.paragraphStyle.m4620getTextAlignbuA522U() : null, (16252927 & 65536) != 0 ? textStyleLerp.paragraphStyle.m4622getTextDirectionmmuk1to() : null, (16252927 & 131072) != 0 ? textStyleLerp.paragraphStyle.m4619getLineHeightXSAIIZE() : 0L, (16252927 & 262144) != 0 ? textStyleLerp.paragraphStyle.getTextIndent() : null, (16252927 & 524288) != 0 ? textStyleLerp.platformStyle : null, (16252927 & 1048576) != 0 ? textStyleLerp.paragraphStyle.getLineHeightStyle() : null, (16252927 & 2097152) != 0 ? textStyleLerp.paragraphStyle.m4617getLineBreakLgCVezo() : null, (16252927 & 4194304) != 0 ? textStyleLerp.paragraphStyle.m4615getHyphensEaSxIns() : null, (16252927 & 8388608) != 0 ? textStyleLerp.paragraphStyle.getTextMotion() : null) : textStyleLerp, null, this.$it, composer, ((this.$$dirty >> 6) & 14) | 384, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
