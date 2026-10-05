package com.itextpdf.text.log;

/* JADX INFO: loaded from: classes3.dex */
public class LoggerFactory {
    private static LoggerFactory myself = new LoggerFactory();
    private Logger logger = new NoOpLogger();

    private LoggerFactory() {
    }

    public static LoggerFactory getInstance() {
        return myself;
    }

    public static Logger getLogger(Class<?> cls) {
        return myself.logger.getLogger(cls);
    }

    public Logger logger() {
        return this.logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public static Logger getLogger(String str) {
        return myself.logger.getLogger(str);
    }
}
