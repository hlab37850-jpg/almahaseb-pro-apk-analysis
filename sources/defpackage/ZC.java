package defpackage;

import com.itextpdf.text.xml.xmp.XmpWriter;
import com.zebra.sdk.util.internal.StringUtilities;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes3.dex */
public class ZC extends FV {
    public short c;
    public SortedMap d;

    public class a implements Comparable {
        public short a;
        public short b;
        public short c;
        public short d;

        public a(short s, short s2, short s3, short s4) {
            this.a = s;
            this.b = s2;
            this.c = s3;
            this.d = s4;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            if (!(obj instanceof a)) {
                return -1;
            }
            a aVar = (a) obj;
            short s = this.a;
            short s2 = aVar.a;
            if (s > s2) {
                return 1;
            }
            if (s < s2) {
                return -1;
            }
            short s3 = this.b;
            short s4 = aVar.b;
            if (s3 > s4) {
                return 1;
            }
            if (s3 < s4) {
                return -1;
            }
            short s5 = this.c;
            short s6 = aVar.c;
            if (s5 > s6) {
                return 1;
            }
            if (s5 < s6) {
                return -1;
            }
            short s7 = this.d;
            short s8 = aVar.d;
            if (s7 > s8) {
                return 1;
            }
            return s7 < s8 ? -1 : 0;
        }

        public boolean equals(Object obj) {
            return compareTo(obj) == 0;
        }
    }

    public ZC() {
        super(1851878757);
        this.d = Collections.synchronizedSortedMap(new TreeMap());
    }

    public static String h(int i, int i2) {
        return (i == 0 || i == 3) ? XmpWriter.UTF16 : "US-ASCII";
    }

    @Override // defpackage.FV
    public T8 b() {
        T8 t8B = T8.b(k());
        short sI = (short) ((i() * 12) + 6);
        t8B.E(j());
        t8B.E(i());
        t8B.E(sI);
        short s = 0;
        for (a aVar : this.d.keySet()) {
            T8 t8G = T8.g(Charset.forName(h(aVar.a, aVar.b)).encode((String) this.d.get(aVar)));
            short sF = (short) (t8G.F() & 65535);
            t8B.E(aVar.a);
            t8B.E(aVar.b);
            t8B.E(aVar.c);
            t8B.E(aVar.d);
            t8B.E(sF);
            t8B.E(s);
            t8B.u();
            t8B.w(sI + s);
            t8B.y(t8G);
            t8B.G();
            s = (short) (s + sF);
        }
        t8B.w(sI + s);
        t8B.f();
        return t8B;
    }

    @Override // defpackage.FV
    public void d(T8 t8) {
        l(t8.p());
        short sP = t8.p();
        short sP2 = t8.p();
        for (int i = 0; i < sP; i++) {
            short sP3 = t8.p();
            short sP4 = t8.p();
            short sP5 = t8.p();
            short sP6 = t8.p();
            int iP = t8.p() & 65535;
            int iP2 = 65535 & t8.p();
            t8.u();
            t8.w(iP2 + sP2);
            T8 t8I = t8.I();
            t8I.t(iP);
            t8.G();
            g(sP3, sP4, sP5, sP6, Charset.forName(h(sP3, sP4)).decode(t8I.J()).toString());
        }
    }

    public void g(short s, short s2, short s3, short s4, String str) {
        this.d.put(new a(s, s2, s3, s4), str);
    }

    public short i() {
        return (short) this.d.size();
    }

    public short j() {
        return this.c;
    }

    public int k() {
        int i = (i() * 12) + 6;
        for (a aVar : this.d.keySet()) {
            i += T8.g(Charset.forName(h(aVar.a, aVar.b)).encode((String) this.d.get(aVar))).F();
        }
        return i;
    }

    public void l(short s) {
        this.c = s;
    }

    @Override // defpackage.FV
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("    Format: " + ((int) j()) + StringUtilities.LF);
        stringBuffer.append("    Count : " + ((int) i()) + StringUtilities.LF);
        for (a aVar : this.d.keySet()) {
            stringBuffer.append("     platformID: " + ((int) aVar.a));
            StringBuilder sb = new StringBuilder(" platformSpecificID: ");
            sb.append((int) aVar.b);
            stringBuffer.append(sb.toString());
            stringBuffer.append(" languageID: " + ((int) aVar.c));
            stringBuffer.append(" nameID: " + ((int) aVar.d) + StringUtilities.LF);
            stringBuffer.append("      " + ((String) this.d.get(aVar)) + StringUtilities.LF);
        }
        return stringBuffer.toString();
    }
}
