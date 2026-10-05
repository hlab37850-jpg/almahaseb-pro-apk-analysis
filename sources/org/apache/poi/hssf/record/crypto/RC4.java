package org.apache.poi.hssf.record.crypto;

import com.zebra.sdk.util.internal.StringUtilities;
import org.apache.poi.util.HexDump;

/* JADX INFO: loaded from: classes4.dex */
final class RC4 {
    private int _i;
    private int _j;
    private final byte[] _s = new byte[256];

    public RC4(byte[] bArr) {
        int length = bArr.length;
        for (int i = 0; i < 256; i++) {
            this._s[i] = (byte) i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            int i4 = i2 + bArr[i3 % length];
            byte[] bArr2 = this._s;
            byte b = bArr2[i3];
            i2 = (i4 + b) & 255;
            bArr2[i3] = bArr2[i2];
            bArr2[i2] = b;
        }
        this._i = 0;
        this._j = 0;
    }

    public void encrypt(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ output());
        }
    }

    public byte output() {
        int i = (this._i + 1) & 255;
        this._i = i;
        int i2 = this._j;
        byte[] bArr = this._s;
        byte b = bArr[i];
        int i3 = (i2 + b) & 255;
        this._j = i3;
        bArr[i] = bArr[i3];
        bArr[i3] = b;
        return bArr[(bArr[i] + b) & 255];
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(RC4.class.getName());
        stringBuffer.append(" [");
        stringBuffer.append("i=");
        stringBuffer.append(this._i);
        stringBuffer.append(" j=");
        stringBuffer.append(this._j);
        stringBuffer.append("]");
        stringBuffer.append(StringUtilities.LF);
        stringBuffer.append(HexDump.dump(this._s, 0L, 0));
        return stringBuffer.toString();
    }

    public void encrypt(byte[] bArr, int i, int i2) {
        int i3 = i2 + i;
        while (i < i3) {
            bArr[i] = (byte) (bArr[i] ^ output());
            i++;
        }
    }
}
