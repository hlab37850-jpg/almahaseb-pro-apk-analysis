package androidx.compose.ui.text.platform.extensions;

import android.graphics.Typeface;
import android.os.Build;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.platform.AndroidTextPaint;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0578Hp;

/* JADX INFO: loaded from: classes.dex */
public final class TextPaintExtensions_androidKt {
    public static final SpanStyle applySpanStyle(AndroidTextPaint androidTextPaint, SpanStyle spanStyle, InterfaceC0578Hp interfaceC0578Hp, Density density, boolean z) {
        AbstractC4492zt.h(androidTextPaint, "<this>");
        AbstractC4492zt.h(spanStyle, "style");
        AbstractC4492zt.h(interfaceC0578Hp, "resolveTypeface");
        AbstractC4492zt.h(density, "density");
        long jM5340getTypeUIouoOA = TextUnit.m5340getTypeUIouoOA(spanStyle.m4665getFontSizeXSAIIZE());
        TextUnitType.Companion companion = TextUnitType.Companion;
        if (TextUnitType.m5369equalsimpl0(jM5340getTypeUIouoOA, companion.m5374getSpUIouoOA())) {
            androidTextPaint.setTextSize(density.mo332toPxR2X_6o(spanStyle.m4665getFontSizeXSAIIZE()));
        } else if (TextUnitType.m5369equalsimpl0(jM5340getTypeUIouoOA, companion.m5373getEmUIouoOA())) {
            androidTextPaint.setTextSize(androidTextPaint.getTextSize() * TextUnit.m5341getValueimpl(spanStyle.m4665getFontSizeXSAIIZE()));
        }
        if (hasFontAttributes(spanStyle)) {
            FontFamily fontFamily = spanStyle.getFontFamily();
            FontWeight fontWeight = spanStyle.getFontWeight();
            if (fontWeight == null) {
                fontWeight = FontWeight.Companion.getNormal();
            }
            FontStyle fontStyleM4666getFontStyle4Lr2A7w = spanStyle.m4666getFontStyle4Lr2A7w();
            FontStyle fontStyleM4798boximpl = FontStyle.m4798boximpl(fontStyleM4666getFontStyle4Lr2A7w != null ? fontStyleM4666getFontStyle4Lr2A7w.m4804unboximpl() : FontStyle.Companion.m4806getNormal_LCdwA());
            FontSynthesis fontSynthesisM4667getFontSynthesisZQGJjVo = spanStyle.m4667getFontSynthesisZQGJjVo();
            androidTextPaint.setTypeface((Typeface) interfaceC0578Hp.invoke(fontFamily, fontWeight, fontStyleM4798boximpl, FontSynthesis.m4807boximpl(fontSynthesisM4667getFontSynthesisZQGJjVo != null ? fontSynthesisM4667getFontSynthesisZQGJjVo.m4815unboximpl() : FontSynthesis.Companion.m4816getAllGVVA2EU())));
        }
        if (spanStyle.getLocaleList() != null && !AbstractC4492zt.d(spanStyle.getLocaleList(), LocaleList.Companion.getCurrent())) {
            if (Build.VERSION.SDK_INT >= 24) {
                LocaleListHelperMethods.INSTANCE.setTextLocales(androidTextPaint, spanStyle.getLocaleList());
            } else {
                androidTextPaint.setTextLocale(LocaleExtensions_androidKt.toJavaLocale(spanStyle.getLocaleList().isEmpty() ? Locale.Companion.getCurrent() : spanStyle.getLocaleList().get(0)));
            }
        }
        if (spanStyle.getFontFeatureSettings() != null && !AbstractC4492zt.d(spanStyle.getFontFeatureSettings(), "")) {
            androidTextPaint.setFontFeatureSettings(spanStyle.getFontFeatureSettings());
        }
        if (spanStyle.getTextGeometricTransform() != null && !AbstractC4492zt.d(spanStyle.getTextGeometricTransform(), TextGeometricTransform.Companion.getNone$ui_text_release())) {
            androidTextPaint.setTextScaleX(androidTextPaint.getTextScaleX() * spanStyle.getTextGeometricTransform().getScaleX());
            androidTextPaint.setTextSkewX(androidTextPaint.getTextSkewX() + spanStyle.getTextGeometricTransform().getSkewX());
        }
        androidTextPaint.m4940setColor8_81llA(spanStyle.m4664getColor0d7_KjU());
        androidTextPaint.m4939setBrush12SF9DM(spanStyle.getBrush(), Size.Companion.m2875getUnspecifiedNHjbRc(), spanStyle.getAlpha());
        androidTextPaint.setShadow(spanStyle.getShadow());
        androidTextPaint.setTextDecoration(spanStyle.getTextDecoration());
        androidTextPaint.setDrawStyle(spanStyle.getDrawStyle());
        if (TextUnitType.m5369equalsimpl0(TextUnit.m5340getTypeUIouoOA(spanStyle.m4668getLetterSpacingXSAIIZE()), companion.m5374getSpUIouoOA()) && TextUnit.m5341getValueimpl(spanStyle.m4668getLetterSpacingXSAIIZE()) != 0.0f) {
            float textSize = androidTextPaint.getTextSize() * androidTextPaint.getTextScaleX();
            float fMo332toPxR2X_6o = density.mo332toPxR2X_6o(spanStyle.m4668getLetterSpacingXSAIIZE());
            if (textSize != 0.0f) {
                androidTextPaint.setLetterSpacing(fMo332toPxR2X_6o / textSize);
            }
        } else if (TextUnitType.m5369equalsimpl0(TextUnit.m5340getTypeUIouoOA(spanStyle.m4668getLetterSpacingXSAIIZE()), companion.m5373getEmUIouoOA())) {
            androidTextPaint.setLetterSpacing(TextUnit.m5341getValueimpl(spanStyle.m4668getLetterSpacingXSAIIZE()));
        }
        return m4954generateFallbackSpanStyle62GTOB8(spanStyle.m4668getLetterSpacingXSAIIZE(), z, spanStyle.m4662getBackground0d7_KjU(), spanStyle.m4663getBaselineShift5SSeXJ0());
    }

    public static /* synthetic */ SpanStyle applySpanStyle$default(AndroidTextPaint androidTextPaint, SpanStyle spanStyle, InterfaceC0578Hp interfaceC0578Hp, Density density, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        return applySpanStyle(androidTextPaint, spanStyle, interfaceC0578Hp, density, z);
    }

    public static final float correctBlurRadius(float f) {
        if (f == 0.0f) {
            return Float.MIN_VALUE;
        }
        return f;
    }

    /* JADX INFO: renamed from: generateFallbackSpanStyle-62GTOB8, reason: not valid java name */
    private static final SpanStyle m4954generateFallbackSpanStyle62GTOB8(long j, boolean z, long j2, BaselineShift baselineShift) {
        long jM3068getUnspecified0d7_KjU = j2;
        boolean z2 = false;
        boolean z3 = z && TextUnitType.m5369equalsimpl0(TextUnit.m5340getTypeUIouoOA(j), TextUnitType.Companion.m5374getSpUIouoOA()) && TextUnit.m5341getValueimpl(j) != 0.0f;
        Color.Companion companion = Color.Companion;
        boolean z4 = (Color.m3033equalsimpl0(jM3068getUnspecified0d7_KjU, companion.m3068getUnspecified0d7_KjU()) || Color.m3033equalsimpl0(jM3068getUnspecified0d7_KjU, companion.m3067getTransparent0d7_KjU())) ? false : true;
        if (baselineShift != null) {
            if (!BaselineShift.m4962equalsimpl0(baselineShift.m4965unboximpl(), BaselineShift.Companion.m4969getNoney9eOQZs())) {
                z2 = true;
            }
        }
        if (!z3 && !z4 && !z2) {
            return null;
        }
        long jM5352getUnspecifiedXSAIIZE = z3 ? j : TextUnit.Companion.m5352getUnspecifiedXSAIIZE();
        if (!z4) {
            jM3068getUnspecified0d7_KjU = companion.m3068getUnspecified0d7_KjU();
        }
        return new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, jM5352getUnspecifiedXSAIIZE, z2 ? baselineShift : null, (TextGeometricTransform) null, (LocaleList) null, jM3068getUnspecified0d7_KjU, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 63103, (AbstractC0419Di) null);
    }

    public static final boolean hasFontAttributes(SpanStyle spanStyle) {
        AbstractC4492zt.h(spanStyle, "<this>");
        return (spanStyle.getFontFamily() == null && spanStyle.m4666getFontStyle4Lr2A7w() == null && spanStyle.getFontWeight() == null) ? false : true;
    }

    public static final void setTextMotion(AndroidTextPaint androidTextPaint, TextMotion textMotion) {
        AbstractC4492zt.h(androidTextPaint, "<this>");
        if (textMotion == null) {
            textMotion = TextMotion.Companion.getStatic();
        }
        androidTextPaint.setFlags(textMotion.getSubpixelTextPositioning$ui_text_release() ? androidTextPaint.getFlags() | 128 : androidTextPaint.getFlags() & (-129));
        int iM5092getLinearity4e0Vf04$ui_text_release = textMotion.m5092getLinearity4e0Vf04$ui_text_release();
        TextMotion.Linearity.Companion companion = TextMotion.Linearity.Companion;
        if (TextMotion.Linearity.m5096equalsimpl0(iM5092getLinearity4e0Vf04$ui_text_release, companion.m5101getLinear4e0Vf04())) {
            androidTextPaint.setFlags(androidTextPaint.getFlags() | 64);
            androidTextPaint.setHinting(0);
        } else if (TextMotion.Linearity.m5096equalsimpl0(iM5092getLinearity4e0Vf04$ui_text_release, companion.m5100getFontHinting4e0Vf04())) {
            androidTextPaint.getFlags();
            androidTextPaint.setHinting(1);
        } else if (!TextMotion.Linearity.m5096equalsimpl0(iM5092getLinearity4e0Vf04$ui_text_release, companion.m5102getNone4e0Vf04())) {
            androidTextPaint.getFlags();
        } else {
            androidTextPaint.getFlags();
            androidTextPaint.setHinting(0);
        }
    }
}
