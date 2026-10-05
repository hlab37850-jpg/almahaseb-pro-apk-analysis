package defpackage;

import com.zebra.sdk.util.internal.StringUtilities;
import java.util.Collections;
import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: renamed from: f9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C2175f9 extends AbstractC2012d9 {
    public SortedMap c;

    /* JADX INFO: renamed from: f9$a */
    public class a implements Comparable {
        public int a;
        public int b;
        public boolean c;

        public a(short s, short s2, boolean z) {
            this.a = s2 & 65535;
            this.b = 65535 & s;
            this.c = z;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            int i;
            if (!(obj instanceof a)) {
                return -1;
            }
            a aVar = (a) obj;
            int i2 = aVar.a;
            int i3 = this.b;
            if ((i2 >= i3 && i2 <= this.a) || ((i = aVar.b) >= i3 && i <= this.a)) {
                return 0;
            }
            int i4 = this.a;
            if (i4 > i2) {
                return 1;
            }
            return i4 < i2 ? -1 : 0;
        }

        public boolean equals(Object obj) {
            return compareTo(obj) == 0;
        }
    }

    public C2175f9(short s) {
        super((short) 4, s);
        this.c = Collections.synchronizedSortedMap(new TreeMap());
        j((short) -1, (short) -1, new char[]{0});
    }

    @Override // defpackage.AbstractC2012d9
    public T8 b() {
        T8 t8B = T8.b(e());
        t8B.E(c());
        t8B.E(e());
        t8B.E(d());
        t8B.E((short) (n() * 2));
        t8B.E(m());
        t8B.E(k());
        t8B.E(l());
        Iterator it = this.c.keySet().iterator();
        while (it.hasNext()) {
            t8B.E((short) ((a) it.next()).a);
        }
        t8B.E((short) 0);
        Iterator it2 = this.c.keySet().iterator();
        while (it2.hasNext()) {
            t8B.E((short) ((a) it2.next()).b);
        }
        for (a aVar : this.c.keySet()) {
            if (aVar.c) {
                t8B.E((short) 0);
            } else {
                t8B.E(((Integer) this.c.get(aVar)).shortValue());
            }
        }
        int iN = (n() * 8) + 16;
        for (a aVar2 : this.c.keySet()) {
            if (aVar2.c) {
                t8B.E((short) (iN - t8B.v()));
                t8B.u();
                t8B.w(iN);
                char[] cArr = (char[]) this.c.get(aVar2);
                for (char c : cArr) {
                    t8B.A(c);
                }
                t8B.G();
                iN += cArr.length * 2;
            } else {
                t8B.E((short) 0);
            }
        }
        t8B.w(iN);
        t8B.f();
        return t8B;
    }

    @Override // defpackage.AbstractC2012d9
    public short e() {
        short size = (short) ((this.c.size() * 8) + 16);
        for (a aVar : this.c.keySet()) {
            if (aVar.c) {
                size = (short) (size + (((char[]) this.c.get(aVar)).length * 2));
            }
        }
        return size;
    }

    @Override // defpackage.AbstractC2012d9
    public char g(char c) {
        for (a aVar : this.c.keySet()) {
            if (aVar.a >= c) {
                if (aVar.b <= c) {
                    return aVar.c ? ((char[]) this.c.get(aVar))[c - aVar.b] : (char) (c + ((Integer) this.c.get(aVar)).intValue());
                }
                return (char) 0;
            }
        }
        return (char) 0;
    }

    @Override // defpackage.AbstractC2012d9
    public void h(int i, T8 t8) {
        int iP = (short) (t8.p() / 2);
        t8.p();
        t8.p();
        t8.p();
        short[] sArr = new short[iP];
        short[] sArr2 = new short[iP];
        short[] sArr3 = new short[iP];
        short[] sArr4 = new short[iP];
        for (int i2 = 0; i2 < iP; i2++) {
            sArr[i2] = t8.p();
        }
        t8.p();
        for (int i3 = 0; i3 < iP; i3++) {
            sArr2[i3] = t8.p();
        }
        for (int i4 = 0; i4 < iP; i4++) {
            sArr3[i4] = t8.p();
        }
        for (int i5 = 0; i5 < iP; i5++) {
            short sP = t8.p();
            sArr4[i5] = sP;
            if (sP <= 0) {
                i(sArr2[i5], sArr[i5], sArr3[i5]);
            } else {
                int iV = sArr4[i5] + (t8.v() - 2);
                int i6 = (sArr[i5] - sArr2[i5]) + 1;
                char[] cArr = new char[i6];
                t8.u();
                for (int i7 = 0; i7 < i6; i7++) {
                    t8.w((i7 * 2) + iV);
                    cArr[i7] = t8.l();
                }
                t8.G();
                j(sArr2[i5], sArr[i5], cArr);
            }
        }
    }

    public void i(short s, short s2, short s3) {
        a aVar = new a(s, s2, false);
        this.c.remove(aVar);
        this.c.put(aVar, new Integer(s3));
    }

    public void j(short s, short s2, char[] cArr) {
        if (cArr.length != (s2 - s) + 1) {
            throw new IllegalArgumentException("Wrong number of entries in map");
        }
        a aVar = new a(s, s2, true);
        this.c.remove(aVar);
        this.c.put(aVar, cArr);
    }

    public short k() {
        return (short) (Math.log(m() / 2) / Math.log(2.0d));
    }

    public short l() {
        return (short) ((n() * 2) - m());
    }

    public short m() {
        return (short) (Math.pow(2.0d, Math.floor(Math.log(n()) / Math.log(2.0d))) * 2.0d);
    }

    public short n() {
        return (short) this.c.size();
    }

    @Override // defpackage.AbstractC2012d9
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(super.toString());
        stringBuffer.append("        SegmentCount : " + ((int) n()) + StringUtilities.LF);
        stringBuffer.append("        SearchRange  : " + ((int) m()) + StringUtilities.LF);
        stringBuffer.append("        EntrySelector: " + ((int) k()) + StringUtilities.LF);
        stringBuffer.append("        RangeShift   : " + ((int) l()) + StringUtilities.LF);
        for (a aVar : this.c.keySet()) {
            stringBuffer.append("        ");
            stringBuffer.append("Segment: " + Integer.toHexString(aVar.b));
            stringBuffer.append("-" + Integer.toHexString(aVar.a) + " ");
            stringBuffer.append("hasMap: " + aVar.c + " ");
            if (!aVar.c) {
                stringBuffer.append("delta: " + this.c.get(aVar));
            }
            stringBuffer.append(StringUtilities.LF);
        }
        return stringBuffer.toString();
    }
}
