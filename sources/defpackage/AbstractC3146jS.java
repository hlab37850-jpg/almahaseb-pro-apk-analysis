package defpackage;

/* JADX INFO: renamed from: jS, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3146jS {
    public static int a(CharSequence charSequence, CharSequence charSequence2) {
        int length = 0;
        if (c(charSequence) || c(charSequence2)) {
            return 0;
        }
        int i = 0;
        while (true) {
            int iA = AbstractC3402mb.a(charSequence, charSequence2, length);
            if (iA == -1) {
                return i;
            }
            i++;
            length = iA + charSequence2.length();
        }
    }

    public static boolean b(CharSequence charSequence) {
        int length;
        if (charSequence != null && (length = charSequence.length()) != 0) {
            for (int i = 0; i < length; i++) {
                if (!Character.isWhitespace(charSequence.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean c(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }
}
