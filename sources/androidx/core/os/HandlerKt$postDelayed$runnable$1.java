package androidx.core.os;

import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes2.dex */
public final class HandlerKt$postDelayed$runnable$1 implements Runnable {
    final /* synthetic */ InterfaceC3588op $action;

    public HandlerKt$postDelayed$runnable$1(InterfaceC3588op interfaceC3588op) {
        this.$action = interfaceC3588op;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.$action.invoke();
    }
}
