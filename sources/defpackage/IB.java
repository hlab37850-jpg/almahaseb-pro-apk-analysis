package defpackage;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class IB {
    public static final a e = new a(null);
    public static final Pattern f = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    public static final Pattern g = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    public final String a;
    public final String b;
    public final String c;
    public final String[] d;

    public static final class a {
        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final IB a(String str) {
            AbstractC4492zt.h(str, "<this>");
            Matcher matcher = IB.f.matcher(str);
            if (!matcher.lookingAt()) {
                throw new IllegalArgumentException(("No subtype found for: \"" + str + '\"').toString());
            }
            String strGroup = matcher.group(1);
            AbstractC4492zt.g(strGroup, "typeSubtype.group(1)");
            Locale locale = Locale.US;
            AbstractC4492zt.g(locale, "US");
            String lowerCase = strGroup.toLowerCase(locale);
            AbstractC4492zt.g(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            String strGroup2 = matcher.group(2);
            AbstractC4492zt.g(strGroup2, "typeSubtype.group(2)");
            AbstractC4492zt.g(locale, "US");
            String lowerCase2 = strGroup2.toLowerCase(locale);
            AbstractC4492zt.g(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
            ArrayList arrayList = new ArrayList();
            Matcher matcher2 = IB.g.matcher(str);
            int iEnd = matcher.end();
            while (iEnd < str.length()) {
                matcher2.region(iEnd, str.length());
                if (!matcher2.lookingAt()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Parameter is not formatted correctly: \"");
                    String strSubstring = str.substring(iEnd);
                    AbstractC4492zt.g(strSubstring, "this as java.lang.String).substring(startIndex)");
                    sb.append(strSubstring);
                    sb.append("\" for: \"");
                    sb.append(str);
                    sb.append('\"');
                    throw new IllegalArgumentException(sb.toString().toString());
                }
                String strGroup3 = matcher2.group(1);
                if (strGroup3 == null) {
                    iEnd = matcher2.end();
                } else {
                    String strGroup4 = matcher2.group(2);
                    if (strGroup4 == null) {
                        strGroup4 = matcher2.group(3);
                    } else if (AbstractC3880sS.B(strGroup4, "'", false, 2, null) && AbstractC3880sS.p(strGroup4, "'", false, 2, null) && strGroup4.length() > 2) {
                        strGroup4 = strGroup4.substring(1, strGroup4.length() - 1);
                        AbstractC4492zt.g(strGroup4, "this as java.lang.String…ing(startIndex, endIndex)");
                    }
                    arrayList.add(strGroup3);
                    arrayList.add(strGroup4);
                    iEnd = matcher2.end();
                }
            }
            return new IB(str, lowerCase, lowerCase2, (String[]) arrayList.toArray(new String[0]), null);
        }

        public final IB b(String str) {
            AbstractC4492zt.h(str, "<this>");
            try {
                return a(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public a() {
        }
    }

    public /* synthetic */ IB(String str, String str2, String str3, String[] strArr, AbstractC0419Di abstractC0419Di) {
        this(str, str2, str3, strArr);
    }

    public static /* synthetic */ Charset d(IB ib, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = null;
        }
        return ib.c(charset);
    }

    public static final IB f(String str) {
        return e.b(str);
    }

    public final Charset c(Charset charset) {
        String strE = e("charset");
        if (strE == null) {
            return charset;
        }
        try {
            return Charset.forName(strE);
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }

    public final String e(String str) {
        AbstractC4492zt.h(str, "name");
        int i = 0;
        int iB = AbstractC3546oI.b(0, this.d.length - 1, 2);
        if (iB < 0) {
            return null;
        }
        while (!AbstractC3880sS.q(this.d[i], str, true)) {
            if (i == iB) {
                return null;
            }
            i += 2;
        }
        return this.d[i + 1];
    }

    public boolean equals(Object obj) {
        return (obj instanceof IB) && AbstractC4492zt.d(((IB) obj).a, this.a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.a;
    }

    public IB(String str, String str2, String str3, String[] strArr) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = strArr;
    }
}
