package defpackage;

import com.google.android.gms.internal.auth.zzee;
import com.google.android.gms.internal.auth.zzez;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public class Ja0 extends Ga0 {
    public final byte[] a;

    public Ja0(byte[] bArr) {
        bArr.getClass();
        this.a = bArr;
    }

    public int a() {
        return 0;
    }

    @Override // com.google.android.gms.internal.auth.zzee
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzee) || zzd() != ((zzee) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof Ja0)) {
            return obj.equals(this);
        }
        Ja0 ja0 = (Ja0) obj;
        int iZzj = zzj();
        int iZzj2 = ja0.zzj();
        if (iZzj != 0 && iZzj2 != 0 && iZzj != iZzj2) {
            return false;
        }
        int iZzd = zzd();
        if (iZzd > ja0.zzd()) {
            throw new IllegalArgumentException("Length too large: " + iZzd + zzd());
        }
        if (iZzd > ja0.zzd()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + iZzd + ", " + ja0.zzd());
        }
        byte[] bArr = this.a;
        byte[] bArr2 = ja0.a;
        ja0.a();
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

    @Override // com.google.android.gms.internal.auth.zzee
    public byte zza(int i) {
        return this.a[i];
    }

    @Override // com.google.android.gms.internal.auth.zzee
    public byte zzb(int i) {
        return this.a[i];
    }

    @Override // com.google.android.gms.internal.auth.zzee
    public int zzd() {
        return this.a.length;
    }

    @Override // com.google.android.gms.internal.auth.zzee
    public final int zze(int i, int i2, int i3) {
        return zzez.zzd(i, this.a, 0, i3);
    }

    @Override // com.google.android.gms.internal.auth.zzee
    public final zzee zzf(int i, int i2) {
        int iZzi = zzee.zzi(0, i2, zzd());
        return iZzi == 0 ? zzee.zzb : new C3970ta0(this.a, 0, iZzi);
    }

    @Override // com.google.android.gms.internal.auth.zzee
    public final String zzg(Charset charset) {
        return new String(this.a, 0, zzd(), charset);
    }

    @Override // com.google.android.gms.internal.auth.zzee
    public final boolean zzh() {
        return AbstractC3245ke0.d(this.a, 0, zzd());
    }
}
