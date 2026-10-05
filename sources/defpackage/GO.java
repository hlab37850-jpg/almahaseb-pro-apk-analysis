package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class GO extends AtomicReference implements InterfaceC0624Jj {
    public GO() {
    }

    public boolean a(InterfaceC0624Jj interfaceC0624Jj) {
        return EnumC0771Nj.c(this, interfaceC0624Jj);
    }

    @Override // defpackage.InterfaceC0624Jj
    public void dispose() {
        EnumC0771Nj.a(this);
    }

    @Override // defpackage.InterfaceC0624Jj
    public boolean isDisposed() {
        return EnumC0771Nj.b((InterfaceC0624Jj) get());
    }

    public GO(InterfaceC0624Jj interfaceC0624Jj) {
        lazySet(interfaceC0624Jj);
    }
}
