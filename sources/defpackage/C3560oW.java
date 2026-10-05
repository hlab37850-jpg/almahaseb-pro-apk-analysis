package defpackage;

import com.fasterxml.jackson.core.a;
import com.itextpdf.text.pdf.ByteBuffer;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.apache.poi.hssf.record.formula.Ref3DPtg;
import org.apache.poi.hssf.record.formula.RefNPtg;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: renamed from: oW, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C3560oW extends AbstractC4240wu {
    public static final byte[] w = AbstractC3484nb.c();
    public static final byte[] x = {110, 117, 108, 108};
    public static final byte[] y = {116, 114, 117, 101};
    public static final byte[] z = {102, 97, 108, 115, 101};
    public final OutputStream k;
    public byte[] l;
    public int n;
    public final int p;
    public final int q;
    public char[] t;
    public final int u;
    public boolean v;

    public C3560oW(C0918Sr c0918Sr, int i, AbstractC2263gE abstractC2263gE, OutputStream outputStream) {
        super(c0918Sr, i, abstractC2263gE);
        this.n = 0;
        this.k = outputStream;
        this.v = true;
        byte[] bArrD = c0918Sr.d();
        this.l = bArrD;
        int length = bArrD.length;
        this.p = length;
        this.q = length >> 3;
        char[] cArrA = c0918Sr.a();
        this.t = cArrA;
        this.u = cArrA.length;
        if (S(a.EnumC0168a.ESCAPE_NON_ASCII)) {
            T(ShapeTypes.VERTICAL_SCROLL);
        }
    }

    @Override // com.fasterxml.jackson.core.a
    public void A(int i) throws IOException {
        c0("write number");
        if (this.n + 11 >= this.p) {
            W();
        }
        if (this.c) {
            k0(i);
        } else {
            this.n = AbstractC1860cE.d(i, this.l, this.n);
        }
    }

    @Override // com.fasterxml.jackson.core.a
    public void C(long j) throws IOException {
        c0("write number");
        if (this.c) {
            l0(j);
            return;
        }
        if (this.n + 21 >= this.p) {
            W();
        }
        this.n = AbstractC1860cE.h(j, this.l, this.n);
    }

    @Override // com.fasterxml.jackson.core.a
    public void F(String str) throws IOException {
        c0("write number");
        if (this.c) {
            m0(str);
        } else {
            K(str);
        }
    }

    @Override // com.fasterxml.jackson.core.a
    public void G(BigDecimal bigDecimal) throws IOException {
        c0("write number");
        if (bigDecimal == null) {
            i0();
        } else if (this.c) {
            m0(bigDecimal);
        } else {
            K(bigDecimal.toString());
        }
    }

    @Override // com.fasterxml.jackson.core.a
    public void H(BigInteger bigInteger) throws IOException {
        c0("write number");
        if (bigInteger == null) {
            i0();
        } else if (this.c) {
            m0(bigInteger);
        } else {
            K(bigInteger.toString());
        }
    }

    @Override // com.fasterxml.jackson.core.a
    public void I(char c) throws IOException {
        if (this.n + 3 >= this.p) {
            W();
        }
        byte[] bArr = this.l;
        if (c <= 127) {
            int i = this.n;
            this.n = i + 1;
            bArr[i] = (byte) c;
        } else {
            if (c >= 2048) {
                Y(c, null, 0, 0);
                return;
            }
            int i2 = this.n;
            int i3 = i2 + 1;
            this.n = i3;
            bArr[i2] = (byte) ((c >> 6) | 192);
            this.n = i2 + 2;
            bArr[i3] = (byte) ((c & '?') | 128);
        }
    }

    @Override // com.fasterxml.jackson.core.a
    public void J(IO io) throws IOException {
        byte[] bArrA = io.a();
        if (bArrA.length > 0) {
            d0(bArrA);
        }
    }

    @Override // com.fasterxml.jackson.core.a
    public void K(String str) throws IOException {
        int length = str.length();
        int i = 0;
        while (length > 0) {
            char[] cArr = this.t;
            int length2 = cArr.length;
            if (length < length2) {
                length2 = length;
            }
            int i2 = i + length2;
            str.getChars(i, i2, cArr, 0);
            L(cArr, 0, length2);
            length -= length2;
            i = i2;
        }
    }

    @Override // com.fasterxml.jackson.core.a
    public final void L(char[] cArr, int i, int i2) throws IOException {
        int i3 = i2 + i2 + i2;
        int i4 = this.n + i3;
        int i5 = this.p;
        if (i4 > i5) {
            if (i5 < i3) {
                n0(cArr, i, i2);
                return;
            }
            W();
        }
        int i6 = i2 + i;
        while (i < i6) {
            do {
                char c = cArr[i];
                if (c > 127) {
                    i++;
                    if (c < 2048) {
                        byte[] bArr = this.l;
                        int i7 = this.n;
                        int i8 = i7 + 1;
                        this.n = i8;
                        bArr[i7] = (byte) ((c >> 6) | 192);
                        this.n = i7 + 2;
                        bArr[i8] = (byte) ((c & '?') | 128);
                    } else {
                        Y(c, cArr, i, i6);
                    }
                } else {
                    byte[] bArr2 = this.l;
                    int i9 = this.n;
                    this.n = i9 + 1;
                    bArr2[i9] = (byte) c;
                    i++;
                }
            } while (i < i6);
            return;
        }
    }

    @Override // com.fasterxml.jackson.core.a
    public final void M() throws IOException {
        c0("start an array");
        this.d = this.d.h();
        KH kh = this.a;
        if (kh != null) {
            kh.h(this);
            return;
        }
        if (this.n >= this.p) {
            W();
        }
        byte[] bArr = this.l;
        int i = this.n;
        this.n = i + 1;
        bArr[i] = 91;
    }

    @Override // com.fasterxml.jackson.core.a
    public final void N() throws IOException {
        c0("start an object");
        this.d = this.d.i();
        KH kh = this.a;
        if (kh != null) {
            kh.a(this);
            return;
        }
        if (this.n >= this.p) {
            W();
        }
        byte[] bArr = this.l;
        int i = this.n;
        this.n = i + 1;
        bArr[i] = 123;
    }

    @Override // com.fasterxml.jackson.core.a
    public void O(String str) throws IOException {
        c0("write text value");
        if (str == null) {
            i0();
            return;
        }
        int length = str.length();
        if (length > this.u) {
            g0(str);
            return;
        }
        str.getChars(0, length, this.t, 0);
        if (length > this.q) {
            h0(this.t, 0, length);
            return;
        }
        if (this.n + length >= this.p) {
            W();
        }
        byte[] bArr = this.l;
        int i = this.n;
        this.n = i + 1;
        bArr[i] = 34;
        o0(this.t, 0, length);
        if (this.n >= this.p) {
            W();
        }
        byte[] bArr2 = this.l;
        int i2 = this.n;
        this.n = i2 + 1;
        bArr2[i2] = 34;
    }

    public final int V(int i, int i2) throws C4159vu {
        if (i2 < 56320 || i2 > 57343) {
            Q("Incomplete surrogate pair: first char 0x" + Integer.toHexString(i) + ", second 0x" + Integer.toHexString(i2));
        }
        return ((i - 55296) << 10) + 65536 + (i2 - 56320);
    }

    public final void W() throws IOException {
        int i = this.n;
        if (i > 0) {
            this.n = 0;
            this.k.write(this.l, 0, i);
        }
    }

    public final int X(int i, int i2) {
        byte[] bArr = this.l;
        if (i < 55296 || i > 57343) {
            bArr[i2] = (byte) ((i >> 12) | 224);
            int i3 = i2 + 2;
            bArr[i2 + 1] = (byte) (((i >> 6) & 63) | 128);
            int i4 = i2 + 3;
            bArr[i3] = (byte) ((i & 63) | 128);
            return i4;
        }
        bArr[i2] = 92;
        bArr[i2 + 1] = 117;
        byte[] bArr2 = w;
        bArr[i2 + 2] = bArr2[(i >> 12) & 15];
        bArr[i2 + 3] = bArr2[(i >> 8) & 15];
        int i5 = i2 + 5;
        bArr[i2 + 4] = bArr2[(i >> 4) & 15];
        int i6 = i2 + 6;
        bArr[i5] = bArr2[i & 15];
        return i6;
    }

    public final int Y(int i, char[] cArr, int i2, int i3) throws IOException {
        if (i >= 55296 && i <= 57343) {
            if (i2 >= i3) {
                Q("Split surrogate on writeRaw() input (last character)");
            }
            Z(i, cArr[i2]);
            return i2 + 1;
        }
        byte[] bArr = this.l;
        int i4 = this.n;
        int i5 = i4 + 1;
        this.n = i5;
        bArr[i4] = (byte) ((i >> 12) | 224);
        int i6 = i4 + 2;
        this.n = i6;
        bArr[i5] = (byte) (((i >> 6) & 63) | 128);
        this.n = i4 + 3;
        bArr[i6] = (byte) ((i & 63) | 128);
        return i2;
    }

    public final void Z(int i, int i2) throws IOException {
        int iV = V(i, i2);
        if (this.n + 4 > this.p) {
            W();
        }
        byte[] bArr = this.l;
        int i3 = this.n;
        int i4 = i3 + 1;
        this.n = i4;
        bArr[i3] = (byte) ((iV >> 18) | 240);
        int i5 = i3 + 2;
        this.n = i5;
        bArr[i4] = (byte) (((iV >> 12) & 63) | 128);
        int i6 = i3 + 3;
        this.n = i6;
        bArr[i5] = (byte) (((iV >> 6) & 63) | 128);
        this.n = i3 + 4;
        bArr[i6] = (byte) ((iV & 63) | 128);
    }

    public void a0() {
        byte[] bArr = this.l;
        if (bArr != null && this.v) {
            this.l = null;
            this.f.m(bArr);
        }
        char[] cArr = this.t;
        if (cArr != null) {
            this.t = null;
            this.f.i(cArr);
        }
    }

    public final void b0(String str, int i) {
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

    public final void c0(String str) throws IOException {
        byte b;
        IO io;
        int iN = this.d.n();
        if (iN == 5) {
            Q("Can not " + str + ", expecting field name");
        }
        if (this.a != null) {
            b0(str, iN);
            return;
        }
        if (iN == 1) {
            b = RefNPtg.sid;
        } else {
            if (iN != 2) {
                if (iN == 3 && (io = this.i) != null) {
                    byte[] bArrA = io.a();
                    if (bArrA.length > 0) {
                        d0(bArrA);
                        return;
                    }
                    return;
                }
                return;
            }
            b = Ref3DPtg.sid;
        }
        if (this.n >= this.p) {
            W();
        }
        byte[] bArr = this.l;
        int i = this.n;
        bArr[i] = b;
        this.n = i + 1;
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
        a0();
    }

    public final void d0(byte[] bArr) throws IOException {
        int length = bArr.length;
        if (this.n + length > this.p) {
            W();
            if (length > 512) {
                this.k.write(bArr, 0, length);
                return;
            }
        }
        System.arraycopy(bArr, 0, this.l, this.n, length);
        this.n += length;
    }

    public final void e0(String str) throws IOException {
        if (!S(a.EnumC0168a.QUOTE_FIELD_NAMES)) {
            r0(str);
            return;
        }
        if (this.n >= this.p) {
            W();
        }
        byte[] bArr = this.l;
        int i = this.n;
        this.n = i + 1;
        bArr[i] = 34;
        int length = str.length();
        if (length <= this.u) {
            str.getChars(0, length, this.t, 0);
            if (length <= this.q) {
                if (this.n + length > this.p) {
                    W();
                }
                o0(this.t, 0, length);
            } else {
                s0(this.t, 0, length);
            }
        } else {
            r0(str);
        }
        if (this.n >= this.p) {
            W();
        }
        byte[] bArr2 = this.l;
        int i2 = this.n;
        this.n = i2 + 1;
        bArr2[i2] = 34;
    }

    public final int f0(int i, int i2) {
        int i3;
        byte[] bArr = this.l;
        bArr[i2] = 92;
        int i4 = i2 + 2;
        bArr[i2 + 1] = 117;
        if (i > 255) {
            int i5 = i >> 8;
            int i6 = i2 + 3;
            byte[] bArr2 = w;
            bArr[i4] = bArr2[(i5 & 255) >> 4];
            i3 = i2 + 4;
            bArr[i6] = bArr2[i5 & 15];
            i &= 255;
        } else {
            int i7 = i2 + 3;
            bArr[i4] = ByteBuffer.ZERO;
            i3 = i2 + 4;
            bArr[i7] = ByteBuffer.ZERO;
        }
        int i8 = i3 + 1;
        byte[] bArr3 = w;
        bArr[i3] = bArr3[i >> 4];
        int i9 = i3 + 2;
        bArr[i8] = bArr3[i & 15];
        return i9;
    }

    @Override // com.fasterxml.jackson.core.a, java.io.Flushable
    public final void flush() throws IOException {
        W();
        if (this.k == null || !S(a.EnumC0168a.FLUSH_PASSED_TO_STREAM)) {
            return;
        }
        this.k.flush();
    }

    public final void g0(String str) throws IOException {
        if (this.n >= this.p) {
            W();
        }
        byte[] bArr = this.l;
        int i = this.n;
        this.n = i + 1;
        bArr[i] = 34;
        r0(str);
        if (this.n >= this.p) {
            W();
        }
        byte[] bArr2 = this.l;
        int i2 = this.n;
        this.n = i2 + 1;
        bArr2[i2] = 34;
    }

    public final void h0(char[] cArr, int i, int i2) throws IOException {
        if (this.n >= this.p) {
            W();
        }
        byte[] bArr = this.l;
        int i3 = this.n;
        this.n = i3 + 1;
        bArr[i3] = 34;
        s0(this.t, 0, i2);
        if (this.n >= this.p) {
            W();
        }
        byte[] bArr2 = this.l;
        int i4 = this.n;
        this.n = i4 + 1;
        bArr2[i4] = 34;
    }

    @Override // com.fasterxml.jackson.core.a
    public void i(boolean z2) throws IOException {
        c0("write boolean value");
        if (this.n + 5 >= this.p) {
            W();
        }
        byte[] bArr = z2 ? y : z;
        int length = bArr.length;
        System.arraycopy(bArr, 0, this.l, this.n, length);
        this.n += length;
    }

    public final void i0() throws IOException {
        if (this.n + 4 >= this.p) {
            W();
        }
        System.arraycopy(x, 0, this.l, this.n, 4);
        this.n += 4;
    }

    public final void j0(String str, boolean z2) throws IOException {
        if (z2) {
            this.a.j(this);
        } else {
            this.a.e(this);
        }
        if (!S(a.EnumC0168a.QUOTE_FIELD_NAMES)) {
            r0(str);
            return;
        }
        if (this.n >= this.p) {
            W();
        }
        byte[] bArr = this.l;
        int i = this.n;
        this.n = i + 1;
        bArr[i] = 34;
        int length = str.length();
        if (length <= this.u) {
            str.getChars(0, length, this.t, 0);
            if (length <= this.q) {
                if (this.n + length > this.p) {
                    W();
                }
                o0(this.t, 0, length);
            } else {
                s0(this.t, 0, length);
            }
        } else {
            r0(str);
        }
        if (this.n >= this.p) {
            W();
        }
        byte[] bArr2 = this.l;
        int i2 = this.n;
        this.n = i2 + 1;
        bArr2[i2] = 34;
    }

    public final void k0(int i) throws IOException {
        if (this.n + 13 >= this.p) {
            W();
        }
        byte[] bArr = this.l;
        int i2 = this.n;
        int i3 = i2 + 1;
        this.n = i3;
        bArr[i2] = 34;
        int iD = AbstractC1860cE.d(i, bArr, i3);
        byte[] bArr2 = this.l;
        this.n = iD + 1;
        bArr2[iD] = 34;
    }

    public final void l0(long j) throws IOException {
        if (this.n + 23 >= this.p) {
            W();
        }
        byte[] bArr = this.l;
        int i = this.n;
        int i2 = i + 1;
        this.n = i2;
        bArr[i] = 34;
        int iH = AbstractC1860cE.h(j, bArr, i2);
        byte[] bArr2 = this.l;
        this.n = iH + 1;
        bArr2[iH] = 34;
    }

    public final void m0(Object obj) throws IOException {
        if (this.n >= this.p) {
            W();
        }
        byte[] bArr = this.l;
        int i = this.n;
        this.n = i + 1;
        bArr[i] = 34;
        K(obj.toString());
        if (this.n >= this.p) {
            W();
        }
        byte[] bArr2 = this.l;
        int i2 = this.n;
        this.n = i2 + 1;
        bArr2[i2] = 34;
    }

    public final void n0(char[] cArr, int i, int i2) throws IOException {
        int i3 = this.p;
        byte[] bArr = this.l;
        while (i < i2) {
            do {
                char c = cArr[i];
                if (c >= 128) {
                    if (this.n + 3 >= this.p) {
                        W();
                    }
                    int i4 = i + 1;
                    char c2 = cArr[i];
                    if (c2 < 2048) {
                        int i5 = this.n;
                        int i6 = i5 + 1;
                        this.n = i6;
                        bArr[i5] = (byte) ((c2 >> 6) | 192);
                        this.n = i5 + 2;
                        bArr[i6] = (byte) ((c2 & '?') | 128);
                    } else {
                        Y(c2, cArr, i4, i2);
                    }
                    i = i4;
                } else {
                    if (this.n >= i3) {
                        W();
                    }
                    int i7 = this.n;
                    this.n = i7 + 1;
                    bArr[i7] = (byte) c;
                    i++;
                }
            } while (i < i2);
            return;
        }
    }

    public final void o0(char[] cArr, int i, int i2) throws IOException {
        int i3 = i2 + i;
        int i4 = this.n;
        byte[] bArr = this.l;
        int[] iArr = this.g;
        while (i < i3) {
            char c = cArr[i];
            if (c > 127 || iArr[c] != 0) {
                break;
            }
            bArr[i4] = (byte) c;
            i++;
            i4++;
        }
        this.n = i4;
        if (i < i3) {
            if (this.h == 0) {
                p0(cArr, i, i3);
            } else {
                q0(cArr, i, i3);
            }
        }
    }

    public final void p0(char[] cArr, int i, int i2) throws IOException {
        if (this.n + ((i2 - i) * 6) > this.p) {
            W();
        }
        int iX = this.n;
        byte[] bArr = this.l;
        int[] iArr = this.g;
        while (i < i2) {
            i++;
            char c = cArr[i];
            if (c <= 127) {
                int i3 = iArr[c];
                if (i3 == 0) {
                    bArr[iX] = (byte) c;
                    iX++;
                } else if (i3 > 0) {
                    int i4 = iX + 1;
                    bArr[iX] = 92;
                    iX += 2;
                    bArr[i4] = (byte) i3;
                } else {
                    iX = f0(c, iX);
                }
            } else if (c <= 2047) {
                int i5 = iX + 1;
                bArr[iX] = (byte) ((c >> 6) | 192);
                iX += 2;
                bArr[i5] = (byte) ((c & '?') | 128);
            } else {
                iX = X(c, iX);
            }
        }
        this.n = iX;
    }

    public final void q0(char[] cArr, int i, int i2) throws IOException {
        if (this.n + ((i2 - i) * 6) > this.p) {
            W();
        }
        int iX = this.n;
        byte[] bArr = this.l;
        int[] iArr = this.g;
        int i3 = this.h;
        while (i < i2) {
            i++;
            char c = cArr[i];
            if (c <= 127) {
                int i4 = iArr[c];
                if (i4 == 0) {
                    bArr[iX] = (byte) c;
                    iX++;
                } else if (i4 > 0) {
                    int i5 = iX + 1;
                    bArr[iX] = 92;
                    iX += 2;
                    bArr[i5] = (byte) i4;
                } else {
                    iX = f0(c, iX);
                }
            } else if (c > i3) {
                iX = f0(c, iX);
            } else if (c <= 2047) {
                int i6 = iX + 1;
                bArr[iX] = (byte) ((c >> 6) | 192);
                iX += 2;
                bArr[i6] = (byte) ((c & '?') | 128);
            } else {
                iX = X(c, iX);
            }
        }
        this.n = iX;
    }

    @Override // com.fasterxml.jackson.core.a
    public final void r() throws IOException {
        if (!this.d.d()) {
            Q("Current context not an ARRAY but " + this.d.c());
        }
        KH kh = this.a;
        if (kh != null) {
            kh.k(this, this.d.b());
        } else {
            if (this.n >= this.p) {
                W();
            }
            byte[] bArr = this.l;
            int i = this.n;
            this.n = i + 1;
            bArr[i] = 93;
        }
        this.d = this.d.k();
    }

    public final void r0(String str) throws IOException {
        int length = str.length();
        char[] cArr = this.t;
        int i = 0;
        while (length > 0) {
            int iMin = Math.min(this.q, length);
            int i2 = i + iMin;
            str.getChars(i, i2, cArr, 0);
            if (this.n + iMin > this.p) {
                W();
            }
            o0(cArr, 0, iMin);
            length -= iMin;
            i = i2;
        }
    }

    public final void s0(char[] cArr, int i, int i2) throws IOException {
        do {
            int iMin = Math.min(this.q, i2);
            if (this.n + iMin > this.p) {
                W();
            }
            o0(cArr, i, iMin);
            i += iMin;
            i2 -= iMin;
        } while (i2 > 0);
    }

    @Override // com.fasterxml.jackson.core.a
    public final void t() throws IOException {
        if (!this.d.e()) {
            Q("Current context not an object but " + this.d.c());
        }
        KH kh = this.a;
        if (kh != null) {
            kh.f(this, this.d.b());
        } else {
            if (this.n >= this.p) {
                W();
            }
            byte[] bArr = this.l;
            int i = this.n;
            this.n = i + 1;
            bArr[i] = 125;
        }
        this.d = this.d.k();
    }

    @Override // com.fasterxml.jackson.core.a
    public final void u(String str) throws IOException {
        int iM = this.d.m(str);
        if (iM == 4) {
            Q("Can not write a field name, expecting a value");
        }
        if (this.a != null) {
            j0(str, iM == 1);
            return;
        }
        if (iM == 1) {
            if (this.n >= this.p) {
                W();
            }
            byte[] bArr = this.l;
            int i = this.n;
            this.n = i + 1;
            bArr[i] = RefNPtg.sid;
        }
        e0(str);
    }

    @Override // com.fasterxml.jackson.core.a
    public void v() throws IOException {
        c0("write null value");
        i0();
    }

    @Override // com.fasterxml.jackson.core.a
    public void x(double d) throws IOException {
        if (this.c || ((Double.isNaN(d) || Double.isInfinite(d)) && S(a.EnumC0168a.QUOTE_NON_NUMERIC_NUMBERS))) {
            O(String.valueOf(d));
        } else {
            c0("write number");
            K(String.valueOf(d));
        }
    }

    @Override // com.fasterxml.jackson.core.a
    public void z(float f) throws IOException {
        if (this.c || ((Float.isNaN(f) || Float.isInfinite(f)) && S(a.EnumC0168a.QUOTE_NON_NUMERIC_NUMBERS))) {
            O(String.valueOf(f));
        } else {
            c0("write number");
            K(String.valueOf(f));
        }
    }
}
