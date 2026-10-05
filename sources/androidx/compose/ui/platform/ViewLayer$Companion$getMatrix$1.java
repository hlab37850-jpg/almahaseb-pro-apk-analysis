package androidx.compose.ui.platform;

import android.graphics.Matrix;
import android.view.View;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class ViewLayer$Companion$getMatrix$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    public static final ViewLayer$Companion$getMatrix$1 INSTANCE = new ViewLayer$Companion$getMatrix$1();

    public ViewLayer$Companion$getMatrix$1() {
        super(2);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        invoke((View) obj, (Matrix) obj2);
        return FW.a;
    }

    public final void invoke(View view, Matrix matrix) {
        AbstractC4492zt.h(view, "view");
        AbstractC4492zt.h(matrix, "matrix");
        matrix.set(view.getMatrix());
    }
}
