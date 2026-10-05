package com.google.common.util.concurrent;

import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import com.itextpdf.tool.xml.html.HTML;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public final class h {
    public static final Logger b = Logger.getLogger(h.class.getName());
    public final List a = Collections.synchronizedList(new ArrayList());

    public interface a {
        void a(Object obj);
    }

    public static final class b implements Runnable {
        public final Object a;
        public final Executor b;
        public final Queue c = Queues.newArrayDeque();
        public final Queue d = Queues.newArrayDeque();
        public boolean e;

        public b(Object obj, Executor executor) {
            this.a = Preconditions.checkNotNull(obj);
            this.b = (Executor) Preconditions.checkNotNull(executor);
        }

        public synchronized void a(a aVar, Object obj) {
            this.c.add(aVar);
            this.d.add(obj);
        }

        public void b() {
            boolean z;
            synchronized (this) {
                try {
                    if (this.e) {
                        z = false;
                    } else {
                        z = true;
                        this.e = true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (z) {
                try {
                    this.b.execute(this);
                } catch (RuntimeException e) {
                    synchronized (this) {
                        this.e = false;
                        Logger logger = h.b;
                        Level level = Level.SEVERE;
                        String strValueOf = String.valueOf(this.a);
                        String strValueOf2 = String.valueOf(this.b);
                        StringBuilder sb = new StringBuilder(strValueOf.length() + 42 + strValueOf2.length());
                        sb.append("Exception while running callbacks for ");
                        sb.append(strValueOf);
                        sb.append(" on ");
                        sb.append(strValueOf2);
                        logger.log(level, sb.toString(), (Throwable) e);
                        throw e;
                    }
                }
            }
        }

        /* JADX WARN: Bottom block not found for handler: all -> 0x006c */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0024, code lost:
        
            r2.a(r10.a);
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x002c, code lost:
        
            r2 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x002d, code lost:
        
            r4 = com.google.common.util.concurrent.h.b;
            r5 = java.util.logging.Level.SEVERE;
            r6 = java.lang.String.valueOf(r10.a);
            r3 = java.lang.String.valueOf(r3);
            r8 = new java.lang.StringBuilder((r6.length() + 37) + r3.length());
            r8.append("Exception while executing callback: ");
            r8.append(r6);
            r8.append(" ");
            r8.append(r3);
            r4.log(r5, r8.toString(), (java.lang.Throwable) r2);
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() throws java.lang.Throwable {
            /*
                r10 = this;
            L0:
                r0 = 0
                r1 = 1
                monitor-enter(r10)     // Catch: java.lang.Throwable -> L2a
                boolean r2 = r10.e     // Catch: java.lang.Throwable -> L1f
                com.google.common.base.Preconditions.checkState(r2)     // Catch: java.lang.Throwable -> L1f
                java.util.Queue r2 = r10.c     // Catch: java.lang.Throwable -> L1f
                java.lang.Object r2 = r2.poll()     // Catch: java.lang.Throwable -> L1f
                com.google.common.util.concurrent.h$a r2 = (com.google.common.util.concurrent.h.a) r2     // Catch: java.lang.Throwable -> L1f
                java.util.Queue r3 = r10.d     // Catch: java.lang.Throwable -> L1f
                java.lang.Object r3 = r3.poll()     // Catch: java.lang.Throwable -> L1f
                if (r2 != 0) goto L23
                r10.e = r0     // Catch: java.lang.Throwable -> L1f
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L1c
                return
            L1c:
                r1 = move-exception
                r2 = 0
                goto L65
            L1f:
                r2 = move-exception
                r1 = r2
                r2 = 1
                goto L65
            L23:
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L1f
                java.lang.Object r4 = r10.a     // Catch: java.lang.Throwable -> L2a java.lang.RuntimeException -> L2c
                r2.a(r4)     // Catch: java.lang.Throwable -> L2a java.lang.RuntimeException -> L2c
                goto L0
            L2a:
                r2 = move-exception
                goto L6e
            L2c:
                r2 = move-exception
                java.util.logging.Logger r4 = com.google.common.util.concurrent.h.a()     // Catch: java.lang.Throwable -> L2a
                java.util.logging.Level r5 = java.util.logging.Level.SEVERE     // Catch: java.lang.Throwable -> L2a
                java.lang.Object r6 = r10.a     // Catch: java.lang.Throwable -> L2a
                java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch: java.lang.Throwable -> L2a
                java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch: java.lang.Throwable -> L2a
                int r7 = r6.length()     // Catch: java.lang.Throwable -> L2a
                int r7 = r7 + 37
                int r8 = r3.length()     // Catch: java.lang.Throwable -> L2a
                int r7 = r7 + r8
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2a
                r8.<init>(r7)     // Catch: java.lang.Throwable -> L2a
                java.lang.String r7 = "Exception while executing callback: "
                r8.append(r7)     // Catch: java.lang.Throwable -> L2a
                r8.append(r6)     // Catch: java.lang.Throwable -> L2a
                java.lang.String r6 = " "
                r8.append(r6)     // Catch: java.lang.Throwable -> L2a
                r8.append(r3)     // Catch: java.lang.Throwable -> L2a
                java.lang.String r3 = r8.toString()     // Catch: java.lang.Throwable -> L2a
                r4.log(r5, r3, r2)     // Catch: java.lang.Throwable -> L2a
                goto L0
            L65:
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L6c
                throw r1     // Catch: java.lang.Throwable -> L67
            L67:
                r1 = move-exception
                r9 = r2
                r2 = r1
                r1 = r9
                goto L6e
            L6c:
                r1 = move-exception
                goto L65
            L6e:
                if (r1 == 0) goto L78
                monitor-enter(r10)
                r10.e = r0     // Catch: java.lang.Throwable -> L75
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L75
                goto L78
            L75:
                r0 = move-exception
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L75
                throw r0
            L78:
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.h.b.run():void");
        }
    }

    public void b(Object obj, Executor executor) {
        Preconditions.checkNotNull(obj, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Preconditions.checkNotNull(executor, "executor");
        this.a.add(new b(obj, executor));
    }

    public void c() {
        for (int i = 0; i < this.a.size(); i++) {
            ((b) this.a.get(i)).b();
        }
    }

    public void d(a aVar) {
        e(aVar, aVar);
    }

    public final void e(a aVar, Object obj) {
        Preconditions.checkNotNull(aVar, NotificationCompat.CATEGORY_EVENT);
        Preconditions.checkNotNull(obj, HTML.Tag.LABEL);
        synchronized (this.a) {
            try {
                Iterator it = this.a.iterator();
                while (it.hasNext()) {
                    ((b) it.next()).a(aVar, obj);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
