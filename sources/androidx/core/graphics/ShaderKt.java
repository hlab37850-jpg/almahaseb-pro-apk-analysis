package androidx.core.graphics;

import android.graphics.Matrix;
import android.graphics.Shader;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class ShaderKt {
    public static final void transform(Shader shader, InterfaceC3750qp interfaceC3750qp) {
        Matrix matrix = new Matrix();
        shader.getLocalMatrix(matrix);
        interfaceC3750qp.invoke(matrix);
        shader.setLocalMatrix(matrix);
    }
}
