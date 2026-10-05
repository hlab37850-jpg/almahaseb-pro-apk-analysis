package com.zebra.sdk.printer.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.graphics.ZebraImageI;
import com.zebra.sdk.graphics.internal.CompressedBitmapOutputStreamZpl;
import com.zebra.sdk.graphics.internal.DitheredImageProvider;
import com.zebra.sdk.graphics.internal.ZebraImageInternal;
import com.zebra.sdk.util.internal.ZPLUtilities;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class GraphicsUtilZpl extends GraphicsUtilA {
    protected Connection printerConnection;

    public GraphicsUtilZpl(Connection connection) {
        this.printerConnection = connection;
    }

    private String getBodyHeader(int i, int i2, boolean z, int i3, int i4) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("^FO");
        stringBuffer.append(i);
        stringBuffer.append(",");
        stringBuffer.append(i2);
        stringBuffer.append("^GFA");
        stringBuffer.append(",");
        stringBuffer.append(i4);
        stringBuffer.append(",");
        stringBuffer.append(i4);
        stringBuffer.append(",");
        stringBuffer.append(i3);
        stringBuffer.append(",");
        String string = stringBuffer.toString();
        if (z) {
            return string;
        }
        return "^XA" + string;
    }

    @Override // com.zebra.sdk.printer.GraphicsUtil
    public void printImage(ZebraImageI zebraImageI, int i, int i2, int i3, int i4, boolean z) throws ConnectionException {
        ZebraImageInternal zebraImageInternalScaleImage = scaleImage(i3, i4, (ZebraImageInternal) zebraImageI);
        int width = (zebraImageInternalScaleImage.getWidth() + 7) / 8;
        this.printerConnection.write(ZPLUtilities.replaceAllWithInternalCharacters(getBodyHeader(i, i2, z, width, width * zebraImageInternalScaleImage.getHeight())).getBytes());
        PrinterConnectionOutputStream printerConnectionOutputStream = new PrinterConnectionOutputStream(this.printerConnection);
        CompressedBitmapOutputStreamZpl compressedBitmapOutputStreamZpl = new CompressedBitmapOutputStreamZpl(printerConnectionOutputStream);
        try {
            DitheredImageProvider.getDitheredImage(zebraImageInternalScaleImage, compressedBitmapOutputStreamZpl);
            compressedBitmapOutputStreamZpl.close();
            printerConnectionOutputStream.close();
            if (z) {
                return;
            }
            this.printerConnection.write(ZPLUtilities.decorateWithFormatPrefix("^XZ").getBytes());
        } catch (IOException e) {
            throw new ConnectionException(e.getMessage());
        }
    }

    @Override // com.zebra.sdk.printer.GraphicsUtil
    public void storeImage(String str, ZebraImageI zebraImageI, int i, int i2) throws Throwable {
        try {
            new GraphicsConversionUtilZpl().sendImageToStream(str, (ZebraImageInternal) zebraImageI, i, i2, new PrinterConnectionOutputStream(this.printerConnection));
        } catch (IOException e) {
            throw new ConnectionException(e.getLocalizedMessage());
        }
    }
}
