package com.itextpdf.tool.xml.html;

import com.itextpdf.text.Chunk;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class HTMLUtils {
    private static List<Chunk> sanitize(String str, boolean z, boolean z2) {
        StringBuilder sb;
        Object obj;
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        char[] charArray = str.toCharArray();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        boolean zIsWhitespace = charArray.length > 0 ? Character.isWhitespace(charArray[0]) : true;
        int length = charArray.length;
        StringBuilder sb4 = sb3;
        while (i < length) {
            char c = charArray[i];
            if (zIsWhitespace && !Character.isWhitespace(c)) {
                if (sb2.length() == 0) {
                    sb = sb4;
                    sb = sb4;
                    obj = sb4;
                    arrayList.add(Chunk.createWhitespace(sb4.toString(), z));
                } else {
                    if (!z) {
                        obj = " ";
                    }
                    sb2.append((CharSequence) obj);
                }
                sb = new StringBuilder();
            }
            sb = sb4;
            sb = sb4;
            sb = sb4;
            zIsWhitespace = Character.isWhitespace(c);
            if (zIsWhitespace) {
                sb.append(c);
            } else {
                sb2.append(c);
            }
            i++;
            sb4 = sb;
        }
        if (sb2.length() > 0) {
            arrayList.add(new Chunk(z2 ? sb2.toString().replace((char) 160, ' ') : sb2.toString()));
        }
        if (sb4.length() > 0) {
            arrayList.add(Chunk.createWhitespace(sb4.toString(), z));
        }
        return arrayList;
    }

    public static List<Chunk> sanitizeInline(String str, boolean z) {
        return sanitize(str, z, false);
    }

    public static List<Chunk> sanitizeInline(String str, boolean z, boolean z2) {
        return sanitize(str, z, z2);
    }

    public static List<Chunk> sanitize(String str, boolean z) {
        return sanitize(str, z, false);
    }
}
