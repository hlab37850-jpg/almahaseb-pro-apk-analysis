package com.zebra.sdk.comm.internal;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ZebraUrlParser {
    public Map<String, String> getVariables(String str) {
        HashMap map = new HashMap();
        if (str != null) {
            String[] strArrSplit = str.trim().split("\\?");
            if (strArrSplit.length >= 2) {
                for (String str2 : strArrSplit[1].split("&")) {
                    String[] strArrSplit2 = str2.split("=");
                    if (strArrSplit2.length == 2) {
                        map.put(strArrSplit2[0], strArrSplit2[1]);
                    }
                }
            }
        }
        return map;
    }
}
