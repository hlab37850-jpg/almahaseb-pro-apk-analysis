package androidx.compose.ui.text.platform;

import androidx.compose.ui.text.PlatformStringDelegate;
import androidx.compose.ui.text.intl.AndroidLocale;
import androidx.compose.ui.text.intl.PlatformLocale;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import defpackage.AbstractC3566ob;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidStringDelegate implements PlatformStringDelegate {
    @Override // androidx.compose.ui.text.PlatformStringDelegate
    public String capitalize(String str, PlatformLocale platformLocale) {
        AbstractC4492zt.h(str, TypedValues.Custom.S_STRING);
        AbstractC4492zt.h(platformLocale, "locale");
        if (str.length() <= 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char cCharAt = str.charAt(0);
        sb.append((Object) (Character.isLowerCase(cCharAt) ? AbstractC3566ob.e(cCharAt, ((AndroidLocale) platformLocale).getJavaLocale()) : String.valueOf(cCharAt)));
        String strSubstring = str.substring(1);
        AbstractC4492zt.g(strSubstring, "this as java.lang.String).substring(startIndex)");
        sb.append(strSubstring);
        return sb.toString();
    }

    @Override // androidx.compose.ui.text.PlatformStringDelegate
    public String decapitalize(String str, PlatformLocale platformLocale) {
        AbstractC4492zt.h(str, TypedValues.Custom.S_STRING);
        AbstractC4492zt.h(platformLocale, "locale");
        if (str.length() <= 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append((Object) AbstractC3566ob.d(str.charAt(0), ((AndroidLocale) platformLocale).getJavaLocale()));
        String strSubstring = str.substring(1);
        AbstractC4492zt.g(strSubstring, "this as java.lang.String).substring(startIndex)");
        sb.append(strSubstring);
        return sb.toString();
    }

    @Override // androidx.compose.ui.text.PlatformStringDelegate
    public String toLowerCase(String str, PlatformLocale platformLocale) {
        AbstractC4492zt.h(str, TypedValues.Custom.S_STRING);
        AbstractC4492zt.h(platformLocale, "locale");
        String lowerCase = str.toLowerCase(((AndroidLocale) platformLocale).getJavaLocale());
        AbstractC4492zt.g(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    @Override // androidx.compose.ui.text.PlatformStringDelegate
    public String toUpperCase(String str, PlatformLocale platformLocale) {
        AbstractC4492zt.h(str, TypedValues.Custom.S_STRING);
        AbstractC4492zt.h(platformLocale, "locale");
        String upperCase = str.toUpperCase(((AndroidLocale) platformLocale).getJavaLocale());
        AbstractC4492zt.g(upperCase, "this as java.lang.String).toUpperCase(locale)");
        return upperCase;
    }
}
