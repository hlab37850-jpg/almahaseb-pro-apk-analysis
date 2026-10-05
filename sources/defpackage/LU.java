package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public final class LU extends ON implements Runnable {
    public final long d;

    public LU(long j, InterfaceC0793Of interfaceC0793Of) {
        super(interfaceC0793Of.getContext(), interfaceC0793Of);
        this.d = j;
    }

    @Override // defpackage.G, defpackage.C3674pu
    public String i0() {
        return super.i0() + "(timeMillis=" + this.d + ')';
    }

    @Override // java.lang.Runnable
    public void run() {
        D(NU.a(this.d, this));
    }
}
