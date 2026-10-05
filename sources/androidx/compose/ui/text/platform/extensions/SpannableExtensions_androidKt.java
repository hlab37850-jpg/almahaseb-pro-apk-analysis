package androidx.compose.ui.text.platform.extensions;

import android.graphics.Typeface;
import android.os.Build;
import android.text.Spannable;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.LocaleSpan;
import android.text.style.MetricAffectingSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ScaleXSpan;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedStringKt;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.android.style.BaselineShiftSpan;
import androidx.compose.ui.text.android.style.FontFeatureSpan;
import androidx.compose.ui.text.android.style.LetterSpacingSpanEm;
import androidx.compose.ui.text.android.style.LetterSpacingSpanPx;
import androidx.compose.ui.text.android.style.LineHeightSpan;
import androidx.compose.ui.text.android.style.LineHeightStyleSpan;
import androidx.compose.ui.text.android.style.ShadowSpan;
import androidx.compose.ui.text.android.style.SkewXSpan;
import androidx.compose.ui.text.android.style.TextDecorationSpan;
import androidx.compose.ui.text.android.style.TypefaceSpan;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.platform.style.DrawStyleSpan;
import androidx.compose.ui.text.platform.style.ShaderBrushSpan;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC1210aB;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4123vS;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0578Hp;
import defpackage.Q5;
import defpackage.R5;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class SpannableExtensions_androidKt {

    /* JADX INFO: renamed from: androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt$setFontAttributes$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ InterfaceC0578Hp $resolveTypeface;
        final /* synthetic */ Spannable $this_setFontAttributes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Spannable spannable, InterfaceC0578Hp interfaceC0578Hp) {
            super(3);
            this.$this_setFontAttributes = spannable;
            this.$resolveTypeface = interfaceC0578Hp;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((SpanStyle) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
            return FW.a;
        }

        public final void invoke(SpanStyle spanStyle, int i, int i2) {
            AbstractC4492zt.h(spanStyle, "spanStyle");
            Spannable spannable = this.$this_setFontAttributes;
            InterfaceC0578Hp interfaceC0578Hp = this.$resolveTypeface;
            FontFamily fontFamily = spanStyle.getFontFamily();
            FontWeight fontWeight = spanStyle.getFontWeight();
            if (fontWeight == null) {
                fontWeight = FontWeight.Companion.getNormal();
            }
            FontStyle fontStyleM4666getFontStyle4Lr2A7w = spanStyle.m4666getFontStyle4Lr2A7w();
            FontStyle fontStyleM4798boximpl = FontStyle.m4798boximpl(fontStyleM4666getFontStyle4Lr2A7w != null ? fontStyleM4666getFontStyle4Lr2A7w.m4804unboximpl() : FontStyle.Companion.m4806getNormal_LCdwA());
            FontSynthesis fontSynthesisM4667getFontSynthesisZQGJjVo = spanStyle.m4667getFontSynthesisZQGJjVo();
            spannable.setSpan(new TypefaceSpan((Typeface) interfaceC0578Hp.invoke(fontFamily, fontWeight, fontStyleM4798boximpl, FontSynthesis.m4807boximpl(fontSynthesisM4667getFontSynthesisZQGJjVo != null ? fontSynthesisM4667getFontSynthesisZQGJjVo.m4815unboximpl() : FontSynthesis.Companion.m4816getAllGVVA2EU()))), i, i2, 33);
        }
    }

    /* JADX INFO: renamed from: createLetterSpacingSpan-eAf_CNQ, reason: not valid java name */
    private static final MetricAffectingSpan m4946createLetterSpacingSpaneAf_CNQ(long j, Density density) {
        long jM5340getTypeUIouoOA = TextUnit.m5340getTypeUIouoOA(j);
        TextUnitType.Companion companion = TextUnitType.Companion;
        if (TextUnitType.m5369equalsimpl0(jM5340getTypeUIouoOA, companion.m5374getSpUIouoOA())) {
            return new LetterSpacingSpanPx(density.mo332toPxR2X_6o(j));
        }
        if (TextUnitType.m5369equalsimpl0(jM5340getTypeUIouoOA, companion.m5373getEmUIouoOA())) {
            return new LetterSpacingSpanEm(TextUnit.m5341getValueimpl(j));
        }
        return null;
    }

    public static final void flattenFontStylesAndApply(SpanStyle spanStyle, List<AnnotatedString.Range<SpanStyle>> list, InterfaceC0552Gp interfaceC0552Gp) {
        AbstractC4492zt.h(list, "spanStyles");
        AbstractC4492zt.h(interfaceC0552Gp, CSS.Value.BLOCK);
        if (list.size() <= 1) {
            if (list.isEmpty()) {
                return;
            }
            interfaceC0552Gp.invoke(merge(spanStyle, list.get(0).getItem()), Integer.valueOf(list.get(0).getStart()), Integer.valueOf(list.get(0).getEnd()));
            return;
        }
        int size = list.size();
        int i = size * 2;
        Integer[] numArr = new Integer[i];
        for (int i2 = 0; i2 < i; i2++) {
            numArr[i2] = 0;
        }
        int size2 = list.size();
        for (int i3 = 0; i3 < size2; i3++) {
            AnnotatedString.Range<SpanStyle> range = list.get(i3);
            numArr[i3] = Integer.valueOf(range.getStart());
            numArr[i3 + size] = Integer.valueOf(range.getEnd());
        }
        Q5.y(numArr);
        int iIntValue = ((Number) R5.J(numArr)).intValue();
        for (int i4 = 0; i4 < i; i4++) {
            Integer num = numArr[i4];
            int iIntValue2 = num.intValue();
            if (iIntValue2 != iIntValue) {
                int size3 = list.size();
                SpanStyle spanStyleMerge = spanStyle;
                for (int i5 = 0; i5 < size3; i5++) {
                    AnnotatedString.Range<SpanStyle> range2 = list.get(i5);
                    if (range2.getStart() != range2.getEnd() && AnnotatedStringKt.intersect(iIntValue, iIntValue2, range2.getStart(), range2.getEnd())) {
                        spanStyleMerge = merge(spanStyleMerge, range2.getItem());
                    }
                }
                if (spanStyleMerge != null) {
                    interfaceC0552Gp.invoke(spanStyleMerge, Integer.valueOf(iIntValue), num);
                }
                iIntValue = iIntValue2;
            }
        }
    }

    private static final boolean getNeedsLetterSpacingSpan(SpanStyle spanStyle) {
        long jM5340getTypeUIouoOA = TextUnit.m5340getTypeUIouoOA(spanStyle.m4668getLetterSpacingXSAIIZE());
        TextUnitType.Companion companion = TextUnitType.Companion;
        return TextUnitType.m5369equalsimpl0(jM5340getTypeUIouoOA, companion.m5374getSpUIouoOA()) || TextUnitType.m5369equalsimpl0(TextUnit.m5340getTypeUIouoOA(spanStyle.m4668getLetterSpacingXSAIIZE()), companion.m5373getEmUIouoOA());
    }

    private static final boolean hasFontAttributes(TextStyle textStyle) {
        return TextPaintExtensions_androidKt.hasFontAttributes(textStyle.toSpanStyle()) || textStyle.m4729getFontSynthesisZQGJjVo() != null;
    }

    private static final SpanStyle merge(SpanStyle spanStyle, SpanStyle spanStyle2) {
        return spanStyle == null ? spanStyle2 : spanStyle.merge(spanStyle2);
    }

    /* JADX INFO: renamed from: resolveLineHeightInPx-o2QH7mI, reason: not valid java name */
    private static final float m4947resolveLineHeightInPxo2QH7mI(long j, float f, Density density) {
        long jM5340getTypeUIouoOA = TextUnit.m5340getTypeUIouoOA(j);
        TextUnitType.Companion companion = TextUnitType.Companion;
        if (TextUnitType.m5369equalsimpl0(jM5340getTypeUIouoOA, companion.m5374getSpUIouoOA())) {
            return density.mo332toPxR2X_6o(j);
        }
        if (TextUnitType.m5369equalsimpl0(jM5340getTypeUIouoOA, companion.m5373getEmUIouoOA())) {
            return TextUnit.m5341getValueimpl(j) * f;
        }
        return Float.NaN;
    }

    /* JADX INFO: renamed from: setBackground-RPmYEkk, reason: not valid java name */
    public static final void m4948setBackgroundRPmYEkk(Spannable spannable, long j, int i, int i2) {
        AbstractC4492zt.h(spannable, "$this$setBackground");
        if (j != Color.Companion.m3068getUnspecified0d7_KjU()) {
            setSpan(spannable, new BackgroundColorSpan(ColorKt.m3086toArgb8_81llA(j)), i, i2);
        }
    }

    /* JADX INFO: renamed from: setBaselineShift-0ocSgnM, reason: not valid java name */
    private static final void m4949setBaselineShift0ocSgnM(Spannable spannable, BaselineShift baselineShift, int i, int i2) {
        if (baselineShift != null) {
            setSpan(spannable, new BaselineShiftSpan(baselineShift.m4965unboximpl()), i, i2);
        }
    }

    private static final void setBrush(Spannable spannable, Brush brush, float f, int i, int i2) {
        if (brush != null) {
            if (brush instanceof SolidColor) {
                m4950setColorRPmYEkk(spannable, ((SolidColor) brush).m3338getValue0d7_KjU(), i, i2);
            } else if (brush instanceof ShaderBrush) {
                setSpan(spannable, new ShaderBrushSpan((ShaderBrush) brush, f), i, i2);
            }
        }
    }

    /* JADX INFO: renamed from: setColor-RPmYEkk, reason: not valid java name */
    public static final void m4950setColorRPmYEkk(Spannable spannable, long j, int i, int i2) {
        AbstractC4492zt.h(spannable, "$this$setColor");
        if (j != Color.Companion.m3068getUnspecified0d7_KjU()) {
            setSpan(spannable, new ForegroundColorSpan(ColorKt.m3086toArgb8_81llA(j)), i, i2);
        }
    }

    private static final void setDrawStyle(Spannable spannable, DrawStyle drawStyle, int i, int i2) {
        if (drawStyle != null) {
            setSpan(spannable, new DrawStyleSpan(drawStyle), i, i2);
        }
    }

    private static final void setFontAttributes(Spannable spannable, TextStyle textStyle, List<AnnotatedString.Range<SpanStyle>> list, InterfaceC0578Hp interfaceC0578Hp) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            AnnotatedString.Range<SpanStyle> range = list.get(i);
            AnnotatedString.Range<SpanStyle> range2 = range;
            if (TextPaintExtensions_androidKt.hasFontAttributes(range2.getItem()) || range2.getItem().m4667getFontSynthesisZQGJjVo() != null) {
                arrayList.add(range);
            }
        }
        flattenFontStylesAndApply(hasFontAttributes(textStyle) ? new SpanStyle(0L, 0L, textStyle.getFontWeight(), textStyle.m4728getFontStyle4Lr2A7w(), textStyle.m4729getFontSynthesisZQGJjVo(), textStyle.getFontFamily(), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65475, (AbstractC0419Di) null) : null, arrayList, new AnonymousClass1(spannable, interfaceC0578Hp));
    }

    private static final void setFontFeatureSettings(Spannable spannable, String str, int i, int i2) {
        if (str != null) {
            setSpan(spannable, new FontFeatureSpan(str), i, i2);
        }
    }

    /* JADX INFO: renamed from: setFontSize-KmRG4DE, reason: not valid java name */
    public static final void m4951setFontSizeKmRG4DE(Spannable spannable, long j, Density density, int i, int i2) {
        AbstractC4492zt.h(spannable, "$this$setFontSize");
        AbstractC4492zt.h(density, "density");
        long jM5340getTypeUIouoOA = TextUnit.m5340getTypeUIouoOA(j);
        TextUnitType.Companion companion = TextUnitType.Companion;
        if (TextUnitType.m5369equalsimpl0(jM5340getTypeUIouoOA, companion.m5374getSpUIouoOA())) {
            setSpan(spannable, new AbsoluteSizeSpan(AbstractC1210aB.c(density.mo332toPxR2X_6o(j)), false), i, i2);
        } else if (TextUnitType.m5369equalsimpl0(jM5340getTypeUIouoOA, companion.m5373getEmUIouoOA())) {
            setSpan(spannable, new RelativeSizeSpan(TextUnit.m5341getValueimpl(j)), i, i2);
        }
    }

    private static final void setGeometricTransform(Spannable spannable, TextGeometricTransform textGeometricTransform, int i, int i2) {
        if (textGeometricTransform != null) {
            setSpan(spannable, new ScaleXSpan(textGeometricTransform.getScaleX()), i, i2);
            setSpan(spannable, new SkewXSpan(textGeometricTransform.getSkewX()), i, i2);
        }
    }

    /* JADX INFO: renamed from: setLineHeight-KmRG4DE, reason: not valid java name */
    public static final void m4952setLineHeightKmRG4DE(Spannable spannable, long j, float f, Density density, LineHeightStyle lineHeightStyle) {
        AbstractC4492zt.h(spannable, "$this$setLineHeight");
        AbstractC4492zt.h(density, "density");
        AbstractC4492zt.h(lineHeightStyle, "lineHeightStyle");
        float fM4947resolveLineHeightInPxo2QH7mI = m4947resolveLineHeightInPxo2QH7mI(j, f, density);
        if (Float.isNaN(fM4947resolveLineHeightInPxo2QH7mI)) {
            return;
        }
        setSpan(spannable, new LineHeightStyleSpan(fM4947resolveLineHeightInPxo2QH7mI, 0, (spannable.length() == 0 || AbstractC4123vS.F0(spannable) == '\n') ? spannable.length() + 1 : spannable.length(), LineHeightStyle.Trim.m5051isTrimFirstLineTopimpl$ui_text_release(lineHeightStyle.m5034getTrimEVpEnUU()), LineHeightStyle.Trim.m5052isTrimLastLineBottomimpl$ui_text_release(lineHeightStyle.m5034getTrimEVpEnUU()), lineHeightStyle.m5033getAlignmentPIaL0Z0()), 0, spannable.length());
    }

    /* JADX INFO: renamed from: setLineHeight-r9BaKPg, reason: not valid java name */
    public static final void m4953setLineHeightr9BaKPg(Spannable spannable, long j, float f, Density density) {
        AbstractC4492zt.h(spannable, "$this$setLineHeight");
        AbstractC4492zt.h(density, "density");
        float fM4947resolveLineHeightInPxo2QH7mI = m4947resolveLineHeightInPxo2QH7mI(j, f, density);
        if (Float.isNaN(fM4947resolveLineHeightInPxo2QH7mI)) {
            return;
        }
        setSpan(spannable, new LineHeightSpan(fM4947resolveLineHeightInPxo2QH7mI), 0, spannable.length());
    }

    public static final void setLocaleList(Spannable spannable, LocaleList localeList, int i, int i2) {
        Object localeSpan;
        AbstractC4492zt.h(spannable, "<this>");
        if (localeList != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                localeSpan = LocaleListHelperMethods.INSTANCE.localeSpan(localeList);
            } else {
                localeSpan = new LocaleSpan(LocaleExtensions_androidKt.toJavaLocale(localeList.isEmpty() ? Locale.Companion.getCurrent() : localeList.get(0)));
            }
            setSpan(spannable, localeSpan, i, i2);
        }
    }

    private static final void setShadow(Spannable spannable, Shadow shadow, int i, int i2) {
        if (shadow != null) {
            setSpan(spannable, new ShadowSpan(ColorKt.m3086toArgb8_81llA(shadow.m3328getColor0d7_KjU()), Offset.m2798getXimpl(shadow.m3329getOffsetF1C5BW0()), Offset.m2799getYimpl(shadow.m3329getOffsetF1C5BW0()), TextPaintExtensions_androidKt.correctBlurRadius(shadow.getBlurRadius())), i, i2);
        }
    }

    public static final void setSpan(Spannable spannable, Object obj, int i, int i2) {
        AbstractC4492zt.h(spannable, "<this>");
        AbstractC4492zt.h(obj, "span");
        spannable.setSpan(obj, i, i2, 33);
    }

    private static final void setSpanStyle(Spannable spannable, AnnotatedString.Range<SpanStyle> range, Density density) {
        int start = range.getStart();
        int end = range.getEnd();
        SpanStyle item = range.getItem();
        m4949setBaselineShift0ocSgnM(spannable, item.m4663getBaselineShift5SSeXJ0(), start, end);
        m4950setColorRPmYEkk(spannable, item.m4664getColor0d7_KjU(), start, end);
        setBrush(spannable, item.getBrush(), item.getAlpha(), start, end);
        setTextDecoration(spannable, item.getTextDecoration(), start, end);
        m4951setFontSizeKmRG4DE(spannable, item.m4665getFontSizeXSAIIZE(), density, start, end);
        setFontFeatureSettings(spannable, item.getFontFeatureSettings(), start, end);
        setGeometricTransform(spannable, item.getTextGeometricTransform(), start, end);
        setLocaleList(spannable, item.getLocaleList(), start, end);
        m4948setBackgroundRPmYEkk(spannable, item.m4662getBackground0d7_KjU(), start, end);
        setShadow(spannable, item.getShadow(), start, end);
        setDrawStyle(spannable, item.getDrawStyle(), start, end);
    }

    public static final void setSpanStyles(Spannable spannable, TextStyle textStyle, List<AnnotatedString.Range<SpanStyle>> list, Density density, InterfaceC0578Hp interfaceC0578Hp) {
        MetricAffectingSpan metricAffectingSpanM4946createLetterSpacingSpaneAf_CNQ;
        AbstractC4492zt.h(spannable, "<this>");
        AbstractC4492zt.h(textStyle, "contextTextStyle");
        AbstractC4492zt.h(list, "spanStyles");
        AbstractC4492zt.h(density, "density");
        AbstractC4492zt.h(interfaceC0578Hp, "resolveTypeface");
        setFontAttributes(spannable, textStyle, list, interfaceC0578Hp);
        int size = list.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            AnnotatedString.Range<SpanStyle> range = list.get(i);
            int start = range.getStart();
            int end = range.getEnd();
            if (start >= 0 && start < spannable.length() && end > start && end <= spannable.length()) {
                setSpanStyle(spannable, range, density);
                if (getNeedsLetterSpacingSpan(range.getItem())) {
                    z = true;
                }
            }
        }
        if (z) {
            int size2 = list.size();
            for (int i2 = 0; i2 < size2; i2++) {
                AnnotatedString.Range<SpanStyle> range2 = list.get(i2);
                int start2 = range2.getStart();
                int end2 = range2.getEnd();
                SpanStyle item = range2.getItem();
                if (start2 >= 0 && start2 < spannable.length() && end2 > start2 && end2 <= spannable.length() && (metricAffectingSpanM4946createLetterSpacingSpaneAf_CNQ = m4946createLetterSpacingSpaneAf_CNQ(item.m4668getLetterSpacingXSAIIZE(), density)) != null) {
                    setSpan(spannable, metricAffectingSpanM4946createLetterSpacingSpaneAf_CNQ, start2, end2);
                }
            }
        }
    }

    public static final void setTextDecoration(Spannable spannable, TextDecoration textDecoration, int i, int i2) {
        AbstractC4492zt.h(spannable, "<this>");
        if (textDecoration != null) {
            TextDecoration.Companion companion = TextDecoration.Companion;
            setSpan(spannable, new TextDecorationSpan(textDecoration.contains(companion.getUnderline()), textDecoration.contains(companion.getLineThrough())), i, i2);
        }
    }

    public static final void setTextIndent(Spannable spannable, TextIndent textIndent, float f, Density density) {
        float fM5341getValueimpl;
        AbstractC4492zt.h(spannable, "<this>");
        AbstractC4492zt.h(density, "density");
        if (textIndent != null) {
            if ((TextUnit.m5338equalsimpl0(textIndent.m5088getFirstLineXSAIIZE(), TextUnitKt.getSp(0)) && TextUnit.m5338equalsimpl0(textIndent.m5089getRestLineXSAIIZE(), TextUnitKt.getSp(0))) || TextUnitKt.m5359isUnspecifiedR2X_6o(textIndent.m5088getFirstLineXSAIIZE()) || TextUnitKt.m5359isUnspecifiedR2X_6o(textIndent.m5089getRestLineXSAIIZE())) {
                return;
            }
            long jM5340getTypeUIouoOA = TextUnit.m5340getTypeUIouoOA(textIndent.m5088getFirstLineXSAIIZE());
            TextUnitType.Companion companion = TextUnitType.Companion;
            float fM5341getValueimpl2 = 0.0f;
            if (TextUnitType.m5369equalsimpl0(jM5340getTypeUIouoOA, companion.m5374getSpUIouoOA())) {
                fM5341getValueimpl = density.mo332toPxR2X_6o(textIndent.m5088getFirstLineXSAIIZE());
            } else {
                fM5341getValueimpl = TextUnitType.m5369equalsimpl0(jM5340getTypeUIouoOA, companion.m5373getEmUIouoOA()) ? TextUnit.m5341getValueimpl(textIndent.m5088getFirstLineXSAIIZE()) * f : 0.0f;
            }
            long jM5340getTypeUIouoOA2 = TextUnit.m5340getTypeUIouoOA(textIndent.m5089getRestLineXSAIIZE());
            if (TextUnitType.m5369equalsimpl0(jM5340getTypeUIouoOA2, companion.m5374getSpUIouoOA())) {
                fM5341getValueimpl2 = density.mo332toPxR2X_6o(textIndent.m5089getRestLineXSAIIZE());
            } else if (TextUnitType.m5369equalsimpl0(jM5340getTypeUIouoOA2, companion.m5373getEmUIouoOA())) {
                fM5341getValueimpl2 = TextUnit.m5341getValueimpl(textIndent.m5089getRestLineXSAIIZE()) * f;
            }
            setSpan(spannable, new LeadingMarginSpan.Standard((int) Math.ceil(fM5341getValueimpl), (int) Math.ceil(fM5341getValueimpl2)), 0, spannable.length());
        }
    }
}
