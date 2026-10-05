package defpackage;

import java.net.ProtocolException;

/* JADX INFO: renamed from: eS, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C2113eS {
    public static final a d = new a(null);
    public final EnumC4356yI a;
    public final int b;
    public final String c;

    /* JADX INFO: renamed from: eS$a */
    public static final class a {
        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final C2113eS a(String str) throws ProtocolException {
            EnumC4356yI enumC4356yI;
            int i;
            String strSubstring;
            AbstractC4492zt.h(str, "statusLine");
            if (AbstractC3880sS.B(str, "HTTP/1.", false, 2, null)) {
                i = 9;
                if (str.length() < 9 || str.charAt(8) != ' ') {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                int iCharAt = str.charAt(7) - '0';
                if (iCharAt == 0) {
                    enumC4356yI = EnumC4356yI.HTTP_1_0;
                } else {
                    if (iCharAt != 1) {
                        throw new ProtocolException("Unexpected status line: " + str);
                    }
                    enumC4356yI = EnumC4356yI.HTTP_1_1;
                }
            } else {
                if (!AbstractC3880sS.B(str, "ICY ", false, 2, null)) {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                enumC4356yI = EnumC4356yI.HTTP_1_0;
                i = 4;
            }
            int i2 = i + 3;
            if (str.length() < i2) {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            try {
                String strSubstring2 = str.substring(i, i2);
                AbstractC4492zt.g(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                int i3 = Integer.parseInt(strSubstring2);
                if (str.length() <= i2) {
                    strSubstring = "";
                } else {
                    if (str.charAt(i2) != ' ') {
                        throw new ProtocolException("Unexpected status line: " + str);
                    }
                    strSubstring = str.substring(i + 4);
                    AbstractC4492zt.g(strSubstring, "this as java.lang.String).substring(startIndex)");
                }
                return new C2113eS(enumC4356yI, i3, strSubstring);
            } catch (NumberFormatException unused) {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        }

        public a() {
        }
    }

    public C2113eS(EnumC4356yI enumC4356yI, int i, String str) {
        AbstractC4492zt.h(enumC4356yI, "protocol");
        AbstractC4492zt.h(str, "message");
        this.a = enumC4356yI;
        this.b = i;
        this.c = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.a == EnumC4356yI.HTTP_1_0) {
            sb.append("HTTP/1.0");
        } else {
            sb.append("HTTP/1.1");
        }
        sb.append(' ');
        sb.append(this.b);
        sb.append(' ');
        sb.append(this.c);
        String string = sb.toString();
        AbstractC4492zt.g(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
