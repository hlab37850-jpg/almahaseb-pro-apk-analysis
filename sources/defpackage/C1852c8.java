package defpackage;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.Version;

/* JADX INFO: renamed from: c8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1852c8 {
    public final BitMatrix a;
    public Version b;
    public C0724Ln c;
    public boolean d;

    public C1852c8(BitMatrix bitMatrix) throws FormatException {
        int height = bitMatrix.getHeight();
        if (height < 21 || (height & 3) != 1) {
            throw FormatException.getFormatInstance();
        }
        this.a = bitMatrix;
    }

    public final int a(int i, int i2, int i3) {
        return this.d ? this.a.get(i2, i) : this.a.get(i, i2) ? (i3 << 1) | 1 : i3 << 1;
    }

    public void b() {
        int i = 0;
        while (i < this.a.getWidth()) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < this.a.getHeight(); i3++) {
                if (this.a.get(i, i3) != this.a.get(i3, i)) {
                    this.a.flip(i3, i);
                    this.a.flip(i, i3);
                }
            }
            i = i2;
        }
    }

    public byte[] c() throws FormatException {
        C0724Ln c0724LnD = d();
        Version versionE = e();
        EnumC4388yh enumC4388yh = EnumC4388yh.values()[c0724LnD.c()];
        int height = this.a.getHeight();
        enumC4388yh.b(this.a, height);
        BitMatrix bitMatrixBuildFunctionPattern = versionE.buildFunctionPattern();
        byte[] bArr = new byte[versionE.getTotalCodewords()];
        int i = height - 1;
        boolean z = true;
        int i2 = i;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i2 > 0) {
            if (i2 == 6) {
                i2--;
            }
            for (int i6 = 0; i6 < height; i6++) {
                int i7 = z ? i - i6 : i6;
                for (int i8 = 0; i8 < 2; i8++) {
                    int i9 = i2 - i8;
                    if (!bitMatrixBuildFunctionPattern.get(i9, i7)) {
                        i4++;
                        i5 <<= 1;
                        if (this.a.get(i9, i7)) {
                            i5 |= 1;
                        }
                        if (i4 == 8) {
                            bArr[i3] = (byte) i5;
                            i3++;
                            i4 = 0;
                            i5 = 0;
                        }
                    }
                }
            }
            z = !z;
            i2 -= 2;
        }
        if (i3 == versionE.getTotalCodewords()) {
            return bArr;
        }
        throw FormatException.getFormatInstance();
    }

    public C0724Ln d() throws FormatException {
        C0724Ln c0724Ln = this.c;
        if (c0724Ln != null) {
            return c0724Ln;
        }
        int iA = 0;
        int iA2 = 0;
        for (int i = 0; i < 6; i++) {
            iA2 = a(i, 8, iA2);
        }
        int iA3 = a(8, 7, a(8, 8, a(7, 8, iA2)));
        for (int i2 = 5; i2 >= 0; i2--) {
            iA3 = a(8, i2, iA3);
        }
        int height = this.a.getHeight();
        int i3 = height - 7;
        for (int i4 = height - 1; i4 >= i3; i4--) {
            iA = a(8, i4, iA);
        }
        for (int i5 = height - 8; i5 < height; i5++) {
            iA = a(i5, 8, iA);
        }
        C0724Ln c0724LnA = C0724Ln.a(iA3, iA);
        this.c = c0724LnA;
        if (c0724LnA != null) {
            return c0724LnA;
        }
        throw FormatException.getFormatInstance();
    }

    public Version e() throws FormatException {
        Version version = this.b;
        if (version != null) {
            return version;
        }
        int height = this.a.getHeight();
        int i = (height - 17) / 4;
        if (i <= 6) {
            return Version.getVersionForNumber(i);
        }
        int i2 = height - 11;
        int iA = 0;
        int iA2 = 0;
        for (int i3 = 5; i3 >= 0; i3--) {
            for (int i4 = height - 9; i4 >= i2; i4--) {
                iA2 = a(i4, i3, iA2);
            }
        }
        Version versionDecodeVersionInformation = Version.decodeVersionInformation(iA2);
        if (versionDecodeVersionInformation != null && versionDecodeVersionInformation.getDimensionForVersion() == height) {
            this.b = versionDecodeVersionInformation;
            return versionDecodeVersionInformation;
        }
        for (int i5 = 5; i5 >= 0; i5--) {
            for (int i6 = height - 9; i6 >= i2; i6--) {
                iA = a(i5, i6, iA);
            }
        }
        Version versionDecodeVersionInformation2 = Version.decodeVersionInformation(iA);
        if (versionDecodeVersionInformation2 == null || versionDecodeVersionInformation2.getDimensionForVersion() != height) {
            throw FormatException.getFormatInstance();
        }
        this.b = versionDecodeVersionInformation2;
        return versionDecodeVersionInformation2;
    }

    public void f() {
        if (this.c == null) {
            return;
        }
        EnumC4388yh.values()[this.c.c()].b(this.a, this.a.getHeight());
    }

    public void g(boolean z) {
        this.b = null;
        this.c = null;
        this.d = z;
    }
}
