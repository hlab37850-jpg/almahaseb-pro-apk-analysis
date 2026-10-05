package defpackage;

import androidx.autofill.HintConstants;
import com.google.common.primitives.UnsignedBytes;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.html.HTML;
import com.itextpdf.xmp.XMPConst;
import java.io.EOFException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: renamed from: Nr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0779Nr {
    public static final b k = new b(null);
    public static final char[] l = {'0', '1', PdfWriter.VERSION_1_2, PdfWriter.VERSION_1_3, PdfWriter.VERSION_1_4, PdfWriter.VERSION_1_5, PdfWriter.VERSION_1_6, PdfWriter.VERSION_1_7, '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final int e;
    public final List f;
    public final List g;
    public final String h;
    public final String i;
    public final boolean j;

    /* JADX INFO: renamed from: Nr$a */
    public static final class a {
        public static final C0012a i = new C0012a(null);
        public String a;
        public String d;
        public final List f;
        public List g;
        public String h;
        public String b = "";
        public String c = "";
        public int e = -1;

        /* JADX INFO: renamed from: Nr$a$a, reason: collision with other inner class name */
        public static final class C0012a {
            public /* synthetic */ C0012a(AbstractC0419Di abstractC0419Di) {
                this();
            }

            public final int e(String str, int i, int i2) {
                try {
                    int i3 = Integer.parseInt(b.b(C0779Nr.k, str, i, i2, "", false, false, false, false, null, 248, null));
                    if (1 > i3 || i3 >= 65536) {
                        return -1;
                    }
                    return i3;
                } catch (NumberFormatException unused) {
                    return -1;
                }
            }

            public final int f(String str, int i, int i2) {
                while (i < i2) {
                    char cCharAt = str.charAt(i);
                    if (cCharAt == '[') {
                        do {
                            i++;
                            if (i >= i2) {
                                break;
                            }
                        } while (str.charAt(i) != ']');
                    } else if (cCharAt == ':') {
                        return i;
                    }
                    i++;
                }
                return i2;
            }

            public final int g(String str, int i, int i2) {
                if (i2 - i < 2) {
                    return -1;
                }
                char cCharAt = str.charAt(i);
                if ((AbstractC4492zt.j(cCharAt, 97) < 0 || AbstractC4492zt.j(cCharAt, 122) > 0) && (AbstractC4492zt.j(cCharAt, 65) < 0 || AbstractC4492zt.j(cCharAt, 90) > 0)) {
                    return -1;
                }
                while (true) {
                    i++;
                    if (i >= i2) {
                        return -1;
                    }
                    char cCharAt2 = str.charAt(i);
                    if ('a' > cCharAt2 || cCharAt2 >= '{') {
                        if ('A' > cCharAt2 || cCharAt2 >= '[') {
                            if ('0' > cCharAt2 || cCharAt2 >= ':') {
                                if (cCharAt2 != '+' && cCharAt2 != '-' && cCharAt2 != '.') {
                                    if (cCharAt2 == ':') {
                                        return i;
                                    }
                                    return -1;
                                }
                            }
                        }
                    }
                }
            }

            public final int h(String str, int i, int i2) {
                int i3 = 0;
                while (i < i2) {
                    char cCharAt = str.charAt(i);
                    if (cCharAt != '\\' && cCharAt != '/') {
                        break;
                    }
                    i3++;
                    i++;
                }
                return i3;
            }

            public C0012a() {
            }
        }

        public a() {
            ArrayList arrayList = new ArrayList();
            this.f = arrayList;
            arrayList.add("");
        }

        public final C0779Nr a() {
            ArrayList arrayList;
            String str = this.a;
            if (str == null) {
                throw new IllegalStateException("scheme == null");
            }
            b bVar = C0779Nr.k;
            String strH = b.h(bVar, this.b, 0, 0, false, 7, null);
            String strH2 = b.h(bVar, this.c, 0, 0, false, 7, null);
            String str2 = this.d;
            if (str2 == null) {
                throw new IllegalStateException("host == null");
            }
            int iB = b();
            List list = this.f;
            ArrayList arrayList2 = new ArrayList(AbstractC2044dc.x(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(b.h(C0779Nr.k, (String) it.next(), 0, 0, false, 7, null));
            }
            List list2 = this.g;
            if (list2 != null) {
                List<String> list3 = list2;
                arrayList = new ArrayList(AbstractC2044dc.x(list3, 10));
                for (String str3 : list3) {
                    arrayList.add(str3 != null ? b.h(C0779Nr.k, str3, 0, 0, true, 3, null) : null);
                }
            } else {
                arrayList = null;
            }
            String str4 = this.h;
            return new C0779Nr(str, strH, strH2, str2, iB, arrayList2, arrayList, str4 != null ? b.h(C0779Nr.k, str4, 0, 0, false, 7, null) : null, toString());
        }

        public final int b() {
            int i2 = this.e;
            if (i2 != -1) {
                return i2;
            }
            b bVar = C0779Nr.k;
            String str = this.a;
            AbstractC4492zt.e(str);
            return bVar.c(str);
        }

        /* JADX WARN: Code duplicated, block: B:6:0x001d  */
        public final a c(String str) {
            List listJ;
            if (str != null) {
                b bVar = C0779Nr.k;
                String strB = b.b(bVar, str, 0, 0, " \"'<>#", true, false, true, false, null, 211, null);
                if (strB != null) {
                    listJ = bVar.j(strB);
                } else {
                    listJ = null;
                }
            } else {
                listJ = null;
            }
            this.g = listJ;
            return this;
        }

        public final List d() {
            return this.f;
        }

        public final a e(String str) {
            AbstractC4492zt.h(str, "host");
            String strE = AbstractC4409yr.e(b.h(C0779Nr.k, str, 0, 0, false, 7, null));
            if (strE != null) {
                this.d = strE;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + str);
        }

        public final boolean f(String str) {
            return AbstractC4492zt.d(str, ".") || AbstractC3880sS.q(str, "%2e", true);
        }

        public final boolean g(String str) {
            return AbstractC4492zt.d(str, "..") || AbstractC3880sS.q(str, "%2e.", true) || AbstractC3880sS.q(str, ".%2e", true) || AbstractC3880sS.q(str, "%2e%2e", true);
        }

        public final a h(C0779Nr c0779Nr, String str) {
            int iQ;
            int i2;
            int i3;
            boolean z;
            String str2 = str;
            AbstractC4492zt.h(str2, HTML.Tag.INPUT);
            int iA = AbstractC3724qX.A(str2, 0, 0, 3, null);
            int iC = AbstractC3724qX.C(str2, iA, 0, 2, null);
            C0012a c0012a = i;
            int iG = c0012a.g(str2, iA, iC);
            byte b = -1;
            if (iG != -1) {
                if (AbstractC3880sS.y(str2, "https:", iA, true)) {
                    this.a = "https";
                    iA += 6;
                } else {
                    if (!AbstractC3880sS.y(str2, "http:", iA, true)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Expected URL scheme 'http' or 'https' but was '");
                        String strSubstring = str2.substring(0, iG);
                        AbstractC4492zt.g(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                        sb.append(strSubstring);
                        sb.append('\'');
                        throw new IllegalArgumentException(sb.toString());
                    }
                    this.a = "http";
                    iA += 5;
                }
            } else {
                if (c0779Nr == null) {
                    if (str.length() > 6) {
                        str2 = AbstractC4123vS.G0(str2, 6) + "...";
                    }
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no scheme was found for " + str2);
                }
                this.a = c0779Nr.q();
            }
            int iH = c0012a.h(str2, iA, iC);
            byte b2 = 63;
            byte b3 = 35;
            if (iH >= 2 || c0779Nr == null || !AbstractC4492zt.d(c0779Nr.q(), this.a)) {
                int i4 = iA + iH;
                boolean z2 = false;
                boolean z3 = false;
                while (true) {
                    iQ = AbstractC3724qX.q(str2, "@/\\?#", i4, iC);
                    byte bCharAt = iQ != iC ? str2.charAt(iQ) : (byte) -1;
                    if (bCharAt == b || bCharAt == b3 || bCharAt == 47 || bCharAt == 92 || bCharAt == b2) {
                        break;
                    }
                    if (bCharAt == 64) {
                        if (z2) {
                            i3 = iQ;
                            this.c += "%40" + b.b(C0779Nr.k, str, i4, i3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                        } else {
                            int iP = AbstractC3724qX.p(str2, ':', i4, iQ);
                            b bVar = C0779Nr.k;
                            String strB = b.b(bVar, str, i4, iP, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                            if (z3) {
                                strB = this.b + "%40" + strB;
                            }
                            this.b = strB;
                            i3 = iQ;
                            if (iP != i3) {
                                this.c = b.b(bVar, str, iP + 1, i3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                                z = true;
                            } else {
                                z = z2;
                            }
                            z2 = z;
                            z3 = true;
                        }
                        i4 = i3 + 1;
                        iC = iC;
                        b3 = 35;
                        b2 = 63;
                        b = -1;
                    }
                }
                i2 = iC;
                C0012a c0012a2 = i;
                int iF = c0012a2.f(str2, i4, iQ);
                int i5 = iF + 1;
                if (i5 < iQ) {
                    this.d = AbstractC4409yr.e(b.h(C0779Nr.k, str, i4, iF, false, 4, null));
                    int iE = c0012a2.e(str2, i5, iQ);
                    this.e = iE;
                    if (iE == -1) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Invalid URL port: \"");
                        String strSubstring2 = str2.substring(i5, iQ);
                        AbstractC4492zt.g(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                        sb2.append(strSubstring2);
                        sb2.append('\"');
                        throw new IllegalArgumentException(sb2.toString().toString());
                    }
                } else {
                    b bVar2 = C0779Nr.k;
                    this.d = AbstractC4409yr.e(b.h(bVar2, str, i4, iF, false, 4, null));
                    String str3 = this.a;
                    AbstractC4492zt.e(str3);
                    this.e = bVar2.c(str3);
                }
                if (this.d == null) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Invalid URL host: \"");
                    String strSubstring3 = str2.substring(i4, iF);
                    AbstractC4492zt.g(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
                    sb3.append(strSubstring3);
                    sb3.append('\"');
                    throw new IllegalArgumentException(sb3.toString().toString());
                }
                iA = iQ;
            } else {
                this.b = c0779Nr.g();
                this.c = c0779Nr.c();
                this.d = c0779Nr.h();
                this.e = c0779Nr.m();
                this.f.clear();
                this.f.addAll(c0779Nr.e());
                if (iA == iC || str2.charAt(iA) == '#') {
                    c(c0779Nr.f());
                }
                i2 = iC;
            }
            int i6 = i2;
            int iQ2 = AbstractC3724qX.q(str2, "?#", iA, i6);
            n(str2, iA, iQ2);
            if (iQ2 < i6 && str2.charAt(iQ2) == '?') {
                int iP2 = AbstractC3724qX.p(str2, '#', iQ2, i6);
                b bVar3 = C0779Nr.k;
                this.g = bVar3.j(b.b(bVar3, str, iQ2 + 1, iP2, " \"'<>#", true, false, true, false, null, 208, null));
                iQ2 = iP2;
            }
            if (iQ2 < i6 && str2.charAt(iQ2) == '#') {
                this.h = b.b(C0779Nr.k, str, iQ2 + 1, i6, "", true, false, false, true, null, ShapeTypes.MATH_PLUS, null);
            }
            return this;
        }

        public final a i(String str) {
            AbstractC4492zt.h(str, HintConstants.AUTOFILL_HINT_PASSWORD);
            this.c = b.b(C0779Nr.k, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return this;
        }

        public final void j() {
            List list = this.f;
            if (((String) list.remove(list.size() - 1)).length() != 0 || this.f.isEmpty()) {
                this.f.add("");
            } else {
                List list2 = this.f;
                list2.set(list2.size() - 1, "");
            }
        }

        public final a k(int i2) {
            if (1 <= i2 && i2 < 65536) {
                this.e = i2;
                return this;
            }
            throw new IllegalArgumentException(("unexpected port: " + i2).toString());
        }

        public final void l(String str, int i2, int i3, boolean z, boolean z2) {
            String strB = b.b(C0779Nr.k, str, i2, i3, " \"<>^`{}|/\\?#", z2, false, false, false, null, 240, null);
            if (f(strB)) {
                return;
            }
            if (g(strB)) {
                j();
                return;
            }
            List list = this.f;
            if (((CharSequence) list.get(list.size() - 1)).length() == 0) {
                List list2 = this.f;
                list2.set(list2.size() - 1, strB);
            } else {
                this.f.add(strB);
            }
            if (z) {
                this.f.add("");
            }
        }

        public final a m() {
            String str = this.d;
            this.d = str != null ? new SJ("[\"<>^`{|}]").e(str, "") : null;
            int size = this.f.size();
            for (int i2 = 0; i2 < size; i2++) {
                List list = this.f;
                list.set(i2, b.b(C0779Nr.k, (String) list.get(i2), 0, 0, XMPConst.ARRAY_ITEM_NAME, true, true, false, false, null, 227, null));
            }
            List list2 = this.g;
            if (list2 != null) {
                int size2 = list2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    String str2 = (String) list2.get(i3);
                    list2.set(i3, str2 != null ? b.b(C0779Nr.k, str2, 0, 0, "\\^`{|}", true, true, true, false, null, 195, null) : null);
                }
            }
            String str3 = this.h;
            this.h = str3 != null ? b.b(C0779Nr.k, str3, 0, 0, " \"#<>\\^`{|}", true, true, false, true, null, ShapeTypes.ACTION_BUTTON_HELP, null) : null;
            return this;
        }

        public final void n(String str, int i2, int i3) {
            if (i2 == i3) {
                return;
            }
            char cCharAt = str.charAt(i2);
            if (cCharAt == '/' || cCharAt == '\\') {
                this.f.clear();
                this.f.add("");
                i2++;
            } else {
                List list = this.f;
                list.set(list.size() - 1, "");
            }
            while (true) {
                int i4 = i2;
                while (i4 < i3) {
                    i2 = AbstractC3724qX.q(str, "/\\", i4, i3);
                    boolean z = i2 < i3;
                    l(str, i4, i2, z, true);
                    if (z) {
                        i4 = i2 + 1;
                    }
                }
                return;
            }
        }

        public final a o(String str) {
            AbstractC4492zt.h(str, "scheme");
            if (AbstractC3880sS.q(str, "http", true)) {
                this.a = "http";
            } else {
                if (!AbstractC3880sS.q(str, "https", true)) {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
                this.a = "https";
            }
            return this;
        }

        public final void p(String str) {
            this.h = str;
        }

        public final void q(String str) {
            AbstractC4492zt.h(str, "<set-?>");
            this.c = str;
        }

        public final void r(String str) {
            AbstractC4492zt.h(str, "<set-?>");
            this.b = str;
        }

        public final void s(String str) {
            this.d = str;
        }

        public final void t(int i2) {
            this.e = i2;
        }

        /* JADX WARN: Code duplicated, block: B:29:0x0085  */
        public String toString() {
            StringBuilder sb = new StringBuilder();
            String str = this.a;
            if (str != null) {
                sb.append(str);
                sb.append("://");
            } else {
                sb.append("//");
            }
            if (this.b.length() > 0 || this.c.length() > 0) {
                sb.append(this.b);
                if (this.c.length() > 0) {
                    sb.append(':');
                    sb.append(this.c);
                }
                sb.append('@');
            }
            String str2 = this.d;
            if (str2 != null) {
                AbstractC4492zt.e(str2);
                if (AbstractC3961tS.F(str2, ':', false, 2, null)) {
                    sb.append('[');
                    sb.append(this.d);
                    sb.append(']');
                } else {
                    sb.append(this.d);
                }
            }
            if (this.e != -1 || this.a != null) {
                int iB = b();
                String str3 = this.a;
                if (str3 != null) {
                    b bVar = C0779Nr.k;
                    AbstractC4492zt.e(str3);
                    if (iB != bVar.c(str3)) {
                        sb.append(':');
                        sb.append(iB);
                    }
                } else {
                    sb.append(':');
                    sb.append(iB);
                }
            }
            b bVar2 = C0779Nr.k;
            bVar2.i(this.f, sb);
            if (this.g != null) {
                sb.append('?');
                List list = this.g;
                AbstractC4492zt.e(list);
                bVar2.k(list, sb);
            }
            if (this.h != null) {
                sb.append('#');
                sb.append(this.h);
            }
            String string = sb.toString();
            AbstractC4492zt.g(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }

        public final void u(String str) {
            this.a = str;
        }

        public final a v(String str) {
            AbstractC4492zt.h(str, HintConstants.AUTOFILL_HINT_USERNAME);
            this.b = b.b(C0779Nr.k, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return this;
        }
    }

    /* JADX INFO: renamed from: Nr$b */
    public static final class b {
        public /* synthetic */ b(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public static /* synthetic */ String b(b bVar, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset, int i3, Object obj) {
            return bVar.a(str, (i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? str.length() : i2, str2, (i3 & 8) != 0 ? false : z, (i3 & 16) != 0 ? false : z2, (i3 & 32) != 0 ? false : z3, (i3 & 64) != 0 ? false : z4, (i3 & 128) != 0 ? null : charset);
        }

        public static /* synthetic */ String h(b bVar, String str, int i, int i2, boolean z, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = str.length();
            }
            if ((i3 & 4) != 0) {
                z = false;
            }
            return bVar.g(str, i, i2, z);
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0041  */
        public final String a(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) throws EOFException {
            AbstractC4492zt.h(str, "<this>");
            AbstractC4492zt.h(str2, "encodeSet");
            int iCharCount = i;
            while (true) {
                if (iCharCount >= i2) {
                    String strSubstring = str.substring(i, i2);
                    AbstractC4492zt.g(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    return strSubstring;
                }
                int iCodePointAt = str.codePointAt(iCharCount);
                if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && !z4) || AbstractC3961tS.F(str2, (char) iCodePointAt, false, 2, null))) {
                    break;
                }
                if (iCodePointAt == 37) {
                    if (!z) {
                        break;
                    }
                    if (z2) {
                        if (e(str, iCharCount, i2)) {
                        }
                    }
                    if (iCodePointAt == 43) {
                    }
                    iCharCount += Character.charCount(iCodePointAt);
                } else if (iCodePointAt == 43 || !z3) {
                    iCharCount += Character.charCount(iCodePointAt);
                }
                H8 h8 = new H8();
                h8.g0(str, i, iCharCount);
                l(h8, str, iCharCount, i2, str2, z, z2, z3, z4, charset);
                return h8.O();
            }
            H8 h9 = new H8();
            h9.g0(str, i, iCharCount);
            l(h9, str, iCharCount, i2, str2, z, z2, z3, z4, charset);
            return h9.O();
        }

        public final int c(String str) {
            AbstractC4492zt.h(str, "scheme");
            if (AbstractC4492zt.d(str, "http")) {
                return 80;
            }
            return AbstractC4492zt.d(str, "https") ? 443 : -1;
        }

        public final C0779Nr d(String str) {
            AbstractC4492zt.h(str, "<this>");
            return new a().h(null, str).a();
        }

        public final boolean e(String str, int i, int i2) {
            int i3 = i + 2;
            return i3 < i2 && str.charAt(i) == '%' && AbstractC3724qX.H(str.charAt(i + 1)) != -1 && AbstractC3724qX.H(str.charAt(i3)) != -1;
        }

        public final C0779Nr f(String str) {
            AbstractC4492zt.h(str, "<this>");
            try {
                return d(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public final String g(String str, int i, int i2, boolean z) {
            AbstractC4492zt.h(str, "<this>");
            for (int i3 = i; i3 < i2; i3++) {
                char cCharAt = str.charAt(i3);
                if (cCharAt == '%' || (cCharAt == '+' && z)) {
                    H8 h8 = new H8();
                    h8.g0(str, i, i3);
                    m(h8, str, i3, i2, z);
                    return h8.O();
                }
            }
            String strSubstring = str.substring(i, i2);
            AbstractC4492zt.g(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            return strSubstring;
        }

        public final void i(List list, StringBuilder sb) {
            AbstractC4492zt.h(list, "<this>");
            AbstractC4492zt.h(sb, "out");
            int size = list.size();
            for (int i = 0; i < size; i++) {
                sb.append('/');
                sb.append((String) list.get(i));
            }
        }

        public final List j(String str) {
            AbstractC4492zt.h(str, "<this>");
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (i <= str.length()) {
                int iQ = AbstractC3961tS.Q(str, '&', i, false, 4, null);
                if (iQ == -1) {
                    iQ = str.length();
                }
                int i2 = iQ;
                int iQ2 = AbstractC3961tS.Q(str, '=', i, false, 4, null);
                if (iQ2 == -1 || iQ2 > i2) {
                    String strSubstring = str.substring(i, i2);
                    AbstractC4492zt.g(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring);
                    arrayList.add(null);
                } else {
                    String strSubstring2 = str.substring(i, iQ2);
                    AbstractC4492zt.g(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring2);
                    String strSubstring3 = str.substring(iQ2 + 1, i2);
                    AbstractC4492zt.g(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring3);
                }
                i = i2 + 1;
            }
            return arrayList;
        }

        public final void k(List list, StringBuilder sb) {
            AbstractC4492zt.h(list, "<this>");
            AbstractC4492zt.h(sb, "out");
            C0945Ts c0945TsR = AbstractC3871sJ.r(AbstractC3871sJ.s(0, list.size()), 2);
            int iB = c0945TsR.b();
            int iC = c0945TsR.c();
            int iD = c0945TsR.d();
            if ((iD <= 0 || iB > iC) && (iD >= 0 || iC > iB)) {
                return;
            }
            while (true) {
                String str = (String) list.get(iB);
                String str2 = (String) list.get(iB + 1);
                if (iB > 0) {
                    sb.append('&');
                }
                sb.append(str);
                if (str2 != null) {
                    sb.append('=');
                    sb.append(str2);
                }
                if (iB == iC) {
                    return;
                } else {
                    iB += iD;
                }
            }
        }

        /* JADX WARN: Code duplicated, block: B:39:0x0067  */
        /* JADX WARN: Code duplicated, block: B:40:0x0069  */
        /* JADX WARN: Code duplicated, block: B:43:0x0071  */
        /* JADX WARN: Code duplicated, block: B:49:0x008a  */
        /* JADX WARN: Code duplicated, block: B:52:0x0093 A[LOOP:1: B:50:0x008d->B:52:0x0093, LOOP_END] */
        public final void l(H8 h8, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) throws EOFException {
            int iCharCount = i;
            H8 h9 = null;
            while (iCharCount < i2) {
                int iCodePointAt = str.codePointAt(iCharCount);
                if (!z || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                    if (iCodePointAt == 43 && z3) {
                        h8.l(z ? "+" : "%2B");
                    } else if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && !z4) || AbstractC3961tS.F(str2, (char) iCodePointAt, false, 2, null))) {
                        if (h9 == null) {
                            h9 = new H8();
                        }
                        if (charset != null || AbstractC4492zt.d(charset, StandardCharsets.UTF_8)) {
                            h9.h0(iCodePointAt);
                        } else {
                            h9.e0(str, iCharCount, Character.charCount(iCodePointAt) + iCharCount, charset);
                        }
                        while (!h9.h()) {
                            byte b = h9.readByte();
                            int i3 = b & UnsignedBytes.MAX_VALUE;
                            h8.writeByte(37);
                            h8.writeByte(C0779Nr.l[(i3 >> 4) & 15]);
                            h8.writeByte(C0779Nr.l[b & 15]);
                        }
                    } else {
                        if (iCodePointAt == 37) {
                            if (z) {
                                if (z2) {
                                    if (!e(str, iCharCount, i2)) {
                                    }
                                }
                            }
                            if (h9 == null) {
                                h9 = new H8();
                            }
                            if (charset != null) {
                                h9.h0(iCodePointAt);
                            } else {
                                h9.h0(iCodePointAt);
                            }
                            while (!h9.h()) {
                                byte b2 = h9.readByte();
                                int i4 = b2 & UnsignedBytes.MAX_VALUE;
                                h8.writeByte(37);
                                h8.writeByte(C0779Nr.l[(i4 >> 4) & 15]);
                                h8.writeByte(C0779Nr.l[b2 & 15]);
                            }
                        }
                        h8.h0(iCodePointAt);
                    }
                }
                iCharCount += Character.charCount(iCodePointAt);
            }
        }

        public final void m(H8 h8, String str, int i, int i2, boolean z) {
            int i3;
            while (i < i2) {
                int iCodePointAt = str.codePointAt(i);
                if (iCodePointAt == 37 && (i3 = i + 2) < i2) {
                    int iH = AbstractC3724qX.H(str.charAt(i + 1));
                    int iH2 = AbstractC3724qX.H(str.charAt(i3));
                    if (iH == -1 || iH2 == -1) {
                        h8.h0(iCodePointAt);
                        i += Character.charCount(iCodePointAt);
                    } else {
                        h8.writeByte((iH << 4) + iH2);
                        i = Character.charCount(iCodePointAt) + i3;
                    }
                } else if (iCodePointAt == 43 && z) {
                    h8.writeByte(32);
                    i++;
                } else {
                    h8.h0(iCodePointAt);
                    i += Character.charCount(iCodePointAt);
                }
            }
        }

        public b() {
        }
    }

    public C0779Nr(String str, String str2, String str3, String str4, int i, List list, List list2, String str5, String str6) {
        AbstractC4492zt.h(str, "scheme");
        AbstractC4492zt.h(str2, HintConstants.AUTOFILL_HINT_USERNAME);
        AbstractC4492zt.h(str3, HintConstants.AUTOFILL_HINT_PASSWORD);
        AbstractC4492zt.h(str4, "host");
        AbstractC4492zt.h(list, "pathSegments");
        AbstractC4492zt.h(str6, "url");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = i;
        this.f = list;
        this.g = list2;
        this.h = str5;
        this.i = str6;
        this.j = AbstractC4492zt.d(str, "https");
    }

    public static final C0779Nr l(String str) {
        return k.f(str);
    }

    public final String b() {
        if (this.h == null) {
            return null;
        }
        String strSubstring = this.i.substring(AbstractC3961tS.Q(this.i, '#', 0, false, 6, null) + 1);
        AbstractC4492zt.g(strSubstring, "this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }

    public final String c() {
        if (this.c.length() == 0) {
            return "";
        }
        String strSubstring = this.i.substring(AbstractC3961tS.Q(this.i, ':', this.a.length() + 3, false, 4, null) + 1, AbstractC3961tS.Q(this.i, '@', 0, false, 6, null));
        AbstractC4492zt.g(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final String d() {
        int iQ = AbstractC3961tS.Q(this.i, '/', this.a.length() + 3, false, 4, null);
        String str = this.i;
        String strSubstring = this.i.substring(iQ, AbstractC3724qX.q(str, "?#", iQ, str.length()));
        AbstractC4492zt.g(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final List e() {
        int iQ = AbstractC3961tS.Q(this.i, '/', this.a.length() + 3, false, 4, null);
        String str = this.i;
        int iQ2 = AbstractC3724qX.q(str, "?#", iQ, str.length());
        ArrayList arrayList = new ArrayList();
        while (iQ < iQ2) {
            int i = iQ + 1;
            int iP = AbstractC3724qX.p(this.i, '/', i, iQ2);
            String strSubstring = this.i.substring(i, iP);
            AbstractC4492zt.g(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            arrayList.add(strSubstring);
            iQ = iP;
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C0779Nr) && AbstractC4492zt.d(((C0779Nr) obj).i, this.i);
    }

    public final String f() {
        if (this.g == null) {
            return null;
        }
        int iQ = AbstractC3961tS.Q(this.i, '?', 0, false, 6, null) + 1;
        String str = this.i;
        String strSubstring = this.i.substring(iQ, AbstractC3724qX.p(str, '#', iQ, str.length()));
        AbstractC4492zt.g(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final String g() {
        if (this.b.length() == 0) {
            return "";
        }
        int length = this.a.length() + 3;
        String str = this.i;
        String strSubstring = this.i.substring(length, AbstractC3724qX.q(str, ":@", length, str.length()));
        AbstractC4492zt.g(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final String h() {
        return this.d;
    }

    public int hashCode() {
        return this.i.hashCode();
    }

    public final boolean i() {
        return this.j;
    }

    public final a j() {
        a aVar = new a();
        aVar.u(this.a);
        aVar.r(g());
        aVar.q(c());
        aVar.s(this.d);
        aVar.t(this.e != k.c(this.a) ? this.e : -1);
        aVar.d().clear();
        aVar.d().addAll(e());
        aVar.c(f());
        aVar.p(b());
        return aVar;
    }

    public final a k(String str) {
        AbstractC4492zt.h(str, HTML.Tag.LINK);
        try {
            return new a().h(this, str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public final int m() {
        return this.e;
    }

    public final String n() {
        if (this.g == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        k.k(this.g, sb);
        return sb.toString();
    }

    public final String o() {
        a aVarK = k("/...");
        AbstractC4492zt.e(aVarK);
        return aVarK.v("").i("").a().toString();
    }

    public final C0779Nr p(String str) {
        AbstractC4492zt.h(str, HTML.Tag.LINK);
        a aVarK = k(str);
        if (aVarK != null) {
            return aVarK.a();
        }
        return null;
    }

    public final String q() {
        return this.a;
    }

    public final URI r() {
        String string = j().m().toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e) {
            try {
                URI uriCreate = URI.create(new SJ("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").e(string, ""));
                AbstractC4492zt.g(uriCreate, "{\n      // Unlikely edge…Unexpected!\n      }\n    }");
                return uriCreate;
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    public final URL s() {
        try {
            return new URL(this.i);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public String toString() {
        return this.i;
    }
}
