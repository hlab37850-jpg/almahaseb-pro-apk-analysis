package org.apache.poi.hssf.eventusermodel.dummyrecord;

/* JADX INFO: loaded from: classes4.dex */
public final class MissingCellDummyRecord extends DummyRecordBase {
    private int column;
    private int row;

    public MissingCellDummyRecord(int i, int i2) {
        this.row = i;
        this.column = i2;
    }

    public int getColumn() {
        return this.column;
    }

    public int getRow() {
        return this.row;
    }

    @Override // org.apache.poi.hssf.eventusermodel.dummyrecord.DummyRecordBase, org.apache.poi.hssf.record.RecordBase
    public /* bridge */ /* synthetic */ int serialize(int i, byte[] bArr) {
        return super.serialize(i, bArr);
    }
}
