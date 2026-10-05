package com.itextpdf.text.pdf;

import com.itextpdf.text.DocumentException;

/* JADX INFO: loaded from: classes3.dex */
public class PdfException extends DocumentException {
    private static final long serialVersionUID = 6767433960955483999L;

    public PdfException(Exception exc) {
        super(exc);
    }

    public PdfException() {
    }

    public PdfException(String str) {
        super(str);
    }
}
