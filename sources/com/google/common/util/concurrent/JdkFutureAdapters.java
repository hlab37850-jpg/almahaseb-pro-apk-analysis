package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtIncompatible
public final class JdkFutureAdapters {

    public static class a extends ForwardingFuture implements ListenableFuture {
        public static final ThreadFactory e;
        public static final Executor f;
        public final Executor a;
        public final ExecutionList b;
        public final AtomicBoolean c;
        public final Future d;

        static {
            ThreadFactory threadFactoryBuild = new ThreadFactoryBuilder().setDaemon(true).setNameFormat("ListenableFutureAdapter-thread-%d").build();
            e = threadFactoryBuild;
            f = Executors.newCachedThreadPool(threadFactoryBuild);
        }

        public a(Future future) {
            this(future, f);
        }

        @Override // com.google.common.util.concurrent.ListenableFuture
        public void addListener(Runnable runnable, Executor executor) {
            this.b.add(runnable, executor);
            if (this.c.compareAndSet(false, true)) {
                if (this.d.isDone()) {
                    this.b.execute();
                } else {
                    this.a.execute(new Runnable() { // from class: Zt
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.e();
                        }
                    });
                }
            }
        }

        public final /* synthetic */ void e() {
            try {
                Uninterruptibles.getUninterruptibly(this.d);
            } catch (Throwable unused) {
            }
            this.b.execute();
        }

        public a(Future future, Executor executor) {
            this.b = new ExecutionList();
            this.c = new AtomicBoolean(false);
            this.d = (Future) Preconditions.checkNotNull(future);
            this.a = (Executor) Preconditions.checkNotNull(executor);
        }

        @Override // com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.ForwardingObject
        public Future delegate() {
            return this.d;
        }
    }

    private JdkFutureAdapters() {
    }

    public static <V> ListenableFuture<V> listenInPoolThread(Future<V> future) {
        return future instanceof ListenableFuture ? (ListenableFuture) future : new a(future);
    }

    public static <V> ListenableFuture<V> listenInPoolThread(Future<V> future, Executor executor) {
        Preconditions.checkNotNull(executor);
        if (future instanceof ListenableFuture) {
            return (ListenableFuture) future;
        }
        return new a(future, executor);
    }
}
