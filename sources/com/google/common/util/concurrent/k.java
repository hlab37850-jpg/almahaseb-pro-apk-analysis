package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import defpackage.AbstractRunnableC4239wt;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;

/* JADX INFO: loaded from: classes3.dex */
public class k extends FluentFuture.a implements RunnableFuture {
    public volatile AbstractRunnableC4239wt a;

    public final class a extends AbstractRunnableC4239wt {
        public final AsyncCallable c;

        public a(AsyncCallable asyncCallable) {
            this.c = (AsyncCallable) Preconditions.checkNotNull(asyncCallable);
        }

        @Override // defpackage.AbstractRunnableC4239wt
        public void a(Throwable th) {
            k.this.setException(th);
        }

        @Override // defpackage.AbstractRunnableC4239wt
        public final boolean e() {
            return k.this.isDone();
        }

        @Override // defpackage.AbstractRunnableC4239wt
        public String h() {
            return this.c.toString();
        }

        @Override // defpackage.AbstractRunnableC4239wt
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public void b(ListenableFuture listenableFuture) {
            k.this.setFuture(listenableFuture);
        }

        @Override // defpackage.AbstractRunnableC4239wt
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public ListenableFuture f() {
            return (ListenableFuture) Preconditions.checkNotNull(this.c.call(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.c);
        }
    }

    public final class b extends AbstractRunnableC4239wt {
        public final Callable c;

        public b(Callable callable) {
            this.c = (Callable) Preconditions.checkNotNull(callable);
        }

        @Override // defpackage.AbstractRunnableC4239wt
        public void a(Throwable th) {
            k.this.setException(th);
        }

        @Override // defpackage.AbstractRunnableC4239wt
        public void b(Object obj) {
            k.this.set(obj);
        }

        @Override // defpackage.AbstractRunnableC4239wt
        public final boolean e() {
            return k.this.isDone();
        }

        @Override // defpackage.AbstractRunnableC4239wt
        public Object f() {
            return this.c.call();
        }

        @Override // defpackage.AbstractRunnableC4239wt
        public String h() {
            return this.c.toString();
        }
    }

    public k(Callable callable) {
        this.a = new b(callable);
    }

    public static k a(AsyncCallable asyncCallable) {
        return new k(asyncCallable);
    }

    public static k b(Runnable runnable, Object obj) {
        return new k(Executors.callable(runnable, obj));
    }

    public static k c(Callable callable) {
        return new k(callable);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public void afterDone() {
        AbstractRunnableC4239wt abstractRunnableC4239wt;
        super.afterDone();
        if (wasInterrupted() && (abstractRunnableC4239wt = this.a) != null) {
            abstractRunnableC4239wt.c();
        }
        this.a = null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public String pendingToString() {
        AbstractRunnableC4239wt abstractRunnableC4239wt = this.a;
        if (abstractRunnableC4239wt == null) {
            return super.pendingToString();
        }
        String strValueOf = String.valueOf(abstractRunnableC4239wt);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 7);
        sb.append("task=[");
        sb.append(strValueOf);
        sb.append("]");
        return sb.toString();
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        AbstractRunnableC4239wt abstractRunnableC4239wt = this.a;
        if (abstractRunnableC4239wt != null) {
            abstractRunnableC4239wt.run();
        }
        this.a = null;
    }

    public k(AsyncCallable asyncCallable) {
        this.a = new a(asyncCallable);
    }
}
