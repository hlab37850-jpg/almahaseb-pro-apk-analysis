package com.itextpdf.text.pdf;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class PdfTextArray {
    ArrayList<Object> arrayList = new ArrayList<>();
    private Float lastNum;
    private String lastStr;

    public PdfTextArray(String str) {
        add(str);
    }

    private void replaceLast(Object obj) {
        ArrayList<Object> arrayList = this.arrayList;
        arrayList.set(arrayList.size() - 1, obj);
    }

    public void add(PdfNumber pdfNumber) {
        add((float) pdfNumber.doubleValue());
    }

    public ArrayList<Object> getArrayList() {
        return this.arrayList;
    }

    public void add(float f) {
        if (f != 0.0f) {
            Float f2 = this.lastNum;
            if (f2 != null) {
                Float f3 = new Float(f + f2.floatValue());
                this.lastNum = f3;
                if (f3.floatValue() != 0.0f) {
                    replaceLast(this.lastNum);
                } else {
                    ArrayList<Object> arrayList = this.arrayList;
                    arrayList.remove(arrayList.size() - 1);
                }
            } else {
                Float f4 = new Float(f);
                this.lastNum = f4;
                this.arrayList.add(f4);
            }
            this.lastStr = null;
        }
    }

    public PdfTextArray() {
    }

    public void add(String str) {
        if (str.length() > 0) {
            if (this.lastStr != null) {
                String str2 = this.lastStr + str;
                this.lastStr = str2;
                replaceLast(str2);
            } else {
                this.lastStr = str;
                this.arrayList.add(str);
            }
            this.lastNum = null;
        }
    }
}
