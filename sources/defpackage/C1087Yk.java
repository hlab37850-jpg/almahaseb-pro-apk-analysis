package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: Yk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1087Yk extends AtomicReference implements InterfaceC1809be, InterfaceC0624Jj {
    @Override // defpackage.InterfaceC1809be
    public void a(InterfaceC0624Jj interfaceC0624Jj) {
        EnumC0771Nj.h(this, interfaceC0624Jj);
    }

    @Override // defpackage.InterfaceC0624Jj
    public void dispose() {
        EnumC0771Nj.a(this);
    }

    @Override // defpackage.InterfaceC0624Jj
    public boolean isDisposed() {
        return get() == EnumC0771Nj.DISPOSED;
    }

    @Override // defpackage.InterfaceC1809be
    public void onComplete() {
        lazySet(EnumC0771Nj.DISPOSED);
    }
}
