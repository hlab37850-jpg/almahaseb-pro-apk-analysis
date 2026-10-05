package com.itextpdf.text.pdf.parser;

import com.google.common.primitives.UnsignedBytes;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.pdf.DocumentFont;
import com.itextpdf.text.pdf.PdfString;
import com.itextpdf.text.xml.xmp.XmpWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class TextRenderInfo {
    private double[] fontMatrix;
    private final GraphicsState gs;
    private final Collection<MarkedContentInfo> markedContentInfos;
    private final PdfString string;
    private final Matrix textToUserSpaceTransformMatrix;
    private String text = null;
    private Float unscaledWidth = null;

    public TextRenderInfo(PdfString pdfString, GraphicsState graphicsState, Matrix matrix, Collection<MarkedContentInfo> collection) {
        this.fontMatrix = null;
        this.string = pdfString;
        this.textToUserSpaceTransformMatrix = matrix.multiply(graphicsState.ctm);
        this.gs = graphicsState;
        this.markedContentInfos = new ArrayList(collection);
        this.fontMatrix = graphicsState.font.getFontMatrix();
    }

    private float convertHeightFromTextSpaceToUserSpace(float f) {
        return new LineSegment(new Vector(0.0f, 0.0f, 1.0f), new Vector(0.0f, f, 1.0f)).transformBy(this.textToUserSpaceTransformMatrix).getLength();
    }

    private float convertWidthFromTextSpaceToUserSpace(float f) {
        return new LineSegment(new Vector(0.0f, 0.0f, 1.0f), new Vector(f, 0.0f, 1.0f)).transformBy(this.textToUserSpaceTransformMatrix).getLength();
    }

    private String decode(PdfString pdfString) {
        byte[] bytes = pdfString.getBytes();
        return this.gs.font.decode(bytes, 0, bytes.length);
    }

    private int getCharCode(String str) {
        try {
            byte[] bytes = str.getBytes(XmpWriter.UTF16BE);
            int i = 0;
            for (int i2 = 0; i2 < bytes.length - 1; i2++) {
                i = (i + (bytes[i2] & UnsignedBytes.MAX_VALUE)) << 8;
            }
            return bytes.length > 0 ? i + (bytes[bytes.length - 1] & UnsignedBytes.MAX_VALUE) : i;
        } catch (UnsupportedEncodingException unused) {
            return 0;
        }
    }

    private float getPdfStringWidth(PdfString pdfString, boolean z) {
        if (z) {
            float[] widthAndWordSpacing = getWidthAndWordSpacing(pdfString, z);
            float f = widthAndWordSpacing[0];
            GraphicsState graphicsState = this.gs;
            return ((f * graphicsState.fontSize) + graphicsState.characterSpacing + widthAndWordSpacing[1]) * graphicsState.horizontalScaling;
        }
        float pdfStringWidth = 0.0f;
        for (PdfString pdfString2 : splitString(pdfString)) {
            pdfStringWidth += getPdfStringWidth(pdfString2, true);
        }
        return pdfStringWidth;
    }

    private float getStringWidth(String str) {
        float f = 0.0f;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            float width = this.gs.font.getWidth(cCharAt) / 1000.0f;
            float f2 = cCharAt == ' ' ? this.gs.wordSpacing : 0.0f;
            GraphicsState graphicsState = this.gs;
            f += ((width * graphicsState.fontSize) + graphicsState.characterSpacing + f2) * graphicsState.horizontalScaling;
        }
        return f;
    }

    private LineSegment getUnscaledBaselineWithOffset(float f) {
        String unicodeString = this.string.toUnicodeString();
        return new LineSegment(new Vector(0.0f, f, 1.0f), new Vector(getUnscaledWidth() - ((this.gs.characterSpacing + ((unicodeString.length() <= 0 || unicodeString.charAt(unicodeString.length() + (-1)) != ' ') ? 0.0f : this.gs.wordSpacing)) * this.gs.horizontalScaling), f, 1.0f));
    }

    private float getUnscaledFontSpaceWidth() {
        return getStringWidth(String.valueOf(this.gs.font.getWidth(32) == 0 ? (char) 160 : ' '));
    }

    private float[] getWidthAndWordSpacing(PdfString pdfString, boolean z) {
        if (!z) {
            throw new UnsupportedOperationException();
        }
        String strDecode = decode(pdfString);
        return new float[]{(float) (((double) this.gs.font.getWidth(getCharCode(strDecode))) * this.fontMatrix[0]), strDecode.equals(" ") ? this.gs.wordSpacing : 0.0f};
    }

    private PdfString[] splitString(PdfString pdfString) {
        ArrayList arrayList = new ArrayList();
        String string = pdfString.toString();
        int i = 0;
        while (i < string.length()) {
            int i2 = i + 1;
            PdfString pdfString2 = new PdfString(string.substring(i, i2), pdfString.getEncoding());
            if (decode(pdfString2).length() == 0 && i < string.length() - 1) {
                pdfString2 = new PdfString(string.substring(i, i + 2), pdfString.getEncoding());
                i = i2;
            }
            arrayList.add(pdfString2);
            i++;
        }
        return (PdfString[]) arrayList.toArray(new PdfString[arrayList.size()]);
    }

    public LineSegment getAscentLine() {
        return getUnscaledBaselineWithOffset(this.gs.getFont().getFontDescriptor(1, this.gs.getFontSize()) + this.gs.rise).transformBy(this.textToUserSpaceTransformMatrix);
    }

    public LineSegment getBaseline() {
        return getUnscaledBaselineWithOffset(this.gs.rise + 0.0f).transformBy(this.textToUserSpaceTransformMatrix);
    }

    public List<TextRenderInfo> getCharacterRenderInfos() {
        ArrayList arrayList = new ArrayList(this.string.length());
        PdfString[] pdfStringArrSplitString = splitString(this.string);
        float f = 0.0f;
        for (int i = 0; i < pdfStringArrSplitString.length; i++) {
            float[] widthAndWordSpacing = getWidthAndWordSpacing(pdfStringArrSplitString[i], true);
            arrayList.add(new TextRenderInfo(this, pdfStringArrSplitString[i], f));
            float f2 = widthAndWordSpacing[0];
            GraphicsState graphicsState = this.gs;
            f += ((f2 * graphicsState.fontSize) + graphicsState.characterSpacing + widthAndWordSpacing[1]) * graphicsState.horizontalScaling;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((TextRenderInfo) it.next()).getUnscaledWidth();
        }
        return arrayList;
    }

    public LineSegment getDescentLine() {
        return getUnscaledBaselineWithOffset(this.gs.getFont().getFontDescriptor(3, this.gs.getFontSize()) + this.gs.rise).transformBy(this.textToUserSpaceTransformMatrix);
    }

    public BaseColor getFillColor() {
        return this.gs.fillColor;
    }

    public DocumentFont getFont() {
        return this.gs.getFont();
    }

    public Integer getMcid() {
        Collection<MarkedContentInfo> collection = this.markedContentInfos;
        if (!(collection instanceof ArrayList)) {
            return null;
        }
        ArrayList arrayList = (ArrayList) collection;
        MarkedContentInfo markedContentInfo = arrayList.size() > 0 ? (MarkedContentInfo) arrayList.get(arrayList.size() - 1) : null;
        if (markedContentInfo == null || !markedContentInfo.hasMcid()) {
            return null;
        }
        return Integer.valueOf(markedContentInfo.getMcid());
    }

    public PdfString getPdfString() {
        return this.string;
    }

    public float getRise() {
        float f = this.gs.rise;
        if (f == 0.0f) {
            return 0.0f;
        }
        return convertHeightFromTextSpaceToUserSpace(f);
    }

    public float getSingleSpaceWidth() {
        return convertWidthFromTextSpaceToUserSpace(getUnscaledFontSpaceWidth());
    }

    public BaseColor getStrokeColor() {
        return this.gs.strokeColor;
    }

    public String getText() {
        if (this.text == null) {
            this.text = decode(this.string);
        }
        return this.text;
    }

    public int getTextRenderMode() {
        return this.gs.renderMode;
    }

    public LineSegment getUnscaledBaseline() {
        return getUnscaledBaselineWithOffset(this.gs.rise + 0.0f);
    }

    public float getUnscaledWidth() {
        if (this.unscaledWidth == null) {
            this.unscaledWidth = Float.valueOf(getPdfStringWidth(this.string, false));
        }
        return this.unscaledWidth.floatValue();
    }

    public boolean hasMcid(int i) {
        return hasMcid(i, false);
    }

    public boolean hasMcid(int i, boolean z) {
        Integer mcid;
        if (z) {
            return (this.markedContentInfos instanceof ArrayList) && (mcid = getMcid()) != null && mcid.intValue() == i;
        }
        for (MarkedContentInfo markedContentInfo : this.markedContentInfos) {
            if (markedContentInfo.hasMcid() && markedContentInfo.getMcid() == i) {
                return true;
            }
        }
        return false;
    }

    private TextRenderInfo(TextRenderInfo textRenderInfo, PdfString pdfString, float f) {
        this.fontMatrix = null;
        this.string = pdfString;
        this.textToUserSpaceTransformMatrix = new Matrix(f, 0.0f).multiply(textRenderInfo.textToUserSpaceTransformMatrix);
        GraphicsState graphicsState = textRenderInfo.gs;
        this.gs = graphicsState;
        this.markedContentInfos = textRenderInfo.markedContentInfos;
        this.fontMatrix = graphicsState.font.getFontMatrix();
    }
}
