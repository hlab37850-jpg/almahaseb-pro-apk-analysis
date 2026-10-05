package defpackage;

import android.util.Log;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public final class S3 {
    public static final S3 a = new S3();
    public static final CopyOnWriteArraySet b = new CopyOnWriteArraySet();
    public static final Map c;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Package r2 = C4271xE.class.getPackage();
        String name = r2 != null ? r2.getName() : null;
        if (name != null) {
            linkedHashMap.put(name, "OkHttp");
        }
        String name2 = C4271xE.class.getName();
        AbstractC4492zt.g(name2, "OkHttpClient::class.java.name");
        linkedHashMap.put(name2, "okhttp.OkHttpClient");
        String name3 = C0376Br.class.getName();
        AbstractC4492zt.g(name3, "Http2::class.java.name");
        linkedHashMap.put(name3, "okhttp.Http2");
        String name4 = ET.class.getName();
        AbstractC4492zt.g(name4, "TaskRunner::class.java.name");
        linkedHashMap.put(name4, "okhttp.TaskRunner");
        linkedHashMap.put("okhttp3.mockwebserver.MockWebServer", "okhttp.MockWebServer");
        c = AbstractC4243wx.s(linkedHashMap);
    }

    public final void a(String str, int i, String str2, Throwable th) {
        int iMin;
        AbstractC4492zt.h(str, "loggerName");
        AbstractC4492zt.h(str2, "message");
        String strD = d(str);
        if (Log.isLoggable(strD, i)) {
            if (th != null) {
                str2 = str2 + '\n' + Log.getStackTraceString(th);
            }
            int length = str2.length();
            int i2 = 0;
            while (i2 < length) {
                int iQ = AbstractC3961tS.Q(str2, '\n', i2, false, 4, null);
                if (iQ == -1) {
                    iQ = length;
                }
                while (true) {
                    iMin = Math.min(iQ, i2 + 4000);
                    String strSubstring = str2.substring(i2, iMin);
                    AbstractC4492zt.g(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    Log.println(i, strD, strSubstring);
                    if (iMin >= iQ) {
                        break;
                    } else {
                        i2 = iMin;
                    }
                }
                i2 = iMin + 1;
            }
        }
    }

    public final void b() {
        for (Map.Entry entry : c.entrySet()) {
            c((String) entry.getKey(), (String) entry.getValue());
        }
    }

    public final void c(String str, String str2) {
        Level level;
        Logger logger = Logger.getLogger(str);
        if (b.add(logger)) {
            logger.setUseParentHandlers(false);
            if (Log.isLoggable(str2, 3)) {
                level = Level.FINE;
            } else {
                level = Log.isLoggable(str2, 4) ? Level.INFO : Level.WARNING;
            }
            logger.setLevel(level);
            logger.addHandler(T3.a);
        }
    }

    public final String d(String str) {
        String str2 = (String) c.get(str);
        return str2 == null ? AbstractC4123vS.G0(str, 23) : str2;
    }
}
