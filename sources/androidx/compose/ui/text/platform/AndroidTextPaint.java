package androidx.compose.ui.text.platform;

import android.text.TextPaint;
import androidx.annotation.VisibleForTesting;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.text.platform.extensions.TextPaintExtensions_androidKt;
import androidx.compose.ui.text.style.TextDecoration;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidTextPaint extends TextPaint {
    private final Paint composePaint;
    private DrawStyle drawStyle;
    private Shadow shadow;
    private TextDecoration textDecoration;

    public AndroidTextPaint(int i, float f) {
        super(i);
        ((TextPaint) this).density = f;
        this.composePaint = AndroidPaint_androidKt.asComposePaint(this);
        this.textDecoration = TextDecoration.Companion.getNone();
        this.shadow = Shadow.Companion.getNone();
    }

    @VisibleForTesting
    public static /* synthetic */ void getShadow$ui_text_release$annotations() {
    }

    /* JADX INFO: renamed from: setBrush-12SF9DM$default, reason: not valid java name */
    public static /* synthetic */ void m4936setBrush12SF9DM$default(AndroidTextPaint androidTextPaint, Brush brush, long j, float f, int i, Object obj) {
        if ((i & 4) != 0) {
            f = Float.NaN;
        }
        androidTextPaint.m4939setBrush12SF9DM(brush, j, f);
    }

    /* JADX INFO: renamed from: getBlendMode-0nO6VwU, reason: not valid java name */
    public final int m4937getBlendMode0nO6VwU() {
        return this.composePaint.mo2912getBlendMode0nO6VwU();
    }

    public final Shadow getShadow$ui_text_release() {
        return this.shadow;
    }

    /* JADX INFO: renamed from: setBlendMode-s9anfk8, reason: not valid java name */
    public final void m4938setBlendModes9anfk8(int i) {
        this.composePaint.mo2918setBlendModes9anfk8(i);
    }

    /* JADX INFO: renamed from: setBrush-12SF9DM, reason: not valid java name */
    public final void m4939setBrush12SF9DM(Brush brush, long j, float f) {
        if (((brush instanceof SolidColor) && ((SolidColor) brush).m3338getValue0d7_KjU() != Color.Companion.m3068getUnspecified0d7_KjU()) || ((brush instanceof ShaderBrush) && j != Size.Companion.m2875getUnspecifiedNHjbRc())) {
            brush.mo2985applyToPq9zytI(j, this.composePaint, Float.isNaN(f) ? this.composePaint.getAlpha() : AbstractC3871sJ.k(f, 0.0f, 1.0f));
        } else if (brush == null) {
            this.composePaint.setShader(null);
        }
    }

    /* JADX INFO: renamed from: setColor-8_81llA, reason: not valid java name */
    public final void m4940setColor8_81llA(long j) {
        if (j != Color.Companion.m3068getUnspecified0d7_KjU()) {
            this.composePaint.mo2919setColor8_81llA(j);
            this.composePaint.setShader(null);
        }
    }

    public final void setDrawStyle(DrawStyle drawStyle) {
        if (drawStyle == null || AbstractC4492zt.d(this.drawStyle, drawStyle)) {
            return;
        }
        this.drawStyle = drawStyle;
        if (AbstractC4492zt.d(drawStyle, Fill.INSTANCE)) {
            this.composePaint.mo2923setStylek9PVt8s(PaintingStyle.Companion.m3273getFillTiuSbCo());
            return;
        }
        if (drawStyle instanceof Stroke) {
            this.composePaint.mo2923setStylek9PVt8s(PaintingStyle.Companion.m3274getStrokeTiuSbCo());
            Stroke stroke = (Stroke) drawStyle;
            this.composePaint.setStrokeWidth(stroke.getWidth());
            this.composePaint.setStrokeMiterLimit(stroke.getMiter());
            this.composePaint.mo2922setStrokeJoinWw9F2mQ(stroke.m3557getJoinLxFBmk8());
            this.composePaint.mo2921setStrokeCapBeK7IIE(stroke.m3556getCapKaPHkGw());
            this.composePaint.setPathEffect(stroke.getPathEffect());
        }
    }

    public final void setShadow(Shadow shadow) {
        if (shadow == null || AbstractC4492zt.d(this.shadow, shadow)) {
            return;
        }
        this.shadow = shadow;
        if (AbstractC4492zt.d(shadow, Shadow.Companion.getNone())) {
            clearShadowLayer();
        } else {
            setShadowLayer(TextPaintExtensions_androidKt.correctBlurRadius(this.shadow.getBlurRadius()), Offset.m2798getXimpl(this.shadow.m3329getOffsetF1C5BW0()), Offset.m2799getYimpl(this.shadow.m3329getOffsetF1C5BW0()), ColorKt.m3086toArgb8_81llA(this.shadow.m3328getColor0d7_KjU()));
        }
    }

    public final void setShadow$ui_text_release(Shadow shadow) {
        AbstractC4492zt.h(shadow, "<set-?>");
        this.shadow = shadow;
    }

    public final void setTextDecoration(TextDecoration textDecoration) {
        if (textDecoration == null || AbstractC4492zt.d(this.textDecoration, textDecoration)) {
            return;
        }
        this.textDecoration = textDecoration;
        TextDecoration.Companion companion = TextDecoration.Companion;
        setUnderlineText(textDecoration.contains(companion.getUnderline()));
        setStrikeThruText(this.textDecoration.contains(companion.getLineThrough()));
    }
}
