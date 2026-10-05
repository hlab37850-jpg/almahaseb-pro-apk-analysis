package androidx.compose.material3;

import androidx.compose.material3.tokens.PrimaryNavigationTabTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class TabKt$Tab$styledText$1$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ InterfaceC0526Fp $text;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabKt$Tab$styledText$1$1(InterfaceC0526Fp interfaceC0526Fp, int i) {
        super(2);
        this.$text = interfaceC0526Fp;
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
            ComposerKt.traceEventStart(708874428, i, -1, "androidx.compose.material3.Tab.<anonymous>.<anonymous> (Tab.kt:104)");
        }
        TextStyle textStyleFromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer, 6), PrimaryNavigationTabTokens.INSTANCE.getLabelTextFont());
        TextKt.ProvideTextStyle(textStyleFromToken.m4719copyCXVQc50((4128601 & 1) != 0 ? textStyleFromToken.spanStyle.m4664getColor0d7_KjU() : 0L, (4128601 & 2) != 0 ? textStyleFromToken.spanStyle.m4665getFontSizeXSAIIZE() : 0L, (4128601 & 4) != 0 ? textStyleFromToken.spanStyle.getFontWeight() : null, (4128601 & 8) != 0 ? textStyleFromToken.spanStyle.m4666getFontStyle4Lr2A7w() : null, (4128601 & 16) != 0 ? textStyleFromToken.spanStyle.m4667getFontSynthesisZQGJjVo() : null, (4128601 & 32) != 0 ? textStyleFromToken.spanStyle.getFontFamily() : null, (4128601 & 64) != 0 ? textStyleFromToken.spanStyle.getFontFeatureSettings() : null, (4128601 & 128) != 0 ? textStyleFromToken.spanStyle.m4668getLetterSpacingXSAIIZE() : 0L, (4128601 & 256) != 0 ? textStyleFromToken.spanStyle.m4663getBaselineShift5SSeXJ0() : null, (4128601 & 512) != 0 ? textStyleFromToken.spanStyle.getTextGeometricTransform() : null, (4128601 & 1024) != 0 ? textStyleFromToken.spanStyle.getLocaleList() : null, (4128601 & 2048) != 0 ? textStyleFromToken.spanStyle.m4662getBackground0d7_KjU() : 0L, (4128601 & 4096) != 0 ? textStyleFromToken.spanStyle.getTextDecoration() : null, (4128601 & 8192) != 0 ? textStyleFromToken.spanStyle.getShadow() : null, (4128601 & 16384) != 0 ? textStyleFromToken.paragraphStyle.m4620getTextAlignbuA522U() : TextAlign.m5059boximpl(TextAlign.Companion.m5066getCentere0LSkKk()), (4128601 & 32768) != 0 ? textStyleFromToken.paragraphStyle.m4622getTextDirectionmmuk1to() : null, (4128601 & 65536) != 0 ? textStyleFromToken.paragraphStyle.m4619getLineHeightXSAIIZE() : 0L, (4128601 & 131072) != 0 ? textStyleFromToken.paragraphStyle.getTextIndent() : null, (4128601 & 262144) != 0 ? textStyleFromToken.platformStyle : null, (4128601 & 524288) != 0 ? textStyleFromToken.paragraphStyle.getLineHeightStyle() : null, (4128601 & 1048576) != 0 ? textStyleFromToken.paragraphStyle.m4617getLineBreakLgCVezo() : null, (4128601 & 2097152) != 0 ? textStyleFromToken.paragraphStyle.m4615getHyphensEaSxIns() : null), this.$text, composer, (this.$$dirty >> 9) & 112);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
