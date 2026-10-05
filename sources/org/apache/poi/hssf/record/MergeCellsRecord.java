package org.apache.poi.hssf.record;

import com.zebra.sdk.util.internal.StringUtilities;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes4.dex */
public final class MergeCellsRecord extends StandardRecord {
    public static final short sid = 229;
    private final int _numberOfRegions;
    private CellRangeAddress[] _regions;
    private final int _startIndex;

    public MergeCellsRecord(CellRangeAddress[] cellRangeAddressArr, int i, int i2) {
        this._regions = cellRangeAddressArr;
        this._startIndex = i;
        this._numberOfRegions = i2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        int i = this._numberOfRegions;
        CellRangeAddress[] cellRangeAddressArr = new CellRangeAddress[i];
        for (int i2 = 0; i2 < i; i2++) {
            cellRangeAddressArr[i2] = this._regions[this._startIndex + i2].copy();
        }
        return new MergeCellsRecord(cellRangeAddressArr, 0, i);
    }

    public CellRangeAddress getAreaAt(int i) {
        return this._regions[this._startIndex + i];
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return CellRangeAddressList.getEncodedSize(this._numberOfRegions);
    }

    public short getNumAreas() {
        return (short) this._numberOfRegions;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this._numberOfRegions);
        for (int i = 0; i < this._numberOfRegions; i++) {
            this._regions[this._startIndex + i].serialize(littleEndianOutput);
        }
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[MERGEDCELLS]");
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("     .numregions =");
        stringBuffer.append((int) getNumAreas());
        stringBuffer.append(StringUtilities.LF);
        for (int i = 0; i < this._numberOfRegions; i++) {
            CellRangeAddress cellRangeAddress = this._regions[this._startIndex + i];
            stringBuffer.append("     .rowfrom =");
            stringBuffer.append(cellRangeAddress.getFirstRow());
            stringBuffer.append(StringUtilities.LF);
            stringBuffer.append("     .rowto   =");
            stringBuffer.append(cellRangeAddress.getLastRow());
            stringBuffer.append(StringUtilities.LF);
            stringBuffer.append("     .colfrom =");
            stringBuffer.append(cellRangeAddress.getFirstColumn());
            stringBuffer.append(StringUtilities.LF);
            stringBuffer.append("     .colto   =");
            stringBuffer.append(cellRangeAddress.getLastColumn());
            stringBuffer.append(StringUtilities.LF);
        }
        stringBuffer.append("[MERGEDCELLS]");
        stringBuffer.append(StringUtilities.LF);
        return stringBuffer.toString();
    }

    public MergeCellsRecord(RecordInputStream recordInputStream) {
        int uShort = recordInputStream.readUShort();
        CellRangeAddress[] cellRangeAddressArr = new CellRangeAddress[uShort];
        for (int i = 0; i < uShort; i++) {
            cellRangeAddressArr[i] = new CellRangeAddress(recordInputStream);
        }
        this._numberOfRegions = uShort;
        this._startIndex = 0;
        this._regions = cellRangeAddressArr;
    }
}
