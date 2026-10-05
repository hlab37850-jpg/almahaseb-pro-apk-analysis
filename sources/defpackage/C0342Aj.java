package defpackage;

import androidx.core.app.NotificationCompat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: Aj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0342Aj {
    public Runnable c;
    public ExecutorService d;
    public int a = 64;
    public int b = 5;
    public final ArrayDeque e = new ArrayDeque();
    public final ArrayDeque f = new ArrayDeque();
    public final ArrayDeque g = new ArrayDeque();

    public final void a(BJ.a aVar) {
        BJ.a aVarC;
        AbstractC4492zt.h(aVar, NotificationCompat.CATEGORY_CALL);
        synchronized (this) {
            try {
                this.e.add(aVar);
                if (!aVar.b().n() && (aVarC = c(aVar.d())) != null) {
                    aVar.e(aVarC);
                }
                FW fw = FW.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        f();
    }

    public final synchronized ExecutorService b() {
        ExecutorService executorService;
        try {
            if (this.d == null) {
                this.d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), AbstractC3724qX.M(AbstractC3724qX.i + " Dispatcher", false));
            }
            executorService = this.d;
            AbstractC4492zt.e(executorService);
        } catch (Throwable th) {
            throw th;
        }
        return executorService;
    }

    public final BJ.a c(String str) {
        for (BJ.a aVar : this.f) {
            if (AbstractC4492zt.d(aVar.d(), str)) {
                return aVar;
            }
        }
        for (BJ.a aVar2 : this.e) {
            if (AbstractC4492zt.d(aVar2.d(), str)) {
                return aVar2;
            }
        }
        return null;
    }

    public final void d(Deque deque, Object obj) {
        Runnable runnable;
        synchronized (this) {
            if (!deque.remove(obj)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            runnable = this.c;
            FW fw = FW.a;
        }
        if (f() || runnable == null) {
            return;
        }
        runnable.run();
    }

    public final void e(BJ.a aVar) {
        AbstractC4492zt.h(aVar, NotificationCompat.CATEGORY_CALL);
        aVar.c().decrementAndGet();
        d(this.f, aVar);
    }

    public final boolean f() {
        int i;
        boolean z;
        if (AbstractC3724qX.h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            try {
                Iterator it = this.e.iterator();
                AbstractC4492zt.g(it, "readyAsyncCalls.iterator()");
                while (it.hasNext()) {
                    BJ.a aVar = (BJ.a) it.next();
                    if (this.f.size() >= this.a) {
                        break;
                    }
                    if (aVar.c().get() < this.b) {
                        it.remove();
                        aVar.c().incrementAndGet();
                        AbstractC4492zt.g(aVar, "asyncCall");
                        arrayList.add(aVar);
                        this.f.add(aVar);
                    }
                }
                z = g() > 0;
                FW fw = FW.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        int size = arrayList.size();
        for (i = 0; i < size; i++) {
            ((BJ.a) arrayList.get(i)).a(b());
        }
        return z;
    }

    public final synchronized int g() {
        return this.f.size() + this.g.size();
    }
}
