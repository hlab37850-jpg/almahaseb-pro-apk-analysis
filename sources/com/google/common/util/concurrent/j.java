package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends FluentFuture.a {
    public ListenableFuture a;
    public ScheduledFuture b;

    public static final class b implements Runnable {
        public j a;

        public b(j jVar) {
            this.a = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ListenableFuture listenableFuture;
            j jVar = this.a;
            if (jVar == null || (listenableFuture = jVar.a) == null) {
                return;
            }
            this.a = null;
            if (listenableFuture.isDone()) {
                jVar.setFuture(listenableFuture);
                return;
            }
            try {
                ScheduledFuture scheduledFuture = jVar.b;
                jVar.b = null;
                String string = "Timed out";
                if (scheduledFuture != null) {
                    try {
                        long jAbs = Math.abs(scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
                        if (jAbs > 10) {
                            StringBuilder sb = new StringBuilder("Timed out".length() + 66);
                            sb.append("Timed out");
                            sb.append(" (timeout delayed by ");
                            sb.append(jAbs);
                            sb.append(" ms after scheduled time)");
                            string = sb.toString();
                        }
                    } catch (Throwable th) {
                        jVar.setException(new c(string));
                        throw th;
                    }
                }
                String strValueOf = String.valueOf(string);
                String strValueOf2 = String.valueOf(listenableFuture);
                StringBuilder sb2 = new StringBuilder(strValueOf.length() + 2 + strValueOf2.length());
                sb2.append(strValueOf);
                sb2.append(": ");
                sb2.append(strValueOf2);
                jVar.setException(new c(sb2.toString()));
                listenableFuture.cancel(true);
            } catch (Throwable th2) {
                listenableFuture.cancel(true);
                throw th2;
            }
        }
    }

    public static final class c extends TimeoutException {
        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            setStackTrace(new StackTraceElement[0]);
            return this;
        }

        public c(String str) {
            super(str);
        }
    }

    public j(ListenableFuture listenableFuture) {
        this.a = (ListenableFuture) Preconditions.checkNotNull(listenableFuture);
    }

    public static ListenableFuture d(ListenableFuture listenableFuture, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        j jVar = new j(listenableFuture);
        b bVar = new b(jVar);
        jVar.b = scheduledExecutorService.schedule(bVar, j, timeUnit);
        listenableFuture.addListener(bVar, MoreExecutors.directExecutor());
        return jVar;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public void afterDone() {
        maybePropagateCancellationTo(this.a);
        ScheduledFuture scheduledFuture = this.b;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.a = null;
        this.b = null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public String pendingToString() {
        ListenableFuture listenableFuture = this.a;
        ScheduledFuture scheduledFuture = this.b;
        if (listenableFuture == null) {
            return null;
        }
        String strValueOf = String.valueOf(listenableFuture);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 14);
        sb.append("inputFuture=[");
        sb.append(strValueOf);
        sb.append("]");
        String string = sb.toString();
        if (scheduledFuture == null) {
            return string;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return string;
        }
        String strValueOf2 = String.valueOf(string);
        StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 43);
        sb2.append(strValueOf2);
        sb2.append(", remaining delay=[");
        sb2.append(delay);
        sb2.append(" ms]");
        return sb2.toString();
    }
}
