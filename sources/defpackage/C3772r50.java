package defpackage;

import com.google.android.gms.internal.fido.zzam;
import com.google.android.gms.internal.fido.zzat;
import java.util.List;

/* JADX INFO: renamed from: r50, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3772r50 extends zzat {
    public final transient int a;
    public final transient int b;
    public final /* synthetic */ zzat c;

    public C3772r50(zzat zzatVar, int i, int i2) {
        this.c = zzatVar;
        this.a = i;
        this.b = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzam.zza(i, this.b, "index");
        return this.c.get(i + this.a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.fido.zzat, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    @Override // com.google.android.gms.internal.fido.zzaq
    public final int zzb() {
        return this.c.zzc() + this.a + this.b;
    }

    @Override // com.google.android.gms.internal.fido.zzaq
    public final int zzc() {
        return this.c.zzc() + this.a;
    }

    @Override // com.google.android.gms.internal.fido.zzaq
    public final Object[] zze() {
        return this.c.zze();
    }

    @Override // com.google.android.gms.internal.fido.zzat
    /* JADX INFO: renamed from: zzf */
    public final zzat subList(int i, int i2) {
        zzam.zze(i, i2, this.b);
        zzat zzatVar = this.c;
        int i3 = this.a;
        return zzatVar.subList(i + i3, i2 + i3);
    }
}
