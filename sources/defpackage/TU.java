package defpackage;

import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class TU {
    public final char[] a;
    public final int b;
    public final Map c;
    public final Map d;
    public final Set e;
    public int f = 0;
    public RU g;

    public TU(String str, Map map, Map map2, Set set) {
        char[] charArray = str.trim().toCharArray();
        this.a = charArray;
        this.b = charArray.length;
        this.c = map;
        this.d = map2;
        this.e = set;
    }

    public static boolean d(int i) {
        return Character.isLetter(i);
    }

    public static boolean h(char c, boolean z) {
        return Character.isDigit(c) || c == '.' || c == 'e' || c == 'E' || (z && (c == '-' || c == '+'));
    }

    public final AbstractC0452Ep a(String str) {
        Map map = this.c;
        AbstractC0452Ep abstractC0452Ep = map != null ? (AbstractC0452Ep) map.get(str) : null;
        return abstractC0452Ep == null ? AbstractC1744aq.a(str) : abstractC0452Ep;
    }

    public final UE b(String str) {
        Map map = this.d;
        UE ue = map != null ? (UE) map.get(str) : null;
        if (ue != null) {
            return ue;
        }
        int i = 1;
        if (str.length() != 1) {
            return ue;
        }
        RU ru2 = this.g;
        if (ru2 != null && ru2.a() != 2 && this.g.a() != 4 && this.g.a() != 7) {
            i = 2;
        }
        return WE.a(str.charAt(0), i);
    }

    public boolean c() {
        return this.a.length > this.f;
    }

    public final boolean e(char c) {
        return c == ',';
    }

    public final boolean f(char c) {
        return c == ')' || c == '}' || c == ']';
    }

    public final boolean g(int i) {
        return this.b <= i;
    }

    public final boolean i(char c) {
        return c == '(' || c == '{' || c == '[';
    }

    public RU j() {
        char c = this.a[this.f];
        while (Character.isWhitespace(c)) {
            char[] cArr = this.a;
            int i = this.f + 1;
            this.f = i;
            c = cArr[i];
        }
        if (Character.isDigit(c) || c == '.') {
            RU ru2 = this.g;
            if (ru2 != null) {
                if (ru2.a() == 1) {
                    throw new IllegalArgumentException("Unable to parse char '" + c + "' (Code:" + ((int) c) + ") at [" + this.f + "]");
                }
                if (this.g.a() != 2 && this.g.a() != 4 && this.g.a() != 3 && this.g.a() != 7) {
                    VE ve = new VE(WE.a('*', 2));
                    this.g = ve;
                    return ve;
                }
            }
            return m(c);
        }
        if (e(c)) {
            return k(c);
        }
        if (i(c)) {
            RU ru3 = this.g;
            if (ru3 == null || ru3.a() == 2 || this.g.a() == 4 || this.g.a() == 3 || this.g.a() == 7) {
                return o(true);
            }
            VE ve2 = new VE(WE.a('*', 2));
            this.g = ve2;
            return ve2;
        }
        if (f(c)) {
            return o(false);
        }
        if (UE.d(c)) {
            return n(c);
        }
        if (!d(c) && c != '_') {
            throw new IllegalArgumentException("Unable to parse char '" + c + "' (Code:" + ((int) c) + ") at [" + this.f + "]");
        }
        RU ru4 = this.g;
        if (ru4 == null || ru4.a() == 2 || this.g.a() == 4 || this.g.a() == 3 || this.g.a() == 7) {
            return l();
        }
        VE ve3 = new VE(WE.a('*', 2));
        this.g = ve3;
        return ve3;
    }

    public final RU k(char c) {
        this.f++;
        R4 r4 = new R4();
        this.g = r4;
        return r4;
    }

    public final RU l() {
        int i = this.f;
        if (g(i)) {
            this.f++;
        }
        RU c0942Tp = null;
        int i2 = 1;
        int i3 = 1;
        while (true) {
            int i4 = (i + i2) - 1;
            if (g(i4) || !(d(this.a[i4]) || Character.isDigit(this.a[i4]) || this.a[i4] == '_')) {
                break;
            }
            String str = new String(this.a, i, i2);
            Set set = this.e;
            if (set == null || !set.contains(str)) {
                AbstractC0452Ep abstractC0452EpA = a(str);
                if (abstractC0452EpA != null) {
                    c0942Tp = new C0942Tp(abstractC0452EpA);
                }
                i2++;
            } else {
                c0942Tp = new AX(str);
            }
            i3 = i2;
            i2++;
        }
        if (c0942Tp != null) {
            this.f += i3;
            this.g = c0942Tp;
            return c0942Tp;
        }
        throw new IllegalArgumentException("Unable to parse setVariable or function starting at pos " + this.f + " in expression '" + new String(this.a) + "'");
    }

    public final RU m(char c) {
        int i;
        int i2 = this.f;
        this.f = i2 + 1;
        if (g(i2 + 1)) {
            C2099eE c2099eE = new C2099eE(Double.parseDouble(String.valueOf(c)));
            this.g = c2099eE;
            return c2099eE;
        }
        int i3 = 1;
        while (true) {
            i = i2 + i3;
            if (!g(i)) {
                char[] cArr = this.a;
                char c2 = cArr[i];
                char c3 = cArr[i - 1];
                if (!h(c2, c3 == 'e' || c3 == 'E')) {
                    break;
                }
                i3++;
                this.f++;
            } else {
                break;
            }
        }
        char[] cArr2 = this.a;
        char c4 = cArr2[i - 1];
        if (c4 == 'e' || c4 == 'E') {
            i3--;
            this.f--;
        }
        C2099eE c2099eE2 = new C2099eE(cArr2, i2, i3);
        this.g = c2099eE2;
        return c2099eE2;
    }

    public final RU n(char c) {
        UE ueB;
        int i = this.f;
        StringBuilder sb = new StringBuilder();
        sb.append(c);
        int i2 = 1;
        while (true) {
            int i3 = i + i2;
            if (g(i3) || !UE.d(this.a[i3])) {
                break;
            }
            i2++;
            sb.append(this.a[i3]);
        }
        while (sb.length() > 0) {
            ueB = b(sb.toString());
            if (ueB != null) {
                this.f += sb.length();
                VE ve = new VE(ueB);
                this.g = ve;
                return ve;
            }
            sb.setLength(sb.length() - 1);
        }
        ueB = null;
        this.f += sb.length();
        VE ve2 = new VE(ueB);
        this.g = ve2;
        return ve2;
    }

    public final RU o(boolean z) {
        if (z) {
            this.g = new TE();
        } else {
            this.g = new C0686Kb();
        }
        this.f++;
        return this.g;
    }
}
