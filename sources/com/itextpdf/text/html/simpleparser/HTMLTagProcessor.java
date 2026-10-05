package com.itextpdf.text.html.simpleparser;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public interface HTMLTagProcessor {
    void endElement(HTMLWorker hTMLWorker, String str);

    void startElement(HTMLWorker hTMLWorker, String str, Map<String, String> map);
}
