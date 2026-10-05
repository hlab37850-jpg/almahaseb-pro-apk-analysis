package com.google.common.util.concurrent;

import com.google.common.collect.Sets;
import defpackage.AbstractC2403i0;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d extends AbstractFuture.j {
    public static final b c;
    public static final Logger d = Logger.getLogger(d.class.getName());
    public volatile Set a = null;
    public volatile int b;

    public static abstract class b {
        public b() {
        }

        public abstract void a(d dVar, Set set, Set set2);

        public abstract int b(d dVar);
    }

    public static final class c extends b {
        public final AtomicReferenceFieldUpdater a;
        public final AtomicIntegerFieldUpdater b;

        public c(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
            super();
            this.a = atomicReferenceFieldUpdater;
            this.b = atomicIntegerFieldUpdater;
        }

        @Override // com.google.common.util.concurrent.d.b
        public void a(d dVar, Set set, Set set2) {
            AbstractC2403i0.a(this.a, dVar, set, set2);
        }

        @Override // com.google.common.util.concurrent.d.b
        public int b(d dVar) {
            return this.b.decrementAndGet(dVar);
        }
    }

    /* JADX INFO: renamed from: com.google.common.util.concurrent.d$d, reason: collision with other inner class name */
    public static final class C0267d extends b {
        public C0267d() {
            super();
        }

        @Override // com.google.common.util.concurrent.d.b
        public void a(d dVar, Set set, Set set2) {
            synchronized (dVar) {
                try {
                    if (dVar.a == set) {
                        dVar.a = set2;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.google.common.util.concurrent.d.b
        public int b(d dVar) {
            int iC;
            synchronized (dVar) {
                iC = d.c(dVar);
            }
            return iC;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        b c0267d;
        Throwable th = null;
        Object[] objArr = 0;
        try {
            c0267d = new c(AtomicReferenceFieldUpdater.newUpdater(d.class, Set.class, "a"), AtomicIntegerFieldUpdater.newUpdater(d.class, "b"));
        } catch (Throwable th2) {
            c0267d = new C0267d();
            th = th2;
        }
        c = c0267d;
        if (th != null) {
            d.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
    }

    public d(int i) {
        this.b = i;
    }

    public static /* synthetic */ int c(d dVar) {
        int i = dVar.b - 1;
        dVar.b = i;
        return i;
    }

    public abstract void d(Set set);

    public final void e() {
        this.a = null;
    }

    public final int f() {
        return c.b(this);
    }

    public final Set g() {
        Set set = this.a;
        if (set != null) {
            return set;
        }
        Set setNewConcurrentHashSet = Sets.newConcurrentHashSet();
        d(setNewConcurrentHashSet);
        c.a(this, null, setNewConcurrentHashSet);
        Set set2 = this.a;
        Objects.requireNonNull(set2);
        return set2;
    }
}
