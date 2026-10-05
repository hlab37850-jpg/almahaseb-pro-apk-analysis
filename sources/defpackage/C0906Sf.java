package defpackage;

import androidx.core.location.LocationRequestCompat;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.common.net.HttpHeaders;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

/* JADX INFO: renamed from: Sf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0906Sf {
    public static final a j = new a(null);
    public static final Pattern k = Pattern.compile("(\\d{2,4})[^\\d]*");
    public static final Pattern l = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    public static final Pattern m = Pattern.compile("(\\d{1,2})[^\\d]*");
    public static final Pattern n = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    public final String a;
    public final String b;
    public final long c;
    public final String d;
    public final String e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;

    /* JADX INFO: renamed from: Sf$a */
    public static final class a {
        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final int a(String str, int i, int i2, boolean z) {
            while (i < i2) {
                char cCharAt = str.charAt(i);
                if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || ('0' <= cCharAt && cCharAt < ':') || (('a' <= cCharAt && cCharAt < '{') || (('A' <= cCharAt && cCharAt < '[') || cCharAt == ':'))) == (!z)) {
                    return i;
                }
                i++;
            }
            return i2;
        }

        public final boolean b(String str, String str2) {
            if (AbstractC4492zt.d(str, str2)) {
                return true;
            }
            return AbstractC3880sS.p(str, str2, false, 2, null) && str.charAt((str.length() - str2.length()) - 1) == '.' && !AbstractC3724qX.i(str);
        }

        public final C0906Sf c(C0779Nr c0779Nr, String str) {
            AbstractC4492zt.h(c0779Nr, "url");
            AbstractC4492zt.h(str, "setCookie");
            return d(System.currentTimeMillis(), c0779Nr, str);
        }

        public final C0906Sf d(long j, C0779Nr c0779Nr, String str) {
            long j2;
            C0906Sf c0906Sf;
            String str2;
            String str3;
            AbstractC4492zt.h(c0779Nr, "url");
            AbstractC4492zt.h(str, "setCookie");
            int iR = AbstractC3724qX.r(str, ';', 0, 0, 6, null);
            int iR2 = AbstractC3724qX.r(str, '=', 0, iR, 2, null);
            if (iR2 == iR) {
                return null;
            }
            String strZ = AbstractC3724qX.Z(str, 0, iR2, 1, null);
            if (strZ.length() == 0 || AbstractC3724qX.y(strZ) != -1) {
                return null;
            }
            String strY = AbstractC3724qX.Y(str, iR2 + 1, iR);
            if (AbstractC3724qX.y(strY) != -1) {
                return null;
            }
            int i = iR + 1;
            int length = str.length();
            String strF = null;
            String str4 = null;
            long jH = -1;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = true;
            long jG = 253402300799999L;
            while (i < length) {
                int iP = AbstractC3724qX.p(str, ';', i, length);
                int iP2 = AbstractC3724qX.p(str, '=', i, iP);
                String strY2 = AbstractC3724qX.Y(str, i, iP2);
                String strY3 = iP2 < iP ? AbstractC3724qX.Y(str, iP2 + 1, iP) : "";
                if (AbstractC3880sS.q(strY2, "expires", true)) {
                    try {
                        jG = g(strY3, 0, strY3.length());
                        z3 = true;
                    } catch (NumberFormatException | IllegalArgumentException unused) {
                    }
                } else if (AbstractC3880sS.q(strY2, "max-age", true)) {
                    jH = h(strY3);
                    z3 = true;
                } else if (AbstractC3880sS.q(strY2, "domain", true)) {
                    strF = f(strY3);
                    z4 = false;
                } else if (AbstractC3880sS.q(strY2, "path", true)) {
                    str4 = strY3;
                } else if (AbstractC3880sS.q(strY2, "secure", true)) {
                    z = true;
                } else if (AbstractC3880sS.q(strY2, "httponly", true)) {
                    z2 = true;
                }
                i = iP + 1;
            }
            long j3 = Long.MIN_VALUE;
            if (jH == Long.MIN_VALUE) {
                j2 = j3;
            } else if (jH != -1) {
                long j4 = j + (jH <= 9223372036854775L ? jH * ((long) 1000) : LocationRequestCompat.PASSIVE_INTERVAL);
                if (j4 >= j) {
                    j3 = 253402300799999L;
                    if (j4 <= 253402300799999L) {
                        j2 = j4;
                    }
                } else {
                    j3 = 253402300799999L;
                }
                j2 = j3;
            } else {
                j2 = jG;
            }
            String strH = c0779Nr.h();
            if (strF == null) {
                str2 = strH;
                c0906Sf = null;
            } else {
                if (!b(strH, strF)) {
                    return null;
                }
                c0906Sf = null;
                str2 = strF;
            }
            if (strH.length() != str2.length() && PublicSuffixDatabase.e.c().c(str2) == null) {
                return c0906Sf;
            }
            String strSubstring = "/";
            String str5 = str4;
            if (str5 == null || !AbstractC3880sS.B(str5, "/", false, 2, c0906Sf)) {
                String strD = c0779Nr.d();
                int iW = AbstractC3961tS.W(strD, '/', 0, false, 6, null);
                if (iW != 0) {
                    strSubstring = strD.substring(0, iW);
                    AbstractC4492zt.g(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                }
                str3 = strSubstring;
            } else {
                str3 = str5;
            }
            return new C0906Sf(strZ, strY, j2, str2, str3, z, z2, z3, z4, null);
        }

        public final List e(C0779Nr c0779Nr, C3994tr c3994tr) {
            AbstractC4492zt.h(c0779Nr, "url");
            AbstractC4492zt.h(c3994tr, "headers");
            List listF = c3994tr.f(HttpHeaders.SET_COOKIE);
            int size = listF.size();
            ArrayList arrayList = null;
            for (int i = 0; i < size; i++) {
                C0906Sf c0906SfC = c(c0779Nr, (String) listF.get(i));
                if (c0906SfC != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(c0906SfC);
                }
            }
            if (arrayList == null) {
                return AbstractC1886cc.m();
            }
            List listUnmodifiableList = Collections.unmodifiableList(arrayList);
            AbstractC4492zt.g(listUnmodifiableList, "{\n        Collections.un…ableList(cookies)\n      }");
            return listUnmodifiableList;
        }

        public final String f(String str) {
            if (AbstractC3880sS.p(str, ".", false, 2, null)) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            String strE = AbstractC4409yr.e(AbstractC3961tS.g0(str, "."));
            if (strE != null) {
                return strE;
            }
            throw new IllegalArgumentException();
        }

        public final long g(String str, int i, int i2) {
            int iA = a(str, i, i2, false);
            Matcher matcher = C0906Sf.n.matcher(str);
            int i3 = -1;
            int i4 = -1;
            int i5 = -1;
            int iR = -1;
            int i6 = -1;
            int i7 = -1;
            while (iA < i2) {
                int iA2 = a(str, iA + 1, i2, true);
                matcher.region(iA, iA2);
                if (i4 == -1 && matcher.usePattern(C0906Sf.n).matches()) {
                    String strGroup = matcher.group(1);
                    AbstractC4492zt.g(strGroup, "matcher.group(1)");
                    i4 = Integer.parseInt(strGroup);
                    String strGroup2 = matcher.group(2);
                    AbstractC4492zt.g(strGroup2, "matcher.group(2)");
                    i6 = Integer.parseInt(strGroup2);
                    String strGroup3 = matcher.group(3);
                    AbstractC4492zt.g(strGroup3, "matcher.group(3)");
                    i7 = Integer.parseInt(strGroup3);
                } else if (i5 == -1 && matcher.usePattern(C0906Sf.m).matches()) {
                    String strGroup4 = matcher.group(1);
                    AbstractC4492zt.g(strGroup4, "matcher.group(1)");
                    i5 = Integer.parseInt(strGroup4);
                } else if (iR == -1 && matcher.usePattern(C0906Sf.l).matches()) {
                    String strGroup5 = matcher.group(1);
                    AbstractC4492zt.g(strGroup5, "matcher.group(1)");
                    Locale locale = Locale.US;
                    AbstractC4492zt.g(locale, "US");
                    String lowerCase = strGroup5.toLowerCase(locale);
                    AbstractC4492zt.g(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                    String strPattern = C0906Sf.l.pattern();
                    AbstractC4492zt.g(strPattern, "MONTH_PATTERN.pattern()");
                    iR = AbstractC3961tS.R(strPattern, lowerCase, 0, false, 6, null) / 4;
                } else if (i3 == -1 && matcher.usePattern(C0906Sf.k).matches()) {
                    String strGroup6 = matcher.group(1);
                    AbstractC4492zt.g(strGroup6, "matcher.group(1)");
                    i3 = Integer.parseInt(strGroup6);
                }
                iA = a(str, iA2 + 1, i2, false);
            }
            if (70 <= i3 && i3 < 100) {
                i3 += 1900;
            }
            if (i3 >= 0 && i3 < 70) {
                i3 += CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE;
            }
            if (i3 < 1601) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (iR == -1) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (1 > i5 || i5 >= 32) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (i4 < 0 || i4 >= 24) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (i6 < 0 || i6 >= 60) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (i7 < 0 || i7 >= 60) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar(AbstractC3724qX.f);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i3);
            gregorianCalendar.set(2, iR - 1);
            gregorianCalendar.set(5, i5);
            gregorianCalendar.set(11, i4);
            gregorianCalendar.set(12, i6);
            gregorianCalendar.set(13, i7);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }

        public final long h(String str) {
            try {
                long j = Long.parseLong(str);
                if (j <= 0) {
                    return Long.MIN_VALUE;
                }
                return j;
            } catch (NumberFormatException e) {
                if (!new SJ("-?\\d+").c(str)) {
                    throw e;
                }
                if (AbstractC3880sS.B(str, "-", false, 2, null)) {
                    return Long.MIN_VALUE;
                }
                return LocationRequestCompat.PASSIVE_INTERVAL;
            }
        }

        public a() {
        }
    }

    public /* synthetic */ C0906Sf(String str, String str2, long j2, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4, AbstractC0419Di abstractC0419Di) {
        this(str, str2, j2, str3, str4, z, z2, z3, z4);
    }

    public final String e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C0906Sf) {
            C0906Sf c0906Sf = (C0906Sf) obj;
            if (AbstractC4492zt.d(c0906Sf.a, this.a) && AbstractC4492zt.d(c0906Sf.b, this.b) && c0906Sf.c == this.c && AbstractC4492zt.d(c0906Sf.d, this.d) && AbstractC4492zt.d(c0906Sf.e, this.e) && c0906Sf.f == this.f && c0906Sf.g == this.g && c0906Sf.h == this.h && c0906Sf.i == this.i) {
                return true;
            }
        }
        return false;
    }

    public final String f(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append('=');
        sb.append(this.b);
        if (this.h) {
            if (this.c == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(AbstractC3170ji.b(new Date(this.c)));
            }
        }
        if (!this.i) {
            sb.append("; domain=");
            if (z) {
                sb.append(".");
            }
            sb.append(this.d);
        }
        sb.append("; path=");
        sb.append(this.e);
        if (this.f) {
            sb.append("; secure");
        }
        if (this.g) {
            sb.append("; httponly");
        }
        String string = sb.toString();
        AbstractC4492zt.g(string, "toString()");
        return string;
    }

    public final String g() {
        return this.b;
    }

    public int hashCode() {
        return ((((((((((((((((MetaDo.META_OFFSETWINDOWORG + this.a.hashCode()) * 31) + this.b.hashCode()) * 31) + AbstractC0723Lm.a(this.c)) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + AbstractC0564Hb.a(this.f)) * 31) + AbstractC0564Hb.a(this.g)) * 31) + AbstractC0564Hb.a(this.h)) * 31) + AbstractC0564Hb.a(this.i);
    }

    public String toString() {
        return f(false);
    }

    public C0906Sf(String str, String str2, long j2, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.a = str;
        this.b = str2;
        this.c = j2;
        this.d = str3;
        this.e = str4;
        this.f = z;
        this.g = z2;
        this.h = z3;
        this.i = z4;
    }
}
