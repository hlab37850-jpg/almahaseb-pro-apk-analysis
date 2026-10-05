package com.itextpdf.text.pdf;

import com.itextpdf.text.log.Counter;
import com.itextpdf.text.log.CounterFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class FdfReader extends PdfReader {
    protected static Counter COUNTER = CounterFactory.getCounter(FdfReader.class);
    PdfName encoding;
    HashMap<String, PdfDictionary> fields;
    String fileSpec;

    public FdfReader(String str) {
        super(str);
    }

    public byte[] getAttachedFile(String str) {
        PdfDictionary pdfDictionary = this.fields.get(str);
        return pdfDictionary != null ? PdfReader.getStreamBytes((PRStream) getPdfObject(((PRIndirectReference) ((PdfDictionary) getPdfObject(((PRIndirectReference) pdfDictionary.get(PdfName.V)).getNumber())).getAsDict(PdfName.EF).get(PdfName.F)).getNumber())) : new byte[0];
    }

    @Override // com.itextpdf.text.pdf.PdfReader
    public Counter getCounter() {
        return COUNTER;
    }

    public PdfDictionary getField(String str) {
        return this.fields.get(str);
    }

    public String getFieldValue(String str) {
        PdfObject pdfObject;
        PdfDictionary pdfDictionary = this.fields.get(str);
        if (pdfDictionary == null || (pdfObject = PdfReader.getPdfObject(pdfDictionary.get(PdfName.V))) == null) {
            return null;
        }
        if (pdfObject.isName()) {
            return PdfName.decodeName(((PdfName) pdfObject).toString());
        }
        if (!pdfObject.isString()) {
            return null;
        }
        PdfString pdfString = (PdfString) pdfObject;
        if (this.encoding == null || pdfString.getEncoding() != null) {
            return pdfString.toUnicodeString();
        }
        byte[] bytes = pdfString.getBytes();
        if (bytes.length >= 2 && bytes[0] == -2 && bytes[1] == -1) {
            return pdfString.toUnicodeString();
        }
        try {
            if (this.encoding.equals(PdfName.SHIFT_JIS)) {
                return new String(bytes, com.google.zxing.common.StringUtils.SHIFT_JIS);
            }
            if (this.encoding.equals(PdfName.UHC)) {
                return new String(bytes, "MS949");
            }
            if (this.encoding.equals(PdfName.GBK)) {
                return new String(bytes, "GBK");
            }
            if (this.encoding.equals(PdfName.BIGFIVE)) {
                return new String(bytes, "Big5");
            }
            if (this.encoding.equals(PdfName.UTF_8)) {
                return new String(bytes, "UTF8");
            }
            return pdfString.toUnicodeString();
        } catch (Exception unused) {
        }
    }

    public HashMap<String, PdfDictionary> getFields() {
        return this.fields;
    }

    public String getFileSpec() {
        return this.fileSpec;
    }

    public void kidNode(PdfDictionary pdfDictionary, String str) {
        PdfName pdfName = PdfName.KIDS;
        PdfArray asArray = pdfDictionary.getAsArray(pdfName);
        if (asArray == null || asArray.isEmpty()) {
            if (str.length() > 0) {
                str = str.substring(1);
            }
            this.fields.put(str, pdfDictionary);
            return;
        }
        pdfDictionary.remove(pdfName);
        for (int i = 0; i < asArray.size(); i++) {
            PdfDictionary pdfDictionary2 = new PdfDictionary();
            pdfDictionary2.merge(pdfDictionary);
            PdfDictionary asDict = asArray.getAsDict(i);
            PdfName pdfName2 = PdfName.T;
            PdfString asString = asDict.getAsString(pdfName2);
            String str2 = asString != null ? str + "." + asString.toUnicodeString() : str;
            pdfDictionary2.merge(asDict);
            pdfDictionary2.remove(pdfName2);
            kidNode(pdfDictionary2, str2);
        }
    }

    public void readFields() {
        PdfDictionary asDict = this.trailer.getAsDict(PdfName.ROOT);
        this.catalog = asDict;
        PdfDictionary asDict2 = asDict.getAsDict(PdfName.FDF);
        if (asDict2 == null) {
            return;
        }
        PdfString asString = asDict2.getAsString(PdfName.F);
        if (asString != null) {
            this.fileSpec = asString.toUnicodeString();
        }
        PdfArray asArray = asDict2.getAsArray(PdfName.FIELDS);
        if (asArray == null) {
            return;
        }
        this.encoding = asDict2.getAsName(PdfName.ENCODING);
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.put(PdfName.KIDS, asArray);
        kidNode(pdfDictionary, "");
    }

    @Override // com.itextpdf.text.pdf.PdfReader
    public void readPdf() throws IOException {
        this.fields = new HashMap<>();
        this.tokens.checkFdfHeader();
        rebuildXref();
        readDocObj();
        readFields();
    }

    public FdfReader(byte[] bArr) {
        super(bArr);
    }

    public FdfReader(URL url) {
        super(url);
    }

    public FdfReader(InputStream inputStream) {
        super(inputStream);
    }
}
