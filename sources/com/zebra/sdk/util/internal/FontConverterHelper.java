package com.zebra.sdk.util.internal;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes3.dex */
public class FontConverterHelper {
    public static long calculateStreamSize(InputStream inputStream) {
        byte[] bArr = new byte[4096];
        long j = 0;
        while (inputStream.available() > 0) {
            j += (long) inputStream.read(bArr);
        }
        return j;
    }

    public static InputStream getFontHeader(long j, String str, char c) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(16);
            byteArrayOutputStream.write("DY".getBytes());
            byteArrayOutputStream.write(str.getBytes());
            byteArrayOutputStream.write(31);
            byteArrayOutputStream.write("b".getBytes());
            byteArrayOutputStream.write(31);
            byteArrayOutputStream.write(c);
            byteArrayOutputStream.write(31);
            byteArrayOutputStream.write(("" + j).getBytes());
            byteArrayOutputStream.write(31);
            byteArrayOutputStream.write(31);
            return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }

    public static void saveFontAsPrinterFont(InputStream inputStream, OutputStream outputStream, String str, String str2) {
        try {
            String strChangeExtension = FileUtilities.changeExtension(str, str2);
            if (inputStream instanceof FileInputStream) {
                FileChannel channel = ((FileInputStream) inputStream).getChannel();
                outputStream.write(FileWrapper.createCisdfHeader(new PrinterFileDescriptor(inputStream, strChangeExtension, new PrinterFileMetadata(channel.size(), "0000", "0000"))).getBytes());
                StreamHelper.copyAndCloseSourceStream(outputStream, inputStream);
                outputStream.write(FileWrapper.getCisdfTrailer());
                channel.close();
                return;
            }
            if (inputStream.markSupported()) {
                inputStream.mark(Integer.MAX_VALUE);
                PrinterFileMetadata printerFileMetadata = new PrinterFileMetadata(inputStream);
                inputStream.reset();
                outputStream.write(FileWrapper.createCisdfHeader(new PrinterFileDescriptor(inputStream, strChangeExtension, printerFileMetadata)).getBytes());
                StreamHelper.copyAndCloseSourceStream(outputStream, inputStream);
                outputStream.write(FileWrapper.getCisdfTrailer());
                return;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (inputStream.available() > 0) {
                byteArrayOutputStream.write(inputStream.read());
            }
            outputStream.write(FileWrapper.createCisdfHeader(new PrinterFileDescriptor(new ByteArrayInputStream("".getBytes()), strChangeExtension, new PrinterFileMetadata(new ByteArrayInputStream(byteArrayOutputStream.toByteArray())))).getBytes());
            StreamHelper.copyAndCloseSourceStream(outputStream, new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            outputStream.write(FileWrapper.getCisdfTrailer());
        } catch (Exception e) {
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }

    public static InputStream getFontHeader(InputStream inputStream, String str, char c) {
        try {
            return getFontHeader((int) calculateStreamSize(inputStream), str, c);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
