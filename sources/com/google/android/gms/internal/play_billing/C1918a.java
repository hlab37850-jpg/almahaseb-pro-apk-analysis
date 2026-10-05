package com.google.android.gms.internal.play_billing;

import java.util.Objects;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1918a extends zzbt {
    public static final zzbt c = new C1918a(new Object[0], 0);
    public final transient Object[] a;
    public final transient int b;

    public C1918a(Object[] objArr, int i) {
        this.a = objArr;
        this.b = i;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzbg.zza(i, this.b, "index");
        Object obj = this.a[i];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbt, com.google.android.gms.internal.play_billing.zzbq
    public final int zza(Object[] objArr, int i) {
        Object[] objArr2 = this.a;
        int i2 = this.b;
        System.arraycopy(objArr2, 0, objArr, 0, i2);
        return i2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbq
    public final int zzb() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbq
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbq
    public final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbq
    public final Object[] zzg() {
        return this.a;
    }
}
