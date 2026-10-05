package defpackage;

import com.google.common.base.Ascii;
import com.itextpdf.text.DocWriter;
import com.itextpdf.text.pdf.ByteBuffer;
import org.apache.poi.hssf.record.PaletteRecord;
import org.apache.poi.hssf.record.formula.Area3DPtg;
import org.apache.poi.hssf.record.formula.AreaErrPtg;
import org.apache.poi.hssf.record.formula.MemFuncPtg;
import org.apache.poi.hssf.record.formula.Ref3DPtg;
import org.apache.poi.hssf.record.formula.RefErrorPtg;
import org.apache.poi.hssf.record.formula.RefNPtg;
import org.apache.poi.hssf.record.formula.RefPtg;

/* JADX INFO: renamed from: d7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2008d7 {
    public static final byte[] a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, ByteBuffer.ZERO, 49, 50, 51, 52, 53, 54, 55, PaletteRecord.STANDARD_PALETTE_SIZE, 57, AreaErrPtg.sid, DocWriter.FORWARD};
    public static final byte[] b = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, ByteBuffer.ZERO, 49, 50, 51, 52, 53, 54, 55, PaletteRecord.STANDARD_PALETTE_SIZE, 57, 45, 95};
    public static final byte[] c = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, DocWriter.GT, -9, -9, -9, 63, 52, 53, 54, 55, PaletteRecord.STANDARD_PALETTE_SIZE, 57, Ref3DPtg.sid, Area3DPtg.sid, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, Ascii.CAN, 25, -9, -9, -9, -9, -9, -9, Ascii.SUB, Ascii.ESC, Ascii.FS, 29, 30, 31, 32, 33, 34, 35, RefPtg.sid, 37, 38, 39, 40, MemFuncPtg.sid, RefErrorPtg.sid, AreaErrPtg.sid, RefNPtg.sid, 45, 46, DocWriter.FORWARD, ByteBuffer.ZERO, 49, 50, 51, -9, -9, -9, -9, -9};
    public static final byte[] d = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, DocWriter.GT, -9, -9, 52, 53, 54, 55, PaletteRecord.STANDARD_PALETTE_SIZE, 57, Ref3DPtg.sid, Area3DPtg.sid, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, Ascii.CAN, 25, -9, -9, -9, -9, 63, -9, Ascii.SUB, Ascii.ESC, Ascii.FS, 29, 30, 31, 32, 33, 34, 35, RefPtg.sid, 37, 38, 39, 40, MemFuncPtg.sid, RefErrorPtg.sid, AreaErrPtg.sid, RefNPtg.sid, 45, 46, DocWriter.FORWARD, ByteBuffer.ZERO, 49, 50, 51, -9, -9, -9, -9, -9};

    public static byte[] a(String str) {
        byte[] bytes = str.getBytes();
        return b(bytes, 0, bytes.length);
    }

    public static byte[] b(byte[] bArr, int i, int i2) {
        return c(bArr, i, i2, c);
    }

    public static byte[] c(byte[] bArr, int i, int i2, byte[] bArr2) throws C2089e7 {
        byte[] bArr3 = new byte[((i2 * 3) / 4) + 2];
        byte[] bArr4 = new byte[4];
        int i3 = 0;
        int iD = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = i4 + i;
            byte b2 = (byte) (bArr[i5] & Ascii.DEL);
            byte b3 = bArr2[b2];
            if (b3 < -5) {
                throw new C2089e7("Bad Base64 input character at " + i4 + ": " + ((int) bArr[i5]) + "(decimal)");
            }
            if (b3 >= -1) {
                if (b2 == 61) {
                    int i6 = i2 - i4;
                    byte b4 = (byte) (bArr[(i2 - 1) + i] & Ascii.DEL);
                    if (i3 == 0 || i3 == 1) {
                        throw new C2089e7("invalid padding byte '=' at byte offset " + i4);
                    }
                    if ((i3 == 3 && i6 > 2) || (i3 == 4 && i6 > 1)) {
                        throw new C2089e7("padding byte '=' falsely signals end of encoded value at offset " + i4);
                    }
                    if (b4 != 61 && b4 != 10) {
                        throw new C2089e7("encoded value has invalid trailing byte");
                    }
                    break;
                    break;
                }
                int i7 = i3 + 1;
                bArr4[i3] = b2;
                if (i7 == 4) {
                    iD += d(bArr4, 0, bArr3, iD, bArr2);
                    i3 = 0;
                } else {
                    i3 = i7;
                }
            }
        }
        if (i3 != 0) {
            if (i3 == 1) {
                throw new C2089e7("single trailing character at offset " + (i2 - 1));
            }
            bArr4[i3] = 61;
            iD += d(bArr4, 0, bArr3, iD, bArr2);
        }
        byte[] bArr5 = new byte[iD];
        System.arraycopy(bArr3, 0, bArr5, 0, iD);
        return bArr5;
    }

    public static int d(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3) {
        byte b2 = bArr[i + 2];
        if (b2 == 61) {
            bArr2[i2] = (byte) ((((bArr3[bArr[i + 1]] << Ascii.CAN) >>> 12) | ((bArr3[bArr[i]] << Ascii.CAN) >>> 6)) >>> 16);
            return 1;
        }
        byte b3 = bArr[i + 3];
        if (b3 == 61) {
            int i3 = ((bArr3[bArr[i + 1]] << Ascii.CAN) >>> 12) | ((bArr3[bArr[i]] << Ascii.CAN) >>> 6) | ((bArr3[b2] << Ascii.CAN) >>> 18);
            bArr2[i2] = (byte) (i3 >>> 16);
            bArr2[i2 + 1] = (byte) (i3 >>> 8);
            return 2;
        }
        int i4 = ((bArr3[bArr[i + 1]] << Ascii.CAN) >>> 12) | ((bArr3[bArr[i]] << Ascii.CAN) >>> 6) | ((bArr3[b2] << Ascii.CAN) >>> 18) | ((bArr3[b3] << Ascii.CAN) >>> 24);
        bArr2[i2] = (byte) (i4 >> 16);
        bArr2[i2 + 1] = (byte) (i4 >> 8);
        bArr2[i2 + 2] = (byte) i4;
        return 3;
    }
}
