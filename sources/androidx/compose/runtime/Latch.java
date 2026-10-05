package androidx.compose.runtime;

import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC0352At;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0703Ks;
import defpackage.AbstractC3416mi;
import defpackage.AbstractC4492zt;
import defpackage.C4374ya;
import defpackage.FW;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3588op;
import defpackage.KL;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class Latch {
    private final Object lock = new Object();
    private List<InterfaceC0793Of> awaiters = new ArrayList();
    private List<InterfaceC0793Of> spareList = new ArrayList();
    private boolean _isOpen = true;

    public final Object await(InterfaceC0793Of interfaceC0793Of) {
        if (isOpen()) {
            return FW.a;
        }
        C4374ya c4374ya = new C4374ya(AbstractC0352At.c(interfaceC0793Of), 1);
        c4374ya.A();
        synchronized (this.lock) {
            this.awaiters.add(c4374ya);
        }
        c4374ya.e(new Latch$await$2$2(this, c4374ya));
        Object objX = c4374ya.x();
        if (objX == AbstractC0378Bt.d()) {
            AbstractC3416mi.c(interfaceC0793Of);
        }
        return objX == AbstractC0378Bt.d() ? objX : FW.a;
    }

    public final void closeLatch() {
        synchronized (this.lock) {
            this._isOpen = false;
            FW fw = FW.a;
        }
    }

    public final boolean isOpen() {
        boolean z;
        synchronized (this.lock) {
            z = this._isOpen;
        }
        return z;
    }

    public final void openLatch() {
        synchronized (this.lock) {
            try {
                if (isOpen()) {
                    return;
                }
                List<InterfaceC0793Of> list = this.awaiters;
                this.awaiters = this.spareList;
                this.spareList = list;
                this._isOpen = true;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    InterfaceC0793Of interfaceC0793Of = list.get(i);
                    KL.a aVar = KL.a;
                    interfaceC0793Of.resumeWith(KL.a(FW.a));
                }
                list.clear();
                FW fw = FW.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final <R> R withClosed(InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3588op, CSS.Value.BLOCK);
        closeLatch();
        try {
            return (R) interfaceC3588op.invoke();
        } finally {
            AbstractC0703Ks.b(1);
            openLatch();
            AbstractC0703Ks.a(1);
        }
    }
}
