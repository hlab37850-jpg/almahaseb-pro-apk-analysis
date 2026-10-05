package defpackage;

import com.google.common.primitives.UnsignedBytes;
import com.itextpdf.tool.xml.html.HTML;
import java.io.PrintStream;
import java.util.Collections;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes3.dex */
public class EV {
    public int a;
    public SortedMap b = Collections.synchronizedSortedMap(new TreeMap());

    public EV(int i) {
        this.a = i;
    }

    public static int c(String str, T8 t8) {
        int iH;
        t8.u();
        if (str.equals(HTML.Tag.HEAD)) {
            t8.C(8, 0);
        }
        int iF = (t8.F() + 3) / 4;
        int i = 0;
        for (int i2 = 0; i2 < iF; i2++) {
            int iF2 = t8.F();
            if (iF2 == 1) {
                iH = (t8.h() & UnsignedBytes.MAX_VALUE) << 24;
            } else if (iF2 != 2) {
                iH = iF2 != 3 ? t8.n() : (t8.p() << 16) + (t8.h() << 8);
            } else {
                iH = t8.p() << 16;
            }
            i += iH;
        }
        t8.G();
        return i;
    }

    public static void j(T8 t8, int i, EV ev) {
        for (int i2 = 0; i2 < i; i2++) {
            String strF = FV.f(t8.n());
            int iN = t8.n();
            int iN2 = t8.n();
            int iN3 = t8.n();
            t8.u();
            t8.w(iN2);
            T8 t8I = t8.I();
            t8I.t(iN3);
            if (c(strF, t8I) == iN) {
                ev.a(strF, t8I);
            } else {
                ev.a(strF, t8I);
            }
            t8.G();
        }
    }

    public static EV k(T8 t8) {
        int iN = t8.n();
        short sP = t8.p();
        t8.p();
        t8.p();
        t8.p();
        EV ev = new EV(iN);
        j(t8, sP, ev);
        return ev;
    }

    public void a(String str, T8 t8) {
        this.b.put(str, t8);
    }

    public void b(String str, FV fv) {
        this.b.put(str, fv);
    }

    public short d() {
        return (short) (Math.log(Math.pow(2.0d, Math.floor(Math.log(e()) / Math.log(2.0d)))) / Math.log(2.0d));
    }

    public short e() {
        return (short) this.b.size();
    }

    public short f() {
        return (short) ((Math.pow(2.0d, Math.floor(Math.log(e()) / Math.log(2.0d))) * 16.0d) - ((double) g()));
    }

    public short g() {
        return (short) (Math.pow(2.0d, Math.floor(Math.log(e()) / Math.log(2.0d))) * 16.0d);
    }

    public FV h(String str) {
        Object obj = this.b.get(str);
        if (!(obj instanceof T8)) {
            return (FV) obj;
        }
        FV fvA = FV.a(this, str, (T8) obj);
        b(str, fvA);
        return fvA;
    }

    public int i() {
        return this.a;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        PrintStream printStream = System.out;
        printStream.println("Type         : " + i());
        printStream.println("NumTables    : " + ((int) e()));
        printStream.println("SearchRange  : " + ((int) g()));
        printStream.println("EntrySelector: " + ((int) d()));
        printStream.println("RangeShift   : " + ((int) f()));
        for (Map.Entry entry : this.b.entrySet()) {
            System.out.println(entry.getValue() instanceof T8 ? h((String) entry.getKey()) : (FV) entry.getValue());
        }
        return stringBuffer.toString();
    }
}
