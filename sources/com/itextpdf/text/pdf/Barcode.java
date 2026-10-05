package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Barcode {
    public static final int CODABAR = 12;
    public static final int CODE128 = 9;
    public static final int CODE128_RAW = 11;
    public static final int CODE128_UCC = 10;
    public static final int EAN13 = 1;
    public static final int EAN8 = 2;
    public static final int PLANET = 8;
    public static final int POSTNET = 7;
    public static final int SUPP2 = 5;
    public static final int SUPP5 = 6;
    public static final int UPCA = 3;
    public static final int UPCE = 4;
    protected String altText;
    protected float barHeight;
    protected float baseline;
    protected boolean checksumText;
    protected int codeType;
    protected boolean extended;
    protected BaseFont font;
    protected boolean generateChecksum;
    protected boolean guardBars;
    protected float n;
    protected float size;
    protected boolean startStopText;
    protected int textAlignment;
    protected float x;
    protected String code = "";
    protected float inkSpreading = 0.0f;

    public Image createImageWithBarcode(PdfContentByte pdfContentByte, BaseColor baseColor, BaseColor baseColor2) {
        try {
            return Image.getInstance(createTemplateWithBarcode(pdfContentByte, baseColor, baseColor2));
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public PdfTemplate createTemplateWithBarcode(PdfContentByte pdfContentByte, BaseColor baseColor, BaseColor baseColor2) {
        PdfTemplate pdfTemplateCreateTemplate = pdfContentByte.createTemplate(0.0f, 0.0f);
        pdfTemplateCreateTemplate.setBoundingBox(placeBarcode(pdfTemplateCreateTemplate, baseColor, baseColor2));
        return pdfTemplateCreateTemplate;
    }

    public String getAltText() {
        return this.altText;
    }

    public float getBarHeight() {
        return this.barHeight;
    }

    public abstract Rectangle getBarcodeSize();

    public float getBaseline() {
        return this.baseline;
    }

    public String getCode() {
        return this.code;
    }

    public int getCodeType() {
        return this.codeType;
    }

    public BaseFont getFont() {
        return this.font;
    }

    public float getInkSpreading() {
        return this.inkSpreading;
    }

    public float getN() {
        return this.n;
    }

    public float getSize() {
        return this.size;
    }

    public int getTextAlignment() {
        return this.textAlignment;
    }

    public float getX() {
        return this.x;
    }

    public boolean isChecksumText() {
        return this.checksumText;
    }

    public boolean isExtended() {
        return this.extended;
    }

    public boolean isGenerateChecksum() {
        return this.generateChecksum;
    }

    public boolean isGuardBars() {
        return this.guardBars;
    }

    public boolean isStartStopText() {
        return this.startStopText;
    }

    public abstract Rectangle placeBarcode(PdfContentByte pdfContentByte, BaseColor baseColor, BaseColor baseColor2);

    public void setAltText(String str) {
        this.altText = str;
    }

    public void setBarHeight(float f) {
        this.barHeight = f;
    }

    public void setBaseline(float f) {
        this.baseline = f;
    }

    public void setChecksumText(boolean z) {
        this.checksumText = z;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setCodeType(int i) {
        this.codeType = i;
    }

    public void setExtended(boolean z) {
        this.extended = z;
    }

    public void setFont(BaseFont baseFont) {
        this.font = baseFont;
    }

    public void setGenerateChecksum(boolean z) {
        this.generateChecksum = z;
    }

    public void setGuardBars(boolean z) {
        this.guardBars = z;
    }

    public void setInkSpreading(float f) {
        this.inkSpreading = f;
    }

    public void setN(float f) {
        this.n = f;
    }

    public void setSize(float f) {
        this.size = f;
    }

    public void setStartStopText(boolean z) {
        this.startStopText = z;
    }

    public void setTextAlignment(int i) {
        this.textAlignment = i;
    }

    public void setX(float f) {
        this.x = f;
    }
}
