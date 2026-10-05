package androidx.compose.ui.text.platform;

import android.graphics.Typeface;
import android.os.Build;
import android.text.SpannableString;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.RestrictTo;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.InternalTextApi;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TtsAnnotation;
import androidx.compose.ui.text.UrlAnnotation;
import androidx.compose.ui.text.font.AndroidFontUtils_androidKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.GenericFontFamily;
import androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.ui.text.platform.extensions.TtsAnnotationExtensions_androidKt;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import defpackage.AbstractC0398Cn;
import defpackage.AbstractC4492zt;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidAccessibilitySpannableString_androidKt {
    private static final void setSpanStyle(SpannableString spannableString, SpanStyle spanStyle, int i, int i2, Density density, FontFamily.Resolver resolver) {
        SpannableExtensions_androidKt.m4950setColorRPmYEkk(spannableString, spanStyle.m4664getColor0d7_KjU(), i, i2);
        SpannableExtensions_androidKt.m4951setFontSizeKmRG4DE(spannableString, spanStyle.m4665getFontSizeXSAIIZE(), density, i, i2);
        if (spanStyle.getFontWeight() != null || spanStyle.m4666getFontStyle4Lr2A7w() != null) {
            FontWeight fontWeight = spanStyle.getFontWeight();
            if (fontWeight == null) {
                fontWeight = FontWeight.Companion.getNormal();
            }
            FontStyle fontStyleM4666getFontStyle4Lr2A7w = spanStyle.m4666getFontStyle4Lr2A7w();
            spannableString.setSpan(new StyleSpan(AndroidFontUtils_androidKt.m4756getAndroidTypefaceStyleFO1MlWM(fontWeight, fontStyleM4666getFontStyle4Lr2A7w != null ? fontStyleM4666getFontStyle4Lr2A7w.m4804unboximpl() : FontStyle.Companion.m4806getNormal_LCdwA())), i, i2, 33);
        }
        if (spanStyle.getFontFamily() != null) {
            if (spanStyle.getFontFamily() instanceof GenericFontFamily) {
                spannableString.setSpan(new TypefaceSpan(((GenericFontFamily) spanStyle.getFontFamily()).getName()), i, i2, 33);
            } else if (Build.VERSION.SDK_INT >= 28) {
                FontFamily fontFamily = spanStyle.getFontFamily();
                FontSynthesis fontSynthesisM4667getFontSynthesisZQGJjVo = spanStyle.m4667getFontSynthesisZQGJjVo();
                Object value = AbstractC0398Cn.a(resolver, fontFamily, null, 0, fontSynthesisM4667getFontSynthesisZQGJjVo != null ? fontSynthesisM4667getFontSynthesisZQGJjVo.m4815unboximpl() : FontSynthesis.Companion.m4816getAllGVVA2EU(), 6, null).getValue();
                AbstractC4492zt.f(value, "null cannot be cast to non-null type android.graphics.Typeface");
                spannableString.setSpan(Api28Impl.INSTANCE.createTypefaceSpan((Typeface) value), i, i2, 33);
            }
        }
        if (spanStyle.getTextDecoration() != null) {
            TextDecoration textDecoration = spanStyle.getTextDecoration();
            TextDecoration.Companion companion = TextDecoration.Companion;
            if (textDecoration.contains(companion.getUnderline())) {
                spannableString.setSpan(new UnderlineSpan(), i, i2, 33);
            }
            if (spanStyle.getTextDecoration().contains(companion.getLineThrough())) {
                spannableString.setSpan(new StrikethroughSpan(), i, i2, 33);
            }
        }
        if (spanStyle.getTextGeometricTransform() != null) {
            spannableString.setSpan(new ScaleXSpan(spanStyle.getTextGeometricTransform().getScaleX()), i, i2, 33);
        }
        SpannableExtensions_androidKt.setLocaleList(spannableString, spanStyle.getLocaleList(), i, i2);
        SpannableExtensions_androidKt.m4948setBackgroundRPmYEkk(spannableString, spanStyle.m4662getBackground0d7_KjU(), i, i2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @InternalTextApi
    public static final SpannableString toAccessibilitySpannableString(AnnotatedString annotatedString, Density density, FontFamily.Resolver resolver, URLSpanCache uRLSpanCache) {
        AbstractC4492zt.h(annotatedString, "<this>");
        AbstractC4492zt.h(density, "density");
        AbstractC4492zt.h(resolver, "fontFamilyResolver");
        AbstractC4492zt.h(uRLSpanCache, "urlSpanCache");
        SpannableString spannableString = new SpannableString(annotatedString.getText());
        List<AnnotatedString.Range<SpanStyle>> spanStylesOrNull$ui_text_release = annotatedString.getSpanStylesOrNull$ui_text_release();
        if (spanStylesOrNull$ui_text_release != null) {
            int size = spanStylesOrNull$ui_text_release.size();
            for (int i = 0; i < size; i++) {
                AnnotatedString.Range<SpanStyle> range = spanStylesOrNull$ui_text_release.get(i);
                SpanStyle spanStyleComponent1 = range.component1();
                setSpanStyle(spannableString, spanStyleComponent1.m4659copyGSF8kmg((65503 & 1) != 0 ? spanStyleComponent1.m4664getColor0d7_KjU() : 0L, (65503 & 2) != 0 ? spanStyleComponent1.fontSize : 0L, (65503 & 4) != 0 ? spanStyleComponent1.fontWeight : null, (65503 & 8) != 0 ? spanStyleComponent1.fontStyle : null, (65503 & 16) != 0 ? spanStyleComponent1.fontSynthesis : null, (65503 & 32) != 0 ? spanStyleComponent1.fontFamily : null, (65503 & 64) != 0 ? spanStyleComponent1.fontFeatureSettings : null, (65503 & 128) != 0 ? spanStyleComponent1.letterSpacing : 0L, (65503 & 256) != 0 ? spanStyleComponent1.baselineShift : null, (65503 & 512) != 0 ? spanStyleComponent1.textGeometricTransform : null, (65503 & 1024) != 0 ? spanStyleComponent1.localeList : null, (65503 & 2048) != 0 ? spanStyleComponent1.background : 0L, (65503 & 4096) != 0 ? spanStyleComponent1.textDecoration : null, (65503 & 8192) != 0 ? spanStyleComponent1.shadow : null, (65503 & 16384) != 0 ? spanStyleComponent1.platformStyle : null, (65503 & 32768) != 0 ? spanStyleComponent1.drawStyle : null), range.component2(), range.component3(), density, resolver);
            }
        }
        List<AnnotatedString.Range<TtsAnnotation>> ttsAnnotations = annotatedString.getTtsAnnotations(0, annotatedString.length());
        int size2 = ttsAnnotations.size();
        for (int i2 = 0; i2 < size2; i2++) {
            AnnotatedString.Range<TtsAnnotation> range2 = ttsAnnotations.get(i2);
            TtsAnnotation ttsAnnotationComponent1 = range2.component1();
            spannableString.setSpan(TtsAnnotationExtensions_androidKt.toSpan(ttsAnnotationComponent1), range2.component2(), range2.component3(), 33);
        }
        List<AnnotatedString.Range<UrlAnnotation>> urlAnnotations = annotatedString.getUrlAnnotations(0, annotatedString.length());
        int size3 = urlAnnotations.size();
        for (int i3 = 0; i3 < size3; i3++) {
            AnnotatedString.Range<UrlAnnotation> range3 = urlAnnotations.get(i3);
            UrlAnnotation urlAnnotationComponent1 = range3.component1();
            spannableString.setSpan(uRLSpanCache.toURLSpan(urlAnnotationComponent1), range3.component2(), range3.component3(), 33);
        }
        return spannableString;
    }
}
