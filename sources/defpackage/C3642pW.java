package defpackage;

import com.fasterxml.jackson.core.JsonParser;
import com.google.common.primitives.UnsignedBytes;
import com.itextpdf.text.pdf.PdfBoolean;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.ss.util.IEEEDouble;

/* JADX INFO: renamed from: pW, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3642pW extends AbstractC3626pG {
    public static final int[] W = AbstractC3484nb.i();
    public static final int[] X = AbstractC3484nb.g();
    public final X8 P;
    public int[] Q;
    public boolean R;
    public int S;
    public InputStream T;
    public byte[] U;
    public boolean V;

    /* JADX INFO: renamed from: pW$a */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC0431Du.values().length];
            a = iArr;
            try {
                iArr[EnumC0431Du.FIELD_NAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[EnumC0431Du.VALUE_STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[EnumC0431Du.VALUE_NUMBER_INT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[EnumC0431Du.VALUE_NUMBER_FLOAT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[EnumC0431Du.VALUE_TRUE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[EnumC0431Du.VALUE_FALSE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public C3642pW(C0918Sr c0918Sr, int i, InputStream inputStream, AbstractC2263gE abstractC2263gE, X8 x8, byte[] bArr, int i2, int i3, boolean z) {
        super(c0918Sr, i);
        this.Q = new int[16];
        this.R = false;
        this.T = inputStream;
        this.P = x8;
        this.U = bArr;
        this.e = i2;
        this.f = i3;
        this.V = z;
    }

    private EnumC0431Du F0() {
        this.u = false;
        EnumC0431Du enumC0431Du = this.p;
        this.p = null;
        if (enumC0431Du == EnumC0431Du.START_ARRAY) {
            this.n = this.n.g(this.k, this.l);
        } else if (enumC0431Du == EnumC0431Du.START_OBJECT) {
            this.n = this.n.h(this.k, this.l);
        }
        this.b = enumC0431Du;
        return enumC0431Du;
    }

    private void Q0() throws C4412yu {
        int[] iArrF = AbstractC3484nb.f();
        while (true) {
            if (this.e >= this.f && !h0()) {
                break;
            }
            byte[] bArr = this.U;
            int i = this.e;
            int i2 = i + 1;
            this.e = i2;
            int i3 = bArr[i] & UnsignedBytes.MAX_VALUE;
            int i4 = iArrF[i3];
            if (i4 != 0) {
                if (i4 == 2) {
                    W0(i3);
                } else if (i4 == 3) {
                    X0(i3);
                } else if (i4 == 4) {
                    Y0(i3);
                } else if (i4 == 10) {
                    U0();
                } else if (i4 == 13) {
                    R0();
                } else if (i4 == 42) {
                    if (i2 >= this.f && !h0()) {
                        break;
                    }
                    byte[] bArr2 = this.U;
                    int i5 = this.e;
                    if (bArr2[i5] == 47) {
                        this.e = i5 + 1;
                        return;
                    }
                } else {
                    L0(i3);
                }
            }
        }
        P(" in a comment");
    }

    private void S0() throws C4412yu {
        if (!G(JsonParser.Feature.ALLOW_COMMENTS)) {
            R(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        }
        if (this.e >= this.f && !h0()) {
            P(" in a comment");
        }
        byte[] bArr = this.U;
        int i = this.e;
        this.e = i + 1;
        int i2 = bArr[i] & UnsignedBytes.MAX_VALUE;
        if (i2 == 47) {
            T0();
        } else if (i2 == 42) {
            Q0();
        } else {
            R(i2, "was expecting either '*' or '/' for a comment");
        }
    }

    private void T0() throws C4412yu {
        int[] iArrF = AbstractC3484nb.f();
        while (true) {
            if (this.e >= this.f && !h0()) {
                return;
            }
            byte[] bArr = this.U;
            int i = this.e;
            this.e = i + 1;
            int i2 = bArr[i] & UnsignedBytes.MAX_VALUE;
            int i3 = iArrF[i2];
            if (i3 != 0) {
                if (i3 == 2) {
                    W0(i2);
                } else if (i3 == 3) {
                    X0(i2);
                } else if (i3 == 4) {
                    Y0(i2);
                } else if (i3 == 10) {
                    U0();
                    return;
                } else if (i3 == 13) {
                    R0();
                    return;
                } else if (i3 != 42) {
                    L0(i2);
                }
            }
        }
    }

    private int Z0() throws C4412yu {
        while (true) {
            if (this.e >= this.f && !h0()) {
                throw c("Unexpected end-of-input within/between " + this.n.c() + " entries");
            }
            byte[] bArr = this.U;
            int i = this.e;
            this.e = i + 1;
            int i2 = bArr[i] & UnsignedBytes.MAX_VALUE;
            if (i2 > 32) {
                if (i2 != 47) {
                    return i2;
                }
                S0();
            } else if (i2 != 32) {
                if (i2 == 10) {
                    U0();
                } else if (i2 == 13) {
                    R0();
                } else if (i2 != 9) {
                    T(i2);
                }
            }
        }
    }

    private int a1() throws C4412yu {
        while (true) {
            if (this.e >= this.f && !h0()) {
                L();
                return -1;
            }
            byte[] bArr = this.U;
            int i = this.e;
            this.e = i + 1;
            int i2 = bArr[i] & UnsignedBytes.MAX_VALUE;
            if (i2 > 32) {
                if (i2 != 47) {
                    return i2;
                }
                S0();
            } else if (i2 != 32) {
                if (i2 == 10) {
                    U0();
                } else if (i2 == 13) {
                    R0();
                } else if (i2 != 9) {
                    T(i2);
                }
            }
        }
    }

    public static int[] g1(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        int length = iArr.length;
        int[] iArr2 = new int[i + length];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        return iArr2;
    }

    public EnumC0431Du A0() throws C4412yu {
        char[] cArrI = this.q.i();
        int[] iArr = W;
        byte[] bArr = this.U;
        int i = 0;
        while (true) {
            if (this.e >= this.f) {
                i0();
            }
            if (i >= cArrI.length) {
                cArrI = this.q.m();
                i = 0;
            }
            int i2 = this.f;
            int length = this.e + (cArrI.length - i);
            if (length < i2) {
                i2 = length;
            }
            while (true) {
                int i3 = this.e;
                if (i3 >= i2) {
                    break;
                }
                int i4 = i3 + 1;
                this.e = i4;
                int iS0 = bArr[i3] & UnsignedBytes.MAX_VALUE;
                if (iS0 == 39 || iArr[iS0] != 0) {
                    if (iS0 != 39) {
                        int i5 = iArr[iS0];
                        if (i5 != 1) {
                            if (i5 == 2) {
                                iS0 = t0(iS0);
                            } else if (i5 == 3) {
                                iS0 = this.f - i4 >= 2 ? v0(iS0) : u0(iS0);
                            } else if (i5 != 4) {
                                if (iS0 < 32) {
                                    U(iS0, "string value");
                                }
                                L0(iS0);
                            } else {
                                int iW0 = w0(iS0);
                                int i6 = i + 1;
                                cArrI[i] = (char) ((iW0 >> 10) | 55296);
                                if (i6 >= cArrI.length) {
                                    cArrI = this.q.m();
                                    i = 0;
                                } else {
                                    i = i6;
                                }
                                iS0 = 56320 | (iW0 & IEEEDouble.EXPONENT_BIAS);
                            }
                        } else if (iS0 != 34) {
                            iS0 = s0();
                        }
                        if (i >= cArrI.length) {
                            cArrI = this.q.m();
                            i = 0;
                        }
                        cArrI[i] = (char) iS0;
                        i++;
                        break;
                    }
                    this.q.w(i);
                    return EnumC0431Du.VALUE_STRING;
                }
                cArrI[i] = (char) iS0;
                i++;
            }
        }
    }

    public EnumC0431Du B0(int i, boolean z) throws C4412yu {
        if (i == 73) {
            if (this.e >= this.f && !h0()) {
                Q();
            }
            byte[] bArr = this.U;
            int i2 = this.e;
            this.e = i2 + 1;
            i = bArr[i2];
            if (i == 78) {
                String str = z ? "-INF" : "+INF";
                E0(str, 3);
                if (G(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                    return o0(str, z ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY);
                }
                N("Non-standard token '" + str + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
            } else if (i == 110) {
                String str2 = z ? "-Infinity" : "+Infinity";
                E0(str2, 3);
                if (G(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                    return o0(str2, z ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY);
                }
                N("Non-standard token '" + str2 + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
            }
        }
        m0(i, "expected digit (0-9) to follow minus sign, for valid numeric value");
        return null;
    }

    public EnumC0431Du C0(int i) throws C4412yu {
        if (i != 39) {
            if (i == 43) {
                if (this.e >= this.f && !h0()) {
                    Q();
                }
                byte[] bArr = this.U;
                int i2 = this.e;
                this.e = i2 + 1;
                return B0(bArr[i2] & UnsignedBytes.MAX_VALUE, false);
            }
            if (i == 78) {
                E0("NaN", 1);
                if (G(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                    return o0("NaN", Double.NaN);
                }
                N("Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
            }
        } else if (G(JsonParser.Feature.ALLOW_SINGLE_QUOTES)) {
            return A0();
        }
        R(i, "expected a valid value (number, String, array, object, 'true', 'false' or 'null')");
        return null;
    }

    public XC D0(int i) throws C4412yu {
        if (i == 39 && G(JsonParser.Feature.ALLOW_SINGLE_QUOTES)) {
            return H0();
        }
        if (!G(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES)) {
            R(i, "was expecting double-quote to start field name");
        }
        int[] iArrJ = AbstractC3484nb.j();
        if (iArrJ[i] != 0) {
            R(i, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
        }
        int[] iArrG1 = this.Q;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i2 < 4) {
                i2++;
                i4 = i | (i4 << 8);
            } else {
                if (i3 >= iArrG1.length) {
                    iArrG1 = g1(iArrG1, iArrG1.length);
                    this.Q = iArrG1;
                }
                iArrG1[i3] = i4;
                i4 = i;
                i3++;
                i2 = 1;
            }
            if (this.e >= this.f && !h0()) {
                P(" in field name");
            }
            byte[] bArr = this.U;
            int i5 = this.e;
            i = bArr[i5] & UnsignedBytes.MAX_VALUE;
            if (iArrJ[i] != 0) {
                break;
            }
            this.e = i5 + 1;
        }
        if (i2 > 0) {
            if (i3 >= iArrG1.length) {
                iArrG1 = g1(iArrG1, iArrG1.length);
                this.Q = iArrG1;
            }
            iArrG1[i3] = i4;
            i3++;
        }
        XC xcM = this.P.m(iArrG1, i3);
        return xcM == null ? c1(iArrG1, i3, i2) : xcM;
    }

    public void E0(String str, int i) throws C4412yu {
        int i2;
        int i3;
        int length = str.length();
        do {
            if (this.e >= this.f && !h0()) {
                P(" in a value");
            }
            if (this.U[this.e] != str.charAt(i)) {
                P0(str.substring(0, i), "'null', 'true', 'false' or NaN");
            }
            i2 = this.e + 1;
            this.e = i2;
            i++;
        } while (i < length);
        if ((i2 < this.f || h0()) && (i3 = this.U[this.e] & UnsignedBytes.MAX_VALUE) >= 48 && i3 != 93 && i3 != 125 && Character.isJavaIdentifierPart((char) r0(i3))) {
            this.e++;
            P0(str.substring(0, i), "'null', 'true', 'false' or NaN");
        }
    }

    @Override // defpackage.AbstractC3707qG, com.fasterxml.jackson.core.JsonParser
    public String F() throws C4412yu {
        EnumC0431Du enumC0431Du = this.b;
        if (enumC0431Du != EnumC0431Du.VALUE_STRING) {
            return z0(enumC0431Du);
        }
        if (this.R) {
            this.R = false;
            x0();
        }
        return this.q.h();
    }

    public final EnumC0431Du G0(int i) throws C4412yu {
        if (i == 34) {
            this.R = true;
            EnumC0431Du enumC0431Du = EnumC0431Du.VALUE_STRING;
            this.b = enumC0431Du;
            return enumC0431Du;
        }
        if (i != 45) {
            if (i == 91) {
                this.n = this.n.g(this.k, this.l);
                EnumC0431Du enumC0431Du2 = EnumC0431Du.START_ARRAY;
                this.b = enumC0431Du2;
                return enumC0431Du2;
            }
            if (i == 93) {
                R(i, "expected a value");
            } else {
                if (i == 102) {
                    E0(PdfBoolean.FALSE, 1);
                    EnumC0431Du enumC0431Du3 = EnumC0431Du.VALUE_FALSE;
                    this.b = enumC0431Du3;
                    return enumC0431Du3;
                }
                if (i == 110) {
                    E0("null", 1);
                    EnumC0431Du enumC0431Du4 = EnumC0431Du.VALUE_NULL;
                    this.b = enumC0431Du4;
                    return enumC0431Du4;
                }
                if (i != 116) {
                    if (i == 123) {
                        this.n = this.n.h(this.k, this.l);
                        EnumC0431Du enumC0431Du5 = EnumC0431Du.START_OBJECT;
                        this.b = enumC0431Du5;
                        return enumC0431Du5;
                    }
                    if (i != 125) {
                        switch (i) {
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
                                break;
                            default:
                                EnumC0431Du enumC0431DuC0 = C0(i);
                                this.b = enumC0431DuC0;
                                return enumC0431DuC0;
                        }
                    }
                    R(i, "expected a value");
                }
            }
            E0(PdfBoolean.TRUE, 1);
            EnumC0431Du enumC0431Du6 = EnumC0431Du.VALUE_TRUE;
            this.b = enumC0431Du6;
            return enumC0431Du6;
        }
        EnumC0431Du enumC0431DuN1 = n1(i);
        this.b = enumC0431DuN1;
        return enumC0431DuN1;
    }

    /* JADX WARN: Code duplicated, block: B:62:0x0112  */
    /* JADX WARN: Code duplicated, block: B:65:0x0122  */
    @Override // defpackage.AbstractC3707qG, com.fasterxml.jackson.core.JsonParser
    public EnumC0431Du H() throws C4412yu {
        EnumC0431Du enumC0431DuN1;
        this.x = 0;
        EnumC0431Du enumC0431Du = this.b;
        EnumC0431Du enumC0431Du2 = EnumC0431Du.FIELD_NAME;
        if (enumC0431Du == enumC0431Du2) {
            return F0();
        }
        if (this.R) {
            V0();
        }
        int iA1 = a1();
        if (iA1 < 0) {
            close();
            this.b = null;
            return null;
        }
        long j = this.g;
        int i = this.e;
        this.j = (j + ((long) i)) - 1;
        this.k = this.h;
        this.l = (i - this.i) - 1;
        this.w = null;
        if (iA1 == 93) {
            if (!this.n.d()) {
                b0(iA1, '}');
            }
            this.n = this.n.l();
            EnumC0431Du enumC0431Du3 = EnumC0431Du.END_ARRAY;
            this.b = enumC0431Du3;
            return enumC0431Du3;
        }
        if (iA1 == 125) {
            if (!this.n.e()) {
                b0(iA1, ']');
            }
            this.n = this.n.l();
            EnumC0431Du enumC0431Du4 = EnumC0431Du.END_OBJECT;
            this.b = enumC0431Du4;
            return enumC0431Du4;
        }
        if (this.n.j()) {
            if (iA1 != 44) {
                R(iA1, "was expecting comma to separate " + this.n.c() + " entries");
            }
            iA1 = Z0();
        }
        if (!this.n.e()) {
            return G0(iA1);
        }
        this.n.o(I0(iA1).d());
        this.b = enumC0431Du2;
        int iZ0 = Z0();
        if (iZ0 != 58) {
            R(iZ0, "was expecting a colon to separate field name and value");
        }
        int iZ1 = Z0();
        if (iZ1 == 34) {
            this.R = true;
            this.p = EnumC0431Du.VALUE_STRING;
            return this.b;
        }
        if (iZ1 == 45) {
            enumC0431DuN1 = n1(iZ1);
        } else if (iZ1 == 91) {
            enumC0431DuN1 = EnumC0431Du.START_ARRAY;
        } else if (iZ1 == 93) {
            R(iZ1, "expected a value");
            E0(PdfBoolean.TRUE, 1);
            enumC0431DuN1 = EnumC0431Du.VALUE_TRUE;
        } else if (iZ1 == 102) {
            E0(PdfBoolean.FALSE, 1);
            enumC0431DuN1 = EnumC0431Du.VALUE_FALSE;
        } else if (iZ1 == 110) {
            E0("null", 1);
            enumC0431DuN1 = EnumC0431Du.VALUE_NULL;
        } else if (iZ1 == 116) {
            E0(PdfBoolean.TRUE, 1);
            enumC0431DuN1 = EnumC0431Du.VALUE_TRUE;
        } else if (iZ1 == 123) {
            enumC0431DuN1 = EnumC0431Du.START_OBJECT;
        } else if (iZ1 != 125) {
            switch (iZ1) {
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
                    enumC0431DuN1 = n1(iZ1);
                    break;
                default:
                    enumC0431DuN1 = C0(iZ1);
                    break;
            }
        } else {
            R(iZ1, "expected a value");
            E0(PdfBoolean.TRUE, 1);
            enumC0431DuN1 = EnumC0431Du.VALUE_TRUE;
        }
        this.p = enumC0431DuN1;
        return this.b;
    }

    public XC H0() throws C4412yu {
        if (this.e >= this.f && !h0()) {
            P(": was expecting closing ''' for name");
        }
        byte[] bArr = this.U;
        int i = this.e;
        this.e = i + 1;
        int iS0 = bArr[i] & UnsignedBytes.MAX_VALUE;
        if (iS0 == 39) {
            return X8.n();
        }
        int[] iArrG1 = this.Q;
        int[] iArr = X;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (iS0 != 39) {
            if (iS0 != 34 && iArr[iS0] != 0) {
                if (iS0 != 92) {
                    U(iS0, "name");
                } else {
                    iS0 = s0();
                }
                if (iS0 > 127) {
                    if (i2 >= 4) {
                        if (i3 >= iArrG1.length) {
                            iArrG1 = g1(iArrG1, iArrG1.length);
                            this.Q = iArrG1;
                        }
                        iArrG1[i3] = i4;
                        i3++;
                        i2 = 0;
                        i4 = 0;
                    }
                    if (iS0 < 2048) {
                        i4 = (i4 << 8) | (iS0 >> 6) | 192;
                        i2++;
                    } else {
                        int i5 = (i4 << 8) | (iS0 >> 12) | 224;
                        int i6 = i2 + 1;
                        if (i6 >= 4) {
                            if (i3 >= iArrG1.length) {
                                iArrG1 = g1(iArrG1, iArrG1.length);
                                this.Q = iArrG1;
                            }
                            iArrG1[i3] = i5;
                            i3++;
                            i6 = 0;
                            i5 = 0;
                        }
                        i4 = (i5 << 8) | ((iS0 >> 6) & 63) | 128;
                        i2 = i6 + 1;
                    }
                    iS0 = (iS0 & 63) | 128;
                }
            }
            if (i2 < 4) {
                i2++;
                i4 = iS0 | (i4 << 8);
            } else {
                if (i3 >= iArrG1.length) {
                    iArrG1 = g1(iArrG1, iArrG1.length);
                    this.Q = iArrG1;
                }
                iArrG1[i3] = i4;
                i4 = iS0;
                i3++;
                i2 = 1;
            }
            if (this.e >= this.f && !h0()) {
                P(" in field name");
            }
            byte[] bArr2 = this.U;
            int i7 = this.e;
            this.e = i7 + 1;
            iS0 = bArr2[i7] & UnsignedBytes.MAX_VALUE;
        }
        if (i2 > 0) {
            if (i3 >= iArrG1.length) {
                iArrG1 = g1(iArrG1, iArrG1.length);
                this.Q = iArrG1;
            }
            iArrG1[i3] = i4;
            i3++;
        }
        XC xcM = this.P.m(iArrG1, i3);
        return xcM == null ? c1(iArrG1, i3, i2) : xcM;
    }

    public XC I0(int i) {
        if (i != 34) {
            return D0(i);
        }
        int i2 = this.e;
        if (i2 + 9 > this.f) {
            return o1();
        }
        byte[] bArr = this.U;
        int[] iArr = X;
        int i3 = i2 + 1;
        this.e = i3;
        int i4 = bArr[i2] & UnsignedBytes.MAX_VALUE;
        if (iArr[i4] != 0) {
            return i4 == 34 ? X8.n() : j1(0, i4, 0);
        }
        int i5 = i2 + 2;
        this.e = i5;
        int i6 = bArr[i3] & UnsignedBytes.MAX_VALUE;
        if (iArr[i6] != 0) {
            return i6 == 34 ? d1(i4, 1) : j1(i4, i6, 1);
        }
        int i7 = i6 | (i4 << 8);
        int i8 = i2 + 3;
        this.e = i8;
        int i9 = bArr[i5] & UnsignedBytes.MAX_VALUE;
        if (iArr[i9] != 0) {
            return i9 == 34 ? d1(i7, 2) : j1(i7, i9, 2);
        }
        int i10 = (i7 << 8) | i9;
        int i11 = i2 + 4;
        this.e = i11;
        int i12 = bArr[i8] & UnsignedBytes.MAX_VALUE;
        if (iArr[i12] != 0) {
            return i12 == 34 ? d1(i10, 3) : j1(i10, i12, 3);
        }
        int i13 = (i10 << 8) | i12;
        this.e = i2 + 5;
        int i14 = bArr[i11] & UnsignedBytes.MAX_VALUE;
        if (iArr[i14] != 0) {
            return i14 == 34 ? d1(i13, 4) : j1(i13, i14, 4);
        }
        this.S = i13;
        return m1(i14, iArr);
    }

    public final EnumC0431Du J0(char[] cArr, int i, int i2, boolean z, int i3) throws C4412yu {
        int i4;
        boolean z2;
        int i5 = 0;
        if (i2 == 46) {
            cArr[i] = (char) i2;
            i++;
            i4 = 0;
            while (true) {
                if (this.e >= this.f && !h0()) {
                    z2 = true;
                    break;
                }
                byte[] bArr = this.U;
                int i6 = this.e;
                this.e = i6 + 1;
                i2 = bArr[i6] & UnsignedBytes.MAX_VALUE;
                if (i2 < 48 || i2 > 57) {
                    z2 = false;
                    break;
                }
                i4++;
                if (i >= cArr.length) {
                    cArr = this.q.m();
                    i = 0;
                }
                cArr[i] = (char) i2;
                i++;
            }
            if (i4 == 0) {
                m0(i2, "Decimal point not followed by a digit");
            }
        } else {
            i4 = 0;
            z2 = false;
        }
        if (i2 == 101 || i2 == 69) {
            if (i >= cArr.length) {
                cArr = this.q.m();
                i = 0;
            }
            int i7 = i + 1;
            cArr[i] = (char) i2;
            if (this.e >= this.f) {
                i0();
            }
            byte[] bArr2 = this.U;
            int i8 = this.e;
            this.e = i8 + 1;
            int i9 = bArr2[i8] & UnsignedBytes.MAX_VALUE;
            if (i9 == 45 || i9 == 43) {
                if (i7 >= cArr.length) {
                    cArr = this.q.m();
                    i7 = 0;
                }
                int i10 = i7 + 1;
                cArr[i7] = (char) i9;
                if (this.e >= this.f) {
                    i0();
                }
                byte[] bArr3 = this.U;
                int i11 = this.e;
                this.e = i11 + 1;
                i9 = bArr3[i11] & UnsignedBytes.MAX_VALUE;
                i7 = i10;
            }
            int i12 = 0;
            while (true) {
                if (i9 <= 57 && i9 >= 48) {
                    i12++;
                    if (i7 >= cArr.length) {
                        cArr = this.q.m();
                        i7 = 0;
                    }
                    int i13 = i7 + 1;
                    cArr[i7] = (char) i9;
                    if (this.e >= this.f && !h0()) {
                        i5 = i12;
                        i7 = i13;
                        z2 = true;
                        break;
                    }
                    byte[] bArr4 = this.U;
                    int i14 = this.e;
                    this.e = i14 + 1;
                    i9 = bArr4[i14] & UnsignedBytes.MAX_VALUE;
                    i7 = i13;
                } else {
                    i5 = i12;
                    break;
                }
            }
            if (i5 == 0) {
                m0(i9, "Exponent indicator not followed by a digit");
            }
            i = i7;
        }
        if (!z2) {
            this.e--;
        }
        this.q.w(i);
        return p0(z, i3, i4, i5);
    }

    public final EnumC0431Du K0(char[] cArr, int i, boolean z, int i2) {
        char[] cArrM = cArr;
        int i3 = i;
        int i4 = i2;
        while (true) {
            if (this.e >= this.f && !h0()) {
                this.q.w(i3);
                return q0(z, i4);
            }
            byte[] bArr = this.U;
            int i5 = this.e;
            this.e = i5 + 1;
            int i6 = bArr[i5] & UnsignedBytes.MAX_VALUE;
            if (i6 > 57 || i6 < 48) {
                if (i6 == 46 || i6 == 101 || i6 == 69) {
                    return J0(cArrM, i3, i6, z, i4);
                }
                this.e = i5;
                this.q.w(i3);
                return q0(z, i4);
            }
            if (i3 >= cArrM.length) {
                i3 = 0;
                cArrM = this.q.m();
            }
            cArrM[i3] = (char) i6;
            i4++;
            i3++;
        }
    }

    public void L0(int i) throws C4412yu {
        if (i < 32) {
            T(i);
        }
        M0(i);
    }

    public void M0(int i) throws C4412yu {
        N("Invalid UTF-8 start byte 0x" + Integer.toHexString(i));
    }

    public void N0(int i) throws C4412yu {
        N("Invalid UTF-8 middle byte 0x" + Integer.toHexString(i));
    }

    public void O0(int i, int i2) throws C4412yu {
        this.e = i2;
        N0(i);
    }

    public void P0(String str, String str2) throws C4412yu {
        StringBuilder sb = new StringBuilder(str);
        while (true) {
            if (this.e >= this.f && !h0()) {
                break;
            }
            byte[] bArr = this.U;
            int i = this.e;
            this.e = i + 1;
            char cR0 = (char) r0(bArr[i]);
            if (!Character.isJavaIdentifierPart(cR0)) {
                break;
            } else {
                sb.append(cR0);
            }
        }
        N("Unrecognized token '" + sb.toString() + "': was expecting " + str2);
    }

    public void R0() {
        if (this.e < this.f || h0()) {
            byte[] bArr = this.U;
            int i = this.e;
            if (bArr[i] == 10) {
                this.e = i + 1;
            }
        }
        this.h++;
        this.i = this.e;
    }

    public void U0() {
        this.h++;
        this.i = this.e;
    }

    public void V0() throws C4412yu {
        this.R = false;
        int[] iArr = W;
        byte[] bArr = this.U;
        while (true) {
            int i = this.e;
            int i2 = this.f;
            if (i >= i2) {
                i0();
                i = this.e;
                i2 = this.f;
            }
            while (true) {
                if (i >= i2) {
                    this.e = i;
                    break;
                }
                int i3 = i + 1;
                int i4 = bArr[i] & UnsignedBytes.MAX_VALUE;
                int i5 = iArr[i4];
                if (i5 != 0) {
                    this.e = i3;
                    if (i4 != 34) {
                        if (i5 == 1) {
                            s0();
                            break;
                        }
                        if (i5 == 2) {
                            W0(i4);
                            break;
                        }
                        if (i5 == 3) {
                            X0(i4);
                            break;
                        }
                        if (i5 == 4) {
                            Y0(i4);
                            break;
                        } else if (i4 >= 32) {
                            L0(i4);
                            break;
                        } else {
                            U(i4, "string value");
                            break;
                        }
                    }
                    return;
                }
                i = i3;
            }
        }
    }

    @Override // defpackage.AbstractC3626pG
    public void W() throws IOException {
        if (this.T != null) {
            if (this.c.h() || G(JsonParser.Feature.AUTO_CLOSE_SOURCE)) {
                this.T.close();
            }
            this.T = null;
        }
    }

    public final void W0(int i) throws C4412yu {
        if (this.e >= this.f) {
            i0();
        }
        byte[] bArr = this.U;
        int i2 = this.e;
        int i3 = i2 + 1;
        this.e = i3;
        byte b = bArr[i2];
        if ((b & 192) != 128) {
            O0(b & UnsignedBytes.MAX_VALUE, i3);
        }
    }

    public final void X0(int i) throws C4412yu {
        if (this.e >= this.f) {
            i0();
        }
        byte[] bArr = this.U;
        int i2 = this.e;
        int i3 = i2 + 1;
        this.e = i3;
        byte b = bArr[i2];
        if ((b & 192) != 128) {
            O0(b & UnsignedBytes.MAX_VALUE, i3);
        }
        if (this.e >= this.f) {
            i0();
        }
        byte[] bArr2 = this.U;
        int i4 = this.e;
        int i5 = i4 + 1;
        this.e = i5;
        byte b2 = bArr2[i4];
        if ((b2 & 192) != 128) {
            O0(b2 & UnsignedBytes.MAX_VALUE, i5);
        }
    }

    public final void Y0(int i) throws C4412yu {
        if (this.e >= this.f) {
            i0();
        }
        byte[] bArr = this.U;
        int i2 = this.e;
        int i3 = i2 + 1;
        this.e = i3;
        byte b = bArr[i2];
        if ((b & 192) != 128) {
            O0(b & UnsignedBytes.MAX_VALUE, i3);
        }
        if (this.e >= this.f) {
            i0();
        }
        byte[] bArr2 = this.U;
        int i4 = this.e;
        int i5 = i4 + 1;
        this.e = i5;
        byte b2 = bArr2[i4];
        if ((b2 & 192) != 128) {
            O0(b2 & UnsignedBytes.MAX_VALUE, i5);
        }
        if (this.e >= this.f) {
            i0();
        }
        byte[] bArr3 = this.U;
        int i6 = this.e;
        int i7 = i6 + 1;
        this.e = i7;
        byte b3 = bArr3[i6];
        if ((b3 & 192) != 128) {
            O0(b3 & UnsignedBytes.MAX_VALUE, i7);
        }
    }

    @Override // defpackage.AbstractC3626pG
    public void a0() {
        byte[] bArr;
        super.a0();
        if (!this.V || (bArr = this.U) == null) {
            return;
        }
        this.U = null;
        this.c.k(bArr);
    }

    public final int b1() throws C4412yu {
        int i;
        if ((this.e >= this.f && !h0()) || (i = this.U[this.e] & UnsignedBytes.MAX_VALUE) < 48 || i > 57) {
            return 48;
        }
        if (!G(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS)) {
            j0("Leading zeroes not allowed");
        }
        this.e++;
        if (i == 48) {
            do {
                if (this.e >= this.f && !h0()) {
                    break;
                }
                byte[] bArr = this.U;
                int i2 = this.e;
                i = bArr[i2] & UnsignedBytes.MAX_VALUE;
                if (i < 48 || i > 57) {
                    return 48;
                }
                this.e = i2 + 1;
            } while (i == 48);
        }
        return i;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0060  */
    /* JADX WARN: Code duplicated, block: B:26:0x0077  */
    /* JADX WARN: Code duplicated, block: B:29:0x0082  */
    /* JADX WARN: Code duplicated, block: B:31:0x0092  */
    /* JADX WARN: Code duplicated, block: B:34:0x009d  */
    /* JADX WARN: Code duplicated, block: B:36:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:40:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:42:0x00c1  */
    public final XC c1(int[] iArr, int i, int i2) throws C4412yu {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10 = ((i << 2) - 4) + i2;
        if (i2 < 4) {
            int i11 = i - 1;
            i3 = iArr[i11];
            iArr[i11] = i3 << ((4 - i2) << 3);
        } else {
            i3 = 0;
        }
        char[] cArrI = this.q.i();
        int i12 = 0;
        int i13 = 0;
        while (i12 < i10) {
            int i14 = iArr[i12 >> 2] >> ((3 - (i12 & 3)) << 3);
            int i15 = i14 & 255;
            int i16 = i12 + 1;
            if (i15 > 127) {
                if ((i14 & 224) == 192) {
                    i4 = i14 & 31;
                } else {
                    if ((i14 & 240) == 224) {
                        i4 = i14 & 15;
                        i5 = 2;
                    } else if ((i14 & 248) == 240) {
                        i4 = i14 & 7;
                        i5 = 3;
                    } else {
                        M0(i15);
                        i4 = 1;
                    }
                    if (i16 + i5 > i10) {
                        P(" in field name");
                    }
                    i6 = iArr[i16 >> 2] >> ((3 - (i16 & 3)) << 3);
                    i16 = i12 + 2;
                    if ((i6 & 192) != 128) {
                        N0(i6);
                    }
                    i7 = (i4 << 6) | (i6 & 63);
                    if (i5 > 1) {
                        i8 = iArr[i16 >> 2] >> ((3 - (i16 & 3)) << 3);
                        i16 = i12 + 3;
                        if ((i8 & 192) != 128) {
                            N0(i8);
                        }
                        i7 = (i7 << 6) | (i8 & 63);
                        if (i5 > 2) {
                            i9 = iArr[i16 >> 2] >> ((3 - (i16 & 3)) << 3);
                            i16 = i12 + 4;
                            if ((i9 & 192) != 128) {
                                N0(i9 & 255);
                            }
                            i7 = (i7 << 6) | (i9 & 63);
                        }
                    }
                    i15 = i7;
                    if (i5 > 2) {
                        int i17 = i15 - 65536;
                        if (i13 >= cArrI.length) {
                            cArrI = this.q.k();
                        }
                        cArrI[i13] = (char) ((i17 >> 10) + 55296);
                        i15 = (i17 & IEEEDouble.EXPONENT_BIAS) | 56320;
                        i13++;
                    }
                }
                i5 = 1;
                if (i16 + i5 > i10) {
                    P(" in field name");
                }
                i6 = iArr[i16 >> 2] >> ((3 - (i16 & 3)) << 3);
                i16 = i12 + 2;
                if ((i6 & 192) != 128) {
                    N0(i6);
                }
                i7 = (i4 << 6) | (i6 & 63);
                if (i5 > 1) {
                    i8 = iArr[i16 >> 2] >> ((3 - (i16 & 3)) << 3);
                    i16 = i12 + 3;
                    if ((i8 & 192) != 128) {
                        N0(i8);
                    }
                    i7 = (i7 << 6) | (i8 & 63);
                    if (i5 > 2) {
                        i9 = iArr[i16 >> 2] >> ((3 - (i16 & 3)) << 3);
                        i16 = i12 + 4;
                        if ((i9 & 192) != 128) {
                            N0(i9 & 255);
                        }
                        i7 = (i7 << 6) | (i9 & 63);
                    }
                }
                i15 = i7;
                if (i5 > 2) {
                    int i18 = i15 - 65536;
                    if (i13 >= cArrI.length) {
                        cArrI = this.q.k();
                    }
                    cArrI[i13] = (char) ((i18 >> 10) + 55296);
                    i15 = (i18 & IEEEDouble.EXPONENT_BIAS) | 56320;
                    i13++;
                }
            }
            i12 = i16;
            if (i13 >= cArrI.length) {
                cArrI = this.q.k();
            }
            cArrI[i13] = (char) i15;
            i13++;
        }
        String str = new String(cArrI, 0, i13);
        if (i2 < 4) {
            iArr[i - 1] = i3;
        }
        return this.P.b(str, iArr, i);
    }

    @Override // defpackage.AbstractC3626pG, com.fasterxml.jackson.core.JsonParser, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        this.P.u();
    }

    public final XC d1(int i, int i2) {
        XC xcK = this.P.k(i);
        if (xcK != null) {
            return xcK;
        }
        int[] iArr = this.Q;
        iArr[0] = i;
        return c1(iArr, 1, i2);
    }

    public final XC e1(int i, int i2, int i3) {
        XC xcL = this.P.l(i, i2);
        if (xcL != null) {
            return xcL;
        }
        int[] iArr = this.Q;
        iArr[0] = i;
        iArr[1] = i2;
        return c1(iArr, 2, i3);
    }

    public final XC f1(int[] iArr, int i, int i2, int i3) {
        if (i >= iArr.length) {
            iArr = g1(iArr, iArr.length);
            this.Q = iArr;
        }
        int i4 = i + 1;
        iArr[i] = i2;
        XC xcM = this.P.m(iArr, i4);
        return xcM == null ? c1(iArr, i4, i3) : xcM;
    }

    @Override // defpackage.AbstractC3626pG
    public boolean h0() throws IOException {
        long j = this.g;
        int i = this.f;
        this.g = j + ((long) i);
        this.i -= i;
        InputStream inputStream = this.T;
        if (inputStream != null) {
            byte[] bArr = this.U;
            int i2 = inputStream.read(bArr, 0, bArr.length);
            if (i2 > 0) {
                this.e = 0;
                this.f = i2;
                return true;
            }
            W();
            if (i2 == 0) {
                throw new IOException("InputStream.read() returned 0 characters when trying to read " + this.U.length + " bytes");
            }
        }
        return false;
    }

    public final int h1() throws C4412yu {
        if (this.e >= this.f) {
            i0();
        }
        byte[] bArr = this.U;
        int i = this.e;
        this.e = i + 1;
        return bArr[i] & UnsignedBytes.MAX_VALUE;
    }

    public XC i1(int[] iArr, int i, int i2, int i3, int i4) throws C4412yu {
        int[] iArr2 = X;
        while (true) {
            if (iArr2[i3] != 0) {
                if (i3 == 34) {
                    break;
                }
                if (i3 != 92) {
                    U(i3, "name");
                } else {
                    i3 = s0();
                }
                if (i3 > 127) {
                    int i5 = 0;
                    if (i4 >= 4) {
                        if (i >= iArr.length) {
                            iArr = g1(iArr, iArr.length);
                            this.Q = iArr;
                        }
                        iArr[i] = i2;
                        i++;
                        i2 = 0;
                        i4 = 0;
                    }
                    if (i3 < 2048) {
                        i2 = (i2 << 8) | (i3 >> 6) | 192;
                        i4++;
                    } else {
                        int i6 = (i2 << 8) | (i3 >> 12) | 224;
                        int i7 = i4 + 1;
                        if (i7 >= 4) {
                            if (i >= iArr.length) {
                                iArr = g1(iArr, iArr.length);
                                this.Q = iArr;
                            }
                            iArr[i] = i6;
                            i++;
                            i7 = 0;
                        } else {
                            i5 = i6;
                        }
                        i2 = (i5 << 8) | ((i3 >> 6) & 63) | 128;
                        i4 = i7 + 1;
                    }
                    i3 = (i3 & 63) | 128;
                }
            }
            if (i4 < 4) {
                i4++;
                i2 = (i2 << 8) | i3;
            } else {
                if (i >= iArr.length) {
                    iArr = g1(iArr, iArr.length);
                    this.Q = iArr;
                }
                iArr[i] = i2;
                i2 = i3;
                i++;
                i4 = 1;
            }
            if (this.e >= this.f && !h0()) {
                P(" in field name");
            }
            byte[] bArr = this.U;
            int i8 = this.e;
            this.e = i8 + 1;
            i3 = bArr[i8] & UnsignedBytes.MAX_VALUE;
        }
        if (i4 > 0) {
            if (i >= iArr.length) {
                iArr = g1(iArr, iArr.length);
                this.Q = iArr;
            }
            iArr[i] = i2;
            i++;
        }
        XC xcM = this.P.m(iArr, i);
        return xcM == null ? c1(iArr, i, i4) : xcM;
    }

    public final XC j1(int i, int i2, int i3) {
        return i1(this.Q, 0, i, i2, i3);
    }

    public final XC k1(int i, int i2, int i3, int i4) {
        int[] iArr = this.Q;
        iArr[0] = i;
        return i1(iArr, 1, i2, i3, i4);
    }

    public XC l1(int i) {
        int[] iArr = X;
        int i2 = 2;
        while (true) {
            int i3 = this.f;
            int i4 = this.e;
            if (i3 - i4 < 4) {
                return i1(this.Q, i2, 0, i, 0);
            }
            byte[] bArr = this.U;
            int i5 = i4 + 1;
            this.e = i5;
            int i6 = bArr[i4] & UnsignedBytes.MAX_VALUE;
            if (iArr[i6] != 0) {
                return i6 == 34 ? f1(this.Q, i2, i, 1) : i1(this.Q, i2, i, i6, 1);
            }
            int i7 = (i << 8) | i6;
            int i8 = i4 + 2;
            this.e = i8;
            int i9 = bArr[i5] & UnsignedBytes.MAX_VALUE;
            if (iArr[i9] != 0) {
                return i9 == 34 ? f1(this.Q, i2, i7, 2) : i1(this.Q, i2, i7, i9, 2);
            }
            int i10 = (i7 << 8) | i9;
            int i11 = i4 + 3;
            this.e = i11;
            int i12 = bArr[i8] & UnsignedBytes.MAX_VALUE;
            if (iArr[i12] != 0) {
                return i12 == 34 ? f1(this.Q, i2, i10, 3) : i1(this.Q, i2, i10, i12, 3);
            }
            int i13 = (i10 << 8) | i12;
            this.e = i4 + 4;
            int i14 = bArr[i11] & UnsignedBytes.MAX_VALUE;
            if (iArr[i14] != 0) {
                return i14 == 34 ? f1(this.Q, i2, i13, 4) : i1(this.Q, i2, i13, i14, 4);
            }
            int[] iArr2 = this.Q;
            if (i2 >= iArr2.length) {
                this.Q = g1(iArr2, i2);
            }
            this.Q[i2] = i13;
            i2++;
            i = i14;
        }
    }

    public XC m1(int i, int[] iArr) {
        byte[] bArr = this.U;
        int i2 = this.e;
        int i3 = i2 + 1;
        this.e = i3;
        int i4 = bArr[i2] & UnsignedBytes.MAX_VALUE;
        if (iArr[i4] != 0) {
            return i4 == 34 ? e1(this.S, i, 1) : k1(this.S, i, i4, 1);
        }
        int i5 = (i << 8) | i4;
        int i6 = i2 + 2;
        this.e = i6;
        int i7 = bArr[i3] & UnsignedBytes.MAX_VALUE;
        if (iArr[i7] != 0) {
            return i7 == 34 ? e1(this.S, i5, 2) : k1(this.S, i5, i7, 2);
        }
        int i8 = (i5 << 8) | i7;
        int i9 = i2 + 3;
        this.e = i9;
        int i10 = bArr[i6] & UnsignedBytes.MAX_VALUE;
        if (iArr[i10] != 0) {
            return i10 == 34 ? e1(this.S, i8, 3) : k1(this.S, i8, i10, 3);
        }
        int i11 = (i8 << 8) | i10;
        this.e = i2 + 4;
        int i12 = bArr[i9] & UnsignedBytes.MAX_VALUE;
        if (iArr[i12] != 0) {
            return i12 == 34 ? e1(this.S, i11, 4) : k1(this.S, i11, i12, 4);
        }
        int[] iArr2 = this.Q;
        iArr2[0] = this.S;
        iArr2[1] = i11;
        return l1(i12);
    }

    public EnumC0431Du n1(int i) throws C4412yu {
        char[] cArrI = this.q.i();
        int i2 = 1;
        int i3 = 0;
        boolean z = i == 45;
        if (z) {
            cArrI[0] = '-';
            if (this.e >= this.f) {
                i0();
            }
            byte[] bArr = this.U;
            int i4 = this.e;
            this.e = i4 + 1;
            i = bArr[i4] & UnsignedBytes.MAX_VALUE;
            if (i < 48 || i > 57) {
                return B0(i, true);
            }
            i3 = 1;
        }
        if (i == 48) {
            i = b1();
        }
        int i5 = i3 + 1;
        cArrI[i3] = (char) i;
        int length = this.e + cArrI.length;
        int i6 = this.f;
        if (length > i6) {
            length = i6;
        }
        while (true) {
            int i7 = this.e;
            if (i7 >= length) {
                return K0(cArrI, i5, z, i2);
            }
            byte[] bArr2 = this.U;
            this.e = i7 + 1;
            int i8 = bArr2[i7] & UnsignedBytes.MAX_VALUE;
            if (i8 < 48 || i8 > 57) {
                if (i8 == 46 || i8 == 101 || i8 == 69) {
                    return J0(cArrI, i5, i8, z, i2);
                }
                this.e = i7;
                this.q.w(i5);
                return q0(z, i2);
            }
            i2++;
            cArrI[i5] = (char) i8;
            i5++;
        }
    }

    public XC o1() throws C4412yu {
        if (this.e >= this.f && !h0()) {
            P(": was expecting closing '\"' for name");
        }
        byte[] bArr = this.U;
        int i = this.e;
        this.e = i + 1;
        int i2 = bArr[i] & UnsignedBytes.MAX_VALUE;
        return i2 == 34 ? X8.n() : i1(this.Q, 0, 0, i2, 0);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0032  */
    /* JADX WARN: Code duplicated, block: B:19:0x003e  */
    /* JADX WARN: Code duplicated, block: B:21:0x0046  */
    /* JADX WARN: Code duplicated, block: B:24:0x0052  */
    /* JADX WARN: Code duplicated, block: B:26:0x005a  */
    /* JADX WARN: Code duplicated, block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:? A[RETURN, SYNTHETIC] */
    public int r0(int i) throws C4412yu {
        char c;
        int iH1;
        int i2;
        int iH2;
        int i3;
        int iH3;
        if (i >= 0) {
            return i;
        }
        if ((i & 224) != 192) {
            if ((i & 240) == 224) {
                i &= 15;
                c = 2;
            } else if ((i & 248) == 240) {
                i &= 7;
                c = 3;
            } else {
                M0(i & 255);
            }
            iH1 = h1();
            if ((iH1 & 192) != 128) {
                N0(iH1 & 255);
            }
            i2 = (i << 6) | (iH1 & 63);
            if (c > 1) {
                return i2;
            }
            iH2 = h1();
            if ((iH2 & 192) != 128) {
                N0(iH2 & 255);
            }
            i3 = (i2 << 6) | (iH2 & 63);
            if (c > 2) {
                return i3;
            }
            iH3 = h1();
            if ((iH3 & 192) != 128) {
                N0(iH3 & 255);
            }
            return (i3 << 6) | (iH3 & 63);
        }
        i &= 31;
        c = 1;
        iH1 = h1();
        if ((iH1 & 192) != 128) {
            N0(iH1 & 255);
        }
        i2 = (i << 6) | (iH1 & 63);
        if (c > 1) {
            return i2;
        }
        iH2 = h1();
        if ((iH2 & 192) != 128) {
            N0(iH2 & 255);
        }
        i3 = (i2 << 6) | (iH2 & 63);
        if (c > 2) {
            return i3;
        }
        iH3 = h1();
        if ((iH3 & 192) != 128) {
            N0(iH3 & 255);
        }
        return (i3 << 6) | (iH3 & 63);
    }

    public char s0() throws C4412yu {
        if (this.e >= this.f && !h0()) {
            P(" in character escape sequence");
        }
        byte[] bArr = this.U;
        int i = this.e;
        this.e = i + 1;
        byte b = bArr[i];
        if (b == 34 || b == 47 || b == 92) {
            return (char) b;
        }
        if (b == 98) {
            return '\b';
        }
        if (b == 102) {
            return '\f';
        }
        if (b == 110) {
            return '\n';
        }
        if (b == 114) {
            return '\r';
        }
        if (b == 116) {
            return '\t';
        }
        if (b != 117) {
            return M((char) r0(b));
        }
        int i2 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            if (this.e >= this.f && !h0()) {
                P(" in character escape sequence");
            }
            byte[] bArr2 = this.U;
            int i4 = this.e;
            this.e = i4 + 1;
            byte b2 = bArr2[i4];
            int iB = AbstractC3484nb.b(b2);
            if (iB < 0) {
                R(b2, "expected a hex-digit for character escape sequence");
            }
            i2 = (i2 << 4) | iB;
        }
        return (char) i2;
    }

    public final int t0(int i) throws C4412yu {
        if (this.e >= this.f) {
            i0();
        }
        byte[] bArr = this.U;
        int i2 = this.e;
        int i3 = i2 + 1;
        this.e = i3;
        byte b = bArr[i2];
        if ((b & 192) != 128) {
            O0(b & UnsignedBytes.MAX_VALUE, i3);
        }
        return ((i & 31) << 6) | (b & 63);
    }

    public final int u0(int i) throws C4412yu {
        if (this.e >= this.f) {
            i0();
        }
        int i2 = i & 15;
        byte[] bArr = this.U;
        int i3 = this.e;
        int i4 = i3 + 1;
        this.e = i4;
        byte b = bArr[i3];
        if ((b & 192) != 128) {
            O0(b & UnsignedBytes.MAX_VALUE, i4);
        }
        int i5 = (i2 << 6) | (b & 63);
        if (this.e >= this.f) {
            i0();
        }
        byte[] bArr2 = this.U;
        int i6 = this.e;
        int i7 = i6 + 1;
        this.e = i7;
        byte b2 = bArr2[i6];
        if ((b2 & 192) != 128) {
            O0(b2 & UnsignedBytes.MAX_VALUE, i7);
        }
        return (i5 << 6) | (b2 & 63);
    }

    public final int v0(int i) throws C4412yu {
        int i2 = i & 15;
        byte[] bArr = this.U;
        int i3 = this.e;
        int i4 = i3 + 1;
        this.e = i4;
        byte b = bArr[i3];
        if ((b & 192) != 128) {
            O0(b & UnsignedBytes.MAX_VALUE, i4);
        }
        int i5 = (i2 << 6) | (b & 63);
        byte[] bArr2 = this.U;
        int i6 = this.e;
        int i7 = i6 + 1;
        this.e = i7;
        byte b2 = bArr2[i6];
        if ((b2 & 192) != 128) {
            O0(b2 & UnsignedBytes.MAX_VALUE, i7);
        }
        return (i5 << 6) | (b2 & 63);
    }

    public final int w0(int i) throws C4412yu {
        if (this.e >= this.f) {
            i0();
        }
        byte[] bArr = this.U;
        int i2 = this.e;
        int i3 = i2 + 1;
        this.e = i3;
        byte b = bArr[i2];
        if ((b & 192) != 128) {
            O0(b & UnsignedBytes.MAX_VALUE, i3);
        }
        int i4 = ((i & 7) << 6) | (b & 63);
        if (this.e >= this.f) {
            i0();
        }
        byte[] bArr2 = this.U;
        int i5 = this.e;
        int i6 = i5 + 1;
        this.e = i6;
        byte b2 = bArr2[i5];
        if ((b2 & 192) != 128) {
            O0(b2 & UnsignedBytes.MAX_VALUE, i6);
        }
        int i7 = (i4 << 6) | (b2 & 63);
        if (this.e >= this.f) {
            i0();
        }
        byte[] bArr3 = this.U;
        int i8 = this.e;
        int i9 = i8 + 1;
        this.e = i9;
        byte b3 = bArr3[i8];
        if ((b3 & 192) != 128) {
            O0(b3 & UnsignedBytes.MAX_VALUE, i9);
        }
        return ((i7 << 6) | (b3 & 63)) - 65536;
    }

    public void x0() throws C4412yu {
        int i = this.e;
        if (i >= this.f) {
            i0();
            i = this.e;
        }
        char[] cArrI = this.q.i();
        int[] iArr = W;
        int iMin = Math.min(this.f, cArrI.length + i);
        byte[] bArr = this.U;
        int i2 = 0;
        while (i < iMin) {
            int i3 = bArr[i] & UnsignedBytes.MAX_VALUE;
            if (iArr[i3] != 0) {
                if (i3 != 34) {
                    break;
                }
                this.e = i + 1;
                this.q.w(i2);
                return;
            }
            i++;
            cArrI[i2] = (char) i3;
            i2++;
        }
        this.e = i;
        y0(cArrI, i2);
    }

    public final void y0(char[] cArr, int i) throws C4412yu {
        int[] iArr = W;
        byte[] bArr = this.U;
        while (true) {
            int i2 = this.e;
            if (i2 >= this.f) {
                i0();
                i2 = this.e;
            }
            int i3 = 0;
            if (i >= cArr.length) {
                cArr = this.q.m();
                i = 0;
            }
            int iMin = Math.min(this.f, (cArr.length - i) + i2);
            while (true) {
                if (i2 >= iMin) {
                    this.e = i2;
                    break;
                }
                int i4 = i2 + 1;
                int iS0 = bArr[i2] & UnsignedBytes.MAX_VALUE;
                int i5 = iArr[iS0];
                if (i5 != 0) {
                    this.e = i4;
                    if (iS0 != 34) {
                        if (i5 == 1) {
                            iS0 = s0();
                        } else if (i5 == 2) {
                            iS0 = t0(iS0);
                        } else if (i5 == 3) {
                            iS0 = this.f - i4 >= 2 ? v0(iS0) : u0(iS0);
                        } else if (i5 == 4) {
                            int iW0 = w0(iS0);
                            int i6 = i + 1;
                            cArr[i] = (char) ((iW0 >> 10) | 55296);
                            if (i6 >= cArr.length) {
                                cArr = this.q.m();
                                i = 0;
                            } else {
                                i = i6;
                            }
                            iS0 = (iW0 & IEEEDouble.EXPONENT_BIAS) | 56320;
                        } else if (iS0 < 32) {
                            U(iS0, "string value");
                        } else {
                            L0(iS0);
                        }
                        if (i >= cArr.length) {
                            cArr = this.q.m();
                        } else {
                            i3 = i;
                        }
                        i = i3 + 1;
                        cArr[i3] = (char) iS0;
                        break;
                    }
                    this.q.w(i);
                    return;
                }
                cArr[i] = (char) iS0;
                i2 = i4;
                i++;
            }
        }
    }

    public String z0(EnumC0431Du enumC0431Du) {
        if (enumC0431Du == null) {
            return null;
        }
        int i = a.a[enumC0431Du.ordinal()];
        if (i != 1) {
            return (i == 2 || i == 3 || i == 4) ? this.q.h() : enumC0431Du.a();
        }
        return this.n.k();
    }
}
