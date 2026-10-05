package org.apache.poi.hssf.record;

import com.zebra.sdk.util.internal.StringUtilities;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes4.dex */
public final class WSBoolRecord extends StandardRecord {
    public static final short sid = 129;
    private byte field_1_wsbool;
    private byte field_2_wsbool;
    private static final BitField autobreaks = BitFieldFactory.getInstance(1);
    private static final BitField dialog = BitFieldFactory.getInstance(16);
    private static final BitField applystyles = BitFieldFactory.getInstance(32);
    private static final BitField rowsumsbelow = BitFieldFactory.getInstance(64);
    private static final BitField rowsumsright = BitFieldFactory.getInstance(128);
    private static final BitField fittopage = BitFieldFactory.getInstance(1);
    private static final BitField displayguts = BitFieldFactory.getInstance(6);
    private static final BitField alternateexpression = BitFieldFactory.getInstance(64);
    private static final BitField alternateformula = BitFieldFactory.getInstance(128);

    public WSBoolRecord() {
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        WSBoolRecord wSBoolRecord = new WSBoolRecord();
        wSBoolRecord.field_1_wsbool = this.field_1_wsbool;
        wSBoolRecord.field_2_wsbool = this.field_2_wsbool;
        return wSBoolRecord;
    }

    public boolean getAlternateExpression() {
        return alternateexpression.isSet(this.field_2_wsbool);
    }

    public boolean getAlternateFormula() {
        return alternateformula.isSet(this.field_2_wsbool);
    }

    public boolean getAutobreaks() {
        return autobreaks.isSet(this.field_1_wsbool);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 2;
    }

    public boolean getDialog() {
        return dialog.isSet(this.field_1_wsbool);
    }

    public boolean getDisplayGuts() {
        return displayguts.isSet(this.field_2_wsbool);
    }

    public boolean getFitToPage() {
        return fittopage.isSet(this.field_2_wsbool);
    }

    public boolean getRowSumsBelow() {
        return rowsumsbelow.isSet(this.field_1_wsbool);
    }

    public boolean getRowSumsRight() {
        return rowsumsright.isSet(this.field_1_wsbool);
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 129;
    }

    public byte getWSBool1() {
        return this.field_1_wsbool;
    }

    public byte getWSBool2() {
        return this.field_2_wsbool;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(getWSBool2());
        littleEndianOutput.writeByte(getWSBool1());
    }

    public void setAlternateExpression(boolean z) {
        this.field_2_wsbool = alternateexpression.setByteBoolean(this.field_2_wsbool, z);
    }

    public void setAlternateFormula(boolean z) {
        this.field_2_wsbool = alternateformula.setByteBoolean(this.field_2_wsbool, z);
    }

    public void setAutobreaks(boolean z) {
        this.field_1_wsbool = autobreaks.setByteBoolean(this.field_1_wsbool, z);
    }

    public void setDialog(boolean z) {
        this.field_1_wsbool = dialog.setByteBoolean(this.field_1_wsbool, z);
    }

    public void setDisplayGuts(boolean z) {
        this.field_2_wsbool = displayguts.setByteBoolean(this.field_2_wsbool, z);
    }

    public void setFitToPage(boolean z) {
        this.field_2_wsbool = fittopage.setByteBoolean(this.field_2_wsbool, z);
    }

    public void setRowSumsBelow(boolean z) {
        this.field_1_wsbool = rowsumsbelow.setByteBoolean(this.field_1_wsbool, z);
    }

    public void setRowSumsRight(boolean z) {
        this.field_1_wsbool = rowsumsright.setByteBoolean(this.field_1_wsbool, z);
    }

    public void setWSBool1(byte b) {
        this.field_1_wsbool = b;
    }

    public void setWSBool2(byte b) {
        this.field_2_wsbool = b;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[WSBOOL]\n");
        stringBuffer.append("    .wsbool1        = ");
        stringBuffer.append(Integer.toHexString(getWSBool1()));
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("        .autobreaks = ");
        stringBuffer.append(getAutobreaks());
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("        .dialog     = ");
        stringBuffer.append(getDialog());
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("        .rowsumsbelw= ");
        stringBuffer.append(getRowSumsBelow());
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("        .rowsumsrigt= ");
        stringBuffer.append(getRowSumsRight());
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("    .wsbool2        = ");
        stringBuffer.append(Integer.toHexString(getWSBool2()));
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("        .fittopage  = ");
        stringBuffer.append(getFitToPage());
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("        .displayguts= ");
        stringBuffer.append(getDisplayGuts());
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("        .alternateex= ");
        stringBuffer.append(getAlternateExpression());
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("        .alternatefo= ");
        stringBuffer.append(getAlternateFormula());
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("[/WSBOOL]\n");
        return stringBuffer.toString();
    }

    public WSBoolRecord(RecordInputStream recordInputStream) {
        byte[] remainder = recordInputStream.readRemainder();
        this.field_1_wsbool = remainder[1];
        this.field_2_wsbool = remainder[0];
    }
}
