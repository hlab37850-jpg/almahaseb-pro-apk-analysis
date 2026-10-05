package defpackage;

import com.google.android.gms.internal.location.zzbm;
import com.google.android.gms.internal.location.zzbs;
import java.util.List;

/* JADX INFO: renamed from: o70, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3533o70 extends zzbs {
    public final transient int a;
    public final transient int b;
    public final /* synthetic */ zzbs c;

    public C3533o70(zzbs zzbsVar, int i, int i2) {
        this.c = zzbsVar;
        this.a = i;
        this.b = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzbm.zza(i, this.b, "index");
        return this.c.get(i + this.a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.location.zzbs, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    @Override // com.google.android.gms.internal.location.zzbp
    public final Object[] zzb() {
        return this.c.zzb();
    }

    @Override // com.google.android.gms.internal.location.zzbp
    public final int zzc() {
        return this.c.zzc() + this.a;
    }

    @Override // com.google.android.gms.internal.location.zzbp
    public final int zzd() {
        return this.c.zzc() + this.a + this.b;
    }

    @Override // com.google.android.gms.internal.location.zzbp
    public final boolean zzf() {
        return true;
    }

    @Override // com.google.android.gms.internal.location.zzbs
    /* JADX INFO: renamed from: zzh */
    public final zzbs subList(int i, int i2) {
        zzbm.zzc(i, i2, this.b);
        zzbs zzbsVar = this.c;
        int i3 = this.a;
        return zzbsVar.subList(i + i3, i2 + i3);
    }
}
