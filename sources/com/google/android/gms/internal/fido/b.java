package com.google.android.gms.internal.fido;

import defpackage.AbstractC2168f50;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends zzau {
    public static final Object[] f;
    public static final b g;
    public final transient Object[] a;
    public final transient int b;
    public final transient Object[] c;
    public final transient int d;
    public final transient int e;

    static {
        Object[] objArr = new Object[0];
        f = objArr;
        g = new b(objArr, 0, objArr, 0, 0);
    }

    public b(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.a = objArr;
        this.b = i;
        this.c = objArr2;
        this.d = i2;
        this.e = i3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        Object[] objArr = this.c;
        if (obj == null || objArr.length == 0) {
            return false;
        }
        int iA = AbstractC2168f50.a(obj.hashCode());
        while (true) {
            int i = iA & this.d;
            Object obj2 = objArr[i];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            iA = i + 1;
        }
    }

    @Override // com.google.android.gms.internal.fido.zzau, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.fido.zzau, com.google.android.gms.internal.fido.zzaq, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return zzg().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.e;
    }

    @Override // com.google.android.gms.internal.fido.zzaq
    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.a, 0, objArr, 0, this.e);
        return this.e;
    }

    @Override // com.google.android.gms.internal.fido.zzaq
    public final int zzb() {
        return this.e;
    }

    @Override // com.google.android.gms.internal.fido.zzaq
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.fido.zzau, com.google.android.gms.internal.fido.zzaq
    /* JADX INFO: renamed from: zzd */
    public final zzaz iterator() {
        return zzg().listIterator(0);
    }

    @Override // com.google.android.gms.internal.fido.zzaq
    public final Object[] zze() {
        return this.a;
    }

    @Override // com.google.android.gms.internal.fido.zzau
    public final zzat zzh() {
        return zzat.zzg(this.a, this.e);
    }

    @Override // com.google.android.gms.internal.fido.zzau
    public final boolean zzj() {
        return true;
    }
}
