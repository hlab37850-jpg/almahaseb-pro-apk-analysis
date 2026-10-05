package defpackage;

import com.google.android.gms.internal.play_billing.zzbt;
import com.google.android.gms.internal.play_billing.zzbw;
import com.google.android.gms.internal.play_billing.zzbx;
import com.google.android.gms.internal.play_billing.zzch;
import java.util.Iterator;

/* JADX INFO: renamed from: j80, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3125j80 extends zzbx {
    public final transient zzbw a;
    public final transient zzbt b;

    public C3125j80(zzbw zzbwVar, zzbt zzbtVar) {
        this.a = zzbwVar;
        this.b = zzbtVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbq, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.a.get(obj) != null;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbx, com.google.android.gms.internal.play_billing.zzbq, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return this.b.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.a.size();
    }

    @Override // com.google.android.gms.internal.play_billing.zzbq
    public final int zza(Object[] objArr, int i) {
        return this.b.zza(objArr, 0);
    }

    @Override // com.google.android.gms.internal.play_billing.zzbx, com.google.android.gms.internal.play_billing.zzbq
    public final zzbt zzd() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbx, com.google.android.gms.internal.play_billing.zzbq
    /* JADX INFO: renamed from: zze */
    public final zzch iterator() {
        return this.b.listIterator(0);
    }

    @Override // com.google.android.gms.internal.play_billing.zzbq
    public final boolean zzf() {
        throw null;
    }
}
