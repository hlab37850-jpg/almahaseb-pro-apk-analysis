package com.zebra.sdk.printer.operations.internal;

import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.device.ZebraIllegalArgumentException;
import com.zebra.sdk.graphics.ZebraImageI;
import com.zebra.sdk.graphics.internal.Ditherer;
import com.zebra.sdk.graphics.internal.DitheringStream;
import com.zebra.sdk.graphics.internal.ZebraImageInternal;
import com.zebra.sdk.printer.LinkOsInformation;
import com.zebra.sdk.printer.PrinterLanguage;
import com.zebra.sdk.util.internal.FileUtilities;
import com.zebra.sdk.util.internal.PrinterFileDescriptor;
import com.zebra.sdk.util.internal.PrinterFileMetadata;
import com.zebra.sdk.util.internal.PrinterFilePath;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class ImageStorer {
    private Connection connection;
    private PrinterLanguage language;
    private LinkOsInformation linkOsInformation;

    public ImageStorer(Connection connection, PrinterLanguage printerLanguage, LinkOsInformation linkOsInformation) {
        this.connection = connection;
        this.language = printerLanguage;
        this.linkOsInformation = linkOsInformation;
    }

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

    public void execute(String str, ZebraImageI zebraImageI, int i, int i2) throws ZebraIllegalArgumentException, ConnectionException {
        ZebraImageInternal zebraImageInternal = (ZebraImageInternal) zebraImageI;
        if (zebraImageInternal == null) {
            throw new ZebraIllegalArgumentException("Invalid image file.");
        }
        zebraImageInternal.scaleImage(i, i2);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrinterFilePath driveAndExtension = FileUtilities.parseDriveAndExtension(str);
            String correctedFileName = getCorrectedFileName(driveAndExtension);
            if (driveAndExtension.getExtension() == null || !driveAndExtension.getExtension().equalsIgnoreCase(".PNG")) {
                DitheringStream ditheringStream = new DitheringStream(zebraImageInternal);
                IOUtils.copy(ditheringStream, byteArrayOutputStream);
                ditheringStream.close();
                byteArrayOutputStream.close();
            } else {
                int[] zebraSpecificPngHeader = Ditherer.getZebraSpecificPngHeader(i, i2);
                for (int i3 : zebraSpecificPngHeader) {
                    byteArrayOutputStream.write(i3);
                }
                zebraImageInternal.writeDitheredPng(byteArrayOutputStream);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new PrinterFileDescriptor(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), correctedFileName, new PrinterFileMetadata(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()))));
            new FileStorer(arrayList, this.connection, this.language, this.linkOsInformation).execute();
        } catch (IOException e) {
            throw new ConnectionException(e.getLocalizedMessage());
        }
    }
}
