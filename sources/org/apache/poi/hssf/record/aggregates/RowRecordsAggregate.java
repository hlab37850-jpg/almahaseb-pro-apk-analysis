package org.apache.poi.hssf.record.aggregates;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.apache.poi.hssf.model.RecordStream;
import org.apache.poi.hssf.record.CellValueRecordInterface;
import org.apache.poi.hssf.record.DBCellRecord;
import org.apache.poi.hssf.record.DimensionsRecord;
import org.apache.poi.hssf.record.FormulaRecord;
import org.apache.poi.hssf.record.IndexRecord;
import org.apache.poi.hssf.record.MulBlankRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RowRecord;
import org.apache.poi.hssf.record.UnknownRecord;
import org.apache.poi.hssf.record.formula.FormulaShifter;
import org.apache.poi.ss.SpreadsheetVersion;

/* JADX INFO: loaded from: classes4.dex */
public final class RowRecordsAggregate extends RecordAggregate {
    private int _firstrow;
    private int _lastrow;
    private final Map<Integer, RowRecord> _rowRecords;
    private final SharedValueManager _sharedValueManager;
    private final List<Record> _unknownRecords;
    private final ValueRecordsAggregate _valuesAgg;

    public RowRecordsAggregate() {
        this(SharedValueManager.createEmpty());
    }

    private void addUnknownRecord(Record record) {
        this._unknownRecords.add(record);
    }

    public static RowRecord createRow(int i) {
        return new RowRecord(i);
    }

    private int getEndRowNumberForBlock(int i) {
        int size = ((i + 1) * 32) - 1;
        if (size >= this._rowRecords.size()) {
            size = this._rowRecords.size() - 1;
        }
        Iterator<RowRecord> it = this._rowRecords.values().iterator();
        RowRecord next = null;
        for (int i2 = 0; i2 <= size; i2++) {
            next = it.next();
        }
        if (next != null) {
            return next.getRowNumber();
        }
        throw new RuntimeException("Did not find start row for block " + i);
    }

    private int getRowBlockSize(int i) {
        return getRowCountForBlock(i) * 20;
    }

    private int getStartRowNumberForBlock(int i) {
        int i2 = i * 32;
        Iterator<RowRecord> it = this._rowRecords.values().iterator();
        RowRecord next = null;
        for (int i3 = 0; i3 <= i2; i3++) {
            next = it.next();
        }
        if (next != null) {
            return next.getRowNumber();
        }
        throw new RuntimeException("Did not find start row for block " + i);
    }

    private int visitRowRecordsForBlock(int i, RecordAggregate.RecordVisitor recordVisitor) {
        int i2 = i * 32;
        int i3 = i2 + 32;
        Iterator<RowRecord> it = this._rowRecords.values().iterator();
        int recordSize = 0;
        int i4 = 0;
        while (i4 < i2) {
            it.next();
            i4++;
        }
        while (it.hasNext()) {
            int i5 = i4 + 1;
            if (i4 >= i3) {
                break;
            }
            RowRecord next = it.next();
            recordSize += next.getRecordSize();
            recordVisitor.visitRecord(next);
            i4 = i5;
        }
        return recordSize;
    }

    private int writeHidden(RowRecord rowRecord, int i) {
        short outlineLevel = rowRecord.getOutlineLevel();
        while (rowRecord != null && getRow(i).getOutlineLevel() >= outlineLevel) {
            rowRecord.setZeroHeight(true);
            i++;
            rowRecord = getRow(i);
        }
        return i;
    }

    public void collapseRow(int i) {
        int iFindStartOfRowOutlineGroup = findStartOfRowOutlineGroup(i);
        int iWriteHidden = writeHidden(getRow(iFindStartOfRowOutlineGroup), iFindStartOfRowOutlineGroup);
        RowRecord row = getRow(iWriteHidden);
        if (row == null) {
            row = createRow(iWriteHidden);
            insertRow(row);
        }
        row.setColapsed(true);
    }

    public DimensionsRecord createDimensions() {
        DimensionsRecord dimensionsRecord = new DimensionsRecord();
        dimensionsRecord.setFirstRow(this._firstrow);
        dimensionsRecord.setLastRow(this._lastrow);
        dimensionsRecord.setFirstCol((short) this._valuesAgg.getFirstCellNum());
        dimensionsRecord.setLastCol((short) this._valuesAgg.getLastCellNum());
        return dimensionsRecord;
    }

    public FormulaRecordAggregate createFormula(int i, int i2) {
        FormulaRecord formulaRecord = new FormulaRecord();
        formulaRecord.setRow(i);
        formulaRecord.setColumn((short) i2);
        return new FormulaRecordAggregate(formulaRecord, null, this._sharedValueManager);
    }

    public IndexRecord createIndexRecord(int i, int i2) {
        IndexRecord indexRecord = new IndexRecord();
        indexRecord.setFirstRow(this._firstrow);
        indexRecord.setLastRowAdd1(this._lastrow + 1);
        int rowBlockCount = getRowBlockCount();
        int recordSizeForBlockCount = i + IndexRecord.getRecordSizeForBlockCount(rowBlockCount) + i2;
        for (int i3 = 0; i3 < rowBlockCount; i3++) {
            int rowBlockSize = recordSizeForBlockCount + getRowBlockSize(i3) + this._valuesAgg.getRowCellBlockSize(getStartRowNumberForBlock(i3), getEndRowNumberForBlock(i3));
            indexRecord.addDbcell(rowBlockSize);
            recordSizeForBlockCount = rowBlockSize + (getRowCountForBlock(i3) * 2) + 8;
        }
        return indexRecord;
    }

    public void expandRow(int i) {
        if (i != -1 && isRowGroupCollapsed(i)) {
            int iFindStartOfRowOutlineGroup = findStartOfRowOutlineGroup(i);
            RowRecord row = getRow(iFindStartOfRowOutlineGroup);
            int iFindEndOfRowOutlineGroup = findEndOfRowOutlineGroup(i);
            if (!isRowGroupHiddenByParent(i)) {
                while (iFindStartOfRowOutlineGroup <= iFindEndOfRowOutlineGroup) {
                    RowRecord row2 = getRow(iFindStartOfRowOutlineGroup);
                    if (row.getOutlineLevel() == row2.getOutlineLevel() || !isRowGroupCollapsed(iFindStartOfRowOutlineGroup)) {
                        row2.setZeroHeight(false);
                    }
                    iFindStartOfRowOutlineGroup++;
                }
            }
            getRow(iFindEndOfRowOutlineGroup + 1).setColapsed(false);
        }
    }

    public int findEndOfRowOutlineGroup(int i) {
        short outlineLevel = getRow(i).getOutlineLevel();
        while (i < getLastRowNum() && getRow(i) != null && getRow(i).getOutlineLevel() >= outlineLevel) {
            i++;
        }
        return i - 1;
    }

    public int findStartOfRowOutlineGroup(int i) {
        short outlineLevel = getRow(i).getOutlineLevel();
        while (getRow(i) != null) {
            if (getRow(i).getOutlineLevel() < outlineLevel) {
                return i + 1;
            }
            i--;
        }
        return i + 1;
    }

    public int getFirstRowNum() {
        return this._firstrow;
    }

    public Iterator<RowRecord> getIterator() {
        return this._rowRecords.values().iterator();
    }

    public int getLastRowNum() {
        return this._lastrow;
    }

    public int getPhysicalNumberOfRows() {
        return this._rowRecords.size();
    }

    public RowRecord getRow(int i) {
        int lastRowIndex = SpreadsheetVersion.EXCEL97.getLastRowIndex();
        if (i >= 0 && i <= lastRowIndex) {
            return this._rowRecords.get(Integer.valueOf(i));
        }
        throw new IllegalArgumentException("The row number must be between 0 and " + lastRowIndex);
    }

    public int getRowBlockCount() {
        int size = this._rowRecords.size() / 32;
        return this._rowRecords.size() % 32 != 0 ? size + 1 : size;
    }

    public int getRowCountForBlock(int i) {
        int i2 = i * 32;
        int size = i2 + 31;
        if (size >= this._rowRecords.size()) {
            size = this._rowRecords.size() - 1;
        }
        return (size - i2) + 1;
    }

    public CellValueRecordInterface[] getValueRecords() {
        return this._valuesAgg.getValueRecords();
    }

    public void insertCell(CellValueRecordInterface cellValueRecordInterface) {
        this._valuesAgg.insertCell(cellValueRecordInterface);
    }

    public void insertRow(RowRecord rowRecord) {
        this._rowRecords.put(Integer.valueOf(rowRecord.getRowNumber()), rowRecord);
        int rowNumber = rowRecord.getRowNumber();
        int i = this._firstrow;
        if (rowNumber < i || i == -1) {
            this._firstrow = rowRecord.getRowNumber();
        }
        int rowNumber2 = rowRecord.getRowNumber();
        int i2 = this._lastrow;
        if (rowNumber2 > i2 || i2 == -1) {
            this._lastrow = rowRecord.getRowNumber();
        }
    }

    public boolean isRowGroupCollapsed(int i) {
        int iFindEndOfRowOutlineGroup = findEndOfRowOutlineGroup(i) + 1;
        if (getRow(iFindEndOfRowOutlineGroup) == null) {
            return false;
        }
        return getRow(iFindEndOfRowOutlineGroup).getColapsed();
    }

    public boolean isRowGroupHiddenByParent(int i) {
        short outlineLevel;
        boolean zeroHeight;
        boolean zeroHeight2;
        int iFindEndOfRowOutlineGroup = findEndOfRowOutlineGroup(i) + 1;
        short outlineLevel2 = 0;
        if (getRow(iFindEndOfRowOutlineGroup) == null) {
            zeroHeight = false;
            outlineLevel = 0;
        } else {
            outlineLevel = getRow(iFindEndOfRowOutlineGroup).getOutlineLevel();
            zeroHeight = getRow(iFindEndOfRowOutlineGroup).getZeroHeight();
        }
        int iFindStartOfRowOutlineGroup = findStartOfRowOutlineGroup(i) - 1;
        if (iFindStartOfRowOutlineGroup < 0 || getRow(iFindStartOfRowOutlineGroup) == null) {
            zeroHeight2 = false;
        } else {
            outlineLevel2 = getRow(iFindStartOfRowOutlineGroup).getOutlineLevel();
            zeroHeight2 = getRow(iFindStartOfRowOutlineGroup).getZeroHeight();
        }
        return outlineLevel > outlineLevel2 ? zeroHeight : zeroHeight2;
    }

    public void removeCell(CellValueRecordInterface cellValueRecordInterface) {
        if (cellValueRecordInterface instanceof FormulaRecordAggregate) {
            ((FormulaRecordAggregate) cellValueRecordInterface).notifyFormulaChanging();
        }
        this._valuesAgg.removeCell(cellValueRecordInterface);
    }

    public void removeRow(RowRecord rowRecord) {
        int rowNumber = rowRecord.getRowNumber();
        this._valuesAgg.removeAllCellsValuesForRow(rowNumber);
        Integer numValueOf = Integer.valueOf(rowNumber);
        RowRecord rowRecordRemove = this._rowRecords.remove(numValueOf);
        if (rowRecordRemove != null) {
            if (rowRecord == rowRecordRemove) {
                return;
            }
            this._rowRecords.put(numValueOf, rowRecordRemove);
            throw new RuntimeException("Attempt to remove row that does not belong to this sheet");
        }
        throw new RuntimeException("Invalid row index (" + rowNumber + ")");
    }

    public void updateFormulasAfterRowShift(FormulaShifter formulaShifter, int i) {
        this._valuesAgg.updateFormulasAfterRowShift(formulaShifter, i);
    }

    @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate
    public void visitContainedRecords(RecordAggregate.RecordVisitor recordVisitor) {
        RecordAggregate.PositionTrackingVisitor positionTrackingVisitor = new RecordAggregate.PositionTrackingVisitor(recordVisitor, 0);
        int rowBlockCount = getRowBlockCount();
        for (int i = 0; i < rowBlockCount; i++) {
            int iVisitRowRecordsForBlock = visitRowRecordsForBlock(i, recordVisitor);
            int endRowNumberForBlock = getEndRowNumberForBlock(i);
            DBCellRecord.Builder builder = new DBCellRecord.Builder();
            int i2 = iVisitRowRecordsForBlock - 20;
            for (int startRowNumberForBlock = getStartRowNumberForBlock(i); startRowNumberForBlock <= endRowNumberForBlock; startRowNumberForBlock++) {
                if (this._valuesAgg.rowHasCells(startRowNumberForBlock)) {
                    positionTrackingVisitor.setPosition(0);
                    this._valuesAgg.visitCellsForRow(startRowNumberForBlock, positionTrackingVisitor);
                    int position = positionTrackingVisitor.getPosition();
                    iVisitRowRecordsForBlock += position;
                    builder.addCellOffset(i2);
                    i2 = position;
                }
            }
            recordVisitor.visitRecord(builder.build(iVisitRowRecordsForBlock));
        }
        for (int i3 = 0; i3 < this._unknownRecords.size(); i3++) {
            recordVisitor.visitRecord(this._unknownRecords.get(i3));
        }
    }

    private RowRecordsAggregate(SharedValueManager sharedValueManager) {
        this._firstrow = -1;
        this._lastrow = -1;
        if (sharedValueManager == null) {
            throw new IllegalArgumentException("SharedValueManager must be provided.");
        }
        this._rowRecords = new TreeMap();
        this._valuesAgg = new ValueRecordsAggregate();
        this._unknownRecords = new ArrayList();
        this._sharedValueManager = sharedValueManager;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RowRecordsAggregate(RecordStream recordStream, SharedValueManager sharedValueManager) {
        this(sharedValueManager);
        while (recordStream.hasNext()) {
            Record next = recordStream.getNext();
            short sid = next.getSid();
            if (sid != 215) {
                if (sid != 520) {
                    if (next instanceof UnknownRecord) {
                        addUnknownRecord(next);
                        while (recordStream.peekNextSid() == 60) {
                            addUnknownRecord(recordStream.getNext());
                        }
                    } else if (next instanceof MulBlankRecord) {
                        this._valuesAgg.addMultipleBlanks((MulBlankRecord) next);
                    } else if (next instanceof CellValueRecordInterface) {
                        this._valuesAgg.construct((CellValueRecordInterface) next, recordStream, sharedValueManager);
                    } else {
                        throw new RuntimeException("Unexpected record type (" + next.getClass().getName() + ")");
                    }
                } else {
                    insertRow((RowRecord) next);
                }
            }
        }
    }
}
