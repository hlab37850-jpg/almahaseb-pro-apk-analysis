package com.zebra.sdk.printer.internal;

import com.zebra.sdk.graphics.internal.CpclCrcHeader;
import com.zebra.sdk.graphics.internal.DitheredImageProvider;
import com.zebra.sdk.graphics.internal.ZebraImageInternal;
import com.zebra.sdk.util.internal.FileUtilities;
import com.zebra.sdk.util.internal.FileWrapper;
import com.zebra.sdk.util.internal.StringUtilities;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class GraphicsConversionUtilCpcl implements GraphicsConvertionUtil {
    private static String getCorrectedFileName(String str) {
        return FileUtilities.parseDriveAndExtension(str).getFileName() + ".PCX";
    }

    private static int getWidthOfImage(int i) {
        return (i + 7) / 8;
    }

    public byte[] createPcxHeader(int i, int i2) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(new byte[]{10, 5, 1, 1});
        byteArrayOutputStream.write(new byte[]{0, 0, 0, 0});
        byteArrayOutputStream.write(integerToLittleEndianByteArray(i - 1));
        byteArrayOutputStream.write(integerToLittleEndianByteArray(i2 - 1));
        byteArrayOutputStream.write(new byte[]{-56, 0, -56, 0});
        int i3 = 0;
        while (true) {
            byteArrayOutputStream.write(0);
            if (i3 >= 48) {
                break;
            }
            i3++;
        }
        byteArrayOutputStream.write(1);
        int widthOfImage = getWidthOfImage(i);
        byteArrayOutputStream.write(integerToLittleEndianByteArray((char) (widthOfImage + ((char) (widthOfImage % 2)))));
        byteArrayOutputStream.write(new byte[]{0, 0});
        for (int i4 = 0; i4 < 58; i4++) {
            byteArrayOutputStream.write(0);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] createPcxImage(int i, int i2, ZebraImageInternal zebraImageInternal) throws IOException {
        if (i <= 0) {
            i = zebraImageInternal.getWidth();
        }
        if (i2 <= 0) {
            i2 = zebraImageInternal.getHeight();
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DitheredImageProvider.getDitheredImage(zebraImageInternal, byteArrayOutputStream);
        byte[] bArrCreatePcxImage = createPcxImage(i, i2, byteArrayOutputStream.toByteArray());
        byteArrayOutputStream.close();
        return bArrCreatePcxImage;
    }

    public byte[] integerToLittleEndianByteArray(int i) {
        return new byte[]{(byte) i, (byte) ((i >>> 8) & 255)};
    }

    @Override // com.zebra.sdk.printer.internal.GraphicsConvertionUtil
    public void sendImageToStream(String str, ZebraImageInternal zebraImageInternal, int i, int i2, OutputStream outputStream) throws IOException {
        zebraImageInternal.scaleImage(i, i2);
        byte[] bArrCreatePcxImage = createPcxImage(i, i2, zebraImageInternal);
        String upperCase = CpclCrcHeader.getCRC16ForCertificateFilesOnly(bArrCreatePcxImage).toUpperCase();
        String strConvertTo8dot3 = StringUtilities.convertTo8dot3(getCorrectedFileName(str));
        String strStringPadToPlaces = StringUtilities.stringPadToPlaces(8, "0", Integer.toHexString(bArrCreatePcxImage.length).toUpperCase());
        String upperCase2 = CpclCrcHeader.getWChecksum(bArrCreatePcxImage).toUpperCase();
        byte[] bytes = StringUtilities.CRLF.getBytes();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(FileWrapper.CPCL_CRC16_FILE_HEADER_FOR_FLASH.getBytes(), 0, 12);
        byteArrayOutputStream.write(bytes, 0, bytes.length);
        byteArrayOutputStream.write(upperCase.getBytes(), 0, upperCase.length());
        byteArrayOutputStream.write(bytes, 0, bytes.length);
        byteArrayOutputStream.write(strConvertTo8dot3.getBytes(), 0, strConvertTo8dot3.length());
        byteArrayOutputStream.write(bytes, 0, bytes.length);
        byteArrayOutputStream.write(strStringPadToPlaces.getBytes(), 0, strStringPadToPlaces.length());
        byteArrayOutputStream.write(bytes, 0, bytes.length);
        byteArrayOutputStream.write(upperCase2.getBytes(), 0, upperCase2.length());
        byteArrayOutputStream.write(bytes, 0, bytes.length);
        byteArrayOutputStream.write(bArrCreatePcxImage, 0, bArrCreatePcxImage.length);
        byteArrayOutputStream.write(bytes, 0, bytes.length);
        outputStream.write(byteArrayOutputStream.toByteArray());
        byteArrayOutputStream.close();
    }

    public byte[] createPcxImage(int i, int i2, byte[] bArr) throws IOException {
        byte[] bArrRleEncoding = new RleEncodedImage().rleEncoding(bArr, getWidthOfImage(i));
        byte[] bArrCreatePcxHeader = createPcxHeader(i, i2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(bArrCreatePcxHeader);
        byteArrayOutputStream.write(bArrRleEncoding);
        return byteArrayOutputStream.toByteArray();
    }
}
