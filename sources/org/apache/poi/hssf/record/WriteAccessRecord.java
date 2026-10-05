package org.apache.poi.hssf.record;

import com.itextpdf.text.pdf.codec.TIFFConstants;
import com.zebra.sdk.util.internal.StringUtilities;
import java.util.Arrays;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes4.dex */
public final class WriteAccessRecord extends StandardRecord {
    private static final int DATA_SIZE = 112;
    private static final byte[] PADDING;
    private static final byte PAD_CHAR = 32;
    public static final short sid = 92;
    private String field_1_username;

    static {
        byte[] bArr = new byte[112];
        PADDING = bArr;
        Arrays.fill(bArr, (byte) 32);
    }

    public WriteAccessRecord() {
        setUsername("");
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 112;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 92;
    }

    public String getUsername() {
        return this.field_1_username;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        String username = getUsername();
        boolean zHasMultibyte = StringUtil.hasMultibyte(username);
        littleEndianOutput.writeShort(username.length());
        littleEndianOutput.writeByte(zHasMultibyte ? 1 : 0);
        if (zHasMultibyte) {
            StringUtil.putUnicodeLE(username, littleEndianOutput);
        } else {
            StringUtil.putCompressedUnicode(username, littleEndianOutput);
        }
        littleEndianOutput.write(PADDING, 0, 112 - ((username.length() * (zHasMultibyte ? 2 : 1)) + 3));
    }

    public void setUsername(String str) {
        if (112 - ((str.length() * (StringUtil.hasMultibyte(str) ? 2 : 1)) + 3) >= 0) {
            this.field_1_username = str;
            return;
        }
        throw new IllegalArgumentException("Name is too long: " + str);
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[WRITEACCESS]\n");
        stringBuffer.append("    .name = ");
        stringBuffer.append(this.field_1_username.toString());
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("[/WRITEACCESS]\n");
        return stringBuffer.toString();
    }

    public WriteAccessRecord(RecordInputStream recordInputStream) {
        String unicodeLE;
        if (recordInputStream.remaining() <= 112) {
            int uShort = recordInputStream.readUShort();
            int uByte = recordInputStream.readUByte();
            if (uShort <= 112 && (uByte & TIFFConstants.TIFFTAG_SUBFILETYPE) == 0) {
                if ((uByte & 1) == 0) {
                    unicodeLE = StringUtil.readCompressedUnicode(recordInputStream, uShort);
                } else {
                    unicodeLE = StringUtil.readUnicodeLE(recordInputStream, uShort);
                }
                this.field_1_username = unicodeLE.trim();
                for (int iRemaining = recordInputStream.remaining(); iRemaining > 0; iRemaining--) {
                    recordInputStream.readUByte();
                }
                return;
            }
            int iRemaining2 = recordInputStream.remaining();
            byte[] bArr = new byte[iRemaining2 + 3];
            LittleEndian.putUShort(bArr, 0, uShort);
            LittleEndian.putByte(bArr, 2, uByte);
            recordInputStream.readFully(bArr, 3, iRemaining2);
            setUsername(new String(bArr).trim());
            return;
        }
        throw new RecordFormatException("Expected data size (112) but got (" + recordInputStream.remaining() + ")");
    }
}
