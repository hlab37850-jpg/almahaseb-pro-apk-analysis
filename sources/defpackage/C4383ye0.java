package defpackage;

import com.google.android.gms.internal.vision.zzht;

/* JADX INFO: renamed from: ye0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C4383ye0 extends Qe0 {
    public final int b;
    public final int c;

    public C4383ye0(byte[] bArr, int i, int i2) {
        super(bArr);
        zzht.zzb(i, i + i2, bArr.length);
        this.b = i;
        this.c = i2;
    }

    @Override // defpackage.Qe0
    public final int b() {
        return this.b;
    }

    @Override // defpackage.Qe0, com.google.android.gms.internal.vision.zzht
    public final byte zza(int i) {
        int iZza = zza();
        if (((iZza - (i + 1)) | i) >= 0) {
            return this.a[this.b + i];
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(22);
            sb.append("Index < 0: ");
            sb.append(i);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Index > length: ");
        sb2.append(i);
        sb2.append(", ");
        sb2.append(iZza);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    @Override // defpackage.Qe0, com.google.android.gms.internal.vision.zzht
    public final byte zzb(int i) {
        return this.a[this.b + i];
    }

    @Override // defpackage.Qe0, com.google.android.gms.internal.vision.zzht
    public final int zza() {
        return this.c;
    }

    @Override // defpackage.Qe0, com.google.android.gms.internal.vision.zzht
    public final void zza(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.a, b(), bArr, 0, i3);
    }
}
