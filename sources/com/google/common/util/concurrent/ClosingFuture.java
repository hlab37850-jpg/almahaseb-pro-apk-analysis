package com.google.common.util.concurrent;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotMock;
import com.google.j2objc.annotations.RetainedWith;
import defpackage.FC;
import java.io.Closeable;
import java.io.IOException;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
@DoNotMock("Use ClosingFuture.from(Futures.immediate*Future)")
public final class ClosingFuture<V> {
    private static final Logger logger = Logger.getLogger(ClosingFuture.class.getName());
    private final m closeables;
    private final FluentFuture<V> future;
    private final AtomicReference<n> state;

    public interface AsyncClosingCallable<V> {
        ClosingFuture<V> call(DeferredCloser deferredCloser);
    }

    public interface AsyncClosingFunction<T, U> {
        ClosingFuture<U> apply(DeferredCloser deferredCloser, T t);
    }

    public interface ClosingCallable<V> {
        V call(DeferredCloser deferredCloser);
    }

    public interface ClosingFunction<T, U> {
        U apply(DeferredCloser deferredCloser, T t);
    }

    @DoNotMock("Use ClosingFuture.whenAllSucceed() or .whenAllComplete() instead.")
    public static class Combiner {
        private static final Function<ClosingFuture<?>, FluentFuture<?>> INNER_FUTURE = new c();
        private final boolean allMustSucceed;
        private final m closeables;
        protected final ImmutableList<ClosingFuture<?>> inputs;

        public interface AsyncCombiningCallable<V> {
            ClosingFuture<V> call(DeferredCloser deferredCloser, Peeker peeker);
        }

        public interface CombiningCallable<V> {
            V call(DeferredCloser deferredCloser, Peeker peeker);
        }

        public class a implements Callable {
            public final /* synthetic */ CombiningCallable a;

            public a(CombiningCallable combiningCallable) {
                this.a = combiningCallable;
            }

            @Override // java.util.concurrent.Callable
            public Object call() {
                return new Peeker(Combiner.this.inputs, null).call(this.a, Combiner.this.closeables);
            }

            public String toString() {
                return this.a.toString();
            }
        }

        public class b implements AsyncCallable {
            public final /* synthetic */ AsyncCombiningCallable a;

            public b(AsyncCombiningCallable asyncCombiningCallable) {
                this.a = asyncCombiningCallable;
            }

            @Override // com.google.common.util.concurrent.AsyncCallable
            public ListenableFuture call() {
                return new Peeker(Combiner.this.inputs, null).callAsync(this.a, Combiner.this.closeables);
            }

            public String toString() {
                return this.a.toString();
            }
        }

        public class c implements Function {
            @Override // com.google.common.base.Function
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public FluentFuture apply(ClosingFuture closingFuture) {
                return closingFuture.future;
            }
        }

        public /* synthetic */ Combiner(boolean z, Iterable iterable, d dVar) {
            this(z, iterable);
        }

        private Futures.FutureCombiner<Object> futureCombiner() {
            return this.allMustSucceed ? Futures.whenAllSucceed(inputFutures()) : Futures.whenAllComplete(inputFutures());
        }

        private ImmutableList<FluentFuture<?>> inputFutures() {
            return FluentIterable.from(this.inputs).transform(INNER_FUTURE).toList();
        }

        public <V> ClosingFuture<V> call(CombiningCallable<V> combiningCallable, Executor executor) {
            ClosingFuture<V> closingFuture = new ClosingFuture<>(futureCombiner().call(new a(combiningCallable), executor), (d) null);
            ((ClosingFuture) closingFuture).closeables.t(this.closeables, MoreExecutors.directExecutor());
            return closingFuture;
        }

        public <V> ClosingFuture<V> callAsync(AsyncCombiningCallable<V> asyncCombiningCallable, Executor executor) {
            ClosingFuture<V> closingFuture = new ClosingFuture<>(futureCombiner().callAsync(new b(asyncCombiningCallable), executor), (d) null);
            ((ClosingFuture) closingFuture).closeables.t(this.closeables, MoreExecutors.directExecutor());
            return closingFuture;
        }

        private Combiner(boolean z, Iterable<? extends ClosingFuture<?>> iterable) {
            this.closeables = new m(null);
            this.allMustSucceed = z;
            this.inputs = ImmutableList.copyOf(iterable);
            Iterator<? extends ClosingFuture<?>> it = iterable.iterator();
            while (it.hasNext()) {
                it.next().becomeSubsumedInto(this.closeables);
            }
        }
    }

    public static final class Combiner2<V1, V2> extends Combiner {
        private final ClosingFuture<V1> future1;
        private final ClosingFuture<V2> future2;

        public interface AsyncClosingFunction2<V1, V2, U> {
            ClosingFuture<U> apply(DeferredCloser deferredCloser, V1 v1, V2 v2);
        }

        public interface ClosingFunction2<V1, V2, U> {
            U apply(DeferredCloser deferredCloser, V1 v1, V2 v2);
        }

        public class a implements Combiner.CombiningCallable {
            public final /* synthetic */ ClosingFunction2 a;

            public a(ClosingFunction2 closingFunction2) {
                this.a = closingFunction2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.CombiningCallable
            public Object call(DeferredCloser deferredCloser, Peeker peeker) {
                return this.a.apply(deferredCloser, peeker.getDone(Combiner2.this.future1), peeker.getDone(Combiner2.this.future2));
            }

            public String toString() {
                return this.a.toString();
            }
        }

        public class b implements Combiner.AsyncCombiningCallable {
            public final /* synthetic */ AsyncClosingFunction2 a;

            public b(AsyncClosingFunction2 asyncClosingFunction2) {
                this.a = asyncClosingFunction2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.AsyncCombiningCallable
            public ClosingFuture call(DeferredCloser deferredCloser, Peeker peeker) {
                return this.a.apply(deferredCloser, peeker.getDone(Combiner2.this.future1), peeker.getDone(Combiner2.this.future2));
            }

            public String toString() {
                return this.a.toString();
            }
        }

        public /* synthetic */ Combiner2(ClosingFuture closingFuture, ClosingFuture closingFuture2, d dVar) {
            this(closingFuture, closingFuture2);
        }

        public <U> ClosingFuture<U> call(ClosingFunction2<V1, V2, U> closingFunction2, Executor executor) {
            return call(new a(closingFunction2), executor);
        }

        public <U> ClosingFuture<U> callAsync(AsyncClosingFunction2<V1, V2, U> asyncClosingFunction2, Executor executor) {
            return callAsync(new b(asyncClosingFunction2), executor);
        }

        private Combiner2(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2) {
            super(true, ImmutableList.of((ClosingFuture<V2>) closingFuture, closingFuture2), null);
            this.future1 = closingFuture;
            this.future2 = closingFuture2;
        }
    }

    public static final class Combiner3<V1, V2, V3> extends Combiner {
        private final ClosingFuture<V1> future1;
        private final ClosingFuture<V2> future2;
        private final ClosingFuture<V3> future3;

        public interface AsyncClosingFunction3<V1, V2, V3, U> {
            ClosingFuture<U> apply(DeferredCloser deferredCloser, V1 v1, V2 v2, V3 v3);
        }

        public interface ClosingFunction3<V1, V2, V3, U> {
            U apply(DeferredCloser deferredCloser, V1 v1, V2 v2, V3 v3);
        }

        public class a implements Combiner.CombiningCallable {
            public final /* synthetic */ ClosingFunction3 a;

            public a(ClosingFunction3 closingFunction3) {
                this.a = closingFunction3;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.CombiningCallable
            public Object call(DeferredCloser deferredCloser, Peeker peeker) {
                return this.a.apply(deferredCloser, peeker.getDone(Combiner3.this.future1), peeker.getDone(Combiner3.this.future2), peeker.getDone(Combiner3.this.future3));
            }

            public String toString() {
                return this.a.toString();
            }
        }

        public class b implements Combiner.AsyncCombiningCallable {
            public final /* synthetic */ AsyncClosingFunction3 a;

            public b(AsyncClosingFunction3 asyncClosingFunction3) {
                this.a = asyncClosingFunction3;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.AsyncCombiningCallable
            public ClosingFuture call(DeferredCloser deferredCloser, Peeker peeker) {
                return this.a.apply(deferredCloser, peeker.getDone(Combiner3.this.future1), peeker.getDone(Combiner3.this.future2), peeker.getDone(Combiner3.this.future3));
            }

            public String toString() {
                return this.a.toString();
            }
        }

        public /* synthetic */ Combiner3(ClosingFuture closingFuture, ClosingFuture closingFuture2, ClosingFuture closingFuture3, d dVar) {
            this(closingFuture, closingFuture2, closingFuture3);
        }

        public <U> ClosingFuture<U> call(ClosingFunction3<V1, V2, V3, U> closingFunction3, Executor executor) {
            return call(new a(closingFunction3), executor);
        }

        public <U> ClosingFuture<U> callAsync(AsyncClosingFunction3<V1, V2, V3, U> asyncClosingFunction3, Executor executor) {
            return callAsync(new b(asyncClosingFunction3), executor);
        }

        private Combiner3(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2, ClosingFuture<V3> closingFuture3) {
            super(true, ImmutableList.of((ClosingFuture<V3>) closingFuture, (ClosingFuture<V3>) closingFuture2, closingFuture3), null);
            this.future1 = closingFuture;
            this.future2 = closingFuture2;
            this.future3 = closingFuture3;
        }
    }

    public static final class Combiner4<V1, V2, V3, V4> extends Combiner {
        private final ClosingFuture<V1> future1;
        private final ClosingFuture<V2> future2;
        private final ClosingFuture<V3> future3;
        private final ClosingFuture<V4> future4;

        public interface AsyncClosingFunction4<V1, V2, V3, V4, U> {
            ClosingFuture<U> apply(DeferredCloser deferredCloser, V1 v1, V2 v2, V3 v3, V4 v4);
        }

        public interface ClosingFunction4<V1, V2, V3, V4, U> {
            U apply(DeferredCloser deferredCloser, V1 v1, V2 v2, V3 v3, V4 v4);
        }

        public class a implements Combiner.CombiningCallable {
            public final /* synthetic */ ClosingFunction4 a;

            public a(ClosingFunction4 closingFunction4) {
                this.a = closingFunction4;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.CombiningCallable
            public Object call(DeferredCloser deferredCloser, Peeker peeker) {
                return this.a.apply(deferredCloser, peeker.getDone(Combiner4.this.future1), peeker.getDone(Combiner4.this.future2), peeker.getDone(Combiner4.this.future3), peeker.getDone(Combiner4.this.future4));
            }

            public String toString() {
                return this.a.toString();
            }
        }

        public class b implements Combiner.AsyncCombiningCallable {
            public final /* synthetic */ AsyncClosingFunction4 a;

            public b(AsyncClosingFunction4 asyncClosingFunction4) {
                this.a = asyncClosingFunction4;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.AsyncCombiningCallable
            public ClosingFuture call(DeferredCloser deferredCloser, Peeker peeker) {
                return this.a.apply(deferredCloser, peeker.getDone(Combiner4.this.future1), peeker.getDone(Combiner4.this.future2), peeker.getDone(Combiner4.this.future3), peeker.getDone(Combiner4.this.future4));
            }

            public String toString() {
                return this.a.toString();
            }
        }

        public /* synthetic */ Combiner4(ClosingFuture closingFuture, ClosingFuture closingFuture2, ClosingFuture closingFuture3, ClosingFuture closingFuture4, d dVar) {
            this(closingFuture, closingFuture2, closingFuture3, closingFuture4);
        }

        public <U> ClosingFuture<U> call(ClosingFunction4<V1, V2, V3, V4, U> closingFunction4, Executor executor) {
            return call(new a(closingFunction4), executor);
        }

        public <U> ClosingFuture<U> callAsync(AsyncClosingFunction4<V1, V2, V3, V4, U> asyncClosingFunction4, Executor executor) {
            return callAsync(new b(asyncClosingFunction4), executor);
        }

        private Combiner4(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2, ClosingFuture<V3> closingFuture3, ClosingFuture<V4> closingFuture4) {
            super(true, ImmutableList.of((ClosingFuture<V4>) closingFuture, (ClosingFuture<V4>) closingFuture2, (ClosingFuture<V4>) closingFuture3, closingFuture4), null);
            this.future1 = closingFuture;
            this.future2 = closingFuture2;
            this.future3 = closingFuture3;
            this.future4 = closingFuture4;
        }
    }

    public static final class Combiner5<V1, V2, V3, V4, V5> extends Combiner {
        private final ClosingFuture<V1> future1;
        private final ClosingFuture<V2> future2;
        private final ClosingFuture<V3> future3;
        private final ClosingFuture<V4> future4;
        private final ClosingFuture<V5> future5;

        public interface AsyncClosingFunction5<V1, V2, V3, V4, V5, U> {
            ClosingFuture<U> apply(DeferredCloser deferredCloser, V1 v1, V2 v2, V3 v3, V4 v4, V5 v5);
        }

        public interface ClosingFunction5<V1, V2, V3, V4, V5, U> {
            U apply(DeferredCloser deferredCloser, V1 v1, V2 v2, V3 v3, V4 v4, V5 v5);
        }

        public class a implements Combiner.CombiningCallable {
            public final /* synthetic */ ClosingFunction5 a;

            public a(ClosingFunction5 closingFunction5) {
                this.a = closingFunction5;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.CombiningCallable
            public Object call(DeferredCloser deferredCloser, Peeker peeker) {
                return this.a.apply(deferredCloser, peeker.getDone(Combiner5.this.future1), peeker.getDone(Combiner5.this.future2), peeker.getDone(Combiner5.this.future3), peeker.getDone(Combiner5.this.future4), peeker.getDone(Combiner5.this.future5));
            }

            public String toString() {
                return this.a.toString();
            }
        }

        public class b implements Combiner.AsyncCombiningCallable {
            public final /* synthetic */ AsyncClosingFunction5 a;

            public b(AsyncClosingFunction5 asyncClosingFunction5) {
                this.a = asyncClosingFunction5;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.util.concurrent.ClosingFuture.Combiner.AsyncCombiningCallable
            public ClosingFuture call(DeferredCloser deferredCloser, Peeker peeker) {
                return this.a.apply(deferredCloser, peeker.getDone(Combiner5.this.future1), peeker.getDone(Combiner5.this.future2), peeker.getDone(Combiner5.this.future3), peeker.getDone(Combiner5.this.future4), peeker.getDone(Combiner5.this.future5));
            }

            public String toString() {
                return this.a.toString();
            }
        }

        public /* synthetic */ Combiner5(ClosingFuture closingFuture, ClosingFuture closingFuture2, ClosingFuture closingFuture3, ClosingFuture closingFuture4, ClosingFuture closingFuture5, d dVar) {
            this(closingFuture, closingFuture2, closingFuture3, closingFuture4, closingFuture5);
        }

        public <U> ClosingFuture<U> call(ClosingFunction5<V1, V2, V3, V4, V5, U> closingFunction5, Executor executor) {
            return call(new a(closingFunction5), executor);
        }

        public <U> ClosingFuture<U> callAsync(AsyncClosingFunction5<V1, V2, V3, V4, V5, U> asyncClosingFunction5, Executor executor) {
            return callAsync(new b(asyncClosingFunction5), executor);
        }

        private Combiner5(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2, ClosingFuture<V3> closingFuture3, ClosingFuture<V4> closingFuture4, ClosingFuture<V5> closingFuture5) {
            super(true, ImmutableList.of((ClosingFuture<V5>) closingFuture, (ClosingFuture<V5>) closingFuture2, (ClosingFuture<V5>) closingFuture3, (ClosingFuture<V5>) closingFuture4, closingFuture5), null);
            this.future1 = closingFuture;
            this.future2 = closingFuture2;
            this.future3 = closingFuture3;
            this.future4 = closingFuture4;
            this.future5 = closingFuture5;
        }
    }

    public static final class DeferredCloser {

        @RetainedWith
        private final m list;

        public DeferredCloser(m mVar) {
            this.list = mVar;
        }

        @CanIgnoreReturnValue
        public <C extends Closeable> C eventuallyClose(C c, Executor executor) {
            Preconditions.checkNotNull(executor);
            if (c != null) {
                this.list.t(c, executor);
            }
            return c;
        }
    }

    public static final class Peeker {
        private volatile boolean beingCalled;
        private final ImmutableList<ClosingFuture<?>> futures;

        public /* synthetic */ Peeker(ImmutableList immutableList, d dVar) {
            this(immutableList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public <V> V call(Combiner.CombiningCallable<V> combiningCallable, m mVar) {
            this.beingCalled = true;
            m mVar2 = new m(null);
            try {
                return combiningCallable.call(mVar2.a, this);
            } finally {
                mVar.t(mVar2, MoreExecutors.directExecutor());
                this.beingCalled = false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public <V> FluentFuture<V> callAsync(Combiner.AsyncCombiningCallable<V> asyncCombiningCallable, m mVar) {
            this.beingCalled = true;
            m mVar2 = new m(null);
            try {
                ClosingFuture<V> closingFutureCall = asyncCombiningCallable.call(mVar2.a, this);
                closingFutureCall.becomeSubsumedInto(mVar);
                return ((ClosingFuture) closingFutureCall).future;
            } finally {
                mVar.t(mVar2, MoreExecutors.directExecutor());
                this.beingCalled = false;
            }
        }

        public final <D> D getDone(ClosingFuture<D> closingFuture) {
            Preconditions.checkState(this.beingCalled);
            Preconditions.checkArgument(this.futures.contains(closingFuture));
            return (D) Futures.getDone(((ClosingFuture) closingFuture).future);
        }

        private Peeker(ImmutableList<ClosingFuture<?>> immutableList) {
            this.futures = (ImmutableList) Preconditions.checkNotNull(immutableList);
        }
    }

    public static final class ValueAndCloser<V> {
        private final ClosingFuture<? extends V> closingFuture;

        public ValueAndCloser(ClosingFuture<? extends V> closingFuture) {
            this.closingFuture = (ClosingFuture) Preconditions.checkNotNull(closingFuture);
        }

        public void closeAsync() {
            this.closingFuture.close();
        }

        public V get() {
            return (V) Futures.getDone(((ClosingFuture) this.closingFuture).future);
        }
    }

    public interface ValueAndCloserConsumer<V> {
        void accept(ValueAndCloser<V> valueAndCloser);
    }

    public class a implements Runnable {
        public final /* synthetic */ ValueAndCloserConsumer a;

        public a(ValueAndCloserConsumer valueAndCloserConsumer) {
            this.a = valueAndCloserConsumer;
        }

        @Override // java.lang.Runnable
        public void run() {
            ClosingFuture.provideValueAndCloser(this.a, ClosingFuture.this);
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ Closeable a;

        public b(Closeable closeable) {
            this.a = closeable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.a.close();
            } catch (IOException | RuntimeException e) {
                ClosingFuture.logger.log(Level.WARNING, "thrown by close()", e);
            }
        }
    }

    public static /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[n.values().length];
            a = iArr;
            try {
                iArr[n.SUBSUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[n.WILL_CREATE_VALUE_AND_CLOSER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[n.WILL_CLOSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[n.CLOSING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[n.CLOSED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[n.OPEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public class d implements FutureCallback {
        public final /* synthetic */ Executor b;

        public d(Executor executor) {
            this.b = executor;
        }

        @Override // com.google.common.util.concurrent.FutureCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Closeable closeable) {
            ClosingFuture.this.closeables.a.eventuallyClose(closeable, this.b);
        }

        @Override // com.google.common.util.concurrent.FutureCallback
        public void onFailure(Throwable th) {
        }
    }

    public class e implements Callable {
        public final /* synthetic */ ClosingCallable a;

        public e(ClosingCallable closingCallable) {
            this.a = closingCallable;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return this.a.call(ClosingFuture.this.closeables.a);
        }

        public String toString() {
            return this.a.toString();
        }
    }

    public class f implements AsyncCallable {
        public final /* synthetic */ AsyncClosingCallable a;

        public f(AsyncClosingCallable asyncClosingCallable) {
            this.a = asyncClosingCallable;
        }

        @Override // com.google.common.util.concurrent.AsyncCallable
        public ListenableFuture call() {
            m mVar = new m(null);
            try {
                ClosingFuture<V> closingFutureCall = this.a.call(mVar.a);
                closingFutureCall.becomeSubsumedInto(ClosingFuture.this.closeables);
                return ((ClosingFuture) closingFutureCall).future;
            } finally {
                ClosingFuture.this.closeables.t(mVar, MoreExecutors.directExecutor());
            }
        }

        public String toString() {
            return this.a.toString();
        }
    }

    public class g implements AsyncFunction {
        public final /* synthetic */ ClosingFunction a;

        public g(ClosingFunction closingFunction) {
            this.a = closingFunction;
        }

        @Override // com.google.common.util.concurrent.AsyncFunction
        public ListenableFuture apply(Object obj) {
            return ClosingFuture.this.closeables.v(this.a, obj);
        }

        public String toString() {
            return this.a.toString();
        }
    }

    public class h implements AsyncFunction {
        public final /* synthetic */ AsyncClosingFunction a;

        public h(AsyncClosingFunction asyncClosingFunction) {
            this.a = asyncClosingFunction;
        }

        @Override // com.google.common.util.concurrent.AsyncFunction
        public ListenableFuture apply(Object obj) {
            return ClosingFuture.this.closeables.u(this.a, obj);
        }

        public String toString() {
            return this.a.toString();
        }
    }

    public class i implements AsyncClosingFunction {
        public final /* synthetic */ AsyncFunction a;

        public i(AsyncFunction asyncFunction) {
            this.a = asyncFunction;
        }

        @Override // com.google.common.util.concurrent.ClosingFuture.AsyncClosingFunction
        public ClosingFuture apply(DeferredCloser deferredCloser, Object obj) {
            return ClosingFuture.from(this.a.apply(obj));
        }
    }

    public class j implements AsyncFunction {
        public final /* synthetic */ ClosingFunction a;

        public j(ClosingFunction closingFunction) {
            this.a = closingFunction;
        }

        @Override // com.google.common.util.concurrent.AsyncFunction
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ListenableFuture apply(Throwable th) {
            return ClosingFuture.this.closeables.v(this.a, th);
        }

        public String toString() {
            return this.a.toString();
        }
    }

    public class k implements AsyncFunction {
        public final /* synthetic */ AsyncClosingFunction a;

        public k(AsyncClosingFunction asyncClosingFunction) {
            this.a = asyncClosingFunction;
        }

        @Override // com.google.common.util.concurrent.AsyncFunction
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ListenableFuture apply(Throwable th) {
            return ClosingFuture.this.closeables.u(this.a, th);
        }

        public String toString() {
            return this.a.toString();
        }
    }

    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ClosingFuture closingFuture = ClosingFuture.this;
            n nVar = n.WILL_CLOSE;
            n nVar2 = n.CLOSING;
            closingFuture.checkAndUpdateState(nVar, nVar2);
            ClosingFuture.this.close();
            ClosingFuture.this.checkAndUpdateState(nVar2, n.CLOSED);
        }
    }

    public enum n {
        OPEN,
        SUBSUMED,
        WILL_CLOSE,
        CLOSING,
        CLOSED,
        WILL_CREATE_VALUE_AND_CLOSER
    }

    public /* synthetic */ ClosingFuture(ListenableFuture listenableFuture, d dVar) {
        this(listenableFuture);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void becomeSubsumedInto(m mVar) {
        checkAndUpdateState(n.OPEN, n.SUBSUMED);
        mVar.t(this.closeables, MoreExecutors.directExecutor());
    }

    private <X extends Throwable, W extends V> ClosingFuture<V> catchingAsyncMoreGeneric(Class<X> cls, AsyncClosingFunction<? super X, W> asyncClosingFunction, Executor executor) {
        Preconditions.checkNotNull(asyncClosingFunction);
        return (ClosingFuture<V>) derive(this.future.catchingAsync(cls, new k(asyncClosingFunction), executor));
    }

    private <X extends Throwable, W extends V> ClosingFuture<V> catchingMoreGeneric(Class<X> cls, ClosingFunction<? super X, W> closingFunction, Executor executor) {
        Preconditions.checkNotNull(closingFunction);
        return (ClosingFuture<V>) derive(this.future.catchingAsync(cls, new j(closingFunction), executor));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAndUpdateState(n nVar, n nVar2) {
        Preconditions.checkState(compareAndUpdateState(nVar, nVar2), "Expected state to be %s, but it was %s", nVar, nVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close() {
        logger.log(Level.FINER, "closing {0}", this);
        this.closeables.close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void closeQuietly(Closeable closeable, Executor executor) {
        if (closeable == null) {
            return;
        }
        try {
            executor.execute(new b(closeable));
        } catch (RejectedExecutionException e2) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            if (logger2.isLoggable(level)) {
                logger2.log(level, String.format("while submitting close to %s; will close inline", executor), (Throwable) e2);
            }
            closeQuietly(closeable, MoreExecutors.directExecutor());
        }
    }

    private boolean compareAndUpdateState(n nVar, n nVar2) {
        return FC.a(this.state, nVar, nVar2);
    }

    private <U> ClosingFuture<U> derive(FluentFuture<U> fluentFuture) {
        ClosingFuture<U> closingFuture = new ClosingFuture<>(fluentFuture);
        becomeSubsumedInto(closingFuture.closeables);
        return closingFuture;
    }

    @Deprecated
    public static <C extends Closeable> ClosingFuture<C> eventuallyClosing(ListenableFuture<C> listenableFuture, Executor executor) {
        Preconditions.checkNotNull(executor);
        ClosingFuture<C> closingFuture = new ClosingFuture<>(Futures.nonCancellationPropagating(listenableFuture));
        Futures.addCallback(listenableFuture, new d(executor), MoreExecutors.directExecutor());
        return closingFuture;
    }

    public static <V> ClosingFuture<V> from(ListenableFuture<V> listenableFuture) {
        return new ClosingFuture<>(listenableFuture);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <C, V extends C> void provideValueAndCloser(ValueAndCloserConsumer<C> valueAndCloserConsumer, ClosingFuture<V> closingFuture) {
        valueAndCloserConsumer.accept(new ValueAndCloser<>(closingFuture));
    }

    public static <V> ClosingFuture<V> submit(ClosingCallable<V> closingCallable, Executor executor) {
        return new ClosingFuture<>(closingCallable, executor);
    }

    public static <V> ClosingFuture<V> submitAsync(AsyncClosingCallable<V> asyncClosingCallable, Executor executor) {
        return new ClosingFuture<>(asyncClosingCallable, executor);
    }

    public static Combiner whenAllComplete(Iterable<? extends ClosingFuture<?>> iterable) {
        return new Combiner(false, iterable, null);
    }

    public static Combiner whenAllSucceed(Iterable<? extends ClosingFuture<?>> iterable) {
        return new Combiner(true, iterable, null);
    }

    public static <V, U> AsyncClosingFunction<V, U> withoutCloser(AsyncFunction<V, U> asyncFunction) {
        Preconditions.checkNotNull(asyncFunction);
        return new i(asyncFunction);
    }

    @CanIgnoreReturnValue
    public boolean cancel(boolean z) {
        logger.log(Level.FINER, "cancelling {0}", this);
        boolean zCancel = this.future.cancel(z);
        if (zCancel) {
            close();
        }
        return zCancel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <X extends Throwable> ClosingFuture<V> catching(Class<X> cls, ClosingFunction<? super X, ? extends V> closingFunction, Executor executor) {
        return catchingMoreGeneric(cls, closingFunction, executor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <X extends Throwable> ClosingFuture<V> catchingAsync(Class<X> cls, AsyncClosingFunction<? super X, ? extends V> asyncClosingFunction, Executor executor) {
        return catchingAsyncMoreGeneric(cls, asyncClosingFunction, executor);
    }

    public void finalize() {
        if (this.state.get().equals(n.OPEN)) {
            logger.log(Level.SEVERE, "Uh oh! An open ClosingFuture has leaked and will close: {0}", this);
            finishToFuture();
        }
    }

    public FluentFuture<V> finishToFuture() {
        if (!compareAndUpdateState(n.OPEN, n.WILL_CLOSE)) {
            switch (c.a[this.state.get().ordinal()]) {
                case 1:
                    throw new IllegalStateException("Cannot call finishToFuture() after deriving another step");
                case 2:
                    throw new IllegalStateException("Cannot call finishToFuture() after calling finishToValueAndCloser()");
                case 3:
                case 4:
                case 5:
                    throw new IllegalStateException("Cannot call finishToFuture() twice");
                case 6:
                    throw new AssertionError();
            }
        }
        logger.log(Level.FINER, "will close {0}", this);
        this.future.addListener(new l(), MoreExecutors.directExecutor());
        return this.future;
    }

    public void finishToValueAndCloser(ValueAndCloserConsumer<? super V> valueAndCloserConsumer, Executor executor) {
        Preconditions.checkNotNull(valueAndCloserConsumer);
        if (compareAndUpdateState(n.OPEN, n.WILL_CREATE_VALUE_AND_CLOSER)) {
            this.future.addListener(new a(valueAndCloserConsumer), executor);
            return;
        }
        int i2 = c.a[this.state.get().ordinal()];
        if (i2 == 1) {
            throw new IllegalStateException("Cannot call finishToValueAndCloser() after deriving another step");
        }
        if (i2 == 2) {
            throw new IllegalStateException("Cannot call finishToValueAndCloser() twice");
        }
        if (i2 != 3 && i2 != 4 && i2 != 5) {
            throw new AssertionError(this.state);
        }
        throw new IllegalStateException("Cannot call finishToValueAndCloser() after calling finishToFuture()");
    }

    public ListenableFuture<?> statusFuture() {
        return Futures.nonCancellationPropagating(this.future.transform(Functions.constant(null), MoreExecutors.directExecutor()));
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("state", this.state.get()).addValue(this.future).toString();
    }

    public <U> ClosingFuture<U> transform(ClosingFunction<? super V, U> closingFunction, Executor executor) {
        Preconditions.checkNotNull(closingFunction);
        return derive(this.future.transformAsync(new g(closingFunction), executor));
    }

    public <U> ClosingFuture<U> transformAsync(AsyncClosingFunction<? super V, U> asyncClosingFunction, Executor executor) {
        Preconditions.checkNotNull(asyncClosingFunction);
        return derive(this.future.transformAsync(new h(asyncClosingFunction), executor));
    }

    @VisibleForTesting
    public CountDownLatch whenClosedCountDown() {
        return this.closeables.x();
    }

    public static final class m extends IdentityHashMap implements Closeable {
        public final DeferredCloser a;
        public volatile boolean b;
        public volatile CountDownLatch c;

        public m() {
            this.a = new DeferredCloser(this);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.b) {
                return;
            }
            synchronized (this) {
                try {
                    if (this.b) {
                        return;
                    }
                    this.b = true;
                    Iterator it = entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry entry = (Map.Entry) it.next();
                        ClosingFuture.closeQuietly((Closeable) entry.getKey(), (Executor) entry.getValue());
                    }
                    clear();
                    if (this.c != null) {
                        this.c.countDown();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void t(Closeable closeable, Executor executor) {
            Preconditions.checkNotNull(executor);
            if (closeable == null) {
                return;
            }
            synchronized (this) {
                try {
                    if (this.b) {
                        ClosingFuture.closeQuietly(closeable, executor);
                    } else {
                        put(closeable, executor);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public FluentFuture u(AsyncClosingFunction asyncClosingFunction, Object obj) {
            m mVar = new m();
            try {
                ClosingFuture closingFutureApply = asyncClosingFunction.apply(mVar.a, obj);
                closingFutureApply.becomeSubsumedInto(mVar);
                return closingFutureApply.future;
            } finally {
                t(mVar, MoreExecutors.directExecutor());
            }
        }

        public ListenableFuture v(ClosingFunction closingFunction, Object obj) {
            m mVar = new m();
            try {
                return Futures.immediateFuture(closingFunction.apply(mVar.a, obj));
            } finally {
                t(mVar, MoreExecutors.directExecutor());
            }
        }

        public CountDownLatch x() {
            if (this.b) {
                return new CountDownLatch(0);
            }
            synchronized (this) {
                try {
                    if (this.b) {
                        return new CountDownLatch(0);
                    }
                    Preconditions.checkState(this.c == null);
                    CountDownLatch countDownLatch = new CountDownLatch(1);
                    this.c = countDownLatch;
                    return countDownLatch;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public /* synthetic */ m(d dVar) {
            this();
        }
    }

    private ClosingFuture(ListenableFuture<V> listenableFuture) {
        this.state = new AtomicReference<>(n.OPEN);
        this.closeables = new m(null);
        this.future = FluentFuture.from(listenableFuture);
    }

    public static Combiner whenAllComplete(ClosingFuture<?> closingFuture, ClosingFuture<?>... closingFutureArr) {
        return whenAllComplete(Lists.asList(closingFuture, closingFutureArr));
    }

    public static <V1, V2> Combiner2<V1, V2> whenAllSucceed(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2) {
        return new Combiner2<>(closingFuture, closingFuture2, null);
    }

    public static <V1, V2, V3> Combiner3<V1, V2, V3> whenAllSucceed(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2, ClosingFuture<V3> closingFuture3) {
        return new Combiner3<>(closingFuture, closingFuture2, closingFuture3, null);
    }

    public static <V1, V2, V3, V4> Combiner4<V1, V2, V3, V4> whenAllSucceed(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2, ClosingFuture<V3> closingFuture3, ClosingFuture<V4> closingFuture4) {
        return new Combiner4<>(closingFuture, closingFuture2, closingFuture3, closingFuture4, null);
    }

    public static <V1, V2, V3, V4, V5> Combiner5<V1, V2, V3, V4, V5> whenAllSucceed(ClosingFuture<V1> closingFuture, ClosingFuture<V2> closingFuture2, ClosingFuture<V3> closingFuture3, ClosingFuture<V4> closingFuture4, ClosingFuture<V5> closingFuture5) {
        return new Combiner5<>(closingFuture, closingFuture2, closingFuture3, closingFuture4, closingFuture5, null);
    }

    private ClosingFuture(ClosingCallable<V> closingCallable, Executor executor) {
        this.state = new AtomicReference<>(n.OPEN);
        this.closeables = new m(null);
        Preconditions.checkNotNull(closingCallable);
        com.google.common.util.concurrent.k kVarC = com.google.common.util.concurrent.k.c(new e(closingCallable));
        executor.execute(kVarC);
        this.future = kVarC;
    }

    public static Combiner whenAllSucceed(ClosingFuture<?> closingFuture, ClosingFuture<?> closingFuture2, ClosingFuture<?> closingFuture3, ClosingFuture<?> closingFuture4, ClosingFuture<?> closingFuture5, ClosingFuture<?> closingFuture6, ClosingFuture<?>... closingFutureArr) {
        return whenAllSucceed(FluentIterable.of(closingFuture, closingFuture2, closingFuture3, closingFuture4, closingFuture5, closingFuture6).append(closingFutureArr));
    }

    private ClosingFuture(AsyncClosingCallable<V> asyncClosingCallable, Executor executor) {
        this.state = new AtomicReference<>(n.OPEN);
        this.closeables = new m(null);
        Preconditions.checkNotNull(asyncClosingCallable);
        com.google.common.util.concurrent.k kVarA = com.google.common.util.concurrent.k.a(new f(asyncClosingCallable));
        executor.execute(kVarA);
        this.future = kVarA;
    }
}
