package com.itextpdf.tool.xml.net;

import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public interface FileRetrieve {
    void processFromHref(String str, ReadingProcessor readingProcessor);

    void processFromStream(InputStream inputStream, ReadingProcessor readingProcessor);
}
