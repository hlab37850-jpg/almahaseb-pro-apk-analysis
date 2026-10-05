package org.apache.poi.hssf.record;

import com.zebra.sdk.util.internal.StringUtilities;
import java.io.ByteArrayInputStream;
import org.apache.poi.hssf.record.formula.Area3DPtg;
import org.apache.poi.hssf.record.formula.AreaPtg;
import org.apache.poi.hssf.record.formula.Ptg;
import org.apache.poi.hssf.record.formula.Ref3DPtg;
import org.apache.poi.hssf.record.formula.RefPtg;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianInputStream;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes4.dex */
public final class EmbeddedObjectRefSubRecord extends SubRecord {
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    public static final short sid = 9;
    private int field_1_unknown_int;
    private Ptg field_2_refPtg;
    private byte[] field_2_unknownFormulaData;
    private boolean field_3_unicode_flag;
    private String field_4_ole_classname;
    private Byte field_4_unknownByte;
    private Integer field_5_stream_id;
    private byte[] field_6_unknown;

    public EmbeddedObjectRefSubRecord() {
        this.field_2_unknownFormulaData = new byte[]{2, 108, 106, 22, 1};
        this.field_6_unknown = EMPTY_BYTE_ARRAY;
        this.field_4_ole_classname = null;
    }

    private int getDataSize(int i) {
        int i2 = i + 2;
        if (this.field_5_stream_id != null) {
            i2 = i + 6;
        }
        return i2 + this.field_6_unknown.length;
    }

    private int getStreamIDOffset(int i) {
        int i2 = i + 6;
        String str = this.field_4_ole_classname;
        if (str != null) {
            i2 = i + 9;
            int length = str.length();
            if (length > 0) {
                int i3 = i + 10;
                if (this.field_3_unicode_flag) {
                    length *= 2;
                }
                i2 = i3 + length;
            }
        }
        return i2 % 2 != 0 ? i2 + 1 : i2;
    }

    private static byte[] readRawData(LittleEndianInput littleEndianInput, int i) {
        if (i >= 0) {
            if (i == 0) {
                return EMPTY_BYTE_ARRAY;
            }
            byte[] bArr = new byte[i];
            littleEndianInput.readFully(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("Negative size (" + i + ")");
    }

    private static Ptg readRefPtg(byte[] bArr) {
        LittleEndianInputStream littleEndianInputStream = new LittleEndianInputStream(new ByteArrayInputStream(bArr));
        byte b = littleEndianInputStream.readByte();
        if (b == 36) {
            return new RefPtg(littleEndianInputStream);
        }
        if (b == 37) {
            return new AreaPtg(littleEndianInputStream);
        }
        if (b == 58) {
            return new Ref3DPtg(littleEndianInputStream);
        }
        if (b != 59) {
            return null;
        }
        return new Area3DPtg(littleEndianInputStream);
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    public Object clone() {
        return this;
    }

    public String getOLEClassName() {
        return this.field_4_ole_classname;
    }

    public byte[] getObjectData() {
        return this.field_6_unknown;
    }

    public short getSid() {
        return (short) 9;
    }

    public Integer getStreamId() {
        return this.field_5_stream_id;
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        Ptg ptg = this.field_2_refPtg;
        int length = ptg == null ? this.field_2_unknownFormulaData.length : ptg.getSize();
        int streamIDOffset = getStreamIDOffset(length);
        int dataSize = getDataSize(streamIDOffset);
        littleEndianOutput.writeShort(9);
        littleEndianOutput.writeShort(dataSize);
        littleEndianOutput.writeShort(streamIDOffset);
        littleEndianOutput.writeShort(length);
        littleEndianOutput.writeInt(this.field_1_unknown_int);
        Ptg ptg2 = this.field_2_refPtg;
        if (ptg2 == null) {
            littleEndianOutput.write(this.field_2_unknownFormulaData);
        } else {
            ptg2.write(littleEndianOutput);
        }
        int i = length + 12;
        if (this.field_4_ole_classname != null) {
            littleEndianOutput.writeByte(3);
            int length2 = this.field_4_ole_classname.length();
            littleEndianOutput.writeShort(length2);
            int i2 = length + 15;
            if (length2 > 0) {
                littleEndianOutput.writeByte(this.field_3_unicode_flag ? 1 : 0);
                int i3 = length + 16;
                if (this.field_3_unicode_flag) {
                    StringUtil.putUnicodeLE(this.field_4_ole_classname, littleEndianOutput);
                    length2 *= 2;
                } else {
                    StringUtil.putCompressedUnicode(this.field_4_ole_classname, littleEndianOutput);
                }
                i = length2 + i3;
            } else {
                i = i2;
            }
        }
        int i4 = streamIDOffset - (i - 6);
        if (i4 != 0) {
            if (i4 != 1) {
                throw new IllegalStateException("Bad padding calculation (" + streamIDOffset + ", " + i + ")");
            }
            Byte b = this.field_4_unknownByte;
            littleEndianOutput.writeByte(b == null ? 0 : b.intValue());
        }
        Integer num = this.field_5_stream_id;
        if (num != null) {
            littleEndianOutput.writeInt(num.intValue());
        }
        littleEndianOutput.write(this.field_6_unknown);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[ftPictFmla]\n");
        stringBuffer.append("    .f2unknown     = ");
        stringBuffer.append(HexDump.intToHex(this.field_1_unknown_int));
        stringBuffer.append(StringUtilities.LF);
        if (this.field_2_refPtg == null) {
            stringBuffer.append("    .f3unknown     = ");
            stringBuffer.append(HexDump.toHex(this.field_2_unknownFormulaData));
            stringBuffer.append(StringUtilities.LF);
        } else {
            stringBuffer.append("    .formula       = ");
            stringBuffer.append(this.field_2_refPtg.toString());
            stringBuffer.append(StringUtilities.LF);
        }
        if (this.field_4_ole_classname != null) {
            stringBuffer.append("    .unicodeFlag   = ");
            stringBuffer.append(this.field_3_unicode_flag);
            stringBuffer.append(StringUtilities.LF);
            stringBuffer.append("    .oleClassname  = ");
            stringBuffer.append(this.field_4_ole_classname);
            stringBuffer.append(StringUtilities.LF);
        }
        if (this.field_4_unknownByte != null) {
            stringBuffer.append("    .f4unknown   = ");
            stringBuffer.append(HexDump.byteToHex(this.field_4_unknownByte.intValue()));
            stringBuffer.append(StringUtilities.LF);
        }
        if (this.field_5_stream_id != null) {
            stringBuffer.append("    .streamId      = ");
            stringBuffer.append(HexDump.intToHex(this.field_5_stream_id.intValue()));
            stringBuffer.append(StringUtilities.LF);
        }
        if (this.field_6_unknown.length > 0) {
            stringBuffer.append("    .f7unknown     = ");
            stringBuffer.append(HexDump.toHex(this.field_6_unknown));
            stringBuffer.append(StringUtilities.LF);
        }
        stringBuffer.append("[/ftPictFmla]");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    public int getDataSize() {
        Ptg ptg = this.field_2_refPtg;
        return getDataSize(getStreamIDOffset(ptg == null ? this.field_2_unknownFormulaData.length : ptg.getSize()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EmbeddedObjectRefSubRecord(LittleEndianInput littleEndianInput, int i) {
        int i2 = (i - 2) - littleEndianInput.readShort();
        int uShort = littleEndianInput.readUShort();
        this.field_1_unknown_int = littleEndianInput.readInt();
        byte[] rawData = readRawData(littleEndianInput, uShort);
        int i3 = (i - 8) - uShort;
        Ptg refPtg = readRefPtg(rawData);
        this.field_2_refPtg = refPtg;
        if (refPtg == null) {
            this.field_2_unknownFormulaData = rawData;
        } else {
            this.field_2_unknownFormulaData = null;
        }
        int i4 = 0;
        if (i3 >= i2 + 3) {
            if (littleEndianInput.readByte() == 3) {
                int uShort2 = littleEndianInput.readUShort();
                if (uShort2 > 0) {
                    boolean z = (littleEndianInput.readByte() & 1) != 0;
                    this.field_3_unicode_flag = z;
                    if (z) {
                        this.field_4_ole_classname = StringUtil.readUnicodeLE(littleEndianInput, uShort2);
                        uShort2 *= 2;
                    } else {
                        this.field_4_ole_classname = StringUtil.readCompressedUnicode(littleEndianInput, uShort2);
                    }
                    i4 = uShort2 + 4;
                } else {
                    this.field_4_ole_classname = "";
                    i4 = 3;
                }
            } else {
                throw new RecordFormatException("Expected byte 0x03 here");
            }
        } else {
            this.field_4_ole_classname = null;
        }
        int i5 = i3 - i4;
        if ((i4 + uShort) % 2 != 0) {
            byte b = littleEndianInput.readByte();
            i5--;
            if (this.field_2_refPtg != null && this.field_4_ole_classname == null) {
                this.field_4_unknownByte = Byte.valueOf(b);
            }
        }
        int i6 = i5 - i2;
        if (i6 > 0) {
            System.err.println("Discarding " + i6 + " unexpected padding bytes ");
            readRawData(littleEndianInput, i6);
            i5 -= i6;
        }
        if (i2 >= 4) {
            this.field_5_stream_id = Integer.valueOf(littleEndianInput.readInt());
            i5 -= 4;
        } else {
            this.field_5_stream_id = null;
        }
        this.field_6_unknown = readRawData(littleEndianInput, i5);
    }
}
