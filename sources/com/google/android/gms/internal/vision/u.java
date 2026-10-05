package com.google.android.gms.internal.vision;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import defpackage.Lg0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class u extends zzif {
    public final byte[] a;
    public final boolean b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;

    public u(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.h = Integer.MAX_VALUE;
        this.a = bArr;
        this.c = i2 + i;
        this.e = i;
        this.f = i;
        this.b = z;
    }

    public final byte a() throws zzjk {
        int i = this.e;
        if (i == this.c) {
            throw zzjk.zza();
        }
        byte[] bArr = this.a;
        this.e = i + 1;
        return bArr[i];
    }

    public final void b(int i) throws zzjk {
        if (i >= 0) {
            int i2 = this.c;
            int i3 = this.e;
            if (i <= i2 - i3) {
                this.e = i3 + i;
                return;
            }
        }
        if (i >= 0) {
            throw zzjk.zza();
        }
        throw zzjk.zzb();
    }

    public final int c() {
        int i;
        int i2 = this.e;
        int i3 = this.c;
        if (i3 != i2) {
            byte[] bArr = this.a;
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.e = i4;
                return b;
            }
            if (i3 - i4 >= 9) {
                int i5 = i2 + 2;
                int i6 = (bArr[i4] << 7) ^ b;
                if (i6 < 0) {
                    i = i6 ^ (-128);
                } else {
                    int i7 = i2 + 3;
                    int i8 = (bArr[i5] << 14) ^ i6;
                    if (i8 >= 0) {
                        i = i8 ^ 16256;
                    } else {
                        int i9 = i2 + 4;
                        int i10 = i8 ^ (bArr[i7] << 21);
                        if (i10 < 0) {
                            i = (-2080896) ^ i10;
                        } else {
                            i7 = i2 + 5;
                            byte b2 = bArr[i9];
                            int i11 = (i10 ^ (b2 << Ascii.FS)) ^ 266354560;
                            if (b2 < 0) {
                                i9 = i2 + 6;
                                if (bArr[i7] < 0) {
                                    i7 = i2 + 7;
                                    if (bArr[i9] < 0) {
                                        i9 = i2 + 8;
                                        if (bArr[i7] < 0) {
                                            i7 = i2 + 9;
                                            if (bArr[i9] < 0) {
                                                int i12 = i2 + 10;
                                                if (bArr[i7] >= 0) {
                                                    i5 = i12;
                                                    i = i11;
                                                }
                                            }
                                        }
                                    }
                                }
                                i = i11;
                            }
                            i = i11;
                        }
                        i5 = i9;
                    }
                    i5 = i7;
                }
                this.e = i5;
                return i;
            }
        }
        return (int) zzs();
    }

    public final long d() {
        long j;
        long j2;
        long j3;
        int i = this.e;
        int i2 = this.c;
        if (i2 != i) {
            byte[] bArr = this.a;
            int i3 = i + 1;
            byte b = bArr[i];
            if (b >= 0) {
                this.e = i3;
                return b;
            }
            if (i2 - i3 >= 9) {
                int i4 = i + 2;
                int i5 = (bArr[i3] << 7) ^ b;
                if (i5 < 0) {
                    j = i5 ^ (-128);
                } else {
                    int i6 = i + 3;
                    int i7 = (bArr[i4] << 14) ^ i5;
                    if (i7 >= 0) {
                        j = i7 ^ 16256;
                        i4 = i6;
                    } else {
                        int i8 = i + 4;
                        int i9 = i7 ^ (bArr[i6] << 21);
                        if (i9 < 0) {
                            long j4 = (-2080896) ^ i9;
                            i4 = i8;
                            j = j4;
                        } else {
                            long j5 = i9;
                            i4 = i + 5;
                            long j6 = j5 ^ (((long) bArr[i8]) << 28);
                            if (j6 >= 0) {
                                j3 = 266354560;
                            } else {
                                int i10 = i + 6;
                                long j7 = j6 ^ (((long) bArr[i4]) << 35);
                                if (j7 < 0) {
                                    j2 = -34093383808L;
                                } else {
                                    i4 = i + 7;
                                    j6 = j7 ^ (((long) bArr[i10]) << 42);
                                    if (j6 >= 0) {
                                        j3 = 4363953127296L;
                                    } else {
                                        i10 = i + 8;
                                        j7 = j6 ^ (((long) bArr[i4]) << 49);
                                        if (j7 < 0) {
                                            j2 = -558586000294016L;
                                        } else {
                                            i4 = i + 9;
                                            long j8 = (j7 ^ (((long) bArr[i10]) << 56)) ^ 71499008037633920L;
                                            if (j8 < 0) {
                                                int i11 = i + 10;
                                                if (bArr[i4] >= 0) {
                                                    i4 = i11;
                                                }
                                            }
                                            j = j8;
                                        }
                                    }
                                }
                                j = j7 ^ j2;
                                i4 = i10;
                            }
                            j = j6 ^ j3;
                        }
                    }
                }
                this.e = i4;
                return j;
            }
        }
        return zzs();
    }

    public final int e() throws zzjk {
        int i = this.e;
        if (this.c - i < 4) {
            throw zzjk.zza();
        }
        byte[] bArr = this.a;
        this.e = i + 4;
        return ((bArr[i + 3] & UnsignedBytes.MAX_VALUE) << 24) | (bArr[i] & UnsignedBytes.MAX_VALUE) | ((bArr[i + 1] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr[i + 2] & UnsignedBytes.MAX_VALUE) << 16);
    }

    public final long f() throws zzjk {
        int i = this.e;
        if (this.c - i < 8) {
            throw zzjk.zza();
        }
        byte[] bArr = this.a;
        this.e = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    public final void g() {
        int i = this.c + this.d;
        this.c = i;
        int i2 = i - this.f;
        int i3 = this.h;
        if (i2 <= i3) {
            this.d = 0;
            return;
        }
        int i4 = i2 - i3;
        this.d = i4;
        this.c = i - i4;
    }

    @Override // com.google.android.gms.internal.vision.zzif
    public final int zza() throws zzjk {
        if (zzt()) {
            this.g = 0;
            return 0;
        }
        int iC = c();
        this.g = iC;
        if ((iC >>> 3) != 0) {
            return iC;
        }
        throw zzjk.zzd();
    }

    @Override // com.google.android.gms.internal.vision.zzif
    public final boolean zzb(int i) throws zzjk {
        int iZza;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.c - this.e < 10) {
                while (i3 < 10) {
                    if (a() < 0) {
                        i3++;
                    }
                }
                throw zzjk.zzc();
            }
            while (i3 < 10) {
                byte[] bArr = this.a;
                int i4 = this.e;
                this.e = i4 + 1;
                if (bArr[i4] < 0) {
                    i3++;
                }
            }
            throw zzjk.zzc();
            return true;
        }
        if (i2 == 1) {
            b(8);
            return true;
        }
        if (i2 == 2) {
            b(c());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 != 5) {
                throw zzjk.zzf();
            }
            b(4);
            return true;
        }
        do {
            iZza = zza();
            if (iZza == 0) {
                break;
            }
        } while (zzb(iZza));
        zza(((i >>> 3) << 3) | 4);
        return true;
    }

    @Override // com.google.android.gms.internal.vision.zzif
    public final float zzc() {
        return Float.intBitsToFloat(e());
    }

    @Override // com.google.android.gms.internal.vision.zzif
    public final long zzd() {
        return d();
    }

    @Override // com.google.android.gms.internal.vision.zzif
    public final long zze() {
        return d();
    }

    @Override // com.google.android.gms.internal.vision.zzif
    public final int zzf() {
        return c();
    }

    @Override // com.google.android.gms.internal.vision.zzif
    public final long zzg() {
        return f();
    }

    @Override // com.google.android.gms.internal.vision.zzif
    public final int zzh() {
        return e();
    }

    @Override // com.google.android.gms.internal.vision.zzif
    public final boolean zzi() {
        return d() != 0;
    }

    @Override // com.google.android.gms.internal.vision.zzif
    public final String zzj() throws zzjk {
        int iC = c();
        if (iC > 0) {
            int i = this.c;
            int i2 = this.e;
            if (iC <= i - i2) {
                String str = new String(this.a, i2, iC, zzjf.zza);
                this.e += iC;
                return str;
            }
        }
        if (iC == 0) {
            return "";
        }
        if (iC < 0) {
            throw zzjk.zzb();
        }
        throw zzjk.zza();
    }

    @Override // com.google.android.gms.internal.vision.zzif
    public final String zzk() throws zzjk {
        int iC = c();
        if (iC > 0) {
            int i = this.c;
            int i2 = this.e;
            if (iC <= i - i2) {
                String strK = Lg0.k(this.a, i2, iC);
                this.e += iC;
                return strK;
            }
        }
        if (iC == 0) {
            return "";
        }
        if (iC <= 0) {
            throw zzjk.zzb();
        }
        throw zzjk.zza();
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0031 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:16:0x0033 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x0035  */
    /* JADX WARN: Code duplicated, block: B:20:0x003c  */
    /* JADX WARN: Code duplicated, block: B:22:0x0041  */
    @Override // com.google.android.gms.internal.vision.zzif
    public final zzht zzl() throws zzjk {
        byte[] bArrCopyOfRange;
        int iC = c();
        if (iC > 0) {
            int i = this.c;
            int i2 = this.e;
            if (iC <= i - i2) {
                zzht zzhtVarZza = zzht.zza(this.a, i2, iC);
                this.e += iC;
                return zzhtVarZza;
            }
        }
        if (iC == 0) {
            return zzht.zza;
        }
        if (iC > 0) {
            int i3 = this.c;
            int i4 = this.e;
            if (iC <= i3 - i4) {
                int i5 = iC + i4;
                this.e = i5;
                bArrCopyOfRange = Arrays.copyOfRange(this.a, i4, i5);
            } else {
                if (iC <= 0) {
                    throw zzjk.zza();
                }
                if (iC == 0) {
                    throw zzjk.zzb();
                }
                bArrCopyOfRange = zzjf.zzb;
            }
        } else {
            if (iC <= 0) {
                throw zzjk.zza();
            }
            if (iC == 0) {
                throw zzjk.zzb();
            }
            bArrCopyOfRange = zzjf.zzb;
        }
        return zzht.zza(bArrCopyOfRange);
    }

    @Override // com.google.android.gms.internal.vision.zzif
    public final int zzm() {
        return c();
    }

    @Override // com.google.android.gms.internal.vision.zzif
    public final int zzn() {
        return c();
    }

    @Override // com.google.android.gms.internal.vision.zzif
    public final int zzo() {
        return e();
    }

    @Override // com.google.android.gms.internal.vision.zzif
    public final long zzp() {
        return f();
    }

    @Override // com.google.android.gms.internal.vision.zzif
    public final int zzq() {
        return zzif.zze(c());
    }

    @Override // com.google.android.gms.internal.vision.zzif
    public final long zzr() {
        return zzif.zza(d());
    }

    @Override // com.google.android.gms.internal.vision.zzif
    public final long zzs() throws zzjk {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte bA = a();
            j |= ((long) (bA & Ascii.DEL)) << i;
            if ((bA & UnsignedBytes.MAX_POWER_OF_TWO) == 0) {
                return j;
            }
        }
        throw zzjk.zzc();
    }

    @Override // com.google.android.gms.internal.vision.zzif
    public final boolean zzt() {
        return this.e == this.c;
    }

    @Override // com.google.android.gms.internal.vision.zzif
    public final int zzu() {
        return this.e - this.f;
    }

    @Override // com.google.android.gms.internal.vision.zzif
    public final int zzc(int i) throws zzjk {
        if (i < 0) {
            throw zzjk.zzb();
        }
        int iZzu = i + zzu();
        int i2 = this.h;
        if (iZzu > i2) {
            throw zzjk.zza();
        }
        this.h = iZzu;
        g();
        return i2;
    }

    @Override // com.google.android.gms.internal.vision.zzif
    public final void zzd(int i) {
        this.h = i;
        g();
    }

    @Override // com.google.android.gms.internal.vision.zzif
    public final void zza(int i) throws zzjk {
        if (this.g != i) {
            throw zzjk.zze();
        }
    }

    @Override // com.google.android.gms.internal.vision.zzif
    public final double zzb() {
        return Double.longBitsToDouble(f());
    }
}
