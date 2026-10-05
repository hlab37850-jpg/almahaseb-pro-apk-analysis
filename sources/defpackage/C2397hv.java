package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: hv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C2397hv extends AtomicReference implements InterfaceC4071un, PS, InterfaceC0624Jj {
    public final InterfaceC2295gf a;
    public final InterfaceC2295gf b;
    public final Y1 c;
    public final InterfaceC2295gf d;

    public C2397hv(InterfaceC2295gf interfaceC2295gf, InterfaceC2295gf interfaceC2295gf2, Y1 y1, InterfaceC2295gf interfaceC2295gf3) {
        this.a = interfaceC2295gf;
        this.b = interfaceC2295gf2;
        this.c = y1;
        this.d = interfaceC2295gf3;
    }

    @Override // defpackage.InterfaceC4071un
    public void a(PS ps) {
        if (RS.f(this, ps)) {
            try {
                this.d.accept(this);
            } catch (Throwable th) {
                AbstractC0722Ll.b(th);
                ps.cancel();
                onError(th);
            }
        }
    }

    @Override // defpackage.NS
    public void b(Object obj) {
        if (isDisposed()) {
            return;
        }
        try {
            this.a.accept(obj);
        } catch (Throwable th) {
            AbstractC0722Ll.b(th);
            ((PS) get()).cancel();
            onError(th);
        }
    }

    @Override // defpackage.PS
    public void cancel() {
        RS.a(this);
    }

    @Override // defpackage.InterfaceC0624Jj
    public void dispose() {
        cancel();
    }

    @Override // defpackage.InterfaceC0624Jj
    public boolean isDisposed() {
        return get() == RS.CANCELLED;
    }

    @Override // defpackage.PS
    public void l(long j) {
        ((PS) get()).l(j);
    }

    @Override // defpackage.NS
    public void onComplete() {
        Object obj = get();
        RS rs = RS.CANCELLED;
        if (obj != rs) {
            lazySet(rs);
            try {
                this.c.run();
            } catch (Throwable th) {
                AbstractC0722Ll.b(th);
                FM.m(th);
            }
        }
    }

    @Override // defpackage.NS
    public void onError(Throwable th) {
        Object obj = get();
        RS rs = RS.CANCELLED;
        if (obj == rs) {
            FM.m(th);
            return;
        }
        lazySet(rs);
        try {
            this.b.accept(th);
        } catch (Throwable th2) {
            AbstractC0722Ll.b(th2);
            FM.m(new C0441Ee(th, th2));
        }
    }
}
