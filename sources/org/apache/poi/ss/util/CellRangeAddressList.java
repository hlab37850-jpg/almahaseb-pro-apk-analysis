package org.apache.poi.ss.util;

import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.util.LittleEndianByteArrayOutputStream;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes4.dex */
public class CellRangeAddressList {
    protected final List _list;

    public CellRangeAddressList() {
        this._list = new ArrayList();
    }

    public static int getEncodedSize(int i) {
        return CellRangeAddress.getEncodedSize(i) + 2;
    }

    public void addCellRangeAddress(int i, int i2, int i3, int i4) {
        addCellRangeAddress(new CellRangeAddress(i, i3, i2, i4));
    }

    public CellRangeAddressList copy() {
        CellRangeAddressList cellRangeAddressList = new CellRangeAddressList();
        int size = this._list.size();
        for (int i = 0; i < size; i++) {
            cellRangeAddressList.addCellRangeAddress(((CellRangeAddress) this._list.get(i)).copy());
        }
        return cellRangeAddressList;
    }

    public int countRanges() {
        return this._list.size();
    }

    public CellRangeAddress getCellRangeAddress(int i) {
        return (CellRangeAddress) this._list.get(i);
    }

    public CellRangeAddress[] getCellRangeAddresses() {
        CellRangeAddress[] cellRangeAddressArr = new CellRangeAddress[this._list.size()];
        this._list.toArray(cellRangeAddressArr);
        return cellRangeAddressArr;
    }

    public int getSize() {
        return getEncodedSize(this._list.size());
    }

    public CellRangeAddress remove(int i) {
        if (this._list.isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        if (i >= 0 && i < this._list.size()) {
            return (CellRangeAddress) this._list.remove(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Range index (");
        sb.append(i);
        sb.append(") is outside allowable range (0..");
        sb.append(this._list.size() - 1);
        sb.append(")");
        throw new RuntimeException(sb.toString());
    }

    public int serialize(int i, byte[] bArr) {
        int size = getSize();
        serialize(new LittleEndianByteArrayOutputStream(bArr, i, size));
        return size;
    }

    public CellRangeAddressList(int i, int i2, int i3, int i4) {
        this();
        addCellRangeAddress(i, i3, i2, i4);
    }

    public void addCellRangeAddress(CellRangeAddress cellRangeAddress) {
        this._list.add(cellRangeAddress);
    }

    public void serialize(LittleEndianOutput littleEndianOutput) {
        int size = this._list.size();
        littleEndianOutput.writeShort(size);
        for (int i = 0; i < size; i++) {
            ((CellRangeAddress) this._list.get(i)).serialize(littleEndianOutput);
        }
    }

    public CellRangeAddressList(RecordInputStream recordInputStream) {
        this();
        int uShort = recordInputStream.readUShort();
        for (int i = 0; i < uShort; i++) {
            this._list.add(new CellRangeAddress(recordInputStream));
        }
    }
}
