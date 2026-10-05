package com.itextpdf.text.pdf.qrcode;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class QRCodeWriter {
    private static final int QUIET_ZONE_SIZE = 4;

    private static ByteMatrix renderResult(QRCode qRCode, int i, int i2) {
        byte b;
        ByteMatrix matrix = qRCode.getMatrix();
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        int i3 = width + 8;
        int i4 = height + 8;
        int iMax = Math.max(i, i3);
        int iMax2 = Math.max(i2, i4);
        int iMin = Math.min(iMax / i3, iMax2 / i4);
        int i5 = width * iMin;
        int i6 = (iMax - i5) / 2;
        int i7 = height * iMin;
        int i8 = (iMax2 - i7) / 2;
        ByteMatrix byteMatrix = new ByteMatrix(iMax, iMax2);
        byte[][] array = byteMatrix.getArray();
        byte[] bArr = new byte[iMax];
        int i9 = 0;
        while (true) {
            b = -1;
            if (i9 >= i8) {
                break;
            }
            setRowColor(array[i9], (byte) -1);
            i9++;
        }
        byte[][] array2 = matrix.getArray();
        int i10 = 0;
        while (i10 < height) {
            for (int i11 = 0; i11 < i6; i11++) {
                bArr[i11] = b;
            }
            int i12 = i6;
            int i13 = 0;
            while (i13 < width) {
                byte[][] bArr2 = array2;
                byte b2 = array2[i10][i13] == 1 ? (byte) 0 : (byte) -1;
                for (int i14 = 0; i14 < iMin; i14++) {
                    bArr[i12 + i14] = b2;
                }
                i12 += iMin;
                i13++;
                array2 = bArr2;
            }
            byte[][] bArr3 = array2;
            for (int i15 = i6 + i5; i15 < iMax; i15++) {
                bArr[i15] = -1;
            }
            int i16 = (i10 * iMin) + i8;
            int i17 = 0;
            while (i17 < iMin) {
                System.arraycopy(bArr, 0, array[i16 + i17], 0, iMax);
                i17++;
                i16 = i16;
            }
            i10++;
            array2 = bArr3;
            b = -1;
        }
        for (int i18 = i8 + i7; i18 < iMax2; i18++) {
            setRowColor(array[i18], (byte) -1);
        }
        return byteMatrix;
    }

    private static void setRowColor(byte[] bArr, byte b) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = b;
        }
    }

    public ByteMatrix encode(String str, int i, int i2) {
        return encode(str, i, i2, null);
    }

    public ByteMatrix encode(String str, int i, int i2, Map<EncodeHintType, Object> map) throws WriterException {
        ErrorCorrectionLevel errorCorrectionLevel;
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i + 'x' + i2);
        }
        ErrorCorrectionLevel errorCorrectionLevel2 = ErrorCorrectionLevel.L;
        if (map != null && (errorCorrectionLevel = (ErrorCorrectionLevel) map.get(EncodeHintType.ERROR_CORRECTION)) != null) {
            errorCorrectionLevel2 = errorCorrectionLevel;
        }
        QRCode qRCode = new QRCode();
        Encoder.encode(str, errorCorrectionLevel2, map, qRCode);
        return renderResult(qRCode, i, i2);
    }
}
