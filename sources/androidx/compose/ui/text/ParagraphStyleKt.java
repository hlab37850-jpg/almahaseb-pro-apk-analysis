package androidx.compose.ui.text;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextIndentKt;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class ParagraphStyleKt {
    private static final long DefaultLineHeight = TextUnit.Companion.m5352getUnspecifiedXSAIIZE();

    /* JADX INFO: renamed from: fastMerge-HtYhynw, reason: not valid java name */
    public static final ParagraphStyle m4623fastMergeHtYhynw(ParagraphStyle paragraphStyle, TextAlign textAlign, TextDirection textDirection, long j, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, TextMotion textMotion) {
        long j2;
        TextAlign textAlignM4620getTextAlignbuA522U = textAlign;
        TextIndent textIndent2 = textIndent;
        AbstractC4492zt.h(paragraphStyle, "$this$fastMerge");
        if (textAlignM4620getTextAlignbuA522U == null || AbstractC4492zt.d(textAlignM4620getTextAlignbuA522U, paragraphStyle.m4620getTextAlignbuA522U())) {
            if (TextUnitKt.m5359isUnspecifiedR2X_6o(j)) {
                j2 = j;
            } else {
                j2 = j;
                if (TextUnit.m5338equalsimpl0(j2, paragraphStyle.m4619getLineHeightXSAIIZE())) {
                }
            }
            if ((textIndent2 == null || AbstractC4492zt.d(textIndent2, paragraphStyle.getTextIndent())) && ((textDirection == null || AbstractC4492zt.d(textDirection, paragraphStyle.m4622getTextDirectionmmuk1to())) && ((platformParagraphStyle == null || AbstractC4492zt.d(platformParagraphStyle, paragraphStyle.getPlatformStyle())) && ((lineHeightStyle == null || AbstractC4492zt.d(lineHeightStyle, paragraphStyle.getLineHeightStyle())) && ((lineBreak == null || AbstractC4492zt.d(lineBreak, paragraphStyle.m4617getLineBreakLgCVezo())) && ((hyphens == null || AbstractC4492zt.d(hyphens, paragraphStyle.m4615getHyphensEaSxIns())) && (textMotion == null || AbstractC4492zt.d(textMotion, paragraphStyle.getTextMotion())))))))) {
                return paragraphStyle;
            }
        } else {
            j2 = j;
        }
        long jM4619getLineHeightXSAIIZE = TextUnitKt.m5359isUnspecifiedR2X_6o(j) ? paragraphStyle.m4619getLineHeightXSAIIZE() : j2;
        if (textIndent2 == null) {
            textIndent2 = paragraphStyle.getTextIndent();
        }
        TextIndent textIndent3 = textIndent2;
        if (textAlignM4620getTextAlignbuA522U == null) {
            textAlignM4620getTextAlignbuA522U = paragraphStyle.m4620getTextAlignbuA522U();
        }
        return new ParagraphStyle(textAlignM4620getTextAlignbuA522U, textDirection == null ? paragraphStyle.m4622getTextDirectionmmuk1to() : textDirection, jM4619getLineHeightXSAIIZE, textIndent3, mergePlatformStyle(paragraphStyle, platformParagraphStyle), lineHeightStyle == null ? paragraphStyle.getLineHeightStyle() : lineHeightStyle, lineBreak == null ? paragraphStyle.m4617getLineBreakLgCVezo() : lineBreak, hyphens == null ? paragraphStyle.m4615getHyphensEaSxIns() : hyphens, textMotion == null ? paragraphStyle.getTextMotion() : textMotion, (AbstractC0419Di) null);
    }

    @Stable
    public static final ParagraphStyle lerp(ParagraphStyle paragraphStyle, ParagraphStyle paragraphStyle2, float f) {
        AbstractC4492zt.h(paragraphStyle, HTML.Attribute.START);
        AbstractC4492zt.h(paragraphStyle2, "stop");
        TextAlign textAlign = (TextAlign) SpanStyleKt.lerpDiscrete(paragraphStyle.m4620getTextAlignbuA522U(), paragraphStyle2.m4620getTextAlignbuA522U(), f);
        TextDirection textDirection = (TextDirection) SpanStyleKt.lerpDiscrete(paragraphStyle.m4622getTextDirectionmmuk1to(), paragraphStyle2.m4622getTextDirectionmmuk1to(), f);
        long jM4670lerpTextUnitInheritableC3pnCVY = SpanStyleKt.m4670lerpTextUnitInheritableC3pnCVY(paragraphStyle.m4619getLineHeightXSAIIZE(), paragraphStyle2.m4619getLineHeightXSAIIZE(), f);
        TextIndent textIndent = paragraphStyle.getTextIndent();
        if (textIndent == null) {
            textIndent = TextIndent.Companion.getNone();
        }
        TextIndent textIndent2 = paragraphStyle2.getTextIndent();
        if (textIndent2 == null) {
            textIndent2 = TextIndent.Companion.getNone();
        }
        return new ParagraphStyle(textAlign, textDirection, jM4670lerpTextUnitInheritableC3pnCVY, TextIndentKt.lerp(textIndent, textIndent2, f), lerpPlatformStyle(paragraphStyle.getPlatformStyle(), paragraphStyle2.getPlatformStyle(), f), (LineHeightStyle) SpanStyleKt.lerpDiscrete(paragraphStyle.getLineHeightStyle(), paragraphStyle2.getLineHeightStyle(), f), (LineBreak) SpanStyleKt.lerpDiscrete(paragraphStyle.m4617getLineBreakLgCVezo(), paragraphStyle2.m4617getLineBreakLgCVezo(), f), (Hyphens) SpanStyleKt.lerpDiscrete(paragraphStyle.m4615getHyphensEaSxIns(), paragraphStyle2.m4615getHyphensEaSxIns(), f), (TextMotion) SpanStyleKt.lerpDiscrete(paragraphStyle.getTextMotion(), paragraphStyle2.getTextMotion(), f), (AbstractC0419Di) null);
    }

    private static final PlatformParagraphStyle lerpPlatformStyle(PlatformParagraphStyle platformParagraphStyle, PlatformParagraphStyle platformParagraphStyle2, float f) {
        if (platformParagraphStyle == null && platformParagraphStyle2 == null) {
            return null;
        }
        if (platformParagraphStyle == null) {
            platformParagraphStyle = PlatformParagraphStyle.Companion.getDefault();
        }
        if (platformParagraphStyle2 == null) {
            platformParagraphStyle2 = PlatformParagraphStyle.Companion.getDefault();
        }
        return AndroidTextStyle_androidKt.lerp(platformParagraphStyle, platformParagraphStyle2, f);
    }

    private static final PlatformParagraphStyle mergePlatformStyle(ParagraphStyle paragraphStyle, PlatformParagraphStyle platformParagraphStyle) {
        if (paragraphStyle.getPlatformStyle() == null) {
            return platformParagraphStyle;
        }
        return platformParagraphStyle == null ? paragraphStyle.getPlatformStyle() : paragraphStyle.getPlatformStyle().merge(platformParagraphStyle);
    }

    public static final ParagraphStyle resolveParagraphStyleDefaults(ParagraphStyle paragraphStyle, LayoutDirection layoutDirection) {
        AbstractC4492zt.h(paragraphStyle, "style");
        AbstractC4492zt.h(layoutDirection, CSS.Property.DIRECTION);
        TextAlign textAlignM5059boximpl = TextAlign.m5059boximpl(paragraphStyle.m4621getTextAlignOrDefaulte0LSkKk$ui_text_release());
        TextDirection textDirectionM5072boximpl = TextDirection.m5072boximpl(TextStyleKt.m4737resolveTextDirectionYj3eThk(layoutDirection, paragraphStyle.m4622getTextDirectionmmuk1to()));
        long jM4619getLineHeightXSAIIZE = TextUnitKt.m5359isUnspecifiedR2X_6o(paragraphStyle.m4619getLineHeightXSAIIZE()) ? DefaultLineHeight : paragraphStyle.m4619getLineHeightXSAIIZE();
        TextIndent textIndent = paragraphStyle.getTextIndent();
        if (textIndent == null) {
            textIndent = TextIndent.Companion.getNone();
        }
        TextIndent textIndent2 = textIndent;
        PlatformParagraphStyle platformStyle = paragraphStyle.getPlatformStyle();
        LineHeightStyle lineHeightStyle = paragraphStyle.getLineHeightStyle();
        LineBreak lineBreakM4987boximpl = LineBreak.m4987boximpl(paragraphStyle.m4618getLineBreakOrDefaultrAG3T2k$ui_text_release());
        Hyphens hyphensM4978boximpl = Hyphens.m4978boximpl(paragraphStyle.m4616getHyphensOrDefaultvmbZdU8$ui_text_release());
        TextMotion textMotion = paragraphStyle.getTextMotion();
        if (textMotion == null) {
            textMotion = TextMotion.Companion.getStatic();
        }
        return new ParagraphStyle(textAlignM5059boximpl, textDirectionM5072boximpl, jM4619getLineHeightXSAIIZE, textIndent2, platformStyle, lineHeightStyle, lineBreakM4987boximpl, hyphensM4978boximpl, textMotion, (AbstractC0419Di) null);
    }
}
