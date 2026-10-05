package defpackage;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: renamed from: m9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C3372m9 extends Thread {
    public static final boolean f = AbstractC2201fY.b;
    public final BlockingQueue a;
    public final BlockingQueue b;
    public final InterfaceC2339h9 c;
    public final GL d;
    public volatile boolean e = false;

    /* JADX INFO: renamed from: m9$a */
    public class a implements Runnable {
        public final /* synthetic */ AbstractC3712qL a;

        public a(AbstractC3712qL abstractC3712qL) {
            this.a = abstractC3712qL;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                C3372m9.this.b.put(this.a);
            } catch (InterruptedException unused) {
            }
        }
    }

    public C3372m9(BlockingQueue blockingQueue, BlockingQueue blockingQueue2, InterfaceC2339h9 interfaceC2339h9, GL gl) {
        this.a = blockingQueue;
        this.b = blockingQueue2;
        this.c = interfaceC2339h9;
        this.d = gl;
    }

    public void b() {
        this.e = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (f) {
            AbstractC2201fY.e("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.c.initialize();
        while (true) {
            try {
                AbstractC3712qL abstractC3712qL = (AbstractC3712qL) this.a.take();
                abstractC3712qL.b("cache-queue-take");
                if (abstractC3712qL.z()) {
                    abstractC3712qL.g("cache-discard-canceled");
                } else {
                    InterfaceC2339h9.a aVar = this.c.get(abstractC3712qL.k());
                    if (aVar == null) {
                        abstractC3712qL.b("cache-miss");
                        this.b.put(abstractC3712qL);
                    } else if (aVar.a()) {
                        abstractC3712qL.b("cache-hit-expired");
                        abstractC3712qL.D(aVar);
                        this.b.put(abstractC3712qL);
                    } else {
                        abstractC3712qL.b("cache-hit");
                        DL dlC = abstractC3712qL.C(new C3865sD(aVar.a, aVar.f));
                        abstractC3712qL.b("cache-hit-parsed");
                        if (aVar.b()) {
                            abstractC3712qL.b("cache-hit-refresh-needed");
                            abstractC3712qL.D(aVar);
                            dlC.d = true;
                            this.d.b(abstractC3712qL, dlC, new a(abstractC3712qL));
                        } else {
                            this.d.a(abstractC3712qL, dlC);
                        }
                    }
                }
            } catch (InterruptedException unused) {
                if (this.e) {
                    return;
                }
            }
        }
    }
}
