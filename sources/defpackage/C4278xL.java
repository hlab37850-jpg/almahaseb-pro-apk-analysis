package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: xL, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C4278xL {
    public AtomicInteger a;
    public final Map b;
    public final Set c;
    public final PriorityBlockingQueue d;
    public final PriorityBlockingQueue e;
    public final InterfaceC2339h9 f;
    public final InterfaceC3213kD g;
    public final GL h;
    public C3541oD[] i;
    public C3372m9 j;

    public C4278xL(InterfaceC2339h9 interfaceC2339h9, InterfaceC3213kD interfaceC3213kD, int i, GL gl) {
        this.a = new AtomicInteger();
        this.b = new HashMap();
        this.c = new HashSet();
        this.d = new PriorityBlockingQueue();
        this.e = new PriorityBlockingQueue();
        this.f = interfaceC2339h9;
        this.g = interfaceC3213kD;
        this.i = new C3541oD[i];
        this.h = gl;
    }

    public AbstractC3712qL a(AbstractC3712qL abstractC3712qL) {
        abstractC3712qL.E(this);
        synchronized (this.c) {
            this.c.add(abstractC3712qL);
        }
        abstractC3712qL.G(c());
        abstractC3712qL.b("add-to-queue");
        if (!abstractC3712qL.J()) {
            this.e.add(abstractC3712qL);
            return abstractC3712qL;
        }
        synchronized (this.b) {
            try {
                String strK = abstractC3712qL.k();
                if (this.b.containsKey(strK)) {
                    Queue linkedList = (Queue) this.b.get(strK);
                    if (linkedList == null) {
                        linkedList = new LinkedList();
                    }
                    linkedList.add(abstractC3712qL);
                    this.b.put(strK, linkedList);
                    if (AbstractC2201fY.b) {
                        AbstractC2201fY.e("Request for cacheKey=%s is in flight, putting on hold.", strK);
                    }
                } else {
                    this.b.put(strK, null);
                    this.d.add(abstractC3712qL);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return abstractC3712qL;
    }

    public void b(AbstractC3712qL abstractC3712qL) {
        synchronized (this.c) {
            this.c.remove(abstractC3712qL);
        }
        if (abstractC3712qL.J()) {
            synchronized (this.b) {
                try {
                    String strK = abstractC3712qL.k();
                    Queue queue = (Queue) this.b.remove(strK);
                    if (queue != null) {
                        if (AbstractC2201fY.b) {
                            AbstractC2201fY.e("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(queue.size()), strK);
                        }
                        this.d.addAll(queue);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public int c() {
        return this.a.incrementAndGet();
    }

    public void d() {
        e();
        C3372m9 c3372m9 = new C3372m9(this.d, this.e, this.f, this.h);
        this.j = c3372m9;
        c3372m9.start();
        for (int i = 0; i < this.i.length; i++) {
            C3541oD c3541oD = new C3541oD(this.e, this.g, this.f, this.h);
            this.i[i] = c3541oD;
            c3541oD.start();
        }
    }

    public void e() {
        C3372m9 c3372m9 = this.j;
        if (c3372m9 != null) {
            c3372m9.b();
        }
        int i = 0;
        while (true) {
            C3541oD[] c3541oDArr = this.i;
            if (i >= c3541oDArr.length) {
                return;
            }
            C3541oD c3541oD = c3541oDArr[i];
            if (c3541oD != null) {
                c3541oD.b();
            }
            i++;
        }
    }

    public C4278xL(InterfaceC2339h9 interfaceC2339h9, InterfaceC3213kD interfaceC3213kD, int i) {
        this(interfaceC2339h9, interfaceC3213kD, i, new C1046Xl(new Handler(Looper.getMainLooper())));
    }

    public C4278xL(InterfaceC2339h9 interfaceC2339h9, InterfaceC3213kD interfaceC3213kD) {
        this(interfaceC2339h9, interfaceC3213kD, 4);
    }
}
