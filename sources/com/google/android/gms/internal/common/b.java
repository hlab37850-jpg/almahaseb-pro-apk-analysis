package com.google.android.gms.internal.common;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends zzag {
    public static final zzag c = new b(new Object[0], 0);
    public final transient Object[] a;
    public final transient int b;

    public b(Object[] objArr, int i) {
        this.a = objArr;
        this.b = i;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzs.zza(i, this.b, "index");
        Object obj = this.a[i];
        obj.getClass();
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.common.zzag, com.google.android.gms.internal.common.zzac
    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.a, 0, objArr, 0, this.b);
        return this.b;
    }

    @Override // com.google.android.gms.internal.common.zzac
    public final int zzb() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.common.zzac
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.common.zzac
    public final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.common.zzac
    public final Object[] zzg() {
        return this.a;
    }
}
