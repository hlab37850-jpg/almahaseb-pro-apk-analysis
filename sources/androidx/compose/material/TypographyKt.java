package androidx.compose.material;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;

/* JADX INFO: loaded from: classes.dex */
public final class TypographyKt {
    private static final TextStyle DefaultTextStyle;
    private static final ProvidableCompositionLocal<Typography> LocalTypography;

    static {
        TextStyle textStyle = TextStyle.Companion.getDefault();
        DefaultTextStyle = textStyle.m4723copyv2rsoow((16252927 & 1) != 0 ? textStyle.spanStyle.m4664getColor0d7_KjU() : 0L, (16252927 & 2) != 0 ? textStyle.spanStyle.m4665getFontSizeXSAIIZE() : 0L, (16252927 & 4) != 0 ? textStyle.spanStyle.getFontWeight() : null, (16252927 & 8) != 0 ? textStyle.spanStyle.m4666getFontStyle4Lr2A7w() : null, (16252927 & 16) != 0 ? textStyle.spanStyle.m4667getFontSynthesisZQGJjVo() : null, (16252927 & 32) != 0 ? textStyle.spanStyle.getFontFamily() : null, (16252927 & 64) != 0 ? textStyle.spanStyle.getFontFeatureSettings() : null, (16252927 & 128) != 0 ? textStyle.spanStyle.m4668getLetterSpacingXSAIIZE() : 0L, (16252927 & 256) != 0 ? textStyle.spanStyle.m4663getBaselineShift5SSeXJ0() : null, (16252927 & 512) != 0 ? textStyle.spanStyle.getTextGeometricTransform() : null, (16252927 & 1024) != 0 ? textStyle.spanStyle.getLocaleList() : null, (16252927 & 2048) != 0 ? textStyle.spanStyle.m4662getBackground0d7_KjU() : 0L, (16252927 & 4096) != 0 ? textStyle.spanStyle.getTextDecoration() : null, (16252927 & 8192) != 0 ? textStyle.spanStyle.getShadow() : null, (16252927 & 16384) != 0 ? textStyle.spanStyle.getDrawStyle() : null, (16252927 & 32768) != 0 ? textStyle.paragraphStyle.m4620getTextAlignbuA522U() : null, (16252927 & 65536) != 0 ? textStyle.paragraphStyle.m4622getTextDirectionmmuk1to() : null, (16252927 & 131072) != 0 ? textStyle.paragraphStyle.m4619getLineHeightXSAIIZE() : 0L, (16252927 & 262144) != 0 ? textStyle.paragraphStyle.getTextIndent() : null, (16252927 & 524288) != 0 ? textStyle.platformStyle : DefaultPlatformTextStyle_androidKt.defaultPlatformTextStyle(), (16252927 & 1048576) != 0 ? textStyle.paragraphStyle.getLineHeightStyle() : null, (16252927 & 2097152) != 0 ? textStyle.paragraphStyle.m4617getLineBreakLgCVezo() : null, (16252927 & 4194304) != 0 ? textStyle.paragraphStyle.m4615getHyphensEaSxIns() : null, (16252927 & 8388608) != 0 ? textStyle.paragraphStyle.getTextMotion() : null);
        LocalTypography = CompositionLocalKt.staticCompositionLocalOf(TypographyKt$LocalTypography$1.INSTANCE);
    }

    public static final TextStyle getDefaultTextStyle() {
        return DefaultTextStyle;
    }

    public static final ProvidableCompositionLocal<Typography> getLocalTypography() {
        return LocalTypography;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextStyle withDefaultFontFamily(TextStyle textStyle, FontFamily fontFamily) {
        return textStyle.getFontFamily() != null ? textStyle : textStyle.m4723copyv2rsoow((16252927 & 1) != 0 ? textStyle.spanStyle.m4664getColor0d7_KjU() : 0L, (16252927 & 2) != 0 ? textStyle.spanStyle.m4665getFontSizeXSAIIZE() : 0L, (16252927 & 4) != 0 ? textStyle.spanStyle.getFontWeight() : null, (16252927 & 8) != 0 ? textStyle.spanStyle.m4666getFontStyle4Lr2A7w() : null, (16252927 & 16) != 0 ? textStyle.spanStyle.m4667getFontSynthesisZQGJjVo() : null, (16252927 & 32) != 0 ? textStyle.spanStyle.getFontFamily() : fontFamily, (16252927 & 64) != 0 ? textStyle.spanStyle.getFontFeatureSettings() : null, (16252927 & 128) != 0 ? textStyle.spanStyle.m4668getLetterSpacingXSAIIZE() : 0L, (16252927 & 256) != 0 ? textStyle.spanStyle.m4663getBaselineShift5SSeXJ0() : null, (16252927 & 512) != 0 ? textStyle.spanStyle.getTextGeometricTransform() : null, (16252927 & 1024) != 0 ? textStyle.spanStyle.getLocaleList() : null, (16252927 & 2048) != 0 ? textStyle.spanStyle.m4662getBackground0d7_KjU() : 0L, (16252927 & 4096) != 0 ? textStyle.spanStyle.getTextDecoration() : null, (16252927 & 8192) != 0 ? textStyle.spanStyle.getShadow() : null, (16252927 & 16384) != 0 ? textStyle.spanStyle.getDrawStyle() : null, (16252927 & 32768) != 0 ? textStyle.paragraphStyle.m4620getTextAlignbuA522U() : null, (16252927 & 65536) != 0 ? textStyle.paragraphStyle.m4622getTextDirectionmmuk1to() : null, (16252927 & 131072) != 0 ? textStyle.paragraphStyle.m4619getLineHeightXSAIIZE() : 0L, (16252927 & 262144) != 0 ? textStyle.paragraphStyle.getTextIndent() : null, (16252927 & 524288) != 0 ? textStyle.platformStyle : null, (16252927 & 1048576) != 0 ? textStyle.paragraphStyle.getLineHeightStyle() : null, (16252927 & 2097152) != 0 ? textStyle.paragraphStyle.m4617getLineBreakLgCVezo() : null, (16252927 & 4194304) != 0 ? textStyle.paragraphStyle.m4615getHyphensEaSxIns() : null, (16252927 & 8388608) != 0 ? textStyle.paragraphStyle.getTextMotion() : null);
    }
}
