package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.ShadowKt;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.FontWeightKt;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.BaselineShiftKt;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDrawStyleKt;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextGeometricTransformKt;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class SpanStyleKt {
    private static final long DefaultBackgroundColor;
    private static final long DefaultColor;
    private static final long DefaultFontSize = TextUnitKt.getSp(14);
    private static final long DefaultLetterSpacing = TextUnitKt.getSp(0);

    /* JADX INFO: renamed from: androidx.compose.ui.text.SpanStyleKt$resolveSpanStyleDefaults$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3588op {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0);
        }

        @Override // defpackage.InterfaceC3588op
        public final TextForegroundStyle invoke() {
            return TextForegroundStyle.Companion.m5085from8_81llA(SpanStyleKt.DefaultColor);
        }
    }

    static {
        Color.Companion companion = Color.Companion;
        DefaultBackgroundColor = companion.m3067getTransparent0d7_KjU();
        DefaultColor = companion.m3058getBlack0d7_KjU();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0034  */
    /* JADX INFO: renamed from: fastMerge-dSHsh3o, reason: not valid java name */
    public static final SpanStyle m4669fastMergedSHsh3o(SpanStyle spanStyle, long j, Brush brush, float f, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle) {
        TextGeometricTransform textGeometricTransform2;
        Shadow shadow2;
        PlatformSpanStyle platformSpanStyle2;
        DrawStyle drawStyle2;
        FontWeight fontWeight2 = fontWeight;
        FontStyle fontStyleM4666getFontStyle4Lr2A7w = fontStyle;
        FontSynthesis fontSynthesisM4667getFontSynthesisZQGJjVo = fontSynthesis;
        String fontFeatureSettings = str;
        BaselineShift baselineShiftM4663getBaselineShift5SSeXJ0 = baselineShift;
        AbstractC4492zt.h(spanStyle, "$this$fastMerge");
        if (!TextUnitKt.m5359isUnspecifiedR2X_6o(j2) && !TextUnit.m5338equalsimpl0(j2, spanStyle.m4665getFontSizeXSAIIZE())) {
            textGeometricTransform2 = textGeometricTransform;
            shadow2 = shadow;
            platformSpanStyle2 = platformSpanStyle;
            drawStyle2 = drawStyle;
        } else if ((brush != null || j == Color.Companion.m3068getUnspecified0d7_KjU() || Color.m3033equalsimpl0(j, spanStyle.getTextForegroundStyle$ui_text_release().mo4973getColor0d7_KjU())) && ((fontStyleM4666getFontStyle4Lr2A7w == null || AbstractC4492zt.d(fontStyleM4666getFontStyle4Lr2A7w, spanStyle.m4666getFontStyle4Lr2A7w())) && ((fontWeight2 == null || AbstractC4492zt.d(fontWeight2, spanStyle.getFontWeight())) && ((fontFamily == null || fontFamily == spanStyle.getFontFamily()) && (TextUnitKt.m5359isUnspecifiedR2X_6o(j3) || TextUnit.m5338equalsimpl0(j3, spanStyle.m4668getLetterSpacingXSAIIZE())))))) {
            if ((textDecoration == null || AbstractC4492zt.d(textDecoration, spanStyle.getTextDecoration())) && AbstractC4492zt.d(brush, spanStyle.getTextForegroundStyle$ui_text_release().getBrush()) && ((brush == null || f == spanStyle.getTextForegroundStyle$ui_text_release().getAlpha()) && ((fontSynthesisM4667getFontSynthesisZQGJjVo == null || AbstractC4492zt.d(fontSynthesisM4667getFontSynthesisZQGJjVo, spanStyle.m4667getFontSynthesisZQGJjVo())) && ((fontFeatureSettings == null || AbstractC4492zt.d(fontFeatureSettings, spanStyle.getFontFeatureSettings())) && (baselineShiftM4663getBaselineShift5SSeXJ0 == null || AbstractC4492zt.d(baselineShiftM4663getBaselineShift5SSeXJ0, spanStyle.m4663getBaselineShift5SSeXJ0())))))) {
                textGeometricTransform2 = textGeometricTransform;
                if ((textGeometricTransform2 == null || AbstractC4492zt.d(textGeometricTransform2, spanStyle.getTextGeometricTransform())) && ((localeList == null || AbstractC4492zt.d(localeList, spanStyle.getLocaleList())) && (j4 == Color.Companion.m3068getUnspecified0d7_KjU() || Color.m3033equalsimpl0(j4, spanStyle.m4662getBackground0d7_KjU())))) {
                    shadow2 = shadow;
                    if (shadow2 == null || AbstractC4492zt.d(shadow2, spanStyle.getShadow())) {
                        platformSpanStyle2 = platformSpanStyle;
                        if (platformSpanStyle2 == null || AbstractC4492zt.d(platformSpanStyle2, spanStyle.getPlatformStyle())) {
                            drawStyle2 = drawStyle;
                            if (drawStyle2 == null || AbstractC4492zt.d(drawStyle2, spanStyle.getDrawStyle())) {
                                return spanStyle;
                            }
                        }
                    }
                    drawStyle2 = drawStyle;
                }
                platformSpanStyle2 = platformSpanStyle;
                drawStyle2 = drawStyle;
            } else {
                textGeometricTransform2 = textGeometricTransform;
            }
            shadow2 = shadow;
            platformSpanStyle2 = platformSpanStyle;
            drawStyle2 = drawStyle;
        } else {
            textGeometricTransform2 = textGeometricTransform;
            shadow2 = shadow;
            platformSpanStyle2 = platformSpanStyle;
            drawStyle2 = drawStyle;
        }
        TextForegroundStyle textForegroundStyleMerge = spanStyle.getTextForegroundStyle$ui_text_release().merge(brush != null ? TextForegroundStyle.Companion.from(brush, f) : TextForegroundStyle.Companion.m5085from8_81llA(j));
        FontFamily fontFamily2 = fontFamily == null ? spanStyle.getFontFamily() : fontFamily;
        long jM4665getFontSizeXSAIIZE = !TextUnitKt.m5359isUnspecifiedR2X_6o(j2) ? j2 : spanStyle.m4665getFontSizeXSAIIZE();
        if (fontWeight2 == null) {
            fontWeight2 = spanStyle.getFontWeight();
        }
        if (fontStyleM4666getFontStyle4Lr2A7w == null) {
            fontStyleM4666getFontStyle4Lr2A7w = spanStyle.m4666getFontStyle4Lr2A7w();
        }
        if (fontSynthesisM4667getFontSynthesisZQGJjVo == null) {
            fontSynthesisM4667getFontSynthesisZQGJjVo = spanStyle.m4667getFontSynthesisZQGJjVo();
        }
        if (fontFeatureSettings == null) {
            fontFeatureSettings = spanStyle.getFontFeatureSettings();
        }
        long jM4668getLetterSpacingXSAIIZE = !TextUnitKt.m5359isUnspecifiedR2X_6o(j3) ? j3 : spanStyle.m4668getLetterSpacingXSAIIZE();
        if (baselineShiftM4663getBaselineShift5SSeXJ0 == null) {
            baselineShiftM4663getBaselineShift5SSeXJ0 = spanStyle.m4663getBaselineShift5SSeXJ0();
        }
        if (textGeometricTransform2 == null) {
            textGeometricTransform2 = spanStyle.getTextGeometricTransform();
        }
        LocaleList localeList2 = localeList == null ? spanStyle.getLocaleList() : localeList;
        long jM4662getBackground0d7_KjU = j4 != Color.Companion.m3068getUnspecified0d7_KjU() ? j4 : spanStyle.m4662getBackground0d7_KjU();
        TextDecoration textDecoration2 = textDecoration == null ? spanStyle.getTextDecoration() : textDecoration;
        if (shadow2 == null) {
            shadow2 = spanStyle.getShadow();
        }
        PlatformSpanStyle platformSpanStyleMergePlatformStyle = mergePlatformStyle(spanStyle, platformSpanStyle2);
        if (drawStyle2 == null) {
            drawStyle2 = spanStyle.getDrawStyle();
        }
        return new SpanStyle(textForegroundStyleMerge, jM4665getFontSizeXSAIIZE, fontWeight2, fontStyleM4666getFontStyle4Lr2A7w, fontSynthesisM4667getFontSynthesisZQGJjVo, fontFamily2, fontFeatureSettings, jM4668getLetterSpacingXSAIIZE, baselineShiftM4663getBaselineShift5SSeXJ0, textGeometricTransform2, localeList2, jM4662getBackground0d7_KjU, textDecoration2, shadow2, platformSpanStyleMergePlatformStyle, drawStyle2, (AbstractC0419Di) null);
    }

    public static final SpanStyle lerp(SpanStyle spanStyle, SpanStyle spanStyle2, float f) {
        AbstractC4492zt.h(spanStyle, HTML.Attribute.START);
        AbstractC4492zt.h(spanStyle2, "stop");
        TextForegroundStyle textForegroundStyleLerp = TextDrawStyleKt.lerp(spanStyle.getTextForegroundStyle$ui_text_release(), spanStyle2.getTextForegroundStyle$ui_text_release(), f);
        FontFamily fontFamily = (FontFamily) lerpDiscrete(spanStyle.getFontFamily(), spanStyle2.getFontFamily(), f);
        long jM4670lerpTextUnitInheritableC3pnCVY = m4670lerpTextUnitInheritableC3pnCVY(spanStyle.m4665getFontSizeXSAIIZE(), spanStyle2.m4665getFontSizeXSAIIZE(), f);
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight == null) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        FontWeight fontWeight2 = spanStyle2.getFontWeight();
        if (fontWeight2 == null) {
            fontWeight2 = FontWeight.Companion.getNormal();
        }
        FontWeight fontWeightLerp = FontWeightKt.lerp(fontWeight, fontWeight2, f);
        FontStyle fontStyle = (FontStyle) lerpDiscrete(spanStyle.m4666getFontStyle4Lr2A7w(), spanStyle2.m4666getFontStyle4Lr2A7w(), f);
        FontSynthesis fontSynthesis = (FontSynthesis) lerpDiscrete(spanStyle.m4667getFontSynthesisZQGJjVo(), spanStyle2.m4667getFontSynthesisZQGJjVo(), f);
        String str = (String) lerpDiscrete(spanStyle.getFontFeatureSettings(), spanStyle2.getFontFeatureSettings(), f);
        long jM4670lerpTextUnitInheritableC3pnCVY2 = m4670lerpTextUnitInheritableC3pnCVY(spanStyle.m4668getLetterSpacingXSAIIZE(), spanStyle2.m4668getLetterSpacingXSAIIZE(), f);
        BaselineShift baselineShiftM4663getBaselineShift5SSeXJ0 = spanStyle.m4663getBaselineShift5SSeXJ0();
        float fM4965unboximpl = baselineShiftM4663getBaselineShift5SSeXJ0 != null ? baselineShiftM4663getBaselineShift5SSeXJ0.m4965unboximpl() : BaselineShift.m4960constructorimpl(0.0f);
        BaselineShift baselineShiftM4663getBaselineShift5SSeXJ1 = spanStyle2.m4663getBaselineShift5SSeXJ0();
        float fM4972lerpjWV1Mfo = BaselineShiftKt.m4972lerpjWV1Mfo(fM4965unboximpl, baselineShiftM4663getBaselineShift5SSeXJ1 != null ? baselineShiftM4663getBaselineShift5SSeXJ1.m4965unboximpl() : BaselineShift.m4960constructorimpl(0.0f), f);
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform == null) {
            textGeometricTransform = TextGeometricTransform.Companion.getNone$ui_text_release();
        }
        TextGeometricTransform textGeometricTransform2 = spanStyle2.getTextGeometricTransform();
        if (textGeometricTransform2 == null) {
            textGeometricTransform2 = TextGeometricTransform.Companion.getNone$ui_text_release();
        }
        TextGeometricTransform textGeometricTransformLerp = TextGeometricTransformKt.lerp(textGeometricTransform, textGeometricTransform2, f);
        LocaleList localeList = (LocaleList) lerpDiscrete(spanStyle.getLocaleList(), spanStyle2.getLocaleList(), f);
        long jM3083lerpjxsXWHM = ColorKt.m3083lerpjxsXWHM(spanStyle.m4662getBackground0d7_KjU(), spanStyle2.m4662getBackground0d7_KjU(), f);
        TextDecoration textDecoration = (TextDecoration) lerpDiscrete(spanStyle.getTextDecoration(), spanStyle2.getTextDecoration(), f);
        Shadow shadow = spanStyle.getShadow();
        if (shadow == null) {
            shadow = new Shadow(0L, 0L, 0.0f, 7, null);
        }
        Shadow shadow2 = spanStyle2.getShadow();
        if (shadow2 == null) {
            shadow2 = new Shadow(0L, 0L, 0.0f, 7, null);
        }
        return new SpanStyle(textForegroundStyleLerp, jM4670lerpTextUnitInheritableC3pnCVY, fontWeightLerp, fontStyle, fontSynthesis, fontFamily, str, jM4670lerpTextUnitInheritableC3pnCVY2, BaselineShift.m4959boximpl(fM4972lerpjWV1Mfo), textGeometricTransformLerp, localeList, jM3083lerpjxsXWHM, textDecoration, ShadowKt.lerp(shadow, shadow2, f), lerpPlatformStyle(spanStyle.getPlatformStyle(), spanStyle2.getPlatformStyle(), f), (DrawStyle) lerpDiscrete(spanStyle.getDrawStyle(), spanStyle2.getDrawStyle(), f), (AbstractC0419Di) null);
    }

    public static final <T> T lerpDiscrete(T t, T t2, float f) {
        return ((double) f) < 0.5d ? t : t2;
    }

    private static final PlatformSpanStyle lerpPlatformStyle(PlatformSpanStyle platformSpanStyle, PlatformSpanStyle platformSpanStyle2, float f) {
        if (platformSpanStyle == null && platformSpanStyle2 == null) {
            return null;
        }
        if (platformSpanStyle == null) {
            platformSpanStyle = PlatformSpanStyle.Companion.getDefault();
        }
        if (platformSpanStyle2 == null) {
            platformSpanStyle2 = PlatformSpanStyle.Companion.getDefault();
        }
        return AndroidTextStyle_androidKt.lerp(platformSpanStyle, platformSpanStyle2, f);
    }

    /* JADX INFO: renamed from: lerpTextUnitInheritable-C3pnCVY, reason: not valid java name */
    public static final long m4670lerpTextUnitInheritableC3pnCVY(long j, long j2, float f) {
        return (TextUnitKt.m5359isUnspecifiedR2X_6o(j) || TextUnitKt.m5359isUnspecifiedR2X_6o(j2)) ? ((TextUnit) lerpDiscrete(TextUnit.m5331boximpl(j), TextUnit.m5331boximpl(j2), f)).m5350unboximpl() : TextUnitKt.m5361lerpC3pnCVY(j, j2, f);
    }

    private static final PlatformSpanStyle mergePlatformStyle(SpanStyle spanStyle, PlatformSpanStyle platformSpanStyle) {
        if (spanStyle.getPlatformStyle() == null) {
            return platformSpanStyle;
        }
        return platformSpanStyle == null ? spanStyle.getPlatformStyle() : spanStyle.getPlatformStyle().merge(platformSpanStyle);
    }

    public static final SpanStyle resolveSpanStyleDefaults(SpanStyle spanStyle) {
        AbstractC4492zt.h(spanStyle, "style");
        TextForegroundStyle textForegroundStyleTakeOrElse = spanStyle.getTextForegroundStyle$ui_text_release().takeOrElse(AnonymousClass1.INSTANCE);
        long jM4665getFontSizeXSAIIZE = TextUnitKt.m5359isUnspecifiedR2X_6o(spanStyle.m4665getFontSizeXSAIIZE()) ? DefaultFontSize : spanStyle.m4665getFontSizeXSAIIZE();
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight == null) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        FontWeight fontWeight2 = fontWeight;
        FontStyle fontStyleM4666getFontStyle4Lr2A7w = spanStyle.m4666getFontStyle4Lr2A7w();
        FontStyle fontStyleM4798boximpl = FontStyle.m4798boximpl(fontStyleM4666getFontStyle4Lr2A7w != null ? fontStyleM4666getFontStyle4Lr2A7w.m4804unboximpl() : FontStyle.Companion.m4806getNormal_LCdwA());
        FontSynthesis fontSynthesisM4667getFontSynthesisZQGJjVo = spanStyle.m4667getFontSynthesisZQGJjVo();
        FontSynthesis fontSynthesisM4807boximpl = FontSynthesis.m4807boximpl(fontSynthesisM4667getFontSynthesisZQGJjVo != null ? fontSynthesisM4667getFontSynthesisZQGJjVo.m4815unboximpl() : FontSynthesis.Companion.m4816getAllGVVA2EU());
        FontFamily fontFamily = spanStyle.getFontFamily();
        if (fontFamily == null) {
            fontFamily = FontFamily.Companion.getDefault();
        }
        FontFamily fontFamily2 = fontFamily;
        String fontFeatureSettings = spanStyle.getFontFeatureSettings();
        if (fontFeatureSettings == null) {
            fontFeatureSettings = "";
        }
        String str = fontFeatureSettings;
        long jM4668getLetterSpacingXSAIIZE = TextUnitKt.m5359isUnspecifiedR2X_6o(spanStyle.m4668getLetterSpacingXSAIIZE()) ? DefaultLetterSpacing : spanStyle.m4668getLetterSpacingXSAIIZE();
        BaselineShift baselineShiftM4663getBaselineShift5SSeXJ0 = spanStyle.m4663getBaselineShift5SSeXJ0();
        BaselineShift baselineShiftM4959boximpl = BaselineShift.m4959boximpl(baselineShiftM4663getBaselineShift5SSeXJ0 != null ? baselineShiftM4663getBaselineShift5SSeXJ0.m4965unboximpl() : BaselineShift.Companion.m4969getNoney9eOQZs());
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform == null) {
            textGeometricTransform = TextGeometricTransform.Companion.getNone$ui_text_release();
        }
        TextGeometricTransform textGeometricTransform2 = textGeometricTransform;
        LocaleList localeList = spanStyle.getLocaleList();
        if (localeList == null) {
            localeList = LocaleList.Companion.getCurrent();
        }
        LocaleList localeList2 = localeList;
        long jM4662getBackground0d7_KjU = spanStyle.m4662getBackground0d7_KjU();
        if (jM4662getBackground0d7_KjU == Color.Companion.m3068getUnspecified0d7_KjU()) {
            jM4662getBackground0d7_KjU = DefaultBackgroundColor;
        }
        long j = jM4662getBackground0d7_KjU;
        TextDecoration textDecoration = spanStyle.getTextDecoration();
        if (textDecoration == null) {
            textDecoration = TextDecoration.Companion.getNone();
        }
        TextDecoration textDecoration2 = textDecoration;
        Shadow shadow = spanStyle.getShadow();
        if (shadow == null) {
            shadow = Shadow.Companion.getNone();
        }
        Shadow shadow2 = shadow;
        PlatformSpanStyle platformStyle = spanStyle.getPlatformStyle();
        DrawStyle drawStyle = spanStyle.getDrawStyle();
        if (drawStyle == null) {
            drawStyle = Fill.INSTANCE;
        }
        return new SpanStyle(textForegroundStyleTakeOrElse, jM4665getFontSizeXSAIIZE, fontWeight2, fontStyleM4798boximpl, fontSynthesisM4807boximpl, fontFamily2, str, jM4668getLetterSpacingXSAIIZE, baselineShiftM4959boximpl, textGeometricTransform2, localeList2, j, textDecoration2, shadow2, platformStyle, drawStyle, (AbstractC0419Di) null);
    }
}
