package org.apache.poi.hssf.record;

import com.zebra.sdk.util.internal.StringUtilities;

/* JADX INFO: loaded from: classes4.dex */
public final class HeaderRecord extends HeaderFooterBase {
    public static final short sid = 20;

    public HeaderRecord(String str) {
        super(str);
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        return new HeaderRecord(getText());
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 20;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[HEADER]\n");
        stringBuffer.append("    .header = ");
        stringBuffer.append(getText());
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("[/HEADER]\n");
        return stringBuffer.toString();
    }

    public HeaderRecord(RecordInputStream recordInputStream) {
        super(recordInputStream);
    }
}
