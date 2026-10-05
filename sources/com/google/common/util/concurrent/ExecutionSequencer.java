package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ExecutionSequencer;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class ExecutionSequencer {
    private final AtomicReference<ListenableFuture<Void>> ref = new AtomicReference<>(Futures.immediateVoidFuture());
    private e latestTaskQueue = new e(null);

    public class a implements AsyncCallable {
        public final /* synthetic */ Callable a;

        public a(ExecutionSequencer executionSequencer, Callable callable) {
            this.a = callable;
        }

        @Override // com.google.common.util.concurrent.AsyncCallable
        public ListenableFuture call() {
            return Futures.immediateFuture(this.a.call());
        }

        public String toString() {
            return this.a.toString();
        }
    }

    public class b implements AsyncCallable {
        public final /* synthetic */ d a;
        public final /* synthetic */ AsyncCallable b;

        public b(ExecutionSequencer executionSequencer, d dVar, AsyncCallable asyncCallable) {
            this.a = dVar;
            this.b = asyncCallable;
        }

        @Override // com.google.common.util.concurrent.AsyncCallable
        public ListenableFuture call() {
            return !this.a.e() ? Futures.immediateCancelledFuture() : this.b.call();
        }

        public String toString() {
            return this.b.toString();
        }
    }

    public enum c {
        NOT_RUN,
        CANCELLED,
        STARTED
    }

    public static final class d extends AtomicReference implements Executor, Runnable {
        public ExecutionSequencer a;
        public Executor b;
        public Runnable c;
        public Thread d;

        public /* synthetic */ d(Executor executor, ExecutionSequencer executionSequencer, a aVar) {
            this(executor, executionSequencer);
        }

        public final boolean c() {
            return compareAndSet(c.NOT_RUN, c.CANCELLED);
        }

        public final boolean e() {
            return compareAndSet(c.NOT_RUN, c.STARTED);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (get() == c.CANCELLED) {
                this.b = null;
                this.a = null;
                return;
            }
            this.d = Thread.currentThread();
            try {
                ExecutionSequencer executionSequencer = this.a;
                Objects.requireNonNull(executionSequencer);
                e eVar = executionSequencer.latestTaskQueue;
                if (eVar.a == this.d) {
                    this.a = null;
                    Preconditions.checkState(eVar.b == null);
                    eVar.b = runnable;
                    Executor executor = this.b;
                    Objects.requireNonNull(executor);
                    eVar.c = executor;
                    this.b = null;
                } else {
                    Executor executor2 = this.b;
                    Objects.requireNonNull(executor2);
                    this.b = null;
                    this.c = runnable;
                    executor2.execute(this);
                }
            } finally {
                this.d = null;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Executor executor;
            Thread threadCurrentThread = Thread.currentThread();
            a aVar = null;
            if (threadCurrentThread != this.d) {
                Runnable runnable = this.c;
                Objects.requireNonNull(runnable);
                this.c = null;
                runnable.run();
                return;
            }
            e eVar = new e(aVar);
            eVar.a = threadCurrentThread;
            ExecutionSequencer executionSequencer = this.a;
            Objects.requireNonNull(executionSequencer);
            executionSequencer.latestTaskQueue = eVar;
            this.a = null;
            try {
                Runnable runnable2 = this.c;
                Objects.requireNonNull(runnable2);
                this.c = null;
                runnable2.run();
                while (true) {
                    Runnable runnable3 = eVar.b;
                    if (runnable3 == null || (executor = eVar.c) == null) {
                        break;
                    }
                    eVar.b = null;
                    eVar.c = null;
                    executor.execute(runnable3);
                }
                eVar.a = null;
            } catch (Throwable th) {
                eVar.a = null;
                throw th;
            }
        }

        public d(Executor executor, ExecutionSequencer executionSequencer) {
            super(c.NOT_RUN);
            this.b = executor;
            this.a = executionSequencer;
        }
    }

    public static final class e {
        public Thread a;
        public Runnable b;
        public Executor c;

        public e() {
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    private ExecutionSequencer() {
    }

    public static ExecutionSequencer create() {
        return new ExecutionSequencer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$submitAsync$0(k kVar, SettableFuture settableFuture, ListenableFuture listenableFuture, ListenableFuture listenableFuture2, d dVar) {
        if (kVar.isDone()) {
            settableFuture.setFuture(listenableFuture);
        } else if (listenableFuture2.isCancelled() && dVar.c()) {
            kVar.cancel(false);
        }
    }

    public <T> ListenableFuture<T> submit(Callable<T> callable, Executor executor) {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(executor);
        return submitAsync(new a(this, callable), executor);
    }

    public <T> ListenableFuture<T> submitAsync(AsyncCallable<T> asyncCallable, Executor executor) {
        Preconditions.checkNotNull(asyncCallable);
        Preconditions.checkNotNull(executor);
        final d dVar = new d(executor, this, null);
        b bVar = new b(this, dVar, asyncCallable);
        final SettableFuture settableFutureCreate = SettableFuture.create();
        final ListenableFuture<Void> andSet = this.ref.getAndSet(settableFutureCreate);
        final k kVarA = k.a(bVar);
        andSet.addListener(kVarA, dVar);
        final ListenableFuture<T> listenableFutureNonCancellationPropagating = Futures.nonCancellationPropagating(kVarA);
        Runnable runnable = new Runnable() { // from class: Ul
            @Override // java.lang.Runnable
            public final void run() {
                ExecutionSequencer.lambda$submitAsync$0(kVarA, settableFutureCreate, andSet, listenableFutureNonCancellationPropagating, dVar);
            }
        };
        listenableFutureNonCancellationPropagating.addListener(runnable, MoreExecutors.directExecutor());
        kVarA.addListener(runnable, MoreExecutors.directExecutor());
        return listenableFutureNonCancellationPropagating;
    }
}
