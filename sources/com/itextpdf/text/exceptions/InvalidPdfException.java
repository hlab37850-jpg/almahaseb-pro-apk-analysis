package com.itextpdf.text.exceptions;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class InvalidPdfException extends IOException {
    private static final long serialVersionUID = -2319614911517026938L;
    private final Throwable cause;

    public InvalidPdfException(String str) {
        this(str, null);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }

    public InvalidPdfException(String str, Throwable th) {
        super(str);
        this.cause = th;
    }
}
