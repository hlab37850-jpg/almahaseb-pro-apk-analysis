package com.itextpdf.text.xml;

import com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler;
import com.itextpdf.text.xml.simpleparser.SimpleXMLParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class XmlToTxt implements SimpleXMLDocHandler {
    protected StringBuffer buf = new StringBuffer();

    public static String parse(InputStream inputStream) throws IOException {
        XmlToTxt xmlToTxt = new XmlToTxt();
        SimpleXMLParser.parse(xmlToTxt, null, new InputStreamReader(inputStream), true);
        return xmlToTxt.toString();
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void endDocument() {
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void endElement(String str) {
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void startDocument() {
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void startElement(String str, Map<String, String> map) {
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void text(String str) {
        this.buf.append(str);
    }

    public String toString() {
        return this.buf.toString();
    }
}
