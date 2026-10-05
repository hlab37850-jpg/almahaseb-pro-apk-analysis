package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseField {
    public static final float BORDER_WIDTH_MEDIUM = 2.0f;
    public static final float BORDER_WIDTH_THICK = 3.0f;
    public static final float BORDER_WIDTH_THIN = 1.0f;
    public static final int COMB = 16777216;
    public static final int DO_NOT_SCROLL = 8388608;
    public static final int DO_NOT_SPELL_CHECK = 4194304;
    public static final int EDIT = 262144;
    public static final int FILE_SELECTION = 1048576;
    public static final int HIDDEN = 1;
    public static final int HIDDEN_BUT_PRINTABLE = 3;
    public static final int MULTILINE = 4096;
    public static final int MULTISELECT = 2097152;
    public static final int PASSWORD = 8192;
    public static final int READ_ONLY = 1;
    public static final int REQUIRED = 2;
    public static final int VISIBLE = 0;
    public static final int VISIBLE_BUT_DOES_NOT_PRINT = 2;
    private static final HashMap<PdfName, Integer> fieldKeys;
    protected BaseColor backgroundColor;
    protected BaseColor borderColor;
    protected Rectangle box;
    protected String fieldName;
    protected BaseFont font;
    protected int maxCharacterLength;
    protected int options;
    protected String text;
    protected BaseColor textColor;
    protected int visibility;
    protected PdfWriter writer;
    protected float borderWidth = 1.0f;
    protected int borderStyle = 0;
    protected float fontSize = 0.0f;
    protected int alignment = 0;
    protected int rotation = 0;

    static {
        HashMap<PdfName, Integer> map = new HashMap<>();
        fieldKeys = map;
        map.putAll(PdfCopyFieldsImp.fieldKeys);
        map.put(PdfName.T, 1);
    }

    public BaseField(PdfWriter pdfWriter, Rectangle rectangle, String str) {
        this.writer = pdfWriter;
        setBox(rectangle);
        this.fieldName = str;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x008f A[PHI: r11 r14
      0x008f: PHI (r11v4 int) = (r11v2 int), (r11v9 int) binds: [B:37:0x00bd, B:28:0x008d] A[DONT_GENERATE, DONT_INLINE]
      0x008f: PHI (r14v2 int) = (r14v1 int), (r14v5 int) binds: [B:37:0x00bd, B:28:0x008d] A[DONT_GENERATE, DONT_INLINE]] */
    public static ArrayList<String> breakLines(ArrayList<String> arrayList, BaseFont baseFont, float f, float f2) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        int i2 = 0;
        while (i2 < arrayList.size()) {
            stringBuffer.setLength(i);
            char[] charArray = arrayList.get(i2).toCharArray();
            int length = charArray.length;
            int i3 = 0;
            char c = 0;
            float widthPoint = 0.0f;
            int i4 = -1;
            int i5 = 0;
            while (i3 < length) {
                char c2 = charArray[i3];
                if (c == 0) {
                    widthPoint += baseFont.getWidthPoint(c2, f);
                    stringBuffer.append(c2);
                    if (widthPoint > f2) {
                        if (stringBuffer.length() > 1) {
                            i3--;
                            stringBuffer.setLength(stringBuffer.length() - 1);
                        }
                        arrayList2.add(stringBuffer.toString());
                        stringBuffer.setLength(0);
                        if (c2 == ' ') {
                            i5 = i3;
                            c = 2;
                        } else {
                            i5 = i3;
                            c = 1;
                        }
                        widthPoint = 0.0f;
                    } else if (c2 != ' ') {
                        c = 1;
                    }
                } else if (c == 1) {
                    widthPoint += baseFont.getWidthPoint(c2, f);
                    stringBuffer.append(c2);
                    if (c2 == ' ') {
                        i4 = i3;
                    }
                    if (widthPoint > f2) {
                        if (i4 >= 0) {
                            stringBuffer.setLength(i4 - i5);
                            trimRight(stringBuffer);
                            arrayList2.add(stringBuffer.toString());
                            stringBuffer.setLength(0);
                            i3 = i4;
                            i5 = i3;
                            c = 2;
                            widthPoint = 0.0f;
                            i4 = -1;
                        } else {
                            if (stringBuffer.length() > 1) {
                                i3--;
                                stringBuffer.setLength(stringBuffer.length() - 1);
                            }
                            arrayList2.add(stringBuffer.toString());
                            stringBuffer.setLength(0);
                            if (c2 == ' ') {
                                i5 = i3;
                                c = 2;
                            } else {
                                i5 = i3;
                            }
                            widthPoint = 0.0f;
                        }
                    }
                } else if (c == 2 && c2 != ' ') {
                    i3--;
                    c = 1;
                    widthPoint = 0.0f;
                }
                i3++;
            }
            trimRight(stringBuffer);
            arrayList2.add(stringBuffer.toString());
            i2++;
            i = 0;
        }
        return arrayList2;
    }

    private void drawBottomFrame(PdfAppearance pdfAppearance) {
        float f = this.borderWidth;
        pdfAppearance.moveTo(f, f);
        float width = this.box.getWidth();
        float f2 = this.borderWidth;
        pdfAppearance.lineTo(width - f2, f2);
        pdfAppearance.lineTo(this.box.getWidth() - this.borderWidth, this.box.getHeight() - this.borderWidth);
        pdfAppearance.lineTo(this.box.getWidth() - (this.borderWidth * 2.0f), this.box.getHeight() - (this.borderWidth * 2.0f));
        float width2 = this.box.getWidth();
        float f3 = this.borderWidth;
        pdfAppearance.lineTo(width2 - (f3 * 2.0f), f3 * 2.0f);
        float f4 = this.borderWidth;
        pdfAppearance.lineTo(f4 * 2.0f, f4 * 2.0f);
        float f5 = this.borderWidth;
        pdfAppearance.lineTo(f5, f5);
        pdfAppearance.fill();
    }

    private void drawTopFrame(PdfAppearance pdfAppearance) {
        float f = this.borderWidth;
        pdfAppearance.moveTo(f, f);
        pdfAppearance.lineTo(this.borderWidth, this.box.getHeight() - this.borderWidth);
        pdfAppearance.lineTo(this.box.getWidth() - this.borderWidth, this.box.getHeight() - this.borderWidth);
        pdfAppearance.lineTo(this.box.getWidth() - (this.borderWidth * 2.0f), this.box.getHeight() - (this.borderWidth * 2.0f));
        pdfAppearance.lineTo(this.borderWidth * 2.0f, this.box.getHeight() - (this.borderWidth * 2.0f));
        float f2 = this.borderWidth;
        pdfAppearance.lineTo(f2 * 2.0f, f2 * 2.0f);
        float f3 = this.borderWidth;
        pdfAppearance.lineTo(f3, f3);
        pdfAppearance.fill();
    }

    public static ArrayList<String> getHardBreaks(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (i < length) {
            char c = charArray[i];
            if (c == '\r') {
                int i2 = i + 1;
                if (i2 < length && charArray[i2] == '\n') {
                    i = i2;
                }
                arrayList.add(stringBuffer.toString());
                stringBuffer = new StringBuffer();
            } else if (c == '\n') {
                arrayList.add(stringBuffer.toString());
                stringBuffer = new StringBuffer();
            } else {
                stringBuffer.append(c);
            }
            i++;
        }
        arrayList.add(stringBuffer.toString());
        return arrayList;
    }

    public static void moveFields(PdfDictionary pdfDictionary, PdfDictionary pdfDictionary2) {
        Iterator<PdfName> it = pdfDictionary.getKeys().iterator();
        while (it.hasNext()) {
            PdfName next = it.next();
            if (fieldKeys.containsKey(next)) {
                if (pdfDictionary2 != null) {
                    pdfDictionary2.put(next, pdfDictionary.get(next));
                }
                it.remove();
            }
        }
    }

    public static void trimRight(StringBuffer stringBuffer) {
        int length = stringBuffer.length();
        while (length != 0) {
            length--;
            if (stringBuffer.charAt(length) != ' ') {
                return;
            } else {
                stringBuffer.setLength(length);
            }
        }
    }

    public int getAlignment() {
        return this.alignment;
    }

    public BaseColor getBackgroundColor() {
        return this.backgroundColor;
    }

    public PdfAppearance getBorderAppearance() {
        BaseColor baseColor;
        BaseColor baseColor2;
        BaseColor baseColor3;
        PdfAppearance pdfAppearanceCreateAppearance = PdfAppearance.createAppearance(this.writer, this.box.getWidth(), this.box.getHeight());
        int i = this.rotation;
        if (i == 90) {
            pdfAppearanceCreateAppearance.setMatrix(0.0f, 1.0f, -1.0f, 0.0f, this.box.getHeight(), 0.0f);
        } else if (i == 180) {
            pdfAppearanceCreateAppearance.setMatrix(-1.0f, 0.0f, 0.0f, -1.0f, this.box.getWidth(), this.box.getHeight());
        } else if (i == 270) {
            pdfAppearanceCreateAppearance.setMatrix(0.0f, -1.0f, 1.0f, 0.0f, 0.0f, this.box.getWidth());
        }
        pdfAppearanceCreateAppearance.saveState();
        BaseColor baseColor4 = this.backgroundColor;
        if (baseColor4 != null) {
            pdfAppearanceCreateAppearance.setColorFill(baseColor4);
            pdfAppearanceCreateAppearance.rectangle(0.0f, 0.0f, this.box.getWidth(), this.box.getHeight());
            pdfAppearanceCreateAppearance.fill();
        }
        int i2 = this.borderStyle;
        if (i2 == 4) {
            if (this.borderWidth != 0.0f && (baseColor3 = this.borderColor) != null) {
                pdfAppearanceCreateAppearance.setColorStroke(baseColor3);
                pdfAppearanceCreateAppearance.setLineWidth(this.borderWidth);
                pdfAppearanceCreateAppearance.moveTo(0.0f, this.borderWidth / 2.0f);
                pdfAppearanceCreateAppearance.lineTo(this.box.getWidth(), this.borderWidth / 2.0f);
                pdfAppearanceCreateAppearance.stroke();
            }
        } else if (i2 == 2) {
            if (this.borderWidth != 0.0f && (baseColor2 = this.borderColor) != null) {
                pdfAppearanceCreateAppearance.setColorStroke(baseColor2);
                pdfAppearanceCreateAppearance.setLineWidth(this.borderWidth);
                float f = this.borderWidth;
                pdfAppearanceCreateAppearance.rectangle(f / 2.0f, f / 2.0f, this.box.getWidth() - this.borderWidth, this.box.getHeight() - this.borderWidth);
                pdfAppearanceCreateAppearance.stroke();
            }
            BaseColor baseColor5 = this.backgroundColor;
            if (baseColor5 == null) {
                baseColor5 = BaseColor.WHITE;
            }
            pdfAppearanceCreateAppearance.setGrayFill(1.0f);
            drawTopFrame(pdfAppearanceCreateAppearance);
            pdfAppearanceCreateAppearance.setColorFill(baseColor5.darker());
            drawBottomFrame(pdfAppearanceCreateAppearance);
        } else if (i2 == 3) {
            if (this.borderWidth != 0.0f && (baseColor = this.borderColor) != null) {
                pdfAppearanceCreateAppearance.setColorStroke(baseColor);
                pdfAppearanceCreateAppearance.setLineWidth(this.borderWidth);
                float f2 = this.borderWidth;
                pdfAppearanceCreateAppearance.rectangle(f2 / 2.0f, f2 / 2.0f, this.box.getWidth() - this.borderWidth, this.box.getHeight() - this.borderWidth);
                pdfAppearanceCreateAppearance.stroke();
            }
            pdfAppearanceCreateAppearance.setGrayFill(0.5f);
            drawTopFrame(pdfAppearanceCreateAppearance);
            pdfAppearanceCreateAppearance.setGrayFill(0.75f);
            drawBottomFrame(pdfAppearanceCreateAppearance);
        } else if (this.borderWidth != 0.0f && this.borderColor != null) {
            if (i2 == 1) {
                pdfAppearanceCreateAppearance.setLineDash(3.0f, 0.0f);
            }
            pdfAppearanceCreateAppearance.setColorStroke(this.borderColor);
            pdfAppearanceCreateAppearance.setLineWidth(this.borderWidth);
            float f3 = this.borderWidth;
            pdfAppearanceCreateAppearance.rectangle(f3 / 2.0f, f3 / 2.0f, this.box.getWidth() - this.borderWidth, this.box.getHeight() - this.borderWidth);
            pdfAppearanceCreateAppearance.stroke();
            if ((this.options & 16777216) != 0 && this.maxCharacterLength > 1) {
                float width = this.box.getWidth() / this.maxCharacterLength;
                float f4 = this.borderWidth / 2.0f;
                float height = this.box.getHeight() - (this.borderWidth / 2.0f);
                for (int i3 = 1; i3 < this.maxCharacterLength; i3++) {
                    float f5 = i3 * width;
                    pdfAppearanceCreateAppearance.moveTo(f5, f4);
                    pdfAppearanceCreateAppearance.lineTo(f5, height);
                }
                pdfAppearanceCreateAppearance.stroke();
            }
        }
        pdfAppearanceCreateAppearance.restoreState();
        return pdfAppearanceCreateAppearance;
    }

    public BaseColor getBorderColor() {
        return this.borderColor;
    }

    public int getBorderStyle() {
        return this.borderStyle;
    }

    public float getBorderWidth() {
        return this.borderWidth;
    }

    public Rectangle getBox() {
        return this.box;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public BaseFont getFont() {
        return this.font;
    }

    public float getFontSize() {
        return this.fontSize;
    }

    public int getMaxCharacterLength() {
        return this.maxCharacterLength;
    }

    public int getOptions() {
        return this.options;
    }

    public BaseFont getRealFont() {
        BaseFont baseFont = this.font;
        return baseFont == null ? BaseFont.createFont("Helvetica", "Cp1252", false) : baseFont;
    }

    public int getRotation() {
        return this.rotation;
    }

    public String getText() {
        return this.text;
    }

    public BaseColor getTextColor() {
        return this.textColor;
    }

    public int getVisibility() {
        return this.visibility;
    }

    public PdfWriter getWriter() {
        return this.writer;
    }

    public void setAlignment(int i) {
        this.alignment = i;
    }

    public void setBackgroundColor(BaseColor baseColor) {
        this.backgroundColor = baseColor;
    }

    public void setBorderColor(BaseColor baseColor) {
        this.borderColor = baseColor;
    }

    public void setBorderStyle(int i) {
        this.borderStyle = i;
    }

    public void setBorderWidth(float f) {
        this.borderWidth = f;
    }

    public void setBox(Rectangle rectangle) {
        if (rectangle == null) {
            this.box = null;
            return;
        }
        Rectangle rectangle2 = new Rectangle(rectangle);
        this.box = rectangle2;
        rectangle2.normalize();
    }

    public void setFieldName(String str) {
        this.fieldName = str;
    }

    public void setFont(BaseFont baseFont) {
        this.font = baseFont;
    }

    public void setFontSize(float f) {
        this.fontSize = f;
    }

    public void setMaxCharacterLength(int i) {
        this.maxCharacterLength = i;
    }

    public void setOptions(int i) {
        this.options = i;
    }

    public void setRotation(int i) {
        if (i % 90 != 0) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("rotation.must.be.a.multiple.of.90", new Object[0]));
        }
        int i2 = i % 360;
        if (i2 < 0) {
            i2 += 360;
        }
        this.rotation = i2;
    }

    public void setRotationFromPage(Rectangle rectangle) {
        setRotation(rectangle.getRotation());
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setTextColor(BaseColor baseColor) {
        this.textColor = baseColor;
    }

    public void setVisibility(int i) {
        this.visibility = i;
    }

    public void setWriter(PdfWriter pdfWriter) {
        this.writer = pdfWriter;
    }
}
