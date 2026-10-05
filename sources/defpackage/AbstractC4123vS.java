package defpackage;

import com.itextpdf.text.Annotation;
import java.util.Collection;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: vS, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4123vS extends AbstractC4042uS {
    public static final String E0(String str, int i) {
        AbstractC4492zt.h(str, "<this>");
        if (i >= 0) {
            String strSubstring = str.substring(AbstractC3871sJ.g(i, str.length()));
            AbstractC4492zt.g(strSubstring, "substring(...)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }

    public static char F0(CharSequence charSequence) {
        AbstractC4492zt.h(charSequence, "<this>");
        if (charSequence.length() != 0) {
            return charSequence.charAt(AbstractC3961tS.L(charSequence));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static String G0(String str, int i) {
        AbstractC4492zt.h(str, "<this>");
        if (i >= 0) {
            String strSubstring = str.substring(0, AbstractC3871sJ.g(i, str.length()));
            AbstractC4492zt.g(strSubstring, "substring(...)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }

    public static Collection H0(CharSequence charSequence, Collection collection) {
        AbstractC4492zt.h(charSequence, "<this>");
        AbstractC4492zt.h(collection, Annotation.DESTINATION);
        for (int i = 0; i < charSequence.length(); i++) {
            collection.add(Character.valueOf(charSequence.charAt(i)));
        }
        return collection;
    }
}
