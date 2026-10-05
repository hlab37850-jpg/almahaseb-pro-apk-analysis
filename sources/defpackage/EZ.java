package defpackage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public abstract class EZ {
    public static String a(String str, int i) {
        return b(str, i, null, false);
    }

    public static String b(String str, int i, String str2, boolean z) {
        return c(str, i, str2, z, " ");
    }

    public static String c(String str, int i, String str2, boolean z, String str3) {
        int iStart;
        if (str == null) {
            return null;
        }
        if (str2 == null) {
            str2 = System.lineSeparator();
        }
        if (i < 1) {
            i = 1;
        }
        if (AbstractC3146jS.b(str3)) {
            str3 = " ";
        }
        Pattern patternCompile = Pattern.compile(str3);
        int length = str.length();
        StringBuilder sb = new StringBuilder(length + 32);
        int iEnd = 0;
        while (iEnd < length) {
            int i2 = iEnd + i;
            Matcher matcher = patternCompile.matcher(str.substring(iEnd, Math.min(i2 + 1, length)));
            if (!matcher.find()) {
                iStart = -1;
            } else if (matcher.start() == 0) {
                iEnd += matcher.end();
            } else {
                iStart = matcher.start() + iEnd;
            }
            if (length - iEnd <= i) {
                break;
            }
            while (matcher.find()) {
                iStart = matcher.start() + iEnd;
            }
            if (iStart >= iEnd) {
                sb.append(str.substring(iEnd, iStart));
                sb.append(str2);
            } else if (z) {
                sb.append(str.substring(iEnd, i2));
                sb.append(str2);
                iEnd = i2;
            } else {
                Matcher matcher2 = patternCompile.matcher(str.substring(i2));
                if (matcher2.find()) {
                    iStart = matcher2.start() + iEnd + i;
                }
                if (iStart >= 0) {
                    sb.append(str.substring(iEnd, iStart));
                    sb.append(str2);
                } else {
                    sb.append(str.substring(iEnd));
                    iEnd = length;
                }
            }
            iEnd = iStart + 1;
        }
        sb.append(str.substring(iEnd));
        return sb.toString();
    }
}
