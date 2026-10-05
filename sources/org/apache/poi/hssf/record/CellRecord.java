package org.apache.poi.hssf.record;

import com.zebra.sdk.util.internal.StringUtilities;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CellRecord extends StandardRecord implements CellValueRecordInterface {
    private int _columnIndex;
    private int _formatIndex;
    private int _rowIndex;

    public CellRecord() {
    }

    public abstract void appendValueText(StringBuilder sb);

    public final void copyBaseFields(CellRecord cellRecord) {
        cellRecord._rowIndex = this._rowIndex;
        cellRecord._columnIndex = this._columnIndex;
        cellRecord._formatIndex = this._formatIndex;
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public final short getColumn() {
        return (short) this._columnIndex;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public final int getDataSize() {
        return getValueDataSize() + 6;
    }

    public abstract String getRecordName();

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public final int getRow() {
        return this._rowIndex;
    }

    public abstract int getValueDataSize();

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public final short getXFIndex() {
        return (short) this._formatIndex;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public final void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(getRow());
        littleEndianOutput.writeShort(getColumn());
        littleEndianOutput.writeShort(getXFIndex());
        serializeValue(littleEndianOutput);
    }

    public abstract void serializeValue(LittleEndianOutput littleEndianOutput);

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public final void setColumn(short s) {
        this._columnIndex = s;
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public final void setRow(int i) {
        this._rowIndex = i;
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public final void setXFIndex(short s) {
        this._formatIndex = s;
    }

    @Override // org.apache.poi.hssf.record.Record
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        String recordName = getRecordName();
        sb.append("[");
        sb.append(recordName);
        sb.append("]\n");
        sb.append("    .row    = ");
        sb.append(HexDump.shortToHex(getRow()));
        sb.append(StringUtilities.LF);
        sb.append("    .col    = ");
        sb.append(HexDump.shortToHex(getColumn()));
        sb.append(StringUtilities.LF);
        sb.append("    .xfindex= ");
        sb.append(HexDump.shortToHex(getXFIndex()));
        sb.append(StringUtilities.LF);
        appendValueText(sb);
        sb.append(StringUtilities.LF);
        sb.append("[/");
        sb.append(recordName);
        sb.append("]\n");
        return sb.toString();
    }

    public CellRecord(RecordInputStream recordInputStream) {
        this._rowIndex = recordInputStream.readUShort();
        this._columnIndex = recordInputStream.readUShort();
        this._formatIndex = recordInputStream.readUShort();
    }
}
