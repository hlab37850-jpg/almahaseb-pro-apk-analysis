package androidx.compose.ui.text.platform.style;

import android.graphics.Shader;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.text.platform.AndroidTextPaint_androidKt;
import defpackage.AbstractC4492zt;
import defpackage.C2020dG;
import defpackage.HV;

/* JADX INFO: loaded from: classes.dex */
public final class ShaderBrushSpan extends CharacterStyle implements UpdateAppearance {
    private final float alpha;
    private C2020dG cachedShader;
    private final ShaderBrush shaderBrush;
    private long size;

    public ShaderBrushSpan(ShaderBrush shaderBrush, float f) {
        AbstractC4492zt.h(shaderBrush, "shaderBrush");
        this.shaderBrush = shaderBrush;
        this.alpha = f;
        this.size = Size.Companion.m2875getUnspecifiedNHjbRc();
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final ShaderBrush getShaderBrush() {
        return this.shaderBrush;
    }

    /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
    public final long m4957getSizeNHjbRc() {
        return this.size;
    }

    /* JADX INFO: renamed from: setSize-uvyYCjk, reason: not valid java name */
    public final void m4958setSizeuvyYCjk(long j) {
        this.size = j;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        AbstractC4492zt.h(textPaint, "textPaint");
        AndroidTextPaint_androidKt.setAlpha(textPaint, this.alpha);
        if (this.size == Size.Companion.m2875getUnspecifiedNHjbRc()) {
            return;
        }
        C2020dG c2020dG = this.cachedShader;
        Shader shaderMo3007createShaderuvyYCjk = (c2020dG == null || !Size.m2863equalsimpl0(((Size) c2020dG.c()).m2872unboximpl(), this.size)) ? this.shaderBrush.mo3007createShaderuvyYCjk(this.size) : (Shader) c2020dG.e();
        textPaint.setShader(shaderMo3007createShaderuvyYCjk);
        this.cachedShader = HV.a(Size.m2855boximpl(this.size), shaderMo3007createShaderuvyYCjk);
    }
}
