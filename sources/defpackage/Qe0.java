package defpackage;

import com.google.android.gms.internal.vision.zzhq;
import com.google.android.gms.internal.vision.zzht;
import com.google.android.gms.internal.vision.zzjf;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public class Qe0 extends Ne0 {
    public final byte[] a;

    public Qe0(byte[] bArr) {
        bArr.getClass();
        this.a = bArr;
    }

    @Override // defpackage.Ne0
    public final boolean a(zzht zzhtVar, int i, int i2) {
        if (i2 > zzhtVar.zza()) {
            int iZza = zza();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(iZza);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i2 > zzhtVar.zza()) {
            int iZza2 = zzhtVar.zza();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(iZza2);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (!(zzhtVar instanceof Qe0)) {
            return zzhtVar.zza(0, i2).equals(zza(0, i2));
        }
        Qe0 qe0 = (Qe0) zzhtVar;
        byte[] bArr = this.a;
        byte[] bArr2 = qe0.a;
        int iB = b() + i2;
        int iB2 = b();
        int iB3 = qe0.b();
        while (iB2 < iB) {
            if (bArr[iB2] != bArr2[iB3]) {
                return false;
            }
            iB2++;
            iB3++;
        }
        return true;
    }

    public int b() {
        return 0;
    }

    @Override // com.google.android.gms.internal.vision.zzht
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzht) || zza() != ((zzht) obj).zza()) {
            return false;
        }
        if (zza() == 0) {
            return true;
        }
        if (!(obj instanceof Qe0)) {
            return obj.equals(this);
        }
        Qe0 qe0 = (Qe0) obj;
        int iZzd = zzd();
        int iZzd2 = qe0.zzd();
        if (iZzd == 0 || iZzd2 == 0 || iZzd == iZzd2) {
            return a(qe0, 0, zza());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.vision.zzht
    public byte zza(int i) {
        return this.a[i];
    }

    @Override // com.google.android.gms.internal.vision.zzht
    public byte zzb(int i) {
        return this.a[i];
    }

    @Override // com.google.android.gms.internal.vision.zzht
    public final boolean zzc() {
        int iB = b();
        return Lg0.g(this.a, iB, zza() + iB);
    }

    @Override // com.google.android.gms.internal.vision.zzht
    public int zza() {
        return this.a.length;
    }

    @Override // com.google.android.gms.internal.vision.zzht
    public final zzht zza(int i, int i2) {
        int iZzb = zzht.zzb(0, i2, zza());
        if (iZzb == 0) {
            return zzht.zza;
        }
        return new C4383ye0(this.a, b(), iZzb);
    }

    @Override // com.google.android.gms.internal.vision.zzht
    public void zza(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.a, 0, bArr, 0, i3);
    }

    @Override // com.google.android.gms.internal.vision.zzht
    public final void zza(zzhq zzhqVar) {
        zzhqVar.zza(this.a, b(), zza());
    }

    @Override // com.google.android.gms.internal.vision.zzht
    public final String zza(Charset charset) {
        return new String(this.a, b(), zza(), charset);
    }

    @Override // com.google.android.gms.internal.vision.zzht
    public final int zza(int i, int i2, int i3) {
        return zzjf.zza(i, this.a, b(), i3);
    }
}
