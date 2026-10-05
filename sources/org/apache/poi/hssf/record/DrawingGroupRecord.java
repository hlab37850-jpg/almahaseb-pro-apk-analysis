package org.apache.poi.hssf.record;

import java.util.Iterator;
import java.util.List;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.ddf.NullEscherSerializationListener;
import org.apache.poi.util.ArrayUtil;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes4.dex */
public final class DrawingGroupRecord extends AbstractEscherHolderRecord {
    private static final int MAX_DATA_SIZE = 8224;
    static final int MAX_RECORD_SIZE = 8228;
    public static final short sid = 235;

    public DrawingGroupRecord() {
    }

    private int getRawDataSize() {
        List<EscherRecord> escherRecords = getEscherRecords();
        byte[] rawData = getRawData();
        if (escherRecords.size() == 0 && rawData != null) {
            return rawData.length;
        }
        Iterator<EscherRecord> it = escherRecords.iterator();
        int recordSize = 0;
        while (it.hasNext()) {
            recordSize += it.next().getRecordSize();
        }
        return recordSize;
    }

    public static int grossSizeFromDataSize(int i) {
        return i + ((((i - 1) / MAX_DATA_SIZE) + 1) * 4);
    }

    private void writeContinueHeader(byte[] bArr, int i, int i2) {
        LittleEndian.putShort(bArr, i, (short) 60);
        LittleEndian.putShort(bArr, i + 2, (short) i2);
    }

    private int writeData(int i, byte[] bArr, byte[] bArr2) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < bArr2.length) {
            int iMin = Math.min(bArr2.length - i2, MAX_DATA_SIZE);
            if (i2 / MAX_DATA_SIZE >= 2) {
                writeContinueHeader(bArr, i, iMin);
            } else {
                writeHeader(bArr, i, iMin);
            }
            int i4 = i + 4;
            ArrayUtil.arraycopy(bArr2, i2, bArr, i4, iMin);
            i = i4 + iMin;
            i2 += iMin;
            i3 = i3 + 4 + iMin;
        }
        return i3;
    }

    private void writeHeader(byte[] bArr, int i, int i2) {
        LittleEndian.putShort(bArr, i, getSid());
        LittleEndian.putShort(bArr, i + 2, (short) i2);
    }

    @Override // org.apache.poi.hssf.record.AbstractEscherHolderRecord
    public String getRecordName() {
        return "MSODRAWINGGROUP";
    }

    @Override // org.apache.poi.hssf.record.AbstractEscherHolderRecord, org.apache.poi.hssf.record.RecordBase
    public int getRecordSize() {
        return grossSizeFromDataSize(getRawDataSize());
    }

    @Override // org.apache.poi.hssf.record.AbstractEscherHolderRecord, org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public void processChildRecords() {
        convertRawBytesToEscherRecords();
    }

    @Override // org.apache.poi.hssf.record.AbstractEscherHolderRecord, org.apache.poi.hssf.record.RecordBase
    public int serialize(int i, byte[] bArr) {
        byte[] rawData = getRawData();
        if (getEscherRecords().size() == 0 && rawData != null) {
            return writeData(i, bArr, rawData);
        }
        byte[] bArr2 = new byte[getRawDataSize()];
        Iterator<EscherRecord> it = getEscherRecords().iterator();
        int iSerialize = 0;
        while (it.hasNext()) {
            iSerialize += it.next().serialize(iSerialize, bArr2, new NullEscherSerializationListener());
        }
        return writeData(i, bArr, bArr2);
    }

    public DrawingGroupRecord(RecordInputStream recordInputStream) {
        super(recordInputStream);
    }
}
