package com.google.android.gms.internal.vision;

/* JADX INFO: renamed from: com.google.android.gms.internal.vision.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1920a extends zzee {
    public static final zzee c = new C1920a(new Object[0], 0);
    public final transient Object[] a;
    public final transient int b;

    public C1920a(Object[] objArr, int i) {
        this.a = objArr;
        this.b = i;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzde.zza(i, this.b);
        return this.a[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.vision.zzee, com.google.android.gms.internal.vision.zzeb
    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.a, 0, objArr, i, this.b);
        return i + this.b;
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    public final Object[] zzb() {
        return this.a;
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    public final int zzd() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    public final boolean zzf() {
        return false;
    }
}
