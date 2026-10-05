package defpackage;

import com.google.android.gms.internal.auth.zzee;

/* JADX INFO: renamed from: ta0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3970ta0 extends Ja0 {
    public final int b;

    public C3970ta0(byte[] bArr, int i, int i2) {
        super(bArr);
        zzee.zzi(0, i2, bArr.length);
        this.b = i2;
    }

    @Override // defpackage.Ja0
    public final int a() {
        return 0;
    }

    @Override // defpackage.Ja0, com.google.android.gms.internal.auth.zzee
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

    @Override // defpackage.Ja0, com.google.android.gms.internal.auth.zzee
    public final byte zzb(int i) {
        return this.a[i];
    }

    @Override // defpackage.Ja0, com.google.android.gms.internal.auth.zzee
    public final int zzd() {
        return this.b;
    }
}
