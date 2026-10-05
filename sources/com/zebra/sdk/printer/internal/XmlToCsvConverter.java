package com.zebra.sdk.printer.internal;

import com.itextpdf.text.Annotation;
import com.itextpdf.tool.xml.html.HTML;
import com.zebra.sdk.util.internal.StringUtilities;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* JADX INFO: loaded from: classes3.dex */
public class XmlToCsvConverter extends DefaultHandler {
    Map<String, String> nameValuePairs;
    private StringBuilder nodeValue;
    private String workingVariable;
    ByteArrayOutputStream allLabelsAsCsv = new ByteArrayOutputStream();
    List<String> columns = new ArrayList();
    List<Map<String, String>> labels = new ArrayList();
    private String defaultQuantity = null;

    public static InputStream convert(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (inputStream.available() > 0) {
            byte[] bArr = new byte[1024];
            byteArrayOutputStream.write(bArr, 0, inputStream.read(bArr));
        }
        return new ByteArrayInputStream(convert(byteArrayOutputStream.toByteArray()));
    }

    private byte[] getCsvOutput() {
        return this.allLabelsAsCsv.toByteArray();
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i2) throws SAXException {
        super.characters(cArr, i, i2);
        this.nodeValue.append(cArr, i, i2);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endDocument() throws SAXException {
        super.endDocument();
        for (int i = 0; i < this.columns.size(); i++) {
            try {
                if (i != 0) {
                    this.allLabelsAsCsv.write(",".getBytes());
                }
                this.allLabelsAsCsv.write(this.columns.get(i).getBytes());
            } catch (IOException unused) {
                return;
            }
        }
        this.allLabelsAsCsv.write(StringUtilities.LF.getBytes());
        for (Map<String, String> map : this.labels) {
            for (int i2 = 0; i2 < this.columns.size(); i2++) {
                if (i2 != 0) {
                    this.allLabelsAsCsv.write(",".getBytes());
                }
                String str = this.columns.get(i2);
                String str2 = map.get(str) == null ? "" : map.get(str);
                if (str2.contains(",")) {
                    str2 = "\"" + str2 + "\"";
                }
                this.allLabelsAsCsv.write(str2.getBytes("utf8"));
            }
            this.allLabelsAsCsv.write(StringUtilities.LF.getBytes());
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) throws SAXException {
        super.endElement(str, str2, str3);
        if (this.nameValuePairs != null) {
            if (str3.equalsIgnoreCase("variable")) {
                this.nameValuePairs.put(this.workingVariable, this.nodeValue.toString().trim());
            } else if (str3.equalsIgnoreCase(HTML.Tag.LABEL)) {
                this.labels.add(this.nameValuePairs);
            }
            this.nodeValue.setLength(0);
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startDocument() throws SAXException {
        super.startDocument();
        this.nodeValue = new StringBuilder();
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        String value;
        List<String> list;
        super.startElement(str, str2, str3, attributes);
        String str4 = "QUANTITY";
        if (str3.equalsIgnoreCase(HTML.Tag.LABEL)) {
            HashMap map = new HashMap();
            this.nameValuePairs = map;
            String str5 = this.defaultQuantity;
            if (str5 != null) {
                map.put("QUANTITY", str5);
                return;
            }
            return;
        }
        if (str3.equalsIgnoreCase("variable")) {
            String value2 = attributes.getValue(attributes.getIndex("name"));
            this.workingVariable = value2;
            if (this.columns.contains(value2)) {
                return;
            }
            list = this.columns;
            str4 = this.workingVariable;
        } else {
            if (!str3.equalsIgnoreCase(Annotation.FILE) || (value = attributes.getValue(attributes.getIndex("_QUANTITY"))) == null) {
                return;
            }
            this.defaultQuantity = value;
            list = this.columns;
        }
        list.add(str4);
    }

    public static byte[] convert(byte[] bArr) {
        try {
            SAXParser sAXParserNewSAXParser = SAXParserFactory.newInstance().newSAXParser();
            XmlToCsvConverter xmlToCsvConverter = new XmlToCsvConverter();
            sAXParserNewSAXParser.parse(new ByteArrayInputStream(bArr), xmlToCsvConverter);
            return xmlToCsvConverter.getCsvOutput();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
