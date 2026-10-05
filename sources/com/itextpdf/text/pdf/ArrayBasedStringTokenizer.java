package com.itextpdf.text.pdf;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class ArrayBasedStringTokenizer {
    private final Pattern regex;

    public ArrayBasedStringTokenizer(String[] strArr) {
        this.regex = Pattern.compile(getRegexFromTokens(strArr));
    }

    private String getRegexFromTokens(String[] strArr) {
        StringBuilder sb = new StringBuilder(100);
        for (String str : strArr) {
            sb.append("(");
            sb.append(str);
            sb.append(")|");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    public String[] tokenize(String str) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = this.regex.matcher(str);
        int iEnd = 0;
        while (matcher.find()) {
            String strSubstring = str.substring(iEnd, matcher.start());
            if (strSubstring.length() > 0) {
                arrayList.add(strSubstring);
            }
            arrayList.add(matcher.group());
            iEnd = matcher.end();
        }
        String strSubstring2 = str.substring(iEnd, str.length());
        if (strSubstring2.length() > 0) {
            arrayList.add(strSubstring2);
        }
        return (String[]) arrayList.toArray(new String[0]);
    }
}
