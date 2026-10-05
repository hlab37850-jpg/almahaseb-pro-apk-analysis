package org.apache.poi.hpsf;

import org.apache.poi.util.HexDump;

/* JADX INFO: loaded from: classes2.dex */
public class ClassID {
    public static final int LENGTH = 16;
    protected byte[] bytes;

    public ClassID(byte[] bArr, int i) {
        read(bArr, i);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ClassID)) {
            return false;
        }
        ClassID classID = (ClassID) obj;
        if (this.bytes.length != classID.bytes.length) {
            return false;
        }
        int i = 0;
        while (true) {
            byte[] bArr = this.bytes;
            if (i >= bArr.length) {
                return true;
            }
            if (bArr[i] != classID.bytes[i]) {
                return false;
            }
            i++;
        }
    }

    public byte[] getBytes() {
        return this.bytes;
    }

    public int hashCode() {
        return new String(this.bytes).hashCode();
    }

    public int length() {
        return 16;
    }

    public byte[] read(byte[] bArr, int i) {
        this.bytes = new byte[]{bArr[i + 3], bArr[i + 2], bArr[i + 1], bArr[i], bArr[i + 5], bArr[i + 4], bArr[i + 7], bArr[i + 6], 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i2 = 8; i2 < 16; i2++) {
            this.bytes[i2] = bArr[i2 + i];
        }
        return this.bytes;
    }

    public void setBytes(byte[] bArr) {
        int i = 0;
        while (true) {
            byte[] bArr2 = this.bytes;
            if (i >= bArr2.length) {
                return;
            }
            bArr2[i] = bArr[i];
            i++;
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(38);
        stringBuffer.append('{');
        for (int i = 0; i < 16; i++) {
            stringBuffer.append(HexDump.toHex(this.bytes[i]));
            if (i == 3 || i == 5 || i == 7 || i == 9) {
                stringBuffer.append('-');
            }
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public void write(byte[] bArr, int i) {
        if (bArr.length < 16) {
            throw new ArrayStoreException("Destination byte[] must have room for at least 16 bytes, but has a length of only " + bArr.length + ".");
        }
        byte[] bArr2 = this.bytes;
        bArr[i] = bArr2[3];
        bArr[i + 1] = bArr2[2];
        bArr[i + 2] = bArr2[1];
        bArr[i + 3] = bArr2[0];
        bArr[i + 4] = bArr2[5];
        bArr[i + 5] = bArr2[4];
        bArr[i + 6] = bArr2[7];
        bArr[i + 7] = bArr2[6];
        for (int i2 = 8; i2 < 16; i2++) {
            bArr[i2 + i] = this.bytes[i2];
        }
    }

    public ClassID() {
        this.bytes = new byte[16];
        for (int i = 0; i < 16; i++) {
            this.bytes[i] = 0;
        }
    }
}
