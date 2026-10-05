package org.apache.poi.util;

import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
public class LongField implements FixedField {
    private final int _offset;
    private long _value;

    public LongField(int i) {
        if (i >= 0) {
            this._offset = i;
            return;
        }
        throw new ArrayIndexOutOfBoundsException("Illegal offset: " + i);
    }

    public long get() {
        return this._value;
    }

    @Override // org.apache.poi.util.FixedField
    public void readFromBytes(byte[] bArr) {
        this._value = LittleEndian.getLong(bArr, this._offset);
    }

    @Override // org.apache.poi.util.FixedField
    public void readFromStream(InputStream inputStream) {
        this._value = LittleEndian.readLong(inputStream);
    }

    public void set(long j) {
        this._value = j;
    }

    @Override // org.apache.poi.util.FixedField
    public String toString() {
        return String.valueOf(this._value);
    }

    @Override // org.apache.poi.util.FixedField
    public void writeToBytes(byte[] bArr) {
        LittleEndian.putLong(bArr, this._offset, this._value);
    }

    public void set(long j, byte[] bArr) {
        this._value = j;
        writeToBytes(bArr);
    }

    public LongField(int i, long j) {
        this(i);
        set(j);
    }

    public LongField(int i, byte[] bArr) {
        this(i);
        readFromBytes(bArr);
    }

    public LongField(int i, long j, byte[] bArr) {
        this(i);
        set(j, bArr);
    }
}
