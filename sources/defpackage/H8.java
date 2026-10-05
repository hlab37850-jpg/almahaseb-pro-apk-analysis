package defpackage;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.location.LocationRequestCompat;
import com.google.common.primitives.UnsignedBytes;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import java.io.Closeable;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
public final class H8 implements L8, K8, Cloneable, ByteChannel {
    public C3306lO a;
    public long b;

    public static final class a implements Closeable {
        public H8 a;
        public boolean b;
        public C3306lO c;
        public byte[] e;
        public long d = -1;
        public int f = -1;
        public int g = -1;

        public final C3306lO c() {
            return this.c;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.a == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            this.a = null;
            r(null);
            this.d = -1L;
            this.e = null;
            this.f = -1;
            this.g = -1;
        }

        public final int d() {
            long j = this.d;
            H8 h8 = this.a;
            AbstractC4492zt.e(h8);
            if (j == h8.R()) {
                throw new IllegalStateException("no more bytes");
            }
            long j2 = this.d;
            return i(j2 == -1 ? 0L : j2 + ((long) (this.g - this.f)));
        }

        public final long g(long j) {
            H8 h8 = this.a;
            if (h8 == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (!this.b) {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
            }
            long jR = h8.R();
            if (j <= jR) {
                if (j < 0) {
                    throw new IllegalArgumentException(("newSize < 0: " + j).toString());
                }
                long j2 = jR - j;
                while (j2 > 0) {
                    C3306lO c3306lO = h8.a;
                    AbstractC4492zt.e(c3306lO);
                    C3306lO c3306lO2 = c3306lO.g;
                    AbstractC4492zt.e(c3306lO2);
                    int i = c3306lO2.c;
                    long j3 = i - c3306lO2.b;
                    if (j3 > j2) {
                        c3306lO2.c = i - ((int) j2);
                        break;
                    }
                    h8.a = c3306lO2.b();
                    C3388mO.b(c3306lO2);
                    j2 -= j3;
                }
                r(null);
                this.d = j;
                this.e = null;
                this.f = -1;
                this.g = -1;
            } else if (j > jR) {
                long j4 = j - jR;
                boolean z = true;
                for (long j5 = 0; j4 > j5; j5 = 0) {
                    C3306lO c3306lOU = h8.U(1);
                    int iMin = (int) Math.min(j4, 8192 - c3306lOU.c);
                    c3306lOU.c += iMin;
                    j4 -= (long) iMin;
                    if (z) {
                        r(c3306lOU);
                        this.d = jR;
                        this.e = c3306lOU.a;
                        int i2 = c3306lOU.c;
                        this.f = i2 - iMin;
                        this.g = i2;
                        z = false;
                    }
                }
            }
            h8.Q(j);
            return jR;
        }

        public final int i(long j) {
            C3306lO c3306lOC;
            H8 h8 = this.a;
            if (h8 == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (j < -1 || j > h8.R()) {
                throw new ArrayIndexOutOfBoundsException("offset=" + j + " > size=" + h8.R());
            }
            if (j == -1 || j == h8.R()) {
                r(null);
                this.d = j;
                this.e = null;
                this.f = -1;
                this.g = -1;
                return -1;
            }
            long jR = h8.R();
            C3306lO c3306lOC2 = h8.a;
            long j2 = 0;
            if (c() != null) {
                long j3 = this.d;
                int i = this.f;
                C3306lO c3306lOC3 = c();
                AbstractC4492zt.e(c3306lOC3);
                long j4 = j3 - ((long) (i - c3306lOC3.b));
                if (j4 > j) {
                    c3306lOC = c3306lOC2;
                    c3306lOC2 = c();
                    jR = j4;
                } else {
                    c3306lOC = c();
                    j2 = j4;
                }
            } else {
                c3306lOC = c3306lOC2;
            }
            if (jR - j > j - j2) {
                while (true) {
                    AbstractC4492zt.e(c3306lOC);
                    int i2 = c3306lOC.c;
                    int i3 = c3306lOC.b;
                    if (j < ((long) (i2 - i3)) + j2) {
                        break;
                    }
                    j2 += (long) (i2 - i3);
                    c3306lOC = c3306lOC.f;
                }
            } else {
                while (jR > j) {
                    AbstractC4492zt.e(c3306lOC2);
                    c3306lOC2 = c3306lOC2.g;
                    AbstractC4492zt.e(c3306lOC2);
                    jR -= (long) (c3306lOC2.c - c3306lOC2.b);
                }
                j2 = jR;
                c3306lOC = c3306lOC2;
            }
            if (this.b) {
                AbstractC4492zt.e(c3306lOC);
                if (c3306lOC.d) {
                    C3306lO c3306lOF = c3306lOC.f();
                    if (h8.a == c3306lOC) {
                        h8.a = c3306lOF;
                    }
                    c3306lOC = c3306lOC.c(c3306lOF);
                    C3306lO c3306lO = c3306lOC.g;
                    AbstractC4492zt.e(c3306lO);
                    c3306lO.b();
                }
            }
            r(c3306lOC);
            this.d = j;
            AbstractC4492zt.e(c3306lOC);
            this.e = c3306lOC.a;
            int i4 = c3306lOC.b + ((int) (j - j2));
            this.f = i4;
            int i5 = c3306lOC.c;
            this.g = i5;
            return i5 - i4;
        }

        public final void r(C3306lO c3306lO) {
            this.c = c3306lO;
        }
    }

    public static /* synthetic */ a I(H8 h8, a aVar, int i, Object obj) {
        if ((i & 1) != 0) {
            aVar = AbstractC2074e.d();
        }
        return h8.H(aVar);
    }

    public long A(W8 w8) {
        AbstractC4492zt.h(w8, "targetBytes");
        return C(w8, 0L);
    }

    @Override // defpackage.L8
    public int B(XE xe) throws EOFException {
        AbstractC4492zt.h(xe, "options");
        int iE = AbstractC1754b.e(this, xe, false, 2, null);
        if (iE == -1) {
            return -1;
        }
        skip(xe.c()[iE].u());
        return iE;
    }

    public long C(W8 w8, long j) {
        int i;
        int i2;
        AbstractC4492zt.h(w8, "targetBytes");
        long jR = 0;
        if (j < 0) {
            throw new IllegalArgumentException(("fromIndex < 0: " + j).toString());
        }
        C3306lO c3306lO = this.a;
        if (c3306lO == null) {
            return -1L;
        }
        if (R() - j < j) {
            jR = R();
            while (jR > j) {
                c3306lO = c3306lO.g;
                AbstractC4492zt.e(c3306lO);
                jR -= (long) (c3306lO.c - c3306lO.b);
            }
            if (w8.u() == 2) {
                byte bE = w8.e(0);
                byte bE2 = w8.e(1);
                while (jR < R()) {
                    byte[] bArr = c3306lO.a;
                    i = (int) ((((long) c3306lO.b) + j) - jR);
                    int i3 = c3306lO.c;
                    while (true) {
                        if (i >= i3) {
                            jR += (long) (c3306lO.c - c3306lO.b);
                            c3306lO = c3306lO.f;
                            AbstractC4492zt.e(c3306lO);
                            j = jR;
                        } else {
                            byte b = bArr[i];
                            if (b == bE || b == bE2) {
                                i2 = c3306lO.b;
                            } else {
                                i++;
                            }
                        }
                    }
                }
                return -1L;
            }
            byte[] bArrL = w8.l();
            while (jR < R()) {
                byte[] bArr2 = c3306lO.a;
                i = (int) ((((long) c3306lO.b) + j) - jR);
                int i4 = c3306lO.c;
                while (true) {
                    if (i < i4) {
                        byte b2 = bArr2[i];
                        int length = bArrL.length;
                        int i5 = 0;
                        while (true) {
                            if (i5 >= length) {
                                i++;
                            } else if (b2 == bArrL[i5]) {
                                i2 = c3306lO.b;
                            } else {
                                i5++;
                            }
                        }
                    } else {
                        jR += (long) (c3306lO.c - c3306lO.b);
                        c3306lO = c3306lO.f;
                        AbstractC4492zt.e(c3306lO);
                        j = jR;
                    }
                }
            }
            return -1L;
        }
        while (true) {
            long j2 = ((long) (c3306lO.c - c3306lO.b)) + jR;
            if (j2 > j) {
                break;
            }
            c3306lO = c3306lO.f;
            AbstractC4492zt.e(c3306lO);
            jR = j2;
        }
        if (w8.u() == 2) {
            byte bE3 = w8.e(0);
            byte bE4 = w8.e(1);
            while (jR < R()) {
                byte[] bArr3 = c3306lO.a;
                i = (int) ((((long) c3306lO.b) + j) - jR);
                int i6 = c3306lO.c;
                while (true) {
                    if (i >= i6) {
                        jR += (long) (c3306lO.c - c3306lO.b);
                        c3306lO = c3306lO.f;
                        AbstractC4492zt.e(c3306lO);
                        j = jR;
                    } else {
                        byte b3 = bArr3[i];
                        if (b3 == bE3 || b3 == bE4) {
                            i2 = c3306lO.b;
                        } else {
                            i++;
                        }
                    }
                }
            }
            return -1L;
        }
        byte[] bArrL2 = w8.l();
        while (jR < R()) {
            byte[] bArr4 = c3306lO.a;
            i = (int) ((((long) c3306lO.b) + j) - jR);
            int i7 = c3306lO.c;
            while (true) {
                if (i < i7) {
                    byte b4 = bArr4[i];
                    int length2 = bArrL2.length;
                    int i8 = 0;
                    while (true) {
                        if (i8 >= length2) {
                            i++;
                        } else if (b4 == bArrL2[i8]) {
                            i2 = c3306lO.b;
                        } else {
                            i8++;
                        }
                    }
                } else {
                    jR += (long) (c3306lO.c - c3306lO.b);
                    c3306lO = c3306lO.f;
                    AbstractC4492zt.e(c3306lO);
                    j = jR;
                }
            }
        }
        return -1L;
        return ((long) (i - i2)) + jR;
    }

    @Override // defpackage.L8
    public void D(long j) throws EOFException {
        if (this.b < j) {
            throw new EOFException();
        }
    }

    @Override // defpackage.L8
    public long E() throws EOFException {
        int i;
        if (R() == 0) {
            throw new EOFException();
        }
        int i2 = 0;
        long j = 0;
        boolean z = false;
        do {
            C3306lO c3306lO = this.a;
            AbstractC4492zt.e(c3306lO);
            byte[] bArr = c3306lO.a;
            int i3 = c3306lO.b;
            int i4 = c3306lO.c;
            while (i3 < i4) {
                byte b = bArr[i3];
                if (b >= 48 && b <= 57) {
                    i = b - 48;
                } else if (b >= 97 && b <= 102) {
                    i = b - 87;
                } else {
                    if (b < 65 || b > 70) {
                        if (i2 != 0) {
                            z = true;
                            break;
                        }
                        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + AbstractC2074e.j(b));
                    }
                    i = b - 55;
                }
                if (((-1152921504606846976L) & j) != 0) {
                    throw new NumberFormatException("Number too large: " + new H8().q(j).writeByte(b).O());
                }
                j = (j << 4) | ((long) i);
                i3++;
                i2++;
            }
            if (i3 == i4) {
                this.a = c3306lO.b();
                C3388mO.b(c3306lO);
            } else {
                c3306lO.b = i3;
            }
            if (z) {
                break;
            }
        } while (this.a != null);
        Q(R() - ((long) i2));
        return j;
    }

    public boolean F(long j, W8 w8) {
        AbstractC4492zt.h(w8, "bytes");
        return G(j, w8, 0, w8.u());
    }

    public boolean G(long j, W8 w8, int i, int i2) {
        AbstractC4492zt.h(w8, "bytes");
        if (j < 0 || i < 0 || i2 < 0 || R() - j < i2 || w8.u() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (x(((long) i3) + j) != w8.e(i + i3)) {
                return false;
            }
        }
        return true;
    }

    public final a H(a aVar) {
        AbstractC4492zt.h(aVar, "unsafeCursor");
        return AbstractC1754b.a(this, aVar);
    }

    public byte[] J() {
        return w(R());
    }

    public W8 K() {
        return e(R());
    }

    public int L() {
        return AbstractC2074e.h(readInt());
    }

    public short M() {
        return AbstractC2074e.i(readShort());
    }

    public String N(long j, Charset charset) throws EOFException {
        AbstractC4492zt.h(charset, "charset");
        if (j < 0 || j > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j).toString());
        }
        if (this.b < j) {
            throw new EOFException();
        }
        if (j == 0) {
            return "";
        }
        C3306lO c3306lO = this.a;
        AbstractC4492zt.e(c3306lO);
        int i = c3306lO.b;
        if (((long) i) + j > c3306lO.c) {
            return new String(w(j), charset);
        }
        int i2 = (int) j;
        String str = new String(c3306lO.a, i, i2, charset);
        int i3 = c3306lO.b + i2;
        c3306lO.b = i3;
        this.b -= j;
        if (i3 == c3306lO.c) {
            this.a = c3306lO.b();
            C3388mO.b(c3306lO);
        }
        return str;
    }

    public String O() {
        return N(this.b, C3809rb.b);
    }

    public String P(long j) throws EOFException {
        return N(j, C3809rb.b);
    }

    public final void Q(long j) {
        this.b = j;
    }

    public final long R() {
        return this.b;
    }

    public final W8 S() {
        if (R() <= 2147483647L) {
            return T((int) R());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + R()).toString());
    }

    public final W8 T(int i) {
        if (i == 0) {
            return W8.e;
        }
        AbstractC2074e.b(R(), 0L, i);
        C3306lO c3306lO = this.a;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            AbstractC4492zt.e(c3306lO);
            int i5 = c3306lO.c;
            int i6 = c3306lO.b;
            if (i5 == i6) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += i5 - i6;
            i4++;
            c3306lO = c3306lO.f;
        }
        byte[][] bArr = new byte[i4][];
        int[] iArr = new int[i4 * 2];
        C3306lO c3306lO2 = this.a;
        int i7 = 0;
        while (i2 < i) {
            AbstractC4492zt.e(c3306lO2);
            bArr[i7] = c3306lO2.a;
            i2 += c3306lO2.c - c3306lO2.b;
            iArr[i7] = Math.min(i2, i);
            iArr[i7 + i4] = c3306lO2.b;
            c3306lO2.d = true;
            i7++;
            c3306lO2 = c3306lO2.f;
        }
        return new C3470nO(bArr, iArr);
    }

    public final C3306lO U(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException("unexpected capacity");
        }
        C3306lO c3306lO = this.a;
        if (c3306lO != null) {
            AbstractC4492zt.e(c3306lO);
            C3306lO c3306lO2 = c3306lO.g;
            AbstractC4492zt.e(c3306lO2);
            return (c3306lO2.c + i > 8192 || !c3306lO2.e) ? c3306lO2.c(C3388mO.c()) : c3306lO2;
        }
        C3306lO c3306lOC = C3388mO.c();
        this.a = c3306lOC;
        c3306lOC.g = c3306lOC;
        c3306lOC.f = c3306lOC;
        return c3306lOC;
    }

    @Override // defpackage.K8
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public H8 n(W8 w8) {
        AbstractC4492zt.h(w8, "byteString");
        w8.z(this, 0, w8.u());
        return this;
    }

    @Override // defpackage.K8
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public H8 write(byte[] bArr) {
        AbstractC4492zt.h(bArr, DublinCoreProperties.SOURCE);
        return write(bArr, 0, bArr.length);
    }

    @Override // defpackage.K8
    /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
    public H8 write(byte[] bArr, int i, int i2) {
        AbstractC4492zt.h(bArr, DublinCoreProperties.SOURCE);
        long j = i2;
        AbstractC2074e.b(bArr.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            C3306lO c3306lOU = U(1);
            int iMin = Math.min(i3 - i, 8192 - c3306lOU.c);
            int i4 = i + iMin;
            Q5.d(bArr, c3306lOU.a, c3306lOU.c, i, i4);
            c3306lOU.c += iMin;
            i = i4;
        }
        Q(R() + j);
        return this;
    }

    public long Y(InterfaceC3309lR interfaceC3309lR) {
        AbstractC4492zt.h(interfaceC3309lR, DublinCoreProperties.SOURCE);
        long j = 0;
        while (true) {
            long jY = interfaceC3309lR.y(this, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (jY == -1) {
                return j;
            }
            j += jY;
        }
    }

    @Override // defpackage.K8
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public H8 writeByte(int i) {
        C3306lO c3306lOU = U(1);
        byte[] bArr = c3306lOU.a;
        int i2 = c3306lOU.c;
        c3306lOU.c = i2 + 1;
        bArr[i2] = (byte) i;
        Q(R() + 1);
        return this;
    }

    @Override // defpackage.K8
    /* JADX INFO: renamed from: a0, reason: merged with bridge method [inline-methods] */
    public H8 q(long j) {
        if (j == 0) {
            return writeByte(48);
        }
        long j2 = (j >>> 1) | j;
        long j3 = j2 | (j2 >>> 2);
        long j4 = j3 | (j3 >>> 4);
        long j5 = j4 | (j4 >>> 8);
        long j6 = j5 | (j5 >>> 16);
        long j7 = j6 | (j6 >>> 32);
        long j8 = j7 - ((j7 >>> 1) & 6148914691236517205L);
        long j9 = ((j8 >>> 2) & 3689348814741910323L) + (j8 & 3689348814741910323L);
        long j10 = ((j9 >>> 4) + j9) & 1085102592571150095L;
        long j11 = j10 + (j10 >>> 8);
        long j12 = j11 + (j11 >>> 16);
        int i = (int) ((((j12 & 63) + ((j12 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        C3306lO c3306lOU = U(i);
        byte[] bArr = c3306lOU.a;
        int i2 = c3306lOU.c;
        for (int i3 = (i2 + i) - 1; i3 >= i2; i3--) {
            bArr[i3] = AbstractC1754b.b()[(int) (15 & j)];
            j >>>= 4;
        }
        c3306lOU.c += i;
        Q(R() + ((long) i));
        return this;
    }

    @Override // defpackage.InterfaceC3309lR
    public JU b() {
        return JU.e;
    }

    @Override // defpackage.K8
    /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
    public H8 writeInt(int i) {
        C3306lO c3306lOU = U(4);
        byte[] bArr = c3306lOU.a;
        int i2 = c3306lOU.c;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        bArr[i2 + 1] = (byte) ((i >>> 16) & 255);
        bArr[i2 + 2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 3] = (byte) (i & 255);
        c3306lOU.c = i2 + 4;
        Q(R() + 4);
        return this;
    }

    public H8 c0(long j) {
        C3306lO c3306lOU = U(8);
        byte[] bArr = c3306lOU.a;
        int i = c3306lOU.c;
        bArr[i] = (byte) ((j >>> 56) & 255);
        bArr[i + 1] = (byte) ((j >>> 48) & 255);
        bArr[i + 2] = (byte) ((j >>> 40) & 255);
        bArr[i + 3] = (byte) ((j >>> 32) & 255);
        bArr[i + 4] = (byte) ((j >>> 24) & 255);
        bArr[i + 5] = (byte) ((j >>> 16) & 255);
        bArr[i + 6] = (byte) ((j >>> 8) & 255);
        bArr[i + 7] = (byte) (j & 255);
        c3306lOU.c = i + 8;
        Q(R() + 8);
        return this;
    }

    public final void d() throws EOFException {
        skip(R());
    }

    @Override // defpackage.K8
    /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
    public H8 writeShort(int i) {
        C3306lO c3306lOU = U(2);
        byte[] bArr = c3306lOU.a;
        int i2 = c3306lOU.c;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 1] = (byte) (i & 255);
        c3306lOU.c = i2 + 2;
        Q(R() + 2);
        return this;
    }

    @Override // defpackage.L8
    public W8 e(long j) throws EOFException {
        if (j < 0 || j > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j).toString());
        }
        if (R() < j) {
            throw new EOFException();
        }
        if (j < PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            return new W8(w(j));
        }
        W8 w8T = T((int) j);
        skip(j);
        return w8T;
    }

    public H8 e0(String str, int i, int i2, Charset charset) {
        AbstractC4492zt.h(str, TypedValues.Custom.S_STRING);
        AbstractC4492zt.h(charset, "charset");
        if (i < 0) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i).toString());
        }
        if (i2 < i) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i2 + " < " + i).toString());
        }
        if (i2 > str.length()) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i2 + " > " + str.length()).toString());
        }
        if (AbstractC4492zt.d(charset, C3809rb.b)) {
            return g0(str, i, i2);
        }
        String strSubstring = str.substring(i, i2);
        AbstractC4492zt.g(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        byte[] bytes = strSubstring.getBytes(charset);
        AbstractC4492zt.g(bytes, "this as java.lang.String).getBytes(charset)");
        return write(bytes, 0, bytes.length);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof H8) {
            H8 h8 = (H8) obj;
            if (R() == h8.R()) {
                if (R() == 0) {
                    return true;
                }
                C3306lO c3306lO = this.a;
                AbstractC4492zt.e(c3306lO);
                C3306lO c3306lO2 = h8.a;
                AbstractC4492zt.e(c3306lO2);
                int i = c3306lO.b;
                int i2 = c3306lO2.b;
                long j = 0;
                while (j < R()) {
                    long jMin = Math.min(c3306lO.c - i, c3306lO2.c - i2);
                    long j2 = 0;
                    while (j2 < jMin) {
                        int i3 = i + 1;
                        int i4 = i2 + 1;
                        if (c3306lO.a[i] == c3306lO2.a[i2]) {
                            j2++;
                            i = i3;
                            i2 = i4;
                        }
                    }
                    if (i == c3306lO.c) {
                        c3306lO = c3306lO.f;
                        AbstractC4492zt.e(c3306lO);
                        i = c3306lO.b;
                    }
                    if (i2 == c3306lO2.c) {
                        c3306lO2 = c3306lO2.f;
                        AbstractC4492zt.e(c3306lO2);
                        i2 = c3306lO2.b;
                    }
                    j += jMin;
                }
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.K8
    /* JADX INFO: renamed from: f0, reason: merged with bridge method [inline-methods] */
    public H8 l(String str) {
        AbstractC4492zt.h(str, TypedValues.Custom.S_STRING);
        return g0(str, 0, str.length());
    }

    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public H8 clone() {
        return r();
    }

    public H8 g0(String str, int i, int i2) {
        char cCharAt;
        AbstractC4492zt.h(str, TypedValues.Custom.S_STRING);
        if (i < 0) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i).toString());
        }
        if (i2 < i) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i2 + " < " + i).toString());
        }
        if (i2 > str.length()) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i2 + " > " + str.length()).toString());
        }
        while (i < i2) {
            char cCharAt2 = str.charAt(i);
            if (cCharAt2 < 128) {
                C3306lO c3306lOU = U(1);
                byte[] bArr = c3306lOU.a;
                int i3 = c3306lOU.c - i;
                int iMin = Math.min(i2, 8192 - i3);
                int i4 = i + 1;
                bArr[i + i3] = (byte) cCharAt2;
                while (true) {
                    i = i4;
                    if (i >= iMin || (cCharAt = str.charAt(i)) >= 128) {
                        break;
                    }
                    i4 = i + 1;
                    bArr[i + i3] = (byte) cCharAt;
                }
                int i5 = c3306lOU.c;
                int i6 = (i3 + i) - i5;
                c3306lOU.c = i5 + i6;
                Q(R() + ((long) i6));
            } else {
                if (cCharAt2 < 2048) {
                    C3306lO c3306lOU2 = U(2);
                    byte[] bArr2 = c3306lOU2.a;
                    int i7 = c3306lOU2.c;
                    bArr2[i7] = (byte) ((cCharAt2 >> 6) | 192);
                    bArr2[i7 + 1] = (byte) ((cCharAt2 & '?') | 128);
                    c3306lOU2.c = i7 + 2;
                    Q(R() + 2);
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    C3306lO c3306lOU3 = U(3);
                    byte[] bArr3 = c3306lOU3.a;
                    int i8 = c3306lOU3.c;
                    bArr3[i8] = (byte) ((cCharAt2 >> '\f') | 224);
                    bArr3[i8 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                    bArr3[i8 + 2] = (byte) ((cCharAt2 & '?') | 128);
                    c3306lOU3.c = i8 + 3;
                    Q(R() + 3);
                } else {
                    int i9 = i + 1;
                    char cCharAt3 = i9 < i2 ? str.charAt(i9) : (char) 0;
                    if (cCharAt2 > 56319 || 56320 > cCharAt3 || cCharAt3 >= 57344) {
                        writeByte(63);
                        i = i9;
                    } else {
                        int i10 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        C3306lO c3306lOU4 = U(4);
                        byte[] bArr4 = c3306lOU4.a;
                        int i11 = c3306lOU4.c;
                        bArr4[i11] = (byte) ((i10 >> 18) | 240);
                        bArr4[i11 + 1] = (byte) (((i10 >> 12) & 63) | 128);
                        bArr4[i11 + 2] = (byte) (((i10 >> 6) & 63) | 128);
                        bArr4[i11 + 3] = (byte) ((i10 & 63) | 128);
                        c3306lOU4.c = i11 + 4;
                        Q(R() + 4);
                        i += 2;
                    }
                }
                i++;
            }
        }
        return this;
    }

    @Override // defpackage.L8
    public boolean h() {
        return this.b == 0;
    }

    public H8 h0(int i) {
        if (i < 128) {
            writeByte(i);
        } else if (i < 2048) {
            C3306lO c3306lOU = U(2);
            byte[] bArr = c3306lOU.a;
            int i2 = c3306lOU.c;
            bArr[i2] = (byte) ((i >> 6) | 192);
            bArr[i2 + 1] = (byte) ((i & 63) | 128);
            c3306lOU.c = i2 + 2;
            Q(R() + 2);
        } else if (55296 <= i && i < 57344) {
            writeByte(63);
        } else if (i < 65536) {
            C3306lO c3306lOU2 = U(3);
            byte[] bArr2 = c3306lOU2.a;
            int i3 = c3306lOU2.c;
            bArr2[i3] = (byte) ((i >> 12) | 224);
            bArr2[i3 + 1] = (byte) (((i >> 6) & 63) | 128);
            bArr2[i3 + 2] = (byte) ((i & 63) | 128);
            c3306lOU2.c = i3 + 3;
            Q(R() + 3);
        } else {
            if (i > 1114111) {
                throw new IllegalArgumentException("Unexpected code point: 0x" + AbstractC2074e.k(i));
            }
            C3306lO c3306lOU3 = U(4);
            byte[] bArr3 = c3306lOU3.a;
            int i4 = c3306lOU3.c;
            bArr3[i4] = (byte) ((i >> 18) | 240);
            bArr3[i4 + 1] = (byte) (((i >> 12) & 63) | 128);
            bArr3[i4 + 2] = (byte) (((i >> 6) & 63) | 128);
            bArr3[i4 + 3] = (byte) ((i & 63) | 128);
            c3306lOU3.c = i4 + 4;
            Q(R() + 4);
        }
        return this;
    }

    public int hashCode() {
        C3306lO c3306lO = this.a;
        if (c3306lO == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = c3306lO.c;
            for (int i3 = c3306lO.b; i3 < i2; i3++) {
                i = (i * 31) + c3306lO.a[i3];
            }
            c3306lO = c3306lO.f;
            AbstractC4492zt.e(c3306lO);
        } while (c3306lO != this.a);
        return i;
    }

    public final long i() {
        long jR = R();
        if (jR == 0) {
            return 0L;
        }
        C3306lO c3306lO = this.a;
        AbstractC4492zt.e(c3306lO);
        C3306lO c3306lO2 = c3306lO.g;
        AbstractC4492zt.e(c3306lO2);
        int i = c3306lO2.c;
        if (i < 8192 && c3306lO2.e) {
            jR -= (long) (i - c3306lO2.b);
        }
        return jR;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // defpackage.L8
    public String k(long j) throws EOFException {
        if (j < 0) {
            throw new IllegalArgumentException(("limit < 0: " + j).toString());
        }
        long j2 = LocationRequestCompat.PASSIVE_INTERVAL;
        if (j != LocationRequestCompat.PASSIVE_INTERVAL) {
            j2 = j + 1;
        }
        long jZ = z((byte) 10, 0L, j2);
        if (jZ != -1) {
            return AbstractC1754b.c(this, jZ);
        }
        if (j2 < R() && x(j2 - 1) == 13 && x(j2) == 10) {
            return AbstractC1754b.c(this, j2);
        }
        H8 h8 = new H8();
        t(h8, 0L, Math.min(32, R()));
        throw new EOFException("\\n not found: limit=" + Math.min(R(), j) + " content=" + h8.K().k() + (char) 8230);
    }

    @Override // defpackage.L8
    public void m(H8 h8, long j) throws EOFException {
        AbstractC4492zt.h(h8, "sink");
        if (R() >= j) {
            h8.p(this, j);
        } else {
            h8.p(this, R());
            throw new EOFException();
        }
    }

    @Override // defpackage.L8
    public String o(Charset charset) {
        AbstractC4492zt.h(charset, "charset");
        return N(this.b, charset);
    }

    @Override // defpackage.LQ
    public void p(H8 h8, long j) {
        C3306lO c3306lO;
        AbstractC4492zt.h(h8, DublinCoreProperties.SOURCE);
        if (h8 == this) {
            throw new IllegalArgumentException("source == this");
        }
        AbstractC2074e.b(h8.R(), 0L, j);
        while (j > 0) {
            C3306lO c3306lO2 = h8.a;
            AbstractC4492zt.e(c3306lO2);
            int i = c3306lO2.c;
            C3306lO c3306lO3 = h8.a;
            AbstractC4492zt.e(c3306lO3);
            if (j < i - c3306lO3.b) {
                C3306lO c3306lO4 = this.a;
                if (c3306lO4 != null) {
                    AbstractC4492zt.e(c3306lO4);
                    c3306lO = c3306lO4.g;
                } else {
                    c3306lO = null;
                }
                if (c3306lO != null && c3306lO.e) {
                    if ((((long) c3306lO.c) + j) - ((long) (c3306lO.d ? 0 : c3306lO.b)) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                        C3306lO c3306lO5 = h8.a;
                        AbstractC4492zt.e(c3306lO5);
                        c3306lO5.g(c3306lO, (int) j);
                        h8.Q(h8.R() - j);
                        Q(R() + j);
                        return;
                    }
                }
                C3306lO c3306lO6 = h8.a;
                AbstractC4492zt.e(c3306lO6);
                h8.a = c3306lO6.e((int) j);
            }
            C3306lO c3306lO7 = h8.a;
            AbstractC4492zt.e(c3306lO7);
            long j2 = c3306lO7.c - c3306lO7.b;
            h8.a = c3306lO7.b();
            C3306lO c3306lO8 = this.a;
            if (c3306lO8 == null) {
                this.a = c3306lO7;
                c3306lO7.g = c3306lO7;
                c3306lO7.f = c3306lO7;
            } else {
                AbstractC4492zt.e(c3306lO8);
                C3306lO c3306lO9 = c3306lO8.g;
                AbstractC4492zt.e(c3306lO9);
                c3306lO9.c(c3306lO7).a();
            }
            h8.Q(h8.R() - j2);
            Q(R() + j2);
            j -= j2;
        }
    }

    public final H8 r() {
        H8 h8 = new H8();
        if (R() != 0) {
            C3306lO c3306lO = this.a;
            AbstractC4492zt.e(c3306lO);
            C3306lO c3306lOD = c3306lO.d();
            h8.a = c3306lOD;
            c3306lOD.g = c3306lOD;
            c3306lOD.f = c3306lOD;
            for (C3306lO c3306lO2 = c3306lO.f; c3306lO2 != c3306lO; c3306lO2 = c3306lO2.f) {
                C3306lO c3306lO3 = c3306lOD.g;
                AbstractC4492zt.e(c3306lO3);
                AbstractC4492zt.e(c3306lO2);
                c3306lO3.c(c3306lO2.d());
            }
            h8.Q(R());
        }
        return h8;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        AbstractC4492zt.h(byteBuffer, "sink");
        C3306lO c3306lO = this.a;
        if (c3306lO == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), c3306lO.c - c3306lO.b);
        byteBuffer.put(c3306lO.a, c3306lO.b, iMin);
        int i = c3306lO.b + iMin;
        c3306lO.b = i;
        this.b -= (long) iMin;
        if (i == c3306lO.c) {
            this.a = c3306lO.b();
            C3388mO.b(c3306lO);
        }
        return iMin;
    }

    @Override // defpackage.L8
    public byte readByte() throws EOFException {
        if (R() == 0) {
            throw new EOFException();
        }
        C3306lO c3306lO = this.a;
        AbstractC4492zt.e(c3306lO);
        int i = c3306lO.b;
        int i2 = c3306lO.c;
        int i3 = i + 1;
        byte b = c3306lO.a[i];
        Q(R() - 1);
        if (i3 == i2) {
            this.a = c3306lO.b();
            C3388mO.b(c3306lO);
        } else {
            c3306lO.b = i3;
        }
        return b;
    }

    @Override // defpackage.L8
    public void readFully(byte[] bArr) throws EOFException {
        AbstractC4492zt.h(bArr, "sink");
        int i = 0;
        while (i < bArr.length) {
            int i2 = read(bArr, i, bArr.length - i);
            if (i2 == -1) {
                throw new EOFException();
            }
            i += i2;
        }
    }

    @Override // defpackage.L8
    public int readInt() throws EOFException {
        if (R() < 4) {
            throw new EOFException();
        }
        C3306lO c3306lO = this.a;
        AbstractC4492zt.e(c3306lO);
        int i = c3306lO.b;
        int i2 = c3306lO.c;
        if (i2 - i < 4) {
            return ((readByte() & UnsignedBytes.MAX_VALUE) << 24) | ((readByte() & UnsignedBytes.MAX_VALUE) << 16) | ((readByte() & UnsignedBytes.MAX_VALUE) << 8) | (readByte() & UnsignedBytes.MAX_VALUE);
        }
        byte[] bArr = c3306lO.a;
        int i3 = i + 3;
        int i4 = ((bArr[i + 1] & UnsignedBytes.MAX_VALUE) << 16) | ((bArr[i] & UnsignedBytes.MAX_VALUE) << 24) | ((bArr[i + 2] & UnsignedBytes.MAX_VALUE) << 8);
        int i5 = i + 4;
        int i6 = (bArr[i3] & UnsignedBytes.MAX_VALUE) | i4;
        Q(R() - 4);
        if (i5 == i2) {
            this.a = c3306lO.b();
            C3388mO.b(c3306lO);
        } else {
            c3306lO.b = i5;
        }
        return i6;
    }

    @Override // defpackage.L8
    public long readLong() throws EOFException {
        if (R() < 8) {
            throw new EOFException();
        }
        C3306lO c3306lO = this.a;
        AbstractC4492zt.e(c3306lO);
        int i = c3306lO.b;
        int i2 = c3306lO.c;
        if (i2 - i < 8) {
            return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
        }
        byte[] bArr = c3306lO.a;
        int i3 = i + 7;
        long j = ((((long) bArr[i + 3]) & 255) << 32) | ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i + 1]) & 255) << 48) | ((((long) bArr[i + 2]) & 255) << 40) | ((((long) bArr[i + 4]) & 255) << 24) | ((((long) bArr[i + 5]) & 255) << 16) | ((((long) bArr[i + 6]) & 255) << 8);
        int i4 = i + 8;
        long j2 = j | (((long) bArr[i3]) & 255);
        Q(R() - 8);
        if (i4 == i2) {
            this.a = c3306lO.b();
            C3388mO.b(c3306lO);
        } else {
            c3306lO.b = i4;
        }
        return j2;
    }

    @Override // defpackage.L8
    public short readShort() throws EOFException {
        if (R() < 2) {
            throw new EOFException();
        }
        C3306lO c3306lO = this.a;
        AbstractC4492zt.e(c3306lO);
        int i = c3306lO.b;
        int i2 = c3306lO.c;
        if (i2 - i < 2) {
            return (short) (((readByte() & UnsignedBytes.MAX_VALUE) << 8) | (readByte() & UnsignedBytes.MAX_VALUE));
        }
        byte[] bArr = c3306lO.a;
        int i3 = i + 1;
        int i4 = (bArr[i] & UnsignedBytes.MAX_VALUE) << 8;
        int i5 = i + 2;
        int i6 = (bArr[i3] & UnsignedBytes.MAX_VALUE) | i4;
        Q(R() - 2);
        if (i5 == i2) {
            this.a = c3306lO.b();
            C3388mO.b(c3306lO);
        } else {
            c3306lO.b = i5;
        }
        return (short) i6;
    }

    @Override // defpackage.L8
    public String s() {
        return k(LocationRequestCompat.PASSIVE_INTERVAL);
    }

    @Override // defpackage.L8
    public void skip(long j) throws EOFException {
        while (j > 0) {
            C3306lO c3306lO = this.a;
            if (c3306lO == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j, c3306lO.c - c3306lO.b);
            long j2 = iMin;
            Q(R() - j2);
            j -= j2;
            int i = c3306lO.b + iMin;
            c3306lO.b = i;
            if (i == c3306lO.c) {
                this.a = c3306lO.b();
                C3388mO.b(c3306lO);
            }
        }
    }

    public final H8 t(H8 h8, long j, long j2) {
        AbstractC4492zt.h(h8, "out");
        AbstractC2074e.b(R(), j, j2);
        if (j2 != 0) {
            h8.Q(h8.R() + j2);
            C3306lO c3306lO = this.a;
            while (true) {
                AbstractC4492zt.e(c3306lO);
                int i = c3306lO.c;
                int i2 = c3306lO.b;
                if (j < i - i2) {
                    break;
                }
                j -= (long) (i - i2);
                c3306lO = c3306lO.f;
            }
            while (j2 > 0) {
                AbstractC4492zt.e(c3306lO);
                C3306lO c3306lOD = c3306lO.d();
                int i3 = c3306lOD.b + ((int) j);
                c3306lOD.b = i3;
                c3306lOD.c = Math.min(i3 + ((int) j2), c3306lOD.c);
                C3306lO c3306lO2 = h8.a;
                if (c3306lO2 == null) {
                    c3306lOD.g = c3306lOD;
                    c3306lOD.f = c3306lOD;
                    h8.a = c3306lOD;
                } else {
                    AbstractC4492zt.e(c3306lO2);
                    C3306lO c3306lO3 = c3306lO2.g;
                    AbstractC4492zt.e(c3306lO3);
                    c3306lO3.c(c3306lOD);
                }
                j2 -= (long) (c3306lOD.c - c3306lOD.b);
                c3306lO = c3306lO.f;
                j = 0;
            }
        }
        return this;
    }

    public String toString() {
        return S().toString();
    }

    @Override // defpackage.L8
    public byte[] w(long j) throws EOFException {
        if (j < 0 || j > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j).toString());
        }
        if (R() < j) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j];
        readFully(bArr);
        return bArr;
    }

    public final byte x(long j) {
        AbstractC2074e.b(R(), j, 1L);
        C3306lO c3306lO = this.a;
        if (c3306lO == null) {
            AbstractC4492zt.e(null);
            throw null;
        }
        if (R() - j < j) {
            long jR = R();
            while (jR > j) {
                c3306lO = c3306lO.g;
                AbstractC4492zt.e(c3306lO);
                jR -= (long) (c3306lO.c - c3306lO.b);
            }
            AbstractC4492zt.e(c3306lO);
            return c3306lO.a[(int) ((((long) c3306lO.b) + j) - jR)];
        }
        long j2 = 0;
        while (true) {
            long j3 = ((long) (c3306lO.c - c3306lO.b)) + j2;
            if (j3 > j) {
                AbstractC4492zt.e(c3306lO);
                return c3306lO.a[(int) ((((long) c3306lO.b) + j) - j2)];
            }
            c3306lO = c3306lO.f;
            AbstractC4492zt.e(c3306lO);
            j2 = j3;
        }
    }

    @Override // defpackage.InterfaceC3309lR
    public long y(H8 h8, long j) {
        AbstractC4492zt.h(h8, "sink");
        if (j < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        }
        if (R() == 0) {
            return -1L;
        }
        if (j > R()) {
            j = R();
        }
        h8.p(this, j);
        return j;
    }

    public long z(byte b, long j, long j2) {
        C3306lO c3306lO;
        int i;
        long jR = 0;
        if (0 > j || j > j2) {
            throw new IllegalArgumentException(("size=" + R() + " fromIndex=" + j + " toIndex=" + j2).toString());
        }
        if (j2 > R()) {
            j2 = R();
        }
        if (j == j2 || (c3306lO = this.a) == null) {
            return -1L;
        }
        if (R() - j < j) {
            jR = R();
            while (jR > j) {
                c3306lO = c3306lO.g;
                AbstractC4492zt.e(c3306lO);
                jR -= (long) (c3306lO.c - c3306lO.b);
            }
            while (jR < j2) {
                byte[] bArr = c3306lO.a;
                int iMin = (int) Math.min(c3306lO.c, (((long) c3306lO.b) + j2) - jR);
                i = (int) ((((long) c3306lO.b) + j) - jR);
                while (i < iMin) {
                    if (bArr[i] != b) {
                        i++;
                    }
                }
                jR += (long) (c3306lO.c - c3306lO.b);
                c3306lO = c3306lO.f;
                AbstractC4492zt.e(c3306lO);
                j = jR;
            }
            return -1L;
        }
        while (true) {
            long j3 = ((long) (c3306lO.c - c3306lO.b)) + jR;
            if (j3 > j) {
                break;
            }
            c3306lO = c3306lO.f;
            AbstractC4492zt.e(c3306lO);
            jR = j3;
        }
        while (jR < j2) {
            byte[] bArr2 = c3306lO.a;
            int iMin2 = (int) Math.min(c3306lO.c, (((long) c3306lO.b) + j2) - jR);
            i = (int) ((((long) c3306lO.b) + j) - jR);
            while (i < iMin2) {
                if (bArr2[i] != b) {
                    i++;
                }
            }
            jR += (long) (c3306lO.c - c3306lO.b);
            c3306lO = c3306lO.f;
            AbstractC4492zt.e(c3306lO);
            j = jR;
        }
        return -1L;
        return ((long) (i - c3306lO.b)) + jR;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        AbstractC4492zt.h(byteBuffer, DublinCoreProperties.SOURCE);
        int iRemaining = byteBuffer.remaining();
        int i = iRemaining;
        while (i > 0) {
            C3306lO c3306lOU = U(1);
            int iMin = Math.min(i, 8192 - c3306lOU.c);
            byteBuffer.get(c3306lOU.a, c3306lOU.c, iMin);
            i -= iMin;
            c3306lOU.c += iMin;
        }
        this.b += (long) iRemaining;
        return iRemaining;
    }

    public int read(byte[] bArr, int i, int i2) {
        AbstractC4492zt.h(bArr, "sink");
        AbstractC2074e.b(bArr.length, i, i2);
        C3306lO c3306lO = this.a;
        if (c3306lO == null) {
            return -1;
        }
        int iMin = Math.min(i2, c3306lO.c - c3306lO.b);
        byte[] bArr2 = c3306lO.a;
        int i3 = c3306lO.b;
        Q5.d(bArr2, bArr, i, i3, i3 + iMin);
        c3306lO.b += iMin;
        Q(R() - ((long) iMin));
        if (c3306lO.b == c3306lO.c) {
            this.a = c3306lO.b();
            C3388mO.b(c3306lO);
        }
        return iMin;
    }

    @Override // defpackage.L8
    public H8 a() {
        return this;
    }

    @Override // defpackage.InterfaceC3309lR, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
    }

    @Override // defpackage.K8, defpackage.LQ, java.io.Flushable
    public void flush() {
    }

    @Override // defpackage.K8
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public H8 f() {
        return this;
    }

    @Override // defpackage.K8
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public H8 j() {
        return this;
    }
}
