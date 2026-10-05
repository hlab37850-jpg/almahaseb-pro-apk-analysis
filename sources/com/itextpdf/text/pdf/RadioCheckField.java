package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Rectangle;

/* JADX INFO: loaded from: classes3.dex */
public class RadioCheckField extends BaseField {
    public static final int TYPE_CHECK = 1;
    public static final int TYPE_CIRCLE = 2;
    public static final int TYPE_CROSS = 3;
    public static final int TYPE_DIAMOND = 4;
    public static final int TYPE_SQUARE = 5;
    public static final int TYPE_STAR = 6;
    protected static String[] typeChars = {"4", "l", "8", "u", "n", "H"};
    protected int checkType;
    private boolean checked;
    private String onValue;

    public RadioCheckField(PdfWriter pdfWriter, Rectangle rectangle, String str, String str2) {
        super(pdfWriter, rectangle, str);
        setOnValue(str2);
        setCheckType(2);
    }

    public PdfAppearance getAppearance(boolean z, boolean z2) {
        float f;
        if (z && this.checkType == 2) {
            return getAppearanceRadioCircle(z2);
        }
        PdfAppearance borderAppearance = getBorderAppearance();
        if (!z2) {
            return borderAppearance;
        }
        BaseFont realFont = getRealFont();
        int i = this.borderStyle;
        boolean z3 = i == 2 || i == 3;
        float height = this.box.getHeight();
        float f2 = this.borderWidth;
        float f3 = height - (f2 * 2.0f);
        if (z3) {
            f3 -= f2 * 2.0f;
            f = f2 * 2.0f;
        } else {
            f = f2;
        }
        if (z3) {
            f2 *= 2.0f;
        }
        float fMin = Math.min(f, Math.max(f2, 1.0f));
        float f4 = fMin * 2.0f;
        float width = this.box.getWidth() - f4;
        float height2 = this.box.getHeight() - f4;
        float fMin2 = this.fontSize;
        if (fMin2 == 0.0f) {
            float widthPoint = realFont.getWidthPoint(this.text, 1.0f);
            fMin2 = Math.min(widthPoint == 0.0f ? 12.0f : width / widthPoint, f3 / realFont.getFontDescriptor(1, 1.0f));
        }
        borderAppearance.saveState();
        borderAppearance.rectangle(fMin, fMin, width, height2);
        borderAppearance.clip();
        borderAppearance.newPath();
        BaseColor baseColor = this.textColor;
        if (baseColor == null) {
            borderAppearance.resetGrayFill();
        } else {
            borderAppearance.setColorFill(baseColor);
        }
        borderAppearance.beginText();
        borderAppearance.setFontAndSize(realFont, fMin2);
        borderAppearance.setTextMatrix((this.box.getWidth() - realFont.getWidthPoint(this.text, fMin2)) / 2.0f, (this.box.getHeight() - realFont.getAscentPoint(this.text, fMin2)) / 2.0f);
        borderAppearance.showText(this.text);
        borderAppearance.endText();
        borderAppearance.restoreState();
        return borderAppearance;
    }

    public PdfAppearance getAppearanceRadioCircle(boolean z) {
        PdfAppearance pdfAppearanceCreateAppearance = PdfAppearance.createAppearance(this.writer, this.box.getWidth(), this.box.getHeight());
        int i = this.rotation;
        if (i == 90) {
            pdfAppearanceCreateAppearance.setMatrix(0.0f, 1.0f, -1.0f, 0.0f, this.box.getHeight(), 0.0f);
        } else if (i == 180) {
            pdfAppearanceCreateAppearance.setMatrix(-1.0f, 0.0f, 0.0f, -1.0f, this.box.getWidth(), this.box.getHeight());
        } else if (i == 270) {
            pdfAppearanceCreateAppearance.setMatrix(0.0f, -1.0f, 1.0f, 0.0f, 0.0f, this.box.getWidth());
        }
        Rectangle rectangle = new Rectangle(pdfAppearanceCreateAppearance.getBoundingBox());
        float width = rectangle.getWidth() / 2.0f;
        float height = rectangle.getHeight() / 2.0f;
        float fMin = (Math.min(rectangle.getWidth(), rectangle.getHeight()) - this.borderWidth) / 2.0f;
        if (fMin <= 0.0f) {
            return pdfAppearanceCreateAppearance;
        }
        BaseColor baseColor = this.backgroundColor;
        if (baseColor != null) {
            pdfAppearanceCreateAppearance.setColorFill(baseColor);
            pdfAppearanceCreateAppearance.circle(width, height, (this.borderWidth / 2.0f) + fMin);
            pdfAppearanceCreateAppearance.fill();
        }
        float f = this.borderWidth;
        if (f > 0.0f && this.borderColor != null) {
            pdfAppearanceCreateAppearance.setLineWidth(f);
            pdfAppearanceCreateAppearance.setColorStroke(this.borderColor);
            pdfAppearanceCreateAppearance.circle(width, height, fMin);
            pdfAppearanceCreateAppearance.stroke();
        }
        if (z) {
            BaseColor baseColor2 = this.textColor;
            if (baseColor2 == null) {
                pdfAppearanceCreateAppearance.resetGrayFill();
            } else {
                pdfAppearanceCreateAppearance.setColorFill(baseColor2);
            }
            pdfAppearanceCreateAppearance.circle(width, height, fMin / 2.0f);
            pdfAppearanceCreateAppearance.fill();
        }
        return pdfAppearanceCreateAppearance;
    }

    public PdfFormField getCheckField() {
        return getField(false);
    }

    public int getCheckType() {
        return this.checkType;
    }

    public PdfFormField getField(boolean z) {
        PdfFormField pdfFormFieldCreateEmpty = z ? PdfFormField.createEmpty(this.writer) : PdfFormField.createCheckBox(this.writer);
        pdfFormFieldCreateEmpty.setWidget(this.box, PdfAnnotation.HIGHLIGHT_INVERT);
        if (!z) {
            pdfFormFieldCreateEmpty.setFieldName(this.fieldName);
            if ((this.options & 1) != 0) {
                pdfFormFieldCreateEmpty.setFieldFlags(1);
            }
            if ((this.options & 2) != 0) {
                pdfFormFieldCreateEmpty.setFieldFlags(2);
            }
            pdfFormFieldCreateEmpty.setValueAsName(this.checked ? this.onValue : "Off");
            setCheckType(this.checkType);
        }
        String str = this.text;
        if (str != null) {
            pdfFormFieldCreateEmpty.setMKNormalCaption(str);
        }
        int i = this.rotation;
        if (i != 0) {
            pdfFormFieldCreateEmpty.setMKRotation(i);
        }
        pdfFormFieldCreateEmpty.setBorderStyle(new PdfBorderDictionary(this.borderWidth, this.borderStyle, new PdfDashPattern(3.0f)));
        PdfAppearance appearance = getAppearance(z, true);
        PdfAppearance appearance2 = getAppearance(z, false);
        PdfName pdfName = PdfAnnotation.APPEARANCE_NORMAL;
        pdfFormFieldCreateEmpty.setAppearance(pdfName, this.onValue, appearance);
        pdfFormFieldCreateEmpty.setAppearance(pdfName, "Off", appearance2);
        pdfFormFieldCreateEmpty.setAppearanceState(this.checked ? this.onValue : "Off");
        PdfAppearance pdfAppearance = (PdfAppearance) appearance.getDuplicate();
        if (getRealFont() != null) {
            pdfAppearance.setFontAndSize(getRealFont(), this.fontSize);
        }
        BaseColor baseColor = this.textColor;
        if (baseColor == null) {
            pdfAppearance.setGrayFill(0.0f);
        } else {
            pdfAppearance.setColorFill(baseColor);
        }
        pdfFormFieldCreateEmpty.setDefaultAppearanceString(pdfAppearance);
        BaseColor baseColor2 = this.borderColor;
        if (baseColor2 != null) {
            pdfFormFieldCreateEmpty.setMKBorderColor(baseColor2);
        }
        BaseColor baseColor3 = this.backgroundColor;
        if (baseColor3 != null) {
            pdfFormFieldCreateEmpty.setMKBackgroundColor(baseColor3);
        }
        int i2 = this.visibility;
        if (i2 == 1) {
            pdfFormFieldCreateEmpty.setFlags(6);
        } else if (i2 != 2) {
            if (i2 != 3) {
                pdfFormFieldCreateEmpty.setFlags(4);
            } else {
                pdfFormFieldCreateEmpty.setFlags(36);
            }
        }
        return pdfFormFieldCreateEmpty;
    }

    public String getOnValue() {
        return this.onValue;
    }

    public PdfFormField getRadioField() {
        return getField(true);
    }

    public PdfFormField getRadioGroup(boolean z, boolean z2) {
        PdfFormField pdfFormFieldCreateRadioButton = PdfFormField.createRadioButton(this.writer, z);
        if (z2) {
            pdfFormFieldCreateRadioButton.setFieldFlags(33554432);
        }
        pdfFormFieldCreateRadioButton.setFieldName(this.fieldName);
        if ((this.options & 1) != 0) {
            pdfFormFieldCreateRadioButton.setFieldFlags(1);
        }
        if ((this.options & 2) != 0) {
            pdfFormFieldCreateRadioButton.setFieldFlags(2);
        }
        pdfFormFieldCreateRadioButton.setValueAsName(this.checked ? this.onValue : "Off");
        return pdfFormFieldCreateRadioButton;
    }

    public boolean isChecked() {
        return this.checked;
    }

    public void setCheckType(int i) {
        if (i < 1 || i > 6) {
            i = 2;
        }
        this.checkType = i;
        setText(typeChars[i - 1]);
        try {
            setFont(BaseFont.createFont("ZapfDingbats", "Cp1252", false));
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public void setChecked(boolean z) {
        this.checked = z;
    }

    public void setOnValue(String str) {
        this.onValue = str;
    }
}
