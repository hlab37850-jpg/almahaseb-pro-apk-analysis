package defpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: tF, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3948tF {
    public static boolean f = false;
    public String a;
    public String b;
    public C4110vF c;
    public C4029uF d;
    public Map e;

    public AbstractC3948tF(String str, C4029uF c4029uF) {
        g(str);
        h(c4029uF);
    }

    public static synchronized AbstractC3948tF d(BF bf, HashMap map) {
        String strS;
        AbstractC3948tF c1773b9;
        try {
            AbstractC3948tF abstractC3948tF = (AbstractC3948tF) bf.g();
            if (abstractC3948tF != null) {
                return abstractC3948tF;
            }
            String strS2 = bf.j("Subtype").s();
            if (strS2 == null) {
                strS2 = bf.j("S").s();
            }
            BF bfJ = bf.j("BaseFont");
            BF bfJ2 = bf.j("Encoding");
            BF bfJ3 = bf.j("FontDescriptor");
            if (bfJ != null) {
                strS = bfJ.s();
            } else {
                BF bfJ4 = bf.j("Name");
                strS = bfJ4 != null ? bfJ4.s() : null;
            }
            C4110vF c4110vF = bfJ2 != null ? new C4110vF(strS2, bfJ2) : null;
            C4029uF c4029uF = bfJ3 != null ? new C4029uF(bfJ3) : new C4029uF(strS);
            if (strS2.equals("Type0")) {
                c1773b9 = new IV(strS, bf, c4029uF);
            } else if (strS2.equals("Type1")) {
                if (c4029uF.b() != null) {
                    c1773b9 = new KV(strS, bf, c4029uF);
                } else {
                    c1773b9 = c4029uF.d() != null ? new JV(strS, bf, c4029uF) : new P8(strS, bf, c4029uF);
                }
            } else if (strS2.equals("TrueType")) {
                c1773b9 = c4029uF.c() != null ? new C3800rT(strS, bf, c4029uF) : new P8(strS, bf, c4029uF);
            } else if (strS2.equals("Type3")) {
                c1773b9 = new LV(strS, bf, map, c4029uF);
            } else {
                if (!strS2.equals("CIDFontType2") && !strS2.equals("CIDFontType0")) {
                    throw new EF("Don't know how to handle a '" + strS2 + "' font");
                }
                c1773b9 = new C1773b9(strS, bf, c4029uF);
            }
            c1773b9.j(strS2);
            c1773b9.i(c4110vF);
            bf.v(c1773b9);
            return c1773b9;
        } catch (Throwable th) {
            throw th;
        }
    }

    public String a() {
        return this.b;
    }

    public C4272xF b(char c, String str) {
        if (this.e == null) {
            this.e = new HashMap();
        }
        C4272xF c4272xF = (C4272xF) this.e.get(new Character(c));
        if (c4272xF != null) {
            return c4272xF;
        }
        C4272xF c4272xFE = e(c, str);
        this.e.put(new Character(c), c4272xFE);
        return c4272xFE;
    }

    public C4029uF c() {
        return this.d;
    }

    public abstract C4272xF e(char c, String str);

    public boolean equals(Object obj) {
        if (obj instanceof AbstractC3948tF) {
            return ((AbstractC3948tF) obj).a().equals(a());
        }
        return false;
    }

    public List f(String str) {
        C4110vF c4110vF = this.c;
        if (c4110vF != null) {
            return c4110vF.d(this, str);
        }
        char[] charArray = str.toCharArray();
        ArrayList arrayList = new ArrayList(charArray.length);
        for (char c : charArray) {
            arrayList.add(b((char) (c & 255), null));
        }
        return arrayList;
    }

    public void g(String str) {
        this.b = str;
    }

    public void h(C4029uF c4029uF) {
        this.d = c4029uF;
    }

    public int hashCode() {
        return a().hashCode();
    }

    public void i(C4110vF c4110vF) {
        this.c = c4110vF;
    }

    public void j(String str) {
        this.a = str;
    }

    public String toString() {
        return a();
    }
}
