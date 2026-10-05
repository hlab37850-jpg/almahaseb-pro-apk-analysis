package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: gv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C2315gv extends AtomicReference implements InterfaceC3866sE, InterfaceC0624Jj {
    public final InterfaceC2295gf a;
    public final InterfaceC2295gf b;
    public final Y1 c;
    public final InterfaceC2295gf d;

    public C2315gv(InterfaceC2295gf interfaceC2295gf, InterfaceC2295gf interfaceC2295gf2, Y1 y1, InterfaceC2295gf interfaceC2295gf3) {
        this.a = interfaceC2295gf;
        this.b = interfaceC2295gf2;
        this.c = y1;
        this.d = interfaceC2295gf3;
    }

    @Override // defpackage.InterfaceC3866sE
    public void a(InterfaceC0624Jj interfaceC0624Jj) {
        if (EnumC0771Nj.h(this, interfaceC0624Jj)) {
            try {
                this.d.accept(this);
            } catch (Throwable th) {
                AbstractC0722Ll.b(th);
                interfaceC0624Jj.dispose();
                onError(th);
            }
        }
    }

    @Override // defpackage.InterfaceC3866sE
    public void b(Object obj) {
        if (isDisposed()) {
            return;
        }
        try {
            this.a.accept(obj);
        } catch (Throwable th) {
            AbstractC0722Ll.b(th);
            ((InterfaceC0624Jj) get()).dispose();
            onError(th);
        }
    }

    @Override // defpackage.InterfaceC0624Jj
    public void dispose() {
        EnumC0771Nj.a(this);
    }

    @Override // defpackage.InterfaceC0624Jj
    public boolean isDisposed() {
        return get() == EnumC0771Nj.DISPOSED;
    }

    @Override // defpackage.InterfaceC3866sE
    public void onComplete() {
        if (isDisposed()) {
            return;
        }
        lazySet(EnumC0771Nj.DISPOSED);
        try {
            this.c.run();
        } catch (Throwable th) {
            AbstractC0722Ll.b(th);
            FM.m(th);
        }
    }

    @Override // defpackage.InterfaceC3866sE
    public void onError(Throwable th) {
        if (isDisposed()) {
            FM.m(th);
            return;
        }
        lazySet(EnumC0771Nj.DISPOSED);
        try {
            this.b.accept(th);
        } catch (Throwable th2) {
            AbstractC0722Ll.b(th2);
            FM.m(new C0441Ee(th, th2));
        }
    }
}
