package org.apache.poi.hssf.record;

import com.zebra.sdk.util.internal.StringUtilities;
import org.apache.poi.hssf.record.cf.CellRangeUtil;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes4.dex */
public final class CFHeaderRecord extends StandardRecord {
    public static final short sid = 432;
    private int field_1_numcf;
    private int field_2_need_recalculation;
    private CellRangeAddress field_3_enclosing_cell_range;
    private CellRangeAddressList field_4_cell_ranges;

    public CFHeaderRecord() {
        this.field_4_cell_ranges = new CellRangeAddressList();
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        CFHeaderRecord cFHeaderRecord = new CFHeaderRecord();
        cFHeaderRecord.field_1_numcf = this.field_1_numcf;
        cFHeaderRecord.field_2_need_recalculation = this.field_2_need_recalculation;
        cFHeaderRecord.field_3_enclosing_cell_range = this.field_3_enclosing_cell_range;
        cFHeaderRecord.field_4_cell_ranges = this.field_4_cell_ranges.copy();
        return cFHeaderRecord;
    }

    public CellRangeAddress[] getCellRanges() {
        return this.field_4_cell_ranges.getCellRangeAddresses();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return this.field_4_cell_ranges.getSize() + 12;
    }

    public CellRangeAddress getEnclosingCellRange() {
        return this.field_3_enclosing_cell_range;
    }

    public boolean getNeedRecalculation() {
        return this.field_2_need_recalculation == 1;
    }

    public int getNumberOfConditionalFormats() {
        return this.field_1_numcf;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_numcf);
        littleEndianOutput.writeShort(this.field_2_need_recalculation);
        this.field_3_enclosing_cell_range.serialize(littleEndianOutput);
        this.field_4_cell_ranges.serialize(littleEndianOutput);
    }

    public void setCellRanges(CellRangeAddress[] cellRangeAddressArr) {
        if (cellRangeAddressArr == null) {
            throw new IllegalArgumentException("cellRanges must not be null");
        }
        CellRangeAddressList cellRangeAddressList = new CellRangeAddressList();
        CellRangeAddress cellRangeAddressCreateEnclosingCellRange = null;
        for (CellRangeAddress cellRangeAddress : cellRangeAddressArr) {
            cellRangeAddressCreateEnclosingCellRange = CellRangeUtil.createEnclosingCellRange(cellRangeAddress, cellRangeAddressCreateEnclosingCellRange);
            cellRangeAddressList.addCellRangeAddress(cellRangeAddress);
        }
        this.field_3_enclosing_cell_range = cellRangeAddressCreateEnclosingCellRange;
        this.field_4_cell_ranges = cellRangeAddressList;
    }

    public void setEnclosingCellRange(CellRangeAddress cellRangeAddress) {
        this.field_3_enclosing_cell_range = cellRangeAddress;
    }

    public void setNeedRecalculation(boolean z) {
        this.field_2_need_recalculation = z ? 1 : 0;
    }

    public void setNumberOfConditionalFormats(int i) {
        this.field_1_numcf = i;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[CFHEADER]\n");
        stringBuffer.append("\t.id\t\t= ");
        stringBuffer.append(Integer.toHexString(432));
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("\t.numCF\t\t\t= ");
        stringBuffer.append(getNumberOfConditionalFormats());
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("\t.needRecalc\t   = ");
        stringBuffer.append(getNeedRecalculation());
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("\t.enclosingCellRange= ");
        stringBuffer.append(getEnclosingCellRange());
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("\t.cfranges=[");
        int i = 0;
        while (i < this.field_4_cell_ranges.countRanges()) {
            stringBuffer.append(i == 0 ? "" : ",");
            stringBuffer.append(this.field_4_cell_ranges.getCellRangeAddress(i).toString());
            i++;
        }
        stringBuffer.append("]\n");
        stringBuffer.append("[/CFHEADER]\n");
        return stringBuffer.toString();
    }

    public CFHeaderRecord(CellRangeAddress[] cellRangeAddressArr, int i) {
        setCellRanges(CellRangeUtil.mergeCellRanges(cellRangeAddressArr));
        this.field_1_numcf = i;
    }

    public CFHeaderRecord(RecordInputStream recordInputStream) {
        this.field_1_numcf = recordInputStream.readShort();
        this.field_2_need_recalculation = recordInputStream.readShort();
        this.field_3_enclosing_cell_range = new CellRangeAddress(recordInputStream);
        this.field_4_cell_ranges = new CellRangeAddressList(recordInputStream);
    }
}
