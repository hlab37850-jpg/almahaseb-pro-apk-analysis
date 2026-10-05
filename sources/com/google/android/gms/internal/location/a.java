package com.google.android.gms.internal.location;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends zzbs {
    public static final zzbs c = new a(new Object[0], 0);
    public final transient Object[] a;
    public final transient int b;

    public a(Object[] objArr, int i) {
        this.a = objArr;
        this.b = i;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzbm.zza(i, this.b, "index");
        return this.a[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.location.zzbp
    public final Object[] zzb() {
        return this.a;
    }

    @Override // com.google.android.gms.internal.location.zzbp
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.location.zzbp
    public final int zzd() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.location.zzbp
    public final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.location.zzbs, com.google.android.gms.internal.location.zzbp
    public final int zzg(Object[] objArr, int i) {
        System.arraycopy(this.a, 0, objArr, 0, this.b);
        return this.b;
    }
}
