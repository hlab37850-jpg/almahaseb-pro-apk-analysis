package defpackage;

import java.util.Comparator;

/* JADX INFO: renamed from: sS, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3880sS extends AbstractC3799rS {
    public static /* synthetic */ boolean A(String str, String str2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return y(str, str2, i, z);
    }

    public static /* synthetic */ boolean B(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return z(str, str2, z);
    }

    public static String m(char[] cArr) {
        AbstractC4492zt.h(cArr, "<this>");
        return new String(cArr);
    }

    public static String n(char[] cArr, int i, int i2) {
        AbstractC4492zt.h(cArr, "<this>");
        V.Companion.a(i, i2, cArr.length);
        return new String(cArr, i, i2 - i);
    }

    public static final boolean o(String str, String str2, boolean z) {
        AbstractC4492zt.h(str, "<this>");
        AbstractC4492zt.h(str2, "suffix");
        return !z ? str.endsWith(str2) : s(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    public static /* synthetic */ boolean p(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return o(str, str2, z);
    }

    public static boolean q(String str, String str2, boolean z) {
        if (str == null) {
            return str2 == null;
        }
        return !z ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public static Comparator r(C2359hS c2359hS) {
        AbstractC4492zt.h(c2359hS, "<this>");
        Comparator comparator = String.CASE_INSENSITIVE_ORDER;
        AbstractC4492zt.g(comparator, "CASE_INSENSITIVE_ORDER");
        return comparator;
    }

    public static final boolean s(String str, int i, String str2, int i2, int i3, boolean z) {
        AbstractC4492zt.h(str, "<this>");
        AbstractC4492zt.h(str2, "other");
        return !z ? str.regionMatches(i, str2, i2, i3) : str.regionMatches(z, i, str2, i2, i3);
    }

    public static String t(CharSequence charSequence, int i) {
        AbstractC4492zt.h(charSequence, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i + '.').toString());
        }
        if (i == 0) {
            return "";
        }
        int i2 = 1;
        if (i == 1) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            char cCharAt = charSequence.charAt(0);
            char[] cArr = new char[i];
            for (int i3 = 0; i3 < i; i3++) {
                cArr[i3] = cCharAt;
            }
            return new String(cArr);
        }
        StringBuilder sb = new StringBuilder(charSequence.length() * i);
        if (1 <= i) {
            while (true) {
                sb.append(charSequence);
                if (i2 == i) {
                    break;
                }
                i2++;
            }
        }
        String string = sb.toString();
        AbstractC4492zt.e(string);
        return string;
    }

    public static final String u(String str, char c, char c2, boolean z) {
        AbstractC4492zt.h(str, "<this>");
        if (!z) {
            String strReplace = str.replace(c, c2);
            AbstractC4492zt.g(strReplace, "replace(...)");
            return strReplace;
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (AbstractC3648pb.h(cCharAt, c, z)) {
                cCharAt = c2;
            }
            sb.append(cCharAt);
        }
        String string = sb.toString();
        AbstractC4492zt.g(string, "toString(...)");
        return string;
    }

    public static final String v(String str, String str2, String str3, boolean z) {
        AbstractC4492zt.h(str, "<this>");
        AbstractC4492zt.h(str2, "oldValue");
        AbstractC4492zt.h(str3, "newValue");
        int i = 0;
        int iN = AbstractC3961tS.N(str, str2, 0, z);
        if (iN < 0) {
            return str;
        }
        int length = str2.length();
        int iD = AbstractC3871sJ.d(length, 1);
        int length2 = (str.length() - length) + str3.length();
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        do {
            sb.append((CharSequence) str, i, iN);
            sb.append(str3);
            i = iN + length;
            if (iN >= str.length()) {
                break;
            }
            iN = AbstractC3961tS.N(str, str2, iN + iD, z);
        } while (iN > 0);
        sb.append((CharSequence) str, i, str.length());
        String string = sb.toString();
        AbstractC4492zt.g(string, "toString(...)");
        return string;
    }

    public static /* synthetic */ String w(String str, char c, char c2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return u(str, c, c2, z);
    }

    public static /* synthetic */ String x(String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return v(str, str2, str3, z);
    }

    public static boolean y(String str, String str2, int i, boolean z) {
        AbstractC4492zt.h(str, "<this>");
        AbstractC4492zt.h(str2, "prefix");
        return !z ? str.startsWith(str2, i) : s(str, i, str2, 0, str2.length(), z);
    }

    public static boolean z(String str, String str2, boolean z) {
        AbstractC4492zt.h(str, "<this>");
        AbstractC4492zt.h(str2, "prefix");
        return !z ? str.startsWith(str2) : s(str, 0, str2, 0, str2.length(), z);
    }
}
