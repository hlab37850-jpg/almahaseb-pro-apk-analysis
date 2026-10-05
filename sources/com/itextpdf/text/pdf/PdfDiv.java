package com.itextpdf.text.pdf;

import com.itextpdf.awt.geom.AffineTransform;
import com.itextpdf.text.AccessibleElementId;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ElementListener;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.api.Spaceable;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class PdfDiv implements Element, Spaceable, IAccessibleElement {
    private Image backgroundImage;
    private Float backgroundImageHeight;
    private Float backgroundImageWidth;
    private BorderTopStyle borderTopStyle;
    private DisplayType display;
    protected float spacingAfter;
    protected float spacingBefore;
    private float yLine;
    private Float left = null;
    private Float top = null;
    private Float right = null;
    private Float bottom = null;
    private Float width = null;
    private Float height = null;
    private Float percentageHeight = null;
    private Float percentageWidth = null;
    private float contentWidth = 0.0f;
    private float contentHeight = 0.0f;
    private int textAlignment = -1;
    private float paddingLeft = 0.0f;
    private float paddingRight = 0.0f;
    private float paddingTop = 0.0f;
    private float paddingBottom = 0.0f;
    private FloatType floatType = FloatType.NONE;
    private PositionType position = PositionType.STATIC;
    private FloatLayout floatLayout = null;
    protected int runDirection = 1;
    protected PdfName role = PdfName.DIV;
    protected HashMap<PdfName, PdfObject> accessibleAttributes = null;
    protected AccessibleElementId id = new AccessibleElementId();
    private BaseColor backgroundColor = null;
    private ArrayList<Element> content = new ArrayList<>();
    private boolean keepTogether = false;

    public enum BorderTopStyle {
        DOTTED,
        DASHED,
        SOLID,
        DOUBLE,
        GROOVE,
        RIDGE,
        INSET,
        OUTSET
    }

    public enum DisplayType {
        NONE,
        BLOCK,
        INLINE,
        INLINE_BLOCK,
        INLINE_TABLE,
        LIST_ITEM,
        RUN_IN,
        TABLE,
        TABLE_CAPTION,
        TABLE_CELL,
        TABLE_COLUMN_GROUP,
        TABLE_COLUMN,
        TABLE_FOOTER_GROUP,
        TABLE_HEADER_GROUP,
        TABLE_ROW,
        TABLE_ROW_GROUP
    }

    public enum FloatType {
        NONE,
        LEFT,
        RIGHT
    }

    public enum PositionType {
        STATIC,
        ABSOLUTE,
        FIXED,
        RELATIVE
    }

    public void addElement(Element element) {
        this.content.add(element);
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public PdfObject getAccessibleAttribute(PdfName pdfName) {
        HashMap<PdfName, PdfObject> map = this.accessibleAttributes;
        if (map != null) {
            return map.get(pdfName);
        }
        return null;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public HashMap<PdfName, PdfObject> getAccessibleAttributes() {
        return this.accessibleAttributes;
    }

    public float getActualHeight() {
        Float f = this.height;
        return (f == null || f.floatValue() < this.contentHeight) ? this.contentHeight : this.height.floatValue();
    }

    public float getActualWidth() {
        Float f = this.width;
        return (f == null || f.floatValue() < this.contentWidth) ? this.contentWidth : this.width.floatValue();
    }

    public BaseColor getBackgroundColor() {
        return this.backgroundColor;
    }

    public BorderTopStyle getBorderTopStyle() {
        return this.borderTopStyle;
    }

    public Float getBottom() {
        return this.bottom;
    }

    @Override // com.itextpdf.text.Element
    public List<Chunk> getChunks() {
        return new ArrayList();
    }

    public ArrayList<Element> getContent() {
        return this.content;
    }

    public float getContentHeight() {
        return this.contentHeight;
    }

    public float getContentWidth() {
        return this.contentWidth;
    }

    public DisplayType getDisplay() {
        return this.display;
    }

    public FloatType getFloatType() {
        return this.floatType;
    }

    public Float getHeight() {
        return this.height;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public AccessibleElementId getId() {
        return this.id;
    }

    public boolean getKeepTogether() {
        return this.keepTogether;
    }

    public Float getLeft() {
        return this.left;
    }

    public float getPaddingBottom() {
        return this.paddingBottom;
    }

    public float getPaddingLeft() {
        return this.paddingLeft;
    }

    public float getPaddingRight() {
        return this.paddingRight;
    }

    @Override // com.itextpdf.text.api.Spaceable
    public float getPaddingTop() {
        return this.paddingTop;
    }

    public Float getPercentageHeight() {
        return this.percentageHeight;
    }

    public Float getPercentageWidth() {
        return this.percentageWidth;
    }

    public PositionType getPosition() {
        return this.position;
    }

    public Float getRight() {
        return this.right;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public PdfName getRole() {
        return this.role;
    }

    public int getRunDirection() {
        return this.runDirection;
    }

    @Override // com.itextpdf.text.api.Spaceable
    public float getSpacingAfter() {
        return this.spacingAfter;
    }

    @Override // com.itextpdf.text.api.Spaceable
    public float getSpacingBefore() {
        return this.spacingBefore;
    }

    public int getTextAlignment() {
        return this.textAlignment;
    }

    public Float getTop() {
        return this.top;
    }

    public Float getWidth() {
        return this.width;
    }

    public float getYLine() {
        return this.yLine;
    }

    @Override // com.itextpdf.text.Element
    public boolean isContent() {
        return true;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public boolean isInline() {
        return false;
    }

    @Override // com.itextpdf.text.Element
    public boolean isNestable() {
        return true;
    }

    public int layout(PdfContentByte pdfContentByte, boolean z, boolean z2, float f, float f2, float f3, float f4) {
        DisplayType displayType;
        float fFloatValue;
        boolean z3;
        int iLayout;
        float fMin = Math.min(f, f3);
        float fMax = Math.max(f2, f4);
        float fMin2 = Math.min(f2, f4);
        float fMax2 = Math.max(f, f3);
        this.yLine = fMax;
        Float f5 = this.width;
        Float fValueOf = Float.valueOf(0.0f);
        if (f5 == null || f5.floatValue() <= 0.0f) {
            Float f6 = this.percentageWidth;
            if (f6 != null) {
                fFloatValue = (fMax2 - fMin) * f6.floatValue();
                this.contentWidth = fFloatValue;
                fMax2 = fFloatValue + fMin;
            } else if (f6 == null && this.floatType == FloatType.NONE && ((displayType = this.display) == null || displayType == DisplayType.BLOCK || displayType == DisplayType.LIST_ITEM || displayType == DisplayType.RUN_IN)) {
                this.contentWidth = fMax2 - fMin;
            }
        } else {
            float f7 = fMax2 - fMin;
            if (this.width.floatValue() < f7) {
                fFloatValue = this.width.floatValue();
                fMax2 = fFloatValue + fMin;
            } else if (this.width.floatValue() > f7) {
                return 2;
            }
        }
        Float f8 = this.height;
        if (f8 == null || f8.floatValue() <= 0.0f) {
            Float f9 = this.percentageHeight;
            if (f9 != null) {
                z3 = ((double) f9.floatValue()) < 1.0d;
                float fFloatValue2 = (fMax - fMin2) * this.percentageHeight.floatValue();
                this.contentHeight = fFloatValue2;
                fMin2 = fMax - fFloatValue2;
            } else {
                z3 = false;
            }
        } else {
            float f10 = fMax - fMin2;
            if (this.height.floatValue() < f10) {
                fMin2 = fMax - this.height.floatValue();
                z3 = true;
            } else {
                if (this.height.floatValue() > f10) {
                    return 2;
                }
                z3 = false;
            }
        }
        if (!z2 && this.position == PositionType.RELATIVE) {
            Float fValueOf2 = this.left;
            if (fValueOf2 == null) {
                Float f11 = this.right;
                fValueOf2 = f11 != null ? Float.valueOf(-f11.floatValue()) : fValueOf;
            }
            Float f12 = this.top;
            if (f12 != null) {
                fValueOf = Float.valueOf(-f12.floatValue());
            } else {
                Float f13 = this.bottom;
                if (f13 != null) {
                    fValueOf = f13;
                }
            }
            pdfContentByte.saveState();
            pdfContentByte.transform(new AffineTransform(1.0f, 0.0f, 0.0f, 1.0f, fValueOf2.floatValue(), fValueOf.floatValue()));
        }
        if (!z2 && ((this.backgroundColor != null || this.backgroundImage != null) && getActualWidth() > 0.0f && getActualHeight() > 0.0f)) {
            float actualWidth = getActualWidth();
            float actualHeight = getActualHeight();
            Float f14 = this.width;
            if (f14 != null) {
                actualWidth = f14.floatValue() > 0.0f ? this.width.floatValue() : 0.0f;
            }
            Float f15 = this.height;
            if (f15 != null) {
                actualHeight = f15.floatValue() > 0.0f ? this.height.floatValue() : 0.0f;
            }
            if (actualWidth > 0.0f && actualHeight > 0.0f) {
                Rectangle rectangle = new Rectangle(fMin, fMax - actualHeight, actualWidth + fMin, fMax);
                BaseColor baseColor = this.backgroundColor;
                if (baseColor != null) {
                    rectangle.setBackgroundColor(baseColor);
                    PdfArtifact pdfArtifact = new PdfArtifact();
                    pdfContentByte.openMCBlock(pdfArtifact);
                    pdfContentByte.rectangle(rectangle);
                    pdfContentByte.closeMCBlock(pdfArtifact);
                }
                Image image = this.backgroundImage;
                if (image != null) {
                    Float f16 = this.backgroundImageWidth;
                    if (f16 == null) {
                        image.scaleToFit(rectangle);
                    } else {
                        image.scaleAbsolute(f16.floatValue(), this.backgroundImageHeight.floatValue());
                    }
                    this.backgroundImage.setAbsolutePosition(rectangle.getLeft(), rectangle.getBottom());
                    pdfContentByte.openMCBlock(this.backgroundImage);
                    pdfContentByte.addImage(this.backgroundImage);
                    pdfContentByte.closeMCBlock(this.backgroundImage);
                }
            }
        }
        if (this.percentageWidth == null) {
            this.contentWidth = 0.0f;
        }
        if (this.percentageHeight == null) {
            this.contentHeight = 0.0f;
        }
        float f17 = fMin2 + this.paddingBottom;
        float f18 = fMin + this.paddingLeft;
        float f19 = fMax2 - this.paddingRight;
        this.yLine -= this.paddingTop;
        if (this.content.isEmpty()) {
            iLayout = 1;
        } else {
            if (this.floatLayout == null) {
                FloatLayout floatLayout = new FloatLayout(new ArrayList(this.content), z);
                this.floatLayout = floatLayout;
                floatLayout.setRunDirection(this.runDirection);
            }
            this.floatLayout.setSimpleColumn(f18, f17, f19, this.yLine);
            if (getBorderTopStyle() != null) {
                this.floatLayout.compositeColumn.setIgnoreSpacingBefore(false);
            }
            iLayout = this.floatLayout.layout(pdfContentByte, z2);
            this.yLine = this.floatLayout.getYLine();
            if (this.percentageWidth == null && this.contentWidth < this.floatLayout.getFilledWidth()) {
                this.contentWidth = this.floatLayout.getFilledWidth();
            }
        }
        if (!z2 && this.position == PositionType.RELATIVE) {
            pdfContentByte.restoreState();
        }
        float f20 = this.yLine - this.paddingBottom;
        this.yLine = f20;
        if (this.percentageHeight == null) {
            this.contentHeight = fMax - f20;
        }
        if (this.percentageWidth == null) {
            this.contentWidth += this.paddingLeft + this.paddingRight;
        }
        if (z3) {
            return 1;
        }
        return iLayout;
    }

    @Override // com.itextpdf.text.Element
    public boolean process(ElementListener elementListener) {
        try {
            return elementListener.add(this);
        } catch (DocumentException unused) {
            return false;
        }
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public void setAccessibleAttribute(PdfName pdfName, PdfObject pdfObject) {
        if (this.accessibleAttributes == null) {
            this.accessibleAttributes = new HashMap<>();
        }
        this.accessibleAttributes.put(pdfName, pdfObject);
    }

    public void setBackgroundColor(BaseColor baseColor) {
        this.backgroundColor = baseColor;
    }

    public void setBackgroundImage(Image image) {
        this.backgroundImage = image;
    }

    public void setBorderTopStyle(BorderTopStyle borderTopStyle) {
        this.borderTopStyle = borderTopStyle;
    }

    public void setBottom(Float f) {
        this.bottom = f;
    }

    public void setContent(ArrayList<Element> arrayList) {
        this.content = arrayList;
    }

    public void setContentHeight(float f) {
        this.contentHeight = f;
    }

    public void setContentWidth(float f) {
        this.contentWidth = f;
    }

    public void setDisplay(DisplayType displayType) {
        this.display = displayType;
    }

    public void setFloatType(FloatType floatType) {
        this.floatType = floatType;
    }

    public void setHeight(Float f) {
        this.height = f;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public void setId(AccessibleElementId accessibleElementId) {
        this.id = accessibleElementId;
    }

    public void setKeepTogether(boolean z) {
        this.keepTogether = z;
    }

    public void setLeft(Float f) {
        this.left = f;
    }

    public void setPaddingBottom(float f) {
        this.paddingBottom = f;
    }

    public void setPaddingLeft(float f) {
        this.paddingLeft = f;
    }

    public void setPaddingRight(float f) {
        this.paddingRight = f;
    }

    @Override // com.itextpdf.text.api.Spaceable
    public void setPaddingTop(float f) {
        this.paddingTop = f;
    }

    public void setPercentageHeight(Float f) {
        this.percentageHeight = f;
    }

    public void setPercentageWidth(Float f) {
        this.percentageWidth = f;
    }

    public void setPosition(PositionType positionType) {
        this.position = positionType;
    }

    public void setRight(Float f) {
        this.right = f;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public void setRole(PdfName pdfName) {
        this.role = pdfName;
    }

    public void setRunDirection(int i) {
        this.runDirection = i;
    }

    @Override // com.itextpdf.text.api.Spaceable
    public void setSpacingAfter(float f) {
        this.spacingAfter = f;
    }

    @Override // com.itextpdf.text.api.Spaceable
    public void setSpacingBefore(float f) {
        this.spacingBefore = f;
    }

    public void setTextAlignment(int i) {
        this.textAlignment = i;
    }

    public void setTop(Float f) {
        this.top = f;
    }

    public void setWidth(Float f) {
        this.width = f;
    }

    @Override // com.itextpdf.text.Element
    public int type() {
        return 37;
    }

    public void setBackgroundImage(Image image, float f, float f2) {
        this.backgroundImage = image;
        this.backgroundImageWidth = Float.valueOf(f);
        this.backgroundImageHeight = Float.valueOf(f2);
    }
}
