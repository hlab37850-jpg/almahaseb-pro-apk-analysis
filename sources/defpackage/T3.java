package defpackage;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

/* JADX INFO: loaded from: classes3.dex */
public final class T3 extends Handler {
    public static final T3 a = new T3();

    @Override // java.util.logging.Handler
    public void publish(LogRecord logRecord) {
        AbstractC4492zt.h(logRecord, "record");
        S3 s3 = S3.a;
        String loggerName = logRecord.getLoggerName();
        AbstractC4492zt.g(loggerName, "record.loggerName");
        int iB = U3.b(logRecord);
        String message = logRecord.getMessage();
        AbstractC4492zt.g(message, "record.message");
        s3.a(loggerName, iB, message, logRecord.getThrown());
    }

    @Override // java.util.logging.Handler
    public void close() {
    }

    @Override // java.util.logging.Handler
    public void flush() {
    }
}
