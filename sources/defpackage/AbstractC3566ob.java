package defpackage;

import java.util.Locale;

/* JADX INFO: renamed from: ob, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3566ob {
    public static int a(int i) {
        if (2 <= i && i < 37) {
            return i;
        }
        throw new IllegalArgumentException("radix " + i + " was not in valid range " + new C1001Vs(2, 36));
    }

    public static final int b(char c, int i) {
        return Character.digit((int) c, i);
    }

    public static final boolean c(char c) {
        return Character.isWhitespace(c) || Character.isSpaceChar(c);
    }

    public static String d(char c, Locale locale) {
        AbstractC4492zt.h(locale, "locale");
        String strValueOf = String.valueOf(c);
        AbstractC4492zt.f(strValueOf, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strValueOf.toLowerCase(locale);
        AbstractC4492zt.g(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    public static String e(char c, Locale locale) {
        AbstractC4492zt.h(locale, "locale");
        String strF = f(c, locale);
        if (strF.length() <= 1) {
            String strValueOf = String.valueOf(c);
            AbstractC4492zt.f(strValueOf, "null cannot be cast to non-null type java.lang.String");
            String upperCase = strValueOf.toUpperCase(Locale.ROOT);
            AbstractC4492zt.g(upperCase, "toUpperCase(...)");
            return !AbstractC4492zt.d(strF, upperCase) ? strF : String.valueOf(Character.toTitleCase(c));
        }
        if (c == 329) {
            return strF;
        }
        char cCharAt = strF.charAt(0);
        AbstractC4492zt.f(strF, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = strF.substring(1);
        AbstractC4492zt.g(strSubstring, "substring(...)");
        AbstractC4492zt.f(strSubstring, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strSubstring.toLowerCase(Locale.ROOT);
        AbstractC4492zt.g(lowerCase, "toLowerCase(...)");
        return cCharAt + lowerCase;
    }

    public static final String f(char c, Locale locale) {
        AbstractC4492zt.h(locale, "locale");
        String strValueOf = String.valueOf(c);
        AbstractC4492zt.f(strValueOf, "null cannot be cast to non-null type java.lang.String");
        String upperCase = strValueOf.toUpperCase(locale);
        AbstractC4492zt.g(upperCase, "toUpperCase(...)");
        return upperCase;
    }
}
