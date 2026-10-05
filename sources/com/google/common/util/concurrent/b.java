package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b extends FluentFuture.a implements Runnable {
    public ListenableFuture a;
    public Object b;

    public static final class a extends b {
        public a(ListenableFuture listenableFuture, AsyncFunction asyncFunction) {
            super(listenableFuture, asyncFunction);
        }

        @Override // com.google.common.util.concurrent.b
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public ListenableFuture c(AsyncFunction asyncFunction, Object obj) {
            ListenableFuture listenableFutureApply = asyncFunction.apply(obj);
            Preconditions.checkNotNull(listenableFutureApply, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", asyncFunction);
            return listenableFutureApply;
        }

        @Override // com.google.common.util.concurrent.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(ListenableFuture listenableFuture) {
            setFuture(listenableFuture);
        }
    }

    /* JADX INFO: renamed from: com.google.common.util.concurrent.b$b, reason: collision with other inner class name */
    public static final class C0266b extends b {
        public C0266b(ListenableFuture listenableFuture, Function function) {
            super(listenableFuture, function);
        }

        @Override // com.google.common.util.concurrent.b
        public void d(Object obj) {
            set(obj);
        }

        @Override // com.google.common.util.concurrent.b
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Object c(Function function, Object obj) {
            return function.apply(obj);
        }
    }

    public b(ListenableFuture listenableFuture, Object obj) {
        this.a = (ListenableFuture) Preconditions.checkNotNull(listenableFuture);
        this.b = Preconditions.checkNotNull(obj);
    }

    public static ListenableFuture a(ListenableFuture listenableFuture, Function function, Executor executor) {
        Preconditions.checkNotNull(function);
        C0266b c0266b = new C0266b(listenableFuture, function);
        listenableFuture.addListener(c0266b, MoreExecutors.rejectionPropagatingExecutor(executor, c0266b));
        return c0266b;
    }

    public static ListenableFuture b(ListenableFuture listenableFuture, AsyncFunction asyncFunction, Executor executor) {
        Preconditions.checkNotNull(executor);
        a aVar = new a(listenableFuture, asyncFunction);
        listenableFuture.addListener(aVar, MoreExecutors.rejectionPropagatingExecutor(executor, aVar));
        return aVar;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        maybePropagateCancellationTo(this.a);
        this.a = null;
        this.b = null;
    }

    public abstract Object c(Object obj, Object obj2);

    public abstract void d(Object obj);

    @Override // com.google.common.util.concurrent.AbstractFuture
    public String pendingToString() {
        String string;
        ListenableFuture listenableFuture = this.a;
        Object obj = this.b;
        String strPendingToString = super.pendingToString();
        if (listenableFuture != null) {
            String strValueOf = String.valueOf(listenableFuture);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 16);
            sb.append("inputFuture=[");
            sb.append(strValueOf);
            sb.append("], ");
            string = sb.toString();
        } else {
            string = "";
        }
        if (obj == null) {
            if (strPendingToString == null) {
                return null;
            }
            String strValueOf2 = String.valueOf(string);
            return strPendingToString.length() != 0 ? strValueOf2.concat(strPendingToString) : new String(strValueOf2);
        }
        String strValueOf3 = String.valueOf(obj);
        StringBuilder sb2 = new StringBuilder(String.valueOf(string).length() + 11 + strValueOf3.length());
        sb2.append(string);
        sb2.append("function=[");
        sb2.append(strValueOf3);
        sb2.append("]");
        return sb2.toString();
    }

    @Override // java.lang.Runnable
    public final void run() {
        ListenableFuture listenableFuture = this.a;
        Object obj = this.b;
        if ((isCancelled() | (listenableFuture == null)) || (obj == null)) {
            return;
        }
        this.a = null;
        if (listenableFuture.isCancelled()) {
            setFuture(listenableFuture);
            return;
        }
        try {
            try {
                Object objC = c(obj, Futures.getDone(listenableFuture));
                this.b = null;
                d(objC);
            } catch (Throwable th) {
                try {
                    setException(th);
                } finally {
                    this.b = null;
                }
            }
        } catch (Error e) {
            setException(e);
        } catch (CancellationException unused) {
            cancel(false);
        } catch (RuntimeException e2) {
            setException(e2);
        } catch (ExecutionException e3) {
            setException(e3.getCause());
        }
    }
}
