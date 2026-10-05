package org.apache.poi.hssf.record.cf;

import com.zebra.sdk.util.internal.StringUtilities;
import org.apache.poi.ss.usermodel.ShapeTypes;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes4.dex */
public final class BorderFormatting {
    public static final short BORDER_DASHED = 3;
    public static final short BORDER_DASH_DOT = 9;
    public static final short BORDER_DASH_DOT_DOT = 11;
    public static final short BORDER_DOTTED = 7;
    public static final short BORDER_DOUBLE = 6;
    public static final short BORDER_HAIR = 4;
    public static final short BORDER_MEDIUM = 2;
    public static final short BORDER_MEDIUM_DASHED = 8;
    public static final short BORDER_MEDIUM_DASH_DOT = 10;
    public static final short BORDER_MEDIUM_DASH_DOT_DOT = 12;
    public static final short BORDER_NONE = 0;
    public static final short BORDER_SLANTED_DASH_DOT = 13;
    public static final short BORDER_THICK = 5;
    public static final short BORDER_THIN = 1;
    private int field_13_border_styles1;
    private int field_14_border_styles2;
    private static final BitField bordLeftLineStyle = BitFieldFactory.getInstance(15);
    private static final BitField bordRightLineStyle = BitFieldFactory.getInstance(240);
    private static final BitField bordTopLineStyle = BitFieldFactory.getInstance(3840);
    private static final BitField bordBottomLineStyle = BitFieldFactory.getInstance(61440);
    private static final BitField bordLeftLineColor = BitFieldFactory.getInstance(8323072);
    private static final BitField bordRightLineColor = BitFieldFactory.getInstance(1065353216);
    private static final BitField bordTlBrLineOnOff = BitFieldFactory.getInstance(1073741824);
    private static final BitField bordBlTrtLineOnOff = BitFieldFactory.getInstance(Integer.MIN_VALUE);
    private static final BitField bordTopLineColor = BitFieldFactory.getInstance(ShapeTypes.VERTICAL_SCROLL);
    private static final BitField bordBottomLineColor = BitFieldFactory.getInstance(16256);
    private static final BitField bordDiagLineColor = BitFieldFactory.getInstance(2080768);
    private static final BitField bordDiagLineStyle = BitFieldFactory.getInstance(31457280);

    public BorderFormatting() {
        this.field_13_border_styles1 = 0;
        this.field_14_border_styles2 = 0;
    }

    public Object clone() {
        BorderFormatting borderFormatting = new BorderFormatting();
        borderFormatting.field_13_border_styles1 = this.field_13_border_styles1;
        borderFormatting.field_14_border_styles2 = this.field_14_border_styles2;
        return borderFormatting;
    }

    public int getBorderBottom() {
        return bordBottomLineStyle.getValue(this.field_13_border_styles1);
    }

    public int getBorderDiagonal() {
        return bordDiagLineStyle.getValue(this.field_14_border_styles2);
    }

    public int getBorderLeft() {
        return bordLeftLineStyle.getValue(this.field_13_border_styles1);
    }

    public int getBorderRight() {
        return bordRightLineStyle.getValue(this.field_13_border_styles1);
    }

    public int getBorderTop() {
        return bordTopLineStyle.getValue(this.field_13_border_styles1);
    }

    public int getBottomBorderColor() {
        return bordBottomLineColor.getValue(this.field_14_border_styles2);
    }

    public int getDiagonalBorderColor() {
        return bordDiagLineColor.getValue(this.field_14_border_styles2);
    }

    public int getLeftBorderColor() {
        return bordLeftLineColor.getValue(this.field_13_border_styles1);
    }

    public int getRightBorderColor() {
        return bordRightLineColor.getValue(this.field_13_border_styles1);
    }

    public int getTopBorderColor() {
        return bordTopLineColor.getValue(this.field_14_border_styles2);
    }

    public boolean isBackwardDiagonalOn() {
        return bordTlBrLineOnOff.isSet(this.field_13_border_styles1);
    }

    public boolean isForwardDiagonalOn() {
        return bordBlTrtLineOnOff.isSet(this.field_13_border_styles1);
    }

    public int serialize(int i, byte[] bArr) {
        LittleEndian.putInt(bArr, i, this.field_13_border_styles1);
        LittleEndian.putInt(bArr, i + 4, this.field_14_border_styles2);
        return 8;
    }

    public void setBackwardDiagonalOn(boolean z) {
        this.field_13_border_styles1 = bordTlBrLineOnOff.setBoolean(this.field_13_border_styles1, z);
    }

    public void setBorderBottom(int i) {
        this.field_13_border_styles1 = bordBottomLineStyle.setValue(this.field_13_border_styles1, i);
    }

    public void setBorderDiagonal(int i) {
        this.field_14_border_styles2 = bordDiagLineStyle.setValue(this.field_14_border_styles2, i);
    }

    public void setBorderLeft(int i) {
        this.field_13_border_styles1 = bordLeftLineStyle.setValue(this.field_13_border_styles1, i);
    }

    public void setBorderRight(int i) {
        this.field_13_border_styles1 = bordRightLineStyle.setValue(this.field_13_border_styles1, i);
    }

    public void setBorderTop(int i) {
        this.field_13_border_styles1 = bordTopLineStyle.setValue(this.field_13_border_styles1, i);
    }

    public void setBottomBorderColor(int i) {
        this.field_14_border_styles2 = bordBottomLineColor.setValue(this.field_14_border_styles2, i);
    }

    public void setDiagonalBorderColor(int i) {
        this.field_14_border_styles2 = bordDiagLineColor.setValue(this.field_14_border_styles2, i);
    }

    public void setForwardDiagonalOn(boolean z) {
        this.field_13_border_styles1 = bordBlTrtLineOnOff.setBoolean(this.field_13_border_styles1, z);
    }

    public void setLeftBorderColor(int i) {
        this.field_13_border_styles1 = bordLeftLineColor.setValue(this.field_13_border_styles1, i);
    }

    public void setRightBorderColor(int i) {
        this.field_13_border_styles1 = bordRightLineColor.setValue(this.field_13_border_styles1, i);
    }

    public void setTopBorderColor(int i) {
        this.field_14_border_styles2 = bordTopLineColor.setValue(this.field_14_border_styles2, i);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("    [Border Formatting]\n");
        stringBuffer.append("          .lftln     = ");
        stringBuffer.append(Integer.toHexString(getBorderLeft()));
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("          .rgtln     = ");
        stringBuffer.append(Integer.toHexString(getBorderRight()));
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("          .topln     = ");
        stringBuffer.append(Integer.toHexString(getBorderTop()));
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("          .btmln     = ");
        stringBuffer.append(Integer.toHexString(getBorderBottom()));
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("          .leftborder= ");
        stringBuffer.append(Integer.toHexString(getLeftBorderColor()));
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("          .rghtborder= ");
        stringBuffer.append(Integer.toHexString(getRightBorderColor()));
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("          .topborder= ");
        stringBuffer.append(Integer.toHexString(getTopBorderColor()));
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("          .bottomborder= ");
        stringBuffer.append(Integer.toHexString(getBottomBorderColor()));
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("          .fwdiag= ");
        stringBuffer.append(isForwardDiagonalOn());
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("          .bwdiag= ");
        stringBuffer.append(isBackwardDiagonalOn());
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("    [/Border Formatting]\n");
        return stringBuffer.toString();
    }

    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeInt(this.field_13_border_styles1);
        littleEndianOutput.writeInt(this.field_14_border_styles2);
    }

    public BorderFormatting(LittleEndianInput littleEndianInput) {
        this.field_13_border_styles1 = littleEndianInput.readInt();
        this.field_14_border_styles2 = littleEndianInput.readInt();
    }
}
