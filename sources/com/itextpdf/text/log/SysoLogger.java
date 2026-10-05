package com.itextpdf.text.log;

import java.io.PrintStream;

/* JADX INFO: loaded from: classes3.dex */
public class SysoLogger implements Logger {
    private String name;
    private final int shorten;

    public SysoLogger() {
        this(1);
    }

    private String shorten(String str) {
        if (this.shorten == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        int iIndexOf = str.indexOf(46);
        String strSubstring = str;
        while (iIndexOf != -1) {
            int i = this.shorten;
            if (iIndexOf < i) {
                i = iIndexOf;
            }
            sb.append(strSubstring.substring(0, i));
            sb.append('.');
            strSubstring = strSubstring.substring(iIndexOf + 1);
            iIndexOf = strSubstring.indexOf(46);
        }
        sb.append(str.substring(str.lastIndexOf(46) + 1));
        return sb.toString();
    }

    @Override // com.itextpdf.text.log.Logger
    public void debug(String str) {
        System.out.println(String.format("%s DEBUG %s", shorten(this.name), str));
    }

    @Override // com.itextpdf.text.log.Logger
    public void error(String str) {
        System.out.println(String.format("%s ERROR %s", this.name, str));
    }

    @Override // com.itextpdf.text.log.Logger
    public Logger getLogger(Class<?> cls) {
        return new SysoLogger(cls.getName(), this.shorten);
    }

    @Override // com.itextpdf.text.log.Logger
    public void info(String str) {
        System.out.println(String.format("%s INFO  %s", shorten(this.name), str));
    }

    @Override // com.itextpdf.text.log.Logger
    public boolean isLogging(Level level) {
        return true;
    }

    @Override // com.itextpdf.text.log.Logger
    public void trace(String str) {
        System.out.println(String.format("%s TRACE %s", shorten(this.name), str));
    }

    @Override // com.itextpdf.text.log.Logger
    public void warn(String str) {
        System.out.println(String.format("%s WARN  %s", shorten(this.name), str));
    }

    public SysoLogger(int i) {
        this.shorten = i;
    }

    @Override // com.itextpdf.text.log.Logger
    public void error(String str, Exception exc) {
        PrintStream printStream = System.out;
        printStream.println(String.format("%s ERROR %s", this.name, str));
        exc.printStackTrace(printStream);
    }

    @Override // com.itextpdf.text.log.Logger
    public Logger getLogger(String str) {
        return new SysoLogger("[itext]", 0);
    }

    public SysoLogger(String str, int i) {
        this.shorten = i;
        this.name = str;
    }
}
