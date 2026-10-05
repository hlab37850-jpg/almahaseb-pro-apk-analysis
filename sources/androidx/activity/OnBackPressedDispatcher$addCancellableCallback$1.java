package androidx.activity;

import defpackage.C0916Sp;
import defpackage.FW;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class OnBackPressedDispatcher$addCancellableCallback$1 extends C0916Sp implements InterfaceC3588op {
    public OnBackPressedDispatcher$addCancellableCallback$1(Object obj) {
        super(0, obj, OnBackPressedDispatcher.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
    }

    @Override // defpackage.InterfaceC3588op
    public /* bridge */ /* synthetic */ Object invoke() {
        m6invoke();
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m6invoke() {
        ((OnBackPressedDispatcher) this.receiver).updateEnabledCallbacks();
    }
}
