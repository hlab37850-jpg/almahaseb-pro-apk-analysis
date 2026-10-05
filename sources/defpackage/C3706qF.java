package defpackage;

import android.graphics.RectF;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/* JADX INFO: renamed from: qF, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3706qF {
    public String a;
    public int b;
    public int c;
    public T8 d;
    public QF[] e;
    public BF f;
    public BF g;
    public BF h;
    public C3126j9 i;
    public boolean j;
    public boolean k;
    public InterfaceC3461nF l;

    public C3706qF(T8 t8) {
        this(t8, null);
    }

    public static boolean i(int i) {
        return i == 37 || i == 47 || i == 60 || i == 62 || i == 91 || i == 93 || i == 123 || i == 125 || i == 40 || i == 41;
    }

    public static boolean j(int i) {
        return (k(i) || i(i)) ? false : true;
    }

    public static boolean k(int i) {
        return i == 0 || i == 32 || i == 9 || i == 10 || i == 12 || i == 13;
    }

    public final BF A(int i, int i2, InterfaceC3461nF interfaceC3461nF) {
        return B(i, i2, false, interfaceC3461nF);
    }

    public final BF B(int i, int i2, boolean z, InterfaceC3461nF interfaceC3461nF) throws EF {
        byte bH;
        BF bfQ = null;
        while (bfQ == null) {
            do {
                bH = this.d.h();
            } while (k(bH));
            if (bH == 60) {
                if (this.d.h() == 60) {
                    bfQ = q(i, i2, interfaceC3461nF);
                } else {
                    T8 t8 = this.d;
                    t8.w(t8.v() - 1);
                    bfQ = t(i, i2, interfaceC3461nF);
                }
            } else if (bH == 40) {
                bfQ = w(i, i2, interfaceC3461nF);
            } else if (bH == 91) {
                bfQ = p(i, i2, interfaceC3461nF);
            } else if (bH == 47) {
                bfQ = x();
            } else if (bH == 37) {
                v();
            } else if ((bH >= 48 && bH <= 57) || bH == 45 || bH == 43 || bH == 46) {
                bfQ = z((char) bH);
                if (!z) {
                    int iV = this.d.v();
                    BF bfB = B(-1, -1, true, interfaceC3461nF);
                    if (bfB == null || bfB.t() != 2) {
                        this.d.w(iV);
                    } else {
                        BF bfB2 = B(-1, -1, true, interfaceC3461nF);
                        if (bfB2 != null && bfB2.t() == 9 && bfB2.s().equals("R")) {
                            bfQ = new BF(this, new QF(bfQ.n(), bfB.n()));
                        } else if (bfB2 != null && bfB2.t() == 9 && bfB2.s().equals("obj")) {
                            bfQ = C(bfQ.n(), bfB.n(), interfaceC3461nF);
                        } else {
                            this.d.w(iV);
                        }
                    }
                }
            } else {
                if ((bH < 97 || bH > 122) && (bH < 65 || bH > 90)) {
                    T8 t9 = this.d;
                    t9.w(t9.v() - 1);
                    break;
                }
                bfQ = u((char) bH);
            }
        }
        return bfQ;
    }

    public final BF C(int i, int i2, InterfaceC3461nF interfaceC3461nF) throws EF {
        long jV = this.d.v();
        BF bfA = A(i, i2, interfaceC3461nF);
        BF bfA2 = A(i, i2, interfaceC3461nF);
        if (bfA2.t() != 9) {
            throw new EF("Expected 'stream' or 'endobj'");
        }
        if (bfA.t() == 6 && bfA2.s().equals("stream")) {
            v();
            T8 t8D = D(bfA);
            if (t8D == null) {
                t8D = T8.b(0);
            }
            bfA.x(t8D);
            bfA2 = A(i, i2, interfaceC3461nF);
        }
        String strS = bfA2.s();
        if (strS == null || !strS.equals("endobj")) {
            System.out.println("WARNING: object at " + jV + " didn't end with 'endobj'");
        }
        bfA.w(i, i2);
        return bfA;
    }

    public final T8 D(BF bf) throws EF {
        BF bfJ = bf.j("Length");
        int iN = bfJ != null ? bfJ.n() : -1;
        if (iN < 0) {
            throw new EF("Unknown length for stream");
        }
        int iV = this.d.v();
        T8 t8I = this.d.I();
        t8I.t(iN);
        T8 t8 = this.d;
        t8.w(t8.v() + iN);
        int iV2 = this.d.v();
        if (l("endstream")) {
            return t8I;
        }
        System.out.println("read " + iN + " chars from " + iV + " to " + iV2);
        throw new EF("Stream ended inappropriately");
    }

    public final void E(GF gf) throws IOException {
        this.e = new QF[50];
        int iV = this.d.v();
        InterfaceC3461nF interfaceC3461nFB = null;
        while (l("xref")) {
            while (true) {
                BF bfA = A(-1, -1, C2066ds.d());
                if (bfA.t() != 9 || !bfA.s().equals("trailer")) {
                    if (bfA.t() != 2) {
                        throw new EF("Expected number for first xref entry");
                    }
                    int iN = bfA.n();
                    BF bfA2 = A(-1, -1, C2066ds.d());
                    if (bfA2.t() != 2) {
                        throw new EF("Expected number for length of xref table");
                    }
                    int iN2 = bfA2.n();
                    v();
                    int i = iN2 + iN;
                    QF[] qfArr = this.e;
                    if (i >= qfArr.length) {
                        QF[] qfArr2 = new QF[i];
                        System.arraycopy(qfArr, 0, qfArr2, 0, qfArr.length);
                        this.e = qfArr2;
                    }
                    while (iN < i) {
                        byte[] bArr = new byte[20];
                        this.d.j(bArr);
                        QF[] qfArr3 = this.e;
                        if (qfArr3[iN] == null) {
                            if (bArr[17] == 110) {
                                qfArr3[iN] = new QF(bArr);
                            } else {
                                qfArr3[iN] = new QF(null);
                            }
                        }
                        iN++;
                    }
                }
            }
            BF bfA3 = A(-1, -1, C2066ds.d());
            if (bfA3.t() != 6) {
                throw new IOException("Expected dictionary after \"trailer\"");
            }
            if (this.f == null) {
                BF bfJ = bfA3.j("Root");
                this.f = bfJ;
                if (bfJ != null) {
                    bfJ.w(-1, -1);
                }
            }
            if (this.g == null) {
                BF bfJ2 = bfA3.j("Encrypt");
                this.g = bfJ2;
                if (bfJ2 != null) {
                    bfJ2.w(-1, -1);
                }
                interfaceC3461nFB = AbstractC3543oF.b(this.g, bfA3.j("ID"), gf);
            }
            if (this.h == null) {
                BF bfJ3 = bfA3.j("Info");
                this.h = bfJ3;
                if (bfJ3 != null) {
                    if (!bfJ3.u()) {
                        throw new EF("Info in trailer must be an indirect reference");
                    }
                    this.h.w(-1, -1);
                }
            }
            BF bfJ4 = bfA3.j("XRefStm");
            if (bfJ4 != null) {
                System.out.println("XRefStm:" + bfJ4.n());
                int iV2 = this.d.v();
                this.d.w(bfJ4.n());
                F(gf);
                this.d.w(iV2);
            }
            BF bfJ5 = bfA3.j("Prev");
            if (bfJ5 == null) {
                if (this.f == null) {
                    throw new EF("No /Root key found in trailer dictionary");
                }
                BF bf = this.g;
                if (bf != null) {
                    BF bfJ6 = bf.j("P");
                    if (bfJ6 != null && !interfaceC3461nFB.b()) {
                        int iN3 = bfJ6.n();
                        this.j = (iN3 & 4) != 0;
                        this.k = (iN3 & 16) != 0;
                    }
                    this.l = interfaceC3461nFB;
                }
                this.f.c();
                return;
            }
            this.d.w(bfJ5.n());
            if (this.f.j("Version") != null) {
                o(this.f.j("Version").s());
            }
        }
        this.d.w(iV);
        F(gf);
    }

    public final void F(GF gf) throws EF {
        int[] iArr;
        C3706qF c3706qF = this;
        InterfaceC3461nF interfaceC3461nFB = null;
        while (true) {
            int i = -1;
            BF bfA = c3706qF.A(-1, -1, C2066ds.d());
            BF[] bfArrD = ((BF) bfA.k().get("W")).d();
            boolean z = false;
            z = false;
            int iN = bfArrD[0].n();
            int iN2 = bfArrD[1].n();
            int iN3 = bfArrD[2].n();
            int iN4 = ((BF) bfA.k().get("Size")).n();
            byte[] bArrQ = bfA.q();
            int length = bArrQ.length / ((iN + iN2) + iN3);
            BF bf = (BF) bfA.k().get("Index");
            if (bf == null) {
                iArr = new int[]{0, iN4};
            } else {
                BF[] bfArrD2 = bf.d();
                int[] iArr2 = new int[bfArrD2.length];
                int i2 = 0;
                while (i2 < bfArrD2.length) {
                    iArr2[i2] = bfArrD2[i2].n();
                    i2++;
                    i = -1;
                    z = false;
                    c3706qF = this;
                }
                iArr = iArr2;
            }
            int length2 = iArr.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length2) {
                int i5 = iArr[i3];
                int i6 = i3 + 2;
                int i7 = i5 + iArr[i3 + 1];
                QF[] qfArr = c3706qF.e;
                if (i7 >= qfArr.length) {
                    QF[] qfArr2 = new QF[i7];
                    System.arraycopy(qfArr, z ? 1 : 0, qfArr2, z ? 1 : 0, qfArr.length);
                    c3706qF.e = qfArr2;
                }
                int i8 = i5;
                while (i8 < i7) {
                    int iY = c3706qF.y(bArrQ, i4, iN);
                    int i9 = i4 + iN;
                    int iY2 = c3706qF.y(bArrQ, i9, iN2);
                    int i10 = i9 + iN2;
                    int iY3 = c3706qF.y(bArrQ, i10, iN3);
                    i4 = i10 + iN3;
                    InterfaceC3461nF interfaceC3461nF = interfaceC3461nFB;
                    QF[] qfArr3 = c3706qF.e;
                    if (qfArr3[i8] == null) {
                        if (iY == 0) {
                            qfArr3[i8] = new QF(null);
                        } else if (iY == 1) {
                            qfArr3[i8] = new QF(iY2, iY3);
                        } else {
                            qfArr3[i8] = new QF(iY2, iY3, true);
                        }
                    }
                    i8++;
                    z = false;
                    c3706qF = this;
                    interfaceC3461nFB = interfaceC3461nF;
                }
                i3 = i6;
                i = -1;
            }
            HashMap mapK = bfA.k();
            if (c3706qF.f == null) {
                BF bf2 = (BF) mapK.get("Root");
                c3706qF.f = bf2;
                if (bf2 != null) {
                    bf2.w(i, i);
                }
            }
            if (c3706qF.g == null) {
                BF bf3 = (BF) mapK.get("Encrypt");
                c3706qF.g = bf3;
                if (bf3 != null) {
                    bf3.w(i, i);
                }
                interfaceC3461nFB = AbstractC3543oF.b(c3706qF.g, (BF) mapK.get("ID"), gf);
            }
            if (c3706qF.h == null) {
                BF bf4 = (BF) mapK.get("Info");
                c3706qF.h = bf4;
                if (bf4 != null) {
                    if (!bf4.u()) {
                        throw new EF("Info in trailer must be an indirect reference");
                    }
                    c3706qF.h.w(i, i);
                }
            }
            BF bf5 = (BF) mapK.get("Prev");
            if (bf5 == null) {
                if (c3706qF.f == null) {
                    throw new EF("No /Root key found in trailer dictionary");
                }
                BF bf6 = c3706qF.g;
                if (bf6 != null) {
                    BF bfJ = bf6.j("P");
                    if (bfJ != null && !interfaceC3461nFB.b()) {
                        int iN5 = bfJ.n();
                        c3706qF.j = (iN5 & 4) != 0;
                        if ((iN5 & 16) != 0) {
                            z = true;
                        }
                        c3706qF.k = z;
                    }
                    c3706qF.l = interfaceC3461nFB;
                }
                c3706qF.f.c();
                return;
            }
            c3706qF.d.w(bf5.n());
            if (c3706qF.f.j("Version") != null) {
                c3706qF.o(c3706qF.f.j("Version").s());
            }
        }
    }

    public final CF a(int i, BF bf) {
        BF bfF = f(bf, "MediaBox");
        RectF rectFN = bfF != null ? n(bfF) : null;
        BF bfF2 = f(bf, "CropBox");
        RectF rectFN2 = bfF2 != null ? n(bfF2) : null;
        BF bfF3 = f(bf, "Rotate");
        int iN = bfF3 != null ? bfF3.n() : 0;
        if (rectFN2 != null) {
            rectFN = rectFN2;
        }
        return new CF(i, rectFN, iN, this.i);
    }

    public synchronized BF b(QF qf, InterfaceC3461nF interfaceC3461nF) {
        QF qf2;
        BF bfA;
        int iD = qf.d();
        QF[] qfArr = this.e;
        if (iD < qfArr.length && (qf2 = qfArr[iD]) != null) {
            BF bfF = qf2.f();
            if (bfF != null) {
                return bfF;
            }
            int iV = this.d.v();
            if (this.e[iD].a()) {
                int iD2 = this.e[iD].d();
                int iE = this.e[iD].e();
                if (iE < 0) {
                    return BF.i;
                }
                BF bfB = b(new QF(iD2, 0), interfaceC3461nF);
                int iN = ((BF) bfB.k().get("First")).n();
                ((BF) bfB.k().get("Length")).n();
                if (iE >= ((BF) bfB.k().get("N")).n()) {
                    return BF.i;
                }
                T8 t8R = bfB.r();
                T8 t8 = this.d;
                this.d = t8R;
                for (int i = 0; i < iE; i++) {
                    B(-1, -1, true, C2066ds.d());
                    B(-1, -1, true, C2066ds.d());
                }
                BF bfB2 = B(-1, -1, true, C2066ds.d());
                BF bfB3 = B(-1, -1, true, C2066ds.d());
                int iN2 = bfB2.n();
                int iN3 = bfB3.n();
                if (iN2 != iD) {
                    return BF.i;
                }
                this.d.w(iN + iN3);
                bfA = A(iN2, 0, C2066ds.d());
                this.d = t8;
            } else {
                int iB = this.e[iD].b();
                if (iB < 0) {
                    return BF.i;
                }
                this.d.w(iB);
                bfA = A(qf.d(), qf.c(), interfaceC3461nF);
            }
            if (bfA == null) {
                bfA = BF.i;
            }
            this.e[iD].g(bfA);
            this.d.w(iV);
            return bfA;
        }
        return BF.i;
    }

    public final BF c(BF bf, int i, int i2, Map map) {
        BF bfJ = bf.j("Resources");
        if (bfJ != null) {
            map.putAll(bfJ.k());
        }
        BF bfJ2 = bf.j("Type");
        if (bfJ2 != null && bfJ2.s().equals("Page")) {
            return bf;
        }
        BF bfJ3 = bf.j("Kids");
        if (bfJ3 == null) {
            return null;
        }
        BF[] bfArrD = bfJ3.d();
        int i3 = 0;
        while (i3 < bfArrD.length) {
            BF bfJ4 = bfArrD[i3].j("Count");
            int iN = (bfJ4 != null ? bfJ4.n() : 1) + i;
            if (iN >= i2) {
                return c(bfArrD[i3], i, i2, map);
            }
            i3++;
            i = iN;
        }
        return null;
    }

    public final byte[] d(BF bf) throws IOException {
        BF bfJ = bf.j("Contents");
        if (bfJ == null) {
            throw new IOException("No page contents!");
        }
        BF[] bfArrD = bfJ.d();
        if (bfArrD.length == 1) {
            return bfArrD[0].q();
        }
        int length = 0;
        for (int i = 0; i < bfArrD.length; i++) {
            byte[] bArrQ = bfArrD[i].q();
            if (bArrQ == null) {
                throw new EF("No stream on content " + i + ": " + bfArrD[i]);
            }
            length += bArrQ.length;
        }
        byte[] bArr = new byte[length];
        int length2 = 0;
        for (BF bf2 : bfArrD) {
            byte[] bArrQ2 = bf2.q();
            System.arraycopy(bArrQ2, 0, bArr, length2, bArrQ2.length);
            length2 += bArrQ2.length;
        }
        return bArr;
    }

    public InterfaceC3461nF e() {
        return this.l;
    }

    public final BF f(BF bf, String str) {
        BF bfJ = bf.j(str);
        if (bfJ != null) {
            return bfJ;
        }
        BF bfJ2 = bf.j("Parent");
        if (bfJ2 != null) {
            return f(bfJ2, str);
        }
        return null;
    }

    public int g() {
        try {
            return this.f.j("Pages").j("Count").n();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public CF h(int i, boolean z) {
        Integer num = new Integer(i);
        CF cfC = this.i.c(num);
        FF ffD = this.i.d(num);
        if (cfC == null) {
            try {
                HashMap map = new HashMap();
                BF bfC = c(this.f.j("Pages"), 0, i, map);
                if (bfC == null) {
                    return null;
                }
                CF cfA = a(i, bfC);
                FF ff = new FF(cfA, d(bfC), map);
                this.i.a(num, cfA, ff);
                cfC = cfA;
                ffD = ff;
            } catch (IOException e) {
                System.out.println("GetPage inner loop:");
                e.printStackTrace();
                return null;
            }
        }
        if (ffD != null && !ffD.f()) {
            ffD.d(z);
        }
        return cfC;
    }

    public final boolean l(String str) {
        byte bH;
        do {
            bH = this.d.h();
        } while (k(bH));
        for (int i = 0; i < str.length(); i++) {
            if (i > 0) {
                bH = this.d.h();
            }
            if (bH != str.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public final void m(GF gf) throws IOException {
        this.d.H();
        String strV = v();
        if (strV.startsWith("%PDF-")) {
            o(strV.substring(5));
        }
        this.d.H();
        byte[] bArr = new byte[32];
        int iF = this.d.F() - 32;
        int i = 0;
        int iIndexOf = 0;
        while (true) {
            if (iF >= 0) {
                this.d.w(iF);
                this.d.j(bArr);
                iIndexOf = new String(bArr).indexOf("startxref");
                if (iIndexOf > 0) {
                    int i2 = iF + iIndexOf;
                    if (i2 + 32 <= this.d.s()) {
                        iF = i2;
                        break;
                    }
                } else {
                    iF -= 22;
                }
            }
            i = iIndexOf;
            break;
        }
        if (iF < 0) {
            throw new IOException("This may not be a PDF File");
        }
        this.d.w(iF);
        this.d.j(bArr);
        String str = new String(bArr);
        int i3 = i + 10;
        if (str.charAt(i3) < ' ') {
            i3 = i + 11;
        }
        while (str.charAt(i3) == ' ') {
            i3++;
        }
        int i4 = i3;
        while (i4 < str.length() && str.charAt(i4) >= '0' && str.charAt(i4) <= '9') {
            i4++;
        }
        this.d.w(Integer.parseInt(str.substring(i3, i4)));
        try {
            E(gf);
        } catch (MW e) {
            throw new EF(e.getMessage(), e);
        }
    }

    public RectF n(BF bf) throws EF {
        if (bf.t() != 5) {
            throw new EF("Rectangle definition not an array");
        }
        BF[] bfArrD = bf.d();
        if (bfArrD.length == 4) {
            return new RectF(bfArrD[0].m(), bfArrD[1].m(), bfArrD[2].m(), bfArrD[3].m());
        }
        throw new EF("Rectangle definition didn't have 4 elements");
    }

    public final void o(String str) {
        try {
            StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
            this.b = Integer.parseInt(stringTokenizer.nextToken());
            this.c = Integer.parseInt(stringTokenizer.nextToken());
            this.a = str;
        } catch (Exception unused) {
        }
    }

    public final BF p(int i, int i2, InterfaceC3461nF interfaceC3461nF) throws EF {
        ArrayList arrayList = new ArrayList();
        while (true) {
            BF bfA = A(i, i2, interfaceC3461nF);
            if (bfA == null) {
                break;
            }
            arrayList.add(bfA);
        }
        if (this.d.h() != 93) {
            throw new EF("Array should end with ']'");
        }
        int size = arrayList.size();
        BF[] bfArr = new BF[size];
        for (int i3 = 0; i3 < size; i3++) {
            bfArr[i3] = (BF) arrayList.get(i3);
        }
        return new BF(this, 5, bfArr);
    }

    public final BF q(int i, int i2, InterfaceC3461nF interfaceC3461nF) throws EF {
        HashMap map = new HashMap();
        while (true) {
            BF bfA = A(i, i2, interfaceC3461nF);
            if (bfA == null) {
                if (l(">>")) {
                    return new BF(this, 6, map);
                }
                throw new EF("End of dictionary wasn't '>>'");
            }
            if (bfA.t() != 4) {
                throw new EF("First item in dictionary must be a /Name.  (Was " + bfA + ")");
            }
            BF bfA2 = A(i, i2, interfaceC3461nF);
            if (bfA2 != null) {
                map.put(bfA.s(), bfA2);
            }
        }
    }

    public final int r() {
        byte bH;
        do {
            bH = this.d.h();
        } while (k(bH));
        switch (bH) {
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
                return bH - 48;
            default:
                switch (bH) {
                    case 65:
                    case 66:
                    case 67:
                    case 68:
                    case 69:
                    case 70:
                        return bH - 55;
                    default:
                        switch (bH) {
                            case 97:
                            case 98:
                            case 99:
                            case 100:
                            case 101:
                            case 102:
                                return bH - 87;
                            default:
                                return -1;
                        }
                }
        }
    }

    public final int s() {
        int iR = r();
        if (iR < 0) {
            T8 t8 = this.d;
            t8.w(t8.v() - 1);
            return -1;
        }
        int iR2 = r();
        if (iR2 >= 0) {
            return (iR << 4) + iR2;
        }
        T8 t9 = this.d;
        t9.w(t9.v() - 1);
        return iR << 4;
    }

    public final BF t(int i, int i2, InterfaceC3461nF interfaceC3461nF) throws EF {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            int iS = s();
            if (iS < 0) {
                break;
            }
            stringBuffer.append((char) iS);
        }
        if (this.d.h() == 62) {
            return new BF(this, 3, interfaceC3461nF.c(i, i2, stringBuffer.toString()));
        }
        throw new EF("Bad character in Hex String");
    }

    public final BF u(char c) {
        StringBuffer stringBuffer = new StringBuffer(String.valueOf(c));
        while (true) {
            byte bH = this.d.h();
            if (!j(bH)) {
                T8 t8 = this.d;
                t8.w(t8.v() - 1);
                return new BF(this, 9, stringBuffer.toString());
            }
            stringBuffer.append((char) bH);
        }
    }

    public final String v() {
        StringBuffer stringBuffer = new StringBuffer();
        while (this.d.F() > 0) {
            char cH = (char) this.d.h();
            if (cH == '\r') {
                if (this.d.F() <= 0) {
                    break;
                }
                T8 t8 = this.d;
                if (((char) t8.i(t8.v())) != '\n') {
                    break;
                }
                this.d.h();
                break;
            }
            if (cH == '\n') {
                break;
            }
            stringBuffer.append(cH);
        }
        return stringBuffer.toString();
    }

    public final BF w(int i, int i2, InterfaceC3461nF interfaceC3461nF) {
        StringBuffer stringBuffer = new StringBuffer();
        int i3 = 1;
        while (i3 > 0) {
            int iH = this.d.h() & UnsignedBytes.MAX_VALUE;
            if (iH == 40) {
                i3++;
            } else if (iH == 41) {
                i3--;
                if (i3 == 0) {
                    break;
                }
            } else if (iH == 92) {
                iH = this.d.h() & UnsignedBytes.MAX_VALUE;
                if (iH >= 48 && iH < 56) {
                    int i4 = 0;
                    for (int i5 = 0; iH >= 48 && iH < 56 && i5 < 3; i5++) {
                        i4 = ((i4 * 8) + iH) - 48;
                        iH = this.d.h() & UnsignedBytes.MAX_VALUE;
                    }
                    T8 t8 = this.d;
                    t8.w(t8.v() - 1);
                    iH = i4;
                } else if (iH == 110) {
                    iH = 10;
                } else if (iH == 114) {
                    iH = 13;
                } else if (iH == 116) {
                    iH = 9;
                } else if (iH == 98) {
                    iH = 8;
                } else if (iH == 102) {
                    iH = 12;
                } else {
                    if (iH == 13) {
                        if ((this.d.h() & UnsignedBytes.MAX_VALUE) != 10) {
                            T8 t9 = this.d;
                            t9.w(t9.v() - 1);
                        }
                    } else if (iH == 10) {
                    }
                    iH = -1;
                }
            }
            if (iH >= 0) {
                stringBuffer.append((char) iH);
            }
        }
        return new BF(this, 3, interfaceC3461nF.c(i, i2, stringBuffer.toString()));
    }

    public final BF x() throws EF {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            int iH = this.d.h();
            if (!j(iH) || (iH < 33 && iH > 126)) {
                break;
            }
            if (iH == 35 && this.b != 1 && this.c != 1 && (iH = s()) < 0) {
                throw new EF("Bad #hex in /Name");
            }
            stringBuffer.append((char) iH);
        }
        T8 t8 = this.d;
        t8.w(t8.v() - 1);
        return new BF(this, 4, stringBuffer.toString());
    }

    public final int y(byte[] bArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 = (i3 << 8) + (bArr[i + i4] & UnsignedBytes.MAX_VALUE);
        }
        return i3;
    }

    public final BF z(char c) throws EF {
        int i = 0;
        boolean z = c == '-';
        byte b = 46;
        boolean z2 = c == '.';
        double d = z2 ? 0.1d : 1.0d;
        if (c >= '0' && c <= '9') {
            i = c - '0';
        }
        double d2 = i;
        while (true) {
            byte bH = this.d.h();
            if (bH == b) {
                if (z2) {
                    throw new EF("Can't have two '.' in a number");
                }
                d = 0.1d;
                z2 = true;
            } else {
                if (bH < 48 || bH > 57) {
                    T8 t8 = this.d;
                    t8.w(t8.v() - 1);
                    if (z) {
                        d2 = -d2;
                    }
                    return new BF(this, 2, new Double(d2));
                }
                int i2 = bH - 48;
                if (z2) {
                    d2 += ((double) i2) * d;
                    d *= 0.1d;
                } else {
                    d2 = (d2 * 10.0d) + ((double) i2);
                }
                z2 = z2;
                b = 46;
            }
        }
    }

    public C3706qF(T8 t8, GF gf) throws IOException {
        this.a = "1.1";
        this.b = 1;
        this.c = 1;
        this.f = null;
        this.g = null;
        this.h = null;
        this.j = true;
        this.k = true;
        this.l = C2066ds.d();
        this.d = t8;
        this.i = new C3126j9();
        m(gf);
    }
}
