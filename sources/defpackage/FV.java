package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class FV {
    public int a;
    public T8 b;

    public FV(int i) {
        this.a = i;
    }

    public static FV a(EV ev, String str, T8 t8) {
        FV c0902Sb;
        FV c3751qq;
        int iE = e(str);
        switch (iE) {
            case 1668112752:
                c0902Sb = new C0902Sb();
                break;
            case 1735162214:
                c3751qq = new C3751qq(ev);
                c0902Sb = c3751qq;
                break;
            case 1751474532:
                c0902Sb = new C3671pr();
                break;
            case 1751672161:
                c0902Sb = new C4237wr();
                break;
            case 1752003704:
                c3751qq = new C4318xr(ev);
                c0902Sb = c3751qq;
                break;
            case 1819239265:
                c3751qq = new C2152ew(ev);
                c0902Sb = c3751qq;
                break;
            case 1835104368:
                c0902Sb = new C2015dB();
                break;
            case 1851878757:
                c0902Sb = new ZC();
                break;
            case 1886352244:
                c0902Sb = new ZG();
                break;
            default:
                c0902Sb = new FV(iE);
                break;
        }
        if (t8 != null) {
            c0902Sb.d(t8);
        }
        return c0902Sb;
    }

    public static int e(String str) {
        char[] charArray = str.toCharArray();
        if (charArray.length == 4) {
            return (charArray[0] << 24) | (charArray[1] << 16) | (charArray[2] << '\b') | charArray[3];
        }
        throw new IllegalArgumentException("Bad tag length: " + str);
    }

    public static String f(int i) {
        return new String(new char[]{(char) ((i >> 24) & 255), (char) ((i >> 16) & 255), (char) ((i >> 8) & 255), (char) (i & 255)});
    }

    public T8 b() {
        return this.b;
    }

    public int c() {
        return this.a;
    }

    public void d(T8 t8) {
        this.b = t8;
    }

    public String toString() {
        String str = "    " + f(c()) + " Table.  Data is: ";
        if (b() == null) {
            return String.valueOf(str) + "not set";
        }
        return String.valueOf(str) + "set";
    }
}
