package defpackage;

import com.fasterxml.jackson.core.a;
import com.itextpdf.text.pdf.Barcode128;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class VZ extends AbstractC4240wu {
    public static final char[] v = AbstractC3484nb.d();
    public final Writer k;
    public char[] l;
    public int n;
    public int p;
    public int q;
    public char[] t;
    public IO u;

    public VZ(C0918Sr c0918Sr, int i, AbstractC2263gE abstractC2263gE, Writer writer) {
        super(c0918Sr, i, abstractC2263gE);
        this.n = 0;
        this.p = 0;
        this.k = writer;
        char[] cArrA = c0918Sr.a();
        this.l = cArrA;
        this.q = cArrA.length;
    }

    private void d0(String str) throws IOException {
        W();
        int length = str.length();
        int i = 0;
        while (true) {
            int i2 = this.q;
            if (i + i2 > length) {
                i2 = length - i;
            }
            int i3 = i + i2;
            str.getChars(i, i3, this.l, 0);
            int i4 = this.h;
            if (i4 != 0) {
                k0(i2, i4);
            } else {
                j0(i2);
            }
            if (i3 >= length) {
                return;
            } else {
                i = i3;
            }
        }
    }

    private void e0() throws IOException {
        if (this.p + 4 >= this.q) {
            W();
        }
        int i = this.p;
        char[] cArr = this.l;
        cArr[i] = 'n';
        cArr[i + 1] = 'u';
        cArr[i + 2] = 'l';
        cArr[i + 3] = 'l';
        this.p = i + 4;
    }

    private void g0(int i) throws IOException {
        if (this.p + 13 >= this.q) {
            W();
        }
        char[] cArr = this.l;
        int i2 = this.p;
        int i3 = i2 + 1;
        this.p = i3;
        cArr[i2] = '\"';
        int iE = AbstractC1860cE.e(i, cArr, i3);
        char[] cArr2 = this.l;
        this.p = iE + 1;
        cArr2[iE] = '\"';
    }

    private void h0(long j) throws IOException {
        if (this.p + 23 >= this.q) {
            W();
        }
        char[] cArr = this.l;
        int i = this.p;
        int i2 = i + 1;
        this.p = i2;
        cArr[i] = '\"';
        int i3 = AbstractC1860cE.i(j, cArr, i2);
        char[] cArr2 = this.l;
        this.p = i3 + 1;
        cArr2[i3] = '\"';
    }

    private void i0(Object obj) throws IOException {
        if (this.p >= this.q) {
            W();
        }
        char[] cArr = this.l;
        int i = this.p;
        this.p = i + 1;
        cArr[i] = '\"';
        K(obj.toString());
        if (this.p >= this.q) {
            W();
        }
        char[] cArr2 = this.l;
        int i2 = this.p;
        this.p = i2 + 1;
        cArr2[i2] = '\"';
    }

    @Override // com.fasterxml.jackson.core.a
    public void A(int i) throws IOException {
        b0("write number");
        if (this.c) {
            g0(i);
            return;
        }
        if (this.p + 11 >= this.q) {
            W();
        }
        this.p = AbstractC1860cE.e(i, this.l, this.p);
    }

    @Override // com.fasterxml.jackson.core.a
    public void C(long j) throws IOException {
        b0("write number");
        if (this.c) {
            h0(j);
            return;
        }
        if (this.p + 21 >= this.q) {
            W();
        }
        this.p = AbstractC1860cE.i(j, this.l, this.p);
    }

    @Override // com.fasterxml.jackson.core.a
    public void F(String str) throws IOException {
        b0("write number");
        if (this.c) {
            i0(str);
        } else {
            K(str);
        }
    }

    @Override // com.fasterxml.jackson.core.a
    public void G(BigDecimal bigDecimal) throws IOException {
        b0("write number");
        if (bigDecimal == null) {
            e0();
        } else if (this.c) {
            i0(bigDecimal);
        } else {
            K(bigDecimal.toString());
        }
    }

    @Override // com.fasterxml.jackson.core.a
    public void H(BigInteger bigInteger) throws IOException {
        b0("write number");
        if (bigInteger == null) {
            e0();
        } else if (this.c) {
            i0(bigInteger);
        } else {
            K(bigInteger.toString());
        }
    }

    @Override // com.fasterxml.jackson.core.a
    public void I(char c) throws IOException {
        if (this.p >= this.q) {
            W();
        }
        char[] cArr = this.l;
        int i = this.p;
        this.p = i + 1;
        cArr[i] = c;
    }

    @Override // com.fasterxml.jackson.core.a
    public void J(IO io) throws IOException {
        K(io.getValue());
    }

    @Override // com.fasterxml.jackson.core.a
    public void K(String str) throws IOException {
        int length = str.length();
        int i = this.q - this.p;
        if (i == 0) {
            W();
            i = this.q - this.p;
        }
        if (i < length) {
            o0(str);
        } else {
            str.getChars(0, length, this.l, this.p);
            this.p += length;
        }
    }

    @Override // com.fasterxml.jackson.core.a
    public void L(char[] cArr, int i, int i2) throws IOException {
        if (i2 >= 32) {
            W();
            this.k.write(cArr, i, i2);
        } else {
            if (i2 > this.q - this.p) {
                W();
            }
            System.arraycopy(cArr, i, this.l, this.p, i2);
            this.p += i2;
        }
    }

    @Override // com.fasterxml.jackson.core.a
    public void M() throws IOException {
        b0("start an array");
        this.d = this.d.h();
        KH kh = this.a;
        if (kh != null) {
            kh.h(this);
            return;
        }
        if (this.p >= this.q) {
            W();
        }
        char[] cArr = this.l;
        int i = this.p;
        this.p = i + 1;
        cArr[i] = '[';
    }

    @Override // com.fasterxml.jackson.core.a
    public void N() throws IOException {
        b0("start an object");
        this.d = this.d.i();
        KH kh = this.a;
        if (kh != null) {
            kh.a(this);
            return;
        }
        if (this.p >= this.q) {
            W();
        }
        char[] cArr = this.l;
        int i = this.p;
        this.p = i + 1;
        cArr[i] = '{';
    }

    @Override // com.fasterxml.jackson.core.a
    public void O(String str) throws IOException {
        b0("write text value");
        if (str == null) {
            e0();
            return;
        }
        if (this.p >= this.q) {
            W();
        }
        char[] cArr = this.l;
        int i = this.p;
        this.p = i + 1;
        cArr[i] = '\"';
        l0(str);
        if (this.p >= this.q) {
            W();
        }
        char[] cArr2 = this.l;
        int i2 = this.p;
        this.p = i2 + 1;
        cArr2[i2] = '\"';
    }

    public final char[] V() {
        char[] cArr = {'\\', 0, '\\', 'u', '0', '0', 0, 0, '\\', 'u', 0, 0, 0, 0};
        this.t = cArr;
        return cArr;
    }

    public void W() throws IOException {
        int i = this.p;
        int i2 = this.n;
        int i3 = i - i2;
        if (i3 > 0) {
            this.n = 0;
            this.p = 0;
            this.k.write(this.l, i2, i3);
        }
    }

    public final int X(char[] cArr, int i, int i2, char c, int i3) throws IOException {
        int i4;
        if (i3 >= 0) {
            if (i > 1 && i < i2) {
                int i5 = i - 2;
                cArr[i5] = '\\';
                cArr[i - 1] = (char) i3;
                return i5;
            }
            char[] cArrV = this.t;
            if (cArrV == null) {
                cArrV = V();
            }
            cArrV[1] = (char) i3;
            this.k.write(cArrV, 0, 2);
            return i;
        }
        if (i3 == -2) {
            this.u.getClass();
            String value = this.u.getValue();
            this.u = null;
            int length = value.length();
            if (i < length || i >= i2) {
                this.k.write(value);
                return i;
            }
            int i6 = i - length;
            value.getChars(0, length, cArr, i6);
            return i6;
        }
        if (i <= 5 || i >= i2) {
            char[] cArrV2 = this.t;
            if (cArrV2 == null) {
                cArrV2 = V();
            }
            this.n = this.p;
            if (c <= 255) {
                char[] cArr2 = v;
                cArrV2[6] = cArr2[c >> 4];
                cArrV2[7] = cArr2[c & 15];
                this.k.write(cArrV2, 2, 6);
                return i;
            }
            int i7 = c >> '\b';
            char[] cArr3 = v;
            cArrV2[10] = cArr3[(i7 & 255) >> 4];
            cArrV2[11] = cArr3[i7 & 15];
            cArrV2[12] = cArr3[(c & 255) >> 4];
            cArrV2[13] = cArr3[c & 15];
            this.k.write(cArrV2, 8, 6);
            return i;
        }
        cArr[i - 6] = '\\';
        int i8 = i - 4;
        cArr[i - 5] = 'u';
        if (c > 255) {
            int i9 = c >> '\b';
            int i10 = i - 3;
            char[] cArr4 = v;
            cArr[i8] = cArr4[(i9 & 255) >> 4];
            i4 = i - 2;
            cArr[i10] = cArr4[i9 & 15];
            c = (char) (c & 255);
        } else {
            int i11 = i - 3;
            cArr[i8] = '0';
            i4 = i - 2;
            cArr[i11] = '0';
        }
        char[] cArr5 = v;
        cArr[i4] = cArr5[c >> 4];
        cArr[i4 + 1] = cArr5[c & 15];
        return i4 - 4;
    }

    public final void Y(char c, int i) throws IOException {
        int i2;
        if (i >= 0) {
            int i3 = this.p;
            if (i3 >= 2) {
                int i4 = i3 - 2;
                this.n = i4;
                char[] cArr = this.l;
                cArr[i4] = '\\';
                cArr[i3 - 1] = (char) i;
                return;
            }
            char[] cArrV = this.t;
            if (cArrV == null) {
                cArrV = V();
            }
            this.n = this.p;
            cArrV[1] = (char) i;
            this.k.write(cArrV, 0, 2);
            return;
        }
        if (i == -2) {
            this.u.getClass();
            String value = this.u.getValue();
            this.u = null;
            int length = value.length();
            int i5 = this.p;
            if (i5 < length) {
                this.n = i5;
                this.k.write(value);
                return;
            } else {
                int i6 = i5 - length;
                this.n = i6;
                value.getChars(0, length, this.l, i6);
                return;
            }
        }
        int i7 = this.p;
        if (i7 < 6) {
            char[] cArrV2 = this.t;
            if (cArrV2 == null) {
                cArrV2 = V();
            }
            this.n = this.p;
            if (c <= 255) {
                char[] cArr2 = v;
                cArrV2[6] = cArr2[c >> 4];
                cArrV2[7] = cArr2[c & 15];
                this.k.write(cArrV2, 2, 6);
                return;
            }
            int i8 = c >> '\b';
            char[] cArr3 = v;
            cArrV2[10] = cArr3[(i8 & 255) >> 4];
            cArrV2[11] = cArr3[i8 & 15];
            cArrV2[12] = cArr3[(c & 255) >> 4];
            cArrV2[13] = cArr3[c & 15];
            this.k.write(cArrV2, 8, 6);
            return;
        }
        char[] cArr4 = this.l;
        int i9 = i7 - 6;
        this.n = i9;
        cArr4[i9] = '\\';
        cArr4[i7 - 5] = 'u';
        if (c > 255) {
            int i10 = c >> '\b';
            char[] cArr5 = v;
            cArr4[i7 - 4] = cArr5[(i10 & 255) >> 4];
            i2 = i7 - 3;
            cArr4[i2] = cArr5[i10 & 15];
            c = (char) (c & 255);
        } else {
            cArr4[i7 - 4] = '0';
            i2 = i7 - 3;
            cArr4[i2] = '0';
        }
        char[] cArr6 = v;
        cArr4[i2 + 1] = cArr6[c >> 4];
        cArr4[i2 + 2] = cArr6[c & 15];
    }

    public void Z() {
        char[] cArr = this.l;
        if (cArr != null) {
            this.l = null;
            this.f.i(cArr);
        }
    }

    public void a0(String str, int i) {
        if (i == 0) {
            if (this.d.d()) {
                this.a.i(this);
                return;
            } else {
                if (this.d.e()) {
                    this.a.e(this);
                    return;
                }
                return;
            }
        }
        if (i == 1) {
            this.a.c(this);
            return;
        }
        if (i == 2) {
            this.a.l(this);
        } else if (i != 3) {
            P();
        } else {
            this.a.b(this);
        }
    }

    public void b0(String str) throws IOException {
        char c;
        IO io;
        int iN = this.d.n();
        if (iN == 5) {
            Q("Can not " + str + ", expecting field name");
        }
        if (this.a != null) {
            a0(str, iN);
            return;
        }
        if (iN == 1) {
            c = ',';
        } else {
            if (iN != 2) {
                if (iN == 3 && (io = this.i) != null) {
                    K(io.getValue());
                    return;
                }
                return;
            }
            c = ':';
        }
        if (this.p >= this.q) {
            W();
        }
        char[] cArr = this.l;
        int i = this.p;
        cArr[i] = c;
        this.p = i + 1;
    }

    public void c0(String str, boolean z) throws IOException {
        if (this.a != null) {
            f0(str, z);
            return;
        }
        if (this.p + 1 >= this.q) {
            W();
        }
        if (z) {
            char[] cArr = this.l;
            int i = this.p;
            this.p = i + 1;
            cArr[i] = ',';
        }
        if (!S(a.EnumC0168a.QUOTE_FIELD_NAMES)) {
            l0(str);
            return;
        }
        char[] cArr2 = this.l;
        int i2 = this.p;
        this.p = i2 + 1;
        cArr2[i2] = '\"';
        l0(str);
        if (this.p >= this.q) {
            W();
        }
        char[] cArr3 = this.l;
        int i3 = this.p;
        this.p = i3 + 1;
        cArr3[i3] = '\"';
    }

    @Override // defpackage.AbstractC2228fq, com.fasterxml.jackson.core.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        if (this.l != null && S(a.EnumC0168a.AUTO_CLOSE_JSON_CONTENT)) {
            while (true) {
                C0531Fu c0531FuR = R();
                if (!c0531FuR.d()) {
                    if (!c0531FuR.e()) {
                        break;
                    } else {
                        t();
                    }
                } else {
                    r();
                }
            }
        }
        W();
        if (this.k != null) {
            if (this.f.h() || S(a.EnumC0168a.AUTO_CLOSE_TARGET)) {
                this.k.close();
            } else if (S(a.EnumC0168a.FLUSH_PASSED_TO_STREAM)) {
                this.k.flush();
            }
        }
        Z();
    }

    public void f0(String str, boolean z) throws IOException {
        if (z) {
            this.a.j(this);
        } else {
            this.a.e(this);
        }
        if (!S(a.EnumC0168a.QUOTE_FIELD_NAMES)) {
            l0(str);
            return;
        }
        if (this.p >= this.q) {
            W();
        }
        char[] cArr = this.l;
        int i = this.p;
        this.p = i + 1;
        cArr[i] = '\"';
        l0(str);
        if (this.p >= this.q) {
            W();
        }
        char[] cArr2 = this.l;
        int i2 = this.p;
        this.p = i2 + 1;
        cArr2[i2] = '\"';
    }

    @Override // com.fasterxml.jackson.core.a, java.io.Flushable
    public void flush() throws IOException {
        W();
        if (this.k == null || !S(a.EnumC0168a.FLUSH_PASSED_TO_STREAM)) {
            return;
        }
        this.k.flush();
    }

    @Override // com.fasterxml.jackson.core.a
    public void i(boolean z) throws IOException {
        int i;
        b0("write boolean value");
        if (this.p + 5 >= this.q) {
            W();
        }
        int i2 = this.p;
        char[] cArr = this.l;
        if (z) {
            cArr[i2] = 't';
            cArr[i2 + 1] = 'r';
            cArr[i2 + 2] = 'u';
            i = i2 + 3;
            cArr[i] = Barcode128.CODE_BC_TO_A;
        } else {
            cArr[i2] = Barcode128.FNC1_INDEX;
            cArr[i2 + 1] = 'a';
            cArr[i2 + 2] = 'l';
            cArr[i2 + 3] = 's';
            i = i2 + 4;
            cArr[i] = Barcode128.CODE_BC_TO_A;
        }
        this.p = i + 1;
    }

    public final void j0(int i) throws IOException {
        char[] cArr;
        char c;
        int[] iArr = this.g;
        int length = iArr.length;
        int i2 = 0;
        int iX = 0;
        while (i2 < i) {
            do {
                cArr = this.l;
                c = cArr[i2];
                if (c < length && iArr[c] != 0) {
                    break;
                } else {
                    i2++;
                }
            } while (i2 < i);
            int i3 = i2 - iX;
            if (i3 > 0) {
                this.k.write(cArr, iX, i3);
                if (i2 >= i) {
                    return;
                }
            }
            i2++;
            iX = X(this.l, i2, i, c, iArr[c]);
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001d A[PHI: r4
      0x001d: PHI (r4v5 int) = (r4v2 int), (r4v6 int) binds: [B:9:0x0019, B:7:0x0016] A[DONT_GENERATE, DONT_INLINE]] */
    public final void k0(int i, int i2) throws IOException {
        char[] cArr;
        char c;
        int[] iArr = this.g;
        int iMin = Math.min(iArr.length, i2 + 1);
        int i3 = 0;
        int iX = 0;
        int i4 = 0;
        while (i3 < i) {
            do {
                cArr = this.l;
                c = cArr[i3];
                if (c < iMin) {
                    i4 = iArr[c];
                    if (i4 != 0) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    if (c > i2) {
                        i4 = -1;
                        break;
                    }
                    i3++;
                }
            } while (i3 < i);
            int i5 = i3 - iX;
            if (i5 > 0) {
                this.k.write(cArr, iX, i5);
                if (i3 >= i) {
                    return;
                }
            }
            i3++;
            iX = X(this.l, i3, i, c, i4);
        }
    }

    public final void l0(String str) throws IOException {
        int length = str.length();
        int i = this.q;
        if (length > i) {
            d0(str);
            return;
        }
        if (this.p + length > i) {
            W();
        }
        str.getChars(0, length, this.l, this.p);
        int i2 = this.h;
        if (i2 != 0) {
            n0(length, i2);
        } else {
            m0(length);
        }
    }

    public final void m0(int i) throws IOException {
        int i2;
        int i3 = this.p + i;
        int[] iArr = this.g;
        int length = iArr.length;
        while (this.p < i3) {
            do {
                char[] cArr = this.l;
                int i4 = this.p;
                char c = cArr[i4];
                if (c >= length || iArr[c] == 0) {
                    i2 = i4 + 1;
                    this.p = i2;
                } else {
                    int i5 = this.n;
                    int i6 = i4 - i5;
                    if (i6 > 0) {
                        this.k.write(cArr, i5, i6);
                    }
                    char[] cArr2 = this.l;
                    int i7 = this.p;
                    this.p = i7 + 1;
                    char c2 = cArr2[i7];
                    Y(c2, iArr[c2]);
                }
            } while (i2 < i3);
            return;
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0025  */
    /* JADX WARN: Code duplicated, block: B:22:0x002a A[SYNTHETIC] */
    public final void n0(int i, int i2) throws IOException {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = this.p + i;
        int[] iArr = this.g;
        int iMin = Math.min(iArr.length, i2 + 1);
        while (this.p < i7) {
            do {
                char[] cArr = this.l;
                int i8 = this.p;
                char c = cArr[i8];
                if (c < iMin) {
                    i3 = iArr[c];
                    if (i3 != 0) {
                        i4 = this.n;
                        i5 = i8 - i4;
                        if (i5 > 0) {
                            this.k.write(cArr, i4, i5);
                        }
                        this.p++;
                        Y(c, i3);
                    }
                    i6 = i8 + 1;
                    this.p = i6;
                } else {
                    if (c > i2) {
                        i3 = -1;
                        i4 = this.n;
                        i5 = i8 - i4;
                        if (i5 > 0) {
                            this.k.write(cArr, i4, i5);
                        }
                        this.p++;
                        Y(c, i3);
                    }
                    i6 = i8 + 1;
                    this.p = i6;
                }
            } while (i6 < i7);
            return;
        }
    }

    public final void o0(String str) throws IOException {
        int i = this.q;
        int i2 = this.p;
        int i3 = i - i2;
        str.getChars(0, i3, this.l, i2);
        this.p += i3;
        W();
        int length = str.length() - i3;
        while (true) {
            int i4 = this.q;
            if (length <= i4) {
                str.getChars(i3, i3 + length, this.l, 0);
                this.n = 0;
                this.p = length;
                return;
            } else {
                int i5 = i3 + i4;
                str.getChars(i3, i5, this.l, 0);
                this.n = 0;
                this.p = i4;
                W();
                length -= i4;
                i3 = i5;
            }
        }
    }

    @Override // com.fasterxml.jackson.core.a
    public void r() throws IOException {
        if (!this.d.d()) {
            Q("Current context not an ARRAY but " + this.d.c());
        }
        KH kh = this.a;
        if (kh != null) {
            kh.k(this, this.d.b());
        } else {
            if (this.p >= this.q) {
                W();
            }
            char[] cArr = this.l;
            int i = this.p;
            this.p = i + 1;
            cArr[i] = ']';
        }
        this.d = this.d.k();
    }

    @Override // com.fasterxml.jackson.core.a
    public void t() throws IOException {
        if (!this.d.e()) {
            Q("Current context not an object but " + this.d.c());
        }
        KH kh = this.a;
        if (kh != null) {
            kh.f(this, this.d.b());
        } else {
            if (this.p >= this.q) {
                W();
            }
            char[] cArr = this.l;
            int i = this.p;
            this.p = i + 1;
            cArr[i] = '}';
        }
        this.d = this.d.k();
    }

    @Override // com.fasterxml.jackson.core.a
    public void u(String str) throws IOException {
        int iM = this.d.m(str);
        if (iM == 4) {
            Q("Can not write a field name, expecting a value");
        }
        c0(str, iM == 1);
    }

    @Override // com.fasterxml.jackson.core.a
    public void v() throws IOException {
        b0("write null value");
        e0();
    }

    @Override // com.fasterxml.jackson.core.a
    public void x(double d) throws IOException {
        if (this.c || ((Double.isNaN(d) || Double.isInfinite(d)) && S(a.EnumC0168a.QUOTE_NON_NUMERIC_NUMBERS))) {
            O(String.valueOf(d));
        } else {
            b0("write number");
            K(String.valueOf(d));
        }
    }

    @Override // com.fasterxml.jackson.core.a
    public void z(float f) throws IOException {
        if (this.c || ((Float.isNaN(f) || Float.isInfinite(f)) && S(a.EnumC0168a.QUOTE_NON_NUMERIC_NUMBERS))) {
            O(String.valueOf(f));
        } else {
            b0("write number");
            K(String.valueOf(f));
        }
    }
}
