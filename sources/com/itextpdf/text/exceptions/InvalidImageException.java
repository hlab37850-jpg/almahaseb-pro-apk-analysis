package com.itextpdf.text.exceptions;

/* JADX INFO: loaded from: classes3.dex */
public class InvalidImageException extends RuntimeException {
    private static final long serialVersionUID = -1319471492541702697L;
    private final Throwable cause;

    public InvalidImageException(String str) {
        this(str, null);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }

    public InvalidImageException(String str, Throwable th) {
        super(str);
        this.cause = th;
    }
}
