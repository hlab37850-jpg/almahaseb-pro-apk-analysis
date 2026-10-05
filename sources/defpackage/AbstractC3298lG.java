package defpackage;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: lG, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3298lG {
    public static Map a(String str) {
        HashMap map = new HashMap();
        for (String str2 : str.split("&")) {
            String[] strArrSplit = str2.split("=");
            map.put(AbstractC3179jq.a(strArrSplit[0]), strArrSplit.length > 1 ? AbstractC3179jq.a(strArrSplit[1]) : "");
        }
        return map;
    }

    public static String b(Map map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(AbstractC3179jq.b((String) entry.getKey()));
            sb.append("=");
            sb.append(AbstractC3179jq.b((String) entry.getValue()));
        }
        return sb.toString();
    }
}
