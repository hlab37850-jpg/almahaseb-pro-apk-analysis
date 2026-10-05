package com.zebra.sdk.printer.internal;

import com.zebra.sdk.printer.FieldDescriptionData;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class CsvPrinterHelper {
    public static int[] extractFdsByColumnHeading(FieldDescriptionData[] fieldDescriptionDataArr, String[] strArr, int[] iArr) throws UseDefaultMappingException {
        HashMap map = new HashMap();
        for (int i = 0; i < strArr.length; i++) {
            map.put(strArr[i], Integer.valueOf(i));
            if (strArr[i].toLowerCase().equals("quantity")) {
                iArr[0] = i;
            }
        }
        int[] iArr2 = new int[fieldDescriptionDataArr.length];
        for (int i2 = 0; i2 < fieldDescriptionDataArr.length; i2++) {
            Integer num = (Integer) map.get(fieldDescriptionDataArr[i2].fieldName);
            if (num == null) {
                throw new UseDefaultMappingException("Column headings do not match data...cannot sort.");
            }
            iArr2[i2] = num.intValue();
        }
        return iArr2;
    }

    public static Map<String, String> parseSingleLineFormat(String[] strArr) {
        HashMap map = new HashMap();
        Pattern patternCompile = Pattern.compile("(.+)\"(.+)\"");
        for (String str : strArr) {
            Matcher matcher = patternCompile.matcher(str);
            if (matcher.find() && matcher.groupCount() == 2) {
                map.put(matcher.group(2), matcher.group(1));
            }
        }
        return map;
    }
}
