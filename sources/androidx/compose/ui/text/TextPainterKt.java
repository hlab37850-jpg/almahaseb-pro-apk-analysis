package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDrawStyleKt;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import defpackage.AbstractC1210aB;
import defpackage.AbstractC3337lk;
import defpackage.AbstractC4492zt;
import java.util.List;
import org.apache.poi.hssf.record.BOFRecord;

/* JADX INFO: loaded from: classes.dex */
public final class TextPainterKt {
    private static final void clip(DrawTransform drawTransform, TextLayoutResult textLayoutResult) {
        if (!textLayoutResult.getHasVisualOverflow() || TextOverflow.m5106equalsimpl0(textLayoutResult.getLayoutInput().m4674getOverflowgIe3tQ8(), TextOverflow.Companion.m5115getVisiblegIe3tQ8())) {
            return;
        }
        AbstractC3337lk.d(drawTransform, 0.0f, 0.0f, IntSize.m5320getWidthimpl(textLayoutResult.m4678getSizeYbymL2g()), IntSize.m5319getHeightimpl(textLayoutResult.m4678getSizeYbymL2g()), 0, 16, null);
    }

    /* JADX INFO: renamed from: drawText-JFhB2K4, reason: not valid java name */
    public static final void m4684drawTextJFhB2K4(DrawScope drawScope, TextMeasurer textMeasurer, AnnotatedString annotatedString, long j, TextStyle textStyle, int i, boolean z, int i2, List<AnnotatedString.Range<Placeholder>> list, long j2, int i3) {
        AbstractC4492zt.h(drawScope, "$this$drawText");
        AbstractC4492zt.h(textMeasurer, "textMeasurer");
        AbstractC4492zt.h(annotatedString, "text");
        AbstractC4492zt.h(textStyle, "style");
        AbstractC4492zt.h(list, "placeholders");
        TextLayoutResult textLayoutResultM4681measurexDpz5zY$default = TextMeasurer.m4681measurexDpz5zY$default(textMeasurer, annotatedString, textStyle, i, z, i2, list, m4692textLayoutConstraintsv_w8tDc(drawScope, j2, j), drawScope.getLayoutDirection(), drawScope, null, false, BOFRecord.VERSION, null);
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo3475getSizeNHjbRc = drawContext.mo3475getSizeNHjbRc();
        drawContext.getCanvas().save();
        DrawTransform transform = drawContext.getTransform();
        transform.translate(Offset.m2798getXimpl(j), Offset.m2799getYimpl(j));
        clip(transform, textLayoutResultM4681measurexDpz5zY$default);
        textLayoutResultM4681measurexDpz5zY$default.getMultiParagraph().m4598paintLG529CI(drawScope.getDrawContext().getCanvas(), (32 & 2) != 0 ? Color.Companion.m3068getUnspecified0d7_KjU() : 0L, (32 & 4) != 0 ? null : null, (32 & 8) != 0 ? null : null, (32 & 16) == 0 ? null : null, (32 & 32) != 0 ? DrawScope.Companion.m3499getDefaultBlendMode0nO6VwU() : i3);
        drawContext.getCanvas().restore();
        drawContext.mo3476setSizeuvyYCjk(jMo3475getSizeNHjbRc);
    }

    /* JADX INFO: renamed from: drawText-LVfH_YU, reason: not valid java name */
    public static final void m4686drawTextLVfH_YU(DrawScope drawScope, TextLayoutResult textLayoutResult, Brush brush, long j, float f, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int i) {
        AbstractC4492zt.h(drawScope, "$this$drawText");
        AbstractC4492zt.h(textLayoutResult, "textLayoutResult");
        AbstractC4492zt.h(brush, "brush");
        Shadow shadow2 = shadow == null ? textLayoutResult.getLayoutInput().getStyle().getShadow() : shadow;
        TextDecoration textDecoration2 = textDecoration == null ? textLayoutResult.getLayoutInput().getStyle().getTextDecoration() : textDecoration;
        DrawStyle drawStyle2 = drawStyle == null ? textLayoutResult.getLayoutInput().getStyle().getDrawStyle() : drawStyle;
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo3475getSizeNHjbRc = drawContext.mo3475getSizeNHjbRc();
        drawContext.getCanvas().save();
        DrawTransform transform = drawContext.getTransform();
        transform.translate(Offset.m2798getXimpl(j), Offset.m2799getYimpl(j));
        clip(transform, textLayoutResult);
        textLayoutResult.getMultiParagraph().m4600painthn5TExg(drawScope.getDrawContext().getCanvas(), brush, !Float.isNaN(f) ? f : textLayoutResult.getLayoutInput().getStyle().getAlpha(), shadow2, textDecoration2, drawStyle2, i);
        drawContext.getCanvas().restore();
        drawContext.mo3476setSizeuvyYCjk(jMo3475getSizeNHjbRc);
    }

    /* JADX INFO: renamed from: drawText-TPWCCtM, reason: not valid java name */
    public static final void m4688drawTextTPWCCtM(DrawScope drawScope, TextMeasurer textMeasurer, String str, long j, TextStyle textStyle, int i, boolean z, int i2, long j2, int i3) {
        AbstractC4492zt.h(drawScope, "$this$drawText");
        AbstractC4492zt.h(textMeasurer, "textMeasurer");
        AbstractC4492zt.h(str, "text");
        AbstractC4492zt.h(textStyle, "style");
        TextLayoutResult textLayoutResultM4681measurexDpz5zY$default = TextMeasurer.m4681measurexDpz5zY$default(textMeasurer, new AnnotatedString(str, null, null, 6, null), textStyle, i, z, i2, null, m4692textLayoutConstraintsv_w8tDc(drawScope, j2, j), drawScope.getLayoutDirection(), drawScope, null, false, 1568, null);
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo3475getSizeNHjbRc = drawContext.mo3475getSizeNHjbRc();
        drawContext.getCanvas().save();
        DrawTransform transform = drawContext.getTransform();
        transform.translate(Offset.m2798getXimpl(j), Offset.m2799getYimpl(j));
        clip(transform, textLayoutResultM4681measurexDpz5zY$default);
        textLayoutResultM4681measurexDpz5zY$default.getMultiParagraph().m4598paintLG529CI(drawScope.getDrawContext().getCanvas(), (32 & 2) != 0 ? Color.Companion.m3068getUnspecified0d7_KjU() : 0L, (32 & 4) != 0 ? null : null, (32 & 8) != 0 ? null : null, (32 & 16) == 0 ? null : null, (32 & 32) != 0 ? DrawScope.Companion.m3499getDefaultBlendMode0nO6VwU() : i3);
        drawContext.getCanvas().restore();
        drawContext.mo3476setSizeuvyYCjk(jMo3475getSizeNHjbRc);
    }

    /* JADX INFO: renamed from: drawText-d8-rzKo, reason: not valid java name */
    public static final void m4690drawTextd8rzKo(DrawScope drawScope, TextLayoutResult textLayoutResult, long j, long j2, float f, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int i) {
        AbstractC4492zt.h(drawScope, "$this$drawText");
        AbstractC4492zt.h(textLayoutResult, "textLayoutResult");
        Shadow shadow2 = shadow == null ? textLayoutResult.getLayoutInput().getStyle().getShadow() : shadow;
        TextDecoration textDecoration2 = textDecoration == null ? textLayoutResult.getLayoutInput().getStyle().getTextDecoration() : textDecoration;
        DrawStyle drawStyle2 = drawStyle == null ? textLayoutResult.getLayoutInput().getStyle().getDrawStyle() : drawStyle;
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo3475getSizeNHjbRc = drawContext.mo3475getSizeNHjbRc();
        drawContext.getCanvas().save();
        DrawTransform transform = drawContext.getTransform();
        transform.translate(Offset.m2798getXimpl(j2), Offset.m2799getYimpl(j2));
        clip(transform, textLayoutResult);
        Brush brush = textLayoutResult.getLayoutInput().getStyle().getBrush();
        if (brush == null || j != Color.Companion.m3068getUnspecified0d7_KjU()) {
            textLayoutResult.getMultiParagraph().m4598paintLG529CI(drawScope.getDrawContext().getCanvas(), TextDrawStyleKt.m5084modulateDxMtmZc(j != Color.Companion.m3068getUnspecified0d7_KjU() ? j : textLayoutResult.getLayoutInput().getStyle().m4726getColor0d7_KjU(), f), shadow2, textDecoration2, drawStyle2, i);
        } else {
            textLayoutResult.getMultiParagraph().m4600painthn5TExg(drawScope.getDrawContext().getCanvas(), brush, !Float.isNaN(f) ? f : textLayoutResult.getLayoutInput().getStyle().getAlpha(), shadow2, textDecoration2, drawStyle2, i);
        }
        drawContext.getCanvas().restore();
        drawContext.mo3476setSizeuvyYCjk(jMo3475getSizeNHjbRc);
    }

    /* JADX INFO: renamed from: textLayoutConstraints-v_w8tDc, reason: not valid java name */
    private static final long m4692textLayoutConstraintsv_w8tDc(DrawScope drawScope, long j, long j2) {
        int iC;
        int iC2;
        int iC3;
        Size.Companion companion = Size.Companion;
        int iC4 = 0;
        if (j == companion.m2875getUnspecifiedNHjbRc() || Float.isNaN(Size.m2867getWidthimpl(j))) {
            iC = AbstractC1210aB.c((float) Math.ceil(Size.m2867getWidthimpl(drawScope.mo3469getSizeNHjbRc()) - Offset.m2798getXimpl(j2)));
            iC2 = 0;
        } else {
            iC2 = AbstractC1210aB.c((float) Math.ceil(Size.m2867getWidthimpl(j)));
            iC = iC2;
        }
        if (j == companion.m2875getUnspecifiedNHjbRc() || Float.isNaN(Size.m2864getHeightimpl(j))) {
            iC3 = AbstractC1210aB.c((float) Math.ceil(Size.m2864getHeightimpl(drawScope.mo3469getSizeNHjbRc()) - Offset.m2799getYimpl(j2)));
        } else {
            iC4 = AbstractC1210aB.c((float) Math.ceil(Size.m2864getHeightimpl(j)));
            iC3 = iC4;
        }
        return ConstraintsKt.Constraints(iC2, iC, iC4, iC3);
    }
}
