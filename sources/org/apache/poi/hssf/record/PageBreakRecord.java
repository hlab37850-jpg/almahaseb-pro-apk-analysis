package org.apache.poi.hssf.record;

import com.zebra.sdk.util.internal.StringUtilities;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes4.dex */
public abstract class PageBreakRecord extends StandardRecord {
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private Map<Integer, Break> _breakMap;
    private List<Break> _breaks;

    public PageBreakRecord() {
        this._breaks = new ArrayList();
        this._breakMap = new HashMap();
    }

    public void addBreak(int i, int i2, int i3) {
        Integer numValueOf = Integer.valueOf(i);
        Break r1 = this._breakMap.get(numValueOf);
        if (r1 == null) {
            Break r2 = new Break(i, i2, i3);
            this._breakMap.put(numValueOf, r2);
            this._breaks.add(r2);
        } else {
            r1.main = i;
            r1.subFrom = i2;
            r1.subTo = i3;
        }
    }

    public final Break getBreak(int i) {
        return this._breakMap.get(Integer.valueOf(i));
    }

    public final int[] getBreaks() {
        int numBreaks = getNumBreaks();
        if (numBreaks < 1) {
            return EMPTY_INT_ARRAY;
        }
        int[] iArr = new int[numBreaks];
        for (int i = 0; i < numBreaks; i++) {
            iArr[i] = this._breaks.get(i).main;
        }
        return iArr;
    }

    public final Iterator<Break> getBreaksIterator() {
        return this._breaks.iterator();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return (this._breaks.size() * 6) + 2;
    }

    public int getNumBreaks() {
        return this._breaks.size();
    }

    public boolean isEmpty() {
        return this._breaks.isEmpty();
    }

    public final void removeBreak(int i) {
        Integer numValueOf = Integer.valueOf(i);
        this._breaks.remove(this._breakMap.get(numValueOf));
        this._breakMap.remove(numValueOf);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public final void serialize(LittleEndianOutput littleEndianOutput) {
        int size = this._breaks.size();
        littleEndianOutput.writeShort(size);
        for (int i = 0; i < size; i++) {
            this._breaks.get(i).serialize(littleEndianOutput);
        }
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        String str;
        String str2;
        StringBuffer stringBuffer = new StringBuffer();
        String str3 = "row";
        if (getSid() == 27) {
            str = "HORIZONTALPAGEBREAK";
            str2 = "col";
        } else {
            str = "VERTICALPAGEBREAK";
            str3 = "column";
            str2 = "row";
        }
        stringBuffer.append("[" + str + "]");
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("     .sid        =");
        stringBuffer.append((int) getSid());
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append("     .numbreaks =");
        stringBuffer.append(getNumBreaks());
        stringBuffer.append(StringUtilities.LF);
        Iterator<Break> breaksIterator = getBreaksIterator();
        for (int i = 0; i < getNumBreaks(); i++) {
            Break next = breaksIterator.next();
            stringBuffer.append("     .");
            stringBuffer.append(str3);
            stringBuffer.append(" (zero-based) =");
            stringBuffer.append(next.main);
            stringBuffer.append(StringUtilities.LF);
            stringBuffer.append("     .");
            stringBuffer.append(str2);
            stringBuffer.append("From    =");
            stringBuffer.append(next.subFrom);
            stringBuffer.append(StringUtilities.LF);
            stringBuffer.append("     .");
            stringBuffer.append(str2);
            stringBuffer.append("To      =");
            stringBuffer.append(next.subTo);
            stringBuffer.append(StringUtilities.LF);
        }
        stringBuffer.append("[" + str + "]");
        stringBuffer.append(StringUtilities.LF);
        return stringBuffer.toString();
    }

    public static final class Break {
        public static final int ENCODED_SIZE = 6;
        public int main;
        public int subFrom;
        public int subTo;

        public Break(int i, int i2, int i3) {
            this.main = i;
            this.subFrom = i2;
            this.subTo = i3;
        }

        public void serialize(LittleEndianOutput littleEndianOutput) {
            littleEndianOutput.writeShort(this.main + 1);
            littleEndianOutput.writeShort(this.subFrom);
            littleEndianOutput.writeShort(this.subTo);
        }

        public Break(RecordInputStream recordInputStream) {
            this.main = recordInputStream.readUShort() - 1;
            this.subFrom = recordInputStream.readUShort();
            this.subTo = recordInputStream.readUShort();
        }
    }

    public PageBreakRecord(RecordInputStream recordInputStream) {
        short s = recordInputStream.readShort();
        this._breaks = new ArrayList(s + 2);
        this._breakMap = new HashMap();
        for (int i = 0; i < s; i++) {
            Break r2 = new Break(recordInputStream);
            this._breaks.add(r2);
            this._breakMap.put(Integer.valueOf(r2.main), r2);
        }
    }
}
