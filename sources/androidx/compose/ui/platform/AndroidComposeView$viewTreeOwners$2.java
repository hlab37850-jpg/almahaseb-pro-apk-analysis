package androidx.compose.ui.platform;

import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidComposeView$viewTreeOwners$2 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ AndroidComposeView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidComposeView$viewTreeOwners$2(AndroidComposeView androidComposeView) {
        super(0);
        this.this$0 = androidComposeView;
    }

    @Override // defpackage.InterfaceC3588op
    public final AndroidComposeView.ViewTreeOwners invoke() {
        return this.this$0.get_viewTreeOwners();
    }
}
