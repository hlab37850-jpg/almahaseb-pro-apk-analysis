package org.apache.poi.hssf.record;

import com.zebra.sdk.util.internal.StringUtilities;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes4.dex */
public final class FilePassRecord extends StandardRecord {
    private static final int ENCRYPTION_OTHER = 1;
    private static final int ENCRYPTION_OTHER_CAPI_2 = 2;
    private static final int ENCRYPTION_OTHER_CAPI_3 = 3;
    private static final int ENCRYPTION_OTHER_RC4 = 1;
    private static final int ENCRYPTION_XOR = 0;
    public static final short sid = 47;
    private byte[] _docId;
    private int _encryptionInfo;
    private int _encryptionType;
    private int _minorVersionNo;
    private byte[] _saltData;
    private byte[] _saltHash;

    public FilePassRecord(RecordInputStream recordInputStream) {
        int uShort = recordInputStream.readUShort();
        this._encryptionType = uShort;
        if (uShort == 0) {
            throw new RecordFormatException("HSSF does not currently support XOR obfuscation");
        }
        if (uShort != 1) {
            throw new RecordFormatException("Unknown encryption type " + this._encryptionType);
        }
        int uShort2 = recordInputStream.readUShort();
        this._encryptionInfo = uShort2;
        if (uShort2 != 1) {
            if (uShort2 == 2 || uShort2 == 3) {
                throw new RecordFormatException("HSSF does not currently support CryptoAPI encryption");
            }
            throw new RecordFormatException("Unknown encryption info " + this._encryptionInfo);
        }
        int uShort3 = recordInputStream.readUShort();
        this._minorVersionNo = uShort3;
        if (uShort3 == 1) {
            this._docId = read(recordInputStream, 16);
            this._saltData = read(recordInputStream, 16);
            this._saltHash = read(recordInputStream, 16);
        } else {
            throw new RecordFormatException("Unexpected VersionInfo number for RC4Header " + this._minorVersionNo);
        }
    }

    private static byte[] read(RecordInputStream recordInputStream, int i) {
        byte[] bArr = new byte[i];
        recordInputStream.readFully(bArr);
        return bArr;
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        return this;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 54;
    }

    public byte[] getDocId() {
        return (byte[]) this._docId.clone();
    }

    public byte[] getSaltData() {
        return (byte[]) this._saltData.clone();
    }

    public byte[] getSaltHash() {
        return (byte[]) this._saltHash.clone();
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 47;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this._encryptionType);
        littleEndianOutput.writeShort(this._encryptionInfo);
        littleEndianOutput.writeShort(this._minorVersionNo);
        littleEndianOutput.write(this._docId);
        littleEndianOutput.write(this._saltData);
        littleEndianOutput.write(this._saltHash);
    }

    public void setDocId(byte[] bArr) {
        this._docId = (byte[]) bArr.clone();
    }

    public void setSaltData(byte[] bArr) {
        this._saltData = (byte[]) bArr.clone();
    }

    public void setSaltHash(byte[] bArr) {
        this._saltHash = (byte[]) bArr.clone();
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[FILEPASS]\n");
        stringBuffer.append("    .type = ");
        stringBuffer.append(HexDump.shortToHex(this._encryptionType));
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("    .info = ");
        stringBuffer.append(HexDump.shortToHex(this._encryptionInfo));
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("    .ver  = ");
        stringBuffer.append(HexDump.shortToHex(this._minorVersionNo));
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("    .docId= ");
        stringBuffer.append(HexDump.toHex(this._docId));
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("    .salt = ");
        stringBuffer.append(HexDump.toHex(this._saltData));
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("    .hash = ");
        stringBuffer.append(HexDump.toHex(this._saltHash));
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("[/FILEPASS]\n");
        return stringBuffer.toString();
    }
}
