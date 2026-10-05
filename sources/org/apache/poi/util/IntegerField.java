package org.apache.poi.util;

import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
public class IntegerField implements FixedField {
    private final int _offset;
    private int _value;

    public IntegerField(int i) {
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException("negative offset");
        }
        this._offset = i;
    }

    public int get() {
        return this._value;
    }

    @Override // org.apache.poi.util.FixedField
    public void readFromBytes(byte[] bArr) {
        this._value = LittleEndian.getInt(bArr, this._offset);
    }

    @Override // org.apache.poi.util.FixedField
    public void readFromStream(InputStream inputStream) {
        this._value = LittleEndian.readInt(inputStream);
    }

    public void set(int i) {
        this._value = i;
    }

    @Override // org.apache.poi.util.FixedField
    public String toString() {
        return String.valueOf(this._value);
    }

    @Override // org.apache.poi.util.FixedField
    public void writeToBytes(byte[] bArr) {
        LittleEndian.putInt(bArr, this._offset, this._value);
    }

    public void set(int i, byte[] bArr) {
        this._value = i;
        writeToBytes(bArr);
    }

    public IntegerField(int i, int i2) {
        this(i);
        set(i2);
    }

    public IntegerField(int i, byte[] bArr) {
        this(i);
        readFromBytes(bArr);
    }

    public IntegerField(int i, int i2, byte[] bArr) {
        this(i);
        set(i2, bArr);
    }
}
