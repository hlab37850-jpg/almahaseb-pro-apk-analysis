package androidx.compose.material;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.TextUnitKt;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class Typography {
    public static final int $stable = 0;
    private final TextStyle body1;
    private final TextStyle body2;
    private final TextStyle button;
    private final TextStyle caption;
    private final TextStyle h1;
    private final TextStyle h2;
    private final TextStyle h3;
    private final TextStyle h4;
    private final TextStyle h5;
    private final TextStyle h6;
    private final TextStyle overline;
    private final TextStyle subtitle1;
    private final TextStyle subtitle2;

    public Typography(TextStyle textStyle, TextStyle textStyle2, TextStyle textStyle3, TextStyle textStyle4, TextStyle textStyle5, TextStyle textStyle6, TextStyle textStyle7, TextStyle textStyle8, TextStyle textStyle9, TextStyle textStyle10, TextStyle textStyle11, TextStyle textStyle12, TextStyle textStyle13) {
        AbstractC4492zt.h(textStyle, "h1");
        AbstractC4492zt.h(textStyle2, "h2");
        AbstractC4492zt.h(textStyle3, "h3");
        AbstractC4492zt.h(textStyle4, "h4");
        AbstractC4492zt.h(textStyle5, "h5");
        AbstractC4492zt.h(textStyle6, "h6");
        AbstractC4492zt.h(textStyle7, "subtitle1");
        AbstractC4492zt.h(textStyle8, "subtitle2");
        AbstractC4492zt.h(textStyle9, "body1");
        AbstractC4492zt.h(textStyle10, "body2");
        AbstractC4492zt.h(textStyle11, HTML.Tag.BUTTON);
        AbstractC4492zt.h(textStyle12, HTML.Tag.CAPTION);
        AbstractC4492zt.h(textStyle13, "overline");
        this.h1 = textStyle;
        this.h2 = textStyle2;
        this.h3 = textStyle3;
        this.h4 = textStyle4;
        this.h5 = textStyle5;
        this.h6 = textStyle6;
        this.subtitle1 = textStyle7;
        this.subtitle2 = textStyle8;
        this.body1 = textStyle9;
        this.body2 = textStyle10;
        this.button = textStyle11;
        this.caption = textStyle12;
        this.overline = textStyle13;
    }

    public final Typography copy(TextStyle textStyle, TextStyle textStyle2, TextStyle textStyle3, TextStyle textStyle4, TextStyle textStyle5, TextStyle textStyle6, TextStyle textStyle7, TextStyle textStyle8, TextStyle textStyle9, TextStyle textStyle10, TextStyle textStyle11, TextStyle textStyle12, TextStyle textStyle13) {
        AbstractC4492zt.h(textStyle, "h1");
        AbstractC4492zt.h(textStyle2, "h2");
        AbstractC4492zt.h(textStyle3, "h3");
        AbstractC4492zt.h(textStyle4, "h4");
        AbstractC4492zt.h(textStyle5, "h5");
        AbstractC4492zt.h(textStyle6, "h6");
        AbstractC4492zt.h(textStyle7, "subtitle1");
        AbstractC4492zt.h(textStyle8, "subtitle2");
        AbstractC4492zt.h(textStyle9, "body1");
        AbstractC4492zt.h(textStyle10, "body2");
        AbstractC4492zt.h(textStyle11, HTML.Tag.BUTTON);
        AbstractC4492zt.h(textStyle12, HTML.Tag.CAPTION);
        AbstractC4492zt.h(textStyle13, "overline");
        return new Typography(textStyle, textStyle2, textStyle3, textStyle4, textStyle5, textStyle6, textStyle7, textStyle8, textStyle9, textStyle10, textStyle11, textStyle12, textStyle13);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Typography)) {
            return false;
        }
        Typography typography = (Typography) obj;
        return AbstractC4492zt.d(this.h1, typography.h1) && AbstractC4492zt.d(this.h2, typography.h2) && AbstractC4492zt.d(this.h3, typography.h3) && AbstractC4492zt.d(this.h4, typography.h4) && AbstractC4492zt.d(this.h5, typography.h5) && AbstractC4492zt.d(this.h6, typography.h6) && AbstractC4492zt.d(this.subtitle1, typography.subtitle1) && AbstractC4492zt.d(this.subtitle2, typography.subtitle2) && AbstractC4492zt.d(this.body1, typography.body1) && AbstractC4492zt.d(this.body2, typography.body2) && AbstractC4492zt.d(this.button, typography.button) && AbstractC4492zt.d(this.caption, typography.caption) && AbstractC4492zt.d(this.overline, typography.overline);
    }

    public final TextStyle getBody1() {
        return this.body1;
    }

    public final TextStyle getBody2() {
        return this.body2;
    }

    public final TextStyle getButton() {
        return this.button;
    }

    public final TextStyle getCaption() {
        return this.caption;
    }

    public final TextStyle getH1() {
        return this.h1;
    }

    public final TextStyle getH2() {
        return this.h2;
    }

    public final TextStyle getH3() {
        return this.h3;
    }

    public final TextStyle getH4() {
        return this.h4;
    }

    public final TextStyle getH5() {
        return this.h5;
    }

    public final TextStyle getH6() {
        return this.h6;
    }

    public final TextStyle getOverline() {
        return this.overline;
    }

    public final TextStyle getSubtitle1() {
        return this.subtitle1;
    }

    public final TextStyle getSubtitle2() {
        return this.subtitle2;
    }

    public int hashCode() {
        return (((((((((((((((((((((((this.h1.hashCode() * 31) + this.h2.hashCode()) * 31) + this.h3.hashCode()) * 31) + this.h4.hashCode()) * 31) + this.h5.hashCode()) * 31) + this.h6.hashCode()) * 31) + this.subtitle1.hashCode()) * 31) + this.subtitle2.hashCode()) * 31) + this.body1.hashCode()) * 31) + this.body2.hashCode()) * 31) + this.button.hashCode()) * 31) + this.caption.hashCode()) * 31) + this.overline.hashCode();
    }

    public String toString() {
        return "Typography(h1=" + this.h1 + ", h2=" + this.h2 + ", h3=" + this.h3 + ", h4=" + this.h4 + ", h5=" + this.h5 + ", h6=" + this.h6 + ", subtitle1=" + this.subtitle1 + ", subtitle2=" + this.subtitle2 + ", body1=" + this.body1 + ", body2=" + this.body2 + ", button=" + this.button + ", caption=" + this.caption + ", overline=" + this.overline + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ Typography(FontFamily fontFamily, TextStyle textStyle, TextStyle textStyle2, TextStyle textStyle3, TextStyle textStyle4, TextStyle textStyle5, TextStyle textStyle6, TextStyle textStyle7, TextStyle textStyle8, TextStyle textStyle9, TextStyle textStyle10, TextStyle textStyle11, TextStyle textStyle12, TextStyle textStyle13, int i, AbstractC0419Di abstractC0419Di) {
        TextStyle textStyleM4723copyv2rsoow;
        TextStyle textStyleM4723copyv2rsoow2;
        TextStyle textStyleM4723copyv2rsoow3;
        TextStyle textStyleM4723copyv2rsoow4;
        TextStyle textStyleM4723copyv2rsoow5;
        TextStyle textStyleM4723copyv2rsoow6;
        TextStyle textStyleM4723copyv2rsoow7;
        TextStyle textStyleM4723copyv2rsoow8;
        TextStyle textStyleM4723copyv2rsoow9;
        TextStyle textStyleM4723copyv2rsoow10;
        TextStyle textStyleM4723copyv2rsoow11;
        TextStyle textStyleM4723copyv2rsoow12;
        TextStyle textStyleM4723copyv2rsoow13;
        FontFamily fontFamily2 = (i & 1) != 0 ? FontFamily.Companion.getDefault() : fontFamily;
        if ((i & 2) != 0) {
            TextStyle defaultTextStyle = TypographyKt.getDefaultTextStyle();
            textStyleM4723copyv2rsoow = defaultTextStyle.m4723copyv2rsoow((16252927 & 1) != 0 ? defaultTextStyle.spanStyle.m4664getColor0d7_KjU() : 0L, (16252927 & 2) != 0 ? defaultTextStyle.spanStyle.m4665getFontSizeXSAIIZE() : TextUnitKt.getSp(96), (16252927 & 4) != 0 ? defaultTextStyle.spanStyle.getFontWeight() : FontWeight.Companion.getLight(), (16252927 & 8) != 0 ? defaultTextStyle.spanStyle.m4666getFontStyle4Lr2A7w() : null, (16252927 & 16) != 0 ? defaultTextStyle.spanStyle.m4667getFontSynthesisZQGJjVo() : null, (16252927 & 32) != 0 ? defaultTextStyle.spanStyle.getFontFamily() : null, (16252927 & 64) != 0 ? defaultTextStyle.spanStyle.getFontFeatureSettings() : null, (16252927 & 128) != 0 ? defaultTextStyle.spanStyle.m4668getLetterSpacingXSAIIZE() : TextUnitKt.getSp(-1.5d), (16252927 & 256) != 0 ? defaultTextStyle.spanStyle.m4663getBaselineShift5SSeXJ0() : null, (16252927 & 512) != 0 ? defaultTextStyle.spanStyle.getTextGeometricTransform() : null, (16252927 & 1024) != 0 ? defaultTextStyle.spanStyle.getLocaleList() : null, (16252927 & 2048) != 0 ? defaultTextStyle.spanStyle.m4662getBackground0d7_KjU() : 0L, (16252927 & 4096) != 0 ? defaultTextStyle.spanStyle.getTextDecoration() : null, (16252927 & 8192) != 0 ? defaultTextStyle.spanStyle.getShadow() : null, (16252927 & 16384) != 0 ? defaultTextStyle.spanStyle.getDrawStyle() : null, (16252927 & 32768) != 0 ? defaultTextStyle.paragraphStyle.m4620getTextAlignbuA522U() : null, (16252927 & 65536) != 0 ? defaultTextStyle.paragraphStyle.m4622getTextDirectionmmuk1to() : null, (16252927 & 131072) != 0 ? defaultTextStyle.paragraphStyle.m4619getLineHeightXSAIIZE() : 0L, (16252927 & 262144) != 0 ? defaultTextStyle.paragraphStyle.getTextIndent() : null, (16252927 & 524288) != 0 ? defaultTextStyle.platformStyle : null, (16252927 & 1048576) != 0 ? defaultTextStyle.paragraphStyle.getLineHeightStyle() : null, (16252927 & 2097152) != 0 ? defaultTextStyle.paragraphStyle.m4617getLineBreakLgCVezo() : null, (16252927 & 4194304) != 0 ? defaultTextStyle.paragraphStyle.m4615getHyphensEaSxIns() : null, (16252927 & 8388608) != 0 ? defaultTextStyle.paragraphStyle.getTextMotion() : null);
        } else {
            textStyleM4723copyv2rsoow = textStyle;
        }
        if ((i & 4) != 0) {
            TextStyle defaultTextStyle2 = TypographyKt.getDefaultTextStyle();
            textStyleM4723copyv2rsoow2 = defaultTextStyle2.m4723copyv2rsoow((16252927 & 1) != 0 ? defaultTextStyle2.spanStyle.m4664getColor0d7_KjU() : 0L, (16252927 & 2) != 0 ? defaultTextStyle2.spanStyle.m4665getFontSizeXSAIIZE() : TextUnitKt.getSp(60), (16252927 & 4) != 0 ? defaultTextStyle2.spanStyle.getFontWeight() : FontWeight.Companion.getLight(), (16252927 & 8) != 0 ? defaultTextStyle2.spanStyle.m4666getFontStyle4Lr2A7w() : null, (16252927 & 16) != 0 ? defaultTextStyle2.spanStyle.m4667getFontSynthesisZQGJjVo() : null, (16252927 & 32) != 0 ? defaultTextStyle2.spanStyle.getFontFamily() : null, (16252927 & 64) != 0 ? defaultTextStyle2.spanStyle.getFontFeatureSettings() : null, (16252927 & 128) != 0 ? defaultTextStyle2.spanStyle.m4668getLetterSpacingXSAIIZE() : TextUnitKt.getSp(-0.5d), (16252927 & 256) != 0 ? defaultTextStyle2.spanStyle.m4663getBaselineShift5SSeXJ0() : null, (16252927 & 512) != 0 ? defaultTextStyle2.spanStyle.getTextGeometricTransform() : null, (16252927 & 1024) != 0 ? defaultTextStyle2.spanStyle.getLocaleList() : null, (16252927 & 2048) != 0 ? defaultTextStyle2.spanStyle.m4662getBackground0d7_KjU() : 0L, (16252927 & 4096) != 0 ? defaultTextStyle2.spanStyle.getTextDecoration() : null, (16252927 & 8192) != 0 ? defaultTextStyle2.spanStyle.getShadow() : null, (16252927 & 16384) != 0 ? defaultTextStyle2.spanStyle.getDrawStyle() : null, (16252927 & 32768) != 0 ? defaultTextStyle2.paragraphStyle.m4620getTextAlignbuA522U() : null, (16252927 & 65536) != 0 ? defaultTextStyle2.paragraphStyle.m4622getTextDirectionmmuk1to() : null, (16252927 & 131072) != 0 ? defaultTextStyle2.paragraphStyle.m4619getLineHeightXSAIIZE() : 0L, (16252927 & 262144) != 0 ? defaultTextStyle2.paragraphStyle.getTextIndent() : null, (16252927 & 524288) != 0 ? defaultTextStyle2.platformStyle : null, (16252927 & 1048576) != 0 ? defaultTextStyle2.paragraphStyle.getLineHeightStyle() : null, (16252927 & 2097152) != 0 ? defaultTextStyle2.paragraphStyle.m4617getLineBreakLgCVezo() : null, (16252927 & 4194304) != 0 ? defaultTextStyle2.paragraphStyle.m4615getHyphensEaSxIns() : null, (16252927 & 8388608) != 0 ? defaultTextStyle2.paragraphStyle.getTextMotion() : null);
        } else {
            textStyleM4723copyv2rsoow2 = textStyle2;
        }
        if ((i & 8) != 0) {
            TextStyle defaultTextStyle3 = TypographyKt.getDefaultTextStyle();
            textStyleM4723copyv2rsoow3 = defaultTextStyle3.m4723copyv2rsoow((16252927 & 1) != 0 ? defaultTextStyle3.spanStyle.m4664getColor0d7_KjU() : 0L, (16252927 & 2) != 0 ? defaultTextStyle3.spanStyle.m4665getFontSizeXSAIIZE() : TextUnitKt.getSp(48), (16252927 & 4) != 0 ? defaultTextStyle3.spanStyle.getFontWeight() : FontWeight.Companion.getNormal(), (16252927 & 8) != 0 ? defaultTextStyle3.spanStyle.m4666getFontStyle4Lr2A7w() : null, (16252927 & 16) != 0 ? defaultTextStyle3.spanStyle.m4667getFontSynthesisZQGJjVo() : null, (16252927 & 32) != 0 ? defaultTextStyle3.spanStyle.getFontFamily() : null, (16252927 & 64) != 0 ? defaultTextStyle3.spanStyle.getFontFeatureSettings() : null, (16252927 & 128) != 0 ? defaultTextStyle3.spanStyle.m4668getLetterSpacingXSAIIZE() : TextUnitKt.getSp(0), (16252927 & 256) != 0 ? defaultTextStyle3.spanStyle.m4663getBaselineShift5SSeXJ0() : null, (16252927 & 512) != 0 ? defaultTextStyle3.spanStyle.getTextGeometricTransform() : null, (16252927 & 1024) != 0 ? defaultTextStyle3.spanStyle.getLocaleList() : null, (16252927 & 2048) != 0 ? defaultTextStyle3.spanStyle.m4662getBackground0d7_KjU() : 0L, (16252927 & 4096) != 0 ? defaultTextStyle3.spanStyle.getTextDecoration() : null, (16252927 & 8192) != 0 ? defaultTextStyle3.spanStyle.getShadow() : null, (16252927 & 16384) != 0 ? defaultTextStyle3.spanStyle.getDrawStyle() : null, (16252927 & 32768) != 0 ? defaultTextStyle3.paragraphStyle.m4620getTextAlignbuA522U() : null, (16252927 & 65536) != 0 ? defaultTextStyle3.paragraphStyle.m4622getTextDirectionmmuk1to() : null, (16252927 & 131072) != 0 ? defaultTextStyle3.paragraphStyle.m4619getLineHeightXSAIIZE() : 0L, (16252927 & 262144) != 0 ? defaultTextStyle3.paragraphStyle.getTextIndent() : null, (16252927 & 524288) != 0 ? defaultTextStyle3.platformStyle : null, (16252927 & 1048576) != 0 ? defaultTextStyle3.paragraphStyle.getLineHeightStyle() : null, (16252927 & 2097152) != 0 ? defaultTextStyle3.paragraphStyle.m4617getLineBreakLgCVezo() : null, (16252927 & 4194304) != 0 ? defaultTextStyle3.paragraphStyle.m4615getHyphensEaSxIns() : null, (16252927 & 8388608) != 0 ? defaultTextStyle3.paragraphStyle.getTextMotion() : null);
        } else {
            textStyleM4723copyv2rsoow3 = textStyle3;
        }
        if ((i & 16) != 0) {
            TextStyle defaultTextStyle4 = TypographyKt.getDefaultTextStyle();
            textStyleM4723copyv2rsoow4 = defaultTextStyle4.m4723copyv2rsoow((16252927 & 1) != 0 ? defaultTextStyle4.spanStyle.m4664getColor0d7_KjU() : 0L, (16252927 & 2) != 0 ? defaultTextStyle4.spanStyle.m4665getFontSizeXSAIIZE() : TextUnitKt.getSp(34), (16252927 & 4) != 0 ? defaultTextStyle4.spanStyle.getFontWeight() : FontWeight.Companion.getNormal(), (16252927 & 8) != 0 ? defaultTextStyle4.spanStyle.m4666getFontStyle4Lr2A7w() : null, (16252927 & 16) != 0 ? defaultTextStyle4.spanStyle.m4667getFontSynthesisZQGJjVo() : null, (16252927 & 32) != 0 ? defaultTextStyle4.spanStyle.getFontFamily() : null, (16252927 & 64) != 0 ? defaultTextStyle4.spanStyle.getFontFeatureSettings() : null, (16252927 & 128) != 0 ? defaultTextStyle4.spanStyle.m4668getLetterSpacingXSAIIZE() : TextUnitKt.getSp(0.25d), (16252927 & 256) != 0 ? defaultTextStyle4.spanStyle.m4663getBaselineShift5SSeXJ0() : null, (16252927 & 512) != 0 ? defaultTextStyle4.spanStyle.getTextGeometricTransform() : null, (16252927 & 1024) != 0 ? defaultTextStyle4.spanStyle.getLocaleList() : null, (16252927 & 2048) != 0 ? defaultTextStyle4.spanStyle.m4662getBackground0d7_KjU() : 0L, (16252927 & 4096) != 0 ? defaultTextStyle4.spanStyle.getTextDecoration() : null, (16252927 & 8192) != 0 ? defaultTextStyle4.spanStyle.getShadow() : null, (16252927 & 16384) != 0 ? defaultTextStyle4.spanStyle.getDrawStyle() : null, (16252927 & 32768) != 0 ? defaultTextStyle4.paragraphStyle.m4620getTextAlignbuA522U() : null, (16252927 & 65536) != 0 ? defaultTextStyle4.paragraphStyle.m4622getTextDirectionmmuk1to() : null, (16252927 & 131072) != 0 ? defaultTextStyle4.paragraphStyle.m4619getLineHeightXSAIIZE() : 0L, (16252927 & 262144) != 0 ? defaultTextStyle4.paragraphStyle.getTextIndent() : null, (16252927 & 524288) != 0 ? defaultTextStyle4.platformStyle : null, (16252927 & 1048576) != 0 ? defaultTextStyle4.paragraphStyle.getLineHeightStyle() : null, (16252927 & 2097152) != 0 ? defaultTextStyle4.paragraphStyle.m4617getLineBreakLgCVezo() : null, (16252927 & 4194304) != 0 ? defaultTextStyle4.paragraphStyle.m4615getHyphensEaSxIns() : null, (16252927 & 8388608) != 0 ? defaultTextStyle4.paragraphStyle.getTextMotion() : null);
        } else {
            textStyleM4723copyv2rsoow4 = textStyle4;
        }
        if ((i & 32) != 0) {
            TextStyle defaultTextStyle5 = TypographyKt.getDefaultTextStyle();
            textStyleM4723copyv2rsoow5 = defaultTextStyle5.m4723copyv2rsoow((16252927 & 1) != 0 ? defaultTextStyle5.spanStyle.m4664getColor0d7_KjU() : 0L, (16252927 & 2) != 0 ? defaultTextStyle5.spanStyle.m4665getFontSizeXSAIIZE() : TextUnitKt.getSp(24), (16252927 & 4) != 0 ? defaultTextStyle5.spanStyle.getFontWeight() : FontWeight.Companion.getNormal(), (16252927 & 8) != 0 ? defaultTextStyle5.spanStyle.m4666getFontStyle4Lr2A7w() : null, (16252927 & 16) != 0 ? defaultTextStyle5.spanStyle.m4667getFontSynthesisZQGJjVo() : null, (16252927 & 32) != 0 ? defaultTextStyle5.spanStyle.getFontFamily() : null, (16252927 & 64) != 0 ? defaultTextStyle5.spanStyle.getFontFeatureSettings() : null, (16252927 & 128) != 0 ? defaultTextStyle5.spanStyle.m4668getLetterSpacingXSAIIZE() : TextUnitKt.getSp(0), (16252927 & 256) != 0 ? defaultTextStyle5.spanStyle.m4663getBaselineShift5SSeXJ0() : null, (16252927 & 512) != 0 ? defaultTextStyle5.spanStyle.getTextGeometricTransform() : null, (16252927 & 1024) != 0 ? defaultTextStyle5.spanStyle.getLocaleList() : null, (16252927 & 2048) != 0 ? defaultTextStyle5.spanStyle.m4662getBackground0d7_KjU() : 0L, (16252927 & 4096) != 0 ? defaultTextStyle5.spanStyle.getTextDecoration() : null, (16252927 & 8192) != 0 ? defaultTextStyle5.spanStyle.getShadow() : null, (16252927 & 16384) != 0 ? defaultTextStyle5.spanStyle.getDrawStyle() : null, (16252927 & 32768) != 0 ? defaultTextStyle5.paragraphStyle.m4620getTextAlignbuA522U() : null, (16252927 & 65536) != 0 ? defaultTextStyle5.paragraphStyle.m4622getTextDirectionmmuk1to() : null, (16252927 & 131072) != 0 ? defaultTextStyle5.paragraphStyle.m4619getLineHeightXSAIIZE() : 0L, (16252927 & 262144) != 0 ? defaultTextStyle5.paragraphStyle.getTextIndent() : null, (16252927 & 524288) != 0 ? defaultTextStyle5.platformStyle : null, (16252927 & 1048576) != 0 ? defaultTextStyle5.paragraphStyle.getLineHeightStyle() : null, (16252927 & 2097152) != 0 ? defaultTextStyle5.paragraphStyle.m4617getLineBreakLgCVezo() : null, (16252927 & 4194304) != 0 ? defaultTextStyle5.paragraphStyle.m4615getHyphensEaSxIns() : null, (16252927 & 8388608) != 0 ? defaultTextStyle5.paragraphStyle.getTextMotion() : null);
        } else {
            textStyleM4723copyv2rsoow5 = textStyle5;
        }
        if ((i & 64) != 0) {
            TextStyle defaultTextStyle6 = TypographyKt.getDefaultTextStyle();
            textStyleM4723copyv2rsoow6 = defaultTextStyle6.m4723copyv2rsoow((16252927 & 1) != 0 ? defaultTextStyle6.spanStyle.m4664getColor0d7_KjU() : 0L, (16252927 & 2) != 0 ? defaultTextStyle6.spanStyle.m4665getFontSizeXSAIIZE() : TextUnitKt.getSp(20), (16252927 & 4) != 0 ? defaultTextStyle6.spanStyle.getFontWeight() : FontWeight.Companion.getMedium(), (16252927 & 8) != 0 ? defaultTextStyle6.spanStyle.m4666getFontStyle4Lr2A7w() : null, (16252927 & 16) != 0 ? defaultTextStyle6.spanStyle.m4667getFontSynthesisZQGJjVo() : null, (16252927 & 32) != 0 ? defaultTextStyle6.spanStyle.getFontFamily() : null, (16252927 & 64) != 0 ? defaultTextStyle6.spanStyle.getFontFeatureSettings() : null, (16252927 & 128) != 0 ? defaultTextStyle6.spanStyle.m4668getLetterSpacingXSAIIZE() : TextUnitKt.getSp(0.15d), (16252927 & 256) != 0 ? defaultTextStyle6.spanStyle.m4663getBaselineShift5SSeXJ0() : null, (16252927 & 512) != 0 ? defaultTextStyle6.spanStyle.getTextGeometricTransform() : null, (16252927 & 1024) != 0 ? defaultTextStyle6.spanStyle.getLocaleList() : null, (16252927 & 2048) != 0 ? defaultTextStyle6.spanStyle.m4662getBackground0d7_KjU() : 0L, (16252927 & 4096) != 0 ? defaultTextStyle6.spanStyle.getTextDecoration() : null, (16252927 & 8192) != 0 ? defaultTextStyle6.spanStyle.getShadow() : null, (16252927 & 16384) != 0 ? defaultTextStyle6.spanStyle.getDrawStyle() : null, (16252927 & 32768) != 0 ? defaultTextStyle6.paragraphStyle.m4620getTextAlignbuA522U() : null, (16252927 & 65536) != 0 ? defaultTextStyle6.paragraphStyle.m4622getTextDirectionmmuk1to() : null, (16252927 & 131072) != 0 ? defaultTextStyle6.paragraphStyle.m4619getLineHeightXSAIIZE() : 0L, (16252927 & 262144) != 0 ? defaultTextStyle6.paragraphStyle.getTextIndent() : null, (16252927 & 524288) != 0 ? defaultTextStyle6.platformStyle : null, (16252927 & 1048576) != 0 ? defaultTextStyle6.paragraphStyle.getLineHeightStyle() : null, (16252927 & 2097152) != 0 ? defaultTextStyle6.paragraphStyle.m4617getLineBreakLgCVezo() : null, (16252927 & 4194304) != 0 ? defaultTextStyle6.paragraphStyle.m4615getHyphensEaSxIns() : null, (16252927 & 8388608) != 0 ? defaultTextStyle6.paragraphStyle.getTextMotion() : null);
        } else {
            textStyleM4723copyv2rsoow6 = textStyle6;
        }
        if ((i & 128) != 0) {
            TextStyle defaultTextStyle7 = TypographyKt.getDefaultTextStyle();
            textStyleM4723copyv2rsoow7 = defaultTextStyle7.m4723copyv2rsoow((16252927 & 1) != 0 ? defaultTextStyle7.spanStyle.m4664getColor0d7_KjU() : 0L, (16252927 & 2) != 0 ? defaultTextStyle7.spanStyle.m4665getFontSizeXSAIIZE() : TextUnitKt.getSp(16), (16252927 & 4) != 0 ? defaultTextStyle7.spanStyle.getFontWeight() : FontWeight.Companion.getNormal(), (16252927 & 8) != 0 ? defaultTextStyle7.spanStyle.m4666getFontStyle4Lr2A7w() : null, (16252927 & 16) != 0 ? defaultTextStyle7.spanStyle.m4667getFontSynthesisZQGJjVo() : null, (16252927 & 32) != 0 ? defaultTextStyle7.spanStyle.getFontFamily() : null, (16252927 & 64) != 0 ? defaultTextStyle7.spanStyle.getFontFeatureSettings() : null, (16252927 & 128) != 0 ? defaultTextStyle7.spanStyle.m4668getLetterSpacingXSAIIZE() : TextUnitKt.getSp(0.15d), (16252927 & 256) != 0 ? defaultTextStyle7.spanStyle.m4663getBaselineShift5SSeXJ0() : null, (16252927 & 512) != 0 ? defaultTextStyle7.spanStyle.getTextGeometricTransform() : null, (16252927 & 1024) != 0 ? defaultTextStyle7.spanStyle.getLocaleList() : null, (16252927 & 2048) != 0 ? defaultTextStyle7.spanStyle.m4662getBackground0d7_KjU() : 0L, (16252927 & 4096) != 0 ? defaultTextStyle7.spanStyle.getTextDecoration() : null, (16252927 & 8192) != 0 ? defaultTextStyle7.spanStyle.getShadow() : null, (16252927 & 16384) != 0 ? defaultTextStyle7.spanStyle.getDrawStyle() : null, (16252927 & 32768) != 0 ? defaultTextStyle7.paragraphStyle.m4620getTextAlignbuA522U() : null, (16252927 & 65536) != 0 ? defaultTextStyle7.paragraphStyle.m4622getTextDirectionmmuk1to() : null, (16252927 & 131072) != 0 ? defaultTextStyle7.paragraphStyle.m4619getLineHeightXSAIIZE() : 0L, (16252927 & 262144) != 0 ? defaultTextStyle7.paragraphStyle.getTextIndent() : null, (16252927 & 524288) != 0 ? defaultTextStyle7.platformStyle : null, (16252927 & 1048576) != 0 ? defaultTextStyle7.paragraphStyle.getLineHeightStyle() : null, (16252927 & 2097152) != 0 ? defaultTextStyle7.paragraphStyle.m4617getLineBreakLgCVezo() : null, (16252927 & 4194304) != 0 ? defaultTextStyle7.paragraphStyle.m4615getHyphensEaSxIns() : null, (16252927 & 8388608) != 0 ? defaultTextStyle7.paragraphStyle.getTextMotion() : null);
        } else {
            textStyleM4723copyv2rsoow7 = textStyle7;
        }
        if ((i & 256) != 0) {
            TextStyle defaultTextStyle8 = TypographyKt.getDefaultTextStyle();
            textStyleM4723copyv2rsoow8 = defaultTextStyle8.m4723copyv2rsoow((16252927 & 1) != 0 ? defaultTextStyle8.spanStyle.m4664getColor0d7_KjU() : 0L, (16252927 & 2) != 0 ? defaultTextStyle8.spanStyle.m4665getFontSizeXSAIIZE() : TextUnitKt.getSp(14), (16252927 & 4) != 0 ? defaultTextStyle8.spanStyle.getFontWeight() : FontWeight.Companion.getMedium(), (16252927 & 8) != 0 ? defaultTextStyle8.spanStyle.m4666getFontStyle4Lr2A7w() : null, (16252927 & 16) != 0 ? defaultTextStyle8.spanStyle.m4667getFontSynthesisZQGJjVo() : null, (16252927 & 32) != 0 ? defaultTextStyle8.spanStyle.getFontFamily() : null, (16252927 & 64) != 0 ? defaultTextStyle8.spanStyle.getFontFeatureSettings() : null, (16252927 & 128) != 0 ? defaultTextStyle8.spanStyle.m4668getLetterSpacingXSAIIZE() : TextUnitKt.getSp(0.1d), (16252927 & 256) != 0 ? defaultTextStyle8.spanStyle.m4663getBaselineShift5SSeXJ0() : null, (16252927 & 512) != 0 ? defaultTextStyle8.spanStyle.getTextGeometricTransform() : null, (16252927 & 1024) != 0 ? defaultTextStyle8.spanStyle.getLocaleList() : null, (16252927 & 2048) != 0 ? defaultTextStyle8.spanStyle.m4662getBackground0d7_KjU() : 0L, (16252927 & 4096) != 0 ? defaultTextStyle8.spanStyle.getTextDecoration() : null, (16252927 & 8192) != 0 ? defaultTextStyle8.spanStyle.getShadow() : null, (16252927 & 16384) != 0 ? defaultTextStyle8.spanStyle.getDrawStyle() : null, (16252927 & 32768) != 0 ? defaultTextStyle8.paragraphStyle.m4620getTextAlignbuA522U() : null, (16252927 & 65536) != 0 ? defaultTextStyle8.paragraphStyle.m4622getTextDirectionmmuk1to() : null, (16252927 & 131072) != 0 ? defaultTextStyle8.paragraphStyle.m4619getLineHeightXSAIIZE() : 0L, (16252927 & 262144) != 0 ? defaultTextStyle8.paragraphStyle.getTextIndent() : null, (16252927 & 524288) != 0 ? defaultTextStyle8.platformStyle : null, (16252927 & 1048576) != 0 ? defaultTextStyle8.paragraphStyle.getLineHeightStyle() : null, (16252927 & 2097152) != 0 ? defaultTextStyle8.paragraphStyle.m4617getLineBreakLgCVezo() : null, (16252927 & 4194304) != 0 ? defaultTextStyle8.paragraphStyle.m4615getHyphensEaSxIns() : null, (16252927 & 8388608) != 0 ? defaultTextStyle8.paragraphStyle.getTextMotion() : null);
        } else {
            textStyleM4723copyv2rsoow8 = textStyle8;
        }
        if ((i & 512) != 0) {
            TextStyle defaultTextStyle9 = TypographyKt.getDefaultTextStyle();
            textStyleM4723copyv2rsoow9 = defaultTextStyle9.m4723copyv2rsoow((16252927 & 1) != 0 ? defaultTextStyle9.spanStyle.m4664getColor0d7_KjU() : 0L, (16252927 & 2) != 0 ? defaultTextStyle9.spanStyle.m4665getFontSizeXSAIIZE() : TextUnitKt.getSp(16), (16252927 & 4) != 0 ? defaultTextStyle9.spanStyle.getFontWeight() : FontWeight.Companion.getNormal(), (16252927 & 8) != 0 ? defaultTextStyle9.spanStyle.m4666getFontStyle4Lr2A7w() : null, (16252927 & 16) != 0 ? defaultTextStyle9.spanStyle.m4667getFontSynthesisZQGJjVo() : null, (16252927 & 32) != 0 ? defaultTextStyle9.spanStyle.getFontFamily() : null, (16252927 & 64) != 0 ? defaultTextStyle9.spanStyle.getFontFeatureSettings() : null, (16252927 & 128) != 0 ? defaultTextStyle9.spanStyle.m4668getLetterSpacingXSAIIZE() : TextUnitKt.getSp(0.5d), (16252927 & 256) != 0 ? defaultTextStyle9.spanStyle.m4663getBaselineShift5SSeXJ0() : null, (16252927 & 512) != 0 ? defaultTextStyle9.spanStyle.getTextGeometricTransform() : null, (16252927 & 1024) != 0 ? defaultTextStyle9.spanStyle.getLocaleList() : null, (16252927 & 2048) != 0 ? defaultTextStyle9.spanStyle.m4662getBackground0d7_KjU() : 0L, (16252927 & 4096) != 0 ? defaultTextStyle9.spanStyle.getTextDecoration() : null, (16252927 & 8192) != 0 ? defaultTextStyle9.spanStyle.getShadow() : null, (16252927 & 16384) != 0 ? defaultTextStyle9.spanStyle.getDrawStyle() : null, (16252927 & 32768) != 0 ? defaultTextStyle9.paragraphStyle.m4620getTextAlignbuA522U() : null, (16252927 & 65536) != 0 ? defaultTextStyle9.paragraphStyle.m4622getTextDirectionmmuk1to() : null, (16252927 & 131072) != 0 ? defaultTextStyle9.paragraphStyle.m4619getLineHeightXSAIIZE() : 0L, (16252927 & 262144) != 0 ? defaultTextStyle9.paragraphStyle.getTextIndent() : null, (16252927 & 524288) != 0 ? defaultTextStyle9.platformStyle : null, (16252927 & 1048576) != 0 ? defaultTextStyle9.paragraphStyle.getLineHeightStyle() : null, (16252927 & 2097152) != 0 ? defaultTextStyle9.paragraphStyle.m4617getLineBreakLgCVezo() : null, (16252927 & 4194304) != 0 ? defaultTextStyle9.paragraphStyle.m4615getHyphensEaSxIns() : null, (16252927 & 8388608) != 0 ? defaultTextStyle9.paragraphStyle.getTextMotion() : null);
        } else {
            textStyleM4723copyv2rsoow9 = textStyle9;
        }
        if ((i & 1024) != 0) {
            TextStyle defaultTextStyle10 = TypographyKt.getDefaultTextStyle();
            textStyleM4723copyv2rsoow10 = defaultTextStyle10.m4723copyv2rsoow((16252927 & 1) != 0 ? defaultTextStyle10.spanStyle.m4664getColor0d7_KjU() : 0L, (16252927 & 2) != 0 ? defaultTextStyle10.spanStyle.m4665getFontSizeXSAIIZE() : TextUnitKt.getSp(14), (16252927 & 4) != 0 ? defaultTextStyle10.spanStyle.getFontWeight() : FontWeight.Companion.getNormal(), (16252927 & 8) != 0 ? defaultTextStyle10.spanStyle.m4666getFontStyle4Lr2A7w() : null, (16252927 & 16) != 0 ? defaultTextStyle10.spanStyle.m4667getFontSynthesisZQGJjVo() : null, (16252927 & 32) != 0 ? defaultTextStyle10.spanStyle.getFontFamily() : null, (16252927 & 64) != 0 ? defaultTextStyle10.spanStyle.getFontFeatureSettings() : null, (16252927 & 128) != 0 ? defaultTextStyle10.spanStyle.m4668getLetterSpacingXSAIIZE() : TextUnitKt.getSp(0.25d), (16252927 & 256) != 0 ? defaultTextStyle10.spanStyle.m4663getBaselineShift5SSeXJ0() : null, (16252927 & 512) != 0 ? defaultTextStyle10.spanStyle.getTextGeometricTransform() : null, (16252927 & 1024) != 0 ? defaultTextStyle10.spanStyle.getLocaleList() : null, (16252927 & 2048) != 0 ? defaultTextStyle10.spanStyle.m4662getBackground0d7_KjU() : 0L, (16252927 & 4096) != 0 ? defaultTextStyle10.spanStyle.getTextDecoration() : null, (16252927 & 8192) != 0 ? defaultTextStyle10.spanStyle.getShadow() : null, (16252927 & 16384) != 0 ? defaultTextStyle10.spanStyle.getDrawStyle() : null, (16252927 & 32768) != 0 ? defaultTextStyle10.paragraphStyle.m4620getTextAlignbuA522U() : null, (16252927 & 65536) != 0 ? defaultTextStyle10.paragraphStyle.m4622getTextDirectionmmuk1to() : null, (16252927 & 131072) != 0 ? defaultTextStyle10.paragraphStyle.m4619getLineHeightXSAIIZE() : 0L, (16252927 & 262144) != 0 ? defaultTextStyle10.paragraphStyle.getTextIndent() : null, (16252927 & 524288) != 0 ? defaultTextStyle10.platformStyle : null, (16252927 & 1048576) != 0 ? defaultTextStyle10.paragraphStyle.getLineHeightStyle() : null, (16252927 & 2097152) != 0 ? defaultTextStyle10.paragraphStyle.m4617getLineBreakLgCVezo() : null, (16252927 & 4194304) != 0 ? defaultTextStyle10.paragraphStyle.m4615getHyphensEaSxIns() : null, (16252927 & 8388608) != 0 ? defaultTextStyle10.paragraphStyle.getTextMotion() : null);
        } else {
            textStyleM4723copyv2rsoow10 = textStyle10;
        }
        if ((i & 2048) != 0) {
            TextStyle defaultTextStyle11 = TypographyKt.getDefaultTextStyle();
            textStyleM4723copyv2rsoow11 = defaultTextStyle11.m4723copyv2rsoow((16252927 & 1) != 0 ? defaultTextStyle11.spanStyle.m4664getColor0d7_KjU() : 0L, (16252927 & 2) != 0 ? defaultTextStyle11.spanStyle.m4665getFontSizeXSAIIZE() : TextUnitKt.getSp(14), (16252927 & 4) != 0 ? defaultTextStyle11.spanStyle.getFontWeight() : FontWeight.Companion.getMedium(), (16252927 & 8) != 0 ? defaultTextStyle11.spanStyle.m4666getFontStyle4Lr2A7w() : null, (16252927 & 16) != 0 ? defaultTextStyle11.spanStyle.m4667getFontSynthesisZQGJjVo() : null, (16252927 & 32) != 0 ? defaultTextStyle11.spanStyle.getFontFamily() : null, (16252927 & 64) != 0 ? defaultTextStyle11.spanStyle.getFontFeatureSettings() : null, (16252927 & 128) != 0 ? defaultTextStyle11.spanStyle.m4668getLetterSpacingXSAIIZE() : TextUnitKt.getSp(1.25d), (16252927 & 256) != 0 ? defaultTextStyle11.spanStyle.m4663getBaselineShift5SSeXJ0() : null, (16252927 & 512) != 0 ? defaultTextStyle11.spanStyle.getTextGeometricTransform() : null, (16252927 & 1024) != 0 ? defaultTextStyle11.spanStyle.getLocaleList() : null, (16252927 & 2048) != 0 ? defaultTextStyle11.spanStyle.m4662getBackground0d7_KjU() : 0L, (16252927 & 4096) != 0 ? defaultTextStyle11.spanStyle.getTextDecoration() : null, (16252927 & 8192) != 0 ? defaultTextStyle11.spanStyle.getShadow() : null, (16252927 & 16384) != 0 ? defaultTextStyle11.spanStyle.getDrawStyle() : null, (16252927 & 32768) != 0 ? defaultTextStyle11.paragraphStyle.m4620getTextAlignbuA522U() : null, (16252927 & 65536) != 0 ? defaultTextStyle11.paragraphStyle.m4622getTextDirectionmmuk1to() : null, (16252927 & 131072) != 0 ? defaultTextStyle11.paragraphStyle.m4619getLineHeightXSAIIZE() : 0L, (16252927 & 262144) != 0 ? defaultTextStyle11.paragraphStyle.getTextIndent() : null, (16252927 & 524288) != 0 ? defaultTextStyle11.platformStyle : null, (16252927 & 1048576) != 0 ? defaultTextStyle11.paragraphStyle.getLineHeightStyle() : null, (16252927 & 2097152) != 0 ? defaultTextStyle11.paragraphStyle.m4617getLineBreakLgCVezo() : null, (16252927 & 4194304) != 0 ? defaultTextStyle11.paragraphStyle.m4615getHyphensEaSxIns() : null, (16252927 & 8388608) != 0 ? defaultTextStyle11.paragraphStyle.getTextMotion() : null);
        } else {
            textStyleM4723copyv2rsoow11 = textStyle11;
        }
        if ((i & 4096) != 0) {
            TextStyle defaultTextStyle12 = TypographyKt.getDefaultTextStyle();
            textStyleM4723copyv2rsoow12 = defaultTextStyle12.m4723copyv2rsoow((16252927 & 1) != 0 ? defaultTextStyle12.spanStyle.m4664getColor0d7_KjU() : 0L, (16252927 & 2) != 0 ? defaultTextStyle12.spanStyle.m4665getFontSizeXSAIIZE() : TextUnitKt.getSp(12), (16252927 & 4) != 0 ? defaultTextStyle12.spanStyle.getFontWeight() : FontWeight.Companion.getNormal(), (16252927 & 8) != 0 ? defaultTextStyle12.spanStyle.m4666getFontStyle4Lr2A7w() : null, (16252927 & 16) != 0 ? defaultTextStyle12.spanStyle.m4667getFontSynthesisZQGJjVo() : null, (16252927 & 32) != 0 ? defaultTextStyle12.spanStyle.getFontFamily() : null, (16252927 & 64) != 0 ? defaultTextStyle12.spanStyle.getFontFeatureSettings() : null, (16252927 & 128) != 0 ? defaultTextStyle12.spanStyle.m4668getLetterSpacingXSAIIZE() : TextUnitKt.getSp(0.4d), (16252927 & 256) != 0 ? defaultTextStyle12.spanStyle.m4663getBaselineShift5SSeXJ0() : null, (16252927 & 512) != 0 ? defaultTextStyle12.spanStyle.getTextGeometricTransform() : null, (16252927 & 1024) != 0 ? defaultTextStyle12.spanStyle.getLocaleList() : null, (16252927 & 2048) != 0 ? defaultTextStyle12.spanStyle.m4662getBackground0d7_KjU() : 0L, (16252927 & 4096) != 0 ? defaultTextStyle12.spanStyle.getTextDecoration() : null, (16252927 & 8192) != 0 ? defaultTextStyle12.spanStyle.getShadow() : null, (16252927 & 16384) != 0 ? defaultTextStyle12.spanStyle.getDrawStyle() : null, (16252927 & 32768) != 0 ? defaultTextStyle12.paragraphStyle.m4620getTextAlignbuA522U() : null, (16252927 & 65536) != 0 ? defaultTextStyle12.paragraphStyle.m4622getTextDirectionmmuk1to() : null, (16252927 & 131072) != 0 ? defaultTextStyle12.paragraphStyle.m4619getLineHeightXSAIIZE() : 0L, (16252927 & 262144) != 0 ? defaultTextStyle12.paragraphStyle.getTextIndent() : null, (16252927 & 524288) != 0 ? defaultTextStyle12.platformStyle : null, (16252927 & 1048576) != 0 ? defaultTextStyle12.paragraphStyle.getLineHeightStyle() : null, (16252927 & 2097152) != 0 ? defaultTextStyle12.paragraphStyle.m4617getLineBreakLgCVezo() : null, (16252927 & 4194304) != 0 ? defaultTextStyle12.paragraphStyle.m4615getHyphensEaSxIns() : null, (16252927 & 8388608) != 0 ? defaultTextStyle12.paragraphStyle.getTextMotion() : null);
        } else {
            textStyleM4723copyv2rsoow12 = textStyle12;
        }
        if ((i & 8192) != 0) {
            TextStyle defaultTextStyle13 = TypographyKt.getDefaultTextStyle();
            textStyleM4723copyv2rsoow13 = defaultTextStyle13.m4723copyv2rsoow((16252927 & 1) != 0 ? defaultTextStyle13.spanStyle.m4664getColor0d7_KjU() : 0L, (16252927 & 2) != 0 ? defaultTextStyle13.spanStyle.m4665getFontSizeXSAIIZE() : TextUnitKt.getSp(10), (16252927 & 4) != 0 ? defaultTextStyle13.spanStyle.getFontWeight() : FontWeight.Companion.getNormal(), (16252927 & 8) != 0 ? defaultTextStyle13.spanStyle.m4666getFontStyle4Lr2A7w() : null, (16252927 & 16) != 0 ? defaultTextStyle13.spanStyle.m4667getFontSynthesisZQGJjVo() : null, (16252927 & 32) != 0 ? defaultTextStyle13.spanStyle.getFontFamily() : null, (16252927 & 64) != 0 ? defaultTextStyle13.spanStyle.getFontFeatureSettings() : null, (16252927 & 128) != 0 ? defaultTextStyle13.spanStyle.m4668getLetterSpacingXSAIIZE() : TextUnitKt.getSp(1.5d), (16252927 & 256) != 0 ? defaultTextStyle13.spanStyle.m4663getBaselineShift5SSeXJ0() : null, (16252927 & 512) != 0 ? defaultTextStyle13.spanStyle.getTextGeometricTransform() : null, (16252927 & 1024) != 0 ? defaultTextStyle13.spanStyle.getLocaleList() : null, (16252927 & 2048) != 0 ? defaultTextStyle13.spanStyle.m4662getBackground0d7_KjU() : 0L, (16252927 & 4096) != 0 ? defaultTextStyle13.spanStyle.getTextDecoration() : null, (16252927 & 8192) != 0 ? defaultTextStyle13.spanStyle.getShadow() : null, (16252927 & 16384) != 0 ? defaultTextStyle13.spanStyle.getDrawStyle() : null, (16252927 & 32768) != 0 ? defaultTextStyle13.paragraphStyle.m4620getTextAlignbuA522U() : null, (16252927 & 65536) != 0 ? defaultTextStyle13.paragraphStyle.m4622getTextDirectionmmuk1to() : null, (16252927 & 131072) != 0 ? defaultTextStyle13.paragraphStyle.m4619getLineHeightXSAIIZE() : 0L, (16252927 & 262144) != 0 ? defaultTextStyle13.paragraphStyle.getTextIndent() : null, (16252927 & 524288) != 0 ? defaultTextStyle13.platformStyle : null, (16252927 & 1048576) != 0 ? defaultTextStyle13.paragraphStyle.getLineHeightStyle() : null, (16252927 & 2097152) != 0 ? defaultTextStyle13.paragraphStyle.m4617getLineBreakLgCVezo() : null, (16252927 & 4194304) != 0 ? defaultTextStyle13.paragraphStyle.m4615getHyphensEaSxIns() : null, (16252927 & 8388608) != 0 ? defaultTextStyle13.paragraphStyle.getTextMotion() : null);
        } else {
            textStyleM4723copyv2rsoow13 = textStyle13;
        }
        this(fontFamily2, textStyleM4723copyv2rsoow, textStyleM4723copyv2rsoow2, textStyleM4723copyv2rsoow3, textStyleM4723copyv2rsoow4, textStyleM4723copyv2rsoow5, textStyleM4723copyv2rsoow6, textStyleM4723copyv2rsoow7, textStyleM4723copyv2rsoow8, textStyleM4723copyv2rsoow9, textStyleM4723copyv2rsoow10, textStyleM4723copyv2rsoow11, textStyleM4723copyv2rsoow12, textStyleM4723copyv2rsoow13);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Typography(FontFamily fontFamily, TextStyle textStyle, TextStyle textStyle2, TextStyle textStyle3, TextStyle textStyle4, TextStyle textStyle5, TextStyle textStyle6, TextStyle textStyle7, TextStyle textStyle8, TextStyle textStyle9, TextStyle textStyle10, TextStyle textStyle11, TextStyle textStyle12, TextStyle textStyle13) {
        this(TypographyKt.withDefaultFontFamily(textStyle, fontFamily), TypographyKt.withDefaultFontFamily(textStyle2, fontFamily), TypographyKt.withDefaultFontFamily(textStyle3, fontFamily), TypographyKt.withDefaultFontFamily(textStyle4, fontFamily), TypographyKt.withDefaultFontFamily(textStyle5, fontFamily), TypographyKt.withDefaultFontFamily(textStyle6, fontFamily), TypographyKt.withDefaultFontFamily(textStyle7, fontFamily), TypographyKt.withDefaultFontFamily(textStyle8, fontFamily), TypographyKt.withDefaultFontFamily(textStyle9, fontFamily), TypographyKt.withDefaultFontFamily(textStyle10, fontFamily), TypographyKt.withDefaultFontFamily(textStyle11, fontFamily), TypographyKt.withDefaultFontFamily(textStyle12, fontFamily), TypographyKt.withDefaultFontFamily(textStyle13, fontFamily));
        AbstractC4492zt.h(fontFamily, "defaultFontFamily");
        AbstractC4492zt.h(textStyle, "h1");
        AbstractC4492zt.h(textStyle2, "h2");
        AbstractC4492zt.h(textStyle3, "h3");
        AbstractC4492zt.h(textStyle4, "h4");
        AbstractC4492zt.h(textStyle5, "h5");
        AbstractC4492zt.h(textStyle6, "h6");
        AbstractC4492zt.h(textStyle7, "subtitle1");
        AbstractC4492zt.h(textStyle8, "subtitle2");
        AbstractC4492zt.h(textStyle9, "body1");
        AbstractC4492zt.h(textStyle10, "body2");
        AbstractC4492zt.h(textStyle11, HTML.Tag.BUTTON);
        AbstractC4492zt.h(textStyle12, HTML.Tag.CAPTION);
        AbstractC4492zt.h(textStyle13, "overline");
    }
}
