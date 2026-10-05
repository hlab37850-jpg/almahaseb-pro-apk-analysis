package com.itextpdf.text.pdf;

import com.itextpdf.text.AccessibleElementId;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class PdfPRow implements IAccessibleElement {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final float BOTTOM_LIMIT = -1.0737418E9f;
    public static final float RIGHT_LIMIT = 20000.0f;
    private final Logger LOGGER;
    protected HashMap<PdfName, PdfObject> accessibleAttributes;
    protected boolean adjusted;
    protected boolean calculated;
    private int[] canvasesPos;
    protected PdfPCell[] cells;
    protected float[] extraHeights;
    protected AccessibleElementId id;
    protected float maxHeight;
    public boolean mayNotBreak;
    protected PdfName role;
    protected float[] widths;

    public PdfPRow(PdfPCell[] pdfPCellArr) {
        this(pdfPCellArr, null);
    }

    private static boolean isTagged(PdfContentByte pdfContentByte) {
        PdfWriter pdfWriter;
        return (pdfContentByte == null || (pdfWriter = pdfContentByte.writer) == null || !pdfWriter.isTagged()) ? false : true;
    }

    public static float setColumn(ColumnText columnText, float f, float f2, float f3, float f4) {
        if (f > f3) {
            f3 = f;
        }
        if (f2 > f4) {
            f4 = f2;
        }
        columnText.setSimpleColumn(f, f2, f3, f4);
        return f4;
    }

    public void calculateHeights() {
        this.maxHeight = 0.0f;
        this.LOGGER.info("calculateHeights");
        int i = 0;
        while (true) {
            PdfPCell[] pdfPCellArr = this.cells;
            if (i >= pdfPCellArr.length) {
                this.calculated = true;
                return;
            }
            PdfPCell pdfPCell = pdfPCellArr[i];
            if (pdfPCell != null) {
                float calculatedHeight = pdfPCell.hasCalculatedHeight() ? pdfPCell.getCalculatedHeight() : pdfPCell.getMaxHeight();
                if (calculatedHeight > this.maxHeight && pdfPCell.getRowspan() == 1) {
                    this.maxHeight = calculatedHeight;
                }
            }
            i++;
        }
    }

    public void copyRowContent(PdfPTable pdfPTable, int i) {
        if (pdfPTable == null) {
            return;
        }
        for (int i2 = 0; i2 < this.cells.length; i2++) {
            PdfPCell pdfPCell = pdfPTable.getRow(i).getCells()[i2];
            int i3 = i;
            while (pdfPCell == null && i3 > 0) {
                i3--;
                pdfPCell = pdfPTable.getRow(i3).getCells()[i2];
            }
            PdfPCell pdfPCell2 = this.cells[i2];
            if (pdfPCell2 != null && pdfPCell != null) {
                pdfPCell2.setColumn(pdfPCell.getColumn());
                this.calculated = false;
            }
        }
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

    public PdfPCell[] getCells() {
        return this.cells;
    }

    public float[] getEventWidth(float f, float[] fArr) {
        int i = 1;
        int colspan = 0;
        int i2 = 1;
        while (true) {
            PdfPCell[] pdfPCellArr = this.cells;
            if (colspan >= pdfPCellArr.length) {
                break;
            }
            PdfPCell pdfPCell = pdfPCellArr[colspan];
            if (pdfPCell != null) {
                i2++;
                colspan += pdfPCell.getColspan();
            } else {
                while (true) {
                    PdfPCell[] pdfPCellArr2 = this.cells;
                    if (colspan >= pdfPCellArr2.length || pdfPCellArr2[colspan] != null) {
                        break;
                    }
                    i2++;
                    colspan++;
                }
            }
        }
        float[] fArr2 = new float[i2];
        fArr2[0] = f;
        int i3 = 0;
        while (true) {
            PdfPCell[] pdfPCellArr3 = this.cells;
            if (i3 >= pdfPCellArr3.length || i >= i2) {
                break;
            }
            PdfPCell pdfPCell2 = pdfPCellArr3[i3];
            if (pdfPCell2 != null) {
                int colspan2 = pdfPCell2.getColspan();
                fArr2[i] = fArr2[i - 1];
                int i4 = 0;
                while (i4 < colspan2 && i3 < fArr.length) {
                    fArr2[i] = fArr2[i] + fArr[i3];
                    i4++;
                    i3++;
                }
            } else {
                fArr2[i] = fArr2[i - 1];
                while (true) {
                    PdfPCell[] pdfPCellArr4 = this.cells;
                    if (i3 >= pdfPCellArr4.length || pdfPCellArr4[i3] != null) {
                        break;
                    }
                    fArr2[i] = fArr2[i] + fArr[i3];
                    i3++;
                }
            }
            i++;
        }
        return fArr2;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public AccessibleElementId getId() {
        return this.id;
    }

    public float getMaxHeights() {
        if (!this.calculated) {
            calculateHeights();
        }
        return this.maxHeight;
    }

    public float getMaxRowHeightsWithoutCalculating() {
        return this.maxHeight;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public PdfName getRole() {
        return this.role;
    }

    public boolean hasRowspan() {
        int i = 0;
        while (true) {
            PdfPCell[] pdfPCellArr = this.cells;
            if (i >= pdfPCellArr.length) {
                return false;
            }
            PdfPCell pdfPCell = pdfPCellArr[i];
            if (pdfPCell != null && pdfPCell.getRowspan() > 1) {
                return true;
            }
            i++;
        }
    }

    public void initExtraHeights() {
        this.extraHeights = new float[this.cells.length];
        int i = 0;
        while (true) {
            float[] fArr = this.extraHeights;
            if (i >= fArr.length) {
                return;
            }
            fArr[i] = 0.0f;
            i++;
        }
    }

    public boolean isAdjusted() {
        return this.adjusted;
    }

    public boolean isCalculated() {
        return this.calculated;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public boolean isInline() {
        return false;
    }

    public boolean isMayNotBreak() {
        return this.mayNotBreak;
    }

    public void restoreCanvases(PdfContentByte[] pdfContentByteArr) {
        for (int i = 0; i < 4; i++) {
            ByteBuffer internalBuffer = pdfContentByteArr[i].getInternalBuffer();
            int size = internalBuffer.size();
            pdfContentByteArr[i].restoreState();
            int[] iArr = this.canvasesPos;
            int i2 = i * 2;
            if (size == iArr[i2 + 1]) {
                internalBuffer.setSize(iArr[i2]);
            }
        }
    }

    public void saveAndRotateCanvases(PdfContentByte[] pdfContentByteArr, float f, float f2, float f3, float f4, float f5, float f6) {
        if (this.canvasesPos == null) {
            this.canvasesPos = new int[8];
        }
        for (int i = 0; i < 4; i++) {
            ByteBuffer internalBuffer = pdfContentByteArr[i].getInternalBuffer();
            int i2 = i * 2;
            this.canvasesPos[i2] = internalBuffer.size();
            pdfContentByteArr[i].saveState();
            pdfContentByteArr[i].concatCTM(f, f2, f3, f4, f5, f6);
            this.canvasesPos[i2 + 1] = internalBuffer.size();
        }
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public void setAccessibleAttribute(PdfName pdfName, PdfObject pdfObject) {
        if (this.accessibleAttributes == null) {
            this.accessibleAttributes = new HashMap<>();
        }
        this.accessibleAttributes.put(pdfName, pdfObject);
    }

    public void setAdjusted(boolean z) {
        this.adjusted = z;
    }

    public void setExtraHeight(int i, float f) {
        if (i < 0 || i >= this.cells.length) {
            return;
        }
        this.extraHeights[i] = f;
    }

    public void setFinalMaxHeights(float f) {
        setMaxHeights(f);
        this.calculated = true;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public void setId(AccessibleElementId accessibleElementId) {
        this.id = accessibleElementId;
    }

    public void setMaxHeights(float f) {
        this.maxHeight = f;
    }

    public void setMayNotBreak(boolean z) {
        this.mayNotBreak = z;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public void setRole(PdfName pdfName) {
        this.role = pdfName;
    }

    public boolean setWidths(float[] fArr) {
        int length = fArr.length;
        PdfPCell[] pdfPCellArr = this.cells;
        int i = 0;
        if (length != pdfPCellArr.length) {
            return false;
        }
        System.arraycopy(fArr, 0, this.widths, 0, pdfPCellArr.length);
        this.calculated = false;
        float f = 0.0f;
        while (i < fArr.length) {
            PdfPCell pdfPCell = this.cells[i];
            if (pdfPCell == null) {
                f += fArr[i];
            } else {
                pdfPCell.setLeft(f);
                int colspan = pdfPCell.getColspan() + i;
                while (i < colspan) {
                    f += fArr[i];
                    i++;
                }
                i--;
                pdfPCell.setRight(f);
                pdfPCell.setTop(0.0f);
            }
            i++;
        }
        return true;
    }

    public PdfPRow splitRow(PdfPTable pdfPTable, int i, float f) {
        int i2;
        float column;
        this.LOGGER.info(String.format("Splitting row %s available height: %s", Integer.valueOf(i), Float.valueOf(f)));
        PdfPCell[] pdfPCellArr = this.cells;
        PdfPCell[] pdfPCellArr2 = new PdfPCell[pdfPCellArr.length];
        float[] fArr = new float[pdfPCellArr.length];
        float[] fArr2 = new float[pdfPCellArr.length];
        float[] fArr3 = new float[pdfPCellArr.length];
        int i3 = 0;
        boolean z = true;
        while (true) {
            PdfPCell[] pdfPCellArr3 = this.cells;
            if (i3 >= pdfPCellArr3.length) {
                break;
            }
            PdfPCell pdfPCell = pdfPCellArr3[i3];
            if (pdfPCell == null) {
                if (pdfPTable.rowSpanAbove(i, i3)) {
                    int i4 = i;
                    while (true) {
                        i4--;
                        if (!pdfPTable.rowSpanAbove(i4, i3)) {
                            break;
                        }
                        pdfPTable.getRow(i4).getMaxHeights();
                    }
                    PdfPRow row = pdfPTable.getRow(i4);
                    if (row != null && row.getCells()[i3] != null) {
                        PdfPCell pdfPCell2 = new PdfPCell(row.getCells()[i3]);
                        pdfPCellArr2[i3] = pdfPCell2;
                        pdfPCell2.setColumn(null);
                        pdfPCellArr2[i3].setRowspan((row.getCells()[i3].getRowspan() - i) + i4);
                        z = false;
                    }
                }
                fArr3 = fArr3;
            } else {
                fArr[i3] = pdfPCell.getCalculatedHeight();
                fArr2[i3] = pdfPCell.getFixedHeight();
                fArr3[i3] = pdfPCell.getMinimumHeight();
                Image image = pdfPCell.getImage();
                PdfPCell pdfPCell3 = new PdfPCell(pdfPCell);
                if (image != null) {
                    float effectivePaddingBottom = pdfPCell.getEffectivePaddingBottom() + pdfPCell.getEffectivePaddingTop() + 2.0f;
                    if ((image.isScaleToFitHeight() || image.getScaledHeight() + effectivePaddingBottom < f) && f > effectivePaddingBottom) {
                        pdfPCell3.setPhrase(null);
                        z = false;
                    }
                } else {
                    ColumnText columnTextDuplicate = ColumnText.duplicate(pdfPCell.getColumn());
                    float left = pdfPCell.getLeft() + pdfPCell.getEffectivePaddingLeft();
                    float top = (pdfPCell.getTop() + pdfPCell.getEffectivePaddingBottom()) - f;
                    float right = pdfPCell.getRight() - pdfPCell.getEffectivePaddingRight();
                    float top2 = pdfPCell.getTop() - pdfPCell.getEffectivePaddingTop();
                    int rotation = pdfPCell.getRotation();
                    if (rotation == 90 || rotation == 270) {
                        column = setColumn(columnTextDuplicate, top, left, top2, right);
                    } else {
                        float f2 = top + 1.0E-5f;
                        if (pdfPCell.isNoWrap()) {
                            right = 20000.0f;
                        }
                        column = setColumn(columnTextDuplicate, left, f2, right, top2);
                    }
                    try {
                        int iGo = columnTextDuplicate.go(true);
                        boolean z2 = columnTextDuplicate.getYLine() == column;
                        if (z2) {
                            pdfPCell3.setColumn(ColumnText.duplicate(pdfPCell.getColumn()));
                            columnTextDuplicate.setFilledWidth(0.0f);
                        } else if ((iGo & 1) == 0) {
                            pdfPCell3.setColumn(columnTextDuplicate);
                            columnTextDuplicate.setFilledWidth(0.0f);
                        } else {
                            pdfPCell3.setPhrase(null);
                        }
                        z = z && z2;
                    } catch (DocumentException e) {
                        throw new ExceptionConverter(e);
                    }
                }
                pdfPCellArr2[i3] = pdfPCell3;
                pdfPCell.setCalculatedHeight(f);
            }
            i3++;
            fArr3 = fArr3;
        }
        float[] fArr4 = fArr3;
        if (!z) {
            calculateHeights();
            PdfPRow pdfPRow = new PdfPRow(pdfPCellArr2, this);
            pdfPRow.widths = (float[]) this.widths.clone();
            return pdfPRow;
        }
        int i5 = 0;
        while (true) {
            PdfPCell[] pdfPCellArr4 = this.cells;
            if (i5 >= pdfPCellArr4.length) {
                return null;
            }
            PdfPCell pdfPCell4 = pdfPCellArr4[i5];
            if (pdfPCell4 == null) {
                i2 = 1;
            } else {
                pdfPCell4.setCalculatedHeight(fArr[i5]);
                float f3 = fArr2[i5];
                if (f3 > 0.0f) {
                    pdfPCell4.setFixedHeight(f3);
                } else {
                    pdfPCell4.setMinimumHeight(fArr4[i5]);
                }
                i2 = 1;
            }
            i5 += i2;
        }
    }

    public void splitRowspans(PdfPTable pdfPTable, int i, PdfPTable pdfPTable2, int i2) {
        if (pdfPTable == null || pdfPTable2 == null) {
            return;
        }
        int colspan = 0;
        while (true) {
            PdfPCell[] pdfPCellArr = this.cells;
            if (colspan >= pdfPCellArr.length) {
                return;
            }
            PdfPCell pdfPCell = pdfPCellArr[colspan];
            if (pdfPCell == null) {
                int cellStartRowIndex = pdfPTable.getCellStartRowIndex(i, colspan);
                int cellStartRowIndex2 = pdfPTable2.getCellStartRowIndex(i2, colspan);
                PdfPCell pdfPCell2 = pdfPTable.getRow(cellStartRowIndex).getCells()[colspan];
                PdfPCell pdfPCell3 = pdfPTable2.getRow(cellStartRowIndex2).getCells()[colspan];
                if (pdfPCell2 != null) {
                    this.cells[colspan] = new PdfPCell(pdfPCell3);
                    int i3 = (i2 - cellStartRowIndex2) + 1;
                    this.cells[colspan].setRowspan(pdfPCell3.getRowspan() - i3);
                    pdfPCell2.setRowspan(i3);
                    this.calculated = false;
                }
                colspan++;
            } else {
                colspan += pdfPCell.getColspan();
            }
        }
    }

    public void writeBorderAndBackground(float f, float f2, float f3, PdfPCell pdfPCell, PdfContentByte[] pdfContentByteArr) {
        BaseColor backgroundColor = pdfPCell.getBackgroundColor();
        if (backgroundColor != null || pdfPCell.hasBorders()) {
            float right = pdfPCell.getRight() + f;
            float top = pdfPCell.getTop() + f2;
            float left = pdfPCell.getLeft() + f;
            float f4 = top - f3;
            if (backgroundColor != null) {
                PdfContentByte pdfContentByte = pdfContentByteArr[1];
                pdfContentByte.setColorFill(backgroundColor);
                pdfContentByte.rectangle(left, f4, right - left, top - f4);
                pdfContentByte.fill();
            }
            if (pdfPCell.hasBorders()) {
                Rectangle rectangle = new Rectangle(left, f4, right, top);
                rectangle.cloneNonPositionParameters(pdfPCell);
                rectangle.setBackgroundColor(null);
                pdfContentByteArr[2].rectangle(rectangle);
            }
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x028f */
    /* JADX WARN: Bottom block not found for handler: all -> 0x03c6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void writeCells(int r20, int r21, float r22, float r23, com.itextpdf.text.pdf.PdfContentByte[] r24, boolean r25) {
        /*
            Method dump skipped, instruction units count: 1060
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfPRow.writeCells(int, int, float, float, com.itextpdf.text.pdf.PdfContentByte[], boolean):void");
    }

    public PdfPRow(PdfPCell[] pdfPCellArr, PdfPRow pdfPRow) {
        this.LOGGER = LoggerFactory.getLogger((Class<?>) PdfPRow.class);
        this.mayNotBreak = false;
        this.maxHeight = 0.0f;
        this.calculated = false;
        this.adjusted = false;
        this.role = PdfName.TR;
        this.accessibleAttributes = null;
        this.id = new AccessibleElementId();
        this.cells = pdfPCellArr;
        this.widths = new float[pdfPCellArr.length];
        initExtraHeights();
        if (pdfPRow != null) {
            this.id = pdfPRow.id;
            this.role = pdfPRow.role;
            if (pdfPRow.accessibleAttributes != null) {
                this.accessibleAttributes = new HashMap<>(pdfPRow.accessibleAttributes);
            }
        }
    }

    public PdfPRow(PdfPRow pdfPRow) {
        PdfPCell[] pdfPCellArr;
        this.LOGGER = LoggerFactory.getLogger((Class<?>) PdfPRow.class);
        this.mayNotBreak = false;
        this.maxHeight = 0.0f;
        this.calculated = false;
        this.adjusted = false;
        this.role = PdfName.TR;
        this.accessibleAttributes = null;
        this.id = new AccessibleElementId();
        this.mayNotBreak = pdfPRow.mayNotBreak;
        this.maxHeight = pdfPRow.maxHeight;
        this.calculated = pdfPRow.calculated;
        this.cells = new PdfPCell[pdfPRow.cells.length];
        int i = 0;
        while (true) {
            pdfPCellArr = this.cells;
            if (i >= pdfPCellArr.length) {
                break;
            }
            PdfPCell pdfPCell = pdfPRow.cells[i];
            if (pdfPCell != null) {
                if (pdfPCell instanceof PdfPHeaderCell) {
                    pdfPCellArr[i] = new PdfPHeaderCell((PdfPHeaderCell) pdfPCell);
                } else {
                    pdfPCellArr[i] = new PdfPCell(pdfPCell);
                }
            }
            i++;
        }
        float[] fArr = new float[pdfPCellArr.length];
        this.widths = fArr;
        System.arraycopy(pdfPRow.widths, 0, fArr, 0, pdfPCellArr.length);
        initExtraHeights();
        this.id = pdfPRow.id;
        this.role = pdfPRow.role;
        if (pdfPRow.accessibleAttributes != null) {
            this.accessibleAttributes = new HashMap<>(pdfPRow.accessibleAttributes);
        }
    }
}
