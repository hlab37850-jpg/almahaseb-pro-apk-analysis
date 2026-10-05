package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public final class AT extends AbstractRunnableC4205wT {
    public final Runnable c;

    public AT(Runnable runnable, long j, InterfaceC4286xT interfaceC4286xT) {
        super(j, interfaceC4286xT);
        this.c = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.c.run();
        } finally {
            this.b.a();
        }
    }

    public String toString() {
        return "Task[" + AbstractC3498ni.a(this.c) + '@' + AbstractC3498ni.b(this.c) + ", " + this.a + ", " + this.b + ']';
    }
}
