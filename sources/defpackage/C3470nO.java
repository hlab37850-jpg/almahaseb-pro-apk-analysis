package defpackage;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: renamed from: nO, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3470nO extends W8 {
    public final transient byte[][] f;
    public final transient int[] g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3470nO(byte[][] bArr, int[] iArr) {
        super(W8.e.f());
        AbstractC4492zt.h(bArr, "segments");
        AbstractC4492zt.h(iArr, "directory");
        this.f = bArr;
        this.g = iArr;
    }

    public final int[] A() {
        return this.g;
    }

    public final byte[][] B() {
        return this.f;
    }

    public final W8 C() {
        return new W8(x());
    }

    @Override // defpackage.W8
    public String a() {
        return C().a();
    }

    @Override // defpackage.W8
    public W8 c(String str) throws NoSuchAlgorithmException {
        AbstractC4492zt.h(str, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        int length = B().length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = A()[length + i];
            int i4 = A()[i];
            messageDigest.update(B()[i], i3, i4 - i2);
            i++;
            i2 = i4;
        }
        byte[] bArrDigest = messageDigest.digest();
        AbstractC4492zt.e(bArrDigest);
        return new W8(bArrDigest);
    }

    @Override // defpackage.W8
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof W8) {
            W8 w8 = (W8) obj;
            if (w8.u() == u() && o(0, w8, 0, u())) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.W8
    public int hashCode() {
        int iH = h();
        if (iH != 0) {
            return iH;
        }
        int length = B().length;
        int i = 0;
        int i2 = 1;
        int i3 = 0;
        while (i < length) {
            int i4 = A()[length + i];
            int i5 = A()[i];
            byte[] bArr = B()[i];
            int i6 = (i5 - i3) + i4;
            while (i4 < i6) {
                i2 = (i2 * 31) + bArr[i4];
                i4++;
            }
            i++;
            i3 = i5;
        }
        q(i2);
        return i2;
    }

    @Override // defpackage.W8
    public int i() {
        return A()[B().length - 1];
    }

    @Override // defpackage.W8
    public String k() {
        return C().k();
    }

    @Override // defpackage.W8
    public byte[] l() {
        return x();
    }

    @Override // defpackage.W8
    public byte m(int i) {
        AbstractC2074e.b(A()[B().length - 1], i, 1L);
        int iB = AbstractC1993d.b(this, i);
        return B()[iB][(i - (iB == 0 ? 0 : A()[iB - 1])) + A()[B().length + iB]];
    }

    @Override // defpackage.W8
    public boolean o(int i, W8 w8, int i2, int i3) {
        AbstractC4492zt.h(w8, "other");
        if (i < 0 || i > u() - i3) {
            return false;
        }
        int i4 = i3 + i;
        int iB = AbstractC1993d.b(this, i);
        while (i < i4) {
            int i5 = iB == 0 ? 0 : A()[iB - 1];
            int i6 = A()[iB] - i5;
            int i7 = A()[B().length + iB];
            int iMin = Math.min(i4, i6 + i5) - i;
            if (!w8.p(i2, B()[iB], i7 + (i - i5), iMin)) {
                return false;
            }
            i2 += iMin;
            i += iMin;
            iB++;
        }
        return true;
    }

    @Override // defpackage.W8
    public boolean p(int i, byte[] bArr, int i2, int i3) {
        AbstractC4492zt.h(bArr, "other");
        if (i < 0 || i > u() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int i4 = i3 + i;
        int iB = AbstractC1993d.b(this, i);
        while (i < i4) {
            int i5 = iB == 0 ? 0 : A()[iB - 1];
            int i6 = A()[iB] - i5;
            int i7 = A()[B().length + iB];
            int iMin = Math.min(i4, i6 + i5) - i;
            if (!AbstractC2074e.a(B()[iB], i7 + (i - i5), bArr, i2, iMin)) {
                return false;
            }
            i2 += iMin;
            i += iMin;
            iB++;
        }
        return true;
    }

    @Override // defpackage.W8
    public String toString() {
        return C().toString();
    }

    @Override // defpackage.W8
    public W8 w() {
        return C().w();
    }

    @Override // defpackage.W8
    public byte[] x() {
        byte[] bArr = new byte[u()];
        int length = B().length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            int i4 = A()[length + i];
            int i5 = A()[i];
            int i6 = i5 - i2;
            Q5.d(B()[i], bArr, i3, i4, i4 + i6);
            i3 += i6;
            i++;
            i2 = i5;
        }
        return bArr;
    }

    @Override // defpackage.W8
    public void z(H8 h8, int i, int i2) {
        AbstractC4492zt.h(h8, "buffer");
        int i3 = i + i2;
        int iB = AbstractC1993d.b(this, i);
        while (i < i3) {
            int i4 = iB == 0 ? 0 : A()[iB - 1];
            int i5 = A()[iB] - i4;
            int i6 = A()[B().length + iB];
            int iMin = Math.min(i3, i5 + i4) - i;
            int i7 = i6 + (i - i4);
            C3306lO c3306lO = new C3306lO(B()[iB], i7, i7 + iMin, true, false);
            C3306lO c3306lO2 = h8.a;
            if (c3306lO2 == null) {
                c3306lO.g = c3306lO;
                c3306lO.f = c3306lO;
                h8.a = c3306lO;
            } else {
                AbstractC4492zt.e(c3306lO2);
                C3306lO c3306lO3 = c3306lO2.g;
                AbstractC4492zt.e(c3306lO3);
                c3306lO3.c(c3306lO);
            }
            i += iMin;
            iB++;
        }
        h8.Q(h8.R() + ((long) i2));
    }
}
