package defpackage;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.Log;
import com.google.common.net.HttpHeaders;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/* JADX INFO: loaded from: classes3.dex */
public class FF extends AbstractRunnableC3450n7 {
    public int f;
    public Stack g;
    public Stack h;
    public a i;
    public Path j;
    public int k;
    public int l;
    public b p;
    public boolean q;
    public C2283gY t;
    public CF u;
    public byte[] v;
    public HashMap w;
    public boolean n = false;
    public boolean x = false;

    public class a implements Cloneable {
        public AbstractC3297lF a;
        public AbstractC3297lF b;
        public OF c;

        public a() {
        }

        public Object clone() {
            a aVar = FF.this.new a();
            aVar.a = this.a;
            aVar.b = this.b;
            aVar.c = (OF) this.c.clone();
            return aVar;
        }
    }

    public static class b {
        public String a;
        public double b;
        public int c;

        public String toString() {
            int i = this.c;
            if (i == 3) {
                return "NUM: " + this.b;
            }
            if (i == 2) {
                return "CMD: " + this.a;
            }
            if (i == 0) {
                return "UNK";
            }
            if (i == -1) {
                return "EOF";
            }
            if (i == 1) {
                return "NAME: " + this.a;
            }
            if (i == 2) {
                return "CMD: " + this.a;
            }
            if (i == 7) {
                return "STR: (" + this.a;
            }
            if (i == 9) {
                return "ARY [";
            }
            if (i == 8) {
                return "ARY ]";
            }
            return "some kind of brace (" + this.c + ")";
        }
    }

    public FF(CF cf, byte[] bArr, HashMap map) {
        this.t = new C2283gY(cf);
        this.w = map;
        if (map == null) {
            this.w = new HashMap();
        }
        this.v = bArr;
        this.f = 0;
    }

    public final void A() {
        this.i.c.r();
    }

    public final void B() {
        this.u.l();
        this.i = (a) this.h.pop();
    }

    public final String C() {
        int i;
        byte b2;
        int i2;
        byte[] bArr = this.v;
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i3 = 0;
        char c = 0;
        while (true) {
            i = this.l;
            if (i >= length || (b2 = bArr[i]) == 62) {
                break;
            }
            char c2 = (char) b2;
            if (c2 >= '0' && c2 <= '9') {
                i2 = c2 - '0';
            } else if (c2 >= 'a' && c2 <= 'f') {
                i2 = c2 - 'W';
            } else if (c2 < 'A' || c2 > 'F') {
                this.l = i + 1;
            } else {
                i2 = c2 - '7';
            }
            byte b3 = (byte) i2;
            int i4 = 1 - (i3 % 2);
            c = (char) (c | ((b3 & 15) << (i4 << 2)));
            if (i4 == 0) {
                stringBuffer.append(c);
                c = 0;
            }
            i3++;
            this.l++;
        }
        this.l = i + 1;
        return stringBuffer.toString();
    }

    public final String D() {
        byte[] bArr = this.v;
        int i = this.l;
        while (true) {
            int i2 = this.l;
            if (i2 >= bArr.length || !C3706qF.j(bArr[i2])) {
                break;
            }
            this.l++;
        }
        return new String(bArr, i, this.l - i);
    }

    public final double E() {
        byte[] bArr = this.v;
        int i = this.l;
        this.l = i + 1;
        byte b2 = bArr[i];
        int i2 = 0;
        boolean z = b2 == 45;
        byte b3 = 46;
        boolean z2 = b2 == 46;
        double d = z2 ? 0.1d : 1.0d;
        if (b2 >= 48 && b2 <= 57) {
            i2 = b2 - 48;
        }
        double d2 = i2;
        while (true) {
            int i3 = this.l;
            this.l = i3 + 1;
            byte b4 = bArr[i3];
            if (b4 == b3) {
                if (z2) {
                    this.l = i3;
                    break;
                }
                d = 0.1d;
                z2 = true;
            } else {
                if (b4 < 48 || b4 > 57) {
                    this.l = i3;
                    break;
                }
                int i4 = b4 - 48;
                if (z2) {
                    d2 += ((double) i4) * d;
                    d *= 0.1d;
                } else {
                    d2 = (d2 * 10.0d) + ((double) i4);
                }
                b3 = 46;
            }
        }
        return z ? -d2 : d2;
    }

    public final String F() {
        byte[] bArr = this.v;
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i = 0;
        while (true) {
            int i2 = this.l;
            if (i2 >= length) {
                break;
            }
            int i3 = i2 + 1;
            this.l = i3;
            int i4 = bArr[i2];
            if (i4 == 41) {
                int i5 = i - 1;
                if (i == 0) {
                    break;
                }
                i = i5;
            } else if (i4 == 40) {
                i++;
            } else if (i4 == 92) {
                this.l = i2 + 2;
                i4 = bArr[i3];
                if (i4 >= 48 && i4 < 56) {
                    int i6 = 0;
                    for (int i7 = 0; i4 >= 48 && i4 < 56 && i7 < 3; i7++) {
                        i6 = ((i6 << 3) + i4) - 48;
                        int i8 = this.l;
                        this.l = i8 + 1;
                        i4 = bArr[i8];
                    }
                    this.l--;
                    i4 = i6;
                } else if (i4 == 110) {
                    i4 = 10;
                } else if (i4 == 114) {
                    i4 = 13;
                } else if (i4 == 116) {
                    i4 = 9;
                } else if (i4 == 98) {
                    i4 = 8;
                } else if (i4 == 102) {
                    i4 = 12;
                }
            }
            stringBuffer.append((char) i4);
        }
        return stringBuffer.toString();
    }

    public final void G(String str) throws EF {
        BF bfO = o(str, "ExtGState");
        BF bfJ = bfO.j("LW");
        if (bfJ != null) {
            this.u.p(bfJ.m());
        }
        BF bfJ2 = bfO.j("LC");
        if (bfJ2 != null) {
            this.u.e(bfJ2.n());
        }
        BF bfJ3 = bfO.j("LJ");
        if (bfJ3 != null) {
            this.u.i(bfJ3.n());
        }
        BF bfJ4 = bfO.j("Font");
        if (bfJ4 != null) {
            this.i.c.t(p(bfJ4.e(0).s()), bfJ4.e(1).m());
        }
        BF bfJ5 = bfO.j("ML");
        if (bfJ5 != null) {
            this.u.j(bfJ5.m());
        }
        BF bfJ6 = bfO.j("D");
        if (bfJ6 != null) {
            BF[] bfArrD = bfJ6.e(0).d();
            float[] fArr = new float[bfArrD.length];
            for (int i = 0; i < bfArrD.length; i++) {
                fArr[i] = bfArrD[i].m();
            }
            this.u.d(fArr, bfJ6.e(1).m());
        }
        BF bfJ7 = bfO.j("CA");
        if (bfJ7 != null) {
            this.u.n(bfJ7.m());
        }
        BF bfJ8 = bfO.j("ca");
        if (bfJ8 != null) {
            this.u.f(bfJ8.m());
        }
    }

    @Override // defpackage.AbstractRunnableC3450n7
    public void a() {
        OF of;
        a aVar = this.i;
        if (aVar != null && (of = aVar.c) != null) {
            of.i();
        }
        CF cf = this.u;
        if (cf != null) {
            cf.r();
        }
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.u = null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:118:0x0537 A[Catch: Exception -> 0x0034, TRY_LEAVE, TryCatch #0 {Exception -> 0x0034, blocks: (B:12:0x0029, B:14:0x002f, B:18:0x0038, B:20:0x003f, B:22:0x0047, B:24:0x004f, B:26:0x0057, B:38:0x0071, B:39:0x0074, B:40:0x0077, B:41:0x007a, B:44:0x0080, B:45:0x0093, B:46:0x0094, B:48:0x0098, B:49:0x009f, B:50:0x00aa, B:51:0x00b9, B:52:0x00c8, B:53:0x00e3, B:54:0x00ee, B:55:0x00f3, B:56:0x00fa, B:57:0x0115, B:58:0x0124, B:59:0x013b, B:60:0x0155, B:61:0x0170, B:62:0x0178, B:63:0x0193, B:64:0x0198, B:65:0x01a2, B:66:0x01af, B:67:0x01bc, B:68:0x01c5, B:69:0x01da, B:70:0x01e7, B:71:0x01f4, B:72:0x020b, B:73:0x021a, B:74:0x022d, B:75:0x023a, B:76:0x0249, B:77:0x0258, B:78:0x0273, B:79:0x0288, B:80:0x02c3, B:81:0x02d4, B:82:0x02ef, B:83:0x02fc, B:84:0x0300, B:85:0x0304, B:86:0x030d, B:87:0x0312, B:88:0x0327, B:89:0x032c, B:90:0x0336, B:91:0x0343, B:92:0x0352, B:93:0x0357, B:94:0x0372, B:95:0x038b, B:96:0x03a6, B:97:0x03ab, B:98:0x03b0, B:99:0x03cc, B:100:0x03ed, B:101:0x03f8, B:102:0x0401, B:103:0x041d, B:104:0x0434, B:105:0x044e, B:106:0x0462, B:107:0x0466, B:108:0x047b, B:109:0x0480, B:110:0x048c, B:111:0x04a1, B:112:0x04b7, B:113:0x04dc, B:114:0x04e7, B:115:0x04f9, B:116:0x0513, B:117:0x051d, B:118:0x0537), top: B:127:0x0029 }] */
    @Override // defpackage.AbstractRunnableC3450n7
    public int g() throws EF {
        CF cf = (CF) this.t.a();
        this.u = cf;
        if (cf == null) {
            System.out.println("Page gone.  Stopping");
            return 5;
        }
        Object objT = t();
        if (objT == null) {
            return 6;
        }
        if (objT instanceof b) {
            String str = ((b) objT).a;
            try {
                int iCharAt = (str.length() > 0 ? str.charAt(0) : (char) 0) + (str.length() > 1 ? str.charAt(1) << '\b' : 0) + (str.length() > 2 ? str.charAt(2) << 16 : 0);
                if (iCharAt == 70) {
                    this.u.k(this.j, this.k | 2);
                    this.k = 0;
                    this.j = new Path();
                } else if (iCharAt == 71) {
                    this.i.b = AbstractC3297lF.a(0);
                    this.u.o(this.i.b.f(w(1)));
                } else if (iCharAt == 74) {
                    this.u.e(y());
                } else if (iCharAt == 75) {
                    this.i.b = AbstractC3297lF.a(2);
                    this.u.o(this.i.b.f(w(4)));
                } else if (iCharAt == 118) {
                    float[] fArrW = w(4);
                    this.j.quadTo(fArrW[0], fArrW[1], fArrW[2], fArrW[3]);
                } else if (iCharAt != 119) {
                    switch (iCharAt) {
                        case 34:
                            String strZ = z();
                            float fV = v();
                            this.i.c.A(v());
                            this.i.c.s(fV);
                            this.i.c.d(this.u, strZ);
                            break;
                        case 39:
                            this.i.c.a();
                            this.i.c.d(this.u, z());
                            break;
                        case 66:
                            this.u.k(this.j, this.k | 3);
                            this.k = 0;
                            this.j = new Path();
                            break;
                        case 77:
                            this.u.j(y());
                            break;
                        case 81:
                            B();
                            break;
                        case 83:
                            this.u.k(this.j, this.k | 1);
                            this.k = 0;
                            this.j = new Path();
                            break;
                        case 87:
                            this.k = 4;
                            break;
                        case 113:
                            this.h.push((a) this.i.clone());
                            this.u.m();
                            break;
                        case 115:
                            this.j.close();
                            this.u.k(this.j, this.k | 1);
                            this.k = 0;
                            this.j = new Path();
                            break;
                        case 121:
                            float[] fArrW2 = w(4);
                            Path path = this.j;
                            float f = fArrW2[0];
                            float f2 = fArrW2[1];
                            float f3 = fArrW2[2];
                            float f4 = fArrW2[3];
                            path.cubicTo(f, f2, f3, f4, f3, f4);
                            break;
                        case 10818:
                            this.j.setFillType(Path.FillType.EVEN_ODD);
                            this.u.k(this.j, this.k | 3);
                            this.k = 0;
                            this.j = new Path();
                            break;
                        case 10836:
                            this.i.c.a();
                            break;
                        case 10839:
                            this.j.setFillType(Path.FillType.EVEN_ODD);
                            this.k = 4;
                            break;
                        case 10850:
                            this.j.close();
                            this.j.setFillType(Path.FillType.EVEN_ODD);
                            this.u.k(this.j, this.k | 3);
                            this.k = 0;
                            this.j = new Path();
                            break;
                        case 10854:
                            this.j.setFillType(Path.FillType.EVEN_ODD);
                            this.u.k(this.j, this.k | 2);
                            this.k = 0;
                            this.j = new Path();
                            break;
                        case 12388:
                            w(2);
                            break;
                        case 12644:
                            w(6);
                            break;
                        case 17235:
                            this.u.o(this.i.b.f(w(this.i.b.e())));
                            break;
                        case 17492:
                            float fV2 = v();
                            float fV3 = v();
                            this.i.c.v(-fV2);
                            this.i.c.b(fV3, fV2);
                            break;
                        case 18258:
                            this.i.b = AbstractC3297lF.a(1);
                            this.u.o(this.i.b.f(w(3)));
                            break;
                        case 18754:
                            s();
                            break;
                        case 19028:
                            this.i.c.e(this.u, u());
                            break;
                        case 19540:
                            this.i.c.v(v());
                            break;
                        case 20548:
                            this.g.pop();
                            z();
                            break;
                        case 20557:
                            z();
                            break;
                        case 21315:
                            this.i.b = r(new BF(this.g.pop()));
                            break;
                        case 21570:
                            A();
                            break;
                        case 21573:
                            this.i.c.h();
                            break;
                        case 22594:
                            this.q = true;
                            break;
                        case 22597:
                            this.q = false;
                            break;
                        case 25428:
                            this.i.c.s(v());
                            break;
                        case 25459:
                            this.u.g(this.i.a.c(w(this.i.a.e())));
                            break;
                        case 25684:
                            this.i.c.b(v(), v());
                            break;
                        case 25970:
                            float[] fArrW3 = w(4);
                            this.j.moveTo(fArrW3[0], fArrW3[1]);
                            this.j.lineTo(fArrW3[0] + fArrW3[2], fArrW3[1]);
                            this.j.lineTo(fArrW3[0] + fArrW3[2], fArrW3[1] + fArrW3[3]);
                            this.j.lineTo(fArrW3[0], fArrW3[1] + fArrW3[3]);
                            this.j.close();
                            break;
                        case 26196:
                            this.i.c.t(p(z()), v());
                            break;
                        case 26482:
                            this.i.a = AbstractC3297lF.a(1);
                            this.u.g(this.i.a.c(w(3)));
                            break;
                        case 26739:
                            m(o(z(), "Shading"));
                            break;
                        case 26994:
                        case 4410693:
                            break;
                        case 27220:
                            this.i.c.d(this.u, z());
                            break;
                        case 27988:
                            this.i.c.w(w(6));
                            break;
                        case 28003:
                            float[] fArrW4 = w(6);
                            Matrix matrix = new Matrix();
                            AbstractC4128vX.d(matrix, fArrW4);
                            this.u.q(matrix);
                            break;
                        case 28484:
                            n(o(z(), "XObject"));
                            break;
                        case 29009:
                            B();
                            this.h.push((a) this.i.clone());
                            this.u.m();
                            break;
                        case 29268:
                            this.i.c.x(y());
                            break;
                        case 29524:
                            this.i.c.y(v());
                            break;
                        case 29539:
                            this.i.a = r(new BF(this.g.pop()));
                            break;
                        case 29543:
                            G(z());
                            break;
                        case 30548:
                            this.i.c.A(v());
                            break;
                        case 31316:
                            this.i.c.u(v());
                            break;
                        case 4408386:
                            this.g.pop();
                            z();
                            break;
                        case 4410690:
                            z();
                            break;
                        case 5129043:
                            this.u.o(this.i.b.f(w(this.i.b.e())));
                            break;
                        case 5522001:
                            B();
                            A();
                            break;
                        case 7234419:
                            this.u.g(this.i.a.c(w(this.i.a.e())));
                            break;
                        default:
                            switch (iCharAt) {
                                case 98:
                                    this.j.close();
                                    this.u.k(this.j, this.k | 3);
                                    this.k = 0;
                                    this.j = new Path();
                                    break;
                                case 99:
                                    float[] fArrW5 = w(6);
                                    this.j.cubicTo(fArrW5[0], fArrW5[1], fArrW5[2], fArrW5[3], fArrW5[4], fArrW5[5]);
                                    break;
                                case 100:
                                    this.u.d(x(), v());
                                    break;
                                default:
                                    switch (iCharAt) {
                                        case 102:
                                            this.u.k(this.j, this.k | 2);
                                            this.k = 0;
                                            this.j = new Path();
                                            break;
                                        case 103:
                                            this.i.a = AbstractC3297lF.a(0);
                                            this.u.g(this.i.a.c(w(1)));
                                            break;
                                        case 104:
                                            this.j.close();
                                            break;
                                        case 105:
                                            v();
                                            break;
                                        case 106:
                                            this.u.i(y());
                                            break;
                                        case 107:
                                            this.i.a = AbstractC3297lF.a(2);
                                            this.u.g(this.i.a.c(w(4)));
                                            break;
                                        case 108:
                                            this.j.lineTo(v(), v());
                                            break;
                                        case 109:
                                            this.j.moveTo(v(), v());
                                            break;
                                        case 110:
                                            int i = this.k;
                                            if (i != 0) {
                                                this.u.k(this.j, i);
                                            }
                                            this.k = 0;
                                            this.j = new Path();
                                            break;
                                        default:
                                            if (!this.q) {
                                                throw new EF("Unknown command: " + str);
                                            }
                                            break;
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                } else {
                    this.u.p(v());
                }
            } catch (Exception e) {
                Log.e("ANDPDF.pdfparser", "cmd='" + str + ":" + e.getMessage(), e);
            }
            if (this.g.size() != 0) {
                this.g.setSize(0);
            }
        } else {
            this.g.push(objT);
        }
        this.u = null;
        return 4;
    }

    @Override // defpackage.AbstractRunnableC3450n7
    public void j() {
        this.g = new Stack();
        this.h = new Stack();
        this.i = new a();
        this.j = new Path();
        this.l = 0;
        this.k = 0;
        this.i.a = AbstractC3297lF.a(0);
        this.i.b = AbstractC3297lF.a(0);
        this.i.c = new OF();
    }

    public final void k(BF bf) {
        Matrix matrix;
        CF cf = (CF) bf.g();
        if (cf == null) {
            BF bfJ = bf.j("Matrix");
            if (bfJ == null) {
                matrix = new Matrix();
            } else {
                float[] fArr = new float[6];
                for (int i = 0; i < 6; i++) {
                    fArr[i] = bfJ.e(i).m();
                }
                matrix = new Matrix();
                AbstractC4128vX.d(matrix, fArr);
            }
            BF bfJ2 = bf.j("BBox");
            CF cf2 = new CF(new RectF(bfJ2.e(0).m(), bfJ2.e(1).m(), bfJ2.e(2).m(), bfJ2.e(3).m()), 0);
            cf2.q(matrix);
            HashMap map = new HashMap(this.w);
            BF bfJ3 = bf.j("Resources");
            if (bfJ3 != null) {
                map.putAll(bfJ3.k());
            }
            new FF(cf2, bf.q(), map).d(true);
            bf.v(cf2);
            cf = cf2;
        }
        this.u.m();
        this.u.b(cf);
        this.u.l();
    }

    public final void l(BF bf) {
        this.u.h(C4353yF.a(bf, this.w));
    }

    public final void n(BF bf) throws EF {
        String strS = bf.j("Subtype").s();
        if (strS == null) {
            strS = bf.j("S").s();
        }
        if (strS.equals("Image")) {
            l(bf);
        } else if (strS.equals("Form")) {
            k(bf);
        } else {
            throw new EF("Unknown XObject subtype: " + strS);
        }
    }

    public final BF o(String str, String str2) throws EF {
        if (str2 == null) {
            return (BF) this.w.get(str);
        }
        BF bf = (BF) this.w.get(str2);
        if (bf != null && bf.t() == 6) {
            return bf.j(str);
        }
        throw new EF("No dictionary called " + str2 + " found in the resources");
    }

    public final AbstractC3948tF p(String str) {
        return AbstractC3948tF.d(o(str, "Font"), this.w);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0074  */
    public final b q() {
        int i;
        int length = this.v.length;
        if (this.n) {
            this.n = false;
            return this.p;
        }
        this.p = new b();
        while (true) {
            int i2 = this.l;
            if (i2 >= length || !C3706qF.k(this.v[i2])) {
                break;
            }
            this.l++;
        }
        int i3 = this.l;
        if (i3 >= length) {
            b bVar = this.p;
            bVar.c = -1;
            return bVar;
        }
        byte[] bArr = this.v;
        this.l = i3 + 1;
        byte b2 = bArr[i3];
        while (b2 == 37) {
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                i = this.l;
                if (i >= length || b2 == 10) {
                    break;
                }
                stringBuffer.append((char) b2);
                byte[] bArr2 = this.v;
                int i4 = this.l;
                this.l = i4 + 1;
                b2 = bArr2[i4];
            }
            if (i < length) {
                byte[] bArr3 = this.v;
                int i5 = i + 1;
                this.l = i5;
                byte b3 = bArr3[i];
                if (b3 == 13) {
                    this.l = i + 2;
                    b2 = bArr3[i5];
                } else {
                    b2 = b3;
                }
            }
        }
        if (b2 == 40) {
            b bVar2 = this.p;
            bVar2.c = 7;
            bVar2.a = F();
        } else if (b2 == 60) {
            byte[] bArr4 = this.v;
            int i6 = this.l;
            this.l = i6 + 1;
            if (bArr4[i6] == 60) {
                this.p.c = 11;
            } else {
                this.l = i6;
                b bVar3 = this.p;
                bVar3.c = 7;
                bVar3.a = C();
            }
        } else if (b2 == 91) {
            this.p.c = 9;
        } else if (b2 == 93) {
            this.p.c = 8;
        } else if (b2 == 123) {
            this.p.c = 5;
        } else if (b2 != 125) {
            switch (b2) {
                case 45:
                case 46:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                    this.l--;
                    b bVar4 = this.p;
                    bVar4.c = 3;
                    bVar4.b = E();
                    break;
                case 47:
                    b bVar5 = this.p;
                    bVar5.c = 1;
                    bVar5.a = D();
                    break;
                default:
                    if (b2 == 62) {
                        byte[] bArr5 = this.v;
                        int i7 = this.l;
                        this.l = i7 + 1;
                        if (bArr5[i7] == 62) {
                            this.p.c = 10;
                        } else if ((b2 >= 97 && b2 <= 122) || ((b2 >= 65 && b2 <= 90) || b2 == 39 || b2 == 34)) {
                            this.l--;
                            b bVar6 = this.p;
                            bVar6.c = 2;
                            bVar6.a = D();
                        } else {
                            System.out.println("Encountered character: " + ((int) b2) + " (" + ((char) b2) + ")");
                            this.p.c = 0;
                        }
                    } else if (b2 >= 97) {
                        System.out.println("Encountered character: " + ((int) b2) + " (" + ((char) b2) + ")");
                        this.p.c = 0;
                    } else {
                        System.out.println("Encountered character: " + ((int) b2) + " (" + ((char) b2) + ")");
                        this.p.c = 0;
                    }
                    break;
            }
        } else {
            this.p.c = 4;
        }
        return this.p;
    }

    public final AbstractC3297lF r(BF bf) {
        return bf == null ? this.i.a : AbstractC3297lF.b(bf, this.w);
    }

    public final void s() {
        HashMap map = new HashMap();
        while (true) {
            b bVarQ = q();
            String str = "ImageMask";
            if (bVarQ.c == 2 && bVarQ.a.equals("ID")) {
                break;
            }
            String str2 = bVarQ.a;
            if (str2.equals("BPC")) {
                str = "BitsPerComponent";
            } else if (str2.equals("CS")) {
                str = "ColorSpace";
            } else if (str2.equals("D")) {
                str = "Decode";
            } else if (str2.equals("DP")) {
                str = "DecodeParms";
            } else if (str2.equals("F")) {
                str = "Filter";
            } else if (str2.equals("H")) {
                str = "Height";
            } else if (!str2.equals("IM")) {
                if (str2.equals("W")) {
                    str = HttpHeaders.WIDTH;
                } else {
                    str = str2.equals("I") ? "Interpolate" : str2;
                }
            }
            map.put(str, new BF(t()));
        }
        byte[] bArr = this.v;
        int i = this.l;
        if (bArr[i] == 13) {
            this.l = i + 1;
        }
        int i2 = this.l;
        byte b2 = bArr[i2];
        if (b2 == 10 || b2 == 32) {
            this.l = i2 + 1;
        }
        BF bf = (BF) map.get("ImageMask");
        if (bf != null && bf.f()) {
            Double[] dArr = {new Double(0.0d), new Double(1.0d)};
            BF bf2 = (BF) map.get("Decode");
            if (bf2 != null) {
                dArr[0] = new Double(bf2.e(0).l());
                dArr[1] = new Double(bf2.e(1).l());
            }
            map.put("Decode", new BF(dArr));
        }
        BF bf3 = new BF(null, 6, map);
        int i3 = this.l;
        while (true) {
            if (C3706qF.k(this.v[this.l])) {
                byte[] bArr2 = this.v;
                int i4 = this.l;
                if (bArr2[i4 + 1] == 69 && bArr2[i4 + 2] == 73) {
                    byte[] bArr3 = new byte[i4 - i3];
                    System.arraycopy(bArr2, i3, bArr3, 0, i4 - i3);
                    bf3.x(T8.K(bArr3));
                    this.l += 3;
                    l(bf3);
                    return;
                }
            }
            this.l++;
        }
    }

    public final Object t() throws EF {
        Object objT;
        b bVarQ = q();
        int i = bVarQ.c;
        if (i != 1) {
            if (i == 2) {
                return bVarQ;
            }
            if (i == 3) {
                return new Double(this.p.b);
            }
            if (i != 7) {
                if (i == 9) {
                    ArrayList arrayList = new ArrayList();
                    while (true) {
                        Object objT2 = t();
                        if (objT2 == null) {
                            break;
                        }
                        arrayList.add(objT2);
                    }
                    if (this.p.c == 8) {
                        return arrayList.toArray();
                    }
                    throw new EF("Expected ']'");
                }
                if (i != 11) {
                    return null;
                }
                HashMap map = new HashMap();
                loop0: while (true) {
                    String str = null;
                    while (true) {
                        objT = t();
                        if (objT == null) {
                            break loop0;
                        }
                        if (str == null) {
                            str = (String) objT;
                        }
                    }
                    map.put(str, new BF(objT));
                }
                if (this.p.c == 10) {
                    return map;
                }
                throw new EF("Inline dict should have ended with '>>'");
            }
        }
        return this.p.a;
    }

    public final Object[] u() throws EF {
        Object objPop = this.g.pop();
        if (objPop instanceof Object[]) {
            return (Object[]) objPop;
        }
        throw new EF("Expected an [array] here: " + objPop.toString());
    }

    public final float v() throws EF {
        Object objPop = this.g.pop();
        if (objPop instanceof Double) {
            return ((Double) objPop).floatValue();
        }
        throw new EF("Expected a number here.");
    }

    public final float[] w(int i) {
        float[] fArr = new float[i];
        for (int i2 = i - 1; i2 >= 0; i2--) {
            fArr[i2] = v();
        }
        return fArr;
    }

    public final float[] x() throws EF {
        Object objPop = this.g.pop();
        if (!(objPop instanceof Object[])) {
            throw new EF("Expected an [array] here.");
        }
        Object[] objArr = (Object[]) objPop;
        int length = objArr.length;
        float[] fArr = new float[length];
        for (int i = 0; i < length; i++) {
            Object obj = objArr[i];
            if (!(obj instanceof Double)) {
                throw new EF("This array doesn't consist only of floats.");
            }
            fArr[i] = ((Double) obj).floatValue();
        }
        return fArr;
    }

    public final int y() throws EF {
        Object objPop = this.g.pop();
        if (objPop instanceof Double) {
            return ((Double) objPop).intValue();
        }
        throw new EF("Expected a number here.");
    }

    public final String z() throws EF {
        Object objPop = this.g.pop();
        if (objPop instanceof String) {
            return (String) objPop;
        }
        throw new EF("Expected string here: " + objPop.toString());
    }

    public final void m(BF bf) {
    }
}
