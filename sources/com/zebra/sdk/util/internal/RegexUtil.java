package com.zebra.sdk.util.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class RegexUtil {
    public static List<String> getMatches(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = Pattern.compile(str).matcher(str2);
        if (matcher.find()) {
            for (int i = 0; i <= matcher.groupCount(); i++) {
                arrayList.add(matcher.group(i));
            }
        }
        return arrayList;
    }
}
