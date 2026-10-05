package com.google.android.gms.internal.vision;

import defpackage.La0;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends zzej {
    public static final c f = new c(new Object[0], 0, null, 0, 0);
    public final transient Object[] a;
    public final transient Object[] b;
    public final transient int c;
    public final transient int d;
    public final transient int e;

    public c(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.a = objArr;
        this.b = objArr2;
        this.c = i2;
        this.d = i;
        this.e = i3;
    }

    @Override // com.google.android.gms.internal.vision.zzeb, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        Object[] objArr = this.b;
        if (obj == null || objArr == null) {
            return false;
        }
        int iB = La0.b(obj);
        while (true) {
            int i = iB & this.c;
            Object obj2 = objArr[i];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            iB = i + 1;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzej, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.d;
    }

    @Override // com.google.android.gms.internal.vision.zzej, com.google.android.gms.internal.vision.zzeb, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.e;
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    /* JADX INFO: renamed from: zza */
    public final zzfa iterator() {
        return (zzfa) zze().iterator();
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
        return this.e;
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    public final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.vision.zzej
    public final boolean zzg() {
        return true;
    }

    @Override // com.google.android.gms.internal.vision.zzej
    public final zzee zzh() {
        return zzee.zzb(this.a, this.e);
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.a, 0, objArr, i, this.e);
        return i + this.e;
    }
}
