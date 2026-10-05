package com.itextpdf.text.pdf;

import com.itextpdf.text.AccessibleElementId;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ElementListener;
import com.itextpdf.text.Image;
import com.itextpdf.text.LargeElement;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.api.Spaceable;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.events.PdfPTableEventForwarder;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class PdfPTable implements LargeElement, Spaceable, IAccessibleElement {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int BACKGROUNDCANVAS = 1;
    public static final int BASECANVAS = 0;
    public static final int LINECANVAS = 2;
    public static final int TEXTCANVAS = 3;
    protected float[] absoluteWidths;
    protected PdfPCell[] currentRow;
    private int footerRows;
    protected int headerRows;
    private boolean headersInEvent;
    private boolean keepTogether;
    private int numberOfWrittenRows;
    protected float paddingTop;
    protected float[] relativeWidths;
    protected float spacingAfter;
    protected float spacingBefore;
    protected PdfPTableEvent tableEvent;
    private final Logger LOGGER = LoggerFactory.getLogger((Class<?>) PdfPTable.class);
    protected ArrayList<PdfPRow> rows = new ArrayList<>();
    protected float totalHeight = 0.0f;
    protected int currentColIdx = 0;
    protected PdfPCell defaultCell = new PdfPCell((Phrase) null);
    protected float totalWidth = 0.0f;
    protected float widthPercentage = 80.0f;
    private int horizontalAlignment = 1;
    private boolean skipFirstHeader = false;
    private boolean skipLastFooter = false;
    protected boolean isColspan = false;
    protected int runDirection = 1;
    private boolean lockedWidth = false;
    private boolean splitRows = true;
    private boolean[] extendLastRow = {false, false};
    private boolean splitLate = true;
    protected boolean complete = true;
    protected boolean rowCompleted = true;
    protected boolean loopCheck = true;
    protected boolean rowsNotChecked = true;
    protected PdfName role = PdfName.TABLE;
    protected HashMap<PdfName, PdfObject> accessibleAttributes = null;
    protected AccessibleElementId id = new AccessibleElementId();
    private PdfPTableHeader header = null;
    private PdfPTableBody body = null;
    private PdfPTableFooter footer = null;

    public static class ColumnMeasurementState {
        public float height = 0.0f;
        public int rowspan = 1;
        public int colspan = 1;

        public void beginCell(PdfPCell pdfPCell, float f, float f2) {
            this.rowspan = pdfPCell.getRowspan();
            this.colspan = pdfPCell.getColspan();
            this.height = f + Math.max(pdfPCell.hasCachedMaxHeight() ? pdfPCell.getCachedMaxHeight() : pdfPCell.getMaxHeight(), f2);
        }

        public boolean cellEnds() {
            return this.rowspan == 1;
        }

        public void consumeRowspan(float f, float f2) {
            this.rowspan--;
        }
    }

    public static class FittingRows {
        public final float completedRowsHeight;
        private final Map<Integer, Float> correctedHeightsForLastRow;
        public final int firstRow;
        public final float height;
        public final int lastRow;

        public FittingRows(int i, int i2, float f, float f2, Map<Integer, Float> map) {
            this.firstRow = i;
            this.lastRow = i2;
            this.height = f;
            this.completedRowsHeight = f2;
            this.correctedHeightsForLastRow = map;
        }

        public void correctLastRowChosen(PdfPTable pdfPTable, int i) {
            PdfPRow row = pdfPTable.getRow(i);
            Float f = this.correctedHeightsForLastRow.get(Integer.valueOf(i));
            if (f != null) {
                row.setFinalMaxHeights(f.floatValue());
            }
        }
    }

    public PdfPTable() {
    }

    public static PdfContentByte[] beginWritingRows(PdfContentByte pdfContentByte) {
        return new PdfContentByte[]{pdfContentByte, pdfContentByte.getDuplicate(), pdfContentByte.getDuplicate(), pdfContentByte.getDuplicate()};
    }

    private PdfPTableBody closeTableBlock(PdfPTableBody pdfPTableBody, PdfContentByte pdfContentByte) {
        if (!pdfContentByte.writer.getStandardStructElems().contains(pdfPTableBody.getRole())) {
            return null;
        }
        pdfContentByte.closeMCBlock(pdfPTableBody);
        return null;
    }

    public static void endWritingRows(PdfContentByte[] pdfContentByteArr) {
        PdfContentByte pdfContentByte = pdfContentByteArr[0];
        PdfArtifact pdfArtifact = new PdfArtifact();
        pdfContentByte.openMCBlock(pdfArtifact);
        pdfContentByte.saveState();
        pdfContentByte.add(pdfContentByteArr[1]);
        pdfContentByte.restoreState();
        pdfContentByte.saveState();
        pdfContentByte.setLineCap(2);
        pdfContentByte.resetRGBColorStroke();
        pdfContentByte.add(pdfContentByteArr[2]);
        pdfContentByte.restoreState();
        pdfContentByte.closeMCBlock(pdfArtifact);
        pdfContentByte.add(pdfContentByteArr[3]);
    }

    private PdfPTableBody openTableBlock(PdfPTableBody pdfPTableBody, PdfContentByte pdfContentByte) {
        if (!pdfContentByte.writer.getStandardStructElems().contains(pdfPTableBody.getRole())) {
            return null;
        }
        pdfContentByte.openMCBlock(pdfPTableBody);
        return pdfPTableBody;
    }

    public static PdfPTable shallowCopy(PdfPTable pdfPTable) {
        PdfPTable pdfPTable2 = new PdfPTable();
        pdfPTable2.copyFormat(pdfPTable);
        return pdfPTable2;
    }

    private void skipColsWithRowspanAbove() {
        int i = this.runDirection == 3 ? -1 : 1;
        while (rowSpanAbove(this.rows.size(), this.currentColIdx)) {
            this.currentColIdx += i;
        }
    }

    public PdfPCell addCell(PdfPCell pdfPCell) {
        boolean z;
        int i;
        PdfPCell[] pdfPCellArr;
        this.rowCompleted = false;
        PdfPCell pdfPHeaderCell = pdfPCell instanceof PdfPHeaderCell ? new PdfPHeaderCell((PdfPHeaderCell) pdfPCell) : new PdfPCell(pdfPCell);
        int iMin = Math.min(Math.max(pdfPHeaderCell.getColspan(), 1), this.currentRow.length - this.currentColIdx);
        pdfPHeaderCell.setColspan(iMin);
        if (iMin != 1) {
            this.isColspan = true;
        }
        if (pdfPHeaderCell.getRunDirection() == 1) {
            pdfPHeaderCell.setRunDirection(this.runDirection);
        }
        skipColsWithRowspanAbove();
        int i2 = this.currentColIdx;
        PdfPCell[] pdfPCellArr2 = this.currentRow;
        if (i2 < pdfPCellArr2.length) {
            pdfPCellArr2[i2] = pdfPHeaderCell;
            this.currentColIdx = i2 + iMin;
            z = true;
        } else {
            z = false;
        }
        skipColsWithRowspanAbove();
        while (true) {
            i = this.currentColIdx;
            pdfPCellArr = this.currentRow;
            if (i < pdfPCellArr.length) {
                break;
            }
            int numberOfColumns = getNumberOfColumns();
            if (this.runDirection == 3) {
                PdfPCell[] pdfPCellArr3 = new PdfPCell[numberOfColumns];
                int length = this.currentRow.length;
                int i3 = 0;
                while (true) {
                    PdfPCell[] pdfPCellArr4 = this.currentRow;
                    if (i3 >= pdfPCellArr4.length) {
                        break;
                    }
                    PdfPCell pdfPCell2 = pdfPCellArr4[i3];
                    int colspan = pdfPCell2.getColspan();
                    length -= colspan;
                    pdfPCellArr3[length] = pdfPCell2;
                    i3 = i3 + (colspan - 1) + 1;
                }
                this.currentRow = pdfPCellArr3;
            }
            PdfPRow pdfPRow = new PdfPRow(this.currentRow);
            if (this.totalWidth > 0.0f) {
                pdfPRow.setWidths(this.absoluteWidths);
                this.totalHeight += pdfPRow.getMaxHeights();
            }
            this.rows.add(pdfPRow);
            this.currentRow = new PdfPCell[numberOfColumns];
            this.currentColIdx = 0;
            skipColsWithRowspanAbove();
            this.rowCompleted = true;
        }
        if (!z) {
            pdfPCellArr[i] = pdfPHeaderCell;
            this.currentColIdx = i + iMin;
        }
        return pdfPHeaderCell;
    }

    public void addNumberOfRowsWritten(int i) {
        this.numberOfWrittenRows += i;
    }

    public PdfPRow adjustCellsInRow(int i, int i2) {
        PdfPRow row = getRow(i);
        if (row.isAdjusted()) {
            return row;
        }
        PdfPRow pdfPRow = new PdfPRow(row);
        PdfPCell[] cells = pdfPRow.getCells();
        for (int i3 = 0; i3 < cells.length; i3++) {
            PdfPCell pdfPCell = cells[i3];
            if (pdfPCell != null && pdfPCell.getRowspan() != 1) {
                int iMin = Math.min(i2, pdfPCell.getRowspan() + i);
                float maxHeights = 0.0f;
                for (int i4 = 1 + i; i4 < iMin; i4++) {
                    maxHeights += getRow(i4).getMaxHeights();
                }
                pdfPRow.setExtraHeight(i3, maxHeights);
            }
        }
        pdfPRow.setAdjusted(true);
        return pdfPRow;
    }

    public float calculateHeights() {
        if (this.totalWidth <= 0.0f) {
            return 0.0f;
        }
        this.totalHeight = 0.0f;
        for (int i = 0; i < this.rows.size(); i++) {
            this.totalHeight += getRowHeight(i, true);
        }
        return this.totalHeight;
    }

    public void calculateWidths() {
        float f = 0.0f;
        if (this.totalWidth <= 0.0f) {
            return;
        }
        int numberOfColumns = getNumberOfColumns();
        for (int i = 0; i < numberOfColumns; i++) {
            f += this.relativeWidths[i];
        }
        for (int i2 = 0; i2 < numberOfColumns; i2++) {
            this.absoluteWidths[i2] = (this.totalWidth * this.relativeWidths[i2]) / f;
        }
    }

    public PdfPCell cellAt(int i, int i2) {
        PdfPCell[] cells = this.rows.get(i).getCells();
        for (int i3 = 0; i3 < cells.length; i3++) {
            PdfPCell pdfPCell = cells[i3];
            if (pdfPCell != null && i2 >= i3 && i2 < pdfPCell.getColspan() + i3) {
                return cells[i3];
            }
        }
        return null;
    }

    public void completeRow() {
        while (!this.rowCompleted) {
            addCell(this.defaultCell);
        }
    }

    public void copyFormat(PdfPTable pdfPTable) {
        this.rowsNotChecked = pdfPTable.rowsNotChecked;
        this.relativeWidths = new float[pdfPTable.getNumberOfColumns()];
        this.absoluteWidths = new float[pdfPTable.getNumberOfColumns()];
        System.arraycopy(pdfPTable.relativeWidths, 0, this.relativeWidths, 0, getNumberOfColumns());
        System.arraycopy(pdfPTable.absoluteWidths, 0, this.absoluteWidths, 0, getNumberOfColumns());
        this.totalWidth = pdfPTable.totalWidth;
        this.totalHeight = pdfPTable.totalHeight;
        this.currentColIdx = 0;
        this.tableEvent = pdfPTable.tableEvent;
        this.runDirection = pdfPTable.runDirection;
        PdfPCell pdfPCell = pdfPTable.defaultCell;
        if (pdfPCell instanceof PdfPHeaderCell) {
            this.defaultCell = new PdfPHeaderCell((PdfPHeaderCell) pdfPCell);
        } else {
            this.defaultCell = new PdfPCell(pdfPCell);
        }
        this.currentRow = new PdfPCell[pdfPTable.currentRow.length];
        this.isColspan = pdfPTable.isColspan;
        this.splitRows = pdfPTable.splitRows;
        this.spacingAfter = pdfPTable.spacingAfter;
        this.spacingBefore = pdfPTable.spacingBefore;
        this.headerRows = pdfPTable.headerRows;
        this.footerRows = pdfPTable.footerRows;
        this.lockedWidth = pdfPTable.lockedWidth;
        this.extendLastRow = pdfPTable.extendLastRow;
        this.headersInEvent = pdfPTable.headersInEvent;
        this.widthPercentage = pdfPTable.widthPercentage;
        this.splitLate = pdfPTable.splitLate;
        this.skipFirstHeader = pdfPTable.skipFirstHeader;
        this.skipLastFooter = pdfPTable.skipLastFooter;
        this.horizontalAlignment = pdfPTable.horizontalAlignment;
        this.keepTogether = pdfPTable.keepTogether;
        this.complete = pdfPTable.complete;
        this.loopCheck = pdfPTable.loopCheck;
        this.id = pdfPTable.id;
        this.role = pdfPTable.role;
        if (pdfPTable.accessibleAttributes != null) {
            this.accessibleAttributes = new HashMap<>(pdfPTable.accessibleAttributes);
        }
        this.header = pdfPTable.getHeader();
        this.body = pdfPTable.getBody();
        this.footer = pdfPTable.getFooter();
    }

    public void deleteBodyRows() {
        ArrayList<PdfPRow> arrayList = new ArrayList<>();
        for (int i = 0; i < this.headerRows; i++) {
            arrayList.add(this.rows.get(i));
        }
        this.rows = arrayList;
        this.totalHeight = 0.0f;
        if (this.totalWidth > 0.0f) {
            this.totalHeight = getHeaderHeight();
        }
    }

    public boolean deleteLastRow() {
        return deleteRow(this.rows.size() - 1);
    }

    public boolean deleteRow(int i) {
        PdfPRow pdfPRow;
        if (i < 0 || i >= this.rows.size()) {
            return false;
        }
        if (this.totalWidth > 0.0f && (pdfPRow = this.rows.get(i)) != null) {
            this.totalHeight -= pdfPRow.getMaxHeights();
        }
        this.rows.remove(i);
        int i2 = this.headerRows;
        if (i < i2) {
            int i3 = i2 - 1;
            this.headerRows = i3;
            int i4 = this.footerRows;
            if (i >= i3 - i4) {
                this.footerRows = i4 - 1;
            }
        }
        return true;
    }

    @Override // com.itextpdf.text.LargeElement
    public void flushContent() {
        deleteBodyRows();
        if (this.numberOfWrittenRows > 0) {
            setSkipFirstHeader(true);
        }
    }

    public float[] getAbsoluteWidths() {
        return this.absoluteWidths;
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

    public PdfPTableBody getBody() {
        if (this.body == null) {
            this.body = new PdfPTableBody();
        }
        return this.body;
    }

    public int getCellStartRowIndex(int i, int i2) {
        while (getRow(i).getCells()[i2] == null && i > 0) {
            i--;
        }
        return i;
    }

    @Override // com.itextpdf.text.Element
    public List<Chunk> getChunks() {
        return new ArrayList();
    }

    public PdfPCell getDefaultCell() {
        return this.defaultCell;
    }

    public float[][] getEventWidths(float f, int i, int i2, boolean z) {
        if (z) {
            i = Math.max(i, this.headerRows);
            i2 = Math.max(i2, this.headerRows);
        }
        int i3 = 0;
        int i4 = ((z ? this.headerRows : 0) + i2) - i;
        float[][] fArr = new float[i4][];
        if (this.isColspan) {
            if (z) {
                int i5 = 0;
                while (i3 < this.headerRows) {
                    PdfPRow pdfPRow = this.rows.get(i3);
                    if (pdfPRow == null) {
                        i5++;
                    } else {
                        fArr[i5] = pdfPRow.getEventWidth(f, this.absoluteWidths);
                        i5++;
                    }
                    i3++;
                }
                i3 = i5;
            }
            while (i < i2) {
                PdfPRow pdfPRow2 = this.rows.get(i);
                if (pdfPRow2 == null) {
                    i3++;
                } else {
                    fArr[i3] = pdfPRow2.getEventWidth(f, this.absoluteWidths);
                    i3++;
                }
                i++;
            }
        } else {
            int numberOfColumns = getNumberOfColumns();
            float[] fArr2 = new float[numberOfColumns + 1];
            fArr2[0] = f;
            int i6 = 0;
            while (i6 < numberOfColumns) {
                int i7 = i6 + 1;
                fArr2[i7] = fArr2[i6] + this.absoluteWidths[i6];
                i6 = i7;
            }
            while (i3 < i4) {
                fArr[i3] = fArr2;
                i3++;
            }
        }
        return fArr;
    }

    public FittingRows getFittingRows(float f, int i) {
        boolean z;
        int i2;
        this.LOGGER.info(String.format("getFittingRows(%s, %s)", Float.valueOf(f), Integer.valueOf(i)));
        if (i > 0) {
            this.rows.size();
        }
        int numberOfColumns = getNumberOfColumns();
        ColumnMeasurementState[] columnMeasurementStateArr = new ColumnMeasurementState[numberOfColumns];
        for (int i3 = 0; i3 < numberOfColumns; i3++) {
            columnMeasurementStateArr[i3] = new ColumnMeasurementState();
        }
        HashMap map = new HashMap();
        int i4 = i;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (i4 < size()) {
            PdfPRow row = getRow(i4);
            float maxRowHeightsWithoutCalculating = row.getMaxRowHeightsWithoutCalculating();
            int i5 = 0;
            float f4 = 0.0f;
            while (i5 < numberOfColumns) {
                PdfPCell pdfPCell = row.getCells()[i5];
                ColumnMeasurementState columnMeasurementState = columnMeasurementStateArr[i5];
                if (pdfPCell == null) {
                    columnMeasurementState.consumeRowspan(f3, maxRowHeightsWithoutCalculating);
                } else {
                    columnMeasurementState.beginCell(pdfPCell, f3, maxRowHeightsWithoutCalculating);
                    this.LOGGER.info(String.format("Height after beginCell: %s (cell: %s)", Float.valueOf(columnMeasurementState.height), Float.valueOf(pdfPCell.getCachedMaxHeight())));
                }
                if (columnMeasurementState.cellEnds()) {
                    float f5 = columnMeasurementState.height;
                    if (f5 > f4) {
                        f4 = f5;
                    }
                }
                int i6 = 1;
                while (true) {
                    i2 = columnMeasurementState.colspan;
                    if (i6 < i2) {
                        columnMeasurementStateArr[i5 + i6].height = columnMeasurementState.height;
                        i6++;
                    }
                }
                i5 += i2;
                maxRowHeightsWithoutCalculating = maxRowHeightsWithoutCalculating;
            }
            float f6 = 0.0f;
            for (int i7 = 0; i7 < numberOfColumns; i7++) {
                float f7 = columnMeasurementStateArr[i7].height;
                if (f7 > f6) {
                    f6 = f7;
                }
            }
            row.setFinalMaxHeights(f4 - f3);
            if (f - (isSplitLate() ? f6 : f4) < 0.0f) {
                z = false;
                this.rowsNotChecked = z;
                return new FittingRows(i, i4 - 1, f2, f3, map);
            }
            map.put(Integer.valueOf(i4), Float.valueOf(f6 - f3));
            i4++;
            f2 = f6;
            f3 = f4;
        }
        z = false;
        this.rowsNotChecked = z;
        return new FittingRows(i, i4 - 1, f2, f3, map);
    }

    public PdfPTableFooter getFooter() {
        if (this.footer == null) {
            this.footer = new PdfPTableFooter();
        }
        return this.footer;
    }

    public float getFooterHeight() {
        int iMin = Math.min(this.rows.size(), this.headerRows);
        float maxHeights = 0.0f;
        for (int iMax = Math.max(0, this.headerRows - this.footerRows); iMax < iMin; iMax++) {
            PdfPRow pdfPRow = this.rows.get(iMax);
            if (pdfPRow != null) {
                maxHeights += pdfPRow.getMaxHeights();
            }
        }
        return maxHeights;
    }

    public int getFooterRows() {
        return this.footerRows;
    }

    public PdfPTableHeader getHeader() {
        if (this.header == null) {
            this.header = new PdfPTableHeader();
        }
        return this.header;
    }

    public float getHeaderHeight() {
        int iMin = Math.min(this.rows.size(), this.headerRows);
        float maxHeights = 0.0f;
        for (int i = 0; i < iMin; i++) {
            PdfPRow pdfPRow = this.rows.get(i);
            if (pdfPRow != null) {
                maxHeights += pdfPRow.getMaxHeights();
            }
        }
        return maxHeights;
    }

    public int getHeaderRows() {
        return this.headerRows;
    }

    public int getHorizontalAlignment() {
        return this.horizontalAlignment;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public AccessibleElementId getId() {
        return this.id;
    }

    public boolean getKeepTogether() {
        return this.keepTogether;
    }

    public int getLastCompletedRowIndex() {
        return this.rows.size() - 1;
    }

    public int getNumberOfColumns() {
        return this.relativeWidths.length;
    }

    @Override // com.itextpdf.text.api.Spaceable
    public float getPaddingTop() {
        return this.paddingTop;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public PdfName getRole() {
        return this.role;
    }

    public PdfPRow getRow(int i) {
        return this.rows.get(i);
    }

    public float getRowHeight(int i) {
        return getRowHeight(i, false);
    }

    public ArrayList<PdfPRow> getRows() {
        return this.rows;
    }

    public float getRowspanHeight(int i, int i2) {
        PdfPRow pdfPRow;
        float rowHeight = 0.0f;
        if (this.totalWidth > 0.0f && i >= 0 && i < this.rows.size() && (pdfPRow = this.rows.get(i)) != null && i2 < pdfPRow.getCells().length) {
            PdfPCell pdfPCell = pdfPRow.getCells()[i2];
            if (pdfPCell == null) {
                return 0.0f;
            }
            for (int i3 = 0; i3 < pdfPCell.getRowspan(); i3++) {
                rowHeight += getRowHeight(i + i3);
            }
        }
        return rowHeight;
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

    public String getSummary() {
        return getAccessibleAttribute(PdfName.SUMMARY).toString();
    }

    public PdfPTableEvent getTableEvent() {
        return this.tableEvent;
    }

    public float getTotalHeight() {
        return this.totalHeight;
    }

    public float getTotalWidth() {
        return this.totalWidth;
    }

    public float getWidthPercentage() {
        return this.widthPercentage;
    }

    public boolean hasRowspan(int i) {
        if (i < this.rows.size() && getRow(i).hasRowspan()) {
            return true;
        }
        PdfPRow row = i > 0 ? getRow(i - 1) : null;
        if (row != null && row.hasRowspan()) {
            return true;
        }
        for (int i2 = 0; i2 < getNumberOfColumns(); i2++) {
            if (rowSpanAbove(i - 1, i2)) {
                return true;
            }
        }
        return false;
    }

    public void init() {
        this.LOGGER.info("Initialize row and cell heights");
        for (PdfPRow pdfPRow : getRows()) {
            if (pdfPRow != null) {
                pdfPRow.calculated = false;
                for (PdfPCell pdfPCell : pdfPRow.getCells()) {
                    if (pdfPCell != null) {
                        pdfPCell.setCalculatedHeight(0.0f);
                    }
                }
            }
        }
    }

    @Override // com.itextpdf.text.LargeElement
    public boolean isComplete() {
        return this.complete;
    }

    @Override // com.itextpdf.text.Element
    public boolean isContent() {
        return true;
    }

    public boolean isExtendLastRow() {
        return this.extendLastRow[0];
    }

    public boolean isHeadersInEvent() {
        return this.headersInEvent;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public boolean isInline() {
        return false;
    }

    public boolean isLockedWidth() {
        return this.lockedWidth;
    }

    public boolean isLoopCheck() {
        return this.loopCheck;
    }

    @Override // com.itextpdf.text.Element
    public boolean isNestable() {
        return true;
    }

    public boolean isSkipFirstHeader() {
        return this.skipFirstHeader;
    }

    public boolean isSkipLastFooter() {
        return this.skipLastFooter;
    }

    public boolean isSplitLate() {
        return this.splitLate;
    }

    public boolean isSplitRows() {
        return this.splitRows;
    }

    public void keepRowsTogether(int[] iArr) {
        for (int i : iArr) {
            getRow(i).setMayNotBreak(true);
        }
    }

    public void normalizeHeadersFooters() {
        int i = this.footerRows;
        int i2 = this.headerRows;
        if (i > i2) {
            this.footerRows = i2;
        }
    }

    @Override // com.itextpdf.text.Element
    public boolean process(ElementListener elementListener) {
        try {
            return elementListener.add(this);
        } catch (DocumentException unused) {
            return false;
        }
    }

    public void resetColumnCount(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("the.number.of.columns.in.pdfptable.constructor.must.be.greater.than.zero", new Object[0]));
        }
        this.relativeWidths = new float[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.relativeWidths[i2] = 1.0f;
        }
        this.absoluteWidths = new float[this.relativeWidths.length];
        calculateWidths();
        this.currentRow = new PdfPCell[this.absoluteWidths.length];
        this.totalHeight = 0.0f;
    }

    public boolean rowSpanAbove(int i, int i2) {
        if (i2 >= getNumberOfColumns() || i2 < 0 || i < 1) {
            return false;
        }
        int i3 = i - 1;
        if (this.rows.get(i3) == null) {
            return false;
        }
        PdfPCell pdfPCellCellAt = cellAt(i3, i2);
        while (pdfPCellCellAt == null && i3 > 0) {
            i3--;
            if (this.rows.get(i3) == null) {
                return false;
            }
            pdfPCellCellAt = cellAt(i3, i2);
        }
        int i4 = i - i3;
        if (pdfPCellCellAt.getRowspan() == 1 && i4 > 1) {
            int i5 = i2 - 1;
            PdfPRow pdfPRow = this.rows.get(i3 + 1);
            i4--;
            pdfPCellCellAt = pdfPRow.getCells()[i5];
            while (pdfPCellCellAt == null && i5 > 0) {
                i5--;
                pdfPCellCellAt = pdfPRow.getCells()[i5];
            }
        }
        return pdfPCellCellAt != null && pdfPCellCellAt.getRowspan() > i4;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public void setAccessibleAttribute(PdfName pdfName, PdfObject pdfObject) {
        if (this.accessibleAttributes == null) {
            this.accessibleAttributes = new HashMap<>();
        }
        this.accessibleAttributes.put(pdfName, pdfObject);
    }

    public void setBreakPoints(int... iArr) {
        keepRowsTogether(0, this.rows.size());
        for (int i : iArr) {
            getRow(i).setMayNotBreak(false);
        }
    }

    @Override // com.itextpdf.text.LargeElement
    public void setComplete(boolean z) {
        this.complete = z;
    }

    public void setExtendLastRow(boolean z) {
        boolean[] zArr = this.extendLastRow;
        zArr[0] = z;
        zArr[1] = z;
    }

    public void setFooterRows(int i) {
        if (i < 0) {
            i = 0;
        }
        this.footerRows = i;
    }

    public void setHeaderRows(int i) {
        if (i < 0) {
            i = 0;
        }
        this.headerRows = i;
    }

    public void setHeadersInEvent(boolean z) {
        this.headersInEvent = z;
    }

    public void setHorizontalAlignment(int i) {
        this.horizontalAlignment = i;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public void setId(AccessibleElementId accessibleElementId) {
        this.id = accessibleElementId;
    }

    public void setKeepTogether(boolean z) {
        this.keepTogether = z;
    }

    public void setLockedWidth(boolean z) {
        this.lockedWidth = z;
    }

    public void setLoopCheck(boolean z) {
        this.loopCheck = z;
    }

    @Override // com.itextpdf.text.api.Spaceable
    public void setPaddingTop(float f) {
        this.paddingTop = f;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public void setRole(PdfName pdfName) {
        this.role = pdfName;
    }

    public void setRunDirection(int i) {
        if (i != 0 && i != 1 && i != 2 && i != 3) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("invalid.run.direction.1", i));
        }
        this.runDirection = i;
    }

    public void setSkipFirstHeader(boolean z) {
        this.skipFirstHeader = z;
    }

    public void setSkipLastFooter(boolean z) {
        this.skipLastFooter = z;
    }

    @Override // com.itextpdf.text.api.Spaceable
    public void setSpacingAfter(float f) {
        this.spacingAfter = f;
    }

    @Override // com.itextpdf.text.api.Spaceable
    public void setSpacingBefore(float f) {
        this.spacingBefore = f;
    }

    public void setSplitLate(boolean z) {
        this.splitLate = z;
    }

    public void setSplitRows(boolean z) {
        this.splitRows = z;
    }

    public void setSummary(String str) {
        setAccessibleAttribute(PdfName.SUMMARY, new PdfString(str));
    }

    public void setTableEvent(PdfPTableEvent pdfPTableEvent) {
        if (pdfPTableEvent == null) {
            this.tableEvent = null;
            return;
        }
        PdfPTableEvent pdfPTableEvent2 = this.tableEvent;
        if (pdfPTableEvent2 == null) {
            this.tableEvent = pdfPTableEvent;
            return;
        }
        if (pdfPTableEvent2 instanceof PdfPTableEventForwarder) {
            ((PdfPTableEventForwarder) pdfPTableEvent2).addTableEvent(pdfPTableEvent);
            return;
        }
        PdfPTableEventForwarder pdfPTableEventForwarder = new PdfPTableEventForwarder();
        pdfPTableEventForwarder.addTableEvent(this.tableEvent);
        pdfPTableEventForwarder.addTableEvent(pdfPTableEvent);
        this.tableEvent = pdfPTableEventForwarder;
    }

    public void setTotalWidth(float f) {
        if (this.totalWidth == f) {
            return;
        }
        this.totalWidth = f;
        this.totalHeight = 0.0f;
        calculateWidths();
        calculateHeights();
    }

    public void setWidthPercentage(float[] fArr, Rectangle rectangle) throws DocumentException {
        if (fArr.length != getNumberOfColumns()) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("wrong.number.of.columns", new Object[0]));
        }
        setTotalWidth(fArr);
        this.widthPercentage = (this.totalWidth / (rectangle.getRight() - rectangle.getLeft())) * 100.0f;
    }

    public void setWidths(float[] fArr) throws DocumentException {
        if (fArr.length != getNumberOfColumns()) {
            throw new DocumentException(MessageLocalization.getComposedMessage("wrong.number.of.columns", new Object[0]));
        }
        float[] fArr2 = new float[fArr.length];
        this.relativeWidths = fArr2;
        System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
        this.absoluteWidths = new float[fArr.length];
        this.totalHeight = 0.0f;
        calculateWidths();
        calculateHeights();
    }

    public int size() {
        return this.rows.size();
    }

    public float spacingAfter() {
        return this.spacingAfter;
    }

    public float spacingBefore() {
        return this.spacingBefore;
    }

    @Override // com.itextpdf.text.Element
    public int type() {
        return 23;
    }

    public float writeSelectedRows(int i, int i2, float f, float f2, PdfContentByte[] pdfContentByteArr) {
        return writeSelectedRows(0, -1, i, i2, f, f2, pdfContentByteArr);
    }

    public float getRowHeight(int i, boolean z) {
        PdfPRow pdfPRow;
        int i2;
        float maxHeight;
        if (this.totalWidth <= 0.0f || i < 0 || i >= this.rows.size() || (pdfPRow = this.rows.get(i)) == null) {
            return 0.0f;
        }
        if (z) {
            pdfPRow.setWidths(this.absoluteWidths);
        }
        float maxHeights = pdfPRow.getMaxHeights();
        for (int i3 = 0; i3 < this.relativeWidths.length; i3++) {
            if (rowSpanAbove(i, i3)) {
                int i4 = 1;
                while (true) {
                    i2 = i - i4;
                    if (!rowSpanAbove(i2, i3)) {
                        break;
                    }
                    i4++;
                }
                PdfPCell pdfPCell = this.rows.get(i2).getCells()[i3];
                if (pdfPCell == null || pdfPCell.getRowspan() != i4 + 1) {
                    maxHeight = 0.0f;
                } else {
                    maxHeight = pdfPCell.getMaxHeight();
                    while (i4 > 0) {
                        maxHeight -= getRowHeight(i - i4);
                        i4--;
                    }
                }
                if (maxHeight > maxHeights) {
                    maxHeights = maxHeight;
                }
            }
        }
        pdfPRow.setMaxHeights(maxHeights);
        return maxHeights;
    }

    public ArrayList<PdfPRow> getRows(int i, int i2) {
        ArrayList<PdfPRow> arrayList = new ArrayList<>();
        if (i >= 0 && i2 <= size()) {
            while (i < i2) {
                arrayList.add(adjustCellsInRow(i, i2));
                i++;
            }
        }
        return arrayList;
    }

    public boolean isExtendLastRow(boolean z) {
        return z ? this.extendLastRow[0] : this.extendLastRow[1];
    }

    public float writeSelectedRows(int i, int i2, int i3, int i4, float f, float f2, PdfContentByte[] pdfContentByteArr) {
        return writeSelectedRows(i, i2, i3, i4, f, f2, pdfContentByteArr, true);
    }

    public void keepRowsTogether(int i, int i2) {
        if (i < i2) {
            while (i < i2) {
                getRow(i).setMayNotBreak(true);
                i++;
            }
        }
    }

    public void setExtendLastRow(boolean z, boolean z2) {
        boolean[] zArr = this.extendLastRow;
        zArr[0] = z;
        zArr[1] = z2;
    }

    public float writeSelectedRows(int i, int i2, int i3, int i4, float f, float f2, PdfContentByte[] pdfContentByteArr, boolean z) {
        PdfPRow pdfPRow;
        PdfPRow pdfPRow2;
        if (this.totalWidth > 0.0f) {
            int size = this.rows.size();
            int i5 = i3 < 0 ? 0 : i3;
            if (i4 >= 0) {
                size = Math.min(i4, size);
            }
            if (i5 >= size) {
                return f2;
            }
            int numberOfColumns = getNumberOfColumns();
            int iMin = i < 0 ? 0 : Math.min(i, numberOfColumns);
            int iMin2 = i2 < 0 ? numberOfColumns : Math.min(i2, numberOfColumns);
            this.LOGGER.info(String.format("Writing row %s to %s; column %s to %s", Integer.valueOf(i5), Integer.valueOf(size), Integer.valueOf(iMin), Integer.valueOf(iMin2)));
            if (this.rowsNotChecked) {
                getFittingRows(Float.MAX_VALUE, i5);
            }
            ArrayList<PdfPRow> rows = getRows(i5, size);
            PdfPTableBody pdfPTableBodyOpenTableBlock = null;
            float maxHeights = f2;
            int i6 = i5;
            for (PdfPRow pdfPRow3 : rows) {
                if (getHeader().rows != null && getHeader().rows.contains(pdfPRow3) && pdfPTableBodyOpenTableBlock == null) {
                    pdfPTableBodyOpenTableBlock = openTableBlock(getHeader(), pdfContentByteArr[3]);
                } else if (getBody().rows != null && getBody().rows.contains(pdfPRow3) && pdfPTableBodyOpenTableBlock == null) {
                    pdfPTableBodyOpenTableBlock = openTableBlock(getBody(), pdfContentByteArr[3]);
                } else if (getFooter().rows != null && getFooter().rows.contains(pdfPRow3) && pdfPTableBodyOpenTableBlock == null) {
                    pdfPTableBodyOpenTableBlock = openTableBlock(getFooter(), pdfContentByteArr[3]);
                }
                PdfPTableBody pdfPTableBody = pdfPTableBodyOpenTableBlock;
                if (pdfPRow3 != null) {
                    pdfPRow = pdfPRow3;
                    pdfPRow3.writeCells(iMin, iMin2, f, maxHeights, pdfContentByteArr, z);
                    maxHeights -= pdfPRow.getMaxHeights();
                } else {
                    pdfPRow = pdfPRow3;
                }
                if (getHeader().rows != null) {
                    pdfPRow2 = pdfPRow;
                    if (getHeader().rows.contains(pdfPRow2) && (i6 == size - 1 || !getHeader().rows.contains(rows.get(i6 + 1)))) {
                        pdfPTableBodyOpenTableBlock = closeTableBlock(getHeader(), pdfContentByteArr[3]);
                    }
                    i6++;
                    rows = rows;
                } else {
                    pdfPRow2 = pdfPRow;
                }
                if (getBody().rows != null && getBody().rows.contains(pdfPRow2) && (i6 == size - 1 || !getBody().rows.contains(rows.get(i6 + 1)))) {
                    pdfPTableBodyOpenTableBlock = closeTableBlock(getBody(), pdfContentByteArr[3]);
                } else {
                    pdfPTableBodyOpenTableBlock = (getFooter().rows == null || !getFooter().rows.contains(pdfPRow2) || (i6 != size + (-1) && getFooter().rows.contains(rows.get(i6 + 1)))) ? pdfPTableBody : closeTableBlock(getFooter(), pdfContentByteArr[3]);
                }
                i6++;
                rows = rows;
            }
            ArrayList<PdfPRow> arrayList = rows;
            if (this.tableEvent != null && iMin == 0 && iMin2 == numberOfColumns) {
                float[] fArr = new float[(size - i5) + 1];
                fArr[0] = f2;
                for (int i7 = i5; i7 < size; i7++) {
                    PdfPRow pdfPRow4 = arrayList.get(i7);
                    int i8 = i7 - i5;
                    fArr[i8 + 1] = fArr[i8] - (pdfPRow4 != null ? pdfPRow4.getMaxHeights() : 0.0f);
                }
                this.tableEvent.tableLayout(this, getEventWidths(f, i5, size, this.headersInEvent), fArr, this.headersInEvent ? this.headerRows : 0, i5, pdfContentByteArr);
            }
            return maxHeights;
        }
        throw new RuntimeException(MessageLocalization.getComposedMessage("the.table.width.must.be.greater.than.zero", new Object[0]));
    }

    public void keepRowsTogether(int i) {
        keepRowsTogether(i, this.rows.size());
    }

    public void setWidthPercentage(float f) {
        this.widthPercentage = f;
    }

    public void setTotalWidth(float[] fArr) throws DocumentException {
        if (fArr.length == getNumberOfColumns()) {
            this.totalWidth = 0.0f;
            for (float f : fArr) {
                this.totalWidth += f;
            }
            setWidths(fArr);
            return;
        }
        throw new DocumentException(MessageLocalization.getComposedMessage("wrong.number.of.columns", new Object[0]));
    }

    public void setWidths(int[] iArr) throws DocumentException {
        float[] fArr = new float[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            fArr[i] = iArr[i];
        }
        setWidths(fArr);
    }

    public PdfPTable(float[] fArr) {
        if (fArr != null) {
            if (fArr.length != 0) {
                float[] fArr2 = new float[fArr.length];
                this.relativeWidths = fArr2;
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                this.absoluteWidths = new float[fArr.length];
                calculateWidths();
                this.currentRow = new PdfPCell[this.absoluteWidths.length];
                this.keepTogether = false;
                return;
            }
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("the.widths.array.in.pdfptable.constructor.can.not.have.zero.length", new Object[0]));
        }
        throw new NullPointerException(MessageLocalization.getComposedMessage("the.widths.array.in.pdfptable.constructor.can.not.be.null", new Object[0]));
    }

    public float writeSelectedRows(int i, int i2, float f, float f2, PdfContentByte pdfContentByte) {
        return writeSelectedRows(0, -1, i, i2, f, f2, pdfContentByte);
    }

    public float writeSelectedRows(int i, int i2, int i3, int i4, float f, float f2, PdfContentByte pdfContentByte) {
        return writeSelectedRows(i, i2, i3, i4, f, f2, pdfContentByte, true);
    }

    public void addCell(String str) {
        addCell(new Phrase(str));
    }

    public float writeSelectedRows(int i, int i2, int i3, int i4, float f, float f2, PdfContentByte pdfContentByte, boolean z) {
        int numberOfColumns = getNumberOfColumns();
        int iMin = i < 0 ? 0 : Math.min(i, numberOfColumns);
        int iMin2 = i2 < 0 ? numberOfColumns : Math.min(i2, numberOfColumns);
        boolean z2 = (iMin == 0 && iMin2 == numberOfColumns) ? false : true;
        if (z2) {
            float f3 = 0.0f;
            for (int i5 = iMin; i5 < iMin2; i5++) {
                f3 += this.absoluteWidths[i5];
            }
            pdfContentByte.saveState();
            float f4 = iMin == 0 ? 10000.0f : 0.0f;
            pdfContentByte.rectangle(f - f4, -10000.0f, f3 + f4 + (iMin2 == numberOfColumns ? 10000.0f : 0.0f), 20000.0f);
            pdfContentByte.clip();
            pdfContentByte.newPath();
        }
        PdfContentByte[] pdfContentByteArrBeginWritingRows = beginWritingRows(pdfContentByte);
        float fWriteSelectedRows = writeSelectedRows(iMin, iMin2, i3, i4, f, f2, pdfContentByteArrBeginWritingRows, z);
        endWritingRows(pdfContentByteArrBeginWritingRows);
        if (z2) {
            pdfContentByte.restoreState();
        }
        return fWriteSelectedRows;
    }

    public void addCell(PdfPTable pdfPTable) {
        this.defaultCell.setTable(pdfPTable);
        addCell(this.defaultCell).id = new AccessibleElementId();
        this.defaultCell.setTable(null);
    }

    public void addCell(Image image) {
        this.defaultCell.setImage(image);
        addCell(this.defaultCell).id = new AccessibleElementId();
        this.defaultCell.setImage(null);
    }

    public void addCell(Phrase phrase) {
        this.defaultCell.setPhrase(phrase);
        addCell(this.defaultCell).id = new AccessibleElementId();
        this.defaultCell.setPhrase(null);
    }

    public PdfPTable(int i) {
        if (i > 0) {
            this.relativeWidths = new float[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.relativeWidths[i2] = 1.0f;
            }
            this.absoluteWidths = new float[this.relativeWidths.length];
            calculateWidths();
            this.currentRow = new PdfPCell[this.absoluteWidths.length];
            this.keepTogether = false;
            return;
        }
        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("the.number.of.columns.in.pdfptable.constructor.must.be.greater.than.zero", new Object[0]));
    }

    public PdfPTable(PdfPTable pdfPTable) {
        PdfPCell pdfPCell;
        copyFormat(pdfPTable);
        int i = 0;
        while (true) {
            PdfPCell[] pdfPCellArr = this.currentRow;
            if (i >= pdfPCellArr.length || (pdfPCell = pdfPTable.currentRow[i]) == null) {
                break;
            }
            pdfPCellArr[i] = new PdfPCell(pdfPCell);
            i++;
        }
        for (int i2 = 0; i2 < pdfPTable.rows.size(); i2++) {
            PdfPRow pdfPRow = pdfPTable.rows.get(i2);
            if (pdfPRow != null) {
                pdfPRow = new PdfPRow(pdfPRow);
            }
            this.rows.add(pdfPRow);
        }
    }
}
