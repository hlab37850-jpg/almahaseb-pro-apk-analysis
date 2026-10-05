package defpackage;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.tool.xml.html.HTML;
import org.apache.poi.ddf.EscherProperties;

/* JADX INFO: loaded from: classes3.dex */
public class ZG extends FV {
    public int c;
    public int d;
    public short e;
    public short f;
    public short g;
    public int h;
    public int i;
    public int j;
    public int k;
    public a l;

    public class c extends b {
        public short[] d;
        public String[] e;

        public c() {
            super();
        }

        @Override // ZG.b, ZG.a
        public short a(String str) {
            short sA;
            int i = 0;
            while (true) {
                String[] strArr = this.e;
                if (i >= strArr.length) {
                    sA = -1;
                    break;
                }
                if (str.equals(strArr[i])) {
                    sA = (short) (this.b.length + i);
                    break;
                }
                i++;
            }
            if (sA == -1) {
                sA = super.a(str);
            }
            short s = sA;
            int i2 = 0;
            while (true) {
                short[] sArr = this.d;
                if (i2 >= sArr.length) {
                    return (short) 0;
                }
                if (sArr[i2] == s) {
                    return (short) i2;
                }
                i2++;
            }
        }

        @Override // ZG.b, ZG.a
        public T8 b() {
            T8 t8B = T8.b(c());
            t8B.E((short) this.d.length);
            int i = 0;
            int i2 = 0;
            while (true) {
                short[] sArr = this.d;
                if (i2 >= sArr.length) {
                    break;
                }
                t8B.E(sArr[i2]);
                i2++;
            }
            while (true) {
                String[] strArr = this.e;
                if (i >= strArr.length) {
                    t8B.f();
                    return t8B;
                }
                t8B.x((byte) strArr[i].length());
                t8B.z(this.e[i].getBytes());
                i++;
            }
        }

        @Override // ZG.b, ZG.a
        public int c() {
            int length = (this.d.length * 2) + 2;
            int i = 0;
            while (true) {
                String[] strArr = this.e;
                if (i >= strArr.length) {
                    return length;
                }
                length += strArr[i].length() + 1;
                i++;
            }
        }

        @Override // ZG.b, ZG.a
        public void d(T8 t8) {
            int iP = t8.p();
            this.d = new short[iP];
            short s = EscherProperties.BLIP__CROPFROMBOTTOM;
            for (int i = 0; i < iP; i++) {
                this.d[i] = t8.p();
                short s2 = this.d[i];
                if (s2 > s) {
                    s = s2;
                }
            }
            int i2 = s - 257;
            this.e = new String[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                byte[] bArr = new byte[t8.h()];
                t8.j(bArr);
                this.e[i3] = new String(bArr);
            }
        }
    }

    public ZG() {
        super(1886352244);
        this.l = new a();
    }

    @Override // defpackage.FV
    public T8 b() {
        T8 t8B = T8.b(k());
        t8B.B(g());
        t8B.B(j());
        t8B.E(p());
        t8B.E(q());
        t8B.E(i());
        t8B.E((short) 0);
        t8B.B(o());
        t8B.B(m());
        t8B.B(n());
        t8B.B(l());
        t8B.y(this.l.b());
        t8B.f();
        return t8B;
    }

    @Override // defpackage.FV
    public void d(T8 t8) {
        r(t8.n());
        t(t8.n());
        y(t8.p());
        z(t8.p());
        s(t8.p());
        t8.p();
        x(t8.n());
        v(t8.n());
        w(t8.n());
        u(t8.n());
        int i = this.c;
        if (i == 65536) {
            this.l = new b();
        } else if (i == 131072) {
            this.l = new c();
        } else if (i != 196608) {
            this.l = new a();
            System.out.println("Unknown post map type: " + Integer.toHexString(this.c));
        } else {
            this.l = new a();
        }
        this.l.d(t8);
    }

    public int g() {
        return this.c;
    }

    public short h(String str) {
        return this.l.a(str);
    }

    public short i() {
        return this.g;
    }

    public int j() {
        return this.d;
    }

    public int k() {
        a aVar = this.l;
        if (aVar != null) {
            return 32 + aVar.c();
        }
        return 32;
    }

    public int l() {
        return this.k;
    }

    public int m() {
        return this.i;
    }

    public int n() {
        return this.j;
    }

    public int o() {
        return this.h;
    }

    public short p() {
        return this.e;
    }

    public short q() {
        return this.f;
    }

    public void r(int i) {
        this.c = i;
    }

    public void s(short s) {
        this.g = s;
    }

    public void t(int i) {
        this.d = i;
    }

    public void u(int i) {
        this.k = i;
    }

    public void v(int i) {
        this.i = i;
    }

    public void w(int i) {
        this.j = i;
    }

    public void x(int i) {
        this.h = i;
    }

    public void y(short s) {
        this.e = s;
    }

    public void z(short s) {
        this.f = s;
    }

    public class a {
        public a() {
        }

        public short a(String str) {
            return (short) 0;
        }

        public T8 b() {
            return T8.b(0);
        }

        public int c() {
            return 0;
        }

        public void d(T8 t8) {
        }
    }

    public class b extends a {
        public final String[] b;

        public b() {
            super();
            this.b = new String[]{BaseFont.notdef, ".null", "nonmarkingreturn", "space", "exclam", "quotedbl", "numbersign", "dollar", "percent", "ampersand", "quotesingle", "parenleft", "parenright", "asterisk", "plus", "comma", "hyphen", TypedValues.CycleType.S_WAVE_PERIOD, "slash", "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "colon", "semicolon", "less", "equal", "greater", "question", "at", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "bracketleft", "ackslash", "bracketright", "asciicircum", "underscore", "grave", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", HTML.Tag.Q, "r", "s", "t", "u", "v", "w", "x", "y", "z", "braceleft", "bar", "braceright", "asciitilde", "Adieresis", "Aring", "Ccedilla", "Eacute", "Ntilde", "Odieresis", "Udieresis", "aacute", "agrave", "acircumflex", "adieresis", "atilde", "aring", "ccedilla", "eacute", "egrave", "ecircumflex", "edieresis", "iacute", "igrave", "icircumflex", "idieresis", "ntilde", "oacute", "ograve", "ocircumflex", "odieresis", "otilde", "uacute", "ugrave", "ucircumflex", "udieresis", "dagger", "degree", "cent", "sterling", HTML.Tag.SECTION, "bullet", "paragraph", "germandbls", "registered", "copyright", "trademark", "acute", "dieresis", "notequal", "AE", "Oslash", "infinity", "plusminus", "lessequal", "greaterequal", "yen", "mu", "partialdiff", "summation", "product", "pi", "integral", "ordfeminine", "ordmasculine", "Omega", "ae", "oslash", "questiondown", "exclamdown", "logicalnot", "radical", "florin", "approxequal", "Delta", "guillemotleft", "guillemotright", "ellipsis", "nonbreakingspace", "Agrave", "Atilde", "Otilde", "OE", "oe", "endash", "emdash", "quotedblleft", "quotedblright", "quoteleft", "quoteright", "divide", "lozenge", "ydieresis", "Ydieresis", "fraction", "currency", "guilsinglleft", "guilsinglright", "fi", "fl", "daggerdbl", "periodcentered", "quotesinglbase", "quotedblbase", "perthousand", "Acircumflex", "Ecircumflex", "Aacute", "Edieresis", "Egrave", "Iacute", "Icircumflex", "Idieresis", "Igrave", "Oacute", "Ocircumflex", "apple", "Ograve", "Uacute", "Ucircumflex", "Ugrave", "dotlessi", "circumflex", "tilde", "macron", "breve", "dotaccent", "ring", "cedilla", "hungarumlaut", "ogonek", "caron", "Lslash", "lslash", "Scaron", "scaron", "Zcaron", "zcaron", "brokenbar", "Eth", "eth", "Yacute", "yacute", "Thorn", "thorn", "minus", "multiply", "onesuperior", "twosuperior", "threesuperior", "onehalf", "onequarter", "threequarters", "franc", "Gbreve", "gbreve", "Idotaccent", "Scedilla", "scedilla", "Cacute", "cacute", "Ccaron", "ccaron", "dcroat"};
        }

        @Override // ZG.a
        public short a(String str) {
            int i = 0;
            while (true) {
                String[] strArr = this.b;
                if (i >= strArr.length) {
                    return (short) 0;
                }
                if (str.equals(strArr[i])) {
                    return (short) i;
                }
                i++;
            }
        }

        @Override // ZG.a
        public T8 b() {
            return T8.b(0);
        }

        @Override // ZG.a
        public int c() {
            return 0;
        }

        @Override // ZG.a
        public void d(T8 t8) {
        }
    }
}
