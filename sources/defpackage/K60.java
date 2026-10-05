package defpackage;

import com.google.android.gms.internal.clearcut.zzba;
import com.google.android.gms.internal.clearcut.zzbb;
import com.google.android.gms.internal.clearcut.zzci;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public class K60 extends J60 {
    public final byte[] a;

    public K60(byte[] bArr) {
        this.a = bArr;
    }

    @Override // defpackage.J60
    public final boolean a(zzbb zzbbVar, int i, int i2) {
        if (i2 > zzbbVar.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i2 > zzbbVar.size()) {
            int size2 = zzbbVar.size();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (!(zzbbVar instanceof K60)) {
            return zzbbVar.zza(0, i2).equals(zza(0, i2));
        }
        K60 k60 = (K60) zzbbVar;
        byte[] bArr = this.a;
        byte[] bArr2 = k60.a;
        int iB = b() + i2;
        int iB2 = b();
        int iB3 = k60.b();
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

    @Override // com.google.android.gms.internal.clearcut.zzbb
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbb) || size() != ((zzbb) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof K60)) {
            return obj.equals(this);
        }
        K60 k60 = (K60) obj;
        int iZzab = zzab();
        int iZzab2 = k60.zzab();
        if (iZzab == 0 || iZzab2 == 0 || iZzab == iZzab2) {
            return a(k60, 0, size());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.clearcut.zzbb
    public int size() {
        return this.a.length;
    }

    @Override // com.google.android.gms.internal.clearcut.zzbb
    public final int zza(int i, int i2, int i3) {
        return zzci.zza(i, this.a, b(), i3);
    }

    @Override // com.google.android.gms.internal.clearcut.zzbb
    public final boolean zzaa() {
        int iB = b();
        return Xb0.i(this.a, iB, size() + iB);
    }

    @Override // com.google.android.gms.internal.clearcut.zzbb
    public byte zzj(int i) {
        return this.a[i];
    }

    @Override // com.google.android.gms.internal.clearcut.zzbb
    public final zzbb zza(int i, int i2) {
        int iZzb = zzbb.zzb(0, i2, size());
        return iZzb == 0 ? zzbb.zzfi : new C4260x60(this.a, b(), iZzb);
    }

    @Override // com.google.android.gms.internal.clearcut.zzbb
    public final String zza(Charset charset) {
        return new String(this.a, b(), size(), charset);
    }

    @Override // com.google.android.gms.internal.clearcut.zzbb
    public final void zza(zzba zzbaVar) {
        zzbaVar.zza(this.a, b(), size());
    }
}
