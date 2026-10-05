package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public final class OL implements Runnable {
    public final AbstractC1040Xf a;
    public final InterfaceC4293xa b;

    public OL(AbstractC1040Xf abstractC1040Xf, InterfaceC4293xa interfaceC4293xa) {
        this.a = abstractC1040Xf;
        this.b = interfaceC4293xa;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.h(this.a, FW.a);
    }
}
