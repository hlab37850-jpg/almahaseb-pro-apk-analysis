package defpackage;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.api.client.http.HttpMethods;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import com.itextpdf.tool.xml.html.HTML;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: renamed from: zr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C4490zr {
    public static final C4490zr a;
    public static final C3752qr[] b;
    public static final Map c;

    static {
        C4490zr c4490zr = new C4490zr();
        a = c4490zr;
        C3752qr c3752qr = new C3752qr(C3752qr.j, "");
        W8 w8 = C3752qr.g;
        C3752qr c3752qr2 = new C3752qr(w8, HttpMethods.GET);
        C3752qr c3752qr3 = new C3752qr(w8, HttpMethods.POST);
        W8 w9 = C3752qr.h;
        C3752qr c3752qr4 = new C3752qr(w9, "/");
        C3752qr c3752qr5 = new C3752qr(w9, "/index.html");
        W8 w10 = C3752qr.i;
        C3752qr c3752qr6 = new C3752qr(w10, "http");
        C3752qr c3752qr7 = new C3752qr(w10, "https");
        W8 w11 = C3752qr.f;
        b = new C3752qr[]{c3752qr, c3752qr2, c3752qr3, c3752qr4, c3752qr5, c3752qr6, c3752qr7, new C3752qr(w11, "200"), new C3752qr(w11, "204"), new C3752qr(w11, "206"), new C3752qr(w11, "304"), new C3752qr(w11, "400"), new C3752qr(w11, "404"), new C3752qr(w11, "500"), new C3752qr("accept-charset", ""), new C3752qr("accept-encoding", "gzip, deflate"), new C3752qr("accept-language", ""), new C3752qr("accept-ranges", ""), new C3752qr("accept", ""), new C3752qr("access-control-allow-origin", ""), new C3752qr("age", ""), new C3752qr("allow", ""), new C3752qr("authorization", ""), new C3752qr("cache-control", ""), new C3752qr("content-disposition", ""), new C3752qr("content-encoding", ""), new C3752qr("content-language", ""), new C3752qr("content-length", ""), new C3752qr("content-location", ""), new C3752qr("content-range", ""), new C3752qr("content-type", ""), new C3752qr("cookie", ""), new C3752qr(DublinCoreProperties.DATE, ""), new C3752qr("etag", ""), new C3752qr("expect", ""), new C3752qr("expires", ""), new C3752qr(TypedValues.TransitionType.S_FROM, ""), new C3752qr("host", ""), new C3752qr("if-match", ""), new C3752qr("if-modified-since", ""), new C3752qr("if-none-match", ""), new C3752qr("if-range", ""), new C3752qr("if-unmodified-since", ""), new C3752qr("last-modified", ""), new C3752qr(HTML.Tag.LINK, ""), new C3752qr("location", ""), new C3752qr("max-forwards", ""), new C3752qr("proxy-authenticate", ""), new C3752qr("proxy-authorization", ""), new C3752qr("range", ""), new C3752qr("referer", ""), new C3752qr("refresh", ""), new C3752qr("retry-after", ""), new C3752qr("server", ""), new C3752qr("set-cookie", ""), new C3752qr("strict-transport-security", ""), new C3752qr("transfer-encoding", ""), new C3752qr("user-agent", ""), new C3752qr("vary", ""), new C3752qr("via", ""), new C3752qr("www-authenticate", "")};
        c = c4490zr.d();
    }

    public final W8 a(W8 w8) throws IOException {
        AbstractC4492zt.h(w8, "name");
        int iU = w8.u();
        for (int i = 0; i < iU; i++) {
            byte bE = w8.e(i);
            if (65 <= bE && bE < 91) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + w8.y());
            }
        }
        return w8;
    }

    public final Map b() {
        return c;
    }

    public final C3752qr[] c() {
        return b;
    }

    public final Map d() {
        C3752qr[] c3752qrArr = b;
        LinkedHashMap linkedHashMap = new LinkedHashMap(c3752qrArr.length);
        int length = c3752qrArr.length;
        for (int i = 0; i < length; i++) {
            C3752qr[] c3752qrArr2 = b;
            if (!linkedHashMap.containsKey(c3752qrArr2[i].a)) {
                linkedHashMap.put(c3752qrArr2[i].a, Integer.valueOf(i));
            }
        }
        Map mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        AbstractC4492zt.g(mapUnmodifiableMap, "unmodifiableMap(result)");
        return mapUnmodifiableMap;
    }

    /* JADX INFO: renamed from: zr$a */
    public static final class a {
        public final int a;
        public int b;
        public final List c;
        public final L8 d;
        public C3752qr[] e;
        public int f;
        public int g;
        public int h;

        public a(InterfaceC3309lR interfaceC3309lR, int i, int i2) {
            AbstractC4492zt.h(interfaceC3309lR, DublinCoreProperties.SOURCE);
            this.a = i;
            this.b = i2;
            this.c = new ArrayList();
            this.d = AbstractC4443zE.b(interfaceC3309lR);
            C3752qr[] c3752qrArr = new C3752qr[8];
            this.e = c3752qrArr;
            this.f = c3752qrArr.length - 1;
        }

        public final void a() {
            int i = this.b;
            int i2 = this.h;
            if (i < i2) {
                if (i == 0) {
                    b();
                } else {
                    d(i2 - i);
                }
            }
        }

        public final void b() {
            Q5.u(this.e, null, 0, 0, 6, null);
            this.f = this.e.length - 1;
            this.g = 0;
            this.h = 0;
        }

        public final int c(int i) {
            return this.f + 1 + i;
        }

        public final int d(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.e.length;
                while (true) {
                    length--;
                    i2 = this.f;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    C3752qr c3752qr = this.e[length];
                    AbstractC4492zt.e(c3752qr);
                    int i4 = c3752qr.c;
                    i -= i4;
                    this.h -= i4;
                    this.g--;
                    i3++;
                }
                C3752qr[] c3752qrArr = this.e;
                System.arraycopy(c3752qrArr, i2 + 1, c3752qrArr, i2 + 1 + i3, this.g);
                this.f += i3;
            }
            return i3;
        }

        public final List e() {
            List listC0 = AbstractC3240kc.C0(this.c);
            this.c.clear();
            return listC0;
        }

        public final W8 f(int i) throws IOException {
            if (h(i)) {
                return C4490zr.a.c()[i].a;
            }
            int iC = c(i - C4490zr.a.c().length);
            if (iC >= 0) {
                C3752qr[] c3752qrArr = this.e;
                if (iC < c3752qrArr.length) {
                    C3752qr c3752qr = c3752qrArr[iC];
                    AbstractC4492zt.e(c3752qr);
                    return c3752qr.a;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        public final void g(int i, C3752qr c3752qr) {
            this.c.add(c3752qr);
            int i2 = c3752qr.c;
            if (i != -1) {
                C3752qr c3752qr2 = this.e[c(i)];
                AbstractC4492zt.e(c3752qr2);
                i2 -= c3752qr2.c;
            }
            int i3 = this.b;
            if (i2 > i3) {
                b();
                return;
            }
            int iD = d((this.h + i2) - i3);
            if (i == -1) {
                int i4 = this.g + 1;
                C3752qr[] c3752qrArr = this.e;
                if (i4 > c3752qrArr.length) {
                    C3752qr[] c3752qrArr2 = new C3752qr[c3752qrArr.length * 2];
                    System.arraycopy(c3752qrArr, 0, c3752qrArr2, c3752qrArr.length, c3752qrArr.length);
                    this.f = this.e.length - 1;
                    this.e = c3752qrArr2;
                }
                int i5 = this.f;
                this.f = i5 - 1;
                this.e[i5] = c3752qr;
                this.g++;
            } else {
                this.e[i + c(i) + iD] = c3752qr;
            }
            this.h += i2;
        }

        public final boolean h(int i) {
            return i >= 0 && i <= C4490zr.a.c().length - 1;
        }

        public final int i() {
            return AbstractC3724qX.d(this.d.readByte(), 255);
        }

        public final W8 j() {
            int i = i();
            boolean z = (i & 128) == 128;
            long jM = m(i, ShapeTypes.VERTICAL_SCROLL);
            if (!z) {
                return this.d.e(jM);
            }
            H8 h8 = new H8();
            C0805Or.a.b(this.d, jM, h8);
            return h8.K();
        }

        public final void k() throws IOException {
            while (!this.d.h()) {
                int iD = AbstractC3724qX.d(this.d.readByte(), 255);
                if (iD == 128) {
                    throw new IOException("index == 0");
                }
                if ((iD & 128) == 128) {
                    l(m(iD, ShapeTypes.VERTICAL_SCROLL) - 1);
                } else if (iD == 64) {
                    o();
                } else if ((iD & 64) == 64) {
                    n(m(iD, 63) - 1);
                } else if ((iD & 32) == 32) {
                    int iM = m(iD, 31);
                    this.b = iM;
                    if (iM < 0 || iM > this.a) {
                        throw new IOException("Invalid dynamic table size update " + this.b);
                    }
                    a();
                } else if (iD == 16 || iD == 0) {
                    q();
                } else {
                    p(m(iD, 15) - 1);
                }
            }
        }

        public final void l(int i) throws IOException {
            if (h(i)) {
                this.c.add(C4490zr.a.c()[i]);
                return;
            }
            int iC = c(i - C4490zr.a.c().length);
            if (iC >= 0) {
                C3752qr[] c3752qrArr = this.e;
                if (iC < c3752qrArr.length) {
                    List list = this.c;
                    C3752qr c3752qr = c3752qrArr[iC];
                    AbstractC4492zt.e(c3752qr);
                    list.add(c3752qr);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        public final int m(int i, int i2) {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int i5 = i();
                if ((i5 & 128) == 0) {
                    return i2 + (i5 << i4);
                }
                i2 += (i5 & ShapeTypes.VERTICAL_SCROLL) << i4;
                i4 += 7;
            }
        }

        public final void n(int i) {
            g(-1, new C3752qr(f(i), j()));
        }

        public final void o() {
            g(-1, new C3752qr(C4490zr.a.a(j()), j()));
        }

        public final void p(int i) throws IOException {
            this.c.add(new C3752qr(f(i), j()));
        }

        public final void q() throws IOException {
            this.c.add(new C3752qr(C4490zr.a.a(j()), j()));
        }

        public /* synthetic */ a(InterfaceC3309lR interfaceC3309lR, int i, int i2, int i3, AbstractC0419Di abstractC0419Di) {
            this(interfaceC3309lR, i, (i3 & 4) != 0 ? i : i2);
        }
    }

    /* JADX INFO: renamed from: zr$b */
    public static final class b {
        public int a;
        public final boolean b;
        public final H8 c;
        public int d;
        public boolean e;
        public int f;
        public C3752qr[] g;
        public int h;
        public int i;
        public int j;

        public b(int i, boolean z, H8 h8) {
            AbstractC4492zt.h(h8, "out");
            this.a = i;
            this.b = z;
            this.c = h8;
            this.d = Integer.MAX_VALUE;
            this.f = i;
            C3752qr[] c3752qrArr = new C3752qr[8];
            this.g = c3752qrArr;
            this.h = c3752qrArr.length - 1;
        }

        public final void a() {
            int i = this.f;
            int i2 = this.j;
            if (i < i2) {
                if (i == 0) {
                    b();
                } else {
                    c(i2 - i);
                }
            }
        }

        public final void b() {
            Q5.u(this.g, null, 0, 0, 6, null);
            this.h = this.g.length - 1;
            this.i = 0;
            this.j = 0;
        }

        public final int c(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.g.length;
                while (true) {
                    length--;
                    i2 = this.h;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    C3752qr c3752qr = this.g[length];
                    AbstractC4492zt.e(c3752qr);
                    i -= c3752qr.c;
                    int i4 = this.j;
                    C3752qr c3752qr2 = this.g[length];
                    AbstractC4492zt.e(c3752qr2);
                    this.j = i4 - c3752qr2.c;
                    this.i--;
                    i3++;
                }
                C3752qr[] c3752qrArr = this.g;
                System.arraycopy(c3752qrArr, i2 + 1, c3752qrArr, i2 + 1 + i3, this.i);
                C3752qr[] c3752qrArr2 = this.g;
                int i5 = this.h;
                Arrays.fill(c3752qrArr2, i5 + 1, i5 + 1 + i3, (Object) null);
                this.h += i3;
            }
            return i3;
        }

        public final void d(C3752qr c3752qr) {
            int i = c3752qr.c;
            int i2 = this.f;
            if (i > i2) {
                b();
                return;
            }
            c((this.j + i) - i2);
            int i3 = this.i + 1;
            C3752qr[] c3752qrArr = this.g;
            if (i3 > c3752qrArr.length) {
                C3752qr[] c3752qrArr2 = new C3752qr[c3752qrArr.length * 2];
                System.arraycopy(c3752qrArr, 0, c3752qrArr2, c3752qrArr.length, c3752qrArr.length);
                this.h = this.g.length - 1;
                this.g = c3752qrArr2;
            }
            int i4 = this.h;
            this.h = i4 - 1;
            this.g[i4] = c3752qr;
            this.i++;
            this.j += i;
        }

        public final void e(int i) {
            this.a = i;
            int iMin = Math.min(i, 16384);
            int i2 = this.f;
            if (i2 == iMin) {
                return;
            }
            if (iMin < i2) {
                this.d = Math.min(this.d, iMin);
            }
            this.e = true;
            this.f = iMin;
            a();
        }

        public final void f(W8 w8) {
            AbstractC4492zt.h(w8, "data");
            if (this.b) {
                C0805Or c0805Or = C0805Or.a;
                if (c0805Or.d(w8) < w8.u()) {
                    H8 h8 = new H8();
                    c0805Or.c(w8, h8);
                    W8 w8K = h8.K();
                    h(w8K.u(), ShapeTypes.VERTICAL_SCROLL, 128);
                    this.c.n(w8K);
                    return;
                }
            }
            h(w8.u(), ShapeTypes.VERTICAL_SCROLL, 0);
            this.c.n(w8);
        }

        /* JADX WARN: Code duplicated, block: B:26:0x007e  */
        /* JADX WARN: Code duplicated, block: B:28:0x0087  */
        /* JADX WARN: Code duplicated, block: B:30:0x0096  */
        /* JADX WARN: Code duplicated, block: B:33:0x00b1 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:34:0x00b3  */
        /* JADX WARN: Code duplicated, block: B:37:0x00c4  */
        /* JADX WARN: Code duplicated, block: B:38:0x00cc  */
        /* JADX WARN: Code duplicated, block: B:40:0x00d0  */
        /* JADX WARN: Code duplicated, block: B:41:0x00df  */
        /* JADX WARN: Code duplicated, block: B:46:0x00f8  */
        /* JADX WARN: Code duplicated, block: B:55:0x00a5 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:57:0x00bf A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:58:0x00bf A[SYNTHETIC] */
        public final void g(List list) {
            int length;
            int length2;
            int i;
            int length3;
            C3752qr c3752qr;
            C3752qr c3752qr2;
            AbstractC4492zt.h(list, "headerBlock");
            if (this.e) {
                int i2 = this.d;
                if (i2 < this.f) {
                    h(i2, 31, 32);
                }
                this.e = false;
                this.d = Integer.MAX_VALUE;
                h(this.f, 31, 32);
            }
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                C3752qr c3752qr3 = (C3752qr) list.get(i3);
                W8 w8W = c3752qr3.a.w();
                W8 w8 = c3752qr3.b;
                C4490zr c4490zr = C4490zr.a;
                Integer num = (Integer) c4490zr.b().get(w8W);
                if (num != null) {
                    int iIntValue = num.intValue();
                    length2 = iIntValue + 1;
                    if (2 <= length2 && length2 < 8) {
                        if (AbstractC4492zt.d(c4490zr.c()[iIntValue].b, w8)) {
                            length = length2;
                        } else if (AbstractC4492zt.d(c4490zr.c()[length2].b, w8)) {
                            length = length2;
                            length2 = iIntValue + 2;
                        }
                        if (length2 == -1) {
                            length3 = this.g.length;
                            for (i = this.h + 1; i < length3; i++) {
                                c3752qr = this.g[i];
                                AbstractC4492zt.e(c3752qr);
                                if (AbstractC4492zt.d(c3752qr.a, w8W)) {
                                    c3752qr2 = this.g[i];
                                    AbstractC4492zt.e(c3752qr2);
                                    if (AbstractC4492zt.d(c3752qr2.b, w8)) {
                                        length2 = C4490zr.a.c().length + (i - this.h);
                                        break;
                                    } else if (length == -1) {
                                        length = (i - this.h) + C4490zr.a.c().length;
                                    }
                                }
                            }
                        }
                        if (length2 != -1) {
                            h(length2, ShapeTypes.VERTICAL_SCROLL, 128);
                        } else if (length == -1) {
                            this.c.writeByte(64);
                            f(w8W);
                            f(w8);
                            d(c3752qr3);
                        } else if (w8W.v(C3752qr.e) || AbstractC4492zt.d(C3752qr.j, w8W)) {
                            h(length, 63, 64);
                            f(w8);
                            d(c3752qr3);
                        } else {
                            h(length, 15, 0);
                            f(w8);
                        }
                    }
                    length = length2;
                } else {
                    length = -1;
                }
                length2 = -1;
                if (length2 == -1) {
                    length3 = this.g.length;
                    while (i < length3) {
                        c3752qr = this.g[i];
                        AbstractC4492zt.e(c3752qr);
                        if (AbstractC4492zt.d(c3752qr.a, w8W)) {
                            c3752qr2 = this.g[i];
                            AbstractC4492zt.e(c3752qr2);
                            if (AbstractC4492zt.d(c3752qr2.b, w8)) {
                                length2 = C4490zr.a.c().length + (i - this.h);
                                break;
                            } else if (length == -1) {
                                length = (i - this.h) + C4490zr.a.c().length;
                            }
                        }
                    }
                }
                if (length2 != -1) {
                    h(length2, ShapeTypes.VERTICAL_SCROLL, 128);
                } else if (length == -1) {
                    this.c.writeByte(64);
                    f(w8W);
                    f(w8);
                    d(c3752qr3);
                } else if (w8W.v(C3752qr.e)) {
                    h(length, 63, 64);
                    f(w8);
                    d(c3752qr3);
                } else {
                    h(length, 63, 64);
                    f(w8);
                    d(c3752qr3);
                }
            }
        }

        public final void h(int i, int i2, int i3) {
            if (i < i2) {
                this.c.writeByte(i | i3);
                return;
            }
            this.c.writeByte(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.c.writeByte(128 | (i4 & ShapeTypes.VERTICAL_SCROLL));
                i4 >>>= 7;
            }
            this.c.writeByte(i4);
        }

        public /* synthetic */ b(int i, boolean z, H8 h8, int i2, AbstractC0419Di abstractC0419Di) {
            this((i2 & 1) != 0 ? 4096 : i, (i2 & 2) != 0 ? true : z, h8);
        }
    }
}
