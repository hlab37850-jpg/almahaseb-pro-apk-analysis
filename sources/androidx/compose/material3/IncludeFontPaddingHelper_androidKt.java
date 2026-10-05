package androidx.compose.material3;

import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class IncludeFontPaddingHelper_androidKt {
    public static final TextStyle copyAndSetFontPadding(TextStyle textStyle, boolean z) {
        AbstractC4492zt.h(textStyle, "style");
        return textStyle.m4719copyCXVQc50((4128601 & 1) != 0 ? textStyle.spanStyle.m4664getColor0d7_KjU() : 0L, (4128601 & 2) != 0 ? textStyle.spanStyle.m4665getFontSizeXSAIIZE() : 0L, (4128601 & 4) != 0 ? textStyle.spanStyle.getFontWeight() : null, (4128601 & 8) != 0 ? textStyle.spanStyle.m4666getFontStyle4Lr2A7w() : null, (4128601 & 16) != 0 ? textStyle.spanStyle.m4667getFontSynthesisZQGJjVo() : null, (4128601 & 32) != 0 ? textStyle.spanStyle.getFontFamily() : null, (4128601 & 64) != 0 ? textStyle.spanStyle.getFontFeatureSettings() : null, (4128601 & 128) != 0 ? textStyle.spanStyle.m4668getLetterSpacingXSAIIZE() : 0L, (4128601 & 256) != 0 ? textStyle.spanStyle.m4663getBaselineShift5SSeXJ0() : null, (4128601 & 512) != 0 ? textStyle.spanStyle.getTextGeometricTransform() : null, (4128601 & 1024) != 0 ? textStyle.spanStyle.getLocaleList() : null, (4128601 & 2048) != 0 ? textStyle.spanStyle.m4662getBackground0d7_KjU() : 0L, (4128601 & 4096) != 0 ? textStyle.spanStyle.getTextDecoration() : null, (4128601 & 8192) != 0 ? textStyle.spanStyle.getShadow() : null, (4128601 & 16384) != 0 ? textStyle.paragraphStyle.m4620getTextAlignbuA522U() : null, (4128601 & 32768) != 0 ? textStyle.paragraphStyle.m4622getTextDirectionmmuk1to() : null, (4128601 & 65536) != 0 ? textStyle.paragraphStyle.m4619getLineHeightXSAIIZE() : 0L, (4128601 & 131072) != 0 ? textStyle.paragraphStyle.getTextIndent() : null, (4128601 & 262144) != 0 ? textStyle.platformStyle : new PlatformTextStyle(z), (4128601 & 524288) != 0 ? textStyle.paragraphStyle.getLineHeightStyle() : null, (4128601 & 1048576) != 0 ? textStyle.paragraphStyle.m4617getLineBreakLgCVezo() : null, (4128601 & 2097152) != 0 ? textStyle.paragraphStyle.m4615getHyphensEaSxIns() : null);
    }
}
