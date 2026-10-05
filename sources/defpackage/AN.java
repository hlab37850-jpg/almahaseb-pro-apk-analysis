package defpackage;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AN {
    static boolean IS_DRIFT_USE_NANOTIME = Boolean.getBoolean("rx3.scheduler.use-nanotime");
    static final long CLOCK_DRIFT_TOLERANCE_NANOSECONDS = computeClockDrift(Long.getLong("rx3.scheduler.drift-tolerance", 15).longValue(), System.getProperty("rx3.scheduler.drift-tolerance-unit", "minutes"));

    public static final class a implements InterfaceC0624Jj, Runnable {
        public final Runnable a;
        public final c b;
        public Thread c;

        public a(Runnable runnable, c cVar) {
            this.a = runnable;
            this.b = cVar;
        }

        @Override // defpackage.InterfaceC0624Jj
        public void dispose() {
            if (this.c == Thread.currentThread()) {
                c cVar = this.b;
                if (cVar instanceof C4108vD) {
                    ((C4108vD) cVar).h();
                    return;
                }
            }
            this.b.dispose();
        }

        @Override // defpackage.InterfaceC0624Jj
        public boolean isDisposed() {
            return this.b.isDisposed();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.c = Thread.currentThread();
            try {
                this.a.run();
                dispose();
                this.c = null;
            } catch (Throwable th) {
                try {
                    FM.m(th);
                    throw th;
                } catch (Throwable th2) {
                    dispose();
                    this.c = null;
                    throw th2;
                }
            }
        }
    }

    public static final class b implements InterfaceC0624Jj, Runnable {
        public final Runnable a;
        public final c b;
        public volatile boolean c;

        public b(Runnable runnable, c cVar) {
            this.a = runnable;
            this.b = cVar;
        }

        @Override // defpackage.InterfaceC0624Jj
        public void dispose() {
            this.c = true;
            this.b.dispose();
        }

        @Override // defpackage.InterfaceC0624Jj
        public boolean isDisposed() {
            return this.c;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.c) {
                return;
            }
            try {
                this.a.run();
            } catch (Throwable th) {
                dispose();
                FM.m(th);
                throw th;
            }
        }
    }

    public static abstract class c implements InterfaceC0624Jj {

        public final class a implements Runnable {
            public final Runnable a;
            public final GO b;
            public final long c;
            public long d;
            public long e;
            public long f;

            public a(long j, Runnable runnable, long j2, GO go, long j3) {
                this.a = runnable;
                this.b = go;
                this.c = j3;
                this.e = j2;
                this.f = j;
            }

            /* JADX WARN: Code duplicated, block: B:10:0x0035  */
            @Override // java.lang.Runnable
            public void run() {
                long j;
                this.a.run();
                if (this.b.isDisposed()) {
                    return;
                }
                c cVar = c.this;
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                long jA = cVar.a(timeUnit);
                long j2 = AN.CLOCK_DRIFT_TOLERANCE_NANOSECONDS;
                long j3 = jA + j2;
                long j4 = this.e;
                if (j3 >= j4) {
                    long j5 = this.c;
                    if (jA >= j4 + j5 + j2) {
                        long j6 = this.c;
                        long j7 = jA + j6;
                        long j8 = this.d + 1;
                        this.d = j8;
                        this.f = j7 - (j6 * j8);
                        j = j7;
                    } else {
                        long j9 = this.f;
                        long j10 = this.d + 1;
                        this.d = j10;
                        j = j9 + (j10 * j5);
                    }
                } else {
                    long j11 = this.c;
                    long j12 = jA + j11;
                    long j13 = this.d + 1;
                    this.d = j13;
                    this.f = j12 - (j11 * j13);
                    j = j12;
                }
                this.e = jA;
                this.b.a(c.this.c(this, j - jA, timeUnit));
            }
        }

        public long a(TimeUnit timeUnit) {
            return AN.computeNow(timeUnit);
        }

        public InterfaceC0624Jj b(Runnable runnable) {
            return c(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        public abstract InterfaceC0624Jj c(Runnable runnable, long j, TimeUnit timeUnit);

        public InterfaceC0624Jj d(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            GO go = new GO();
            GO go2 = new GO(go);
            Runnable runnableO = FM.o(runnable);
            long nanos = timeUnit.toNanos(j2);
            long jA = a(TimeUnit.NANOSECONDS);
            InterfaceC0624Jj interfaceC0624JjC = c(new a(jA + timeUnit.toNanos(j), runnableO, jA, go2, nanos), j, timeUnit);
            if (interfaceC0624JjC == EnumC1255al.INSTANCE) {
                return interfaceC0624JjC;
            }
            go.a(interfaceC0624JjC);
            return go2;
        }
    }

    public static long clockDriftTolerance() {
        return CLOCK_DRIFT_TOLERANCE_NANOSECONDS;
    }

    public static long computeClockDrift(long j, String str) {
        if ("seconds".equalsIgnoreCase(str)) {
            return TimeUnit.SECONDS.toNanos(j);
        }
        return "milliseconds".equalsIgnoreCase(str) ? TimeUnit.MILLISECONDS.toNanos(j) : TimeUnit.MINUTES.toNanos(j);
    }

    public static long computeNow(TimeUnit timeUnit) {
        return !IS_DRIFT_USE_NANOTIME ? timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS) : timeUnit.convert(System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    public abstract c createWorker();

    public long now(TimeUnit timeUnit) {
        return computeNow(timeUnit);
    }

    public InterfaceC0624Jj scheduleDirect(Runnable runnable) {
        return scheduleDirect(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public InterfaceC0624Jj schedulePeriodicallyDirect(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        c cVarCreateWorker = createWorker();
        b bVar = new b(FM.o(runnable), cVarCreateWorker);
        InterfaceC0624Jj interfaceC0624JjD = cVarCreateWorker.d(bVar, j, j2, timeUnit);
        return interfaceC0624JjD == EnumC1255al.INSTANCE ? interfaceC0624JjD : bVar;
    }

    public <S extends AN & InterfaceC0624Jj> S when(InterfaceC0777Np interfaceC0777Np) {
        Objects.requireNonNull(interfaceC0777Np, "combine is null");
        return new HN(interfaceC0777Np, this);
    }

    public InterfaceC0624Jj scheduleDirect(Runnable runnable, long j, TimeUnit timeUnit) {
        c cVarCreateWorker = createWorker();
        a aVar = new a(FM.o(runnable), cVarCreateWorker);
        cVarCreateWorker.c(aVar, j, timeUnit);
        return aVar;
    }

    public void shutdown() {
    }

    public void start() {
    }
}
