package com.itextpdf.text.pdf;

import com.itextpdf.text.DocWriter;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.log.Counter;
import com.itextpdf.text.log.CounterFactory;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes3.dex */
public class FdfWriter {
    private static final byte[] HEADER_FDF = DocWriter.getISOBytes("%FDF-1.4\n%âãÏÓ\n");
    protected Counter COUNTER;
    HashMap<String, Object> fields;
    private String file;
    private String statusMessage;
    Wrt wrt;

    public static class Wrt extends PdfWriter {
        private FdfWriter fdf;

        public Wrt(OutputStream outputStream, FdfWriter fdfWriter) throws IOException {
            super(new PdfDocument(), outputStream);
            this.fdf = fdfWriter;
            this.os.write(FdfWriter.HEADER_FDF);
            this.body = new PdfWriter.PdfBody(this);
        }

        /* JADX WARN: Code duplicated, block: B:21:0x0078  */
        public PdfArray calculate(HashMap<String, Object> map) {
            PdfArray pdfArray = new PdfArray();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                PdfDictionary pdfDictionary = new PdfDictionary();
                pdfDictionary.put(PdfName.T, new PdfString(key, PdfObject.TEXT_UNICODE));
                if (value instanceof HashMap) {
                    pdfDictionary.put(PdfName.KIDS, calculate((HashMap) value));
                } else if (value instanceof PdfAction) {
                    pdfDictionary.put(PdfName.A, (PdfAction) value);
                } else if (value instanceof PdfAnnotation) {
                    pdfDictionary.put(PdfName.AA, (PdfAnnotation) value);
                } else if (value instanceof PdfDictionary) {
                    PdfDictionary pdfDictionary2 = (PdfDictionary) value;
                    if (pdfDictionary2.size() == 1 && pdfDictionary2.contains(PdfName.N)) {
                        pdfDictionary.put(PdfName.AP, pdfDictionary2);
                    } else {
                        pdfDictionary.put(PdfName.V, (PdfObject) value);
                    }
                } else {
                    pdfDictionary.put(PdfName.V, (PdfObject) value);
                }
                pdfArray.add(pdfDictionary);
            }
            return pdfArray;
        }

        public void write() throws IOException {
            for (PdfReaderInstance pdfReaderInstance : this.readerInstances.values()) {
                this.currentPdfReaderInstance = pdfReaderInstance;
                pdfReaderInstance.writeAllPages();
            }
            PdfDictionary pdfDictionary = new PdfDictionary();
            pdfDictionary.put(PdfName.FIELDS, calculate(this.fdf.fields));
            if (this.fdf.file != null) {
                pdfDictionary.put(PdfName.F, new PdfString(this.fdf.file, PdfObject.TEXT_UNICODE));
            }
            if (this.fdf.statusMessage != null && this.fdf.statusMessage.trim().length() != 0) {
                pdfDictionary.put(PdfName.STATUS, new PdfString(this.fdf.statusMessage));
            }
            PdfDictionary pdfDictionary2 = new PdfDictionary();
            pdfDictionary2.put(PdfName.FDF, pdfDictionary);
            PdfIndirectReference indirectReference = addToBody(pdfDictionary2).getIndirectReference();
            this.os.write(DocWriter.getISOBytes("trailer\n"));
            PdfDictionary pdfDictionary3 = new PdfDictionary();
            pdfDictionary3.put(PdfName.ROOT, indirectReference);
            pdfDictionary3.toPdf(null, this.os);
            this.os.write(DocWriter.getISOBytes("\n%%EOF\n"));
            this.os.close();
        }
    }

    public FdfWriter() {
        this.fields = new HashMap<>();
        this.wrt = null;
        this.COUNTER = CounterFactory.getCounter(FdfWriter.class);
    }

    public PdfTemplate createTemplate(float f, float f2) {
        return PdfTemplate.createTemplate(this.wrt, f, f2);
    }

    public Counter getCounter() {
        return this.COUNTER;
    }

    public String getField(String str) {
        HashMap<String, Object> map = this.fields;
        StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
        if (!stringTokenizer.hasMoreTokens()) {
            return null;
        }
        while (true) {
            Object obj = map.get(stringTokenizer.nextToken());
            if (obj == null) {
                return null;
            }
            if (!stringTokenizer.hasMoreTokens()) {
                if (obj instanceof HashMap) {
                    return null;
                }
                return ((PdfObject) obj).isString() ? ((PdfString) obj).toUnicodeString() : PdfName.decodeName(obj.toString());
            }
            if (!(obj instanceof HashMap)) {
                return null;
            }
            map = (HashMap) obj;
        }
    }

    public HashMap<String, Object> getFields() {
        HashMap<String, Object> map = new HashMap<>();
        iterateFields(map, this.fields, "");
        return map;
    }

    public String getFile() {
        return this.file;
    }

    public PdfImportedPage getImportedPage(PdfReader pdfReader, int i) {
        return this.wrt.getImportedPage(pdfReader, i);
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public void iterateFields(HashMap<String, Object> map, HashMap<String, Object> map2, String str) {
        for (Map.Entry<String, Object> entry : map2.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof HashMap) {
                iterateFields(map, (HashMap) value, str + "." + key);
            } else {
                map.put((str + "." + key).substring(1), value);
            }
        }
    }

    public boolean removeField(String str) {
        HashMap<String, Object> map = this.fields;
        StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
        if (!stringTokenizer.hasMoreTokens()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            String strNextToken = stringTokenizer.nextToken();
            Object obj = map.get(strNextToken);
            if (obj == null) {
                return false;
            }
            arrayList.add(map);
            arrayList.add(strNextToken);
            if (!stringTokenizer.hasMoreTokens()) {
                if (obj instanceof HashMap) {
                    return false;
                }
                for (int size = arrayList.size() - 2; size >= 0; size -= 2) {
                    HashMap map2 = (HashMap) arrayList.get(size);
                    map2.remove((String) arrayList.get(size + 1));
                    if (!map2.isEmpty()) {
                        return true;
                    }
                }
                return true;
            }
            if (!(obj instanceof HashMap)) {
                return false;
            }
            map = (HashMap) obj;
        }
    }

    public boolean setField(String str, PdfObject pdfObject) {
        HashMap<String, Object> map = this.fields;
        StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
        if (!stringTokenizer.hasMoreTokens()) {
            return false;
        }
        while (true) {
            String strNextToken = stringTokenizer.nextToken();
            Object obj = map.get(strNextToken);
            if (!stringTokenizer.hasMoreTokens()) {
                if (obj instanceof HashMap) {
                    return false;
                }
                map.put(strNextToken, pdfObject);
                return true;
            }
            if (obj == null) {
                HashMap<String, Object> map2 = new HashMap<>();
                map.put(strNextToken, map2);
                map = map2;
            } else {
                if (!(obj instanceof HashMap)) {
                    return false;
                }
                map = (HashMap) obj;
            }
        }
    }

    public boolean setFieldAsAction(String str, PdfAction pdfAction) {
        return setField(str, pdfAction);
    }

    public boolean setFieldAsImage(String str, Image image) {
        try {
            if (Float.isNaN(image.getAbsoluteX())) {
                image.setAbsolutePosition(0.0f, image.getAbsoluteY());
            }
            if (Float.isNaN(image.getAbsoluteY())) {
                image.setAbsolutePosition(image.getAbsoluteY(), 0.0f);
            }
            PdfTemplate pdfTemplateCreateTemplate = PdfTemplate.createTemplate(this.wrt, image.getWidth(), image.getHeight());
            pdfTemplateCreateTemplate.addImage(image);
            PdfIndirectReference indirectReference = this.wrt.addToBody(pdfTemplateCreateTemplate.getFormXObject(0)).getIndirectReference();
            PdfDictionary pdfDictionary = new PdfDictionary();
            pdfDictionary.put(PdfName.N, indirectReference);
            return setField(str, pdfDictionary);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public boolean setFieldAsJavascript(String str, PdfName pdfName, String str2) {
        PdfAnnotation pdfAnnotationCreateAnnotation = this.wrt.createAnnotation(null, null);
        pdfAnnotationCreateAnnotation.put(pdfName, PdfAction.javaScript(str2, this.wrt));
        return setField(str, pdfAnnotationCreateAnnotation);
    }

    public boolean setFieldAsName(String str, String str2) {
        return setField(str, new PdfName(str2));
    }

    public boolean setFieldAsString(String str, String str2) {
        return setField(str, new PdfString(str2, PdfObject.TEXT_UNICODE));
    }

    public boolean setFieldAsTemplate(String str, PdfTemplate pdfTemplate) {
        try {
            PdfDictionary pdfDictionary = new PdfDictionary();
            if (pdfTemplate instanceof PdfImportedPage) {
                pdfDictionary.put(PdfName.N, pdfTemplate.getIndirectReference());
            } else {
                pdfDictionary.put(PdfName.N, this.wrt.addToBody(pdfTemplate.getFormXObject(0)).getIndirectReference());
            }
            return setField(str, pdfDictionary);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public void setFields(FdfReader fdfReader) {
        for (Map.Entry<String, PdfDictionary> entry : fdfReader.getFields().entrySet()) {
            String key = entry.getKey();
            PdfDictionary value = entry.getValue();
            PdfObject pdfObject = value.get(PdfName.V);
            if (pdfObject != null) {
                setField(key, pdfObject);
            }
            PdfObject pdfObject2 = value.get(PdfName.A);
            if (pdfObject2 != null) {
                setField(key, pdfObject2);
            }
        }
    }

    public void setFile(String str) {
        this.file = str;
    }

    public void setStatusMessage(String str) {
        this.statusMessage = str;
    }

    public void write() throws IOException {
        this.wrt.write();
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        if (this.wrt == null) {
            this.wrt = new Wrt(outputStream, this);
        }
        this.wrt.write();
    }

    public FdfWriter(OutputStream outputStream) {
        this.fields = new HashMap<>();
        this.wrt = null;
        this.COUNTER = CounterFactory.getCounter(FdfWriter.class);
        this.wrt = new Wrt(outputStream, this);
    }

    public void setFields(PdfReader pdfReader) {
        setFields(pdfReader.getAcroFields());
    }

    public void setFields(AcroFields acroFields) {
        PdfObject pdfObjectRelease;
        for (Map.Entry<String, AcroFields.Item> entry : acroFields.getFields().entrySet()) {
            String key = entry.getKey();
            PdfDictionary merged = entry.getValue().getMerged(0);
            PdfObject pdfObjectRelease2 = PdfReader.getPdfObjectRelease(merged.get(PdfName.V));
            if (pdfObjectRelease2 != null && (pdfObjectRelease = PdfReader.getPdfObjectRelease(merged.get(PdfName.FT))) != null && !PdfName.SIG.equals(pdfObjectRelease)) {
                setField(key, pdfObjectRelease2);
            }
        }
    }
}
