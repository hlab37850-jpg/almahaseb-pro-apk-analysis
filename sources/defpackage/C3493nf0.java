package defpackage;

import com.google.android.gms.internal.play_billing.z;
import com.google.android.gms.internal.play_billing.zzi;
import com.google.android.gms.internal.play_billing.zzo;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: renamed from: nf0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3493nf0 extends AbstractC3209k90 {
    public final AtomicReferenceFieldUpdater a;
    public final AtomicReferenceFieldUpdater b;
    public final AtomicReferenceFieldUpdater c;
    public final AtomicReferenceFieldUpdater d;
    public final AtomicReferenceFieldUpdater e;

    public C3493nf0(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
        super(null);
        this.a = atomicReferenceFieldUpdater;
        this.b = atomicReferenceFieldUpdater2;
        this.c = atomicReferenceFieldUpdater3;
        this.d = atomicReferenceFieldUpdater4;
        this.e = atomicReferenceFieldUpdater5;
    }

    @Override // defpackage.AbstractC3209k90
    public final void a(z zVar, z zVar2) {
        this.b.lazySet(zVar, zVar2);
    }

    @Override // defpackage.AbstractC3209k90
    public final void b(z zVar, Thread thread) {
        this.a.lazySet(zVar, thread);
    }

    @Override // defpackage.AbstractC3209k90
    public final boolean c(zzo zzoVar, Hd0 hd0, Hd0 hd1) {
        return zzi.zza(this.d, zzoVar, hd0, hd1);
    }

    @Override // defpackage.AbstractC3209k90
    public final boolean d(zzo zzoVar, Object obj, Object obj2) {
        return zzi.zza(this.e, zzoVar, obj, obj2);
    }

    @Override // defpackage.AbstractC3209k90
    public final boolean e(zzo zzoVar, z zVar, z zVar2) {
        return zzi.zza(this.c, zzoVar, zVar, zVar2);
    }
}
