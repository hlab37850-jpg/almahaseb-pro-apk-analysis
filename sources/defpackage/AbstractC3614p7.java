package defpackage;

/* JADX INFO: renamed from: p7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3614p7 implements InterfaceC0792Oe, InterfaceC2023dJ {
    public final InterfaceC0792Oe a;
    public PS b;
    public InterfaceC2023dJ c;
    public boolean d;
    public int e;

    public AbstractC3614p7(InterfaceC0792Oe interfaceC0792Oe) {
        this.a = interfaceC0792Oe;
    }

    @Override // defpackage.InterfaceC4071un
    public final void a(PS ps) {
        if (RS.i(this.b, ps)) {
            this.b = ps;
            if (ps instanceof InterfaceC2023dJ) {
                this.c = (InterfaceC2023dJ) ps;
            }
            if (e()) {
                this.a.a(this);
                d();
            }
        }
    }

    @Override // defpackage.PS
    public void cancel() {
        this.b.cancel();
    }

    @Override // defpackage.InterfaceC4283xQ
    public void clear() {
        this.c.clear();
    }

    public boolean e() {
        return true;
    }

    public final void f(Throwable th) {
        AbstractC0722Ll.b(th);
        this.b.cancel();
        onError(th);
    }

    @Override // defpackage.InterfaceC4283xQ
    public boolean isEmpty() {
        return this.c.isEmpty();
    }

    @Override // defpackage.PS
    public void l(long j) {
        this.b.l(j);
    }

    @Override // defpackage.InterfaceC4283xQ
    public final boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // defpackage.NS
    public void onComplete() {
        if (this.d) {
            return;
        }
        this.d = true;
        this.a.onComplete();
    }

    @Override // defpackage.NS
    public void onError(Throwable th) {
        if (this.d) {
            FM.m(th);
        } else {
            this.d = true;
            this.a.onError(th);
        }
    }

    public void d() {
    }
}
