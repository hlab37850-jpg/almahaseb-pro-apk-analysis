package com.google.android.gms.internal.fido;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends zzat {
    public static final zzat c = new a(new Object[0], 0);
    public final transient Object[] a;
    public final transient int b;

    public a(Object[] objArr, int i) {
        this.a = objArr;
        this.b = i;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzam.zza(i, this.b, "index");
        Object obj = this.a[i];
        obj.getClass();
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.fido.zzat, com.google.android.gms.internal.fido.zzaq
    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.a, 0, objArr, 0, this.b);
        return this.b;
    }

    @Override // com.google.android.gms.internal.fido.zzaq
    public final int zzb() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.fido.zzaq
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.fido.zzaq
    public final Object[] zze() {
        return this.a;
    }
}
