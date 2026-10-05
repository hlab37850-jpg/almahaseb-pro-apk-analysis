package com.google.android.gms.internal.play_billing;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends h {
    public static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(l.class, Thread.class, "a");
    public static final AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(l.class, l.class, "b");
    public static final AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(m.class, l.class, "waitersField");
    public static final AtomicReferenceFieldUpdater d = AtomicReferenceFieldUpdater.newUpdater(m.class, f.class, "listenersField");
    public static final AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "valueField");

    public /* synthetic */ i(zzco zzcoVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.play_billing.h
    public final f a(m mVar, f fVar) {
        return (f) d.getAndSet(mVar, fVar);
    }

    @Override // com.google.android.gms.internal.play_billing.h
    public final l b(m mVar, l lVar) {
        return (l) c.getAndSet(mVar, lVar);
    }

    @Override // com.google.android.gms.internal.play_billing.h
    public final void c(l lVar, l lVar2) {
        b.lazySet(lVar, lVar2);
    }

    @Override // com.google.android.gms.internal.play_billing.h
    public final void d(l lVar, Thread thread) {
        a.lazySet(lVar, thread);
    }

    @Override // com.google.android.gms.internal.play_billing.h
    public final boolean e(m mVar, f fVar, f fVar2) {
        return zzcl.zza(d, mVar, fVar, fVar2);
    }

    @Override // com.google.android.gms.internal.play_billing.h
    public final boolean f(m mVar, Object obj, Object obj2) {
        return zzcl.zza(e, mVar, obj, obj2);
    }

    @Override // com.google.android.gms.internal.play_billing.h
    public final boolean g(m mVar, l lVar, l lVar2) {
        return zzcl.zza(c, mVar, lVar, lVar2);
    }
}
