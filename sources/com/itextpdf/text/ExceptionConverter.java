package com.itextpdf.text;

import java.io.PrintStream;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes3.dex */
public class ExceptionConverter extends RuntimeException {
    private static final long serialVersionUID = 8657630363395849399L;
    private Exception ex;
    private String prefix;

    public ExceptionConverter(Exception exc) {
        super(exc);
        this.ex = exc;
        this.prefix = exc instanceof RuntimeException ? "" : "ExceptionConverter: ";
    }

    public static final RuntimeException convertException(Exception exc) {
        return exc instanceof RuntimeException ? (RuntimeException) exc : new ExceptionConverter(exc);
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }

    public Exception getException() {
        return this.ex;
    }

    @Override // java.lang.Throwable
    public String getLocalizedMessage() {
        return this.ex.getLocalizedMessage();
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.ex.getMessage();
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return this.prefix + this.ex;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        synchronized (printStream) {
            printStream.print(this.prefix);
            this.ex.printStackTrace(printStream);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        synchronized (printWriter) {
            printWriter.print(this.prefix);
            this.ex.printStackTrace(printWriter);
        }
    }
}
