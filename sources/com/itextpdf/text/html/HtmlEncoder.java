package com.itextpdf.text.html;

import com.itextpdf.text.BaseColor;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class HtmlEncoder {
    private static final String[] HTML_CODE = new String[256];
    private static final Set<String> NEWLINETAGS;

    static {
        int i;
        int i2;
        for (int i3 = 0; i3 < 10; i3++) {
            HTML_CODE[i3] = "&#00" + i3 + ";";
        }
        int i4 = 10;
        while (true) {
            i = 32;
            if (i4 >= 32) {
                break;
            }
            HTML_CODE[i4] = "&#0" + i4 + ";";
            i4++;
        }
        while (true) {
            if (i >= 128) {
                break;
            }
            HTML_CODE[i] = String.valueOf((char) i);
            i++;
        }
        String[] strArr = HTML_CODE;
        strArr[9] = "\t";
        strArr[10] = "<br />\n";
        strArr[34] = "&quot;";
        strArr[38] = "&amp;";
        strArr[60] = "&lt;";
        strArr[62] = "&gt;";
        for (i2 = 128; i2 < 256; i2++) {
            HTML_CODE[i2] = "&#" + i2 + ";";
        }
        HashSet hashSet = new HashSet();
        NEWLINETAGS = hashSet;
        hashSet.add("p");
        hashSet.add("blockquote");
        hashSet.add("br");
    }

    private HtmlEncoder() {
    }

    public static String encode(String str) {
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt < 256) {
                stringBuffer.append(HTML_CODE[cCharAt]);
            } else {
                stringBuffer.append("&#");
                stringBuffer.append((int) cCharAt);
                stringBuffer.append(';');
            }
        }
        return stringBuffer.toString();
    }

    public static String getAlignment(int i) {
        switch (i) {
            case 0:
                return "left";
            case 1:
                return "center";
            case 2:
                return "right";
            case 3:
            case 8:
                return "justify";
            case 4:
                return "top";
            case 5:
                return HtmlTags.ALIGN_MIDDLE;
            case 6:
                return "bottom";
            case 7:
                return HtmlTags.ALIGN_BASELINE;
            default:
                return "";
        }
    }

    public static boolean isNewLineTag(String str) {
        return NEWLINETAGS.contains(str);
    }

    public static String encode(BaseColor baseColor) {
        StringBuffer stringBuffer = new StringBuffer("#");
        if (baseColor.getRed() < 16) {
            stringBuffer.append('0');
        }
        stringBuffer.append(Integer.toString(baseColor.getRed(), 16));
        if (baseColor.getGreen() < 16) {
            stringBuffer.append('0');
        }
        stringBuffer.append(Integer.toString(baseColor.getGreen(), 16));
        if (baseColor.getBlue() < 16) {
            stringBuffer.append('0');
        }
        stringBuffer.append(Integer.toString(baseColor.getBlue(), 16));
        return stringBuffer.toString();
    }
}
