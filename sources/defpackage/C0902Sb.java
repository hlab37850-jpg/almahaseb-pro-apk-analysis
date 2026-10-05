package defpackage;

import com.zebra.sdk.util.internal.StringUtilities;
import java.io.PrintStream;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: renamed from: Sb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0902Sb extends FV {
    public short c;
    public SortedMap d;

    /* JADX INFO: renamed from: Sb$a */
    public class a implements Comparable {
        public short a;
        public short b;

        public a(short s, short s2) {
            this.a = s;
            this.b = s2;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            a aVar;
            short s;
            short s2;
            if (!(obj instanceof a) || (s = this.a) < (s2 = (aVar = (a) obj).a)) {
                return -1;
            }
            if (s > s2) {
                return 1;
            }
            short s3 = this.b;
            short s4 = aVar.b;
            if (s3 < s4) {
                return -1;
            }
            return s3 > s4 ? 1 : 0;
        }

        public boolean equals(Object obj) {
            return compareTo(obj) == 0;
        }
    }

    public C0902Sb() {
        super(1668112752);
        m((short) 0);
        this.d = Collections.synchronizedSortedMap(new TreeMap());
    }

    @Override // defpackage.FV
    public T8 b() {
        T8 t8B = T8.b(j());
        t8B.E(l());
        t8B.E((short) this.d.size());
        int size = (this.d.size() * 8) + 4;
        for (a aVar : this.d.keySet()) {
            AbstractC2012d9 abstractC2012d9 = (AbstractC2012d9) this.d.get(aVar);
            t8B.E(aVar.a);
            t8B.E(aVar.b);
            t8B.B(size);
            size += abstractC2012d9.e();
        }
        Iterator it = this.d.values().iterator();
        while (it.hasNext()) {
            t8B.y(((AbstractC2012d9) it.next()).b());
        }
        t8B.f();
        return t8B;
    }

    @Override // defpackage.FV
    public void d(T8 t8) {
        m(t8.p());
        short sP = t8.p();
        for (int i = 0; i < sP; i++) {
            short sP2 = t8.p();
            short sP3 = t8.p();
            int iN = t8.n();
            t8.u();
            t8.w(iN);
            T8 t8I = t8.I();
            t8.G();
            try {
                AbstractC2012d9 abstractC2012d9F = AbstractC2012d9.f(t8I);
                if (abstractC2012d9F != null) {
                    g(sP2, sP3, abstractC2012d9F);
                }
            } catch (Exception e) {
                PrintStream printStream = System.out;
                printStream.println("Error reading map.  PlatformID=" + ((int) sP2) + ", PlatformSpecificID=" + ((int) sP3));
                StringBuilder sb = new StringBuilder("Reason: ");
                sb.append(e);
                printStream.println(sb.toString());
            }
        }
    }

    public void g(short s, short s2, AbstractC2012d9 abstractC2012d9) {
        this.d.put(new a(s, s2), abstractC2012d9);
    }

    public AbstractC2012d9 h(short s, short s2) {
        return (AbstractC2012d9) this.d.get(new a(s, s2));
    }

    public AbstractC2012d9[] i() {
        Collection collectionValues = this.d.values();
        AbstractC2012d9[] abstractC2012d9Arr = new AbstractC2012d9[collectionValues.size()];
        collectionValues.toArray(abstractC2012d9Arr);
        return abstractC2012d9Arr;
    }

    public int j() {
        int size = (this.d.size() * 8) + 4;
        Iterator it = this.d.values().iterator();
        while (it.hasNext()) {
            size += ((AbstractC2012d9) it.next()).e();
        }
        return size;
    }

    public short k() {
        return (short) this.d.size();
    }

    public short l() {
        return this.c;
    }

    public void m(short s) {
        this.c = s;
    }

    @Override // defpackage.FV
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("    Version: " + ((int) l()) + StringUtilities.LF);
        stringBuffer.append("    NumMaps: " + ((int) k()) + StringUtilities.LF);
        for (a aVar : this.d.keySet()) {
            stringBuffer.append("    Map: platformID: " + ((int) aVar.a) + " PlatformSpecificID: " + ((int) aVar.b) + StringUtilities.LF);
            stringBuffer.append(((AbstractC2012d9) this.d.get(aVar)).toString());
        }
        return stringBuffer.toString();
    }
}
