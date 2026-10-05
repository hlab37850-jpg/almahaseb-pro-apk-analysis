package defpackage;

import com.itextpdf.text.xml.xmp.XmpWriter;

/* JADX INFO: renamed from: uu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public enum EnumC4078uu {
    UTF8(XmpWriter.UTF8, false),
    UTF16_BE(XmpWriter.UTF16BE, true),
    UTF16_LE(XmpWriter.UTF16LE, false),
    UTF32_BE("UTF-32BE", true),
    UTF32_LE("UTF-32LE", false);

    public final String a;
    public final boolean b;

    EnumC4078uu(String str, boolean z) {
        this.a = str;
        this.b = z;
    }

    public String a() {
        return this.a;
    }

    public boolean b() {
        return this.b;
    }
}
