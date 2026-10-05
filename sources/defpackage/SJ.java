package defpackage;

import com.itextpdf.tool.xml.html.HTML;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class SJ implements Serializable {
    public static final a b = new a(null);
    public final Pattern a;

    public static final class a {
        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public a() {
        }
    }

    public SJ(Pattern pattern) {
        AbstractC4492zt.h(pattern, "nativePattern");
        this.a = pattern;
    }

    public static /* synthetic */ InterfaceC0434Dx b(SJ sj, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return sj.a(charSequence, i);
    }

    public final InterfaceC0434Dx a(CharSequence charSequence, int i) {
        AbstractC4492zt.h(charSequence, HTML.Tag.INPUT);
        Matcher matcher = this.a.matcher(charSequence);
        AbstractC4492zt.g(matcher, "matcher(...)");
        return TJ.c(matcher, i, charSequence);
    }

    public final boolean c(CharSequence charSequence) {
        AbstractC4492zt.h(charSequence, HTML.Tag.INPUT);
        return this.a.matcher(charSequence).matches();
    }

    public final String e(CharSequence charSequence, String str) {
        AbstractC4492zt.h(charSequence, HTML.Tag.INPUT);
        AbstractC4492zt.h(str, "replacement");
        String strReplaceAll = this.a.matcher(charSequence).replaceAll(str);
        AbstractC4492zt.g(strReplaceAll, "replaceAll(...)");
        return strReplaceAll;
    }

    public final String f(CharSequence charSequence, String str) {
        AbstractC4492zt.h(charSequence, HTML.Tag.INPUT);
        AbstractC4492zt.h(str, "replacement");
        String strReplaceFirst = this.a.matcher(charSequence).replaceFirst(str);
        AbstractC4492zt.g(strReplaceFirst, "replaceFirst(...)");
        return strReplaceFirst;
    }

    public String toString() {
        String string = this.a.toString();
        AbstractC4492zt.g(string, "toString(...)");
        return string;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SJ(String str) {
        AbstractC4492zt.h(str, "pattern");
        Pattern patternCompile = Pattern.compile(str);
        AbstractC4492zt.g(patternCompile, "compile(...)");
        this(patternCompile);
    }
}
