package androidx.compose.material3;

import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC3880sS;
import defpackage.AbstractC3961tS;
import defpackage.AbstractC4492zt;
import defpackage.C0382Bx;
import defpackage.InterfaceC0434Dx;
import defpackage.SJ;

/* JADX INFO: loaded from: classes.dex */
public final class CalendarModelKt {
    public static final int DaysInWeek = 7;
    public static final long MillisecondsIn24Hours = 86400000;

    @ExperimentalMaterial3Api
    public static final DateInputFormat datePatternAsInputFormat(String str) {
        AbstractC4492zt.h(str, "localeFormat");
        String strH0 = AbstractC3961tS.h0(AbstractC3880sS.x(new SJ("y{1,4}").e(new SJ("M{1,2}").e(new SJ("d{1,2}").e(new SJ("[^dMy/\\-.]").e(str, ""), HTML.Tag.DD), "MM"), "yyyy"), "My", "M/y", false, 4, null), ".");
        InterfaceC0434Dx interfaceC0434DxB = SJ.b(new SJ("[/\\-.]"), strH0, 0, 2, null);
        AbstractC4492zt.e(interfaceC0434DxB);
        C0382Bx c0382Bx = interfaceC0434DxB.a().get(0);
        AbstractC4492zt.e(c0382Bx);
        int iB = c0382Bx.a().b();
        String strSubstring = strH0.substring(iB, iB + 1);
        AbstractC4492zt.g(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return new DateInputFormat(strH0, strSubstring.charAt(0));
    }
}
