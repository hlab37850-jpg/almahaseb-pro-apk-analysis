package defpackage;

import com.google.common.primitives.UnsignedBytes;

/* JADX INFO: renamed from: pq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3670pq extends C3507nq {
    public short[] f;
    public byte[] g;
    public byte[] h;
    public short[] i;
    public short[] j;

    public void A(short[] sArr) {
        this.j = sArr;
    }

    public boolean B(int i) {
        return (p(i) & 2) != 0;
    }

    public boolean C(int i) {
        return (p(i) & 16) != 0;
    }

    public boolean D(int i) {
        return (p(i) & 4) != 0;
    }

    public boolean E(int i) {
        return (p(i) & 32) != 0;
    }

    @Override // defpackage.C3507nq
    public T8 a() {
        T8 t8A = super.a();
        for (int i = 0; i < h(); i++) {
            t8A.E(o(i));
        }
        t8A.E(r());
        for (int i2 = 0; i2 < r(); i2++) {
            t8A.x(q(i2));
        }
        int i3 = 0;
        while (i3 < s()) {
            byte b = 0;
            while (i3 > 0 && p(i3) == p(i3 - 1)) {
                b = (byte) (b + 1);
                i3++;
            }
            if (b > 0) {
                t8A.x(b);
            } else {
                t8A.x(p(i3));
            }
            i3++;
        }
        for (int i4 = 0; i4 < s(); i4++) {
            if (B(i4)) {
                t8A.x((byte) t(i4));
            } else if (!C(i4)) {
                t8A.E(t(i4));
            }
        }
        for (int i5 = 0; i5 < s(); i5++) {
            if (D(i5)) {
                t8A.x((byte) u(i5));
            } else if (!E(i5)) {
                t8A.E(u(i5));
            }
        }
        return t8A;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x003c  */
    /* JADX WARN: Code duplicated, block: B:19:0x0040  */
    /* JADX WARN: Code duplicated, block: B:21:0x0046  */
    /* JADX WARN: Code duplicated, block: B:33:0x0049 A[SYNTHETIC] */
    @Override // defpackage.C3507nq
    public short c() {
        int i;
        int i2;
        short sC = (short) (((short) (super.c() + (h() * 2))) + r() + 2);
        for (int i3 = 0; i3 < s(); i3++) {
            while (i3 > 0 && p(i3) == p(i3 - 1)) {
            }
            sC = (short) (sC + 1);
        }
        for (int i4 = 0; i4 < s(); i4++) {
            if (B(i4)) {
                i = sC + 1;
            } else {
                if (!C(i4)) {
                    i = sC + 2;
                }
                if (D(i4)) {
                    i2 = sC + 1;
                } else {
                    if (!E(i4)) {
                        i2 = sC + 2;
                    }
                }
                sC = (short) i2;
            }
            sC = (short) i;
            if (D(i4)) {
                i2 = sC + 1;
            } else {
                if (!E(i4)) {
                    i2 = sC + 2;
                }
            }
            sC = (short) i2;
        }
        return sC;
    }

    @Override // defpackage.C3507nq
    public void i(T8 t8) {
        int iH = h();
        short[] sArr = new short[iH];
        for (int i = 0; i < iH; i++) {
            sArr[i] = t8.p();
        }
        w(sArr);
        int iO = o(h() - 1) + 1;
        byte[] bArr = new byte[t8.p()];
        t8.j(bArr);
        y(bArr);
        byte[] bArr2 = new byte[iO];
        int i2 = 0;
        while (i2 < iO) {
            byte bH = t8.h();
            bArr2[i2] = bH;
            if ((bH & 8) != 0) {
                int iH2 = t8.h() & UnsignedBytes.MAX_VALUE;
                for (int i3 = 0; i3 < iH2; i3++) {
                    i2++;
                    bArr2[i2] = bH;
                }
            }
            i2++;
        }
        x(bArr2);
        short[] sArr2 = new short[iO];
        for (int i4 = 0; i4 < iO; i4++) {
            if (i4 > 0) {
                sArr2[i4] = sArr2[i4 - 1];
            }
            if (B(i4)) {
                int iH3 = t8.h() & UnsignedBytes.MAX_VALUE;
                if (!C(i4)) {
                    iH3 = -iH3;
                }
                sArr2[i4] = (short) (sArr2[i4] + iH3);
            } else if (!C(i4)) {
                sArr2[i4] = (short) (sArr2[i4] + t8.p());
            }
        }
        z(sArr2);
        short[] sArr3 = new short[iO];
        for (int i5 = 0; i5 < iO; i5++) {
            if (i5 > 0) {
                sArr3[i5] = sArr3[i5 - 1];
            }
            if (D(i5)) {
                int iH4 = t8.h() & UnsignedBytes.MAX_VALUE;
                if (!E(i5)) {
                    iH4 = -iH4;
                }
                sArr3[i5] = (short) (sArr3[i5] + iH4);
            } else if (!E(i5)) {
                sArr3[i5] = (short) (sArr3[i5] + t8.p());
            }
        }
        A(sArr3);
    }

    public short o(int i) {
        return this.f[i];
    }

    public byte p(int i) {
        return this.h[i];
    }

    public byte q(int i) {
        return this.g[i];
    }

    public short r() {
        return (short) this.g.length;
    }

    public short s() {
        return (short) this.h.length;
    }

    public short t(int i) {
        return this.i[i];
    }

    public short u(int i) {
        return this.j[i];
    }

    public boolean v(int i) {
        return (p(i) & 1) != 0;
    }

    public void w(short[] sArr) {
        this.f = sArr;
    }

    public void x(byte[] bArr) {
        this.h = bArr;
    }

    public void y(byte[] bArr) {
        this.g = bArr;
    }

    public void z(short[] sArr) {
        this.i = sArr;
    }
}
