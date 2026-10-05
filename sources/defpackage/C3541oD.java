package defpackage;

import android.net.TrafficStats;
import android.os.Process;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: renamed from: oD, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C3541oD extends Thread {
    public final BlockingQueue a;
    public final InterfaceC3213kD b;
    public final InterfaceC2339h9 c;
    public final GL d;
    public volatile boolean e = false;

    public C3541oD(BlockingQueue blockingQueue, InterfaceC3213kD interfaceC3213kD, InterfaceC2339h9 interfaceC2339h9, GL gl) {
        this.a = blockingQueue;
        this.b = interfaceC3213kD;
        this.c = interfaceC2339h9;
        this.d = gl;
    }

    public final void a(AbstractC3712qL abstractC3712qL, C2119eY c2119eY) {
        this.d.c(abstractC3712qL, abstractC3712qL.B(c2119eY));
    }

    public void b() {
        this.e = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                AbstractC3712qL abstractC3712qL = (AbstractC3712qL) this.a.take();
                try {
                    abstractC3712qL.b("network-queue-take");
                    if (abstractC3712qL.z()) {
                        abstractC3712qL.g("network-discard-cancelled");
                    } else {
                        TrafficStats.setThreadStatsTag(abstractC3712qL.w());
                        C3865sD c3865sDA = this.b.a(abstractC3712qL);
                        abstractC3712qL.b("network-http-complete");
                        if (c3865sDA.d && abstractC3712qL.y()) {
                            abstractC3712qL.g("not-modified");
                        } else {
                            DL dlC = abstractC3712qL.C(c3865sDA);
                            abstractC3712qL.b("network-parse-complete");
                            if (abstractC3712qL.J() && dlC.b != null) {
                                this.c.a(abstractC3712qL.k(), dlC.b);
                                abstractC3712qL.b("network-cache-written");
                            }
                            abstractC3712qL.A();
                            this.d.a(abstractC3712qL, dlC);
                        }
                    }
                } catch (C2119eY e) {
                    a(abstractC3712qL, e);
                } catch (Exception e2) {
                    AbstractC2201fY.d(e2, "Unhandled exception %s", e2.toString());
                    this.d.c(abstractC3712qL, new C2119eY(e2));
                }
            } catch (InterruptedException unused) {
                if (this.e) {
                    return;
                }
            }
        }
    }
}
