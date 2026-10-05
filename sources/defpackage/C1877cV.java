package defpackage;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: cV, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1877cV extends AN {
    public static final C1877cV a = new C1877cV();

    /* JADX INFO: renamed from: cV$a */
    public static final class a implements Runnable {
        public final Runnable a;
        public final c b;
        public final long c;

        public a(Runnable runnable, c cVar, long j) {
            this.a = runnable;
            this.b = cVar;
            this.c = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.b.d) {
                return;
            }
            long jA = this.b.a(TimeUnit.MILLISECONDS);
            long j = this.c;
            if (j > jA) {
                try {
                    Thread.sleep(j - jA);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    FM.m(e);
                    return;
                }
            }
            if (this.b.d) {
                return;
            }
            this.a.run();
        }
    }

    /* JADX INFO: renamed from: cV$b */
    public static final class b implements Comparable {
        public final Runnable a;
        public final long b;
        public final int c;
        public volatile boolean d;

        public b(Runnable runnable, Long l, int i) {
            this.a = runnable;
            this.b = l.longValue();
            this.c = i;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            int iCompare = Long.compare(this.b, bVar.b);
            return iCompare == 0 ? Integer.compare(this.c, bVar.c) : iCompare;
        }
    }

    /* JADX INFO: renamed from: cV$c */
    public static final class c extends AN.c implements InterfaceC0624Jj {
        public final PriorityBlockingQueue a = new PriorityBlockingQueue();
        public final AtomicInteger b = new AtomicInteger();
        public final AtomicInteger c = new AtomicInteger();
        public volatile boolean d;

        /* JADX INFO: renamed from: cV$c$a */
        public final class a implements Runnable {
            public final b a;

            public a(b bVar) {
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.d = true;
                c.this.a.remove(this.a);
            }
        }

        @Override // AN.c
        public InterfaceC0624Jj b(Runnable runnable) {
            return e(runnable, a(TimeUnit.MILLISECONDS));
        }

        @Override // AN.c
        public InterfaceC0624Jj c(Runnable runnable, long j, TimeUnit timeUnit) {
            long jA = a(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j);
            return e(new a(runnable, this, jA), jA);
        }

        @Override // defpackage.InterfaceC0624Jj
        public void dispose() {
            this.d = true;
        }

        public InterfaceC0624Jj e(Runnable runnable, long j) {
            if (this.d) {
                return EnumC1255al.INSTANCE;
            }
            b bVar = new b(runnable, Long.valueOf(j), this.c.incrementAndGet());
            this.a.add(bVar);
            if (this.b.getAndIncrement() != 0) {
                return AbstractC0598Ij.c(new a(bVar));
            }
            int iAddAndGet = 1;
            while (!this.d) {
                b bVar2 = (b) this.a.poll();
                if (bVar2 == null) {
                    iAddAndGet = this.b.addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return EnumC1255al.INSTANCE;
                    }
                } else if (!bVar2.d) {
                    bVar2.a.run();
                }
            }
            this.a.clear();
            return EnumC1255al.INSTANCE;
        }

        @Override // defpackage.InterfaceC0624Jj
        public boolean isDisposed() {
            return this.d;
        }
    }

    public static C1877cV a() {
        return a;
    }

    @Override // defpackage.AN
    public AN.c createWorker() {
        return new c();
    }

    @Override // defpackage.AN
    public InterfaceC0624Jj scheduleDirect(Runnable runnable) {
        FM.o(runnable).run();
        return EnumC1255al.INSTANCE;
    }

    @Override // defpackage.AN
    public InterfaceC0624Jj scheduleDirect(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j);
            FM.o(runnable).run();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            FM.m(e);
        }
        return EnumC1255al.INSTANCE;
    }
}
