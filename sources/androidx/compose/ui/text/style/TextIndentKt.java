package androidx.compose.ui.text.style;

import androidx.compose.ui.text.SpanStyleKt;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class TextIndentKt {
    public static final TextIndent lerp(TextIndent textIndent, TextIndent textIndent2, float f) {
        AbstractC4492zt.h(textIndent, HTML.Attribute.START);
        AbstractC4492zt.h(textIndent2, "stop");
        return new TextIndent(SpanStyleKt.m4670lerpTextUnitInheritableC3pnCVY(textIndent.m5088getFirstLineXSAIIZE(), textIndent2.m5088getFirstLineXSAIIZE(), f), SpanStyleKt.m4670lerpTextUnitInheritableC3pnCVY(textIndent.m5089getRestLineXSAIIZE(), textIndent2.m5089getRestLineXSAIIZE(), f), null);
    }
}
