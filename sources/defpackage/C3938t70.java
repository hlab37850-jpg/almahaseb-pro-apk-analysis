package defpackage;

import com.google.android.gms.internal.play_billing.zzbg;
import com.google.android.gms.internal.play_billing.zzbt;
import java.util.List;
import java.util.Objects;

/* JADX INFO: renamed from: t70, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3938t70 extends zzbt {
    public final transient int a;
    public final transient int b;
    public final /* synthetic */ zzbt c;

    public C3938t70(zzbt zzbtVar, int i, int i2) {
        Objects.requireNonNull(zzbtVar);
        this.c = zzbtVar;
        this.a = i;
        this.b = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzbg.zza(i, this.b, "index");
        return this.c.get(i + this.a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbt, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzbq
    public final int zzb() {
        return this.c.zzc() + this.a + this.b;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbq
    public final int zzc() {
        return this.c.zzc() + this.a;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbq
    public final boolean zzf() {
        return true;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbq
    public final Object[] zzg() {
        return this.c.zzg();
    }

    @Override // com.google.android.gms.internal.play_billing.zzbt
    /* JADX INFO: renamed from: zzh */
    public final zzbt subList(int i, int i2) {
        zzbg.zzd(i, i2, this.b);
        int i3 = this.a;
        return this.c.subList(i + i3, i2 + i3);
    }
}
