package com.google.android.gms.internal.vision;

import defpackage.S90;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes2.dex */
public class zzeh<K, V> extends S90 implements Serializable {
    private final transient zzef<K, ? extends zzeb<V>> zza;
    private final transient int zzb;

    public zzeh(zzef<K, ? extends zzeb<V>> zzefVar, int i) {
        this.zza = zzefVar;
        this.zzb = i;
    }

    @Override // defpackage.U90
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    @Override // defpackage.U90
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // defpackage.U90
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // defpackage.U90
    public final boolean zza(@NullableDecl Object obj) {
        return obj != null && super.zza(obj);
    }

    public final Map<K, Collection<V>> zzb() {
        throw new AssertionError("should never be called");
    }

    @Override // defpackage.U90, com.google.android.gms.internal.vision.zzen
    public final /* synthetic */ Map zza() {
        return this.zza;
    }
}
