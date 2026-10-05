package com.itextpdf.text.pdf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes3.dex */
public class PRAcroForm extends PdfDictionary {
    PdfReader reader;
    ArrayList<FieldInformation> fields = new ArrayList<>();
    HashMap<String, FieldInformation> fieldByName = new HashMap<>();
    ArrayList<PdfDictionary> stack = new ArrayList<>();

    public static class FieldInformation {
        String fieldName;

        /* JADX INFO: renamed from: info, reason: collision with root package name */
        PdfDictionary f88info;
        PRIndirectReference ref;

        public FieldInformation(String str, PdfDictionary pdfDictionary, PRIndirectReference pRIndirectReference) {
            this.fieldName = str;
            this.f88info = pdfDictionary;
            this.ref = pRIndirectReference;
        }

        public PdfDictionary getInfo() {
            return this.f88info;
        }

        public String getName() {
            return this.fieldName;
        }

        public PRIndirectReference getRef() {
            return this.ref;
        }

        public String getWidgetName() {
            PdfObject pdfObject = this.f88info.get(PdfName.NM);
            if (pdfObject != null) {
                return pdfObject.toString();
            }
            return null;
        }
    }

    public PRAcroForm(PdfReader pdfReader) {
        this.reader = pdfReader;
    }

    public FieldInformation getField(String str) {
        return this.fieldByName.get(str);
    }

    public ArrayList<FieldInformation> getFields() {
        return this.fields;
    }

    public PRIndirectReference getRefByName(String str) {
        FieldInformation fieldInformation = this.fieldByName.get(str);
        if (fieldInformation == null) {
            return null;
        }
        return fieldInformation.getRef();
    }

    public void iterateFields(PdfArray pdfArray, PRIndirectReference pRIndirectReference, String str) {
        String string;
        ListIterator<PdfObject> listIterator = pdfArray.listIterator();
        while (listIterator.hasNext()) {
            PRIndirectReference pRIndirectReference2 = (PRIndirectReference) listIterator.next();
            PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObjectRelease(pRIndirectReference2);
            PdfName pdfName = PdfName.T;
            PdfString pdfString = (PdfString) pdfDictionary.get(pdfName);
            boolean z = pdfString != null;
            if (!z) {
                pRIndirectReference2 = pRIndirectReference;
                string = str;
            } else if (str == null) {
                string = pdfString.toString();
            } else {
                string = str + '.' + pdfString.toString();
            }
            PdfArray pdfArray2 = (PdfArray) pdfDictionary.get(PdfName.KIDS);
            if (pdfArray2 != null) {
                pushAttrib(pdfDictionary);
                iterateFields(pdfArray2, pRIndirectReference2, string);
                ArrayList<PdfDictionary> arrayList = this.stack;
                arrayList.remove(arrayList.size() - 1);
            } else if (pRIndirectReference2 != null) {
                ArrayList<PdfDictionary> arrayList2 = this.stack;
                PdfDictionary pdfDictionaryMergeAttrib = arrayList2.get(arrayList2.size() - 1);
                if (z) {
                    pdfDictionaryMergeAttrib = mergeAttrib(pdfDictionaryMergeAttrib, pdfDictionary);
                }
                pdfDictionaryMergeAttrib.put(pdfName, new PdfString(string));
                FieldInformation fieldInformation = new FieldInformation(string, pdfDictionaryMergeAttrib, pRIndirectReference2);
                this.fields.add(fieldInformation);
                this.fieldByName.put(string, fieldInformation);
            }
        }
    }

    public PdfDictionary mergeAttrib(PdfDictionary pdfDictionary, PdfDictionary pdfDictionary2) {
        PdfDictionary pdfDictionary3 = new PdfDictionary();
        if (pdfDictionary != null) {
            pdfDictionary3.putAll(pdfDictionary);
        }
        for (PdfName pdfName : pdfDictionary2.getKeys()) {
            if (pdfName.equals(PdfName.DR) || pdfName.equals(PdfName.DA) || pdfName.equals(PdfName.Q) || pdfName.equals(PdfName.FF) || pdfName.equals(PdfName.DV) || pdfName.equals(PdfName.V) || pdfName.equals(PdfName.FT) || pdfName.equals(PdfName.NM) || pdfName.equals(PdfName.F)) {
                pdfDictionary3.put(pdfName, pdfDictionary2.get(pdfName));
            }
        }
        return pdfDictionary3;
    }

    public void pushAttrib(PdfDictionary pdfDictionary) {
        PdfDictionary pdfDictionary2;
        if (this.stack.isEmpty()) {
            pdfDictionary2 = null;
        } else {
            ArrayList<PdfDictionary> arrayList = this.stack;
            pdfDictionary2 = arrayList.get(arrayList.size() - 1);
        }
        this.stack.add(mergeAttrib(pdfDictionary2, pdfDictionary));
    }

    public void readAcroForm(PdfDictionary pdfDictionary) {
        if (pdfDictionary == null) {
            return;
        }
        this.hashMap = pdfDictionary.hashMap;
        pushAttrib(pdfDictionary);
        PdfArray pdfArray = (PdfArray) PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.FIELDS));
        if (pdfArray != null) {
            iterateFields(pdfArray, null, null);
        }
    }

    @Override // com.itextpdf.text.pdf.PdfDictionary
    public int size() {
        return this.fields.size();
    }
}
