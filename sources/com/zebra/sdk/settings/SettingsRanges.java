package com.zebra.sdk.settings;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.type.TypeReference;
import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.printer.LinkOsInformation;
import com.zebra.sdk.printer.PrinterLanguage;
import com.zebra.sdk.printer.operations.internal.SendJsonOperation;
import com.zebra.sdk.util.internal.JacksonObjectMapperFactory;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class SettingsRanges {

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.ANY)
    public static class Range {
        String range;

        public Range() {
            this.range = null;
        }

        public String getRange() {
            return this.range;
        }

        public void setRange(String str) {
            this.range = str;
        }

        public Range(String str) {
            this.range = str;
        }
    }

    private SettingsRanges() {
    }

    public static Map<String, String> getRanges(List<String> list, Connection connection, PrinterLanguage printerLanguage, LinkOsInformation linkOsInformation) {
        if (linkOsInformation.getMajor() < 3 || (linkOsInformation.getMajor() == 3 && linkOsInformation.getMinor() < 2)) {
            throw new IllegalStateException("Not supported for LinkOS versions less than 3.2");
        }
        Iterator<String> it = list.iterator();
        String strSubstring = "";
        while (it.hasNext()) {
            strSubstring = strSubstring + "\"" + it.next() + "\",";
        }
        if (strSubstring.length() > 0) {
            strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
        }
        SendJsonOperation sendJsonOperation = new SendJsonOperation(connection, printerLanguage, String.format("{}{'get':{ 'field': ['range'], 'name': [%s] }}".replace("'", "\""), strSubstring));
        new HashMap();
        return parseJsonForRanges(sendJsonOperation.execute());
    }

    public static Map<String, String> parseJsonForRanges(String str) {
        Map map = (Map) JacksonObjectMapperFactory.getInstance().readValue(str, new TypeReference() { // from class: com.zebra.sdk.settings.SettingsRanges.1
        });
        HashMap map2 = new HashMap();
        for (String str2 : map.keySet()) {
            Range range = (Range) map.get(str2);
            map2.put(str2, range != null ? range.getRange() : null);
        }
        return map2;
    }
}
