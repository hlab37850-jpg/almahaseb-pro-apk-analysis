package com.itextpdf.text.pdf;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes3.dex */
public class PdfArray extends PdfObject implements Iterable<PdfObject> {
    protected ArrayList<PdfObject> arrayList;

    public PdfArray() {
        super(5);
        this.arrayList = new ArrayList<>();
    }

    public boolean add(PdfObject pdfObject) {
        return this.arrayList.add(pdfObject);
    }

    public void addFirst(PdfObject pdfObject) {
        this.arrayList.add(0, pdfObject);
    }

    public double[] asDoubleArray() {
        int size = size();
        double[] dArr = new double[size];
        for (int i = 0; i < size; i++) {
            dArr[i] = getAsNumber(i).doubleValue();
        }
        return dArr;
    }

    public long[] asLongArray() {
        int size = size();
        long[] jArr = new long[size];
        for (int i = 0; i < size; i++) {
            jArr[i] = getAsNumber(i).longValue();
        }
        return jArr;
    }

    public boolean contains(PdfObject pdfObject) {
        return this.arrayList.contains(pdfObject);
    }

    @Deprecated
    public ArrayList<PdfObject> getArrayList() {
        return this.arrayList;
    }

    public PdfArray getAsArray(int i) {
        PdfObject directObject = getDirectObject(i);
        if (directObject == null || !directObject.isArray()) {
            return null;
        }
        return (PdfArray) directObject;
    }

    public PdfBoolean getAsBoolean(int i) {
        PdfObject directObject = getDirectObject(i);
        if (directObject == null || !directObject.isBoolean()) {
            return null;
        }
        return (PdfBoolean) directObject;
    }

    public PdfDictionary getAsDict(int i) {
        PdfObject directObject = getDirectObject(i);
        if (directObject == null || !directObject.isDictionary()) {
            return null;
        }
        return (PdfDictionary) directObject;
    }

    public PdfIndirectReference getAsIndirectObject(int i) {
        PdfObject pdfObject = getPdfObject(i);
        if (pdfObject instanceof PdfIndirectReference) {
            return (PdfIndirectReference) pdfObject;
        }
        return null;
    }

    public PdfName getAsName(int i) {
        PdfObject directObject = getDirectObject(i);
        if (directObject == null || !directObject.isName()) {
            return null;
        }
        return (PdfName) directObject;
    }

    public PdfNumber getAsNumber(int i) {
        PdfObject directObject = getDirectObject(i);
        if (directObject == null || !directObject.isNumber()) {
            return null;
        }
        return (PdfNumber) directObject;
    }

    public PdfStream getAsStream(int i) {
        PdfObject directObject = getDirectObject(i);
        if (directObject == null || !directObject.isStream()) {
            return null;
        }
        return (PdfStream) directObject;
    }

    public PdfString getAsString(int i) {
        PdfObject directObject = getDirectObject(i);
        if (directObject == null || !directObject.isString()) {
            return null;
        }
        return (PdfString) directObject;
    }

    public PdfObject getDirectObject(int i) {
        return PdfReader.getPdfObject(getPdfObject(i));
    }

    public PdfObject getPdfObject(int i) {
        return this.arrayList.get(i);
    }

    public boolean isEmpty() {
        return this.arrayList.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<PdfObject> iterator() {
        return this.arrayList.iterator();
    }

    public ListIterator<PdfObject> listIterator() {
        return this.arrayList.listIterator();
    }

    public PdfObject remove(int i) {
        return this.arrayList.remove(i);
    }

    public PdfObject set(int i, PdfObject pdfObject) {
        return this.arrayList.set(i, pdfObject);
    }

    public int size() {
        return this.arrayList.size();
    }

    @Override // com.itextpdf.text.pdf.PdfObject
    public void toPdf(PdfWriter pdfWriter, OutputStream outputStream) throws IOException {
        PdfWriter.checkPdfIsoConformance(pdfWriter, 11, this);
        outputStream.write(91);
        Iterator<PdfObject> it = this.arrayList.iterator();
        if (it.hasNext()) {
            PdfObject next = it.next();
            if (next == null) {
                next = PdfNull.PDFNULL;
            }
            next.toPdf(pdfWriter, outputStream);
        }
        while (it.hasNext()) {
            PdfObject next2 = it.next();
            if (next2 == null) {
                next2 = PdfNull.PDFNULL;
            }
            int iType = next2.type();
            if (iType != 5 && iType != 6 && iType != 4 && iType != 3) {
                outputStream.write(32);
            }
            next2.toPdf(pdfWriter, outputStream);
        }
        outputStream.write(93);
    }

    @Override // com.itextpdf.text.pdf.PdfObject
    public String toString() {
        return this.arrayList.toString();
    }

    public boolean add(float[] fArr) {
        for (float f : fArr) {
            this.arrayList.add(new PdfNumber(f));
        }
        return true;
    }

    public PdfArray(int i) {
        super(5);
        this.arrayList = new ArrayList<>(i);
    }

    public boolean add(int[] iArr) {
        for (int i : iArr) {
            this.arrayList.add(new PdfNumber(i));
        }
        return true;
    }

    public PdfArray(PdfObject pdfObject) {
        super(5);
        ArrayList<PdfObject> arrayList = new ArrayList<>();
        this.arrayList = arrayList;
        arrayList.add(pdfObject);
    }

    public void add(int i, PdfObject pdfObject) {
        this.arrayList.add(i, pdfObject);
    }

    public PdfArray(float[] fArr) {
        super(5);
        this.arrayList = new ArrayList<>();
        add(fArr);
    }

    public PdfArray(int[] iArr) {
        super(5);
        this.arrayList = new ArrayList<>();
        add(iArr);
    }

    public PdfArray(List<PdfObject> list) {
        this();
        Iterator<PdfObject> it = list.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    public PdfArray(PdfArray pdfArray) {
        super(5);
        this.arrayList = new ArrayList<>(pdfArray.arrayList);
    }
}
