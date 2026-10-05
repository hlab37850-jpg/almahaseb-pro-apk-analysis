package com.google.android.gms.internal.play_billing;

import defpackage.AbstractC3491ne0;
import defpackage.AbstractC3978te0;
import defpackage.C3816re0;
import defpackage.InterfaceC3814rd0;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class q extends zzep {
    public final byte[] a;
    public final int b;
    public int c;

    public q(byte[] bArr, int i, int i2) {
        super(null);
        int length = bArr.length;
        if (((length - i2) | i2) < 0) {
            throw new IllegalArgumentException(String.format(Locale.US, "Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i2)));
        }
        this.a = bArr;
        this.c = 0;
        this.b = i2;
    }

    public final void a(byte[] bArr, int i, int i2) {
        try {
            System.arraycopy(bArr, 0, this.a, this.c, i2);
            this.c += i2;
        } catch (IndexOutOfBoundsException e) {
            throw new zzen(this.c, this.b, i2, e);
        }
    }

    public final void b(zzei zzeiVar) throws zzen {
        zzv(zzeiVar.zzd());
        zzeiVar.zzg(this);
    }

    public final void c(zzgl zzglVar) throws zzen {
        zzv(zzglVar.zzj());
        zzglVar.zzL(this);
    }

    public final void d(String str) throws zzen {
        int i = this.c;
        try {
            int iZzC = zzep.zzC(str.length() * 3);
            int iZzC2 = zzep.zzC(str.length());
            if (iZzC2 != iZzC) {
                zzv(AbstractC3978te0.c(str));
                byte[] bArr = this.a;
                int i2 = this.c;
                this.c = AbstractC3978te0.b(str, bArr, i2, this.b - i2);
                return;
            }
            int i3 = i + iZzC2;
            this.c = i3;
            int iB = AbstractC3978te0.b(str, this.a, i3, this.b - i3);
            this.c = i;
            zzv((iB - i) - iZzC2);
            this.c = iB;
        } catch (IndexOutOfBoundsException e) {
            throw new zzen(e);
        } catch (C3816re0 e2) {
            this.c = i;
            zzF(str, e2);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzep
    public final int zza() {
        return this.b - this.c;
    }

    @Override // com.google.android.gms.internal.play_billing.zzep
    public final void zzb(byte b) throws zzen {
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i = this.c;
        try {
            int i2 = i + 1;
            try {
                this.a[i] = b;
                this.c = i2;
            } catch (IndexOutOfBoundsException e) {
                indexOutOfBoundsException = e;
                i = i2;
                throw new zzen(i, this.b, 1, indexOutOfBoundsException);
            }
        } catch (IndexOutOfBoundsException e2) {
            indexOutOfBoundsException = e2;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzep
    public final void zzd(int i, boolean z) throws zzen {
        zzv(i << 3);
        zzb(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.play_billing.zzep
    public final void zze(int i, zzei zzeiVar) throws zzen {
        zzv((i << 3) | 2);
        b(zzeiVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzep
    public final void zzg(int i, int i2) throws zzen {
        zzv((i << 3) | 5);
        zzh(i2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzep
    public final void zzh(int i) throws zzen {
        int i2 = this.c;
        try {
            byte[] bArr = this.a;
            bArr[i2] = (byte) i;
            bArr[i2 + 1] = (byte) (i >> 8);
            bArr[i2 + 2] = (byte) (i >> 16);
            bArr[i2 + 3] = (byte) (i >> 24);
            this.c = i2 + 4;
        } catch (IndexOutOfBoundsException e) {
            throw new zzen(i2, this.b, 4, e);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzep
    public final void zzi(int i, long j) throws zzen {
        zzv((i << 3) | 1);
        zzj(j);
    }

    @Override // com.google.android.gms.internal.play_billing.zzep
    public final void zzj(long j) throws zzen {
        int i = this.c;
        try {
            byte[] bArr = this.a;
            bArr[i] = (byte) j;
            bArr[i + 1] = (byte) (j >> 8);
            bArr[i + 2] = (byte) (j >> 16);
            bArr[i + 3] = (byte) (j >> 24);
            bArr[i + 4] = (byte) (j >> 32);
            bArr[i + 5] = (byte) (j >> 40);
            bArr[i + 6] = (byte) (j >> 48);
            bArr[i + 7] = (byte) (j >> 56);
            this.c = i + 8;
        } catch (IndexOutOfBoundsException e) {
            throw new zzen(i, this.b, 8, e);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzep
    public final void zzk(int i, int i2) throws zzen {
        zzv(i << 3);
        zzl(i2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzep
    public final void zzl(int i) throws zzen {
        if (i >= 0) {
            zzv(i);
        } else {
            zzx(i);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzep
    public final void zzm(byte[] bArr, int i, int i2) {
        a(bArr, 0, i2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzep
    public final void zzn(int i, zzgl zzglVar, InterfaceC3814rd0 interfaceC3814rd0) throws zzen {
        zzv((i << 3) | 2);
        zzv(((zzds) zzglVar).zze(interfaceC3814rd0));
        interfaceC3814rd0.c(zzglVar, this.zza);
    }

    @Override // com.google.android.gms.internal.play_billing.zzep
    public final void zzp(int i, zzgl zzglVar) throws zzen {
        zzv(11);
        zzu(2, i);
        zzv(26);
        c(zzglVar);
        zzv(12);
    }

    @Override // com.google.android.gms.internal.play_billing.zzep
    public final void zzq(int i, zzei zzeiVar) throws zzen {
        zzv(11);
        zzu(2, i);
        zze(3, zzeiVar);
        zzv(12);
    }

    @Override // com.google.android.gms.internal.play_billing.zzep
    public final void zzr(int i, String str) throws zzen {
        zzv((i << 3) | 2);
        d(str);
    }

    @Override // com.google.android.gms.internal.play_billing.zzep
    public final void zzt(int i, int i2) throws zzen {
        zzv((i << 3) | i2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzep
    public final void zzu(int i, int i2) throws zzen {
        zzv(i << 3);
        zzv(i2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzep
    public final void zzv(int i) throws zzen {
        int i2;
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i3 = this.c;
        while ((i & (-128)) != 0) {
            try {
                i2 = i3 + 1;
                try {
                    this.a[i3] = (byte) (i | 128);
                    i >>>= 7;
                    i3 = i2;
                } catch (IndexOutOfBoundsException e) {
                    indexOutOfBoundsException = e;
                    i3 = i2;
                    throw new zzen(i3, this.b, 1, indexOutOfBoundsException);
                }
            } catch (IndexOutOfBoundsException e2) {
                indexOutOfBoundsException = e2;
                throw new zzen(i3, this.b, 1, indexOutOfBoundsException);
            }
        }
        i2 = i3 + 1;
        this.a[i3] = (byte) i;
        this.c = i2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzep
    public final void zzw(int i, long j) throws zzen {
        zzv(i << 3);
        zzx(j);
    }

    @Override // com.google.android.gms.internal.play_billing.zzep
    public final void zzx(long j) throws zzen {
        int i;
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i2 = this.c;
        if (!zzep.zzd || this.b - i2 < 10) {
            while ((j & (-128)) != 0) {
                try {
                    int i3 = i2 + 1;
                    try {
                        this.a[i2] = (byte) (((int) j) | 128);
                        j >>>= 7;
                        i2 = i3;
                    } catch (IndexOutOfBoundsException e) {
                        e = e;
                        i2 = i3;
                        indexOutOfBoundsException = e;
                        throw new zzen(i2, this.b, 1, indexOutOfBoundsException);
                    }
                } catch (IndexOutOfBoundsException e2) {
                    e = e2;
                }
            }
            i = i2 + 1;
            try {
                this.a[i2] = (byte) j;
            } catch (IndexOutOfBoundsException e3) {
                indexOutOfBoundsException = e3;
                i2 = i;
                throw new zzen(i2, this.b, 1, indexOutOfBoundsException);
            }
        } else {
            while ((j & (-128)) != 0) {
                AbstractC3491ne0.s(this.a, i2, (byte) (((int) j) | 128));
                j >>>= 7;
                i2++;
            }
            i = i2 + 1;
            AbstractC3491ne0.s(this.a, i2, (byte) j);
        }
        this.c = i;
    }
}
