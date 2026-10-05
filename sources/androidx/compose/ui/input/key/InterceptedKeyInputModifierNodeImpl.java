package androidx.compose.ui.input.key;

import androidx.compose.ui.Modifier;
import androidx.core.app.NotificationCompat;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
final class InterceptedKeyInputModifierNodeImpl extends Modifier.Node implements SoftKeyboardInterceptionModifierNode {
    private InterfaceC3750qp onEvent;
    private InterfaceC3750qp onPreEvent;

    public InterceptedKeyInputModifierNodeImpl(InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2) {
        this.onEvent = interfaceC3750qp;
        this.onPreEvent = interfaceC3750qp2;
    }

    public final InterfaceC3750qp getOnEvent() {
        return this.onEvent;
    }

    public final InterfaceC3750qp getOnPreEvent() {
        return this.onPreEvent;
    }

    @Override // androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode
    /* JADX INFO: renamed from: onInterceptKeyBeforeSoftKeyboard-ZmokQxo, reason: not valid java name */
    public boolean mo3626onInterceptKeyBeforeSoftKeyboardZmokQxo(android.view.KeyEvent keyEvent) {
        AbstractC4492zt.h(keyEvent, NotificationCompat.CATEGORY_EVENT);
        InterfaceC3750qp interfaceC3750qp = this.onEvent;
        if (interfaceC3750qp != null) {
            return ((Boolean) interfaceC3750qp.invoke(KeyEvent.m3922boximpl(keyEvent))).booleanValue();
        }
        return false;
    }

    @Override // androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode
    /* JADX INFO: renamed from: onPreInterceptKeyBeforeSoftKeyboard-ZmokQxo, reason: not valid java name */
    public boolean mo3627onPreInterceptKeyBeforeSoftKeyboardZmokQxo(android.view.KeyEvent keyEvent) {
        AbstractC4492zt.h(keyEvent, NotificationCompat.CATEGORY_EVENT);
        InterfaceC3750qp interfaceC3750qp = this.onPreEvent;
        if (interfaceC3750qp != null) {
            return ((Boolean) interfaceC3750qp.invoke(KeyEvent.m3922boximpl(keyEvent))).booleanValue();
        }
        return false;
    }

    public final void setOnEvent(InterfaceC3750qp interfaceC3750qp) {
        this.onEvent = interfaceC3750qp;
    }

    public final void setOnPreEvent(InterfaceC3750qp interfaceC3750qp) {
        this.onPreEvent = interfaceC3750qp;
    }
}
