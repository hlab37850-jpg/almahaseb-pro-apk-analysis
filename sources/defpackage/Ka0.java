package defpackage;

import com.google.android.gms.internal.play_billing.zzei;

/* JADX INFO: loaded from: classes2.dex */
public final class Ka0 extends Va0 {
    public final int b;

    public Ka0(byte[] bArr, int i, int i2) {
        super(bArr);
        zzei.zzh(0, i2, bArr.length);
        this.b = i2;
    }

    @Override // defpackage.Va0
    public final int a() {
        return 0;
    }

    @Override // defpackage.Va0, com.google.android.gms.internal.play_billing.zzei
    public final byte zza(int i) {
        int i2 = this.b;
        if (((i2 - (i + 1)) | i) >= 0) {
            return this.a[i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + i2);
    }

    @Override // defpackage.Va0, com.google.android.gms.internal.play_billing.zzei
    public final byte zzb(int i) {
        return this.a[i];
    }

    @Override // defpackage.Va0, com.google.android.gms.internal.play_billing.zzei
    public final int zzd() {
        return this.b;
    }
}
