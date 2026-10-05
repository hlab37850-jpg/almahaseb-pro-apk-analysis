package org.apache.poi.hssf.record;

/* JADX INFO: loaded from: classes4.dex */
public abstract class RecordBase {
    public abstract int getRecordSize();

    public abstract int serialize(int i, byte[] bArr);
}
