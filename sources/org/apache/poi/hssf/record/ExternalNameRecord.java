package org.apache.poi.hssf.record;

import com.zebra.sdk.util.internal.StringUtilities;
import org.apache.poi.hssf.record.constant.ConstantValueParser;
import org.apache.poi.ss.formula.Formula;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes4.dex */
public final class ExternalNameRecord extends StandardRecord {
    private static final int OPT_AUTOMATIC_LINK = 2;
    private static final int OPT_BUILTIN_NAME = 1;
    private static final int OPT_ICONIFIED_PICTURE_LINK = 32768;
    private static final int OPT_OLE_LINK = 16;
    private static final int OPT_PICTURE_LINK = 4;
    private static final int OPT_STD_DOCUMENT_NAME = 8;
    public static final short sid = 35;
    private Object[] _ddeValues;
    private int _nColumns;
    private int _nRows;
    private short field_1_option_flag;
    private short field_2_ixals;
    private short field_3_not_used;
    private String field_4_name;
    private Formula field_5_name_definition;

    public ExternalNameRecord(RecordInputStream recordInputStream) {
        this.field_1_option_flag = recordInputStream.readShort();
        this.field_2_ixals = recordInputStream.readShort();
        this.field_3_not_used = recordInputStream.readShort();
        this.field_4_name = StringUtil.readUnicodeString(recordInputStream, recordInputStream.readUByte());
        if (isOLELink() || isStdDocumentNameIdentifier()) {
            return;
        }
        if (!isAutomaticLink()) {
            this.field_5_name_definition = Formula.read(recordInputStream.readUShort(), recordInputStream);
            return;
        }
        int uByte = recordInputStream.readUByte() + 1;
        int i = recordInputStream.readShort() + 1;
        this._ddeValues = ConstantValueParser.parse(recordInputStream, i * uByte);
        this._nColumns = uByte;
        this._nRows = i;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        int encodedSize = StringUtil.getEncodedSize(this.field_4_name);
        int i = encodedSize + 5;
        if (isOLELink() || isStdDocumentNameIdentifier()) {
            return i;
        }
        if (!isAutomaticLink()) {
            return i + this.field_5_name_definition.getEncodedSize();
        }
        return ConstantValueParser.getEncodedSize(this._ddeValues) + encodedSize + 8;
    }

    public short getIx() {
        return this.field_2_ixals;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 35;
    }

    public String getText() {
        return this.field_4_name;
    }

    public boolean isAutomaticLink() {
        return (this.field_1_option_flag & 2) != 0;
    }

    public boolean isBuiltInName() {
        return (this.field_1_option_flag & 1) != 0;
    }

    public boolean isIconifiedPictureLink() {
        return (this.field_1_option_flag & Short.MIN_VALUE) != 0;
    }

    public boolean isOLELink() {
        return (this.field_1_option_flag & 16) != 0;
    }

    public boolean isPicureLink() {
        return (this.field_1_option_flag & 4) != 0;
    }

    public boolean isStdDocumentNameIdentifier() {
        return (this.field_1_option_flag & 8) != 0;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_option_flag);
        littleEndianOutput.writeShort(this.field_2_ixals);
        littleEndianOutput.writeShort(this.field_3_not_used);
        littleEndianOutput.writeByte(this.field_4_name.length());
        StringUtil.writeUnicodeStringFlagAndData(littleEndianOutput, this.field_4_name);
        if (isOLELink() || isStdDocumentNameIdentifier()) {
            return;
        }
        if (!isAutomaticLink()) {
            this.field_5_name_definition.serialize(littleEndianOutput);
            return;
        }
        littleEndianOutput.writeByte(this._nColumns - 1);
        littleEndianOutput.writeShort(this._nRows - 1);
        ConstantValueParser.encode(littleEndianOutput, this._ddeValues);
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[EXTERNALNAME]\n");
        stringBuffer.append("    .ix      = ");
        stringBuffer.append((int) this.field_2_ixals);
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("    .name    = ");
        stringBuffer.append(this.field_4_name);
        stringBuffer.append(StringUtilities.LF);
        if (this.field_5_name_definition != null) {
            stringBuffer.append("    .formula = ");
            stringBuffer.append(this.field_5_name_definition);
            stringBuffer.append(StringUtilities.LF);
        }
        stringBuffer.append("[/EXTERNALNAME]\n");
        return stringBuffer.toString();
    }
}
