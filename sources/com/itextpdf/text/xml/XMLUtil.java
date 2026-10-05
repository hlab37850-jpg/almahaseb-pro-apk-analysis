package com.itextpdf.text.xml;

import com.google.common.primitives.UnsignedBytes;
import com.itextpdf.text.xml.xmp.XmpWriter;

/* JADX INFO: loaded from: classes3.dex */
public class XMLUtil {
    public static String escapeXML(String str, boolean z) {
        char[] charArray = str.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (char c : charArray) {
            if (c == '\"') {
                stringBuffer.append("&quot;");
            } else if (c == '<') {
                stringBuffer.append("&lt;");
            } else if (c == '>') {
                stringBuffer.append("&gt;");
            } else if (c == '&') {
                stringBuffer.append("&amp;");
            } else if (c == '\'') {
                stringBuffer.append("&apos;");
            } else if (isValidCharacterValue(c)) {
                if (!z || c <= 127) {
                    stringBuffer.append(c);
                } else {
                    stringBuffer.append("&#");
                    stringBuffer.append((int) c);
                    stringBuffer.append(';');
                }
            }
        }
        return stringBuffer.toString();
    }

    public static int findInArray(char c, char[] cArr, int i) {
        while (i < cArr.length) {
            if (cArr[i] == ';') {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static String getEncodingName(byte[] bArr) {
        int i = bArr[0] & UnsignedBytes.MAX_VALUE;
        int i2 = bArr[1] & UnsignedBytes.MAX_VALUE;
        if (i == 254 && i2 == 255) {
            return XmpWriter.UTF16BE;
        }
        if (i == 255 && i2 == 254) {
            return XmpWriter.UTF16LE;
        }
        int i3 = bArr[2] & UnsignedBytes.MAX_VALUE;
        if (i == 239 && i2 == 187 && i3 == 191) {
            return XmpWriter.UTF8;
        }
        int i4 = bArr[3] & UnsignedBytes.MAX_VALUE;
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 60) {
            return "ISO-10646-UCS-4";
        }
        if (i == 60 && i2 == 0 && i3 == 0 && i4 == 0) {
            return "ISO-10646-UCS-4";
        }
        if (i == 0 && i2 == 0 && i3 == 60 && i4 == 0) {
            return "ISO-10646-UCS-4";
        }
        if (i == 0 && i2 == 60 && i3 == 0 && i4 == 0) {
            return "ISO-10646-UCS-4";
        }
        if (i == 0 && i2 == 60 && i3 == 0 && i4 == 63) {
            return XmpWriter.UTF16BE;
        }
        if (i == 60 && i2 == 0 && i3 == 63 && i4 == 0) {
            return XmpWriter.UTF16LE;
        }
        return (i == 76 && i2 == 111 && i3 == 167 && i4 == 148) ? "CP037" : XmpWriter.UTF8;
    }

    public static boolean isValidCharacterValue(int i) {
        return i == 9 || i == 10 || i == 13 || (i >= 32 && i <= 55295) || ((i >= 57344 && i <= 65533) || (i >= 65536 && i <= 1114111));
    }

    public static int unescape(String str) {
        if ("apos".equals(str)) {
            return 39;
        }
        if ("quot".equals(str)) {
            return 34;
        }
        if ("lt".equals(str)) {
            return 60;
        }
        if ("gt".equals(str)) {
            return 62;
        }
        return "amp".equals(str) ? 38 : -1;
    }

    public static String unescapeXML(String str) {
        int i;
        int iFindInArray;
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = 0;
        while (i2 < length) {
            char c = charArray[i2];
            if (c != '&' || (iFindInArray = findInArray(';', charArray, i2 + 3)) <= -1) {
                i = c;
                i = c;
                i = c;
                i = c;
                i = c;
                i = c;
                stringBuffer.append((char) i);
                iFindInArray = i2;
            } else {
                String str2 = new String(charArray, i2 + 1, (iFindInArray - i2) - 1);
                if (str2.startsWith("#")) {
                    String strSubstring = str2.substring(1);
                    if (isValidCharacterValue(strSubstring)) {
                        i = c;
                        i = c;
                        char c2 = (char) Integer.parseInt(strSubstring);
                        i2 = iFindInArray;
                        i = c2;
                    } else {
                        i = c;
                        i = c;
                    }
                } else {
                    int iUnescape = unescape(str2);
                    if (iUnescape > 0) {
                        i = c;
                        i = c;
                        i = c;
                        i2 = iFindInArray;
                        i = iUnescape;
                    }
                }
                i = c;
                i = c;
                i = c;
                i = c;
                i = c;
                i = c;
                stringBuffer.append((char) i);
                iFindInArray = i2;
            }
            i2 = iFindInArray + 1;
        }
        return stringBuffer.toString();
    }

    public static boolean isValidCharacterValue(String str) {
        try {
            return isValidCharacterValue(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            return false;
        }
    }
}
