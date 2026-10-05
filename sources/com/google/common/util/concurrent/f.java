package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import defpackage.AbstractRunnableC4239wt;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends com.google.common.util.concurrent.c {
    public c i;

    public final class a extends c {
        public final AsyncCallable e;

        public a(AsyncCallable asyncCallable, Executor executor) {
            super(executor);
            this.e = (AsyncCallable) Preconditions.checkNotNull(asyncCallable);
        }

        @Override // defpackage.AbstractRunnableC4239wt
        public String h() {
            return this.e.toString();
        }

        @Override // defpackage.AbstractRunnableC4239wt
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public ListenableFuture f() {
            return (ListenableFuture) Preconditions.checkNotNull(this.e.call(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.e);
        }

        @Override // com.google.common.util.concurrent.f.c
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public void k(ListenableFuture listenableFuture) {
            f.this.setFuture(listenableFuture);
        }
    }

    public final class b extends c {
        public final Callable e;

        public b(Callable callable, Executor executor) {
            super(executor);
            this.e = (Callable) Preconditions.checkNotNull(callable);
        }

        @Override // defpackage.AbstractRunnableC4239wt
        public Object f() {
            return this.e.call();
        }

        @Override // defpackage.AbstractRunnableC4239wt
        public String h() {
            return this.e.toString();
        }

        @Override // com.google.common.util.concurrent.f.c
        public void k(Object obj) {
            f.this.set(obj);
        }
    }

    public abstract class c extends AbstractRunnableC4239wt {
        public final Executor c;

        public c(Executor executor) {
            this.c = (Executor) Preconditions.checkNotNull(executor);
        }

        @Override // defpackage.AbstractRunnableC4239wt
        public final void a(Throwable th) {
            f.this.i = null;
            if (th instanceof ExecutionException) {
                f.this.setException(((ExecutionException) th).getCause());
            } else if (th instanceof CancellationException) {
                f.this.cancel(false);
            } else {
                f.this.setException(th);
            }
        }

        @Override // defpackage.AbstractRunnableC4239wt
        public final void b(Object obj) {
            f.this.i = null;
            k(obj);
        }

        @Override // defpackage.AbstractRunnableC4239wt
        public final boolean e() {
            return f.this.isDone();
        }

        public final void j() {
            try {
                this.c.execute(this);
            } catch (RejectedExecutionException e) {
                f.this.setException(e);
            }
        }

        public abstract void k(Object obj);
    }

    public f(ImmutableCollection immutableCollection, boolean z, Executor executor, AsyncCallable asyncCallable) {
        super(immutableCollection, z, false);
        this.i = new a(asyncCallable, executor);
        p();
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public void interruptTask() {
        c cVar = this.i;
        if (cVar != null) {
            cVar.c();
        }
    }

    @Override // com.google.common.util.concurrent.c
    public void k(int i, Object obj) {
    }

    @Override // com.google.common.util.concurrent.c
    public void n() {
        c cVar = this.i;
        if (cVar != null) {
            cVar.j();
        }
    }

    @Override // com.google.common.util.concurrent.c
    public void u(com.google.common.util.concurrent.c.a aVar) {
        super.u(aVar);
        if (aVar == com.google.common.util.concurrent.c.a.OUTPUT_FUTURE_DONE) {
            this.i = null;
        }
    }

    public f(ImmutableCollection immutableCollection, boolean z, Executor executor, Callable callable) {
        super(immutableCollection, z, false);
        this.i = new b(callable, executor);
        p();
    }
}
