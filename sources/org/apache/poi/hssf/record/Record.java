package org.apache.poi.hssf.record;

import java.io.ByteArrayInputStream;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Record extends RecordBase {
    public Object clone() {
        throw new RuntimeException("The class " + getClass().getName() + " needs to define a clone method");
    }

    public Record cloneViaReserialise() {
        RecordInputStream recordInputStream = new RecordInputStream(new ByteArrayInputStream(serialize()));
        recordInputStream.nextRecord();
        Record[] recordArrCreateRecord = RecordFactory.createRecord(recordInputStream);
        if (recordArrCreateRecord.length == 1) {
            return recordArrCreateRecord[0];
        }
        throw new IllegalStateException("Re-serialised a record to clone it, but got " + recordArrCreateRecord.length + " records back!");
    }

    public abstract short getSid();

    public final byte[] serialize() {
        byte[] bArr = new byte[getRecordSize()];
        serialize(0, bArr);
        return bArr;
    }

    public String toString() {
        return super.toString();
    }
}
