package com.itextpdf.text.pdf;

import com.itextpdf.text.AccessibleElementId;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.events.PdfPCellEventForwarder;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class PdfPCell extends Rectangle implements IAccessibleElement {
    protected HashMap<PdfName, PdfObject> accessibleAttributes;
    private float cachedMaxHeight;
    private float calculatedHeight;
    private PdfPCellEvent cellEvent;
    private int colspan;
    private ColumnText column;
    private float fixedHeight;
    protected ArrayList<PdfPHeaderCell> headers;
    protected AccessibleElementId id;
    private Image image;
    private float minimumHeight;
    private boolean noWrap;
    private float paddingBottom;
    private float paddingLeft;
    private float paddingRight;
    private float paddingTop;
    protected Phrase phrase;
    protected PdfName role;
    private int rotation;
    private int rowspan;
    private PdfPTable table;
    private boolean useBorderPadding;
    private boolean useDescender;
    private int verticalAlignment;

    public PdfPCell() {
        super(0.0f, 0.0f, 0.0f, 0.0f);
        this.column = new ColumnText(null);
        this.verticalAlignment = 4;
        this.paddingLeft = 2.0f;
        this.paddingRight = 2.0f;
        this.paddingTop = 2.0f;
        this.paddingBottom = 2.0f;
        this.fixedHeight = 0.0f;
        this.calculatedHeight = 0.0f;
        this.noWrap = false;
        this.colspan = 1;
        this.rowspan = 1;
        this.useDescender = false;
        this.useBorderPadding = false;
        this.role = PdfName.TD;
        this.accessibleAttributes = null;
        this.id = new AccessibleElementId();
        this.headers = null;
        this.borderWidth = 0.5f;
        this.border = 15;
        this.column.setLeading(0.0f, 1.0f);
    }

    public void addElement(Element element) {
        if (this.table != null) {
            this.table = null;
            this.column.setText(null);
        }
        if (element instanceof PdfPTable) {
            ((PdfPTable) element).setSplitLate(false);
        } else if (element instanceof PdfDiv) {
            for (Element element2 : ((PdfDiv) element).getContent()) {
                if (element2 instanceof PdfPTable) {
                    ((PdfPTable) element2).setSplitLate(false);
                }
            }
        }
        this.column.addElement(element);
    }

    public void addHeader(PdfPHeaderCell pdfPHeaderCell) {
        if (this.headers == null) {
            this.headers = new ArrayList<>();
        }
        this.headers.add(pdfPHeaderCell);
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

    public int getArabicOptions() {
        return this.column.getArabicOptions();
    }

    public float getCachedMaxHeight() {
        return this.cachedMaxHeight;
    }

    public float getCalculatedHeight() {
        return this.calculatedHeight;
    }

    public PdfPCellEvent getCellEvent() {
        return this.cellEvent;
    }

    public int getColspan() {
        return this.colspan;
    }

    public ColumnText getColumn() {
        return this.column;
    }

    public List<Element> getCompositeElements() {
        return getColumn().compositeElements;
    }

    public float getEffectivePaddingBottom() {
        if (isUseBorderPadding()) {
            return this.paddingBottom + (getBorderWidthBottom() / (isUseVariableBorders() ? 1.0f : 2.0f));
        }
        return this.paddingBottom;
    }

    public float getEffectivePaddingLeft() {
        if (isUseBorderPadding()) {
            return this.paddingLeft + (getBorderWidthLeft() / (isUseVariableBorders() ? 1.0f : 2.0f));
        }
        return this.paddingLeft;
    }

    public float getEffectivePaddingRight() {
        if (isUseBorderPadding()) {
            return this.paddingRight + (getBorderWidthRight() / (isUseVariableBorders() ? 1.0f : 2.0f));
        }
        return this.paddingRight;
    }

    public float getEffectivePaddingTop() {
        if (isUseBorderPadding()) {
            return this.paddingTop + (getBorderWidthTop() / (isUseVariableBorders() ? 1.0f : 2.0f));
        }
        return this.paddingTop;
    }

    public float getExtraParagraphSpace() {
        return this.column.getExtraParagraphSpace();
    }

    public float getFixedHeight() {
        return this.fixedHeight;
    }

    public float getFollowingIndent() {
        return this.column.getFollowingIndent();
    }

    public ArrayList<PdfPHeaderCell> getHeaders() {
        return this.headers;
    }

    public int getHorizontalAlignment() {
        return this.column.getAlignment();
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public AccessibleElementId getId() {
        return this.id;
    }

    public Image getImage() {
        return this.image;
    }

    public float getIndent() {
        return this.column.getIndent();
    }

    public float getLeading() {
        return this.column.getLeading();
    }

    public float getMaxHeight() {
        float top;
        float left;
        float top2;
        boolean z = getRotation() == 90 || getRotation() == 270;
        Image image = getImage();
        if (image != null) {
            image.scalePercent(100.0f);
            image.scalePercent(((((getRight() - getEffectivePaddingRight()) - getEffectivePaddingLeft()) - getLeft()) / (z ? image.getScaledHeight() : image.getScaledWidth())) * 100.0f);
            setBottom(((getTop() - getEffectivePaddingTop()) - getEffectivePaddingBottom()) - (z ? image.getScaledWidth() : image.getScaledHeight()));
        } else if ((z && hasFixedHeight()) || getColumn() == null) {
            setBottom(getTop() - getFixedHeight());
        } else {
            ColumnText columnTextDuplicate = ColumnText.duplicate(getColumn());
            float right = 20000.0f;
            if (z) {
                top = getRight() - getEffectivePaddingRight();
                top2 = getLeft() + getEffectivePaddingLeft();
                left = 0.0f;
            } else {
                right = isNoWrap() ? 20000.0f : getRight() - getEffectivePaddingRight();
                top = getTop() - getEffectivePaddingTop();
                left = getLeft() + getEffectivePaddingLeft();
                top2 = hasCalculatedHeight() ? (getTop() + getEffectivePaddingBottom()) - getCalculatedHeight() : -1.0737418E9f;
            }
            PdfPRow.setColumn(columnTextDuplicate, left, top2, right, top);
            try {
                columnTextDuplicate.go(true);
                if (z) {
                    setBottom(((getTop() - getEffectivePaddingTop()) - getEffectivePaddingBottom()) - columnTextDuplicate.getFilledWidth());
                } else {
                    float yLine = columnTextDuplicate.getYLine();
                    if (isUseDescender()) {
                        yLine += columnTextDuplicate.getDescender();
                    }
                    setBottom(yLine - getEffectivePaddingBottom());
                }
            } catch (DocumentException e) {
                throw new ExceptionConverter(e);
            }
        }
        float height = getHeight();
        float minimumHeight = height != getEffectivePaddingTop() + getEffectivePaddingBottom() ? height : 0.0f;
        if (hasFixedHeight()) {
            minimumHeight = getFixedHeight();
        } else if (hasMinimumHeight() && minimumHeight < getMinimumHeight()) {
            minimumHeight = getMinimumHeight();
        }
        this.cachedMaxHeight = minimumHeight;
        return minimumHeight;
    }

    public float getMinimumHeight() {
        return this.minimumHeight;
    }

    public float getMultipliedLeading() {
        return this.column.getMultipliedLeading();
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

    public float getPaddingTop() {
        return this.paddingTop;
    }

    public Phrase getPhrase() {
        return this.phrase;
    }

    public float getRightIndent() {
        return this.column.getRightIndent();
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public PdfName getRole() {
        return this.role;
    }

    @Override // com.itextpdf.text.Rectangle
    public int getRotation() {
        return this.rotation;
    }

    public int getRowspan() {
        return this.rowspan;
    }

    public int getRunDirection() {
        return this.column.getRunDirection();
    }

    public float getSpaceCharRatio() {
        return this.column.getSpaceCharRatio();
    }

    public PdfPTable getTable() {
        return this.table;
    }

    public int getVerticalAlignment() {
        return this.verticalAlignment;
    }

    public boolean hasCachedMaxHeight() {
        return this.cachedMaxHeight > 0.0f;
    }

    public boolean hasCalculatedHeight() {
        return getCalculatedHeight() > 0.0f;
    }

    public boolean hasFixedHeight() {
        return getFixedHeight() > 0.0f;
    }

    public boolean hasMinimumHeight() {
        return getMinimumHeight() > 0.0f;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public boolean isInline() {
        return false;
    }

    public boolean isNoWrap() {
        return this.noWrap;
    }

    public boolean isUseAscender() {
        return this.column.isUseAscender();
    }

    public boolean isUseBorderPadding() {
        return this.useBorderPadding;
    }

    public boolean isUseDescender() {
        return this.useDescender;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public void setAccessibleAttribute(PdfName pdfName, PdfObject pdfObject) {
        if (this.accessibleAttributes == null) {
            this.accessibleAttributes = new HashMap<>();
        }
        this.accessibleAttributes.put(pdfName, pdfObject);
    }

    public void setArabicOptions(int i) {
        this.column.setArabicOptions(i);
    }

    public void setCalculatedHeight(float f) {
        this.calculatedHeight = f;
    }

    public void setCellEvent(PdfPCellEvent pdfPCellEvent) {
        if (pdfPCellEvent == null) {
            this.cellEvent = null;
            return;
        }
        PdfPCellEvent pdfPCellEvent2 = this.cellEvent;
        if (pdfPCellEvent2 == null) {
            this.cellEvent = pdfPCellEvent;
            return;
        }
        if (pdfPCellEvent2 instanceof PdfPCellEventForwarder) {
            ((PdfPCellEventForwarder) pdfPCellEvent2).addCellEvent(pdfPCellEvent);
            return;
        }
        PdfPCellEventForwarder pdfPCellEventForwarder = new PdfPCellEventForwarder();
        pdfPCellEventForwarder.addCellEvent(this.cellEvent);
        pdfPCellEventForwarder.addCellEvent(pdfPCellEvent);
        this.cellEvent = pdfPCellEventForwarder;
    }

    public void setColspan(int i) {
        this.colspan = i;
    }

    public void setColumn(ColumnText columnText) {
        this.column = columnText;
    }

    public void setExtraParagraphSpace(float f) {
        this.column.setExtraParagraphSpace(f);
    }

    public void setFixedHeight(float f) {
        this.fixedHeight = f;
        this.minimumHeight = 0.0f;
    }

    public void setFollowingIndent(float f) {
        this.column.setFollowingIndent(f);
    }

    public void setHorizontalAlignment(int i) {
        this.column.setAlignment(i);
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public void setId(AccessibleElementId accessibleElementId) {
        this.id = accessibleElementId;
    }

    public void setImage(Image image) {
        this.column.setText(null);
        this.table = null;
        this.image = image;
    }

    public void setIndent(float f) {
        this.column.setIndent(f);
    }

    public void setLeading(float f, float f2) {
        this.column.setLeading(f, f2);
    }

    public void setMinimumHeight(float f) {
        this.minimumHeight = f;
        this.fixedHeight = 0.0f;
    }

    public void setNoWrap(boolean z) {
        this.noWrap = z;
    }

    public void setPadding(float f) {
        this.paddingBottom = f;
        this.paddingTop = f;
        this.paddingLeft = f;
        this.paddingRight = f;
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

    public void setPaddingTop(float f) {
        this.paddingTop = f;
    }

    public void setPhrase(Phrase phrase) {
        this.table = null;
        this.image = null;
        ColumnText columnText = this.column;
        this.phrase = phrase;
        columnText.setText(phrase);
    }

    public void setRightIndent(float f) {
        this.column.setRightIndent(f);
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public void setRole(PdfName pdfName) {
        this.role = pdfName;
    }

    @Override // com.itextpdf.text.Rectangle
    public void setRotation(int i) {
        int i2 = i % 360;
        if (i2 < 0) {
            i2 += 360;
        }
        if (i2 % 90 != 0) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("rotation.must.be.a.multiple.of.90", new Object[0]));
        }
        this.rotation = i2;
    }

    public void setRowspan(int i) {
        this.rowspan = i;
    }

    public void setRunDirection(int i) {
        this.column.setRunDirection(i);
    }

    public void setSpaceCharRatio(float f) {
        this.column.setSpaceCharRatio(f);
    }

    public void setTable(PdfPTable pdfPTable) {
        this.table = pdfPTable;
        this.column.setText(null);
        this.image = null;
        if (pdfPTable != null) {
            pdfPTable.setExtendLastRow(this.verticalAlignment == 4);
            this.column.addElement(pdfPTable);
            pdfPTable.setWidthPercentage(100.0f);
        }
    }

    public void setUseAscender(boolean z) {
        this.column.setUseAscender(z);
    }

    public void setUseBorderPadding(boolean z) {
        this.useBorderPadding = z;
    }

    public void setUseDescender(boolean z) {
        this.useDescender = z;
    }

    public void setVerticalAlignment(int i) {
        PdfPTable pdfPTable = this.table;
        if (pdfPTable != null) {
            pdfPTable.setExtendLastRow(i == 4);
        }
        this.verticalAlignment = i;
    }

    public PdfPCell(Phrase phrase) {
        super(0.0f, 0.0f, 0.0f, 0.0f);
        this.column = new ColumnText(null);
        this.verticalAlignment = 4;
        this.paddingLeft = 2.0f;
        this.paddingRight = 2.0f;
        this.paddingTop = 2.0f;
        this.paddingBottom = 2.0f;
        this.fixedHeight = 0.0f;
        this.calculatedHeight = 0.0f;
        this.noWrap = false;
        this.colspan = 1;
        this.rowspan = 1;
        this.useDescender = false;
        this.useBorderPadding = false;
        this.role = PdfName.TD;
        this.accessibleAttributes = null;
        this.id = new AccessibleElementId();
        this.headers = null;
        this.borderWidth = 0.5f;
        this.border = 15;
        ColumnText columnText = this.column;
        this.phrase = phrase;
        columnText.addText(phrase);
        this.column.setLeading(0.0f, 1.0f);
    }

    public PdfPCell(Image image) {
        this(image, false);
    }

    public PdfPCell(Image image, boolean z) {
        super(0.0f, 0.0f, 0.0f, 0.0f);
        this.column = new ColumnText(null);
        this.verticalAlignment = 4;
        this.paddingLeft = 2.0f;
        this.paddingRight = 2.0f;
        this.paddingTop = 2.0f;
        this.paddingBottom = 2.0f;
        this.fixedHeight = 0.0f;
        this.calculatedHeight = 0.0f;
        this.noWrap = false;
        this.colspan = 1;
        this.rowspan = 1;
        this.useDescender = false;
        this.useBorderPadding = false;
        this.role = PdfName.TD;
        this.accessibleAttributes = null;
        this.id = new AccessibleElementId();
        this.headers = null;
        this.borderWidth = 0.5f;
        this.border = 15;
        this.column.setLeading(0.0f, 1.0f);
        if (z) {
            this.image = image;
            setPadding(this.borderWidth / 2.0f);
            return;
        }
        image.setScaleToFitLineWhenOverflow(false);
        ColumnText columnText = this.column;
        Phrase phrase = new Phrase(new Chunk(image, 0.0f, 0.0f, true));
        this.phrase = phrase;
        columnText.addText(phrase);
        setPadding(0.0f);
    }

    public PdfPCell(PdfPTable pdfPTable) {
        this(pdfPTable, (PdfPCell) null);
    }

    public PdfPCell(PdfPTable pdfPTable, PdfPCell pdfPCell) {
        super(0.0f, 0.0f, 0.0f, 0.0f);
        this.column = new ColumnText(null);
        this.verticalAlignment = 4;
        this.paddingLeft = 2.0f;
        this.paddingRight = 2.0f;
        this.paddingTop = 2.0f;
        this.paddingBottom = 2.0f;
        this.fixedHeight = 0.0f;
        this.calculatedHeight = 0.0f;
        this.noWrap = false;
        this.colspan = 1;
        this.rowspan = 1;
        this.useDescender = false;
        this.useBorderPadding = false;
        this.role = PdfName.TD;
        this.accessibleAttributes = null;
        this.id = new AccessibleElementId();
        this.headers = null;
        this.borderWidth = 0.5f;
        this.border = 15;
        this.column.setLeading(0.0f, 1.0f);
        this.table = pdfPTable;
        pdfPTable.setWidthPercentage(100.0f);
        pdfPTable.setExtendLastRow(true);
        this.column.addElement(pdfPTable);
        if (pdfPCell != null) {
            cloneNonPositionParameters(pdfPCell);
            this.verticalAlignment = pdfPCell.verticalAlignment;
            this.paddingLeft = pdfPCell.paddingLeft;
            this.paddingRight = pdfPCell.paddingRight;
            this.paddingTop = pdfPCell.paddingTop;
            this.paddingBottom = pdfPCell.paddingBottom;
            this.colspan = pdfPCell.colspan;
            this.rowspan = pdfPCell.rowspan;
            this.cellEvent = pdfPCell.cellEvent;
            this.useDescender = pdfPCell.useDescender;
            this.useBorderPadding = pdfPCell.useBorderPadding;
            this.rotation = pdfPCell.rotation;
            return;
        }
        setPadding(0.0f);
    }

    public PdfPCell(PdfPCell pdfPCell) {
        super(pdfPCell.llx, pdfPCell.lly, pdfPCell.urx, pdfPCell.ury);
        this.column = new ColumnText(null);
        this.verticalAlignment = 4;
        this.paddingLeft = 2.0f;
        this.paddingRight = 2.0f;
        this.paddingTop = 2.0f;
        this.paddingBottom = 2.0f;
        this.fixedHeight = 0.0f;
        this.calculatedHeight = 0.0f;
        this.noWrap = false;
        this.colspan = 1;
        this.rowspan = 1;
        this.useDescender = false;
        this.useBorderPadding = false;
        this.role = PdfName.TD;
        this.accessibleAttributes = null;
        this.id = new AccessibleElementId();
        this.headers = null;
        cloneNonPositionParameters(pdfPCell);
        this.verticalAlignment = pdfPCell.verticalAlignment;
        this.paddingLeft = pdfPCell.paddingLeft;
        this.paddingRight = pdfPCell.paddingRight;
        this.paddingTop = pdfPCell.paddingTop;
        this.paddingBottom = pdfPCell.paddingBottom;
        this.phrase = pdfPCell.phrase;
        this.fixedHeight = pdfPCell.fixedHeight;
        this.minimumHeight = pdfPCell.minimumHeight;
        this.noWrap = pdfPCell.noWrap;
        this.colspan = pdfPCell.colspan;
        this.rowspan = pdfPCell.rowspan;
        if (pdfPCell.table != null) {
            this.table = new PdfPTable(pdfPCell.table);
        }
        this.image = Image.getInstance(pdfPCell.image);
        this.cellEvent = pdfPCell.cellEvent;
        this.useDescender = pdfPCell.useDescender;
        this.column = ColumnText.duplicate(pdfPCell.column);
        this.useBorderPadding = pdfPCell.useBorderPadding;
        this.rotation = pdfPCell.rotation;
        this.id = pdfPCell.id;
        this.role = pdfPCell.role;
        if (pdfPCell.accessibleAttributes != null) {
            this.accessibleAttributes = new HashMap<>(pdfPCell.accessibleAttributes);
        }
        this.headers = pdfPCell.headers;
    }
}
