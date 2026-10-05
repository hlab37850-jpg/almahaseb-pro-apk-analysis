package com.itextpdf.text.pdf.security;

import org.w3c.dom.Document;

/* JADX INFO: loaded from: classes3.dex */
public interface XmlLocator {
    Document getDocument();

    String getEncoding();

    void setDocument(Document document);
}
