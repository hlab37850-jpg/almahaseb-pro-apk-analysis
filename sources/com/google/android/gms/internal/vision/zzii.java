package com.google.android.gms.internal.vision;

import defpackage.Ig0;
import defpackage.InterfaceC3167jg0;
import defpackage.Lg0;
import defpackage.Og0;
import defpackage.Zd0;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzii extends zzhq {
    private static final Logger zzb = Logger.getLogger(zzii.class.getName());
    private static final boolean zzc = Ig0.m();
    v zza;

    public static class a extends zzii {
        public final byte[] a;
        public final int b;
        public final int c;
        public int d;

        public a(byte[] bArr, int i, int i2) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            if (((bArr.length - i2) | i2) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i2)));
            }
            this.a = bArr;
            this.b = 0;
            this.d = 0;
            this.c = i2;
        }

        public final void a(byte[] bArr, int i, int i2) throws zzb {
            try {
                System.arraycopy(bArr, i, this.a, this.d, i2);
                this.d += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.d), Integer.valueOf(this.c), Integer.valueOf(i2)), e);
            }
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void zza(int i, int i2) {
            zzb((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void zzb(int i, int i2) {
            zza(i, 0);
            zza(i2);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void zzc(int i, int i2) {
            zza(i, 0);
            zzb(i2);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void zzd(int i) throws zzb {
            try {
                byte[] bArr = this.a;
                int i2 = this.d;
                int i3 = i2 + 1;
                this.d = i3;
                bArr[i2] = (byte) i;
                int i4 = i2 + 2;
                this.d = i4;
                bArr[i3] = (byte) (i >> 8);
                int i5 = i2 + 3;
                this.d = i5;
                bArr[i4] = (byte) (i >> 16);
                this.d = i2 + 4;
                bArr[i5] = (byte) (i >>> 24);
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.d), Integer.valueOf(this.c), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void zze(int i, int i2) {
            zza(i, 5);
            zzd(i2);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void zza(int i, long j) {
            zza(i, 0);
            zza(j);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void zzb(byte[] bArr, int i, int i2) throws zzb {
            zzb(i2);
            a(bArr, 0, i2);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void zzc(int i, long j) {
            zza(i, 1);
            zzc(j);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void zza(int i, boolean z) {
            zza(i, 0);
            zza(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void zzb(int i, zzht zzhtVar) {
            zza(1, 3);
            zzc(2, i);
            zza(3, zzhtVar);
            zza(1, 4);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void zzc(long j) throws zzb {
            try {
                byte[] bArr = this.a;
                int i = this.d;
                int i2 = i + 1;
                this.d = i2;
                bArr[i] = (byte) j;
                int i3 = i + 2;
                this.d = i3;
                bArr[i2] = (byte) (j >> 8);
                int i4 = i + 3;
                this.d = i4;
                bArr[i3] = (byte) (j >> 16);
                int i5 = i + 4;
                this.d = i5;
                bArr[i4] = (byte) (j >> 24);
                int i6 = i + 5;
                this.d = i6;
                bArr[i5] = (byte) (j >> 32);
                int i7 = i + 6;
                this.d = i7;
                bArr[i6] = (byte) (j >> 40);
                int i8 = i + 7;
                this.d = i8;
                bArr[i7] = (byte) (j >> 48);
                this.d = i + 8;
                bArr[i8] = (byte) (j >> 56);
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.d), Integer.valueOf(this.c), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void zza(int i, String str) {
            zza(i, 2);
            zza(str);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void zza(int i, zzht zzhtVar) {
            zza(i, 2);
            zza(zzhtVar);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void zzb(int i) throws zzb {
            if (!zzii.zzc || Zd0.b() || zza() < 5) {
                while ((i & (-128)) != 0) {
                    try {
                        byte[] bArr = this.a;
                        int i2 = this.d;
                        this.d = i2 + 1;
                        bArr[i2] = (byte) ((i & ShapeTypes.VERTICAL_SCROLL) | 128);
                        i >>>= 7;
                    } catch (IndexOutOfBoundsException e) {
                        throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.d), Integer.valueOf(this.c), 1), e);
                    }
                }
                byte[] bArr2 = this.a;
                int i3 = this.d;
                this.d = i3 + 1;
                bArr2[i3] = (byte) i;
                return;
            }
            if ((i & (-128)) == 0) {
                byte[] bArr3 = this.a;
                int i4 = this.d;
                this.d = 1 + i4;
                Ig0.l(bArr3, i4, (byte) i);
                return;
            }
            byte[] bArr4 = this.a;
            int i5 = this.d;
            this.d = i5 + 1;
            Ig0.l(bArr4, i5, (byte) (i | 128));
            int i6 = i >>> 7;
            if ((i6 & (-128)) == 0) {
                byte[] bArr5 = this.a;
                int i7 = this.d;
                this.d = 1 + i7;
                Ig0.l(bArr5, i7, (byte) i6);
                return;
            }
            byte[] bArr6 = this.a;
            int i8 = this.d;
            this.d = i8 + 1;
            Ig0.l(bArr6, i8, (byte) (i6 | 128));
            int i9 = i >>> 14;
            if ((i9 & (-128)) == 0) {
                byte[] bArr7 = this.a;
                int i10 = this.d;
                this.d = 1 + i10;
                Ig0.l(bArr7, i10, (byte) i9);
                return;
            }
            byte[] bArr8 = this.a;
            int i11 = this.d;
            this.d = i11 + 1;
            Ig0.l(bArr8, i11, (byte) (i9 | 128));
            int i12 = i >>> 21;
            if ((i12 & (-128)) == 0) {
                byte[] bArr9 = this.a;
                int i13 = this.d;
                this.d = 1 + i13;
                Ig0.l(bArr9, i13, (byte) i12);
                return;
            }
            byte[] bArr10 = this.a;
            int i14 = this.d;
            this.d = i14 + 1;
            Ig0.l(bArr10, i14, (byte) (i12 | 128));
            byte[] bArr11 = this.a;
            int i15 = this.d;
            this.d = 1 + i15;
            Ig0.l(bArr11, i15, (byte) (i >>> 28));
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void zza(zzht zzhtVar) {
            zzb(zzhtVar.zza());
            zzhtVar.zza(this);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void zza(int i, zzkk zzkkVar, InterfaceC3167jg0 interfaceC3167jg0) {
            zza(i, 2);
            zzhf zzhfVar = (zzhf) zzkkVar;
            int iZzi = zzhfVar.zzi();
            if (iZzi == -1) {
                iZzi = interfaceC3167jg0.zzb(zzhfVar);
                zzhfVar.zzb(iZzi);
            }
            zzb(iZzi);
            interfaceC3167jg0.g(zzkkVar, this.zza);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void zza(int i, zzkk zzkkVar) {
            zza(1, 3);
            zzc(2, i);
            zza(3, 2);
            zza(zzkkVar);
            zza(1, 4);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void zza(zzkk zzkkVar) {
            zzb(zzkkVar.zzm());
            zzkkVar.zza(this);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void zza(byte b) throws zzb {
            try {
                byte[] bArr = this.a;
                int i = this.d;
                this.d = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.d), Integer.valueOf(this.c), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void zza(int i) {
            if (i >= 0) {
                zzb(i);
            } else {
                zza(i);
            }
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void zza(long j) throws zzb {
            if (zzii.zzc && zza() >= 10) {
                while ((j & (-128)) != 0) {
                    byte[] bArr = this.a;
                    int i = this.d;
                    this.d = i + 1;
                    Ig0.l(bArr, i, (byte) ((((int) j) & ShapeTypes.VERTICAL_SCROLL) | 128));
                    j >>>= 7;
                }
                byte[] bArr2 = this.a;
                int i2 = this.d;
                this.d = 1 + i2;
                Ig0.l(bArr2, i2, (byte) j);
                return;
            }
            while ((j & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.a;
                    int i3 = this.d;
                    this.d = i3 + 1;
                    bArr3[i3] = (byte) ((((int) j) & ShapeTypes.VERTICAL_SCROLL) | 128);
                    j >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.d), Integer.valueOf(this.c), 1), e);
                }
            }
            byte[] bArr4 = this.a;
            int i4 = this.d;
            this.d = i4 + 1;
            bArr4[i4] = (byte) j;
        }

        @Override // com.google.android.gms.internal.vision.zzhq
        public final void zza(byte[] bArr, int i, int i2) throws zzb {
            a(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void zza(String str) throws zzb {
            int i = this.d;
            try {
                int iZzg = zzii.zzg(str.length() * 3);
                int iZzg2 = zzii.zzg(str.length());
                if (iZzg2 == iZzg) {
                    int i2 = i + iZzg2;
                    this.d = i2;
                    int iE = Lg0.e(str, this.a, i2, zza());
                    this.d = i;
                    zzb((iE - i) - iZzg2);
                    this.d = iE;
                    return;
                }
                zzb(Lg0.d(str));
                this.d = Lg0.e(str, this.a, this.d, zza());
            } catch (Og0 e) {
                this.d = i;
                zza(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzb(e2);
            }
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final int zza() {
            return this.c - this.d;
        }
    }

    public static class zzb extends IOException {
        public zzb() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        public zzb(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public zzb(String str, Throwable th) {
            String strValueOf = String.valueOf(str);
            super(strValueOf.length() != 0 ? "CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(strValueOf) : new String("CodedOutputStream was writing to a flat byte array and ran out of space.: "), th);
        }
    }

    private zzii() {
    }

    public static zzii zza(byte[] bArr) {
        return new a(bArr, 0, bArr.length);
    }

    public static int zzb(double d) {
        return 8;
    }

    public static int zze(long j) {
        int i;
        if (((-128) & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if (((-34359738368L) & j) != 0) {
            j >>>= 28;
            i = 6;
        } else {
            i = 2;
        }
        if (((-2097152) & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & (-16384)) != 0 ? i + 1 : i;
    }

    public static int zzf(int i, int i2) {
        return zzg(i << 3) + zzf(i2);
    }

    public static int zzg(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int zzh(long j) {
        return 8;
    }

    public static int zzi(int i) {
        return 4;
    }

    public static int zzj(int i) {
        return 4;
    }

    public static int zzk(int i, int i2) {
        return zzg(i << 3) + zzf(i2);
    }

    @Deprecated
    public static int zzl(int i) {
        return zzg(i);
    }

    private static int zzm(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public abstract int zza();

    public abstract void zza(byte b);

    public abstract void zza(int i);

    public abstract void zza(int i, int i2);

    public abstract void zza(int i, long j);

    public abstract void zza(int i, zzht zzhtVar);

    public abstract void zza(int i, zzkk zzkkVar);

    public abstract void zza(int i, zzkk zzkkVar, InterfaceC3167jg0 interfaceC3167jg0);

    public abstract void zza(int i, String str);

    public abstract void zza(int i, boolean z);

    public abstract void zza(long j);

    public abstract void zza(zzht zzhtVar);

    public abstract void zza(zzkk zzkkVar);

    public abstract void zza(String str);

    public abstract void zzb(int i);

    public abstract void zzb(int i, int i2);

    public abstract void zzb(int i, zzht zzhtVar);

    public abstract void zzb(byte[] bArr, int i, int i2);

    public final void zzc(int i) {
        zzb(zzm(i));
    }

    public abstract void zzc(int i, int i2);

    public abstract void zzc(int i, long j);

    public abstract void zzc(long j);

    public abstract void zzd(int i);

    public final void zzd(int i, int i2) {
        zzc(i, zzm(i2));
    }

    public abstract void zze(int i, int i2);

    public static int zzb(float f) {
        return 4;
    }

    public static int zzc(int i, zzht zzhtVar) {
        int iZzg = zzg(i << 3);
        int iZza = zzhtVar.zza();
        return iZzg + zzg(iZza) + iZza;
    }

    public static int zzd(int i, long j) {
        return zzg(i << 3) + zze(j);
    }

    public static int zze(int i, long j) {
        return zzg(i << 3) + zze(j);
    }

    public static int zzg(long j) {
        return 8;
    }

    public static int zzh(int i, int i2) {
        return zzg(i << 3) + zzg(zzm(i2));
    }

    private static long zzi(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int zzj(int i, int i2) {
        return zzg(i << 3) + 4;
    }

    public static int zzb(boolean z) {
        return 1;
    }

    public static int zzf(int i, long j) {
        return zzg(i << 3) + zze(zzi(j));
    }

    public static int zzg(int i, int i2) {
        return zzg(i << 3) + zzg(i2);
    }

    public static int zzi(int i, int i2) {
        return zzg(i << 3) + 4;
    }

    public static int zzk(int i) {
        return zzf(i);
    }

    public final void zza(int i, float f) {
        zze(i, Float.floatToRawIntBits(f));
    }

    public static int zzd(int i, zzht zzhtVar) {
        return (zzg(8) << 1) + zzg(2, i) + zzc(3, zzhtVar);
    }

    public static int zze(int i) {
        return zzg(i << 3);
    }

    public static int zzh(int i, long j) {
        return zzg(i << 3) + 8;
    }

    public final void zza(int i, double d) {
        zzc(i, Double.doubleToRawLongBits(d));
    }

    public final void zzb(int i, long j) {
        zza(i, zzi(j));
    }

    @Deprecated
    public static int zzc(int i, zzkk zzkkVar, InterfaceC3167jg0 interfaceC3167jg0) {
        int iZzg = zzg(i << 3) << 1;
        zzhf zzhfVar = (zzhf) zzkkVar;
        int iZzi = zzhfVar.zzi();
        if (iZzi == -1) {
            iZzi = interfaceC3167jg0.zzb(zzhfVar);
            zzhfVar.zzb(iZzi);
        }
        return iZzg + iZzi;
    }

    public static int zzf(int i) {
        if (i >= 0) {
            return zzg(i);
        }
        return 10;
    }

    public static int zzg(int i, long j) {
        return zzg(i << 3) + 8;
    }

    public static int zzh(int i) {
        return zzg(zzm(i));
    }

    public final void zza(float f) {
        zzd(Float.floatToRawIntBits(f));
    }

    public final void zzb(long j) {
        zza(zzi(j));
    }

    public static int zzb(int i, float f) {
        return zzg(i << 3) + 4;
    }

    public static int zzf(long j) {
        return zze(zzi(j));
    }

    public final void zza(double d) {
        zzc(Double.doubleToRawLongBits(d));
    }

    public static int zzb(int i, double d) {
        return zzg(i << 3) + 8;
    }

    public static int zzd(long j) {
        return zze(j);
    }

    public final void zza(boolean z) {
        zza(z ? (byte) 1 : (byte) 0);
    }

    public static int zza(int i, zzjt zzjtVar) {
        int iZzg = zzg(i << 3);
        int iZzb = zzjtVar.zzb();
        return iZzg + zzg(iZzb) + iZzb;
    }

    public static int zzb(int i, boolean z) {
        return zzg(i << 3) + 1;
    }

    public static int zzb(int i, String str) {
        return zzg(i << 3) + zzb(str);
    }

    @Deprecated
    public static int zzc(zzkk zzkkVar) {
        return zzkkVar.zzm();
    }

    public static int zza(zzjt zzjtVar) {
        int iZzb = zzjtVar.zzb();
        return zzg(iZzb) + iZzb;
    }

    public static int zzb(int i, zzkk zzkkVar, InterfaceC3167jg0 interfaceC3167jg0) {
        return zzg(i << 3) + zza(zzkkVar, interfaceC3167jg0);
    }

    public static int zza(zzkk zzkkVar, InterfaceC3167jg0 interfaceC3167jg0) {
        zzhf zzhfVar = (zzhf) zzkkVar;
        int iZzi = zzhfVar.zzi();
        if (iZzi == -1) {
            iZzi = interfaceC3167jg0.zzb(zzhfVar);
            zzhfVar.zzb(iZzi);
        }
        return zzg(iZzi) + iZzi;
    }

    public static int zzb(int i, zzkk zzkkVar) {
        return (zzg(8) << 1) + zzg(2, i) + zzg(24) + zzb(zzkkVar);
    }

    public static int zzb(int i, zzjt zzjtVar) {
        return (zzg(8) << 1) + zzg(2, i) + zza(3, zzjtVar);
    }

    public final void zza(String str, Og0 og0) throws zzb {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) og0);
        byte[] bytes = str.getBytes(zzjf.zza);
        try {
            zzb(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (zzb e) {
            throw e;
        } catch (IndexOutOfBoundsException e2) {
            throw new zzb(e2);
        }
    }

    public static int zzb(String str) {
        int length;
        try {
            length = Lg0.d(str);
        } catch (Og0 unused) {
            length = str.getBytes(zzjf.zza).length;
        }
        return zzg(length) + length;
    }

    public static int zzb(zzht zzhtVar) {
        int iZza = zzhtVar.zza();
        return zzg(iZza) + iZza;
    }

    public static int zzb(byte[] bArr) {
        int length = bArr.length;
        return zzg(length) + length;
    }

    public static int zzb(zzkk zzkkVar) {
        int iZzm = zzkkVar.zzm();
        return zzg(iZzm) + iZzm;
    }

    public final void zzb() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }
}
