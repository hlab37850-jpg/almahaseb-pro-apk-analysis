package defpackage;

import com.zebra.sdk.util.internal.StringUtilities;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: renamed from: tr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3994tr implements Iterable, InterfaceC0756Mu {
    public static final b b = new b(null);
    public final String[] a;

    /* JADX INFO: renamed from: tr$a */
    public static final class a {
        public final List a = new ArrayList(20);

        public final a a(String str, String str2) {
            AbstractC4492zt.h(str, "name");
            AbstractC4492zt.h(str2, "value");
            b bVar = C3994tr.b;
            bVar.d(str);
            bVar.e(str2, str);
            c(str, str2);
            return this;
        }

        public final a b(String str) {
            AbstractC4492zt.h(str, "line");
            int iQ = AbstractC3961tS.Q(str, ':', 1, false, 4, null);
            if (iQ != -1) {
                String strSubstring = str.substring(0, iQ);
                AbstractC4492zt.g(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                String strSubstring2 = str.substring(iQ + 1);
                AbstractC4492zt.g(strSubstring2, "this as java.lang.String).substring(startIndex)");
                c(strSubstring, strSubstring2);
            } else if (str.charAt(0) == ':') {
                String strSubstring3 = str.substring(1);
                AbstractC4492zt.g(strSubstring3, "this as java.lang.String).substring(startIndex)");
                c("", strSubstring3);
            } else {
                c("", str);
            }
            return this;
        }

        public final a c(String str, String str2) {
            AbstractC4492zt.h(str, "name");
            AbstractC4492zt.h(str2, "value");
            this.a.add(str);
            this.a.add(AbstractC3961tS.D0(str2).toString());
            return this;
        }

        public final C3994tr d() {
            return new C3994tr((String[]) this.a.toArray(new String[0]), null);
        }

        public final List e() {
            return this.a;
        }

        public final a f(String str) {
            AbstractC4492zt.h(str, "name");
            int i = 0;
            while (i < this.a.size()) {
                if (AbstractC3880sS.q(str, (String) this.a.get(i), true)) {
                    this.a.remove(i);
                    this.a.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        public final a g(String str, String str2) {
            AbstractC4492zt.h(str, "name");
            AbstractC4492zt.h(str2, "value");
            b bVar = C3994tr.b;
            bVar.d(str);
            bVar.e(str2, str);
            f(str);
            c(str, str2);
            return this;
        }
    }

    /* JADX INFO: renamed from: tr$b */
    public static final class b {
        public /* synthetic */ b(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final void d(String str) {
            if (str.length() <= 0) {
                throw new IllegalArgumentException("name is empty");
            }
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if ('!' > cCharAt || cCharAt >= 127) {
                    throw new IllegalArgumentException(AbstractC3724qX.t("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str).toString());
                }
            }
        }

        public final void e(String str, String str2) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt != '\t' && (' ' > cCharAt || cCharAt >= 127)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(AbstractC3724qX.t("Unexpected char %#04x at %d in %s value", Integer.valueOf(cCharAt), Integer.valueOf(i), str2));
                    sb.append(AbstractC3724qX.G(str2) ? "" : ": " + str);
                    throw new IllegalArgumentException(sb.toString().toString());
                }
            }
        }

        public final String f(String[] strArr, String str) {
            int length = strArr.length - 2;
            int iB = AbstractC3546oI.b(length, 0, -2);
            if (iB > length) {
                return null;
            }
            while (!AbstractC3880sS.q(str, strArr[length], true)) {
                if (length == iB) {
                    return null;
                }
                length -= 2;
            }
            return strArr[length + 1];
        }

        public final C3994tr g(String... strArr) {
            AbstractC4492zt.h(strArr, "namesAndValues");
            if (strArr.length % 2 != 0) {
                throw new IllegalArgumentException("Expected alternating header names and values");
            }
            String[] strArr2 = (String[]) strArr.clone();
            int length = strArr2.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                String str = strArr2[i2];
                if (str == null) {
                    throw new IllegalArgumentException("Headers cannot be null");
                }
                strArr2[i2] = AbstractC3961tS.D0(str).toString();
            }
            int iB = AbstractC3546oI.b(0, strArr2.length - 1, 2);
            if (iB >= 0) {
                while (true) {
                    String str2 = strArr2[i];
                    String str3 = strArr2[i + 1];
                    d(str2);
                    e(str3, str2);
                    if (i == iB) {
                        break;
                    }
                    i += 2;
                }
            }
            return new C3994tr(strArr2, null);
        }

        public b() {
        }
    }

    public /* synthetic */ C3994tr(String[] strArr, AbstractC0419Di abstractC0419Di) {
        this(strArr);
    }

    public final String a(String str) {
        AbstractC4492zt.h(str, "name");
        return b.f(this.a, str);
    }

    public final String b(int i) {
        return this.a[i * 2];
    }

    public final a c() {
        a aVar = new a();
        AbstractC2371hc.E(aVar.e(), this.a);
        return aVar;
    }

    public final Map d() {
        TreeMap treeMap = new TreeMap(AbstractC3880sS.r(C2359hS.a));
        int size = size();
        for (int i = 0; i < size; i++) {
            String strB = b(i);
            Locale locale = Locale.US;
            AbstractC4492zt.g(locale, "US");
            String lowerCase = strB.toLowerCase(locale);
            AbstractC4492zt.g(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            List arrayList = (List) treeMap.get(lowerCase);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
                treeMap.put(lowerCase, arrayList);
            }
            arrayList.add(e(i));
        }
        return treeMap;
    }

    public final String e(int i) {
        return this.a[(i * 2) + 1];
    }

    public boolean equals(Object obj) {
        return (obj instanceof C3994tr) && Arrays.equals(this.a, ((C3994tr) obj).a);
    }

    public final List f(String str) {
        AbstractC4492zt.h(str, "name");
        int size = size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            if (AbstractC3880sS.q(str, b(i), true)) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(e(i));
            }
        }
        if (arrayList == null) {
            return AbstractC1886cc.m();
        }
        List listUnmodifiableList = Collections.unmodifiableList(arrayList);
        AbstractC4492zt.g(listUnmodifiableList, "{\n      Collections.unmodifiableList(result)\n    }");
        return listUnmodifiableList;
    }

    public int hashCode() {
        return Arrays.hashCode(this.a);
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        int size = size();
        C2020dG[] c2020dGArr = new C2020dG[size];
        for (int i = 0; i < size; i++) {
            c2020dGArr[i] = HV.a(b(i), e(i));
        }
        return AbstractC1199a5.a(c2020dGArr);
    }

    public final int size() {
        return this.a.length / 2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        for (int i = 0; i < size; i++) {
            String strB = b(i);
            String strE = e(i);
            sb.append(strB);
            sb.append(": ");
            if (AbstractC3724qX.G(strB)) {
                strE = "██";
            }
            sb.append(strE);
            sb.append(StringUtilities.LF);
        }
        String string = sb.toString();
        AbstractC4492zt.g(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public C3994tr(String[] strArr) {
        this.a = strArr;
    }
}
