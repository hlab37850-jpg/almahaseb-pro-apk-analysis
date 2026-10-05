package org.apache.poi.hssf.record;

import org.apache.poi.ss.usermodel.ErrorConstants;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes4.dex */
public final class BoolErrRecord extends CellRecord {
    public static final short sid = 517;
    private boolean _isError;
    private int _value;

    public BoolErrRecord() {
    }

    @Override // org.apache.poi.hssf.record.CellRecord
    public void appendValueText(StringBuilder sb) {
        if (isBoolean()) {
            sb.append("  .boolVal = ");
            sb.append(getBooleanValue());
            return;
        }
        sb.append("  .errCode = ");
        sb.append(ErrorConstants.getText(getErrorValue()));
        sb.append(" (");
        sb.append(HexDump.byteToHex(getErrorValue()));
        sb.append(")");
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        BoolErrRecord boolErrRecord = new BoolErrRecord();
        copyBaseFields(boolErrRecord);
        boolErrRecord._value = this._value;
        boolErrRecord._isError = this._isError;
        return boolErrRecord;
    }

    public boolean getBooleanValue() {
        return this._value != 0;
    }

    public byte getErrorValue() {
        return (byte) this._value;
    }

    @Override // org.apache.poi.hssf.record.CellRecord
    public String getRecordName() {
        return "BOOLERR";
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 517;
    }

    @Override // org.apache.poi.hssf.record.CellRecord
    public int getValueDataSize() {
        return 2;
    }

    public boolean isBoolean() {
        return !this._isError;
    }

    public boolean isError() {
        return this._isError;
    }

    @Override // org.apache.poi.hssf.record.CellRecord
    public void serializeValue(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(this._value);
        littleEndianOutput.writeByte(this._isError ? 1 : 0);
    }

    public void setValue(boolean z) {
        this._value = z ? 1 : 0;
        this._isError = false;
    }

    public BoolErrRecord(RecordInputStream recordInputStream) {
        super(recordInputStream);
        int iRemaining = recordInputStream.remaining();
        if (iRemaining == 2) {
            this._value = recordInputStream.readByte();
        } else {
            if (iRemaining != 3) {
                throw new RecordFormatException("Unexpected size (" + recordInputStream.remaining() + ") for BOOLERR record.");
            }
            this._value = recordInputStream.readUShort();
        }
        int uByte = recordInputStream.readUByte();
        if (uByte == 0) {
            this._isError = false;
            return;
        }
        if (uByte == 1) {
            this._isError = true;
            return;
        }
        throw new RecordFormatException("Unexpected isError flag (" + uByte + ") for BOOLERR record.");
    }

    public void setValue(byte b) {
        if (b != 0 && b != 7 && b != 15 && b != 23 && b != 29 && b != 36 && b != 42) {
            throw new IllegalArgumentException("Error Value can only be 0,7,15,23,29,36 or 42. It cannot be " + ((int) b));
        }
        this._value = b;
        this._isError = true;
    }
}
