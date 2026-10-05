package defpackage;

import com.google.android.gms.internal.vision.zzde;
import com.google.android.gms.internal.vision.zzee;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class Wa0 extends zzee {
    public final transient int a;
    public final transient int b;
    public final /* synthetic */ zzee c;

    public Wa0(zzee zzeeVar, int i, int i2) {
        this.c = zzeeVar;
        this.a = i;
        this.b = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzde.zza(i, this.b);
        return this.c.get(i + this.a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.vision.zzee, java.util.List
    public final /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    @Override // com.google.android.gms.internal.vision.zzee
    /* JADX INFO: renamed from: zza */
    public final zzee subList(int i, int i2) {
        zzde.zza(i, i2, this.b);
        zzee zzeeVar = this.c;
        int i3 = this.a;
        return (zzee) zzeeVar.subList(i + i3, i2 + i3);
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    public final Object[] zzb() {
        return this.c.zzb();
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    public final int zzc() {
        return this.c.zzc() + this.a;
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    public final int zzd() {
        return this.c.zzc() + this.a + this.b;
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    public final boolean zzf() {
        return true;
    }
}
