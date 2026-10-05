package defpackage;

import com.itextpdf.tool.xml.html.HTML;
import java.net.IDN;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Locale;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: renamed from: yr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4409yr {
    public static final boolean a(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (AbstractC4492zt.j(cCharAt, 31) <= 0 || AbstractC4492zt.j(cCharAt, ShapeTypes.VERTICAL_SCROLL) >= 0 || AbstractC3961tS.Q(" #%/:?@[\\]", cCharAt, 0, false, 6, null) != -1) {
                return true;
            }
        }
        return false;
    }

    public static final boolean b(String str, int i, int i2, byte[] bArr, int i3) {
        int i4 = i3;
        while (i < i2) {
            if (i4 == bArr.length) {
                return false;
            }
            if (i4 != i3) {
                if (str.charAt(i) != '.') {
                    return false;
                }
                i++;
            }
            int i5 = i;
            int i6 = 0;
            while (i5 < i2) {
                char cCharAt = str.charAt(i5);
                if (AbstractC4492zt.j(cCharAt, 48) < 0 || AbstractC4492zt.j(cCharAt, 57) > 0) {
                    break;
                }
                if ((i6 == 0 && i != i5) || (i6 = ((i6 * 10) + cCharAt) - 48) > 255) {
                    return false;
                }
                i5++;
            }
            if (i5 - i == 0) {
                return false;
            }
            bArr[i4] = (byte) i6;
            i4++;
            i = i5;
        }
        return i4 == i3 + 4;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x006b  */
    /* JADX WARN: Code duplicated, block: B:33:0x0075 A[LOOP:1: B:30:0x0069->B:33:0x0075, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:54:0x007b A[EDGE_INSN: B:54:0x007b->B:34:0x007b BREAK  A[LOOP:1: B:30:0x0069->B:33:0x0075], SYNTHETIC] */
    public static final InetAddress c(String str, int i, int i2) {
        int i3;
        int i4;
        int iH;
        byte[] bArr = new byte[16];
        int i5 = i;
        int i6 = 0;
        int i7 = -1;
        int i8 = -1;
        while (i5 < i2) {
            if (i6 == 16) {
                return null;
            }
            int i9 = i5 + 2;
            if (i9 <= i2 && AbstractC3880sS.A(str, "::", i5, false, 4, null)) {
                if (i7 != -1) {
                    return null;
                }
                i6 += 2;
                if (i9 == i2) {
                    i7 = i6;
                    break;
                }
                i8 = i9;
                i7 = i6;
                i5 = i8;
                i3 = 0;
                while (i5 < i2) {
                    iH = AbstractC3724qX.H(str.charAt(i5));
                    if (iH != -1) {
                        break;
                        break;
                    }
                    i3 = (i3 << 4) + iH;
                    i5++;
                }
                i4 = i5 - i8;
                if (i4 != 0) {
                }
                return null;
            }
            if (i6 != 0) {
                if (!AbstractC3880sS.A(str, ":", i5, false, 4, null)) {
                    if (!AbstractC3880sS.A(str, ".", i5, false, 4, null) || !b(str, i8, i2, bArr, i6 - 2)) {
                        return null;
                    }
                    i6 += 2;
                    break;
                }
                i5++;
            }
            i8 = i5;
            i5 = i8;
            i3 = 0;
            while (i5 < i2) {
                iH = AbstractC3724qX.H(str.charAt(i5));
                if (iH != -1) {
                    break;
                }
                i3 = (i3 << 4) + iH;
                i5++;
            }
            i4 = i5 - i8;
            if (i4 != 0 || i4 > 4) {
                return null;
            }
            int i10 = i6 + 1;
            bArr[i6] = (byte) ((i3 >>> 8) & 255);
            i6 += 2;
            bArr[i10] = (byte) (i3 & 255);
        }
        if (i6 != 16) {
            if (i7 == -1) {
                return null;
            }
            int i11 = i6 - i7;
            System.arraycopy(bArr, i7, bArr, 16 - i11, i11);
            Arrays.fill(bArr, i7, (16 - i6) + i7, (byte) 0);
        }
        return InetAddress.getByAddress(bArr);
    }

    public static final String d(byte[] bArr) {
        int i = -1;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < bArr.length) {
            int i5 = i3;
            while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                i5 += 2;
            }
            int i6 = i5 - i3;
            if (i6 > i4 && i6 >= 4) {
                i = i3;
                i4 = i6;
            }
            i3 = i5 + 2;
        }
        H8 h8 = new H8();
        while (i2 < bArr.length) {
            if (i2 == i) {
                h8.writeByte(58);
                i2 += i4;
                if (i2 == 16) {
                    h8.writeByte(58);
                }
            } else {
                if (i2 > 0) {
                    h8.writeByte(58);
                }
                h8.q((AbstractC3724qX.d(bArr[i2], 255) << 8) | AbstractC3724qX.d(bArr[i2 + 1], 255));
                i2 += 2;
            }
        }
        return h8.O();
    }

    public static final String e(String str) {
        AbstractC4492zt.h(str, "<this>");
        if (!AbstractC3961tS.G(str, ":", false, 2, null)) {
            try {
                String ascii = IDN.toASCII(str);
                AbstractC4492zt.g(ascii, "toASCII(host)");
                Locale locale = Locale.US;
                AbstractC4492zt.g(locale, "US");
                String lowerCase = ascii.toLowerCase(locale);
                AbstractC4492zt.g(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                if (lowerCase.length() == 0 || a(lowerCase)) {
                    return null;
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        InetAddress inetAddressC = (AbstractC3880sS.B(str, "[", false, 2, null) && AbstractC3880sS.p(str, "]", false, 2, null)) ? c(str, 1, str.length() - 1) : c(str, 0, str.length());
        if (inetAddressC == null) {
            return null;
        }
        byte[] address = inetAddressC.getAddress();
        if (address.length == 16) {
            AbstractC4492zt.g(address, HTML.Tag.ADDRESS);
            return d(address);
        }
        if (address.length == 4) {
            return inetAddressC.getHostAddress();
        }
        throw new AssertionError("Invalid IPv6 address: '" + str + '\'');
    }
}
