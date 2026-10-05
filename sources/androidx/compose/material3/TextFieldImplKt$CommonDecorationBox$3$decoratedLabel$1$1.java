package androidx.compose.material3;

import androidx.compose.runtime.Composable;
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

    @Composable
    public final void invoke(Composer composer, int i) {
        if ((i & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-382297919, i, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:117)");
        }
        MaterialTheme materialTheme = MaterialTheme.INSTANCE;
        TextStyle textStyleLerp = TextStyleKt.lerp(materialTheme.getTypography(composer, 6).getBodyLarge(), materialTheme.getTypography(composer, 6).getBodySmall(), this.$labelProgress);
        TextFieldImplKt.m1920DecorationKTwxG1Y(this.$labelContentColor, this.$shouldOverrideTextStyleColor ? textStyleLerp.m4719copyCXVQc50((4128601 & 1) != 0 ? textStyleLerp.spanStyle.m4664getColor0d7_KjU() : this.$labelTextStyleColor, (4128601 & 2) != 0 ? textStyleLerp.spanStyle.m4665getFontSizeXSAIIZE() : 0L, (4128601 & 4) != 0 ? textStyleLerp.spanStyle.getFontWeight() : null, (4128601 & 8) != 0 ? textStyleLerp.spanStyle.m4666getFontStyle4Lr2A7w() : null, (4128601 & 16) != 0 ? textStyleLerp.spanStyle.m4667getFontSynthesisZQGJjVo() : null, (4128601 & 32) != 0 ? textStyleLerp.spanStyle.getFontFamily() : null, (4128601 & 64) != 0 ? textStyleLerp.spanStyle.getFontFeatureSettings() : null, (4128601 & 128) != 0 ? textStyleLerp.spanStyle.m4668getLetterSpacingXSAIIZE() : 0L, (4128601 & 256) != 0 ? textStyleLerp.spanStyle.m4663getBaselineShift5SSeXJ0() : null, (4128601 & 512) != 0 ? textStyleLerp.spanStyle.getTextGeometricTransform() : null, (4128601 & 1024) != 0 ? textStyleLerp.spanStyle.getLocaleList() : null, (4128601 & 2048) != 0 ? textStyleLerp.spanStyle.m4662getBackground0d7_KjU() : 0L, (4128601 & 4096) != 0 ? textStyleLerp.spanStyle.getTextDecoration() : null, (4128601 & 8192) != 0 ? textStyleLerp.spanStyle.getShadow() : null, (4128601 & 16384) != 0 ? textStyleLerp.paragraphStyle.m4620getTextAlignbuA522U() : null, (4128601 & 32768) != 0 ? textStyleLerp.paragraphStyle.m4622getTextDirectionmmuk1to() : null, (4128601 & 65536) != 0 ? textStyleLerp.paragraphStyle.m4619getLineHeightXSAIIZE() : 0L, (4128601 & 131072) != 0 ? textStyleLerp.paragraphStyle.getTextIndent() : null, (4128601 & 262144) != 0 ? textStyleLerp.platformStyle : null, (4128601 & 524288) != 0 ? textStyleLerp.paragraphStyle.getLineHeightStyle() : null, (4128601 & 1048576) != 0 ? textStyleLerp.paragraphStyle.m4617getLineBreakLgCVezo() : null, (4128601 & 2097152) != 0 ? textStyleLerp.paragraphStyle.m4615getHyphensEaSxIns() : null) : textStyleLerp, this.$it, composer, (this.$$dirty >> 6) & 14, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
