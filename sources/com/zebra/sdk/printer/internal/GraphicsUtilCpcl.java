package com.zebra.sdk.printer.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.graphics.ZebraImageI;
import com.zebra.sdk.graphics.internal.CompressedBitmapOutputStreamCpcl;
import com.zebra.sdk.graphics.internal.DitheredImageProvider;
import com.zebra.sdk.graphics.internal.ZebraImageInternal;
import com.zebra.sdk.util.internal.StringUtilities;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class GraphicsUtilCpcl extends GraphicsUtilA {
    protected Connection printerConnection;

    public GraphicsUtilCpcl(Connection connection) {
        this.printerConnection = connection;
    }

    @Override // com.zebra.sdk.printer.GraphicsUtil
    public void printImage(ZebraImageI zebraImageI, int i, int i2, int i3, int i4, boolean z) throws ConnectionException {
        String str;
        ZebraImageInternal zebraImageInternalScaleImage = scaleImage(i3, i4, (ZebraImageInternal) zebraImageI);
        int width = (zebraImageI.getWidth() + 7) / 8;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            String str2 = "";
            if (z) {
                str = "";
            } else {
                str = "! 0 200 200 " + zebraImageInternalScaleImage.getHeight() + " 1\r\n";
            }
            if (!z) {
                str2 = "FORM\r\nPRINT\r\n";
            }
            byteArrayOutputStream.write(str.getBytes());
            byteArrayOutputStream.write("CG ".getBytes());
            byteArrayOutputStream.write(String.valueOf(width).getBytes());
            byteArrayOutputStream.write(" ".getBytes());
            byteArrayOutputStream.write(String.valueOf(zebraImageInternalScaleImage.getHeight()).getBytes());
            byteArrayOutputStream.write(" ".getBytes());
            byteArrayOutputStream.write(String.valueOf(i).getBytes());
            byteArrayOutputStream.write(" ".getBytes());
            byteArrayOutputStream.write(String.valueOf(i2).getBytes());
            byteArrayOutputStream.write(" ".getBytes());
            this.printerConnection.write(byteArrayOutputStream.toByteArray());
            PrinterConnectionOutputStream printerConnectionOutputStream = new PrinterConnectionOutputStream(this.printerConnection);
            CompressedBitmapOutputStreamCpcl compressedBitmapOutputStreamCpcl = new CompressedBitmapOutputStreamCpcl(printerConnectionOutputStream);
            DitheredImageProvider.getDitheredImage(zebraImageInternalScaleImage, compressedBitmapOutputStreamCpcl);
            compressedBitmapOutputStreamCpcl.close();
            printerConnectionOutputStream.close();
            this.printerConnection.write(StringUtilities.CRLF.getBytes());
            this.printerConnection.write(str2.getBytes());
        } catch (Exception e) {
            throw new ConnectionException(e.getMessage());
        }
    }

    @Override // com.zebra.sdk.printer.GraphicsUtil
    public void storeImage(String str, ZebraImageI zebraImageI, int i, int i2) throws ConnectionException {
        try {
            new GraphicsConversionUtilCpcl().sendImageToStream(str, (ZebraImageInternal) zebraImageI, i, i2, new PrinterConnectionOutputStream(this.printerConnection));
        } catch (IOException e) {
            throw new ConnectionException(e.getLocalizedMessage());
        }
    }
}
