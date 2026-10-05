package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import com.google.common.util.concurrent.internal.InternalFutures;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import defpackage.AbstractC0999Vq;
import defpackage.AbstractC1983cq;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
public final class Futures extends AbstractC0999Vq {

    @Beta
    @GwtCompatible
    @CanIgnoreReturnValue
    public static final class FutureCombiner<V> {
        private final boolean allMustSucceed;
        private final ImmutableList<ListenableFuture<? extends V>> futures;

        public class a implements Callable {
            public final /* synthetic */ Runnable a;

            public a(FutureCombiner futureCombiner, Runnable runnable) {
                this.a = runnable;
            }

            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void call() {
                this.a.run();
                return null;
            }
        }

        public /* synthetic */ FutureCombiner(boolean z, ImmutableList immutableList, a aVar) {
            this(z, immutableList);
        }

        @CanIgnoreReturnValue
        public <C> ListenableFuture<C> call(Callable<C> callable, Executor executor) {
            return new com.google.common.util.concurrent.f(this.futures, this.allMustSucceed, executor, callable);
        }

        public <C> ListenableFuture<C> callAsync(AsyncCallable<C> asyncCallable, Executor executor) {
            return new com.google.common.util.concurrent.f(this.futures, this.allMustSucceed, executor, asyncCallable);
        }

        public ListenableFuture<?> run(Runnable runnable, Executor executor) {
            return call(new a(this, runnable), executor);
        }

        private FutureCombiner(boolean z, ImmutableList<ListenableFuture<? extends V>> immutableList) {
            this.allMustSucceed = z;
            this.futures = immutableList;
        }
    }

    public class a implements Runnable {
        public final /* synthetic */ Future a;

        public a(Future future) {
            this.a = future;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.cancel(false);
        }
    }

    public class b implements Future {
        public final /* synthetic */ Future a;
        public final /* synthetic */ Function b;

        public b(Future future, Function function) {
            this.a = future;
            this.b = function;
        }

        public final Object a(Object obj) throws ExecutionException {
            try {
                return this.b.apply(obj);
            } catch (Throwable th) {
                throw new ExecutionException(th);
            }
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z) {
            return this.a.cancel(z);
        }

        @Override // java.util.concurrent.Future
        public Object get() {
            return a(this.a.get());
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.a.isCancelled();
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.a.isDone();
        }

        @Override // java.util.concurrent.Future
        public Object get(long j, TimeUnit timeUnit) {
            return a(this.a.get(j, timeUnit));
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ f a;
        public final /* synthetic */ ImmutableList b;
        public final /* synthetic */ int c;

        public c(f fVar, ImmutableList immutableList, int i) {
            this.a = fVar;
            this.b = immutableList;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.f(this.b, this.c);
        }
    }

    public static final class d implements Runnable {
        public final Future a;
        public final FutureCallback b;

        public d(Future future, FutureCallback futureCallback) {
            this.a = future;
            this.b = futureCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable thTryInternalFastPathGetFailure;
            Object obj = this.a;
            if ((obj instanceof InternalFutureFailureAccess) && (thTryInternalFastPathGetFailure = InternalFutures.tryInternalFastPathGetFailure((InternalFutureFailureAccess) obj)) != null) {
                this.b.onFailure(thTryInternalFastPathGetFailure);
                return;
            }
            try {
                this.b.onSuccess(Futures.getDone(this.a));
            } catch (Error e) {
                e = e;
                this.b.onFailure(e);
            } catch (RuntimeException e2) {
                e = e2;
                this.b.onFailure(e);
            } catch (ExecutionException e3) {
                this.b.onFailure(e3.getCause());
            }
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).addValue(this.b).toString();
        }
    }

    public static final class e extends AbstractFuture {
        public f a;

        public /* synthetic */ e(f fVar, a aVar) {
            this(fVar);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        public void afterDone() {
            this.a = null;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public boolean cancel(boolean z) {
            f fVar = this.a;
            if (!super.cancel(z)) {
                return false;
            }
            Objects.requireNonNull(fVar);
            fVar.g(z);
            return true;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        public String pendingToString() {
            f fVar = this.a;
            if (fVar == null) {
                return null;
            }
            int length = fVar.d.length;
            int i = fVar.c.get();
            StringBuilder sb = new StringBuilder(49);
            sb.append("inputCount=[");
            sb.append(length);
            sb.append("], remaining=[");
            sb.append(i);
            sb.append("]");
            return sb.toString();
        }

        public e(f fVar) {
            this.a = fVar;
        }
    }

    public static final class f {
        public boolean a;
        public boolean b;
        public final AtomicInteger c;
        public final ListenableFuture[] d;
        public volatile int e;

        public /* synthetic */ f(ListenableFuture[] listenableFutureArr, a aVar) {
            this(listenableFutureArr);
        }

        public final void e() {
            if (this.c.decrementAndGet() == 0 && this.a) {
                for (ListenableFuture listenableFuture : this.d) {
                    if (listenableFuture != null) {
                        listenableFuture.cancel(this.b);
                    }
                }
            }
        }

        public final void f(ImmutableList immutableList, int i) {
            ListenableFuture listenableFuture = this.d[i];
            Objects.requireNonNull(listenableFuture);
            ListenableFuture listenableFuture2 = listenableFuture;
            this.d[i] = null;
            for (int i2 = this.e; i2 < immutableList.size(); i2++) {
                if (((AbstractFuture) immutableList.get(i2)).setFuture(listenableFuture2)) {
                    e();
                    this.e = i2 + 1;
                    return;
                }
            }
            this.e = immutableList.size();
        }

        public final void g(boolean z) {
            this.a = true;
            if (!z) {
                this.b = false;
            }
            e();
        }

        public f(ListenableFuture[] listenableFutureArr) {
            this.a = false;
            this.b = true;
            this.e = 0;
            this.d = listenableFutureArr;
            this.c = new AtomicInteger(listenableFutureArr.length);
        }
    }

    public static final class g extends AbstractFuture.j implements Runnable {
        public ListenableFuture a;

        public g(ListenableFuture listenableFuture) {
            this.a = listenableFuture;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        public void afterDone() {
            this.a = null;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        public String pendingToString() {
            ListenableFuture listenableFuture = this.a;
            if (listenableFuture == null) {
                return null;
            }
            String strValueOf = String.valueOf(listenableFuture);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 11);
            sb.append("delegate=[");
            sb.append(strValueOf);
            sb.append("]");
            return sb.toString();
        }

        @Override // java.lang.Runnable
        public void run() {
            ListenableFuture listenableFuture = this.a;
            if (listenableFuture != null) {
                setFuture(listenableFuture);
            }
        }
    }

    private Futures() {
    }

    public static <V> void addCallback(ListenableFuture<V> listenableFuture, FutureCallback<? super V> futureCallback, Executor executor) {
        Preconditions.checkNotNull(futureCallback);
        listenableFuture.addListener(new d(listenableFuture, futureCallback), executor);
    }

    @SafeVarargs
    @Beta
    public static <V> ListenableFuture<List<V>> allAsList(ListenableFuture<? extends V>... listenableFutureArr) {
        return new com.google.common.util.concurrent.e.a(ImmutableList.copyOf(listenableFutureArr), true);
    }

    @Beta
    public static <V, X extends Throwable> ListenableFuture<V> catching(ListenableFuture<? extends V> listenableFuture, Class<X> cls, Function<? super X, ? extends V> function, Executor executor) {
        return com.google.common.util.concurrent.a.a(listenableFuture, cls, function, executor);
    }

    @Beta
    public static <V, X extends Throwable> ListenableFuture<V> catchingAsync(ListenableFuture<? extends V> listenableFuture, Class<X> cls, AsyncFunction<? super X, ? extends V> asyncFunction, Executor executor) {
        return com.google.common.util.concurrent.a.b(listenableFuture, cls, asyncFunction, executor);
    }

    @CanIgnoreReturnValue
    @Beta
    @GwtIncompatible
    public static <V, X extends Exception> V getChecked(Future<V> future, Class<X> cls) {
        return (V) AbstractC1983cq.d(future, cls);
    }

    @CanIgnoreReturnValue
    public static <V> V getDone(Future<V> future) {
        Preconditions.checkState(future.isDone(), "Future was expected to be done: %s", future);
        return (V) Uninterruptibles.getUninterruptibly(future);
    }

    @CanIgnoreReturnValue
    public static <V> V getUnchecked(Future<V> future) {
        Preconditions.checkNotNull(future);
        try {
            return (V) Uninterruptibles.getUninterruptibly(future);
        } catch (ExecutionException e2) {
            wrapAndThrowUnchecked(e2.getCause());
            throw new AssertionError();
        }
    }

    private static <T> ListenableFuture<? extends T>[] gwtCompatibleToArray(Iterable<? extends ListenableFuture<? extends T>> iterable) {
        return (ListenableFuture[]) (iterable instanceof Collection ? (Collection) iterable : ImmutableList.copyOf(iterable)).toArray(new ListenableFuture[0]);
    }

    public static <V> ListenableFuture<V> immediateCancelledFuture() {
        com.google.common.util.concurrent.g.a aVar = com.google.common.util.concurrent.g.a.a;
        return aVar != null ? aVar : new com.google.common.util.concurrent.g.a();
    }

    public static <V> ListenableFuture<V> immediateFailedFuture(Throwable th) {
        Preconditions.checkNotNull(th);
        return new com.google.common.util.concurrent.g.b(th);
    }

    public static <V> ListenableFuture<V> immediateFuture(V v) {
        return v == null ? com.google.common.util.concurrent.g.b : new com.google.common.util.concurrent.g(v);
    }

    public static ListenableFuture<Void> immediateVoidFuture() {
        return com.google.common.util.concurrent.g.b;
    }

    public static <T> ImmutableList<ListenableFuture<T>> inCompletionOrder(Iterable<? extends ListenableFuture<? extends T>> iterable) {
        ListenableFuture[] listenableFutureArrGwtCompatibleToArray = gwtCompatibleToArray(iterable);
        a aVar = null;
        f fVar = new f(listenableFutureArrGwtCompatibleToArray, aVar);
        ImmutableList.Builder builderBuilderWithExpectedSize = ImmutableList.builderWithExpectedSize(listenableFutureArrGwtCompatibleToArray.length);
        for (int i = 0; i < listenableFutureArrGwtCompatibleToArray.length; i++) {
            builderBuilderWithExpectedSize.add(new e(fVar, aVar));
        }
        ImmutableList<ListenableFuture<T>> immutableListBuild = builderBuilderWithExpectedSize.build();
        for (int i2 = 0; i2 < listenableFutureArrGwtCompatibleToArray.length; i2++) {
            listenableFutureArrGwtCompatibleToArray[i2].addListener(new c(fVar, immutableListBuild, i2), MoreExecutors.directExecutor());
        }
        return immutableListBuild;
    }

    @Beta
    @GwtIncompatible
    public static <I, O> Future<O> lazyTransform(Future<I> future, Function<? super I, ? extends O> function) {
        Preconditions.checkNotNull(future);
        Preconditions.checkNotNull(function);
        return new b(future, function);
    }

    public static <V> ListenableFuture<V> nonCancellationPropagating(ListenableFuture<V> listenableFuture) {
        if (listenableFuture.isDone()) {
            return listenableFuture;
        }
        g gVar = new g(listenableFuture);
        listenableFuture.addListener(gVar, MoreExecutors.directExecutor());
        return gVar;
    }

    @GwtIncompatible
    public static <O> ListenableFuture<O> scheduleAsync(AsyncCallable<O> asyncCallable, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        k kVarA = k.a(asyncCallable);
        kVarA.addListener(new a(scheduledExecutorService.schedule(kVarA, j, timeUnit)), MoreExecutors.directExecutor());
        return kVarA;
    }

    public static <O> ListenableFuture<O> submit(Callable<O> callable, Executor executor) {
        k kVarC = k.c(callable);
        executor.execute(kVarC);
        return kVarC;
    }

    public static <O> ListenableFuture<O> submitAsync(AsyncCallable<O> asyncCallable, Executor executor) {
        k kVarA = k.a(asyncCallable);
        executor.execute(kVarA);
        return kVarA;
    }

    @SafeVarargs
    @Beta
    public static <V> ListenableFuture<List<V>> successfulAsList(ListenableFuture<? extends V>... listenableFutureArr) {
        return new com.google.common.util.concurrent.e.a(ImmutableList.copyOf(listenableFutureArr), false);
    }

    @Beta
    public static <I, O> ListenableFuture<O> transform(ListenableFuture<I> listenableFuture, Function<? super I, ? extends O> function, Executor executor) {
        return com.google.common.util.concurrent.b.a(listenableFuture, function, executor);
    }

    @Beta
    public static <I, O> ListenableFuture<O> transformAsync(ListenableFuture<I> listenableFuture, AsyncFunction<? super I, ? extends O> asyncFunction, Executor executor) {
        return com.google.common.util.concurrent.b.b(listenableFuture, asyncFunction, executor);
    }

    @SafeVarargs
    @Beta
    public static <V> FutureCombiner<V> whenAllComplete(ListenableFuture<? extends V>... listenableFutureArr) {
        return new FutureCombiner<>(false, ImmutableList.copyOf(listenableFutureArr), null);
    }

    @SafeVarargs
    @Beta
    public static <V> FutureCombiner<V> whenAllSucceed(ListenableFuture<? extends V>... listenableFutureArr) {
        return new FutureCombiner<>(true, ImmutableList.copyOf(listenableFutureArr), null);
    }

    @Beta
    @GwtIncompatible
    public static <V> ListenableFuture<V> withTimeout(ListenableFuture<V> listenableFuture, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return listenableFuture.isDone() ? listenableFuture : j.d(listenableFuture, j, timeUnit, scheduledExecutorService);
    }

    private static void wrapAndThrowUnchecked(Throwable th) {
        if (!(th instanceof Error)) {
            throw new UncheckedExecutionException(th);
        }
        throw new ExecutionError((Error) th);
    }

    @CanIgnoreReturnValue
    @Beta
    @GwtIncompatible
    public static <V, X extends Exception> V getChecked(Future<V> future, Class<X> cls, long j, TimeUnit timeUnit) {
        return (V) AbstractC1983cq.e(future, cls, j, timeUnit);
    }

    @Beta
    public static <V> ListenableFuture<List<V>> successfulAsList(Iterable<? extends ListenableFuture<? extends V>> iterable) {
        return new com.google.common.util.concurrent.e.a(ImmutableList.copyOf(iterable), false);
    }

    @Beta
    public static <V> FutureCombiner<V> whenAllComplete(Iterable<? extends ListenableFuture<? extends V>> iterable) {
        return new FutureCombiner<>(false, ImmutableList.copyOf(iterable), null);
    }

    @Beta
    public static <V> FutureCombiner<V> whenAllSucceed(Iterable<? extends ListenableFuture<? extends V>> iterable) {
        return new FutureCombiner<>(true, ImmutableList.copyOf(iterable), null);
    }

    @Beta
    public static <V> ListenableFuture<List<V>> allAsList(Iterable<? extends ListenableFuture<? extends V>> iterable) {
        return new com.google.common.util.concurrent.e.a(ImmutableList.copyOf(iterable), true);
    }

    public static ListenableFuture<Void> submit(Runnable runnable, Executor executor) {
        k kVarB = k.b(runnable, null);
        executor.execute(kVarB);
        return kVarB;
    }
}
