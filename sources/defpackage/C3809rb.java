package defpackage;

import com.itextpdf.text.xml.xmp.XmpWriter;
import java.nio.charset.Charset;

/* JADX INFO: renamed from: rb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3809rb {
    public static final C3809rb a = new C3809rb();
    public static final Charset b;
    public static final Charset c;
    public static final Charset d;
    public static final Charset e;
    public static final Charset f;
    public static final Charset g;
    public static volatile Charset h;
    public static volatile Charset i;

    static {
        Charset charsetForName = Charset.forName(XmpWriter.UTF8);
        AbstractC4492zt.g(charsetForName, "forName(...)");
        b = charsetForName;
        Charset charsetForName2 = Charset.forName(XmpWriter.UTF16);
        AbstractC4492zt.g(charsetForName2, "forName(...)");
        c = charsetForName2;
        Charset charsetForName3 = Charset.forName(XmpWriter.UTF16BE);
        AbstractC4492zt.g(charsetForName3, "forName(...)");
        d = charsetForName3;
        Charset charsetForName4 = Charset.forName(XmpWriter.UTF16LE);
        AbstractC4492zt.g(charsetForName4, "forName(...)");
        e = charsetForName4;
        Charset charsetForName5 = Charset.forName("US-ASCII");
        AbstractC4492zt.g(charsetForName5, "forName(...)");
        f = charsetForName5;
        Charset charsetForName6 = Charset.forName("ISO-8859-1");
        AbstractC4492zt.g(charsetForName6, "forName(...)");
        g = charsetForName6;
    }

    public final Charset a() {
        Charset charset = i;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32BE");
        AbstractC4492zt.g(charsetForName, "forName(...)");
        i = charsetForName;
        return charsetForName;
    }

    public final Charset b() {
        Charset charset = h;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32LE");
        AbstractC4492zt.g(charsetForName, "forName(...)");
        h = charsetForName;
        return charsetForName;
    }
}
