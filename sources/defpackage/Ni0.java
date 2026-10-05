package defpackage;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final class Ni0 implements Runnable {
    public final /* synthetic */ ui0 a;
    public final /* synthetic */ Callable b;

    public Ni0(ui0 ui0Var, Callable callable) {
        this.a = ui0Var;
        this.b = callable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.a.b(this.b.call());
        } catch (Exception e) {
            this.a.a(e);
        } catch (Throwable th) {
            this.a.a(new RuntimeException(th));
        }
    }
}
