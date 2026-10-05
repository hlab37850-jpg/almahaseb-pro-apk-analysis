package org.apache.poi.hssf.record;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ddf.DefaultEscherRecordFactory;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.ddf.EscherRecordFactory;
import org.apache.poi.ddf.NullEscherSerializationListener;
import org.apache.poi.hssf.util.LazilyConcatenatedByteArray;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractEscherHolderRecord extends Record {
    private static boolean DESERIALISE;
    private LazilyConcatenatedByteArray rawDataContainer = new LazilyConcatenatedByteArray();
    private List<EscherRecord> escherRecords = new ArrayList();

    static {
        try {
            DESERIALISE = System.getProperty("poi.deserialize.escher") != null;
        } catch (SecurityException unused) {
            DESERIALISE = false;
        }
    }

    public AbstractEscherHolderRecord() {
    }

    private void convertToEscherRecords(int i, int i2, byte[] bArr) {
        EscherRecordFactory defaultEscherRecordFactory = new DefaultEscherRecordFactory();
        int i3 = i;
        while (i3 < i + i2) {
            EscherRecord escherRecordCreateRecord = defaultEscherRecordFactory.createRecord(bArr, i3);
            int iFillFields = escherRecordCreateRecord.fillFields(bArr, i3, defaultEscherRecordFactory);
            this.escherRecords.add(escherRecordCreateRecord);
            i3 += iFillFields;
        }
    }

    public void addEscherRecord(int i, EscherRecord escherRecord) {
        this.escherRecords.add(i, escherRecord);
    }

    public void clearEscherRecords() {
        this.escherRecords.clear();
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        return cloneViaReserialise();
    }

    public void convertRawBytesToEscherRecords() {
        byte[] rawData = getRawData();
        convertToEscherRecords(0, rawData.length, rawData);
    }

    public void decode() {
        byte[] rawData = getRawData();
        convertToEscherRecords(0, rawData.length, rawData);
    }

    public EscherRecord findFirstWithId(short s) {
        return findFirstWithId(s, getEscherRecords());
    }

    public EscherContainerRecord getEscherContainer() {
        for (EscherRecord escherRecord : this.escherRecords) {
            if (escherRecord instanceof EscherContainerRecord) {
                return (EscherContainerRecord) escherRecord;
            }
        }
        return null;
    }

    public EscherRecord getEscherRecord(int i) {
        return this.escherRecords.get(i);
    }

    public List<EscherRecord> getEscherRecords() {
        return this.escherRecords;
    }

    public byte[] getRawData() {
        return this.rawDataContainer.toArray();
    }

    public abstract String getRecordName();

    @Override // org.apache.poi.hssf.record.RecordBase
    public int getRecordSize() {
        byte[] rawData = getRawData();
        if (this.escherRecords.size() == 0 && rawData != null) {
            return rawData.length;
        }
        Iterator<EscherRecord> it = this.escherRecords.iterator();
        int recordSize = 0;
        while (it.hasNext()) {
            recordSize += it.next().getRecordSize();
        }
        return recordSize;
    }

    @Override // org.apache.poi.hssf.record.Record
    public abstract short getSid();

    public void join(AbstractEscherHolderRecord abstractEscherHolderRecord) {
        this.rawDataContainer.concatenate(abstractEscherHolderRecord.getRawData());
    }

    public void processContinueRecord(byte[] bArr) {
        this.rawDataContainer.concatenate(bArr);
    }

    @Override // org.apache.poi.hssf.record.RecordBase
    public int serialize(int i, byte[] bArr) {
        LittleEndian.putShort(bArr, i, getSid());
        int i2 = i + 2;
        LittleEndian.putShort(bArr, i2, (short) (getRecordSize() - 4));
        byte[] rawData = getRawData();
        if (this.escherRecords.size() == 0 && rawData != null) {
            LittleEndian.putShort(bArr, i, getSid());
            LittleEndian.putShort(bArr, i2, (short) (getRecordSize() - 4));
            System.arraycopy(rawData, 0, bArr, i + 4, rawData.length);
            return rawData.length + 4;
        }
        LittleEndian.putShort(bArr, i, getSid());
        LittleEndian.putShort(bArr, i2, (short) (getRecordSize() - 4));
        int iSerialize = i + 4;
        Iterator<EscherRecord> it = this.escherRecords.iterator();
        while (it.hasNext()) {
            iSerialize += it.next().serialize(iSerialize, bArr, new NullEscherSerializationListener());
        }
        return getRecordSize();
    }

    public void setRawData(byte[] bArr) {
        this.rawDataContainer.clear();
        this.rawDataContainer.concatenate(bArr);
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String property = System.getProperty("line.separator");
        stringBuffer.append('[' + getRecordName() + ']' + property);
        if (this.escherRecords.size() == 0) {
            stringBuffer.append("No Escher Records Decoded" + property);
        }
        Iterator<EscherRecord> it = this.escherRecords.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next().toString());
        }
        stringBuffer.append("[/" + getRecordName() + ']' + property);
        return stringBuffer.toString();
    }

    private EscherRecord findFirstWithId(short s, List<EscherRecord> list) {
        EscherRecord escherRecordFindFirstWithId;
        for (EscherRecord escherRecord : list) {
            if (escherRecord.getRecordId() == s) {
                return escherRecord;
            }
        }
        for (EscherRecord escherRecord2 : list) {
            if (escherRecord2.isContainerRecord() && (escherRecordFindFirstWithId = findFirstWithId(s, escherRecord2.getChildRecords())) != null) {
                return escherRecordFindFirstWithId;
            }
        }
        return null;
    }

    public boolean addEscherRecord(EscherRecord escherRecord) {
        return this.escherRecords.add(escherRecord);
    }

    public AbstractEscherHolderRecord(RecordInputStream recordInputStream) {
        if (!DESERIALISE) {
            this.rawDataContainer.concatenate(recordInputStream.readRemainder());
        } else {
            byte[] allContinuedRemainder = recordInputStream.readAllContinuedRemainder();
            convertToEscherRecords(0, allContinuedRemainder.length, allContinuedRemainder);
        }
    }
}
