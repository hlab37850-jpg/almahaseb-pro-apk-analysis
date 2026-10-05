package androidx.compose.ui.viewinterop;

import android.view.View;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidView_androidKt$NoOpUpdate$1 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final AndroidView_androidKt$NoOpUpdate$1 INSTANCE = new AndroidView_androidKt$NoOpUpdate$1();

    public AndroidView_androidKt$NoOpUpdate$1() {
        super(1);
    }

    public final void invoke(View view) {
        AbstractC4492zt.h(view, "$this$null");
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return FW.a;
    }
}
