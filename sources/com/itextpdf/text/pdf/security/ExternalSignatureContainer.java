package com.itextpdf.text.pdf.security;

import com.itextpdf.text.pdf.PdfDictionary;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public interface ExternalSignatureContainer {
    void modifySigningDictionary(PdfDictionary pdfDictionary);

    byte[] sign(InputStream inputStream);
}
