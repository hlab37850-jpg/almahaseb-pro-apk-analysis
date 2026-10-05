package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;

/* JADX INFO: loaded from: classes3.dex */
public class PushbuttonField extends BaseField {
    public static final int LAYOUT_ICON_LEFT_LABEL_RIGHT = 5;
    public static final int LAYOUT_ICON_ONLY = 2;
    public static final int LAYOUT_ICON_TOP_LABEL_BOTTOM = 3;
    public static final int LAYOUT_LABEL_LEFT_ICON_RIGHT = 6;
    public static final int LAYOUT_LABEL_ONLY = 1;
    public static final int LAYOUT_LABEL_OVER_ICON = 7;
    public static final int LAYOUT_LABEL_TOP_ICON_BOTTOM = 4;
    public static final int SCALE_ICON_ALWAYS = 1;
    public static final int SCALE_ICON_IS_TOO_BIG = 3;
    public static final int SCALE_ICON_IS_TOO_SMALL = 4;
    public static final int SCALE_ICON_NEVER = 2;
    private boolean iconFitToBounds;
    private float iconHorizontalAdjustment;
    private PRIndirectReference iconReference;
    private float iconVerticalAdjustment;
    private Image image;
    private int layout;
    private boolean proportionalIcon;
    private int scaleIcon;
    private PdfTemplate template;
    private PdfTemplate tp;

    public PushbuttonField(PdfWriter pdfWriter, Rectangle rectangle, String str) {
        super(pdfWriter, rectangle, str);
        this.layout = 1;
        this.scaleIcon = 1;
        this.proportionalIcon = true;
        this.iconVerticalAdjustment = 0.5f;
        this.iconHorizontalAdjustment = 0.5f;
    }

    private float calculateFontSize(float f, float f2) {
        BaseFont realFont = getRealFont();
        float f3 = this.fontSize;
        if (f3 != 0.0f) {
            return f3;
        }
        float widthPoint = realFont.getWidthPoint(this.text, 1.0f);
        float fMin = Math.min(widthPoint == 0.0f ? 12.0f : f / widthPoint, f2 / (1.0f - realFont.getFontDescriptor(3, 1.0f)));
        if (fMin < 4.0f) {
            return 4.0f;
        }
        return fMin;
    }

    /* JADX WARN: Code duplicated, block: B:105:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:107:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:121:0x0217  */
    /* JADX WARN: Code duplicated, block: B:128:0x0241  */
    /* JADX WARN: Code duplicated, block: B:131:0x0245  */
    /* JADX WARN: Code duplicated, block: B:138:0x0271  */
    /* JADX WARN: Code duplicated, block: B:147:0x028c  */
    /* JADX WARN: Code duplicated, block: B:149:0x0290  */
    /* JADX WARN: Code duplicated, block: B:151:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:153:0x02e4  */
    /* JADX WARN: Code duplicated, block: B:154:0x0338  */
    /* JADX WARN: Code duplicated, block: B:159:0x0362  */
    /* JADX WARN: Code duplicated, block: B:161:0x0369  */
    /* JADX WARN: Code duplicated, block: B:163:0x0377  */
    /* JADX WARN: Code duplicated, block: B:165:0x037c  */
    /* JADX WARN: Code duplicated, block: B:167:0x037f  */
    /* JADX WARN: Code duplicated, block: B:169:0x0382  */
    /* JADX WARN: Code duplicated, block: B:170:0x0387  */
    /* JADX WARN: Code duplicated, block: B:171:0x0392  */
    /* JADX WARN: Code duplicated, block: B:172:0x039d  */
    /* JADX WARN: Code duplicated, block: B:174:0x03a4  */
    /* JADX WARN: Code duplicated, block: B:176:0x03ab  */
    /* JADX WARN: Code duplicated, block: B:178:0x03ae  */
    /* JADX WARN: Code duplicated, block: B:181:0x03b3  */
    /* JADX WARN: Code duplicated, block: B:183:0x03bf  */
    /* JADX WARN: Code duplicated, block: B:184:0x03ca  */
    /* JADX WARN: Code duplicated, block: B:187:0x0412  */
    /* JADX WARN: Code duplicated, block: B:188:0x0424  */
    /* JADX WARN: Code duplicated, block: B:199:0x044e A[PHI: r17
      0x044e: PHI (r17v1 float) = (r17v0 float), (r17v0 float), (r17v5 float) binds: [B:188:0x0424, B:190:0x042b, B:198:0x044c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:202:0x0471  */
    /* JADX WARN: Code duplicated, block: B:205:0x047b  */
    /* JADX WARN: Code duplicated, block: B:207:0x0495  */
    /* JADX WARN: Code duplicated, block: B:208:0x0499  */
    /* JADX WARN: Code duplicated, block: B:213:0x009d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:214:0x0213 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:215:0x0241 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:218:0x0102 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:221:0x0102 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:224:0x0102 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:227:0x0102 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:71:0x0104  */
    /* JADX WARN: Code duplicated, block: B:73:0x0108  */
    /* JADX WARN: Code duplicated, block: B:88:0x0167  */
    /* JADX WARN: Code duplicated, block: B:90:0x016b  */
    /* JADX WARN: Failed to find 'out' block for switch in B:48:0x009a. Please report as an issue. */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x00d4 -> B:47:0x0093). Please report as a decompilation issue!!! */
    public PdfAppearance getAppearance() throws DocumentException {
        float width;
        float height;
        Rectangle rectangle;
        float f;
        String str;
        String str2;
        String str3;
        String str4;
        float f2;
        float width2;
        float height2;
        PdfArray pdfArray;
        BaseColor baseColor;
        float width3;
        float height3;
        int i;
        float f3;
        float fMin;
        float left;
        float bottom;
        PdfTemplate pdfTemplate;
        float fFloatValue;
        int i2;
        float fMin2;
        PRIndirectReference pRIndirectReference;
        PdfDictionary pdfDictionary;
        String str5;
        PdfAppearance borderAppearance = getBorderAppearance();
        Rectangle rectangle2 = new Rectangle(borderAppearance.getBoundingBox());
        String str6 = this.text;
        boolean z = true;
        if (((str6 == null || str6.length() == 0) && (this.layout == 1 || (this.image == null && this.template == null && this.iconReference == null))) || (this.layout == 2 && this.image == null && this.template == null && this.iconReference == null)) {
            return borderAppearance;
        }
        BaseFont realFont = getRealFont();
        int i3 = this.borderStyle;
        boolean z2 = i3 == 2 || i3 == 3;
        rectangle2.getHeight();
        float f4 = this.borderWidth;
        float f5 = z2 ? f4 * 2.0f : f4;
        if (z2) {
            f4 *= 2.0f;
        }
        float fMin3 = Math.min(f5, Math.max(f4, 1.0f));
        this.tp = null;
        float fCalculateFontSize = this.fontSize;
        float f6 = fMin3 * 2.0f;
        float width4 = (rectangle2.getWidth() - f6) - 2.0f;
        float height4 = rectangle2.getHeight() - f6;
        float f7 = 0.0f;
        float f8 = this.iconFitToBounds ? 0.0f : fMin3 + 1.0f;
        int i4 = this.layout;
        if (this.image == null && this.template == null && this.iconReference == null) {
            i4 = 1;
            while (true) {
                width = Float.NaN;
                switch (i4) {
                    case 1:
                    case 7:
                        str = this.text;
                        if (str != null) {
                            height = 0.0f;
                        } else {
                            height = 0.0f;
                        }
                        if (i4 == 7) {
                        }
                        rectangle = new Rectangle(rectangle2.getLeft() + f8, rectangle2.getBottom() + f8, rectangle2.getRight() - f8, rectangle2.getTop() - f8);
                        f = fCalculateFontSize;
                        break;
                    case 2:
                        height = 0.0f;
                        if (i4 == 7) {
                        }
                        rectangle = new Rectangle(rectangle2.getLeft() + f8, rectangle2.getBottom() + f8, rectangle2.getRight() - f8, rectangle2.getTop() - f8);
                        f = fCalculateFontSize;
                        break;
                    case 3:
                        str2 = this.text;
                        if (str2 != null) {
                            continue;
                        }
                        i4 = 2;
                        break;
                    case 4:
                        str3 = this.text;
                        if (str3 != null) {
                            continue;
                        }
                        i4 = 2;
                        break;
                    case 5:
                        str4 = this.text;
                        if (str4 != null) {
                            continue;
                        }
                        i4 = 2;
                        break;
                    case 6:
                        str5 = this.text;
                        if (str5 == null) {
                            continue;
                        }
                        i4 = 2;
                        break;
                    default:
                        f = fCalculateFontSize;
                        height = 0.0f;
                        rectangle = null;
                        break;
                }
                if (height < rectangle2.getBottom() + fMin3) {
                    height = rectangle2.getBottom() + fMin3;
                }
                f2 = height;
                if (rectangle != null) {
                    rectangle = null;
                }
                if (rectangle == null) {
                    z = false;
                    width2 = 0.0f;
                    height2 = 0.0f;
                    pdfArray = null;
                } else {
                    if (this.image != null) {
                        PdfTemplate pdfTemplate2 = new PdfTemplate(this.writer);
                        this.tp = pdfTemplate2;
                        pdfTemplate2.setBoundingBox(new Rectangle(this.image));
                        this.writer.addDirectTemplateSimple(this.tp, PdfName.FRM);
                        PdfTemplate pdfTemplate3 = this.tp;
                        Image image = this.image;
                        pdfTemplate3.addImage(image, image.getWidth(), 0.0f, 0.0f, this.image.getHeight(), 0.0f, 0.0f);
                        width2 = this.tp.getBoundingBox().getWidth();
                        height2 = this.tp.getBoundingBox().getHeight();
                    } else if (this.template != null) {
                        PdfTemplate pdfTemplate4 = new PdfTemplate(this.writer);
                        this.tp = pdfTemplate4;
                        pdfTemplate4.setBoundingBox(new Rectangle(this.template.getWidth(), this.template.getHeight()));
                        this.writer.addDirectTemplateSimple(this.tp, PdfName.FRM);
                        PdfTemplate pdfTemplate5 = this.tp;
                        PdfTemplate pdfTemplate6 = this.template;
                        pdfTemplate5.addTemplate(pdfTemplate6, pdfTemplate6.getBoundingBox().getLeft(), this.template.getBoundingBox().getBottom());
                        width2 = this.tp.getBoundingBox().getWidth();
                        height2 = this.tp.getBoundingBox().getHeight();
                    } else {
                        pRIndirectReference = this.iconReference;
                        if (pRIndirectReference != null) {
                        }
                        z = false;
                        width2 = 0.0f;
                        height2 = 0.0f;
                    }
                    pdfArray = null;
                }
                if (z) {
                    width3 = rectangle.getWidth() / width2;
                    height3 = rectangle.getHeight() / height2;
                    if (this.proportionalIcon) {
                        i2 = this.scaleIcon;
                        if (i2 != 2) {
                            fMin2 = 1.0f;
                        } else if (i2 != 3) {
                            fMin2 = Math.min(Math.min(width3, height3), 1.0f);
                        } else if (i2 != 4) {
                            fMin2 = Math.min(width3, height3);
                        } else {
                            fMin2 = Math.max(Math.min(width3, height3), 1.0f);
                        }
                        f3 = fMin2;
                        height3 = f3;
                    } else {
                        i = this.scaleIcon;
                        if (i != 2) {
                            if (i != 3) {
                                if (i == 4) {
                                    width3 = Math.max(width3, 1.0f);
                                    fMin = Math.max(height3, 1.0f);
                                }
                                f3 = width3;
                            } else {
                                width3 = Math.min(width3, 1.0f);
                                fMin = Math.min(height3, 1.0f);
                            }
                            height3 = fMin;
                            f3 = width3;
                        } else {
                            f3 = 1.0f;
                            height3 = 1.0f;
                        }
                    }
                    left = rectangle.getLeft() + ((rectangle.getWidth() - (width2 * f3)) * this.iconHorizontalAdjustment);
                    bottom = rectangle.getBottom() + ((rectangle.getHeight() - (height2 * height3)) * this.iconVerticalAdjustment);
                    borderAppearance.saveState();
                    borderAppearance.rectangle(rectangle.getLeft(), rectangle.getBottom(), rectangle.getWidth(), rectangle.getHeight());
                    borderAppearance.clip();
                    borderAppearance.newPath();
                    pdfTemplate = this.tp;
                    if (pdfTemplate != null) {
                        borderAppearance.addTemplate(pdfTemplate, f3, 0.0f, 0.0f, height3, left, bottom);
                    } else {
                        if (pdfArray == null) {
                            fFloatValue = 0.0f;
                        } else {
                            fFloatValue = 0.0f;
                        }
                        borderAppearance.addTemplateReference((PdfIndirectReference) this.iconReference, PdfName.FRM, f3, 0.0f, 0.0f, height3, left - (f7 * f3), bottom - (fFloatValue * height3));
                    }
                    borderAppearance.restoreState();
                } else {
                    f2 = f2;
                    width = width;
                }
                if (!Float.isNaN(width)) {
                    borderAppearance.saveState();
                    borderAppearance.rectangle(fMin3, fMin3, rectangle2.getWidth() - f6, rectangle2.getHeight() - f6);
                    borderAppearance.clip();
                    borderAppearance.newPath();
                    baseColor = this.textColor;
                    if (baseColor == null) {
                        borderAppearance.resetGrayFill();
                    } else {
                        borderAppearance.setColorFill(baseColor);
                    }
                    borderAppearance.beginText();
                    borderAppearance.setFontAndSize(realFont, f);
                    borderAppearance.setTextMatrix(width, f2);
                    borderAppearance.showText(this.text);
                    borderAppearance.endText();
                    borderAppearance.restoreState();
                }
            }
        } else {
            while (true) {
                width = Float.NaN;
                switch (i4) {
                    case 1:
                    case 7:
                        str = this.text;
                        if (str != null || str.length() <= 0 || width4 <= 0.0f || height4 <= 0.0f) {
                            height = 0.0f;
                        } else {
                            fCalculateFontSize = calculateFontSize(width4, height4);
                            width = (rectangle2.getWidth() - realFont.getWidthPoint(this.text, fCalculateFontSize)) / 2.0f;
                            height = (rectangle2.getHeight() - realFont.getFontDescriptor(1, fCalculateFontSize)) / 2.0f;
                        }
                        if (i4 == 7 && i4 != 2) {
                            f = fCalculateFontSize;
                            rectangle = null;
                        } else {
                            rectangle = new Rectangle(rectangle2.getLeft() + f8, rectangle2.getBottom() + f8, rectangle2.getRight() - f8, rectangle2.getTop() - f8);
                            f = fCalculateFontSize;
                        }
                        break;
                    case 2:
                        height = 0.0f;
                        if (i4 == 7) {
                        }
                        rectangle = new Rectangle(rectangle2.getLeft() + f8, rectangle2.getBottom() + f8, rectangle2.getRight() - f8, rectangle2.getTop() - f8);
                        f = fCalculateFontSize;
                        break;
                    case 3:
                        str2 = this.text;
                        if (str2 != null && str2.length() != 0 && width4 > 0.0f && height4 > 0.0f) {
                            float height5 = (rectangle2.getHeight() * 0.35f) - fMin3;
                            fCalculateFontSize = height5 > 0.0f ? calculateFontSize(width4, height5) : 4.0f;
                            width = (rectangle2.getWidth() - realFont.getWidthPoint(this.text, fCalculateFontSize)) / 2.0f;
                            height = fMin3 - realFont.getFontDescriptor(3, fCalculateFontSize);
                            rectangle = new Rectangle(rectangle2.getLeft() + f8, height + fCalculateFontSize, rectangle2.getRight() - f8, rectangle2.getTop() - f8);
                            f = fCalculateFontSize;
                        } else {
                            i4 = 2;
                        }
                        break;
                    case 4:
                        str3 = this.text;
                        if (str3 != null && str3.length() != 0 && width4 > 0.0f && height4 > 0.0f) {
                            float height6 = (rectangle2.getHeight() * 0.35f) - fMin3;
                            fCalculateFontSize = height6 > 0.0f ? calculateFontSize(width4, height6) : 4.0f;
                            width = (rectangle2.getWidth() - realFont.getWidthPoint(this.text, fCalculateFontSize)) / 2.0f;
                            height = (rectangle2.getHeight() - fMin3) - fCalculateFontSize;
                            if (height < fMin3) {
                                height = fMin3;
                            }
                            rectangle = new Rectangle(rectangle2.getLeft() + f8, rectangle2.getBottom() + f8, rectangle2.getRight() - f8, realFont.getFontDescriptor(3, fCalculateFontSize) + height);
                            f = fCalculateFontSize;
                        } else {
                            i4 = 2;
                        }
                        break;
                    case 5:
                        str4 = this.text;
                        if (str4 != null && str4.length() != 0 && width4 > 0.0f && height4 > 0.0f) {
                            float width5 = (rectangle2.getWidth() * 0.35f) - fMin3;
                            fCalculateFontSize = width5 > 0.0f ? calculateFontSize(width4, width5) : 4.0f;
                            if (realFont.getWidthPoint(this.text, fCalculateFontSize) >= width4) {
                                fCalculateFontSize = this.fontSize;
                                i4 = 1;
                                width = Float.NaN;
                                switch (i4) {
                                    case 1:
                                    case 7:
                                        str = this.text;
                                        if (str != null) {
                                            height = 0.0f;
                                        } else {
                                            height = 0.0f;
                                        }
                                        if (i4 == 7) {
                                        }
                                        rectangle = new Rectangle(rectangle2.getLeft() + f8, rectangle2.getBottom() + f8, rectangle2.getRight() - f8, rectangle2.getTop() - f8);
                                        break;
                                    case 2:
                                        height = 0.0f;
                                        if (i4 == 7) {
                                        }
                                        rectangle = new Rectangle(rectangle2.getLeft() + f8, rectangle2.getBottom() + f8, rectangle2.getRight() - f8, rectangle2.getTop() - f8);
                                        break;
                                    case 3:
                                        str2 = this.text;
                                        if (str2 != null) {
                                        }
                                        break;
                                    case 4:
                                        str3 = this.text;
                                        if (str3 != null) {
                                        }
                                        break;
                                    case 5:
                                        str4 = this.text;
                                        if (str4 != null) {
                                        }
                                        break;
                                    case 6:
                                        str5 = this.text;
                                        if (str5 == null || str5.length() == 0 || width4 <= 0.0f || height4 <= 0.0f) {
                                            break;
                                        } else {
                                            float width6 = (rectangle2.getWidth() * 0.35f) - fMin3;
                                            fCalculateFontSize = width6 > 0.0f ? calculateFontSize(width4, width6) : 4.0f;
                                            if (realFont.getWidthPoint(this.text, fCalculateFontSize) >= width4) {
                                                fCalculateFontSize = this.fontSize;
                                                i4 = 1;
                                                width = Float.NaN;
                                                switch (i4) {
                                                    case 1:
                                                    case 7:
                                                        str = this.text;
                                                        if (str != null) {
                                                            height = 0.0f;
                                                        } else {
                                                            height = 0.0f;
                                                        }
                                                        if (i4 == 7) {
                                                        }
                                                        rectangle = new Rectangle(rectangle2.getLeft() + f8, rectangle2.getBottom() + f8, rectangle2.getRight() - f8, rectangle2.getTop() - f8);
                                                        break;
                                                    case 2:
                                                        height = 0.0f;
                                                        if (i4 == 7) {
                                                        }
                                                        rectangle = new Rectangle(rectangle2.getLeft() + f8, rectangle2.getBottom() + f8, rectangle2.getRight() - f8, rectangle2.getTop() - f8);
                                                        break;
                                                    case 3:
                                                        str2 = this.text;
                                                        if (str2 != null) {
                                                        }
                                                        break;
                                                    case 4:
                                                        str3 = this.text;
                                                        if (str3 != null) {
                                                        }
                                                        break;
                                                    case 5:
                                                        str4 = this.text;
                                                        if (str4 != null) {
                                                        }
                                                        break;
                                                    case 6:
                                                        str5 = this.text;
                                                        if (str5 == null) {
                                                        }
                                                        break;
                                                    default:
                                                        f = fCalculateFontSize;
                                                        height = 0.0f;
                                                        rectangle = null;
                                                        break;
                                                }
                                            } else {
                                                width = fMin3 + 1.0f;
                                                height = (rectangle2.getHeight() - realFont.getFontDescriptor(1, fCalculateFontSize)) / 2.0f;
                                                rectangle = new Rectangle(width + realFont.getWidthPoint(this.text, fCalculateFontSize), rectangle2.getBottom() + f8, rectangle2.getRight() - f8, rectangle2.getTop() - f8);
                                                break;
                                            }
                                        }
                                        break;
                                    default:
                                        f = fCalculateFontSize;
                                        height = 0.0f;
                                        rectangle = null;
                                        break;
                                }
                            } else {
                                width = ((rectangle2.getWidth() - realFont.getWidthPoint(this.text, fCalculateFontSize)) - fMin3) - 1.0f;
                                height = (rectangle2.getHeight() - realFont.getFontDescriptor(1, fCalculateFontSize)) / 2.0f;
                                rectangle = new Rectangle(rectangle2.getLeft() + f8, rectangle2.getBottom() + f8, width - 1.0f, rectangle2.getTop() - f8);
                            }
                            f = fCalculateFontSize;
                            break;
                        }
                        i4 = 2;
                        break;
                    case 6:
                        str5 = this.text;
                        if (str5 == null) {
                            continue;
                        }
                        i4 = 2;
                        break;
                    default:
                        f = fCalculateFontSize;
                        height = 0.0f;
                        rectangle = null;
                        break;
                }
                if (height < rectangle2.getBottom() + fMin3) {
                    height = rectangle2.getBottom() + fMin3;
                }
                f2 = height;
                if (rectangle != null && (rectangle.getWidth() <= 0.0f || rectangle.getHeight() <= 0.0f)) {
                    rectangle = null;
                }
                if (rectangle == null) {
                    z = false;
                    width2 = 0.0f;
                    height2 = 0.0f;
                    pdfArray = null;
                } else {
                    if (this.image != null) {
                        PdfTemplate pdfTemplate7 = new PdfTemplate(this.writer);
                        this.tp = pdfTemplate7;
                        pdfTemplate7.setBoundingBox(new Rectangle(this.image));
                        this.writer.addDirectTemplateSimple(this.tp, PdfName.FRM);
                        PdfTemplate pdfTemplate8 = this.tp;
                        Image image2 = this.image;
                        pdfTemplate8.addImage(image2, image2.getWidth(), 0.0f, 0.0f, this.image.getHeight(), 0.0f, 0.0f);
                        width2 = this.tp.getBoundingBox().getWidth();
                        height2 = this.tp.getBoundingBox().getHeight();
                    } else if (this.template != null) {
                        PdfTemplate pdfTemplate9 = new PdfTemplate(this.writer);
                        this.tp = pdfTemplate9;
                        pdfTemplate9.setBoundingBox(new Rectangle(this.template.getWidth(), this.template.getHeight()));
                        this.writer.addDirectTemplateSimple(this.tp, PdfName.FRM);
                        PdfTemplate pdfTemplate10 = this.tp;
                        PdfTemplate pdfTemplate11 = this.template;
                        pdfTemplate10.addTemplate(pdfTemplate11, pdfTemplate11.getBoundingBox().getLeft(), this.template.getBoundingBox().getBottom());
                        width2 = this.tp.getBoundingBox().getWidth();
                        height2 = this.tp.getBoundingBox().getHeight();
                    } else {
                        pRIndirectReference = this.iconReference;
                        if (pRIndirectReference != null || (pdfDictionary = (PdfDictionary) PdfReader.getPdfObject(pRIndirectReference)) == null) {
                            z = false;
                            width2 = 0.0f;
                            height2 = 0.0f;
                        } else {
                            Rectangle normalizedRectangle = PdfReader.getNormalizedRectangle(pdfDictionary.getAsArray(PdfName.BBOX));
                            PdfArray asArray = pdfDictionary.getAsArray(PdfName.MATRIX);
                            float width7 = normalizedRectangle.getWidth();
                            height2 = normalizedRectangle.getHeight();
                            pdfArray = asArray;
                            width2 = width7;
                        }
                    }
                    pdfArray = null;
                }
                if (z) {
                    width3 = rectangle.getWidth() / width2;
                    height3 = rectangle.getHeight() / height2;
                    if (this.proportionalIcon) {
                        i2 = this.scaleIcon;
                        if (i2 != 2) {
                            fMin2 = 1.0f;
                        } else if (i2 != 3) {
                            fMin2 = Math.min(Math.min(width3, height3), 1.0f);
                        } else if (i2 != 4) {
                            fMin2 = Math.min(width3, height3);
                        } else {
                            fMin2 = Math.max(Math.min(width3, height3), 1.0f);
                        }
                        f3 = fMin2;
                        height3 = f3;
                    } else {
                        i = this.scaleIcon;
                        if (i != 2) {
                            if (i != 3) {
                                if (i == 4) {
                                    width3 = Math.max(width3, 1.0f);
                                    fMin = Math.max(height3, 1.0f);
                                }
                                f3 = width3;
                            } else {
                                width3 = Math.min(width3, 1.0f);
                                fMin = Math.min(height3, 1.0f);
                            }
                            height3 = fMin;
                            f3 = width3;
                        } else {
                            f3 = 1.0f;
                            height3 = 1.0f;
                        }
                    }
                    left = rectangle.getLeft() + ((rectangle.getWidth() - (width2 * f3)) * this.iconHorizontalAdjustment);
                    bottom = rectangle.getBottom() + ((rectangle.getHeight() - (height2 * height3)) * this.iconVerticalAdjustment);
                    borderAppearance.saveState();
                    borderAppearance.rectangle(rectangle.getLeft(), rectangle.getBottom(), rectangle.getWidth(), rectangle.getHeight());
                    borderAppearance.clip();
                    borderAppearance.newPath();
                    pdfTemplate = this.tp;
                    if (pdfTemplate != null) {
                        borderAppearance.addTemplate(pdfTemplate, f3, 0.0f, 0.0f, height3, left, bottom);
                    } else {
                        if (pdfArray == null && pdfArray.size() == 6) {
                            PdfNumber asNumber = pdfArray.getAsNumber(4);
                            float fFloatValue2 = asNumber != null ? asNumber.floatValue() : 0.0f;
                            PdfNumber asNumber2 = pdfArray.getAsNumber(5);
                            if (asNumber2 != null) {
                                f7 = fFloatValue2;
                                fFloatValue = asNumber2.floatValue();
                            } else {
                                f7 = fFloatValue2;
                                fFloatValue = 0.0f;
                            }
                        } else {
                            fFloatValue = 0.0f;
                        }
                        borderAppearance.addTemplateReference((PdfIndirectReference) this.iconReference, PdfName.FRM, f3, 0.0f, 0.0f, height3, left - (f7 * f3), bottom - (fFloatValue * height3));
                    }
                    borderAppearance.restoreState();
                } else {
                    f2 = f2;
                    width = width;
                }
                if (!Float.isNaN(width)) {
                    borderAppearance.saveState();
                    borderAppearance.rectangle(fMin3, fMin3, rectangle2.getWidth() - f6, rectangle2.getHeight() - f6);
                    borderAppearance.clip();
                    borderAppearance.newPath();
                    baseColor = this.textColor;
                    if (baseColor == null) {
                        borderAppearance.resetGrayFill();
                    } else {
                        borderAppearance.setColorFill(baseColor);
                    }
                    borderAppearance.beginText();
                    borderAppearance.setFontAndSize(realFont, f);
                    borderAppearance.setTextMatrix(width, f2);
                    borderAppearance.showText(this.text);
                    borderAppearance.endText();
                    borderAppearance.restoreState();
                }
            }
        }
        return borderAppearance;
    }

    public PdfFormField getField() throws DocumentException {
        PdfName pdfName;
        PdfFormField pdfFormFieldCreatePushButton = PdfFormField.createPushButton(this.writer);
        pdfFormFieldCreatePushButton.setWidget(this.box, PdfAnnotation.HIGHLIGHT_INVERT);
        String str = this.fieldName;
        if (str != null) {
            pdfFormFieldCreatePushButton.setFieldName(str);
            if ((this.options & 1) != 0) {
                pdfFormFieldCreatePushButton.setFieldFlags(1);
            }
            if ((this.options & 2) != 0) {
                pdfFormFieldCreatePushButton.setFieldFlags(2);
            }
        }
        String str2 = this.text;
        if (str2 != null) {
            pdfFormFieldCreatePushButton.setMKNormalCaption(str2);
        }
        int i = this.rotation;
        if (i != 0) {
            pdfFormFieldCreatePushButton.setMKRotation(i);
        }
        pdfFormFieldCreatePushButton.setBorderStyle(new PdfBorderDictionary(this.borderWidth, this.borderStyle, new PdfDashPattern(3.0f)));
        PdfAppearance appearance = getAppearance();
        pdfFormFieldCreatePushButton.setAppearance(PdfAnnotation.APPEARANCE_NORMAL, appearance);
        PdfAppearance pdfAppearance = (PdfAppearance) appearance.getDuplicate();
        pdfAppearance.setFontAndSize(getRealFont(), this.fontSize);
        BaseColor baseColor = this.textColor;
        if (baseColor == null) {
            pdfAppearance.setGrayFill(0.0f);
        } else {
            pdfAppearance.setColorFill(baseColor);
        }
        pdfFormFieldCreatePushButton.setDefaultAppearanceString(pdfAppearance);
        BaseColor baseColor2 = this.borderColor;
        if (baseColor2 != null) {
            pdfFormFieldCreatePushButton.setMKBorderColor(baseColor2);
        }
        BaseColor baseColor3 = this.backgroundColor;
        if (baseColor3 != null) {
            pdfFormFieldCreatePushButton.setMKBackgroundColor(baseColor3);
        }
        int i2 = this.visibility;
        if (i2 == 1) {
            pdfFormFieldCreatePushButton.setFlags(6);
        } else if (i2 != 2) {
            if (i2 != 3) {
                pdfFormFieldCreatePushButton.setFlags(4);
            } else {
                pdfFormFieldCreatePushButton.setFlags(36);
            }
        }
        PdfTemplate pdfTemplate = this.tp;
        if (pdfTemplate != null) {
            pdfFormFieldCreatePushButton.setMKNormalIcon(pdfTemplate);
        }
        pdfFormFieldCreatePushButton.setMKTextPosition(this.layout - 1);
        PdfName pdfName2 = PdfName.A;
        int i3 = this.scaleIcon;
        if (i3 == 3) {
            pdfName = PdfName.B;
        } else if (i3 == 4) {
            pdfName = PdfName.S;
        } else {
            pdfName = i3 == 2 ? PdfName.N : pdfName2;
        }
        if (this.proportionalIcon) {
            pdfName2 = PdfName.P;
        }
        pdfFormFieldCreatePushButton.setMKIconFit(pdfName, pdfName2, this.iconHorizontalAdjustment, this.iconVerticalAdjustment, this.iconFitToBounds);
        return pdfFormFieldCreatePushButton;
    }

    public float getIconHorizontalAdjustment() {
        return this.iconHorizontalAdjustment;
    }

    public PRIndirectReference getIconReference() {
        return this.iconReference;
    }

    public float getIconVerticalAdjustment() {
        return this.iconVerticalAdjustment;
    }

    public Image getImage() {
        return this.image;
    }

    public int getLayout() {
        return this.layout;
    }

    public int getScaleIcon() {
        return this.scaleIcon;
    }

    public PdfTemplate getTemplate() {
        return this.template;
    }

    public boolean isIconFitToBounds() {
        return this.iconFitToBounds;
    }

    public boolean isProportionalIcon() {
        return this.proportionalIcon;
    }

    public void setIconFitToBounds(boolean z) {
        this.iconFitToBounds = z;
    }

    public void setIconHorizontalAdjustment(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        this.iconHorizontalAdjustment = f;
    }

    public void setIconReference(PRIndirectReference pRIndirectReference) {
        this.iconReference = pRIndirectReference;
    }

    public void setIconVerticalAdjustment(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        this.iconVerticalAdjustment = f;
    }

    public void setImage(Image image) {
        this.image = image;
        this.template = null;
    }

    public void setLayout(int i) {
        if (i < 1 || i > 7) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("layout.out.of.bounds", new Object[0]));
        }
        this.layout = i;
    }

    public void setProportionalIcon(boolean z) {
        this.proportionalIcon = z;
    }

    public void setScaleIcon(int i) {
        if (i < 1 || i > 4) {
            i = 1;
        }
        this.scaleIcon = i;
    }

    public void setTemplate(PdfTemplate pdfTemplate) {
        this.template = pdfTemplate;
        this.image = null;
    }
}
