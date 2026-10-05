package androidx.activity;

import androidx.annotation.MainThread;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class OnBackPressedCallback {
    private final CopyOnWriteArrayList<Cancellable> cancellables = new CopyOnWriteArrayList<>();
    private InterfaceC3588op enabledChangedCallback;
    private boolean isEnabled;

    public OnBackPressedCallback(boolean z) {
        this.isEnabled = z;
    }

    public final void addCancellable(Cancellable cancellable) {
        AbstractC4492zt.h(cancellable, "cancellable");
        this.cancellables.add(cancellable);
    }

    public final InterfaceC3588op getEnabledChangedCallback$activity_release() {
        return this.enabledChangedCallback;
    }

    @MainThread
    public void handleOnBackCancelled() {
    }

    @MainThread
    public abstract void handleOnBackPressed();

    @MainThread
    public void handleOnBackProgressed(BackEventCompat backEventCompat) {
        AbstractC4492zt.h(backEventCompat, "backEvent");
    }

    @MainThread
    public void handleOnBackStarted(BackEventCompat backEventCompat) {
        AbstractC4492zt.h(backEventCompat, "backEvent");
    }

    @MainThread
    public final boolean isEnabled() {
        return this.isEnabled;
    }

    @MainThread
    public final void remove() {
        Iterator<T> it = this.cancellables.iterator();
        while (it.hasNext()) {
            ((Cancellable) it.next()).cancel();
        }
    }

    public final void removeCancellable(Cancellable cancellable) {
        AbstractC4492zt.h(cancellable, "cancellable");
        this.cancellables.remove(cancellable);
    }

    @MainThread
    public final void setEnabled(boolean z) {
        this.isEnabled = z;
        InterfaceC3588op interfaceC3588op = this.enabledChangedCallback;
        if (interfaceC3588op != null) {
            interfaceC3588op.invoke();
        }
    }

    public final void setEnabledChangedCallback$activity_release(InterfaceC3588op interfaceC3588op) {
        this.enabledChangedCallback = interfaceC3588op;
    }
}
