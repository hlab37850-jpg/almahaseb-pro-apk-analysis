package com.google.android.gms.internal.vision;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import defpackage.AbstractC3163je0;
import defpackage.AbstractC3574of;
import defpackage.AbstractC3897se0;
import defpackage.AbstractC3899sf0;
import defpackage.C4142vf0;
import defpackage.Df0;
import defpackage.InterfaceC3167jg0;
import defpackage.Lg0;
import defpackage.Pf0;
import defpackage.Ve0;
import defpackage.Yf0;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class s extends AbstractC3163je0 {
    public final boolean a;
    public final byte[] b;
    public int c;
    public final int d;
    public int e;
    public int f;
    public int g;

    public s(ByteBuffer byteBuffer, boolean z) {
        super();
        this.a = true;
        this.b = byteBuffer.array();
        int iArrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
        this.c = iArrayOffset;
        this.d = iArrayOffset;
        this.e = byteBuffer.arrayOffset() + byteBuffer.limit();
    }

    public final String A(boolean z) throws zzjk {
        I(2);
        int iO = O();
        if (iO == 0) {
            return "";
        }
        G(iO);
        if (z) {
            byte[] bArr = this.b;
            int i = this.c;
            if (!Lg0.g(bArr, i, i + iO)) {
                throw zzjk.zzh();
            }
        }
        String str = new String(this.b, this.c, iO, zzjf.zza);
        this.c += iO;
        return str;
    }

    public final void B(int i) throws zzjk {
        G(i);
        this.c += i;
    }

    public final void C(List list, boolean z) throws zzjn {
        int i;
        int i2;
        if ((this.f & 7) != 2) {
            throw zzjk.zzf();
        }
        if (!(list instanceof zzjv) || z) {
            do {
                list.add(A(z));
                if (N()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (O() == this.f);
            this.c = i;
            return;
        }
        zzjv zzjvVar = (zzjv) list;
        do {
            zzjvVar.zza(f());
            if (N()) {
                return;
            } else {
                i2 = this.c;
            }
        } while (O() == this.f);
        this.c = i2;
    }

    public final long D() throws zzjk {
        G(8);
        return F();
    }

    public final int E() {
        int i = this.c;
        byte[] bArr = this.b;
        this.c = i + 4;
        return ((bArr[i + 3] & UnsignedBytes.MAX_VALUE) << 24) | (bArr[i] & UnsignedBytes.MAX_VALUE) | ((bArr[i + 1] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr[i + 2] & UnsignedBytes.MAX_VALUE) << 16);
    }

    public final long F() {
        int i = this.c;
        byte[] bArr = this.b;
        this.c = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    public final void G(int i) throws zzjk {
        if (i < 0 || i > this.e - this.c) {
            throw zzjk.zza();
        }
    }

    public final Object H(InterfaceC3167jg0 interfaceC3167jg0, zzio zzioVar) throws zzjk {
        int iO = O();
        G(iO);
        int i = this.e;
        int i2 = this.c + iO;
        this.e = i2;
        try {
            Object objZza = interfaceC3167jg0.zza();
            interfaceC3167jg0.f(objZza, this, zzioVar);
            interfaceC3167jg0.a(objZza);
            if (this.c != i2) {
                throw zzjk.zzg();
            }
            this.e = i;
            return objZza;
        } catch (Throwable th) {
            this.e = i;
            throw th;
        }
    }

    public final void I(int i) throws zzjn {
        if ((this.f & 7) != i) {
            throw zzjk.zzf();
        }
    }

    public final Object J(InterfaceC3167jg0 interfaceC3167jg0, zzio zzioVar) {
        int i = this.g;
        this.g = ((this.f >>> 3) << 3) | 4;
        try {
            Object objZza = interfaceC3167jg0.zza();
            interfaceC3167jg0.f(objZza, this, zzioVar);
            interfaceC3167jg0.a(objZza);
            if (this.f != this.g) {
                throw zzjk.zzg();
            }
            this.g = i;
            return objZza;
        } catch (Throwable th) {
            this.g = i;
            throw th;
        }
    }

    public final void K(int i) throws zzjk {
        G(i);
        if ((i & 7) != 0) {
            throw zzjk.zzg();
        }
    }

    public final void L(int i) throws zzjk {
        G(i);
        if ((i & 3) != 0) {
            throw zzjk.zzg();
        }
    }

    public final void M(int i) throws zzjk {
        if (this.c != i) {
            throw zzjk.zza();
        }
    }

    public final boolean N() {
        return this.c == this.e;
    }

    public final int O() throws zzjk {
        int i;
        int i2 = this.c;
        int i3 = this.e;
        if (i3 == i2) {
            throw zzjk.zza();
        }
        byte[] bArr = this.b;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            this.c = i4;
            return b;
        }
        if (i3 - i4 < 9) {
            return (int) Q();
        }
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
                                        if (bArr[i7] < 0) {
                                            throw zzjk.zzc();
                                        }
                                        i5 = i12;
                                        i = i11;
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
        this.c = i5;
        return i;
    }

    public final long P() throws zzjk {
        long j;
        long j2;
        long j3;
        int i = this.c;
        int i2 = this.e;
        if (i2 == i) {
            throw zzjk.zza();
        }
        byte[] bArr = this.b;
        int i3 = i + 1;
        byte b = bArr[i];
        if (b >= 0) {
            this.c = i3;
            return b;
        }
        if (i2 - i3 < 9) {
            return Q();
        }
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
                                        if (bArr[i4] < 0) {
                                            throw zzjk.zzc();
                                        }
                                        i4 = i11;
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
        this.c = i4;
        return j;
    }

    public final long Q() throws zzjk {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte bR = R();
            j |= ((long) (bR & Ascii.DEL)) << i;
            if ((bR & UnsignedBytes.MAX_POWER_OF_TWO) == 0) {
                return j;
            }
        }
        throw zzjk.zzc();
    }

    public final byte R() throws zzjk {
        int i = this.c;
        if (i == this.e) {
            throw zzjk.zza();
        }
        byte[] bArr = this.b;
        this.c = i + 1;
        return bArr[i];
    }

    public final int S() throws zzjk {
        G(4);
        return E();
    }

    @Override // defpackage.InterfaceC3249kg0
    public final void a(List list) throws zzjk {
        int i;
        if (list instanceof AbstractC3897se0) {
            AbstractC3574of.a(list);
            int i2 = this.f & 7;
            if (i2 == 0) {
                zzk();
                throw null;
            }
            if (i2 != 2) {
                throw zzjk.zzf();
            }
            int iO = O();
            int i3 = this.c;
            int i4 = iO + i3;
            if (i3 >= i4) {
                M(i4);
                return;
            } else {
                O();
                throw null;
            }
        }
        int i5 = this.f & 7;
        if (i5 != 0) {
            if (i5 != 2) {
                throw zzjk.zzf();
            }
            int iO2 = this.c + O();
            while (this.c < iO2) {
                list.add(Boolean.valueOf(O() != 0));
            }
            M(iO2);
            return;
        }
        do {
            list.add(Boolean.valueOf(zzk()));
            if (N()) {
                return;
            } else {
                i = this.c;
            }
        } while (O() == this.f);
        this.c = i;
    }

    @Override // defpackage.InterfaceC3249kg0
    public final void b(List list) throws zzjk {
        int i;
        int i2;
        if (!(list instanceof C4142vf0)) {
            int i3 = this.f & 7;
            if (i3 == 2) {
                int iO = O();
                L(iO);
                int i4 = this.c + iO;
                while (this.c < i4) {
                    list.add(Integer.valueOf(E()));
                }
                return;
            }
            if (i3 != 5) {
                throw zzjk.zzf();
            }
            do {
                list.add(Integer.valueOf(zzj()));
                if (N()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (O() == this.f);
            this.c = i;
            return;
        }
        C4142vf0 c4142vf0 = (C4142vf0) list;
        int i5 = this.f & 7;
        if (i5 == 2) {
            int iO2 = O();
            L(iO2);
            int i6 = this.c + iO2;
            while (this.c < i6) {
                c4142vf0.b(E());
            }
            return;
        }
        if (i5 != 5) {
            throw zzjk.zzf();
        }
        do {
            c4142vf0.b(zzj());
            if (N()) {
                return;
            } else {
                i2 = this.c;
            }
        } while (O() == this.f);
        this.c = i2;
    }

    @Override // defpackage.InterfaceC3249kg0
    public final void c(List list) throws zzjk {
        int i;
        int i2;
        if (!(list instanceof C4142vf0)) {
            int i3 = this.f & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw zzjk.zzf();
                }
                int iO = this.c + O();
                while (this.c < iO) {
                    list.add(Integer.valueOf(zzif.zze(O())));
                }
                return;
            }
            do {
                list.add(Integer.valueOf(zzs()));
                if (N()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (O() == this.f);
            this.c = i;
            return;
        }
        C4142vf0 c4142vf0 = (C4142vf0) list;
        int i4 = this.f & 7;
        if (i4 != 0) {
            if (i4 != 2) {
                throw zzjk.zzf();
            }
            int iO2 = this.c + O();
            while (this.c < iO2) {
                c4142vf0.b(zzif.zze(O()));
            }
            return;
        }
        do {
            c4142vf0.b(zzs());
            if (N()) {
                return;
            } else {
                i2 = this.c;
            }
        } while (O() == this.f);
        this.c = i2;
    }

    @Override // defpackage.InterfaceC3249kg0
    public final void d(List list) throws zzjk {
        int i;
        if (list instanceof Df0) {
            AbstractC3574of.a(list);
            int i2 = this.f & 7;
            if (i2 == 1) {
                zzr();
                throw null;
            }
            if (i2 != 2) {
                throw zzjk.zzf();
            }
            int iO = O();
            K(iO);
            int i3 = this.c;
            if (i3 >= iO + i3) {
                return;
            }
            F();
            throw null;
        }
        int i4 = this.f & 7;
        if (i4 == 1) {
            do {
                list.add(Long.valueOf(zzr()));
                if (N()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (O() == this.f);
            this.c = i;
            return;
        }
        if (i4 != 2) {
            throw zzjk.zzf();
        }
        int iO2 = O();
        K(iO2);
        int i5 = this.c + iO2;
        while (this.c < i5) {
            list.add(Long.valueOf(F()));
        }
    }

    @Override // defpackage.InterfaceC3249kg0
    public final void e(List list) throws zzjk {
        int i;
        if (list instanceof Df0) {
            AbstractC3574of.a(list);
            int i2 = this.f & 7;
            if (i2 == 1) {
                zzi();
                throw null;
            }
            if (i2 != 2) {
                throw zzjk.zzf();
            }
            int iO = O();
            K(iO);
            int i3 = this.c;
            if (i3 >= iO + i3) {
                return;
            }
            F();
            throw null;
        }
        int i4 = this.f & 7;
        if (i4 == 1) {
            do {
                list.add(Long.valueOf(zzi()));
                if (N()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (O() == this.f);
            this.c = i;
            return;
        }
        if (i4 != 2) {
            throw zzjk.zzf();
        }
        int iO2 = O();
        K(iO2);
        int i5 = this.c + iO2;
        while (this.c < i5) {
            list.add(Long.valueOf(F()));
        }
    }

    @Override // defpackage.InterfaceC3249kg0
    public final zzht f() throws zzjk {
        I(2);
        int iO = O();
        if (iO == 0) {
            return zzht.zza;
        }
        G(iO);
        zzht zzhtVarZzb = this.a ? zzht.zzb(this.b, this.c, iO) : zzht.zza(this.b, this.c, iO);
        this.c += iO;
        return zzhtVarZzb;
    }

    @Override // defpackage.InterfaceC3249kg0
    public final void g(List list) throws zzjn {
        C(list, true);
    }

    @Override // defpackage.InterfaceC3249kg0
    public final void h(List list) throws zzjk {
        int i;
        if (list instanceof Ve0) {
            AbstractC3574of.a(list);
            int i2 = this.f & 7;
            if (i2 == 1) {
                zzd();
                throw null;
            }
            if (i2 != 2) {
                throw zzjk.zzf();
            }
            int iO = O();
            K(iO);
            int i3 = this.c;
            if (i3 >= iO + i3) {
                return;
            }
            Double.longBitsToDouble(F());
            throw null;
        }
        int i4 = this.f & 7;
        if (i4 == 1) {
            do {
                list.add(Double.valueOf(zzd()));
                if (N()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (O() == this.f);
            this.c = i;
            return;
        }
        if (i4 != 2) {
            throw zzjk.zzf();
        }
        int iO2 = O();
        K(iO2);
        int i5 = this.c + iO2;
        while (this.c < i5) {
            list.add(Double.valueOf(Double.longBitsToDouble(F())));
        }
    }

    @Override // defpackage.InterfaceC3249kg0
    public final int i() throws zzjn {
        I(0);
        return O();
    }

    @Override // defpackage.InterfaceC3249kg0
    public final Object j(InterfaceC3167jg0 interfaceC3167jg0, zzio zzioVar) throws zzjn {
        I(2);
        return H(interfaceC3167jg0, zzioVar);
    }

    @Override // defpackage.InterfaceC3249kg0
    public final void k(List list) throws zzjn {
        C(list, false);
    }

    @Override // defpackage.InterfaceC3249kg0
    public final void l(List list) throws zzjk {
        int i;
        if (list instanceof Df0) {
            AbstractC3574of.a(list);
            int i2 = this.f & 7;
            if (i2 == 0) {
                zzt();
                throw null;
            }
            if (i2 != 2) {
                throw zzjk.zzf();
            }
            int iO = O();
            int i3 = this.c;
            if (i3 >= iO + i3) {
                return;
            }
            zzif.zza(P());
            throw null;
        }
        int i4 = this.f & 7;
        if (i4 != 0) {
            if (i4 != 2) {
                throw zzjk.zzf();
            }
            int iO2 = this.c + O();
            while (this.c < iO2) {
                list.add(Long.valueOf(zzif.zza(P())));
            }
            return;
        }
        do {
            list.add(Long.valueOf(zzt()));
            if (N()) {
                return;
            } else {
                i = this.c;
            }
        } while (O() == this.f);
        this.c = i;
    }

    @Override // defpackage.InterfaceC3249kg0
    public final Object m(InterfaceC3167jg0 interfaceC3167jg0, zzio zzioVar) throws zzjn {
        I(3);
        return J(interfaceC3167jg0, zzioVar);
    }

    @Override // defpackage.InterfaceC3249kg0
    public final void n(List list) throws zzjk {
        int i;
        int i2;
        if (!(list instanceof C4142vf0)) {
            int i3 = this.f & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw zzjk.zzf();
                }
                int iO = this.c + O();
                while (this.c < iO) {
                    list.add(Integer.valueOf(O()));
                }
                return;
            }
            do {
                list.add(Integer.valueOf(i()));
                if (N()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (O() == this.f);
            this.c = i;
            return;
        }
        C4142vf0 c4142vf0 = (C4142vf0) list;
        int i4 = this.f & 7;
        if (i4 != 0) {
            if (i4 != 2) {
                throw zzjk.zzf();
            }
            int iO2 = this.c + O();
            while (this.c < iO2) {
                c4142vf0.b(O());
            }
            return;
        }
        do {
            c4142vf0.b(i());
            if (N()) {
                return;
            } else {
                i2 = this.c;
            }
        } while (O() == this.f);
        this.c = i2;
    }

    @Override // defpackage.InterfaceC3249kg0
    public final String o() {
        return A(false);
    }

    @Override // defpackage.InterfaceC3249kg0
    public final void p(List list, InterfaceC3167jg0 interfaceC3167jg0, zzio zzioVar) throws zzjn {
        int i;
        int i2 = this.f;
        if ((i2 & 7) != 3) {
            throw zzjk.zzf();
        }
        do {
            list.add(J(interfaceC3167jg0, zzioVar));
            if (N()) {
                return;
            } else {
                i = this.c;
            }
        } while (O() == i2);
        this.c = i;
    }

    @Override // defpackage.InterfaceC3249kg0
    public final void q(List list) throws zzjk {
        int i;
        if (list instanceof Df0) {
            AbstractC3574of.a(list);
            int i2 = this.f & 7;
            if (i2 == 0) {
                zzf();
                throw null;
            }
            if (i2 != 2) {
                throw zzjk.zzf();
            }
            int iO = O();
            int i3 = this.c;
            int i4 = iO + i3;
            if (i3 >= i4) {
                M(i4);
                return;
            } else {
                P();
                throw null;
            }
        }
        int i5 = this.f & 7;
        if (i5 == 0) {
            do {
                list.add(Long.valueOf(zzf()));
                if (N()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (O() == this.f);
            this.c = i;
            return;
        }
        if (i5 != 2) {
            throw zzjk.zzf();
        }
        int iO2 = this.c + O();
        while (this.c < iO2) {
            list.add(Long.valueOf(P()));
        }
        M(iO2);
    }

    @Override // defpackage.InterfaceC3249kg0
    public final void r(List list) throws zzjn {
        int i;
        if ((this.f & 7) != 2) {
            throw zzjk.zzf();
        }
        do {
            list.add(f());
            if (N()) {
                return;
            } else {
                i = this.c;
            }
        } while (O() == this.f);
        this.c = i;
    }

    @Override // defpackage.InterfaceC3249kg0
    public final void s(List list, InterfaceC3167jg0 interfaceC3167jg0, zzio zzioVar) throws zzjn {
        int i;
        int i2 = this.f;
        if ((i2 & 7) != 2) {
            throw zzjk.zzf();
        }
        do {
            list.add(H(interfaceC3167jg0, zzioVar));
            if (N()) {
                return;
            } else {
                i = this.c;
            }
        } while (O() == i2);
        this.c = i;
    }

    @Override // defpackage.InterfaceC3249kg0
    public final void t(List list) throws zzjk {
        int i;
        int i2;
        if (!(list instanceof C4142vf0)) {
            int i3 = this.f & 7;
            if (i3 == 2) {
                int iO = O();
                L(iO);
                int i4 = this.c + iO;
                while (this.c < i4) {
                    list.add(Integer.valueOf(E()));
                }
                return;
            }
            if (i3 != 5) {
                throw zzjk.zzf();
            }
            do {
                list.add(Integer.valueOf(zzq()));
                if (N()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (O() == this.f);
            this.c = i;
            return;
        }
        C4142vf0 c4142vf0 = (C4142vf0) list;
        int i5 = this.f & 7;
        if (i5 == 2) {
            int iO2 = O();
            L(iO2);
            int i6 = this.c + iO2;
            while (this.c < i6) {
                c4142vf0.b(E());
            }
            return;
        }
        if (i5 != 5) {
            throw zzjk.zzf();
        }
        do {
            c4142vf0.b(zzq());
            if (N()) {
                return;
            } else {
                i2 = this.c;
            }
        } while (O() == this.f);
        this.c = i2;
    }

    @Override // defpackage.InterfaceC3249kg0
    public final Object u(Class cls, zzio zzioVar) throws zzjn {
        I(3);
        return J(Yf0.a().b(cls), zzioVar);
    }

    @Override // defpackage.InterfaceC3249kg0
    public final void v(List list) throws zzjk {
        int i;
        int i2;
        if (!(list instanceof C4142vf0)) {
            int i3 = this.f & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(zzh()));
                    if (N()) {
                        return;
                    } else {
                        i = this.c;
                    }
                } while (O() == this.f);
                this.c = i;
                return;
            }
            if (i3 != 2) {
                throw zzjk.zzf();
            }
            int iO = this.c + O();
            while (this.c < iO) {
                list.add(Integer.valueOf(O()));
            }
            M(iO);
            return;
        }
        C4142vf0 c4142vf0 = (C4142vf0) list;
        int i4 = this.f & 7;
        if (i4 == 0) {
            do {
                c4142vf0.b(zzh());
                if (N()) {
                    return;
                } else {
                    i2 = this.c;
                }
            } while (O() == this.f);
            this.c = i2;
            return;
        }
        if (i4 != 2) {
            throw zzjk.zzf();
        }
        int iO2 = this.c + O();
        while (this.c < iO2) {
            c4142vf0.b(O());
        }
        M(iO2);
    }

    @Override // defpackage.InterfaceC3249kg0
    public final void w(List list) throws zzjk {
        int i;
        int i2;
        if (!(list instanceof C4142vf0)) {
            int i3 = this.f & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw zzjk.zzf();
                }
                int iO = this.c + O();
                while (this.c < iO) {
                    list.add(Integer.valueOf(O()));
                }
                return;
            }
            do {
                list.add(Integer.valueOf(zzp()));
                if (N()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (O() == this.f);
            this.c = i;
            return;
        }
        C4142vf0 c4142vf0 = (C4142vf0) list;
        int i4 = this.f & 7;
        if (i4 != 0) {
            if (i4 != 2) {
                throw zzjk.zzf();
            }
            int iO2 = this.c + O();
            while (this.c < iO2) {
                c4142vf0.b(O());
            }
            return;
        }
        do {
            c4142vf0.b(zzp());
            if (N()) {
                return;
            } else {
                i2 = this.c;
            }
        } while (O() == this.f);
        this.c = i2;
    }

    @Override // defpackage.InterfaceC3249kg0
    public final Object x(Class cls, zzio zzioVar) throws zzjn {
        I(2);
        return H(Yf0.a().b(cls), zzioVar);
    }

    @Override // defpackage.InterfaceC3249kg0
    public final void y(List list) throws zzjk {
        int i;
        if (list instanceof Df0) {
            AbstractC3574of.a(list);
            int i2 = this.f & 7;
            if (i2 == 0) {
                zzg();
                throw null;
            }
            if (i2 != 2) {
                throw zzjk.zzf();
            }
            int iO = O();
            int i3 = this.c;
            int i4 = iO + i3;
            if (i3 >= i4) {
                M(i4);
                return;
            } else {
                P();
                throw null;
            }
        }
        int i5 = this.f & 7;
        if (i5 == 0) {
            do {
                list.add(Long.valueOf(zzg()));
                if (N()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (O() == this.f);
            this.c = i;
            return;
        }
        if (i5 != 2) {
            throw zzjk.zzf();
        }
        int iO2 = this.c + O();
        while (this.c < iO2) {
            list.add(Long.valueOf(P()));
        }
        M(iO2);
    }

    @Override // defpackage.InterfaceC3249kg0
    public final void z(Map map, Pf0 pf0, zzio zzioVar) throws zzjk {
        I(2);
        int iO = O();
        G(iO);
        int i = this.e;
        this.e = this.c + iO;
        try {
            throw null;
        } catch (Throwable th) {
            this.e = i;
            throw th;
        }
    }

    @Override // defpackage.InterfaceC3249kg0
    public final int zza() throws zzjk {
        if (N()) {
            return Integer.MAX_VALUE;
        }
        int iO = O();
        this.f = iO;
        if (iO == this.g) {
            return Integer.MAX_VALUE;
        }
        return iO >>> 3;
    }

    @Override // defpackage.InterfaceC3249kg0
    public final int zzb() {
        return this.f;
    }

    /* JADX WARN: Code duplicated, block: B:44:0x0076  */
    /* JADX WARN: Code duplicated, block: B:46:0x007c A[LOOP:2: B:43:0x0074->B:46:0x007c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:57:0x007f A[SYNTHETIC] */
    @Override // defpackage.InterfaceC3249kg0
    public final boolean zzc() throws zzjk {
        int i;
        int i2;
        if (N() || (i = this.f) == (i2 = this.g)) {
            return false;
        }
        int i3 = i & 7;
        if (i3 != 0) {
            if (i3 == 1) {
                B(8);
                return true;
            }
            if (i3 == 2) {
                B(O());
                return true;
            }
            if (i3 != 3) {
                if (i3 != 5) {
                    throw zzjk.zzf();
                }
                B(4);
                return true;
            }
            this.g = ((i >>> 3) << 3) | 4;
            while (zza() != Integer.MAX_VALUE && zzc()) {
            }
            if (this.f != this.g) {
                throw zzjk.zzg();
            }
            this.g = i2;
            return true;
        }
        int i4 = this.e;
        int i5 = this.c;
        if (i4 - i5 < 10) {
            for (int i6 = 0; i6 < 10; i6++) {
                if (R() < 0) {
                }
            }
            throw zzjk.zzc();
        }
        byte[] bArr = this.b;
        int i7 = 0;
        while (i7 < 10) {
            int i8 = i5 + 1;
            if (bArr[i5] >= 0) {
                this.c = i8;
            } else {
                i7++;
                i5 = i8;
            }
        }
        while (i6 < 10) {
            if (R() < 0) {
            }
        }
        throw zzjk.zzc();
        return true;
    }

    @Override // defpackage.InterfaceC3249kg0
    public final double zzd() throws zzjn {
        I(1);
        return Double.longBitsToDouble(D());
    }

    @Override // defpackage.InterfaceC3249kg0
    public final float zze() throws zzjn {
        I(5);
        return Float.intBitsToFloat(S());
    }

    @Override // defpackage.InterfaceC3249kg0
    public final long zzf() throws zzjn {
        I(0);
        return P();
    }

    @Override // defpackage.InterfaceC3249kg0
    public final long zzg() throws zzjn {
        I(0);
        return P();
    }

    @Override // defpackage.InterfaceC3249kg0
    public final int zzh() throws zzjn {
        I(0);
        return O();
    }

    @Override // defpackage.InterfaceC3249kg0
    public final long zzi() throws zzjn {
        I(1);
        return D();
    }

    @Override // defpackage.InterfaceC3249kg0
    public final int zzj() throws zzjn {
        I(5);
        return S();
    }

    @Override // defpackage.InterfaceC3249kg0
    public final boolean zzk() throws zzjn {
        I(0);
        return O() != 0;
    }

    @Override // defpackage.InterfaceC3249kg0
    public final String zzm() {
        return A(true);
    }

    @Override // defpackage.InterfaceC3249kg0
    public final int zzp() throws zzjn {
        I(0);
        return O();
    }

    @Override // defpackage.InterfaceC3249kg0
    public final int zzq() throws zzjn {
        I(5);
        return S();
    }

    @Override // defpackage.InterfaceC3249kg0
    public final long zzr() throws zzjn {
        I(1);
        return D();
    }

    @Override // defpackage.InterfaceC3249kg0
    public final int zzs() throws zzjn {
        I(0);
        return zzif.zze(O());
    }

    @Override // defpackage.InterfaceC3249kg0
    public final long zzt() throws zzjn {
        I(0);
        return zzif.zza(P());
    }

    @Override // defpackage.InterfaceC3249kg0
    public final void zzb(List list) throws zzjk {
        int i;
        if (list instanceof AbstractC3899sf0) {
            AbstractC3574of.a(list);
            int i2 = this.f & 7;
            if (i2 != 2) {
                if (i2 != 5) {
                    throw zzjk.zzf();
                }
                zze();
                throw null;
            }
            int iO = O();
            L(iO);
            int i3 = this.c;
            if (i3 >= iO + i3) {
                return;
            }
            Float.intBitsToFloat(E());
            throw null;
        }
        int i4 = this.f & 7;
        if (i4 == 2) {
            int iO2 = O();
            L(iO2);
            int i5 = this.c + iO2;
            while (this.c < i5) {
                list.add(Float.valueOf(Float.intBitsToFloat(E())));
            }
            return;
        }
        if (i4 != 5) {
            throw zzjk.zzf();
        }
        do {
            list.add(Float.valueOf(zze()));
            if (N()) {
                return;
            } else {
                i = this.c;
            }
        } while (O() == this.f);
        this.c = i;
    }
}
