package org.apache.poi.util;

import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
public class ShortField implements FixedField {
    private final int _offset;
    private short _value;

    public ShortField(int i) {
        if (i >= 0) {
            this._offset = i;
            return;
        }
        throw new ArrayIndexOutOfBoundsException("Illegal offset: " + i);
    }

    public short get() {
        return this._value;
    }

    @Override // org.apache.poi.util.FixedField
    public void readFromBytes(byte[] bArr) {
        this._value = LittleEndian.getShort(bArr, this._offset);
    }

    @Override // org.apache.poi.util.FixedField
    public void readFromStream(InputStream inputStream) {
        this._value = LittleEndian.readShort(inputStream);
    }

    public void set(short s) {
        this._value = s;
    }

    @Override // org.apache.poi.util.FixedField
    public String toString() {
        return String.valueOf((int) this._value);
    }

    @Override // org.apache.poi.util.FixedField
    public void writeToBytes(byte[] bArr) {
        LittleEndian.putShort(bArr, this._offset, this._value);
    }

    public void set(short s, byte[] bArr) {
        this._value = s;
        writeToBytes(bArr);
    }

    public ShortField(int i, short s) {
        this(i);
        set(s);
    }

    public ShortField(int i, byte[] bArr) {
        this(i);
        readFromBytes(bArr);
    }

    public ShortField(int i, short s, byte[] bArr) {
        this(i);
        set(s, bArr);
    }
}
