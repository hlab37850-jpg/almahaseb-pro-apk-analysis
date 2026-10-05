package com.itextpdf.text.html;

import com.itextpdf.text.BaseColor;
import com.itextpdf.tool.xml.css.CSS;
import java.util.HashMap;
import java.util.Properties;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class HtmlUtilities {
    public static final float DEFAULT_FONT_SIZE = 12.0f;
    public static final int[] FONTSIZES;
    private static HashMap<String, Float> sizes;

    static {
        HashMap<String, Float> map = new HashMap<>();
        sizes = map;
        map.put(CSS.Value.XX_SMALL, new Float(4.0f));
        sizes.put(CSS.Value.X_SMALL, new Float(6.0f));
        sizes.put("small", new Float(8.0f));
        sizes.put(CSS.Value.MEDIUM, new Float(10.0f));
        sizes.put(CSS.Value.LARGE, new Float(13.0f));
        sizes.put(CSS.Value.X_LARGE, new Float(18.0f));
        sizes.put(CSS.Value.XX_LARGE, new Float(26.0f));
        FONTSIZES = new int[]{8, 10, 12, 14, 18, 24, 36};
    }

    public static int alignmentValue(String str) {
        if (str == null) {
            return -1;
        }
        if ("center".equalsIgnoreCase(str)) {
            return 1;
        }
        if ("left".equalsIgnoreCase(str)) {
            return 0;
        }
        if ("right".equalsIgnoreCase(str)) {
            return 2;
        }
        if ("justify".equalsIgnoreCase(str)) {
            return 3;
        }
        if (HtmlTags.ALIGN_JUSTIFIED_ALL.equalsIgnoreCase(str)) {
            return 8;
        }
        if ("top".equalsIgnoreCase(str)) {
            return 4;
        }
        if (HtmlTags.ALIGN_MIDDLE.equalsIgnoreCase(str)) {
            return 5;
        }
        if ("bottom".equalsIgnoreCase(str)) {
            return 6;
        }
        return HtmlTags.ALIGN_BASELINE.equalsIgnoreCase(str) ? 7 : -1;
    }

    public static BaseColor decodeColor(String str) {
        if (str == null) {
            return null;
        }
        try {
            return WebColors.getRGBColor(str.toLowerCase().trim());
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static String eliminateWhiteSpace(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        boolean z = false;
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '\t') {
                if (cCharAt != '\n') {
                    if (cCharAt != '\r') {
                        if (cCharAt != ' ') {
                            stringBuffer.append(cCharAt);
                            z = false;
                        } else if (!z) {
                            stringBuffer.append(cCharAt);
                        }
                    }
                } else if (i > 0) {
                    stringBuffer.append(' ');
                    z = true;
                }
            }
        }
        return stringBuffer.toString();
    }

    public static int getIndexedFontSize(String str, String str2) {
        int i;
        int length = 0;
        if (str.startsWith("+") || str.startsWith("-")) {
            if (str2 == null) {
                str2 = "12";
            }
            int i2 = (int) Float.parseFloat(str2);
            int length2 = FONTSIZES.length - 1;
            while (true) {
                if (length2 < 0) {
                    length2 = 0;
                    break;
                }
                if (i2 >= FONTSIZES[length2]) {
                    break;
                }
                length2--;
            }
            if (str.startsWith("+")) {
                str = str.substring(1);
            }
            i = Integer.parseInt(str) + length2;
        } else {
            try {
                i = Integer.parseInt(str) - 1;
            } catch (NumberFormatException unused) {
                i = 0;
            }
        }
        if (i >= 0) {
            int[] iArr = FONTSIZES;
            length = i >= iArr.length ? iArr.length - 1 : i;
        }
        return FONTSIZES[length];
    }

    public static Properties parseAttributes(String str) {
        Properties properties = new Properties();
        if (str == null) {
            return properties;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str, ";");
        while (stringTokenizer.hasMoreTokens()) {
            StringTokenizer stringTokenizer2 = new StringTokenizer(stringTokenizer.nextToken(), ":");
            if (stringTokenizer2.hasMoreTokens()) {
                String strTrim = stringTokenizer2.nextToken().trim();
                if (stringTokenizer2.hasMoreTokens()) {
                    String strTrim2 = stringTokenizer2.nextToken().trim();
                    if (strTrim2.startsWith("\"")) {
                        strTrim2 = strTrim2.substring(1);
                    }
                    if (strTrim2.endsWith("\"")) {
                        strTrim2 = strTrim2.substring(0, strTrim2.length() - 1);
                    }
                    properties.setProperty(strTrim.toLowerCase(), strTrim2);
                }
            }
        }
        return properties;
    }

    public static float parseLength(String str) {
        return parseLength(str, 12.0f);
    }

    public static String removeComment(String str, String str2, String str3) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = str3.length();
        int iIndexOf = 0;
        int iIndexOf2 = str.indexOf(str2, 0);
        while (iIndexOf2 > -1) {
            stringBuffer.append(str.substring(iIndexOf, iIndexOf2));
            iIndexOf = str.indexOf(str3, iIndexOf2) + length;
            iIndexOf2 = str.indexOf(str2, iIndexOf);
        }
        stringBuffer.append(str.substring(iIndexOf));
        return stringBuffer.toString();
    }

    public static float parseLength(String str, float f) {
        if (str == null) {
            return 0.0f;
        }
        Float f2 = sizes.get(str.toLowerCase());
        if (f2 != null) {
            return f2.floatValue();
        }
        int length = str.length();
        boolean z = true;
        int i = 0;
        while (z && i < length) {
            switch (str.charAt(i)) {
                case '+':
                case '-':
                case '.':
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    i++;
                    break;
                case ',':
                case '/':
                default:
                    z = false;
                    break;
            }
        }
        if (i == 0) {
            return 0.0f;
        }
        if (i == length) {
            return Float.parseFloat(str + "f");
        }
        float f3 = Float.parseFloat(str.substring(0, i) + "f");
        String strSubstring = str.substring(i);
        if (strSubstring.startsWith(CSS.Value.IN)) {
            return f3 * 72.0f;
        }
        if (strSubstring.startsWith(CSS.Value.CM)) {
            return (f3 / 2.54f) * 72.0f;
        }
        if (strSubstring.startsWith(CSS.Value.MM)) {
            return (f3 / 25.4f) * 72.0f;
        }
        if (strSubstring.startsWith(CSS.Value.PC)) {
            return f3 * 12.0f;
        }
        if (strSubstring.startsWith("em")) {
            return f3 * f;
        }
        return strSubstring.startsWith(CSS.Value.EX) ? (f3 * f) / 2.0f : f3;
    }
}
