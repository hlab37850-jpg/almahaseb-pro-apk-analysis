package com.itextpdf.text.pdf.parser;

import com.itextpdf.text.pdf.PdfArray;

/* JADX INFO: loaded from: classes3.dex */
public class LineDashPattern {
    private DashArrayElem currentElem;
    private int currentIndex;
    private PdfArray dashArray;
    private float dashPhase;
    private int elemOrdinalNumber = 1;

    public class DashArrayElem {
        private boolean isGap;
        private float val;

        public DashArrayElem(float f, boolean z) {
            this.val = f;
            this.isGap = z;
        }

        public float getVal() {
            return this.val;
        }

        public boolean isGap() {
            return this.isGap;
        }

        public void setGap(boolean z) {
            this.isGap = z;
        }

        public void setVal(float f) {
            this.val = f;
        }
    }

    public LineDashPattern(PdfArray pdfArray, float f) {
        this.dashArray = new PdfArray(pdfArray);
        this.dashPhase = f;
        initFirst(f);
    }

    private void initFirst(float f) {
        if (this.dashArray.size() > 0) {
            while (f > 0.0f) {
                f -= this.dashArray.getAsNumber(this.currentIndex).floatValue();
                this.currentIndex = (this.currentIndex + 1) % this.dashArray.size();
                this.elemOrdinalNumber++;
            }
            if (f >= 0.0f) {
                this.currentElem = new DashArrayElem(this.dashArray.getAsNumber(this.currentIndex).floatValue(), isEven(this.elemOrdinalNumber));
                return;
            }
            int i = this.elemOrdinalNumber - 1;
            this.elemOrdinalNumber = i;
            this.currentIndex--;
            this.currentElem = new DashArrayElem(-f, isEven(i));
        }
    }

    private boolean isEven(int i) {
        return i % 2 == 0;
    }

    public PdfArray getDashArray() {
        return this.dashArray;
    }

    public float getDashPhase() {
        return this.dashPhase;
    }

    public boolean isSolid() {
        if (this.dashArray.size() % 2 != 0) {
            return false;
        }
        float fFloatValue = 0.0f;
        for (int i = 1; i < this.dashArray.size(); i += 2) {
            fFloatValue += this.dashArray.getAsNumber(i).floatValue();
        }
        return Float.compare(fFloatValue, 0.0f) == 0;
    }

    public DashArrayElem next() {
        DashArrayElem dashArrayElem = this.currentElem;
        if (this.dashArray.size() > 0) {
            int size = (this.currentIndex + 1) % this.dashArray.size();
            this.currentIndex = size;
            float fFloatValue = this.dashArray.getAsNumber(size).floatValue();
            int i = this.elemOrdinalNumber + 1;
            this.elemOrdinalNumber = i;
            this.currentElem = new DashArrayElem(fFloatValue, isEven(i));
        }
        return dashArrayElem;
    }

    public void reset() {
        this.currentIndex = 0;
        this.elemOrdinalNumber = 1;
        initFirst(this.dashPhase);
    }

    public void setDashArray(PdfArray pdfArray) {
        this.dashArray = pdfArray;
    }

    public void setDashPhase(float f) {
        this.dashPhase = f;
    }
}
