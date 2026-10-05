package androidx.compose.material;

import android.view.View;
import android.view.ViewTreeObserver;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
final class OnGlobalLayoutListener implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {
    private boolean isListeningToGlobalLayout;
    private final InterfaceC3588op onGlobalLayoutCallback;
    private final View view;

    public OnGlobalLayoutListener(View view, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(view, "view");
        AbstractC4492zt.h(interfaceC3588op, "onGlobalLayoutCallback");
        this.view = view;
        this.onGlobalLayoutCallback = interfaceC3588op;
        view.addOnAttachStateChangeListener(this);
        registerOnGlobalLayoutListener();
    }

    private final void registerOnGlobalLayoutListener() {
        if (this.isListeningToGlobalLayout || !this.view.isAttachedToWindow()) {
            return;
        }
        this.view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.isListeningToGlobalLayout = true;
    }

    private final void unregisterOnGlobalLayoutListener() {
        if (this.isListeningToGlobalLayout) {
            this.view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.isListeningToGlobalLayout = false;
        }
    }

    public final void dispose() {
        unregisterOnGlobalLayoutListener();
        this.view.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.onGlobalLayoutCallback.invoke();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        AbstractC4492zt.h(view, "p0");
        registerOnGlobalLayoutListener();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        AbstractC4492zt.h(view, "p0");
        unregisterOnGlobalLayoutListener();
    }
}
