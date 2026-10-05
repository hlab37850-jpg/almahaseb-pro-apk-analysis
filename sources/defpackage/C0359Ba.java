package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: Ba, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0359Ba extends AtomicReference implements InterfaceC0624Jj {
    public C0359Ba(InterfaceC4212wa interfaceC4212wa) {
        super(interfaceC4212wa);
    }

    @Override // defpackage.InterfaceC0624Jj
    public void dispose() {
        InterfaceC4212wa interfaceC4212wa;
        if (get() == null || (interfaceC4212wa = (InterfaceC4212wa) getAndSet(null)) == null) {
            return;
        }
        try {
            interfaceC4212wa.cancel();
        } catch (Throwable th) {
            AbstractC0722Ll.b(th);
            FM.m(th);
        }
    }

    @Override // defpackage.InterfaceC0624Jj
    public boolean isDisposed() {
        return get() == null;
    }
}
