package com.itextpdf.text.pdf.parser;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.xml.XMLUtil;
import com.itextpdf.text.xml.xmp.XmpWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes3.dex */
public class TaggedPdfReaderTool {
    protected PrintWriter out;
    protected PdfReader reader;

    private static String fixTagName(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            boolean z = true;
            boolean z2 = cCharAt == ':' || (cCharAt >= 'A' && cCharAt <= 'Z') || cCharAt == '_' || ((cCharAt >= 'a' && cCharAt <= 'z') || ((cCharAt >= 192 && cCharAt <= 214) || ((cCharAt >= 216 && cCharAt <= 246) || ((cCharAt >= 248 && cCharAt <= 767) || ((cCharAt >= 880 && cCharAt <= 893) || ((cCharAt >= 895 && cCharAt <= 8191) || ((cCharAt >= 8204 && cCharAt <= 8205) || ((cCharAt >= 8304 && cCharAt <= 8591) || ((cCharAt >= 11264 && cCharAt <= 12271) || ((cCharAt >= 12289 && cCharAt <= 55295) || ((cCharAt >= 63744 && cCharAt <= 64975) || (cCharAt >= 65008 && cCharAt <= 65533))))))))))));
            if (cCharAt != '-' && cCharAt != '.' && ((cCharAt < '0' || cCharAt > '9') && cCharAt != 183 && ((cCharAt < 768 || cCharAt > 879) && ((cCharAt < 8255 || cCharAt > 8256) && !z2)))) {
                z = false;
            }
            if (i == 0) {
                if (!z2) {
                    cCharAt = '_';
                }
            } else if (!z) {
                cCharAt = '-';
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    public void convertToXml(PdfReader pdfReader, OutputStream outputStream, String str) throws IOException {
        this.reader = pdfReader;
        this.out = new PrintWriter(new OutputStreamWriter(outputStream, str));
        PdfDictionary asDict = pdfReader.getCatalog().getAsDict(PdfName.STRUCTTREEROOT);
        if (asDict == null) {
            throw new IOException(MessageLocalization.getComposedMessage("no.structtreeroot.found", new Object[0]));
        }
        inspectChild(asDict.getDirectObject(PdfName.K));
        this.out.flush();
        this.out.close();
    }

    public void inspectChild(PdfObject pdfObject) {
        if (pdfObject == null) {
            return;
        }
        if (pdfObject instanceof PdfArray) {
            inspectChildArray((PdfArray) pdfObject);
        } else if (pdfObject instanceof PdfDictionary) {
            inspectChildDictionary((PdfDictionary) pdfObject);
        }
    }

    public void inspectChildArray(PdfArray pdfArray) {
        if (pdfArray == null) {
            return;
        }
        for (int i = 0; i < pdfArray.size(); i++) {
            inspectChild(pdfArray.getDirectObject(i));
        }
    }

    public void inspectChildDictionary(PdfDictionary pdfDictionary) {
        inspectChildDictionary(pdfDictionary, false);
    }

    public void parseTag(String str, PdfObject pdfObject, PdfDictionary pdfDictionary) {
        if (pdfObject instanceof PdfNumber) {
            FilteredTextRenderListener filteredTextRenderListener = new FilteredTextRenderListener(new SimpleTextExtractionStrategy(), new MarkedContentRenderFilter(((PdfNumber) pdfObject).intValue()));
            new PdfContentStreamProcessor(filteredTextRenderListener).processContent(PdfReader.getPageContent(pdfDictionary), pdfDictionary.getAsDict(PdfName.RESOURCES));
            this.out.print(XMLUtil.escapeXML(filteredTextRenderListener.getResultantText(), true));
            return;
        }
        if (!(pdfObject instanceof PdfArray)) {
            if (pdfObject instanceof PdfDictionary) {
                PdfDictionary pdfDictionary2 = (PdfDictionary) pdfObject;
                parseTag(str, pdfDictionary2.getDirectObject(PdfName.MCID), pdfDictionary2.getAsDict(PdfName.PG));
                return;
            }
            return;
        }
        PdfArray pdfArray = (PdfArray) pdfObject;
        int size = pdfArray.size();
        for (int i = 0; i < size; i++) {
            parseTag(str, pdfArray.getPdfObject(i), pdfDictionary);
            if (i < size - 1) {
                this.out.println();
            }
        }
    }

    public String xmlName(PdfName pdfName) {
        String strReplaceFirst = pdfName.toString().replaceFirst("/", "");
        return Character.toLowerCase(strReplaceFirst.charAt(0)) + strReplaceFirst.substring(1);
    }

    public void inspectChildDictionary(PdfDictionary pdfDictionary, boolean z) {
        PdfDictionary asDict;
        if (pdfDictionary == null) {
            return;
        }
        PdfName asName = pdfDictionary.getAsName(PdfName.S);
        if (asName == null) {
            inspectChild(pdfDictionary.getDirectObject(PdfName.K));
            return;
        }
        String strDecodeName = PdfName.decodeName(asName.toString());
        String strFixTagName = fixTagName(strDecodeName);
        this.out.print("<");
        this.out.print(strFixTagName);
        if (z && (asDict = pdfDictionary.getAsDict(PdfName.A)) != null) {
            for (PdfName pdfName : asDict.getKeys()) {
                this.out.print(' ');
                PdfObject pdfObject = PdfReader.getPdfObject(asDict.get(pdfName));
                this.out.print(xmlName(pdfName));
                this.out.print("=\"");
                this.out.print(pdfObject.toString());
                this.out.print("\"");
            }
        }
        this.out.print(">");
        PdfObject pdfObject2 = pdfDictionary.get(PdfName.ALT);
        if (pdfObject2 != null && pdfObject2.toString() != null) {
            this.out.print("<alt><![CDATA[");
            this.out.print(pdfObject2.toString().replaceAll("[\\000]*", ""));
            this.out.print("]]></alt>");
        }
        PdfDictionary asDict2 = pdfDictionary.getAsDict(PdfName.PG);
        if (asDict2 != null) {
            parseTag(strDecodeName, pdfDictionary.getDirectObject(PdfName.K), asDict2);
        }
        inspectChild(pdfDictionary.getDirectObject(PdfName.K));
        this.out.print("</");
        this.out.print(strFixTagName);
        this.out.println(">");
    }

    public void convertToXml(PdfReader pdfReader, OutputStream outputStream) throws IOException {
        convertToXml(pdfReader, outputStream, XmpWriter.UTF8);
    }
}
