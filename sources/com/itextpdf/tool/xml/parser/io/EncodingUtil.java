package com.itextpdf.tool.xml.parser.io;

import com.itextpdf.text.html.HtmlTags;

/* JADX INFO: loaded from: classes3.dex */
public class EncodingUtil {
    public static String getDeclaredEncoding(String str) {
        int iIndexOf;
        int iIndexOf2;
        int iIndexOf3;
        int i;
        int iIndexOf4;
        if (str == null || (iIndexOf = str.indexOf(HtmlTags.ENCODING)) < 0 || (iIndexOf2 = str.indexOf(34, iIndexOf)) == (iIndexOf3 = str.indexOf(39, iIndexOf))) {
            return null;
        }
        if ((iIndexOf2 < 0 && iIndexOf3 > 0) || (iIndexOf3 > 0 && iIndexOf3 < iIndexOf2)) {
            int i2 = iIndexOf3 + 1;
            int iIndexOf5 = str.indexOf(39, i2);
            if (iIndexOf5 < 0) {
                return null;
            }
            return str.substring(i2, iIndexOf5);
        }
        if (((iIndexOf3 >= 0 || iIndexOf2 <= 0) && (iIndexOf2 <= 0 || iIndexOf2 >= iIndexOf3)) || (iIndexOf4 = str.indexOf(34, (i = iIndexOf2 + 1))) < 0) {
            return null;
        }
        return str.substring(i, iIndexOf4);
    }
}
