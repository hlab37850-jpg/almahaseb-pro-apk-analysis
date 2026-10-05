package com.itextpdf.tool.xml.parser.io;

import com.itextpdf.tool.xml.parser.XMLParserListener;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ParserListenerWriter implements XMLParserListener {
    private final boolean formatted;
    private final Appender writer;

    public ParserListenerWriter(Appender appender, boolean z) {
        this.writer = appender;
        this.formatted = z;
    }

    @Override // com.itextpdf.tool.xml.parser.XMLParserListener
    public void close() {
    }

    @Override // com.itextpdf.tool.xml.parser.XMLParserListener
    public void comment(String str) {
        this.writer.append("<!--").append(str).append("-->");
    }

    @Override // com.itextpdf.tool.xml.parser.XMLParserListener
    public void endElement(String str, String str2) {
        if (str2.length() > 0) {
            str2 = str2 + ":";
        }
        this.writer.append("</").append(str2).append(str).append('>');
        if (this.formatted) {
            this.writer.append('\r');
        }
    }

    @Override // com.itextpdf.tool.xml.parser.XMLParserListener
    public void init() {
    }

    @Override // com.itextpdf.tool.xml.parser.XMLParserListener
    public void startElement(String str, Map<String, String> map, String str2) {
        if (str2.length() > 0) {
            str2 = str2 + ":";
        }
        if (map.size() <= 0) {
            this.writer.append('<').append(str2).append(str).append('>');
            return;
        }
        this.writer.append("<").append(str2).append(str).append(" ");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.writer.append(entry.getKey()).append("=\"").append(entry.getValue()).append("\" ");
        }
        this.writer.append('>');
    }

    @Override // com.itextpdf.tool.xml.parser.XMLParserListener
    public void text(String str) {
        this.writer.append(str);
    }

    @Override // com.itextpdf.tool.xml.parser.XMLParserListener
    public void unknownText(String str) {
    }

    public ParserListenerWriter(Appender appender) {
        this(appender, true);
    }
}
