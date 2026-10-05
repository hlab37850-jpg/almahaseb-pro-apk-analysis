package defpackage;

import com.google.common.primitives.UnsignedBytes;
import com.itextpdf.text.pdf.security.DigestAlgorithms;
import com.zebra.sdk.util.internal.StringUtilities;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class W8 implements Serializable, Comparable {
    public static final a d = new a(null);
    public static final W8 e = new W8(new byte[0]);
    public final byte[] a;
    public transient int b;
    public transient String c;

    public static final class a {
        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public static /* synthetic */ W8 f(a aVar, byte[] bArr, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = AbstractC2074e.c();
            }
            return aVar.e(bArr, i, i2);
        }

        public final W8 a(String str) {
            AbstractC4492zt.h(str, "<this>");
            if (str.length() % 2 != 0) {
                throw new IllegalArgumentException(("Unexpected hex string: " + str).toString());
            }
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) ((AbstractC1835c.e(str.charAt(i2)) << 4) + AbstractC1835c.e(str.charAt(i2 + 1)));
            }
            return new W8(bArr);
        }

        public final W8 b(String str, Charset charset) {
            AbstractC4492zt.h(str, "<this>");
            AbstractC4492zt.h(charset, "charset");
            byte[] bytes = str.getBytes(charset);
            AbstractC4492zt.g(bytes, "this as java.lang.String).getBytes(charset)");
            return new W8(bytes);
        }

        public final W8 c(String str) {
            AbstractC4492zt.h(str, "<this>");
            W8 w8 = new W8(D00.a(str));
            w8.r(str);
            return w8;
        }

        public final W8 d(byte... bArr) {
            AbstractC4492zt.h(bArr, "data");
            byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
            AbstractC4492zt.g(bArrCopyOf, "copyOf(this, size)");
            return new W8(bArrCopyOf);
        }

        public final W8 e(byte[] bArr, int i, int i2) {
            AbstractC4492zt.h(bArr, "<this>");
            int iF = AbstractC2074e.f(bArr, i2);
            AbstractC2074e.b(bArr.length, i, iF);
            return new W8(Q5.n(bArr, i, iF + i));
        }

        public a() {
        }
    }

    public W8(byte[] bArr) {
        AbstractC4492zt.h(bArr, "data");
        this.a = bArr;
    }

    public static final W8 n(byte... bArr) {
        return d.d(bArr);
    }

    public String a() {
        return AbstractC1188a.b(f(), null, 1, null);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002c A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:9:0x002a A[ORIG_RETURN, RETURN] */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(W8 w8) {
        AbstractC4492zt.h(w8, "other");
        int iU = u();
        int iU2 = w8.u();
        int iMin = Math.min(iU, iU2);
        for (int i = 0; i < iMin; i++) {
            int iE = e(i) & UnsignedBytes.MAX_VALUE;
            int iE2 = w8.e(i) & UnsignedBytes.MAX_VALUE;
            if (iE != iE2) {
                if (iE < iE2) {
                    return -1;
                }
                return 1;
            }
        }
        if (iU == iU2) {
            return 0;
        }
        if (iU < iU2) {
            return -1;
        }
        return 1;
    }

    public W8 c(String str) throws NoSuchAlgorithmException {
        AbstractC4492zt.h(str, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        messageDigest.update(this.a, 0, u());
        byte[] bArrDigest = messageDigest.digest();
        AbstractC4492zt.e(bArrDigest);
        return new W8(bArrDigest);
    }

    public final byte e(int i) {
        return m(i);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof W8) {
            W8 w8 = (W8) obj;
            if (w8.u() == f().length && w8.p(0, f(), 0, f().length)) {
                return true;
            }
        }
        return false;
    }

    public final byte[] f() {
        return this.a;
    }

    public final int h() {
        return this.b;
    }

    public int hashCode() {
        int iH = h();
        if (iH != 0) {
            return iH;
        }
        int iHashCode = Arrays.hashCode(f());
        q(iHashCode);
        return iHashCode;
    }

    public int i() {
        return f().length;
    }

    public final String j() {
        return this.c;
    }

    public String k() {
        char[] cArr = new char[f().length * 2];
        int i = 0;
        for (byte b : f()) {
            int i2 = i + 1;
            cArr[i] = AbstractC1835c.f()[(b >> 4) & 15];
            i += 2;
            cArr[i2] = AbstractC1835c.f()[b & 15];
        }
        return AbstractC3880sS.m(cArr);
    }

    public byte[] l() {
        return f();
    }

    public byte m(int i) {
        return f()[i];
    }

    public boolean o(int i, W8 w8, int i2, int i3) {
        AbstractC4492zt.h(w8, "other");
        return w8.p(i2, f(), i, i3);
    }

    public boolean p(int i, byte[] bArr, int i2, int i3) {
        AbstractC4492zt.h(bArr, "other");
        return i >= 0 && i <= f().length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && AbstractC2074e.a(f(), i, bArr, i2, i3);
    }

    public final void q(int i) {
        this.b = i;
    }

    public final void r(String str) {
        this.c = str;
    }

    public final W8 s() {
        return c(DigestAlgorithms.SHA1);
    }

    public final W8 t() {
        return c("SHA-256");
    }

    public String toString() {
        String str;
        if (f().length == 0) {
            str = "[size=0]";
        } else {
            int iC = AbstractC1835c.c(f(), 64);
            if (iC != -1) {
                String strY = y();
                String strSubstring = strY.substring(0, iC);
                AbstractC4492zt.g(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                String strX = AbstractC3880sS.x(AbstractC3880sS.x(AbstractC3880sS.x(strSubstring, "\\", "\\\\", false, 4, null), StringUtilities.LF, "\\n", false, 4, null), "\r", "\\r", false, 4, null);
                if (iC >= strY.length()) {
                    return "[text=" + strX + ']';
                }
                return "[size=" + f().length + " text=" + strX + "…]";
            }
            if (f().length > 64) {
                StringBuilder sb = new StringBuilder();
                sb.append("[size=");
                sb.append(f().length);
                sb.append(" hex=");
                int iE = AbstractC2074e.e(this, 64);
                if (iE <= f().length) {
                    if (iE < 0) {
                        throw new IllegalArgumentException("endIndex < beginIndex");
                    }
                    sb.append((iE == f().length ? this : new W8(Q5.n(f(), 0, iE))).k());
                    sb.append("…]");
                    return sb.toString();
                }
                throw new IllegalArgumentException(("endIndex > length(" + f().length + ')').toString());
            }
            str = "[hex=" + k() + ']';
        }
        return str;
    }

    public final int u() {
        return i();
    }

    public final boolean v(W8 w8) {
        AbstractC4492zt.h(w8, "prefix");
        return o(0, w8, 0, w8.u());
    }

    public W8 w() {
        for (int i = 0; i < f().length; i++) {
            byte b = f()[i];
            if (b >= 65 && b <= 90) {
                byte[] bArrF = f();
                byte[] bArrCopyOf = Arrays.copyOf(bArrF, bArrF.length);
                AbstractC4492zt.g(bArrCopyOf, "copyOf(this, size)");
                bArrCopyOf[i] = (byte) (b + 32);
                for (int i2 = i + 1; i2 < bArrCopyOf.length; i2++) {
                    byte b2 = bArrCopyOf[i2];
                    if (b2 >= 65 && b2 <= 90) {
                        bArrCopyOf[i2] = (byte) (b2 + 32);
                    }
                }
                return new W8(bArrCopyOf);
            }
        }
        return this;
    }

    public byte[] x() {
        byte[] bArrF = f();
        byte[] bArrCopyOf = Arrays.copyOf(bArrF, bArrF.length);
        AbstractC4492zt.g(bArrCopyOf, "copyOf(this, size)");
        return bArrCopyOf;
    }

    public String y() {
        String strJ = j();
        if (strJ != null) {
            return strJ;
        }
        String strB = D00.b(l());
        r(strB);
        return strB;
    }

    public void z(H8 h8, int i, int i2) {
        AbstractC4492zt.h(h8, "buffer");
        AbstractC1835c.d(this, h8, i, i2);
    }
}
