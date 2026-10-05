package androidx.compose.ui.graphics;

import android.graphics.Shader;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class BrushKt {
    public static final ShaderBrush ShaderBrush(final Shader shader) {
        AbstractC4492zt.h(shader, "shader");
        return new ShaderBrush() { // from class: androidx.compose.ui.graphics.BrushKt.ShaderBrush.1
            @Override // androidx.compose.ui.graphics.ShaderBrush
            /* JADX INFO: renamed from: createShader-uvyYCjk, reason: not valid java name */
            public Shader mo3007createShaderuvyYCjk(long j) {
                return shader;
            }
        };
    }
}
