package org.apache.poi.hssf.usermodel;

import org.apache.poi.ss.usermodel.RichTextString;

/* JADX INFO: loaded from: classes4.dex */
public class HSSFTextbox extends HSSFSimpleShape {
    public static final short HORIZONTAL_ALIGNMENT_CENTERED = 2;
    public static final short HORIZONTAL_ALIGNMENT_DISTRIBUTED = 7;
    public static final short HORIZONTAL_ALIGNMENT_JUSTIFIED = 4;
    public static final short HORIZONTAL_ALIGNMENT_LEFT = 1;
    public static final short HORIZONTAL_ALIGNMENT_RIGHT = 3;
    public static final short OBJECT_TYPE_TEXT = 6;
    public static final short VERTICAL_ALIGNMENT_BOTTOM = 3;
    public static final short VERTICAL_ALIGNMENT_CENTER = 2;
    public static final short VERTICAL_ALIGNMENT_DISTRIBUTED = 7;
    public static final short VERTICAL_ALIGNMENT_JUSTIFY = 4;
    public static final short VERTICAL_ALIGNMENT_TOP = 1;
    short halign;
    int marginBottom;
    int marginLeft;
    int marginRight;
    int marginTop;
    HSSFRichTextString string;
    short valign;

    public HSSFTextbox(HSSFShape hSSFShape, HSSFAnchor hSSFAnchor) {
        super(hSSFShape, hSSFAnchor);
        this.string = new HSSFRichTextString("");
        setShapeType(6);
        this.halign = (short) 1;
        this.valign = (short) 1;
    }

    public short getHorizontalAlignment() {
        return this.halign;
    }

    public int getMarginBottom() {
        return this.marginBottom;
    }

    public int getMarginLeft() {
        return this.marginLeft;
    }

    public int getMarginRight() {
        return this.marginRight;
    }

    public int getMarginTop() {
        return this.marginTop;
    }

    public HSSFRichTextString getString() {
        return this.string;
    }

    public short getVerticalAlignment() {
        return this.valign;
    }

    public void setHorizontalAlignment(short s) {
        this.halign = s;
    }

    public void setMarginBottom(int i) {
        this.marginBottom = i;
    }

    public void setMarginLeft(int i) {
        this.marginLeft = i;
    }

    public void setMarginRight(int i) {
        this.marginRight = i;
    }

    public void setMarginTop(int i) {
        this.marginTop = i;
    }

    public void setString(RichTextString richTextString) {
        HSSFRichTextString hSSFRichTextString = (HSSFRichTextString) richTextString;
        if (hSSFRichTextString.numFormattingRuns() == 0) {
            hSSFRichTextString.applyFont((short) 0);
        }
        this.string = hSSFRichTextString;
    }

    public void setVerticalAlignment(short s) {
        this.valign = s;
    }
}
