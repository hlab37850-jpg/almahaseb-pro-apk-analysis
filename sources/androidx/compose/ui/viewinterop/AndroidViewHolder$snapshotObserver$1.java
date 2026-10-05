package androidx.compose.ui.viewinterop;

import android.os.Looper;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidViewHolder$snapshotObserver$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ AndroidViewHolder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidViewHolder$snapshotObserver$1(AndroidViewHolder androidViewHolder) {
        super(1);
        this.this$0 = androidViewHolder;
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
        if (this.this$0.getHandler().getLooper() == Looper.myLooper()) {
            interfaceC3588op.invoke();
        } else {
            this.this$0.getHandler().post(new Runnable() { // from class: androidx.compose.ui.viewinterop.b
                @Override // java.lang.Runnable
                public final void run() {
                    AndroidViewHolder$snapshotObserver$1.invoke$lambda$0(interfaceC3588op);
                }
            });
        }
    }
}
