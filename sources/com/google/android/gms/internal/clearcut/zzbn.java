package com.google.android.gms.internal.clearcut;

import com.google.common.base.Ascii;
import defpackage.C2045dc0;
import defpackage.Sb0;
import defpackage.Ta0;
import defpackage.Xb0;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzbn extends zzba {
    private static final Logger logger = Logger.getLogger(zzbn.class.getName());
    private static final boolean zzfy = Sb0.x();
    C1913h zzfz;

    public static class a extends zzbn {
        public final byte[] a;
        public final int b;
        public final int c;
        public int d;

        public a(byte[] bArr, int i, int i2) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            int i3 = i + i2;
            if ((i | i2 | (bArr.length - i3)) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
            }
            this.a = bArr;
            this.b = i;
            this.d = i;
            this.c = i3;
        }

        public final int a() {
            return this.d - this.b;
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public void flush() {
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void write(byte[] bArr, int i, int i2) throws zzc {
            try {
                System.arraycopy(bArr, i, this.a, this.d, i2);
                this.d += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.d), Integer.valueOf(this.c), Integer.valueOf(i2)), e);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zza(byte b) throws zzc {
            try {
                byte[] bArr = this.a;
                int i = this.d;
                this.d = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.d), Integer.valueOf(this.c), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final int zzag() {
            return this.c - this.d;
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzb(int i, int i2) {
            zzo((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzc(int i, int i2) {
            zzb(i, 0);
            zzn(i2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzd(int i, int i2) {
            zzb(i, 0);
            zzo(i2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzf(int i, int i2) {
            zzb(i, 5);
            zzq(i2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzg(String str) throws zzc {
            int i = this.d;
            try {
                int iZzt = zzbn.zzt(str.length() * 3);
                int iZzt2 = zzbn.zzt(str.length());
                if (iZzt2 != iZzt) {
                    zzo(Xb0.a(str));
                    this.d = Xb0.b(str, this.a, this.d, zzag());
                    return;
                }
                int i2 = i + iZzt2;
                this.d = i2;
                int iB = Xb0.b(str, this.a, i2, zzag());
                this.d = i;
                zzo((iB - i) - iZzt2);
                this.d = iB;
            } catch (C2045dc0 e) {
                this.d = i;
                zza(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(e2);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzn(int i) {
            if (i >= 0) {
                zzo(i);
            } else {
                zzb(i);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzo(int i) throws zzc {
            if (zzbn.zzfy && zzag() >= 10) {
                while ((i & (-128)) != 0) {
                    byte[] bArr = this.a;
                    int i2 = this.d;
                    this.d = i2 + 1;
                    Sb0.k(bArr, i2, (byte) ((i & ShapeTypes.VERTICAL_SCROLL) | 128));
                    i >>>= 7;
                }
                byte[] bArr2 = this.a;
                int i3 = this.d;
                this.d = 1 + i3;
                Sb0.k(bArr2, i3, (byte) i);
                return;
            }
            while ((i & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.a;
                    int i4 = this.d;
                    this.d = i4 + 1;
                    bArr3[i4] = (byte) ((i & ShapeTypes.VERTICAL_SCROLL) | 128);
                    i >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.d), Integer.valueOf(this.c), 1), e);
                }
            }
            byte[] bArr4 = this.a;
            int i5 = this.d;
            this.d = i5 + 1;
            bArr4[i5] = (byte) i;
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzq(int i) throws zzc {
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
                bArr[i5] = i >> Ascii.CAN;
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.d), Integer.valueOf(this.c), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zza(int i, long j) {
            zzb(i, 0);
            zzb(j);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzb(int i, zzbb zzbbVar) {
            zzb(1, 3);
            zzd(2, i);
            zza(3, zzbbVar);
            zzb(1, 4);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzc(int i, long j) {
            zzb(i, 1);
            zzd(j);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzd(long j) throws zzc {
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
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.d), Integer.valueOf(this.c), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zza(int i, zzbb zzbbVar) {
            zzb(i, 2);
            zza(zzbbVar);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzb(int i, zzdo zzdoVar) {
            zzb(1, 3);
            zzd(2, i);
            zza(3, zzdoVar);
            zzb(1, 4);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzd(byte[] bArr, int i, int i2) {
            zzo(i2);
            write(bArr, 0, i2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zza(int i, zzdo zzdoVar) {
            zzb(i, 2);
            zzb(zzdoVar);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzb(int i, boolean z) {
            zzb(i, 0);
            zza(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zza(int i, zzdo zzdoVar, Ta0 ta0) {
            zzb(i, 2);
            zzas zzasVar = (zzas) zzdoVar;
            int iZzs = zzasVar.zzs();
            if (iZzs == -1) {
                iZzs = ta0.c(zzasVar);
                zzasVar.zzf(iZzs);
            }
            zzo(iZzs);
            ta0.d(zzdoVar, this.zzfz);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzb(long j) throws zzc {
            if (zzbn.zzfy && zzag() >= 10) {
                while ((j & (-128)) != 0) {
                    byte[] bArr = this.a;
                    int i = this.d;
                    this.d = i + 1;
                    Sb0.k(bArr, i, (byte) ((((int) j) & ShapeTypes.VERTICAL_SCROLL) | 128));
                    j >>>= 7;
                }
                byte[] bArr2 = this.a;
                int i2 = this.d;
                this.d = 1 + i2;
                Sb0.k(bArr2, i2, (byte) j);
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
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.d), Integer.valueOf(this.c), 1), e);
                }
            }
            byte[] bArr4 = this.a;
            int i4 = this.d;
            this.d = i4 + 1;
            bArr4[i4] = (byte) j;
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zza(int i, String str) {
            zzb(i, 2);
            zzg(str);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzb(zzdo zzdoVar) {
            zzo(zzdoVar.zzas());
            zzdoVar.zzb(this);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zza(zzbb zzbbVar) {
            zzo(zzbbVar.size());
            zzbbVar.zza(this);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zza(zzdo zzdoVar, Ta0 ta0) {
            zzas zzasVar = (zzas) zzdoVar;
            int iZzs = zzasVar.zzs();
            if (iZzs == -1) {
                iZzs = ta0.c(zzasVar);
                zzasVar.zzf(iZzs);
            }
            zzo(iZzs);
            ta0.d(zzdoVar, this.zzfz);
        }

        @Override // com.google.android.gms.internal.clearcut.zzba
        public final void zza(byte[] bArr, int i, int i2) {
            write(bArr, i, i2);
        }
    }

    public static final class b extends a {
        public final ByteBuffer e;
        public int f;

        public b(ByteBuffer byteBuffer) {
            super(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            this.e = byteBuffer;
            this.f = byteBuffer.position();
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn.a, com.google.android.gms.internal.clearcut.zzbn
        public final void flush() {
            this.e.position(this.f + a());
        }
    }

    public static final class c extends zzbn {
        public final ByteBuffer a;
        public final ByteBuffer b;
        public final int c;

        public c(ByteBuffer byteBuffer) {
            super();
            this.a = byteBuffer;
            this.b = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.c = byteBuffer.position();
        }

        public final void a(String str) throws zzc {
            try {
                Xb0.c(str, this.b);
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(e);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void flush() {
            this.a.position(this.b.position());
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void write(byte[] bArr, int i, int i2) throws zzc {
            try {
                this.b.put(bArr, i, i2);
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(e);
            } catch (BufferOverflowException e2) {
                throw new zzc(e2);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zza(byte b) throws zzc {
            try {
                this.b.put(b);
            } catch (BufferOverflowException e) {
                throw new zzc(e);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final int zzag() {
            return this.b.remaining();
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzb(int i, int i2) {
            zzo((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzc(int i, int i2) {
            zzb(i, 0);
            zzn(i2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzd(int i, int i2) {
            zzb(i, 0);
            zzo(i2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzf(int i, int i2) {
            zzb(i, 5);
            zzq(i2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzg(String str) throws zzc {
            int iPosition = this.b.position();
            try {
                int iZzt = zzbn.zzt(str.length() * 3);
                int iZzt2 = zzbn.zzt(str.length());
                if (iZzt2 != iZzt) {
                    zzo(Xb0.a(str));
                    a(str);
                    return;
                }
                int iPosition2 = this.b.position() + iZzt2;
                this.b.position(iPosition2);
                a(str);
                int iPosition3 = this.b.position();
                this.b.position(iPosition);
                zzo(iPosition3 - iPosition2);
                this.b.position(iPosition3);
            } catch (C2045dc0 e) {
                this.b.position(iPosition);
                zza(str, e);
            } catch (IllegalArgumentException e2) {
                throw new zzc(e2);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzn(int i) {
            if (i >= 0) {
                zzo(i);
            } else {
                zzb(i);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzo(int i) throws zzc {
            while ((i & (-128)) != 0) {
                try {
                    this.b.put((byte) ((i & ShapeTypes.VERTICAL_SCROLL) | 128));
                    i >>>= 7;
                } catch (BufferOverflowException e) {
                    throw new zzc(e);
                }
            }
            this.b.put((byte) i);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzq(int i) throws zzc {
            try {
                this.b.putInt(i);
            } catch (BufferOverflowException e) {
                throw new zzc(e);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zza(int i, long j) {
            zzb(i, 0);
            zzb(j);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzb(int i, zzbb zzbbVar) {
            zzb(1, 3);
            zzd(2, i);
            zza(3, zzbbVar);
            zzb(1, 4);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzc(int i, long j) {
            zzb(i, 1);
            zzd(j);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzd(long j) throws zzc {
            try {
                this.b.putLong(j);
            } catch (BufferOverflowException e) {
                throw new zzc(e);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zza(int i, zzbb zzbbVar) {
            zzb(i, 2);
            zza(zzbbVar);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzb(int i, zzdo zzdoVar) {
            zzb(1, 3);
            zzd(2, i);
            zza(3, zzdoVar);
            zzb(1, 4);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzd(byte[] bArr, int i, int i2) {
            zzo(i2);
            write(bArr, 0, i2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zza(int i, zzdo zzdoVar) {
            zzb(i, 2);
            zzb(zzdoVar);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzb(int i, boolean z) {
            zzb(i, 0);
            zza(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zza(int i, zzdo zzdoVar, Ta0 ta0) {
            zzb(i, 2);
            zza(zzdoVar, ta0);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzb(long j) throws zzc {
            while (((-128) & j) != 0) {
                try {
                    this.b.put((byte) ((((int) j) & ShapeTypes.VERTICAL_SCROLL) | 128));
                    j >>>= 7;
                } catch (BufferOverflowException e) {
                    throw new zzc(e);
                }
            }
            this.b.put((byte) j);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zza(int i, String str) {
            zzb(i, 2);
            zzg(str);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzb(zzdo zzdoVar) {
            zzo(zzdoVar.zzas());
            zzdoVar.zzb(this);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zza(zzbb zzbbVar) {
            zzo(zzbbVar.size());
            zzbbVar.zza(this);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zza(zzdo zzdoVar, Ta0 ta0) {
            zzas zzasVar = (zzas) zzdoVar;
            int iZzs = zzasVar.zzs();
            if (iZzs == -1) {
                iZzs = ta0.c(zzasVar);
                zzasVar.zzf(iZzs);
            }
            zzo(iZzs);
            ta0.d(zzdoVar, this.zzfz);
        }

        @Override // com.google.android.gms.internal.clearcut.zzba
        public final void zza(byte[] bArr, int i, int i2) {
            write(bArr, i, i2);
        }
    }

    public static final class d extends zzbn {
        public final ByteBuffer a;
        public final ByteBuffer b;
        public final long c;
        public final long d;
        public final long e;
        public final long f;
        public long g;

        public d(ByteBuffer byteBuffer) {
            super();
            this.a = byteBuffer;
            this.b = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            long jO = Sb0.o(byteBuffer);
            this.c = jO;
            long jPosition = ((long) byteBuffer.position()) + jO;
            this.d = jPosition;
            long jLimit = jO + ((long) byteBuffer.limit());
            this.e = jLimit;
            this.f = jLimit - 10;
            this.g = jPosition;
        }

        public final void a(long j) {
            this.b.position((int) (j - this.c));
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void flush() {
            this.a.position((int) (this.g - this.c));
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void write(byte[] bArr, int i, int i2) throws zzc {
            if (bArr != null && i >= 0 && i2 >= 0 && bArr.length - i2 >= i) {
                long j = i2;
                long j2 = this.e - j;
                long j3 = this.g;
                if (j2 >= j3) {
                    Sb0.l(bArr, i, j3, j);
                    this.g += j;
                    return;
                }
            }
            if (bArr != null) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.g), Long.valueOf(this.e), Integer.valueOf(i2)));
            }
            throw new NullPointerException("value");
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zza(byte b) throws zzc {
            long j = this.g;
            if (j >= this.e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.g), Long.valueOf(this.e), 1));
            }
            this.g = 1 + j;
            Sb0.c(j, b);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final int zzag() {
            return (int) (this.e - this.g);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzb(int i, int i2) {
            zzo((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzc(int i, int i2) {
            zzb(i, 0);
            zzn(i2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzd(int i, int i2) {
            zzb(i, 0);
            zzo(i2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzf(int i, int i2) {
            zzb(i, 5);
            zzq(i2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzg(String str) throws zzc {
            long j = this.g;
            try {
                int iZzt = zzbn.zzt(str.length() * 3);
                int iZzt2 = zzbn.zzt(str.length());
                if (iZzt2 != iZzt) {
                    int iA = Xb0.a(str);
                    zzo(iA);
                    a(this.g);
                    Xb0.c(str, this.b);
                    this.g += (long) iA;
                    return;
                }
                int i = ((int) (this.g - this.c)) + iZzt2;
                this.b.position(i);
                Xb0.c(str, this.b);
                int iPosition = this.b.position() - i;
                zzo(iPosition);
                this.g += (long) iPosition;
            } catch (C2045dc0 e) {
                this.g = j;
                a(j);
                zza(str, e);
            } catch (IllegalArgumentException e2) {
                throw new zzc(e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new zzc(e3);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzn(int i) {
            if (i >= 0) {
                zzo(i);
            } else {
                zzb(i);
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzo(int i) throws zzc {
            if (this.g <= this.f) {
                while ((i & (-128)) != 0) {
                    long j = this.g;
                    this.g = j + 1;
                    Sb0.c(j, (byte) ((i & ShapeTypes.VERTICAL_SCROLL) | 128));
                    i >>>= 7;
                }
                long j2 = this.g;
                this.g = 1 + j2;
                Sb0.c(j2, (byte) i);
                return;
            }
            while (true) {
                long j3 = this.g;
                if (j3 >= this.e) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.g), Long.valueOf(this.e), 1));
                }
                if ((i & (-128)) == 0) {
                    this.g = 1 + j3;
                    Sb0.c(j3, (byte) i);
                    return;
                } else {
                    this.g = j3 + 1;
                    Sb0.c(j3, (byte) ((i & ShapeTypes.VERTICAL_SCROLL) | 128));
                    i >>>= 7;
                }
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzq(int i) {
            this.b.putInt((int) (this.g - this.c), i);
            this.g += 4;
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zza(int i, long j) {
            zzb(i, 0);
            zzb(j);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzb(int i, zzbb zzbbVar) {
            zzb(1, 3);
            zzd(2, i);
            zza(3, zzbbVar);
            zzb(1, 4);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzc(int i, long j) {
            zzb(i, 1);
            zzd(j);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzd(long j) {
            this.b.putLong((int) (this.g - this.c), j);
            this.g += 8;
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zza(int i, zzbb zzbbVar) {
            zzb(i, 2);
            zza(zzbbVar);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzb(int i, zzdo zzdoVar) {
            zzb(1, 3);
            zzd(2, i);
            zza(3, zzdoVar);
            zzb(1, 4);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzd(byte[] bArr, int i, int i2) {
            zzo(i2);
            write(bArr, 0, i2);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zza(int i, zzdo zzdoVar) {
            zzb(i, 2);
            zzb(zzdoVar);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzb(int i, boolean z) {
            zzb(i, 0);
            zza(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zza(int i, zzdo zzdoVar, Ta0 ta0) {
            zzb(i, 2);
            zza(zzdoVar, ta0);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzb(long j) throws zzc {
            if (this.g <= this.f) {
                while (true) {
                    long j2 = j & (-128);
                    long j3 = this.g;
                    if (j2 == 0) {
                        this.g = 1 + j3;
                        Sb0.c(j3, (byte) j);
                        return;
                    } else {
                        this.g = j3 + 1;
                        Sb0.c(j3, (byte) ((((int) j) & ShapeTypes.VERTICAL_SCROLL) | 128));
                        j >>>= 7;
                    }
                }
            } else {
                while (true) {
                    long j4 = this.g;
                    if (j4 >= this.e) {
                        throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.g), Long.valueOf(this.e), 1));
                    }
                    if ((j & (-128)) == 0) {
                        this.g = 1 + j4;
                        Sb0.c(j4, (byte) j);
                        return;
                    } else {
                        this.g = j4 + 1;
                        Sb0.c(j4, (byte) ((((int) j) & ShapeTypes.VERTICAL_SCROLL) | 128));
                        j >>>= 7;
                    }
                }
            }
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zza(int i, String str) {
            zzb(i, 2);
            zzg(str);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zzb(zzdo zzdoVar) {
            zzo(zzdoVar.zzas());
            zzdoVar.zzb(this);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zza(zzbb zzbbVar) {
            zzo(zzbbVar.size());
            zzbbVar.zza(this);
        }

        @Override // com.google.android.gms.internal.clearcut.zzbn
        public final void zza(zzdo zzdoVar, Ta0 ta0) {
            zzas zzasVar = (zzas) zzdoVar;
            int iZzs = zzasVar.zzs();
            if (iZzs == -1) {
                iZzs = ta0.c(zzasVar);
                zzasVar.zzf(iZzs);
            }
            zzo(iZzs);
            ta0.d(zzdoVar, this.zzfz);
        }

        @Override // com.google.android.gms.internal.clearcut.zzba
        public final void zza(byte[] bArr, int i, int i2) {
            write(bArr, i, i2);
        }
    }

    public static class zzc extends IOException {
        public zzc() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public zzc(String str) {
            String strValueOf = String.valueOf(str);
            super(strValueOf.length() != 0 ? "CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(strValueOf) : new String("CodedOutputStream was writing to a flat byte array and ran out of space.: "));
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public zzc(String str, Throwable th) {
            String strValueOf = String.valueOf(str);
            super(strValueOf.length() != 0 ? "CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(strValueOf) : new String("CodedOutputStream was writing to a flat byte array and ran out of space.: "), th);
        }

        public zzc(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }
    }

    private zzbn() {
    }

    public static int zza(int i, zzcv zzcvVar) {
        int iZzr = zzr(i);
        int iZzas = zzcvVar.zzas();
        return iZzr + zzt(iZzas) + iZzas;
    }

    public static int zzb(double d2) {
        return 8;
    }

    public static int zzc(int i, zzbb zzbbVar) {
        int iZzr = zzr(i);
        int size = zzbbVar.size();
        return iZzr + zzt(size) + size;
    }

    public static int zzd(int i, long j) {
        return zzr(i) + zzf(j);
    }

    public static int zze(int i, long j) {
        return zzr(i) + zzf(j);
    }

    public static int zzf(int i, long j) {
        return zzr(i) + zzf(zzj(j));
    }

    public static int zzg(int i, int i2) {
        return zzr(i) + zzs(i2);
    }

    public static int zzh(int i, int i2) {
        return zzr(i) + zzt(i2);
    }

    public static int zzi(int i, int i2) {
        return zzr(i) + zzt(zzy(i2));
    }

    public static int zzj(int i, int i2) {
        return zzr(i) + 4;
    }

    public static int zzk(int i, int i2) {
        return zzr(i) + 4;
    }

    public static int zzl(int i, int i2) {
        return zzr(i) + zzs(i2);
    }

    public static int zzr(int i) {
        return zzt(i << 3);
    }

    public static int zzs(int i) {
        if (i >= 0) {
            return zzt(i);
        }
        return 10;
    }

    public static int zzt(int i) {
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

    public static int zzu(int i) {
        return zzt(zzy(i));
    }

    public static int zzv(int i) {
        return 4;
    }

    public static int zzw(int i) {
        return 4;
    }

    public static int zzx(int i) {
        return zzs(i);
    }

    private static int zzy(int i) {
        return (i >> 31) ^ (i << 1);
    }

    @Deprecated
    public static int zzz(int i) {
        return zzt(i);
    }

    public abstract void flush();

    public abstract void write(byte[] bArr, int i, int i2);

    public abstract void zza(byte b2);

    public abstract void zza(int i, long j);

    public abstract void zza(int i, zzbb zzbbVar);

    public abstract void zza(int i, zzdo zzdoVar);

    public abstract void zza(int i, zzdo zzdoVar, Ta0 ta0);

    public abstract void zza(int i, String str);

    public abstract void zza(zzbb zzbbVar);

    public abstract void zza(zzdo zzdoVar, Ta0 ta0);

    public abstract int zzag();

    public abstract void zzb(int i, int i2);

    public abstract void zzb(int i, zzbb zzbbVar);

    public abstract void zzb(int i, zzdo zzdoVar);

    public abstract void zzb(int i, boolean z);

    public abstract void zzb(long j);

    public abstract void zzb(zzdo zzdoVar);

    public abstract void zzc(int i, int i2);

    public abstract void zzc(int i, long j);

    public abstract void zzd(int i, int i2);

    public abstract void zzd(long j);

    public abstract void zzd(byte[] bArr, int i, int i2);

    public abstract void zzf(int i, int i2);

    public abstract void zzg(String str);

    public abstract void zzn(int i);

    public abstract void zzo(int i);

    public final void zzp(int i) {
        zzo(zzy(i));
    }

    public abstract void zzq(int i);

    public static int zza(zzcv zzcvVar) {
        int iZzas = zzcvVar.zzas();
        return zzt(iZzas) + iZzas;
    }

    public static int zzb(float f) {
        return 4;
    }

    public static int zzc(int i, zzdo zzdoVar) {
        return zzr(i) + zzc(zzdoVar);
    }

    public static int zzd(int i, zzbb zzbbVar) {
        return (zzr(1) << 1) + zzh(2, i) + zzc(3, zzbbVar);
    }

    public static int zze(long j) {
        return zzf(j);
    }

    public static int zzf(long j) {
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

    public static int zzg(int i, long j) {
        return zzr(i) + 8;
    }

    public static int zzh(int i, long j) {
        return zzr(i) + 8;
    }

    public static int zzi(long j) {
        return 8;
    }

    private static long zzj(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static zzbn zza(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return new b(byteBuffer);
        }
        if (!byteBuffer.isDirect() || byteBuffer.isReadOnly()) {
            throw new IllegalArgumentException("ByteBuffer is read-only");
        }
        return Sb0.y() ? new d(byteBuffer) : new c(byteBuffer);
    }

    public static int zzb(int i, double d2) {
        return zzr(i) + 8;
    }

    @Deprecated
    public static int zzc(int i, zzdo zzdoVar, Ta0 ta0) {
        int iZzr = zzr(i) << 1;
        zzas zzasVar = (zzas) zzdoVar;
        int iZzs = zzasVar.zzs();
        if (iZzs == -1) {
            iZzs = ta0.c(zzasVar);
            zzasVar.zzf(iZzs);
        }
        return iZzr + iZzs;
    }

    public static int zzd(int i, zzdo zzdoVar) {
        return (zzr(1) << 1) + zzh(2, i) + zzc(3, zzdoVar);
    }

    public static int zzg(long j) {
        return zzf(zzj(j));
    }

    public static int zzh(long j) {
        return 8;
    }

    public final void zze(int i, int i2) {
        zzd(i, zzy(i2));
    }

    public static int zzb(int i, float f) {
        return zzr(i) + 4;
    }

    public static int zzc(int i, boolean z) {
        return zzr(i) + 1;
    }

    @Deprecated
    public static int zzd(zzdo zzdoVar) {
        return zzdoVar.zzas();
    }

    public static int zzh(String str) {
        int length;
        try {
            length = Xb0.a(str);
        } catch (C2045dc0 unused) {
            length = str.getBytes(zzci.UTF_8).length;
        }
        return zzt(length) + length;
    }

    public final void zza(double d2) {
        zzd(Double.doubleToRawLongBits(d2));
    }

    public static int zzb(int i, zzcv zzcvVar) {
        return (zzr(1) << 1) + zzh(2, i) + zza(3, zzcvVar);
    }

    public static int zzc(zzdo zzdoVar) {
        int iZzas = zzdoVar.zzas();
        return zzt(iZzas) + iZzas;
    }

    public static int zzd(byte[] bArr) {
        int length = bArr.length;
        return zzt(length) + length;
    }

    public final void zza(float f) {
        zzq(Float.floatToRawIntBits(f));
    }

    public static int zzb(int i, zzdo zzdoVar, Ta0 ta0) {
        return zzr(i) + zzb(zzdoVar, ta0);
    }

    public static zzbn zzc(byte[] bArr) {
        return new a(bArr, 0, bArr.length);
    }

    public final void zza(int i, double d2) {
        zzc(i, Double.doubleToRawLongBits(d2));
    }

    public static int zzb(int i, String str) {
        return zzr(i) + zzh(str);
    }

    public final void zza(int i, float f) {
        zzf(i, Float.floatToRawIntBits(f));
    }

    public final void zzc(long j) {
        zzb(zzj(j));
    }

    public static int zzb(zzbb zzbbVar) {
        int size = zzbbVar.size();
        return zzt(size) + size;
    }

    public final void zza(String str, C2045dc0 c2045dc0) throws zzc {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) c2045dc0);
        byte[] bytes = str.getBytes(zzci.UTF_8);
        try {
            zzo(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (zzc e) {
            throw e;
        } catch (IndexOutOfBoundsException e2) {
            throw new zzc(e2);
        }
    }

    public static int zzb(zzdo zzdoVar, Ta0 ta0) {
        zzas zzasVar = (zzas) zzdoVar;
        int iZzs = zzasVar.zzs();
        if (iZzs == -1) {
            iZzs = ta0.c(zzasVar);
            zzasVar.zzf(iZzs);
        }
        return zzt(iZzs) + iZzs;
    }

    public final void zza(boolean z) {
        zza(z ? (byte) 1 : (byte) 0);
    }

    public static int zzb(boolean z) {
        return 1;
    }

    public final void zzb(int i, long j) {
        zza(i, zzj(j));
    }
}
