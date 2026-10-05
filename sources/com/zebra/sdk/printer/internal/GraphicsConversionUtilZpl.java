package com.zebra.sdk.printer.internal;

import com.zebra.sdk.device.ZebraIllegalArgumentException;
import com.zebra.sdk.graphics.internal.CompressedBitmapOutputStreamZpl;
import com.zebra.sdk.graphics.internal.DitheredImageProvider;
import com.zebra.sdk.graphics.internal.ZebraImageInternal;
import com.zebra.sdk.util.internal.FileUtilities;
import com.zebra.sdk.util.internal.PrinterFilePath;
import com.zebra.sdk.util.internal.ZCRC16;
import com.zebra.sdk.util.internal.ZPLUtilities;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.poi.hssf.record.formula.Ref3DPtg;

/* JADX INFO: loaded from: classes3.dex */
public class GraphicsConversionUtilZpl implements GraphicsConvertionUtil {
    private static String getCorrectedFileName(PrinterFilePath printerFilePath) throws ZebraIllegalArgumentException {
        String drive = printerFilePath.getDrive();
        String fileName = printerFilePath.getFileName();
        String extension = printerFilePath.getExtension();
        if (extension == null || !extension.equalsIgnoreCase(".PNG")) {
            extension = ".GRF";
        }
        if (drive == null || drive.length() == 0) {
            drive = "E";
        } else if (drive.length() > 1) {
            throw new ZebraIllegalArgumentException("Invalid drive specified : " + drive);
        }
        return drive + ":" + fileName + extension;
    }

    @Override // com.zebra.sdk.printer.internal.GraphicsConvertionUtil
    public void sendImageToStream(String str, ZebraImageInternal zebraImageInternal, int i, int i2, OutputStream outputStream) throws Throwable {
        if (zebraImageInternal == null) {
            throw new ZebraIllegalArgumentException("Invalid image file.");
        }
        zebraImageInternal.scaleImage(i, i2);
        int width = (zebraImageInternal.getWidth() + 7) / 8;
        int height = zebraImageInternal.getHeight() * width;
        PrinterFilePath driveAndExtension = FileUtilities.parseDriveAndExtension(str);
        StringBuilder sb = new StringBuilder();
        String correctedFileName = getCorrectedFileName(driveAndExtension);
        if (driveAndExtension.getExtension() == null || !driveAndExtension.getExtension().equalsIgnoreCase(".PNG")) {
            sb.append("~DG");
            sb.append(correctedFileName);
            sb.append(",");
            sb.append(height);
            sb.append(",");
            sb.append(width);
            sb.append(",");
            outputStream.write(ZPLUtilities.replaceAllWithInternalCharacters(sb.toString()).getBytes());
            writeImageDataToStream(zebraImageInternal, outputStream);
            return;
        }
        byte[] ditheredB64EncodedPng = zebraImageInternal.getDitheredB64EncodedPng();
        sb.append("~DY");
        sb.append(correctedFileName.substring(0, correctedFileName.indexOf(46)));
        sb.append(",p,p,");
        sb.append(ditheredB64EncodedPng.length);
        sb.append(",");
        sb.append(",:B64:");
        outputStream.write(ZPLUtilities.replaceAllWithInternalCharacters(sb.toString()).getBytes());
        outputStream.write(ditheredB64EncodedPng);
        outputStream.write(new byte[]{Ref3DPtg.sid});
        outputStream.write(ZCRC16.getCRC16ForZpl(new String(ditheredB64EncodedPng)).getBytes());
    }

    public void writeImageDataToStream(ZebraImageInternal zebraImageInternal, OutputStream outputStream) throws Throwable {
        CompressedBitmapOutputStreamZpl compressedBitmapOutputStreamZpl = null;
        try {
            CompressedBitmapOutputStreamZpl compressedBitmapOutputStreamZpl2 = new CompressedBitmapOutputStreamZpl(outputStream);
            try {
                DitheredImageProvider.getDitheredImage(zebraImageInternal, compressedBitmapOutputStreamZpl2);
                try {
                    compressedBitmapOutputStreamZpl2.close();
                } catch (IOException unused) {
                }
            } catch (Throwable th) {
                th = th;
                compressedBitmapOutputStreamZpl = compressedBitmapOutputStreamZpl2;
                if (compressedBitmapOutputStreamZpl != null) {
                    try {
                        compressedBitmapOutputStreamZpl.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
