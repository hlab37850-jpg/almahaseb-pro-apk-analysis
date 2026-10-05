package defpackage;

import com.google.android.gms.internal.play_billing.q;
import com.google.android.gms.internal.play_billing.zzdz;
import com.google.android.gms.internal.play_billing.zzei;
import com.google.android.gms.internal.play_billing.zzfo;

/* JADX INFO: loaded from: classes2.dex */
public class Va0 extends Sa0 {
    public final byte[] a;

    public Va0(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.a = bArr;
    }

    public int a() {
        return 0;
    }

    @Override // com.google.android.gms.internal.play_billing.zzei
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzei) || zzd() != ((zzei) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof Va0)) {
            return obj.equals(this);
        }
        Va0 va0 = (Va0) obj;
        int iZzi = zzi();
        int iZzi2 = va0.zzi();
        if (iZzi != 0 && iZzi2 != 0 && iZzi != iZzi2) {
            return false;
        }
        int iZzd = zzd();
        if (iZzd > va0.zzd()) {
            throw new IllegalArgumentException("Length too large: " + iZzd + zzd());
        }
        if (iZzd > va0.zzd()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + iZzd + ", " + va0.zzd());
        }
        byte[] bArr = this.a;
        byte[] bArr2 = va0.a;
        va0.a();
        int i = 0;
        int i2 = 0;
        while (i < iZzd) {
            if (bArr[i] != bArr2[i2]) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.play_billing.zzei
    public byte zza(int i) {
        return this.a[i];
    }

    @Override // com.google.android.gms.internal.play_billing.zzei
    public byte zzb(int i) {
        return this.a[i];
    }

    @Override // com.google.android.gms.internal.play_billing.zzei
    public int zzd() {
        return this.a.length;
    }

    @Override // com.google.android.gms.internal.play_billing.zzei
    public final int zze(int i, int i2, int i3) {
        return zzfo.zzb(i, this.a, 0, i3);
    }

    @Override // com.google.android.gms.internal.play_billing.zzei
    public final zzei zzf(int i, int i2) {
        int iZzh = zzei.zzh(0, i2, zzd());
        return iZzh == 0 ? zzei.zzb : new Ka0(this.a, 0, iZzh);
    }

    @Override // com.google.android.gms.internal.play_billing.zzei
    public final void zzg(zzdz zzdzVar) {
        ((q) zzdzVar).a(this.a, 0, zzd());
    }
}
