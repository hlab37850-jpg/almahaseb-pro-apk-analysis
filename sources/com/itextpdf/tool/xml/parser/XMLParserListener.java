package com.itextpdf.tool.xml.parser;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface XMLParserListener {
    void close();

    void comment(String str);

    void endElement(String str, String str2);

    void init();

    void startElement(String str, Map<String, String> map, String str2);

    void text(String str);

    void unknownText(String str);
}
