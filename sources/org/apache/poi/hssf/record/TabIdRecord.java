package org.apache.poi.hssf.record;

import com.zebra.sdk.util.internal.StringUtilities;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes4.dex */
public final class TabIdRecord extends StandardRecord {
    private static final short[] EMPTY_SHORT_ARRAY = new short[0];
    public static final short sid = 317;
    public short[] _tabids;

    public TabIdRecord() {
        this._tabids = EMPTY_SHORT_ARRAY;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return this._tabids.length * 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 317;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        for (short s : this._tabids) {
            littleEndianOutput.writeShort(s);
        }
    }

    public void setTabIdArray(short[] sArr) {
        this._tabids = sArr;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[TABID]\n");
        stringBuffer.append("    .elements        = ");
        stringBuffer.append(this._tabids.length);
        stringBuffer.append(StringUtilities.LF);
        for (int i = 0; i < this._tabids.length; i++) {
            stringBuffer.append("    .element_");
            stringBuffer.append(i);
            stringBuffer.append(" = ");
            stringBuffer.append((int) this._tabids[i]);
            stringBuffer.append(StringUtilities.LF);
        }
        stringBuffer.append("[/TABID]\n");
        return stringBuffer.toString();
    }

    public TabIdRecord(RecordInputStream recordInputStream) {
        this._tabids = new short[recordInputStream.remaining() / 2];
        int i = 0;
        while (true) {
            short[] sArr = this._tabids;
            if (i >= sArr.length) {
                return;
            }
            sArr[i] = recordInputStream.readShort();
            i++;
        }
    }
}
