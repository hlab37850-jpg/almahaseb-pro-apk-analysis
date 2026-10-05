package defpackage;

import com.fasterxml.jackson.core.JsonParser;

/* JADX INFO: renamed from: qG, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC3707qG extends JsonParser {
    public EnumC0431Du b;

    /* JADX INFO: renamed from: qG$a */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC0431Du.values().length];
            a = iArr;
            try {
                iArr[EnumC0431Du.START_OBJECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[EnumC0431Du.START_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[EnumC0431Du.END_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[EnumC0431Du.END_ARRAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[EnumC0431Du.VALUE_NUMBER_INT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[EnumC0431Du.VALUE_TRUE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[EnumC0431Du.VALUE_FALSE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[EnumC0431Du.VALUE_NULL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[EnumC0431Du.VALUE_EMBEDDED_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[EnumC0431Du.VALUE_STRING.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[EnumC0431Du.VALUE_NUMBER_FLOAT.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public static final String K(int i) {
        char c = (char) i;
        if (Character.isISOControl(c)) {
            return "(CTRL-CHAR, code " + i + ")";
        }
        if (i <= 255) {
            return "'" + c + "' (code " + i + ")";
        }
        return "'" + c + "' (code " + i + " / 0x" + Integer.toHexString(i) + ")";
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public abstract String F();

    @Override // com.fasterxml.jackson.core.JsonParser
    public abstract EnumC0431Du H();

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonParser I() {
        EnumC0431Du enumC0431Du = this.b;
        if (enumC0431Du != EnumC0431Du.START_OBJECT && enumC0431Du != EnumC0431Du.START_ARRAY) {
            return this;
        }
        int i = 1;
        while (true) {
            EnumC0431Du enumC0431DuH = H();
            if (enumC0431DuH == null) {
                L();
                return this;
            }
            int i2 = a.a[enumC0431DuH.ordinal()];
            if (i2 == 1 || i2 == 2) {
                i++;
            } else if (i2 == 3 || i2 == 4) {
                i--;
                if (i == 0) {
                    return this;
                }
            }
        }
    }

    public final C4412yu J(String str, Throwable th) {
        return new C4412yu(str, i(), th);
    }

    public abstract void L();

    public char M(char c) throws C4412yu {
        if (G(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER)) {
            return c;
        }
        if (c == '\'' && G(JsonParser.Feature.ALLOW_SINGLE_QUOTES)) {
            return c;
        }
        N("Unrecognized character escape " + K(c));
        return c;
    }

    public final void N(String str) throws C4412yu {
        throw c(str);
    }

    public void O() throws C4412yu {
        P(" in " + this.b);
    }

    public void P(String str) throws C4412yu {
        N("Unexpected end-of-input" + str);
    }

    public void Q() throws C4412yu {
        P(" in a value");
    }

    public void R(int i, String str) throws C4412yu {
        String str2 = "Unexpected character (" + K(i) + ")";
        if (str != null) {
            str2 = str2 + ": " + str;
        }
        N(str2);
    }

    public final void S() {
        throw new RuntimeException("Internal error: this code path should never get executed");
    }

    public void T(int i) throws C4412yu {
        N("Illegal character (" + K((char) i) + "): only regular white space (\\r, \\n, \\t) is allowed between tokens");
    }

    public void U(int i, String str) throws C4412yu {
        if (!G(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS) || i >= 32) {
            N("Illegal unquoted character (" + K((char) i) + "): has to be escaped using backslash to be included in " + str);
        }
    }

    public final void V(String str, Throwable th) throws C4412yu {
        throw J(str, th);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public EnumC0431Du t() {
        return this.b;
    }
}
