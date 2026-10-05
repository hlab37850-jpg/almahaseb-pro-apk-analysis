package defpackage;

/* JADX INFO: renamed from: Dv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC0432Dv extends AbstractC1040Xf implements Runnable, InterfaceC1017Wi {
    public final AbstractC1040Xf a;
    public final int b;
    public final /* synthetic */ InterfaceC1017Wi c;
    public final C0559Gw d;
    public final Object e;
    private volatile int runningWorkers;

    /* JADX WARN: Multi-variable type inference failed */
    public RunnableC0432Dv(AbstractC1040Xf abstractC1040Xf, int i) {
        this.a = abstractC1040Xf;
        this.b = i;
        InterfaceC1017Wi interfaceC1017Wi = abstractC1040Xf instanceof InterfaceC1017Wi ? (InterfaceC1017Wi) abstractC1040Xf : null;
        this.c = interfaceC1017Wi == null ? AbstractC0545Gi.a() : interfaceC1017Wi;
        this.d = new C0559Gw(false);
        this.e = new Object();
    }

    public final boolean G(Runnable runnable) {
        this.d.a(runnable);
        return this.runningWorkers >= this.b;
    }

    public final boolean H() {
        synchronized (this.e) {
            if (this.runningWorkers >= this.b) {
                return false;
            }
            this.runningWorkers++;
            return true;
        }
    }

    @Override // defpackage.InterfaceC1017Wi
    public InterfaceC0745Mj d(long j, Runnable runnable, InterfaceC0988Vf interfaceC0988Vf) {
        return this.c.d(j, runnable, interfaceC0988Vf);
    }

    @Override // defpackage.AbstractC1040Xf
    public void dispatch(InterfaceC0988Vf interfaceC0988Vf, Runnable runnable) {
        if (G(runnable) || !H()) {
            return;
        }
        this.a.dispatch(this, this);
    }

    @Override // defpackage.AbstractC1040Xf
    public void dispatchYield(InterfaceC0988Vf interfaceC0988Vf, Runnable runnable) {
        if (G(runnable) || !H()) {
            return;
        }
        this.a.dispatchYield(this, this);
    }

    @Override // defpackage.InterfaceC1017Wi
    public void g(long j, InterfaceC4293xa interfaceC4293xa) {
        this.c.g(j, interfaceC4293xa);
    }

    @Override // defpackage.AbstractC1040Xf
    public AbstractC1040Xf limitedParallelism(int i) {
        AbstractC0458Ev.a(i);
        return i >= this.b ? this : super.limitedParallelism(i);
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            int i = 0;
            while (true) {
                Runnable runnable = (Runnable) this.d.d();
                if (runnable != null) {
                    try {
                        runnable.run();
                    } catch (Throwable th) {
                        AbstractC1247ag.a(C1172Zk.a, th);
                    }
                    i++;
                    if (i >= 16 && this.a.isDispatchNeeded(this)) {
                        this.a.dispatch(this, this);
                        return;
                    }
                }
            }
            synchronized (this.e) {
                this.runningWorkers--;
                if (this.d.c() == 0) {
                    return;
                }
                this.runningWorkers++;
                FW fw = FW.a;
            }
        }
    }
}
