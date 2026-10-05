package defpackage;

import com.google.android.gms.internal.play_billing.zzbt;
import com.google.android.gms.internal.play_billing.zzbw;
import com.google.android.gms.internal.play_billing.zzbx;
import com.google.android.gms.internal.play_billing.zzch;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: f80, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2174f80 extends zzbx {
    public final transient zzbw a;
    public final transient Object[] b;
    public final transient int c;

    public C2174f80(zzbw zzbwVar, Object[] objArr, int i, int i2) {
        this.a = zzbwVar;
        this.b = objArr;
        this.c = i2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbq, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.a.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbx, com.google.android.gms.internal.play_billing.zzbq, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return zzd().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbq
    public final int zza(Object[] objArr, int i) {
        return zzd().zza(objArr, 0);
    }

    @Override // com.google.android.gms.internal.play_billing.zzbx, com.google.android.gms.internal.play_billing.zzbq
    /* JADX INFO: renamed from: zze */
    public final zzch iterator() {
        return zzd().listIterator(0);
    }

    @Override // com.google.android.gms.internal.play_billing.zzbq
    public final boolean zzf() {
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbx
    public final zzbt zzh() {
        return new C1772b80(this);
    }
}
