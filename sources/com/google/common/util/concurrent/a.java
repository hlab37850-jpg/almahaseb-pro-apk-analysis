package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import com.google.common.util.concurrent.internal.InternalFutures;
import defpackage.DG;
import defpackage.XD;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends FluentFuture.a implements Runnable {
    public ListenableFuture a;
    public Class b;
    public Object c;

    /* JADX INFO: renamed from: com.google.common.util.concurrent.a$a, reason: collision with other inner class name */
    public static final class C0265a extends a {
        public C0265a(ListenableFuture listenableFuture, Class cls, AsyncFunction asyncFunction) {
            super(listenableFuture, cls, asyncFunction);
        }

        @Override // com.google.common.util.concurrent.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public ListenableFuture c(AsyncFunction asyncFunction, Throwable th) {
            ListenableFuture listenableFutureApply = asyncFunction.apply(th);
            Preconditions.checkNotNull(listenableFutureApply, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", asyncFunction);
            return listenableFutureApply;
        }

        @Override // com.google.common.util.concurrent.a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(ListenableFuture listenableFuture) {
            setFuture(listenableFuture);
        }
    }

    public static final class b extends a {
        public b(ListenableFuture listenableFuture, Class cls, Function function) {
            super(listenableFuture, cls, function);
        }

        @Override // com.google.common.util.concurrent.a
        public void d(Object obj) {
            set(obj);
        }

        @Override // com.google.common.util.concurrent.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Object c(Function function, Throwable th) {
            return function.apply(th);
        }
    }

    public a(ListenableFuture listenableFuture, Class cls, Object obj) {
        this.a = (ListenableFuture) Preconditions.checkNotNull(listenableFuture);
        this.b = (Class) Preconditions.checkNotNull(cls);
        this.c = Preconditions.checkNotNull(obj);
    }

    public static ListenableFuture a(ListenableFuture listenableFuture, Class cls, Function function, Executor executor) {
        b bVar = new b(listenableFuture, cls, function);
        listenableFuture.addListener(bVar, MoreExecutors.rejectionPropagatingExecutor(executor, bVar));
        return bVar;
    }

    public static ListenableFuture b(ListenableFuture listenableFuture, Class cls, AsyncFunction asyncFunction, Executor executor) {
        C0265a c0265a = new C0265a(listenableFuture, cls, asyncFunction);
        listenableFuture.addListener(c0265a, MoreExecutors.rejectionPropagatingExecutor(executor, c0265a));
        return c0265a;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        maybePropagateCancellationTo(this.a);
        this.a = null;
        this.b = null;
        this.c = null;
    }

    public abstract Object c(Object obj, Throwable th);

    public abstract void d(Object obj);

    @Override // com.google.common.util.concurrent.AbstractFuture
    public String pendingToString() {
        String string;
        ListenableFuture listenableFuture = this.a;
        Class cls = this.b;
        Object obj = this.c;
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
        if (cls == null || obj == null) {
            if (strPendingToString == null) {
                return null;
            }
            String strValueOf2 = String.valueOf(string);
            return strPendingToString.length() != 0 ? strValueOf2.concat(strPendingToString) : new String(strValueOf2);
        }
        String strValueOf3 = String.valueOf(cls);
        String strValueOf4 = String.valueOf(obj);
        StringBuilder sb2 = new StringBuilder(String.valueOf(string).length() + 29 + strValueOf3.length() + strValueOf4.length());
        sb2.append(string);
        sb2.append("exceptionType=[");
        sb2.append(strValueOf3);
        sb2.append("], fallback=[");
        sb2.append(strValueOf4);
        sb2.append("]");
        return sb2.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        Object done;
        ListenableFuture listenableFuture = this.a;
        Class cls = this.b;
        Object obj = this.c;
        if (((obj == null) || ((listenableFuture == 0) | (cls == null))) || isCancelled()) {
            return;
        }
        this.a = null;
        try {
            th = listenableFuture instanceof InternalFutureFailureAccess ? InternalFutures.tryInternalFastPathGetFailure((InternalFutureFailureAccess) listenableFuture) : null;
            done = th == null ? Futures.getDone(listenableFuture) : null;
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause == null) {
                String strValueOf = String.valueOf(listenableFuture.getClass());
                String strValueOf2 = String.valueOf(e.getClass());
                StringBuilder sb = new StringBuilder(strValueOf.length() + 35 + strValueOf2.length());
                sb.append("Future type ");
                sb.append(strValueOf);
                sb.append(" threw ");
                sb.append(strValueOf2);
                sb.append(" without a cause");
                cause = new NullPointerException(sb.toString());
            }
            th = cause;
        } catch (Throwable th) {
            th = th;
        }
        if (th == null) {
            set(XD.a(done));
            return;
        }
        if (!DG.a(th, cls)) {
            setFuture(listenableFuture);
            return;
        }
        try {
            Object objC = c(obj, th);
            this.b = null;
            this.c = null;
            d(objC);
        } catch (Throwable th2) {
            try {
                setException(th2);
            } finally {
                this.b = null;
                this.c = null;
            }
        }
    }
}
