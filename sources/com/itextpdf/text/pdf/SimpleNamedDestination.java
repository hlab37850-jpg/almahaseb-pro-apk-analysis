package com.itextpdf.text.pdf;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.xml.XMLUtil;
import com.itextpdf.text.xml.simpleparser.IanaEncodings;
import com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler;
import com.itextpdf.text.xml.simpleparser.SimpleXMLParser;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes3.dex */
public final class SimpleNamedDestination implements SimpleXMLDocHandler {
    private HashMap<String, String> xmlLast;
    private HashMap<String, String> xmlNames;

    private SimpleNamedDestination() {
    }

    public static PdfArray createDestinationArray(String str, PdfWriter pdfWriter) {
        PdfArray pdfArray = new PdfArray();
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        pdfArray.add(pdfWriter.getPageReference(Integer.parseInt(stringTokenizer.nextToken())));
        if (stringTokenizer.hasMoreTokens()) {
            String strNextToken = stringTokenizer.nextToken();
            if (strNextToken.startsWith("/")) {
                strNextToken = strNextToken.substring(1);
            }
            pdfArray.add(new PdfName(strNextToken));
            for (int i = 0; i < 4 && stringTokenizer.hasMoreTokens(); i++) {
                String strNextToken2 = stringTokenizer.nextToken();
                if (strNextToken2.equals("null")) {
                    pdfArray.add(PdfNull.PDFNULL);
                } else {
                    pdfArray.add(new PdfNumber(strNextToken2));
                }
            }
        } else {
            pdfArray.add(PdfName.XYZ);
            pdfArray.add(new float[]{0.0f, 10000.0f, 0.0f});
        }
        return pdfArray;
    }

    public static String escapeBinaryString(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (char c : str.toCharArray()) {
            if (c < ' ') {
                stringBuffer.append('\\');
                String str2 = "00" + Integer.toOctalString(c);
                stringBuffer.append(str2.substring(str2.length() - 3));
            } else if (c == '\\') {
                stringBuffer.append("\\\\");
            } else {
                stringBuffer.append(c);
            }
        }
        return stringBuffer.toString();
    }

    public static void exportToXML(HashMap<String, String> map, OutputStream outputStream, String str, boolean z) throws IOException {
        exportToXML(map, new BufferedWriter(new OutputStreamWriter(outputStream, IanaEncodings.getJavaEncoding(str))), str, z);
    }

    public static HashMap<String, String> getNamedDestination(PdfReader pdfReader, boolean z) {
        IntHashtable intHashtable = new IntHashtable();
        int numberOfPages = pdfReader.getNumberOfPages();
        for (int i = 1; i <= numberOfPages; i++) {
            intHashtable.put(pdfReader.getPageOrigRef(i).getNumber(), i);
        }
        HashMap<String, PdfObject> namedDestinationFromNames = z ? pdfReader.getNamedDestinationFromNames() : pdfReader.getNamedDestinationFromStrings();
        HashMap<String, String> map = new HashMap<>(namedDestinationFromNames.size());
        for (Map.Entry<String, PdfObject> entry : namedDestinationFromNames.entrySet()) {
            PdfArray pdfArray = (PdfArray) entry.getValue();
            StringBuffer stringBuffer = new StringBuffer();
            try {
                stringBuffer.append(intHashtable.get(pdfArray.getAsIndirectObject(0).getNumber()));
                stringBuffer.append(' ');
                stringBuffer.append(pdfArray.getPdfObject(1).toString().substring(1));
                for (int i2 = 2; i2 < pdfArray.size(); i2++) {
                    stringBuffer.append(' ');
                    stringBuffer.append(pdfArray.getPdfObject(i2).toString());
                }
                map.put(entry.getKey(), stringBuffer.toString());
            } catch (Exception unused) {
            }
        }
        return map;
    }

    public static HashMap<String, String> importFromXML(InputStream inputStream) throws IOException {
        SimpleNamedDestination simpleNamedDestination = new SimpleNamedDestination();
        SimpleXMLParser.parse(simpleNamedDestination, inputStream);
        return simpleNamedDestination.xmlNames;
    }

    public static PdfDictionary outputNamedDestinationAsNames(HashMap<String, String> map, PdfWriter pdfWriter) {
        PdfDictionary pdfDictionary = new PdfDictionary();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            try {
                String key = entry.getKey();
                pdfDictionary.put(new PdfName(key), createDestinationArray(entry.getValue(), pdfWriter));
            } catch (Exception unused) {
            }
        }
        return pdfDictionary;
    }

    public static PdfDictionary outputNamedDestinationAsStrings(HashMap<String, String> map, PdfWriter pdfWriter) {
        HashMap map2 = new HashMap(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            try {
                map2.put(entry.getKey(), pdfWriter.addToBody(createDestinationArray(entry.getValue(), pdfWriter)).getIndirectReference());
            } catch (Exception unused) {
            }
        }
        return PdfNameTree.writeTree(map2, pdfWriter);
    }

    public static String unEscapeBinaryString(String str) {
        char c;
        StringBuffer stringBuffer = new StringBuffer();
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i = 0;
        while (i < length) {
            char c2 = charArray[i];
            if (c2 == '\\') {
                int i2 = i + 1;
                if (i2 >= length) {
                    stringBuffer.append('\\');
                    break;
                }
                char c3 = charArray[i2];
                if (c3 < '0' || c3 > '7') {
                    stringBuffer.append(c3);
                    i = i2;
                } else {
                    int i3 = c3 - '0';
                    int i4 = i + 2;
                    for (int i5 = 0; i5 < 2 && i4 < length && (c = charArray[i4]) >= '0' && c <= '7'; i5++) {
                        i4++;
                        i3 = ((i3 * 8) + c) - 48;
                    }
                    i = i4 - 1;
                    stringBuffer.append((char) i3);
                }
            } else {
                stringBuffer.append(c2);
            }
            i++;
        }
        return stringBuffer.toString();
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void endDocument() {
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void endElement(String str) {
        if (str.equals("Destination")) {
            if (this.xmlLast != null || this.xmlNames == null) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("destination.end.tag.out.of.place", new Object[0]));
            }
        } else {
            if (!str.equals("Name")) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("invalid.end.tag.1", str));
            }
            HashMap<String, String> map = this.xmlLast;
            if (map == null || this.xmlNames == null) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("name.end.tag.out.of.place", new Object[0]));
            }
            if (!map.containsKey("Page")) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("page.attribute.missing", new Object[0]));
            }
            this.xmlNames.put(unEscapeBinaryString(this.xmlLast.get("Name")), this.xmlLast.get("Page"));
            this.xmlLast = null;
        }
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void startDocument() {
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void startElement(String str, Map<String, String> map) {
        if (this.xmlNames == null) {
            if (!str.equals("Destination")) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("root.element.is.not.destination", new Object[0]));
            }
            this.xmlNames = new HashMap<>();
        } else {
            if (!str.equals("Name")) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("tag.1.not.allowed", str));
            }
            if (this.xmlLast != null) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("nested.tags.are.not.allowed", new Object[0]));
            }
            HashMap<String, String> map2 = new HashMap<>(map);
            this.xmlLast = map2;
            map2.put("Name", "");
        }
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void text(String str) {
        HashMap<String, String> map = this.xmlLast;
        if (map == null) {
            return;
        }
        this.xmlLast.put("Name", map.get("Name") + str);
    }

    public static void exportToXML(HashMap<String, String> map, Writer writer, String str, boolean z) throws IOException {
        writer.write("<?xml version=\"1.0\" encoding=\"");
        writer.write(XMLUtil.escapeXML(str, z));
        writer.write("\"?>\n<Destination>\n");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            writer.write("  <Name Page=\"");
            writer.write(XMLUtil.escapeXML(value, z));
            writer.write("\">");
            writer.write(XMLUtil.escapeXML(escapeBinaryString(key), z));
            writer.write("</Name>\n");
        }
        writer.write("</Destination>\n");
        writer.flush();
    }

    public static HashMap<String, String> importFromXML(Reader reader) throws IOException {
        SimpleNamedDestination simpleNamedDestination = new SimpleNamedDestination();
        SimpleXMLParser.parse(simpleNamedDestination, reader);
        return simpleNamedDestination.xmlNames;
    }
}
