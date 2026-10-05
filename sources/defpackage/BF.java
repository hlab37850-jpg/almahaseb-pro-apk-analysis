package defpackage;

import com.itextpdf.text.pdf.PdfBoolean;
import com.zebra.sdk.util.internal.StringUtilities;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class BF {
    public static final BF i = new BF(null, 8, null);
    public int a;
    public Object b;
    public T8 c;
    public ZQ d;
    public C3706qF e;
    public ZQ f;
    public int g;
    public int h;

    public BF(C3706qF c3706qF, int i2, Object obj) {
        this.g = -2;
        this.h = -2;
        this.a = i2;
        if (i2 == 4) {
            obj = ((String) obj).intern();
        } else if (i2 == 9 && obj.equals(PdfBoolean.TRUE)) {
            this.a = 1;
            obj = Boolean.TRUE;
        } else if (i2 == 9 && obj.equals(PdfBoolean.FALSE)) {
            this.a = 1;
            obj = Boolean.FALSE;
        }
        this.b = obj;
        this.e = c3706qF;
    }

    public BF a() {
        if (this.a != 0) {
            return this;
        }
        ZQ zq = this.f;
        BF bf = zq != null ? (BF) zq.a() : null;
        if ((bf == null || bf.b == null) && this.e == null) {
            System.out.println("Bad seed (owner==null)!  Object=" + this);
        }
        return bf;
    }

    public final T8 b() {
        ZQ zq = this.d;
        T8 t8 = zq != null ? (T8) zq.a() : null;
        if (t8 != null) {
            return t8;
        }
        this.c.H();
        T8 t8A = AbstractC3379mF.a(this, this.c);
        this.d = new ZQ(t8A);
        return t8A;
    }

    public BF c() {
        if (this.a != 0) {
            return this;
        }
        ZQ zq = this.f;
        BF bf = zq != null ? (BF) zq.a() : null;
        if (bf != null && bf.b != null) {
            return bf;
        }
        if (this.e == null) {
            System.out.println("Bad seed (owner==null)!  Object=" + this);
        }
        BF bfB = this.e.b((QF) this.b, h());
        this.f = new ZQ(bfB);
        return bfB;
    }

    public BF[] d() {
        int i2 = this.a;
        if (i2 == 0) {
            return c().d();
        }
        return i2 == 5 ? (BF[]) this.b : new BF[]{this};
    }

    public BF e(int i2) {
        int i3 = this.a;
        if (i3 == 0) {
            return c().e(i2);
        }
        if (i3 == 5) {
            return ((BF[]) this.b)[i2];
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (this.a == 0 && (obj instanceof BF)) {
            BF bf = (BF) obj;
            if (bf.a == 0) {
                QF qf = (QF) this.b;
                QF qf2 = (QF) bf.b;
                if (qf.d() == qf2.d() && qf.c() == qf2.c() && qf.a() == qf2.a()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean f() {
        int i2 = this.a;
        if (i2 == 0) {
            return c().f();
        }
        return i2 == 1 && this.b == Boolean.TRUE;
    }

    public Object g() {
        if (this.a == 0) {
            return c().g();
        }
        ZQ zq = this.f;
        if (zq != null) {
            return zq.a();
        }
        return null;
    }

    public InterfaceC3461nF h() {
        C3706qF c3706qF = this.e;
        return c3706qF != null ? c3706qF.e() : C2066ds.d();
    }

    public Iterator i() {
        int i2 = this.a;
        if (i2 == 0) {
            return c().i();
        }
        return (i2 == 6 || i2 == 7) ? ((HashMap) this.b).keySet().iterator() : new ArrayList().iterator();
    }

    public BF j(String str) {
        int i2 = this.a;
        if (i2 == 0) {
            return c().j(str);
        }
        if (i2 != 6 && i2 != 7) {
            return null;
        }
        return (BF) ((HashMap) this.b).get(str.intern().intern());
    }

    public HashMap k() {
        int i2 = this.a;
        if (i2 == 0) {
            return c().k();
        }
        return (i2 == 6 || i2 == 7) ? (HashMap) this.b : new HashMap();
    }

    public double l() {
        int i2 = this.a;
        if (i2 == 0) {
            return c().l();
        }
        if (i2 == 2) {
            return ((Double) this.b).doubleValue();
        }
        return 0.0d;
    }

    public float m() {
        int i2 = this.a;
        if (i2 == 0) {
            return c().m();
        }
        if (i2 == 2) {
            return ((Double) this.b).floatValue();
        }
        return 0.0f;
    }

    public int n() {
        int i2 = this.a;
        if (i2 == 0) {
            return c().n();
        }
        if (i2 == 2) {
            return ((Double) this.b).intValue();
        }
        return 0;
    }

    public int o() {
        return this.h;
    }

    public int p() {
        return this.g;
    }

    public byte[] q() {
        T8 t8;
        int i2 = this.a;
        if (i2 == 0) {
            return c().q();
        }
        if (i2 != 7 || (t8 = this.c) == null) {
            if (i2 == 3) {
                return LF.b(s());
            }
            return null;
        }
        synchronized (t8) {
            try {
                T8 t8B = b();
                if (t8B.q() && t8B.d() == 0) {
                    byte[] bArrC = t8B.c();
                    if (bArrC.length == t8B.F()) {
                        return bArrC;
                    }
                }
                byte[] bArr = new byte[t8B.F()];
                t8B.j(bArr);
                t8B.f();
                return bArr;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public T8 r() {
        T8 t8;
        T8 t8E;
        int i2 = this.a;
        if (i2 == 0) {
            return c().r();
        }
        if (i2 != 7 || (t8 = this.c) == null) {
            if (i2 == 3) {
                return T8.K(s().getBytes());
            }
            return null;
        }
        synchronized (t8) {
            t8E = b().e();
        }
        return t8E;
    }

    public String s() {
        int i2 = this.a;
        if (i2 == 0) {
            return c().s();
        }
        if (i2 == 3 || i2 == 4 || i2 == 9) {
            return (String) this.b;
        }
        return null;
    }

    public int t() {
        int i2 = this.a;
        return i2 == 0 ? c().t() : i2;
    }

    public String toString() {
        try {
            int i2 = this.a;
            if (i2 == 0) {
                StringBuffer stringBuffer = new StringBuffer();
                StringBuilder sb = new StringBuilder("Indirect to #");
                sb.append(((QF) this.b).d());
                sb.append(((QF) this.b).a() ? " comp" : "");
                stringBuffer.append(sb.toString());
                try {
                    BF bfA = a();
                    StringBuilder sb2 = new StringBuilder(StringUtilities.LF);
                    sb2.append(bfA == null ? "<ref>" : bfA.toString());
                    stringBuffer.append(sb2.toString());
                } catch (Throwable th) {
                    stringBuffer.append(th.toString());
                }
                return stringBuffer.toString();
            }
            if (i2 == 1) {
                StringBuilder sb3 = new StringBuilder("Boolean: ");
                sb3.append(f() ? PdfBoolean.TRUE : PdfBoolean.FALSE);
                return sb3.toString();
            }
            if (i2 == 2) {
                return "Number: " + l();
            }
            if (i2 == 3) {
                return "String: " + s();
            }
            if (i2 == 4) {
                return "Name: /" + s();
            }
            if (i2 == 5) {
                return "Array, length=" + ((BF[]) this.b).length;
            }
            if (i2 != 6) {
                if (i2 != 7) {
                    if (i2 == 8) {
                        return "Null";
                    }
                    if (i2 != 9) {
                        return "Whoops!  big error!  Unknown type";
                    }
                    return "Keyword: " + s();
                }
                byte[] bArrQ = q();
                if (bArrQ == null) {
                    return "Broken stream";
                }
                StringBuilder sb4 = new StringBuilder("Stream: [[");
                int length = 30;
                if (bArrQ.length <= 30) {
                    length = bArrQ.length;
                }
                sb4.append(new String(bArrQ, 0, length));
                sb4.append("]]");
                return sb4.toString();
            }
            StringBuffer stringBuffer2 = new StringBuffer();
            BF bfJ = j("Type");
            if (bfJ != null) {
                stringBuffer2.append(bfJ.s());
                BF bfJ2 = j("Subtype");
                if (bfJ2 == null) {
                    bfJ2 = j("S");
                }
                if (bfJ2 != null) {
                    stringBuffer2.append("/" + bfJ2.s());
                }
            } else {
                stringBuffer2.append("Untyped");
            }
            stringBuffer2.append(" dictionary. Keys:");
            for (Map.Entry entry : ((HashMap) this.b).entrySet()) {
                stringBuffer2.append("\n   " + entry.getKey() + "  " + entry.getValue());
            }
            return stringBuffer2.toString();
        } catch (IOException e) {
            return "Caught an error: " + e;
        }
    }

    public boolean u() {
        return this.a == 0;
    }

    public void v(Object obj) {
        if (this.a == 0) {
            c().v(obj);
        } else {
            this.f = new ZQ(obj);
        }
    }

    public void w(int i2, int i3) {
        this.g = i2;
        this.h = i3;
    }

    public void x(T8 t8) {
        this.a = 7;
        this.c = t8;
    }

    public BF(Object obj) throws EF {
        this.g = -2;
        this.h = -2;
        this.e = null;
        this.b = obj;
        if (!(obj instanceof Double) && !(obj instanceof Integer)) {
            if (obj instanceof String) {
                this.a = 4;
                return;
            }
            if (obj instanceof BF[]) {
                this.a = 5;
                return;
            }
            if (obj instanceof Object[]) {
                Object[] objArr = (Object[]) obj;
                BF[] bfArr = new BF[objArr.length];
                for (int i2 = 0; i2 < objArr.length; i2++) {
                    bfArr[i2] = new BF(objArr[i2]);
                }
                this.b = bfArr;
                this.a = 5;
                return;
            }
            if (obj instanceof HashMap) {
                this.a = 6;
                return;
            }
            if (obj instanceof Boolean) {
                this.a = 1;
                return;
            }
            if (obj instanceof FF.b) {
                FF.b bVar = (FF.b) obj;
                if (bVar.a.equals(PdfBoolean.TRUE)) {
                    this.b = Boolean.TRUE;
                    this.a = 1;
                    return;
                } else if (bVar.a.equals(PdfBoolean.FALSE)) {
                    this.b = Boolean.FALSE;
                    this.a = 1;
                    return;
                } else {
                    this.b = bVar.a;
                    this.a = 4;
                    return;
                }
            }
            throw new EF("Bad type for raw PDFObject: " + obj);
        }
        this.a = 2;
    }

    public BF(C3706qF c3706qF, QF qf) {
        this.g = -2;
        this.h = -2;
        this.a = 0;
        this.b = qf;
        this.e = c3706qF;
    }
}
