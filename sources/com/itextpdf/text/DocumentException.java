package com.itextpdf.text;

/* JADX INFO: loaded from: classes3.dex */
public class DocumentException extends Exception {
    private static final long serialVersionUID = -2191131489390840739L;

    public DocumentException(Exception exc) {
        super(exc);
    }

    public DocumentException() {
    }

    public DocumentException(String str) {
        super(str);
    }

    public DocumentException(String str, Exception exc) {
        super(str, exc);
    }
}
