package androidx.compose.ui.viewinterop;

import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class ViewFactoryHolder$releaseBlock$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ ViewFactoryHolder<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewFactoryHolder$releaseBlock$1(ViewFactoryHolder<T> viewFactoryHolder) {
        super(0);
        this.this$0 = viewFactoryHolder;
    }

    @Override // defpackage.InterfaceC3588op
    public /* bridge */ /* synthetic */ Object invoke() {
        m5402invoke();
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m5402invoke() {
        this.this$0.getReleaseBlock().invoke(((ViewFactoryHolder) this.this$0).typedView);
        this.this$0.unregisterSaveStateProvider();
    }
}
