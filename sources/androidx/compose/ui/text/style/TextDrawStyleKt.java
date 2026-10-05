package androidx.compose.ui.text.style;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.text.SpanStyleKt;
import androidx.compose.ui.util.MathHelpersKt;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class TextDrawStyleKt {
    public static final TextForegroundStyle lerp(TextForegroundStyle textForegroundStyle, TextForegroundStyle textForegroundStyle2, float f) {
        AbstractC4492zt.h(textForegroundStyle, HTML.Attribute.START);
        AbstractC4492zt.h(textForegroundStyle2, "stop");
        boolean z = textForegroundStyle instanceof BrushStyle;
        if (z || (textForegroundStyle2 instanceof BrushStyle)) {
            return (z && (textForegroundStyle2 instanceof BrushStyle)) ? TextForegroundStyle.Companion.from((Brush) SpanStyleKt.lerpDiscrete(((BrushStyle) textForegroundStyle).getBrush(), ((BrushStyle) textForegroundStyle2).getBrush(), f), MathHelpersKt.lerp(textForegroundStyle.getAlpha(), textForegroundStyle2.getAlpha(), f)) : (TextForegroundStyle) SpanStyleKt.lerpDiscrete(textForegroundStyle, textForegroundStyle2, f);
        }
        return TextForegroundStyle.Companion.m5085from8_81llA(ColorKt.m3083lerpjxsXWHM(textForegroundStyle.mo4973getColor0d7_KjU(), textForegroundStyle2.mo4973getColor0d7_KjU(), f));
    }

    /* JADX INFO: renamed from: modulate-DxMtmZc, reason: not valid java name */
    public static final long m5084modulateDxMtmZc(long j, float f) {
        return (Float.isNaN(f) || f >= 1.0f) ? j : Color.m3031copywmQWz5c$default(j, Color.m3034getAlphaimpl(j) * f, 0.0f, 0.0f, 0.0f, 14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float takeOrElse(float f, InterfaceC3588op interfaceC3588op) {
        return Float.isNaN(f) ? ((Number) interfaceC3588op.invoke()).floatValue() : f;
    }
}
