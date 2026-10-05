package androidx.compose.ui.platform;

import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC3588op;
import defpackage.OJ;

/* JADX INFO: loaded from: classes.dex */
public final class ViewCompositionStrategy$DisposeOnViewTreeLifecycleDestroyed$installFor$2 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ OJ $disposer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewCompositionStrategy$DisposeOnViewTreeLifecycleDestroyed$installFor$2(OJ oj) {
        super(0);
        this.$disposer = oj;
    }

    @Override // defpackage.InterfaceC3588op
    public /* bridge */ /* synthetic */ Object invoke() {
        m4527invoke();
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m4527invoke() {
        ((InterfaceC3588op) this.$disposer.a).invoke();
    }
}
