package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c extends d {
    public static final Logger h = Logger.getLogger(c.class.getName());
    public ImmutableCollection e;
    public final boolean f;
    public final boolean g;

    public enum a {
        OUTPUT_FUTURE_DONE,
        ALL_INPUT_FUTURES_PROCESSED
    }

    public c(ImmutableCollection immutableCollection, boolean z, boolean z2) {
        super(immutableCollection.size());
        this.e = (ImmutableCollection) Preconditions.checkNotNull(immutableCollection);
        this.f = z;
        this.g = z2;
    }

    public static boolean j(Set set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }

    public static void s(Throwable th) {
        h.log(Level.SEVERE, th instanceof Error ? "Input Future failed with Error" : "Got more than one input Future failure. Logging failures after the first", th);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        super.afterDone();
        ImmutableCollection immutableCollection = this.e;
        u(a.OUTPUT_FUTURE_DONE);
        if (isCancelled() && (immutableCollection != null)) {
            boolean zWasInterrupted = wasInterrupted();
            UnmodifiableIterator it = immutableCollection.iterator();
            while (it.hasNext()) {
                ((Future) it.next()).cancel(zWasInterrupted);
            }
        }
    }

    @Override // com.google.common.util.concurrent.d
    public final void d(Set set) {
        Preconditions.checkNotNull(set);
        if (isCancelled()) {
            return;
        }
        Throwable thTryInternalFastPathGetFailure = tryInternalFastPathGetFailure();
        Objects.requireNonNull(thTryInternalFastPathGetFailure);
        j(set, thTryInternalFastPathGetFailure);
    }

    public abstract void k(int i, Object obj);

    public final void l(int i, Future future) {
        try {
            k(i, Futures.getDone(future));
        } catch (ExecutionException e) {
            o(e.getCause());
        } catch (Throwable th) {
            o(th);
        }
    }

    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public final void r(ImmutableCollection immutableCollection) {
        int iF = f();
        Preconditions.checkState(iF >= 0, "Less than 0 remaining futures");
        if (iF == 0) {
            t(immutableCollection);
        }
    }

    public abstract void n();

    public final void o(Throwable th) {
        Preconditions.checkNotNull(th);
        if (this.f && !setException(th) && j(g(), th)) {
            s(th);
        } else if (th instanceof Error) {
            s(th);
        }
    }

    public final void p() {
        Objects.requireNonNull(this.e);
        if (this.e.isEmpty()) {
            n();
            return;
        }
        if (!this.f) {
            final ImmutableCollection immutableCollection = this.g ? this.e : null;
            Runnable runnable = new Runnable() { // from class: w2
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.r(immutableCollection);
                }
            };
            UnmodifiableIterator it = this.e.iterator();
            while (it.hasNext()) {
                ((ListenableFuture) it.next()).addListener(runnable, MoreExecutors.directExecutor());
            }
            return;
        }
        UnmodifiableIterator it2 = this.e.iterator();
        final int i = 0;
        while (it2.hasNext()) {
            final ListenableFuture listenableFuture = (ListenableFuture) it2.next();
            listenableFuture.addListener(new Runnable() { // from class: v2
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.q(listenableFuture, i);
                }
            }, MoreExecutors.directExecutor());
            i++;
        }
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final String pendingToString() {
        ImmutableCollection immutableCollection = this.e;
        if (immutableCollection == null) {
            return super.pendingToString();
        }
        String strValueOf = String.valueOf(immutableCollection);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 8);
        sb.append("futures=");
        sb.append(strValueOf);
        return sb.toString();
    }

    public final /* synthetic */ void q(ListenableFuture listenableFuture, int i) {
        try {
            if (listenableFuture.isCancelled()) {
                this.e = null;
                cancel(false);
            } else {
                l(i, listenableFuture);
            }
        } finally {
            r(null);
        }
    }

    public final void t(ImmutableCollection immutableCollection) {
        if (immutableCollection != null) {
            UnmodifiableIterator it = immutableCollection.iterator();
            int i = 0;
            while (it.hasNext()) {
                Future future = (Future) it.next();
                if (!future.isCancelled()) {
                    l(i, future);
                }
                i++;
            }
        }
        e();
        n();
        u(a.ALL_INPUT_FUTURES_PROCESSED);
    }

    public void u(a aVar) {
        Preconditions.checkNotNull(aVar);
        this.e = null;
    }
}
