package defpackage;

import com.google.android.gms.internal.common.zzag;
import com.google.android.gms.internal.common.zzs;
import java.util.List;

/* JADX INFO: renamed from: u40, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C4013u40 extends zzag {
    public final transient int a;
    public final transient int b;
    public final /* synthetic */ zzag c;

    public C4013u40(zzag zzagVar, int i, int i2) {
        this.c = zzagVar;
        this.a = i;
        this.b = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzs.zza(i, this.b, "index");
        return this.c.get(i + this.a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.common.zzag, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    @Override // com.google.android.gms.internal.common.zzac
    public final int zzb() {
        return this.c.zzc() + this.a + this.b;
    }

    @Override // com.google.android.gms.internal.common.zzac
    public final int zzc() {
        return this.c.zzc() + this.a;
    }

    @Override // com.google.android.gms.internal.common.zzac
    public final boolean zzf() {
        return true;
    }

    @Override // com.google.android.gms.internal.common.zzac
    public final Object[] zzg() {
        return this.c.zzg();
    }

    @Override // com.google.android.gms.internal.common.zzag
    /* JADX INFO: renamed from: zzh */
    public final zzag subList(int i, int i2) {
        zzs.zzc(i, i2, this.b);
        int i3 = this.a;
        return this.c.subList(i + i3, i2 + i3);
    }
}
