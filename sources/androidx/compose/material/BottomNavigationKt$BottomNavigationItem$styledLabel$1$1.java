package androidx.compose.material;

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
public final class BottomNavigationKt$BottomNavigationItem$styledLabel$1$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ InterfaceC0526Fp $label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomNavigationKt$BottomNavigationItem$styledLabel$1$1(InterfaceC0526Fp interfaceC0526Fp, int i) {
        super(2);
        this.$label = interfaceC0526Fp;
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
            ComposerKt.traceEventStart(1343298261, i, -1, "androidx.compose.material.BottomNavigationItem.<anonymous>.<anonymous> (BottomNavigation.kt:159)");
        }
        TextStyle caption = MaterialTheme.INSTANCE.getTypography(composer, 6).getCaption();
        TextKt.ProvideTextStyle(caption.m4723copyv2rsoow((16252927 & 1) != 0 ? caption.spanStyle.m4664getColor0d7_KjU() : 0L, (16252927 & 2) != 0 ? caption.spanStyle.m4665getFontSizeXSAIIZE() : 0L, (16252927 & 4) != 0 ? caption.spanStyle.getFontWeight() : null, (16252927 & 8) != 0 ? caption.spanStyle.m4666getFontStyle4Lr2A7w() : null, (16252927 & 16) != 0 ? caption.spanStyle.m4667getFontSynthesisZQGJjVo() : null, (16252927 & 32) != 0 ? caption.spanStyle.getFontFamily() : null, (16252927 & 64) != 0 ? caption.spanStyle.getFontFeatureSettings() : null, (16252927 & 128) != 0 ? caption.spanStyle.m4668getLetterSpacingXSAIIZE() : 0L, (16252927 & 256) != 0 ? caption.spanStyle.m4663getBaselineShift5SSeXJ0() : null, (16252927 & 512) != 0 ? caption.spanStyle.getTextGeometricTransform() : null, (16252927 & 1024) != 0 ? caption.spanStyle.getLocaleList() : null, (16252927 & 2048) != 0 ? caption.spanStyle.m4662getBackground0d7_KjU() : 0L, (16252927 & 4096) != 0 ? caption.spanStyle.getTextDecoration() : null, (16252927 & 8192) != 0 ? caption.spanStyle.getShadow() : null, (16252927 & 16384) != 0 ? caption.spanStyle.getDrawStyle() : null, (16252927 & 32768) != 0 ? caption.paragraphStyle.m4620getTextAlignbuA522U() : TextAlign.m5059boximpl(TextAlign.Companion.m5066getCentere0LSkKk()), (16252927 & 65536) != 0 ? caption.paragraphStyle.m4622getTextDirectionmmuk1to() : null, (16252927 & 131072) != 0 ? caption.paragraphStyle.m4619getLineHeightXSAIIZE() : 0L, (16252927 & 262144) != 0 ? caption.paragraphStyle.getTextIndent() : null, (16252927 & 524288) != 0 ? caption.platformStyle : null, (16252927 & 1048576) != 0 ? caption.paragraphStyle.getLineHeightStyle() : null, (16252927 & 2097152) != 0 ? caption.paragraphStyle.m4617getLineBreakLgCVezo() : null, (16252927 & 4194304) != 0 ? caption.paragraphStyle.m4615getHyphensEaSxIns() : null, (16252927 & 8388608) != 0 ? caption.paragraphStyle.getTextMotion() : null), this.$label, composer, (this.$$dirty >> 15) & 112);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
