package org.apache.poi.hssf.record;

import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public final class VerticalPageBreakRecord extends PageBreakRecord {
    public static final short sid = 26;

    public VerticalPageBreakRecord() {
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        VerticalPageBreakRecord verticalPageBreakRecord = new VerticalPageBreakRecord();
        Iterator<PageBreakRecord.Break> breaksIterator = getBreaksIterator();
        while (breaksIterator.hasNext()) {
            PageBreakRecord.Break next = breaksIterator.next();
            verticalPageBreakRecord.addBreak(next.main, next.subFrom, next.subTo);
        }
        return verticalPageBreakRecord;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 26;
    }

    public VerticalPageBreakRecord(RecordInputStream recordInputStream) {
        super(recordInputStream);
    }
}
