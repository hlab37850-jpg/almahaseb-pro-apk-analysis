package defpackage;

import com.fasterxml.jackson.core.JsonParser;
import com.itextpdf.text.pdf.PdfBoolean;
import java.io.IOException;
import java.io.Reader;

/* JADX INFO: renamed from: vJ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C4114vJ extends AbstractC3626pG {
    public Reader P;
    public char[] Q;
    public final C3729qb R;
    public final int S;
    public boolean T;

    /* JADX INFO: renamed from: vJ$a */
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

    public C4114vJ(C0918Sr c0918Sr, int i, Reader reader, AbstractC2263gE abstractC2263gE, C3729qb c3729qb) {
        super(c0918Sr, i);
        this.T = false;
        this.P = reader;
        this.Q = c0918Sr.c();
        this.R = c3729qb;
        this.S = c3729qb.i();
    }

    public final EnumC0431Du A0() {
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

    public String B0() {
        int i = this.e;
        int i2 = this.S;
        int i3 = this.f;
        if (i < i3) {
            int[] iArrG = AbstractC3484nb.g();
            int length = iArrG.length;
            do {
                char[] cArr = this.Q;
                char c = cArr[i];
                if (c != '\'') {
                    if (c < length && iArrG[c] != 0) {
                        break;
                    }
                    i2 = (i2 * 33) + c;
                    i++;
                } else {
                    int i4 = this.e;
                    this.e = i + 1;
                    return this.R.h(cArr, i4, i - i4, i2);
                }
            } while (i < i3);
        }
        int i5 = this.e;
        this.e = i;
        return D0(i5, i2, 39);
    }

    public String C0(int i) {
        if (i != 34) {
            return y0(i);
        }
        int i2 = this.e;
        int i3 = this.S;
        int i4 = this.f;
        if (i2 < i4) {
            int[] iArrG = AbstractC3484nb.g();
            int length = iArrG.length;
            do {
                char[] cArr = this.Q;
                char c = cArr[i2];
                if (c < length && iArrG[c] != 0) {
                    if (c != '\"') {
                        break;
                    }
                    int i5 = this.e;
                    this.e = i2 + 1;
                    return this.R.h(cArr, i5, i2 - i5, i3);
                }
                i3 = (i3 * 33) + c;
                i2++;
            } while (i2 < i4);
        }
        int i6 = this.e;
        this.e = i2;
        return D0(i6, i3, 34);
    }

    public final String D0(int i, int i2, int i3) throws C4412yu {
        char cR0;
        this.q.u(this.Q, i, this.e - i);
        char[] cArrN = this.q.n();
        int iO = this.q.o();
        while (true) {
            if (this.e >= this.f && !h0()) {
                P(": was expecting closing '" + ((char) i3) + "' for name");
            }
            char[] cArr = this.Q;
            int i4 = this.e;
            this.e = i4 + 1;
            char c = cArr[i4];
            if (c > '\\') {
                cR0 = c;
            } else if (c == '\\') {
                cR0 = r0();
            } else {
                if (c <= i3) {
                    if (c == i3) {
                        this.q.w(iO);
                        C1876cU c1876cU = this.q;
                        return this.R.h(c1876cU.p(), c1876cU.q(), c1876cU.x(), i2);
                    }
                    if (c < ' ') {
                        U(c, "name");
                    }
                }
                cR0 = c;
            }
            i2 = (i2 * 33) + c;
            int i5 = iO + 1;
            cArrN[iO] = cR0;
            if (i5 >= cArrN.length) {
                cArrN = this.q.m();
                iO = 0;
            } else {
                iO = i5;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0069 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:25:0x0061 A[SYNTHETIC] */
    public final String E0(int i, int i2, int[] iArr) {
        int i3;
        this.q.u(this.Q, i, this.e - i);
        char[] cArrN = this.q.n();
        int iO = this.q.o();
        int length = iArr.length;
        while (true) {
            if (this.e >= this.f && !h0()) {
                break;
            }
            char c = this.Q[this.e];
            if (c <= length) {
                if (iArr[c] != 0) {
                    break;
                }
                this.e++;
                i2 = (i2 * 33) + c;
                i3 = iO + 1;
                cArrN[iO] = c;
                if (i3 >= cArrN.length) {
                    cArrN = this.q.m();
                    iO = 0;
                } else {
                    iO = i3;
                }
            } else {
                if (!Character.isJavaIdentifierPart(c)) {
                    break;
                }
                this.e++;
                i2 = (i2 * 33) + c;
                i3 = iO + 1;
                cArrN[iO] = c;
                if (i3 >= cArrN.length) {
                    cArrN = this.q.m();
                    iO = 0;
                } else {
                    iO = i3;
                }
            }
        }
        this.q.w(iO);
        C1876cU c1876cU = this.q;
        return this.R.h(c1876cU.p(), c1876cU.q(), c1876cU.x(), i2);
    }

    @Override // defpackage.AbstractC3707qG, com.fasterxml.jackson.core.JsonParser
    public String F() throws C4412yu {
        EnumC0431Du enumC0431Du = this.b;
        if (enumC0431Du != EnumC0431Du.VALUE_STRING) {
            return u0(enumC0431Du);
        }
        if (this.T) {
            this.T = false;
            s0();
        }
        return this.q.h();
    }

    public void F0(String str, String str2) throws C4412yu {
        StringBuilder sb = new StringBuilder(str);
        while (true) {
            if (this.e >= this.f && !h0()) {
                break;
            }
            char c = this.Q[this.e];
            if (!Character.isJavaIdentifierPart(c)) {
                break;
            }
            this.e++;
            sb.append(c);
        }
        N("Unrecognized token '" + sb.toString() + "': was expecting ");
    }

    public final void G0() throws C4412yu {
        while (true) {
            if (this.e >= this.f && !h0()) {
                break;
            }
            char[] cArr = this.Q;
            int i = this.e;
            int i2 = i + 1;
            this.e = i2;
            char c = cArr[i];
            if (c <= '*') {
                if (c == '*') {
                    if (i2 >= this.f && !h0()) {
                        break;
                    }
                    char[] cArr2 = this.Q;
                    int i3 = this.e;
                    if (cArr2[i3] == '/') {
                        this.e = i3 + 1;
                        return;
                    }
                } else if (c < ' ') {
                    if (c == '\n') {
                        K0();
                    } else if (c == '\r') {
                        H0();
                    } else if (c != '\t') {
                        T(c);
                    }
                }
            }
        }
        P(" in a comment");
    }

    /* JADX WARN: Code duplicated, block: B:61:0x010e  */
    /* JADX WARN: Code duplicated, block: B:66:0x012c  */
    @Override // defpackage.AbstractC3707qG, com.fasterxml.jackson.core.JsonParser
    public EnumC0431Du H() throws IOException {
        EnumC0431Du enumC0431DuQ0;
        this.x = 0;
        EnumC0431Du enumC0431Du = this.b;
        EnumC0431Du enumC0431Du2 = EnumC0431Du.FIELD_NAME;
        if (enumC0431Du == enumC0431Du2) {
            return A0();
        }
        if (this.T) {
            L0();
        }
        int iN0 = N0();
        if (iN0 < 0) {
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
        if (iN0 == 93) {
            if (!this.n.d()) {
                b0(iN0, '}');
            }
            this.n = this.n.l();
            EnumC0431Du enumC0431Du3 = EnumC0431Du.END_ARRAY;
            this.b = enumC0431Du3;
            return enumC0431Du3;
        }
        if (iN0 == 125) {
            if (!this.n.e()) {
                b0(iN0, ']');
            }
            this.n = this.n.l();
            EnumC0431Du enumC0431Du4 = EnumC0431Du.END_OBJECT;
            this.b = enumC0431Du4;
            return enumC0431Du4;
        }
        if (this.n.j()) {
            if (iN0 != 44) {
                R(iN0, "was expecting comma to separate " + this.n.c() + " entries");
            }
            iN0 = M0();
        }
        boolean zE = this.n.e();
        if (zE) {
            this.n.o(C0(iN0));
            this.b = enumC0431Du2;
            int iM0 = M0();
            if (iM0 != 58) {
                R(iM0, "was expecting a colon to separate field name and value");
            }
            iN0 = M0();
        }
        if (iN0 == 34) {
            this.T = true;
            enumC0431DuQ0 = EnumC0431Du.VALUE_STRING;
        } else if (iN0 == 45) {
            enumC0431DuQ0 = Q0(iN0);
        } else if (iN0 == 91) {
            if (!zE) {
                this.n = this.n.g(this.k, this.l);
            }
            enumC0431DuQ0 = EnumC0431Du.START_ARRAY;
        } else if (iN0 == 93) {
            R(iN0, "expected a value");
            z0(PdfBoolean.TRUE, 1);
            enumC0431DuQ0 = EnumC0431Du.VALUE_TRUE;
        } else if (iN0 == 102) {
            z0(PdfBoolean.FALSE, 1);
            enumC0431DuQ0 = EnumC0431Du.VALUE_FALSE;
        } else if (iN0 == 110) {
            z0("null", 1);
            enumC0431DuQ0 = EnumC0431Du.VALUE_NULL;
        } else if (iN0 == 116) {
            z0(PdfBoolean.TRUE, 1);
            enumC0431DuQ0 = EnumC0431Du.VALUE_TRUE;
        } else if (iN0 == 123) {
            if (!zE) {
                this.n = this.n.h(this.k, this.l);
            }
            enumC0431DuQ0 = EnumC0431Du.START_OBJECT;
        } else if (iN0 != 125) {
            switch (iN0) {
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
                    enumC0431DuQ0 = Q0(iN0);
                    break;
                default:
                    enumC0431DuQ0 = x0(iN0);
                    break;
            }
        } else {
            R(iN0, "expected a value");
            z0(PdfBoolean.TRUE, 1);
            enumC0431DuQ0 = EnumC0431Du.VALUE_TRUE;
        }
        if (zE) {
            this.p = enumC0431DuQ0;
            return this.b;
        }
        this.b = enumC0431DuQ0;
        return enumC0431DuQ0;
    }

    public void H0() {
        if (this.e < this.f || h0()) {
            char[] cArr = this.Q;
            int i = this.e;
            if (cArr[i] == '\n') {
                this.e = i + 1;
            }
        }
        this.h++;
        this.i = this.e;
    }

    public final void I0() throws C4412yu {
        if (!G(JsonParser.Feature.ALLOW_COMMENTS)) {
            R(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        }
        if (this.e >= this.f && !h0()) {
            P(" in a comment");
        }
        char[] cArr = this.Q;
        int i = this.e;
        this.e = i + 1;
        char c = cArr[i];
        if (c == '/') {
            J0();
        } else if (c == '*') {
            G0();
        } else {
            R(c, "was expecting either '*' or '/' for a comment");
        }
    }

    public final void J0() throws C4412yu {
        while (true) {
            if (this.e >= this.f && !h0()) {
                return;
            }
            char[] cArr = this.Q;
            int i = this.e;
            this.e = i + 1;
            char c = cArr[i];
            if (c < ' ') {
                if (c == '\n') {
                    K0();
                    return;
                } else if (c == '\r') {
                    H0();
                    return;
                } else if (c != '\t') {
                    T(c);
                }
            }
        }
    }

    public void K0() {
        this.h++;
        this.i = this.e;
    }

    public void L0() throws C4412yu {
        this.T = false;
        int i = this.e;
        int i2 = this.f;
        char[] cArr = this.Q;
        while (true) {
            if (i >= i2) {
                this.e = i;
                if (!h0()) {
                    P(": was expecting closing quote for a string value");
                }
                i = this.e;
                i2 = this.f;
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c <= '\\') {
                if (c == '\\') {
                    this.e = i3;
                    r0();
                    i = this.e;
                    i2 = this.f;
                } else if (c <= '\"') {
                    if (c == '\"') {
                        this.e = i3;
                        return;
                    } else if (c < ' ') {
                        this.e = i3;
                        U(c, "string value");
                    }
                }
            }
            i = i3;
        }
    }

    public final int M0() throws C4412yu {
        while (true) {
            if (this.e >= this.f && !h0()) {
                throw c("Unexpected end-of-input within/between " + this.n.c() + " entries");
            }
            char[] cArr = this.Q;
            int i = this.e;
            this.e = i + 1;
            char c = cArr[i];
            if (c > ' ') {
                if (c != '/') {
                    return c;
                }
                I0();
            } else if (c != ' ') {
                if (c == '\n') {
                    K0();
                } else if (c == '\r') {
                    H0();
                } else if (c != '\t') {
                    T(c);
                }
            }
        }
    }

    public final int N0() throws C4412yu {
        while (true) {
            if (this.e >= this.f && !h0()) {
                L();
                return -1;
            }
            char[] cArr = this.Q;
            int i = this.e;
            this.e = i + 1;
            char c = cArr[i];
            if (c > ' ') {
                if (c != '/') {
                    return c;
                }
                I0();
            } else if (c != ' ') {
                if (c == '\n') {
                    K0();
                } else if (c == '\r') {
                    H0();
                } else if (c != '\t') {
                    T(c);
                }
            }
        }
    }

    public final char O0() throws C4412yu {
        char c;
        if ((this.e >= this.f && !h0()) || (c = this.Q[this.e]) < '0' || c > '9') {
            return '0';
        }
        if (!G(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS)) {
            j0("Leading zeroes not allowed");
        }
        this.e++;
        if (c == '0') {
            do {
                if (this.e >= this.f && !h0()) {
                    break;
                }
                char[] cArr = this.Q;
                int i = this.e;
                c = cArr[i];
                if (c < '0' || c > '9') {
                    return '0';
                }
                this.e = i + 1;
            } while (c == '0');
        }
        return c;
    }

    public char P0(String str) throws C4412yu {
        if (this.e >= this.f && !h0()) {
            P(str);
        }
        char[] cArr = this.Q;
        int i = this.e;
        this.e = i + 1;
        return cArr[i];
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r15v0 ??, r15v2 ??, r15v17 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public defpackage.EnumC0431Du Q0(
    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r15v0 ??, r15v2 ??, r15v17 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r15v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:215)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        */

    public final EnumC0431Du R0(boolean z) throws C4412yu {
        int i;
        char cP0;
        boolean z2;
        int i2;
        char cP1;
        int i3;
        char[] cArrI = this.q.i();
        int i4 = 0;
        if (z) {
            cArrI[0] = '-';
            i = 1;
        } else {
            i = 0;
        }
        int i5 = this.e;
        if (i5 < this.f) {
            char[] cArr = this.Q;
            this.e = i5 + 1;
            cP0 = cArr[i5];
        } else {
            cP0 = P0("No digit following minus sign");
        }
        if (cP0 == '0') {
            cP0 = O0();
        }
        int i6 = 0;
        while (true) {
            if (cP0 >= '0' && cP0 <= '9') {
                i6++;
                if (i >= cArrI.length) {
                    cArrI = this.q.m();
                    i = 0;
                }
                int i7 = i + 1;
                cArrI[i] = cP0;
                if (this.e >= this.f && !h0()) {
                    i = i7;
                    cP0 = 0;
                    z2 = true;
                    break;
                }
                char[] cArr2 = this.Q;
                int i8 = this.e;
                this.e = i8 + 1;
                cP0 = cArr2[i8];
                i = i7;
            } else {
                z2 = false;
                break;
            }
        }
        if (i6 == 0) {
            j0("Missing integer part (next char " + AbstractC3707qG.K(cP0) + ")");
        }
        if (cP0 == '.') {
            cArrI[i] = cP0;
            i++;
            i2 = 0;
            while (true) {
                if (this.e >= this.f && !h0()) {
                    z2 = true;
                    break;
                }
                char[] cArr3 = this.Q;
                int i9 = this.e;
                this.e = i9 + 1;
                cP0 = cArr3[i9];
                if (cP0 < '0' || cP0 > '9') {
                    break;
                }
                i2++;
                if (i >= cArrI.length) {
                    cArrI = this.q.m();
                    i = 0;
                }
                cArrI[i] = cP0;
                i++;
            }
            if (i2 == 0) {
                m0(cP0, "Decimal point not followed by a digit");
            }
        } else {
            i2 = 0;
        }
        if (cP0 == 'e' || cP0 == 'E') {
            if (i >= cArrI.length) {
                cArrI = this.q.m();
                i = 0;
            }
            int i10 = i + 1;
            cArrI[i] = cP0;
            int i11 = this.e;
            if (i11 < this.f) {
                char[] cArr4 = this.Q;
                this.e = i11 + 1;
                cP1 = cArr4[i11];
            } else {
                cP1 = P0("expected a digit for number exponent");
            }
            if (cP1 == '-' || cP1 == '+') {
                if (i10 >= cArrI.length) {
                    cArrI = this.q.m();
                    i10 = 0;
                }
                int i12 = i10 + 1;
                cArrI[i10] = cP1;
                int i13 = this.e;
                if (i13 < this.f) {
                    char[] cArr5 = this.Q;
                    this.e = i13 + 1;
                    cP1 = cArr5[i13];
                } else {
                    cP1 = P0("expected a digit for number exponent");
                }
                i10 = i12;
            }
            int i14 = 0;
            while (true) {
                if (cP1 <= '9' && cP1 >= '0') {
                    i14++;
                    if (i10 >= cArrI.length) {
                        cArrI = this.q.m();
                        i10 = 0;
                    }
                    i3 = i10 + 1;
                    cArrI[i10] = cP1;
                    if (this.e >= this.f && !h0()) {
                        i4 = i14;
                        z2 = true;
                        break;
                    }
                    char[] cArr6 = this.Q;
                    int i15 = this.e;
                    this.e = i15 + 1;
                    cP1 = cArr6[i15];
                    i10 = i3;
                } else {
                    i4 = i14;
                    i3 = i10;
                    break;
                }
            }
            if (i4 == 0) {
                m0(cP1, "Exponent indicator not followed by a digit");
            }
            i = i3;
        }
        if (!z2) {
            this.e--;
        }
        this.q.w(i);
        return n0(z, i6, i2, i4);
    }

    @Override // defpackage.AbstractC3626pG
    public void W() throws IOException {
        if (this.P != null) {
            if (this.c.h() || G(JsonParser.Feature.AUTO_CLOSE_SOURCE)) {
                this.P.close();
            }
            this.P = null;
        }
    }

    @Override // defpackage.AbstractC3626pG
    public void a0() {
        super.a0();
        char[] cArr = this.Q;
        if (cArr != null) {
            this.Q = null;
            this.c.l(cArr);
        }
    }

    @Override // defpackage.AbstractC3626pG, com.fasterxml.jackson.core.JsonParser, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        this.R.p();
    }

    @Override // defpackage.AbstractC3626pG
    public boolean h0() throws IOException {
        long j = this.g;
        int i = this.f;
        this.g = j + ((long) i);
        this.i -= i;
        Reader reader = this.P;
        if (reader != null) {
            char[] cArr = this.Q;
            int i2 = reader.read(cArr, 0, cArr.length);
            if (i2 > 0) {
                this.e = 0;
                this.f = i2;
                return true;
            }
            W();
            if (i2 == 0) {
                throw new IOException("Reader returned 0 characters when trying to read " + this.f);
            }
        }
        return false;
    }

    public char r0() throws C4412yu {
        if (this.e >= this.f && !h0()) {
            P(" in character escape sequence");
        }
        char[] cArr = this.Q;
        int i = this.e;
        this.e = i + 1;
        char c = cArr[i];
        if (c == '\"' || c == '/' || c == '\\') {
            return c;
        }
        if (c == 'b') {
            return '\b';
        }
        if (c == 'f') {
            return '\f';
        }
        if (c == 'n') {
            return '\n';
        }
        if (c == 'r') {
            return '\r';
        }
        if (c == 't') {
            return '\t';
        }
        if (c != 'u') {
            return M(c);
        }
        int i2 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            if (this.e >= this.f && !h0()) {
                P(" in character escape sequence");
            }
            char[] cArr2 = this.Q;
            int i4 = this.e;
            this.e = i4 + 1;
            char c2 = cArr2[i4];
            int iB = AbstractC3484nb.b(c2);
            if (iB < 0) {
                R(c2, "expected a hex-digit for character escape sequence");
            }
            i2 = (i2 << 4) | iB;
        }
        return (char) i2;
    }

    public void s0() throws C4412yu {
        int i = this.e;
        int i2 = this.f;
        if (i < i2) {
            int[] iArrG = AbstractC3484nb.g();
            int length = iArrG.length;
            do {
                char[] cArr = this.Q;
                char c = cArr[i];
                if (c < length && iArrG[c] != 0) {
                    if (c != '\"') {
                        break;
                    }
                    C1876cU c1876cU = this.q;
                    int i3 = this.e;
                    c1876cU.u(cArr, i3, i - i3);
                    this.e = i + 1;
                    return;
                }
                i++;
            } while (i < i2);
        }
        C1876cU c1876cU2 = this.q;
        char[] cArr2 = this.Q;
        int i4 = this.e;
        c1876cU2.s(cArr2, i4, i - i4);
        this.e = i;
        t0();
    }

    public void t0() throws C4412yu {
        char[] cArrN = this.q.n();
        int iO = this.q.o();
        while (true) {
            if (this.e >= this.f && !h0()) {
                P(": was expecting closing quote for a string value");
            }
            char[] cArr = this.Q;
            int i = this.e;
            this.e = i + 1;
            char cR0 = cArr[i];
            if (cR0 <= '\\') {
                if (cR0 == '\\') {
                    cR0 = r0();
                } else if (cR0 <= '\"') {
                    if (cR0 == '\"') {
                        this.q.w(iO);
                        return;
                    } else if (cR0 < ' ') {
                        U(cR0, "string value");
                    }
                }
            }
            if (iO >= cArrN.length) {
                cArrN = this.q.m();
                iO = 0;
            }
            cArrN[iO] = cR0;
            iO++;
        }
    }

    public String u0(EnumC0431Du enumC0431Du) {
        if (enumC0431Du == null) {
            return null;
        }
        int i = a.a[enumC0431Du.ordinal()];
        if (i != 1) {
            return (i == 2 || i == 3 || i == 4) ? this.q.h() : enumC0431Du.a();
        }
        return this.n.k();
    }

    public EnumC0431Du v0() throws C4412yu {
        char[] cArrI = this.q.i();
        int iO = this.q.o();
        while (true) {
            if (this.e >= this.f && !h0()) {
                P(": was expecting closing quote for a string value");
            }
            char[] cArr = this.Q;
            int i = this.e;
            this.e = i + 1;
            char cR0 = cArr[i];
            if (cR0 <= '\\') {
                if (cR0 == '\\') {
                    cR0 = r0();
                } else if (cR0 <= '\'') {
                    if (cR0 == '\'') {
                        this.q.w(iO);
                        return EnumC0431Du.VALUE_STRING;
                    }
                    if (cR0 < ' ') {
                        U(cR0, "string value");
                    }
                }
            }
            if (iO >= cArrI.length) {
                cArrI = this.q.m();
                iO = 0;
            }
            cArrI[iO] = cR0;
            iO++;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r9v0 ??, r9v1 ??, r9v5 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public defpackage.EnumC0431Du w0(
    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r9v0 ??, r9v1 ??, r9v5 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r9v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:215)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        */

    public EnumC0431Du x0(int i) throws C4412yu {
        if (i != 39) {
            if (i == 43) {
                if (this.e >= this.f && !h0()) {
                    Q();
                }
                char[] cArr = this.Q;
                int i2 = this.e;
                this.e = i2 + 1;
                return w0(cArr[i2], false);
            }
            if (i == 78) {
                z0("NaN", 1);
                if (G(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                    return o0("NaN", Double.NaN);
                }
                N("Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
            }
        } else if (G(JsonParser.Feature.ALLOW_SINGLE_QUOTES)) {
            return v0();
        }
        R(i, "expected a valid value (number, String, array, object, 'true', 'false' or 'null')");
        return null;
    }

    public String y0(int i) throws C4412yu {
        boolean zIsJavaIdentifierPart;
        if (i == 39 && G(JsonParser.Feature.ALLOW_SINGLE_QUOTES)) {
            return B0();
        }
        if (!G(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES)) {
            R(i, "was expecting double-quote to start field name");
        }
        int[] iArrH = AbstractC3484nb.h();
        int length = iArrH.length;
        if (i < length) {
            zIsJavaIdentifierPart = iArrH[i] == 0 && (i < 48 || i > 57);
        } else {
            zIsJavaIdentifierPart = Character.isJavaIdentifierPart((char) i);
        }
        if (!zIsJavaIdentifierPart) {
            R(i, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
        }
        int i2 = this.e;
        int i3 = this.S;
        int i4 = this.f;
        if (i2 < i4) {
            do {
                char[] cArr = this.Q;
                char c = cArr[i2];
                if (c < length) {
                    if (iArrH[c] != 0) {
                        int i5 = this.e - 1;
                        this.e = i2;
                        return this.R.h(cArr, i5, i2 - i5, i3);
                    }
                } else if (!Character.isJavaIdentifierPart(c)) {
                    int i6 = this.e - 1;
                    this.e = i2;
                    return this.R.h(this.Q, i6, i2 - i6, i3);
                }
                i3 = (i3 * 33) + c;
                i2++;
            } while (i2 < i4);
        }
        int i7 = this.e - 1;
        this.e = i2;
        return E0(i7, i3, iArrH);
    }

    public void z0(String str, int i) throws C4412yu {
        int i2;
        char c;
        int length = str.length();
        do {
            if (this.e >= this.f && !h0()) {
                Q();
            }
            if (this.Q[this.e] != str.charAt(i)) {
                F0(str.substring(0, i), "'null', 'true', 'false' or NaN");
            }
            i2 = this.e + 1;
            this.e = i2;
            i++;
        } while (i < length);
        if ((i2 < this.f || h0()) && (c = this.Q[this.e]) >= '0' && c != ']' && c != '}' && Character.isJavaIdentifierPart(c)) {
            F0(str.substring(0, i), "'null', 'true', 'false' or NaN");
        }
    }
}
