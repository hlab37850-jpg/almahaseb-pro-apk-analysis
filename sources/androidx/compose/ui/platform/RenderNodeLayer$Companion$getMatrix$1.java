package androidx.compose.ui.platform;

import android.graphics.Matrix;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class RenderNodeLayer$Companion$getMatrix$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    public static final RenderNodeLayer$Companion$getMatrix$1 INSTANCE = new RenderNodeLayer$Companion$getMatrix$1();

    public RenderNodeLayer$Companion$getMatrix$1() {
        super(2);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        invoke((DeviceRenderNode) obj, (Matrix) obj2);
        return FW.a;
    }

    public final void invoke(DeviceRenderNode deviceRenderNode, Matrix matrix) {
        AbstractC4492zt.h(deviceRenderNode, "rn");
        AbstractC4492zt.h(matrix, "matrix");
        deviceRenderNode.getMatrix(matrix);
    }
}
