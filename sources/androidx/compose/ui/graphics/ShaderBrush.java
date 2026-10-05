package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.runtime.Immutable;
import androidx.compose.ui.geometry.Size;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@Immutable
public abstract class ShaderBrush extends Brush {
    private long createdSize;
    private Shader internalShader;

    public ShaderBrush() {
        super(null);
        this.createdSize = Size.Companion.m2875getUnspecifiedNHjbRc();
    }

    @Override // androidx.compose.ui.graphics.Brush
    /* JADX INFO: renamed from: applyTo-Pq9zytI */
    public final void mo2985applyToPq9zytI(long j, Paint paint, float f) {
        AbstractC4492zt.h(paint, "p");
        Shader shaderMo3007createShaderuvyYCjk = this.internalShader;
        if (shaderMo3007createShaderuvyYCjk == null || !Size.m2863equalsimpl0(this.createdSize, j)) {
            if (Size.m2869isEmptyimpl(j)) {
                shaderMo3007createShaderuvyYCjk = null;
                this.internalShader = null;
                this.createdSize = Size.Companion.m2875getUnspecifiedNHjbRc();
            } else {
                shaderMo3007createShaderuvyYCjk = mo3007createShaderuvyYCjk(j);
                this.internalShader = shaderMo3007createShaderuvyYCjk;
                this.createdSize = j;
            }
        }
        long jMo2913getColor0d7_KjU = paint.mo2913getColor0d7_KjU();
        Color.Companion companion = Color.Companion;
        if (!Color.m3033equalsimpl0(jMo2913getColor0d7_KjU, companion.m3058getBlack0d7_KjU())) {
            paint.mo2919setColor8_81llA(companion.m3058getBlack0d7_KjU());
        }
        if (!AbstractC4492zt.d(paint.getShader(), shaderMo3007createShaderuvyYCjk)) {
            paint.setShader(shaderMo3007createShaderuvyYCjk);
        }
        if (paint.getAlpha() == f) {
            return;
        }
        paint.setAlpha(f);
    }

    /* JADX INFO: renamed from: createShader-uvyYCjk */
    public abstract Shader mo3007createShaderuvyYCjk(long j);
}
