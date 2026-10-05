package org.apache.poi.hssf.record.crypto;

import com.google.common.primitives.UnsignedBytes;

/* JADX INFO: loaded from: classes4.dex */
final class Biff8RC4 {
    private static final int RC4_REKEYING_INTERVAL = 1024;
    private int _currentKeyIndex;
    private final Biff8EncryptionKey _key;
    private int _nextRC4BlockStart;
    private RC4 _rc4;
    private boolean _shouldSkipEncryptionOnCurrentRecord;
    private int _streamPos;

    public Biff8RC4(int i, Biff8EncryptionKey biff8EncryptionKey) {
        if (i >= 1024) {
            throw new RuntimeException("initialOffset (" + i + ")>1024 not supported yet");
        }
        this._key = biff8EncryptionKey;
        this._streamPos = 0;
        rekeyForNextBlock();
        this._streamPos = i;
        while (i > 0) {
            this._rc4.output();
            i--;
        }
        this._shouldSkipEncryptionOnCurrentRecord = false;
    }

    private int getNextRC4Byte() {
        if (this._streamPos >= this._nextRC4BlockStart) {
            rekeyForNextBlock();
        }
        byte bOutput = this._rc4.output();
        this._streamPos++;
        if (this._shouldSkipEncryptionOnCurrentRecord) {
            return 0;
        }
        return bOutput & UnsignedBytes.MAX_VALUE;
    }

    private static boolean isNeverEncryptedRecord(int i) {
        return i == 47 || i == 225 || i == 2057;
    }

    private void rekeyForNextBlock() {
        int i = this._streamPos / 1024;
        this._currentKeyIndex = i;
        this._rc4 = this._key.createRC4(i);
        this._nextRC4BlockStart = (this._currentKeyIndex + 1) * 1024;
    }

    public void skipTwoBytes() {
        getNextRC4Byte();
        getNextRC4Byte();
    }

    public void startRecord(int i) {
        this._shouldSkipEncryptionOnCurrentRecord = isNeverEncryptedRecord(i);
    }

    public void xor(byte[] bArr, int i, int i2) {
        int i3 = this._nextRC4BlockStart - this._streamPos;
        if (i2 <= i3) {
            this._rc4.encrypt(bArr, i, i2);
            this._streamPos += i2;
            return;
        }
        if (i2 > i3) {
            if (i3 > 0) {
                this._rc4.encrypt(bArr, i, i3);
                this._streamPos += i3;
                i += i3;
                i2 -= i3;
            }
            rekeyForNextBlock();
        }
        while (i2 > 1024) {
            this._rc4.encrypt(bArr, i, 1024);
            this._streamPos += 1024;
            i += 1024;
            i2 -= 1024;
            rekeyForNextBlock();
        }
        this._rc4.encrypt(bArr, i, i2);
        this._streamPos += i2;
    }

    public int xorByte(int i) {
        return (byte) (i ^ getNextRC4Byte());
    }

    public int xorInt(int i) {
        int nextRC4Byte = getNextRC4Byte();
        int nextRC4Byte2 = getNextRC4Byte();
        return i ^ ((((getNextRC4Byte() << 24) + (getNextRC4Byte() << 16)) + (nextRC4Byte2 << 8)) + nextRC4Byte);
    }

    public long xorLong(long j) {
        int nextRC4Byte = getNextRC4Byte();
        int nextRC4Byte2 = getNextRC4Byte();
        int nextRC4Byte3 = getNextRC4Byte();
        int nextRC4Byte4 = getNextRC4Byte();
        int nextRC4Byte5 = getNextRC4Byte();
        int nextRC4Byte6 = getNextRC4Byte();
        return j ^ ((((((((((long) getNextRC4Byte()) << 56) + (((long) getNextRC4Byte()) << 48)) + (((long) nextRC4Byte6) << 40)) + (((long) nextRC4Byte5) << 32)) + (((long) nextRC4Byte4) << 24)) + ((long) (nextRC4Byte3 << 16))) + ((long) (nextRC4Byte2 << 8))) + ((long) nextRC4Byte));
    }

    public int xorShort(int i) {
        return i ^ ((getNextRC4Byte() << 8) + getNextRC4Byte());
    }
}
