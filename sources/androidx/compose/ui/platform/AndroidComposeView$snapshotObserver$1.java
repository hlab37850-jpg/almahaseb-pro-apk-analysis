package androidx.compose.ui.platform;

import android.os.Handler;
import android.os.Looper;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidComposeView$snapshotObserver$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ AndroidComposeView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidComposeView$snapshotObserver$1(AndroidComposeView androidComposeView) {
        super(1);
        this.this$0 = androidComposeView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3588op, "$tmp0");
        interfaceC3588op.invoke();
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InterfaceC3588op) obj);
        return FW.a;
    }

    public final void invoke(final InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3588op, HTML.Tag.COMMAND);
        Handler handler = this.this$0.getHandler();
        if ((handler != null ? handler.getLooper() : null) == Looper.myLooper()) {
            interfaceC3588op.invoke();
            return;
        }
        Handler handler2 = this.this$0.getHandler();
        if (handler2 != null) {
            handler2.post(new Runnable() { // from class: androidx.compose.ui.platform.a
                @Override // java.lang.Runnable
                public final void run() {
                    AndroidComposeView$snapshotObserver$1.invoke$lambda$0(interfaceC3588op);
                }
            });
        }
    }
}
