package org.apache.poi.util;

import java.io.PrintStream;

/* JADX INFO: loaded from: classes4.dex */
public class SystemOutLogger extends POILogger {
    private String _cat;

    @Override // org.apache.poi.util.POILogger
    public boolean check(int i) {
        int i2;
        try {
            i2 = Integer.parseInt(System.getProperty("poi.log.level", POILogger.WARN + ""));
        } catch (SecurityException unused) {
            i2 = POILogger.DEBUG;
        }
        return i >= i2;
    }

    @Override // org.apache.poi.util.POILogger
    public void initialize(String str) {
        this._cat = str;
    }

    @Override // org.apache.poi.util.POILogger
    public void log(int i, Object obj) {
        log(i, obj, (Throwable) null);
    }

    @Override // org.apache.poi.util.POILogger
    public void log(int i, Object obj, Throwable th) {
        if (check(i)) {
            PrintStream printStream = System.out;
            printStream.println("[" + this._cat + "] " + obj);
            if (th != null) {
                th.printStackTrace(printStream);
            }
        }
    }
}
