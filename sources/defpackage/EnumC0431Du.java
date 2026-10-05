package defpackage;

import com.itextpdf.text.pdf.PdfBoolean;

/* JADX INFO: renamed from: Du, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public enum EnumC0431Du {
    NOT_AVAILABLE(null),
    START_OBJECT("{"),
    END_OBJECT("}"),
    START_ARRAY("["),
    END_ARRAY("]"),
    FIELD_NAME(null),
    VALUE_EMBEDDED_OBJECT(null),
    VALUE_STRING(null),
    VALUE_NUMBER_INT(null),
    VALUE_NUMBER_FLOAT(null),
    VALUE_TRUE(PdfBoolean.TRUE),
    VALUE_FALSE(PdfBoolean.FALSE),
    VALUE_NULL("null");

    public final String a;
    public final char[] b;
    public final byte[] c;

    EnumC0431Du(String str) {
        if (str == null) {
            this.a = null;
            this.b = null;
            this.c = null;
            return;
        }
        this.a = str;
        char[] charArray = str.toCharArray();
        this.b = charArray;
        int length = charArray.length;
        this.c = new byte[length];
        for (int i = 0; i < length; i++) {
            this.c[i] = (byte) this.b[i];
        }
    }

    public String a() {
        return this.a;
    }
}
