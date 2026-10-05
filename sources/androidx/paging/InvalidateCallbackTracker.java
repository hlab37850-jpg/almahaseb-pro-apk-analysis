package androidx.paging;

import androidx.annotation.VisibleForTesting;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
public final class InvalidateCallbackTracker<T> {
    private final InterfaceC3750qp callbackInvoker;
    private final List<T> callbacks;
    private boolean invalid;
    private final InterfaceC3588op invalidGetter;
    private final ReentrantLock lock;

    public InvalidateCallbackTracker(InterfaceC3750qp interfaceC3750qp, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3750qp, "callbackInvoker");
        this.callbackInvoker = interfaceC3750qp;
        this.invalidGetter = interfaceC3588op;
        this.lock = new ReentrantLock();
        this.callbacks = new ArrayList();
    }

    @VisibleForTesting
    public final int callbackCount$paging_common() {
        return this.callbacks.size();
    }

    public final boolean getInvalid$paging_common() {
        return this.invalid;
    }

    public final boolean invalidate$paging_common() {
        if (this.invalid) {
            return false;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.invalid) {
                reentrantLock.unlock();
                return false;
            }
            this.invalid = true;
            List listC0 = AbstractC3240kc.C0(this.callbacks);
            this.callbacks.clear();
            FW fw = FW.a;
            reentrantLock.unlock();
            if (listC0 != null) {
                InterfaceC3750qp interfaceC3750qp = this.callbackInvoker;
                Iterator<T> it = listC0.iterator();
                while (it.hasNext()) {
                    interfaceC3750qp.invoke(it.next());
                }
            }
            return true;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void registerInvalidatedCallback$paging_common(T t) {
        InterfaceC3588op interfaceC3588op = this.invalidGetter;
        boolean z = true;
        if (interfaceC3588op != null && ((Boolean) interfaceC3588op.invoke()).booleanValue()) {
            invalidate$paging_common();
        }
        if (this.invalid) {
            this.callbackInvoker.invoke(t);
            return;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.invalid) {
                FW fw = FW.a;
            } else {
                this.callbacks.add(t);
                z = false;
            }
            reentrantLock.unlock();
            if (z) {
                this.callbackInvoker.invoke(t);
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void unregisterInvalidatedCallback$paging_common(T t) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.callbacks.remove(t);
        } finally {
            reentrantLock.unlock();
        }
    }

    public /* synthetic */ InvalidateCallbackTracker(InterfaceC3750qp interfaceC3750qp, InterfaceC3588op interfaceC3588op, int i, AbstractC0419Di abstractC0419Di) {
        this(interfaceC3750qp, (i & 2) != 0 ? null : interfaceC3588op);
    }
}
