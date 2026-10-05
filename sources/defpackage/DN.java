package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DN extends AbstractC0994Vl {
    public final int b;
    public final int c;
    public final long d;
    public final String e;
    public ExecutorC1894cg f = G();

    public DN(int i, int i2, long j, String str) {
        this.b = i;
        this.c = i2;
        this.d = j;
        this.e = str;
    }

    public final ExecutorC1894cg G() {
        return new ExecutorC1894cg(this.b, this.c, this.d, this.e);
    }

    public final void H(Runnable runnable, InterfaceC4286xT interfaceC4286xT, boolean z) {
        this.f.r(runnable, interfaceC4286xT, z);
    }

    @Override // defpackage.AbstractC1040Xf
    public void dispatch(InterfaceC0988Vf interfaceC0988Vf, Runnable runnable) {
        ExecutorC1894cg.t(this.f, runnable, null, false, 6, null);
    }

    @Override // defpackage.AbstractC1040Xf
    public void dispatchYield(InterfaceC0988Vf interfaceC0988Vf, Runnable runnable) {
        ExecutorC1894cg.t(this.f, runnable, null, true, 2, null);
    }
}
