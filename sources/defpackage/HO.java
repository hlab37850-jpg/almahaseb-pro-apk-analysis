package defpackage;

import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public final class HO implements Executor {
    public static final Logger f = Logger.getLogger(HO.class.getName());
    public final Executor a;
    public final Deque b = new ArrayDeque();
    public c c = c.IDLE;
    public long d = 0;
    public final b e = new b(this, null);

    public class a implements Runnable {
        public final /* synthetic */ Runnable a;

        public a(HO ho, Runnable runnable) {
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.run();
        }

        public String toString() {
            return this.a.toString();
        }
    }

    public final class b implements Runnable {
        public Runnable a;

        public b() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0045, code lost:
        
            if (r1 == false) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0047, code lost:
        
            java.lang.Thread.currentThread().interrupt();
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x004e, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0054, code lost:
        
            r1 = r1 | java.lang.Thread.interrupted();
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0056, code lost:
        
            r9.a.run();
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0060, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0062, code lost:
        
            r3 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0063, code lost:
        
            r4 = defpackage.HO.f;
            r5 = java.util.logging.Level.SEVERE;
            r6 = java.lang.String.valueOf(r9.a);
            r8 = new java.lang.StringBuilder(r6.length() + 35);
            r8.append("Exception while executing runnable ");
            r8.append(r6);
            r4.log(r5, r8.toString(), (java.lang.Throwable) r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x008a, code lost:
        
            r9.a = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x008c, code lost:
        
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:?, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void a() {
            /*
                r9 = this;
                r0 = 0
                r1 = 0
            L2:
                HO r2 = defpackage.HO.this     // Catch: java.lang.Throwable -> L5e
                java.util.Deque r2 = defpackage.HO.a(r2)     // Catch: java.lang.Throwable -> L5e
                monitor-enter(r2)     // Catch: java.lang.Throwable -> L5e
                if (r0 != 0) goto L2d
                HO r0 = defpackage.HO.this     // Catch: java.lang.Throwable -> L20
                HO$c r0 = defpackage.HO.b(r0)     // Catch: java.lang.Throwable -> L20
                HO$c r3 = HO.c.RUNNING     // Catch: java.lang.Throwable -> L20
                if (r0 != r3) goto L22
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
                if (r1 == 0) goto L1f
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.interrupt()
            L1f:
                return
            L20:
                r0 = move-exception
                goto L8d
            L22:
                HO r0 = defpackage.HO.this     // Catch: java.lang.Throwable -> L20
                defpackage.HO.d(r0)     // Catch: java.lang.Throwable -> L20
                HO r0 = defpackage.HO.this     // Catch: java.lang.Throwable -> L20
                defpackage.HO.c(r0, r3)     // Catch: java.lang.Throwable -> L20
                r0 = 1
            L2d:
                HO r3 = defpackage.HO.this     // Catch: java.lang.Throwable -> L20
                java.util.Deque r3 = defpackage.HO.a(r3)     // Catch: java.lang.Throwable -> L20
                java.lang.Object r3 = r3.poll()     // Catch: java.lang.Throwable -> L20
                java.lang.Runnable r3 = (java.lang.Runnable) r3     // Catch: java.lang.Throwable -> L20
                r9.a = r3     // Catch: java.lang.Throwable -> L20
                if (r3 != 0) goto L4f
                HO r0 = defpackage.HO.this     // Catch: java.lang.Throwable -> L20
                HO$c r3 = HO.c.IDLE     // Catch: java.lang.Throwable -> L20
                defpackage.HO.c(r0, r3)     // Catch: java.lang.Throwable -> L20
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
                if (r1 == 0) goto L4e
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.interrupt()
            L4e:
                return
            L4f:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
                boolean r2 = java.lang.Thread.interrupted()     // Catch: java.lang.Throwable -> L5e
                r1 = r1 | r2
                r2 = 0
                java.lang.Runnable r3 = r9.a     // Catch: java.lang.Throwable -> L60 java.lang.RuntimeException -> L62
                r3.run()     // Catch: java.lang.Throwable -> L60 java.lang.RuntimeException -> L62
            L5b:
                r9.a = r2     // Catch: java.lang.Throwable -> L5e
                goto L2
            L5e:
                r0 = move-exception
                goto L8f
            L60:
                r0 = move-exception
                goto L8a
            L62:
                r3 = move-exception
                java.util.logging.Logger r4 = defpackage.HO.e()     // Catch: java.lang.Throwable -> L60
                java.util.logging.Level r5 = java.util.logging.Level.SEVERE     // Catch: java.lang.Throwable -> L60
                java.lang.Runnable r6 = r9.a     // Catch: java.lang.Throwable -> L60
                java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch: java.lang.Throwable -> L60
                int r7 = r6.length()     // Catch: java.lang.Throwable -> L60
                int r7 = r7 + 35
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L60
                r8.<init>(r7)     // Catch: java.lang.Throwable -> L60
                java.lang.String r7 = "Exception while executing runnable "
                r8.append(r7)     // Catch: java.lang.Throwable -> L60
                r8.append(r6)     // Catch: java.lang.Throwable -> L60
                java.lang.String r6 = r8.toString()     // Catch: java.lang.Throwable -> L60
                r4.log(r5, r6, r3)     // Catch: java.lang.Throwable -> L60
                goto L5b
            L8a:
                r9.a = r2     // Catch: java.lang.Throwable -> L5e
                throw r0     // Catch: java.lang.Throwable -> L5e
            L8d:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
                throw r0     // Catch: java.lang.Throwable -> L5e
            L8f:
                if (r1 == 0) goto L98
                java.lang.Thread r1 = java.lang.Thread.currentThread()
                r1.interrupt()
            L98:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: HO.b.a():void");
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a();
            } catch (Error e) {
                synchronized (HO.this.b) {
                    HO.this.c = c.IDLE;
                    throw e;
                }
            }
        }

        public String toString() {
            Runnable runnable = this.a;
            if (runnable != null) {
                String strValueOf = String.valueOf(runnable);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 34);
                sb.append("SequentialExecutorWorker{running=");
                sb.append(strValueOf);
                sb.append("}");
                return sb.toString();
            }
            String strValueOf2 = String.valueOf(HO.this.c);
            StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 32);
            sb2.append("SequentialExecutorWorker{state=");
            sb2.append(strValueOf2);
            sb2.append("}");
            return sb2.toString();
        }

        public /* synthetic */ b(HO ho, a aVar) {
            this();
        }
    }

    public enum c {
        IDLE,
        QUEUING,
        QUEUED,
        RUNNING
    }

    public HO(Executor executor) {
        this.a = (Executor) Preconditions.checkNotNull(executor);
    }

    public static /* synthetic */ long d(HO ho) {
        long j = ho.d;
        ho.d = 1 + j;
        return j;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x0061  */
    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        c cVar;
        boolean z;
        Preconditions.checkNotNull(runnable);
        synchronized (this.b) {
            c cVar2 = this.c;
            if (cVar2 != c.RUNNING && cVar2 != (cVar = c.QUEUED)) {
                long j = this.d;
                a aVar = new a(this, runnable);
                this.b.add(aVar);
                c cVar3 = c.QUEUING;
                this.c = cVar3;
                try {
                    this.a.execute(this.e);
                    if (this.c != cVar3) {
                        return;
                    }
                    synchronized (this.b) {
                        try {
                            if (this.d == j && this.c == cVar3) {
                                this.c = cVar;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return;
                } catch (Error | RuntimeException e) {
                    synchronized (this.b) {
                        try {
                            c cVar4 = this.c;
                            if (cVar4 != c.IDLE && cVar4 != c.QUEUING) {
                                z = false;
                            } else if (this.b.removeLastOccurrence(aVar)) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (!(e instanceof RejectedExecutionException) || z) {
                                throw e;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    return;
                }
            }
            this.b.add(runnable);
        }
    }

    public String toString() {
        int iIdentityHashCode = System.identityHashCode(this);
        String strValueOf = String.valueOf(this.a);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 32);
        sb.append("SequentialExecutor@");
        sb.append(iIdentityHashCode);
        sb.append("{");
        sb.append(strValueOf);
        sb.append("}");
        return sb.toString();
    }
}
