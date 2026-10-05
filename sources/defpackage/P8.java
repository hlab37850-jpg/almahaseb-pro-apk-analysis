package defpackage;

import android.content.res.Resources;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.poi.hssf.usermodel.HSSFFont;

/* JADX INFO: loaded from: classes3.dex */
public class P8 extends KV {
    public static Properties v;
    public static Resources w;
    public static String x;
    public static final String[] y = {"Courier", "Courier-Bold", "Courier-BoldOblique", "Courier-Oblique", "Helvetica", "Helvetica-Bold", "Helvetica-BoldOblique", "Helvetica-Oblique", "Times-Roman", "Times-Bold", "Times-BoldItalic", "Times-Italic", "Symbol", "ZapfDingbats"};
    public static final String[] z = {HSSFFont.FONT_ARIAL, "Helvetica", "Arial,Bold", "Helvetica-Bold", "Arial,BoldItalic", "Helvetica-BoldOblique", "Arial,Italic", "Helvetica-Oblique", "TimesNewRoman", "Times-Roman", "TimesNewRoman,Bold", "Times-Bold", "TimesNewRoman,BoldItalic", "Times-BoldItalic", "TimesNewRoman,Italic", "Times-Italic"};

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    public P8(String str, BF bf, C4029uF c4029uF) throws IOException {
        ?? r3;
        String str2;
        super(str, bf, c4029uF);
        String strE = c4029uF.e();
        int i = 0;
        while (true) {
            String[] strArr = y;
            if (i >= strArr.length) {
                int i2 = 0;
                while (true) {
                    String[] strArr2 = z;
                    if (i2 >= strArr2.length) {
                        int iA = c4029uF.a();
                        boolean z2 = strE.indexOf("Bold") <= 0 ? (262144 & iA) != 0 : true;
                        if (c4029uF.f() != 0 || (iA & 32) != 0) {
                            r3 = z2;
                            r3 = (z2 ? 1 : 0) | 2;
                        }
                        r3 = z2;
                        if ((iA & 1) != 0) {
                            int i3 = r3 & 1;
                            str2 = (i3 <= 0 || (r3 & 2) <= 0) ? i3 > 0 ? "Courier-Bold" : (r3 & 2) > 0 ? "Courier-Oblique" : "Courier" : "Courier-BoldOblique";
                        } else if ((iA & 2) != 0) {
                            int i4 = r3 & 1;
                            str2 = (i4 <= 0 || (r3 & 2) <= 0) ? i4 > 0 ? "Times-Bold" : (r3 & 2) > 0 ? "Times-Italic" : "Times-Roman" : "Times-BoldItalic";
                        } else {
                            int i5 = r3 & 1;
                            str2 = (i5 <= 0 || (r3 & 2) <= 0) ? i5 > 0 ? "Helvetica-Bold" : (r3 & 2) > 0 ? "Helvetica-Oblique" : "Helvetica" : "Helvetica-BoldOblique";
                        }
                        E(str2);
                        return;
                    }
                    if (strE.equalsIgnoreCase(strArr2[i2])) {
                        E(strArr2[i2 + 1]);
                        return;
                    }
                    i2 += 2;
                }
            } else {
                if (strE.equalsIgnoreCase(strArr[i])) {
                    E(strE);
                    return;
                }
                i++;
            }
        }
    }

    public final void E(String str) throws IOException {
        int i;
        int i2;
        if (v == null) {
            Properties properties = new Properties();
            v = properties;
            try {
                properties.load(P8.class.getResourceAsStream("res/BaseFonts.properties"));
            } catch (NullPointerException unused) {
                Properties properties2 = v;
                Resources resources = w;
                properties2.load(resources.openRawResource(resources.getIdentifier("basefonts", "raw", x)));
            }
        }
        if (!v.containsKey(String.valueOf(str) + ".file")) {
            throw new IllegalArgumentException("Unknown Base Font: " + str);
        }
        String property = v.getProperty(String.valueOf(str) + ".file");
        int i3 = Integer.parseInt(v.getProperty(String.valueOf(str) + ".length"));
        byte[] bArr = new byte[i3];
        InputStream resourceAsStream = P8.class.getResourceAsStream("res/" + property);
        if (resourceAsStream == null) {
            Resources resources2 = w;
            resourceAsStream = resources2.openRawResource(resources2.getIdentifier(property.substring(0, property.indexOf(46)), "raw", x));
        }
        for (int i4 = 0; i4 < i3; i4 += resourceAsStream.read(bArr, i4, i3 - i4)) {
        }
        resourceAsStream.close();
        if ((bArr[0] & UnsignedBytes.MAX_VALUE) == 128) {
            int i5 = (bArr[2] & UnsignedBytes.MAX_VALUE) | ((bArr[3] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr[4] & UnsignedBytes.MAX_VALUE) << 16) | ((bArr[5] & UnsignedBytes.MAX_VALUE) << 24);
            i = (bArr[i5 + 8] & UnsignedBytes.MAX_VALUE) | ((bArr[i5 + 9] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr[i5 + 10] & UnsignedBytes.MAX_VALUE) << 16) | ((bArr[i5 + 11] & UnsignedBytes.MAX_VALUE) << 24);
            i2 = i5 + 12;
        } else {
            int i6 = Integer.parseInt(v.getProperty(String.valueOf(str) + ".length1"));
            i = v.containsKey(String.valueOf(str) + ".length2") ? Integer.parseInt(v.getProperty(String.valueOf(str) + ".lenth2")) : i3 - i6;
            i2 = i6;
        }
        w(bArr, i2, i);
    }
}
