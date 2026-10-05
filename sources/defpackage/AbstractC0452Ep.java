package defpackage;

/* JADX INFO: renamed from: Ep, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0452Ep {
    public final String a;
    public final int b;

    public AbstractC0452Ep(String str, int i) {
        if (i < 0) {
            throw new IllegalArgumentException("The number of function arguments can not be less than 0 for '" + str + "'");
        }
        if (c(str)) {
            this.a = str;
            this.b = i;
        } else {
            throw new IllegalArgumentException("The function name '" + str + "' is invalid");
        }
    }

    public static boolean c(String str) {
        int length;
        if (str == null || (length = str.length()) == 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (!Character.isLetter(cCharAt) && cCharAt != '_' && (!Character.isDigit(cCharAt) || i <= 0)) {
                return false;
            }
        }
        return true;
    }

    public abstract double a(double... dArr);

    public int b() {
        return this.b;
    }

    public AbstractC0452Ep(String str) {
        this(str, 1);
    }
}
