package defpackage;

import com.google.common.net.HttpHeaders;
import java.util.Map;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;

/* JADX INFO: renamed from: Ir, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0606Ir {
    public static InterfaceC2339h9.a a(C3865sD c3865sD) {
        long j;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Map map = c3865sD.c;
        String str = (String) map.get(HttpHeaders.DATE);
        long j2 = 0;
        long jC = str != null ? c(str) : 0L;
        String str2 = (String) map.get(HttpHeaders.CACHE_CONTROL);
        int i = 0;
        if (str2 != null) {
            String[] strArrSplit = str2.split(",");
            j = 0;
            while (i < strArrSplit.length) {
                String strTrim = strArrSplit[i].trim();
                if (strTrim.equals("no-cache") || strTrim.equals("no-store")) {
                    return null;
                }
                if (strTrim.startsWith("max-age=")) {
                    try {
                        j = Long.parseLong(strTrim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (strTrim.equals("must-revalidate") || strTrim.equals("proxy-revalidate")) {
                    j = 0;
                }
                i++;
            }
            i = 1;
        } else {
            j = 0;
        }
        String str3 = (String) map.get(HttpHeaders.EXPIRES);
        long jC2 = str3 != null ? c(str3) : 0L;
        String str4 = (String) map.get(HttpHeaders.ETAG);
        if (i != 0) {
            j2 = jCurrentTimeMillis + (j * 1000);
        } else if (jC > 0 && jC2 >= jC) {
            j2 = jCurrentTimeMillis + (jC2 - jC);
        }
        InterfaceC2339h9.a aVar = new InterfaceC2339h9.a();
        aVar.a = c3865sD.b;
        aVar.b = str4;
        aVar.e = j2;
        aVar.d = j2;
        aVar.c = jC;
        aVar.f = map;
        return aVar;
    }

    public static String b(Map map) {
        String str = (String) map.get(HttpHeaders.CONTENT_TYPE);
        if (str == null) {
            return "ISO-8859-1";
        }
        String[] strArrSplit = str.split(";");
        for (int i = 1; i < strArrSplit.length; i++) {
            String[] strArrSplit2 = strArrSplit[i].trim().split("=");
            if (strArrSplit2.length == 2 && strArrSplit2[0].equals("charset")) {
                return strArrSplit2[1];
            }
        }
        return "ISO-8859-1";
    }

    public static long c(String str) {
        try {
            return DateUtils.parseDate(str).getTime();
        } catch (DateParseException unused) {
            return 0L;
        }
    }
}
