package defpackage;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: Xl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C1046Xl implements GL {
    public final Executor a;

    /* JADX INFO: renamed from: Xl$a */
    public class a implements Executor {
        public final /* synthetic */ Handler a;

        public a(Handler handler) {
            this.a = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.a.post(runnable);
        }
    }

    /* JADX INFO: renamed from: Xl$b */
    public class b implements Runnable {
        public final AbstractC3712qL a;
        public final DL b;
        public final Runnable c;

        public b(AbstractC3712qL abstractC3712qL, DL dl, Runnable runnable) {
            this.a = abstractC3712qL;
            this.b = dl;
            this.c = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.z()) {
                this.a.g("canceled-at-delivery");
                return;
            }
            if (this.b.b()) {
                this.a.e(this.b.a);
            } else {
                this.a.d(this.b.c);
            }
            if (this.b.d) {
                this.a.b("intermediate-response");
            } else {
                this.a.g("done");
            }
            Runnable runnable = this.c;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public C1046Xl(Handler handler) {
        this.a = new a(handler);
    }

    @Override // defpackage.GL
    public void a(AbstractC3712qL abstractC3712qL, DL dl) {
        b(abstractC3712qL, dl, null);
    }

    @Override // defpackage.GL
    public void b(AbstractC3712qL abstractC3712qL, DL dl, Runnable runnable) {
        abstractC3712qL.A();
        abstractC3712qL.b("post-response");
        this.a.execute(new b(abstractC3712qL, dl, runnable));
    }

    @Override // defpackage.GL
    public void c(AbstractC3712qL abstractC3712qL, C2119eY c2119eY) {
        abstractC3712qL.b("post-error");
        this.a.execute(new b(abstractC3712qL, DL.a(c2119eY), null));
    }
}
