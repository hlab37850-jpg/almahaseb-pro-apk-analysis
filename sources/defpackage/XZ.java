package defpackage;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class XZ {
    public static char[] a;
    public static int b;
    public static int c;
    public static String d;
    public static Map e;

    static {
        char[] charArray = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz-_".toCharArray();
        a = charArray;
        b = charArray.length;
        c = 0;
        e = new HashMap(b);
        for (int i = 0; i < b; i++) {
            e.put(Character.valueOf(a[i]), Integer.valueOf(i));
        }
    }

    public static String a(long j) {
        StringBuilder sb = new StringBuilder();
        do {
            sb.insert(0, a[(int) (j % ((long) b))]);
            j /= (long) b;
        } while (j > 0);
        return sb.toString();
    }

    public static String b() {
        String strA = a(new Date().getTime());
        if (!strA.equals(d)) {
            c = 0;
            d = strA;
            return strA;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(strA);
        sb.append(".");
        int i = c;
        c = i + 1;
        sb.append(a(i));
        return sb.toString();
    }
}
